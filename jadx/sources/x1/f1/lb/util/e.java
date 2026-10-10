package x1.f1.lb.util;

import kotlin.Metadata;
import x.l1.b2.R$string;
import z1.b1.lb.m.IApiResponse;
import z1.b1.lb.m.ptv.ApiResponseBasic;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014¨\u0006\u0016"}, d2 = {"Lx1/f1/lb/util/e;", "", "<init>", "()V", "", "code", "b", "(I)I", "Lz1/b1/lb/m/IApiResponse;", "response", "", "a", "(Lz1/b1/lb/m/IApiResponse;)Ljava/lang/String;", "errorMsg", "Lr8/u;", "", "c", "(Ljava/lang/String;)Lr8/u;", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f21383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    static {
        e eVar = new e();
        f21383a = eVar;
        logger = q6.c.d(eVar.getClass());
    }

    public final String a(IApiResponse response) {
        String str;
        kotlin.jvm.internal.m.f(response, "response");
        int errCode = response.getErrCode();
        String errMsg = response.getErrMsg();
        if (errCode == 9000010) {
            xe.c.c().o(new nf.u(errCode, "api"));
            x1.f1.lb.user.f.f21202a.x1();
        } else if (errCode == 9000042) {
            xe.c.c().o(new nf.u(errCode, "api"));
            x1.f1.lb.user.f.f21202a.Z0("API", 1);
        }
        int iB = b(errCode);
        if (iB == 0) {
            return "";
        }
        if (response instanceof ApiResponseBasic) {
            str = "a[" + ((ApiResponseBasic) response).c() + ":" + errMsg + "]";
        } else {
            str = "b[" + errCode + ":" + errMsg + "]";
        }
        logger.error("api_failure: " + str, new Object[0]);
        if (iB == R$string.unknown_error_code) {
            kotlin.jvm.internal.m.c(errMsg);
            return errMsg;
        }
        kotlin.jvm.internal.m.c(errMsg);
        return errMsg;
    }

    public final r8.u<Boolean, Integer, String> c(String errorMsg) {
        return new r8.u<>(Boolean.FALSE, -3, errorMsg);
    }

    private e() {
    }

    private final int b(int code) {
        switch (code) {
            case 0:
                return 0;
            case 10100001:
                return R$string.password_is_incorrect;
            case 10100003:
                return R$string.account_is_locked;
            case 10100007:
                return R$string.recharge_code_error;
            case 10100008:
                return R$string.recharge_code_used;
            case 10100009:
                return R$string.recharge_code_locked;
            case 10100010:
                return R$string.recharge_code_forbidden;
            case 10100011:
                return R$string.recharge_code_invalid;
            case 10100027:
                return R$string.account_or_password_error;
            case 10100028:
                return R$string.account_or_verification_code_incorrect;
            case 10100030:
                return R$string.verification_code_incorrect;
            case 10100033:
                return R$string.contact_already_exists;
            case 10100037:
                return R$string.unlink_failure;
            case 10100039:
                return R$string.unlink_not_allow;
            default:
                return R$string.unknown_error_code;
        }
    }
}
