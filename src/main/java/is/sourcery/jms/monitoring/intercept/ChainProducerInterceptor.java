package is.sourcery.jms.monitoring.intercept;

import javax.jms.Destination;
import javax.jms.Message;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pearcem on 14/12/2016.
 */
public class ChainProducerInterceptor implements ProducerInterceptor
{

   List<ProducerInterceptor> producerInterceptorList;
   
   public ChainProducerInterceptor(List<ProducerInterceptor> producerInterceptorList){
      this.producerInterceptorList = new ArrayList<ProducerInterceptor>(producerInterceptorList);
   }
   
   public Message onIntercept(String clientId, Destination destination, Message message)
   {
      for(ProducerInterceptor producerInterceptor : producerInterceptorList){
         message = producerInterceptor.onIntercept(clientId, destination, message);
      }
      return message;
   }
}
