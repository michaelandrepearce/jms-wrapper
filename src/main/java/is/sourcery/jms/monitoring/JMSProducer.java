package is.sourcery.jms.monitoring;

import javax.jms.BytesMessage;
import javax.jms.CompletionListener;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageFormatRuntimeException;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import is.sourcery.jms.monitoring.intercept.ProducerInterceptor;

/**
 * Created by michaelandrepearce on 25/11/2016.
 */
public class JMSProducer<T extends javax.jms.JMSProducer> extends ForwardingObject<T> implements javax.jms.JMSProducer
{

    private final JMSContext context;
    private ProducerInterceptor producerInterceptor;
    private String clientId;
    
    public JMSProducer(JMSContext context, T jmsProducer)
    {
        super(jmsProducer);
        this.context = context;
        this.producerInterceptor = context.getConnectionFactory().getProducerInterceptor();
        this.clientId = context.getClientID();
    }
    
    public javax.jms.JMSContext getJMSContext(){
        return context;
    }
    
    public Message intercept(Destination destination, Message message) {
        return producerInterceptor == null ? message : producerInterceptor.onIntercept(clientId, destination, message);
    }

    public javax.jms.JMSProducer send(Destination destination, Message message) {
        return delegate().send(destination, intercept(destination, message));
    }

    public javax.jms.JMSProducer send(Destination destination, String body) {
        TextMessage message = context.createTextMessage(body);
        send(destination, message);
        return this;
    }

    public javax.jms.JMSProducer send(Destination destination, Map<String, Object> body) {
        MapMessage message = context.createMapMessage();
        if (body != null) {
            try {
                for (Map.Entry<String, Object> entry : body.entrySet()) {
                    final String name = entry.getKey();
                    final Object v = entry.getValue();
                    if (v instanceof String) {
                        message.setString(name, (String) v);
                    } else if (v instanceof Long) {
                        message.setLong(name, (Long) v);
                    } else if (v instanceof Double) {
                        message.setDouble(name, (Double) v);
                    } else if (v instanceof Integer) {
                        message.setInt(name, (Integer) v);
                    } else if (v instanceof Character) {
                        message.setChar(name, (Character) v);
                    } else if (v instanceof Short) {
                        message.setShort(name, (Short) v);
                    } else if (v instanceof Boolean) {
                        message.setBoolean(name, (Boolean) v);
                    } else if (v instanceof Float) {
                        message.setFloat(name, (Float) v);
                    } else if (v instanceof Byte) {
                        message.setByte(name, (Byte) v);
                    } else if (v instanceof byte[]) {
                        byte[] array = (byte[]) v;
                        message.setBytes(name, array, 0, array.length);
                    } else {
                        message.setObject(name, v);
                    }
                }
            } catch (JMSException e) {
                throw new MessageFormatRuntimeException(e.getMessage());
            }
        }
        send(destination, message);
        return this;
    }

    public javax.jms.JMSProducer send(Destination destination, byte[] body) {
        BytesMessage message = context.createBytesMessage();
        if (body != null) {
            try {
                message.writeBytes(body);
            } catch (JMSException e) {
                throw new MessageFormatRuntimeException(e.getMessage());
            }
        }
        send(destination, message);
        return this;
    }

    public javax.jms.JMSProducer send(Destination destination, Serializable body)
    {
        ObjectMessage message = context.createObjectMessage(body);
        send(destination, message);
        return this;
    }

    public javax.jms.JMSProducer setDisableMessageID(boolean b)
    {
        return delegate().setDisableMessageID(b);
    }

    public boolean getDisableMessageID()
    {
        return delegate().getDisableMessageID();
    }

    public javax.jms.JMSProducer setDisableMessageTimestamp(boolean b)
    {
        return delegate().setDisableMessageTimestamp(b);
    }

    public boolean getDisableMessageTimestamp()
    {
        return delegate().getDisableMessageTimestamp();
    }

    public javax.jms.JMSProducer setDeliveryMode(int i)
    {
        return delegate().setDeliveryMode(i);
    }

    public int getDeliveryMode()
    {
        return delegate().getDeliveryMode();
    }

    public javax.jms.JMSProducer setPriority(int i)
    {
        return delegate().setPriority(i);
    }

    public int getPriority()
    {
        return delegate().getPriority();
    }

    public javax.jms.JMSProducer setTimeToLive(long l)
    {
        return delegate().setTimeToLive(l);
    }

    public long getTimeToLive()
    {
        return delegate().getTimeToLive();
    }

    public javax.jms.JMSProducer setDeliveryDelay(long l)
    {
        return delegate().setDeliveryDelay(l);
    }

    public long getDeliveryDelay()
    {
        return delegate().getDeliveryDelay();
    }

    public javax.jms.JMSProducer setAsync(CompletionListener completionListener)
    {
        return delegate().setAsync(completionListener);
    }

    public CompletionListener getAsync()
    {
        return delegate().getAsync();
    }

    public javax.jms.JMSProducer setProperty(String s, boolean b)
    {
        return delegate().setProperty(s, b);
    }

    public javax.jms.JMSProducer setProperty(String s, byte b)
    {
        return delegate().setProperty(s, b);
    }

    public javax.jms.JMSProducer setProperty(String s, short i)
    {
        return delegate().setProperty(s, i);
    }

    public javax.jms.JMSProducer setProperty(String s, int i)
    {
        return delegate().setProperty(s, i);
    }

    public javax.jms.JMSProducer setProperty(String s, long l)
    {
        return delegate().setProperty(s, l);
    }

    public javax.jms.JMSProducer setProperty(String s, float v)
    {
        return delegate().setProperty(s, v);
    }

    public javax.jms.JMSProducer setProperty(String s, double v)
    {
        return delegate().setProperty(s, v);
    }

    public javax.jms.JMSProducer setProperty(String s, String s1)
    {
        return delegate().setProperty(s, s1);
    }

    public javax.jms.JMSProducer setProperty(String s, Object o)
    {
        return delegate().setProperty(s, o);
    }

    public javax.jms.JMSProducer clearProperties()
    {
        return delegate().clearProperties();
    }

    public boolean propertyExists(String s)
    {
        return delegate().propertyExists(s);
    }

    public boolean getBooleanProperty(String s)
    {
        return delegate().getBooleanProperty(s);
    }

    public byte getByteProperty(String s)
    {
        return delegate().getByteProperty(s);
    }

    public short getShortProperty(String s)
    {
        return delegate().getShortProperty(s);
    }

    public int getIntProperty(String s)
    {
        return delegate().getIntProperty(s);
    }

    public long getLongProperty(String s)
    {
        return delegate().getLongProperty(s);
    }

    public float getFloatProperty(String s)
    {
        return delegate().getFloatProperty(s);
    }

    public double getDoubleProperty(String s)
    {
        return delegate().getDoubleProperty(s);
    }

    public String getStringProperty(String s)
    {
        return delegate().getStringProperty(s);
    }

    public Object getObjectProperty(String s)
    {
        return delegate().getObjectProperty(s);
    }

    public Set<String> getPropertyNames()
    {
        return delegate().getPropertyNames();
    }

    public javax.jms.JMSProducer setJMSCorrelationIDAsBytes(byte[] bytes)
    {
        return delegate().setJMSCorrelationIDAsBytes(bytes);
    }

    public byte[] getJMSCorrelationIDAsBytes()
    {
        return delegate().getJMSCorrelationIDAsBytes();
    }

    public javax.jms.JMSProducer setJMSCorrelationID(String s)
    {
        return delegate().setJMSCorrelationID(s);
    }

    public String getJMSCorrelationID()
    {
        return delegate().getJMSCorrelationID();
    }

    public javax.jms.JMSProducer setJMSType(String s)
    {
        return delegate().setJMSType(s);
    }

    public String getJMSType()
    {
        return delegate().getJMSType();
    }

    public javax.jms.JMSProducer setJMSReplyTo(Destination destination)
    {
        return delegate().setJMSReplyTo(destination);
    }

    public Destination getJMSReplyTo()
    {
        return delegate().getJMSReplyTo();
    }

}
