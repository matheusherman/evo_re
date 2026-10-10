package org.apache.log4j.rewrite;

import java.util.Enumeration;
import java.util.Properties;
import org.apache.log4j.Appender;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.helpers.AppenderAttachableImpl;
import org.apache.log4j.spi.AppenderAttachable;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.OptionHandler;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.xml.UnrecognizedElementHandler;
import org.w3c.dom.Element;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class RewriteAppender extends AppenderSkeleton implements AppenderAttachable, UnrecognizedElementHandler {
    static /* synthetic */ Class class$org$apache$log4j$rewrite$RewritePolicy;
    private final AppenderAttachableImpl appenders = new AppenderAttachableImpl();
    private RewritePolicy policy;

    @Override // org.apache.log4j.Appender
    public void close() {
        this.closed = true;
        synchronized (this.appenders) {
            try {
                Enumeration allAppenders = this.appenders.getAllAppenders();
                if (allAppenders != null) {
                    while (allAppenders.hasMoreElements()) {
                        Object objNextElement = allAppenders.nextElement();
                        if (objNextElement instanceof Appender) {
                            ((Appender) objNextElement).close();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public void removeAppender(Appender appender) {
        synchronized (this.appenders) {
            this.appenders.removeAppender(appender);
        }
    }

    @Override // org.apache.log4j.Appender
    public boolean requiresLayout() {
        return false;
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public void addAppender(Appender appender) {
        synchronized (this.appenders) {
            this.appenders.addAppender(appender);
        }
    }

    @Override // org.apache.log4j.AppenderSkeleton
    protected void append(LoggingEvent loggingEvent) {
        RewritePolicy rewritePolicy = this.policy;
        if (rewritePolicy != null) {
            loggingEvent = rewritePolicy.rewrite(loggingEvent);
        }
        if (loggingEvent != null) {
            synchronized (this.appenders) {
                this.appenders.appendLoopOnAppenders(loggingEvent);
            }
        }
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public Enumeration getAllAppenders() {
        Enumeration allAppenders;
        synchronized (this.appenders) {
            allAppenders = this.appenders.getAllAppenders();
        }
        return allAppenders;
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public Appender getAppender(String str) {
        Appender appender;
        synchronized (this.appenders) {
            appender = this.appenders.getAppender(str);
        }
        return appender;
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public boolean isAttached(Appender appender) {
        boolean zIsAttached;
        synchronized (this.appenders) {
            zIsAttached = this.appenders.isAttached(appender);
        }
        return zIsAttached;
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public void removeAllAppenders() {
        synchronized (this.appenders) {
            this.appenders.removeAllAppenders();
        }
    }

    public void setRewritePolicy(RewritePolicy rewritePolicy) {
        this.policy = rewritePolicy;
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    @Override // org.apache.log4j.xml.UnrecognizedElementHandler
    public boolean parseUnrecognizedElement(Element element, Properties properties) throws Throwable {
        if ("rewritePolicy".equals(element.getNodeName())) {
            Class clsClass$ = class$org$apache$log4j$rewrite$RewritePolicy;
            if (clsClass$ == null) {
                clsClass$ = class$("org.apache.log4j.rewrite.RewritePolicy");
                class$org$apache$log4j$rewrite$RewritePolicy = clsClass$;
            }
            Object element2 = DOMConfigurator.parseElement(element, properties, clsClass$);
            if (element2 != null) {
                if (element2 instanceof OptionHandler) {
                    ((OptionHandler) element2).activateOptions();
                }
                setRewritePolicy((RewritePolicy) element2);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public void removeAppender(String str) {
        synchronized (this.appenders) {
            this.appenders.removeAppender(str);
        }
    }
}
