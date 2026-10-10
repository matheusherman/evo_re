package pf;

import com.google.gson.e;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.d0;
import okhttp3.e0;
import okhttp3.j;
import okhttp3.v;
import okhttp3.w;
import okhttp3.x;
import org.apache.log4j.spi.LocationInfo;
import tb.d;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import ua.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\f\u001a\n \n*\u0004\u0018\u00010\t0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000b¨\u0006\r"}, d2 = {"Lpf/a;", "Lokhttp3/w;", "<init>", "()V", "Lokhttp3/w$a;", "chain", "Lokhttp3/d0;", "a", "(Lokhttp3/w$a;)Lokhttp3/d0;", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger = q6.c.d(a.class);

    @Override // okhttp3.w
    public d0 a(w.a chain) {
        a0 a0VarA;
        m.f(chain, "chain");
        b0 request = chain.getRequest();
        try {
            lf.b bVar = lf.b.f15415a;
            if (!bVar.g()) {
                String str = request.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String().getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String();
                b0.a aVarH = request.h();
                of.a.f16585a.n(str, aVarH);
                return chain.a(aVarH.b());
            }
            String method = request.getMethod();
            if (m.a(method, IMediaPlayer.DRM_REQ_GET)) {
                v vVarC = request.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String().k().c();
                String str2 = vVarC.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String();
                String strO = vVarC.o();
                String strE = n.E(n.E(str2, strO == null ? "" : strO, "", false, 4, null), LocationInfo.NA, "", false, 4, null);
                b0.a aVarK = request.h().k(strE);
                of.a.f16585a.n(strE, aVarK);
                HashMap map = new HashMap();
                Iterator<String> it = vVarC.q().iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    Iterator<String> it2 = it;
                    String strP = vVarC.p(next);
                    if (strP != null) {
                        map.put(next, strP);
                    }
                    it = it2;
                }
                String strW = new e().w(map);
                lf.b bVar2 = lf.b.f15415a;
                m.c(strW);
                lf.b.EncryptedPayload encryptedPayloadD = bVar2.d(strW);
                aVarK.a("X-Version", "1001").a("Content-Type", "application/octet-stream").a("X-Key", encryptedPayloadD.getAesKeyEncrypted()).a("X-V", encryptedPayloadD.getIv()).a("X-Timestamp", encryptedPayloadD.getTimestamp()).a("X-Nonce", encryptedPayloadD.getNonce()).a("X-Sign", encryptedPayloadD.getSign()).a("X-Data", encryptedPayloadD.getCipherText());
                b0 b0VarB = aVarK.b();
                c.f17588a.a().put(b0VarB, encryptedPayloadD);
                return chain.a(b0VarB);
            }
            if (!m.a(method, IMediaPlayer.DRM_REQ_POST)) {
                String str3 = request.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String().getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String();
                b0.a aVarH2 = request.h();
                of.a.f16585a.n(str3, aVarH2);
                return chain.a(aVarH2.b());
            }
            d dVar = new d();
            c0 body = request.getBody();
            if (body != null) {
                body.i(dVar);
            }
            Charset charsetForName = Charset.forName("UTF-8");
            x contentType = body != null ? body.getContentType() : null;
            if (contentType != null) {
                charsetForName = contentType.c(charsetForName);
            }
            m.c(charsetForName);
            lf.b.EncryptedPayload encryptedPayloadD2 = bVar.d(dVar.U(charsetForName));
            c0 c0VarB = c0.INSTANCE.b(encryptedPayloadD2.getCipherText(), x.INSTANCE.a("application/octet-stream"));
            String str4 = request.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String().getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String();
            b0.a aVarH3 = request.h();
            of.a.f16585a.n(str4, aVarH3);
            aVarH3.h(c0VarB).a("X-Version", "1001").a("X-Key", encryptedPayloadD2.getAesKeyEncrypted()).a("X-V", encryptedPayloadD2.getIv()).a("X-Timestamp", encryptedPayloadD2.getTimestamp()).a("X-Nonce", encryptedPayloadD2.getNonce()).a("X-Sign", encryptedPayloadD2.getSign());
            b0 b0VarB2 = aVarH3.b();
            c.f17588a.a().put(b0VarB2, encryptedPayloadD2);
            return chain.a(b0VarB2);
        } catch (Throwable th) {
            this.logger.error("request failure[" + request.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String() + "]", th);
            d0.a aVar = new d0.a();
            j jVarB = chain.b();
            if (jVarB == null || (a0VarA = jVarB.a()) == null) {
                a0VarA = a0.HTTP_1_1;
            }
            return aVar.p(a0VarA).r(request).g(400).m("failure in request interceptor").b(e0.INSTANCE.a("", null)).c();
        }
    }
}
