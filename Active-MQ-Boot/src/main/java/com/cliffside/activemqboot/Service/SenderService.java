package com.cliffside.activemqboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author cliffside
 * @date 2021-04-21 11:03
 */
@Service
public class SenderService {
    /**
     * 底层用的还是jms template
     */
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private JmsTemplate jmsTemplate;
    public void send(String destination, String msg) {
        
        jmsMessagingTemplate.convertAndSend(destination,msg);
    }
}
