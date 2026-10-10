package rb;

import com.pengrad.telegrambot.model.chatbackground.BackgroundTypePattern;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import tb.b0;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import ua.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\nJ\u0013\u0010\r\u001a\u00020\u0004*\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\b*\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0012\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\nJ\u001b\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lrb/d;", "Ljavax/net/ssl/HostnameVerifier;", "<init>", "()V", "", "ipAddress", "Ljava/security/cert/X509Certificate;", "certificate", "", "h", "(Ljava/lang/String;Ljava/security/cert/X509Certificate;)Z", "hostname", "g", "b", "(Ljava/lang/String;)Ljava/lang/String;", "d", "(Ljava/lang/String;)Z", BackgroundTypePattern.TYPE, "f", "(Ljava/lang/String;Ljava/lang/String;)Z", "", IjkMediaMeta.IJKM_KEY_TYPE, "", "c", "(Ljava/security/cert/X509Certificate;I)Ljava/util/List;", "host", "Ljavax/net/ssl/SSLSession;", "session", "verify", "(Ljava/lang/String;Ljavax/net/ssl/SSLSession;)Z", "e", "a", "(Ljava/security/cert/X509Certificate;)Ljava/util/List;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class d implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f17904a = new d();

    private final boolean f(String hostname, String pattern) {
        if (hostname != null && hostname.length() != 0 && !n.I(hostname, ".", false, 2, null) && !n.v(hostname, "..", false, 2, null) && pattern != null && pattern.length() != 0 && !n.I(pattern, ".", false, 2, null) && !n.v(pattern, "..", false, 2, null)) {
            if (!n.v(hostname, ".", false, 2, null)) {
                hostname = hostname + '.';
            }
            String str = hostname;
            if (!n.v(pattern, ".", false, 2, null)) {
                pattern = pattern + '.';
            }
            String strB = b(pattern);
            if (!n.O(strB, "*", false, 2, null)) {
                return m.a(str, strB);
            }
            if (!n.I(strB, "*.", false, 2, null) || n.a0(strB, '*', 1, false, 4, null) != -1 || str.length() < strB.length() || m.a("*.", strB)) {
                return false;
            }
            String strSubstring = strB.substring(1);
            m.e(strSubstring, "this as java.lang.String).substring(startIndex)");
            if (!n.v(str, strSubstring, false, 2, null)) {
                return false;
            }
            int length = str.length() - strSubstring.length();
            return length <= 0 || n.g0(str, '.', length + (-1), false, 4, null) == -1;
        }
        return false;
    }

    public final List<String> a(X509Certificate certificate) {
        m.f(certificate, "certificate");
        return r.B0(c(certificate, 7), c(certificate, 2));
    }

    public final boolean e(String host, X509Certificate certificate) {
        m.f(host, "host");
        m.f(certificate, "certificate");
        return hb.d.i(host) ? h(host, certificate) : g(host, certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String host, SSLSession session) {
        m.f(host, "host");
        m.f(session, "session");
        if (!d(host)) {
            return false;
        }
        try {
            Certificate certificate = session.getPeerCertificates()[0];
            m.d(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            return e(host, (X509Certificate) certificate);
        } catch (SSLException unused) {
            return false;
        }
    }

    private d() {
    }

    private final String b(String str) {
        if (d(str)) {
            Locale US = Locale.US;
            m.e(US, "US");
            String lowerCase = str.toLowerCase(US);
            m.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            return lowerCase;
        }
        return str;
    }

    private final List<String> c(X509Certificate certificate, int type) {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return r.l();
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && m.a(list.get(0), Integer.valueOf(type)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return r.l();
        }
    }

    private final boolean d(String str) {
        if (str.length() != ((int) b0.b(str, 0, 0, 3, null))) {
            return false;
        }
        return true;
    }

    private final boolean g(String hostname, X509Certificate certificate) {
        String strB = b(hostname);
        List<String> listC = c(certificate, 2);
        if ((listC instanceof Collection) && listC.isEmpty()) {
            return false;
        }
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            if (f17904a.f(strB, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private final boolean h(String ipAddress, X509Certificate certificate) {
        String strE = hb.a.e(ipAddress);
        List<String> listC = c(certificate, 7);
        if ((listC instanceof Collection) && listC.isEmpty()) {
            return false;
        }
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            if (m.a(strE, hb.a.e((String) it.next()))) {
                return true;
            }
        }
        return false;
    }
}
