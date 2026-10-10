package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlinx.coroutines.h0;
import org.apache.log4j.net.SyslogAppender;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b \u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B-\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0012\u001a\u00020\u00112\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0014\u001a\u00020\u00112\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eH¤@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0018\u001a\u00020\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u0016H\u0094@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001a\u001a\u00020\u00112\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0015J\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lkotlinx/coroutines/flow/internal/g;", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/e;", "Lkotlinx/coroutines/flow/f;", "flow", "Lv8/j;", "context", "", "capacity", "Lkotlinx/coroutines/channels/a;", "onBufferOverflow", "<init>", "(Lkotlinx/coroutines/flow/f;Lv8/j;ILkotlinx/coroutines/channels/a;)V", "Lkotlinx/coroutines/flow/g;", "collector", "newContext", "Lr8/z;", "l", "(Lkotlinx/coroutines/flow/g;Lv8/j;Lv8/f;)Ljava/lang/Object;", "m", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/s;", "scope", "e", "(Lkotlinx/coroutines/channels/s;Lv8/f;)Ljava/lang/Object;", "collect", "", "toString", "()Ljava/lang/String;", "d", "Lkotlinx/coroutines/flow/f;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class g<S, T> extends e<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    protected final kotlinx.coroutines.flow.f<S> flow;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2", f = "ChannelFlow.kt", l = {SyslogAppender.LOG_LOCAL3}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/g;", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {1, 8, 0})
    static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super T>, v8.f<? super z>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ g<S, T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(g<S, T> gVar, v8.f<? super a> fVar) {
            super(2, fVar);
            this.this$0 = gVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            a aVar = new a(this.this$0, fVar);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.flow.g<? super T> gVar, v8.f<? super z> fVar) {
            return ((a) create(gVar, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r8.r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                kotlinx.coroutines.flow.g<? super T> gVar = (kotlinx.coroutines.flow.g) this.L$0;
                g<S, T> gVar2 = this.this$0;
                this.label = 1;
                if (gVar2.m(gVar, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    protected abstract Object m(kotlinx.coroutines.flow.g<? super T> gVar, v8.f<? super z> fVar);

    static /* synthetic */ <S, T> Object j(g<S, T> gVar, kotlinx.coroutines.flow.g<? super T> gVar2, v8.f<? super z> fVar) {
        if (gVar.capacity == -3) {
            v8.j context = fVar.getContext();
            v8.j jVarE = h0.e(context, gVar.context);
            if (kotlin.jvm.internal.m.a(jVarE, context)) {
                Object objM = gVar.m(gVar2, fVar);
                return objM == kotlin.coroutines.intrinsics.b.c() ? objM : z.f17874a;
            }
            v8.g.Companion companion = v8.g.INSTANCE;
            if (kotlin.jvm.internal.m.a(jVarE.get(companion), context.get(companion))) {
                Object objL = gVar.l(gVar2, jVarE, fVar);
                return objL == kotlin.coroutines.intrinsics.b.c() ? objL : z.f17874a;
            }
        }
        Object objCollect = super.collect(gVar2, fVar);
        return objCollect == kotlin.coroutines.intrinsics.b.c() ? objCollect : z.f17874a;
    }

    static /* synthetic */ <S, T> Object k(g<S, T> gVar, kotlinx.coroutines.channels.s<? super T> sVar, v8.f<? super z> fVar) {
        Object objM = gVar.m(new t(sVar), fVar);
        return objM == kotlin.coroutines.intrinsics.b.c() ? objM : z.f17874a;
    }

    @Override // kotlinx.coroutines.flow.internal.e
    public String toString() {
        return this.flow + " -> " + super.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(kotlinx.coroutines.flow.f<? extends S> fVar, v8.j jVar, int i10, kotlinx.coroutines.channels.a aVar) {
        super(jVar, i10, aVar);
        this.flow = fVar;
    }

    private final Object l(kotlinx.coroutines.flow.g<? super T> gVar, v8.j jVar, v8.f<? super z> fVar) {
        Object objC = f.c(jVar, f.d(gVar, fVar.getContext()), null, new a(this, null), fVar, 4, null);
        if (objC == kotlin.coroutines.intrinsics.b.c()) {
            return objC;
        }
        return z.f17874a;
    }

    @Override // kotlinx.coroutines.flow.internal.e, kotlinx.coroutines.flow.f
    public Object collect(kotlinx.coroutines.flow.g<? super T> gVar, v8.f<? super z> fVar) {
        return j(this, gVar, fVar);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    protected Object e(kotlinx.coroutines.channels.s<? super T> sVar, v8.f<? super z> fVar) {
        return k(this, sVar, fVar);
    }
}
