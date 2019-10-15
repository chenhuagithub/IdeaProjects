import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProducer {

    public static String ACTIVEMQ_URL = "tcp://localhost:61616";
    public static String QUEUE_NAME = "jdbc01";
    public static String TOPIC_NAME = "jdbctopic";

    public static void main(String[] args) throws JMSException {
        // 1. 创建连接工厂, 按照给定的url地址, 采用默认用户名和密码(默认用户名和密码都是admin)
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        // 2. 通过连接工厂, 获得连接connection并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        // 3. 创建会话session
        // 两个参数, 第一个叫事务, 第二个叫签收
//        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); // 自动签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 4. 创建目的地(具体是队列还是主题)
//        Queue queue = session.createQueue(QUEUE_NAME);
        Topic topic = session.createTopic(TOPIC_NAME);
        // 5. 创建消息生产者
        MessageProducer producer = session.createProducer(topic);
        // 6. 通过使用消息生产者生产3条消息发送到MQ的队列里面
        for (int i = 0; i < 7; i++) {
            // 7. 创建消息, 好比学生按照老师的要求写好的作业一样
            TextMessage textMessage = session.createTextMessage("msg-----" + i);
//            MapMessage mapMessage = session.createMapMessage();
            // 8. 通过messageProducer发送mq
//            mapMessage.setString("k"+i, "v"+i);
            producer.send(textMessage);
        }

//        session.commit();
        // 9.关闭资源
        producer.close();
        session.close();
        connection.close();
    }
}
