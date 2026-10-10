package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\r\u001a\u00020\u00078\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\tR\u0014\u0010\u000f\u001a\u00020\u00078PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\t¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/x1;", "Lkotlinx/coroutines/c2;", "Lkotlinx/coroutines/z;", "Lkotlinx/coroutines/u1;", "parent", "<init>", "(Lkotlinx/coroutines/u1;)V", "", "I0", "()Z", "c", "Z", "X", "handlesException", "Y", "onCancelComplete", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class x1 extends c2 implements z {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean handlesException;

    public x1(u1 u1Var) {
        super(true);
        e0(u1Var);
        this.handlesException = I0();
    }

    @Override // kotlinx.coroutines.c2
    public boolean Y() {
        return true;
    }

    @Override // kotlinx.coroutines.c2
    /* JADX INFO: renamed from: X, reason: from getter */
    public boolean getHandlesException() {
        return this.handlesException;
    }

    private final boolean I0() {
        u uVar;
        c2 c2VarT;
        u uVar2;
        t tVarA0 = a0();
        if (tVarA0 instanceof u) {
            uVar = (u) tVarA0;
        } else {
            uVar = null;
        }
        if (uVar != null && (c2VarT = uVar.t()) != null) {
            while (!c2VarT.getHandlesException()) {
                t tVarA1 = c2VarT.a0();
                if (tVarA1 instanceof u) {
                    uVar2 = (u) tVarA1;
                } else {
                    uVar2 = null;
                }
                if (uVar2 == null || (c2VarT = uVar2.t()) == null) {
                }
            }
            return true;
        }
        return false;
    }
}
