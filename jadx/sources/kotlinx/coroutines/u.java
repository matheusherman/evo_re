package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/u;", "Lkotlinx/coroutines/w1;", "Lkotlinx/coroutines/t;", "Lkotlinx/coroutines/v;", "childJob", "<init>", "(Lkotlinx/coroutines/v;)V", "", "cause", "Lr8/z;", "s", "(Ljava/lang/Throwable;)V", "", "f", "(Ljava/lang/Throwable;)Z", "e", "Lkotlinx/coroutines/v;", "Lkotlinx/coroutines/u1;", "getParent", "()Lkotlinx/coroutines/u1;", "parent", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class u extends w1 implements t {

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final v childJob;

    @Override // c9.l
    public /* bridge */ /* synthetic */ r8.z invoke(Throwable th) {
        s(th);
        return r8.z.f17874a;
    }

    @Override // kotlinx.coroutines.d0
    public void s(Throwable cause) {
        this.childJob.m(t());
    }

    public u(v vVar) {
        this.childJob = vVar;
    }

    @Override // kotlinx.coroutines.t
    public boolean f(Throwable cause) {
        return t().O(cause);
    }

    @Override // kotlinx.coroutines.t
    public u1 getParent() {
        return t();
    }
}
