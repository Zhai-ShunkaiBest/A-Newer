package com.cliffside.activemqboot.Service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @author cliffside
 * @date 2021-04-21 13:06
 */
@Service
public class ReceiverService {
    @JmsListener(destination = "springboot",containerFactory = "jmsListenerContainerTopic")
    public void receiver(String msg){
        System.out.println("收到消息:"+msg);
    }
}
