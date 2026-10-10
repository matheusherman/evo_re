package org.apache.log4j.config;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Properties;
import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.spi.OptionHandler;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class PropertySetter {
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$org$apache$log4j$Priority;
    static /* synthetic */ Class class$org$apache$log4j$spi$ErrorHandler;
    static /* synthetic */ Class class$org$apache$log4j$spi$OptionHandler;
    protected Object obj;
    protected PropertyDescriptor[] props;

    public static void setProperties(Object obj, Properties properties, String str) {
        new PropertySetter(obj).setProperties(properties, str);
    }

    protected Object convertArg(String str, Class cls) throws Throwable {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        Class clsClass$ = class$java$lang$String;
        if (clsClass$ == null) {
            clsClass$ = class$("java.lang.String");
            class$java$lang$String = clsClass$;
        }
        if (clsClass$.isAssignableFrom(cls)) {
            return str;
        }
        if (Integer.TYPE.isAssignableFrom(cls)) {
            return new Integer(strTrim);
        }
        if (Long.TYPE.isAssignableFrom(cls)) {
            return new Long(strTrim);
        }
        if (!Boolean.TYPE.isAssignableFrom(cls)) {
            Class clsClass$2 = class$org$apache$log4j$Priority;
            if (clsClass$2 == null) {
                clsClass$2 = class$("org.apache.log4j.Priority");
                class$org$apache$log4j$Priority = clsClass$2;
            }
            if (clsClass$2.isAssignableFrom(cls)) {
                return OptionConverter.toLevel(strTrim, Level.DEBUG);
            }
            Class clsClass$3 = class$org$apache$log4j$spi$ErrorHandler;
            if (clsClass$3 == null) {
                clsClass$3 = class$("org.apache.log4j.spi.ErrorHandler");
                class$org$apache$log4j$spi$ErrorHandler = clsClass$3;
            }
            if (clsClass$3.isAssignableFrom(cls)) {
                Class clsClass$4 = class$org$apache$log4j$spi$ErrorHandler;
                if (clsClass$4 == null) {
                    clsClass$4 = class$("org.apache.log4j.spi.ErrorHandler");
                    class$org$apache$log4j$spi$ErrorHandler = clsClass$4;
                }
                return OptionConverter.instantiateByClassName(strTrim, clsClass$4, null);
            }
        } else {
            if ("true".equalsIgnoreCase(strTrim)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(strTrim)) {
                return Boolean.FALSE;
            }
        }
        return null;
    }

    public void setProperty(String str, String str2) {
        if (str2 == null) {
            return;
        }
        String strDecapitalize = Introspector.decapitalize(str);
        PropertyDescriptor propertyDescriptor = getPropertyDescriptor(strDecapitalize);
        if (propertyDescriptor == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("No such property [");
            stringBuffer.append(strDecapitalize);
            stringBuffer.append("] in ");
            stringBuffer.append(this.obj.getClass().getName());
            stringBuffer.append(".");
            LogLog.warn(stringBuffer.toString());
            return;
        }
        try {
            setProperty(propertyDescriptor, strDecapitalize, str2);
        } catch (PropertySetterException e10) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Failed to set property [");
            stringBuffer2.append(strDecapitalize);
            stringBuffer2.append("] to value \"");
            stringBuffer2.append(str2);
            stringBuffer2.append("\". ");
            LogLog.warn(stringBuffer2.toString(), e10.rootCause);
        }
    }

    public void activate() {
        Object obj = this.obj;
        if (obj instanceof OptionHandler) {
            ((OptionHandler) obj).activateOptions();
        }
    }

    protected PropertyDescriptor getPropertyDescriptor(String str) {
        if (this.props == null) {
            introspect();
        }
        int i10 = 0;
        while (true) {
            PropertyDescriptor[] propertyDescriptorArr = this.props;
            if (i10 >= propertyDescriptorArr.length) {
                return null;
            }
            if (str.equals(propertyDescriptorArr[i10].getName())) {
                return this.props[i10];
            }
            i10++;
        }
    }

    protected void introspect() {
        try {
            this.props = Introspector.getBeanInfo(this.obj.getClass()).getPropertyDescriptors();
        } catch (IntrospectionException e10) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Failed to introspect ");
            stringBuffer.append(this.obj);
            stringBuffer.append(": ");
            stringBuffer.append(e10.getMessage());
            LogLog.error(stringBuffer.toString());
            this.props = new PropertyDescriptor[0];
        }
    }

    public void setProperties(Properties properties, String str) {
        int length = str.length();
        Enumeration<?> enumerationPropertyNames = properties.propertyNames();
        while (enumerationPropertyNames.hasMoreElements()) {
            String str2 = (String) enumerationPropertyNames.nextElement();
            if (str2.startsWith(str) && str2.indexOf(46, length + 1) <= 0) {
                String strFindAndSubst = OptionConverter.findAndSubst(str2, properties);
                String strSubstring = str2.substring(length);
                if ((!"layout".equals(strSubstring) && !"errorhandler".equals(strSubstring)) || !(this.obj instanceof Appender)) {
                    PropertyDescriptor propertyDescriptor = getPropertyDescriptor(Introspector.decapitalize(strSubstring));
                    if (propertyDescriptor != null) {
                        Class clsClass$ = class$org$apache$log4j$spi$OptionHandler;
                        if (clsClass$ == null) {
                            clsClass$ = class$("org.apache.log4j.spi.OptionHandler");
                            class$org$apache$log4j$spi$OptionHandler = clsClass$;
                        }
                        if (clsClass$.isAssignableFrom(propertyDescriptor.getPropertyType()) && propertyDescriptor.getWriteMethod() != null) {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append(str);
                            stringBuffer.append(strSubstring);
                            OptionHandler optionHandler = (OptionHandler) OptionConverter.instantiateByKey(properties, stringBuffer.toString(), propertyDescriptor.getPropertyType(), null);
                            PropertySetter propertySetter = new PropertySetter(optionHandler);
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append(str);
                            stringBuffer2.append(strSubstring);
                            stringBuffer2.append(".");
                            propertySetter.setProperties(properties, stringBuffer2.toString());
                            try {
                                propertyDescriptor.getWriteMethod().invoke(this.obj, optionHandler);
                            } catch (IllegalAccessException e10) {
                                StringBuffer stringBuffer3 = new StringBuffer();
                                stringBuffer3.append("Failed to set property [");
                                stringBuffer3.append(strSubstring);
                                stringBuffer3.append("] to value \"");
                                stringBuffer3.append(strFindAndSubst);
                                stringBuffer3.append("\". ");
                                LogLog.warn(stringBuffer3.toString(), e10);
                            } catch (RuntimeException e11) {
                                StringBuffer stringBuffer4 = new StringBuffer();
                                stringBuffer4.append("Failed to set property [");
                                stringBuffer4.append(strSubstring);
                                stringBuffer4.append("] to value \"");
                                stringBuffer4.append(strFindAndSubst);
                                stringBuffer4.append("\". ");
                                LogLog.warn(stringBuffer4.toString(), e11);
                            } catch (InvocationTargetException e12) {
                                if ((e12.getTargetException() instanceof InterruptedException) || (e12.getTargetException() instanceof InterruptedIOException)) {
                                    Thread.currentThread().interrupt();
                                }
                                StringBuffer stringBuffer5 = new StringBuffer();
                                stringBuffer5.append("Failed to set property [");
                                stringBuffer5.append(strSubstring);
                                stringBuffer5.append("] to value \"");
                                stringBuffer5.append(strFindAndSubst);
                                stringBuffer5.append("\". ");
                                LogLog.warn(stringBuffer5.toString(), e12);
                            }
                        }
                    }
                    setProperty(strSubstring, strFindAndSubst);
                }
            }
        }
        activate();
    }

    public PropertySetter(Object obj) {
        this.obj = obj;
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    public void setProperty(PropertyDescriptor propertyDescriptor, String str, String str2) throws PropertySetterException {
        Method writeMethod = propertyDescriptor.getWriteMethod();
        if (writeMethod == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("No setter for property [");
            stringBuffer.append(str);
            stringBuffer.append("].");
            throw new PropertySetterException(stringBuffer.toString());
        }
        Class<?>[] parameterTypes = writeMethod.getParameterTypes();
        if (parameterTypes.length == 1) {
            try {
                Object objConvertArg = convertArg(str2, parameterTypes[0]);
                if (objConvertArg == null) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Conversion to type [");
                    stringBuffer2.append(parameterTypes[0]);
                    stringBuffer2.append("] failed.");
                    throw new PropertySetterException(stringBuffer2.toString());
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Setting property [");
                stringBuffer3.append(str);
                stringBuffer3.append("] to [");
                stringBuffer3.append(objConvertArg);
                stringBuffer3.append("].");
                LogLog.debug(stringBuffer3.toString());
                try {
                    writeMethod.invoke(this.obj, objConvertArg);
                    return;
                } catch (IllegalAccessException e10) {
                    throw new PropertySetterException(e10);
                } catch (RuntimeException e11) {
                    throw new PropertySetterException(e11);
                } catch (InvocationTargetException e12) {
                    if ((e12.getTargetException() instanceof InterruptedException) || (e12.getTargetException() instanceof InterruptedIOException)) {
                        Thread.currentThread().interrupt();
                    }
                    throw new PropertySetterException(e12);
                }
            } catch (Throwable th) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("Conversion to type [");
                stringBuffer4.append(parameterTypes[0]);
                stringBuffer4.append("] failed. Reason: ");
                stringBuffer4.append(th);
                throw new PropertySetterException(stringBuffer4.toString());
            }
        }
        throw new PropertySetterException("#params for setter != 1");
    }
}
