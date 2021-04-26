package com.clilffside;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.ArrayList;

/**
 * 消息发送者
 * @author cliffside
 * @date 2021-04-20 14:08
 */
public class SenderTopic {
    public static void main(String[] args) throws JMSException {
        //1.获取连接工厂

        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(
                "admin"
                ,"admin"
                ,"tcp://127.0.0.1:61616");
        //2.获取一个向ActiveMQ的连接
        //信任持久化类型
        ArrayList<String> objects = new ArrayList<>();
        objects.add(Person.class.getPackage().getName());
        activeMQConnectionFactory.setTrustedPackages(objects);
        Connection connection = activeMQConnectionFactory.createConnection();
        //3.获取session
        /**
         * 参数1：是否开启事务，开启事务之后，任何模式都没用了
         * 参数2：queue中ack就remove掉消息，
         */
        //Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        //4. 获取destination，消费端也从这个destination获取消息
        /**
         * queue 继承了destination
         */
        Destination topic = session.createTopic("topic");
        //5.1 消息创建者
        /**
         * consumer -> 消息的接收者
         * producer -> 消息的创建者/发送者
         */
        MessageProducer producer = session.createProducer(topic);
        //不进行持久化
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        try{
            //5.2 创建消息
            for (int i=0;i<10;i++){

                TextMessage textMessage = session.createTextMessage("hello"+i);
                //5.3 向目的地写入消息
                //设置优先级，给所有消息
                producer.setPriority(1);
                //发送，可以在这里对单个消息进行配置
                producer.send(textMessage);
            }
            //事务提交
            //session.commit();
        }catch (Exception e){
            //事务回滚
            //session.rollback();
        }
        //6.关闭连接
        connection.close();
        /**
         * 在localhost的8161 -> queues中可以看到
         */
    }
}
