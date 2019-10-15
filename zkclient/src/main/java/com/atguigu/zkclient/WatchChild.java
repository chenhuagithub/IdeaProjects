package com.atguigu.zkclient;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;


public class WatchChild {

    // 常量
    private static Logger logger;
    private final static String CONNETCTION_STRING = "localhost:2181";
    private final static int SESSION_TIMEOUT = 50 * 1000;
    private final static String PATH = "/atguigu";
    // 实例
    ZooKeeper zooKeeper = null;

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
                if(watchedEvent.getType()  == Event.EventType.NodeChildrenChanged && watchedEvent.getPath().equals(PATH)){
                    System.out.println("if");
                    showChildNode(PATH);
                }else {
                    System.out.println("else");
                    showChildNode("/");
                }
            }
        });
    }

    private void showChildNode(String path) {
        try {
            List<String> list = zooKeeper.getChildren(path, true);
            System.out.println("**************"+list);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) throws Exception{

        WatchChild watchChild = new WatchChild();
        watchChild.setZooKeeper(watchChild.startZK());
        Thread.sleep(Long.MAX_VALUE);
//        WatchChild watchMore = new WatchChild();
//        watchMore.setZooKeeper(watchMore.startZK());
//        if(watchMore.getZooKeeper().exists(PATH, false) == null){
//            watchMore.createZnode(PATH, "AAA");
//            String retValue = watchMore.getZnode(PATH);
////            logger.info("***************first retValue:"+retValue);
//            System.out.println("***************first retValue:"+retValue);
//            Thread.sleep(Long.MAX_VALUE);
//        }else {
//            System.out.println("**************node ok");
////            System.out.println("jflsdjflj");
//        }

    }

}
