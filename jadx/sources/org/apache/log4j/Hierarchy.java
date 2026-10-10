package org.apache.log4j;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.or.ObjectRenderer;
import org.apache.log4j.or.RendererMap;
import org.apache.log4j.spi.HierarchyEventListener;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.RendererSupport;
import org.apache.log4j.spi.ThrowableRenderer;
import org.apache.log4j.spi.ThrowableRendererSupport;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class Hierarchy implements LoggerRepository, RendererSupport, ThrowableRendererSupport {
    private LoggerFactory defaultFactory;
    RendererMap rendererMap;
    Logger root;
    Level threshold;
    int thresholdInt;
    boolean emittedNoAppenderWarning = false;
    boolean emittedNoResourceBundleWarning = false;
    private ThrowableRenderer throwableRenderer = null;
    Hashtable ht = new Hashtable();
    private Vector listeners = new Vector(1);

    @Override // org.apache.log4j.spi.LoggerRepository
    public Logger getLogger(String str) {
        return getLogger(str, this.defaultFactory);
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public void setThreshold(String str) {
        Level level = Level.toLevel(str, (Level) null);
        if (level != null) {
            setThreshold(level);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Could not convert [");
        stringBuffer.append(str);
        stringBuffer.append("] to Level.");
        LogLog.warn(stringBuffer.toString());
    }

    private final void updateParents(Logger logger) {
        String str = logger.name;
        for (int iLastIndexOf = str.lastIndexOf(46, str.length() - 1); iLastIndexOf >= 0; iLastIndexOf = str.lastIndexOf(46, iLastIndexOf - 1)) {
            CategoryKey categoryKey = new CategoryKey(str.substring(0, iLastIndexOf));
            Object obj = this.ht.get(categoryKey);
            if (obj == null) {
                this.ht.put(categoryKey, new ProvisionNode(logger));
            } else if (obj instanceof Category) {
                logger.parent = (Category) obj;
                return;
            } else if (obj instanceof ProvisionNode) {
                ((ProvisionNode) obj).addElement(logger);
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("unexpected object type ");
                stringBuffer.append(obj.getClass());
                stringBuffer.append(" in ht.");
                new IllegalStateException(stringBuffer.toString()).printStackTrace();
            }
        }
        logger.parent = this.root;
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public void addHierarchyEventListener(HierarchyEventListener hierarchyEventListener) {
        if (this.listeners.contains(hierarchyEventListener)) {
            LogLog.warn("Ignoring attempt to add an existent listener.");
        } else {
            this.listeners.addElement(hierarchyEventListener);
        }
    }

    public void addRenderer(Class cls, ObjectRenderer objectRenderer) {
        this.rendererMap.put(cls, objectRenderer);
    }

    public void clear() {
        this.ht.clear();
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public void emitNoAppenderWarning(Category category) {
        if (this.emittedNoAppenderWarning) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("No appenders could be found for logger (");
        stringBuffer.append(category.getName());
        stringBuffer.append(").");
        LogLog.warn(stringBuffer.toString());
        LogLog.warn("Please initialize the log4j system properly.");
        LogLog.warn("See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.");
        this.emittedNoAppenderWarning = true;
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public Logger exists(String str) {
        Object obj = this.ht.get(new CategoryKey(str));
        if (obj instanceof Logger) {
            return (Logger) obj;
        }
        return null;
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public void fireAddAppenderEvent(Category category, Appender appender) {
        Vector vector = this.listeners;
        if (vector != null) {
            int size = vector.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((HierarchyEventListener) this.listeners.elementAt(i10)).addAppenderEvent(category, appender);
            }
        }
    }

    void fireRemoveAppenderEvent(Category category, Appender appender) {
        Vector vector = this.listeners;
        if (vector != null) {
            int size = vector.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((HierarchyEventListener) this.listeners.elementAt(i10)).removeAppenderEvent(category, appender);
            }
        }
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public Enumeration getCurrentLoggers() {
        Vector vector = new Vector(this.ht.size());
        Enumeration enumerationElements = this.ht.elements();
        while (enumerationElements.hasMoreElements()) {
            Object objNextElement = enumerationElements.nextElement();
            if (objNextElement instanceof Logger) {
                vector.addElement(objNextElement);
            }
        }
        return vector.elements();
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public Logger getLogger(String str, LoggerFactory loggerFactory) {
        CategoryKey categoryKey = new CategoryKey(str);
        synchronized (this.ht) {
            try {
                Object obj = this.ht.get(categoryKey);
                if (obj == null) {
                    Logger loggerMakeNewLoggerInstance = loggerFactory.makeNewLoggerInstance(str);
                    loggerMakeNewLoggerInstance.setHierarchy(this);
                    this.ht.put(categoryKey, loggerMakeNewLoggerInstance);
                    updateParents(loggerMakeNewLoggerInstance);
                    return loggerMakeNewLoggerInstance;
                }
                if (obj instanceof Logger) {
                    return (Logger) obj;
                }
                if (!(obj instanceof ProvisionNode)) {
                    return null;
                }
                Logger loggerMakeNewLoggerInstance2 = loggerFactory.makeNewLoggerInstance(str);
                loggerMakeNewLoggerInstance2.setHierarchy(this);
                this.ht.put(categoryKey, loggerMakeNewLoggerInstance2);
                updateChildren((ProvisionNode) obj, loggerMakeNewLoggerInstance2);
                updateParents(loggerMakeNewLoggerInstance2);
                return loggerMakeNewLoggerInstance2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.log4j.spi.RendererSupport
    public RendererMap getRendererMap() {
        return this.rendererMap;
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public Logger getRootLogger() {
        return this.root;
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public Level getThreshold() {
        return this.threshold;
    }

    @Override // org.apache.log4j.spi.ThrowableRendererSupport
    public ThrowableRenderer getThrowableRenderer() {
        return this.throwableRenderer;
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public boolean isDisabled(int i10) {
        return this.thresholdInt > i10;
    }

    public void overrideAsNeeded(String str) {
        LogLog.warn("The Hiearchy.overrideAsNeeded method has been deprecated.");
    }

    public void setDisableOverride(String str) {
        LogLog.warn("The Hiearchy.setDisableOverride method has been deprecated.");
    }

    @Override // org.apache.log4j.spi.RendererSupport
    public void setRenderer(Class cls, ObjectRenderer objectRenderer) {
        this.rendererMap.put(cls, objectRenderer);
    }

    @Override // org.apache.log4j.spi.ThrowableRendererSupport
    public void setThrowableRenderer(ThrowableRenderer throwableRenderer) {
        this.throwableRenderer = throwableRenderer;
    }

    public Hierarchy(Logger logger) {
        this.root = logger;
        setThreshold(Level.ALL);
        this.root.setHierarchy(this);
        this.rendererMap = new RendererMap();
        this.defaultFactory = new DefaultCategoryFactory();
    }

    private final void updateChildren(ProvisionNode provisionNode, Logger logger) {
        int size = provisionNode.size();
        for (int i10 = 0; i10 < size; i10++) {
            Logger logger2 = (Logger) provisionNode.elementAt(i10);
            if (!logger2.parent.name.startsWith(logger.name)) {
                logger.parent = logger2.parent;
                logger2.parent = logger;
            }
        }
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public Enumeration getCurrentCategories() {
        return getCurrentLoggers();
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public void resetConfiguration() {
        getRootLogger().setLevel(Level.DEBUG);
        this.root.setResourceBundle(null);
        setThreshold(Level.ALL);
        synchronized (this.ht) {
            try {
                shutdown();
                Enumeration currentLoggers = getCurrentLoggers();
                while (currentLoggers.hasMoreElements()) {
                    Logger logger = (Logger) currentLoggers.nextElement();
                    logger.setLevel(null);
                    logger.setAdditivity(true);
                    logger.setResourceBundle(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.rendererMap.clear();
        this.throwableRenderer = null;
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public void shutdown() {
        Logger rootLogger = getRootLogger();
        rootLogger.closeNestedAppenders();
        synchronized (this.ht) {
            try {
                Enumeration currentLoggers = getCurrentLoggers();
                while (currentLoggers.hasMoreElements()) {
                    ((Logger) currentLoggers.nextElement()).closeNestedAppenders();
                }
                rootLogger.removeAllAppenders();
                Enumeration currentLoggers2 = getCurrentLoggers();
                while (currentLoggers2.hasMoreElements()) {
                    ((Logger) currentLoggers2.nextElement()).removeAllAppenders();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public void setThreshold(Level level) {
        if (level != null) {
            this.thresholdInt = level.level;
            this.threshold = level;
        }
    }
}
