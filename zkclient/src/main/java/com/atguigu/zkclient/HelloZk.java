package com.atguigu.zkclient;

import org.apache.log4j.Logger;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class HelloZk {

    private static final Logger logger = Logger.getLogger(HelloZk.class);
    // zookeeper地址
    private final static String CONNETCTION_STRING = "localhost:2181";
    // 连接超时的时间
    private final static int SESSION_TIMEOUT = 50 * 1000;
    // 节点
    private final static String PATH = "/atguigu";


    /**
     * public ZooKeeper(String connectString, int sessionTimeout, Watcher watcher)
     *  connectString: 连接zookeeper服务器的地址
     *  sessionTimeout: 连接超时时间
     *  watcher: 观察者实例
     */
    // 开启zookeeper
    public ZooKeeper startZK() throws IOException {
        return new ZooKeeper(CONNETCTION_STRING, SESSION_TIMEOUT, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }

    // 关闭zookeeper
    public void stopZK(ZooKeeper zooKeeper) throws InterruptedException {
        if(zooKeeper != null){
            zooKeeper.close();
        }

    }

    /**
     *
     * @param zooKeeper
     * @param nodePath
     * @param nodeValue
     * @throws KeeperException
     * @throws InterruptedException
     */
    // 创建节点
    public void createZnode(ZooKeeper zooKeeper, String nodePath, String nodeValue) throws KeeperException, InterruptedException {
        /**
         * public String create(String path, byte[] data, List<ACL> acl, CreateMode createMode)
         * nodePath: 节点路径
         * nodeValue: 节点值
         * createMode: 节点类型, 是临时节点还是持久节点
         *
         */
        zooKeeper.create(nodePath, nodeValue.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }


    // 获取节点
    public String getZnode(ZooKeeper zooKeeper, String nodePath) throws KeeperException, InterruptedException {
        String result;
        // 获取节点值
        byte[] data = zooKeeper.getData(nodePath, false, new Stat());
        result = new String(data);
        return result;
    }


    public static void main(String[] args) throws Exception{


        HelloZk helloZk = new HelloZk();
        ZooKeeper zooKeeper = helloZk.startZK();
        if(zooKeeper.exists(PATH, false) == null){
            helloZk.createZnode(zooKeeper, PATH, "hello0316");
            String retValue = helloZk.getZnode(zooKeeper, PATH);
            System.out.println("*****************retValue:"+retValue);
        }else {
            System.out.println("*****************I have this node");
        }

        helloZk.stopZK(zooKeeper);
    }

}
