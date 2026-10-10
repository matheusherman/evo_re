package l7;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class d implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f15226a;

    public boolean equals(Object obj) {
        if (TextUtils.isEmpty(this.f15226a) || !(obj instanceof d)) {
            return false;
        }
        String str = ((d) obj).f15226a;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f15226a.equals(str);
    }

    public d(String str) {
        this.f15226a = str;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.f15226a, sSLSession);
    }
}
