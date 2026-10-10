package ob;

import android.annotation.SuppressLint;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.r;
import okhttp3.a0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lob/c;", "Lob/m;", "<init>", "()V", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/a0;", "protocols", "Lr8/z;", "e", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "g", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "", "i", "(Ljava/lang/String;)Z", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Lrb/c;", "c", "(Ljavax/net/ssl/X509TrustManager;)Lrb/c;", "Lpb/m;", "d", "Ljava/util/List;", "socketAdapters", "a", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class c extends m {

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final boolean f16518f;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<pb.m> socketAdapters;

    /* JADX INFO: renamed from: ob.c$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lob/c$a;", "", "<init>", "()V", "Lob/m;", "a", "()Lob/m;", "", "isSupported", "Z", "b", "()Z", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final m a() {
            if (b()) {
                return new c();
            }
            return null;
        }

        public final boolean b() {
            return c.f16518f;
        }
    }

    static {
        f16518f = m.INSTANCE.h() && Build.VERSION.SDK_INT >= 29;
    }

    @Override // ob.m
    public rb.c c(X509TrustManager trustManager) {
        kotlin.jvm.internal.m.f(trustManager, "trustManager");
        pb.d dVarA = pb.d.INSTANCE.a(trustManager);
        return dVarA != null ? dVarA : super.c(trustManager);
    }

    @Override // ob.m
    public void e(SSLSocket sslSocket, String hostname, List<? extends a0> protocols) {
        Object next;
        kotlin.jvm.internal.m.f(sslSocket, "sslSocket");
        kotlin.jvm.internal.m.f(protocols, "protocols");
        Iterator<T> it = this.socketAdapters.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((pb.m) next).a(sslSocket));
        pb.m mVar = (pb.m) next;
        if (mVar != null) {
            mVar.c(sslSocket, hostname, protocols);
        }
    }

    @Override // ob.m
    public String g(SSLSocket sslSocket) {
        Object next;
        kotlin.jvm.internal.m.f(sslSocket, "sslSocket");
        Iterator<T> it = this.socketAdapters.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((pb.m) next).a(sslSocket));
        pb.m mVar = (pb.m) next;
        if (mVar != null) {
            return mVar.b(sslSocket);
        }
        return null;
    }

    @Override // ob.m
    @SuppressLint({"NewApi"})
    public boolean i(String hostname) {
        kotlin.jvm.internal.m.f(hostname, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
    }

    public c() {
        List listQ = r.q(pb.c.INSTANCE.a(), new pb.l(pb.h.INSTANCE.d()), new pb.l(pb.k.INSTANCE.a()), new pb.l(pb.i.INSTANCE.a()));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listQ) {
            if (((pb.m) obj).isSupported()) {
                arrayList.add(obj);
            }
        }
        this.socketAdapters = arrayList;
    }
}
