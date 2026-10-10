package org.apache.log4j.net;

import java.util.Properties;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class JMSAppender extends AppenderSkeleton {
    String initialContextFactoryName;
    boolean locationInfo;
    String password;
    String providerURL;
    String securityCredentials;
    String securityPrincipalName;
    String tcfBindingName;
    String topicBindingName;
    TopicConnection topicConnection;
    TopicPublisher topicPublisher;
    TopicSession topicSession;
    String urlPkgPrefixes;
    String userName;

    @Override // org.apache.log4j.Appender
    public synchronized void close() {
        try {
            if (this.closed) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Closing appender [");
            stringBuffer.append(this.name);
            stringBuffer.append("].");
            LogLog.debug(stringBuffer.toString());
            this.closed = true;
            try {
                TopicSession topicSession = this.topicSession;
                if (topicSession != null) {
                    topicSession.close();
                }
                TopicConnection topicConnection = this.topicConnection;
                if (topicConnection != null) {
                    topicConnection.close();
                }
            } catch (JMSException e10) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Error while closing JMSAppender [");
                stringBuffer2.append(this.name);
                stringBuffer2.append("].");
                LogLog.error(stringBuffer2.toString(), e10);
            } catch (RuntimeException e11) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Error while closing JMSAppender [");
                stringBuffer3.append(this.name);
                stringBuffer3.append("].");
                LogLog.error(stringBuffer3.toString(), e11);
            }
            this.topicPublisher = null;
            this.topicSession = null;
            this.topicConnection = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.apache.log4j.Appender
    public boolean requiresLayout() {
        return false;
    }

    @Override // org.apache.log4j.AppenderSkeleton, org.apache.log4j.spi.OptionHandler
    public void activateOptions() {
        InitialContext initialContext;
        try {
            LogLog.debug("Getting initial context.");
            if (this.initialContextFactoryName != null) {
                Properties properties = new Properties();
                properties.put("java.naming.factory.initial", this.initialContextFactoryName);
                String str = this.providerURL;
                if (str != null) {
                    properties.put("java.naming.provider.url", str);
                } else {
                    LogLog.warn("You have set InitialContextFactoryName option but not the ProviderURL. This is likely to cause problems.");
                }
                String str2 = this.urlPkgPrefixes;
                if (str2 != null) {
                    properties.put("java.naming.factory.url.pkgs", str2);
                }
                String str3 = this.securityPrincipalName;
                if (str3 != null) {
                    properties.put("java.naming.security.principal", str3);
                    String str4 = this.securityCredentials;
                    if (str4 != null) {
                        properties.put("java.naming.security.credentials", str4);
                    } else {
                        LogLog.warn("You have set SecurityPrincipalName option but not the SecurityCredentials. This is likely to cause problems.");
                    }
                }
                initialContext = new InitialContext(properties);
            } else {
                initialContext = new InitialContext();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Looking up [");
            stringBuffer.append(this.tcfBindingName);
            stringBuffer.append("]");
            LogLog.debug(stringBuffer.toString());
            TopicConnectionFactory topicConnectionFactory = (TopicConnectionFactory) lookup(initialContext, this.tcfBindingName);
            LogLog.debug("About to create TopicConnection.");
            String str5 = this.userName;
            if (str5 != null) {
                this.topicConnection = topicConnectionFactory.createTopicConnection(str5, this.password);
            } else {
                this.topicConnection = topicConnectionFactory.createTopicConnection();
            }
            LogLog.debug("Creating TopicSession, non-transactional, in AUTO_ACKNOWLEDGE mode.");
            this.topicSession = this.topicConnection.createTopicSession(false, 1);
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Looking up topic name [");
            stringBuffer2.append(this.topicBindingName);
            stringBuffer2.append("].");
            LogLog.debug(stringBuffer2.toString());
            Topic topic = (Topic) lookup(initialContext, this.topicBindingName);
            LogLog.debug("Creating TopicPublisher.");
            this.topicPublisher = this.topicSession.createPublisher(topic);
            LogLog.debug("Starting TopicConnection.");
            this.topicConnection.start();
            initialContext.close();
        } catch (JMSException e10) {
            ErrorHandler errorHandler = this.errorHandler;
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Error while activating options for appender named [");
            stringBuffer3.append(this.name);
            stringBuffer3.append("].");
            errorHandler.error(stringBuffer3.toString(), e10, 0);
        } catch (RuntimeException e11) {
            ErrorHandler errorHandler2 = this.errorHandler;
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("Error while activating options for appender named [");
            stringBuffer4.append(this.name);
            stringBuffer4.append("].");
            errorHandler2.error(stringBuffer4.toString(), e11, 0);
        } catch (NamingException e12) {
            ErrorHandler errorHandler3 = this.errorHandler;
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("Error while activating options for appender named [");
            stringBuffer5.append(this.name);
            stringBuffer5.append("].");
            errorHandler3.error(stringBuffer5.toString(), e12, 0);
        }
    }

    @Override // org.apache.log4j.AppenderSkeleton
    public void append(LoggingEvent loggingEvent) {
        if (checkEntryConditions()) {
            try {
                ObjectMessage objectMessageCreateObjectMessage = this.topicSession.createObjectMessage();
                if (this.locationInfo) {
                    loggingEvent.getLocationInformation();
                }
                objectMessageCreateObjectMessage.setObject(loggingEvent);
                this.topicPublisher.publish(objectMessageCreateObjectMessage);
            } catch (JMSException e10) {
                ErrorHandler errorHandler = this.errorHandler;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Could not publish message in JMSAppender [");
                stringBuffer.append(this.name);
                stringBuffer.append("].");
                errorHandler.error(stringBuffer.toString(), e10, 0);
            } catch (RuntimeException e11) {
                ErrorHandler errorHandler2 = this.errorHandler;
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Could not publish message in JMSAppender [");
                stringBuffer2.append(this.name);
                stringBuffer2.append("].");
                errorHandler2.error(stringBuffer2.toString(), e11, 0);
            }
        }
    }

    protected boolean checkEntryConditions() {
        String str;
        if (this.topicConnection == null) {
            str = "No TopicConnection";
        } else if (this.topicSession == null) {
            str = "No TopicSession";
        } else {
            str = this.topicPublisher == null ? "No TopicPublisher" : null;
        }
        if (str == null) {
            return true;
        }
        ErrorHandler errorHandler = this.errorHandler;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(" for JMSAppender named [");
        stringBuffer.append(this.name);
        stringBuffer.append("].");
        errorHandler.error(stringBuffer.toString());
        return false;
    }

    public String getInitialContextFactoryName() {
        return this.initialContextFactoryName;
    }

    public boolean getLocationInfo() {
        return this.locationInfo;
    }

    public String getPassword() {
        return this.password;
    }

    public String getProviderURL() {
        return this.providerURL;
    }

    public String getSecurityCredentials() {
        return this.securityCredentials;
    }

    public String getSecurityPrincipalName() {
        return this.securityPrincipalName;
    }

    public String getTopicBindingName() {
        return this.topicBindingName;
    }

    protected TopicConnection getTopicConnection() {
        return this.topicConnection;
    }

    public String getTopicConnectionFactoryBindingName() {
        return this.tcfBindingName;
    }

    protected TopicPublisher getTopicPublisher() {
        return this.topicPublisher;
    }

    protected TopicSession getTopicSession() {
        return this.topicSession;
    }

    String getURLPkgPrefixes() {
        return this.urlPkgPrefixes;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setInitialContextFactoryName(String str) {
        this.initialContextFactoryName = str;
    }

    public void setLocationInfo(boolean z10) {
        this.locationInfo = z10;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setProviderURL(String str) {
        this.providerURL = str;
    }

    public void setSecurityCredentials(String str) {
        this.securityCredentials = str;
    }

    public void setSecurityPrincipalName(String str) {
        this.securityPrincipalName = str;
    }

    public void setTopicBindingName(String str) {
        this.topicBindingName = str;
    }

    public void setTopicConnectionFactoryBindingName(String str) {
        this.tcfBindingName = str;
    }

    public void setURLPkgPrefixes(String str) {
        this.urlPkgPrefixes = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.naming.NameNotFoundException */
    protected Object lookup(Context context, String str) throws NameNotFoundException {
        try {
            return context.lookup(str);
        } catch (NameNotFoundException e10) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not find name [");
            stringBuffer.append(str);
            stringBuffer.append("].");
            LogLog.error(stringBuffer.toString());
            throw e10;
        }
    }
}
