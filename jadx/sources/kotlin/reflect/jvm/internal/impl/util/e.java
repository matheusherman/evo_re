package kotlin.reflect.jvm.internal.impl.util;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class e<K, T> extends a<K, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c<T> f14407a;

    protected e(c<T> arrayMap) {
        kotlin.jvm.internal.m.f(arrayMap, "arrayMap");
        this.f14407a = arrayMap;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.a
    protected final c<T> e() {
        return this.f14407a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final void h(i9.d<? extends K> tClass, T value) {
        kotlin.jvm.internal.m.f(tClass, "tClass");
        kotlin.jvm.internal.m.f(value, "value");
        int iD = f().d(tClass);
        int iE = this.f14407a.e();
        if (iE == 0) {
            this.f14407a = new o(value, iD);
            return;
        }
        if (iE == 1) {
            c<T> cVar = this.f14407a;
            kotlin.jvm.internal.m.d(cVar, "null cannot be cast to non-null type org.jetbrains.kotlin.util.OneElementArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
            o oVar = (o) cVar;
            if (oVar.h() == iD) {
                this.f14407a = new o(value, iD);
                return;
            } else {
                d dVar = new d();
                this.f14407a = dVar;
                dVar.f(oVar.h(), oVar.i());
            }
        }
        this.f14407a.f(iD, value);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public e() {
        i iVar = i.f14420a;
        kotlin.jvm.internal.m.d(iVar, "null cannot be cast to non-null type org.jetbrains.kotlin.util.ArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
        this(iVar);
    }
}
