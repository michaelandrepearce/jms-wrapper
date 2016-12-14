package is.sourcery.jms.monitoring;

import javax.jms.Message;

import is.sourcery.jms.monitoring.intercept.ConsumerInterceptor;

/**
 * Created by pearcem on 13/12/2016.
 */
public class MessageListener<T extends javax.jms.MessageListener> extends ForwardingObject<T> implements javax.jms.MessageListener
{

   private String clientId;
   private String subscriptionName;
   private ConsumerInterceptor consumerInterceptor;
   
   public MessageListener(ConsumerInterceptor consumerInterceptor, String clientId, String subscriptionName, T messageListener){
      super(messageListener);
      this.clientId = clientId;
      this.subscriptionName = subscriptionName;
      this.consumerInterceptor = consumerInterceptor;
   }

   public void onMessage(Message message)
   {
      delegate().onMessage(intercept(message));
   }
   
   public Message intercept(Message message)
   {
      return consumerInterceptor.onIntercept(clientId, subscriptionName, message);
   }
}
