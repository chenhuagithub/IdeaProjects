package topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsConsumer_Topic2 {

    public static String ACTIVEMQ_URL = "tcp://localhost:61616";
    public static String TOPIC_NAME = "mytopic";


    public static void main(String[] args) throws JMSException{

        System.out.println("**********我是李四***************");
        // 1. 创建连接工厂, 按照给定的url地址, 采用默认用户名和密码(默认用户名和密码都是admin)
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        // 2. 通过连接工厂, 获得连接connection并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();

        // 说明是订阅谁的消息
        connection.setClientID("ls");

        // 3. 创建会话session
        // 两个参数, 第一个叫事务, 第二个叫签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 4. 创建目的地(具体是队列还是主题)
        Topic topic = session.createTopic(TOPIC_NAME);
        // 订阅谁的消息
        TopicSubscriber durableSubscriber = session.createDurableSubscriber(topic, "remark...");
        // 启动
        connection.start();
        // 等待消息
        Message message = durableSubscriber.receive();

        while (message != null){
            TextMessage textMessage = (TextMessage)message;
            System.out.println("*********收到持久化topic:"+textMessage.getText());
            // 继续监听消息
            message = durableSubscriber.receive(10000L);
        }


        session.close();
        connection.close();


    }
}
