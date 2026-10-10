package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR&\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/r1;", "Lkotlinx/coroutines/l;", "Lkotlin/Function1;", "", "Lr8/z;", "Lkotlinx/coroutines/CompletionHandler;", "handler", "<init>", "(Lc9/l;)V", "cause", "e", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "a", "Lc9/l;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class r1 extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final c9.l<Throwable, r8.z> handler;

    @Override // kotlinx.coroutines.m
    public void e(Throwable cause) {
        this.handler.invoke(cause);
    }

    @Override // c9.l
    public /* bridge */ /* synthetic */ r8.z invoke(Throwable th) {
        e(th);
        return r8.z.f17874a;
    }

    public String toString() {
        return "InvokeOnCancel[" + p0.a(this.handler) + '@' + p0.b(this) + ']';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r1(c9.l<? super Throwable, r8.z> lVar) {
        this.handler = lVar;
    }
}
