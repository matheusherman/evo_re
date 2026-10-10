package org.apache.log4j;

import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Vector;
import org.apache.log4j.helpers.AppenderAttachableImpl;
import org.apache.log4j.helpers.NullEnumeration;
import org.apache.log4j.spi.AppenderAttachable;
import org.apache.log4j.spi.HierarchyEventListener;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class Category implements AppenderAttachable {
    private static final String FQCN;
    static /* synthetic */ Class class$org$apache$log4j$Category;
    AppenderAttachableImpl aai;
    protected boolean additive = true;
    protected volatile Level level;
    protected String name;
    protected volatile Category parent;
    protected LoggerRepository repository;
    protected ResourceBundle resourceBundle;

    public static Category getInstance(String str) {
        return LogManager.getLogger(str);
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public synchronized void addAppender(Appender appender) {
        try {
            if (this.aai == null) {
                this.aai = new AppenderAttachableImpl();
            }
            this.aai.addAppender(appender);
            this.repository.fireAddAppenderEvent(this, appender);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0018, code lost:
    
        r1 = r1.parent;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void callAppenders(LoggingEvent loggingEvent) {
        int iAppendLoopOnAppenders = 0;
        Category category = this;
        while (category != null) {
            synchronized (category) {
                try {
                    AppenderAttachableImpl appenderAttachableImpl = category.aai;
                    if (appenderAttachableImpl != null) {
                        iAppendLoopOnAppenders += appenderAttachableImpl.appendLoopOnAppenders(loggingEvent);
                    }
                    if (!category.additive) {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            break;
        }
        if (iAppendLoopOnAppenders == 0) {
            this.repository.emitNoAppenderWarning(this);
        }
    }

    synchronized void closeNestedAppenders() {
        Enumeration allAppenders = getAllAppenders();
        if (allAppenders != null) {
            while (allAppenders.hasMoreElements()) {
                Appender appender = (Appender) allAppenders.nextElement();
                if (appender instanceof AppenderAttachable) {
                    appender.close();
                }
            }
        }
    }

    public void debug(Object obj) {
        if (this.repository.isDisabled(10000)) {
            return;
        }
        Level level = Level.DEBUG;
        if (level.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, level, obj, null);
        }
    }

    public void error(Object obj) {
        if (this.repository.isDisabled(Priority.ERROR_INT)) {
            return;
        }
        Level level = Level.ERROR;
        if (level.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, level, obj, null);
        }
    }

    public void fatal(Object obj) {
        if (this.repository.isDisabled(Priority.FATAL_INT)) {
            return;
        }
        Level level = Level.FATAL;
        if (level.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, level, obj, null);
        }
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public synchronized Enumeration getAllAppenders() {
        AppenderAttachableImpl appenderAttachableImpl = this.aai;
        if (appenderAttachableImpl == null) {
            return NullEnumeration.getInstance();
        }
        return appenderAttachableImpl.getAllAppenders();
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public synchronized Appender getAppender(String str) {
        AppenderAttachableImpl appenderAttachableImpl = this.aai;
        if (appenderAttachableImpl != null && str != null) {
            return appenderAttachableImpl.getAppender(str);
        }
        return null;
    }

    public Priority getChainedPriority() {
        for (Category category = this; category != null; category = category.parent) {
            if (category.level != null) {
                return category.level;
            }
        }
        return null;
    }

    public Level getEffectiveLevel() {
        for (Category category = this; category != null; category = category.parent) {
            if (category.level != null) {
                return category.level;
            }
        }
        return null;
    }

    public ResourceBundle getResourceBundle() {
        for (Category category = this; category != null; category = category.parent) {
            ResourceBundle resourceBundle = category.resourceBundle;
            if (resourceBundle != null) {
                return resourceBundle;
            }
        }
        return null;
    }

    public void info(Object obj) {
        if (this.repository.isDisabled(20000)) {
            return;
        }
        Level level = Level.INFO;
        if (level.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, level, obj, null);
        }
    }

    public void l7dlog(Priority priority, String str, Throwable th) {
        if (!this.repository.isDisabled(priority.level) && priority.isGreaterOrEqual(getEffectiveLevel())) {
            String resourceBundleString = getResourceBundleString(str);
            if (resourceBundleString != null) {
                str = resourceBundleString;
            }
            forcedLog(FQCN, priority, str, th);
        }
    }

    public void log(Priority priority, Object obj, Throwable th) {
        if (!this.repository.isDisabled(priority.level) && priority.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, priority, obj, th);
        }
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public synchronized void removeAllAppenders() {
        try {
            if (this.aai != null) {
                Vector vector = new Vector();
                Enumeration allAppenders = this.aai.getAllAppenders();
                while (allAppenders != null && allAppenders.hasMoreElements()) {
                    vector.add(allAppenders.nextElement());
                }
                this.aai.removeAllAppenders();
                Enumeration enumerationElements = vector.elements();
                while (enumerationElements.hasMoreElements()) {
                    fireRemoveAppenderEvent((Appender) enumerationElements.nextElement());
                }
                this.aai = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public synchronized void removeAppender(Appender appender) {
        if (appender != null) {
            AppenderAttachableImpl appenderAttachableImpl = this.aai;
            if (appenderAttachableImpl != null) {
                boolean zIsAttached = appenderAttachableImpl.isAttached(appender);
                this.aai.removeAppender(appender);
                if (zIsAttached) {
                    fireRemoveAppenderEvent(appender);
                }
            }
        }
    }

    public void warn(Object obj) {
        if (this.repository.isDisabled(Priority.WARN_INT)) {
            return;
        }
        Level level = Level.WARN;
        if (level.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, level, obj, null);
        }
    }

    static {
        Class clsClass$ = class$org$apache$log4j$Category;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.Category");
            class$org$apache$log4j$Category = clsClass$;
        }
        FQCN = clsClass$.getName();
    }

    private void fireRemoveAppenderEvent(Appender appender) {
        if (appender != null) {
            LoggerRepository loggerRepository = this.repository;
            if (loggerRepository instanceof Hierarchy) {
                ((Hierarchy) loggerRepository).fireRemoveAppenderEvent(this, appender);
            } else if (loggerRepository instanceof HierarchyEventListener) {
                ((HierarchyEventListener) loggerRepository).removeAppenderEvent(this, appender);
            }
        }
    }

    public static Category getInstance(Class cls) {
        return LogManager.getLogger(cls);
    }

    public void assertLog(boolean z10, String str) {
        if (z10) {
            return;
        }
        error(str);
    }

    protected void forcedLog(String str, Priority priority, Object obj, Throwable th) {
        callAppenders(new LoggingEvent(str, this, priority, obj, th));
    }

    public boolean getAdditivity() {
        return this.additive;
    }

    public LoggerRepository getHierarchy() {
        return this.repository;
    }

    public final Level getLevel() {
        return this.level;
    }

    public LoggerRepository getLoggerRepository() {
        return this.repository;
    }

    public final String getName() {
        return this.name;
    }

    public final Category getParent() {
        return this.parent;
    }

    public final Level getPriority() {
        return this.level;
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public boolean isAttached(Appender appender) {
        AppenderAttachableImpl appenderAttachableImpl;
        if (appender == null || (appenderAttachableImpl = this.aai) == null) {
            return false;
        }
        return appenderAttachableImpl.isAttached(appender);
    }

    public boolean isDebugEnabled() {
        if (this.repository.isDisabled(10000)) {
            return false;
        }
        return Level.DEBUG.isGreaterOrEqual(getEffectiveLevel());
    }

    public boolean isEnabledFor(Priority priority) {
        if (this.repository.isDisabled(priority.level)) {
            return false;
        }
        return priority.isGreaterOrEqual(getEffectiveLevel());
    }

    public boolean isInfoEnabled() {
        if (this.repository.isDisabled(20000)) {
            return false;
        }
        return Level.INFO.isGreaterOrEqual(getEffectiveLevel());
    }

    public void setAdditivity(boolean z10) {
        this.additive = z10;
    }

    final void setHierarchy(LoggerRepository loggerRepository) {
        this.repository = loggerRepository;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setPriority(Priority priority) {
        this.level = (Level) priority;
    }

    public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    protected Category(String str) {
        this.name = str;
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    public static Logger exists(String str) {
        return LogManager.exists(str);
    }

    public static Enumeration getCurrentCategories() {
        return LogManager.getCurrentLoggers();
    }

    public static LoggerRepository getDefaultHierarchy() {
        return LogManager.getLoggerRepository();
    }

    public static final Category getRoot() {
        return LogManager.getRootLogger();
    }

    public static void shutdown() {
        LogManager.shutdown();
    }

    protected String getResourceBundleString(String str) {
        ResourceBundle resourceBundle = getResourceBundle();
        if (resourceBundle == null) {
            return null;
        }
        try {
            return resourceBundle.getString(str);
        } catch (MissingResourceException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("No resource is associated with key \"");
            stringBuffer.append(str);
            stringBuffer.append("\".");
            error(stringBuffer.toString());
            return null;
        }
    }

    public void debug(Object obj, Throwable th) {
        if (this.repository.isDisabled(10000)) {
            return;
        }
        Level level = Level.DEBUG;
        if (level.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, level, obj, th);
        }
    }

    public void error(Object obj, Throwable th) {
        if (this.repository.isDisabled(Priority.ERROR_INT)) {
            return;
        }
        Level level = Level.ERROR;
        if (level.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, level, obj, th);
        }
    }

    public void fatal(Object obj, Throwable th) {
        if (this.repository.isDisabled(Priority.FATAL_INT)) {
            return;
        }
        Level level = Level.FATAL;
        if (level.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, level, obj, th);
        }
    }

    public void info(Object obj, Throwable th) {
        if (this.repository.isDisabled(20000)) {
            return;
        }
        Level level = Level.INFO;
        if (level.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, level, obj, th);
        }
    }

    public void log(Priority priority, Object obj) {
        if (!this.repository.isDisabled(priority.level) && priority.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, priority, obj, null);
        }
    }

    public void warn(Object obj, Throwable th) {
        if (this.repository.isDisabled(Priority.WARN_INT)) {
            return;
        }
        Level level = Level.WARN;
        if (level.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, level, obj, th);
        }
    }

    public void l7dlog(Priority priority, String str, Object[] objArr, Throwable th) {
        if (!this.repository.isDisabled(priority.level) && priority.isGreaterOrEqual(getEffectiveLevel())) {
            String resourceBundleString = getResourceBundleString(str);
            if (resourceBundleString != null) {
                str = MessageFormat.format(resourceBundleString, objArr);
            }
            forcedLog(FQCN, priority, str, th);
        }
    }

    public void log(String str, Priority priority, Object obj, Throwable th) {
        if (!this.repository.isDisabled(priority.level) && priority.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(str, priority, obj, th);
        }
    }

    @Override // org.apache.log4j.spi.AppenderAttachable
    public synchronized void removeAppender(String str) {
        if (str != null) {
            AppenderAttachableImpl appenderAttachableImpl = this.aai;
            if (appenderAttachableImpl != null) {
                Appender appender = appenderAttachableImpl.getAppender(str);
                this.aai.removeAppender(str);
                if (appender != null) {
                    fireRemoveAppenderEvent(appender);
                }
            }
        }
    }
}
