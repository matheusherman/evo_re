package okhttp3;

import java.io.IOException;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lokhttp3/a0;", "", "", "protocol", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "a", "b", "c", "d", "e", "f", "g", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum a0 {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");


    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String protocol;

    /* JADX INFO: renamed from: okhttp3.a0$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lokhttp3/a0$a;", "", "<init>", "()V", "", "protocol", "Lokhttp3/a0;", "a", "(Ljava/lang/String;)Lokhttp3/a0;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final a0 a(String protocol) throws IOException {
            kotlin.jvm.internal.m.f(protocol, "protocol");
            a0 a0Var = a0.HTTP_1_0;
            if (kotlin.jvm.internal.m.a(protocol, a0Var.protocol)) {
                return a0Var;
            }
            a0 a0Var2 = a0.HTTP_1_1;
            if (kotlin.jvm.internal.m.a(protocol, a0Var2.protocol)) {
                return a0Var2;
            }
            a0 a0Var3 = a0.H2_PRIOR_KNOWLEDGE;
            if (kotlin.jvm.internal.m.a(protocol, a0Var3.protocol)) {
                return a0Var3;
            }
            a0 a0Var4 = a0.HTTP_2;
            if (kotlin.jvm.internal.m.a(protocol, a0Var4.protocol)) {
                return a0Var4;
            }
            a0 a0Var5 = a0.SPDY_3;
            if (kotlin.jvm.internal.m.a(protocol, a0Var5.protocol)) {
                return a0Var5;
            }
            a0 a0Var6 = a0.QUIC;
            if (kotlin.jvm.internal.m.a(protocol, a0Var6.protocol)) {
                return a0Var6;
            }
            throw new IOException("Unexpected protocol: " + protocol);
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }

    a0(String str) {
        this.protocol = str;
    }
}
