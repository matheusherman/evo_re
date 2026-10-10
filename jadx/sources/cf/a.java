package cf;

import java.util.Queue;
import org.slf4j.helpers.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a implements bf.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f1170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    g f1171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Queue<d> f1172c;

    private void c(b bVar, String str, Object[] objArr, Throwable th) {
        b(bVar, null, str, objArr, th);
    }

    @Override // bf.b
    public void debug(String str) {
        c(b.TRACE, str, null, null);
    }

    @Override // bf.b
    public void error(String str) {
        c(b.ERROR, str, null, null);
    }

    @Override // bf.b
    public boolean isDebugEnabled() {
        return true;
    }

    @Override // bf.b
    public boolean isErrorEnabled() {
        return true;
    }

    @Override // bf.b
    public boolean isInfoEnabled() {
        return true;
    }

    @Override // bf.b
    public boolean isTraceEnabled() {
        return true;
    }

    @Override // bf.b
    public boolean isWarnEnabled() {
        return true;
    }

    @Override // bf.b
    public void trace(String str, Object obj) {
        c(b.TRACE, str, new Object[]{obj}, null);
    }

    @Override // bf.b
    public void warn(String str) {
        c(b.WARN, str, null, null);
    }

    private void b(b bVar, bf.d dVar, String str, Object[] objArr, Throwable th) {
        d dVar2 = new d();
        dVar2.j(System.currentTimeMillis());
        dVar2.c(bVar);
        dVar2.d(this.f1171b);
        dVar2.e(this.f1170a);
        dVar2.f(dVar);
        dVar2.g(str);
        dVar2.b(objArr);
        dVar2.i(th);
        dVar2.h(Thread.currentThread().getName());
        this.f1172c.add(dVar2);
    }

    @Override // bf.b
    public void debug(String str, Object obj) {
        c(b.DEBUG, str, new Object[]{obj}, null);
    }

    @Override // bf.b
    public void error(String str, Object obj) {
        c(b.ERROR, str, new Object[]{obj}, null);
    }

    @Override // bf.b
    public String getName() {
        return this.f1170a;
    }

    @Override // bf.b
    public void info(String str) {
        c(b.INFO, str, null, null);
    }

    @Override // bf.b
    public void trace(String str, Object obj, Object obj2) {
        c(b.TRACE, str, new Object[]{obj, obj2}, null);
    }

    @Override // bf.b
    public void warn(String str, Object obj) {
        c(b.WARN, str, new Object[]{obj}, null);
    }

    public a(g gVar, Queue<d> queue) {
        this.f1171b = gVar;
        this.f1170a = gVar.getName();
        this.f1172c = queue;
    }

    @Override // bf.b
    public void debug(String str, Object obj, Object obj2) {
        c(b.DEBUG, str, new Object[]{obj, obj2}, null);
    }

    @Override // bf.b
    public void error(String str, Object obj, Object obj2) {
        c(b.ERROR, str, new Object[]{obj, obj2}, null);
    }

    @Override // bf.b
    public void trace(String str, Throwable th) {
        c(b.TRACE, str, null, th);
    }

    @Override // bf.b
    public void warn(String str, Object obj, Object obj2) {
        c(b.WARN, str, new Object[]{obj, obj2}, null);
    }

    @Override // bf.b
    public void debug(String str, Object... objArr) {
        c(b.DEBUG, str, objArr, null);
    }

    @Override // bf.b
    public void error(String str, Object... objArr) {
        c(b.ERROR, str, objArr, null);
    }

    @Override // bf.b
    public void warn(String str, Object... objArr) {
        c(b.WARN, str, objArr, null);
    }

    @Override // bf.b
    public void debug(String str, Throwable th) {
        c(b.DEBUG, str, null, th);
    }

    @Override // bf.b
    public void error(String str, Throwable th) {
        c(b.ERROR, str, null, th);
    }

    @Override // bf.b
    public void warn(String str, Throwable th) {
        c(b.WARN, str, null, th);
    }
}
