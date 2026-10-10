package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlinx.coroutines.y1;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u00032\u00020\u0004B\u001d\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\"\u0010\u001e\u001a\u00020\u000e2\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001cH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u000bH\u0016¢\u0006\u0004\b \u0010!J\u001b\u0010\"\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\"\u0010#R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010$R\u0014\u0010\u0007\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010%R\u0014\u0010'\u001a\u00020&8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010)\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010%R\u001e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u00101\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100\u0082\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"Lkotlinx/coroutines/flow/internal/q;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/g;", "Lkotlin/coroutines/jvm/internal/d;", "Lkotlin/coroutines/jvm/internal/e;", "collector", "Lv8/j;", "collectContext", "<init>", "(Lkotlinx/coroutines/flow/g;Lv8/j;)V", "Lv8/f;", "Lr8/z;", "uCont", "value", "", "c", "(Lv8/f;Ljava/lang/Object;)Ljava/lang/Object;", "currentContext", "previousContext", "b", "(Lv8/j;Lv8/j;Ljava/lang/Object;)V", "Lkotlinx/coroutines/flow/internal/k;", "exception", "f", "(Lkotlinx/coroutines/flow/internal/k;Ljava/lang/Object;)V", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "Lr8/q;", "result", "invokeSuspend", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "()V", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/g;", "Lv8/j;", "", "collectContextSize", "I", "lastEmissionContext", "completion", "Lv8/f;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/e;", "callerFrame", "getContext", "()Lv8/j;", "context", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class q<T> extends kotlin.coroutines.jvm.internal.d implements kotlinx.coroutines.flow.g<T>, kotlin.coroutines.jvm.internal.e {
    public final v8.j collectContext;
    public final int collectContextSize;
    public final kotlinx.coroutines.flow.g<T> collector;
    private v8.f<? super z> completion;
    private v8.j lastEmissionContext;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "count", "Lv8/j$b;", "<anonymous parameter 1>", "a", "(ILv8/j$b;)Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    static final class a extends kotlin.jvm.internal.o implements c9.p<Integer, v8.j.b, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14744a = new a();

        a() {
            super(2);
        }

        public final Integer a(int i10, v8.j.b bVar) {
            return Integer.valueOf(i10 + 1);
        }

        @Override // c9.p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, v8.j.b bVar) {
            return a(num.intValue(), bVar);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q(kotlinx.coroutines.flow.g<? super T> gVar, v8.j jVar) {
        super(n.f14738a, v8.k.f19724a);
        this.collector = gVar;
        this.collectContext = jVar;
        this.collectContextSize = ((Number) jVar.fold(0, a.f14744a)).intValue();
    }

    private final void b(v8.j currentContext, v8.j previousContext, T value) {
        if (previousContext instanceof k) {
            f((k) previousContext, value);
        }
        s.a(this, currentContext);
    }

    private final void f(k exception, Object value) {
        throw new IllegalStateException(ua.n.j("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + exception.e + ", but then emission attempt of value '" + value + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    @Override // kotlin.coroutines.jvm.internal.a, kotlin.coroutines.jvm.internal.e
    public kotlin.coroutines.jvm.internal.e getCallerFrame() {
        v8.f<? super z> fVar = this.completion;
        if (fVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) fVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.d, v8.f
    public v8.j getContext() {
        v8.j jVar = this.lastEmissionContext;
        return jVar == null ? v8.k.f19724a : jVar;
    }

    private final Object c(v8.f<? super z> uCont, T value) {
        v8.j context = uCont.getContext();
        y1.h(context);
        v8.j jVar = this.lastEmissionContext;
        if (jVar != context) {
            b(context, jVar, value);
            this.lastEmissionContext = context;
        }
        this.completion = uCont;
        c9.q qVar = r.f14745a;
        kotlinx.coroutines.flow.g<T> gVar = this.collector;
        kotlin.jvm.internal.m.d(gVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        kotlin.jvm.internal.m.d(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object objInvoke = qVar.invoke(gVar, value, this);
        if (!kotlin.jvm.internal.m.a(objInvoke, kotlin.coroutines.intrinsics.b.c())) {
            this.completion = null;
        }
        return objInvoke;
    }

    @Override // kotlinx.coroutines.flow.g
    public Object emit(T t10, v8.f<? super z> fVar) {
        try {
            Object objC = c(fVar, t10);
            if (objC == kotlin.coroutines.intrinsics.b.c()) {
                kotlin.coroutines.jvm.internal.h.c(fVar);
            }
            if (objC == kotlin.coroutines.intrinsics.b.c()) {
                return objC;
            }
            return z.f17874a;
        } catch (Throwable th) {
            this.lastEmissionContext = new k(th, fVar.getContext());
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public Object invokeSuspend(Object result) {
        Throwable thC = r8.q.c(result);
        if (thC != null) {
            this.lastEmissionContext = new k(thC, getContext());
        }
        v8.f<? super z> fVar = this.completion;
        if (fVar != null) {
            fVar.resumeWith(result);
        }
        return kotlin.coroutines.intrinsics.b.c();
    }

    @Override // kotlin.coroutines.jvm.internal.d, kotlin.coroutines.jvm.internal.a
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
