package org.slf4j.helpers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class g implements bf.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f17124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile bf.b f17125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Boolean f17126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Method f17127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private cf.a f17128e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Queue<cf.d> f17129f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f17130g;

    @Override // bf.b
    public void debug(String str) {
        b().debug(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f17124a.equals(((g) obj).f17124a);
    }

    @Override // bf.b
    public void error(String str) {
        b().error(str);
    }

    @Override // bf.b
    public void trace(String str, Object obj) {
        b().trace(str, obj);
    }

    @Override // bf.b
    public void warn(String str) {
        b().warn(str);
    }

    private bf.b c() {
        if (this.f17128e == null) {
            this.f17128e = new cf.a(this, this.f17129f);
        }
        return this.f17128e;
    }

    bf.b b() {
        if (this.f17125b != null) {
            return this.f17125b;
        }
        return this.f17130g ? d.f17123a : c();
    }

    public boolean d() {
        Boolean bool = this.f17126c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.f17127d = this.f17125b.getClass().getMethod("log", cf.c.class);
            this.f17126c = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.f17126c = Boolean.FALSE;
        }
        return this.f17126c.booleanValue();
    }

    @Override // bf.b
    public void debug(String str, Object obj) {
        b().debug(str, obj);
    }

    public boolean e() {
        return this.f17125b instanceof d;
    }

    @Override // bf.b
    public void error(String str, Object obj) {
        b().error(str, obj);
    }

    public boolean f() {
        return this.f17125b == null;
    }

    @Override // bf.b
    public String getName() {
        return this.f17124a;
    }

    public void h(bf.b bVar) {
        this.f17125b = bVar;
    }

    public int hashCode() {
        return this.f17124a.hashCode();
    }

    @Override // bf.b
    public void trace(String str, Object obj, Object obj2) {
        b().trace(str, obj, obj2);
    }

    @Override // bf.b
    public void warn(String str, Object obj) {
        b().warn(str, obj);
    }

    public g(String str, Queue<cf.d> queue, boolean z10) {
        this.f17124a = str;
        this.f17129f = queue;
        this.f17130g = z10;
    }

    @Override // bf.b
    public void debug(String str, Object obj, Object obj2) {
        b().debug(str, obj, obj2);
    }

    @Override // bf.b
    public void error(String str, Object obj, Object obj2) {
        b().error(str, obj, obj2);
    }

    public void g(cf.c cVar) {
        if (d()) {
            try {
                this.f17127d.invoke(this.f17125b, cVar);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    @Override // bf.b
    public void info(String str) {
        b().info(str);
    }

    @Override // bf.b
    public boolean isDebugEnabled() {
        return b().isDebugEnabled();
    }

    @Override // bf.b
    public boolean isErrorEnabled() {
        return b().isErrorEnabled();
    }

    @Override // bf.b
    public boolean isInfoEnabled() {
        return b().isInfoEnabled();
    }

    @Override // bf.b
    public boolean isTraceEnabled() {
        return b().isTraceEnabled();
    }

    @Override // bf.b
    public boolean isWarnEnabled() {
        return b().isWarnEnabled();
    }

    @Override // bf.b
    public void trace(String str, Throwable th) {
        b().trace(str, th);
    }

    @Override // bf.b
    public void warn(String str, Object obj, Object obj2) {
        b().warn(str, obj, obj2);
    }

    @Override // bf.b
    public void debug(String str, Object... objArr) {
        b().debug(str, objArr);
    }

    @Override // bf.b
    public void error(String str, Object... objArr) {
        b().error(str, objArr);
    }

    @Override // bf.b
    public void warn(String str, Object... objArr) {
        b().warn(str, objArr);
    }

    @Override // bf.b
    public void debug(String str, Throwable th) {
        b().debug(str, th);
    }

    @Override // bf.b
    public void error(String str, Throwable th) {
        b().error(str, th);
    }

    @Override // bf.b
    public void warn(String str, Throwable th) {
        b().warn(str, th);
    }
}
