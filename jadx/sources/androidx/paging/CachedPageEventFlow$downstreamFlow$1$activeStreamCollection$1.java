package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import c9.q;
import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.channels.o;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.u1;
import r8.r;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@f(c = "androidx.paging.CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1", f = "CachedPageEventFlow.kt", l = {295}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/l0;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1 extends l implements p<l0, v8.f<? super z>, Object> {
    final /* synthetic */ u1 $historyCollection;
    final /* synthetic */ kotlin.jvm.internal.z $lastReceivedHistoryIndex;
    final /* synthetic */ TemporaryDownstream $snapshot;
    final /* synthetic */ s $this_channelFlow;
    int label;
    final /* synthetic */ CachedPageEventFlow$downstreamFlow$1 this$0;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.paging.CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1$1", f = "CachedPageEventFlow.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u008a@¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/g;", "Lkotlin/collections/h0;", "Landroidx/paging/PageEvent;", "", "throwable", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1<T> extends l implements q<g<? super IndexedValue<? extends PageEvent<T>>>, Throwable, v8.f<? super z>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(v8.f fVar) {
            super(3, fVar);
        }

        public final v8.f<z> create(g<? super IndexedValue<? extends PageEvent<T>>> create, Throwable throwable, v8.f<? super z> continuation) {
            m.f(create, "$this$create");
            m.f(throwable, "throwable");
            m.f(continuation, "continuation");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = throwable;
            return anonymousClass1;
        }

        @Override // c9.q
        public final Object invoke(Object obj, Throwable th, v8.f<? super z> fVar) {
            return ((AnonymousClass1) create((g) obj, th, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            b.c();
            if (this.label == 0) {
                r.b(obj);
                Throwable th = (Throwable) this.L$0;
                if (th instanceof o) {
                    return z.f17874a;
                }
                throw th;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.paging.CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1$2", f = "CachedPageEventFlow.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u008a@¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/g;", "Lkotlin/collections/h0;", "Landroidx/paging/PageEvent;", "", "it", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass2<T> extends l implements q<g<? super IndexedValue<? extends PageEvent<T>>>, Throwable, v8.f<? super z>, Object> {
        int label;

        AnonymousClass2(v8.f fVar) {
            super(3, fVar);
        }

        public final v8.f<z> create(g<? super IndexedValue<? extends PageEvent<T>>> create, Throwable th, v8.f<? super z> continuation) {
            m.f(create, "$this$create");
            m.f(continuation, "continuation");
            return CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1.this.new AnonymousClass2(continuation);
        }

        @Override // c9.q
        public final Object invoke(Object obj, Throwable th, v8.f<? super z> fVar) {
            return ((AnonymousClass2) create((g) obj, th, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.label == 0) {
                r.b(obj);
                CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1.this.$snapshot.close();
                return z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1(CachedPageEventFlow$downstreamFlow$1 cachedPageEventFlow$downstreamFlow$1, s sVar, TemporaryDownstream temporaryDownstream, u1 u1Var, kotlin.jvm.internal.z zVar, v8.f fVar) {
        super(2, fVar);
        this.this$0 = cachedPageEventFlow$downstreamFlow$1;
        this.$this_channelFlow = sVar;
        this.$snapshot = temporaryDownstream;
        this.$historyCollection = u1Var;
        this.$lastReceivedHistoryIndex = zVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final v8.f<z> create(Object obj, v8.f<?> completion) {
        m.f(completion, "completion");
        return new CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1(this.this$0, this.$this_channelFlow, this.$snapshot, this.$historyCollection, this.$lastReceivedHistoryIndex, completion);
    }

    @Override // c9.p
    public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
        return ((CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1) create(l0Var, fVar)).invokeSuspend(z.f17874a);
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
            kotlinx.coroutines.flow.f fVarB = h.B(h.f(this.this$0.this$0.multicastedSrc.getFlow(), new AnonymousClass1(null)), new AnonymousClass2(null));
            CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1$invokeSuspend$$inlined$collect$1 cachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1$invokeSuspend$$inlined$collect$1 = new CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1$invokeSuspend$$inlined$collect$1(this);
            this.label = 1;
            if (fVarB.collect(cachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1$invokeSuspend$$inlined$collect$1, this) == objC) {
                return objC;
            }
        }
        return z.f17874a;
    }
}
