package x1.f1.lb.media;

import c9.p;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.r;
import r8.z;
import x1.f1.lb.util.d1;
import x1.f1.lb.util.w0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0019\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010 R \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010 ¨\u0006#"}, d2 = {"Lx1/f1/lb/media/e;", "", "<init>", "()V", "Lr8/z;", "h", "g", "", "streamId", "", "f", "(Ljava/lang/String;)J", "timeMs", "d", "(Ljava/lang/String;J)V", "mediaId", "", "mediaPrivilegeType", "Lqf/b;", "e", "(Ljava/lang/String;Ljava/lang/Integer;)Lqf/b;", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "Lcom/google/gson/e;", "c", "Lcom/google/gson/e;", "gson", "", "Ljava/util/concurrent/atomic/AtomicLong;", "Ljava/util/Map;", "playedTimeMap", "playedTimeSavedTimeMap", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f20835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final com.google.gson.e gson;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static Map<String, AtomicLong> playedTimeMap;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, AtomicLong> playedTimeSavedTimeMap;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.MediaPlayManager$loadMediaPlayedTime$1", f = "MediaPlayManager.kt", l = {112, 119}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class a extends kotlin.coroutines.jvm.internal.l implements p<l0, v8.f<? super z>, Object> {
        int label;

        a(v8.f<? super a> fVar) {
            super(2, fVar);
        }

        /* JADX INFO: renamed from: x1.f1.lb.media.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"x1/f1/lb/media/e$a$a", "Lf3/a;", "", "", "Ljava/util/concurrent/atomic/AtomicLong;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C0426a extends f3.a<Map<String, AtomicLong>> {
            C0426a() {
            }
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new a(fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
        
            if (r13 == r0) goto L24;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            a aVar;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            try {
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            r.b(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        r.b(obj);
                        aVar = this;
                    }
                    String str = (String) obj;
                    if (ac.g.f(str)) {
                        return z.f17874a;
                    }
                    Object objO = e.gson.o(str, new C0426a().d());
                    kotlin.jvm.internal.m.e(objO, "fromJson(...)");
                    e.playedTimeMap = (Map) objO;
                    return z.f17874a;
                }
                r.b(obj);
                w0 w0Var = w0.f21452a;
                this.label = 1;
                obj = w0.l(w0Var, "channel_played_date", 0L, this, 2, null);
                aVar = this;
                if (obj == objC) {
                }
                return objC;
                long jLongValue = ((Number) obj).longValue();
                long jD = d1.d();
                if (jD - jLongValue > 86400000) {
                    w0.f21452a.s("channel_played_date", jD);
                    return z.f17874a;
                }
                w0 w0Var2 = w0.f21452a;
                aVar.label = 2;
                obj = w0.o(w0Var2, "channel_played_time", null, aVar, 2, null);
            } catch (Exception e10) {
                e.logger.error("load subscribed channels failure", e10);
            }
        }
    }

    static {
        e eVar = new e();
        f20835a = eVar;
        logger = q6.c.d(eVar.getClass());
        gson = new com.google.gson.e();
        playedTimeMap = new HashMap();
        playedTimeSavedTimeMap = new HashMap();
        eVar.g();
    }

    private final void h() {
        try {
            String strW = gson.w(playedTimeMap);
            w0 w0Var = w0.f21452a;
            kotlin.jvm.internal.m.c(strW);
            w0Var.t("channel_played_time", strW);
        } catch (Exception e10) {
            logger.error("save played time failure", e10);
        }
    }

    public final void d(String streamId, long timeMs) {
        kotlin.jvm.internal.m.f(streamId, "streamId");
        AtomicLong atomicLong = playedTimeMap.get(streamId);
        if (atomicLong == null) {
            playedTimeMap.put(streamId, new AtomicLong(timeMs));
        } else {
            atomicLong.addAndGet(timeMs);
        }
        Map<String, AtomicLong> map = playedTimeSavedTimeMap;
        AtomicLong atomicLong2 = map.get(streamId);
        long jC = d1.c();
        if (jC - (atomicLong2 != null ? atomicLong2.get() : 0L) < 30000) {
            return;
        }
        if (atomicLong2 == null) {
            map.put(streamId, new AtomicLong(jC));
        } else {
            atomicLong2.set(jC);
        }
        h();
    }

    public final qf.b e(String mediaId, Integer mediaPrivilegeType) {
        if (mediaId == null) {
            return qf.b.NO_FREE_NO_TRIAL_TIME;
        }
        x1.f1.lb.user.f fVar = x1.f1.lb.user.f.f21202a;
        boolean zG0 = fVar.G0();
        boolean zN0 = fVar.N0();
        long jF = f(mediaId);
        long jN0 = fVar.n0();
        if (x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("trialOf [" + mediaId + "] detail: [" + zG0 + ", " + zN0 + ", " + jF + " / " + jN0 + "]", new Object[0]);
        }
        if (zG0 && !zN0) {
            return qf.b.SUBSCRIBED;
        }
        if ((mediaPrivilegeType != null && mediaPrivilegeType.intValue() == 3) || (mediaPrivilegeType != null && mediaPrivilegeType.intValue() == 2)) {
            return qf.b.FREE;
        }
        return (!(zN0 && zG0) && jF >= jN0) ? qf.b.NO_FREE_NO_TRIAL_TIME : qf.b.NO_FREE_BUT_HAS_TRIAL_TIME;
    }

    public final long f(String streamId) {
        kotlin.jvm.internal.m.f(streamId, "streamId");
        AtomicLong atomicLong = playedTimeMap.get(streamId);
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    private e() {
    }

    private final void g() {
        kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new a(null), 3, null);
    }
}
