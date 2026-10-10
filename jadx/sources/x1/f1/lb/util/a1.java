package x1.f1.lb.util;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR,\u0010 \u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00060\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR,\u0010\"\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00060\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010$¨\u0006&"}, d2 = {"Lx1/f1/lb/util/a1;", "", "<init>", "()V", "", "statKey", "Ljava/util/concurrent/ConcurrentSkipListMap;", "", "map", "Lr8/z;", "k", "(Ljava/lang/String;Ljava/util/concurrent/ConcurrentSkipListMap;)V", "step", "f", "(Ljava/lang/String;)V", "session", "j", "(J)V", "", "isFinal", "e", "(JLjava/lang/String;Z)V", "g", "(Ljava/lang/String;Ljava/lang/String;Z)V", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "Ljava/util/concurrent/ConcurrentHashMap;", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "statMap", "d", "playMap", "Lkotlinx/coroutines/sync/a;", "Lkotlinx/coroutines/sync/a;", "mutex", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a1 f21305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, ConcurrentSkipListMap<Long, String>> statMap;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<Long, ConcurrentSkipListMap<Long, String>> playMap;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final kotlinx.coroutines.sync.a mutex;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.util.StartStatUtil$addStep$1", f = "StartStatUtil.kt", l = {129}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ boolean $isFinal;
        final /* synthetic */ long $session;
        final /* synthetic */ String $step;
        long J$0;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j10, String str, boolean z10, v8.f<? super a> fVar) {
            super(2, fVar);
            this.$session = j10;
            this.$step = str;
            this.$isFinal = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new a(this.$session, this.$step, this.$isFinal, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0088  */
        /* JADX WARN: Code duplicated, block: B:27:0x009b  */
        /* JADX WARN: Instruction removed from duplicated block: B:27:0x009b, please report this as an issue */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v11, types: [T, java.lang.Object, java.util.concurrent.ConcurrentSkipListMap] */
        /* JADX WARN: Type inference failed for: r8v2, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v9, types: [T, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.jvm.internal.b0 b0Var;
            kotlinx.coroutines.sync.a aVar;
            long j10;
            ConcurrentSkipListMap concurrentSkipListMap;
            boolean z10;
            long j11;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            try {
                if (i10 != 0) {
                    if (i10 == 1) {
                        j10 = this.J$0;
                        aVar = (kotlinx.coroutines.sync.a) this.L$1;
                        b0Var = (kotlin.jvm.internal.b0) this.L$0;
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r8.r.b(obj);
                    b0Var = new kotlin.jvm.internal.b0();
                    ?? r10 = a1.playMap.get(kotlin.coroutines.jvm.internal.b.c(this.$session));
                    b0Var.element = r10;
                    if (r10 == 0) {
                        kotlinx.coroutines.sync.a aVar2 = a1.mutex;
                        long j12 = this.$session;
                        this.L$0 = b0Var;
                        this.L$1 = aVar2;
                        this.J$0 = j12;
                        this.label = 1;
                        if (aVar2.a(null, this) == objC) {
                            return objC;
                        }
                        aVar = aVar2;
                        j10 = j12;
                    }
                    concurrentSkipListMap = (ConcurrentSkipListMap) b0Var.element;
                    if (concurrentSkipListMap != null) {
                        String str = this.$step;
                        z10 = this.$isFinal;
                        j11 = this.$session;
                        concurrentSkipListMap.put(kotlin.coroutines.jvm.internal.b.c(d1.c()), str);
                        if (z10) {
                            a1.f21305a.k("PlayZappingTimeStat[" + j11 + "]", concurrentSkipListMap);
                            concurrentSkipListMap.clear();
                        }
                    }
                    return r8.z.f17874a;
                }
                ?? r11 = a1.playMap.get(kotlin.coroutines.jvm.internal.b.c(j10));
                b0Var.element = r11;
                if (r11 == 0) {
                    ?? concurrentSkipListMap2 = new ConcurrentSkipListMap();
                    a1.playMap.put(kotlin.coroutines.jvm.internal.b.c(j10), concurrentSkipListMap2);
                    b0Var.element = concurrentSkipListMap2;
                }
                r8.z zVar = r8.z.f17874a;
                aVar.b(null);
                concurrentSkipListMap = (ConcurrentSkipListMap) b0Var.element;
                if (concurrentSkipListMap != null) {
                    String str2 = this.$step;
                    z10 = this.$isFinal;
                    j11 = this.$session;
                    concurrentSkipListMap.put(kotlin.coroutines.jvm.internal.b.c(d1.c()), str2);
                    if (z10) {
                        a1.f21305a.k("PlayZappingTimeStat[" + j11 + "]", concurrentSkipListMap);
                        concurrentSkipListMap.clear();
                    }
                }
                return r8.z.f17874a;
            } catch (Throwable th) {
                aVar.b(null);
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.util.StartStatUtil$addStep$2", f = "StartStatUtil.kt", l = {129}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ boolean $isFinal;
        final /* synthetic */ String $statKey;
        final /* synthetic */ String $step;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, String str2, boolean z10, v8.f<? super b> fVar) {
            super(2, fVar);
            this.$statKey = str;
            this.$step = str2;
            this.$isFinal = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new b(this.$statKey, this.$step, this.$isFinal, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((b) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x007f  */
        /* JADX WARN: Code duplicated, block: B:27:0x0092  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v11, types: [T, java.lang.Object, java.util.concurrent.ConcurrentSkipListMap] */
        /* JADX WARN: Type inference failed for: r6v8, types: [T, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.jvm.internal.b0 b0Var;
            kotlinx.coroutines.sync.a aVar;
            kotlin.jvm.internal.b0 b0Var2;
            String str;
            ConcurrentSkipListMap concurrentSkipListMap;
            boolean z10;
            String str2;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            try {
                if (i10 != 0) {
                    if (i10 == 1) {
                        str = (String) this.L$2;
                        aVar = (kotlinx.coroutines.sync.a) this.L$1;
                        b0Var2 = (kotlin.jvm.internal.b0) this.L$0;
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r8.r.b(obj);
                    b0Var = new kotlin.jvm.internal.b0();
                    ?? r10 = a1.statMap.get(this.$statKey);
                    b0Var.element = r10;
                    if (r10 == 0) {
                        aVar = a1.mutex;
                        String str3 = this.$statKey;
                        this.L$0 = b0Var;
                        this.L$1 = aVar;
                        this.L$2 = str3;
                        this.label = 1;
                        if (aVar.a(null, this) == objC) {
                            return objC;
                        }
                        b0Var2 = b0Var;
                        str = str3;
                    }
                    concurrentSkipListMap = (ConcurrentSkipListMap) b0Var.element;
                    if (concurrentSkipListMap != null) {
                        String str4 = this.$step;
                        z10 = this.$isFinal;
                        str2 = this.$statKey;
                        concurrentSkipListMap.put(kotlin.coroutines.jvm.internal.b.c(d1.c()), str4);
                        if (z10) {
                            a1.f21305a.k(str2, concurrentSkipListMap);
                            concurrentSkipListMap.clear();
                        }
                    }
                    return r8.z.f17874a;
                }
                ?? r11 = a1.statMap.get(str);
                b0Var2.element = r11;
                if (r11 == 0) {
                    ?? concurrentSkipListMap2 = new ConcurrentSkipListMap();
                    a1.statMap.put(str, concurrentSkipListMap2);
                    b0Var2.element = concurrentSkipListMap2;
                }
                r8.z zVar = r8.z.f17874a;
                aVar.b(null);
                b0Var = b0Var2;
                concurrentSkipListMap = (ConcurrentSkipListMap) b0Var.element;
                if (concurrentSkipListMap != null) {
                    String str5 = this.$step;
                    z10 = this.$isFinal;
                    str2 = this.$statKey;
                    concurrentSkipListMap.put(kotlin.coroutines.jvm.internal.b.c(d1.c()), str5);
                    if (z10) {
                        a1.f21305a.k(str2, concurrentSkipListMap);
                        concurrentSkipListMap.clear();
                    }
                }
                return r8.z.f17874a;
            } catch (Throwable th) {
                aVar.b(null);
                throw th;
            }
        }
    }

    static {
        a1 a1Var = new a1();
        f21305a = a1Var;
        logger = q6.c.d(a1Var.getClass());
        statMap = new ConcurrentHashMap<>();
        playMap = new ConcurrentHashMap<>();
        mutex = kotlinx.coroutines.sync.c.b(false, 1, null);
    }

    public static /* synthetic */ void h(a1 a1Var, long j10, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        a1Var.e(j10, str, z10);
    }

    public static /* synthetic */ void i(a1 a1Var, String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        a1Var.g(str, str2, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(String statKey, ConcurrentSkipListMap<Long, String> map) {
        long j10;
        if (x1.f1.lb.config.b.f20643a.t()) {
            StringBuilder sb2 = new StringBuilder();
            long j11 = 0;
            long j12 = 0;
            long j13 = 0;
            for (Map.Entry<Long, String> entry : map.entrySet()) {
                kotlin.jvm.internal.m.e(entry, "next(...)");
                Map.Entry<Long, String> entry2 = entry;
                Long key = entry2.getKey();
                kotlin.jvm.internal.m.e(key, "<get-key>(...)");
                long jLongValue = key.longValue();
                if (j12 > j11) {
                    j10 = jLongValue - j12;
                    j13 += j10;
                } else {
                    j10 = j11;
                }
                kotlin.jvm.internal.g0 g0Var = kotlin.jvm.internal.g0.f12340a;
                long j14 = 1000;
                String str = String.format("%06d ", Arrays.copyOf(new Object[]{Long.valueOf(j13 / j14)}, 1));
                kotlin.jvm.internal.m.e(str, "format(...)");
                sb2.append(str);
                String str2 = String.format("% 4d", Arrays.copyOf(new Object[]{Long.valueOf(j10 / j14)}, 1));
                kotlin.jvm.internal.m.e(str2, "format(...)");
                sb2.append(str2);
                sb2.append(": (@");
                sb2.append(n.n().h(10, jLongValue));
                sb2.append(") ");
                sb2.append(entry2.getValue());
                sb2.append("\n");
                j12 = jLongValue;
                j11 = 0;
            }
            logger.debug(statKey + ":\n{}", sb2.toString());
        }
    }

    public final void e(long session, String step, boolean isFinal) {
        kotlin.jvm.internal.m.f(step, "step");
        if (x1.f1.lb.config.b.f20643a.t()) {
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new a(session, step, isFinal, null), 3, null);
        }
    }

    public final void f(String step) {
        kotlin.jvm.internal.m.f(step, "step");
        g("AppStartTimeStat", step, false);
    }

    public final void g(String statKey, String step, boolean isFinal) {
        kotlin.jvm.internal.m.f(statKey, "statKey");
        kotlin.jvm.internal.m.f(step, "step");
        if (x1.f1.lb.config.b.f20643a.t()) {
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new b(statKey, step, isFinal, null), 3, null);
        }
    }

    public final void j(long session) {
        ConcurrentSkipListMap<Long, String> concurrentSkipListMapRemove = playMap.remove(Long.valueOf(session));
        if (concurrentSkipListMapRemove == null || concurrentSkipListMapRemove.isEmpty()) {
            return;
        }
        k("PlayZappingTimeStat(clear)[" + session + "]", concurrentSkipListMapRemove);
    }

    private a1() {
    }
}
