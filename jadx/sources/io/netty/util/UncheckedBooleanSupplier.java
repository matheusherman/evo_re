package io.netty.util;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface UncheckedBooleanSupplier {
    public static final UncheckedBooleanSupplier FALSE_SUPPLIER = new UncheckedBooleanSupplier() { // from class: io.netty.util.UncheckedBooleanSupplier.1
        @Override // io.netty.util.UncheckedBooleanSupplier
        public boolean get() {
            return false;
        }
    };
    public static final UncheckedBooleanSupplier TRUE_SUPPLIER = new UncheckedBooleanSupplier() { // from class: io.netty.util.UncheckedBooleanSupplier.2
        @Override // io.netty.util.UncheckedBooleanSupplier
        public boolean get() {
            return true;
        }
    };

    boolean get();
}
