package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/b2;", "Lkotlinx/coroutines/d0;", "Lkotlinx/coroutines/b1;", "Lkotlinx/coroutines/p1;", "<init>", "()V", "Lr8/z;", "dispose", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/c2;", "d", "Lkotlinx/coroutines/c2;", "t", "()Lkotlinx/coroutines/c2;", "u", "(Lkotlinx/coroutines/c2;)V", "job", "", "isActive", "()Z", "Lkotlinx/coroutines/h2;", "a", "()Lkotlinx/coroutines/h2;", "list", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class b2 extends d0 implements b1, p1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    public c2 job;

    @Override // kotlinx.coroutines.p1
    /* JADX INFO: renamed from: a */
    public h2 getList() {
        return null;
    }

    @Override // kotlinx.coroutines.p1
    /* JADX INFO: renamed from: isActive */
    public boolean getIsActive() {
        return true;
    }

    public final c2 t() {
        c2 c2Var = this.job;
        if (c2Var != null) {
            return c2Var;
        }
        kotlin.jvm.internal.m.v("job");
        return null;
    }

    @Override // kotlinx.coroutines.internal.q
    public String toString() {
        return p0.a(this) + '@' + p0.b(this) + "[job@" + p0.b(t()) + ']';
    }

    public final void u(c2 c2Var) {
        this.job = c2Var;
    }

    @Override // kotlinx.coroutines.b1
    public void dispose() {
        t().w0(this);
    }
}
