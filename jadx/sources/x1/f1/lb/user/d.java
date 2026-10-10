package x1.f1.lb.user;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.pengrad.telegrambot.passport.decrypt.RsaOaep;
import com.taobao.sophix.PatchStatus;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import org.apache.log4j.net.SyslogAppender;
import r8.r;
import r8.u;
import r8.z;
import x1.f1.lb.util.d1;
import x1.f1.lb.util.q;
import x1.f1.lb.util.v0;
import z1.b1.lb.m.feedback.FeedbackUploadResponse;
import z1.b1.lb.m.ptv.ApiResponse;
import z1.b1.lb.m.ptv.ApiResponseBasic;
import z1.b1.lb.m.ptv.referral.ReferralSummary;
import z1.b1.lb.m.ptv.user.PTVLoginInfo;
import z1.b1.lb.m.ptv.user.RegisterRequest;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004*\u0001<\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ;\u0010\u0011\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e0\r2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012Jq\u0010\u0016\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e0\r\"\u0004\b\u0000\u0010\u00132\u0014\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0018\u00010\n2(\u0010\u0015\u001a$\u0012\u0004\u0012\u00028\u0000\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e0\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ,\u0010\u001b\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e0\rH\u0096@¢\u0006\u0004\b\u001b\u0010\u001cJ,\u0010\u001d\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e0\rH\u0096@¢\u0006\u0004\b\u001d\u0010\u001cJL\u0010!\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e0\r2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0096@¢\u0006\u0004\b!\u0010\"JD\u0010$\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e0\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0096@¢\u0006\u0004\b$\u0010%J4\u0010'\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e0\r2\u0006\u0010&\u001a\u00020\u0005H\u0096@¢\u0006\u0004\b'\u0010(J4\u0010*\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e0\r2\u0006\u0010)\u001a\u00020\u0005H\u0096@¢\u0006\u0004\b*\u0010(J,\u0010+\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e0\rH\u0096@¢\u0006\u0004\b+\u0010\u001cJ4\u0010,\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e0\r2\u0006\u0010&\u001a\u00020\u0005H\u0096@¢\u0006\u0004\b,\u0010(JD\u0010.\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e0\r2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0096@¢\u0006\u0004\b.\u0010%J4\u00100\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e0\r2\u0006\u0010/\u001a\u00020\u0005H\u0096@¢\u0006\u0004\b0\u0010(JT\u00103\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e0\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0096@¢\u0006\u0004\b3\u00104J,\u00105\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e0\rH\u0096@¢\u0006\u0004\b5\u0010\u001cJ,\u00106\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e0\rH\u0096@¢\u0006\u0004\b6\u0010\u001cJ\u0018\u0010:\u001a\u0002092\u0006\u00108\u001a\u000207H\u0096@¢\u0006\u0004\b:\u0010;R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010=¨\u0006?"}, d2 = {"Lx1/f1/lb/user/d;", "Lx1/f1/lb/user/a;", "Lz1/b1/lb/m/ptv/ApiResponse;", "<init>", "()V", "", "contact", "digitalCode", "u", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lcom/skydoves/sandwich/a;", "Lz1/b1/lb/m/ptv/ApiResponseBasic;", "response", "Lkotlinx/coroutines/flow/f;", "Lr8/u;", "", "", "r", "(Lcom/skydoves/sandwich/a;)Lkotlinx/coroutines/flow/f;", "X", "Lx1/f1/lb/user/b$a;", "convertor", "s", "(Lcom/skydoves/sandwich/a;Lx1/f1/lb/user/b$a;)Lkotlinx/coroutines/flow/f;", "clearPassword", "t", "(Ljava/lang/String;)Ljava/lang/String;", "f", "(Lv8/f;)Ljava/lang/Object;", "m", "userName", "password", "captchaCode", "i", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "actionType", "l", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "code", "n", "(Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "token", "g", "j", "b", "passwordDigest", "e", "refreshToken", "d", "verificationCode", "invitationCode", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "a", "k", "Ljava/io/File;", "feedbackFile", "Lz1/b1/lb/m/feedback/FeedbackUploadResponse;", "h", "(Ljava/io/File;Lv8/f;)Ljava/lang/Object;", "x1/f1/lb/user/d$p", "Lx1/f1/lb/user/d$p;", "updateSessionCallback", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d implements x1.f1.lb.user.a<ApiResponse<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final p updateSessionCallback = new p();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.PTV3AAdapter$callApi$1", f = "PTV3AAdapter.kt", l = {229, 232, 234, 236}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super u<? extends Boolean, ? extends Integer, ? extends String>>, v8.f<? super z>, Object> {
        final /* synthetic */ String $caller;
        final /* synthetic */ com.skydoves.sandwich.a<ApiResponseBasic> $response;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: x1.f1.lb.user.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.PTV3AAdapter$callApi$1$1", f = "PTV3AAdapter.kt", l = {230}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lz1/b1/lb/m/ptv/ApiResponseBasic;", "Lr8/z;", "<anonymous>", "(Lz1/b1/lb/m/ptv/ApiResponseBasic;)V"}, k = 3, mv = {2, 1, 0})
        static final class C0451a extends kotlin.coroutines.jvm.internal.l implements c9.p<ApiResponseBasic, v8.f<? super z>, Object> {
            final /* synthetic */ kotlinx.coroutines.flow.g<u<Boolean, Integer, String>> $$this$flow;
            final /* synthetic */ String $caller;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0451a(kotlinx.coroutines.flow.g<? super u<Boolean, Integer, String>> gVar, String str, v8.f<? super C0451a> fVar) {
                super(2, fVar);
                this.$$this$flow = gVar;
                this.$caller = str;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                C0451a c0451a = new C0451a(this.$$this$flow, this.$caller, fVar);
                c0451a.L$0 = obj;
                return c0451a;
            }

            @Override // c9.p
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(ApiResponseBasic apiResponseBasic, v8.f<? super z> fVar) {
                return ((C0451a) create(apiResponseBasic, fVar)).invokeSuspend(z.f17874a);
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
                                r.b(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            aVar = (com.skydoves.sandwich.a) this.L$1;
                            gVar3 = (kotlinx.coroutines.flow.g) this.L$0;
                            r.b(obj);
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
                        r.b(obj);
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
                    r.b(obj);
                }
                return z.f17874a;
            }
            r.b(obj);
            kotlinx.coroutines.flow.g gVar4 = (kotlinx.coroutines.flow.g) this.L$0;
            com.skydoves.sandwich.a<ApiResponseBasic> aVar2 = this.$response;
            C0451a c0451a = new C0451a(gVar4, this.$caller, null);
            this.L$0 = gVar4;
            this.label = 1;
            Object objG = com.skydoves.sandwich.c.g(aVar2, c0451a, this);
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
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.PTV3AAdapter$callApi$2", f = "PTV3AAdapter.kt", l = {253, 281, 283, 285}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super u<? extends Boolean, ? extends Integer, ? extends String>>, v8.f<? super z>, Object> {
        final /* synthetic */ String $caller;
        final /* synthetic */ long $clientRequestTimestamp;
        final /* synthetic */ x1.f1.lb.user.b.a<X, u<Boolean, Integer, String>> $convertor;
        final /* synthetic */ com.skydoves.sandwich.a<ApiResponse<X>> $response;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: Add missing generic type declarations: [X] */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.PTV3AAdapter$callApi$2$1", f = "PTV3AAdapter.kt", l = {266, 268, 270, 275}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"X", "Lz1/b1/lb/m/ptv/ApiResponse;", "Lr8/z;", "<anonymous>", "(Lz1/b1/lb/m/ptv/ApiResponse;)V"}, k = 3, mv = {2, 1, 0})
        static final class a<X> extends kotlin.coroutines.jvm.internal.l implements c9.p<ApiResponse<X>, v8.f<? super z>, Object> {
            final /* synthetic */ kotlinx.coroutines.flow.g<u<Boolean, Integer, String>> $$this$flow;
            final /* synthetic */ String $caller;
            final /* synthetic */ long $clientRequestTimestamp;
            final /* synthetic */ x1.f1.lb.user.b.a<X, u<Boolean, Integer, String>> $convertor;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(long j10, x1.f1.lb.user.b.a<X, u<Boolean, Integer, String>> aVar, kotlinx.coroutines.flow.g<? super u<Boolean, Integer, String>> gVar, String str, v8.f<? super a> fVar) {
                super(2, fVar);
                this.$clientRequestTimestamp = j10;
                this.$convertor = aVar;
                this.$$this$flow = gVar;
                this.$caller = str;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                a aVar = new a(this.$clientRequestTimestamp, this.$convertor, this.$$this$flow, this.$caller, fVar);
                aVar.L$0 = obj;
                return aVar;
            }

            @Override // c9.p
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(ApiResponse<X> apiResponse, v8.f<? super z> fVar) {
                return ((a) create(apiResponse, fVar)).invokeSuspend(z.f17874a);
            }

            /* JADX WARN: Code duplicated, block: B:23:0x0071  */
            /* JADX WARN: Code duplicated, block: B:26:0x007e  */
            /* JADX WARN: Code restructure failed: missing block: B:24:0x007b, code lost:
            
                if (r1.emit(r15, r14) == r0) goto L31;
             */
            /* JADX WARN: Code restructure failed: missing block: B:27:0x00ad, code lost:
            
                if (r15.emit(r1, r14) == r0) goto L31;
             */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x00dd, code lost:
            
                if (r15.emit(r1, r14) == r0) goto L31;
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
                        r.b(obj);
                    } else {
                        apiResponse = (ApiResponse) this.L$0;
                        r.b(obj);
                        uVar = (u) obj;
                        if (uVar != null) {
                            kotlinx.coroutines.flow.g<u<Boolean, Integer, String>> gVar = this.$$this$flow;
                            this.L$0 = null;
                            this.label = 2;
                        } else {
                            kotlinx.coroutines.flow.g<u<Boolean, Integer, String>> gVar2 = this.$$this$flow;
                            u<Boolean, Integer, String> uVarB = x1.f1.lb.user.b.f21174a.b(this.$caller, new u<>(kotlin.coroutines.jvm.internal.b.a(false), kotlin.coroutines.jvm.internal.b.b(apiResponse.getErrCode()), x1.f1.lb.util.e.f21383a.a(apiResponse)), this.$convertor.a());
                            this.L$0 = null;
                            this.label = 3;
                        }
                    }
                    return z.f17874a;
                }
                r.b(obj);
                apiResponse = (ApiResponse) this.L$0;
                long jC = d1.c();
                long serverTime = ((long) 1000) * apiResponse.getServerTime();
                if (serverTime > 0) {
                    d1.f("api", jC, this.$clientRequestTimestamp, serverTime);
                }
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
                            u<Boolean, Integer, String> uVarB2 = x1.f1.lb.user.b.f21174a.b(this.$caller, new u<>(kotlin.coroutines.jvm.internal.b.a(false), kotlin.coroutines.jvm.internal.b.b(apiResponse.getErrCode()), x1.f1.lb.util.e.f21383a.a(apiResponse)), this.$convertor.a());
                            this.L$0 = null;
                            this.label = 3;
                        }
                    }
                } else {
                    kotlinx.coroutines.flow.g<u<Boolean, Integer, String>> gVar5 = this.$$this$flow;
                    u<Boolean, Integer, String> uVarB3 = x1.f1.lb.user.b.f21174a.b(this.$caller, new u<>(kotlin.coroutines.jvm.internal.b.a(false), kotlin.coroutines.jvm.internal.b.b(apiResponse.getErrCode()), x1.f1.lb.util.e.f21383a.a(apiResponse)), this.$convertor.a());
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
        b(com.skydoves.sandwich.a<? extends ApiResponse<X>> aVar, long j10, x1.f1.lb.user.b.a<X, u<Boolean, Integer, String>> aVar2, String str, v8.f<? super b> fVar) {
            super(2, fVar);
            this.$response = aVar;
            this.$clientRequestTimestamp = j10;
            this.$convertor = aVar2;
            this.$caller = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            b bVar = new b(this.$response, this.$clientRequestTimestamp, this.$convertor, this.$caller, fVar);
            bVar.L$0 = obj;
            return bVar;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.flow.g<? super u<Boolean, Integer, String>> gVar, v8.f<? super z> fVar) {
            return ((b) create(gVar, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x009f  */
        /* JADX WARN: Code duplicated, block: B:29:0x00c4  */
        /* JADX WARN: Code duplicated, block: B:31:0x00c6 A[PHI: r1 r4
          0x00c6: PHI (r1v5 com.skydoves.sandwich.a) = (r1v4 com.skydoves.sandwich.a), (r1v7 com.skydoves.sandwich.a) binds: [B:25:0x009d, B:30:0x00c5] A[DONT_GENERATE, DONT_INLINE]
          0x00c6: PHI (r4v4 kotlinx.coroutines.flow.g) = (r4v3 kotlinx.coroutines.flow.g), (r4v5 kotlinx.coroutines.flow.g) binds: [B:25:0x009d, B:30:0x00c5] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:33:0x00cc  */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0094, code lost:
        
            if (r1.emit(r5, r13) == r0) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00ef, code lost:
        
            if (r4.emit(r14, r13) == r0) goto L35;
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
                                r.b(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            aVar = (com.skydoves.sandwich.a) this.L$1;
                            gVar3 = (kotlinx.coroutines.flow.g) this.L$0;
                            r.b(obj);
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
                        r.b(obj);
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
                    r.b(obj);
                }
                return z.f17874a;
            }
            r.b(obj);
            kotlinx.coroutines.flow.g gVar4 = (kotlinx.coroutines.flow.g) this.L$0;
            com.skydoves.sandwich.a<ApiResponse<X>> aVar2 = this.$response;
            a aVar3 = new a(this.$clientRequestTimestamp, this.$convertor, gVar4, this.$caller, null);
            this.L$0 = gVar4;
            this.label = 1;
            obj = com.skydoves.sandwich.c.g(aVar2, aVar3, this);
            if (obj != objC) {
                gVar = gVar4;
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

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.PTV3AAdapter", f = "PTV3AAdapter.kt", l = {187}, m = "getReferralSummary")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class c extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        c(v8.f<? super c> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return d.this.k(this);
        }
    }

    /* JADX INFO: renamed from: x1.f1.lb.user.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002$\u0012\u0004\u0012\u00020\u0002\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00030\u0001JD\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"x1/f1/lb/user/d$d", "Lx1/f1/lb/user/b$a;", "Lz1/b1/lb/m/ptv/referral/ReferralSummary;", "Lr8/u;", "", "", "", "code", NotificationCompat.CATEGORY_MESSAGE, "x", "c", "(ILjava/lang/String;Lz1/b1/lb/m/ptv/referral/ReferralSummary;Lv8/f;)Ljava/lang/Object;", "a", "()Ljava/lang/String;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C0452d implements x1.f1.lb.user.b.a<ReferralSummary, u<? extends Boolean, ? extends Integer, ? extends String>> {
        @Override // x1.f1.lb.user.b.a
        public String a() {
            return "get referral summary";
        }

        @Override // x1.f1.lb.user.b.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Object b(int i10, String str, ReferralSummary referralSummary, v8.f<? super u<Boolean, Integer, String>> fVar) {
            if (referralSummary == null) {
                return new u(kotlin.coroutines.jvm.internal.b.a(false), kotlin.coroutines.jvm.internal.b.b(i10), str);
            }
            x1.f1.lb.user.f.f21202a.A1(referralSummary);
            return new u(kotlin.coroutines.jvm.internal.b.a(true), kotlin.coroutines.jvm.internal.b.b(i10), str);
        }

        C0452d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.PTV3AAdapter", f = "PTV3AAdapter.kt", l = {161}, m = "linkContact")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class e extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        e(v8.f<? super e> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return d.this.c(null, null, null, null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.PTV3AAdapter$login$2", f = "PTV3AAdapter.kt", l = {110, 115}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class f extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super u<? extends Boolean, ? extends Integer, ? extends String>>, v8.f<? super z>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class a<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.g<u<Boolean, Integer, String>> f21193a;

            /* JADX WARN: Multi-variable type inference failed */
            a(kotlinx.coroutines.flow.g<? super u<Boolean, Integer, String>> gVar) {
                this.f21193a = gVar;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(u<Boolean, Integer, String> uVar, v8.f<? super z> fVar) {
                Object objEmit = this.f21193a.emit(uVar, fVar);
                return objEmit == kotlin.coroutines.intrinsics.b.c() ? objEmit : z.f17874a;
            }
        }

        @Override // c9.p
        public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.flow.g<? super u<? extends Boolean, ? extends Integer, ? extends String>> gVar, v8.f<? super z> fVar) {
            return invoke2((kotlinx.coroutines.flow.g<? super u<Boolean, Integer, String>>) gVar, fVar);
        }

        f(v8.f<? super f> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            f fVar2 = d.this.new f(fVar);
            fVar2.L$0 = obj;
            return fVar2;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.flow.g<? super u<Boolean, Integer, String>> gVar, v8.f<? super z> fVar) {
            return ((f) create(gVar, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x009b, code lost:
        
            if (r2.collect(r4, r19) == r1) goto L20;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object objD;
            kotlinx.coroutines.flow.g gVar;
            d dVar;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    dVar = (d) this.L$1;
                    kotlinx.coroutines.flow.g gVar2 = (kotlinx.coroutines.flow.g) this.L$0;
                    r.b(obj);
                    gVar = gVar2;
                    objD = obj;
                } else {
                    if (i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r.b(obj);
                }
                return z.f17874a;
            }
            r.b(obj);
            kotlinx.coroutines.flow.g gVar3 = (kotlinx.coroutines.flow.g) this.L$0;
            d dVar2 = d.this;
            x1.f1.lb.api.i iVar = x1.f1.lb.api.i.f20569a;
            this.L$0 = gVar3;
            this.L$1 = dVar2;
            this.label = 1;
            objD = iVar.d(this);
            if (objD != objC) {
                gVar = gVar3;
                dVar = dVar2;
            }
            return objC;
            kotlinx.coroutines.flow.f fVarS = dVar.s((com.skydoves.sandwich.a) objD, x1.f1.lb.user.f.f21202a.T0() ? x1.f1.lb.user.b.g(x1.f1.lb.user.b.f21174a, true, false, d.this.updateSessionCallback, "8.1", "", "", "", false, 128, null) : x1.f1.lb.user.b.g(x1.f1.lb.user.b.f21174a, true, false, d.this.updateSessionCallback, "8.2", null, null, null, false, 240, null));
            a aVar = new a(gVar);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.PTV3AAdapter", f = "PTV3AAdapter.kt", l = {PatchStatus.CODE_LOAD_LIB_UNDEFINED}, m = "login")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class g extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        g(v8.f<? super g> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return d.this.e(null, null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.PTV3AAdapter$logout$2", f = "PTV3AAdapter.kt", l = {SyslogAppender.LOG_LOCAL6, SyslogAppender.LOG_LOCAL6}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class h extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super u<? extends Boolean, ? extends Integer, ? extends String>>, v8.f<? super z>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class a<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.g<u<Boolean, Integer, String>> f21194a;

            /* JADX WARN: Multi-variable type inference failed */
            a(kotlinx.coroutines.flow.g<? super u<Boolean, Integer, String>> gVar) {
                this.f21194a = gVar;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(u<Boolean, Integer, String> uVar, v8.f<? super z> fVar) {
                Integer numE = uVar.e();
                if (numE != null && numE.intValue() == -9) {
                    Object objEmit = this.f21194a.emit(new u<>(kotlin.coroutines.jvm.internal.b.a(true), null, ""), fVar);
                    if (objEmit == kotlin.coroutines.intrinsics.b.c()) {
                        return objEmit;
                    }
                    return z.f17874a;
                }
                Object objEmit2 = this.f21194a.emit(uVar, fVar);
                if (objEmit2 == kotlin.coroutines.intrinsics.b.c()) {
                    return objEmit2;
                }
                return z.f17874a;
            }
        }

        @Override // c9.p
        public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.flow.g<? super u<? extends Boolean, ? extends Integer, ? extends String>> gVar, v8.f<? super z> fVar) {
            return invoke2((kotlinx.coroutines.flow.g<? super u<Boolean, Integer, String>>) gVar, fVar);
        }

        h(v8.f<? super h> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            h hVar = d.this.new h(fVar);
            hVar.L$0 = obj;
            return hVar;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.flow.g<? super u<Boolean, Integer, String>> gVar, v8.f<? super z> fVar) {
            return ((h) create(gVar, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
        
            if (r7.collect(r1, r6) == r0) goto L16;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            d dVar;
            kotlinx.coroutines.flow.g gVar;
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
                    dVar = (d) this.L$1;
                    gVar = (kotlinx.coroutines.flow.g) this.L$0;
                    r.b(obj);
                }
                return z.f17874a;
            }
            r.b(obj);
            kotlinx.coroutines.flow.g gVar2 = (kotlinx.coroutines.flow.g) this.L$0;
            dVar = d.this;
            x1.f1.lb.api.i iVar = x1.f1.lb.api.i.f20569a;
            this.L$0 = gVar2;
            this.L$1 = dVar;
            this.label = 1;
            Object objG = iVar.g(this);
            if (objG != objC) {
                gVar = gVar2;
                obj = objG;
            }
            return objC;
            kotlinx.coroutines.flow.f fVarR = dVar.r((com.skydoves.sandwich.a) obj);
            a aVar = new a(gVar);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.PTV3AAdapter", f = "PTV3AAdapter.kt", l = {34}, m = "queryMetaInfo")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class i extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        i(v8.f<? super i> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return d.this.f(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002$\u0012\u0004\u0012\u00020\u0002\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00030\u0001JD\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"x1/f1/lb/user/d$j", "Lx1/f1/lb/user/b$a;", "", "Lr8/u;", "", "", "", "code", NotificationCompat.CATEGORY_MESSAGE, "x", "b", "(ILjava/lang/String;Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "a", "()Ljava/lang/String;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class j implements x1.f1.lb.user.b.a<Object, u<? extends Boolean, ? extends Integer, ? extends String>> {
        @Override // x1.f1.lb.user.b.a
        public String a() {
            return "query meta info";
        }

        @Override // x1.f1.lb.user.b.a
        public Object b(int i10, String str, Object obj, v8.f<? super u<? extends Boolean, ? extends Integer, ? extends String>> fVar) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Map) {
                x1.f1.lb.user.b.f21174a.e((Map) obj);
            }
            return new u(kotlin.coroutines.jvm.internal.b.a(true), kotlin.coroutines.jvm.internal.b.b(i10), str);
        }

        j() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.PTV3AAdapter", f = "PTV3AAdapter.kt", l = {90}, m = "recharge")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class k extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        k(v8.f<? super k> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return d.this.n(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.PTV3AAdapter", f = "PTV3AAdapter.kt", l = {138}, m = "refresh")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class l extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        l(v8.f<? super l> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return d.this.d(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.PTV3AAdapter", f = "PTV3AAdapter.kt", l = {77}, m = "resetPassword")
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
            return d.this.i(null, null, null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.PTV3AAdapter", f = "PTV3AAdapter.kt", l = {85}, m = "sendCaptcha")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class n extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        n(v8.f<? super n> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return d.this.l(null, null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.PTV3AAdapter$updateSession$2", f = "PTV3AAdapter.kt", l = {99, 101}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class o extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super u<? extends Boolean, ? extends Integer, ? extends String>>, v8.f<? super z>, Object> {
        final /* synthetic */ String $token;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class a<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.g<u<Boolean, Integer, String>> f21195a;

            /* JADX WARN: Multi-variable type inference failed */
            a(kotlinx.coroutines.flow.g<? super u<Boolean, Integer, String>> gVar) {
                this.f21195a = gVar;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(u<Boolean, Integer, String> uVar, v8.f<? super z> fVar) {
                Object objEmit = this.f21195a.emit(uVar, fVar);
                return objEmit == kotlin.coroutines.intrinsics.b.c() ? objEmit : z.f17874a;
            }
        }

        @Override // c9.p
        public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.flow.g<? super u<? extends Boolean, ? extends Integer, ? extends String>> gVar, v8.f<? super z> fVar) {
            return invoke2((kotlinx.coroutines.flow.g<? super u<Boolean, Integer, String>>) gVar, fVar);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(String str, v8.f<? super o> fVar) {
            super(2, fVar);
            this.$token = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            o oVar = d.this.new o(this.$token, fVar);
            oVar.L$0 = obj;
            return oVar;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.flow.g<? super u<Boolean, Integer, String>> gVar, v8.f<? super z> fVar) {
            return ((o) create(gVar, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0091, code lost:
        
            if (r2.collect(r3, r20) == r1) goto L26;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.g gVar;
            int i10;
            d dVar;
            Object objF;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i11 = this.label;
            if (i11 != 0) {
                if (i11 == 1) {
                    i10 = this.I$0;
                    dVar = (d) this.L$1;
                    gVar = (kotlinx.coroutines.flow.g) this.L$0;
                    r.b(obj);
                    objF = obj;
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r.b(obj);
                }
                return z.f17874a;
            }
            r.b(obj);
            gVar = (kotlinx.coroutines.flow.g) this.L$0;
            x1.f1.lb.user.f fVar = x1.f1.lb.user.f.f21202a;
            i10 = (fVar.T0() || !fVar.J0()) ? 1 : 0;
            dVar = d.this;
            x1.f1.lb.api.i iVar = x1.f1.lb.api.i.f20569a;
            String str = this.$token;
            this.L$0 = gVar;
            this.L$1 = dVar;
            this.I$0 = i10;
            this.label = 1;
            objF = iVar.f(str, this);
            if (objF != objC) {
            }
            return objC;
            kotlinx.coroutines.flow.f fVarS = dVar.s((com.skydoves.sandwich.a) objF, x1.f1.lb.user.b.g(x1.f1.lb.user.b.f21174a, i10 != 0, false, d.this.updateSessionCallback, "4", null, null, null, false, 240, null));
            a aVar = new a(gVar);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"x1/f1/lb/user/d$p", "Lx1/f1/lb/util/m;", "Lx1/f1/lb/user/e;", "Lz1/b1/lb/m/ptv/user/PTVLoginInfo;", "v", "Lr8/z;", "c", "(Lx1/f1/lb/user/e;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class p implements x1.f1.lb.util.m<x1.f1.lb.user.e<PTVLoginInfo>> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(x1.f1.lb.user.e<PTVLoginInfo> v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            x1.f1.lb.user.g.f21276a.d(v10);
        }

        p() {
        }
    }

    private final String u(String contact, String digitalCode) {
        return ua.n.I(contact, digitalCode, false, 2, null) ? ua.n.E(contact, digitalCode, "", false, 4, null) : contact;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlinx.coroutines.flow.f<u<Boolean, Integer, String>> r(com.skydoves.sandwich.a<? extends ApiResponseBasic> response) {
        return response == null ? kotlinx.coroutines.flow.h.w(new u(Boolean.FALSE, -1, "response is null")) : kotlinx.coroutines.flow.h.v(new a(response, q.f21441a.b(3), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <X> kotlinx.coroutines.flow.f<u<Boolean, Integer, String>> s(com.skydoves.sandwich.a<? extends ApiResponse<X>> response, x1.f1.lb.user.b.a<X, u<Boolean, Integer, String>> convertor) {
        String strB = q.f21441a.b(3);
        return response == null ? kotlinx.coroutines.flow.h.w(x1.f1.lb.user.b.c(x1.f1.lb.user.b.f21174a, strB, new u(Boolean.FALSE, -1, "response is null"), null, 4, null)) : kotlinx.coroutines.flow.h.v(new b(response, d1.c(), convertor, strB, null));
    }

    @Override // x1.f1.lb.user.a
    public Object a(v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        return kotlinx.coroutines.flow.h.v(new h(null));
    }

    @Override // x1.f1.lb.user.a
    public Object b(String str, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        return kotlinx.coroutines.flow.h.w(new u(kotlin.coroutines.jvm.internal.b.a(false), kotlin.coroutines.jvm.internal.b.b(-2), "api not support"));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    @Override // x1.f1.lb.user.a
    public Object c(String str, String str2, String str3, String str4, String str5, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        e eVar;
        d dVar;
        String str6;
        String str7;
        d dVar2;
        if (fVar instanceof e) {
            eVar = (e) fVar;
            int i10 = eVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                eVar.label = i10 - Integer.MIN_VALUE;
            } else {
                eVar = new e(fVar);
            }
        } else {
            eVar = new e(fVar);
        }
        Object objL = eVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = eVar.label;
        if (i11 == 0) {
            r.b(objL);
            RegisterRequest registerRequest = new RegisterRequest(of.a.f16585a.b(), x1.f1.lb.user.f.f21202a.b0(), str, str2, str3, str5);
            x1.f1.lb.api.i iVar = x1.f1.lb.api.i.f20569a;
            eVar.L$0 = this;
            eVar.L$1 = str;
            eVar.L$2 = str2;
            eVar.L$3 = this;
            eVar.label = 1;
            objL = iVar.l(registerRequest, eVar);
            if (objL == objC) {
                return objC;
            }
            dVar = this;
            str6 = str;
            str7 = str2;
            dVar2 = dVar;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            dVar2 = (d) eVar.L$3;
            String str8 = (String) eVar.L$2;
            String str9 = (String) eVar.L$1;
            dVar = (d) eVar.L$0;
            r.b(objL);
            str7 = str8;
            str6 = str9;
        }
        return dVar2.s((com.skydoves.sandwich.a) objL, x1.f1.lb.user.b.g(x1.f1.lb.user.b.f21174a, true, false, dVar.updateSessionCallback, "c", str6, dVar.t(str7), null, false, RsaOaep.DerParser.PRIVATE, null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // x1.f1.lb.user.a
    public Object d(String str, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        l lVar;
        d dVar;
        d dVar2;
        if (fVar instanceof l) {
            lVar = (l) fVar;
            int i10 = lVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                lVar.label = i10 - Integer.MIN_VALUE;
            } else {
                lVar = new l(fVar);
            }
        } else {
            lVar = new l(fVar);
        }
        Object objK = lVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = lVar.label;
        if (i11 == 0) {
            r.b(objK);
            x1.f1.lb.api.i iVar = x1.f1.lb.api.i.f20569a;
            lVar.L$0 = this;
            lVar.L$1 = this;
            lVar.label = 1;
            objK = iVar.k(str, lVar);
            if (objK == objC) {
                return objC;
            }
            dVar = this;
            dVar2 = dVar;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            dVar = (d) lVar.L$1;
            dVar2 = (d) lVar.L$0;
            r.b(objK);
        }
        return dVar.s((com.skydoves.sandwich.a) objK, x1.f1.lb.user.b.f21174a.f(false, true, dVar2.updateSessionCallback, ExifInterface.GPS_MEASUREMENT_2D, null, null, null, true));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // x1.f1.lb.user.a
    public Object e(String str, String str2, String str3, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        g gVar;
        d dVar;
        String str4;
        d dVar2;
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
        Object objE = gVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = gVar.label;
        if (i11 == 0) {
            r.b(objE);
            x1.f1.lb.api.i iVar = x1.f1.lb.api.i.f20569a;
            gVar.L$0 = this;
            gVar.L$1 = str;
            gVar.L$2 = str2;
            gVar.L$3 = this;
            gVar.label = 1;
            objE = iVar.e(str, str2, str3, gVar);
            if (objE == objC) {
                return objC;
            }
            dVar = this;
            str4 = str;
            dVar2 = dVar;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            dVar2 = (d) gVar.L$3;
            str2 = (String) gVar.L$2;
            String str5 = (String) gVar.L$1;
            dVar = (d) gVar.L$0;
            r.b(objE);
            str4 = str5;
        }
        return dVar2.s((com.skydoves.sandwich.a) objE, x1.f1.lb.user.b.g(x1.f1.lb.user.b.f21174a, true, false, dVar.updateSessionCallback, "1", str4, str2, null, false, RsaOaep.DerParser.PRIVATE, null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // x1.f1.lb.user.a
    public Object f(v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        i iVar;
        d dVar;
        if (fVar instanceof i) {
            iVar = (i) fVar;
            int i10 = iVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                iVar.label = i10 - Integer.MIN_VALUE;
            } else {
                iVar = new i(fVar);
            }
        } else {
            iVar = new i(fVar);
        }
        Object objH = iVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = iVar.label;
        if (i11 == 0) {
            r.b(objH);
            x1.f1.lb.api.i iVar2 = x1.f1.lb.api.i.f20569a;
            iVar.L$0 = this;
            iVar.label = 1;
            objH = iVar2.h(iVar);
            if (objH == objC) {
                return objC;
            }
            dVar = this;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            dVar = (d) iVar.L$0;
            r.b(objH);
        }
        return dVar.s((com.skydoves.sandwich.a) objH, new j());
    }

    @Override // x1.f1.lb.user.a
    public Object g(String str, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        return kotlinx.coroutines.flow.h.v(new o(str, null));
    }

    @Override // x1.f1.lb.user.a
    public Object h(File file, v8.f<? super FeedbackUploadResponse> fVar) {
        return x1.f1.lb.api.i.f20569a.p(file, fVar);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    @Override // x1.f1.lb.user.a
    public Object i(String str, String str2, String str3, String str4, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        m mVar;
        d dVar;
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
        m mVar2 = mVar;
        Object objM = mVar2.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = mVar2.label;
        if (i11 == 0) {
            r.b(objM);
            x1.f1.lb.api.i iVar = x1.f1.lb.api.i.f20569a;
            mVar2.L$0 = this;
            mVar2.label = 1;
            objM = iVar.m(str, str2, str3, str4, mVar2);
            if (objM == objC) {
                return objC;
            }
            dVar = this;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            dVar = (d) mVar2.L$0;
            r.b(objM);
        }
        return dVar.r((com.skydoves.sandwich.a) objM);
    }

    @Override // x1.f1.lb.user.a
    public Object j(v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        return kotlinx.coroutines.flow.h.v(new f(null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // x1.f1.lb.user.a
    public Object k(v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        c cVar;
        d dVar;
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
        Object objJ = cVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = cVar.label;
        if (i11 == 0) {
            r.b(objJ);
            x1.f1.lb.api.i iVar = x1.f1.lb.api.i.f20569a;
            cVar.L$0 = this;
            cVar.label = 1;
            objJ = iVar.j(cVar);
            if (objJ == objC) {
                return objC;
            }
            dVar = this;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            dVar = (d) cVar.L$0;
            r.b(objJ);
        }
        return dVar.s((com.skydoves.sandwich.a) objJ, new C0452d());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // x1.f1.lb.user.a
    public Object l(String str, String str2, String str3, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        n nVar;
        d dVar;
        if (fVar instanceof n) {
            nVar = (n) fVar;
            int i10 = nVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                nVar.label = i10 - Integer.MIN_VALUE;
            } else {
                nVar = new n(fVar);
            }
        } else {
            nVar = new n(fVar);
        }
        Object objN = nVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = nVar.label;
        if (i11 == 0) {
            r.b(objN);
            x1.f1.lb.api.i iVar = x1.f1.lb.api.i.f20569a;
            String strU = u(str, str2);
            nVar.L$0 = this;
            nVar.label = 1;
            objN = iVar.n(strU, str2, str3, nVar);
            if (objN == objC) {
                return objC;
            }
            dVar = this;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            dVar = (d) nVar.L$0;
            r.b(objN);
        }
        return dVar.r((com.skydoves.sandwich.a) objN);
    }

    @Override // x1.f1.lb.user.a
    public Object m(v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        return kotlinx.coroutines.flow.h.w(new u(kotlin.coroutines.jvm.internal.b.a(false), kotlin.coroutines.jvm.internal.b.b(-2), "api not support"));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // x1.f1.lb.user.a
    public Object n(String str, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        k kVar;
        d dVar;
        d dVar2;
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
        Object objI = kVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = kVar.label;
        if (i11 == 0) {
            r.b(objI);
            x1.f1.lb.api.i iVar = x1.f1.lb.api.i.f20569a;
            kVar.L$0 = this;
            kVar.L$1 = this;
            kVar.label = 1;
            objI = iVar.i(str, kVar);
            if (objI == objC) {
                return objC;
            }
            dVar = this;
            dVar2 = dVar;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            dVar = (d) kVar.L$1;
            dVar2 = (d) kVar.L$0;
            r.b(objI);
        }
        return dVar.s((com.skydoves.sandwich.a) objI, x1.f1.lb.user.b.g(x1.f1.lb.user.b.f21174a, false, false, dVar2.updateSessionCallback, ExifInterface.GPS_MEASUREMENT_3D, null, null, null, false, 240, null));
    }

    private final String t(String clearPassword) {
        String strO = x1.f1.lb.util.n.n().o(clearPassword);
        kotlin.jvm.internal.m.e(strO, "md5(...)");
        return strO;
    }
}
