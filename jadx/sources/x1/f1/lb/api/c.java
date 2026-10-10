package x1.f1.lb.api;

import c9.q;
import kotlin.Metadata;
import r8.r;
import r8.z;
import z1.b1.lb.m.extra.ApiResponse;
import z1.b1.lb.m.extra.subscription.RechargeInfo;
import z1.b1.lb.m.extra.subscription.RechargeRequest;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lx1/f1/lb/api/c;", "", "<init>", "()V", "", "code", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/extra/ApiResponse;", "Lz1/b1/lb/m/extra/subscription/RechargeInfo;", "c", "(Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "Lq6/b;", "b", "Lq6/b;", "logger", "Lx1/f1/lb/host/a;", "Lx1/f1/lb/api/m;", "Lx1/f1/lb/host/a;", "rechargeApiServerProvider", "Lcom/skydoves/sandwich/retry/b;", "d", "Lcom/skydoves/sandwich/retry/b;", "retryPolicy", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f20556a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final x1.f1.lb.host.a<m> rechargeApiServerProvider;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final com.skydoves.sandwich.retry.b retryPolicy;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"x1/f1/lb/api/c$a", "Lcom/skydoves/sandwich/retry/b;", "", "attempt", "", "message", "b", "(ILjava/lang/String;)I", "", "a", "(ILjava/lang/String;)Z", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements com.skydoves.sandwich.retry.b {
        @Override // com.skydoves.sandwich.retry.b
        public boolean a(int attempt, String message) {
            return attempt <= 3;
        }

        @Override // com.skydoves.sandwich.retry.b
        public int b(int attempt, String message) {
            return 3000;
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.ApiSubscriptionClient$recharge$2", f = "ApiSubscriptionClient.kt", l = {35}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/extra/ApiResponse;", "Lz1/b1/lb/m/extra/subscription/RechargeInfo;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<RechargeInfo>>>, Object> {
        final /* synthetic */ String $code;
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, v8.f<? super b> fVar) {
            super(3, fVar);
            this.$code = str;
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<RechargeInfo>>> fVar) {
            b bVar = new b(this.$code, fVar);
            bVar.I$0 = i10;
            bVar.L$0 = str;
            return bVar.invokeSuspend(z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<RechargeInfo>>> fVar) {
            return b(num.intValue(), str, fVar);
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
                int i11 = this.I$0;
                String str = (String) this.L$0;
                if (x1.f1.lb.config.b.f20643a.t()) {
                    c.logger.debug("recharge, request[ {}, {} ]", kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                m mVar = (m) c.rechargeApiServerProvider.a(i11);
                if (mVar != null) {
                    RechargeRequest rechargeRequest = new RechargeRequest(this.$code);
                    this.label = 1;
                    obj = mVar.a(rechargeRequest, this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("recharge api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("recharge api service is null");
        }
    }

    static {
        q6.b bVarD = q6.c.d(c.class);
        kotlin.jvm.internal.m.e(bVarD, "getLogger(...)");
        logger = bVarD;
        rechargeApiServerProvider = x1.f1.lb.host.b.f20720a.k();
        retryPolicy = new a();
    }

    public final Object c(String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<RechargeInfo>>> fVar) {
        return com.skydoves.sandwich.retry.a.a(retryPolicy, new b(str, null), fVar);
    }

    private c() {
    }
}
