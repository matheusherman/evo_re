package okhttp3;

import com.pengrad.telegrambot.model.chatbackground.BackgroundTypePattern;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.jvm.internal.h0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0003\u000f\u0014\u0016B#\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000b0\u0011H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lokhttp3/g;", "", "", "Lokhttp3/g$c;", "pins", "Lrb/c;", "certificateChainCleaner", "<init>", "(Ljava/util/Set;Lrb/c;)V", "", "hostname", "", "Ljava/security/cert/Certificate;", "peerCertificates", "Lr8/z;", "a", "(Ljava/lang/String;Ljava/util/List;)V", "Lkotlin/Function0;", "Ljava/security/cert/X509Certificate;", "cleanedPeerCertificatesFn", "b", "(Ljava/lang/String;Lc9/a;)V", "c", "(Ljava/lang/String;)Ljava/util/List;", "e", "(Lrb/c;)Lokhttp3/g;", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/util/Set;", "getPins", "()Ljava/util/Set;", "Lrb/c;", "d", "()Lrb/c;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f16703d = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Set<c> pins;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final rb.c certificateChainCleaner;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lokhttp3/g$a;", "", "<init>", "()V", "Lokhttp3/g;", "a", "()Lokhttp3/g;", "", "Lokhttp3/g$c;", "Ljava/util/List;", "getPins", "()Ljava/util/List;", "pins", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final List<c> pins = new ArrayList();

        /* JADX WARN: Multi-variable type inference failed */
        public final g a() {
            return new g(kotlin.collections.r.S0(this.pins), null, 2, 0 == true ? 1 : 0);
        }
    }

    /* JADX INFO: renamed from: okhttp3.g$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\b\u001a\u00020\u0005*\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lokhttp3/g$b;", "", "<init>", "()V", "Ljava/security/cert/X509Certificate;", "Ltb/g;", "b", "(Ljava/security/cert/X509Certificate;)Ltb/g;", "c", "Ljava/security/cert/Certificate;", "certificate", "", "a", "(Ljava/security/cert/Certificate;)Ljava/lang/String;", "Lokhttp3/g;", "DEFAULT", "Lokhttp3/g;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final String a(Certificate certificate) {
            kotlin.jvm.internal.m.f(certificate, "certificate");
            if (!(certificate instanceof X509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
            }
            return "sha256/" + c((X509Certificate) certificate).a();
        }

        public final tb.g b(X509Certificate x509Certificate) {
            kotlin.jvm.internal.m.f(x509Certificate, "<this>");
            tb.g.Companion companion = tb.g.INSTANCE;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            kotlin.jvm.internal.m.e(encoded, "publicKey.encoded");
            return tb.g.Companion.e(companion, encoded, 0, 0, 3, null).v();
        }

        public final tb.g c(X509Certificate x509Certificate) {
            kotlin.jvm.internal.m.f(x509Certificate, "<this>");
            tb.g.Companion companion = tb.g.INSTANCE;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            kotlin.jvm.internal.m.e(encoded, "publicKey.encoded");
            return tb.g.Companion.e(companion, encoded, 0, 0, 3, null).w();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0014\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0013\u0010\bR\u0017\u0010\u0018\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u000f\u0010\u0017¨\u0006\u0019"}, d2 = {"Lokhttp3/g$c;", "", "", "hostname", "", "c", "(Ljava/lang/String;)Z", "toString", "()Ljava/lang/String;", TransactionPartnerType.OTHER, "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "a", "Ljava/lang/String;", "getPattern", BackgroundTypePattern.TYPE, "b", "hashAlgorithm", "Ltb/g;", "Ltb/g;", "()Ltb/g;", "hash", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final String pattern;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final String hashAlgorithm;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final tb.g hash;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            return kotlin.jvm.internal.m.a(this.pattern, cVar.pattern) && kotlin.jvm.internal.m.a(this.hashAlgorithm, cVar.hashAlgorithm) && kotlin.jvm.internal.m.a(this.hash, cVar.hash);
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final tb.g getHash() {
            return this.hash;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        public final boolean c(String hostname) {
            kotlin.jvm.internal.m.f(hostname, "hostname");
            if (ua.n.I(this.pattern, "**.", false, 2, null)) {
                int length = this.pattern.length() - 3;
                int length2 = hostname.length() - length;
                return ua.y.y(hostname, hostname.length() - length, this.pattern, 3, length, (16 & 16) != 0 ? false : false) && (length2 == 0 || hostname.charAt(length2 - 1) == '.');
            }
            if (!ua.n.I(this.pattern, "*.", false, 2, null)) {
                return kotlin.jvm.internal.m.a(hostname, this.pattern);
            }
            int length3 = this.pattern.length() - 1;
            return ua.y.y(hostname, hostname.length() - length3, this.pattern, 1, length3, (16 & 16) != 0 ? false : false) && ua.n.g0(hostname, '.', (hostname.length() - length3) + (-1), false, 4, null) == -1;
        }

        public int hashCode() {
            return (((this.pattern.hashCode() * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }

        public String toString() {
            return this.hashAlgorithm + '/' + this.hash.a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Ljava/security/cert/X509Certificate;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class d extends kotlin.jvm.internal.o implements c9.a<List<? extends X509Certificate>> {
        final /* synthetic */ String $hostname;
        final /* synthetic */ List<Certificate> $peerCertificates;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(List<? extends Certificate> list, String str) {
            super(0);
            this.$peerCertificates = list;
            this.$hostname = str;
        }

        @Override // c9.a
        public final List<? extends X509Certificate> invoke() {
            List<Certificate> listA;
            rb.c certificateChainCleaner = g.this.getCertificateChainCleaner();
            if (certificateChainCleaner == null || (listA = certificateChainCleaner.a(this.$peerCertificates, this.$hostname)) == null) {
                listA = this.$peerCertificates;
            }
            List<Certificate> list = listA;
            ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
            for (Certificate certificate : list) {
                kotlin.jvm.internal.m.d(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                arrayList.add((X509Certificate) certificate);
            }
            return arrayList;
        }
    }

    public g(Set<c> pins, rb.c cVar) {
        kotlin.jvm.internal.m.f(pins, "pins");
        this.pins = pins;
        this.certificateChainCleaner = cVar;
    }

    public final void a(String hostname, List<? extends Certificate> peerCertificates) {
        kotlin.jvm.internal.m.f(hostname, "hostname");
        kotlin.jvm.internal.m.f(peerCertificates, "peerCertificates");
        b(hostname, new d(peerCertificates, hostname));
    }

    public final void b(String hostname, c9.a<? extends List<? extends X509Certificate>> cleanedPeerCertificatesFn) throws SSLPeerUnverifiedException {
        kotlin.jvm.internal.m.f(hostname, "hostname");
        kotlin.jvm.internal.m.f(cleanedPeerCertificatesFn, "cleanedPeerCertificatesFn");
        List<c> listC = c(hostname);
        if (listC.isEmpty()) {
            return;
        }
        List<? extends X509Certificate> listInvoke = cleanedPeerCertificatesFn.invoke();
        for (X509Certificate x509Certificate : listInvoke) {
            tb.g gVarC = null;
            tb.g gVarB = null;
            for (c cVar : listC) {
                String hashAlgorithm = cVar.getHashAlgorithm();
                if (kotlin.jvm.internal.m.a(hashAlgorithm, "sha256")) {
                    if (gVarC == null) {
                        gVarC = INSTANCE.c(x509Certificate);
                    }
                    if (kotlin.jvm.internal.m.a(cVar.getHash(), gVarC)) {
                        return;
                    }
                } else {
                    if (!kotlin.jvm.internal.m.a(hashAlgorithm, "sha1")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + cVar.getHashAlgorithm());
                    }
                    if (gVarB == null) {
                        gVarB = INSTANCE.b(x509Certificate);
                    }
                    if (kotlin.jvm.internal.m.a(cVar.getHash(), gVarB)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Certificate pinning failure!");
        sb2.append("\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : listInvoke) {
            sb2.append("\n    ");
            sb2.append(INSTANCE.a(x509Certificate2));
            sb2.append(": ");
            sb2.append(x509Certificate2.getSubjectDN().getName());
        }
        sb2.append("\n  Pinned certificates for ");
        sb2.append(hostname);
        sb2.append(":");
        for (c cVar2 : listC) {
            sb2.append("\n    ");
            sb2.append(cVar2);
        }
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(string);
    }

    public final List<c> c(String hostname) {
        kotlin.jvm.internal.m.f(hostname, "hostname");
        Set<c> set = this.pins;
        List<c> listL = kotlin.collections.r.l();
        for (Object obj : set) {
            if (((c) obj).c(hostname)) {
                if (listL.isEmpty()) {
                    listL = new ArrayList<>();
                }
                kotlin.jvm.internal.m.d(listL, "null cannot be cast to non-null type kotlin.collections.MutableList<T of okhttp3.internal.Util.filterList>");
                h0.c(listL).add(obj);
            }
        }
        return listL;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final rb.c getCertificateChainCleaner() {
        return this.certificateChainCleaner;
    }

    public final g e(rb.c certificateChainCleaner) {
        kotlin.jvm.internal.m.f(certificateChainCleaner, "certificateChainCleaner");
        return kotlin.jvm.internal.m.a(this.certificateChainCleaner, certificateChainCleaner) ? this : new g(this.pins, certificateChainCleaner);
    }

    public boolean equals(Object other) {
        if (!(other instanceof g)) {
            return false;
        }
        g gVar = (g) other;
        return kotlin.jvm.internal.m.a(gVar.pins, this.pins) && kotlin.jvm.internal.m.a(gVar.certificateChainCleaner, this.certificateChainCleaner);
    }

    public int hashCode() {
        int iHashCode = (1517 + this.pins.hashCode()) * 41;
        rb.c cVar = this.certificateChainCleaner;
        return iHashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    public /* synthetic */ g(Set set, rb.c cVar, int i10, kotlin.jvm.internal.g gVar) {
        this(set, (i10 & 2) != 0 ? null : cVar);
    }
}
