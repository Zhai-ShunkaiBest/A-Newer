package com.clilffside;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 消息接收
 * @author cliffside
 * @date 2021-04-20 14:50
 */
public class ReceiverTopic {
    public static void main(String[] args) throws JMSException {
        // 1.获取连接工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                "admin"
                ,"admin"
                , "tcp://localhost:61616"
        );
        // 2.获取一个向ActiveMQ的连接
        Connection connection = connectionFactory.createConnection();

        connection.start();
        // 3.获取session
        //Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        // 4. 找目的地，获取destination，消费端，也会从这个目的地取消息

        Destination topic = session.createTopic("topic");

        //session.createQueue("")
        // 5.获取消息

        //5.1 消息接收者
        /**
         * consumer -> 消息的接收者
         * producer -> 消息的创建者/发送者
         */
        MessageConsumer consumer = session.createConsumer(topic);

        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage)message;
                try {
                    System.out.println(textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

//        //5.2 接收消息 死循环的阻塞方法，不建议使用
//        while (true){
//            //将会阻塞
//            TextMessage receive = (TextMessage) consumer.receive();
//            System.out.println("message"+receive.getText());
//            //开启client_ack时，手动ack
//            receive.acknowledge();
//        }

        /**
         * 在localhost的8161 -> queues中可以看到
         */
    }
}
