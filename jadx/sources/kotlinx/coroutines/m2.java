package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/m2;", "Lkotlinx/coroutines/b2;", "Lv8/f;", "Lr8/z;", "continuation", "<init>", "(Lv8/f;)V", "", "cause", "s", "(Ljava/lang/Throwable;)V", "e", "Lv8/f;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class m2 extends b2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final v8.f<r8.z> continuation;

    @Override // c9.l
    public /* bridge */ /* synthetic */ r8.z invoke(Throwable th) {
        s(th);
        return r8.z.f17874a;
    }

    @Override // kotlinx.coroutines.d0
    public void s(Throwable cause) {
        v8.f<r8.z> fVar = this.continuation;
        r8.q.Companion companion = r8.q.INSTANCE;
        fVar.resumeWith(r8.q.a(r8.z.f17874a));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m2(v8.f<? super r8.z> fVar) {
        this.continuation = fVar;
    }
}
