package com.google.common.base;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class a<T> extends l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final a<Object> f4558a = new a<>();
    private static final long serialVersionUID = 0;

    @Override // com.google.common.base.l
    public boolean c() {
        return false;
    }

    static <T> l<T> e() {
        return f4558a;
    }

    private Object readResolve() {
        return f4558a;
    }

    @Override // com.google.common.base.l
    public T b() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public String toString() {
        return "Optional.absent()";
    }

    private a() {
    }

    public int hashCode() {
        return 2040732332;
    }
}
