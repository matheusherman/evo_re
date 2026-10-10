package org.apache.log4j;

import org.apache.log4j.spi.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class Logger extends Category {
    private static final String FQCN;
    static /* synthetic */ Class class$org$apache$log4j$Logger;

    public static Logger getLogger(String str) {
        return LogManager.getLogger(str);
    }

    public void trace(Object obj) {
        if (this.repository.isDisabled(5000)) {
            return;
        }
        Level level = Level.TRACE;
        if (level.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, level, obj, null);
        }
    }

    static {
        Class clsClass$ = class$org$apache$log4j$Logger;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.Logger");
            class$org$apache$log4j$Logger = clsClass$;
        }
        FQCN = clsClass$.getName();
    }

    public static Logger getLogger(Class cls) {
        return LogManager.getLogger(cls.getName());
    }

    public boolean isTraceEnabled() {
        if (this.repository.isDisabled(5000)) {
            return false;
        }
        return Level.TRACE.isGreaterOrEqual(getEffectiveLevel());
    }

    protected Logger(String str) {
        super(str);
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    public static Logger getLogger(String str, LoggerFactory loggerFactory) {
        return LogManager.getLogger(str, loggerFactory);
    }

    public static Logger getRootLogger() {
        return LogManager.getRootLogger();
    }

    public void trace(Object obj, Throwable th) {
        if (this.repository.isDisabled(5000)) {
            return;
        }
        Level level = Level.TRACE;
        if (level.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, level, obj, th);
        }
    }
}
