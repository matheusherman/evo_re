package org.slf4j.impl;

import bf.d;
import java.io.Serializable;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class a extends org.slf4j.helpers.b implements df.a, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String f17134b = "org.slf4j.impl.a";
    private static final long serialVersionUID = 6182834493563598289L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final transient Logger f17135a;
    final boolean traceCapable;

    @Override // bf.b
    public void debug(String str) {
        this.f17135a.log(f17134b, Level.DEBUG, str, null);
    }

    @Override // bf.b
    public void error(String str) {
        this.f17135a.log(f17134b, Level.ERROR, str, null);
    }

    @Override // bf.b
    public void trace(String str, Object obj) {
        if (isTraceEnabled()) {
            org.slf4j.helpers.a aVarI = org.slf4j.helpers.c.i(str, obj);
            this.f17135a.log(f17134b, this.traceCapable ? Level.TRACE : Level.DEBUG, aVarI.b(), aVarI.c());
        }
    }

    @Override // bf.b
    public void warn(String str) {
        this.f17135a.log(f17134b, Level.WARN, str, null);
    }

    private boolean b() {
        try {
            this.f17135a.isTraceEnabled();
            return true;
        } catch (NoSuchMethodError unused) {
            return false;
        }
    }

    private Level c(int i10) {
        if (i10 == 0) {
            return this.traceCapable ? Level.TRACE : Level.DEBUG;
        }
        if (i10 == 10) {
            return Level.DEBUG;
        }
        if (i10 == 20) {
            return Level.INFO;
        }
        if (i10 == 30) {
            return Level.WARN;
        }
        if (i10 == 40) {
            return Level.ERROR;
        }
        throw new IllegalStateException("Level number " + i10 + " is not recognized.");
    }

    @Override // bf.b
    public void debug(String str, Object obj) {
        if (this.f17135a.isDebugEnabled()) {
            org.slf4j.helpers.a aVarI = org.slf4j.helpers.c.i(str, obj);
            this.f17135a.log(f17134b, Level.DEBUG, aVarI.b(), aVarI.c());
        }
    }

    @Override // bf.b
    public void error(String str, Object obj) {
        Logger logger = this.f17135a;
        Level level = Level.ERROR;
        if (logger.isEnabledFor(level)) {
            org.slf4j.helpers.a aVarI = org.slf4j.helpers.c.i(str, obj);
            this.f17135a.log(f17134b, level, aVarI.b(), aVarI.c());
        }
    }

    @Override // bf.b
    public void info(String str) {
        this.f17135a.log(f17134b, Level.INFO, str, null);
    }

    @Override // bf.b
    public boolean isDebugEnabled() {
        return this.f17135a.isDebugEnabled();
    }

    @Override // bf.b
    public boolean isErrorEnabled() {
        return this.f17135a.isEnabledFor(Level.ERROR);
    }

    @Override // bf.b
    public boolean isInfoEnabled() {
        return this.f17135a.isInfoEnabled();
    }

    @Override // bf.b
    public boolean isTraceEnabled() {
        return this.traceCapable ? this.f17135a.isTraceEnabled() : this.f17135a.isDebugEnabled();
    }

    @Override // bf.b
    public boolean isWarnEnabled() {
        return this.f17135a.isEnabledFor(Level.WARN);
    }

    @Override // bf.b
    public void warn(String str, Object obj) {
        Logger logger = this.f17135a;
        Level level = Level.WARN;
        if (logger.isEnabledFor(level)) {
            org.slf4j.helpers.a aVarI = org.slf4j.helpers.c.i(str, obj);
            this.f17135a.log(f17134b, level, aVarI.b(), aVarI.c());
        }
    }

    a(Logger logger) {
        this.f17135a = logger;
        this.name = logger.getName();
        this.traceCapable = b();
    }

    @Override // df.a
    public void a(d dVar, String str, int i10, String str2, Object[] objArr, Throwable th) {
        this.f17135a.log(str, c(i10), str2, th);
    }

    @Override // bf.b
    public void trace(String str, Object obj, Object obj2) {
        if (isTraceEnabled()) {
            org.slf4j.helpers.a aVarJ = org.slf4j.helpers.c.j(str, obj, obj2);
            this.f17135a.log(f17134b, this.traceCapable ? Level.TRACE : Level.DEBUG, aVarJ.b(), aVarJ.c());
        }
    }

    @Override // bf.b
    public void debug(String str, Object obj, Object obj2) {
        if (this.f17135a.isDebugEnabled()) {
            org.slf4j.helpers.a aVarJ = org.slf4j.helpers.c.j(str, obj, obj2);
            this.f17135a.log(f17134b, Level.DEBUG, aVarJ.b(), aVarJ.c());
        }
    }

    @Override // bf.b
    public void error(String str, Object obj, Object obj2) {
        Logger logger = this.f17135a;
        Level level = Level.ERROR;
        if (logger.isEnabledFor(level)) {
            org.slf4j.helpers.a aVarJ = org.slf4j.helpers.c.j(str, obj, obj2);
            this.f17135a.log(f17134b, level, aVarJ.b(), aVarJ.c());
        }
    }

    @Override // bf.b
    public void warn(String str, Object obj, Object obj2) {
        Logger logger = this.f17135a;
        Level level = Level.WARN;
        if (logger.isEnabledFor(level)) {
            org.slf4j.helpers.a aVarJ = org.slf4j.helpers.c.j(str, obj, obj2);
            this.f17135a.log(f17134b, level, aVarJ.b(), aVarJ.c());
        }
    }

    @Override // bf.b
    public void trace(String str, Throwable th) {
        this.f17135a.log(f17134b, this.traceCapable ? Level.TRACE : Level.DEBUG, str, th);
    }

    @Override // bf.b
    public void debug(String str, Object... objArr) {
        if (this.f17135a.isDebugEnabled()) {
            org.slf4j.helpers.a aVarA = org.slf4j.helpers.c.a(str, objArr);
            this.f17135a.log(f17134b, Level.DEBUG, aVarA.b(), aVarA.c());
        }
    }

    @Override // bf.b
    public void error(String str, Object... objArr) {
        Logger logger = this.f17135a;
        Level level = Level.ERROR;
        if (logger.isEnabledFor(level)) {
            org.slf4j.helpers.a aVarA = org.slf4j.helpers.c.a(str, objArr);
            this.f17135a.log(f17134b, level, aVarA.b(), aVarA.c());
        }
    }

    @Override // bf.b
    public void warn(String str, Object... objArr) {
        Logger logger = this.f17135a;
        Level level = Level.WARN;
        if (logger.isEnabledFor(level)) {
            org.slf4j.helpers.a aVarA = org.slf4j.helpers.c.a(str, objArr);
            this.f17135a.log(f17134b, level, aVarA.b(), aVarA.c());
        }
    }

    @Override // bf.b
    public void debug(String str, Throwable th) {
        this.f17135a.log(f17134b, Level.DEBUG, str, th);
    }

    @Override // bf.b
    public void error(String str, Throwable th) {
        this.f17135a.log(f17134b, Level.ERROR, str, th);
    }

    @Override // bf.b
    public void warn(String str, Throwable th) {
        this.f17135a.log(f17134b, Level.WARN, str, th);
    }
}
