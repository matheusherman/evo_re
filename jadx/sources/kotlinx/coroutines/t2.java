package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\u0003J\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\n\u0010\u000bR(\u0010\u0010\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040\fj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\t\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/t2;", "", "<init>", "()V", "Lkotlinx/coroutines/e1;", "a", "()Lkotlinx/coroutines/e1;", "Lr8/z;", "c", "eventLoop", "d", "(Lkotlinx/coroutines/e1;)V", "Ljava/lang/ThreadLocal;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "b", "Ljava/lang/ThreadLocal;", "ref", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class t2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t2 f14936a = new t2();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ThreadLocal<e1> ref = kotlinx.coroutines.internal.m0.a(new kotlinx.coroutines.internal.f0("ThreadLocalEventLoop"));

    public final e1 a() {
        return ref.get();
    }

    public final e1 b() {
        ThreadLocal<e1> threadLocal = ref;
        e1 e1Var = threadLocal.get();
        if (e1Var != null) {
            return e1Var;
        }
        e1 e1VarA = h1.a();
        threadLocal.set(e1VarA);
        return e1VarA;
    }

    public final void c() {
        ref.set(null);
    }

    public final void d(e1 eventLoop) {
        ref.set(eventLoop);
    }

    private t2() {
    }
}
