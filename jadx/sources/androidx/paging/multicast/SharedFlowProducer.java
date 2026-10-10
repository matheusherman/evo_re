package androidx.paging.multicast;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.channels.o;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.u1;
import kotlinx.coroutines.y1;
import r8.r;
import r8.z;
import v8.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BJ\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012(\u0010\u000b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0016R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0017R9\u0010\u000b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00078\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u000b\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Landroidx/paging/multicast/SharedFlowProducer;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/l0;", "scope", "Lkotlinx/coroutines/flow/f;", "src", "Lkotlin/Function2;", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch;", "Lv8/f;", "Lr8/z;", "sendUpsteamMessage", "<init>", "(Lkotlinx/coroutines/l0;Lkotlinx/coroutines/flow/f;Lc9/p;)V", "start", "()V", "cancelAndJoin", "(Lv8/f;)Ljava/lang/Object;", "cancel", "Lkotlinx/coroutines/u1;", "collectionJob", "Lkotlinx/coroutines/u1;", "Lkotlinx/coroutines/l0;", "Lkotlinx/coroutines/flow/f;", "Lc9/p;", "paging-common"}, k = 1, mv = {1, 4, 1})
public final class SharedFlowProducer<T> {
    private final u1 collectionJob;
    private final l0 scope;
    private final p<ChannelManager.Message.Dispatch<T>, f<? super z>, Object> sendUpsteamMessage;
    private final kotlinx.coroutines.flow.f<T> src;

    /* JADX INFO: renamed from: androidx.paging.multicast.SharedFlowProducer$start$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.paging.multicast.SharedFlowProducer$start$1", f = "SharedFlowProducer.kt", l = {75, 80, 80}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/l0;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1 extends l implements p<l0, f<? super z>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(f fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final f<z> create(Object obj, f<?> completion) {
            m.f(completion, "completion");
            return new AnonymousClass1(completion);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, f<? super z> fVar) {
            return ((AnonymousClass1) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
        
            if (r6.invoke(r1, r5) == r0) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
        
            if (r1.invoke(r3, r5) == r0) goto L29;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v2, types: [androidx.paging.multicast.SharedFlowProducer] */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = b.c();
            int i10 = this.label;
            int i11 = 3;
            try {
                try {
                    if (i10 != 0) {
                        if (i10 != 1) {
                            if (i10 != 2) {
                                if (i10 != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                Throwable th = (Throwable) this.L$0;
                                try {
                                    r.b(obj);
                                    throw th;
                                } catch (o unused) {
                                    throw th;
                                }
                            }
                            r.b(obj);
                        } else {
                            r.b(obj);
                        }
                        return z.f17874a;
                    }
                    r.b(obj);
                    u1 u1Var = SharedFlowProducer.this.collectionJob;
                    this.label = 1;
                    if (u1Var.s(this) != objC) {
                    }
                    return objC;
                    p pVar = SharedFlowProducer.this.sendUpsteamMessage;
                    i11 = SharedFlowProducer.this;
                    ChannelManager.Message.Dispatch.UpstreamFinished upstreamFinished = new ChannelManager.Message.Dispatch.UpstreamFinished(i11);
                    this.label = 2;
                } catch (o unused2) {
                }
            } catch (Throwable th2) {
                try {
                    p pVar2 = SharedFlowProducer.this.sendUpsteamMessage;
                    ChannelManager.Message.Dispatch.UpstreamFinished upstreamFinished2 = new ChannelManager.Message.Dispatch.UpstreamFinished(SharedFlowProducer.this);
                    this.L$0 = th2;
                    this.label = i11;
                } catch (o unused3) {
                }
            }
            throw th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SharedFlowProducer(l0 scope, kotlinx.coroutines.flow.f<? extends T> src, p<? super ChannelManager.Message.Dispatch<T>, ? super f<? super z>, ? extends Object> sendUpsteamMessage) {
        m.f(scope, "scope");
        m.f(src, "src");
        m.f(sendUpsteamMessage, "sendUpsteamMessage");
        this.scope = scope;
        this.src = src;
        this.sendUpsteamMessage = sendUpsteamMessage;
        this.collectionJob = j.d(scope, null, n0.LAZY, new SharedFlowProducer$collectionJob$1(this, null), 1, null);
    }

    public final void cancel() {
        u1.a.a(this.collectionJob, null, 1, null);
    }

    public final Object cancelAndJoin(f<? super z> fVar) {
        Object objE = y1.e(this.collectionJob, fVar);
        return objE == b.c() ? objE : z.f17874a;
    }

    public final void start() {
        j.d(this.scope, null, null, new AnonymousClass1(null), 3, null);
    }
}
