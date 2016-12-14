package is.sourcery.jms.monitoring.intercept;

import javax.jms.Destination;
import javax.jms.Message;

/**
 * Created by pearcem on 14/12/2016.
 */
public class NoOpProducerInterceptor implements ProducerInterceptor
{
   /**
    * Private constructor prevents instantiation from other classes
    */
   private NoOpProducerInterceptor() {}

   /**
    * SingletonHolder is loaded on the first execution of Singleton.getInstance() 
    * or the first access to SingletonHolder.INSTANCE, not before.
    */
   private static class SingletonHolder {
      private static final NoOpProducerInterceptor INSTANCE = new NoOpProducerInterceptor();
   }

   public static NoOpProducerInterceptor getInstance() {
      return NoOpProducerInterceptor.SingletonHolder.INSTANCE;
   }

   public Message onIntercept(String clientId, Destination destination, Message message)
   {
      return message;
   }
}
