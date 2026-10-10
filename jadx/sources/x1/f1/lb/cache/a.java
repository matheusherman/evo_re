package x1.f1.lb.cache;

import android.util.LruCache;
import androidx.exifinterface.media.ExifInterface;
import c9.p;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import r8.r;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import x1.f1.lb.util.d1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u000f*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001eB1\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00028\u0000H\u0086@¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0011\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0016\u0010\u0017J \u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0018H\u0086@¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0011\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u001b\u0010\u0017J\r\u0010\u001c\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010)\u001a\n '*\u0004\u0018\u00010&0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010(R$\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u0000\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010+¨\u0006-"}, d2 = {"Lx1/f1/lb/cache/a;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "cacheDirectory", "Ljava/lang/reflect/Type;", IjkMediaMeta.IJKM_KEY_TYPE, "", "appVersion", "", "maxDiskSizeInBytes", "memCacheItemCnt", "<init>", "(Ljava/lang/String;Ljava/lang/reflect/Type;IJI)V", "Lx1/f1/lb/cache/b;", "e", "()Lx1/f1/lb/cache/b;", "key", "content", "", "f", "(Ljava/lang/String;Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "c", "(Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "", "g", "(Ljava/lang/String;[BLv8/f;)Ljava/lang/Object;", "d", "h", "()J", "a", "Ljava/lang/String;", "getCacheDirectory", "()Ljava/lang/String;", "b", "Ljava/lang/reflect/Type;", "getType", "()Ljava/lang/reflect/Type;", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "Landroid/util/LruCache;", "Landroid/util/LruCache;", "lruCache", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final com.google.gson.e f20594f = new com.google.gson.e();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Map<String, x1.f1.lb.cache.b> f20595g = new LinkedHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String cacheDirectory;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Type type;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LruCache<String, T> lruCache;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "x1.f1.lb.cache.BaseCache", f = "BaseCache.kt", l = {84}, m = "get")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class b extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ a<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(a<T> aVar, v8.f<? super b> fVar) {
            super(fVar);
            this.this$0 = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.c(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "x1.f1.lb.cache.BaseCache$getArray$2", f = "BaseCache.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "", "<anonymous>", "(Lkotlinx/coroutines/l0;)[B"}, k = 3, mv = {2, 1, 0})
    static final class c extends l implements p<l0, v8.f<? super byte[]>, Object> {
        final /* synthetic */ String $key;
        int label;
        final /* synthetic */ a<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(a<T> aVar, String str, v8.f<? super c> fVar) {
            super(2, fVar);
            this.this$0 = aVar;
            this.$key = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new c(this.this$0, this.$key, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super byte[]> fVar) {
            return ((c) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Not initialized variable reg: 4, insn: 0x00b2: MOVE (r0 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:179), block:B:33:0x00b2 */
        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            InputStream inputStreamA;
            Closeable closeable;
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r.b(obj);
                x1.f1.lb.cache.b bVarE = this.this$0.e();
                Closeable closeable2 = null;
                if (bVarE == null) {
                    return null;
                }
                String str = this.$key;
                a<T> aVar = this.this$0;
                synchronized (str) {
                    try {
                        try {
                            try {
                                x1.f1.lb.cache.b.e eVarT = bVarE.t(str);
                                if (eVarT == null) {
                                    if (x1.f1.lb.config.b.f20643a.t()) {
                                        ((a) aVar).logger.debug("load [" + str + "] no cache", new Object[0]);
                                    }
                                    x1.f1.lb.cache.e.a(null);
                                    return null;
                                }
                                long jD = d1.d();
                                inputStreamA = eVarT.a(0);
                                try {
                                    int i10 = ((inputStreamA.read() & 255) << 24) | ((inputStreamA.read() & 255) << 16) | ((inputStreamA.read() & 255) << 8) | (inputStreamA.read() & 255);
                                    if (i10 <= 0) {
                                        ((a) aVar).logger.warn("load case invalid[" + str + "] size[" + i10 + "]", new Object[0]);
                                        bVarE.A(str);
                                        x1.f1.lb.cache.e.a(inputStreamA);
                                        return null;
                                    }
                                    byte[] bArr = new byte[i10];
                                    inputStreamA.read(bArr, 0, i10);
                                    long jD2 = d1.d() - jD;
                                    if (x1.f1.lb.config.b.f20643a.t()) {
                                        ((a) aVar).logger.debug("load cache[" + str + "]->[" + i10 + "] time[" + jD2 + " ms]", new Object[0]);
                                    } else if (jD2 >= 100) {
                                        String str2 = "load cache[" + str + "]->[" + i10 + "] time[" + jD2 + " ms]";
                                        if (jD2 >= 200) {
                                            ((a) aVar).logger.warn(str2, new Object[0]);
                                        } else {
                                            ((a) aVar).logger.a(str2, new Object[0]);
                                        }
                                    }
                                    x1.f1.lb.cache.e.a(inputStreamA);
                                    return bArr;
                                } catch (IOException e10) {
                                    e = e10;
                                    ((a) aVar).logger.error("load cache failure[" + str + "]", e);
                                    x1.f1.lb.cache.e.a(inputStreamA);
                                    return null;
                                }
                            } catch (Throwable th) {
                                th = th;
                                closeable2 = closeable;
                                x1.f1.lb.cache.e.a(closeable2);
                                throw th;
                            }
                        } catch (IOException e11) {
                            e = e11;
                            inputStreamA = null;
                        } catch (Throwable th2) {
                            th = th2;
                            x1.f1.lb.cache.e.a(closeable2);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "x1.f1.lb.cache.BaseCache", f = "BaseCache.kt", l = {69}, m = "put")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class d extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ a<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(a<T> aVar, v8.f<? super d> fVar) {
            super(fVar);
            this.this$0 = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.f(null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "x1.f1.lb.cache.BaseCache$putArray$2", f = "BaseCache.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "", "<anonymous>", "(Lkotlinx/coroutines/l0;)Z"}, k = 3, mv = {2, 1, 0})
    static final class e extends l implements p<l0, v8.f<? super Boolean>, Object> {
        final /* synthetic */ byte[] $content;
        final /* synthetic */ String $key;
        int label;
        final /* synthetic */ a<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(a<T> aVar, String str, byte[] bArr, v8.f<? super e> fVar) {
            super(2, fVar);
            this.this$0 = aVar;
            this.$key = str;
            this.$content = bArr;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new e(this.this$0, this.$key, this.$content, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super Boolean> fVar) {
            return ((e) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            OutputStream outputStreamF;
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r.b(obj);
                x1.f1.lb.cache.b bVarE = this.this$0.e();
                if (bVarE == null) {
                    return kotlin.coroutines.jvm.internal.b.a(false);
                }
                String str = this.$key;
                byte[] bArr = this.$content;
                a<T> aVar = this.this$0;
                synchronized (str) {
                    OutputStream outputStream = null;
                    try {
                        try {
                            x1.f1.lb.cache.b.c cVarR = bVarE.r(str);
                            if (cVarR != null && (outputStreamF = cVarR.f(0)) != null) {
                                try {
                                    long jD = d1.d();
                                    int length = bArr.length;
                                    outputStreamF.write((length >>> 24) & 255);
                                    outputStreamF.write((length >>> 16) & 255);
                                    outputStreamF.write((length >>> 8) & 255);
                                    outputStreamF.write(length & 255);
                                    outputStreamF.write(bArr);
                                    cVarR.e();
                                    bVarE.flush();
                                    long jD2 = d1.d() - jD;
                                    if (x1.f1.lb.config.b.f20643a.t()) {
                                        ((a) aVar).logger.debug("put cache[" + str + "]->[" + bArr.length + "]", new Object[0]);
                                    } else if (jD2 >= 100) {
                                        String str2 = "put cache[" + str + "]->[" + bArr.length + "] time[" + jD2 + " ms]";
                                        if (jD2 >= 200) {
                                            ((a) aVar).logger.warn(str2, new Object[0]);
                                        } else {
                                            ((a) aVar).logger.a(str2, new Object[0]);
                                        }
                                    }
                                    Boolean boolA = kotlin.coroutines.jvm.internal.b.a(true);
                                    x1.f1.lb.cache.e.a(outputStreamF);
                                    return boolA;
                                } catch (IOException unused) {
                                    outputStream = outputStreamF;
                                } catch (Throwable th) {
                                    th = th;
                                    outputStream = outputStreamF;
                                    x1.f1.lb.cache.e.a(outputStream);
                                    throw th;
                                }
                            } else {
                                Boolean boolA2 = kotlin.coroutines.jvm.internal.b.a(false);
                                x1.f1.lb.cache.e.a(null);
                                return boolA2;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    } catch (IOException unused2) {
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    x1.f1.lb.cache.e.a(outputStream);
                    return kotlin.coroutines.jvm.internal.b.a(false);
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public a(String cacheDirectory, Type type, int i10, long j10, int i11) {
        m.f(cacheDirectory, "cacheDirectory");
        m.f(type, "type");
        this.cacheDirectory = cacheDirectory;
        this.type = type;
        this.logger = q6.c.d(getClass());
        try {
            Map<String, x1.f1.lb.cache.b> map = f20595g;
            if (map.get(cacheDirectory) == null) {
                synchronized (map) {
                    try {
                        File file = new File(cacheDirectory);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        x1.f1.lb.cache.b bVarV = x1.f1.lb.cache.b.v(new File(cacheDirectory), i10, 1, j10);
                        if (i11 > 0) {
                            this.lruCache = new LruCache<>(i11);
                        }
                        map.put(cacheDirectory, bVarV);
                        z zVar = z.f17874a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (Throwable th2) {
            this.logger.error("create cache[" + this.cacheDirectory + "] failure", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final x1.f1.lb.cache.b e() {
        x1.f1.lb.cache.b bVar;
        Map<String, x1.f1.lb.cache.b> map = f20595g;
        synchronized (map) {
            bVar = map.get(this.cacheDirectory);
            if (bVar == null) {
                this.logger.error("no cache found[" + this.cacheDirectory + "]", new Object[0]);
            }
        }
        return bVar;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [x1.f1.lb.cache.a] */
    /* JADX WARN: Type inference failed for: r0v13, types: [x1.f1.lb.cache.a] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [x1.f1.lb.cache.a] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object, x1.f1.lb.cache.a, x1.f1.lb.cache.a<T>] */
    public final Object c(String str, v8.f<? super T> fVar) {
        b bVar;
        ?? r10;
        T t10;
        String str2;
        if (fVar instanceof b) {
            bVar = (b) fVar;
            int i10 = bVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                bVar.label = i10 - Integer.MIN_VALUE;
            } else {
                bVar = new b(this, fVar);
            }
        } else {
            bVar = new b(this, fVar);
        }
        Object objD = bVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = bVar.label;
        if (i11 == 0) {
            r.b(objD);
            try {
                LruCache<String, T> lruCache = this.lruCache;
                if (lruCache != null && (t10 = lruCache.get(str)) != null) {
                    return t10;
                }
                bVar.L$0 = this;
                bVar.L$1 = str;
                bVar.label = 1;
                objD = d(str, bVar);
                if (objD == objC) {
                    return objC;
                }
                r10 = this;
            } catch (Throwable th) {
                th = th;
                r10 = this;
                str2 = null;
            }
            r10.logger.error("parse cache failure[" + str2 + "]->[" + r10.type + "]", th);
            return null;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        str = (String) bVar.L$1;
        r10 = (a) bVar.L$0;
        try {
            r.b(objD);
            r10 = r10;
        } catch (Throwable th2) {
            th = th2;
            str2 = null;
        }
        byte[] bArr = (byte[]) objD;
        if (bArr == null) {
            return null;
        }
        str2 = new String(bArr, ua.d.UTF_8);
        try {
            Object objO = f20594f.o(str2, r10.type);
            LruCache<String, T> lruCache2 = r10.lruCache;
            if (lruCache2 == null) {
                return objO;
            }
            lruCache2.put(str, (T) objO);
            return objO;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object f(String str, T t10, v8.f<? super Boolean> fVar) {
        d dVar;
        a aVar;
        byte[] bytes;
        if (fVar instanceof d) {
            dVar = (d) fVar;
            int i10 = dVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                dVar.label = i10 - Integer.MIN_VALUE;
            } else {
                dVar = new d(this, fVar);
            }
        } else {
            dVar = new d(this, fVar);
        }
        Object obj = dVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = dVar.label;
        if (i11 == 0) {
            r.b(obj);
            try {
                LruCache<String, T> lruCache = this.lruCache;
                if (lruCache != null) {
                    lruCache.put(str, t10);
                }
                if (e() == null) {
                    return kotlin.coroutines.jvm.internal.b.a(false);
                }
                if (t10 instanceof String) {
                    bytes = ((String) t10).getBytes(ua.d.UTF_8);
                    m.e(bytes, "getBytes(...)");
                } else {
                    String strW = f20594f.w(t10);
                    m.e(strW, "toJson(...)");
                    bytes = strW.getBytes(ua.d.UTF_8);
                    m.e(bytes, "getBytes(...)");
                }
                dVar.L$0 = this;
                dVar.label = 1;
                Object objG = g(str, bytes, dVar);
                return objG == objC ? objC : objG;
            } catch (Throwable th) {
                th = th;
                aVar = this;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            aVar = (a) dVar.L$0;
            try {
                r.b(obj);
                return obj;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        aVar.logger.error("put cache failure", th);
        return kotlin.coroutines.jvm.internal.b.a(false);
    }

    public final Object d(String str, v8.f<? super byte[]> fVar) {
        return h.g(a1.b(), new c(this, str, null), fVar);
    }

    public final Object g(String str, byte[] bArr, v8.f<? super Boolean> fVar) {
        return h.g(a1.b(), new e(this, str, bArr, null), fVar);
    }

    public final long h() {
        x1.f1.lb.cache.b bVarE = e();
        if (bVarE != null) {
            return bVarE.size();
        }
        return -1L;
    }

    public /* synthetic */ a(String str, Type type, int i10, long j10, int i11, int i12, g gVar) {
        this(str, type, i10, j10, (i12 & 16) != 0 ? 100 : i11);
    }
}
