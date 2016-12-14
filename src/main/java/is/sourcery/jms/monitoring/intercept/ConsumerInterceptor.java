package is.sourcery.jms.monitoring.intercept;

import javax.jms.Message;

/**
 * Created by pearcem on 13/12/2016.
 */
public interface ConsumerInterceptor
{
   Message onIntercept(String clientId, String subscriptionName, Message message);
}
