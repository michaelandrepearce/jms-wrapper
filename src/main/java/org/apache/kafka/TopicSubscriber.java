package org.apache.kafka;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * Created by michaelandrepearce on 12/12/2016.
 */
public class TopicSubscriber<T extends javax.jms.TopicSubscriber> extends MessageConsumer<T> implements javax.jms.TopicSubscriber {

    public TopicSubscriber(T topicSubscriber){
        super(topicSubscriber);
    }

    public Topic getTopic() throws JMSException {
        return delegate().getTopic();
    }

    public boolean getNoLocal() throws JMSException {
        return delegate().getNoLocal();
    }
}
