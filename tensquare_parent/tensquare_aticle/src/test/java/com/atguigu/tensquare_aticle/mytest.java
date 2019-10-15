package com.atguigu.tensquare_aticle;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class mytest {


    @Test
    public void test1(){
        // 连接数据库
        MongoClient client = new MongoClient("localhost", 27017);
        // 得到要操作的数据库
        MongoDatabase spitdb = client.getDatabase("spitdb");
        // 得到要操作的集合
        MongoCollection<Document> spit = spitdb.getCollection("spit");
        System.out.println("================");
        System.out.println(spit);
        System.out.println("==================");

        Document document1 = new Document();
        Map<String, Object> map = new HashMap<>();
        map.put("content", "时间过得好快啊");
        map.put("userid", "1016");
        map.put("visits", 1000);





        client.close();

    }


}
