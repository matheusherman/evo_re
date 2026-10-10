package x1.f1.lb.user;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import java.util.Map;
import kotlin.Metadata;
import org.apache.log4j.spi.Configurator;
import r8.r;
import r8.u;
import x1.f1.lb.util.l;
import x1.f1.lb.util.m;
import z1.b1.lb.m.extra.user.LoginInfo;
import z1.b1.lb.m.ptv.ApiResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001/B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\n2\u000e\u0010\t\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b¢\u0006\u0004\b\u000b\u0010\fJ\u0091\u0001\u0010\u001d\u001a$\u0012\u0004\u0012\u00028\u0000\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u001b0\u001a\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u000e¢\u0006\u0004\b\u001d\u0010\u001eJS\u0010\"\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u001b2\u0006\u0010\u001f\u001a\u00020\u00142\u001c\u0010 \u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u001b2\b\b\u0002\u0010!\u001a\u00020\u0014¢\u0006\u0004\b\"\u0010#R\u001c\u0010'\u001a\n %*\u0004\u0018\u00010$0$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010.\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010-¨\u00060"}, d2 = {"Lx1/f1/lb/user/b;", "", "<init>", "()V", "Lx1/f1/lb/user/a;", "Lz1/b1/lb/m/ptv/ApiResponse;", "d", "()Lx1/f1/lb/user/a;", "", "map", "Lr8/z;", "e", "(Ljava/util/Map;)V", "X", "", "isLogin", "isRefreshAccessToken", "Lx1/f1/lb/util/m;", "Lx1/f1/lb/user/e;", "updateCallback", "", TypedValues.TransitionType.S_FROM, "username", "password", "loginByCode", "retFalseIfNull", "Lx1/f1/lb/user/b$a;", "Lr8/u;", "", "f", "(ZZLx1/f1/lb/util/m;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lx1/f1/lb/user/b$a;", "caller", "triple", "botDesc", "b", "(Ljava/lang/String;Lr8/u;Ljava/lang/String;)Lr8/u;", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "Lx1/f1/lb/user/d;", "c", "Lx1/f1/lb/user/d;", "ptvAAAAdapter", "Lx1/f1/lb/user/c;", "Lx1/f1/lb/user/c;", "extraAAAAdapter", "a", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f21174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final d ptvAAAAdapter;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final c extraAAAAdapter;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J.\u0010\t\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00018\u0000H¦@¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lx1/f1/lb/user/b$a;", "X", "Y", "", "", "code", "", NotificationCompat.CATEGORY_MESSAGE, "x", "b", "(ILjava/lang/String;Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "a", "()Ljava/lang/String;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a<X, Y> {
        String a();

        Object b(int i10, String str, X x10, v8.f<? super Y> fVar);
    }

    /* JADX INFO: Add missing generic type declarations: [X] */
    /* JADX INFO: renamed from: x1.f1.lb.user.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002$\u0012\u0004\u0012\u00028\u0000\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00020\u0001JD\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00018\u0000H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"x1/f1/lb/user/b$b", "Lx1/f1/lb/user/b$a;", "Lr8/u;", "", "", "", "code", NotificationCompat.CATEGORY_MESSAGE, "x", "b", "(ILjava/lang/String;Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "a", "()Ljava/lang/String;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C0448b<X> implements a<X, u<? extends Boolean, ? extends Integer, ? extends String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f21178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f21179b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f21180c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f21181d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f21182e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f21183f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ m<e<X>> f21184g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f21185h;

        /* JADX INFO: renamed from: x1.f1.lb.user.b$b$a */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.AAAAdapterFactory$updateLocalSession$1", f = "AAAAdapterFactory.kt", l = {77}, m = "convert")
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class a extends kotlin.coroutines.jvm.internal.d {
            int I$0;
            int label;
            /* synthetic */ Object result;

            a(v8.f<? super a> fVar) {
                super(fVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return C0448b.this.b(0, null, null, this);
            }
        }

        C0448b(boolean z10, boolean z11, String str, String str2, String str3, String str4, m<e<X>> mVar, boolean z12) {
            this.f21178a = z10;
            this.f21179b = z11;
            this.f21180c = str;
            this.f21181d = str2;
            this.f21182e = str3;
            this.f21183f = str4;
            this.f21184g = mVar;
            this.f21185h = z12;
        }

        @Override // x1.f1.lb.user.b.a
        public String a() {
            boolean z10 = this.f21185h;
            boolean z11 = this.f21179b;
            String str = this.f21180c;
            String str2 = this.f21182e;
            String str3 = this.f21183f;
            return "l[" + z10 + "], r[" + z11 + "], f[" + str + "], u[" + str2 + "], p[" + ((str3 == null || str3.length() == 0) ? Configurator.NULL : "*") + "], c[" + l.f21408a.a(this.f21181d) + "]";
        }

        /* JADX WARN: Code duplicated, block: B:8:0x0018  */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // x1.f1.lb.user.b.a
        public Object b(int i10, String str, X x10, v8.f<? super u<? extends Boolean, ? extends Integer, ? extends String>> fVar) {
            a aVar;
            if (fVar instanceof a) {
                aVar = (a) fVar;
                int i11 = aVar.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    aVar.label = i11 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(fVar);
                }
            } else {
                aVar = new a(fVar);
            }
            a aVar2 = aVar;
            Object obj = aVar2.result;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i12 = aVar2.label;
            if (i12 == 0) {
                r.b(obj);
                if (x10 == 0) {
                    b.logger.warn("update local session failure, response null object, " + str + "(" + i10 + ")", new Object[0]);
                    if (this.f21178a) {
                        return new u(kotlin.coroutines.jvm.internal.b.a(false), kotlin.coroutines.jvm.internal.b.b(i10), str);
                    }
                    return null;
                }
                f fVar2 = f.f21202a;
                String strB0 = fVar2.B0();
                if (i10 != 0) {
                    if (i10 != 10100035) {
                        return new u(kotlin.coroutines.jvm.internal.b.a(false), kotlin.coroutines.jvm.internal.b.b(i10), str);
                    }
                    if (x10 instanceof LoginInfo) {
                        g.f21276a.h((LoginInfo) x10);
                    }
                    return new u(kotlin.coroutines.jvm.internal.b.a(false), kotlin.coroutines.jvm.internal.b.b(-8), str);
                }
                this.f21184g.a(new e<>(x10, this.f21179b, this.f21180c, this.f21181d, this.f21182e, this.f21183f));
                if (this.f21185h) {
                    aVar2.I$0 = i10;
                    aVar2.label = 1;
                    if (fVar2.a0(strB0, aVar2) == objC) {
                        return objC;
                    }
                }
            } else {
                if (i12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i10 = aVar2.I$0;
                r.b(obj);
            }
            return new u(kotlin.coroutines.jvm.internal.b.a(true), kotlin.coroutines.jvm.internal.b.b(i10), null);
        }
    }

    static {
        b bVar = new b();
        f21174a = bVar;
        logger = q6.c.d(bVar.getClass());
        ptvAAAAdapter = new d();
        extraAAAAdapter = new c();
    }

    public static /* synthetic */ u c(b bVar, String str, u uVar, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = "";
        }
        return bVar.b(str, uVar, str2);
    }

    public static /* synthetic */ a g(b bVar, boolean z10, boolean z11, m mVar, String str, String str2, String str3, String str4, boolean z12, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str = "";
        }
        return bVar.f(z10, z11, mVar, str, (i10 & 16) != 0 ? null : str2, (i10 & 32) != 0 ? null : str3, (i10 & 64) != 0 ? null : str4, (i10 & 128) != 0 ? false : z12);
    }

    public final u<Boolean, Integer, String> b(String caller, u<Boolean, Integer, String> triple, String botDesc) {
        kotlin.jvm.internal.m.f(caller, "caller");
        kotlin.jvm.internal.m.f(triple, "triple");
        kotlin.jvm.internal.m.f(botDesc, "botDesc");
        if (!triple.d().booleanValue()) {
            x1.f1.lb.bot.a.f20583a.l("[auth] failure\nerr_code:" + triple.e() + "\nerror:" + ((Object) triple.f()) + "\nparam:" + botDesc + "\nat:" + caller);
        }
        return triple;
    }

    public final x1.f1.lb.user.a<ApiResponse<?>> d() {
        return ptvAAAAdapter;
    }

    public final void e(Map<?, ?> map) {
        kotlin.jvm.internal.m.f(map, "map");
        x1.f1.lb.heartbeat.f.f20678a.K0(map);
        x1.f1.lb.host.b.f20720a.p(map);
    }

    public final <X> a<X, u<Boolean, Integer, String>> f(boolean isLogin, boolean isRefreshAccessToken, m<e<X>> updateCallback, String from, String username, String password, String loginByCode, boolean retFalseIfNull) {
        kotlin.jvm.internal.m.f(updateCallback, "updateCallback");
        kotlin.jvm.internal.m.f(from, "from");
        return new C0448b(retFalseIfNull, isRefreshAccessToken, from, loginByCode, username, password, updateCallback, isLogin);
    }

    private b() {
    }
}
