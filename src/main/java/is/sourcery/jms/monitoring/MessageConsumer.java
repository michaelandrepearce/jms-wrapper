package is.sourcery.jms.monitoring;

import javax.jms.JMSException;
import javax.jms.Message;

import is.sourcery.jms.monitoring.intercept.ConsumerInterceptor;

/**
 * Created by michaelandrepearce on 12/12/2016.
 */
public class MessageConsumer<T extends javax.jms.MessageConsumer> extends ForwardingObject<T> implements javax.jms.MessageConsumer {

    private Session session;
    private String subscriptionName;
    private String clientId;
    private ConsumerInterceptor consumerInterceptor;


    public MessageConsumer(Session session, T messageConsumer){
        this(session, messageConsumer, null);
    }

    public MessageConsumer(Session session, T messageConsumer, String subscriptionName){
        super(messageConsumer);
        this.session = session;
        this.subscriptionName = subscriptionName;
        this.consumerInterceptor = session.getConnection().getConnectionFactory().getConsumerInterceptor();
        try {
            this.clientId = session.getConnection().getClientID();
        } catch (JMSException e) {
            throw JmsExceptionUtils.convertToRuntimeException(e);
        }
    }

    public Message intercept(Message message) {
        return consumerInterceptor.onIntercept(clientId, subscriptionName, message);
    }
    
    public String getSubscriptionName(){
        return subscriptionName;
    }


    public Session getSession(){
        return session;
    }

    public String getMessageSelector() throws JMSException {
        return delegate().getMessageSelector();
    }

    public javax.jms.MessageListener getMessageListener() throws JMSException {
        return delegate().getMessageListener();
    }

    public void setMessageListener(javax.jms.MessageListener listener) throws JMSException {
        delegate().setMessageListener(new MessageListener(consumerInterceptor, clientId, subscriptionName, listener));
    }

    public Message receive() throws JMSException {
        return intercept(delegate().receive());
    }

    public Message receive(long timeout) throws JMSException {
        return intercept(delegate().receive(timeout));

    }

    public Message receiveNoWait() throws JMSException {
        return intercept(delegate().receiveNoWait());
    }

    public void close() throws JMSException {
        delegate().close();
    }


}
