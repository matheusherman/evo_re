package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0005¢\u0006\u0004\b\u000b\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/g2;", "Lkotlinx/coroutines/i0;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "parallelism", "limitedParallelism", "(I)Lkotlinx/coroutines/i0;", "o", "d", "()Lkotlinx/coroutines/g2;", "immediate", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class g2 extends i0 {
    public abstract g2 d();

    @Override // kotlinx.coroutines.i0
    public i0 limitedParallelism(int parallelism) {
        kotlinx.coroutines.internal.n.a(parallelism);
        return this;
    }

    protected final String o() {
        g2 g2VarD;
        g2 g2VarC = a1.c();
        if (this == g2VarC) {
            return "Dispatchers.Main";
        }
        try {
            g2VarD = g2VarC.d();
        } catch (UnsupportedOperationException unused) {
            g2VarD = null;
        }
        if (this != g2VarD) {
            return null;
        }
        return "Dispatchers.Main.immediate";
    }

    @Override // kotlinx.coroutines.i0
    public String toString() {
        String strO = o();
        if (strO == null) {
            return p0.a(this) + '@' + p0.b(this);
        }
        return strO;
    }
}
