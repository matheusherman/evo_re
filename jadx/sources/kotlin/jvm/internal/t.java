package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class t extends x implements i9.l {
    @Override // i9.k
    public i9.l.a getGetter() {
        return ((i9.l) getReflected()).getGetter();
    }

    public t(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }

    @Override // kotlin.jvm.internal.c
    protected i9.c computeReflected() {
        return c0.f(this);
    }

    @Override // c9.a
    public Object invoke() {
        return get();
    }
}
