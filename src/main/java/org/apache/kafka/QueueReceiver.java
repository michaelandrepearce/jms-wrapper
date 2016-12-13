package org.apache.kafka;

import javax.jms.*;

/**
 * Created by michaelandrepearce on 12/12/2016.
 */
public class QueueReceiver<T extends javax.jms.QueueReceiver> extends MessageConsumer<T> implements javax.jms.QueueReceiver {

    public QueueReceiver(T queueReceiver){
        super(queueReceiver);
    }

    public Queue getQueue() throws JMSException {
        return delegate().getQueue();
    }
}
