package is.sourcery.jms.monitoring.intercept;

import javax.jms.Destination;
import javax.jms.Message;

/**
 * Created by pearcem on 13/12/2016.
 */
public interface ProducerInterceptor
{
   Message onIntercept(String clientId, Destination destination, Message message);
}
