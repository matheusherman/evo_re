package pb;

import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import okhttp3.a0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u001a¨\u0006\u001c"}, d2 = {"Lpb/l;", "Lpb/m;", "Lpb/l$a;", "socketAdapterFactory", "<init>", "(Lpb/l$a;)V", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "d", "(Ljavax/net/ssl/SSLSocket;)Lpb/m;", "", "isSupported", "()Z", "a", "(Ljavax/net/ssl/SSLSocket;)Z", "", "hostname", "", "Lokhttp3/a0;", "protocols", "Lr8/z;", "c", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "b", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "Lpb/l$a;", "Lpb/m;", "delegate", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class l implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final a socketAdapterFactory;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private m delegate;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lpb/l$a;", "", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "a", "(Ljavax/net/ssl/SSLSocket;)Z", "Lpb/m;", "b", "(Ljavax/net/ssl/SSLSocket;)Lpb/m;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface a {
        boolean a(SSLSocket sslSocket);

        m b(SSLSocket sslSocket);
    }

    private final synchronized m d(SSLSocket sslSocket) {
        try {
            if (this.delegate == null && this.socketAdapterFactory.a(sslSocket)) {
                this.delegate = this.socketAdapterFactory.b(sslSocket);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.delegate;
    }

    @Override // pb.m
    public boolean isSupported() {
        return true;
    }

    public l(a socketAdapterFactory) {
        kotlin.jvm.internal.m.f(socketAdapterFactory, "socketAdapterFactory");
        this.socketAdapterFactory = socketAdapterFactory;
    }

    @Override // pb.m
    public boolean a(SSLSocket sslSocket) {
        kotlin.jvm.internal.m.f(sslSocket, "sslSocket");
        return this.socketAdapterFactory.a(sslSocket);
    }

    @Override // pb.m
    public String b(SSLSocket sslSocket) {
        kotlin.jvm.internal.m.f(sslSocket, "sslSocket");
        m mVarD = d(sslSocket);
        if (mVarD != null) {
            return mVarD.b(sslSocket);
        }
        return null;
    }

    @Override // pb.m
    public void c(SSLSocket sslSocket, String hostname, List<? extends a0> protocols) {
        kotlin.jvm.internal.m.f(sslSocket, "sslSocket");
        kotlin.jvm.internal.m.f(protocols, "protocols");
        m mVarD = d(sslSocket);
        if (mVarD != null) {
            mVarD.c(sslSocket, hostname, protocols);
        }
    }
}
