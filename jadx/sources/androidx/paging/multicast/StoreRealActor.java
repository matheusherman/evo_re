package androidx.paging.multicast;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import c9.p;
import c9.q;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.channels.d;
import kotlinx.coroutines.channels.v;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;
import r8.r;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000 \u001a*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001aB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\u001b\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\rJ\u0013\u0010\u000f\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Landroidx/paging/multicast/StoreRealActor;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/l0;", "scope", "<init>", "(Lkotlinx/coroutines/l0;)V", "Lr8/z;", "doClose", "()V", "onClosed", NotificationCompat.CATEGORY_MESSAGE, "handle", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "send", "close", "(Lv8/f;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/d;", "inboundChannel", "Lkotlinx/coroutines/channels/d;", "Lkotlinx/coroutines/w;", "closeCompleted", "Lkotlinx/coroutines/w;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "didClose", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Companion", "paging-common"}, k = 1, mv = {1, 4, 1})
public abstract class StoreRealActor<T> {
    private final w<z> closeCompleted;
    private final AtomicBoolean didClose;
    private final d<Object> inboundChannel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Object CLOSE_TOKEN = new Object();

    /* JADX INFO: renamed from: androidx.paging.multicast.StoreRealActor$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.multicast.StoreRealActor$1", f = "StoreRealActor.kt", l = {45}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", NotificationCompat.CATEGORY_MESSAGE, "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1 extends l implements p<Object, v8.f<? super z>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(v8.f fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> completion) {
            m.f(completion, "completion");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(completion);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // c9.p
        public final Object invoke(Object obj, v8.f<? super z> fVar) {
            return ((AnonymousClass1) create(obj, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Multi-variable type inference failed */
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
                Object obj2 = this.L$0;
                if (obj2 == StoreRealActor.INSTANCE.getCLOSE_TOKEN()) {
                    StoreRealActor.this.doClose();
                } else {
                    StoreRealActor storeRealActor = StoreRealActor.this;
                    this.label = 1;
                    if (storeRealActor.handle(obj2, this) == objC) {
                        return objC;
                    }
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.multicast.StoreRealActor$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.multicast.StoreRealActor$2", f = "StoreRealActor.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass2 extends l implements q<g<? super Object>, Throwable, v8.f<? super z>, Object> {
        int label;

        AnonymousClass2(v8.f fVar) {
            super(3, fVar);
        }

        public final v8.f<z> create(g<Object> create, Throwable th, v8.f<? super z> continuation) {
            m.f(create, "$this$create");
            m.f(continuation, "continuation");
            return new AnonymousClass2(continuation);
        }

        @Override // c9.q
        public final Object invoke(g<? super Object> gVar, Throwable th, v8.f<? super z> fVar) {
            return ((AnonymousClass2) create(gVar, th, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.label == 0) {
                r.b(obj);
                StoreRealActor.this.doClose();
                return z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/paging/multicast/StoreRealActor$Companion;", "", "()V", "CLOSE_TOKEN", "getCLOSE_TOKEN", "()Ljava/lang/Object;", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final Object getCLOSE_TOKEN() {
            return StoreRealActor.CLOSE_TOKEN;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.multicast.StoreRealActor$close$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.multicast.StoreRealActor", f = "StoreRealActor.kt", l = {74, 76}, m = "close")
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lv8/f;", "Lr8/z;", "continuation", "", "close", "(Lv8/f;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    static final class C05721 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C05721(v8.f fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StoreRealActor.this.close(this);
        }
    }

    public abstract Object handle(T t10, v8.f<? super z> fVar);

    public StoreRealActor(l0 scope) {
        m.f(scope, "scope");
        d<Object> dVarB = kotlinx.coroutines.channels.g.b(0, null, null, 6, null);
        this.inboundChannel = dVarB;
        this.closeCompleted = y.b(null, 1, null);
        this.didClose = new AtomicBoolean(false);
        h.z(h.B(h.C(h.l(dVarB), new AnonymousClass1(null)), new AnonymousClass2(null)), scope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doClose() {
        if (this.didClose.compareAndSet(false, true)) {
            try {
                onClosed();
            } finally {
                v.a.a(this.inboundChannel, null, 1, null);
                this.closeCompleted.r(z.f17874a);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
    
        if (r6.B(r0) == r1) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object close(v8.f<? super z> fVar) {
        C05721 c05721;
        StoreRealActor<T> storeRealActor;
        if (fVar instanceof C05721) {
            c05721 = (C05721) fVar;
            int i10 = c05721.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c05721.label = i10 - Integer.MIN_VALUE;
            } else {
                c05721 = new C05721(fVar);
            }
        } else {
            c05721 = new C05721(fVar);
        }
        Object obj = c05721.result;
        Object objC = b.c();
        int i11 = c05721.label;
        if (i11 != 0) {
            if (i11 == 1) {
                storeRealActor = (StoreRealActor) c05721.L$0;
                r.b(obj);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r.b(obj);
            }
            return z.f17874a;
        }
        r.b(obj);
        d<Object> dVar = this.inboundChannel;
        Object obj2 = CLOSE_TOKEN;
        c05721.L$0 = this;
        c05721.label = 1;
        if (dVar.b(obj2, c05721) != objC) {
            storeRealActor = this;
        }
        return objC;
        w<z> wVar = storeRealActor.closeCompleted;
        c05721.L$0 = null;
        c05721.label = 2;
    }

    public final Object send(T t10, v8.f<? super z> fVar) {
        Object objB = this.inboundChannel.b(t10, fVar);
        return objB == b.c() ? objB : z.f17874a;
    }

    public void onClosed() {
    }
}
