package is.sourcery.jms.monitoring.intercept;

import javax.jms.Message;

/**
 * Created by pearcem on 14/12/2016.
 */
public class NoOpConsumerInterceptor implements ConsumerInterceptor
{

   /**
    * Private constructor prevents instantiation from other classes
    */
   private NoOpConsumerInterceptor() {}

   /**
    * SingletonHolder is loaded on the first execution of Singleton.getInstance() 
    * or the first access to SingletonHolder.INSTANCE, not before.
    */
   private static class SingletonHolder {
      private static final NoOpConsumerInterceptor INSTANCE = new NoOpConsumerInterceptor();
   }

   public static NoOpConsumerInterceptor getInstance() {
      return SingletonHolder.INSTANCE;
   }
   
   public Message onIntercept(String clientId, String subscriptionName, Message message)
   {
      return message;
   }
}
