package org.apache.log4j.jmx;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;
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
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.RuntimeOperationsException;
import org.apache.log4j.Appender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.spi.OptionHandler;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class AppenderDynamicMBean extends AbstractDynamicMBean {
    private static Logger cat;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$org$apache$log4j$Layout;
    static /* synthetic */ Class class$org$apache$log4j$Priority;
    static /* synthetic */ Class class$org$apache$log4j$jmx$AppenderDynamicMBean;
    private Appender appender;
    private MBeanConstructorInfo[] dConstructors = new MBeanConstructorInfo[1];
    private Vector dAttributes = new Vector();
    private String dClassName = getClass().getName();
    private Hashtable dynamicProps = new Hashtable(5);
    private MBeanOperationInfo[] dOperations = new MBeanOperationInfo[2];
    private String dDescription = "This MBean acts as a management facade for log4j appenders.";

    static {
        Class clsClass$ = class$org$apache$log4j$jmx$AppenderDynamicMBean;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.jmx.AppenderDynamicMBean");
            class$org$apache$log4j$jmx$AppenderDynamicMBean = clsClass$;
        }
        cat = Logger.getLogger(clsClass$);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.management.AttributeNotFoundException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.management.RuntimeOperationsException */
    public Object getAttribute(String str) throws AttributeNotFoundException, RuntimeOperationsException {
        Method method;
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Attribute name cannot be null");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Cannot invoke a getter of ");
            stringBuffer.append(this.dClassName);
            stringBuffer.append(" with null attribute name");
            throw new RuntimeOperationsException(illegalArgumentException, stringBuffer.toString());
        }
        Logger logger = cat;
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("getAttribute called with [");
        stringBuffer2.append(str);
        stringBuffer2.append("].");
        logger.debug(stringBuffer2.toString());
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append("appender=");
        stringBuffer3.append(this.appender.getName());
        stringBuffer3.append(",layout");
        if (str.startsWith(stringBuffer3.toString())) {
            try {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("log4j:");
                stringBuffer4.append(str);
                return new ObjectName(stringBuffer4.toString());
            } catch (RuntimeException e10) {
                cat.error("attributeName", e10);
            } catch (MalformedObjectNameException e11) {
                cat.error("attributeName", e11);
            }
        }
        MethodUnion methodUnion = (MethodUnion) this.dynamicProps.get(str);
        if (methodUnion == null || (method = methodUnion.readMethod) == null) {
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("Cannot find ");
            stringBuffer5.append(str);
            stringBuffer5.append(" attribute in ");
            stringBuffer5.append(this.dClassName);
            throw new AttributeNotFoundException(stringBuffer5.toString());
        }
        try {
            return method.invoke(this.appender, null);
        } catch (IllegalAccessException unused) {
            return null;
        } catch (RuntimeException unused2) {
            return null;
        } catch (InvocationTargetException e12) {
            if ((e12.getTargetException() instanceof InterruptedException) || (e12.getTargetException() instanceof InterruptedIOException)) {
                Thread.currentThread().interrupt();
            }
            return null;
        }
    }

    @Override // org.apache.log4j.jmx.AbstractDynamicMBean
    protected Logger getLogger() {
        return cat;
    }

    public MBeanInfo getMBeanInfo() {
        cat.debug("getMBeanInfo called.");
        MBeanAttributeInfo[] mBeanAttributeInfoArr = new MBeanAttributeInfo[this.dAttributes.size()];
        this.dAttributes.toArray(mBeanAttributeInfoArr);
        return new MBeanInfo(this.dClassName, this.dDescription, mBeanAttributeInfoArr, this.dConstructors, this.dOperations, new MBeanNotificationInfo[0]);
    }

    public Object invoke(String str, Object[] objArr, String[] strArr) throws Throwable {
        if (str.equals("activateOptions")) {
            Appender appender = this.appender;
            if (appender instanceof OptionHandler) {
                ((OptionHandler) appender).activateOptions();
                return "Options activated.";
            }
        }
        if (str.equals("setLayout")) {
            String str2 = (String) objArr[0];
            Class clsClass$ = class$org$apache$log4j$Layout;
            if (clsClass$ == null) {
                clsClass$ = class$("org.apache.log4j.Layout");
                class$org$apache$log4j$Layout = clsClass$;
            }
            Layout layout = (Layout) OptionConverter.instantiateByClassName(str2, clsClass$, null);
            this.appender.setLayout(layout);
            registerLayoutMBean(layout);
        }
        return null;
    }

    @Override // org.apache.log4j.jmx.AbstractDynamicMBean
    public ObjectName preRegister(MBeanServer mBeanServer, ObjectName objectName) {
        Logger logger = cat;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("preRegister called. Server=");
        stringBuffer.append(mBeanServer);
        stringBuffer.append(", name=");
        stringBuffer.append(objectName);
        logger.debug(stringBuffer.toString());
        this.server = mBeanServer;
        registerLayoutMBean(this.appender.getLayout());
        return objectName;
    }

    void registerLayoutMBean(Layout layout) {
        if (layout == null) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(AbstractDynamicMBean.getAppenderName(this.appender));
        stringBuffer.append(",layout=");
        stringBuffer.append(layout.getClass().getName());
        String string = stringBuffer.toString();
        Logger logger = cat;
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Adding LayoutMBean:");
        stringBuffer2.append(string);
        logger.debug(stringBuffer2.toString());
        try {
            LayoutDynamicMBean layoutDynamicMBean = new LayoutDynamicMBean(layout);
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("log4j:appender=");
            stringBuffer3.append(string);
            ObjectName objectName = new ObjectName(stringBuffer3.toString());
            if (this.server.isRegistered(objectName)) {
                return;
            }
            registerMBean(layoutDynamicMBean, objectName);
            Vector vector = this.dAttributes;
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("appender=");
            stringBuffer4.append(string);
            String string2 = stringBuffer4.toString();
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("The ");
            stringBuffer5.append(string);
            stringBuffer5.append(" layout.");
            vector.add(new MBeanAttributeInfo(string2, "javax.management.ObjectName", stringBuffer5.toString(), true, true, false));
        } catch (RuntimeException e10) {
            Logger logger2 = cat;
            StringBuffer stringBuffer6 = new StringBuffer();
            stringBuffer6.append("Could not add DynamicLayoutMBean for [");
            stringBuffer6.append(string);
            stringBuffer6.append("].");
            logger2.error(stringBuffer6.toString(), e10);
        } catch (JMException e11) {
            Logger logger3 = cat;
            StringBuffer stringBuffer7 = new StringBuffer();
            stringBuffer7.append("Could not add DynamicLayoutMBean for [");
            stringBuffer7.append(string);
            stringBuffer7.append("].");
            logger3.error(stringBuffer7.toString(), e11);
        } catch (IntrospectionException e12) {
            Logger logger4 = cat;
            StringBuffer stringBuffer8 = new StringBuffer();
            stringBuffer8.append("Could not add DynamicLayoutMBean for [");
            stringBuffer8.append(string);
            stringBuffer8.append("].");
            logger4.error(stringBuffer8.toString(), e12);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.management.AttributeNotFoundException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.management.RuntimeOperationsException */
    public void setAttribute(Attribute attribute) throws Throwable {
        Method method;
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
        MethodUnion methodUnion = (MethodUnion) this.dynamicProps.get(name);
        if (methodUnion == null || (method = methodUnion.writeMethod) == null) {
            if (name.endsWith(".layout")) {
                return;
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Attribute ");
            stringBuffer3.append(name);
            stringBuffer3.append(" not found in ");
            stringBuffer3.append(getClass().getName());
            throw new AttributeNotFoundException(stringBuffer3.toString());
        }
        Class<?> cls = method.getParameterTypes()[0];
        Class<?> clsClass$ = class$org$apache$log4j$Priority;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.Priority");
            class$org$apache$log4j$Priority = clsClass$;
        }
        if (cls == clsClass$) {
            value = OptionConverter.toLevel((String) value, (Level) getAttribute(name));
        }
        try {
            methodUnion.writeMethod.invoke(this.appender, value);
        } catch (IllegalAccessException e10) {
            cat.error("FIXME", e10);
        } catch (RuntimeException e11) {
            cat.error("FIXME", e11);
        } catch (InvocationTargetException e12) {
            if ((e12.getTargetException() instanceof InterruptedException) || (e12.getTargetException() instanceof InterruptedIOException)) {
                Thread.currentThread().interrupt();
            }
            cat.error("FIXME", e12);
        }
    }

    public AppenderDynamicMBean(Appender appender) throws Throwable {
        this.appender = appender;
        buildDynamicMBeanInfo();
    }

    private void buildDynamicMBeanInfo() throws Throwable {
        boolean z10;
        this.dConstructors[0] = new MBeanConstructorInfo("AppenderDynamicMBean(): Constructs a AppenderDynamicMBean instance", getClass().getConstructors()[0]);
        PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(this.appender.getClass()).getPropertyDescriptors();
        int length = propertyDescriptors.length;
        int i10 = 0;
        while (true) {
            String name = "java.lang.String";
            if (i10 < length) {
                String name2 = propertyDescriptors[i10].getName();
                Method readMethod = propertyDescriptors[i10].getReadMethod();
                Method writeMethod = propertyDescriptors[i10].getWriteMethod();
                if (readMethod != null) {
                    Class<?> returnType = readMethod.getReturnType();
                    if (isSupportedType(returnType)) {
                        Class<?> clsClass$ = class$org$apache$log4j$Priority;
                        if (clsClass$ == null) {
                            clsClass$ = class$("org.apache.log4j.Priority");
                            class$org$apache$log4j$Priority = clsClass$;
                        }
                        if (!returnType.isAssignableFrom(clsClass$)) {
                            name = returnType.getName();
                        }
                        String str = name;
                        Vector vector = this.dAttributes;
                        if (writeMethod != null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        vector.add(new MBeanAttributeInfo(name2, str, "Dynamic", true, z10, false));
                        this.dynamicProps.put(name2, new MethodUnion(readMethod, writeMethod));
                    }
                }
                i10++;
            } else {
                this.dOperations[0] = new MBeanOperationInfo("activateOptions", "activateOptions(): add an appender", new MBeanParameterInfo[0], "void", 1);
                this.dOperations[1] = new MBeanOperationInfo("setLayout", "setLayout(): add a layout", new MBeanParameterInfo[]{new MBeanParameterInfo("layout class", "java.lang.String", "layout class")}, "void", 1);
                return;
            }
        }
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    private boolean isSupportedType(Class cls) throws Throwable {
        if (cls.isPrimitive()) {
            return true;
        }
        Class clsClass$ = class$java$lang$String;
        if (clsClass$ == null) {
            clsClass$ = class$("java.lang.String");
            class$java$lang$String = clsClass$;
        }
        if (cls == clsClass$) {
            return true;
        }
        Class<?> clsClass$2 = class$org$apache$log4j$Priority;
        if (clsClass$2 == null) {
            clsClass$2 = class$("org.apache.log4j.Priority");
            class$org$apache$log4j$Priority = clsClass$2;
        }
        if (cls.isAssignableFrom(clsClass$2)) {
            return true;
        }
        return false;
    }
}
