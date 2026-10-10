package x1.f1.lb.marquee;

import c9.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.h0;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import org.apache.log4j.Priority;
import org.apache.log4j.helpers.FileWatchdog;
import r8.p;
import r8.r;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import z1.b1.lb.m.extra.marquee.MarqueeInfo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001WB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00120\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b \u0010\u001fJ\u001b\u0010\"\u001a\u00020\u00162\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u0012¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b$\u0010\u0018R\u001c\u0010(\u001a\n &*\u0004\u0018\u00010%0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010'R\u0016\u0010+\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010*R\u0016\u00100\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010*R\u0016\u00105\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R.\u0010;\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020807068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R2\u0010>\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0<07068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010:R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001c0?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010AR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010S\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u00104\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\"\u0010V\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u00104\u001a\u0004\bT\u0010P\"\u0004\bU\u0010R¨\u0006X"}, d2 = {"Lx1/f1/lb/marquee/a;", "", "<init>", "()V", "", "now", "", "q", "(J)Z", IjkMediaMeta.IJKM_KEY_TRACK_ID, "", "seq", "", "content", "Lz1/b1/lb/m/extra/marquee/MarqueeInfo;", "p", "(JILjava/lang/String;)Lz1/b1/lb/m/extra/marquee/MarqueeInfo;", "Lkotlinx/coroutines/flow/f;", "", "r", "()Lkotlinx/coroutines/flow/f;", "intervalMS", "Lr8/z;", "x", "(J)V", "b", "t", "(Z)V", "Lx1/f1/lb/marquee/a$a;", "listener", "n", "(Lx1/f1/lb/marquee/a$a;)Z", "s", "contents", "w", "(Ljava/util/List;)V", "o", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "c", "J", "updateTime", "d", "updateInterval", "e", "Z", "isAlternatelyDisplay", "f", "requestTime", "g", "I", "retryInterval", "", "Lr8/p;", "Ljava/util/concurrent/atomic/AtomicInteger;", "h", "Ljava/util/Map;", "toDisplayMarqueeMap", "", "i", "marqueeLastDisplayTime", "", "j", "Ljava/util/List;", "marqueeListeners", "Ljava/util/concurrent/atomic/AtomicBoolean;", "k", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInDoing", "l", "list", "m", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getDisplayInterval", "()I", "u", "(I)V", "displayInterval", "getDisplayTimes", "v", "displayTimes", "a", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long updateTime;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long updateInterval;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean isAlternatelyDisplay;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long requestTime;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static int retryInterval;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static Map<Long, p<MarqueeInfo, AtomicInteger>> toDisplayMarqueeMap;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static final Map<Long, p<Long, Set<Integer>>> marqueeLastDisplayTime;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static final List<InterfaceC0417a> marqueeListeners;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean isInDoing;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static List<? extends MarqueeInfo> list;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static String content;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private static int displayInterval;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private static int displayTimes;

    /* JADX INFO: renamed from: x1.f1.lb.marquee.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lx1/f1/lb/marquee/a$a;", "", "", "content", "", "a", "(Ljava/lang/String;)Z", "isRunning", "()Z", "stop", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface InterfaceC0417a {
        boolean a(String content);

        boolean isRunning();

        boolean stop();
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "x1.f1.lb.marquee.MarqueeManager$checkAndUpdate$1", f = "MarqueeManager.kt", l = {116}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends l implements c9.p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ long $now;
        Object L$0;
        int label;

        /* JADX INFO: renamed from: x1.f1.lb.marquee.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @f(c = "x1.f1.lb.marquee.MarqueeManager$checkAndUpdate$1$1", f = "MarqueeManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Lz1/b1/lb/m/extra/marquee/MarqueeInfo;", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class C0418a extends l implements q<g<? super List<? extends MarqueeInfo>>, Throwable, v8.f<? super z>, Object> {
            /* synthetic */ Object L$0;
            int label;

            C0418a(v8.f<? super C0418a> fVar) {
                super(3, fVar);
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(g<? super List<? extends MarqueeInfo>> gVar, Throwable th, v8.f<? super z> fVar) {
                C0418a c0418a = new C0418a(fVar);
                c0418a.L$0 = th;
                return c0418a.invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r.b(obj);
                    Throwable th = (Throwable) this.L$0;
                    a.logger.a("global_marquee, query marquee info failure, will retry after " + a.retryInterval + " ms", th);
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: x1.f1.lb.marquee.a$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class C0419b<T> implements g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f20753a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ b0<Boolean> f20754b;

            C0419b(long j10, b0<Boolean> b0Var) {
                this.f20753a = j10;
                this.f20754b = b0Var;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(List<? extends MarqueeInfo> list, v8.f<? super z> fVar) {
                p pVar;
                MarqueeInfo marqueeInfo;
                AtomicInteger atomicInteger;
                a aVar = a.f20738a;
                a.updateTime = this.f20753a;
                HashSet hashSet = new HashSet();
                int i10 = 0;
                for (MarqueeInfo marqueeInfo2 : list) {
                    if (a.toDisplayMarqueeMap.containsKey(kotlin.coroutines.jvm.internal.b.c(marqueeInfo2.getId()))) {
                        hashSet.add(kotlin.coroutines.jvm.internal.b.c(marqueeInfo2.getId()));
                    } else {
                        a.toDisplayMarqueeMap.put(kotlin.coroutines.jvm.internal.b.c(marqueeInfo2.getId()), new p(marqueeInfo2, new AtomicInteger(0)));
                        i10++;
                    }
                }
                Iterator it = a.toDisplayMarqueeMap.keySet().iterator();
                int i11 = 0;
                while (it.hasNext()) {
                    long jLongValue = ((Number) it.next()).longValue();
                    if (!hashSet.contains(kotlin.coroutines.jvm.internal.b.c(jLongValue)) && (pVar = (p) a.toDisplayMarqueeMap.get(kotlin.coroutines.jvm.internal.b.c(jLongValue))) != null && (marqueeInfo = (MarqueeInfo) pVar.c()) != null) {
                        p pVar2 = (p) a.toDisplayMarqueeMap.get(kotlin.coroutines.jvm.internal.b.c(jLongValue));
                        if (((pVar2 == null || (atomicInteger = (AtomicInteger) pVar2.d()) == null) ? 0 : atomicInteger.get()) >= marqueeInfo.getDisplayTimes()) {
                            a.toDisplayMarqueeMap.remove(kotlin.coroutines.jvm.internal.b.c(marqueeInfo.getId()));
                            i11++;
                        }
                    }
                }
                if (x1.f1.lb.config.b.f20643a.t()) {
                    a.logger.debug("global_marquee query complete, got " + i10 + ", del " + i11, new Object[0]);
                }
                if (i10 > 0 || i11 > 0) {
                    this.f20754b.element = null;
                }
                return z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j10, v8.f<? super b> fVar) {
            super(2, fVar);
            this.$now = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new b(this.$now, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((b) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Type inference failed for: r1v14, types: [T, java.lang.Boolean] */
        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            b0 b0Var;
            b0 b0Var2;
            Throwable th;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    b0Var2 = (b0) this.L$0;
                    try {
                        r.b(obj);
                        b0Var = b0Var2;
                    } catch (Throwable th2) {
                        th = th2;
                        m.a(b0Var2.element, kotlin.coroutines.jvm.internal.b.a(true));
                        a.isInDoing.compareAndSet(true, false);
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r.b(obj);
                b0Var = new b0();
                if (!a.marqueeListeners.isEmpty()) {
                    b0Var.element = kotlin.coroutines.jvm.internal.b.a(a.f20738a.q(this.$now));
                }
                try {
                    if (a.updateTime + a.updateInterval < this.$now) {
                        long j10 = a.requestTime + ((long) a.retryInterval);
                        long j11 = this.$now;
                        if (j10 <= j11) {
                            a.requestTime = j11;
                            kotlinx.coroutines.flow.f fVarF = h.f(a.f20738a.r(), new C0418a(null));
                            C0419b c0419b = new C0419b(this.$now, b0Var);
                            this.L$0 = b0Var;
                            this.label = 1;
                            if (fVarF.collect(c0419b, this) == objC) {
                                return objC;
                            }
                            b0Var2 = b0Var;
                            b0Var = b0Var2;
                        } else {
                            z zVar = z.f17874a;
                            m.a(b0Var.element, kotlin.coroutines.jvm.internal.b.a(true));
                            a.isInDoing.compareAndSet(true, false);
                            return zVar;
                        }
                    }
                } catch (Throwable th3) {
                    b0Var2 = b0Var;
                    th = th3;
                    m.a(b0Var2.element, kotlin.coroutines.jvm.internal.b.a(true));
                    a.isInDoing.compareAndSet(true, false);
                    throw th;
                }
            }
            m.a(b0Var.element, kotlin.coroutines.jvm.internal.b.a(true));
            a.isInDoing.compareAndSet(true, false);
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "x1.f1.lb.marquee.MarqueeManager$queryMarqueeInfo$1", f = "MarqueeManager.kt", l = {344}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Lz1/b1/lb/m/extra/marquee/MarqueeInfo;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class c extends l implements c9.p<g<? super List<? extends MarqueeInfo>>, v8.f<? super z>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        c(v8.f<? super c> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            c cVar = new c(fVar);
            cVar.L$0 = obj;
            return cVar;
        }

        @Override // c9.p
        public final Object invoke(g<? super List<? extends MarqueeInfo>> gVar, v8.f<? super z> fVar) {
            return ((c) create(gVar, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r.b(obj);
                g gVar = (g) this.L$0;
                List list = a.list;
                this.label = 1;
                if (gVar.emit(list, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean q(long now) {
        Map.Entry entryFirstEntry;
        AtomicInteger atomicIntegerD;
        Map.Entry entryFirstEntry2;
        TreeMap treeMap;
        Map.Entry entryFirstEntry3;
        TreeMap treeMap2;
        synchronized (this) {
            try {
                List list2 = null;
                boolean z10 = false;
                TreeMap treeMap3 = null;
                TreeMap treeMap4 = null;
                int i10 = 0;
                for (Map.Entry<Long, p<MarqueeInfo, AtomicInteger>> entry : toDisplayMarqueeMap.entrySet()) {
                    long jLongValue = entry.getKey().longValue();
                    MarqueeInfo marqueeInfoC = entry.getValue().c();
                    int i11 = entry.getValue().d().get();
                    if (i11 >= marqueeInfoC.getDisplayTimes()) {
                        i10++;
                    } else {
                        Map<Long, p<Long, Set<Integer>>> map = marqueeLastDisplayTime;
                        p<Long, Set<Integer>> pVar = map.get(Long.valueOf(jLongValue));
                        if ((pVar != null ? pVar.c().longValue() : 0L) + ((long) marqueeInfoC.getDisplayInterval()) > now) {
                            p<Long, Set<Integer>> pVar2 = map.get(Long.valueOf(jLongValue));
                            Set<Integer> setD = pVar2 != null ? pVar2.d() : null;
                            ArrayList arrayList = new ArrayList();
                            if (setD != null) {
                                Iterator<InterfaceC0417a> it = marqueeListeners.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        InterfaceC0417a next = it.next();
                                        int iHashCode = next.hashCode();
                                        arrayList.add(Integer.valueOf(iHashCode));
                                        if (setD.contains(Integer.valueOf(iHashCode)) && next.isRunning()) {
                                            if (x1.f1.lb.config.b.f20643a.t()) {
                                                logger.debug("global_marquee in running" + setD + " current" + arrayList + " \"" + marqueeInfoC.getContent() + "\" " + i11 + "/" + marqueeInfoC.getDisplayTimes(), new Object[0]);
                                            }
                                        }
                                    }
                                }
                            }
                            HashSet hashSet = new HashSet();
                            for (InterfaceC0417a interfaceC0417a : marqueeListeners) {
                                String content2 = marqueeInfoC.getContent();
                                m.e(content2, "getContent(...)");
                                if (interfaceC0417a.a(content2)) {
                                    hashSet.add(Integer.valueOf(interfaceC0417a.hashCode()));
                                }
                            }
                            if (!hashSet.isEmpty()) {
                                marqueeLastDisplayTime.put(Long.valueOf(marqueeInfoC.getId()), new p<>(Long.valueOf(now), hashSet));
                                if (x1.f1.lb.config.b.f20643a.t()) {
                                    logger.debug("global_marquee restart " + hashSet + " \"" + marqueeInfoC.getContent() + "\" " + i11 + "/" + marqueeInfoC.getDisplayTimes(), new Object[0]);
                                }
                                return true;
                            }
                        }
                        if (isAlternatelyDisplay) {
                            if (treeMap4 == null) {
                                treeMap4 = new TreeMap();
                            }
                            treeMap2 = (TreeMap) treeMap4.get(Integer.valueOf(i11));
                            if (treeMap2 == null) {
                                treeMap2 = new TreeMap();
                                treeMap4.put(Integer.valueOf(i11), treeMap2);
                            }
                        } else {
                            if (treeMap3 == null) {
                                treeMap3 = new TreeMap();
                            }
                            treeMap2 = treeMap3;
                        }
                        List arrayList2 = (List) treeMap2.get(Integer.valueOf(marqueeInfoC.getSeq()));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                            treeMap2.put(Integer.valueOf(marqueeInfoC.getSeq()), arrayList2);
                        }
                        arrayList2.add(marqueeInfoC);
                    }
                }
                if (i10 >= toDisplayMarqueeMap.size()) {
                    for (InterfaceC0417a interfaceC0417a2 : marqueeListeners) {
                        if (interfaceC0417a2.stop() && x1.f1.lb.config.b.f20643a.t()) {
                            logger.debug("global_marquee stop[" + interfaceC0417a2.getClass().getSimpleName() + "]", new Object[0]);
                        }
                    }
                    return false;
                }
                if (isAlternatelyDisplay) {
                    if (treeMap4 != null && (entryFirstEntry2 = treeMap4.firstEntry()) != null && (treeMap = (TreeMap) entryFirstEntry2.getValue()) != null && (entryFirstEntry3 = treeMap.firstEntry()) != null) {
                        list2 = (List) entryFirstEntry3.getValue();
                    }
                } else if (treeMap3 != null && (entryFirstEntry = treeMap3.firstEntry()) != null) {
                    list2 = (List) entryFirstEntry.getValue();
                }
                if (list2 == null) {
                    return false;
                }
                MarqueeInfo marqueeInfo = (MarqueeInfo) list2.get(0);
                HashSet hashSet2 = new HashSet();
                for (InterfaceC0417a interfaceC0417a3 : marqueeListeners) {
                    String content3 = marqueeInfo.getContent();
                    m.e(content3, "getContent(...)");
                    if (interfaceC0417a3.a(content3)) {
                        hashSet2.add(Integer.valueOf(interfaceC0417a3.hashCode()));
                    }
                }
                if (!hashSet2.isEmpty()) {
                    marqueeLastDisplayTime.put(Long.valueOf(marqueeInfo.getId()), new p<>(Long.valueOf(now), hashSet2));
                    p<MarqueeInfo, AtomicInteger> pVar3 = toDisplayMarqueeMap.get(Long.valueOf(marqueeInfo.getId()));
                    int iIncrementAndGet = (pVar3 == null || (atomicIntegerD = pVar3.d()) == null) ? 0 : atomicIntegerD.incrementAndGet();
                    if (x1.f1.lb.config.b.f20643a.t()) {
                        logger.debug("global_marquee start " + hashSet2 + " \"" + marqueeInfo.getContent() + "\" " + iIncrementAndGet + "/" + marqueeInfo.getDisplayTimes(), new Object[0]);
                    }
                    z10 = true;
                }
                return z10;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean n(InterfaceC0417a listener) {
        boolean zAdd;
        if (listener == null) {
            return false;
        }
        List<InterfaceC0417a> list2 = marqueeListeners;
        if (list2.contains(listener)) {
            return false;
        }
        synchronized (this) {
            zAdd = list2.add(listener);
        }
        return zAdd;
    }

    public final boolean s(InterfaceC0417a listener) {
        boolean zRemove;
        synchronized (this) {
            zRemove = h0.a(marqueeListeners).remove(listener);
        }
        return zRemove;
    }

    static {
        a aVar = new a();
        f20738a = aVar;
        logger = q6.c.d(aVar.getClass());
        updateInterval = 43200000L;
        isAlternatelyDisplay = true;
        retryInterval = Priority.WARN_INT;
        toDisplayMarqueeMap = new HashMap();
        marqueeLastDisplayTime = new HashMap();
        List<InterfaceC0417a> listSynchronizedList = Collections.synchronizedList(new ArrayList());
        m.e(listSynchronizedList, "synchronizedList(...)");
        marqueeListeners = listSynchronizedList;
        isInDoing = new AtomicBoolean(false);
        list = kotlin.collections.r.l();
        content = "";
        displayInterval = 6000;
        displayTimes = 3;
    }

    private final MarqueeInfo p(long id2, int seq, String content2) {
        MarqueeInfo marqueeInfo = new MarqueeInfo();
        marqueeInfo.setDisplayTimes(displayTimes);
        marqueeInfo.setSeq(seq);
        marqueeInfo.setId(id2);
        marqueeInfo.setDisplayInterval(displayInterval);
        marqueeInfo.setLang("pt");
        marqueeInfo.setContent(content2);
        return marqueeInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlinx.coroutines.flow.f<List<MarqueeInfo>> r() {
        return h.v(new c(null));
    }

    public final void o(long now) {
        if (isInDoing.compareAndSet(false, true)) {
            j.d(m0.a(a1.b()), null, null, new b(now, null), 3, null);
        }
    }

    public final void t(boolean b10) {
        isAlternatelyDisplay = b10;
    }

    public final void u(int i10) {
        displayInterval = i10;
    }

    public final void v(int i10) {
        displayTimes = i10;
    }

    public final void w(List<String> contents) {
        m.f(contents, "contents");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = contents.iterator();
        long j10 = 0;
        int i10 = 0;
        while (it.hasNext()) {
            arrayList.add(p(j10, i10, (String) it.next()));
            i10++;
            j10 = 1 + j10;
        }
        list = arrayList;
    }

    private a() {
    }

    public final void x(long intervalMS) {
        if (intervalMS > FileWatchdog.DEFAULT_DELAY) {
            updateInterval = intervalMS;
        }
    }
}
