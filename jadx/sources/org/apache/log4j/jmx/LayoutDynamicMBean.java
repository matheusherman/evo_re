package org.apache.log4j.jmx;

import androidx.view.k;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Vector;
import javax.management.Attribute;
import javax.management.AttributeNotFoundException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanConstructorInfo;
import javax.management.MBeanInfo;
import javax.management.MBeanNotificationInfo;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;
import javax.management.RuntimeOperationsException;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.OptionConverter;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class LayoutDynamicMBean extends AbstractDynamicMBean {
    private static Logger cat;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$org$apache$log4j$Level;
    static /* synthetic */ Class class$org$apache$log4j$Priority;
    static /* synthetic */ Class class$org$apache$log4j$jmx$LayoutDynamicMBean;
    private Layout layout;
    private MBeanConstructorInfo[] dConstructors = new MBeanConstructorInfo[1];
    private Vector dAttributes = new Vector();
    private String dClassName = getClass().getName();
    private Hashtable dynamicProps = new Hashtable(5);
    private MBeanOperationInfo[] dOperations = new MBeanOperationInfo[1];
    private String dDescription = "This MBean acts as a management facade for log4j layouts.";

    static {
        Class clsClass$ = class$org$apache$log4j$jmx$LayoutDynamicMBean;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.jmx.LayoutDynamicMBean");
            class$org$apache$log4j$jmx$LayoutDynamicMBean = clsClass$;
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
        MethodUnion methodUnion = (MethodUnion) this.dynamicProps.get(str);
        Logger logger = cat;
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("----name=");
        stringBuffer2.append(str);
        stringBuffer2.append(", mu=");
        stringBuffer2.append(methodUnion);
        logger.debug(stringBuffer2.toString());
        if (methodUnion == null || (method = methodUnion.readMethod) == null) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Cannot find ");
            stringBuffer3.append(str);
            stringBuffer3.append(" attribute in ");
            stringBuffer3.append(this.dClassName);
            throw new AttributeNotFoundException(stringBuffer3.toString());
        }
        try {
            return method.invoke(this.layout, null);
        } catch (IllegalAccessException | RuntimeException unused) {
            return null;
        } catch (InvocationTargetException e10) {
            if ((e10.getTargetException() instanceof InterruptedException) || (e10.getTargetException() instanceof InterruptedIOException)) {
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

    public Object invoke(String str, Object[] objArr, String[] strArr) {
        if (!str.equals("activateOptions") || !k.a(this.layout)) {
            return null;
        }
        this.layout.activateOptions();
        return "Options activated.";
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
            methodUnion.writeMethod.invoke(this.layout, value);
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

    public LayoutDynamicMBean(Layout layout) throws Throwable {
        this.layout = layout;
        buildDynamicMBeanInfo();
    }

    private void buildDynamicMBeanInfo() throws Throwable {
        String name;
        boolean z10;
        this.dConstructors[0] = new MBeanConstructorInfo("LayoutDynamicMBean(): Constructs a LayoutDynamicMBean instance", getClass().getConstructors()[0]);
        PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(this.layout.getClass()).getPropertyDescriptors();
        int length = propertyDescriptors.length;
        for (int i10 = 0; i10 < length; i10++) {
            String name2 = propertyDescriptors[i10].getName();
            Method readMethod = propertyDescriptors[i10].getReadMethod();
            Method writeMethod = propertyDescriptors[i10].getWriteMethod();
            if (readMethod != null) {
                Class<?> returnType = readMethod.getReturnType();
                if (isSupportedType(returnType)) {
                    Class<?> clsClass$ = class$org$apache$log4j$Level;
                    if (clsClass$ == null) {
                        clsClass$ = class$("org.apache.log4j.Level");
                        class$org$apache$log4j$Level = clsClass$;
                    }
                    if (returnType.isAssignableFrom(clsClass$)) {
                        name = "java.lang.String";
                    } else {
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
        }
        this.dOperations[0] = new MBeanOperationInfo("activateOptions", "activateOptions(): add an layout", new MBeanParameterInfo[0], "void", 1);
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
        Class<?> clsClass$2 = class$org$apache$log4j$Level;
        if (clsClass$2 == null) {
            clsClass$2 = class$("org.apache.log4j.Level");
            class$org$apache$log4j$Level = clsClass$2;
        }
        if (cls.isAssignableFrom(clsClass$2)) {
            return true;
        }
        return false;
    }
}
