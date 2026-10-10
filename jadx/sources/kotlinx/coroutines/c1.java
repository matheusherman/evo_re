package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/c1;", "Lkotlinx/coroutines/l;", "Lkotlinx/coroutines/b1;", "handle", "<init>", "(Lkotlinx/coroutines/b1;)V", "", "cause", "Lr8/z;", "e", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "a", "Lkotlinx/coroutines/b1;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class c1 extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final b1 handle;

    @Override // kotlinx.coroutines.m
    public void e(Throwable cause) {
        this.handle.dispose();
    }

    @Override // c9.l
    public /* bridge */ /* synthetic */ r8.z invoke(Throwable th) {
        e(th);
        return r8.z.f17874a;
    }

    public String toString() {
        return "DisposeOnCancel[" + this.handle + ']';
    }

    public c1(b1 b1Var) {
        this.handle = b1Var;
    }
}
