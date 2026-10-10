package org.apache.log4j.jmx;

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
import javax.management.Notification;
import javax.management.NotificationBroadcaster;
import javax.management.NotificationBroadcasterSupport;
import javax.management.NotificationFilter;
import javax.management.NotificationFilterSupport;
import javax.management.NotificationListener;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.RuntimeOperationsException;
import org.apache.log4j.Appender;
import org.apache.log4j.Category;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.spi.HierarchyEventListener;
import org.apache.log4j.spi.LoggerRepository;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class HierarchyDynamicMBean extends AbstractDynamicMBean implements HierarchyEventListener, NotificationBroadcaster {
    static final String ADD_APPENDER = "addAppender.";
    static final String THRESHOLD = "threshold";
    static /* synthetic */ Class class$org$apache$log4j$jmx$HierarchyDynamicMBean;
    private static Logger log;
    private MBeanConstructorInfo[] dConstructors = new MBeanConstructorInfo[1];
    private MBeanOperationInfo[] dOperations = new MBeanOperationInfo[1];
    private Vector vAttributes = new Vector();
    private String dClassName = getClass().getName();
    private String dDescription = "This MBean acts as a management facade for org.apache.log4j.Hierarchy.";
    private NotificationBroadcasterSupport nbs = new NotificationBroadcasterSupport();
    private LoggerRepository hierarchy = LogManager.getLoggerRepository();

    public ObjectName addLoggerMBean(String str) {
        Logger loggerExists = LogManager.exists(str);
        if (loggerExists != null) {
            return addLoggerMBean(loggerExists);
        }
        return null;
    }

    static {
        Class clsClass$ = class$org$apache$log4j$jmx$HierarchyDynamicMBean;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.jmx.HierarchyDynamicMBean");
            class$org$apache$log4j$jmx$HierarchyDynamicMBean = clsClass$;
        }
        log = Logger.getLogger(clsClass$);
    }

    @Override // org.apache.log4j.spi.HierarchyEventListener
    public void addAppenderEvent(Category category, Appender appender) {
        Logger logger = log;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("addAppenderEvent called: logger=");
        stringBuffer.append(category.getName());
        stringBuffer.append(", appender=");
        stringBuffer.append(appender.getName());
        logger.debug(stringBuffer.toString());
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(ADD_APPENDER);
        stringBuffer2.append(category.getName());
        Notification notification = new Notification(stringBuffer2.toString(), this, 0L);
        notification.setUserData(appender);
        log.debug("sending notification.");
        this.nbs.sendNotification(notification);
    }

    public void addNotificationListener(NotificationListener notificationListener, NotificationFilter notificationFilter, Object obj) {
        this.nbs.addNotificationListener(notificationListener, notificationFilter, obj);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.management.AttributeNotFoundException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.management.RuntimeOperationsException */
    public Object getAttribute(String str) throws AttributeNotFoundException, RuntimeOperationsException {
        String string;
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Attribute name cannot be null");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Cannot invoke a getter of ");
            stringBuffer.append(this.dClassName);
            stringBuffer.append(" with null attribute name");
            throw new RuntimeOperationsException(illegalArgumentException, stringBuffer.toString());
        }
        Logger logger = log;
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Called getAttribute with [");
        stringBuffer2.append(str);
        stringBuffer2.append("].");
        logger.debug(stringBuffer2.toString());
        if (str.equals(THRESHOLD)) {
            return this.hierarchy.getThreshold();
        }
        if (str.startsWith("logger")) {
            int iIndexOf = str.indexOf("%3D");
            if (iIndexOf > 0) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append(str.substring(0, iIndexOf));
                stringBuffer3.append('=');
                stringBuffer3.append(str.substring(iIndexOf + 3));
                string = stringBuffer3.toString();
            } else {
                string = str;
            }
            try {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("log4j:");
                stringBuffer4.append(string);
                return new ObjectName(stringBuffer4.toString());
            } catch (RuntimeException unused) {
                Logger logger2 = log;
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append("Could not create ObjectName");
                stringBuffer5.append(string);
                logger2.error(stringBuffer5.toString());
            } catch (JMException unused2) {
                Logger logger3 = log;
                StringBuffer stringBuffer6 = new StringBuffer();
                stringBuffer6.append("Could not create ObjectName");
                stringBuffer6.append(string);
                logger3.error(stringBuffer6.toString());
            }
        }
        StringBuffer stringBuffer7 = new StringBuffer();
        stringBuffer7.append("Cannot find ");
        stringBuffer7.append(str);
        stringBuffer7.append(" attribute in ");
        stringBuffer7.append(this.dClassName);
        throw new AttributeNotFoundException(stringBuffer7.toString());
    }

    @Override // org.apache.log4j.jmx.AbstractDynamicMBean
    protected Logger getLogger() {
        return log;
    }

    public MBeanInfo getMBeanInfo() {
        MBeanAttributeInfo[] mBeanAttributeInfoArr = new MBeanAttributeInfo[this.vAttributes.size()];
        this.vAttributes.toArray(mBeanAttributeInfoArr);
        return new MBeanInfo(this.dClassName, this.dDescription, mBeanAttributeInfoArr, this.dConstructors, this.dOperations, new MBeanNotificationInfo[0]);
    }

    public MBeanNotificationInfo[] getNotificationInfo() {
        return this.nbs.getNotificationInfo();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.management.ReflectionException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.management.RuntimeOperationsException */
    public Object invoke(String str, Object[] objArr, String[] strArr) throws ReflectionException, RuntimeOperationsException {
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Operation name cannot be null");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Cannot invoke a null operation in ");
            stringBuffer.append(this.dClassName);
            throw new RuntimeOperationsException(illegalArgumentException, stringBuffer.toString());
        }
        if (str.equals("addLoggerMBean")) {
            return addLoggerMBean((String) objArr[0]);
        }
        NoSuchMethodException noSuchMethodException = new NoSuchMethodException(str);
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Cannot find the operation ");
        stringBuffer2.append(str);
        stringBuffer2.append(" in ");
        stringBuffer2.append(this.dClassName);
        throw new ReflectionException(noSuchMethodException, stringBuffer2.toString());
    }

    @Override // org.apache.log4j.jmx.AbstractDynamicMBean
    public void postRegister(Boolean bool) {
        log.debug("postRegister is called.");
        this.hierarchy.addHierarchyEventListener(this);
        addLoggerMBean(this.hierarchy.getRootLogger());
    }

    @Override // org.apache.log4j.spi.HierarchyEventListener
    public void removeAppenderEvent(Category category, Appender appender) {
        Logger logger = log;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("removeAppenderCalled: logger=");
        stringBuffer.append(category.getName());
        stringBuffer.append(", appender=");
        stringBuffer.append(appender.getName());
        logger.debug(stringBuffer.toString());
    }

    public void removeNotificationListener(NotificationListener notificationListener) {
        this.nbs.removeNotificationListener(notificationListener);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.management.RuntimeOperationsException */
    public void setAttribute(Attribute attribute) throws Throwable {
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
        if (name != null) {
            if (name.equals(THRESHOLD)) {
                this.hierarchy.setThreshold(OptionConverter.toLevel((String) value, this.hierarchy.getThreshold()));
                return;
            }
            return;
        }
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Attribute name cannot be null");
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Cannot invoke the setter of ");
        stringBuffer2.append(this.dClassName);
        stringBuffer2.append(" with null attribute name");
        throw new RuntimeOperationsException(illegalArgumentException2, stringBuffer2.toString());
    }

    public HierarchyDynamicMBean() {
        buildDynamicMBeanInfo();
    }

    private void buildDynamicMBeanInfo() {
        this.dConstructors[0] = new MBeanConstructorInfo("HierarchyDynamicMBean(): Constructs a HierarchyDynamicMBean instance", getClass().getConstructors()[0]);
        this.vAttributes.add(new MBeanAttributeInfo(THRESHOLD, "java.lang.String", "The \"threshold\" state of the hiearchy.", true, true, false));
        this.dOperations[0] = new MBeanOperationInfo("addLoggerMBean", "addLoggerMBean(): add a loggerMBean", new MBeanParameterInfo[]{new MBeanParameterInfo("name", "java.lang.String", "Create a logger MBean")}, "javax.management.ObjectName", 1);
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    ObjectName addLoggerMBean(Logger logger) {
        RuntimeException runtimeException;
        Throwable th;
        String name = logger.getName();
        ObjectName objectName = null;
        try {
            LoggerDynamicMBean loggerDynamicMBean = new LoggerDynamicMBean(logger);
            ObjectName objectName2 = new ObjectName("log4j", "logger", name);
            try {
                if (this.server.isRegistered(objectName2)) {
                    return objectName2;
                }
                registerMBean(loggerDynamicMBean, objectName2);
                NotificationFilterSupport notificationFilterSupport = new NotificationFilterSupport();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(ADD_APPENDER);
                stringBuffer.append(logger.getName());
                notificationFilterSupport.enableType(stringBuffer.toString());
                Logger logger2 = log;
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("---Adding logger [");
                stringBuffer2.append(name);
                stringBuffer2.append("] as listener.");
                logger2.debug(stringBuffer2.toString());
                this.nbs.addNotificationListener(loggerDynamicMBean, notificationFilterSupport, (Object) null);
                Vector vector = this.vAttributes;
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("logger=");
                stringBuffer3.append(name);
                String string = stringBuffer3.toString();
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("The ");
                stringBuffer4.append(name);
                stringBuffer4.append(" logger.");
                vector.add(new MBeanAttributeInfo(string, "javax.management.ObjectName", stringBuffer4.toString(), true, true, false));
                return objectName2;
            } catch (RuntimeException e10) {
                runtimeException = e10;
                objectName = objectName2;
                Logger logger3 = log;
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append("Could not add loggerMBean for [");
                stringBuffer5.append(name);
                stringBuffer5.append("].");
                logger3.error(stringBuffer5.toString(), runtimeException);
                return objectName;
            } catch (JMException e11) {
                th = e11;
                objectName = objectName2;
                Logger logger4 = log;
                StringBuffer stringBuffer6 = new StringBuffer();
                stringBuffer6.append("Could not add loggerMBean for [");
                stringBuffer6.append(name);
                stringBuffer6.append("].");
                logger4.error(stringBuffer6.toString(), th);
                return objectName;
            }
        } catch (JMException e12) {
            th = e12;
        } catch (RuntimeException e13) {
            runtimeException = e13;
        }
    }
}
