package is.sourcery.jms.monitoring;

import javax.jms.JMSException;
import javax.jms.JMSRuntimeException;
import javax.jms.Message;
import javax.jms.MessageListener;

import is.sourcery.jms.monitoring.intercept.ConsumerInterceptor;

/**
 * Created by michaelandrepearce on 25/11/2016.
 */
public class JMSConsumer<T extends javax.jms.JMSConsumer> extends ForwardingObject<T> implements javax.jms.JMSConsumer
{
    private JMSContext context;
    private ConsumerInterceptor consumerInterceptor;
    private String subscriptionName;
    private String clientId;

    public JMSConsumer(JMSContext context, T jmsConsumer){
        this(context, jmsConsumer, null);
    }


    public JMSConsumer(JMSContext context, T jmsConsumer, String subscriptionName)
    {
        super(jmsConsumer);
        this.context = context;
        this.subscriptionName = subscriptionName;
        this.clientId = context.getClientID();
    }

    public Message intercept(Message message) {
        return consumerInterceptor.onIntercept(clientId, subscriptionName, message);
    }

    public javax.jms.JMSContext getJMSContext(){
        return context;
    }
    
    public String getMessageSelector()
    {
        return delegate().getMessageSelector();
    }

    public MessageListener getMessageListener() throws JMSRuntimeException
    {
        return delegate().getMessageListener();
    }

    public void setMessageListener(MessageListener messageListener) throws JMSRuntimeException
    {
        delegate().setMessageListener(new is.sourcery.jms.monitoring.MessageListener(consumerInterceptor, clientId, subscriptionName, messageListener));
    }

    public Message receive()
    {
        return intercept(delegate().receive());
    }

    public Message receive(long l)
    {
        return intercept(delegate().receive(l));
    }

    public Message receiveNoWait()
    {
        return intercept(delegate().receiveNoWait());
    }

    public void close()
    {
        delegate().close();
    }

    public <T> T receiveBody(Class<T> aClass)
    {
        try
        {
            Message message = intercept(delegate().receive());
            return message == null ? null : message.getBody(aClass);
        } catch (JMSException e){
            throw JmsExceptionUtils.convertToRuntimeException(e);
        }
    }

    public <T> T receiveBody(Class<T> aClass, long l)
    {
        try
        {
            Message message = intercept(delegate().receive(l));
            return message == null ? null : message.getBody(aClass);
        } catch (JMSException e){
            throw JmsExceptionUtils.convertToRuntimeException(e);
        }
    }

    public <T> T receiveBodyNoWait(Class<T> aClass)
    {
        try
        {
            Message message = intercept(delegate().receiveNoWait());
            return message == null ? null : message.getBody(aClass);
        } catch (JMSException e){
            throw JmsExceptionUtils.convertToRuntimeException(e);
        }
    }
    
}
