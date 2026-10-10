package of;

import android.util.Log;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.k;
import okhttp3.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0019¨\u0006\u001b"}, d2 = {"Lof/e;", "", "<init>", "()V", "Ljavax/net/ssl/SSLContext;", "g", "()Ljavax/net/ssl/SSLContext;", "Ljavax/net/ssl/X509TrustManager;", "h", "()Ljavax/net/ssl/X509TrustManager;", "Lokhttp3/z$a;", "c", "()Lokhttp3/z$a;", "Lokhttp3/z;", "f", "()Lokhttp3/z;", "e", "b", "Lokhttp3/z;", "cryptoClient", "plainClient", "d", "Ljavax/net/ssl/X509TrustManager;", "xtm", "Lsb/a;", "Lsb/a;", "logInterceptor", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static z cryptoClient;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static z plainClient;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static sb.a logInterceptor;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f16588a = new e();

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final X509TrustManager xtm = new a();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J%\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ%\u0010\n\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"of/e$a", "Ljavax/net/ssl/X509TrustManager;", "", "Ljava/security/cert/X509Certificate;", "chain", "", "authType", "Lr8/z;", "checkClientTrusted", "([Ljava/security/cert/X509Certificate;Ljava/lang/String;)V", "checkServerTrusted", "getAcceptedIssuers", "()[Ljava/security/cert/X509Certificate;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] chain, String authType) {
            m.f(chain, "chain");
            m.f(authType, "authType");
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] chain, String authType) {
            m.f(chain, "chain");
            m.f(authType, "authType");
        }

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(String str, SSLSession sSLSession) {
        return true;
    }

    private final SSLContext g() {
        SSLContext sSLContext;
        NoSuchAlgorithmException e10;
        KeyManagementException e11;
        try {
            sSLContext = SSLContext.getInstance("SSL");
            try {
                sSLContext.init(null, new TrustManager[]{xtm}, new SecureRandom());
                return sSLContext;
            } catch (KeyManagementException e12) {
                e11 = e12;
                e11.printStackTrace();
                return sSLContext;
            } catch (NoSuchAlgorithmException e13) {
                e10 = e13;
                e10.printStackTrace();
                return sSLContext;
            }
        } catch (KeyManagementException e14) {
            sSLContext = null;
            e11 = e14;
        } catch (NoSuchAlgorithmException e15) {
            sSLContext = null;
            e10 = e15;
        }
    }

    static {
        sb.a aVar = new sb.a(new sb.a.b() { // from class: of.c
            @Override // sb.a.b
            public final void a(String str) {
                e.i(str);
            }
        });
        aVar.c(sb.a.EnumC0360a.BODY);
        logInterceptor = aVar;
    }

    private final z.a c() {
        z.a aVar = new z.a();
        e eVar = f16588a;
        SSLContext sSLContextG = eVar.g();
        if (sSLContextG != null) {
            SSLSocketFactory socketFactory = sSLContextG.getSocketFactory();
            m.e(socketFactory, "getSocketFactory(...)");
            aVar.R(socketFactory, eVar.h());
            System.setProperty("https.protocols", "TLSv1.2,TLSv1.1,SSLv3");
            aVar.N(new HostnameVerifier() { // from class: of.d
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str, SSLSession sSLSession) {
                    return e.d(str, sSLSession);
                }
            });
        }
        return aVar;
    }

    private final X509TrustManager h() {
        return xtm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(String it) {
        m.f(it, "it");
        q6.b bVarD = q6.c.d(sb.a.class);
        if (x1.f1.lb.config.b.f20643a.t()) {
            try {
                if (it.length() > 1000) {
                    bVarD.debug("http[{}]", it.subSequence(0, 1000));
                } else {
                    bVarD.debug("http[{}]", it);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                try {
                    Log.i("OkHttpUtils", "http[{" + it + "}]");
                } catch (Exception e11) {
                    e11.printStackTrace();
                    r8.z zVar = r8.z.f17874a;
                }
            }
        }
    }

    public final z e() {
        z zVarC;
        z zVar = plainClient;
        if (zVar != null) {
            return zVar;
        }
        synchronized (this) {
            try {
                z.a aVarE = f16588a.c().e(new k(10, 2L, TimeUnit.MINUTES));
                TimeUnit timeUnit = TimeUnit.SECONDS;
                z.a aVarI = aVarE.d(15L, timeUnit).P(15L, timeUnit).O(30L, timeUnit).Q(true).g(new mf.b()).i(false);
                if (x1.f1.lb.config.b.f20643a.t()) {
                    aVarI.a(logInterceptor);
                }
                zVarC = aVarI.c();
                plainClient = zVarC;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zVarC;
    }

    public final z f() {
        z zVarC;
        z zVar = cryptoClient;
        if (zVar != null) {
            return zVar;
        }
        synchronized (this) {
            try {
                z.a aVarE = f16588a.c().e(new k(10, 2L, TimeUnit.MINUTES));
                TimeUnit timeUnit = TimeUnit.SECONDS;
                z.a aVarA = aVarE.d(15L, timeUnit).P(15L, timeUnit).O(30L, timeUnit).Q(true).g(new mf.b()).i(false).a(new pf.a());
                if (x1.f1.lb.config.b.f20643a.t()) {
                    aVarA.a(logInterceptor);
                }
                aVarA.a(new pf.b());
                zVarC = aVarA.c();
                cryptoClient = zVarC;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zVarC;
    }

    private e() {
    }
}
