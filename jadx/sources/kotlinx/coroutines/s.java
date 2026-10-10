package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/s;", "Lkotlinx/coroutines/w1;", "Lkotlinx/coroutines/o;", "child", "<init>", "(Lkotlinx/coroutines/o;)V", "", "cause", "Lr8/z;", "s", "(Ljava/lang/Throwable;)V", "e", "Lkotlinx/coroutines/o;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class s extends w1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final o<?> child;

    @Override // c9.l
    public /* bridge */ /* synthetic */ r8.z invoke(Throwable th) {
        s(th);
        return r8.z.f17874a;
    }

    @Override // kotlinx.coroutines.d0
    public void s(Throwable cause) {
        o<?> oVar = this.child;
        oVar.L(oVar.w(t()));
    }

    public s(o<?> oVar) {
        this.child = oVar;
    }
}
