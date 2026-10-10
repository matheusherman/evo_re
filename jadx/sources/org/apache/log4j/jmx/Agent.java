package org.apache.log4j.jmx;

import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import javax.management.JMException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import org.apache.log4j.Logger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class Agent {
    static /* synthetic */ Class class$org$apache$log4j$jmx$Agent;
    static Logger log;

    static {
        Class clsClass$ = class$org$apache$log4j$jmx$Agent;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.jmx.Agent");
            class$org$apache$log4j$jmx$Agent = clsClass$;
        }
        log = Logger.getLogger(clsClass$);
    }

    private static Object createServer() {
        try {
            return Class.forName("com.sun.jdmk.comm.HtmlAdapterServer").newInstance();
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException(e10.toString());
        } catch (IllegalAccessException e11) {
            throw new RuntimeException(e11.toString());
        } catch (InstantiationException e12) {
            throw new RuntimeException(e12.toString());
        }
    }

    public void start() {
        MBeanServer mBeanServerCreateMBeanServer = MBeanServerFactory.createMBeanServer();
        Object objCreateServer = createServer();
        try {
            log.info("Registering HtmlAdaptorServer instance.");
            mBeanServerCreateMBeanServer.registerMBean(objCreateServer, new ObjectName("Adaptor:name=html,port=8082"));
            log.info("Registering HierarchyDynamicMBean instance.");
            mBeanServerCreateMBeanServer.registerMBean(new HierarchyDynamicMBean(), new ObjectName("log4j:hiearchy=default"));
            startServer(objCreateServer);
        } catch (RuntimeException e10) {
            log.error("Problem while registering MBeans instances.", e10);
        } catch (JMException e11) {
            log.error("Problem while registering MBeans instances.", e11);
        }
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    private static void startServer(Object obj) {
        try {
            obj.getClass().getMethod("start", null).invoke(obj, null);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10.toString());
        } catch (NoSuchMethodException e11) {
            throw new RuntimeException(e11.toString());
        } catch (InvocationTargetException e12) {
            Throwable targetException = e12.getTargetException();
            if (!(targetException instanceof RuntimeException)) {
                if (targetException != null) {
                    if ((targetException instanceof InterruptedException) || (targetException instanceof InterruptedIOException)) {
                        Thread.currentThread().interrupt();
                    }
                    throw new RuntimeException(targetException.toString());
                }
                throw new RuntimeException();
            }
            throw ((RuntimeException) targetException);
        }
    }
}
