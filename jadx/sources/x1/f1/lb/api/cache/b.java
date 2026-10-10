package x1.f1.lb.api.cache;

import c9.p;
import c9.q;
import java.io.File;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.r;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import x1.f1.lb.util.b0;
import x1.f1.lb.util.b1;
import x1.f1.lb.util.n;
import x1.f1.lb.util.w0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J2\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0012\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H\u0086@¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001d\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010!\u001a\n \u001a*\u0004\u0018\u00010\u001e0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 RR\u0010(\u001a>\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040#j\b\u0012\u0004\u0012\u00020\u0004`$0\"j\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040#j\b\u0012\u0004\u0012\u00020\u0004`$`%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010.¨\u00060"}, d2 = {"Lx1/f1/lb/api/cache/b;", "", "<init>", "()V", "", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "", "k", "(Ljava/lang/String;)Z", "Lx1/f1/lb/util/b0$d;", "g", "(Ljava/lang/String;)Lx1/f1/lb/util/b0$d;", "j", "(Ljava/lang/String;)Ljava/lang/String;", "", "bytes", "f", "([B)Ljava/lang/String;", "cacheKey", "", "urls", "", "Ljava/io/File;", "h", "(Ljava/lang/String;Ljava/util/List;Lv8/f;)Ljava/lang/Object;", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "Ljava/util/concurrent/ExecutorService;", "c", "Ljava/util/concurrent/ExecutorService;", "executorService", "Ljava/util/HashMap;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "fileCacheKey", "Ljava/util/concurrent/CountDownLatch;", "e", "Ljava/util/concurrent/CountDownLatch;", "initCountDownLatch", "Lcom/google/gson/e;", "Lcom/google/gson/e;", "gson", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f20561a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger = q6.c.d(b.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ExecutorService executorService = n.f21413l;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static HashMap<String, HashSet<String>> fileCacheKey = new HashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final CountDownLatch initCountDownLatch = new CountDownLatch(1);

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final com.google.gson.e gson = new com.google.gson.e();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "x1.f1.lb.api.cache.FileDiskCacheUtil$1", f = "FileDiskCacheUtil.kt", l = {32}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class a extends l implements p<l0, v8.f<? super z>, Object> {
        int label;

        /* JADX INFO: renamed from: x1.f1.lb.api.cache.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @f(c = "x1.f1.lb.api.cache.FileDiskCacheUtil$1$1", f = "FileDiskCacheUtil.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class C0404a extends l implements q<g<? super String>, Throwable, v8.f<? super z>, Object> {
            /* synthetic */ Object L$0;
            int label;

            C0404a(v8.f<? super C0404a> fVar) {
                super(3, fVar);
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(g<? super String> gVar, Throwable th, v8.f<? super z> fVar) {
                C0404a c0404a = new C0404a(fVar);
                c0404a.L$0 = th;
                return c0404a.invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r.b(obj);
                    b.logger.error("load file_disk_cache_mapping failure", (Throwable) this.L$0);
                    b.initCountDownLatch.countDown();
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: x1.f1.lb.api.cache.b$a$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class C0405b<T> implements g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0405b<T> f20567a = new C0405b<>();

            /* JADX INFO: renamed from: x1.f1.lb.api.cache.b$a$b$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002D\u0012@\u0012>\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0004j\b\u0012\u0004\u0012\u00020\u0003`\u00050\u0002j\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0004j\b\u0012\u0004\u0012\u00020\u0003`\u0005`\u00060\u0001¨\u0006\u0007"}, d2 = {"x1/f1/lb/api/cache/b$a$b$a", "Lf3/a;", "Ljava/util/HashMap;", "", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Lkotlin/collections/HashMap;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
            public static final class C0406a extends f3.a<HashMap<String, HashSet<String>>> {
                C0406a() {
                }
            }

            C0405b() {
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(String str, v8.f<? super z> fVar) {
                try {
                    if (str.length() != 0) {
                        b.fileCacheKey = (HashMap) b.gson.o(str, new C0406a().d());
                        return z.f17874a;
                    }
                    z zVar = z.f17874a;
                    b.initCountDownLatch.countDown();
                    return zVar;
                } catch (Throwable th) {
                    try {
                        b.logger.error("parse file_disk_cache_mapping failure", th);
                    } finally {
                        b.initCountDownLatch.countDown();
                    }
                }
            }
        }

        a(v8.f<? super a> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new a(fVar);
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
                kotlinx.coroutines.flow.f fVarF = h.f(w0.f21452a.g("file_disk_cache_mapping", ""), new C0404a(null));
                g gVar = C0405b.f20567a;
                this.label = 1;
                if (fVarF.collect(gVar, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: x1.f1.lb.api.cache.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"x1/f1/lb/api/cache/b$b", "Lx1/f1/lb/util/b0$c;", "Ljava/io/File;", "file", "", "f", "(Ljava/io/File;)Z", "g", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C0407b extends b0.c {
        C0407b(String str, String str2, String str3, c cVar) {
            super(str, str2, str3, false, cVar);
        }

        @Override // x1.f1.lb.util.b0.d
        public boolean f(File file) {
            m.f(file, "file");
            return true;
        }

        @Override // x1.f1.lb.util.b0.d
        public boolean g(File file) {
            m.f(file, "file");
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"x1/f1/lb/api/cache/b$c", "Lx1/f1/lb/util/b0$f;", "", "savedPath", "Lr8/z;", "b", "(Ljava/lang/String;)V", "", "progress", "c", "(I)V", "", "e", "a", "(Ljava/lang/Throwable;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c implements b0.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f20568a;

        c(String str) {
            this.f20568a = str;
        }

        @Override // x1.f1.lb.util.b0.f
        public void a(Throwable e10) {
            m.f(e10, "e");
            b.logger.error("download failure [" + this.f20568a + "]", e10);
        }

        @Override // x1.f1.lb.util.b0.f
        public void b(String savedPath) {
            m.f(savedPath, "savedPath");
        }

        @Override // x1.f1.lb.util.b0.f
        public void c(int progress) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "x1.f1.lb.api.cache.FileDiskCacheUtil", f = "FileDiskCacheUtil.kt", l = {54}, m = "get")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class d extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        d(v8.f<? super d> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return b.this.h(null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "x1.f1.lb.api.cache.FileDiskCacheUtil$get$2", f = "FileDiskCacheUtil.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class e extends l implements p<l0, v8.f<? super z>, Object> {
        int label;

        e(v8.f<? super e> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new e(fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((e) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) throws InterruptedException {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r.b(obj);
                b.initCountDownLatch.await();
                return z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        j.d(m0.a(a1.b()), null, null, new a(null), 3, null);
    }

    private final String f(byte[] bytes) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bytes) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                sb2.append('0');
            }
            sb2.append(hexString);
        }
        String string = sb2.toString();
        m.e(string, "toString(...)");
        return string;
    }

    private final b0.d g(String url) {
        return new C0407b(url, b1.f21324a.i(), f20561a.j(url), new c(url));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(b0.d dVar) {
        b0.h(b0.f21310a, dVar, false, null, 6, null);
    }

    private final String j(String url) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = url.getBytes(ua.d.UTF_8);
            m.e(bytes, "getBytes(...)");
            messageDigest.update(bytes);
            byte[] bArrDigest = messageDigest.digest();
            m.e(bArrDigest, "digest(...)");
            return f(bArrDigest);
        } catch (Throwable unused) {
            return String.valueOf(url.hashCode());
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object h(String str, List<String> list, v8.f<? super Map<String, ? extends File>> fVar) {
        d dVar;
        Map linkedHashMap;
        b bVar;
        Map map;
        if (fVar instanceof d) {
            dVar = (d) fVar;
            int i10 = dVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                dVar.label = i10 - Integer.MIN_VALUE;
            } else {
                dVar = new d(fVar);
            }
        } else {
            dVar = new d(fVar);
        }
        Object obj = dVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = dVar.label;
        if (i11 == 0) {
            r.b(obj);
            linkedHashMap = new LinkedHashMap();
            if (list.isEmpty()) {
                return linkedHashMap;
            }
            try {
                i0 i0VarB = a1.b();
                e eVar = new e(null);
                dVar.L$0 = this;
                dVar.L$1 = str;
                dVar.L$2 = list;
                dVar.L$3 = linkedHashMap;
                dVar.label = 1;
                if (kotlinx.coroutines.h.g(i0VarB, eVar, dVar) == objC) {
                    return objC;
                }
                bVar = this;
            } catch (Throwable th) {
                th = th;
                map = linkedHashMap;
                logger.error("wait for cache mapping ready failure", th);
                return map;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            map = (Map) dVar.L$3;
            list = (List) dVar.L$2;
            String str2 = (String) dVar.L$1;
            bVar = (b) dVar.L$0;
            try {
                r.b(obj);
                linkedHashMap = map;
                str = str2;
            } catch (Throwable th2) {
                th = th2;
                logger.error("wait for cache mapping ready failure", th);
                return map;
            }
        }
        HashSet<String> hashSet = fileCacheKey.get(str);
        if (hashSet == null) {
            hashSet = new HashSet<>();
        }
        Iterator<String> it = hashSet.iterator();
        m.e(it, "iterator(...)");
        while (it.hasNext()) {
            String next = it.next();
            m.e(next, "next(...)");
            String str3 = next;
            if (!list.contains(str3)) {
                bVar.k(str3);
            }
        }
        boolean z10 = false;
        for (String str4 : list) {
            if (str4.length() != 0) {
                final b0.d dVarG = bVar.g(str4);
                File file = dVarG.getFile();
                dVarG.getTryTimes().set(2);
                if (file.exists()) {
                    linkedHashMap.put(str4, file);
                } else {
                    executorService.submit(new Runnable() { // from class: x1.f1.lb.api.cache.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.i(dVarG);
                        }
                    });
                }
                if (!hashSet.contains(str4)) {
                    hashSet.add(str4);
                    z10 = true;
                }
            }
        }
        if (!z10) {
            return linkedHashMap;
        }
        try {
            fileCacheKey.put(str, hashSet);
            String strW = gson.w(fileCacheKey);
            w0 w0Var = w0.f21452a;
            m.c(strW);
            w0Var.t("file_disk_cache_mapping", strW);
            return linkedHashMap;
        } catch (Throwable th3) {
            try {
                logger.error("save file_disk_cache_mapping failure", th3);
                return linkedHashMap;
            } catch (Throwable th4) {
                th = th4;
                map = linkedHashMap;
                logger.error("wait for cache mapping ready failure", th);
                return map;
            }
        }
    }

    private b() {
    }

    private final boolean k(String url) {
        File file = g(url).getFile();
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }
}
