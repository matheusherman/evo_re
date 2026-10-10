package x1.f1.lb.streaming.client;

import android.content.Context;
import android.content.res.Resources;
import c9.p;
import java.io.InputStream;
import java.security.KeyStore;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManagerFactory;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.r;
import r8.z;
import x.l1.b2.R$raw;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lx1/f1/lb/streaming/client/d;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lr8/z;", "d", "(Landroid/content/Context;)V", "Lq6/b;", "b", "Lq6/b;", "logger", "Lcom/koushikdutta/async/http/a;", "c", "Lcom/koushikdutta/async/http/a;", "asyncHttpClient", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f21015a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static com.koushikdutta.async.http.a asyncHttpClient;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "x1.f1.lb.streaming.client.SSLHttpClient$init$1", f = "SSLHttpClient.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class a extends l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, v8.f<? super a> fVar) {
            super(2, fVar);
            this.$context = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean c(String str, SSLSession sSLSession) {
            if (!x1.f1.lb.config.b.f20643a.t()) {
                return true;
            }
            d.logger.debug("verify: " + str, new Object[0]);
            return true;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new a(this.$context, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r.b(obj);
            try {
                KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("X509");
                KeyStore keyStore = KeyStore.getInstance("BKS");
                Resources resources = this.$context.getResources();
                int i10 = R$raw.server;
                InputStream inputStreamOpenRawResource = resources.openRawResource(i10);
                char[] charArray = "123456".toCharArray();
                m.e(charArray, "toCharArray(...)");
                keyStore.load(inputStreamOpenRawResource, charArray);
                char[] charArray2 = "123456".toCharArray();
                m.e(charArray2, "toCharArray(...)");
                keyManagerFactory.init(keyStore, charArray2);
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                KeyStore keyStore2 = KeyStore.getInstance(KeyStore.getDefaultType());
                InputStream inputStreamOpenRawResource2 = this.$context.getResources().openRawResource(i10);
                char[] charArray3 = "123456".toCharArray();
                m.e(charArray3, "toCharArray(...)");
                keyStore2.load(inputStreamOpenRawResource2, charArray3);
                trustManagerFactory.init(keyStore2);
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
                if (d.asyncHttpClient == null) {
                    d.asyncHttpClient = com.koushikdutta.async.http.a.a();
                }
                com.koushikdutta.async.http.a.a().b().c(sSLContext);
                com.koushikdutta.async.http.a.a().b().d(trustManagerFactory.getTrustManagers());
                com.koushikdutta.async.http.a.a().b().b(new HostnameVerifier() { // from class: x1.f1.lb.streaming.client.c
                    @Override // javax.net.ssl.HostnameVerifier
                    public final boolean verify(String str, SSLSession sSLSession) {
                        return d.a.c(str, sSLSession);
                    }
                });
            } catch (Exception e10) {
                d.logger.error("init ssl http client failure", e10);
            }
            return z.f17874a;
        }
    }

    static {
        q6.b bVarD = q6.c.d(d.class);
        m.e(bVarD, "getLogger(...)");
        logger = bVarD;
    }

    public final void d(Context context) {
        m.f(context, "context");
        j.d(m0.a(a1.b()), null, null, new a(context, null), 3, null);
    }

    private d() {
    }
}
