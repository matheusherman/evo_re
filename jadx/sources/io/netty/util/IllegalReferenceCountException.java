package io.netty.util;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class IllegalReferenceCountException extends IllegalStateException {
    private static final long serialVersionUID = -2507492394288153468L;

    public IllegalReferenceCountException(int i10) {
        this("refCnt: " + i10);
    }

    public IllegalReferenceCountException(int i10, int i11) {
        StringBuilder sb2;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("refCnt: ");
        sb3.append(i10);
        sb3.append(", ");
        if (i11 > 0) {
            sb2 = new StringBuilder();
            sb2.append("increment: ");
        } else {
            sb2 = new StringBuilder();
            sb2.append("decrement: ");
            i11 = -i11;
        }
        sb2.append(i11);
        sb3.append(sb2.toString());
        this(sb3.toString());
    }

    public IllegalReferenceCountException(String str) {
        super(str);
    }

    public IllegalReferenceCountException(String str, Throwable th) {
        super(str, th);
    }
}
