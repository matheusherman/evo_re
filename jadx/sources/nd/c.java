package nd;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class c extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f16350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<h> f16351d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<j> f16352e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f16353f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f16354g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private d f16355h;

    private c(int i10, List<h> list, List<j> list2, long j10, long j11, boolean z10) {
        super(true);
        this.f16354g = 0L;
        this.f16349b = i10;
        this.f16351d = Collections.unmodifiableList(list);
        this.f16352e = Collections.unmodifiableList(list2);
        this.f16354g = j10;
        this.f16353f = j11;
        this.f16350c = z10;
    }

    public synchronized d d() {
        return new d(this.f16349b, e().i());
    }

    @Override // nd.g, re.c
    public synchronized byte[] getEncoded() {
        a aVarA;
        try {
            aVarA = a.f().i(0).i(this.f16349b).j(this.f16354g).j(this.f16353f).a(this.f16350c);
            Iterator<h> it = this.f16351d.iterator();
            while (it.hasNext()) {
                aVarA.c(it.next());
            }
            Iterator<j> it2 = this.f16352e.iterator();
            while (it2.hasNext()) {
                aVarA.c(it2.next());
            }
        } catch (Throwable th) {
            throw th;
        }
        return aVarA.b();
    }

    public static c a(Object obj) throws Throwable {
        Throwable th;
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) obj;
            if (dataInputStream.readInt() != 0) {
                throw new IllegalStateException("unknown version for hss private key");
            }
            int i10 = dataInputStream.readInt();
            long j10 = dataInputStream.readLong();
            long j11 = dataInputStream.readLong();
            boolean z10 = dataInputStream.readBoolean();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i11 = 0; i11 < i10; i11++) {
                arrayList.add(h.e(obj));
            }
            for (int i12 = 0; i12 < i10 - 1; i12++) {
                arrayList2.add(j.a(obj));
            }
            return new c(i10, arrayList, arrayList2, j10, j11, z10);
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return a(te.a.c((InputStream) obj));
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        DataInputStream dataInputStream2 = null;
        try {
            DataInputStream dataInputStream3 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                c cVarA = a(dataInputStream3);
                dataInputStream3.close();
                return cVarA;
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

    public int c() {
        return this.f16349b;
    }

    h e() {
        return this.f16351d.get(0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f16349b == cVar.f16349b && this.f16350c == cVar.f16350c && this.f16353f == cVar.f16353f && this.f16354g == cVar.f16354g && this.f16351d.equals(cVar.f16351d)) {
            return this.f16352e.equals(cVar.f16352e);
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = ((((((this.f16349b * 31) + (this.f16350c ? 1 : 0)) * 31) + this.f16351d.hashCode()) * 31) + this.f16352e.hashCode()) * 31;
        long j10 = this.f16353f;
        int i10 = (iHashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.f16354g;
        return i10 + ((int) (j11 ^ (j11 >>> 32)));
    }

    public static c b(byte[] bArr, byte[] bArr2) throws Throwable {
        c cVarA = a(bArr);
        cVarA.f16355h = d.a(bArr2);
        return cVarA;
    }

    private static c f(c cVar) {
        try {
            return a(cVar.getEncoded());
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage(), e10);
        }
    }

    protected Object clone() {
        return f(this);
    }
}
