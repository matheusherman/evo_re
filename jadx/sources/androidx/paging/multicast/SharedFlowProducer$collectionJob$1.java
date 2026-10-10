package androidx.paging.multicast;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import c9.q;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.channels.o;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.l0;
import r8.r;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@f(c = "androidx.paging.multicast.SharedFlowProducer$collectionJob$1", f = "SharedFlowProducer.kt", l = {97}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/l0;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class SharedFlowProducer$collectionJob$1 extends l implements p<l0, v8.f<? super z>, Object> {
    int label;
    final /* synthetic */ SharedFlowProducer this$0;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.paging.multicast.SharedFlowProducer$collectionJob$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.multicast.SharedFlowProducer$collectionJob$1$1", f = "SharedFlowProducer.kt", l = {50}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/g;", "", "it", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1<T> extends l implements q<g<? super T>, Throwable, v8.f<? super z>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(v8.f fVar) {
            super(3, fVar);
        }

        public final v8.f<z> create(g<? super T> create, Throwable it, v8.f<? super z> continuation) {
            m.f(create, "$this$create");
            m.f(it, "it");
            m.f(continuation, "continuation");
            AnonymousClass1 anonymousClass1 = SharedFlowProducer$collectionJob$1.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = it;
            return anonymousClass1;
        }

        @Override // c9.q
        public final Object invoke(Object obj, Throwable th, v8.f<? super z> fVar) {
            return ((AnonymousClass1) create((g) obj, th, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r.b(obj);
                Throwable th = (Throwable) this.L$0;
                p pVar = SharedFlowProducer$collectionJob$1.this.this$0.sendUpsteamMessage;
                ChannelManager.Message.Dispatch.Error error = new ChannelManager.Message.Dispatch.Error(th);
                this.label = 1;
                if (pVar.invoke(error, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SharedFlowProducer$collectionJob$1(SharedFlowProducer sharedFlowProducer, v8.f fVar) {
        super(2, fVar);
        this.this$0 = sharedFlowProducer;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final v8.f<z> create(Object obj, v8.f<?> completion) {
        m.f(completion, "completion");
        return new SharedFlowProducer$collectionJob$1(this.this$0, completion);
    }

    @Override // c9.p
    public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
        return ((SharedFlowProducer$collectionJob$1) create(l0Var, fVar)).invokeSuspend(z.f17874a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object objC = b.c();
        int i10 = this.label;
        try {
            if (i10 != 0) {
                if (i10 == 1) {
                    r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r.b(obj);
                kotlinx.coroutines.flow.f fVarF = h.f(this.this$0.src, new AnonymousClass1(null));
                SharedFlowProducer$collectionJob$1$invokeSuspend$$inlined$collect$1 sharedFlowProducer$collectionJob$1$invokeSuspend$$inlined$collect$1 = new SharedFlowProducer$collectionJob$1$invokeSuspend$$inlined$collect$1(this);
                this.label = 1;
                if (fVarF.collect(sharedFlowProducer$collectionJob$1$invokeSuspend$$inlined$collect$1, this) == objC) {
                    return objC;
                }
            }
        } catch (o unused) {
        }
        return z.f17874a;
    }
}
