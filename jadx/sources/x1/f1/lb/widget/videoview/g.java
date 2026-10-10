package x1.f1.lb.widget.videoview;

import java.io.IOException;
import java.lang.reflect.Type;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00132\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001a\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lx1/f1/lb/widget/videoview/g;", "", "<init>", "()V", "", "g", "()Ljava/lang/String;", "cacheDirectory", "", "appVersion", "", "maxSize", "Lr8/z;", "e", "(Ljava/lang/String;IJ)V", "videoName", "position", "f", "(Ljava/lang/String;J)V", "Lkotlinx/coroutines/flow/f;", "d", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/f;", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "Lx1/f1/lb/cache/a;", "c", "Lx1/f1/lb/cache/a;", "diskLruCache", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f21577a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger = q6.c.d(g.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static x1.f1.lb.cache.a<Long> diskLruCache;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayPositionCache$get$1", f = "PlayPositionCache.kt", l = {63, 69, 70, 72}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super Long>, v8.f<? super r8.z>, Object> {
        final /* synthetic */ String $videoName;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, v8.f<? super a> fVar) {
            super(2, fVar);
            this.$videoName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            a aVar = new a(this.$videoName, fVar);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.flow.g<? super Long> gVar, v8.f<? super r8.z> fVar) {
            return ((a) create(gVar, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code duplicated, block: B:32:0x0080 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:12:0x002c, B:17:0x0037, B:30:0x007c, B:32:0x0080, B:34:0x0086, B:27:0x005d), top: B:44:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:33:0x0085  */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0057, code lost:
        
            if (r1.emit(r14, r13) == r0) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0092, code lost:
        
            if (r1.emit(r14, r13) == r0) goto L39;
         */
        /* JADX WARN: Type inference failed for: r1v0, types: [int, kotlinx.coroutines.flow.g] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: int
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:59)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:32)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:508)
        	at jadx.core.dex.nodes.utils.TypeUtils.getClassTypeVars(TypeUtils.java:53)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:175)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Throwable th;
            kotlinx.coroutines.flow.g gVar;
            Long l10;
            long jLongValue;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            ?? r10 = this.label;
            try {
                if (r10 != 0) {
                    if (r10 != 1) {
                        if (r10 != 2) {
                            if (r10 != 3) {
                                if (r10 == 4) {
                                    th = (Throwable) this.L$0;
                                    r8.r.b(obj);
                                    g.logger.error("load play_position failure[" + g.f21577a.g() + "." + this.$videoName + "]", th);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                r8.r.b(obj);
                            }
                        } else {
                            gVar = (kotlinx.coroutines.flow.g) this.L$0;
                            r8.r.b(obj);
                            l10 = (Long) obj;
                            if (l10 != null) {
                                jLongValue = l10.longValue();
                            } else {
                                jLongValue = 0;
                            }
                            Long lC = kotlin.coroutines.jvm.internal.b.c(jLongValue);
                            this.L$0 = gVar;
                            this.label = 3;
                        }
                        return r8.z.f17874a;
                    }
                    r8.r.b(obj);
                    return r8.z.f17874a;
                }
                r8.r.b(obj);
                gVar = (kotlinx.coroutines.flow.g) this.L$0;
                x1.f1.lb.cache.a aVar = g.diskLruCache;
                if (aVar == null) {
                    Long lC2 = kotlin.coroutines.jvm.internal.b.c(0L);
                    this.label = 1;
                } else {
                    String strE = x1.f1.lb.util.o.f21430a.e(g.f21577a.g(), this.$videoName);
                    this.L$0 = gVar;
                    this.label = 2;
                    obj = aVar.c(strE, this);
                    if (obj != objC) {
                        l10 = (Long) obj;
                        if (l10 != null) {
                            jLongValue = l10.longValue();
                        } else {
                            jLongValue = 0;
                        }
                        Long lC3 = kotlin.coroutines.jvm.internal.b.c(jLongValue);
                        this.L$0 = gVar;
                        this.label = 3;
                    }
                }
                return objC;
            } catch (Throwable th2) {
                Long lC4 = kotlin.coroutines.jvm.internal.b.c(0L);
                this.L$0 = th2;
                this.label = 4;
                if (r10.emit(lC4, this) != objC) {
                    th = th2;
                }
                return objC;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayPositionCache$put$1", f = "PlayPositionCache.kt", l = {47}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class c extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ x1.f1.lb.cache.a<Long> $cache;
        final /* synthetic */ long $position;
        final /* synthetic */ String $videoName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, x1.f1.lb.cache.a<Long> aVar, long j10, v8.f<? super c> fVar) {
            super(2, fVar);
            this.$videoName = str;
            this.$cache = aVar;
            this.$position = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new c(this.$videoName, this.$cache, this.$position, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((c) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
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
                    String strE = x1.f1.lb.util.o.f21430a.e(g.f21577a.g(), this.$videoName);
                    x1.f1.lb.cache.a<Long> aVar = this.$cache;
                    Long lC = kotlin.coroutines.jvm.internal.b.c(this.$position);
                    this.label = 1;
                    obj = aVar.f(strE, lC, this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                if (x1.f1.lb.config.b.f20643a.t()) {
                    g.logger.debug("cache play_position [" + g.f21577a.g() + "." + this.$videoName + "] position[" + this.$position + "] [" + zBooleanValue + "]", new Object[0]);
                }
            } catch (Throwable th) {
                g.logger.error("cache play_position failure[" + g.f21577a.g() + "." + this.$videoName + "] position[" + this.$position + "]", th);
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"x1/f1/lb/widget/videoview/g$b", "Lf3/a;", "", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends f3.a<Long> {
        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String g() {
        x1.f1.lb.user.f fVar = x1.f1.lb.user.f.f21202a;
        return (kotlin.jvm.internal.m.a(fVar.c0(), "guest") || fVar.D0().length() == 0) ? of.a.f16585a.k() : of.a.f16585a.b();
    }

    public final kotlinx.coroutines.flow.f<Long> d(String videoName) {
        kotlin.jvm.internal.m.f(videoName, "videoName");
        return kotlinx.coroutines.flow.h.y(kotlinx.coroutines.flow.h.v(new a(videoName, null)), kotlinx.coroutines.a1.b());
    }

    public final void e(String cacheDirectory, int appVersion, long maxSize) {
        kotlin.jvm.internal.m.f(cacheDirectory, "cacheDirectory");
        try {
            Type typeD = new b().d();
            kotlin.jvm.internal.m.e(typeD, "getType(...)");
            diskLruCache = new x1.f1.lb.cache.a<>(cacheDirectory, typeD, appVersion, maxSize, 0, 16, null);
        } catch (IOException e10) {
            logger.error("create play position cache failure", e10);
        }
    }

    public final void f(String videoName, long position) {
        kotlin.jvm.internal.m.f(videoName, "videoName");
        x1.f1.lb.cache.a<Long> aVar = diskLruCache;
        if (aVar == null) {
            return;
        }
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new c(videoName, aVar, position, null), 3, null);
    }

    private g() {
    }
}
