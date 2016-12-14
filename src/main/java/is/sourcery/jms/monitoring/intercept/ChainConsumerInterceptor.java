package is.sourcery.jms.monitoring.intercept;

import javax.jms.Destination;
import javax.jms.Message;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pearcem on 14/12/2016.
 */
public class ChainConsumerInterceptor implements ConsumerInterceptor
{

   List<ConsumerInterceptor> consumerInterceptorList;
   
   public ChainConsumerInterceptor(List<ConsumerInterceptor> consumerInterceptorList){
      this.consumerInterceptorList = new ArrayList<ConsumerInterceptor>(consumerInterceptorList);
   }

   public Message onIntercept(String clientId, String subscriptionName, Message message)
   {
      for(ConsumerInterceptor consumerInterceptor : consumerInterceptorList){
         message = consumerInterceptor.onIntercept(clientId, subscriptionName, message);
      }
      return message;
   }
}
