package is.sourcery.jms.monitoring;

import javax.jms.JMSException;
import javax.jms.Topic;

/**
 * Created by michaelandrepearce on 12/12/2016.
 */
public class TopicSubscriber<T extends javax.jms.TopicSubscriber> extends MessageConsumer<T> implements javax.jms.TopicSubscriber {

    public TopicSubscriber(Session session, T topicSubscriber){
        super(session, topicSubscriber);
    }

    public Topic getTopic() throws JMSException {
        return delegate().getTopic();
    }

    public boolean getNoLocal() throws JMSException {
        return delegate().getNoLocal();
    }
}
