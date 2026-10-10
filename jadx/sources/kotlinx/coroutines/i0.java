package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001#B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH&¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0017¢\u0006\u0004\b\u0014\u0010\u0013J'\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00112\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!¨\u0006$"}, d2 = {"Lkotlinx/coroutines/i0;", "Lv8/a;", "Lv8/g;", "<init>", "()V", "Lv8/j;", "context", "", "isDispatchNeeded", "(Lv8/j;)Z", "", "parallelism", "limitedParallelism", "(I)Lkotlinx/coroutines/i0;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lr8/z;", "dispatch", "(Lv8/j;Ljava/lang/Runnable;)V", "dispatchYield", ExifInterface.GPS_DIRECTION_TRUE, "Lv8/f;", "continuation", "interceptContinuation", "(Lv8/f;)Lv8/f;", "releaseInterceptedContinuation", "(Lv8/f;)V", TransactionPartnerType.OTHER, "plus", "(Lkotlinx/coroutines/i0;)Lkotlinx/coroutines/i0;", "", "toString", "()Ljava/lang/String;", "Key", "a", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class i0 extends v8.a implements v8.g {

    /* JADX INFO: renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: kotlinx.coroutines.i0$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/i0$a;", "Lv8/b;", "Lv8/g;", "Lkotlinx/coroutines/i0;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion extends v8.b<v8.g, i0> {

        /* JADX INFO: renamed from: kotlinx.coroutines.i0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lv8/j$b;", "it", "Lkotlinx/coroutines/i0;", "a", "(Lv8/j$b;)Lkotlinx/coroutines/i0;"}, k = 3, mv = {1, 8, 0})
        static final class C0291a extends kotlin.jvm.internal.o implements c9.l<v8.j.b, i0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0291a f14806a = new C0291a();

            C0291a() {
                super(1);
            }

            @Override // c9.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final i0 invoke(v8.j.b bVar) {
                if (bVar instanceof i0) {
                    return (i0) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
            super(v8.g.INSTANCE, C0291a.f14806a);
        }
    }

    public abstract void dispatch(v8.j context, Runnable block);

    public boolean isDispatchNeeded(v8.j context) {
        return true;
    }

    public i0() {
        super(v8.g.INSTANCE);
    }

    @Override // v8.g
    public final <T> v8.f<T> interceptContinuation(v8.f<? super T> continuation) {
        return new kotlinx.coroutines.internal.j(this, continuation);
    }

    @Override // v8.g
    public final void releaseInterceptedContinuation(v8.f<?> continuation) {
        kotlin.jvm.internal.m.d(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((kotlinx.coroutines.internal.j) continuation).t();
    }

    public String toString() {
        return p0.a(this) + '@' + p0.b(this);
    }

    public void dispatchYield(v8.j context, Runnable block) {
        dispatch(context, block);
    }

    @Override // v8.a, v8.j.b, v8.j
    public <E extends v8.j.b> E get(v8.j.c<E> cVar) {
        return (E) v8.g.a.a(this, cVar);
    }

    public i0 limitedParallelism(int parallelism) {
        kotlinx.coroutines.internal.n.a(parallelism);
        return new kotlinx.coroutines.internal.m(this, parallelism);
    }

    @Override // v8.a, v8.j
    public v8.j minusKey(v8.j.c<?> cVar) {
        return v8.g.a.b(this, cVar);
    }

    public final i0 plus(i0 other) {
        return other;
    }
}
