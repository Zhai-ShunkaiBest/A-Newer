package com.clilffside;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.PrintStream;

/**
 * 消息接收
 * @author cliffside
 * @date 2021-04-20 14:50
 */
public class ReceiverQueue {
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

        //session.createBrowser();只能看不能订阅
        Destination queue = session.createQueue("user");
        Destination dlq = session.createQueue("ActiveMQ.DLQ");
        MessageConsumer consumer2 = session.createConsumer(dlq);
        consumer2.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if (message instanceof TextMessage){
                    TextMessage textMessage = (TextMessage)message;
                    try {
                        String text = textMessage.getText();
                        System.out.println("DLQ:"+text);
                        textMessage.acknowledge();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        // 5.获取消息

        //5.1 消息接收者
        /**
         * consumer -> 消息的接收者
         * producer -> 消息的创建者/发送者
         */
        MessageConsumer consumer = session.createConsumer(queue);
        //5.2 接收消息
        while (true){
            //将会阻塞
            TextMessage receive = (TextMessage) consumer.receive();
            System.out.println("message"+receive.getText());
            //开启client_ack时，手动ack
            receive.acknowledge();
        }

        /**
         * 在localhost的8161 -> queues中可以看到
         */
    }
}
