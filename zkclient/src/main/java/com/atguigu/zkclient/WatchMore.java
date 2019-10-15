package com.atguigu.zkclient;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.logging.Logger;


public class WatchMore {

    // 常量
    private static Logger logger;
    private final static String CONNETCTION_STRING = "localhost:2181";
    private final static int SESSION_TIMEOUT = 50 * 1000;
    private final static String PATH = "/atguigu";
    // 实例
    ZooKeeper zooKeeper = null;

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    String oldValue = null;

    public ZooKeeper getZooKeeper() {
        return zooKeeper;
    }

    public void setZooKeeper(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }

    // 开启zookeeper
    public ZooKeeper startZK() throws IOException {
        return new ZooKeeper(CONNETCTION_STRING, SESSION_TIMEOUT, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }


    public boolean trigerValue(String nodePath) throws KeeperException, InterruptedException {
        String result = null;
        byte[] data = zooKeeper.getData(PATH, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                try {
                    trigerValue(nodePath);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, new Stat());
        result = new String(data);
        String newValue = result;
        if(oldValue.equals(newValue)){
            System.out.println("********no change*********");
            return false;
        }else {
            System.out.println("******************oldValue:"+oldValue);
            System.out.println("******************newValue:"+newValue);
            oldValue = newValue;
            return true;
        }
////        logger.info("****************watch one time : "+result);
//        System.out.println("****************watch one time : "+result);
//
//        return result;
    }



    // 创建节点
    public void createZnode(String nodePath, String nodeValue) throws KeeperException, InterruptedException {
        zooKeeper.create(nodePath, nodeValue.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }


    // 获取节点
    public String getZnode(String nodePath) throws KeeperException, InterruptedException {
        String result = null;
//        byte[] data = zooKeeper.getData(nodePath, false, new Stat());
        byte[] data = zooKeeper.getData(nodePath, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                try {
                    trigerValue(PATH);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, new Stat());
        result = new String(data);
        oldValue = result;
        return result;
    }


    public static void main(String[] args) throws Exception{

        WatchMore watchMore = new WatchMore();
        watchMore.setZooKeeper(watchMore.startZK());
        if(watchMore.getZooKeeper().exists(PATH, false) == null){
            watchMore.createZnode(PATH, "AAA");
            String retValue = watchMore.getZnode(PATH);
//            logger.info("***************first retValue:"+retValue);
            System.out.println("***************first retValue:"+retValue);
            Thread.sleep(Long.MAX_VALUE);
        }else {
            System.out.println("**************node ok");
//            System.out.println("jflsdjflj");
        }

    }

}
