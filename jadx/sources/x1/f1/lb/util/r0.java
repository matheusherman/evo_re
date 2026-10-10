package x1.f1.lb.util;

import android.annotation.SuppressLint;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@SuppressLint({"CustomX509TrustManager"})
class r0 implements X509TrustManager {
    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    r0() {
    }

    @Override // javax.net.ssl.X509TrustManager
    @SuppressLint({"TrustAllX509TrustManager"})
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    @Override // javax.net.ssl.X509TrustManager
    @SuppressLint({"TrustAllX509TrustManager"})
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
    }
}
