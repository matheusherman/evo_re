package x1.f1.lb.streaming.server;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.io.IOException;
import java.lang.reflect.Type;
import java.security.MessageDigest;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.b0;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import x1.f1.lb.util.b1;
import x1.f1.lb.util.w0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\u000b\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J5\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001f\u0010\u0003J=\u0010!\u001a\u00020\u00172\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010 \u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b!\u0010\"J6\u0010#\u001a\u0004\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0004\b#\u0010$R\u001c\u0010(\u001a\n &*\u0004\u0018\u00010%0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010'R\u001e\u0010,\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u001e\u0010.\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010+R\u0018\u00101\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00062"}, d2 = {"Lx1/f1/lb/streaming/server/s;", "Ly6/l;", "<init>", "()V", "Lv6/b;", "mediaType", "", "mediaHash", "blockId", "", "blockName", "h", "(Lv6/b;IILjava/lang/String;)Ljava/lang/String;", "", "bytes", "g", "([B)Ljava/lang/String;", "cacheDirectory", "fullDataDirectory", "appVersion", "", "maxSize", "fullDataMaxSize", "Lr8/z;", "i", "(Ljava/lang/String;Ljava/lang/String;IJJ)V", "Lx1/f1/lb/streaming/server/e;", "listener", "j", "(Lx1/f1/lb/streaming/server/e;)V", "start", "stop", "data", "b", "(Lv6/b;IILjava/lang/String;[B)V", "a", "(Lv6/b;IILjava/lang/String;)[B", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "Lx1/f1/lb/cache/a;", "c", "Lx1/f1/lb/cache/a;", "quickStartMyDiskLruCache", "d", "fullDataDiskLruCode", "e", "Lx1/f1/lb/streaming/server/e;", "cacheManageListener", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class s implements y6.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f21156a = new s();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger = q6.c.d(s.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static x1.f1.lb.cache.a<byte[]> quickStartMyDiskLruCache;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static x1.f1.lb.cache.a<byte[]> fullDataDiskLruCode;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static e cacheManageListener;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.server.VoDLocalDiskCacheManage$get$1", f = "VoDLocalDiskCacheManage.kt", l = {167}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ int $blockId;
        final /* synthetic */ String $blockName;
        final /* synthetic */ byte[][] $byteArray;
        final /* synthetic */ b0<x1.f1.lb.cache.a<byte[]>> $cache;
        final /* synthetic */ CountDownLatch $countDownLatch;
        final /* synthetic */ int $mediaHash;
        final /* synthetic */ v6.b $mediaType;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(v6.b bVar, int i10, int i11, String str, b0<x1.f1.lb.cache.a<byte[]>> b0Var, byte[][] bArr, CountDownLatch countDownLatch, v8.f<? super a> fVar) {
            super(2, fVar);
            this.$mediaType = bVar;
            this.$mediaHash = i10;
            this.$blockId = i11;
            this.$blockName = str;
            this.$cache = b0Var;
            this.$byteArray = bArr;
            this.$countDownLatch = countDownLatch;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new a(this.$mediaType, this.$mediaHash, this.$blockId, this.$blockName, this.$cache, this.$byteArray, this.$countDownLatch, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            String str;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    r8.r.b(obj);
                    String strH = s.f21156a.h(this.$mediaType, this.$mediaHash, this.$blockId, this.$blockName);
                    x1.f1.lb.cache.a<byte[]> aVar = this.$cache.element;
                    this.L$0 = strH;
                    this.label = 1;
                    Object objD = aVar.d(strH, this);
                    if (objD == objC) {
                        return objC;
                    }
                    str = strH;
                    obj = objD;
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str = (String) this.L$0;
                    r8.r.b(obj);
                }
                this.$byteArray[0] = (byte[]) obj;
                if (x1.f1.lb.config.b.f20643a.t()) {
                    s.logger.debug("vod_cache get[" + this.$mediaType + "-" + this.$mediaHash + "-" + this.$blockId + "-" + this.$blockName + "]->[" + str + "]", new Object[0]);
                }
            } catch (Throwable th) {
                try {
                    s.logger.error("load cache failure[" + this.$mediaType + "." + this.$mediaHash + "." + this.$blockId + "." + this.$blockName + "]", th);
                } finally {
                    this.$countDownLatch.countDown();
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/streaming/server/s$b", "Lx1/f1/lb/util/w0$a;", "", "value", "Lr8/z;", "b", "(J)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements w0.a<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f21161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f21162b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f21163c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f21164d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f21165e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f21166f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f21167g;

        /* JADX INFO: renamed from: x1.f1.lb.streaming.server.s$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/streaming/server/s$b$b", "Lx1/f1/lb/util/w0$a;", "", "value", "Lr8/z;", "b", "(J)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C0447b implements w0.a<Long> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f21168a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f21169b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ long f21170c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f21171d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f21172e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f21173f;

            /* JADX INFO: renamed from: x1.f1.lb.streaming.server.s$b$b$a */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"x1/f1/lb/streaming/server/s$b$b$a", "Lf3/a;", "", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
            public static final class a extends f3.a<byte[]> {
                a() {
                }
            }

            C0447b(long j10, long j11, long j12, long j13, String str, int i10) {
                this.f21168a = j10;
                this.f21169b = j11;
                this.f21170c = j12;
                this.f21171d = j13;
                this.f21172e = str;
                this.f21173f = i10;
            }

            @Override // x1.f1.lb.util.w0.a
            public /* bridge */ /* synthetic */ void a(Long l10) {
                b(l10.longValue());
            }

            public void b(long value) {
                long j10 = this.f21168a - value;
                long j11 = this.f21169b;
                if (j11 < j10) {
                    j10 = j11 > IjkMediaMeta.AV_CH_STEREO_RIGHT ? j11 - ((long) BasicMeasure.EXACTLY) : 0L;
                }
                long j12 = value + j10;
                if (j12 == 0) {
                    s.logger.warn("vod_cache local storage is not enough for vod full cache, totalStorage[" + this.f21170c + "] freeStorage[" + this.f21171d + "]", new Object[0]);
                    return;
                }
                try {
                    s sVar = s.f21156a;
                    String str = this.f21172e;
                    Type typeD = new a().d();
                    kotlin.jvm.internal.m.e(typeD, "getType(...)");
                    s.fullDataDiskLruCode = new x1.f1.lb.cache.a(str, typeD, this.f21173f, j12, 0, 16, null);
                    s.logger.a("vod_cache local storage init for full video cache, totalStorage[" + this.f21170c + "] freeStorage[" + this.f21171d + "] expectCacheSize[" + this.f21168a + "] historyCacheSize[" + value + "]+allocateCacheSize[" + j10 + "]=realCacheSize[" + j12 + "]", new Object[0]);
                } catch (IOException e10) {
                    s.logger.error("open vod block cache failure", e10);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"x1/f1/lb/streaming/server/s$b$a", "Lf3/a;", "", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a extends f3.a<byte[]> {
            a() {
            }
        }

        b(long j10, long j11, long j12, String str, int i10, long j13, String str2) {
            this.f21161a = j10;
            this.f21162b = j11;
            this.f21163c = j12;
            this.f21164d = str;
            this.f21165e = i10;
            this.f21166f = j13;
            this.f21167g = str2;
        }

        @Override // x1.f1.lb.util.w0.a
        public /* bridge */ /* synthetic */ void a(Long l10) {
            b(l10.longValue());
        }

        public void b(long value) {
            long j10 = this.f21161a - value;
            long j11 = this.f21162b;
            if (j11 < j10) {
                j10 = j11 > IjkMediaMeta.AV_CH_STEREO_RIGHT ? j11 - ((long) BasicMeasure.EXACTLY) : 0L;
            }
            long j12 = value + j10;
            if (j12 == 0) {
                s.logger.warn("vod_cache local storage is not enough for vod cache, totalStorage[" + this.f21163c + "] freeStorage[" + this.f21162b + "]", new Object[0]);
                return;
            }
            try {
                s sVar = s.f21156a;
                String str = this.f21164d;
                Type typeD = new a().d();
                kotlin.jvm.internal.m.e(typeD, "getType(...)");
                s.quickStartMyDiskLruCache = new x1.f1.lb.cache.a(str, typeD, this.f21165e, j12, 0, 16, null);
                s.logger.a("vod_cache local storage init for video quick start cache, totalStorage[" + this.f21163c + "] freeStorage[" + this.f21162b + " expectCacheSize[" + this.f21161a + "] realCacheSize[" + j12 + "]", new Object[0]);
            } catch (IOException e10) {
                s.logger.error("open vod quick start cache failure", e10);
            }
            long j13 = this.f21162b;
            w0.f21452a.k("sp_full_date_cache_size", new C0447b(this.f21166f, j13 - j10, this.f21163c, j13, this.f21167g, this.f21165e), 0L);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.server.VoDLocalDiskCacheManage$put$1", f = "VoDLocalDiskCacheManage.kt", l = {ModuleDescriptor.MODULE_VERSION}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class c extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ int $blockId;
        final /* synthetic */ String $blockName;
        final /* synthetic */ b0<x1.f1.lb.cache.a<byte[]>> $cache;
        final /* synthetic */ byte[] $data;
        final /* synthetic */ int $mediaHash;
        final /* synthetic */ v6.b $mediaType;
        final /* synthetic */ b0<String> $sizeKey;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(v6.b bVar, int i10, int i11, String str, b0<x1.f1.lb.cache.a<byte[]>> b0Var, byte[] bArr, b0<String> b0Var2, v8.f<? super c> fVar) {
            super(2, fVar);
            this.$mediaType = bVar;
            this.$mediaHash = i10;
            this.$blockId = i11;
            this.$blockName = str;
            this.$cache = b0Var;
            this.$data = bArr;
            this.$sizeKey = b0Var2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new c(this.$mediaType, this.$mediaHash, this.$blockId, this.$blockName, this.$cache, this.$data, this.$sizeKey, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((c) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    r8.r.b(obj);
                    String strH = s.f21156a.h(this.$mediaType, this.$mediaHash, this.$blockId, this.$blockName);
                    if (x1.f1.lb.config.b.f20643a.t()) {
                        s.logger.debug("vod_cache put[" + this.$mediaType + "-" + this.$mediaHash + "-" + this.$blockId + "-" + this.$blockName + "]->[" + strH + "]", new Object[0]);
                    }
                    x1.f1.lb.cache.a<byte[]> aVar = this.$cache.element;
                    byte[] bArr = this.$data;
                    this.label = 1;
                    obj = aVar.g(strH, bArr, this);
                    if (obj == objC) {
                        return objC;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r8.r.b(obj);
                }
                if (((Boolean) obj).booleanValue()) {
                    w0.f21452a.s(this.$sizeKey.element, this.$cache.element.h());
                }
            } catch (Throwable th) {
                s.logger.error("vod cache failure", th);
            }
            return z.f17874a;
        }
    }

    private final String g(byte[] bytes) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bytes) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                sb2.append('0');
            }
            sb2.append(hexString);
        }
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "toString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String h(v6.b mediaType, int mediaHash, int blockId, String blockName) {
        String str = mediaType + "." + mediaHash + "." + blockId + "." + blockName;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes(ua.d.UTF_8);
            kotlin.jvm.internal.m.e(bytes, "getBytes(...)");
            messageDigest.update(bytes);
            byte[] bArrDigest = messageDigest.digest();
            kotlin.jvm.internal.m.e(bArrDigest, "digest(...)");
            return g(bArrDigest);
        } catch (Throwable unused) {
            return String.valueOf(str.hashCode());
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, x1.f1.lb.cache.a<byte[]>] */
    /* JADX WARN: Type inference failed for: r0v6, types: [T, x1.f1.lb.cache.a<byte[]>] */
    @Override // y6.l
    public byte[] a(v6.b mediaType, int mediaHash, int blockId, String blockName) throws InterruptedException {
        int i10;
        b0 b0Var = new b0();
        ?? r10 = quickStartMyDiskLruCache;
        if (r10 == 0) {
            return null;
        }
        b0Var.element = r10;
        if (mediaType == v6.b.BLOCK) {
            i10 = blockId;
            if (i10 > 30) {
                ?? r11 = fullDataDiskLruCode;
                if (r11 == 0) {
                    return null;
                }
                b0Var.element = r11;
            }
        } else {
            i10 = blockId;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        byte[][] bArr = new byte[1][];
        kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new a(mediaType, mediaHash, i10, blockName, b0Var, bArr, countDownLatch, null), 3, null);
        countDownLatch.await();
        return bArr[0];
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, x1.f1.lb.cache.a<byte[]>] */
    /* JADX WARN: Type inference failed for: r0v6, types: [T, x1.f1.lb.cache.a<byte[]>] */
    @Override // y6.l
    public void b(v6.b mediaType, int mediaHash, int blockId, String blockName, byte[] data) {
        int i10;
        b0 b0Var = new b0();
        ?? r10 = quickStartMyDiskLruCache;
        if (r10 == 0) {
            return;
        }
        b0Var.element = r10;
        b0 b0Var2 = new b0();
        b0Var2.element = "sp_quick_start_cache_size";
        if (data == null) {
            return;
        }
        if (mediaType == v6.b.BLOCK) {
            i10 = blockId;
            if (i10 > 30) {
                ?? r11 = fullDataDiskLruCode;
                if (r11 == 0) {
                    return;
                }
                b0Var.element = r11;
                b0Var2.element = "sp_full_date_cache_size";
            }
        } else {
            i10 = blockId;
        }
        kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new c(mediaType, mediaHash, i10, blockName, b0Var, data, b0Var2, null), 3, null);
    }

    public final void i(String cacheDirectory, String fullDataDirectory, int appVersion, long maxSize, long fullDataMaxSize) {
        kotlin.jvm.internal.m.f(cacheDirectory, "cacheDirectory");
        kotlin.jvm.internal.m.f(fullDataDirectory, "fullDataDirectory");
        try {
            b1 b1Var = b1.f21324a;
            w0.f21452a.k("sp_quick_start_cache_size", new b(maxSize, b1Var.j(), b1Var.l(), cacheDirectory, appVersion, fullDataMaxSize, fullDataDirectory), 0L);
        } catch (IOException e10) {
            logger.error("create disk cache failure", e10);
        }
    }

    public final void j(e listener) {
        kotlin.jvm.internal.m.f(listener, "listener");
        cacheManageListener = listener;
    }

    private s() {
    }

    @Override // y6.l
    public void start() {
    }

    @Override // y6.l
    public void stop() {
    }
}
