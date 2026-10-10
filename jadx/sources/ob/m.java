package ob;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.r;
import okhttp3.a0;
import okhttp3.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ/\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ-\u0010$\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\u001c2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020&2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b'\u0010(J\u0019\u0010*\u001a\u0004\u0018\u00010\u00012\u0006\u0010)\u001a\u00020\fH\u0016¢\u0006\u0004\b*\u0010+J!\u0010-\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\f2\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u0002002\u0006\u0010/\u001a\u00020\u0007H\u0016¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u0002032\u0006\u0010/\u001a\u00020\u0007H\u0016¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u0002062\u0006\u0010/\u001a\u00020\u0007H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\fH\u0016¢\u0006\u0004\b9\u0010:¨\u0006<"}, d2 = {"Lob/m;", "", "<init>", "()V", "Ljavax/net/ssl/SSLContext;", "m", "()Ljavax/net/ssl/SSLContext;", "Ljavax/net/ssl/X509TrustManager;", "o", "()Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/a0;", "protocols", "Lr8/z;", "e", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "b", "(Ljavax/net/ssl/SSLSocket;)V", "g", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "Ljava/net/Socket;", "socket", "Ljava/net/InetSocketAddress;", "address", "", "connectTimeout", "f", "(Ljava/net/Socket;Ljava/net/InetSocketAddress;I)V", "message", "level", "", "t", "j", "(Ljava/lang/String;ILjava/lang/Throwable;)V", "", "i", "(Ljava/lang/String;)Z", "closer", "h", "(Ljava/lang/String;)Ljava/lang/Object;", "stackTrace", "l", "(Ljava/lang/String;Ljava/lang/Object;)V", "trustManager", "Lrb/c;", "c", "(Ljavax/net/ssl/X509TrustManager;)Lrb/c;", "Lrb/e;", "d", "(Ljavax/net/ssl/X509TrustManager;)Lrb/e;", "Ljavax/net/ssl/SSLSocketFactory;", "n", "(Ljavax/net/ssl/X509TrustManager;)Ljavax/net/ssl/SSLSocketFactory;", "toString", "()Ljava/lang/String;", "a", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile m f16548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Logger f16549c;

    /* JADX INFO: renamed from: ob.m$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\u0006J!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u00020\u00102\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\u001c\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\u001d8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u001d8\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u001fR\u001c\u0010#\u001a\n \"*\u0004\u0018\u00010!0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lob/m$a;", "", "<init>", "()V", "Lob/m;", "f", "()Lob/m;", "d", "e", "g", "", "Lokhttp3/a0;", "protocols", "", "b", "(Ljava/util/List;)Ljava/util/List;", "", "c", "(Ljava/util/List;)[B", "", "j", "()Z", "isConscryptPreferred", "k", "isOpenJSSEPreferred", "i", "isBouncyCastlePreferred", "h", "isAndroid", "", "INFO", "I", "WARN", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "logger", "Ljava/util/logging/Logger;", "platform", "Lob/m;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        private final m d() {
            pb.e.f17464a.b();
            m mVarA = c.INSTANCE.a();
            if (mVarA != null) {
                return mVarA;
            }
            m mVarA2 = e.f16520f.a();
            kotlin.jvm.internal.m.c(mVarA2);
            return mVarA2;
        }

        public final List<String> b(List<? extends a0> protocols) {
            kotlin.jvm.internal.m.f(protocols, "protocols");
            ArrayList arrayList = new ArrayList();
            for (Object obj : protocols) {
                if (((a0) obj) != a0.HTTP_1_0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(r.w(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((a0) it.next()).getProtocol());
            }
            return arrayList2;
        }

        public final byte[] c(List<? extends a0> protocols) {
            kotlin.jvm.internal.m.f(protocols, "protocols");
            tb.d dVar = new tb.d();
            for (String str : b(protocols)) {
                dVar.writeByte(str.length());
                dVar.T(str);
            }
            return dVar.K();
        }

        public final boolean h() {
            return kotlin.jvm.internal.m.a("Dalvik", System.getProperty("java.vm.name"));
        }

        private final m e() {
            l lVarA;
            f fVarA;
            g gVarB;
            if (j() && (gVarB = g.INSTANCE.b()) != null) {
                return gVarB;
            }
            if (i() && (fVarA = f.INSTANCE.a()) != null) {
                return fVarA;
            }
            if (k() && (lVarA = l.INSTANCE.a()) != null) {
                return lVarA;
            }
            k kVarA = k.INSTANCE.a();
            if (kVarA != null) {
                return kVarA;
            }
            m mVarA = h.INSTANCE.a();
            if (mVarA != null) {
                return mVarA;
            }
            return new m();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final m f() {
            if (h()) {
                return d();
            }
            return e();
        }

        private final boolean i() {
            return kotlin.jvm.internal.m.a("BC", Security.getProviders()[0].getName());
        }

        private final boolean j() {
            return kotlin.jvm.internal.m.a("Conscrypt", Security.getProviders()[0].getName());
        }

        private final boolean k() {
            return kotlin.jvm.internal.m.a("OpenJSSE", Security.getProviders()[0].getName());
        }

        public final m g() {
            return m.f16548b;
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        f16548b = companion.f();
        f16549c = Logger.getLogger(z.class.getName());
    }

    public static /* synthetic */ void k(m mVar, String str, int i10, Throwable th, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
        if ((i11 & 2) != 0) {
            i10 = 4;
        }
        if ((i11 & 4) != 0) {
            th = null;
        }
        mVar.j(str, i10, th);
    }

    public void b(SSLSocket sslSocket) {
        kotlin.jvm.internal.m.f(sslSocket, "sslSocket");
    }

    public rb.c c(X509TrustManager trustManager) {
        kotlin.jvm.internal.m.f(trustManager, "trustManager");
        return new rb.a(d(trustManager));
    }

    public rb.e d(X509TrustManager trustManager) {
        kotlin.jvm.internal.m.f(trustManager, "trustManager");
        X509Certificate[] acceptedIssuers = trustManager.getAcceptedIssuers();
        kotlin.jvm.internal.m.e(acceptedIssuers, "trustManager.acceptedIssuers");
        return new rb.b((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void e(SSLSocket sslSocket, String hostname, List<a0> protocols) {
        kotlin.jvm.internal.m.f(sslSocket, "sslSocket");
        kotlin.jvm.internal.m.f(protocols, "protocols");
    }

    public void f(Socket socket, InetSocketAddress address, int connectTimeout) throws IOException {
        kotlin.jvm.internal.m.f(socket, "socket");
        kotlin.jvm.internal.m.f(address, "address");
        socket.connect(address, connectTimeout);
    }

    public String g(SSLSocket sslSocket) {
        kotlin.jvm.internal.m.f(sslSocket, "sslSocket");
        return null;
    }

    public Object h(String closer) {
        kotlin.jvm.internal.m.f(closer, "closer");
        if (f16549c.isLoggable(Level.FINE)) {
            return new Throwable(closer);
        }
        return null;
    }

    public boolean i(String hostname) {
        kotlin.jvm.internal.m.f(hostname, "hostname");
        return true;
    }

    public void j(String message, int level, Throwable t10) {
        kotlin.jvm.internal.m.f(message, "message");
        f16549c.log(level == 5 ? Level.WARNING : Level.INFO, message, t10);
    }

    public void l(String message, Object stackTrace) {
        kotlin.jvm.internal.m.f(message, "message");
        if (stackTrace == null) {
            message = message + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        j(message, 5, (Throwable) stackTrace);
    }

    public SSLContext m() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        kotlin.jvm.internal.m.e(sSLContext, "getInstance(\"TLS\")");
        return sSLContext;
    }

    public SSLSocketFactory n(X509TrustManager trustManager) {
        kotlin.jvm.internal.m.f(trustManager, "trustManager");
        try {
            SSLContext sSLContextM = m();
            sSLContextM.init(null, new TrustManager[]{trustManager}, null);
            SSLSocketFactory socketFactory = sSLContextM.getSocketFactory();
            kotlin.jvm.internal.m.e(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e10) {
            throw new AssertionError("No System TLS: " + e10, e10);
        }
    }

    public X509TrustManager o() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        kotlin.jvm.internal.m.c(trustManagers);
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                kotlin.jvm.internal.m.d(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
                return (X509TrustManager) trustManager;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unexpected default trust managers: ");
        String string = Arrays.toString(trustManagers);
        kotlin.jvm.internal.m.e(string, "toString(this)");
        sb2.append(string);
        throw new IllegalStateException(sb2.toString().toString());
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        kotlin.jvm.internal.m.e(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
