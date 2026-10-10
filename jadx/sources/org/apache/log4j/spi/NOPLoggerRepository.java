package org.apache.log4j.spi;

import java.util.Enumeration;
import java.util.Vector;
import org.apache.log4j.Appender;
import org.apache.log4j.Category;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class NOPLoggerRepository implements LoggerRepository {
    @Override // org.apache.log4j.spi.LoggerRepository
    public Logger exists(String str) {
        return null;
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public Logger getLogger(String str) {
        return new NOPLogger(this, str);
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public boolean isDisabled(int i10) {
        return true;
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public void setThreshold(String str) {
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public Enumeration getCurrentLoggers() {
        return new Vector().elements();
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public Logger getLogger(String str, LoggerFactory loggerFactory) {
        return new NOPLogger(this, str);
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public Logger getRootLogger() {
        return new NOPLogger(this, "root");
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public Level getThreshold() {
        return Level.OFF;
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public void setThreshold(Level level) {
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public Enumeration getCurrentCategories() {
        return getCurrentLoggers();
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public void resetConfiguration() {
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public void shutdown() {
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public void addHierarchyEventListener(HierarchyEventListener hierarchyEventListener) {
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public void emitNoAppenderWarning(Category category) {
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    public void fireAddAppenderEvent(Category category, Appender appender) {
    }
}
