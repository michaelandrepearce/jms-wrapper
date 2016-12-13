package org.apache.kafka;

import javax.jms.CompletionListener;
import javax.jms.Destination;
import javax.jms.Message;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * Created by michaelandrepearce on 25/11/2016.
 */
public class JMSProducer implements javax.jms.JMSProducer {
    public javax.jms.JMSProducer send(Destination destination, Message message) {
        return null;
    }

    public javax.jms.JMSProducer send(Destination destination, String body) {
        return null;
    }

    public javax.jms.JMSProducer send(Destination destination, Map<String, Object> body) {
        return null;
    }

    public javax.jms.JMSProducer send(Destination destination, byte[] body) {
        return null;
    }

    public javax.jms.JMSProducer send(Destination destination, Serializable body) {
        return null;
    }

    public javax.jms.JMSProducer setDisableMessageID(boolean value) {
        return null;
    }

    public boolean getDisableMessageID() {
        return false;
    }

    public javax.jms.JMSProducer setDisableMessageTimestamp(boolean value) {
        return null;
    }

    public boolean getDisableMessageTimestamp() {
        return false;
    }

    public javax.jms.JMSProducer setDeliveryMode(int deliveryMode) {
        return null;
    }

    public int getDeliveryMode() {
        return 0;
    }

    public javax.jms.JMSProducer setPriority(int priority) {
        return null;
    }

    public int getPriority() {
        return 0;
    }

    public javax.jms.JMSProducer setTimeToLive(long timeToLive) {
        return null;
    }

    public long getTimeToLive() {
        return 0;
    }

    public javax.jms.JMSProducer setDeliveryDelay(long deliveryDelay) {
        return null;
    }

    public long getDeliveryDelay() {
        return 0;
    }

    public javax.jms.JMSProducer setAsync(CompletionListener completionListener) {
        return null;
    }

    public CompletionListener getAsync() {
        return null;
    }

    public javax.jms.JMSProducer setProperty(String name, boolean value) {
        return null;
    }

    public javax.jms.JMSProducer setProperty(String name, byte value) {
        return null;
    }

    public javax.jms.JMSProducer setProperty(String name, short value) {
        return null;
    }

    public javax.jms.JMSProducer setProperty(String name, int value) {
        return null;
    }

    public javax.jms.JMSProducer setProperty(String name, long value) {
        return null;
    }

    public javax.jms.JMSProducer setProperty(String name, float value) {
        return null;
    }

    public javax.jms.JMSProducer setProperty(String name, double value) {
        return null;
    }

    public javax.jms.JMSProducer setProperty(String name, String value) {
        return null;
    }

    public javax.jms.JMSProducer setProperty(String name, Object value) {
        return null;
    }

    public javax.jms.JMSProducer clearProperties() {
        return null;
    }

    public boolean propertyExists(String name) {
        return false;
    }

    public boolean getBooleanProperty(String name) {
        return false;
    }

    public byte getByteProperty(String name) {
        return 0;
    }

    public short getShortProperty(String name) {
        return 0;
    }

    public int getIntProperty(String name) {
        return 0;
    }

    public long getLongProperty(String name) {
        return 0;
    }

    public float getFloatProperty(String name) {
        return 0;
    }

    public double getDoubleProperty(String name) {
        return 0;
    }

    public String getStringProperty(String name) {
        return null;
    }

    public Object getObjectProperty(String name) {
        return null;
    }

    public Set<String> getPropertyNames() {
        return null;
    }

    public javax.jms.JMSProducer setJMSCorrelationIDAsBytes(byte[] correlationID) {
        return null;
    }

    public byte[] getJMSCorrelationIDAsBytes() {
        return new byte[0];
    }

    public javax.jms.JMSProducer setJMSCorrelationID(String correlationID) {
        return null;
    }

    public String getJMSCorrelationID() {
        return null;
    }

    public javax.jms.JMSProducer setJMSType(String type) {
        return null;
    }

    public String getJMSType() {
        return null;
    }

    public javax.jms.JMSProducer setJMSReplyTo(Destination replyTo) {
        return null;
    }

    public Destination getJMSReplyTo() {
        return null;
    }
}
