package lb;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.d0;
import okhttp3.e0;
import okhttp3.n;
import okhttp3.w;
import okhttp3.x;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Llb/a;", "Lokhttp3/w;", "Lokhttp3/n;", "cookieJar", "<init>", "(Lokhttp3/n;)V", "", "Lokhttp3/m;", "cookies", "", "b", "(Ljava/util/List;)Ljava/lang/String;", "Lokhttp3/w$a;", "chain", "Lokhttp3/d0;", "a", "(Lokhttp3/w$a;)Lokhttp3/d0;", "Lokhttp3/n;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class a implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final n cookieJar;

    public a(n cookieJar) {
        m.f(cookieJar, "cookieJar");
        this.cookieJar = cookieJar;
    }

    private final String b(List<okhttp3.m> cookies) {
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        for (Object obj : cookies) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                r.v();
            }
            okhttp3.m mVar = (okhttp3.m) obj;
            if (i10 > 0) {
                sb2.append("; ");
            }
            sb2.append(mVar.getName());
            sb2.append('=');
            sb2.append(mVar.getValue());
            i10 = i11;
        }
        String string = sb2.toString();
        m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // okhttp3.w
    public d0 a(w.a chain) {
        e0 body;
        m.f(chain, "chain");
        b0 b0VarF = chain.getRequest();
        b0.a aVarH = b0VarF.h();
        c0 body2 = b0VarF.getBody();
        if (body2 != null) {
            x contentType = body2.getContentType();
            if (contentType != null) {
                aVarH.e("Content-Type", contentType.getMediaType());
            }
            long jA = body2.a();
            if (jA != -1) {
                aVarH.e("Content-Length", String.valueOf(jA));
                aVarH.i("Transfer-Encoding");
            } else {
                aVarH.e("Transfer-Encoding", "chunked");
                aVarH.i("Content-Length");
            }
        }
        boolean z10 = false;
        if (b0VarF.d("Host") == null) {
            aVarH.e("Host", hb.d.R(b0VarF.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String(), false, 1, null));
        }
        if (b0VarF.d("Connection") == null) {
            aVarH.e("Connection", "Keep-Alive");
        }
        if (b0VarF.d("Accept-Encoding") == null && b0VarF.d("Range") == null) {
            aVarH.e("Accept-Encoding", "gzip");
            z10 = true;
        }
        List<okhttp3.m> listB = this.cookieJar.b(b0VarF.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String());
        if (!listB.isEmpty()) {
            aVarH.e("Cookie", b(listB));
        }
        if (b0VarF.d("User-Agent") == null) {
            aVarH.e("User-Agent", "okhttp/4.12.0");
        }
        d0 d0VarA = chain.a(aVarH.b());
        e.f(this.cookieJar, b0VarF.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String(), d0VarA.getHeaders());
        d0.a aVarR = d0VarA.q().r(b0VarF);
        if (z10 && ua.n.w("gzip", d0.l(d0VarA, "Content-Encoding", null, 2, null), true) && e.b(d0VarA) && (body = d0VarA.getBody()) != null) {
            tb.k kVar = new tb.k(body.getSource());
            aVarR.k(d0VarA.getHeaders().h().h("Content-Encoding").h("Content-Length").f());
            aVarR.b(new h(d0.l(d0VarA, "Content-Type", null, 2, null), -1L, tb.n.b(kVar)));
        }
        return aVarR.c();
    }
}
