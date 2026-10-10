package x1.f1.lb.metric.monitor;

import androidx.core.app.NotificationCompat;
import c9.p;
import c9.q;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.r;
import r8.z;
import tf.AccountInfo;
import tf.SystemInfo;
import ua.n;
import x1.f1.lb.util.d1;
import x1.f1.lb.util.k;
import x1.f1.lb.util.w0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0013\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0017\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0014J\r\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u0003J\u001d\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010\"\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010#J;\u0010*\u001a\u00020\u00182\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010\u00012\b\u0010(\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010)\u001a\u00020\u0006¢\u0006\u0004\b*\u0010+J\u0015\u0010.\u001a\u00020\u00182\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\u0015\u00102\u001a\u00020\u00182\u0006\u00101\u001a\u000200¢\u0006\u0004\b2\u00103J#\u00106\u001a\u00020\u00182\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000104¢\u0006\u0004\b6\u00107J\u0015\u0010:\u001a\u00020\u00182\u0006\u00109\u001a\u000208¢\u0006\u0004\b:\u0010;R\u001c\u0010@\u001a\n =*\u0004\u0018\u00010<0<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010DR\u0018\u0010F\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010BR\u0018\u0010H\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010DR\u0016\u0010\u001c\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010IR\u0016\u0010J\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010IR\u0016\u0010K\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010I¨\u0006L"}, d2 = {"Lx1/f1/lb/metric/monitor/a;", "", "<init>", "()V", "", "expireTS", "", "planName", "leftDur", "j", "(JLjava/lang/String;J)Ljava/lang/String;", "k", "(JJ)Ljava/lang/String;", "plan", "l", "(Ljava/lang/String;)Ljava/lang/String;", "str1", "str2", "", "g", "(Ljava/lang/String;Ljava/lang/String;)Z", "plan1", "plan2", "i", "Lr8/z;", "h", "Ltf/f;", "systemInfo", "session", "q", "(Ltf/f;J)V", "Ltf/a;", "accountInfo", "remainDays", "p", "(Ltf/a;Ljava/lang/String;)V", "Ljava/lang/StringBuilder;", "builder", "desc", "old", "new", "remark", "e", "(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;)V", "Lvf/e;", "appUpgradeMetric", "d", "(Lvf/e;)V", "Lvf/f;", "zappingTimeMetric", "n", "(Lvf/f;)V", "", "map", "m", "(Ljava/util/Map;)V", "Lvf/a;", "playEndMetric", "o", "(Lvf/a;)V", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "c", "Ltf/f;", "lastSystemInfo", "Ltf/a;", "lastAccountInfo", "lastLogSystemInfo", "f", "lastLogAccountInfo", "J", "zappingSession", "zappingTime", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static SystemInfo lastSystemInfo;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static AccountInfo lastAccountInfo;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static SystemInfo lastLogSystemInfo;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static AccountInfo lastLogAccountInfo;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static long session;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static long zappingSession;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static long zappingTime;

    /* JADX INFO: renamed from: x1.f1.lb.metric.monitor.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.metric.monitor.AppUsageMonitor$init$1", f = "AppUsageMonitor.kt", l = {45, 57}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class C0430a extends l implements p<l0, v8.f<? super z>, Object> {
        Object L$0;
        int label;

        /* JADX INFO: renamed from: x1.f1.lb.metric.monitor.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.metric.monitor.AppUsageMonitor$init$1$1", f = "AppUsageMonitor.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class C0431a extends l implements q<kotlinx.coroutines.flow.g<? super String>, Throwable, v8.f<? super z>, Object> {
            /* synthetic */ Object L$0;
            int label;

            C0431a(v8.f<? super C0431a> fVar) {
                super(3, fVar);
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super String> gVar, Throwable th, v8.f<? super z> fVar) {
                C0431a c0431a = new C0431a(fVar);
                c0431a.L$0 = th;
                return c0431a.invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r.b(obj);
                    a.logger.error("load system info failure", (Throwable) this.L$0);
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: x1.f1.lb.metric.monitor.a$a$b */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.google.gson.e f20896a;

            b(com.google.gson.e eVar) {
                this.f20896a = eVar;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(String str, v8.f<? super z> fVar) {
                if (str.length() == 0) {
                    return z.f17874a;
                }
                try {
                    a aVar = a.f20887a;
                    a.lastSystemInfo = (SystemInfo) this.f20896a.n(str, SystemInfo.class);
                } catch (Throwable th) {
                    a.logger.error("parse system info failure", th);
                }
                return z.f17874a;
            }
        }

        /* JADX INFO: renamed from: x1.f1.lb.metric.monitor.a$a$c */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.metric.monitor.AppUsageMonitor$init$1$3", f = "AppUsageMonitor.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class c extends l implements q<kotlinx.coroutines.flow.g<? super String>, Throwable, v8.f<? super z>, Object> {
            /* synthetic */ Object L$0;
            int label;

            c(v8.f<? super c> fVar) {
                super(3, fVar);
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super String> gVar, Throwable th, v8.f<? super z> fVar) {
                c cVar = new c(fVar);
                cVar.L$0 = th;
                return cVar.invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r.b(obj);
                    a.logger.error("load account info failure", (Throwable) this.L$0);
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: x1.f1.lb.metric.monitor.a$a$d */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class d<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.google.gson.e f20897a;

            d(com.google.gson.e eVar) {
                this.f20897a = eVar;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(String str, v8.f<? super z> fVar) {
                if (str.length() == 0) {
                    return z.f17874a;
                }
                try {
                    a aVar = a.f20887a;
                    a.lastAccountInfo = (AccountInfo) this.f20897a.n(str, AccountInfo.class);
                } catch (Throwable th) {
                    a.logger.error("parse account info failure", th);
                }
                return z.f17874a;
            }
        }

        C0430a(v8.f<? super C0430a> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new C0430a(fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((C0430a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0071, code lost:
        
            if (r8.collect(r2, r7) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            com.google.gson.e eVar;
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
                    eVar = (com.google.gson.e) this.L$0;
                    r.b(obj);
                }
                return z.f17874a;
            }
            r.b(obj);
            x1.f1.lb.bot.a.f20583a.j();
            eVar = new com.google.gson.e();
            kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(w0.f21452a.g("app_usage_system_info", ""), new C0431a(null));
            b bVar = new b(eVar);
            this.L$0 = eVar;
            this.label = 1;
            if (fVarF.collect(bVar, this) != objC) {
            }
            return objC;
            kotlinx.coroutines.flow.f fVarF2 = kotlinx.coroutines.flow.h.f(w0.f21452a.g("account_info", ""), new c(null));
            d dVar = new d(eVar);
            this.L$0 = null;
            this.label = 2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v15 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4, types: [long] */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [x1.f1.lb.metric.monitor.a] */
    /* JADX WARN: Type inference failed for: r8v10, types: [long] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void p(AccountInfo accountInfo, String remainDays) {
        ?? r16;
        ?? LongValue;
        String username;
        Object accountId;
        m.f(accountInfo, "accountInfo");
        m.f(remainDays, "remainDays");
        synchronized ("account_info") {
            try {
                AccountInfo accountInfo2 = lastAccountInfo;
                if (m.a(accountInfo, accountInfo2)) {
                    if (lastLogAccountInfo == null) {
                        String strW = new com.google.gson.e().w(accountInfo);
                        logger.a("app_use_info, account login: remainDays[" + remainDays + "] " + strW, new Object[0]);
                        lastLogAccountInfo = accountInfo;
                    }
                    return;
                }
                com.google.gson.e eVar = new com.google.gson.e();
                String strW2 = eVar.w(accountInfo);
                StringBuilder sb2 = new StringBuilder();
                if (accountInfo2 == null) {
                    logger.a("app_use_info, new account login: remainDays[" + remainDays + "] " + strW2, new Object[0]);
                } else {
                    ?? r10 = f20887a;
                    if (!r10.g(accountInfo.getAppChannel(), accountInfo2.getAppChannel())) {
                        f(r10, sb2, "chanel", accountInfo2.getAppChannel(), accountInfo.getAppChannel(), null, 16, null);
                    }
                    if (!r10.g(accountInfo.getAccountType(), accountInfo2.getAccountType())) {
                        f(r10, sb2, "acctType", accountInfo2.getAccountType(), accountInfo.getAccountType(), null, 16, null);
                    }
                    if (!m.a(accountInfo.getAccountId(), accountInfo2.getAccountId())) {
                        f(r10, sb2, "account", accountInfo2.getUsername() + "(" + accountInfo2.getAccountId() + ")", accountInfo.getUsername() + "(" + accountInfo.getAccountId() + ")", null, 16, null);
                    }
                    if (!r10.i(accountInfo.getPlan(), accountInfo2.getPlan())) {
                        f(r10, sb2, "plan", accountInfo2.getPlan(), accountInfo.getPlan(), null, 16, null);
                    }
                    if (!r10.g(accountInfo.getEmail(), accountInfo2.getEmail())) {
                        f(r10, sb2, NotificationCompat.CATEGORY_EMAIL, accountInfo2.getEmail(), accountInfo.getEmail(), null, 16, null);
                    }
                    if (!r10.g(accountInfo.getPhone(), accountInfo2.getPhone())) {
                        f(r10, sb2, "phone", accountInfo2.getPhone(), accountInfo.getPhone(), null, 16, null);
                    }
                    if (!r10.g(accountInfo.getCode(), accountInfo2.getCode())) {
                        f(r10, sb2, "code", accountInfo2.getCode(), accountInfo.getCode(), null, 16, null);
                    }
                    if (m.a(accountInfo.getExpireTS(), accountInfo2.getExpireTS())) {
                        sb2 = sb2;
                    } else {
                        long jD = d1.d();
                        String strL = r10.l(accountInfo2.getPlan());
                        Long expireTS = accountInfo2.getExpireTS();
                        long jLongValue = expireTS != null ? expireTS.longValue() : 0L;
                        String strJ = r10.j(jLongValue, strL, jLongValue - jD);
                        String strL2 = r10.l(accountInfo.getPlan());
                        Long expireTS2 = accountInfo.getExpireTS();
                        LongValue = expireTS2 != null ? expireTS2.longValue() : 0;
                        sb2 = sb2;
                        r10.e(sb2, "expireTS", accountInfo2.getExpireTS(), accountInfo.getExpireTS(), strJ + " -> " + r10.j(LongValue, strL2, LongValue - jD));
                    }
                    if (!r10.g(accountInfo.getDid(), accountInfo2.getDid())) {
                        f(r10, sb2, "did", accountInfo2.getDid(), accountInfo.getDid(), null, 16, null);
                    }
                    if (!r10.g(accountInfo.getAndroidId(), accountInfo2.getAndroidId())) {
                        f(r10, sb2, "androidId", accountInfo2.getAndroidId(), accountInfo.getAndroidId(), null, 16, null);
                    }
                    if (sb2.length() > 0) {
                        logger.a("app_use_info, account login, but changed: remainDays[" + remainDays + "] " + eVar.w(accountInfo2) + " -> " + strW2, new Object[0]);
                    }
                }
                try {
                    if (accountInfo2 == null) {
                        x1.f1.lb.bot.a aVar = x1.f1.lb.bot.a.f20583a;
                        String username2 = accountInfo.getUsername();
                        if (username2 == null || username2.length() == 0) {
                            accountId = accountInfo.getAccountId();
                        } else {
                            accountId = accountInfo.getUsername() + "(" + accountInfo.getAccountId() + ")";
                        }
                        aVar.k("[client first login]\naccount: " + accountId + "\ntype: " + accountInfo.getAccountType() + "\nplan: " + accountInfo.getPlan() + "\nremain: " + remainDays);
                        LongValue = 0;
                    } else if (m.a(accountInfo2.getUsername(), accountInfo.getUsername()) || (username = accountInfo.getUsername()) == null || username.length() == 0) {
                        LongValue = 0;
                        LongValue = 0;
                        if (sb2.length() > 0) {
                            x1.f1.lb.bot.a.f20583a.k("[client account change]\n" + ((Object) sb2) + "\nremain: " + remainDays + " days");
                        }
                    } else {
                        String username3 = accountInfo2.getUsername();
                        if (username3 == null || username3.length() == 0) {
                            LongValue = 0;
                            x1.f1.lb.bot.a.f20583a.k("[client first account login]\naccount: " + accountInfo.getUsername() + "(" + accountInfo.getAccountId() + ")\ntype: " + accountInfo.getAccountType() + "\nplan: " + accountInfo.getPlan() + "\nremain: " + remainDays + " days");
                        } else {
                            x1.f1.lb.bot.a aVar2 = x1.f1.lb.bot.a.f20583a;
                            String username4 = accountInfo2.getUsername();
                            Long accountId2 = accountInfo2.getAccountId();
                            String accountType = accountInfo2.getAccountType();
                            String plan = accountInfo2.getPlan();
                            String str = (plan == null || plan.length() == 0) ? "" : ", ";
                            String plan2 = accountInfo2.getPlan();
                            String username5 = accountInfo.getUsername();
                            Long accountId3 = accountInfo.getAccountId();
                            String strC0 = x1.f1.lb.user.f.f21202a.c0();
                            String plan3 = accountInfo.getPlan();
                            StringBuilder sb3 = new StringBuilder();
                            LongValue = 0;
                            sb3.append("[client switch account]\nfrom: ");
                            sb3.append(username4);
                            sb3.append("(");
                            sb3.append(accountId2);
                            sb3.append("), ");
                            sb3.append(accountType);
                            sb3.append(str);
                            sb3.append(plan2);
                            sb3.append("\nto: ");
                            sb3.append(username5);
                            sb3.append("(");
                            sb3.append(accountId3);
                            sb3.append(")type: ");
                            sb3.append(strC0);
                            sb3.append("\nplan: ");
                            sb3.append(plan3);
                            sb3.append("\nremain: ");
                            sb3.append(remainDays);
                            sb3.append(" days");
                            aVar2.k(sb3.toString());
                        }
                    }
                    lastAccountInfo = accountInfo;
                    lastLogAccountInfo = accountInfo;
                    w0 w0Var = w0.f21452a;
                    m.c(strW2);
                    w0Var.t("account_info", strW2);
                } catch (Throwable th) {
                    th = th;
                    r16 = LongValue;
                    q6.b bVar = logger;
                    Object[] objArr = new Object[1];
                    objArr[r16] = th;
                    bVar.error("set account info failure", objArr);
                }
                z zVar = z.f17874a;
            } catch (Throwable th2) {
                th = th2;
                r16 = 0;
            }
        }
    }

    static {
        a aVar = new a();
        f20887a = aVar;
        logger = q6.c.d(aVar.getClass());
    }

    public static /* synthetic */ void f(a aVar, StringBuilder sb2, String str, Object obj, Object obj2, String str2, int i10, Object obj3) {
        if ((i10 & 16) != 0) {
            str2 = "";
        }
        aVar.e(sb2, str, obj, obj2, str2);
    }

    private final boolean g(String str1, String str2) {
        if (str1 == null) {
            str1 = "";
        }
        String string = n.Q0(str1).toString();
        if (str2 == null) {
            str2 = "";
        }
        return m.a(string, n.Q0(str2).toString());
    }

    private final boolean i(String plan1, String plan2) {
        if (plan1 == null) {
            plan1 = "";
        }
        String string = n.Q0(plan1).toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string.toLowerCase(locale);
        m.e(lowerCase, "toLowerCase(...)");
        if (plan2 == null) {
            plan2 = "";
        }
        String lowerCase2 = n.Q0(plan2).toString().toLowerCase(locale);
        m.e(lowerCase2, "toLowerCase(...)");
        if (m.a(lowerCase, lowerCase2)) {
            return true;
        }
        return (lowerCase.length() == 0 && m.a(lowerCase2, "expired")) || (m.a(lowerCase, "expired") && lowerCase2.length() == 0);
    }

    private final String k(long expireTS, long leftDur) {
        if (expireTS <= 0) {
            return "";
        }
        String strB = d1.b(Math.abs(leftDur), null);
        m.e(strB, "generateDurationDescText(...)");
        return strB;
    }

    private final String l(String plan) {
        return (plan == null || plan.length() == 0) ? "none" : n.Q0(plan).toString();
    }

    public final void d(vf.e appUpgradeMetric) {
        m.f(appUpgradeMetric, "appUpgradeMetric");
        try {
            String strW = new com.google.gson.e().w(appUpgradeMetric);
            logger.a("app_use_info, app upgrade, " + strW, new Object[0]);
        } catch (Throwable th) {
            logger.error("app upgrade log failure", th);
        }
    }

    public final void e(StringBuilder builder, String desc, Object old, Object obj, String remark) {
        m.f(builder, "builder");
        m.f(desc, "desc");
        m.f(remark, "remark");
        builder.append(desc);
        builder.append(": ");
        builder.append(old);
        builder.append(" -> ");
        builder.append(obj);
        if (remark.length() > 0) {
            builder.append("(");
            builder.append(remark);
            builder.append(")");
        }
        builder.append("\n");
    }

    public final void m(Map<String, ? extends Object> map) {
        m.f(map, "map");
        logger.a("app_use_info, session[" + session + "] play abnormal: " + map, new Object[0]);
    }

    public final void n(vf.f zappingTimeMetric) {
        m.f(zappingTimeMetric, "zappingTimeMetric");
        zappingSession = zappingTimeMetric.t();
        zappingTime = zappingTimeMetric.x();
    }

    public final void o(vf.a playEndMetric) {
        m.f(playEndMetric, "playEndMetric");
        String strB = d1.b(d1.c() - playEndMetric.K(), null);
        String strU = playEndMetric.u();
        String strN = playEndMetric.N();
        String strG = playEndMetric.g();
        long jK = playEndMetric.K();
        long j10 = jK == zappingSession ? zappingTime : -1L;
        int iO = playEndMetric.o();
        int iK = playEndMetric.k();
        int iC = playEndMetric.c();
        String strB2 = d1.b(playEndMetric.O(), null);
        int iP = playEndMetric.p();
        int iA = playEndMetric.A();
        logger.a("app_use_info, session[" + session + "] play end[" + strU + "][" + strG + "][" + strN + "] start at[" + jK + "] zt[" + j10 + "] dur[" + strB + "] rtt[" + iO + ", " + iC + ", " + iK + "] buffering[" + strB2 + "] noSignal[" + iP + "] restart[" + iA + "]", new Object[0]);
    }

    public final void q(SystemInfo systemInfo, long session2) {
        m.f(systemInfo, "systemInfo");
        synchronized ("system_info") {
            try {
                SystemInfo systemInfo2 = lastSystemInfo;
                String strX = k.f21398a.x();
                session = session2;
                if (m.a(systemInfo, systemInfo2)) {
                    if (lastLogSystemInfo == null) {
                        String strW = new com.google.gson.e().w(systemInfo);
                        logger.a("app_use_info, client start: [" + strX + "] session[" + session2 + "] " + strW, new Object[0]);
                        lastLogSystemInfo = systemInfo;
                    }
                    return;
                }
                com.google.gson.e eVar = new com.google.gson.e();
                String strW2 = eVar.w(systemInfo);
                if (systemInfo2 == null) {
                    logger.a("app_use_info, new client created: [" + strX + "] session[" + session2 + "]  " + strW2, new Object[0]);
                    String etherMac = systemInfo.getEtherMac();
                    if (etherMac == null) {
                        etherMac = null;
                    } else if (etherMac.length() == 0) {
                        etherMac = systemInfo.getWifiMac();
                    }
                    x1.f1.lb.bot.a.f20583a.k("[new client]\nmanufacture: " + systemInfo.getManufacturer() + ", brand: " + systemInfo.getBrand() + ", model: " + systemInfo.getModel() + "\nmac: " + etherMac + "\n" + systemInfo.getFingerprint());
                } else {
                    logger.a("app_use_info, client start, but changed: [" + strX + "] session[" + session2 + "] " + eVar.w(systemInfo2) + " -> " + strW2, new Object[0]);
                }
                lastSystemInfo = systemInfo;
                lastLogSystemInfo = systemInfo;
                w0 w0Var = w0.f21452a;
                m.c(strW2);
                w0Var.t("app_usage_system_info", strW2);
                z zVar = z.f17874a;
            } catch (Throwable th) {
                logger.error("set system info failure", th);
            }
        }
    }

    private a() {
    }

    private final String j(long expireTS, String planName, long leftDur) {
        String strK = k(expireTS, leftDur);
        if (strK.length() == 0) {
            return "[" + planName + "]";
        }
        if (leftDur < 0) {
            return "[" + planName + "(" + strK + " expired)]";
        }
        return "[" + planName + "(" + strK + " left)]";
    }

    public final void h() {
        j.d(m0.a(a1.b()), null, null, new C0430a(null), 3, null);
    }
}
