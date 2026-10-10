package nd;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class h extends g {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static a f16373l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static a[] f16374m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f16375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k f16376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e f16377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f16378e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f16379f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<a, byte[]> f16380g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f16381h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final tc.i f16382i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f16383j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private i f16384k;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f16385a;

        public boolean equals(Object obj) {
            return (obj instanceof a) && ((a) obj).f16385a == this.f16385a;
        }

        public int hashCode() {
            return this.f16385a;
        }

        a(int i10) {
            this.f16385a = i10;
        }
    }

    public h(k kVar, e eVar, int i10, byte[] bArr, int i11, byte[] bArr2) {
        super(true);
        this.f16376c = kVar;
        this.f16377d = eVar;
        this.f16383j = i10;
        this.f16375b = re.a.d(bArr);
        this.f16378e = i11;
        this.f16379f = re.a.d(bArr2);
        this.f16381h = 1 << (kVar.c() + 1);
        this.f16380g = new WeakHashMap();
        this.f16382i = b.a(kVar.b());
    }

    public boolean equals(Object obj) {
        i iVar;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f16383j != hVar.f16383j || this.f16378e != hVar.f16378e || !re.a.a(this.f16375b, hVar.f16375b)) {
            return false;
        }
        k kVar = this.f16376c;
        if (kVar == null ? hVar.f16376c != null : !kVar.equals(hVar.f16376c)) {
            return false;
        }
        e eVar = this.f16377d;
        if (eVar == null ? hVar.f16377d != null : !eVar.equals(hVar.f16377d)) {
            return false;
        }
        if (!re.a.a(this.f16379f, hVar.f16379f)) {
            return false;
        }
        i iVar2 = this.f16384k;
        if (iVar2 == null || (iVar = hVar.f16384k) == null) {
            return true;
        }
        return iVar2.equals(iVar);
    }

    public i i() {
        i iVar;
        synchronized (this) {
            try {
                if (this.f16384k == null) {
                    this.f16384k = new i(this.f16376c, this.f16377d, c(f16373l), this.f16375b);
                }
                iVar = this.f16384k;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVar;
    }

    static {
        a aVar = new a(1);
        f16373l = aVar;
        a[] aVarArr = new a[129];
        f16374m = aVarArr;
        aVarArr[1] = aVar;
        int i10 = 2;
        while (true) {
            a[] aVarArr2 = f16374m;
            if (i10 >= aVarArr2.length) {
                return;
            }
            aVarArr2[i10] = new a(i10);
            i10++;
        }
    }

    private byte[] c(a aVar) {
        byte[] bArrA;
        synchronized (this.f16380g) {
            try {
                bArrA = this.f16380g.get(aVar);
                if (bArrA == null) {
                    bArrA = a(aVar.f16385a);
                    this.f16380g.put(aVar, bArrA);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrA;
    }

    public static h e(Object obj) throws Throwable {
        Throwable th;
        if (obj instanceof h) {
            return (h) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) obj;
            if (dataInputStream.readInt() != 0) {
                throw new IllegalStateException("expected version 0 lms private key");
            }
            k kVarE = k.e(dataInputStream.readInt());
            e eVarE = e.e(dataInputStream.readInt());
            byte[] bArr = new byte[16];
            dataInputStream.readFully(bArr);
            int i10 = dataInputStream.readInt();
            int i11 = dataInputStream.readInt();
            int i12 = dataInputStream.readInt();
            if (i12 < 0) {
                throw new IllegalStateException("secret length less than zero");
            }
            if (i12 <= dataInputStream.available()) {
                byte[] bArr2 = new byte[i12];
                dataInputStream.readFully(bArr2);
                return new h(kVarE, eVarE, i10, bArr, i11, bArr2);
            }
            throw new IOException("secret length exceeded " + dataInputStream.available());
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return e(te.a.c((InputStream) obj));
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        DataInputStream dataInputStream2 = null;
        try {
            DataInputStream dataInputStream3 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                h hVarE = e(dataInputStream3);
                dataInputStream3.close();
                return hVarE;
            } catch (Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream3;
                if (dataInputStream2 == null) {
                    throw th;
                }
                dataInputStream2.close();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    byte[] b(int i10) {
        if (i10 >= this.f16381h) {
            return a(i10);
        }
        a[] aVarArr = f16374m;
        return c(i10 < aVarArr.length ? aVarArr[i10] : new a(i10));
    }

    public byte[] d() {
        return re.a.d(this.f16375b);
    }

    public byte[] g() {
        return re.a.d(this.f16379f);
    }

    public e h() {
        return this.f16377d;
    }

    public int hashCode() {
        int iL = ((this.f16383j * 31) + re.a.l(this.f16375b)) * 31;
        k kVar = this.f16376c;
        int iHashCode = (iL + (kVar != null ? kVar.hashCode() : 0)) * 31;
        e eVar = this.f16377d;
        int iHashCode2 = (((((iHashCode + (eVar != null ? eVar.hashCode() : 0)) * 31) + this.f16378e) * 31) + re.a.l(this.f16379f)) * 31;
        i iVar = this.f16384k;
        return iHashCode2 + (iVar != null ? iVar.hashCode() : 0);
    }

    public k j() {
        return this.f16376c;
    }

    private byte[] a(int i10) {
        int iC = 1 << j().c();
        if (i10 >= iC) {
            m.a(d(), this.f16382i);
            m.c(i10, this.f16382i);
            m.b((short) -32126, this.f16382i);
            m.a(l.a(h(), d(), i10 - iC, g()), this.f16382i);
            byte[] bArr = new byte[this.f16382i.e()];
            this.f16382i.b(bArr, 0);
            return bArr;
        }
        int i11 = i10 * 2;
        byte[] bArrB = b(i11);
        byte[] bArrB2 = b(i11 + 1);
        m.a(d(), this.f16382i);
        m.c(i10, this.f16382i);
        m.b((short) -31869, this.f16382i);
        m.a(bArrB, this.f16382i);
        m.a(bArrB2, this.f16382i);
        byte[] bArr2 = new byte[this.f16382i.e()];
        this.f16382i.b(bArr2, 0);
        return bArr2;
    }

    public static h f(byte[] bArr, byte[] bArr2) throws Throwable {
        h hVarE = e(bArr);
        hVarE.f16384k = i.a(bArr2);
        return hVarE;
    }

    @Override // nd.g, re.c
    public byte[] getEncoded() {
        return nd.a.f().i(0).i(this.f16376c.f()).i(this.f16377d.f()).d(this.f16375b).i(this.f16383j).i(this.f16378e).i(this.f16379f.length).d(this.f16379f).b();
    }
}
