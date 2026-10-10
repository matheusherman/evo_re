package x1.f1.lb.util;

import android.view.KeyEvent;
import java.util.HashSet;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J!\u0010\t\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0003J\r\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0011J\r\u0010\u0018\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\u0011J\r\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u0003R\u001c\u0010\u001e\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R(\u00102\u001a\b\u0012\u0004\u0012\u00020\u000b0+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u00105R\u0016\u00108\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u00105R\u0016\u00109\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u00105R\u0016\u0010:\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u00105R$\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010;R&\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u000b0<j\b\u0012\u0004\u0012\u00020\u000b`=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010>R\u0016\u0010A\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010@¨\u0006B"}, d2 = {"Lx1/f1/lb/util/d0;", "", "<init>", "()V", "Lr8/z;", "m", "Lkotlin/Function1;", "", "onTip", "i", "(Lc9/l;)V", "", "key", "q", "(Ljava/lang/String;)V", "h", "n", "()Z", "j", "Landroid/view/KeyEvent;", "keyEvent", "p", "(Landroid/view/KeyEvent;)Z", "k", "l", "o", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "Ljava/util/Timer;", "c", "Ljava/util/Timer;", "timer", "", "d", "J", "lastKeyPress", "Lnf/f;", "e", "Lnf/f;", "lastEvent", "", "f", "Ljava/util/List;", "getEcoModePics", "()Ljava/util/List;", "s", "(Ljava/util/List;)V", "ecoModePics", "", "g", "I", "oldKeyPressCnt", "oldTouchCnt", "keyPressCnt", "touchCnt", "isTipStb", "Lc9/l;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "saveFlag", "Z", "isInEcoMode", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static Timer timer;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static nf.f lastEvent;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static int oldKeyPressCnt;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static int oldTouchCnt;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static int keyPressCnt;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static int touchCnt;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static int isTipStb;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static c9.l<? super Boolean, r8.z> onTip;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private static boolean isInEcoMode;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f21360a = new d0();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger = q6.c.d(d0.class);

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long lastKeyPress = d1.c();

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static List<String> ecoModePics = kotlin.collections.r.l();

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static HashSet<String> saveFlag = new HashSet<>();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.util.EcoModeHelper$load$1", f = "EcoModeHelper.kt", l = {40, 46, 52}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.util.EcoModeHelper$load$1$1", f = "EcoModeHelper.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super Integer>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;

            a(v8.f<? super a> fVar) {
                super(3, fVar);
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super Integer> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                a aVar = new a(fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    d0.logger.error("get [key_press_cnt_key] failure", (Throwable) this.L$0);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: x1.f1.lb.util.d0$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class C0466b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0466b<T> f21374a = new C0466b<>();

            @Override // kotlinx.coroutines.flow.g
            public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                return b(((Number) obj).intValue(), fVar);
            }

            C0466b() {
            }

            public final Object b(int i10, v8.f<? super r8.z> fVar) {
                d0.oldKeyPressCnt = i10;
                return r8.z.f17874a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.util.EcoModeHelper$load$1$3", f = "EcoModeHelper.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class c extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super Integer>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;

            c(v8.f<? super c> fVar) {
                super(3, fVar);
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super Integer> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                c cVar = new c(fVar);
                cVar.L$0 = th;
                return cVar.invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    d0.logger.error("get [touch_cnt_key] failure", (Throwable) this.L$0);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class d<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d<T> f21375a = new d<>();

            @Override // kotlinx.coroutines.flow.g
            public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                return b(((Number) obj).intValue(), fVar);
            }

            d() {
            }

            public final Object b(int i10, v8.f<? super r8.z> fVar) {
                d0.oldTouchCnt = i10;
                return r8.z.f17874a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.util.EcoModeHelper$load$1$5", f = "EcoModeHelper.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class e extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super Integer>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;

            e(v8.f<? super e> fVar) {
                super(3, fVar);
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super Integer> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                e eVar = new e(fVar);
                eVar.L$0 = th;
                return eVar.invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    d0.logger.error("get [is_tip_stb_key] failure", (Throwable) this.L$0);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class f<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final f<T> f21376a = new f<>();

            @Override // kotlinx.coroutines.flow.g
            public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                return b(((Number) obj).intValue(), fVar);
            }

            f() {
            }

            public final Object b(int i10, v8.f<? super r8.z> fVar) {
                d0.isTipStb = i10;
                return r8.z.f17874a;
            }
        }

        b(v8.f<? super b> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new b(fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((b) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0088, code lost:
        
            if (r9.collect(r1, r8) == r0) goto L20;
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
                    if (i10 != 2) {
                        if (i10 == 3) {
                            r8.r.b(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        r8.r.b(obj);
                        kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(w0.f21452a.g("is_tip_stb_key", kotlin.coroutines.jvm.internal.b.b(0)), new e(null));
                        kotlinx.coroutines.flow.g gVar = f.f21376a;
                        this.label = 3;
                    }
                } else {
                    r8.r.b(obj);
                }
                return r8.z.f17874a;
            }
            r8.r.b(obj);
            kotlinx.coroutines.flow.f fVarF2 = kotlinx.coroutines.flow.h.f(w0.f21452a.g("key_press_cnt_key", kotlin.coroutines.jvm.internal.b.b(0)), new a(null));
            kotlinx.coroutines.flow.g gVar2 = C0466b.f21374a;
            this.label = 1;
            if (fVarF2.collect(gVar2, this) != objC) {
            }
            return objC;
            kotlinx.coroutines.flow.f fVarF3 = kotlinx.coroutines.flow.h.f(w0.f21452a.g("touch_cnt_key", kotlin.coroutines.jvm.internal.b.b(0)), new c(null));
            kotlinx.coroutines.flow.g gVar3 = d.f21375a;
            this.label = 2;
            if (fVarF3.collect(gVar3, this) != objC) {
                kotlinx.coroutines.flow.f fVarF4 = kotlinx.coroutines.flow.h.f(w0.f21452a.g("is_tip_stb_key", kotlin.coroutines.jvm.internal.b.b(0)), new e(null));
                kotlinx.coroutines.flow.g gVar4 = f.f21376a;
                this.label = 3;
            }
            return objC;
        }
    }

    public final void h() {
        isInEcoMode = true;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"x1/f1/lb/util/d0$a", "Ljava/util/TimerTask;", "Lr8/z;", "run", "()V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (d0.lastEvent == null && d1.c() - d0.lastKeyPress > x1.f1.lb.user.f.f21202a.Y()) {
                nf.f fVar = new nf.f();
                xe.c.c().o(fVar);
                d0.lastEvent = fVar;
                uf.c.f19486a.j("enterEcoMode");
            }
        }
    }

    public static /* synthetic */ void r(d0 d0Var, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        d0Var.q(str);
    }

    public final void i(c9.l<? super Boolean, r8.z> onTip2) {
        kotlin.jvm.internal.m.f(onTip2, "onTip");
        Timer timer2 = timer;
        if (timer2 != null) {
            timer2.cancel();
            timer2.purge();
        }
        onTip = onTip2;
        Timer timer3 = new Timer("Key monitor");
        timer = timer3;
        timer3.schedule(new a(), 30000L, 30000L);
        if (x1.f1.lb.config.b.f20643a.t()) {
            ecoModePics = kotlin.collections.r.o("https://upload-images.jianshu.io/upload_images/5809200-7fe8c323e533f656.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240", "https://upload-images.jianshu.io/upload_images/5809200-736bc3917fe92142.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240", "https://upload-images.jianshu.io/upload_images/5809200-a99419bb94924e6d.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240");
        }
        logger.a("key service onCreate", new Object[0]);
    }

    public final boolean j() {
        return isInEcoMode;
    }

    public final boolean k() {
        return (keyPressCnt > 0 || oldKeyPressCnt > 0) && oldTouchCnt == 0 && touchCnt == 0;
    }

    public final boolean l() {
        return oldTouchCnt > 0 || touchCnt > 0;
    }

    public final void o() {
        Timer timer2 = timer;
        if (timer2 != null) {
            timer = null;
            timer2.cancel();
        }
    }

    public final boolean p(KeyEvent keyEvent) {
        if (x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("key service onKeyEvent, keyCode[{}], action[{}]", keyEvent != null ? Integer.valueOf(keyEvent.getKeyCode()) : null, keyEvent != null ? Integer.valueOf(keyEvent.getAction()) : null);
        }
        keyPressCnt++;
        r(this, null, 1, null);
        return n();
    }

    public final void q(String key) {
        if (key != null) {
            int iHashCode = key.hashCode();
            if (iHashCode != -1613682515) {
                if (iHashCode != -302233207) {
                    if (iHashCode == 1190210568 && key.equals("is_tip_stb_key")) {
                        w0.f21452a.r("is_tip_stb_key", isTipStb);
                        return;
                    }
                } else if (key.equals("touch_cnt_key")) {
                    if (touchCnt <= oldTouchCnt || saveFlag.contains(key)) {
                        return;
                    }
                    saveFlag.add(key);
                    w0.f21452a.r("touch_cnt_key", touchCnt);
                    return;
                }
            } else if (key.equals("key_press_cnt_key")) {
                if (keyPressCnt <= oldKeyPressCnt || saveFlag.contains(key)) {
                    return;
                }
                saveFlag.add(key);
                w0.f21452a.r("key_press_cnt_key", keyPressCnt);
                return;
            }
        }
        w0 w0Var = w0.f21452a;
        w0Var.r("key_press_cnt_key", keyPressCnt);
        w0Var.r("touch_cnt_key", touchCnt);
        w0Var.r("is_tip_stb_key", isTipStb);
    }

    public final void s(List<String> list) {
        kotlin.jvm.internal.m.f(list, "<set-?>");
        ecoModePics = list;
    }

    private d0() {
    }

    public final void m() {
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new b(null), 3, null);
    }

    public final boolean n() {
        lastKeyPress = d1.c();
        if (!isInEcoMode && lastEvent == null) {
            return false;
        }
        logger.debug("eco-exit onclick engine", new Object[0]);
        isInEcoMode = false;
        lastEvent = null;
        xe.c.c().o(new nf.f(false));
        return true;
    }
}
