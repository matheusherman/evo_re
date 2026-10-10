package xd;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class b implements Serializable {
    private static final long serialVersionUID = -3464451825208522308L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient long f22071a;
    private final Map<Integer, a> bdsState = new TreeMap();

    b(long j10) {
        this.f22071a = j10;
    }

    b(b bVar, long j10) {
        for (Integer num : bVar.bdsState.keySet()) {
            this.bdsState.put(num, new a(bVar.bdsState.get(num)));
        }
        this.f22071a = j10;
    }

    a a(int i10) {
        return this.bdsState.get(re.d.a(i10));
    }

    public long b() {
        return this.f22071a;
    }

    void c(int i10, a aVar) {
        this.bdsState.put(re.d.a(i10), aVar);
    }

    a d(int i10, byte[] bArr, byte[] bArr2, j jVar) {
        return this.bdsState.put(re.d.a(i10), this.bdsState.get(re.d.a(i10)).d(bArr, bArr2, jVar));
    }

    void e(r rVar, long j10, byte[] bArr, byte[] bArr2) {
        x xVarH = rVar.h();
        int iB = xVarH.b();
        long j11 = a0.j(j10, iB);
        int i10 = a0.i(j10, iB);
        j jVar = (j) new j.b().h(j11).p(i10).l();
        int i11 = (1 << iB) - 1;
        if (i10 < i11) {
            if (a(0) == null || i10 == 0) {
                c(0, new a(xVarH, bArr, bArr2, jVar));
            }
            d(0, bArr, bArr2, jVar);
        }
        for (int i12 = 1; i12 < rVar.b(); i12++) {
            int i13 = a0.i(j11, iB);
            j11 = a0.j(j11, iB);
            j jVar2 = (j) new j.b().g(i12).h(j11).p(i13).l();
            if (this.bdsState.get(Integer.valueOf(i12)) == null || a0.n(j10, iB, i12)) {
                this.bdsState.put(Integer.valueOf(i12), new a(xVarH, bArr, bArr2, jVar2));
            }
            if (i13 < i11 && a0.m(j10, iB, i12)) {
                d(i12, bArr, bArr2, jVar2);
            }
        }
    }

    public b f(fc.u uVar) {
        b bVar = new b(this.f22071a);
        for (Integer num : this.bdsState.keySet()) {
            bVar.bdsState.put(num, this.bdsState.get(num).h(uVar));
        }
        return bVar;
    }

    b(r rVar, long j10, byte[] bArr, byte[] bArr2) {
        this.f22071a = (1 << rVar.a()) - 1;
        for (long j11 = 0; j11 < j10; j11++) {
            e(rVar, j11, bArr, bArr2);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        long j10;
        objectInputStream.defaultReadObject();
        if (objectInputStream.available() != 0) {
            j10 = objectInputStream.readLong();
        } else {
            j10 = 0;
        }
        this.f22071a = j10;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(this.f22071a);
    }
}
