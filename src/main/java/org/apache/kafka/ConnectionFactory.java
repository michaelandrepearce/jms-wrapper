package org.apache.kafka;

import javax.jms.Connection;
import javax.jms.JMSContext;
import javax.jms.JMSException;

/**
 * Created by michaelandrepearce on 12/12/2016.
 */
public class ConnectionFactory<T extends javax.jms.ConnectionFactory> extends ForwardingObject<T> implements javax.jms.ConnectionFactory {

    public ConnectionFactory(T connectionFactory){
        super(connectionFactory);
    }

    public Connection createConnection() throws JMSException {
        return delegate().createConnection();
    }

    public Connection createConnection(String userName, String password) throws JMSException {
        return delegate().createConnection(userName, password);
    }

    public JMSContext createContext() {
        return delegate().createContext();
    }

    public JMSContext createContext(String userName, String password) {
        return delegate().createContext(userName, password);
    }

    public JMSContext createContext(String userName, String password, int sessionMode) {
        return delegate().createContext(userName, password, sessionMode);
    }

    public JMSContext createContext(int sessionMode) {
        return delegate().createContext(sessionMode);
    }

}
