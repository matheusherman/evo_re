package l7;

import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import android.text.TextUtils;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class f extends SSLSocketFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15228b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Method f15227a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HostnameVerifier f15229c = HttpsURLConnection.getDefaultHostnameVerifier();

    @Override // javax.net.SocketFactory
    public Socket createSocket() {
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10) {
        return null;
    }

    public boolean equals(Object obj) {
        if (TextUtils.isEmpty(this.f15228b) || !(obj instanceof f)) {
            return false;
        }
        String str = ((f) obj).f15228b;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f15228b.equals(str);
    }

    public f(String str) {
        this.f15228b = str;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10, InetAddress inetAddress, int i11) {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i10) {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i10, InetAddress inetAddress2, int i11) {
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i10, boolean z10) throws IOException {
        SSLSocket sSLSocket;
        m7.f.h("", "peerHost", this.f15228b, "host", str, IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT, Integer.valueOf(i10), "autoClose", Boolean.valueOf(z10));
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 24) {
            sSLCertificateSocketFactory.setTrustManagers(g.a());
        } else {
            sSLCertificateSocketFactory.setTrustManagers(c.a());
        }
        m7.f.e("", "createSocket");
        if (i11 < 23) {
            InetAddress inetAddress = socket.getInetAddress();
            if (z10) {
                socket.close();
            }
            sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i10);
        } else {
            sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(socket, this.f15228b, i10, true);
        }
        m7.f.e("", "createSocket end");
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        sSLCertificateSocketFactory.setHostname(sSLSocket, this.f15228b);
        SSLSession session = sSLSocket.getSession();
        if (this.f15229c.verify(this.f15228b, session)) {
            m7.f.h("", "SSLSession PeerHost", session.getPeerHost());
            return sSLSocket;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + this.f15228b);
    }
}
