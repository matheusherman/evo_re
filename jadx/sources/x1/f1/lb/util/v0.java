package x1.f1.lb.util;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import java.net.SocketTimeoutException;
import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import x.l1.b2.R$string;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0014¨\u0006\u0016"}, d2 = {"Lx1/f1/lb/util/v0;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/skydoves/sandwich/a$b$b;", "exception", "", "b", "(Lcom/skydoves/sandwich/a$b$b;)Ljava/lang/String;", "Lcom/skydoves/sandwich/a$b$a;", IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR, "a", "(Lcom/skydoves/sandwich/a$b$a;)Ljava/lang/String;", "Lcom/skydoves/sandwich/a$b;", "failure", "c", "(Lcom/skydoves/sandwich/a$b;)Ljava/lang/String;", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v0 f21450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    static {
        v0 v0Var = new v0();
        f21450a = v0Var;
        logger = q6.c.d(v0Var.getClass());
    }

    public final <T> String a(com.skydoves.sandwich.a.b.C0151a<T> error) {
        kotlin.jvm.internal.m.f(error, "error");
        okhttp3.d0 raw = error.getRaw();
        q6.b bVar = logger;
        bVar.error("ApiResponse.Failure.Error: url[" + raw.getRequest().getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String() + "] message[" + com.skydoves.sandwich.b.c(error) + "]", new Object[0]);
        bVar.error("ApiResponse.Failure.Error: url[" + raw.getRequest().getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String() + "] request headers[" + raw.getHeaders() + "]", new Object[0]);
        bVar.error("ApiResponse.Failure.Error: url[" + raw.getRequest().getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String() + "] response(" + raw.getCode() + ") headers[" + raw.getHeaders() + "]", new Object[0]);
        com.skydoves.sandwich.e statusCode = error.getStatusCode();
        return statusCode.name() + "(" + statusCode.getCode() + ")";
    }

    public final <T> String b(com.skydoves.sandwich.a.b.C0152b<T> exception) {
        String simpleName;
        kotlin.jvm.internal.m.f(exception, "exception");
        logger.error("ApiResponse.Failure.Exception:[" + com.skydoves.sandwich.b.d(exception) + "]", exception.getException());
        if (exception.getException() instanceof SocketTimeoutException) {
            Context contextA = x1.f1.lb.config.b.f20643a.a();
            simpleName = contextA != null ? contextA.getString(R$string.timeout_error) : null;
        } else {
            simpleName = exception.getException().getClass().getSimpleName();
        }
        return simpleName == null ? "Unknown error" : simpleName;
    }

    public final <T> String c(com.skydoves.sandwich.a.b<T> failure) {
        String string;
        kotlin.jvm.internal.m.f(failure, "failure");
        logger.error("ApiResponse.Failure:Request failure[" + com.skydoves.sandwich.b.e(failure) + "]", new Object[0]);
        Context contextA = x1.f1.lb.config.b.f20643a.a();
        return (contextA == null || (string = contextA.getString(R$string.request_failure)) == null) ? "Request failure" : string;
    }

    private v0() {
    }
}
