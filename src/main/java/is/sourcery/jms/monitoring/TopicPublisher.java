package is.sourcery.jms.monitoring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Topic;

/**
 * Created by michaelandrepearce on 12/12/2016.
 */
public class TopicPublisher<T extends javax.jms.TopicPublisher> extends MessageProducer<T> implements javax.jms.TopicPublisher {

    public TopicPublisher(Session session, T topicPublisher){
        super(session, topicPublisher);
    }

    public Topic getTopic() throws JMSException {
        return delegate().getTopic();
    }

    public void publish(Message message) throws JMSException {
        delegate().publish(message);
    }

    public void publish(Message message, int deliveryMode, int priority, long timeToLive) throws JMSException {
        delegate().publish(message, deliveryMode, priority, timeToLive);
    }

    public void publish(Topic topic, Message message) throws JMSException {
        delegate().publish(topic, message);
    }

    public void publish(Topic topic, Message message, int deliveryMode, int priority, long timeToLive) throws JMSException {
        delegate().publish(topic, message, deliveryMode, priority, timeToLive);
    }

}
