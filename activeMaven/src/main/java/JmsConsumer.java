import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class JmsConsumer {

    public static String ACTIVEMQ_URL = "tcp://localhost:61618";
    public static String QUEUE_NAME = "jdbc01";
    public static String TOPIC_NAME = "jdbctopic";

    public static void main(String[] args) throws JMSException {

        System.out.println("**********我是1号消费者***************");
        // 1. 创建连接工厂, 按照给定的url地址, 采用默认用户名和密码(默认用户名和密码都是admin)
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        // 2. 通过连接工厂, 获得连接connection并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
//        connection.start();
        // 3. 创建会话session
        // 两个参数, 第一个叫事务, 第二个叫签收
//        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 4. 创建目的地(具体是队列还是主题)
//        Queue queue = session.createQueue(QUEUE_NAME);
        Topic topic = session.createTopic(TOPIC_NAME);
        // 5. 创建消费者
        MessageConsumer consumer = session.createConsumer(topic);



        /**
         * 方式一: 同步阻塞
         */
//        while (true){
//            // 等待消息
//            TextMessage message = (TextMessage) consumer.receive(4000L);
//            if(message != null){
//                System.out.println("[broker]消费者接受的消息为:"+message.getText());
////                message.acknowledge();
//            }else {
//                break;
//            }
//        }



        /**
         * 方式二: 通过监听器的方式来获取消息
         */
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if(message != null && message instanceof TextMessage){
                    TextMessage textMessage = (TextMessage) message;
//                    MapMessage mapMessage = (MapMessage) message;
                    try {
                        System.out.println(textMessage.getText());
//                        System.out.println(mapMessage.getString("k1"));
//                        System.out.println(mapMessage.getStringProperty("c01"));
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        try {
            // 保证控制台不灭
            int read = System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        session.commit();
        consumer.close();
        session.close();
        connection.close();
    }
}
