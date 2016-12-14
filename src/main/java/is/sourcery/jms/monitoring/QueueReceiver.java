package is.sourcery.jms.monitoring;

import javax.jms.*;

/**
 * Created by michaelandrepearce on 12/12/2016.
 */
public class QueueReceiver<T extends javax.jms.QueueReceiver> extends is.sourcery.jms.monitoring.MessageConsumer<T> implements javax.jms.QueueReceiver {

    public QueueReceiver(Session session, T queueReceiver){
        super(session, queueReceiver);
    }

    public Queue getQueue() throws JMSException {
        return delegate().getQueue();
    }
}
