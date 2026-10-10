package com.google.common.base;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class o<T> extends l<T> {
    private static final long serialVersionUID = 0;
    private final T reference;

    @Override // com.google.common.base.l
    public boolean c() {
        return true;
    }

    @Override // com.google.common.base.l
    public T b() {
        return this.reference;
    }

    public boolean equals(Object obj) {
        if (obj instanceof o) {
            return this.reference.equals(((o) obj).reference);
        }
        return false;
    }

    public int hashCode() {
        return this.reference.hashCode() + 1502476572;
    }

    public String toString() {
        return "Optional.of(" + this.reference + ")";
    }

    o(T t10) {
        this.reference = t10;
    }
}
