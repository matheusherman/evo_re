package org.apache.log4j.or.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.or.ObjectRenderer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class MessageRenderer implements ObjectRenderer {
    @Override // org.apache.log4j.or.ObjectRenderer
    public String doRender(Object obj) {
        if (!(obj instanceof Message)) {
            return obj.toString();
        }
        StringBuffer stringBuffer = new StringBuffer();
        Message message = (Message) obj;
        try {
            stringBuffer.append("DeliveryMode=");
            int jMSDeliveryMode = message.getJMSDeliveryMode();
            if (jMSDeliveryMode == 1) {
                stringBuffer.append("NON_PERSISTENT");
            } else if (jMSDeliveryMode != 2) {
                stringBuffer.append("UNKNOWN");
            } else {
                stringBuffer.append("PERSISTENT");
            }
            stringBuffer.append(", CorrelationID=");
            stringBuffer.append(message.getJMSCorrelationID());
            stringBuffer.append(", Destination=");
            stringBuffer.append(message.getJMSDestination());
            stringBuffer.append(", Expiration=");
            stringBuffer.append(message.getJMSExpiration());
            stringBuffer.append(", MessageID=");
            stringBuffer.append(message.getJMSMessageID());
            stringBuffer.append(", Priority=");
            stringBuffer.append(message.getJMSPriority());
            stringBuffer.append(", Redelivered=");
            stringBuffer.append(message.getJMSRedelivered());
            stringBuffer.append(", ReplyTo=");
            stringBuffer.append(message.getJMSReplyTo());
            stringBuffer.append(", Timestamp=");
            stringBuffer.append(message.getJMSTimestamp());
            stringBuffer.append(", Type=");
            stringBuffer.append(message.getJMSType());
        } catch (JMSException e10) {
            LogLog.error("Could not parse Message.", e10);
        }
        return stringBuffer.toString();
    }
}
