package org.apache.log4j.jmx;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.DynamicMBean;
import javax.management.InstanceNotFoundException;
import javax.management.JMException;
import javax.management.MBeanRegistration;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.RuntimeOperationsException;
import org.apache.log4j.Appender;
import org.apache.log4j.Logger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public abstract class AbstractDynamicMBean implements DynamicMBean, MBeanRegistration {
    String dClassName;
    private final Vector mbeanList = new Vector();
    MBeanServer server;

    protected abstract Logger getLogger();

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.management.RuntimeOperationsException */
    public AttributeList getAttributes(String[] strArr) throws RuntimeOperationsException {
        if (strArr == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("attributeNames[] cannot be null");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Cannot invoke a getter of ");
            stringBuffer.append(this.dClassName);
            throw new RuntimeOperationsException(illegalArgumentException, stringBuffer.toString());
        }
        AttributeList attributeList = new AttributeList();
        if (strArr.length != 0) {
            for (int i10 = 0; i10 < strArr.length; i10++) {
                try {
                    attributeList.add(new Attribute(strArr[i10], getAttribute(strArr[i10])));
                } catch (JMException e10) {
                    e10.printStackTrace();
                } catch (RuntimeException e11) {
                    e11.printStackTrace();
                }
            }
        }
        return attributeList;
    }

    protected void registerMBean(Object obj, ObjectName objectName) {
        this.server.registerMBean(obj, objectName);
        this.mbeanList.add(objectName);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.management.RuntimeOperationsException */
    public AttributeList setAttributes(AttributeList attributeList) throws RuntimeOperationsException {
        if (attributeList == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("AttributeList attributes cannot be null");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Cannot invoke a setter of ");
            stringBuffer.append(this.dClassName);
            throw new RuntimeOperationsException(illegalArgumentException, stringBuffer.toString());
        }
        AttributeList attributeList2 = new AttributeList();
        if (!attributeList.isEmpty()) {
            Iterator it = attributeList.iterator();
            while (it.hasNext()) {
                Attribute attribute = (Attribute) it.next();
                try {
                    setAttribute(attribute);
                    String name = attribute.getName();
                    attributeList2.add(new Attribute(name, getAttribute(name)));
                } catch (JMException e10) {
                    e10.printStackTrace();
                } catch (RuntimeException e11) {
                    e11.printStackTrace();
                }
            }
        }
        return attributeList2;
    }

    protected static String getAppenderName(Appender appender) {
        String name = appender.getName();
        if (name != null && name.trim().length() != 0) {
            return name;
        }
        return appender.toString();
    }

    public void postDeregister() {
        getLogger().debug("postDeregister is called.");
    }

    public void preDeregister() {
        getLogger().debug("preDeregister called.");
        Enumeration enumerationElements = this.mbeanList.elements();
        while (enumerationElements.hasMoreElements()) {
            ObjectName objectName = (ObjectName) enumerationElements.nextElement();
            try {
                this.server.unregisterMBean(objectName);
            } catch (InstanceNotFoundException unused) {
                Logger logger = getLogger();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Missing MBean ");
                stringBuffer.append(objectName.getCanonicalName());
                logger.warn(stringBuffer.toString());
            } catch (MBeanRegistrationException unused2) {
                Logger logger2 = getLogger();
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Failed unregistering ");
                stringBuffer2.append(objectName.getCanonicalName());
                logger2.warn(stringBuffer2.toString());
            }
        }
    }

    public ObjectName preRegister(MBeanServer mBeanServer, ObjectName objectName) {
        Logger logger = getLogger();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("preRegister called. Server=");
        stringBuffer.append(mBeanServer);
        stringBuffer.append(", name=");
        stringBuffer.append(objectName);
        logger.debug(stringBuffer.toString());
        this.server = mBeanServer;
        return objectName;
    }

    public void postRegister(Boolean bool) {
    }
}
