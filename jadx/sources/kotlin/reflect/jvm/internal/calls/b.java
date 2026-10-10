package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class b implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f12388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f12389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final r8.i f12390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final r8.i f12391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f12392e;

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        return c.i(this.f12388a, this.f12389b, this.f12390c, this.f12391d, this.f12392e, obj, method, objArr);
    }

    public b(Class cls, Map map, r8.i iVar, r8.i iVar2, List list) {
        this.f12388a = cls;
        this.f12389b = map;
        this.f12390c = iVar;
        this.f12391d = iVar2;
        this.f12392e = list;
    }
}
