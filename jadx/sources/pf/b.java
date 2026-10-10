package pf;

import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.b0;
import okhttp3.d0;
import okhttp3.e0;
import okhttp3.w;
import okhttp3.x;
import ua.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\f\u001a\n \n*\u0004\u0018\u00010\t0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000b¨\u0006\r"}, d2 = {"Lpf/b;", "Lokhttp3/w;", "<init>", "()V", "Lokhttp3/w$a;", "chain", "Lokhttp3/d0;", "a", "(Lokhttp3/w$a;)Lokhttp3/d0;", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger = q6.c.d(b.class);

    @Override // okhttp3.w
    @RequiresApi(30)
    public d0 a(w.a chain) {
        lf.b.EncryptedPayload encryptedPayload;
        String strE;
        String strL;
        m.f(chain, "chain");
        b0 request = chain.getRequest();
        d0 d0VarA = chain.a(request);
        lf.b bVar = lf.b.f15415a;
        if (!bVar.g() || (encryptedPayload = c.f17588a.a().get(request)) == null) {
            return d0VarA;
        }
        d0.a aVarQ = d0VarA.q();
        String strL2 = d0.l(d0VarA, "X-Timestamp", null, 2, null);
        String strL3 = d0.l(d0VarA, "X-Nonce", null, 2, null);
        String strL4 = d0.l(d0VarA, "X-Sign", null, 2, null);
        if (strL2 != null && strL2.length() != 0 && strL3 != null && strL3.length() != 0 && strL4 != null && strL4.length() != 0) {
            e0 body = d0VarA.getBody();
            if (body == null || (strL = body.l()) == null || (strE = n.E(strL, "\"", "", false, 4, null)) == null) {
                strE = "";
            }
            aVarQ.b(e0.INSTANCE.a(bVar.e(strE, strL2, strL3, strL4, encryptedPayload.getAesKey(), encryptedPayload.getIvRaw(), "MDYcfn10w0SRglN87LkxGC3E13xLMgKN"), x.INSTANCE.b("application/json")));
            return aVarQ.c();
        }
        this.logger.error("response header invalid, url[" + chain.getRequest().getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String() + "] request headers[" + request.getHeaders() + "]", new Object[0]);
        this.logger.error("response header invalid, url[" + chain.getRequest().getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String() + "] response [" + d0VarA.getCode() + "] headers[" + d0VarA.getHeaders() + "]", new Object[0]);
        return d0VarA;
    }
}
