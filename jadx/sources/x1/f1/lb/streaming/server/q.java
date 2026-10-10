package x1.f1.lb.streaming.server;

import java.lang.reflect.Type;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\bR\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0016¨\u0006\u0018"}, d2 = {"Lx1/f1/lb/streaming/server/q;", "", "<init>", "()V", "", "uid", "mediaId", "c", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "cacheDirectory", "", "appVersion", "", "maxSize", "Lr8/z;", "d", "(Ljava/lang/String;IJ)V", "signature", "e", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "b", "Lx1/f1/lb/cache/a;", "Lx1/f1/lb/cache/a;", "baseCache", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f21130a = new q();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static x1.f1.lb.cache.a<String> baseCache;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.server.SignatureCache$get$1", f = "SignatureCache.kt", l = {39}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ String[] $array;
        final /* synthetic */ CountDownLatch $countDownLatch;
        final /* synthetic */ String $key;
        int I$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String[] strArr, String str, CountDownLatch countDownLatch, v8.f<? super a> fVar) {
            super(2, fVar);
            this.$array = strArr;
            this.$key = str;
            this.$countDownLatch = countDownLatch;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new a(this.$array, this.$key, this.$countDownLatch, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            String[] strArr;
            int i10;
            String str;
            int i11;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i12 = this.label;
            try {
                if (i12 != 0) {
                    if (i12 == 1) {
                        i11 = this.I$0;
                        strArr = (String[]) this.L$0;
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r8.r.b(obj);
                    strArr = this.$array;
                    x1.f1.lb.cache.a aVar = q.baseCache;
                    i10 = 0;
                    if (aVar != null) {
                        String str2 = this.$key;
                        this.L$0 = strArr;
                        this.I$0 = 0;
                        this.label = 1;
                        obj = aVar.c(str2, this);
                        if (obj == objC) {
                            return objC;
                        }
                        i11 = 0;
                    } else {
                        str = null;
                    }
                    strArr[i10] = str;
                    this.$countDownLatch.countDown();
                    return z.f17874a;
                }
                str = (String) obj;
                i10 = i11;
                strArr[i10] = str;
            } catch (Throwable unused) {
            }
            this.$countDownLatch.countDown();
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.server.SignatureCache$put$1", f = "SignatureCache.kt", l = {26}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class c extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ String $key;
        final /* synthetic */ String $signature;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, String str2, v8.f<? super c> fVar) {
            super(2, fVar);
            this.$key = str;
            this.$signature = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new c(this.$key, this.$signature, fVar);
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
                if (i10 != 0) {
                    if (i10 == 1) {
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r8.r.b(obj);
                    x1.f1.lb.cache.a aVar = q.baseCache;
                    if (aVar != null) {
                        String str = this.$key;
                        String str2 = this.$signature;
                        this.label = 1;
                        obj = aVar.f(str, str2, this);
                        if (obj == objC) {
                            return objC;
                        }
                    }
                    return z.f17874a;
                }
            } catch (Throwable unused) {
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"x1/f1/lb/streaming/server/q$b", "Lf3/a;", "", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends f3.a<String> {
        b() {
        }
    }

    private final String c(String uid, String mediaId) {
        return uid + "." + mediaId;
    }

    public final String b(String uid, String mediaId) throws InterruptedException {
        kotlin.jvm.internal.m.f(uid, "uid");
        kotlin.jvm.internal.m.f(mediaId, "mediaId");
        String strC = c(uid, mediaId);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String[] strArr = new String[1];
        kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new a(strArr, strC, countDownLatch, null), 3, null);
        countDownLatch.await();
        String str = strArr[0];
        return str == null ? "" : str;
    }

    public final void d(String cacheDirectory, int appVersion, long maxSize) {
        kotlin.jvm.internal.m.f(cacheDirectory, "cacheDirectory");
        Type typeD = new b().d();
        kotlin.jvm.internal.m.e(typeD, "getType(...)");
        baseCache = new x1.f1.lb.cache.a<>(cacheDirectory, typeD, appVersion, maxSize, 0, 16, null);
    }

    public final void e(String uid, String mediaId, String signature) {
        kotlin.jvm.internal.m.f(uid, "uid");
        kotlin.jvm.internal.m.f(mediaId, "mediaId");
        kotlin.jvm.internal.m.f(signature, "signature");
        kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new c(c(uid, mediaId), signature, null), 3, null);
    }

    private q() {
    }
}
