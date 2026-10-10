package io.netty.util.internal.logging;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class JdkLogger extends AbstractInternalLogger {
    static final String SELF = "io.netty.util.internal.logging.JdkLogger";
    static final String SUPER = AbstractInternalLogger.class.getName();
    private static final long serialVersionUID = -1767272577989225979L;
    final transient Logger logger;

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str) {
        Logger logger = this.logger;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            log(SELF, level, str, null);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str) {
        Logger logger = this.logger;
        Level level = Level.SEVERE;
        if (logger.isLoggable(level)) {
            log(SELF, level, str, null);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(String str, Object obj) {
        Logger logger = this.logger;
        Level level = Level.FINEST;
        if (logger.isLoggable(level)) {
            FormattingTuple formattingTuple = MessageFormatter.format(str, obj);
            log(SELF, level, formattingTuple.getMessage(), formattingTuple.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str) {
        Logger logger = this.logger;
        Level level = Level.WARNING;
        if (logger.isLoggable(level)) {
            log(SELF, level, str, null);
        }
    }

    private static void fillCallerData(String str, LogRecord logRecord) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int i10 = 0;
        while (true) {
            if (i10 >= stackTrace.length) {
                i10 = -1;
                break;
            }
            String className = stackTrace[i10].getClassName();
            if (className.equals(str) || className.equals(SUPER)) {
                break;
            } else {
                i10++;
            }
        }
        while (true) {
            i10++;
            if (i10 >= stackTrace.length) {
                i10 = -1;
                break;
            }
            String className2 = stackTrace[i10].getClassName();
            if (!className2.equals(str) && !className2.equals(SUPER)) {
                break;
            }
        }
        if (i10 != -1) {
            StackTraceElement stackTraceElement = stackTrace[i10];
            logRecord.setSourceClassName(stackTraceElement.getClassName());
            logRecord.setSourceMethodName(stackTraceElement.getMethodName());
        }
    }

    private void log(String str, Level level, String str2, Throwable th) {
        LogRecord logRecord = new LogRecord(level, str2);
        logRecord.setLoggerName(name());
        logRecord.setThrown(th);
        fillCallerData(str, logRecord);
        this.logger.log(logRecord);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void info(String str) {
        Logger logger = this.logger;
        Level level = Level.INFO;
        if (logger.isLoggable(level)) {
            log(SELF, level, str, null);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isDebugEnabled() {
        return this.logger.isLoggable(Level.FINE);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isErrorEnabled() {
        return this.logger.isLoggable(Level.SEVERE);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isInfoEnabled() {
        return this.logger.isLoggable(Level.INFO);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isTraceEnabled() {
        return this.logger.isLoggable(Level.FINEST);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isWarnEnabled() {
        return this.logger.isLoggable(Level.WARNING);
    }

    JdkLogger(Logger logger) {
        super(logger.getName());
        this.logger = logger;
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str, Object obj) {
        Logger logger = this.logger;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            FormattingTuple formattingTuple = MessageFormatter.format(str, obj);
            log(SELF, level, formattingTuple.getMessage(), formattingTuple.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str, Object obj) {
        Logger logger = this.logger;
        Level level = Level.SEVERE;
        if (logger.isLoggable(level)) {
            FormattingTuple formattingTuple = MessageFormatter.format(str, obj);
            log(SELF, level, formattingTuple.getMessage(), formattingTuple.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str, Object obj) {
        Logger logger = this.logger;
        Level level = Level.WARNING;
        if (logger.isLoggable(level)) {
            FormattingTuple formattingTuple = MessageFormatter.format(str, obj);
            log(SELF, level, formattingTuple.getMessage(), formattingTuple.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(String str, Object obj, Object obj2) {
        Logger logger = this.logger;
        Level level = Level.FINEST;
        if (logger.isLoggable(level)) {
            FormattingTuple formattingTuple = MessageFormatter.format(str, obj, obj2);
            log(SELF, level, formattingTuple.getMessage(), formattingTuple.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str, Object obj, Object obj2) {
        Logger logger = this.logger;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            FormattingTuple formattingTuple = MessageFormatter.format(str, obj, obj2);
            log(SELF, level, formattingTuple.getMessage(), formattingTuple.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str, Object obj, Object obj2) {
        Logger logger = this.logger;
        Level level = Level.SEVERE;
        if (logger.isLoggable(level)) {
            FormattingTuple formattingTuple = MessageFormatter.format(str, obj, obj2);
            log(SELF, level, formattingTuple.getMessage(), formattingTuple.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str, Object obj, Object obj2) {
        Logger logger = this.logger;
        Level level = Level.WARNING;
        if (logger.isLoggable(level)) {
            FormattingTuple formattingTuple = MessageFormatter.format(str, obj, obj2);
            log(SELF, level, formattingTuple.getMessage(), formattingTuple.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(String str, Throwable th) {
        Logger logger = this.logger;
        Level level = Level.FINEST;
        if (logger.isLoggable(level)) {
            log(SELF, level, str, th);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str, Object... objArr) {
        Logger logger = this.logger;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            FormattingTuple formattingTupleArrayFormat = MessageFormatter.arrayFormat(str, objArr);
            log(SELF, level, formattingTupleArrayFormat.getMessage(), formattingTupleArrayFormat.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str, Object... objArr) {
        Logger logger = this.logger;
        Level level = Level.SEVERE;
        if (logger.isLoggable(level)) {
            FormattingTuple formattingTupleArrayFormat = MessageFormatter.arrayFormat(str, objArr);
            log(SELF, level, formattingTupleArrayFormat.getMessage(), formattingTupleArrayFormat.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str, Object... objArr) {
        Logger logger = this.logger;
        Level level = Level.WARNING;
        if (logger.isLoggable(level)) {
            FormattingTuple formattingTupleArrayFormat = MessageFormatter.arrayFormat(str, objArr);
            log(SELF, level, formattingTupleArrayFormat.getMessage(), formattingTupleArrayFormat.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str, Throwable th) {
        Logger logger = this.logger;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            log(SELF, level, str, th);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str, Throwable th) {
        Logger logger = this.logger;
        Level level = Level.SEVERE;
        if (logger.isLoggable(level)) {
            log(SELF, level, str, th);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str, Throwable th) {
        Logger logger = this.logger;
        Level level = Level.WARNING;
        if (logger.isLoggable(level)) {
            log(SELF, level, str, th);
        }
    }
}
