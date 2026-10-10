package org.apache.log4j.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.xml.DOMConfigurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class JMSSink implements MessageListener {
    static /* synthetic */ Class class$org$apache$log4j$net$JMSSink;
    static Logger logger;

    public static void main(String[] strArr) throws Throwable {
        if (strArr.length != 5) {
            usage("Wrong number of arguments.");
        }
        String str = strArr[0];
        String str2 = strArr[1];
        String str3 = strArr[2];
        String str4 = strArr[3];
        String str5 = strArr[4];
        if (str5.endsWith(".xml")) {
            DOMConfigurator.configure(str5);
        } else {
            PropertyConfigurator.configure(str5);
        }
        new JMSSink(str, str2, str3, str4);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Type \"exit\" to quit JMSSink.");
        while (!bufferedReader.readLine().equalsIgnoreCase("exit")) {
        }
        System.out.println("Exiting. Kill the application if it does not exit due to daemon threads.");
    }

    static {
        Class clsClass$ = class$org$apache$log4j$net$JMSSink;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.net.JMSSink");
            class$org$apache$log4j$net$JMSSink = clsClass$;
        }
        logger = Logger.getLogger(clsClass$);
    }

    public JMSSink(String str, String str2, String str3, String str4) {
        try {
            InitialContext initialContext = new InitialContext();
            TopicConnection topicConnectionCreateTopicConnection = ((TopicConnectionFactory) lookup(initialContext, str)).createTopicConnection(str3, str4);
            topicConnectionCreateTopicConnection.start();
            topicConnectionCreateTopicConnection.createTopicSession(false, 1).createSubscriber((Topic) initialContext.lookup(str2)).setMessageListener(this);
        } catch (RuntimeException e10) {
            logger.error("Could not read JMS message.", e10);
        } catch (JMSException e11) {
            logger.error("Could not read JMS message.", e11);
        } catch (NamingException e12) {
            logger.error("Could not read JMS message.", e12);
        }
    }

    static void usage(String str) throws Throwable {
        System.err.println(str);
        PrintStream printStream = System.err;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Usage: java ");
        Class clsClass$ = class$org$apache$log4j$net$JMSSink;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.net.JMSSink");
            class$org$apache$log4j$net$JMSSink = clsClass$;
        }
        stringBuffer.append(clsClass$.getName());
        stringBuffer.append(" TopicConnectionFactoryBindingName TopicBindingName username password configFile");
        printStream.println(stringBuffer.toString());
        System.exit(1);
    }

    public void onMessage(Message message) {
        try {
            if (message instanceof ObjectMessage) {
                LoggingEvent loggingEvent = (LoggingEvent) ((ObjectMessage) message).getObject();
                Logger.getLogger(loggingEvent.getLoggerName()).callAppenders(loggingEvent);
                return;
            }
            Logger logger2 = logger;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Received message is of type ");
            stringBuffer.append(message.getJMSType());
            stringBuffer.append(", was expecting ObjectMessage.");
            logger2.warn(stringBuffer.toString());
        } catch (JMSException e10) {
            logger.error("Exception thrown while processing incoming message.", e10);
        }
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.naming.NameNotFoundException */
    protected static Object lookup(Context context, String str) throws NameNotFoundException {
        try {
            return context.lookup(str);
        } catch (NameNotFoundException e10) {
            Logger logger2 = logger;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not find name [");
            stringBuffer.append(str);
            stringBuffer.append("].");
            logger2.error(stringBuffer.toString());
            throw e10;
        }
    }
}
