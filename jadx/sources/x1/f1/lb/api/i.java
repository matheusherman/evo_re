package x1.f1.lb.api;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.pengrad.telegrambot.request.ContentTypes;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import okhttp3.c0;
import x.l1.b2.R$string;
import x1.f1.lb.util.d1;
import x1.f1.lb.util.u0;
import z1.b1.lb.m.extra.upgrade.UpgradeInfo;
import z1.b1.lb.m.extra.user.LoginRequest;
import z1.b1.lb.m.extra.user.ResetPasswordRequest;
import z1.b1.lb.m.extra.user.VerificationCodeRequest;
import z1.b1.lb.m.feedback.FeedbackUploadResponse;
import z1.b1.lb.m.ptv.ApiResponse;
import z1.b1.lb.m.ptv.referral.ReferralSummary;
import z1.b1.lb.m.ptv.subscription.ChargeCodeRechargeRequest;
import z1.b1.lb.m.ptv.user.PTVLoginInfo;
import z1.b1.lb.m.ptv.user.RegisterRequest;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0004*\u0001F\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u0004H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u0004H\u0086@¢\u0006\u0004\b\t\u0010\u0007J$\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0004\b\f\u0010\rJ$\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011J4\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u00042\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u0015\u0010\u0016J<\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u00042\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u001a\u0010\u001bJ4\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u00042\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u001e\u0010\u0016J$\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u00042\u0006\u0010\u001f\u001a\u00020\nH\u0086@¢\u0006\u0004\b \u0010\rJ\u001c\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00050\u0004H\u0086@¢\u0006\u0004\b\"\u0010\u0007J$\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0004\b#\u0010\rJ\u001c\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u0004H\u0086@¢\u0006\u0004\b$\u0010\u0007J\u001c\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00050\u0004H\u0086@¢\u0006\u0004\b&\u0010\u0007J\u0018\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020'H\u0086@¢\u0006\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00104\u001a\b\u0012\u0004\u0012\u000201008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001c\u00106\u001a\b\u0012\u0004\u0012\u000205008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u00103R\u001c\u00108\u001a\b\u0012\u0004\u0012\u000207008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u00103R\u001c\u0010:\u001a\b\u0012\u0004\u0012\u000209008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u00103R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020;008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u00103R\u0016\u0010?\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010>R$\u0010E\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0014\u0010H\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010G¨\u0006I"}, d2 = {"Lx1/f1/lb/api/i;", "", "<init>", "()V", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/ptv/ApiResponse;", "h", "(Lv8/f;)Ljava/lang/Object;", "Lz1/b1/lb/m/ptv/user/PTVLoginInfo;", "d", "", "token", "f", "(Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "Lz1/b1/lb/m/ptv/user/RegisterRequest;", "registerRequest", "l", "(Lz1/b1/lb/m/ptv/user/RegisterRequest;Lv8/f;)Ljava/lang/Object;", "username", "passwordDigest", "digitalCode", "e", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "userName", "newPassword", "captchaCode", "m", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "contact", "actionType", "n", "code", "i", "Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;", "o", "k", "g", "Lz1/b1/lb/m/ptv/referral/ReferralSummary;", "j", "Ljava/io/File;", "feedbackFile", "Lz1/b1/lb/m/feedback/FeedbackUploadResponse;", "p", "(Ljava/io/File;Lv8/f;)Ljava/lang/Object;", "Lq6/b;", "b", "Lq6/b;", "logger", "Lx1/f1/lb/host/a;", "Lx1/f1/lb/api/h;", "c", "Lx1/f1/lb/host/a;", "authServerProvider", "Lx1/f1/lb/api/f;", "heartbeatServerProvider", "Lx1/f1/lb/api/n;", "upgradeServerProvider", "Lx1/f1/lb/api/g;", "noticeServerProvider", "Lx1/f1/lb/api/e;", "feedbackServerProvider", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "loginSeq", "Ljava/lang/String;", "getState", "()Ljava/lang/String;", "setState", "(Ljava/lang/String;)V", "state", "x1/f1/lb/api/i$u", "Lx1/f1/lb/api/i$u;", "retryPolicy", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f20569a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final x1.f1.lb.host.a<x1.f1.lb.api.h> authServerProvider;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static x1.f1.lb.host.a<x1.f1.lb.api.f> heartbeatServerProvider;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static x1.f1.lb.host.a<x1.f1.lb.api.n> upgradeServerProvider;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static x1.f1.lb.host.a<x1.f1.lb.api.g> noticeServerProvider;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static x1.f1.lb.host.a<x1.f1.lb.api.e> feedbackServerProvider;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static AtomicInteger loginSeq;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static String state;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static final u retryPolicy;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.PTVApi3AClient", f = "PTVApi3AClient.kt", l = {93}, m = "guestLogin")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class a extends kotlin.coroutines.jvm.internal.d {
        int label;
        /* synthetic */ Object result;

        a(v8.f<? super a> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return i.this.d(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.PTVApi3AClient$guestLogin$response$1", f = "PTVApi3AClient.kt", l = {95}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/ptv/ApiResponse;", "Lz1/b1/lb/m/ptv/user/PTVLoginInfo;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements c9.q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>>, Object> {
        final /* synthetic */ long $begin;
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j10, v8.f<? super b> fVar) {
            super(3, fVar);
            this.$begin = j10;
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>> fVar) {
            b bVar = new b(this.$begin, fVar);
            bVar.I$0 = i10;
            bVar.L$0 = str;
            return bVar.invokeSuspend(r8.z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>> fVar) {
            return b(num.intValue(), str, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r8.r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                int i11 = this.I$0;
                String str = (String) this.L$0;
                if (x1.f1.lb.config.b.f20643a.t()) {
                    i.logger.debug("guestLogin, request[ {}, {} ]", kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                x1.f1.lb.api.h hVar = (x1.f1.lb.api.h) i.authServerProvider.a(i11);
                if (hVar != null) {
                    this.label = 1;
                    obj = hVar.e(this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("user api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
            if (aVar != null) {
                q6.b bVar = i.logger;
                Long lC = kotlin.coroutines.jvm.internal.b.c(d1.c() - this.$begin);
                Integer numB = kotlin.coroutines.jvm.internal.b.b(i.loginSeq.getAndIncrement());
                x1.f1.lb.user.f fVar = x1.f1.lb.user.f.f21202a;
                bVar.a("api: guest login [{}ms] seq[{}] act[{}] rft[{}] stt[{}]", lC, numB, fVar.b0(), fVar.y0(), fVar.A0());
                return aVar;
            }
            throw new NullPointerException("user api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.PTVApi3AClient", f = "PTVApi3AClient.kt", l = {118}, m = "login")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class c extends kotlin.coroutines.jvm.internal.d {
        int label;
        /* synthetic */ Object result;

        c(v8.f<? super c> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return i.this.f(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.PTVApi3AClient", f = "PTVApi3AClient.kt", l = {161}, m = "login")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class d extends kotlin.coroutines.jvm.internal.d {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        d(v8.f<? super d> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return i.this.e(null, null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.PTVApi3AClient$login$response$1", f = "PTVApi3AClient.kt", l = {120}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/ptv/ApiResponse;", "Lz1/b1/lb/m/ptv/user/PTVLoginInfo;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class e extends kotlin.coroutines.jvm.internal.l implements c9.q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>>, Object> {
        final /* synthetic */ long $begin;
        final /* synthetic */ String $token;
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, long j10, v8.f<? super e> fVar) {
            super(3, fVar);
            this.$token = str;
            this.$begin = j10;
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>> fVar) {
            e eVar = new e(this.$token, this.$begin, fVar);
            eVar.I$0 = i10;
            eVar.L$0 = str;
            return eVar.invokeSuspend(r8.z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>> fVar) {
            return b(num.intValue(), str, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r8.r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                int i11 = this.I$0;
                String str = (String) this.L$0;
                if (x1.f1.lb.config.b.f20643a.t()) {
                    i.logger.debug("login[{}], request[ {}, {} ]", this.$token, kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                x1.f1.lb.api.h hVar = (x1.f1.lb.api.h) i.authServerProvider.a(i11);
                if (hVar != null) {
                    String str2 = this.$token;
                    this.label = 1;
                    obj = hVar.b(str2, this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("user api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
            if (aVar != null) {
                q6.b bVar = i.logger;
                Long lC = kotlin.coroutines.jvm.internal.b.c(d1.c() - this.$begin);
                Integer numB = kotlin.coroutines.jvm.internal.b.b(i.loginSeq.getAndIncrement());
                String str3 = this.$token;
                x1.f1.lb.user.f fVar = x1.f1.lb.user.f.f21202a;
                bVar.a("api:login by token[{}ms] seq[{}] token[{}] act[{}] rft[{}] stt[{}]", lC, numB, str3, fVar.b0(), fVar.y0(), fVar.A0());
                return aVar;
            }
            throw new NullPointerException("user api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.PTVApi3AClient$login$response$2", f = "PTVApi3AClient.kt", l = {164}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/ptv/ApiResponse;", "Lz1/b1/lb/m/ptv/user/PTVLoginInfo;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class f extends kotlin.coroutines.jvm.internal.l implements c9.q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>>, Object> {
        final /* synthetic */ String $digitalCode;
        final /* synthetic */ String $passwordDigest;
        final /* synthetic */ String $username;
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, String str2, String str3, v8.f<? super f> fVar) {
            super(3, fVar);
            this.$username = str;
            this.$passwordDigest = str2;
            this.$digitalCode = str3;
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>> fVar) {
            f fVar2 = new f(this.$username, this.$passwordDigest, this.$digitalCode, fVar);
            fVar2.I$0 = i10;
            fVar2.L$0 = str;
            return fVar2.invokeSuspend(r8.z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>> fVar) {
            return b(num.intValue(), str, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r8.r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                int i11 = this.I$0;
                String str = (String) this.L$0;
                if (x1.f1.lb.config.b.f20643a.t()) {
                    i.logger.debug("login[{}], request[ {}, {} ]", this.$username, kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                x1.f1.lb.api.h hVar = (x1.f1.lb.api.h) i.authServerProvider.a(i11);
                if (hVar != null) {
                    LoginRequest loginRequest = new LoginRequest(this.$username, this.$passwordDigest, this.$digitalCode);
                    this.label = 1;
                    obj = hVar.l(loginRequest, this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("user api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("user api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.PTVApi3AClient", f = "PTVApi3AClient.kt", l = {290}, m = "logout")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class g extends kotlin.coroutines.jvm.internal.d {
        long J$0;
        int label;
        /* synthetic */ Object result;

        g(v8.f<? super g> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return i.this.g(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.PTVApi3AClient$logout$response$1", f = "PTVApi3AClient.kt", l = {292}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/ptv/ApiResponse;", "", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class h extends kotlin.coroutines.jvm.internal.l implements c9.q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<Object>>>, Object> {
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        h(v8.f<? super h> fVar) {
            super(3, fVar);
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<Object>>> fVar) {
            h hVar = new h(fVar);
            hVar.I$0 = i10;
            hVar.L$0 = str;
            return hVar.invokeSuspend(r8.z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<Object>>> fVar) {
            return b(num.intValue(), str, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r8.r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                int i11 = this.I$0;
                String str = (String) this.L$0;
                if (x1.f1.lb.config.b.f20643a.t()) {
                    i.logger.debug("logout, request[ {}, {} ]", kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                x1.f1.lb.api.h hVar = (x1.f1.lb.api.h) i.authServerProvider.a(i11);
                if (hVar != null) {
                    this.label = 1;
                    obj = hVar.a(this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("user api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("user api service is null");
        }
    }

    /* JADX INFO: renamed from: x1.f1.lb.api.i$i, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.PTVApi3AClient", f = "PTVApi3AClient.kt", l = {58}, m = "queryMetaInfo")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class C0408i extends kotlin.coroutines.jvm.internal.d {
        long J$0;
        int label;
        /* synthetic */ Object result;

        C0408i(v8.f<? super C0408i> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return i.this.h(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.PTVApi3AClient$queryMetaInfo$response$1", f = "PTVApi3AClient.kt", l = {60}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/ptv/ApiResponse;", "", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class j extends kotlin.coroutines.jvm.internal.l implements c9.q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<Object>>>, Object> {
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        j(v8.f<? super j> fVar) {
            super(3, fVar);
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<Object>>> fVar) {
            j jVar = new j(fVar);
            jVar.I$0 = i10;
            jVar.L$0 = str;
            return jVar.invokeSuspend(r8.z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<Object>>> fVar) {
            return b(num.intValue(), str, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r8.r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                int i11 = this.I$0;
                String str = (String) this.L$0;
                if (x1.f1.lb.config.b.f20643a.t()) {
                    i.logger.debug("query meta info, request[ {}, {} ]", kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                x1.f1.lb.api.h hVar = (x1.f1.lb.api.h) i.authServerProvider.a(i11);
                if (hVar != null) {
                    String strValueOf = String.valueOf(of.a.f16585a.h());
                    this.label = 1;
                    obj = hVar.f(strValueOf, this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("user api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("user api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.PTVApi3AClient", f = "PTVApi3AClient.kt", l = {235}, m = "recharge")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class k extends kotlin.coroutines.jvm.internal.d {
        int label;
        /* synthetic */ Object result;

        k(v8.f<? super k> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return i.this.i(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.PTVApi3AClient$recharge$response$1", f = "PTVApi3AClient.kt", l = {237}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/ptv/ApiResponse;", "Lz1/b1/lb/m/ptv/user/PTVLoginInfo;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class l extends kotlin.coroutines.jvm.internal.l implements c9.q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>>, Object> {
        final /* synthetic */ String $code;
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(String str, v8.f<? super l> fVar) {
            super(3, fVar);
            this.$code = str;
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>> fVar) {
            l lVar = new l(this.$code, fVar);
            lVar.I$0 = i10;
            lVar.L$0 = str;
            return lVar.invokeSuspend(r8.z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>> fVar) {
            return b(num.intValue(), str, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r8.r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                int i11 = this.I$0;
                String str = (String) this.L$0;
                if (x1.f1.lb.config.b.f20643a.t()) {
                    i.logger.debug("recharge, request[ {}, {} ]", kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                x1.f1.lb.api.h hVar = (x1.f1.lb.api.h) i.authServerProvider.a(i11);
                if (hVar != null) {
                    ChargeCodeRechargeRequest chargeCodeRechargeRequest = new ChargeCodeRechargeRequest(this.$code);
                    this.label = 1;
                    obj = hVar.i(chargeCodeRechargeRequest, this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("user api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("user api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.PTVApi3AClient", f = "PTVApi3AClient.kt", l = {310}, m = "referralSummary")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class m extends kotlin.coroutines.jvm.internal.d {
        int label;
        /* synthetic */ Object result;

        m(v8.f<? super m> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return i.this.j(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.PTVApi3AClient$referralSummary$response$1", f = "PTVApi3AClient.kt", l = {TypedValues.AttributesType.TYPE_PATH_ROTATE}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/ptv/ApiResponse;", "Lz1/b1/lb/m/ptv/referral/ReferralSummary;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class n extends kotlin.coroutines.jvm.internal.l implements c9.q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<ReferralSummary>>>, Object> {
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        n(v8.f<? super n> fVar) {
            super(3, fVar);
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<ReferralSummary>>> fVar) {
            n nVar = new n(fVar);
            nVar.I$0 = i10;
            nVar.L$0 = str;
            return nVar.invokeSuspend(r8.z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<ReferralSummary>>> fVar) {
            return b(num.intValue(), str, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r8.r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                int i11 = this.I$0;
                String str = (String) this.L$0;
                if (x1.f1.lb.config.b.f20643a.t()) {
                    i.logger.debug("referral summary, request[ {}, {} ]", kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                x1.f1.lb.api.h hVar = (x1.f1.lb.api.h) i.authServerProvider.a(i11);
                if (hVar != null) {
                    this.label = 1;
                    obj = hVar.h(this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("referral summary api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("referral summary api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.PTVApi3AClient", f = "PTVApi3AClient.kt", l = {268}, m = "refresh")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class o extends kotlin.coroutines.jvm.internal.d {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        o(v8.f<? super o> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return i.this.k(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.PTVApi3AClient$refresh$response$1", f = "PTVApi3AClient.kt", l = {270}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/ptv/ApiResponse;", "Lz1/b1/lb/m/ptv/user/PTVLoginInfo;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class p extends kotlin.coroutines.jvm.internal.l implements c9.q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>>, Object> {
        final /* synthetic */ String $token;
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(String str, v8.f<? super p> fVar) {
            super(3, fVar);
            this.$token = str;
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>> fVar) {
            p pVar = new p(this.$token, fVar);
            pVar.I$0 = i10;
            pVar.L$0 = str;
            return pVar.invokeSuspend(r8.z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>> fVar) {
            return b(num.intValue(), str, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r8.r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                int i11 = this.I$0;
                String str = (String) this.L$0;
                if (x1.f1.lb.config.b.f20643a.t()) {
                    i.logger.debug("refresh, request[ {}, {} ]", kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                x1.f1.lb.api.h hVar = (x1.f1.lb.api.h) i.authServerProvider.a(i11);
                if (hVar != null) {
                    String str2 = this.$token;
                    this.label = 1;
                    obj = hVar.d(str2, this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("user api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("user api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.PTVApi3AClient", f = "PTVApi3AClient.kt", l = {142}, m = "register")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class q extends kotlin.coroutines.jvm.internal.d {
        int label;
        /* synthetic */ Object result;

        q(v8.f<? super q> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return i.this.l(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.PTVApi3AClient$register$response$1", f = "PTVApi3AClient.kt", l = {145}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/ptv/ApiResponse;", "Lz1/b1/lb/m/ptv/user/PTVLoginInfo;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class r extends kotlin.coroutines.jvm.internal.l implements c9.q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>>, Object> {
        final /* synthetic */ RegisterRequest $registerRequest;
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(RegisterRequest registerRequest, v8.f<? super r> fVar) {
            super(3, fVar);
            this.$registerRequest = registerRequest;
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>> fVar) {
            r rVar = new r(this.$registerRequest, fVar);
            rVar.I$0 = i10;
            rVar.L$0 = str;
            return rVar.invokeSuspend(r8.z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>> fVar) {
            return b(num.intValue(), str, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r8.r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                int i11 = this.I$0;
                String str = (String) this.L$0;
                if (x1.f1.lb.config.b.f20643a.t()) {
                    i.logger.debug("register[{}], request[ {}, {} ]", this.$registerRequest, kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                x1.f1.lb.api.h hVar = (x1.f1.lb.api.h) i.authServerProvider.a(i11);
                if (hVar != null) {
                    RegisterRequest registerRequest = this.$registerRequest;
                    this.label = 1;
                    obj = hVar.g(registerRequest, this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("user api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("user api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.PTVApi3AClient", f = "PTVApi3AClient.kt", l = {201}, m = "resetPassword")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class s extends kotlin.coroutines.jvm.internal.d {
        int label;
        /* synthetic */ Object result;

        s(v8.f<? super s> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return i.this.m(null, null, null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.PTVApi3AClient$resetPassword$response$1", f = "PTVApi3AClient.kt", l = {203}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/ptv/ApiResponse;", "", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class t extends kotlin.coroutines.jvm.internal.l implements c9.q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<Object>>>, Object> {
        final /* synthetic */ String $captchaCode;
        final /* synthetic */ String $digitalCode;
        final /* synthetic */ String $newPassword;
        final /* synthetic */ String $userName;
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(String str, String str2, String str3, String str4, v8.f<? super t> fVar) {
            super(3, fVar);
            this.$userName = str;
            this.$digitalCode = str2;
            this.$newPassword = str3;
            this.$captchaCode = str4;
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<Object>>> fVar) {
            t tVar = new t(this.$userName, this.$digitalCode, this.$newPassword, this.$captchaCode, fVar);
            tVar.I$0 = i10;
            tVar.L$0 = str;
            return tVar.invokeSuspend(r8.z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<Object>>> fVar) {
            return b(num.intValue(), str, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r8.r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                int i11 = this.I$0;
                String str = (String) this.L$0;
                if (x1.f1.lb.config.b.f20643a.t()) {
                    i.logger.debug("reset password, request[ {}, {} ]", kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                x1.f1.lb.api.h hVar = (x1.f1.lb.api.h) i.authServerProvider.a(i11);
                if (hVar != null) {
                    ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest(this.$userName, this.$digitalCode, this.$newPassword, this.$captchaCode);
                    this.label = 1;
                    obj = hVar.c(resetPasswordRequest, this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("user api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("user api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"x1/f1/lb/api/i$u", "Lcom/skydoves/sandwich/retry/b;", "", "attempt", "", "message", "b", "(ILjava/lang/String;)I", "", "a", "(ILjava/lang/String;)Z", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class u implements com.skydoves.sandwich.retry.b {
        @Override // com.skydoves.sandwich.retry.b
        public boolean a(int attempt, String message) {
            return attempt <= 3;
        }

        @Override // com.skydoves.sandwich.retry.b
        public int b(int attempt, String message) {
            return 3000;
        }

        u() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.PTVApi3AClient", f = "PTVApi3AClient.kt", l = {218}, m = "sendCaptcha")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class v extends kotlin.coroutines.jvm.internal.d {
        int label;
        /* synthetic */ Object result;

        v(v8.f<? super v> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return i.this.n(null, null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.PTVApi3AClient$sendCaptcha$response$1", f = "PTVApi3AClient.kt", l = {220}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/ptv/ApiResponse;", "", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class w extends kotlin.coroutines.jvm.internal.l implements c9.q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<Object>>>, Object> {
        final /* synthetic */ String $actionType;
        final /* synthetic */ String $contact;
        final /* synthetic */ String $digitalCode;
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        w(String str, String str2, String str3, v8.f<? super w> fVar) {
            super(3, fVar);
            this.$contact = str;
            this.$digitalCode = str2;
            this.$actionType = str3;
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<Object>>> fVar) {
            w wVar = new w(this.$contact, this.$digitalCode, this.$actionType, fVar);
            wVar.I$0 = i10;
            wVar.L$0 = str;
            return wVar.invokeSuspend(r8.z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<Object>>> fVar) {
            return b(num.intValue(), str, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r8.r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                int i11 = this.I$0;
                String str = (String) this.L$0;
                if (x1.f1.lb.config.b.f20643a.t()) {
                    i.logger.debug("send captcha, request[ {}, {} ]", kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                x1.f1.lb.api.h hVar = (x1.f1.lb.api.h) i.authServerProvider.a(i11);
                if (hVar != null) {
                    VerificationCodeRequest verificationCodeRequest = new VerificationCodeRequest(this.$contact, this.$digitalCode, this.$actionType);
                    this.label = 1;
                    obj = hVar.j(verificationCodeRequest, this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("user api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("user api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.PTVApi3AClient", f = "PTVApi3AClient.kt", l = {251}, m = "upgrade")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class x extends kotlin.coroutines.jvm.internal.d {
        int label;
        /* synthetic */ Object result;

        x(v8.f<? super x> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return i.this.o(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.PTVApi3AClient$upgrade$response$1", f = "PTVApi3AClient.kt", l = {253}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "attempt", "", "reason", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/ptv/ApiResponse;", "Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;", "<anonymous>", "(ILjava/lang/String;)Lcom/skydoves/sandwich/a;"}, k = 3, mv = {2, 1, 0})
    static final class y extends kotlin.coroutines.jvm.internal.l implements c9.q<Integer, String, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<UpgradeInfo>>>, Object> {
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        int label;

        y(v8.f<? super y> fVar) {
            super(3, fVar);
        }

        public final Object b(int i10, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<UpgradeInfo>>> fVar) {
            y yVar = new y(fVar);
            yVar.I$0 = i10;
            yVar.L$0 = str;
            return yVar.invokeSuspend(r8.z.f17874a);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ Object invoke(Integer num, String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<UpgradeInfo>>> fVar) {
            return b(num.intValue(), str, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r8.r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                int i11 = this.I$0;
                String str = (String) this.L$0;
                if (x1.f1.lb.config.b.f20643a.t()) {
                    i.logger.debug("upgrade, request[ {}, {} ]", kotlin.coroutines.jvm.internal.b.b(i11), str);
                }
                x1.f1.lb.api.h hVar = (x1.f1.lb.api.h) i.authServerProvider.a(i11);
                if (hVar != null) {
                    this.label = 1;
                    obj = hVar.k(this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                throw new NullPointerException("upgrade api service is null");
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
            if (aVar != null) {
                return aVar;
            }
            throw new NullPointerException("upgrade api service is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.api.PTVApi3AClient", f = "PTVApi3AClient.kt", l = {350}, m = "uploadFeedbackFile")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class z extends kotlin.coroutines.jvm.internal.d {
        int label;
        /* synthetic */ Object result;

        z(v8.f<? super z> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return i.this.p(null, this);
        }
    }

    static {
        q6.b bVarD = q6.c.d(i.class);
        kotlin.jvm.internal.m.e(bVarD, "getLogger(...)");
        logger = bVarD;
        x1.f1.lb.host.b bVar = x1.f1.lb.host.b.f20720a;
        authServerProvider = bVar.j();
        heartbeatServerProvider = bVar.f();
        upgradeServerProvider = bVar.q();
        noticeServerProvider = bVar.h();
        feedbackServerProvider = bVar.c();
        loginSeq = new AtomicInteger(0);
        retryPolicy = new u();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object d(v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>> fVar) {
        a aVar;
        if (fVar instanceof a) {
            aVar = (a) fVar;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(fVar);
            }
        } else {
            aVar = new a(fVar);
        }
        Object objA = aVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = aVar.label;
        try {
            if (i11 == 0) {
                r8.r.b(objA);
                long jC = d1.c();
                u uVar = retryPolicy;
                b bVar = new b(jC, null);
                aVar.label = 1;
                objA = com.skydoves.sandwich.retry.a.a(uVar, bVar, aVar);
                if (objA == objC) {
                    return objC;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r8.r.b(objA);
            }
            return (com.skydoves.sandwich.a) objA;
        } catch (Throwable th) {
            return com.skydoves.sandwich.a.INSTANCE.a(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object e(String str, String str2, String str3, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>> fVar) {
        d dVar;
        String str4;
        long j10;
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
        Object objA = dVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = dVar.label;
        try {
            if (i11 == 0) {
                r8.r.b(objA);
                long jC = d1.c();
                u uVar = retryPolicy;
                f fVar2 = new f(str, str2, str3, null);
                dVar.L$0 = str;
                dVar.J$0 = jC;
                dVar.label = 1;
                objA = com.skydoves.sandwich.retry.a.a(uVar, fVar2, dVar);
                if (objA == objC) {
                    return objC;
                }
                str4 = str;
                j10 = jC;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j10 = dVar.J$0;
                str4 = (String) dVar.L$0;
                r8.r.b(objA);
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) objA;
            q6.b bVar = logger;
            Long lC = kotlin.coroutines.jvm.internal.b.c(d1.c() - j10);
            Integer numB = kotlin.coroutines.jvm.internal.b.b(loginSeq.getAndIncrement());
            x1.f1.lb.user.f fVar3 = x1.f1.lb.user.f.f21202a;
            bVar.a("api:login by username[{}ms] username[{}] seq[{}] act[{}] rft[{}] stt[{}]", lC, str4, numB, fVar3.b0(), fVar3.y0(), fVar3.A0());
            return aVar;
        } catch (Throwable th) {
            return com.skydoves.sandwich.a.INSTANCE.a(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object f(String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>> fVar) {
        c cVar;
        if (fVar instanceof c) {
            cVar = (c) fVar;
            int i10 = cVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                cVar.label = i10 - Integer.MIN_VALUE;
            } else {
                cVar = new c(fVar);
            }
        } else {
            cVar = new c(fVar);
        }
        Object objA = cVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = cVar.label;
        try {
            if (i11 == 0) {
                r8.r.b(objA);
                long jC = d1.c();
                u uVar = retryPolicy;
                e eVar = new e(str, jC, null);
                cVar.label = 1;
                objA = com.skydoves.sandwich.retry.a.a(uVar, eVar, cVar);
                if (objA == objC) {
                    return objC;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r8.r.b(objA);
            }
            return (com.skydoves.sandwich.a) objA;
        } catch (Throwable th) {
            return com.skydoves.sandwich.a.INSTANCE.a(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object g(v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<Object>>> fVar) {
        g gVar;
        long j10;
        if (fVar instanceof g) {
            gVar = (g) fVar;
            int i10 = gVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                gVar.label = i10 - Integer.MIN_VALUE;
            } else {
                gVar = new g(fVar);
            }
        } else {
            gVar = new g(fVar);
        }
        Object objA = gVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = gVar.label;
        try {
            if (i11 == 0) {
                r8.r.b(objA);
                long jC = d1.c();
                u uVar = retryPolicy;
                h hVar = new h(null);
                gVar.J$0 = jC;
                gVar.label = 1;
                objA = com.skydoves.sandwich.retry.a.a(uVar, hVar, gVar);
                if (objA == objC) {
                    return objC;
                }
                j10 = jC;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j10 = gVar.J$0;
                r8.r.b(objA);
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) objA;
            q6.b bVar = logger;
            Long lC = kotlin.coroutines.jvm.internal.b.c(d1.c() - j10);
            Integer numB = kotlin.coroutines.jvm.internal.b.b(loginSeq.get());
            x1.f1.lb.user.f fVar2 = x1.f1.lb.user.f.f21202a;
            bVar.a("api:logout[{}ms] seq[{}], act[{}], rft[{}], stt[{}]", lC, numB, fVar2.b0(), fVar2.y0(), fVar2.A0());
            return aVar;
        } catch (Throwable th) {
            return com.skydoves.sandwich.a.INSTANCE.a(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object h(v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<Object>>> fVar) {
        C0408i c0408i;
        long j10;
        if (fVar instanceof C0408i) {
            c0408i = (C0408i) fVar;
            int i10 = c0408i.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c0408i.label = i10 - Integer.MIN_VALUE;
            } else {
                c0408i = new C0408i(fVar);
            }
        } else {
            c0408i = new C0408i(fVar);
        }
        Object objA = c0408i.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = c0408i.label;
        if (i11 == 0) {
            r8.r.b(objA);
            long jC = d1.c();
            try {
                u uVar = retryPolicy;
                j jVar = new j(null);
                c0408i.J$0 = jC;
                c0408i.label = 1;
                objA = com.skydoves.sandwich.retry.a.a(uVar, jVar, c0408i);
                if (objA == objC) {
                    return objC;
                }
                j10 = jC;
            } catch (Throwable th) {
                th = th;
                j10 = jC;
                long jC2 = d1.c() - j10;
                state = (u0.f21448a.a(R$string.fail, "Disconnected") + " (" + th.getClass().getSimpleName() + ")") + " (" + d1.b(jC2, null) + ")";
                return com.skydoves.sandwich.a.INSTANCE.a(th);
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j10 = c0408i.J$0;
            try {
                r8.r.b(objA);
            } catch (Throwable th2) {
                th = th2;
                long jC3 = d1.c() - j10;
                state = (u0.f21448a.a(R$string.fail, "Disconnected") + " (" + th.getClass().getSimpleName() + ")") + " (" + d1.b(jC3, null) + ")";
                return com.skydoves.sandwich.a.INSTANCE.a(th);
            }
        }
        com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) objA;
        q6.b bVar = logger;
        Long lC = kotlin.coroutines.jvm.internal.b.c(d1.c() - j10);
        Integer numB = kotlin.coroutines.jvm.internal.b.b(loginSeq.get());
        x1.f1.lb.user.f fVar2 = x1.f1.lb.user.f.f21202a;
        bVar.a("api:query meta info[{}ms] seq[{}] act[{}] rft[{}] stt[{}], ret[{}]", lC, numB, fVar2.b0(), fVar2.y0(), fVar2.A0());
        long jC4 = d1.c() - j10;
        state = u0.f21448a.a(R$string.pass, "Connected") + " (" + d1.b(jC4, null) + ")";
        return aVar;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object i(String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>> fVar) {
        k kVar;
        if (fVar instanceof k) {
            kVar = (k) fVar;
            int i10 = kVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                kVar.label = i10 - Integer.MIN_VALUE;
            } else {
                kVar = new k(fVar);
            }
        } else {
            kVar = new k(fVar);
        }
        Object objA = kVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = kVar.label;
        try {
            if (i11 == 0) {
                r8.r.b(objA);
                u uVar = retryPolicy;
                l lVar = new l(str, null);
                kVar.label = 1;
                objA = com.skydoves.sandwich.retry.a.a(uVar, lVar, kVar);
                if (objA == objC) {
                    return objC;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r8.r.b(objA);
            }
            return (com.skydoves.sandwich.a) objA;
        } catch (Throwable th) {
            return com.skydoves.sandwich.a.INSTANCE.a(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object j(v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<ReferralSummary>>> fVar) {
        m mVar;
        if (fVar instanceof m) {
            mVar = (m) fVar;
            int i10 = mVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                mVar.label = i10 - Integer.MIN_VALUE;
            } else {
                mVar = new m(fVar);
            }
        } else {
            mVar = new m(fVar);
        }
        Object objA = mVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = mVar.label;
        try {
            if (i11 == 0) {
                r8.r.b(objA);
                u uVar = retryPolicy;
                n nVar = new n(null);
                mVar.label = 1;
                objA = com.skydoves.sandwich.retry.a.a(uVar, nVar, mVar);
                if (objA == objC) {
                    return objC;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r8.r.b(objA);
            }
            return (com.skydoves.sandwich.a) objA;
        } catch (Throwable th) {
            return com.skydoves.sandwich.a.INSTANCE.a(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object k(String str, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>> fVar) {
        o oVar;
        long j10;
        if (fVar instanceof o) {
            oVar = (o) fVar;
            int i10 = oVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                oVar.label = i10 - Integer.MIN_VALUE;
            } else {
                oVar = new o(fVar);
            }
        } else {
            oVar = new o(fVar);
        }
        Object objA = oVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = oVar.label;
        try {
            if (i11 == 0) {
                r8.r.b(objA);
                long jC = d1.c();
                u uVar = retryPolicy;
                p pVar = new p(str, null);
                oVar.L$0 = str;
                oVar.J$0 = jC;
                oVar.label = 1;
                objA = com.skydoves.sandwich.retry.a.a(uVar, pVar, oVar);
                if (objA == objC) {
                    return objC;
                }
                j10 = jC;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j10 = oVar.J$0;
                str = (String) oVar.L$0;
                r8.r.b(objA);
            }
            com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) objA;
            q6.b bVar = logger;
            Long lC = kotlin.coroutines.jvm.internal.b.c(d1.c() - j10);
            Integer numB = kotlin.coroutines.jvm.internal.b.b(loginSeq.get());
            x1.f1.lb.user.f fVar2 = x1.f1.lb.user.f.f21202a;
            bVar.a("api:refresh[{}ms] seq[{}], token[{}] act[{}] rft[{}], stt[{}]", lC, str, numB, fVar2.b0(), fVar2.y0(), fVar2.A0());
            return aVar;
        } catch (Throwable th) {
            return com.skydoves.sandwich.a.INSTANCE.a(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object l(RegisterRequest registerRequest, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<PTVLoginInfo>>> fVar) {
        q qVar;
        if (fVar instanceof q) {
            qVar = (q) fVar;
            int i10 = qVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                qVar.label = i10 - Integer.MIN_VALUE;
            } else {
                qVar = new q(fVar);
            }
        } else {
            qVar = new q(fVar);
        }
        Object objA = qVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = qVar.label;
        try {
            if (i11 == 0) {
                r8.r.b(objA);
                u uVar = retryPolicy;
                r rVar = new r(registerRequest, null);
                qVar.label = 1;
                objA = com.skydoves.sandwich.retry.a.a(uVar, rVar, qVar);
                if (objA == objC) {
                    return objC;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r8.r.b(objA);
            }
            return (com.skydoves.sandwich.a) objA;
        } catch (Throwable th) {
            return com.skydoves.sandwich.a.INSTANCE.a(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object m(String str, String str2, String str3, String str4, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<Object>>> fVar) {
        s sVar;
        if (fVar instanceof s) {
            sVar = (s) fVar;
            int i10 = sVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                sVar.label = i10 - Integer.MIN_VALUE;
            } else {
                sVar = new s(fVar);
            }
        } else {
            sVar = new s(fVar);
        }
        Object objA = sVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = sVar.label;
        try {
            if (i11 == 0) {
                r8.r.b(objA);
                u uVar = retryPolicy;
                t tVar = new t(str, str2, str3, str4, null);
                sVar.label = 1;
                objA = com.skydoves.sandwich.retry.a.a(uVar, tVar, sVar);
                if (objA == objC) {
                    return objC;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r8.r.b(objA);
            }
            return (com.skydoves.sandwich.a) objA;
        } catch (Throwable th) {
            return com.skydoves.sandwich.a.INSTANCE.a(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object n(String str, String str2, String str3, v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<Object>>> fVar) {
        v vVar;
        if (fVar instanceof v) {
            vVar = (v) fVar;
            int i10 = vVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                vVar.label = i10 - Integer.MIN_VALUE;
            } else {
                vVar = new v(fVar);
            }
        } else {
            vVar = new v(fVar);
        }
        Object objA = vVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = vVar.label;
        try {
            if (i11 == 0) {
                r8.r.b(objA);
                u uVar = retryPolicy;
                w wVar = new w(str, str2, str3, null);
                vVar.label = 1;
                objA = com.skydoves.sandwich.retry.a.a(uVar, wVar, vVar);
                if (objA == objC) {
                    return objC;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r8.r.b(objA);
            }
            return (com.skydoves.sandwich.a) objA;
        } catch (Throwable th) {
            return com.skydoves.sandwich.a.INSTANCE.a(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object o(v8.f<? super com.skydoves.sandwich.a<? extends ApiResponse<UpgradeInfo>>> fVar) {
        x xVar;
        if (fVar instanceof x) {
            xVar = (x) fVar;
            int i10 = xVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                xVar.label = i10 - Integer.MIN_VALUE;
            } else {
                xVar = new x(fVar);
            }
        } else {
            xVar = new x(fVar);
        }
        Object objA = xVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = xVar.label;
        try {
            if (i11 == 0) {
                r8.r.b(objA);
                u uVar = retryPolicy;
                y yVar = new y(null);
                xVar.label = 1;
                objA = com.skydoves.sandwich.retry.a.a(uVar, yVar, xVar);
                if (objA == objC) {
                    return objC;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r8.r.b(objA);
            }
            return (com.skydoves.sandwich.a) objA;
        } catch (Throwable th) {
            return com.skydoves.sandwich.a.INSTANCE.a(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:25:0x00d6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object p(File file, v8.f<? super FeedbackUploadResponse> fVar) {
        z zVar;
        FeedbackUploadResponse feedbackUploadResponse;
        if (fVar instanceof z) {
            zVar = (z) fVar;
            int i10 = zVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                zVar.label = i10 - Integer.MIN_VALUE;
            } else {
                zVar = new z(fVar);
            }
        } else {
            zVar = new z(fVar);
        }
        z zVar2 = zVar;
        Object objA = zVar2.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = zVar2.label;
        if (i11 == 0) {
            r8.r.b(objA);
            of.a aVar = of.a.f16585a;
            String strValueOf = String.valueOf(aVar.h());
            String strB = aVar.b();
            String strK = aVar.k();
            String strValueOf2 = String.valueOf(d1.d());
            String str = strValueOf + "_" + strB + "_" + strK + "_" + strValueOf2 + "_logcat.gz";
            c0.Companion companion = c0.INSTANCE;
            okhttp3.x.Companion companion2 = okhttp3.x.INSTANCE;
            c0 c0VarB = companion.b(strValueOf, companion2.b(ContentTypes.DOC_MIME_TYPE));
            c0 c0VarB2 = companion.b(strB, companion2.b(ContentTypes.DOC_MIME_TYPE));
            c0 c0VarB3 = companion.b(strK, companion2.b(ContentTypes.DOC_MIME_TYPE));
            c0 c0VarB4 = companion.b(strValueOf2, companion2.b(ContentTypes.DOC_MIME_TYPE));
            okhttp3.y.c cVarC = okhttp3.y.c.INSTANCE.c("file", str, companion.a(file, companion2.b("application/gzip")));
            x1.f1.lb.api.e eVarC = feedbackServerProvider.c(1);
            if (eVarC != null) {
                zVar2.label = 1;
                objA = eVarC.a(c0VarB, c0VarB2, c0VarB3, c0VarB4, cVarC, zVar2);
                if (objA == objC) {
                    return objC;
                }
            } else {
                feedbackUploadResponse = null;
            }
            if (feedbackUploadResponse == null) {
                return new FeedbackUploadResponse("-1", "", null);
            }
            return feedbackUploadResponse;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        r8.r.b(objA);
        feedbackUploadResponse = (FeedbackUploadResponse) objA;
        if (feedbackUploadResponse == null) {
            return new FeedbackUploadResponse("-1", "", null);
        }
        return feedbackUploadResponse;
    }

    private i() {
    }
}
