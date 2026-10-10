package x1.f1.lb.host;

import ac.g;
import c9.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import ua.n;
import x1.f1.lb.api.e;
import x1.f1.lb.api.h;
import x1.f1.lb.api.j;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJp\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\u00182\u0010\u0010\u001e\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\"2\u0006\u0010!\u001a\u00020\u0004¢\u0006\u0004\b#\u0010$J\u0013\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%¢\u0006\u0004\b'\u0010(J\u0013\u0010*\u001a\b\u0012\u0004\u0012\u00020)0%¢\u0006\u0004\b*\u0010(J\u0013\u0010,\u001a\b\u0012\u0004\u0012\u00020+0%¢\u0006\u0004\b,\u0010(J\u0013\u0010.\u001a\b\u0012\u0004\u0012\u00020-0%¢\u0006\u0004\b.\u0010(J\u0013\u00100\u001a\b\u0012\u0004\u0012\u00020/0%¢\u0006\u0004\b0\u0010(J\u0013\u00102\u001a\b\u0012\u0004\u0012\u0002010%¢\u0006\u0004\b2\u0010(J\u0013\u00104\u001a\b\u0012\u0004\u0012\u0002030%¢\u0006\u0004\b4\u0010(J\u0013\u00106\u001a\b\u0012\u0004\u0012\u0002050%¢\u0006\u0004\b6\u0010(J\u0013\u00108\u001a\b\u0012\u0004\u0012\u0002070%¢\u0006\u0004\b8\u0010(J\u0013\u0010:\u001a\b\u0012\u0004\u0012\u0002090%¢\u0006\u0004\b:\u0010(R\u001c\u0010>\u001a\n <*\u0004\u0018\u00010;0;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010=R\u001e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010@R<\u0010E\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070Bj\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0007`C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010DRP\u0010H\u001a>\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040Fj\b\u0012\u0004\u0012\u00020\u0004`G0Bj\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040Fj\b\u0012\u0004\u0012\u00020\u0004`G`C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010D¨\u0006I"}, d2 = {"Lx1/f1/lb/host/b;", "", "<init>", "()V", "", "key", "line", "", "old", "n", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Ljava/util/List;", "hostsCachePath", "", "appVersion", "authEndPoint", "adEndPoint", "channelEndPoint", "feedbackEndPoint", "upgradeEndPoint", "messageEndPoint", "metricEndPoint", "streamMediaEndPoint", "imgEndPoint", "sportsEndPoint", "Lr8/z;", "g", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "e", "(Ljava/lang/String;)Ljava/util/List;", "", "properties", "p", "(Ljava/util/Map;)V", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "", "d", "(Ljava/lang/String;)Ljava/util/Set;", "Lx1/f1/lb/host/a;", "Lx1/f1/lb/api/d;", "b", "()Lx1/f1/lb/host/a;", "Lx1/f1/lb/api/h;", "j", "Lx1/f1/lb/api/j;", "l", "Lx1/f1/lb/api/m;", "k", "Lx1/f1/lb/api/f;", "f", "Lx1/f1/lb/api/l;", "m", "Lx1/f1/lb/api/e;", "c", "Lx1/f1/lb/api/n;", "q", "Lx1/f1/lb/api/g;", "h", "Luf/b;", "i", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "Lx1/f1/lb/cache/a;", "Lx1/f1/lb/cache/a;", "hostsCache", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "servers", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "endpoints", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f20720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static x1.f1.lb.cache.a<String> hostsCache;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, List<String>> servers;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, HashSet<String>> endpoints;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "x1.f1.lb.host.ServerProviderUtils", f = "ServerProviderUtils.kt", l = {80}, m = "init")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class a extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        a(v8.f<? super a> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return b.this.g(null, 0, null, null, null, null, null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "x1.f1.lb.host.ServerProviderUtils$updateServer$1", f = "ServerProviderUtils.kt", l = {154, 158}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class c extends l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ Map<String, String> $map;
        final /* synthetic */ Map<?, ?> $properties;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Map<String, String> map, Map<?, ?> map2, v8.f<? super c> fVar) {
            super(2, fVar);
            this.$map = map;
            this.$properties = map2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new c(this.$map, this.$properties, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((c) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0043  */
        /* JADX WARN: Code duplicated, block: B:18:0x005e  */
        /* JADX WARN: Code duplicated, block: B:22:0x0070  */
        /* JADX WARN: Code duplicated, block: B:26:0x0078  */
        /* JADX WARN: Code duplicated, block: B:28:0x0082  */
        /* JADX WARN: Code duplicated, block: B:35:0x0058 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:36:? A[PHI: r6
          PHI (r6v3 java.util.Iterator<java.lang.String>) = 
          (r6v0 java.util.Iterator<java.lang.String>)
          (r6v1 java.util.Iterator<java.lang.String>)
          (r6v1 java.util.Iterator<java.lang.String>)
          (r6v4 java.util.Iterator<java.lang.String>)
         binds: [B:10:0x002f, B:24:0x0075, B:27:0x0080, B:31:0x0091] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:37:? A[LOOP:0: B:11:0x003d->B:37:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0075 -> B:11:0x003d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0080 -> B:11:0x003d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x008e -> B:31:0x0091). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:37:?
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
                int r1 = r7.label
                r2 = 2
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L2f
                if (r1 == r3) goto L21
                if (r1 != r2) goto L19
                java.lang.Object r1 = r7.L$0
                java.util.Iterator r1 = (java.util.Iterator) r1
                r8.r.b(r8)
                r6 = r1
                goto L91
            L19:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L21:
                java.lang.Object r1 = r7.L$2
                java.lang.Object r5 = r7.L$1
                java.lang.String r5 = (java.lang.String) r5
                java.lang.Object r6 = r7.L$0
                java.util.Iterator r6 = (java.util.Iterator) r6
                r8.r.b(r8)
                goto L6d
            L2f:
                r8.r.b(r8)
                java.util.Map<java.lang.String, java.lang.String> r8 = r7.$map
                java.util.Set r8 = r8.keySet()
                java.util.Iterator r8 = r8.iterator()
                r6 = r8
            L3d:
                boolean r8 = r6.hasNext()
                if (r8 == 0) goto L94
                java.lang.Object r8 = r6.next()
                java.lang.String r1 = "next(...)"
                kotlin.jvm.internal.m.e(r8, r1)
                r5 = r8
                java.lang.String r5 = (java.lang.String) r5
                java.util.Map<?, ?> r8 = r7.$properties
                java.lang.Object r1 = r8.get(r5)
                if (r1 != 0) goto L58
                goto L3d
            L58:
                x1.f1.lb.cache.a r8 = x1.f1.lb.host.b.a()
                if (r8 == 0) goto L70
                r7.L$0 = r6
                r7.L$1 = r5
                r7.L$2 = r1
                r7.label = r3
                java.lang.Object r8 = r8.c(r5, r7)
                if (r8 != r0) goto L6d
                goto L90
            L6d:
                java.lang.String r8 = (java.lang.String) r8
                goto L71
            L70:
                r8 = r4
            L71:
                boolean r8 = kotlin.jvm.internal.m.a(r8, r1)
                if (r8 == 0) goto L78
                goto L3d
            L78:
                java.lang.String r8 = r1.toString()
                x1.f1.lb.cache.a r1 = x1.f1.lb.host.b.a()
                if (r1 == 0) goto L3d
                r7.L$0 = r6
                r7.L$1 = r4
                r7.L$2 = r4
                r7.label = r2
                java.lang.Object r8 = r1.f(r5, r8, r7)
                if (r8 != r0) goto L91
            L90:
                return r0
            L91:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                goto L3d
            L94:
                r8.z r8 = r8.z.f17874a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: x1.f1.lb.host.b.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0116  */
    /* JADX WARN: Code duplicated, block: B:19:0x0124  */
    /* JADX WARN: Code duplicated, block: B:20:0x0141  */
    /* JADX WARN: Code duplicated, block: B:23:0x0153 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x0158  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0151 -> B:24:0x0154). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:23:0x0153
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object g(java.lang.String r17, int r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, v8.f<? super r8.z> r29) {
        /*
            Method dump skipped, instruction units count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x1.f1.lb.host.b.g(java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, v8.f):java.lang.Object");
    }

    /* JADX INFO: renamed from: x1.f1.lb.host.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"x1/f1/lb/host/b$b", "Lf3/a;", "", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C0414b extends f3.a<String> {
        C0414b() {
        }
    }

    static {
        b bVar = new b();
        f20720a = bVar;
        logger = q6.c.d(bVar.getClass());
        servers = new HashMap<>();
        endpoints = new HashMap<>();
    }

    private final List<String> n(String key, String line, List<String> old) {
        if (line == null || line.length() == 0) {
            return old == null ? new ArrayList() : old;
        }
        ArrayList arrayList = new ArrayList();
        String[] strArrL = g.l(line, ",");
        m.c(strArrL);
        if (strArrL.length == 0) {
            arrayList.set(0, g.r(line));
        } else {
            Iterator itA = kotlin.jvm.internal.b.a(strArrL);
            while (itA.hasNext()) {
                arrayList.add(g.r((String) itA.next()));
            }
        }
        if (old != null) {
            for (String str : old) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        Iterator it = arrayList.iterator();
        m.e(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            m.e(next, "next(...)");
            String str2 = (String) next;
            HashMap<String, HashSet<String>> map = endpoints;
            HashSet<String> hashSet = map.get(str2);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                map.put(str2, hashSet);
            }
            hashSet.add(key);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ List o(b bVar, String str, String str2, List list, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            list = null;
        }
        return bVar.n(str, str2, list);
    }

    public final x1.f1.lb.host.a<x1.f1.lb.api.d> b() {
        return new x1.f1.lb.host.a<>("ACCOUNT_SERVERS", x1.f1.lb.api.d.class);
    }

    public final x1.f1.lb.host.a<e> c() {
        return new x1.f1.lb.host.a<>("FEEDBACK_SERVERS", e.class);
    }

    public final Set<String> d(String url) {
        m.f(url, "url");
        for (String str : endpoints.keySet()) {
            m.e(str, "next(...)");
            String str2 = str;
            if (n.I(url, str2, false, 2, null)) {
                HashSet<String> hashSet = endpoints.get(str2);
                return hashSet != null ? hashSet : new HashSet();
            }
        }
        return new HashSet();
    }

    public final List<String> e(String key) {
        m.f(key, "key");
        return servers.get(key);
    }

    public final x1.f1.lb.host.a<x1.f1.lb.api.f> f() {
        return new x1.f1.lb.host.a<>("ACCOUNT_SERVERS", x1.f1.lb.api.f.class);
    }

    public final x1.f1.lb.host.a<x1.f1.lb.api.g> h() {
        return new x1.f1.lb.host.a<>("MESSAGE_CENTER_SERVERS", x1.f1.lb.api.g.class);
    }

    public final x1.f1.lb.host.a<uf.b> i() {
        return new x1.f1.lb.host.a<>("APP_METRIC_SERVERS", uf.b.class);
    }

    public final x1.f1.lb.host.a<h> j() {
        return new x1.f1.lb.host.a<>("ACCOUNT_SERVERS", h.class);
    }

    public final x1.f1.lb.host.a<x1.f1.lb.api.m> k() {
        return new x1.f1.lb.host.a<>("ACCOUNT_SERVERS", x1.f1.lb.api.m.class);
    }

    public final x1.f1.lb.host.a<j> l() {
        return new x1.f1.lb.host.a<>("SPORTS_SERVERS", j.class);
    }

    public final x1.f1.lb.host.a<x1.f1.lb.api.l> m() {
        return new x1.f1.lb.host.a<>("STREAM_META_SERVERS", x1.f1.lb.api.l.class);
    }

    public final void p(Map<?, ?> properties) {
        if (properties == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : servers.keySet()) {
            m.e(str, "next(...)");
            String str2 = str;
            Object obj = properties.get(str2);
            if (obj != null) {
                String string = obj.toString();
                HashMap<String, List<String>> map = servers;
                List<String> list = map.get(str2);
                List<String> listN = n(str2, string, list);
                if (m.a(listN, list)) {
                    break;
                }
                linkedHashMap.put(str2, string);
                map.put(str2, listN);
                if (x1.f1.lb.config.b.f20643a.t()) {
                    logger.debug("update " + str2 + " server:" + list + " -> " + listN, new Object[0]);
                }
            }
        }
        if (linkedHashMap.isEmpty()) {
            return;
        }
        kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new c(linkedHashMap, properties, null), 3, null);
    }

    public final x1.f1.lb.host.a<x1.f1.lb.api.n> q() {
        return new x1.f1.lb.host.a<>("UPGRADE_SERVERS", x1.f1.lb.api.n.class);
    }

    private b() {
    }
}
