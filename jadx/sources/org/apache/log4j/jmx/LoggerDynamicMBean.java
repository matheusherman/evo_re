package org.apache.log4j.jmx;

import java.beans.IntrospectionException;
import java.util.Enumeration;
import java.util.Vector;
import javax.management.Attribute;
import javax.management.AttributeNotFoundException;
import javax.management.JMException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanConstructorInfo;
import javax.management.MBeanInfo;
import javax.management.MBeanNotificationInfo;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;
import javax.management.MalformedObjectNameException;
import javax.management.Notification;
import javax.management.NotificationListener;
import javax.management.ObjectName;
import javax.management.RuntimeOperationsException;
import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.DateLayout;
import org.apache.log4j.helpers.OptionConverter;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class LoggerDynamicMBean extends AbstractDynamicMBean implements NotificationListener {
    private static Logger cat;
    static /* synthetic */ Class class$org$apache$log4j$Appender;
    static /* synthetic */ Class class$org$apache$log4j$jmx$LoggerDynamicMBean;
    private Logger logger;
    private MBeanConstructorInfo[] dConstructors = new MBeanConstructorInfo[1];
    private MBeanOperationInfo[] dOperations = new MBeanOperationInfo[1];
    private Vector dAttributes = new Vector();
    private String dClassName = getClass().getName();
    private String dDescription = "This MBean acts as a management facade for a org.apache.log4j.Logger instance.";

    static {
        Class clsClass$ = class$org$apache$log4j$jmx$LoggerDynamicMBean;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.jmx.LoggerDynamicMBean");
            class$org$apache$log4j$jmx$LoggerDynamicMBean = clsClass$;
        }
        cat = Logger.getLogger(clsClass$);
    }

    void addAppender(String str, String str2) throws Throwable {
        Logger logger = cat;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("addAppender called with ");
        stringBuffer.append(str);
        stringBuffer.append(", ");
        stringBuffer.append(str2);
        logger.debug(stringBuffer.toString());
        Class clsClass$ = class$org$apache$log4j$Appender;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.Appender");
            class$org$apache$log4j$Appender = clsClass$;
        }
        Appender appender = (Appender) OptionConverter.instantiateByClassName(str, clsClass$, null);
        appender.setName(str2);
        this.logger.addAppender(appender);
    }

    void appenderMBeanRegistration() {
        Enumeration allAppenders = this.logger.getAllAppenders();
        while (allAppenders.hasMoreElements()) {
            registerAppenderMBean((Appender) allAppenders.nextElement());
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.management.AttributeNotFoundException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.management.RuntimeOperationsException */
    public Object getAttribute(String str) throws AttributeNotFoundException, RuntimeOperationsException {
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Attribute name cannot be null");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Cannot invoke a getter of ");
            stringBuffer.append(this.dClassName);
            stringBuffer.append(" with null attribute name");
            throw new RuntimeOperationsException(illegalArgumentException, stringBuffer.toString());
        }
        if (str.equals("name")) {
            return this.logger.getName();
        }
        if (str.equals("priority")) {
            Level level = this.logger.getLevel();
            if (level == null) {
                return null;
            }
            return level.toString();
        }
        if (str.startsWith("appender=")) {
            try {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("log4j:");
                stringBuffer2.append(str);
                return new ObjectName(stringBuffer2.toString());
            } catch (MalformedObjectNameException unused) {
                Logger logger = cat;
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Could not create ObjectName");
                stringBuffer3.append(str);
                logger.error(stringBuffer3.toString());
            } catch (RuntimeException unused2) {
                Logger logger2 = cat;
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("Could not create ObjectName");
                stringBuffer4.append(str);
                logger2.error(stringBuffer4.toString());
            }
        }
        StringBuffer stringBuffer5 = new StringBuffer();
        stringBuffer5.append("Cannot find ");
        stringBuffer5.append(str);
        stringBuffer5.append(" attribute in ");
        stringBuffer5.append(this.dClassName);
        throw new AttributeNotFoundException(stringBuffer5.toString());
    }

    @Override // org.apache.log4j.jmx.AbstractDynamicMBean
    protected Logger getLogger() {
        return this.logger;
    }

    public MBeanInfo getMBeanInfo() {
        MBeanAttributeInfo[] mBeanAttributeInfoArr = new MBeanAttributeInfo[this.dAttributes.size()];
        this.dAttributes.toArray(mBeanAttributeInfoArr);
        return new MBeanInfo(this.dClassName, this.dDescription, mBeanAttributeInfoArr, this.dConstructors, this.dOperations, new MBeanNotificationInfo[0]);
    }

    public void handleNotification(Notification notification, Object obj) {
        Logger logger = cat;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Received notification: ");
        stringBuffer.append(notification.getType());
        logger.debug(stringBuffer.toString());
        registerAppenderMBean((Appender) notification.getUserData());
    }

    public Object invoke(String str, Object[] objArr, String[] strArr) throws Throwable {
        if (!str.equals("addAppender")) {
            return null;
        }
        addAppender((String) objArr[0], (String) objArr[1]);
        return "Hello world.";
    }

    void registerAppenderMBean(Appender appender) {
        String appenderName = AbstractDynamicMBean.getAppenderName(appender);
        Logger logger = cat;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Adding AppenderMBean for appender named ");
        stringBuffer.append(appenderName);
        logger.debug(stringBuffer.toString());
        try {
            AppenderDynamicMBean appenderDynamicMBean = new AppenderDynamicMBean(appender);
            ObjectName objectName = new ObjectName("log4j", "appender", appenderName);
            if (this.server.isRegistered(objectName)) {
                return;
            }
            registerMBean(appenderDynamicMBean, objectName);
            Vector vector = this.dAttributes;
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("appender=");
            stringBuffer2.append(appenderName);
            String string = stringBuffer2.toString();
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("The ");
            stringBuffer3.append(appenderName);
            stringBuffer3.append(" appender.");
            vector.add(new MBeanAttributeInfo(string, "javax.management.ObjectName", stringBuffer3.toString(), true, true, false));
        } catch (RuntimeException e10) {
            Logger logger2 = cat;
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("Could not add appenderMBean for [");
            stringBuffer4.append(appenderName);
            stringBuffer4.append("].");
            logger2.error(stringBuffer4.toString(), e10);
        } catch (JMException e11) {
            Logger logger3 = cat;
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("Could not add appenderMBean for [");
            stringBuffer5.append(appenderName);
            stringBuffer5.append("].");
            logger3.error(stringBuffer5.toString(), e11);
        } catch (IntrospectionException e12) {
            Logger logger4 = cat;
            StringBuffer stringBuffer6 = new StringBuffer();
            stringBuffer6.append("Could not add appenderMBean for [");
            stringBuffer6.append(appenderName);
            stringBuffer6.append("].");
            logger4.error(stringBuffer6.toString(), e12);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.management.AttributeNotFoundException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.management.RuntimeOperationsException */
    public void setAttribute(Attribute attribute) throws AttributeNotFoundException, RuntimeOperationsException {
        if (attribute == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Attribute cannot be null");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Cannot invoke a setter of ");
            stringBuffer.append(this.dClassName);
            stringBuffer.append(" with null attribute");
            throw new RuntimeOperationsException(illegalArgumentException, stringBuffer.toString());
        }
        String name = attribute.getName();
        Object value = attribute.getValue();
        if (name == null) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Attribute name cannot be null");
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Cannot invoke the setter of ");
            stringBuffer2.append(this.dClassName);
            stringBuffer2.append(" with null attribute name");
            throw new RuntimeOperationsException(illegalArgumentException2, stringBuffer2.toString());
        }
        if (name.equals("priority")) {
            if (value instanceof String) {
                String str = (String) value;
                this.logger.setLevel(str.equalsIgnoreCase(DateLayout.NULL_DATE_FORMAT) ? null : OptionConverter.toLevel(str, this.logger.getLevel()));
                return;
            }
            return;
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append("Attribute ");
        stringBuffer3.append(name);
        stringBuffer3.append(" not found in ");
        stringBuffer3.append(getClass().getName());
        throw new AttributeNotFoundException(stringBuffer3.toString());
    }

    public LoggerDynamicMBean(Logger logger) {
        this.logger = logger;
        buildDynamicMBeanInfo();
    }

    private void buildDynamicMBeanInfo() {
        this.dConstructors[0] = new MBeanConstructorInfo("HierarchyDynamicMBean(): Constructs a HierarchyDynamicMBean instance", getClass().getConstructors()[0]);
        this.dAttributes.add(new MBeanAttributeInfo("name", "java.lang.String", "The name of this Logger.", true, false, false));
        this.dAttributes.add(new MBeanAttributeInfo("priority", "java.lang.String", "The priority of this logger.", true, true, false));
        this.dOperations[0] = new MBeanOperationInfo("addAppender", "addAppender(): add an appender", new MBeanParameterInfo[]{new MBeanParameterInfo("class name", "java.lang.String", "add an appender to this logger"), new MBeanParameterInfo("appender name", "java.lang.String", "name of the appender")}, "void", 1);
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    @Override // org.apache.log4j.jmx.AbstractDynamicMBean
    public void postRegister(Boolean bool) {
        appenderMBeanRegistration();
    }
}
