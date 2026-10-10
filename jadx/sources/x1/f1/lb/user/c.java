package x1.f1.lb.user;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.taobao.sophix.PatchStatus;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import r8.u;
import r8.z;
import x1.f1.lb.util.v0;
import z1.b1.lb.m.extra.ApiResponse;
import z1.b1.lb.m.extra.ApiResponseBasic;
import z1.b1.lb.m.extra.subscription.RechargeInfo;
import z1.b1.lb.m.extra.user.GuestLoginInfo;
import z1.b1.lb.m.extra.user.LoginInfo;
import z1.b1.lb.m.extra.user.LoginRequest;
import z1.b1.lb.m.extra.user.QueryMetaInfo;
import z1.b1.lb.m.extra.user.QueryPropertiesInfo;
import z1.b1.lb.m.extra.user.RefreshInfo;
import z1.b1.lb.m.extra.user.RegisterInfo;
import z1.b1.lb.m.feedback.FeedbackUploadResponse;
import z1.b1.lb.m.local.LocalSessionInfo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J4\u0010\f\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b0\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0082@¢\u0006\u0004\b\f\u0010\rJ;\u0010\u0011\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b0\u00072\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012Jq\u0010\u0016\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b0\u0007\"\u0004\b\u0000\u0010\u00132\u0014\u0010\u0010\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0018\u00010\u000e2(\u0010\u0015\u001a$\u0012\u0004\u0012\u00028\u0000\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b0\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ,\u0010\u001b\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b0\u0007H\u0096@¢\u0006\u0004\b\u001b\u0010\u001cJ,\u0010\u001d\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b0\u0007H\u0096@¢\u0006\u0004\b\u001d\u0010\u001cJL\u0010\"\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b0\u00072\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\"\u0010#JD\u0010&\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b0\u00072\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b&\u0010'J4\u0010)\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b0\u00072\u0006\u0010(\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b)\u0010*J4\u0010,\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b0\u00072\u0006\u0010+\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b,\u0010*J,\u0010-\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b0\u0007H\u0096@¢\u0006\u0004\b-\u0010\u001cJ4\u0010.\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b0\u00072\u0006\u0010(\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b.\u0010*JD\u00100\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b0\u00072\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b0\u0010'J4\u00102\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b0\u00072\u0006\u00101\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b2\u0010*JT\u00105\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b0\u00072\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b5\u00106J,\u00107\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b0\u0007H\u0096@¢\u0006\u0004\b7\u0010\u001cJ,\u00108\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b0\u0007H\u0096@¢\u0006\u0004\b8\u0010\u001cJ\u0018\u0010<\u001a\u00020;2\u0006\u0010:\u001a\u000209H\u0096@¢\u0006\u0004\b<\u0010=¨\u0006>"}, d2 = {"Lx1/f1/lb/user/c;", "Lx1/f1/lb/user/a;", "Lz1/b1/lb/m/extra/ApiResponse;", "<init>", "()V", "Lz1/b1/lb/m/extra/user/LoginRequest;", "loginRequest", "Lkotlinx/coroutines/flow/f;", "Lr8/u;", "", "", "", "r", "(Lz1/b1/lb/m/extra/user/LoginRequest;Lv8/f;)Ljava/lang/Object;", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/extra/ApiResponseBasic;", "response", "p", "(Lcom/skydoves/sandwich/a;)Lkotlinx/coroutines/flow/f;", "X", "Lx1/f1/lb/user/b$a;", "convertor", "q", "(Lcom/skydoves/sandwich/a;Lx1/f1/lb/user/b$a;)Lkotlinx/coroutines/flow/f;", "clearPassword", "s", "(Ljava/lang/String;)Ljava/lang/String;", "f", "(Lv8/f;)Ljava/lang/Object;", "m", "userName", "digitalCode", "password", "captchaCode", "i", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "contact", "actionType", "l", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "code", "n", "(Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "token", "g", "j", "b", "passwordDigest", "e", "refreshToken", "d", "verificationCode", "invitationCode", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "a", "k", "Ljava/io/File;", "feedbackFile", "Lz1/b1/lb/m/feedback/FeedbackUploadResponse;", "h", "(Ljava/io/File;Lv8/f;)Ljava/lang/Object;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c implements x1.f1.lb.user.a<ApiResponse<?>> {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.Extra3AAdapter$callApi$2", f = "Extra3AAdapter.kt", l = {285, 288, 290, 292}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super u<? extends Boolean, ? extends Integer, ? extends String>>, v8.f<? super z>, Object> {
        final /* synthetic */ String $caller;
        final /* synthetic */ com.skydoves.sandwich.a<ApiResponseBasic> $response;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: x1.f1.lb.user.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.Extra3AAdapter$callApi$2$1", f = "Extra3AAdapter.kt", l = {286}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lz1/b1/lb/m/extra/ApiResponseBasic;", "Lr8/z;", "<anonymous>", "(Lz1/b1/lb/m/extra/ApiResponseBasic;)V"}, k = 3, mv = {2, 1, 0})
        static final class C0449a extends kotlin.coroutines.jvm.internal.l implements c9.p<ApiResponseBasic, v8.f<? super z>, Object> {
            final /* synthetic */ kotlinx.coroutines.flow.g<u<Boolean, Integer, String>> $$this$flow;
            final /* synthetic */ String $caller;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0449a(kotlinx.coroutines.flow.g<? super u<Boolean, Integer, String>> gVar, String str, v8.f<? super C0449a> fVar) {
                super(2, fVar);
                this.$$this$flow = gVar;
                this.$caller = str;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                C0449a c0449a = new C0449a(this.$$this$flow, this.$caller, fVar);
                c0449a.L$0 = obj;
                return c0449a;
            }

            @Override // c9.p
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(ApiResponseBasic apiResponseBasic, v8.f<? super z> fVar) {
                return ((C0449a) create(apiResponseBasic, fVar)).invokeSuspend(z.f17874a);
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
                    ApiResponseBasic apiResponseBasic = (ApiResponseBasic) this.L$0;
                    kotlinx.coroutines.flow.g<u<Boolean, Integer, String>> gVar = this.$$this$flow;
                    u<Boolean, Integer, String> uVarC = x1.f1.lb.user.b.c(x1.f1.lb.user.b.f21174a, this.$caller, new u(kotlin.coroutines.jvm.internal.b.a(apiResponseBasic.isSuccess()), kotlin.coroutines.jvm.internal.b.b(apiResponseBasic.getErrCode()), x1.f1.lb.util.e.f21383a.a(apiResponseBasic)), null, 4, null);
                    this.label = 1;
                    if (gVar.emit(uVarC, this) == objC) {
                        return objC;
                    }
                }
                return z.f17874a;
            }
        }

        @Override // c9.p
        public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.flow.g<? super u<? extends Boolean, ? extends Integer, ? extends String>> gVar, v8.f<? super z> fVar) {
            return invoke2((kotlinx.coroutines.flow.g<? super u<Boolean, Integer, String>>) gVar, fVar);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(com.skydoves.sandwich.a<? extends ApiResponseBasic> aVar, String str, v8.f<? super a> fVar) {
            super(2, fVar);
            this.$response = aVar;
            this.$caller = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            a aVar = new a(this.$response, this.$caller, fVar);
            aVar.L$0 = obj;
            return aVar;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.flow.g<? super u<Boolean, Integer, String>> gVar, v8.f<? super z> fVar) {
            return ((a) create(gVar, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x009c  */
        /* JADX WARN: Code duplicated, block: B:29:0x00c1  */
        /* JADX WARN: Code duplicated, block: B:31:0x00c3 A[PHI: r1 r5
          0x00c3: PHI (r1v7 com.skydoves.sandwich.a) = (r1v6 com.skydoves.sandwich.a), (r1v8 com.skydoves.sandwich.a) binds: [B:25:0x009a, B:30:0x00c2] A[DONT_GENERATE, DONT_INLINE]
          0x00c3: PHI (r5v4 kotlinx.coroutines.flow.g) = (r5v3 kotlinx.coroutines.flow.g), (r5v5 kotlinx.coroutines.flow.g) binds: [B:25:0x009a, B:30:0x00c2] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:33:0x00c9  */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0091, code lost:
        
            if (r1.emit(r6, r13) == r0) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00eb, code lost:
        
            if (r5.emit(r14, r13) == r0) goto L35;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.g gVar;
            kotlinx.coroutines.flow.g gVar2;
            com.skydoves.sandwich.a aVar;
            String str;
            u uVarC;
            kotlinx.coroutines.flow.g gVar3;
            String str2;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            if (i10 == 4) {
                                r8.r.b(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            aVar = (com.skydoves.sandwich.a) this.L$1;
                            gVar3 = (kotlinx.coroutines.flow.g) this.L$0;
                            r8.r.b(obj);
                            gVar2 = gVar3;
                            str2 = this.$caller;
                            if (aVar instanceof com.skydoves.sandwich.a.b.C0151a) {
                                u uVarC2 = x1.f1.lb.user.b.c(x1.f1.lb.user.b.f21174a, str2, x1.f1.lb.util.e.f21383a.c(v0.f21450a.a((com.skydoves.sandwich.a.b.C0151a) aVar)), null, 4, null);
                                this.L$0 = aVar;
                                this.L$1 = null;
                                this.label = 4;
                            }
                        }
                    } else {
                        aVar = (com.skydoves.sandwich.a) this.L$1;
                        gVar2 = (kotlinx.coroutines.flow.g) this.L$0;
                        r8.r.b(obj);
                        str = this.$caller;
                        if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                            uVarC = x1.f1.lb.user.b.c(x1.f1.lb.user.b.f21174a, str, x1.f1.lb.util.e.f21383a.c(v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar)), null, 4, null);
                            this.L$0 = gVar2;
                            this.L$1 = aVar;
                            this.label = 3;
                            if (gVar2.emit(uVarC, this) != objC) {
                                gVar3 = gVar2;
                                gVar2 = gVar3;
                                str2 = this.$caller;
                                if (aVar instanceof com.skydoves.sandwich.a.b.C0151a) {
                                    u uVarC3 = x1.f1.lb.user.b.c(x1.f1.lb.user.b.f21174a, str2, x1.f1.lb.util.e.f21383a.c(v0.f21450a.a((com.skydoves.sandwich.a.b.C0151a) aVar)), null, 4, null);
                                    this.L$0 = aVar;
                                    this.L$1 = null;
                                    this.label = 4;
                                }
                            }
                        } else {
                            str2 = this.$caller;
                            if (aVar instanceof com.skydoves.sandwich.a.b.C0151a) {
                                u uVarC4 = x1.f1.lb.user.b.c(x1.f1.lb.user.b.f21174a, str2, x1.f1.lb.util.e.f21383a.c(v0.f21450a.a((com.skydoves.sandwich.a.b.C0151a) aVar)), null, 4, null);
                                this.L$0 = aVar;
                                this.L$1 = null;
                                this.label = 4;
                            }
                        }
                        return objC;
                    }
                } else {
                    gVar = (kotlinx.coroutines.flow.g) this.L$0;
                    r8.r.b(obj);
                }
                return z.f17874a;
            }
            r8.r.b(obj);
            kotlinx.coroutines.flow.g gVar4 = (kotlinx.coroutines.flow.g) this.L$0;
            com.skydoves.sandwich.a<ApiResponseBasic> aVar2 = this.$response;
            C0449a c0449a = new C0449a(gVar4, this.$caller, null);
            this.L$0 = gVar4;
            this.label = 1;
            Object objG = com.skydoves.sandwich.c.g(aVar2, c0449a, this);
            if (objG != objC) {
                gVar = gVar4;
                obj = objG;
            }
            return objC;
            com.skydoves.sandwich.a aVar3 = (com.skydoves.sandwich.a) obj;
            String str3 = this.$caller;
            if (aVar3 instanceof com.skydoves.sandwich.a.b) {
                u uVarC5 = x1.f1.lb.user.b.c(x1.f1.lb.user.b.f21174a, str3, x1.f1.lb.util.e.f21383a.c(v0.f21450a.c((com.skydoves.sandwich.a.b) aVar3)), null, 4, null);
                this.L$0 = gVar;
                this.L$1 = aVar3;
                this.label = 2;
            }
            gVar2 = gVar;
            aVar = aVar3;
            str = this.$caller;
            if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                uVarC = x1.f1.lb.user.b.c(x1.f1.lb.user.b.f21174a, str, x1.f1.lb.util.e.f21383a.c(v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar)), null, 4, null);
                this.L$0 = gVar2;
                this.L$1 = aVar;
                this.label = 3;
                if (gVar2.emit(uVarC, this) != objC) {
                    gVar3 = gVar2;
                    gVar2 = gVar3;
                    str2 = this.$caller;
                    if (aVar instanceof com.skydoves.sandwich.a.b.C0151a) {
                        u uVarC6 = x1.f1.lb.user.b.c(x1.f1.lb.user.b.f21174a, str2, x1.f1.lb.util.e.f21383a.c(v0.f21450a.a((com.skydoves.sandwich.a.b.C0151a) aVar)), null, 4, null);
                        this.L$0 = aVar;
                        this.L$1 = null;
                        this.label = 4;
                    }
                    return z.f17874a;
                }
            } else {
                str2 = this.$caller;
                if (aVar instanceof com.skydoves.sandwich.a.b.C0151a) {
                    u uVarC7 = x1.f1.lb.user.b.c(x1.f1.lb.user.b.f21174a, str2, x1.f1.lb.util.e.f21383a.c(v0.f21450a.a((com.skydoves.sandwich.a.b.C0151a) aVar)), null, 4, null);
                    this.L$0 = aVar;
                    this.L$1 = null;
                    this.label = 4;
                }
                return z.f17874a;
            }
            return objC;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.Extra3AAdapter$callApi$3", f = "Extra3AAdapter.kt", l = {307, TypedValues.AttributesType.TYPE_PIVOT_TARGET, 320, 322}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super u<? extends Boolean, ? extends Integer, ? extends String>>, v8.f<? super z>, Object> {
        final /* synthetic */ String $caller;
        final /* synthetic */ x1.f1.lb.user.b.a<X, u<Boolean, Integer, String>> $convertor;
        final /* synthetic */ com.skydoves.sandwich.a<ApiResponse<X>> $response;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: Add missing generic type declarations: [X] */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.Extra3AAdapter$callApi$3$1", f = "Extra3AAdapter.kt", l = {309, 311, 313, 315}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"X", "Lz1/b1/lb/m/extra/ApiResponse;", "Lr8/z;", "<anonymous>", "(Lz1/b1/lb/m/extra/ApiResponse;)V"}, k = 3, mv = {2, 1, 0})
        static final class a<X> extends kotlin.coroutines.jvm.internal.l implements c9.p<ApiResponse<X>, v8.f<? super z>, Object> {
            final /* synthetic */ kotlinx.coroutines.flow.g<u<Boolean, Integer, String>> $$this$flow;
            final /* synthetic */ String $caller;
            final /* synthetic */ x1.f1.lb.user.b.a<X, u<Boolean, Integer, String>> $convertor;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(x1.f1.lb.user.b.a<X, u<Boolean, Integer, String>> aVar, kotlinx.coroutines.flow.g<? super u<Boolean, Integer, String>> gVar, String str, v8.f<? super a> fVar) {
                super(2, fVar);
                this.$convertor = aVar;
                this.$$this$flow = gVar;
                this.$caller = str;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                a aVar = new a(this.$convertor, this.$$this$flow, this.$caller, fVar);
                aVar.L$0 = obj;
                return aVar;
            }

            @Override // c9.p
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(ApiResponse<X> apiResponse, v8.f<? super z> fVar) {
                return ((a) create(apiResponse, fVar)).invokeSuspend(z.f17874a);
            }

            /* JADX WARN: Code duplicated, block: B:20:0x0057  */
            /* JADX WARN: Code duplicated, block: B:23:0x0064  */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x0061, code lost:
            
                if (r1.emit(r12, r11) == r0) goto L28;
             */
            /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:
            
                if (r12.emit(r1, r11) == r0) goto L28;
             */
            /* JADX WARN: Code restructure failed: missing block: B:27:0x00bd, code lost:
            
                if (r12.emit(r1, r11) == r0) goto L28;
             */
            /* JADX WARN: Multi-variable type inference failed */
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
            @Override // kotlin.coroutines.jvm.internal.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                ApiResponse apiResponse;
                u<Boolean, Integer, String> uVar;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i10 = this.label;
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 != 2 && i10 != 3 && i10 != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        r8.r.b(obj);
                    } else {
                        apiResponse = (ApiResponse) this.L$0;
                        r8.r.b(obj);
                        uVar = (u) obj;
                        if (uVar != null) {
                            kotlinx.coroutines.flow.g<u<Boolean, Integer, String>> gVar = this.$$this$flow;
                            this.L$0 = null;
                            this.label = 2;
                        } else {
                            kotlinx.coroutines.flow.g<u<Boolean, Integer, String>> gVar2 = this.$$this$flow;
                            u<Boolean, Integer, String> uVarC = x1.f1.lb.user.b.c(x1.f1.lb.user.b.f21174a, this.$caller, new u(kotlin.coroutines.jvm.internal.b.a(false), kotlin.coroutines.jvm.internal.b.b(apiResponse.getErrCode()), x1.f1.lb.util.e.f21383a.a(apiResponse)), null, 4, null);
                            this.L$0 = null;
                            this.label = 3;
                        }
                    }
                    return z.f17874a;
                }
                r8.r.b(obj);
                apiResponse = (ApiResponse) this.L$0;
                if (apiResponse.isSuccess()) {
                    x1.f1.lb.user.b.a<X, u<Boolean, Integer, String>> aVar = this.$convertor;
                    int errCode = apiResponse.getErrCode();
                    String errMsg = apiResponse.getErrMsg();
                    Object data = apiResponse.getData();
                    this.L$0 = apiResponse;
                    this.label = 1;
                    obj = aVar.b(errCode, errMsg, data, this);
                    if (obj != objC) {
                        uVar = (u) obj;
                        if (uVar != null) {
                            kotlinx.coroutines.flow.g<u<Boolean, Integer, String>> gVar3 = this.$$this$flow;
                            this.L$0 = null;
                            this.label = 2;
                        } else {
                            kotlinx.coroutines.flow.g<u<Boolean, Integer, String>> gVar4 = this.$$this$flow;
                            u<Boolean, Integer, String> uVarC2 = x1.f1.lb.user.b.c(x1.f1.lb.user.b.f21174a, this.$caller, new u(kotlin.coroutines.jvm.internal.b.a(false), kotlin.coroutines.jvm.internal.b.b(apiResponse.getErrCode()), x1.f1.lb.util.e.f21383a.a(apiResponse)), null, 4, null);
                            this.L$0 = null;
                            this.label = 3;
                        }
                    }
                } else {
                    kotlinx.coroutines.flow.g<u<Boolean, Integer, String>> gVar5 = this.$$this$flow;
                    u<Boolean, Integer, String> uVarC3 = x1.f1.lb.user.b.c(x1.f1.lb.user.b.f21174a, this.$caller, new u(kotlin.coroutines.jvm.internal.b.a(false), kotlin.coroutines.jvm.internal.b.b(apiResponse.getErrCode()), x1.f1.lb.util.e.f21383a.a(apiResponse)), null, 4, null);
                    this.label = 4;
                }
                return objC;
            }
        }

        @Override // c9.p
        public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.flow.g<? super u<? extends Boolean, ? extends Integer, ? extends String>> gVar, v8.f<? super z> fVar) {
            return invoke2((kotlinx.coroutines.flow.g<? super u<Boolean, Integer, String>>) gVar, fVar);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(com.skydoves.sandwich.a<? extends ApiResponse<X>> aVar, x1.f1.lb.user.b.a<X, u<Boolean, Integer, String>> aVar2, String str, v8.f<? super b> fVar) {
            super(2, fVar);
            this.$response = aVar;
            this.$convertor = aVar2;
            this.$caller = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            b bVar = new b(this.$response, this.$convertor, this.$caller, fVar);
            bVar.L$0 = obj;
            return bVar;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.flow.g<? super u<Boolean, Integer, String>> gVar, v8.f<? super z> fVar) {
            return ((b) create(gVar, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x009e  */
        /* JADX WARN: Code duplicated, block: B:29:0x00c3  */
        /* JADX WARN: Code duplicated, block: B:31:0x00c5 A[PHI: r1 r5
          0x00c5: PHI (r1v7 com.skydoves.sandwich.a) = (r1v6 com.skydoves.sandwich.a), (r1v8 com.skydoves.sandwich.a) binds: [B:25:0x009c, B:30:0x00c4] A[DONT_GENERATE, DONT_INLINE]
          0x00c5: PHI (r5v4 kotlinx.coroutines.flow.g) = (r5v3 kotlinx.coroutines.flow.g), (r5v5 kotlinx.coroutines.flow.g) binds: [B:25:0x009c, B:30:0x00c4] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:33:0x00cb  */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0093, code lost:
        
            if (r1.emit(r6, r13) == r0) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00ed, code lost:
        
            if (r5.emit(r14, r13) == r0) goto L35;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.g gVar;
            kotlinx.coroutines.flow.g gVar2;
            com.skydoves.sandwich.a aVar;
            String str;
            u uVarC;
            kotlinx.coroutines.flow.g gVar3;
            String str2;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            if (i10 == 4) {
                                r8.r.b(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            aVar = (com.skydoves.sandwich.a) this.L$1;
                            gVar3 = (kotlinx.coroutines.flow.g) this.L$0;
                            r8.r.b(obj);
                            gVar2 = gVar3;
                            str2 = this.$caller;
                            if (aVar instanceof com.skydoves.sandwich.a.b.C0151a) {
                                u uVarC2 = x1.f1.lb.user.b.c(x1.f1.lb.user.b.f21174a, str2, x1.f1.lb.util.e.f21383a.c(v0.f21450a.a((com.skydoves.sandwich.a.b.C0151a) aVar)), null, 4, null);
                                this.L$0 = aVar;
                                this.L$1 = null;
                                this.label = 4;
                            }
                        }
                    } else {
                        aVar = (com.skydoves.sandwich.a) this.L$1;
                        gVar2 = (kotlinx.coroutines.flow.g) this.L$0;
                        r8.r.b(obj);
                        str = this.$caller;
                        if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                            uVarC = x1.f1.lb.user.b.c(x1.f1.lb.user.b.f21174a, str, x1.f1.lb.util.e.f21383a.c(v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar)), null, 4, null);
                            this.L$0 = gVar2;
                            this.L$1 = aVar;
                            this.label = 3;
                            if (gVar2.emit(uVarC, this) != objC) {
                                gVar3 = gVar2;
                                gVar2 = gVar3;
                                str2 = this.$caller;
                                if (aVar instanceof com.skydoves.sandwich.a.b.C0151a) {
                                    u uVarC3 = x1.f1.lb.user.b.c(x1.f1.lb.user.b.f21174a, str2, x1.f1.lb.util.e.f21383a.c(v0.f21450a.a((com.skydoves.sandwich.a.b.C0151a) aVar)), null, 4, null);
                                    this.L$0 = aVar;
                                    this.L$1 = null;
                                    this.label = 4;
                                }
                            }
                        } else {
                            str2 = this.$caller;
                            if (aVar instanceof com.skydoves.sandwich.a.b.C0151a) {
                                u uVarC4 = x1.f1.lb.user.b.c(x1.f1.lb.user.b.f21174a, str2, x1.f1.lb.util.e.f21383a.c(v0.f21450a.a((com.skydoves.sandwich.a.b.C0151a) aVar)), null, 4, null);
                                this.L$0 = aVar;
                                this.L$1 = null;
                                this.label = 4;
                            }
                        }
                        return objC;
                    }
                } else {
                    gVar = (kotlinx.coroutines.flow.g) this.L$0;
                    r8.r.b(obj);
                }
                return z.f17874a;
            }
            r8.r.b(obj);
            kotlinx.coroutines.flow.g gVar4 = (kotlinx.coroutines.flow.g) this.L$0;
            com.skydoves.sandwich.a<ApiResponse<X>> aVar2 = this.$response;
            a aVar3 = new a(this.$convertor, gVar4, this.$caller, null);
            this.L$0 = gVar4;
            this.label = 1;
            Object objG = com.skydoves.sandwich.c.g(aVar2, aVar3, this);
            if (objG != objC) {
                gVar = gVar4;
                obj = objG;
            }
            return objC;
            com.skydoves.sandwich.a aVar4 = (com.skydoves.sandwich.a) obj;
            String str3 = this.$caller;
            if (aVar4 instanceof com.skydoves.sandwich.a.b) {
                u uVarC5 = x1.f1.lb.user.b.c(x1.f1.lb.user.b.f21174a, str3, x1.f1.lb.util.e.f21383a.c(v0.f21450a.c((com.skydoves.sandwich.a.b) aVar4)), null, 4, null);
                this.L$0 = gVar;
                this.L$1 = aVar4;
                this.label = 2;
            }
            gVar2 = gVar;
            aVar = aVar4;
            str = this.$caller;
            if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                uVarC = x1.f1.lb.user.b.c(x1.f1.lb.user.b.f21174a, str, x1.f1.lb.util.e.f21383a.c(v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar)), null, 4, null);
                this.L$0 = gVar2;
                this.L$1 = aVar;
                this.label = 3;
                if (gVar2.emit(uVarC, this) != objC) {
                    gVar3 = gVar2;
                    gVar2 = gVar3;
                    str2 = this.$caller;
                    if (aVar instanceof com.skydoves.sandwich.a.b.C0151a) {
                        u uVarC6 = x1.f1.lb.user.b.c(x1.f1.lb.user.b.f21174a, str2, x1.f1.lb.util.e.f21383a.c(v0.f21450a.a((com.skydoves.sandwich.a.b.C0151a) aVar)), null, 4, null);
                        this.L$0 = aVar;
                        this.L$1 = null;
                        this.label = 4;
                    }
                    return z.f17874a;
                }
            } else {
                str2 = this.$caller;
                if (aVar instanceof com.skydoves.sandwich.a.b.C0151a) {
                    u uVarC7 = x1.f1.lb.user.b.c(x1.f1.lb.user.b.f21174a, str2, x1.f1.lb.util.e.f21383a.c(v0.f21450a.a((com.skydoves.sandwich.a.b.C0151a) aVar)), null, 4, null);
                    this.L$0 = aVar;
                    this.L$1 = null;
                    this.label = 4;
                }
                return z.f17874a;
            }
            return objC;
        }
    }

    /* JADX INFO: renamed from: x1.f1.lb.user.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.Extra3AAdapter", f = "Extra3AAdapter.kt", l = {201, 214}, m = "linkContact")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class C0450c extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C0450c(v8.f<? super C0450c> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c.this.c(null, null, null, null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"x1/f1/lb/user/c$d", "Lx1/f1/lb/util/m;", "Lx1/f1/lb/user/e;", "Lz1/b1/lb/m/extra/user/RegisterInfo;", "v", "Lr8/z;", "c", "(Lx1/f1/lb/user/e;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d implements x1.f1.lb.util.m<x1.f1.lb.user.e<RegisterInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f21186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f21187b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f21188c;

        d(String str, String str2, String str3) {
            this.f21186a = str;
            this.f21187b = str2;
            this.f21188c = str3;
        }

        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(x1.f1.lb.user.e<RegisterInfo> v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            x1.f1.lb.user.g.f21276a.b(this.f21186a, this.f21187b, this.f21188c, v10.e());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"x1/f1/lb/user/c$e", "Lx1/f1/lb/util/m;", "Lx1/f1/lb/user/e;", "Lz1/b1/lb/m/extra/user/LoginInfo;", "v", "Lr8/z;", "c", "(Lx1/f1/lb/user/e;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e implements x1.f1.lb.util.m<x1.f1.lb.user.e<LoginInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f21189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f21190b;

        e(String str, String str2) {
            this.f21189a = str;
            this.f21190b = str2;
        }

        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(x1.f1.lb.user.e<LoginInfo> v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            x1.f1.lb.user.g.f21276a.c(this.f21189a, this.f21190b, v10.e());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.Extra3AAdapter", f = "Extra3AAdapter.kt", l = {151}, m = "login")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class f extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        f(v8.f<? super f> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c.this.j(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"x1/f1/lb/user/c$g", "Lx1/f1/lb/util/m;", "Lx1/f1/lb/user/e;", "Lz1/b1/lb/m/extra/user/GuestLoginInfo;", "v", "Lr8/z;", "c", "(Lx1/f1/lb/user/e;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class g implements x1.f1.lb.util.m<x1.f1.lb.user.e<GuestLoginInfo>> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(x1.f1.lb.user.e<GuestLoginInfo> v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            x1.f1.lb.user.g.f21276a.f(v10.e());
        }

        g() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.Extra3AAdapter", f = "Extra3AAdapter.kt", l = {245}, m = "login")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class h extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        h(v8.f<? super h> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c.this.r(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"x1/f1/lb/user/c$i", "Lx1/f1/lb/util/m;", "Lx1/f1/lb/user/e;", "Lz1/b1/lb/m/extra/user/LoginInfo;", "v", "Lr8/z;", "c", "(Lx1/f1/lb/user/e;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class i implements x1.f1.lb.util.m<x1.f1.lb.user.e<LoginInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LoginRequest f21191a;

        i(LoginRequest loginRequest) {
            this.f21191a = loginRequest;
        }

        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(x1.f1.lb.user.e<LoginInfo> v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            x1.f1.lb.user.g gVar = x1.f1.lb.user.g.f21276a;
            String username = this.f21191a.getUsername();
            kotlin.jvm.internal.m.e(username, "getUsername(...)");
            String password = this.f21191a.getPassword();
            kotlin.jvm.internal.m.e(password, "getPassword(...)");
            gVar.c(username, password, v10.e());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.Extra3AAdapter", f = "Extra3AAdapter.kt", l = {233}, m = "logout")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class j extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        j(v8.f<? super j> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c.this.a(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.Extra3AAdapter", f = "Extra3AAdapter.kt", l = {64}, m = "queryAppProperty")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class k extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        k(v8.f<? super k> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c.this.m(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002$\u0012\u0004\u0012\u00020\u0002\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00030\u0001JD\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"x1/f1/lb/user/c$l", "Lx1/f1/lb/user/b$a;", "Lz1/b1/lb/m/extra/user/QueryPropertiesInfo;", "Lr8/u;", "", "", "", "code", NotificationCompat.CATEGORY_MESSAGE, "x", "c", "(ILjava/lang/String;Lz1/b1/lb/m/extra/user/QueryPropertiesInfo;Lv8/f;)Ljava/lang/Object;", "a", "()Ljava/lang/String;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class l implements x1.f1.lb.user.b.a<QueryPropertiesInfo, u<? extends Boolean, ? extends Integer, ? extends String>> {
        @Override // x1.f1.lb.user.b.a
        public String a() {
            return "query app property";
        }

        @Override // x1.f1.lb.user.b.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Object b(int i10, String str, QueryPropertiesInfo queryPropertiesInfo, v8.f<? super u<Boolean, Integer, String>> fVar) {
            x1.f1.lb.heartbeat.f.f20678a.K0(queryPropertiesInfo != null ? queryPropertiesInfo.getProperties() : null);
            return null;
        }

        l() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.Extra3AAdapter", f = "Extra3AAdapter.kt", l = {36}, m = "queryMetaInfo")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class m extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        m(v8.f<? super m> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c.this.f(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002$\u0012\u0004\u0012\u00020\u0002\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00030\u0001JD\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"x1/f1/lb/user/c$n", "Lx1/f1/lb/user/b$a;", "Lz1/b1/lb/m/extra/user/QueryMetaInfo;", "Lr8/u;", "", "", "", "code", NotificationCompat.CATEGORY_MESSAGE, "x", "c", "(ILjava/lang/String;Lz1/b1/lb/m/extra/user/QueryMetaInfo;Lv8/f;)Ljava/lang/Object;", "a", "()Ljava/lang/String;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class n implements x1.f1.lb.user.b.a<QueryMetaInfo, u<? extends Boolean, ? extends Integer, ? extends String>> {
        @Override // x1.f1.lb.user.b.a
        public String a() {
            return "query meta info";
        }

        @Override // x1.f1.lb.user.b.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Object b(int i10, String str, QueryMetaInfo queryMetaInfo, v8.f<? super u<Boolean, Integer, String>> fVar) {
            Map<?, ?> properties;
            if (queryMetaInfo == null || (properties = queryMetaInfo.getProperties()) == null) {
                return null;
            }
            x1.f1.lb.user.b.f21174a.e(properties);
            LoginInfo loginInfo = queryMetaInfo.getLoginInfo();
            if (loginInfo == null) {
                return new u(kotlin.coroutines.jvm.internal.b.a(true), kotlin.coroutines.jvm.internal.b.b(i10), str);
            }
            x1.f1.lb.user.g.f21276a.h(loginInfo);
            return new u(kotlin.coroutines.jvm.internal.b.a(false), kotlin.coroutines.jvm.internal.b.b(-8), str);
        }

        n() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.Extra3AAdapter", f = "Extra3AAdapter.kt", l = {PatchStatus.CODE_LOAD_LIB_LOST}, m = "recharge")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class o extends kotlin.coroutines.jvm.internal.d {
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
            return c.this.n(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"x1/f1/lb/user/c$p", "Lx1/f1/lb/util/m;", "Lx1/f1/lb/user/e;", "Lz1/b1/lb/m/extra/subscription/RechargeInfo;", "v", "Lr8/z;", "c", "(Lx1/f1/lb/user/e;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class p implements x1.f1.lb.util.m<x1.f1.lb.user.e<RechargeInfo>> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(x1.f1.lb.user.e<RechargeInfo> v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            x1.f1.lb.user.g.f21276a.e(v10.e());
        }

        p() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.Extra3AAdapter", f = "Extra3AAdapter.kt", l = {174}, m = "refresh")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class q extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        q(v8.f<? super q> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c.this.d(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"x1/f1/lb/user/c$r", "Lx1/f1/lb/util/m;", "Lx1/f1/lb/user/e;", "Lz1/b1/lb/m/extra/user/RefreshInfo;", "v", "Lr8/z;", "c", "(Lx1/f1/lb/user/e;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class r implements x1.f1.lb.util.m<x1.f1.lb.user.e<RefreshInfo>> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(x1.f1.lb.user.e<RefreshInfo> v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            x1.f1.lb.user.g.f21276a.g(v10.e());
        }

        r() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.Extra3AAdapter", f = "Extra3AAdapter.kt", l = {122}, m = "resetPassword")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class s extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        s(v8.f<? super s> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c.this.i(null, null, null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.Extra3AAdapter", f = "Extra3AAdapter.kt", l = {130}, m = "sendCaptcha")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class t extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        t(v8.f<? super t> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c.this.l(null, null, null, this);
        }
    }

    private final kotlinx.coroutines.flow.f<u<Boolean, Integer, String>> p(com.skydoves.sandwich.a<? extends ApiResponseBasic> response) {
        String strB = x1.f1.lb.util.q.f21441a.b(3);
        return response == null ? kotlinx.coroutines.flow.h.w(x1.f1.lb.user.b.c(x1.f1.lb.user.b.f21174a, strB, new u(Boolean.FALSE, -1, null), null, 4, null)) : kotlinx.coroutines.flow.h.v(new a(response, strB, null));
    }

    private final <X> kotlinx.coroutines.flow.f<u<Boolean, Integer, String>> q(com.skydoves.sandwich.a<? extends ApiResponse<X>> response, x1.f1.lb.user.b.a<X, u<Boolean, Integer, String>> convertor) {
        String strB = x1.f1.lb.util.q.f21441a.b(3);
        return response == null ? kotlinx.coroutines.flow.h.w(x1.f1.lb.user.b.c(x1.f1.lb.user.b.f21174a, strB, new u(Boolean.FALSE, -1, null), null, 4, null)) : kotlinx.coroutines.flow.h.v(new b(response, convertor, strB, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object r(LoginRequest loginRequest, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        h hVar;
        LoginRequest loginRequest2;
        c cVar;
        if (fVar instanceof h) {
            hVar = (h) fVar;
            int i10 = hVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                hVar.label = i10 - Integer.MIN_VALUE;
            } else {
                hVar = new h(fVar);
            }
        } else {
            hVar = new h(fVar);
        }
        Object objE = hVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = hVar.label;
        if (i11 == 0) {
            r8.r.b(objE);
            x1.f1.lb.api.a aVar = x1.f1.lb.api.a.f20544a;
            hVar.L$0 = loginRequest;
            hVar.L$1 = this;
            hVar.label = 1;
            objE = aVar.e(loginRequest, hVar);
            if (objE == objC) {
                return objC;
            }
            loginRequest2 = loginRequest;
            cVar = this;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cVar = (c) hVar.L$1;
            loginRequest2 = (LoginRequest) hVar.L$0;
            r8.r.b(objE);
        }
        return cVar.q((com.skydoves.sandwich.a) objE, x1.f1.lb.user.b.g(x1.f1.lb.user.b.f21174a, true, false, new i(loginRequest2), null, null, null, null, false, 248, null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // x1.f1.lb.user.a
    public Object a(v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        j jVar;
        c cVar;
        if (fVar instanceof j) {
            jVar = (j) fVar;
            int i10 = jVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                jVar.label = i10 - Integer.MIN_VALUE;
            } else {
                jVar = new j(fVar);
            }
        } else {
            jVar = new j(fVar);
        }
        Object objF = jVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = jVar.label;
        if (i11 == 0) {
            r8.r.b(objF);
            x1.f1.lb.api.a aVar = x1.f1.lb.api.a.f20544a;
            jVar.L$0 = this;
            jVar.label = 1;
            objF = aVar.f(jVar);
            if (objF == objC) {
                return objC;
            }
            cVar = this;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cVar = (c) jVar.L$0;
            r8.r.b(objF);
        }
        return cVar.p((com.skydoves.sandwich.a) objF);
    }

    @Override // x1.f1.lb.user.a
    public Object b(String str, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        return r(new LoginRequest(str), fVar);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    @Override // x1.f1.lb.user.a
    public Object c(String str, String str2, String str3, String str4, String str5, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        C0450c c0450c;
        String strS;
        String str6;
        String str7;
        c cVar;
        String str8;
        c cVar2;
        String str9 = str;
        if (fVar instanceof C0450c) {
            c0450c = (C0450c) fVar;
            int i10 = c0450c.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c0450c.label = i10 - Integer.MIN_VALUE;
            } else {
                c0450c = new C0450c(fVar);
            }
        } else {
            c0450c = new C0450c(fVar);
        }
        C0450c c0450c2 = c0450c;
        Object objK = c0450c2.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = c0450c2.label;
        if (i11 != 0) {
            if (i11 == 1) {
                cVar = (c) c0450c2.L$3;
                strS = (String) c0450c2.L$2;
                String str10 = (String) c0450c2.L$1;
                str7 = (String) c0450c2.L$0;
                r8.r.b(objK);
                str6 = str10;
                return cVar.q((com.skydoves.sandwich.a) objK, x1.f1.lb.user.b.g(x1.f1.lb.user.b.f21174a, false, false, new d(str7, str6, strS), null, null, null, null, false, 248, null));
            }
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c cVar3 = (c) c0450c2.L$2;
            String str11 = (String) c0450c2.L$1;
            String str12 = (String) c0450c2.L$0;
            r8.r.b(objK);
            cVar2 = cVar3;
            str9 = str12;
            str8 = str11;
            return cVar2.q((com.skydoves.sandwich.a) objK, x1.f1.lb.user.b.g(x1.f1.lb.user.b.f21174a, false, false, new e(str9, str8), null, null, null, null, false, 248, null));
        }
        r8.r.b(objK);
        LocalSessionInfo localSessionInfoP0 = x1.f1.lb.user.f.f21202a.p0();
        strS = s(str2);
        String username = localSessionInfoP0 != null ? localSessionInfoP0.getUsername() : null;
        if (username == null || username.length() == 0) {
            x1.f1.lb.api.a aVar = x1.f1.lb.api.a.f20544a;
            c0450c2.L$0 = str9;
            str6 = str4;
            c0450c2.L$1 = str6;
            c0450c2.L$2 = strS;
            c0450c2.L$3 = this;
            c0450c2.label = 1;
            objK = x1.f1.lb.api.a.k(aVar, str9, strS, str3, null, c0450c2, 8, null);
            if (objK != objC) {
                str7 = str;
                cVar = this;
                return cVar.q((com.skydoves.sandwich.a) objK, x1.f1.lb.user.b.g(x1.f1.lb.user.b.f21174a, false, false, new d(str7, str6, strS), null, null, null, null, false, 248, null));
            }
        } else {
            x1.f1.lb.api.a aVar2 = x1.f1.lb.api.a.f20544a;
            c0450c2.L$0 = str9;
            c0450c2.L$1 = strS;
            c0450c2.L$2 = this;
            c0450c2.label = 2;
            objK = aVar2.d(str9, str4, strS, str3, c0450c2);
            if (objK != objC) {
                str8 = strS;
                cVar2 = this;
                return cVar2.q((com.skydoves.sandwich.a) objK, x1.f1.lb.user.b.g(x1.f1.lb.user.b.f21174a, false, false, new e(str9, str8), null, null, null, null, false, 248, null));
            }
        }
        return objC;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // x1.f1.lb.user.a
    public Object d(String str, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        q qVar;
        c cVar;
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
        Object objI = qVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = qVar.label;
        if (i11 == 0) {
            r8.r.b(objI);
            x1.f1.lb.api.a aVar = x1.f1.lb.api.a.f20544a;
            qVar.L$0 = this;
            qVar.label = 1;
            objI = aVar.i(str, qVar);
            if (objI == objC) {
                return objC;
            }
            cVar = this;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cVar = (c) qVar.L$0;
            r8.r.b(objI);
        }
        return cVar.q((com.skydoves.sandwich.a) objI, x1.f1.lb.user.b.f21174a.f(false, true, new r(), "", null, null, null, true));
    }

    @Override // x1.f1.lb.user.a
    public Object e(String str, String str2, String str3, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        return r(new LoginRequest(str, str2, str3), fVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // x1.f1.lb.user.a
    public Object f(v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        m mVar;
        c cVar;
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
        Object objH = mVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = mVar.label;
        if (i11 == 0) {
            r8.r.b(objH);
            x1.f1.lb.api.a aVar = x1.f1.lb.api.a.f20544a;
            mVar.L$0 = this;
            mVar.label = 1;
            objH = aVar.h(mVar);
            if (objH == objC) {
                return objC;
            }
            cVar = this;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cVar = (c) mVar.L$0;
            r8.r.b(objH);
        }
        return cVar.q((com.skydoves.sandwich.a) objH, new n());
    }

    @Override // x1.f1.lb.user.a
    public Object g(String str, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        return kotlinx.coroutines.flow.h.w(new u(kotlin.coroutines.jvm.internal.b.a(false), kotlin.coroutines.jvm.internal.b.b(-2), null));
    }

    @Override // x1.f1.lb.user.a
    public Object h(File file, v8.f<? super FeedbackUploadResponse> fVar) {
        return new FeedbackUploadResponse("-1", "", null);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    @Override // x1.f1.lb.user.a
    public Object i(String str, String str2, String str3, String str4, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        s sVar;
        c cVar;
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
        s sVar2 = sVar;
        Object objL = sVar2.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = sVar2.label;
        if (i11 == 0) {
            r8.r.b(objL);
            x1.f1.lb.api.a aVar = x1.f1.lb.api.a.f20544a;
            String strS = s(str3);
            sVar2.L$0 = this;
            sVar2.label = 1;
            objL = aVar.l(str, str2, strS, str4, sVar2);
            if (objL == objC) {
                return objC;
            }
            cVar = this;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cVar = (c) sVar2.L$0;
            r8.r.b(objL);
        }
        return cVar.p((com.skydoves.sandwich.a) objL);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // x1.f1.lb.user.a
    public Object j(v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        f fVar2;
        c cVar;
        if (fVar instanceof f) {
            fVar2 = (f) fVar;
            int i10 = fVar2.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                fVar2.label = i10 - Integer.MIN_VALUE;
            } else {
                fVar2 = new f(fVar);
            }
        } else {
            fVar2 = new f(fVar);
        }
        Object objC = fVar2.result;
        Object objC2 = kotlin.coroutines.intrinsics.b.c();
        int i11 = fVar2.label;
        if (i11 == 0) {
            r8.r.b(objC);
            LocalSessionInfo localSessionInfoP0 = x1.f1.lb.user.f.f21202a.p0();
            Long lC = localSessionInfoP0 != null ? kotlin.coroutines.jvm.internal.b.c(localSessionInfoP0.getAccountId()) : null;
            String accountName = localSessionInfoP0 != null ? localSessionInfoP0.getAccountName() : null;
            x1.f1.lb.api.a aVar = x1.f1.lb.api.a.f20544a;
            fVar2.L$0 = this;
            fVar2.label = 1;
            objC = aVar.c(lC, accountName, fVar2);
            if (objC == objC2) {
                return objC2;
            }
            cVar = this;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cVar = (c) fVar2.L$0;
            r8.r.b(objC);
        }
        return cVar.q((com.skydoves.sandwich.a) objC, x1.f1.lb.user.b.g(x1.f1.lb.user.b.f21174a, true, false, new g(), null, null, null, null, false, 248, null));
    }

    @Override // x1.f1.lb.user.a
    public Object k(v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        return kotlinx.coroutines.flow.h.w(new u(kotlin.coroutines.jvm.internal.b.a(false), kotlin.coroutines.jvm.internal.b.b(-2), null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // x1.f1.lb.user.a
    public Object l(String str, String str2, String str3, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        t tVar;
        c cVar;
        if (fVar instanceof t) {
            tVar = (t) fVar;
            int i10 = tVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                tVar.label = i10 - Integer.MIN_VALUE;
            } else {
                tVar = new t(fVar);
            }
        } else {
            tVar = new t(fVar);
        }
        Object objM = tVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = tVar.label;
        if (i11 == 0) {
            r8.r.b(objM);
            x1.f1.lb.api.a aVar = x1.f1.lb.api.a.f20544a;
            tVar.L$0 = this;
            tVar.label = 1;
            objM = aVar.m(str, str2, tVar);
            if (objM == objC) {
                return objC;
            }
            cVar = this;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cVar = (c) tVar.L$0;
            r8.r.b(objM);
        }
        return cVar.p((com.skydoves.sandwich.a) objM);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // x1.f1.lb.user.a
    public Object m(v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        k kVar;
        c cVar;
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
        Object objG = kVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = kVar.label;
        if (i11 == 0) {
            r8.r.b(objG);
            x1.f1.lb.api.a aVar = x1.f1.lb.api.a.f20544a;
            kVar.L$0 = this;
            kVar.label = 1;
            objG = aVar.g(kVar);
            if (objG == objC) {
                return objC;
            }
            cVar = this;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cVar = (c) kVar.L$0;
            r8.r.b(objG);
        }
        return cVar.q((com.skydoves.sandwich.a) objG, new l());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // x1.f1.lb.user.a
    public Object n(String str, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        o oVar;
        c cVar;
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
        Object objC = oVar.result;
        Object objC2 = kotlin.coroutines.intrinsics.b.c();
        int i11 = oVar.label;
        if (i11 == 0) {
            r8.r.b(objC);
            x1.f1.lb.api.c cVar2 = x1.f1.lb.api.c.f20556a;
            oVar.L$0 = this;
            oVar.label = 1;
            objC = cVar2.c(str, oVar);
            if (objC == objC2) {
                return objC2;
            }
            cVar = this;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cVar = (c) oVar.L$0;
            r8.r.b(objC);
        }
        return cVar.q((com.skydoves.sandwich.a) objC, x1.f1.lb.user.b.g(x1.f1.lb.user.b.f21174a, false, false, new p(), null, null, null, null, false, 248, null));
    }

    private final String s(String clearPassword) {
        String strO = x1.f1.lb.util.n.n().o(clearPassword);
        kotlin.jvm.internal.m.e(strO, "md5(...)");
        return strO;
    }
}
