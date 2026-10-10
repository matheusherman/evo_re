package org.apache.log4j.spi;

import java.util.Enumeration;
import org.apache.log4j.Appender;
import org.apache.log4j.Category;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public interface LoggerRepository {
    void addHierarchyEventListener(HierarchyEventListener hierarchyEventListener);

    void emitNoAppenderWarning(Category category);

    Logger exists(String str);

    void fireAddAppenderEvent(Category category, Appender appender);

    Enumeration getCurrentCategories();

    Enumeration getCurrentLoggers();

    Logger getLogger(String str);

    Logger getLogger(String str, LoggerFactory loggerFactory);

    Logger getRootLogger();

    Level getThreshold();

    boolean isDisabled(int i10);

    void resetConfiguration();

    void setThreshold(String str);

    void setThreshold(Level level);

    void shutdown();
}
