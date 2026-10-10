package x1.f1.lb.api;

import c9.q;
import com.taobao.sophix.PatchStatus;
import kotlin.Metadata;
import r8.r;
import r8.z;
import z1.b1.lb.m.extra.ApiRequestBasic;
import z1.b1.lb.m.extra.ApiResponse;
import z1.b1.lb.m.extra.ApiResponseBasic;
import z1.b1.lb.m.extra.user.GuestLoginInfo;
import z1.b1.lb.m.extra.user.GuestLoginRequest;
import z1.b1.lb.m.extra.user.LinkRequest;
import z1.b1.lb.m.extra.user.LoginInfo;
import z1.b1.lb.m.extra.user.LoginRequest;
import z1.b1.lb.m.extra.user.QueryMetaInfo;
import z1.b1.lb.m.extra.user.QueryPropertiesInfo;
import z1.b1.lb.m.extra.user.RefreshInfo;
import z1.b1.lb.m.extra.user.RefreshTokenRequest;
import z1.b1.lb.m.extra.user.RegisterInfo;
import z1.b1.lb.m.extra.user.RegisterRequest;
import z1.b1.lb.m.extra.user.ResetPasswordRequest;
import z1.b1.lb.m.extra.user.VerificationCodeRequest;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0086@¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00050\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0086@¢\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00050\u0004H\u0086@¢\u0006\u0004\b\u0016\u0010\bJ$\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00050\u00042\u0006\u0010\u0017\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b\u0019\u0010\u001aJ.\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u00042\u0006\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b\u001d\u0010\u001eJ>\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00050\u00042\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b$\u0010%J<\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u00042\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b(\u0010%J\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\u0004H\u0086@¢\u0006\u0004\b*\u0010\bJ<\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00050\u00042\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b+\u0010%R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00103\u001a\b\u0012\u0004\u0012\u000201008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u00102R\u001c\u00105\u001a\b\u0012\u0004\u0012\u000204008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u00102R\u001c\u00107\u001a\b\u0012\u0004\u0012\u000206008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u00102R\u001c\u00109\u001a\b\u0012\u0004\u0012\u000208008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u00102R\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020:008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u00102R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010=¨\u0006?"}, d2 = {"Lx1/f1/lb/api/a;", "", "<init>", "()V", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/extra/ApiResponse;", "Lz1/b1/lb/m/extra/user/QueryMetaInfo;", "h", "(Lv8/f;)Ljava/lang/Object;", "", "accountId", "", "accountName", "Lz1/b1/lb/m/extra/user/GuestLoginInfo;", "c", "(Ljava/lang/Long;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "Lz1/b1/lb/m/extra/user/LoginRequest;", "loginRequest", "Lz1/b1/lb/m/extra/user/LoginInfo;", "e", "(Lz1/b1/lb/m/extra/user/LoginRequest;Lv8/f;)Ljava/lang/Object;", "Lz1/b1/lb/m/extra/user/QueryPropertiesInfo;", "g", "refreshToken", "Lz1/b1/lb/m/extra/user/RefreshInfo;", "i", "(Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "contact", "digitalCode", "m", "(Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "username", "password", "verificationCode", "invitationCode", "Lz1/b1/lb/m/extra/user/RegisterInfo;", "j", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "newPassword", "captchaCode", "l", "Lz1/b1/lb/m/extra/ApiResponseBasic;", "f", "d", "Lq6/b;", "b", "Lq6/b;", "logger", "Lx1/f1/lb/host/a;", "Lx1/f1/lb/api/d;", "Lx1/f1/lb/host/a;", "authServerProvider", "Lx1/f1/lb/api/f;", "heartbeatServerProvider", "Lx1/f1/lb/api/n;", "upgradeServerProvider", "Lx1/f1/lb/api/g;", "noticeServerProvider", "Lx1/f1/lb/api/e;", "feedbackServerProvider", "Lcom/skydoves/sandwich/retry/b;", "Lcom/skydoves/sandwich/retry/b;", "retryPolicy", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20544a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final x1.f1.lb.host.a<x1.f1.lb.api.d> authServerProvider;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static x1.f1.lb.host.a<x1.f1.lb.api.f> heartbeatServerProvider;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static x1.f1.lb.host.a<n> upgradeServerProvider;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static x1.f1.lb.host.a<x1.f1.lb.api.g> noticeServerProvider;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static x1.f1.lb.host.a<x1.f1.lb.api.e> feedbackServerProvider;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final com.skydoves.sandwich.retry.b retryPolicy;

    /* JADX INFO: renamed from: x1.f1.lb.api.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"x1/f1/lb/api/a$a", "Lcom/skydoves/sandwich/retry/b;", "", "attempt", "", "message", "b", "(ILjava/lang/String;)I", "", "a", "(ILjava/lang/String;)Z", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C0402a implements com.skydoves.sandwich.retry.b {
        @Override // com.skydoves.sandwich.retry.b
        public boolean a(int attempt, String message) {
            return attempt <= 3;
        }

        @Override // com.skydoves.sandwich.retry.b
        public int b(int attempt, String message) {
            return 3000;
        }

        C0402a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.Api3AClient$guestLogin$2", f = "Api3AClient.kt", l = {72}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/extra/ApiResponse;", "Lz1/b1/lb/m/extra/user/GuestLoginInfo;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<GuestLoginInfo>>>, Object> {
        final /* synthetic */ Long $accountId;
        final /* synthetic */ String $accountName;
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Long l10, String str, v8.f<? super b> fVar) {
            super(3, fVar);
            this.$accountId = l10;
            this.$accountName = str;
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<GuestLoginInfo>>> fVar) {
            b bVar = new b(this.$accountId, this.$accountName, fVar);
            bVar.I$0 = i10;
            bVar.L$0 = str;
            return bVar.invokeSuspend(z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<GuestLoginInfo>>> fVar) {
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
                    a.logger.debug("guest login, request[ {}, {} ]", kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                x1.f1.lb.api.d dVar = (x1.f1.lb.api.d) a.authServerProvider.a(i11);
                if (dVar != null) {
                    GuestLoginRequest guestLoginRequest = new GuestLoginRequest(this.$accountId, this.$accountName);
                    this.label = 1;
                    obj = dVar.d(guestLoginRequest, this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("guestLogin api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("guestLogin api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.Api3AClient$linkContact$2", f = "Api3AClient.kt", l = {232}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/extra/ApiResponse;", "Lz1/b1/lb/m/extra/user/LoginInfo;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class c extends kotlin.coroutines.jvm.internal.l implements q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<LoginInfo>>>, Object> {
        final /* synthetic */ String $contact;
        final /* synthetic */ String $digitalCode;
        final /* synthetic */ String $password;
        final /* synthetic */ String $verificationCode;
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, String str2, String str3, String str4, v8.f<? super c> fVar) {
            super(3, fVar);
            this.$contact = str;
            this.$digitalCode = str2;
            this.$password = str3;
            this.$verificationCode = str4;
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<LoginInfo>>> fVar) {
            c cVar = new c(this.$contact, this.$digitalCode, this.$password, this.$verificationCode, fVar);
            cVar.I$0 = i10;
            cVar.L$0 = str;
            return cVar.invokeSuspend(z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<LoginInfo>>> fVar) {
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
                    a.logger.debug("linkContact, request[ {}, {} ]", kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                x1.f1.lb.api.d dVar = (x1.f1.lb.api.d) a.authServerProvider.a(i11);
                if (dVar != null) {
                    LinkRequest linkRequest = new LinkRequest(this.$contact, this.$digitalCode, this.$password, this.$verificationCode);
                    this.label = 1;
                    obj = dVar.h(linkRequest, this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("linkContact api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("linkContact api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.Api3AClient$loginExtra$2", f = "Api3AClient.kt", l = {81}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/extra/ApiResponse;", "Lz1/b1/lb/m/extra/user/LoginInfo;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class d extends kotlin.coroutines.jvm.internal.l implements q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<LoginInfo>>>, Object> {
        final /* synthetic */ LoginRequest $loginRequest;
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(LoginRequest loginRequest, v8.f<? super d> fVar) {
            super(3, fVar);
            this.$loginRequest = loginRequest;
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<LoginInfo>>> fVar) {
            d dVar = new d(this.$loginRequest, fVar);
            dVar.I$0 = i10;
            dVar.L$0 = str;
            return dVar.invokeSuspend(z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<LoginInfo>>> fVar) {
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
                    a.logger.debug("login extra, request[ {}, {} ]", kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                x1.f1.lb.api.d dVar = (x1.f1.lb.api.d) a.authServerProvider.a(i11);
                if (dVar != null) {
                    LoginRequest loginRequest = this.$loginRequest;
                    this.label = 1;
                    obj = dVar.f(loginRequest, this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("loginExtra api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("loginExtra api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.Api3AClient$logout$2", f = "Api3AClient.kt", l = {177}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/extra/ApiResponseBasic;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class e extends kotlin.coroutines.jvm.internal.l implements q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponseBasic>>, Object> {
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        e(v8.f<? super e> fVar) {
            super(3, fVar);
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponseBasic>> fVar) {
            e eVar = new e(fVar);
            eVar.I$0 = i10;
            eVar.L$0 = str;
            return eVar.invokeSuspend(z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponseBasic>> fVar) {
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
                    a.logger.debug("logout, request[ {}, {} ]", kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                x1.f1.lb.api.d dVar = (x1.f1.lb.api.d) a.authServerProvider.a(i11);
                if (dVar != null) {
                    eg.a aVar = new eg.a();
                    this.label = 1;
                    obj = dVar.j(aVar, this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("user extra api service is null");
            }
            com.skydoves.sandwich.a aVar2 = (com.skydoves.sandwich.a) obj;
            if (aVar2 != null) {
                return aVar2;
            }
            throw new NullPointerException("user extra api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.Api3AClient$queryAppProperty$2", f = "Api3AClient.kt", l = {95}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/extra/ApiResponse;", "Lz1/b1/lb/m/extra/user/QueryPropertiesInfo;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class f extends kotlin.coroutines.jvm.internal.l implements q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<QueryPropertiesInfo>>>, Object> {
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        f(v8.f<? super f> fVar) {
            super(3, fVar);
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<QueryPropertiesInfo>>> fVar) {
            f fVar2 = new f(fVar);
            fVar2.I$0 = i10;
            fVar2.L$0 = str;
            return fVar2.invokeSuspend(z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<QueryPropertiesInfo>>> fVar) {
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
                    a.logger.debug("query app property, request[ {}, {} ]", kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                x1.f1.lb.api.d dVar = (x1.f1.lb.api.d) a.authServerProvider.a(i11);
                if (dVar != null) {
                    eg.b bVar = new eg.b();
                    this.label = 1;
                    obj = dVar.e(bVar, this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("queryAppProperty api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("queryAppProperty api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.Api3AClient$queryMetaInfo$2", f = "Api3AClient.kt", l = {63}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/extra/ApiResponse;", "Lz1/b1/lb/m/extra/user/QueryMetaInfo;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class g extends kotlin.coroutines.jvm.internal.l implements q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<QueryMetaInfo>>>, Object> {
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        g(v8.f<? super g> fVar) {
            super(3, fVar);
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<QueryMetaInfo>>> fVar) {
            g gVar = new g(fVar);
            gVar.I$0 = i10;
            gVar.L$0 = str;
            return gVar.invokeSuspend(z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<QueryMetaInfo>>> fVar) {
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
                    a.logger.debug("query meta info, request[ {}, {} ]", kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                x1.f1.lb.api.d dVar = (x1.f1.lb.api.d) a.authServerProvider.a(i11);
                if (dVar != null) {
                    ApiRequestBasic apiRequestBasic = new ApiRequestBasic();
                    this.label = 1;
                    obj = dVar.k(apiRequestBasic, this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("queryMetaInfo api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("queryMetaInfo api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.Api3AClient$refreshToken$2", f = "Api3AClient.kt", l = {104}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/extra/ApiResponse;", "Lz1/b1/lb/m/extra/user/RefreshInfo;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class h extends kotlin.coroutines.jvm.internal.l implements q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<RefreshInfo>>>, Object> {
        final /* synthetic */ String $refreshToken;
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(String str, v8.f<? super h> fVar) {
            super(3, fVar);
            this.$refreshToken = str;
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<RefreshInfo>>> fVar) {
            h hVar = new h(this.$refreshToken, fVar);
            hVar.I$0 = i10;
            hVar.L$0 = str;
            return hVar.invokeSuspend(z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<RefreshInfo>>> fVar) {
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
                    a.logger.debug("refresh token, request[ {}, {} ]", kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                x1.f1.lb.api.d dVar = (x1.f1.lb.api.d) a.authServerProvider.a(i11);
                if (dVar != null) {
                    RefreshTokenRequest refreshTokenRequest = new RefreshTokenRequest(this.$refreshToken);
                    this.label = 1;
                    obj = dVar.i(refreshTokenRequest, this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("refreshToken api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("refreshToken api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.Api3AClient$register$2", f = "Api3AClient.kt", l = {PatchStatus.CODE_LOAD_LIB_UNDEFINED}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/extra/ApiResponse;", "Lz1/b1/lb/m/extra/user/RegisterInfo;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class i extends kotlin.coroutines.jvm.internal.l implements q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<RegisterInfo>>>, Object> {
        final /* synthetic */ String $invitationCode;
        final /* synthetic */ String $password;
        final /* synthetic */ String $username;
        final /* synthetic */ String $verificationCode;
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(String str, String str2, String str3, String str4, v8.f<? super i> fVar) {
            super(3, fVar);
            this.$username = str;
            this.$password = str2;
            this.$verificationCode = str3;
            this.$invitationCode = str4;
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<RegisterInfo>>> fVar) {
            i iVar = new i(this.$username, this.$password, this.$verificationCode, this.$invitationCode, fVar);
            iVar.I$0 = i10;
            iVar.L$0 = str;
            return iVar.invokeSuspend(z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<RegisterInfo>>> fVar) {
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
                    a.logger.debug("register, request[ {}, {} ]", kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                x1.f1.lb.api.d dVar = (x1.f1.lb.api.d) a.authServerProvider.a(i11);
                if (dVar != null) {
                    RegisterRequest registerRequest = new RegisterRequest(this.$username, this.$password, this.$verificationCode, this.$invitationCode);
                    this.label = 1;
                    obj = dVar.l(registerRequest, this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("register api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("register api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.Api3AClient$resetPassword$2", f = "Api3AClient.kt", l = {146}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/extra/ApiResponse;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class j extends kotlin.coroutines.jvm.internal.l implements q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<String>>>, Object> {
        final /* synthetic */ String $captchaCode;
        final /* synthetic */ String $digitalCode;
        final /* synthetic */ String $newPassword;
        final /* synthetic */ String $username;
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(String str, String str2, String str3, String str4, v8.f<? super j> fVar) {
            super(3, fVar);
            this.$username = str;
            this.$digitalCode = str2;
            this.$newPassword = str3;
            this.$captchaCode = str4;
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<String>>> fVar) {
            j jVar = new j(this.$username, this.$digitalCode, this.$newPassword, this.$captchaCode, fVar);
            jVar.I$0 = i10;
            jVar.L$0 = str;
            return jVar.invokeSuspend(z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<String>>> fVar) {
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
                    a.logger.debug("resetPassword, request[ {}, {} ]", kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                x1.f1.lb.api.d dVar = (x1.f1.lb.api.d) a.authServerProvider.a(i11);
                if (dVar != null) {
                    ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest(this.$username, this.$digitalCode, this.$newPassword, this.$captchaCode);
                    this.label = 1;
                    obj = dVar.c(resetPasswordRequest, this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("resetPassword api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("resetPassword api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.Api3AClient$sendVerificationCode$2", f = "Api3AClient.kt", l = {117}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/extra/ApiResponse;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class k extends kotlin.coroutines.jvm.internal.l implements q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<String>>>, Object> {
        final /* synthetic */ String $contact;
        final /* synthetic */ String $digitalCode;
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(String str, String str2, v8.f<? super k> fVar) {
            super(3, fVar);
            this.$contact = str;
            this.$digitalCode = str2;
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<String>>> fVar) {
            k kVar = new k(this.$contact, this.$digitalCode, fVar);
            kVar.I$0 = i10;
            kVar.L$0 = str;
            return kVar.invokeSuspend(z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<String>>> fVar) {
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
                    a.logger.debug("sendVerificationCode, request[ {}, {} ]", kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                x1.f1.lb.api.d dVar = (x1.f1.lb.api.d) a.authServerProvider.a(i11);
                if (dVar != null) {
                    VerificationCodeRequest verificationCodeRequest = new VerificationCodeRequest(this.$contact, this.$digitalCode, "");
                    this.label = 1;
                    obj = dVar.g(verificationCodeRequest, this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("sendVerificationCode api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("sendVerificationCode api service is null");
        }
    }

    static {
        q6.b bVarD = q6.c.d(a.class);
        kotlin.jvm.internal.m.e(bVarD, "getLogger(...)");
        logger = bVarD;
        x1.f1.lb.host.b bVar = x1.f1.lb.host.b.f20720a;
        authServerProvider = bVar.b();
        heartbeatServerProvider = bVar.f();
        upgradeServerProvider = bVar.q();
        noticeServerProvider = bVar.h();
        feedbackServerProvider = bVar.c();
        retryPolicy = new C0402a();
    }

    public static /* synthetic */ Object k(a aVar, String str, String str2, String str3, String str4, v8.f fVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str4 = "";
        }
        return aVar.j(str, str2, str3, str4, fVar);
    }

    public final Object c(Long l10, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<GuestLoginInfo>>> fVar) {
        return com.skydoves.sandwich.retry.a.a(retryPolicy, new b(l10, str, null), fVar);
    }

    public final Object d(String str, String str2, String str3, String str4, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<LoginInfo>>> fVar) {
        return com.skydoves.sandwich.retry.a.a(retryPolicy, new c(str, str2, str3, str4, null), fVar);
    }

    public final Object e(LoginRequest loginRequest, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<LoginInfo>>> fVar) {
        return com.skydoves.sandwich.retry.a.a(retryPolicy, new d(loginRequest, null), fVar);
    }

    public final Object f(v8.f<? super com.skydoves.sandwich.a<? extends ApiResponseBasic>> fVar) {
        return com.skydoves.sandwich.retry.a.a(retryPolicy, new e(null), fVar);
    }

    public final Object g(v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<QueryPropertiesInfo>>> fVar) {
        return com.skydoves.sandwich.retry.a.a(retryPolicy, new f(null), fVar);
    }

    public final Object h(v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<QueryMetaInfo>>> fVar) {
        return com.skydoves.sandwich.retry.a.a(retryPolicy, new g(null), fVar);
    }

    public final Object i(String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<RefreshInfo>>> fVar) {
        return com.skydoves.sandwich.retry.a.a(retryPolicy, new h(str, null), fVar);
    }

    public final Object j(String str, String str2, String str3, String str4, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<RegisterInfo>>> fVar) {
        return com.skydoves.sandwich.retry.a.a(retryPolicy, new i(str, str2, str3, str4, null), fVar);
    }

    public final Object l(String str, String str2, String str3, String str4, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<String>>> fVar) {
        return com.skydoves.sandwich.retry.a.a(retryPolicy, new j(str, str2, str3, str4, null), fVar);
    }

    public final Object m(String str, String str2, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<String>>> fVar) {
        return com.skydoves.sandwich.retry.a.a(retryPolicy, new k(str, str2, null), fVar);
    }

    private a() {
    }
}
