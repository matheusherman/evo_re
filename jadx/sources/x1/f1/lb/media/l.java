package x1.f1.lb.media;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import c9.q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.channels.v;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import org.apache.log4j.net.SyslogAppender;
import r8.p;
import r8.r;
import r8.z;
import x1.f1.lb.util.d1;
import x1.f1.lb.util.v0;
import x1.f1.lb.util.w0;
import z1.b1.lb.m.meta.MetaDetailResponse;
import z1.b1.lb.m.meta.PlaylistResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002E!B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\t\"\u0004\b\u0000\u0010\u00042\u0018\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00060\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fH\u0082@¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fH\u0082@¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u0003J-\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\t2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010#\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R0\u0010)\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020%0$j\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020%`&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R \u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00110*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R.\u00103\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00110/0.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R.\u00105\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0/0.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00102R.\u00107\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00110/0.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00102R\"\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002000.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00102R\"\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002000.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00102R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010=R\u0016\u0010A\u001a\u00020?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010@R\u0014\u0010D\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010C¨\u0006F"}, d2 = {"Lx1/f1/lb/media/l;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "Lx1/f1/lb/media/l$b;", "Lcom/skydoves/sandwich/a;", "Ln6/b;", "apiCaller", "Lkotlinx/coroutines/flow/f;", "l", "(Lx1/f1/lb/media/l$b;)Lkotlinx/coroutines/flow/f;", "Lr8/z;", "o", "(Lv8/f;)Ljava/lang/Object;", "p", "q", "Lz1/b1/lb/m/meta/MetaDetailResponse;", "detailResponse", "k", "(Lz1/b1/lb/m/meta/MetaDetailResponse;)V", "", "metaId", "j", "(Ljava/lang/String;)Lz1/b1/lb/m/meta/MetaDetailResponse;", "n", "", "pageId", "pageSize", "m", "(Ljava/lang/String;II)Lkotlinx/coroutines/flow/f;", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "Ljava/util/HashMap;", "Lz1/b1/lb/m/meta/PlaylistResponse;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "metaQueryExpressionPlayList", "Lu4/d;", "d", "Lu4/d;", "metaDetailResponseCache", "", "Lr8/p;", "", "e", "Ljava/util/Map;", "favoritesMap", "f", "playEpisodeHist", "g", "historyMap", "h", "playlistCacheUpdateTime", "i", "detailCacheUpdateTime", "Lcom/google/gson/e;", "Lcom/google/gson/e;", "gson", "", "Z", "isCacheLoaded", "Lx1/f1/lb/media/l$a;", "Lx1/f1/lb/media/l$a;", "checksumKeeper", "a", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f20862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, PlaylistResponse> metaQueryExpressionPlayList;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final u4.d<String, MetaDetailResponse> metaDetailResponseCache;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static Map<String, p<Long, MetaDetailResponse>> favoritesMap;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static Map<String, p<Integer, Integer>> playEpisodeHist;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static Map<String, p<Long, MetaDetailResponse>> historyMap;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static Map<String, Long> playlistCacheUpdateTime;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static Map<String, Long> detailCacheUpdateTime;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static final com.google.gson.e gson;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static boolean isCacheLoaded;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static final a checksumKeeper;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0005\u0010\b¨\u0006\n"}, d2 = {"Lx1/f1/lb/media/l$a;", "", "<init>", "()V", "Lr8/z;", "a", "(Lv8/f;)Ljava/lang/Object;", "", "Ljava/lang/String;", "checksumCacheKey", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final String checksumCacheKey = "vod_check_sum_cache";

        public final Object a(v8.f<? super z> fVar) {
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0010\u0010\u0003\u001a\u00028\u0000H¦@¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H¦@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lx1/f1/lb/media/l$b;", ExifInterface.GPS_DIRECTION_TRUE, "", "a", "(Lv8/f;)Ljava/lang/Object;", "", "checksum", "Lr8/z;", "b", "(Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface b<T> {
        Object a(v8.f<? super T> fVar);

        Object b(String str, v8.f<? super z> fVar);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.VoDManager$flow$1", f = "VoDManager.kt", l = {SyslogAppender.LOG_LOCAL7, 186}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/g;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class c<T> extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super T>, v8.f<? super z>, Object> {
        final /* synthetic */ b<com.skydoves.sandwich.a<n6.b<T>>> $apiCaller;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.VoDManager$flow$1$1", f = "VoDManager.kt", l = {188, 189}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Ln6/b;", "Lr8/z;", "<anonymous>", "(Ln6/b;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<n6.b<T>, v8.f<? super z>, Object> {
            final /* synthetic */ kotlinx.coroutines.flow.g<T> $$this$flow;
            final /* synthetic */ b<com.skydoves.sandwich.a<n6.b<T>>> $apiCaller;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(kotlinx.coroutines.flow.g<? super T> gVar, b<com.skydoves.sandwich.a<n6.b<T>>> bVar, v8.f<? super a> fVar) {
                super(2, fVar);
                this.$$this$flow = gVar;
                this.$apiCaller = bVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                a aVar = new a(this.$$this$flow, this.$apiCaller, fVar);
                aVar.L$0 = obj;
                return aVar;
            }

            @Override // c9.p
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(n6.b<T> bVar, v8.f<? super z> fVar) {
                return ((a) create(bVar, fVar)).invokeSuspend(z.f17874a);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type v8.f to x1.f1.lb.media.l$c$a for r5v1 'this'  v8.f
                	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
                	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
                	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
                	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
                	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                */
            @Override // kotlin.coroutines.jvm.internal.a
            public final java.lang.Object invokeSuspend(java.lang.Object r6) {
                /*
                    r5 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
                    int r1 = r5.label
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L22
                    if (r1 == r3) goto L1a
                    if (r1 != r2) goto L12
                    r8.r.b(r6)
                    goto L5b
                L12:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r0)
                    throw r6
                L1a:
                    java.lang.Object r1 = r5.L$0
                    n6.b r1 = (n6.b) r1
                    r8.r.b(r6)
                    goto L49
                L22:
                    r8.r.b(r6)
                    java.lang.Object r6 = r5.L$0
                    r1 = r6
                    n6.b r1 = (n6.b) r1
                    java.lang.String r6 = r1.getCode()
                    java.lang.String r4 = "0"
                    boolean r6 = kotlin.jvm.internal.m.a(r6, r4)
                    if (r6 == 0) goto L5e
                    java.lang.String r6 = r1.c()
                    if (r6 == 0) goto L49
                    x1.f1.lb.media.l$b<com.skydoves.sandwich.a<n6.b<T>>> r4 = r5.$apiCaller
                    r5.L$0 = r1
                    r5.label = r3
                    java.lang.Object r6 = r4.b(r6, r5)
                    if (r6 != r0) goto L49
                    goto L5a
                L49:
                    kotlinx.coroutines.flow.g<T> r6 = r5.$$this$flow
                    java.lang.Object r1 = r1.getData()
                    r3 = 0
                    r5.L$0 = r3
                    r5.label = r2
                    java.lang.Object r6 = r6.emit(r1, r5)
                    if (r6 != r0) goto L5b
                L5a:
                    return r0
                L5b:
                    r8.z r6 = r8.z.f17874a
                    return r6
                L5e:
                    sf.b r6 = new sf.b
                    java.lang.String r0 = r1.getCode()
                    java.lang.String r2 = "getCode(...)"
                    kotlin.jvm.internal.m.e(r0, r2)
                    java.lang.String r1 = r1.d()
                    java.lang.String r2 = "getMsg(...)"
                    kotlin.jvm.internal.m.e(r1, r2)
                    r6.<init>(r0, r1)
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: x1.f1.lb.media.l.c.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(b<com.skydoves.sandwich.a<n6.b<T>>> bVar, v8.f<? super c> fVar) {
            super(2, fVar);
            this.$apiCaller = bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            c cVar = new c(this.$apiCaller, fVar);
            cVar.L$0 = obj;
            return cVar;
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.flow.g<? super T> gVar, v8.f<? super z> fVar) {
            return ((c) create(gVar, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:
        
            if (r7 == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Exception {
            kotlinx.coroutines.flow.g gVar;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    gVar = (kotlinx.coroutines.flow.g) this.L$0;
                    r.b(obj);
                }
                com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
                if (!(aVar instanceof com.skydoves.sandwich.a.b.C0151a)) {
                    if (!(aVar instanceof com.skydoves.sandwich.a.b.C0152b)) {
                        if (!(aVar instanceof com.skydoves.sandwich.a.b)) {
                            return z.f17874a;
                        }
                        throw new Exception(v0.f21450a.c((com.skydoves.sandwich.a.b) aVar));
                    }
                    com.skydoves.sandwich.a.b.C0152b<T> c0152b = (com.skydoves.sandwich.a.b.C0152b) aVar;
                    throw new Exception(v0.f21450a.b(c0152b), c0152b.getException());
                }
                com.skydoves.sandwich.a.b.C0151a<T> c0151a = (com.skydoves.sandwich.a.b.C0151a) aVar;
                throw new sf.a(c0151a.getStatusCode().getCode(), v0.f21450a.a(c0151a));
            }
            r.b(obj);
            gVar = (kotlinx.coroutines.flow.g) this.L$0;
            b<com.skydoves.sandwich.a<n6.b<T>>> bVar = this.$apiCaller;
            this.L$0 = gVar;
            this.label = 1;
            obj = bVar.a(this);
            if (obj != objC) {
            }
            return objC;
            a aVar2 = new a(gVar, this.$apiCaller, null);
            this.L$0 = null;
            this.label = 2;
            obj = com.skydoves.sandwich.c.g((com.skydoves.sandwich.a) obj, aVar2, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.VoDManager$getVideoDetail$1$1", f = "VoDManager.kt", l = {730}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/channels/s;", "Lz1/b1/lb/m/meta/MetaDetailResponse;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/channels/s;)V"}, k = 3, mv = {2, 1, 0})
    static final class d extends kotlin.coroutines.jvm.internal.l implements c9.p<s<? super MetaDetailResponse>, v8.f<? super z>, Object> {
        final /* synthetic */ MetaDetailResponse $detail;
        final /* synthetic */ kotlinx.coroutines.flow.f<MetaDetailResponse> $flow;
        final /* synthetic */ String $key;
        final /* synthetic */ long $now;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.VoDManager$getVideoDetail$1$1$1", f = "VoDManager.kt", l = {716}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
            final /* synthetic */ s<MetaDetailResponse> $$this$callbackFlow;
            final /* synthetic */ MetaDetailResponse $detail;
            final /* synthetic */ kotlinx.coroutines.flow.f<MetaDetailResponse> $flow;
            final /* synthetic */ String $key;
            final /* synthetic */ long $now;
            int label;

            /* JADX INFO: renamed from: x1.f1.lb.media.l$d$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.VoDManager$getVideoDetail$1$1$1$1", f = "VoDManager.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lz1/b1/lb/m/meta/MetaDetailResponse;", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0428a extends kotlin.coroutines.jvm.internal.l implements q<kotlinx.coroutines.flow.g<? super MetaDetailResponse>, Throwable, v8.f<? super z>, Object> {
                final /* synthetic */ s<MetaDetailResponse> $$this$callbackFlow;
                final /* synthetic */ MetaDetailResponse $detail;
                /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C0428a(MetaDetailResponse metaDetailResponse, s<? super MetaDetailResponse> sVar, v8.f<? super C0428a> fVar) {
                    super(3, fVar);
                    this.$detail = metaDetailResponse;
                    this.$$this$callbackFlow = sVar;
                }

                @Override // c9.q
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object invoke(kotlinx.coroutines.flow.g<? super MetaDetailResponse> gVar, Throwable th, v8.f<? super z> fVar) {
                    C0428a c0428a = new C0428a(this.$detail, this.$$this$callbackFlow, fVar);
                    c0428a.L$0 = th;
                    return c0428a.invokeSuspend(z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r.b(obj);
                        Throwable th = (Throwable) this.L$0;
                        l.logger.error("reload [" + this.$detail.getTitle() + "(" + this.$detail.getMetaId() + ")] video detail failure", th);
                        v.a.a(this.$$this$callbackFlow, null, 1, null);
                        return z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            static final class b<T> implements kotlinx.coroutines.flow.g {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ String f20875a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ long f20876b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ MetaDetailResponse f20877c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ s<MetaDetailResponse> f20878d;

                /* JADX WARN: Multi-variable type inference failed */
                b(String str, long j10, MetaDetailResponse metaDetailResponse, s<? super MetaDetailResponse> sVar) {
                    this.f20875a = str;
                    this.f20876b = j10;
                    this.f20877c = metaDetailResponse;
                    this.f20878d = sVar;
                }

                @Override // kotlinx.coroutines.flow.g
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object emit(MetaDetailResponse metaDetailResponse, v8.f<? super z> fVar) {
                    if (metaDetailResponse != null) {
                        l.detailCacheUpdateTime.put(this.f20875a, kotlin.coroutines.jvm.internal.b.c(this.f20876b));
                        if (!kotlin.jvm.internal.m.a(this.f20877c, metaDetailResponse)) {
                            l.logger.a("got [" + this.f20877c.getTitle() + "(" + this.f20877c.getMetaId() + ")] video detail update", new Object[0]);
                            l.f20862a.k(metaDetailResponse);
                            kotlinx.coroutines.channels.k.b(this.f20878d, metaDetailResponse);
                        }
                    }
                    v.a.a(this.f20878d, null, 1, null);
                    return z.f17874a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(kotlinx.coroutines.flow.f<? extends MetaDetailResponse> fVar, MetaDetailResponse metaDetailResponse, s<? super MetaDetailResponse> sVar, String str, long j10, v8.f<? super a> fVar2) {
                super(2, fVar2);
                this.$flow = fVar;
                this.$detail = metaDetailResponse;
                this.$$this$callbackFlow = sVar;
                this.$key = str;
                this.$now = j10;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                return new a(this.$flow, this.$detail, this.$$this$callbackFlow, this.$key, this.$now, fVar);
            }

            @Override // c9.p
            public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                return ((a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
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
                    kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(this.$flow, new C0428a(this.$detail, this.$$this$callbackFlow, null));
                    b bVar = new b(this.$key, this.$now, this.$detail, this.$$this$callbackFlow);
                    this.label = 1;
                    if (fVarF.collect(bVar, this) == objC) {
                        return objC;
                    }
                }
                return z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(MetaDetailResponse metaDetailResponse, kotlinx.coroutines.flow.f<? extends MetaDetailResponse> fVar, String str, long j10, v8.f<? super d> fVar2) {
            super(2, fVar2);
            this.$detail = metaDetailResponse;
            this.$flow = fVar;
            this.$key = str;
            this.$now = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final z c() {
            return z.f17874a;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            d dVar = new d(this.$detail, this.$flow, this.$key, this.$now, fVar);
            dVar.L$0 = obj;
            return dVar;
        }

        @Override // c9.p
        public final Object invoke(s<? super MetaDetailResponse> sVar, v8.f<? super z> fVar) {
            return ((d) create(sVar, fVar)).invokeSuspend(z.f17874a);
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
                s sVar = (s) this.L$0;
                kotlinx.coroutines.channels.k.b(sVar, this.$detail);
                kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new a(this.$flow, this.$detail, sVar, this.$key, this.$now, null), 3, null);
                c9.a aVar = new c9.a() { // from class: x1.f1.lb.media.m
                    @Override // c9.a
                    public final Object invoke() {
                        return l.d.c();
                    }
                };
                this.label = 1;
                if (kotlinx.coroutines.channels.q.a(sVar, aVar, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001J\u001c\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0096@¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"x1/f1/lb/media/l$e", "Lx1/f1/lb/media/l$b;", "Lcom/skydoves/sandwich/a;", "Ln6/b;", "Lz1/b1/lb/m/meta/MetaDetailResponse;", "a", "(Lv8/f;)Ljava/lang/Object;", "", "checksum", "Lr8/z;", "b", "(Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e implements b<com.skydoves.sandwich.a<? extends n6.b<MetaDetailResponse>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f20879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f20880b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f20881c;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.VoDManager$getVideoDetail$flow$1", f = "VoDManager.kt", l = {671}, m = NotificationCompat.CATEGORY_CALL)
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class a extends kotlin.coroutines.jvm.internal.d {
            int label;
            /* synthetic */ Object result;

            a(v8.f<? super a> fVar) {
                super(fVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return e.this.a(this);
            }
        }

        e(String str, int i10, int i11) {
            this.f20879a = str;
            this.f20880b = i10;
            this.f20881c = i11;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0017  */
        @Override // x1.f1.lb.media.l.b
        public Object a(v8.f<? super com.skydoves.sandwich.a<? extends n6.b<MetaDetailResponse>>> fVar) {
            a aVar;
            MetaDetailResponse metaDetailResponse;
            if (fVar instanceof a) {
                aVar = (a) fVar;
                int i10 = aVar.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    aVar.label = i10 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(fVar);
                }
            } else {
                aVar = new a(fVar);
            }
            Object obj = aVar.result;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i11 = aVar.label;
            if (i11 == 0) {
                r.b(obj);
                x1.f1.lb.api.b bVar = x1.f1.lb.api.b.f20552a;
                of.a aVar2 = of.a.f16585a;
                String strValueOf = String.valueOf(aVar2.h());
                String strValueOf2 = String.valueOf(aVar2.a());
                long jI = aVar2.i();
                String strK = aVar2.k();
                String strL = aVar2.l();
                String str = this.f20879a;
                int i12 = this.f20880b;
                int i13 = this.f20881c;
                long jD = d1.d();
                String strG = aVar2.g();
                String strB = aVar2.b();
                aVar.label = 1;
                Object objF = bVar.f(strValueOf, strValueOf2, jI, strK, strL, str, i12, i13, jD, strG, strB, aVar);
                if (objF == objC) {
                    return objC;
                }
                obj = objF;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r.b(obj);
            }
            com.skydoves.sandwich.a aVar3 = (com.skydoves.sandwich.a) obj;
            n6.b bVar2 = (n6.b) com.skydoves.sandwich.b.a(aVar3);
            if (bVar2 != null && (metaDetailResponse = (MetaDetailResponse) bVar2.getData()) != null) {
                l.f20862a.k(metaDetailResponse);
            }
            return aVar3;
        }

        @Override // x1.f1.lb.media.l.b
        public Object b(String str, v8.f<? super z> fVar) {
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.VoDManager$initLocalPlayList$1", f = "VoDManager.kt", l = {TypedValues.PositionType.TYPE_PERCENT_WIDTH}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class f extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.VoDManager$initLocalPlayList$1$1", f = "VoDManager.kt", l = {TypedValues.PositionType.TYPE_TRANSITION_EASING, TypedValues.PositionType.TYPE_DRAWPATH}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements q<kotlinx.coroutines.flow.g<? super String>, Throwable, v8.f<? super z>, Object> {
            /* synthetic */ Object L$0;
            int label;

            a(v8.f<? super a> fVar) {
                super(3, fVar);
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super String> gVar, Throwable th, v8.f<? super z> fVar) {
                a aVar = new a(fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(z.f17874a);
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:
            
                if (r7.o(r6) == r0) goto L15;
             */
            @Override // kotlin.coroutines.jvm.internal.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i10 = this.label;
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            r.b(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        r.b(obj);
                    }
                    return z.f17874a;
                }
                r.b(obj);
                l.logger.error("load cache lang failure", (Throwable) this.L$0);
                l.isCacheLoaded = true;
                l lVar = l.f20862a;
                this.label = 1;
                if (lVar.p(this) != objC) {
                }
                return objC;
                l lVar2 = l.f20862a;
                this.label = 2;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f20882a;

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.VoDManager$initLocalPlayList$1$2", f = "VoDManager.kt", l = {TypedValues.PositionType.TYPE_PERCENT_X, InputDeviceCompat.SOURCE_DPAD, 514}, m = "emit")
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            static final class a extends kotlin.coroutines.jvm.internal.d {
                int label;
                /* synthetic */ Object result;
                final /* synthetic */ b<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                a(b<? super T> bVar, v8.f<? super a> fVar) {
                    super(fVar);
                    this.this$0 = bVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.emit(null, this);
                }
            }

            b(String str) {
                this.f20882a = str;
            }

            /* JADX WARN: Code duplicated, block: B:28:0x0096  */
            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x007f, code lost:
            
                if (r9.a(r0) == r1) goto L30;
             */
            /* JADX WARN: Code restructure failed: missing block: B:29:0x009e, code lost:
            
                if (r9.o(r0) == r1) goto L30;
             */
            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(String str, v8.f<? super z> fVar) {
                a aVar;
                l lVar;
                if (fVar instanceof a) {
                    aVar = (a) fVar;
                    int i10 = aVar.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        aVar.label = i10 - Integer.MIN_VALUE;
                    } else {
                        aVar = new a(this, fVar);
                    }
                } else {
                    aVar = new a(this, fVar);
                }
                Object obj = aVar.result;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i11 = aVar.label;
                if (i11 != 0) {
                    if (i11 == 1) {
                        r.b(obj);
                    } else if (i11 == 2) {
                        r.b(obj);
                        l lVar2 = l.f20862a;
                        aVar.label = 3;
                    } else {
                        if (i11 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        r.b(obj);
                    }
                    return z.f17874a;
                }
                r.b(obj);
                l.logger.a("cacheLang[" + str + "] lang[" + this.f20882a + "]", new Object[0]);
                if (kotlin.jvm.internal.m.a(str, this.f20882a)) {
                    a aVar2 = l.checksumKeeper;
                    aVar.label = 1;
                } else {
                    l.isCacheLoaded = true;
                    lVar = l.f20862a;
                    aVar.label = 2;
                    if (lVar.p(aVar) != objC) {
                        l lVar3 = l.f20862a;
                        aVar.label = 3;
                    }
                }
                return objC;
                l.f20862a.q();
                lVar = l.f20862a;
                aVar.label = 2;
                if (lVar.p(aVar) != objC) {
                    l lVar4 = l.f20862a;
                    aVar.label = 3;
                }
                return objC;
            }
        }

        f(v8.f<? super f> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new f(fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((f) create(l0Var, fVar)).invokeSuspend(z.f17874a);
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
                String strL = of.a.f16585a.l();
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(w0.f21452a.g("", ""), new a(null));
                b bVar = new b(strL);
                this.label = 1;
                if (fVarF.collect(bVar, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.VoDManager", f = "VoDManager.kt", l = {208}, m = "loadLocalPlayEpisodes")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class g extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        g(v8.f<? super g> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return l.this.o(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.VoDManager", f = "VoDManager.kt", l = {225, 255}, m = "loadLocalPlaylist")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class i extends kotlin.coroutines.jvm.internal.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        i(v8.f<? super i> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return l.this.p(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.VoDManager$loadLocalPlaylist$2", f = "VoDManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lz1/b1/lb/m/meta/MetaDetailResponse;", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    static final class j extends kotlin.coroutines.jvm.internal.l implements q<kotlinx.coroutines.flow.g<? super MetaDetailResponse>, Throwable, v8.f<? super z>, Object> {
        final /* synthetic */ CountDownLatch $latch;
        final /* synthetic */ String $metaId;
        final /* synthetic */ String $typeKey;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(CountDownLatch countDownLatch, String str, String str2, v8.f<? super j> fVar) {
            super(3, fVar);
            this.$latch = countDownLatch;
            this.$typeKey = str;
            this.$metaId = str2;
        }

        @Override // c9.q
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(kotlinx.coroutines.flow.g<? super MetaDetailResponse> gVar, Throwable th, v8.f<? super z> fVar) {
            j jVar = new j(this.$latch, this.$typeKey, this.$metaId, fVar);
            jVar.L$0 = th;
            return jVar.invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r.b(obj);
                Throwable th = (Throwable) this.L$0;
                this.$latch.countDown();
                l.logger.error("load " + this.$typeKey + " " + this.$metaId + " failure", th);
                return z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class k<T> implements kotlinx.coroutines.flow.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f20883a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LinkedHashMap<String, Long> f20884b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map<String, p<Long, MetaDetailResponse>> f20885c;

        k(CountDownLatch countDownLatch, LinkedHashMap<String, Long> linkedHashMap, Map<String, p<Long, MetaDetailResponse>> map) {
            this.f20883a = countDownLatch;
            this.f20884b = linkedHashMap;
            this.f20885c = map;
        }

        @Override // kotlinx.coroutines.flow.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(MetaDetailResponse metaDetailResponse, v8.f<? super z> fVar) {
            this.f20883a.countDown();
            if (metaDetailResponse == null) {
                return z.f17874a;
            }
            Long l10 = this.f20884b.get(metaDetailResponse.getMetaId());
            this.f20885c.put(metaDetailResponse.getMetaId(), new p<>(kotlin.coroutines.jvm.internal.b.c(l10 != null ? l10.longValue() : d1.d()), metaDetailResponse));
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/media/l$m", "Lx1/f1/lb/util/w0$a;", "", "value", "Lr8/z;", "b", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class m implements w0.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f20886a;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"x1/f1/lb/media/l$m$a", "Lf3/a;", "", "Lz1/b1/lb/m/meta/MetaDetailResponse;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a extends f3.a<List<MetaDetailResponse>> {
            a() {
            }
        }

        m(long j10) {
            this.f20886a = j10;
        }

        @Override // x1.f1.lb.util.w0.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(String value) {
            kotlin.jvm.internal.m.f(value, "value");
            if (value.length() == 0) {
                return;
            }
            long jC = d1.c();
            l.logger.a("load video detail from local cache size[" + value.length() + "], (" + (jC - this.f20886a) + " ms)", new Object[0]);
            try {
                Object objO = l.gson.o(value, new a().d());
                kotlin.jvm.internal.m.e(objO, "fromJson(...)");
                List list = (List) objO;
                l.logger.a("parse video detail from local cache count[" + list.size() + "], (" + (d1.c() - jC) + " ms)", new Object[0]);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    l.f20862a.k((MetaDetailResponse) it.next());
                }
            } catch (Throwable th) {
                l.logger.error("load video detail cache failure", th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002<\u00128\u00126\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0002j\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004`\u00060\u0001¨\u0006\u0007"}, d2 = {"x1/f1/lb/media/l$h", "Lf3/a;", "Ljava/util/LinkedHashMap;", "", "Lr8/p;", "", "Lkotlin/collections/LinkedHashMap;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class h extends f3.a<LinkedHashMap<String, p<? extends Integer, ? extends Integer>>> {
        h() {
        }
    }

    /* JADX INFO: renamed from: x1.f1.lb.media.l$l, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00050\u0001¨\u0006\u0006"}, d2 = {"x1/f1/lb/media/l$l", "Lf3/a;", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C0429l extends f3.a<LinkedHashMap<String, Long>> {
        C0429l() {
        }
    }

    static {
        l lVar = new l();
        f20862a = lVar;
        logger = q6.c.d(lVar.getClass());
        metaQueryExpressionPlayList = new HashMap<>();
        metaDetailResponseCache = new u4.d<>(128L);
        favoritesMap = new LinkedHashMap();
        playEpisodeHist = new LinkedHashMap();
        historyMap = new LinkedHashMap();
        playlistCacheUpdateTime = new ConcurrentHashMap();
        detailCacheUpdateTime = new ConcurrentHashMap();
        gson = new com.google.gson.e();
        isCacheLoaded = true;
        checksumKeeper = new a();
    }

    private final MetaDetailResponse j(String metaId) {
        return metaDetailResponseCache.c(metaId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(MetaDetailResponse detailResponse) {
        metaDetailResponseCache.d(detailResponse.getMetaId(), detailResponse);
    }

    private final <T> kotlinx.coroutines.flow.f<T> l(b<com.skydoves.sandwich.a<n6.b<T>>> apiCaller) {
        return kotlinx.coroutines.flow.h.v(new c(apiCaller, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object o(v8.f<? super z> fVar) {
        g gVar;
        if (fVar instanceof g) {
            gVar = (g) fVar;
            int i10 = gVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                gVar.label = i10 - Integer.MIN_VALUE;
            } else {
                gVar = new g(fVar);
            }
        } else {
            gVar = new g(fVar);
        }
        g gVar2 = gVar;
        Object objO = gVar2.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = gVar2.label;
        try {
            if (i11 == 0) {
                r.b(objO);
                w0 w0Var = w0.f21452a;
                gVar2.L$0 = this;
                gVar2.label = 1;
                objO = w0.o(w0Var, "vod_episode_history", null, gVar2, 2, null);
                if (objO == objC) {
                    return objC;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r.b(objO);
            }
            String str = (String) objO;
            if (ac.g.f(str)) {
                return z.f17874a;
            }
            Object objO2 = gson.o(str, new h().d());
            kotlin.jvm.internal.m.e(objO2, "fromJson(...)");
            playEpisodeHist = (LinkedHashMap) objO2;
            return z.f17874a;
        } catch (Throwable th) {
            logger.error("load local play episodes history failure", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:125:0x015f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x01bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:32:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:35:0x00d6 A[Catch: all -> 0x0150, TryCatch #0 {all -> 0x0150, blocks: (B:33:0x00ce, B:35:0x00d6, B:36:0x00fe, B:38:0x0104), top: B:104:0x00ce }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0104 A[Catch: all -> 0x0150, TRY_LEAVE, TryCatch #0 {all -> 0x0150, blocks: (B:33:0x00ce, B:35:0x00d6, B:36:0x00fe, B:38:0x0104), top: B:104:0x00ce }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0131 A[Catch: all -> 0x0144, TryCatch #6 {all -> 0x0144, blocks: (B:40:0x0115, B:42:0x0131, B:46:0x014c), top: B:115:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x014c A[Catch: all -> 0x0144, TRY_LEAVE, TryCatch #6 {all -> 0x0144, blocks: (B:40:0x0115, B:42:0x0131, B:46:0x014c), top: B:115:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x017e A[Catch: all -> 0x01d0, TRY_LEAVE, TryCatch #2 {all -> 0x01d0, blocks: (B:55:0x0178, B:57:0x017e), top: B:108:0x0178 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x01bd A[LOOP:1: B:108:0x0178->B:66:0x01bd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:78:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:81:0x01f7 A[Catch: all -> 0x01c2, TRY_LEAVE, TryCatch #3 {all -> 0x01c2, blocks: (B:63:0x01b4, B:79:0x01f1, B:81:0x01f7, B:75:0x01d4), top: B:110:0x01b4 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:86:0x0204 A[Catch: all -> 0x0207, TRY_LEAVE, TryCatch #7 {all -> 0x0207, blocks: (B:84:0x01fe, B:86:0x0204), top: B:117:0x01fe }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0217  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v29, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r22v0, types: [v8.f, v8.f<? super r8.z>] */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v10 */
    /* JADX WARN: Type inference failed for: r22v11 */
    /* JADX WARN: Type inference failed for: r22v12 */
    /* JADX WARN: Type inference failed for: r22v14 */
    /* JADX WARN: Type inference failed for: r22v15 */
    /* JADX WARN: Type inference failed for: r22v16 */
    /* JADX WARN: Type inference failed for: r22v17 */
    /* JADX WARN: Type inference failed for: r22v18 */
    /* JADX WARN: Type inference failed for: r22v19 */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r22v20 */
    /* JADX WARN: Type inference failed for: r22v3 */
    /* JADX WARN: Type inference failed for: r22v4 */
    /* JADX WARN: Type inference failed for: r22v5 */
    /* JADX WARN: Type inference failed for: r22v6 */
    /* JADX WARN: Type inference failed for: r22v7 */
    /* JADX WARN: Type inference failed for: r22v8 */
    /* JADX WARN: Type inference failed for: r22v9 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11, types: [x1.f1.lb.media.l] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v4, types: [x1.f1.lb.media.l] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.lang.Object, x1.f1.lb.media.l] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object p(v8.f<? super r8.z> r22) {
        /*
            Method dump skipped, instruction units count: 616
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x1.f1.lb.media.l.p(v8.f):java.lang.Object");
    }

    public final kotlinx.coroutines.flow.f<MetaDetailResponse> m(String metaId, int pageId, int pageSize) {
        kotlin.jvm.internal.m.f(metaId, "metaId");
        kotlinx.coroutines.flow.f<MetaDetailResponse> fVarL = l(new e(metaId, pageId, pageSize));
        MetaDetailResponse metaDetailResponseJ = j(metaId);
        if (metaDetailResponseJ == null) {
            return fVarL;
        }
        String str = metaId + pageId + pageSize;
        long jD = d1.d();
        Long l10 = detailCacheUpdateTime.get(str);
        return jD - (l10 != null ? l10.longValue() : 0L) < x1.f1.lb.heartbeat.f.f20678a.n0() ? kotlinx.coroutines.flow.h.w(metaDetailResponseJ) : kotlinx.coroutines.flow.h.e(new d(metaDetailResponseJ, fVarL, str, jD, null));
    }

    private l() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        w0.p(w0.f21452a, "vod_detail_cache", new m(d1.c()), null, 4, null);
    }

    public final void n() {
        kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new f(null), 3, null);
    }
}
