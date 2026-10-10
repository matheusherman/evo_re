package xc;

import java.math.BigInteger;
import re.g;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BigInteger f22049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BigInteger f22050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BigInteger f22051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BigInteger f22052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f22053e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f22054f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private c f22055g;

    public BigInteger a() {
        return this.f22049a;
    }

    public BigInteger b() {
        return this.f22050b;
    }

    public BigInteger c() {
        return this.f22051c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (c() != null) {
            if (!c().equals(bVar.c())) {
                return false;
            }
        } else if (bVar.c() != null) {
            return false;
        }
        return bVar.b().equals(this.f22050b) && bVar.a().equals(this.f22049a);
    }

    public b(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i10, int i11, BigInteger bigInteger4, c cVar) {
        if (i11 != 0) {
            if (i11 <= bigInteger.bitLength()) {
                if (i11 < i10) {
                    throw new IllegalArgumentException("when l value specified, it may not be less than m value");
                }
            } else {
                throw new IllegalArgumentException("when l value specified, it must satisfy 2^(l-1) <= p");
            }
        }
        if (i10 > bigInteger.bitLength() && !g.b("org.bouncycastle.dh.allow_unsafe_p_value")) {
            throw new IllegalArgumentException("unsafe p value so small specific l required");
        }
        this.f22049a = bigInteger2;
        this.f22050b = bigInteger;
        this.f22051c = bigInteger3;
        this.f22053e = i10;
        this.f22054f = i11;
        this.f22052d = bigInteger4;
        this.f22055g = cVar;
    }

    public int hashCode() {
        int iHashCode;
        int iHashCode2 = b().hashCode() ^ a().hashCode();
        if (c() != null) {
            iHashCode = c().hashCode();
        } else {
            iHashCode = 0;
        }
        return iHashCode2 ^ iHashCode;
    }
}
