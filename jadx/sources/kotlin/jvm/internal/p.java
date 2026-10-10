package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class p extends r implements i9.i {
    public p() {
    }

    public p(Object obj) {
        super(obj);
    }

    @Override // i9.k
    public i9.m.a getGetter() {
        return ((i9.i) getReflected()).getGetter();
    }

    @Override // i9.h
    public i9.i.a getSetter() {
        return ((i9.i) getReflected()).getSetter();
    }

    public p(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }

    @Override // kotlin.jvm.internal.c
    protected i9.c computeReflected() {
        return c0.e(this);
    }

    @Override // i9.m
    public Object getDelegate(Object obj) {
        return ((i9.i) getReflected()).getDelegate(obj);
    }

    @Override // c9.l
    public Object invoke(Object obj) {
        return get(obj);
    }
}
