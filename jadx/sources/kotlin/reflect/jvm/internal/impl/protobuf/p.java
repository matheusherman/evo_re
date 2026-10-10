package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class p extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final byte[] f13697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13698c = 0;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class b implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f13699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f13700b;

        private b() {
            this.f13699a = 0;
            this.f13700b = p.this.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.d.a
        public byte a() {
            try {
                byte[] bArr = p.this.f13697b;
                int i10 = this.f13699a;
                this.f13699a = i10 + 1;
                return bArr[i10];
            } catch (ArrayIndexOutOfBoundsException e10) {
                throw new NoSuchElementException(e10.getMessage());
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13699a < this.f13700b;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Byte next() {
            return Byte.valueOf(a());
        }
    }

    static int I(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            i10 = (i10 * 31) + bArr[i13];
        }
        return i10;
    }

    protected int H() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d) || size() != ((d) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof p) {
            return E((p) obj, 0, size());
        }
        if (obj instanceof u) {
            return obj.equals(this);
        }
        String strValueOf = String.valueOf(obj.getClass());
        StringBuilder sb2 = new StringBuilder(strValueOf.length() + 49);
        sb2.append("Has a new type of ByteString been created? Found ");
        sb2.append(strValueOf);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int o() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected boolean q() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    void C(OutputStream outputStream, int i10, int i11) throws IOException {
        outputStream.write(this.f13697b, H() + i10, i11);
    }

    public byte D(int i10) {
        return this.f13697b[i10];
    }

    public int hashCode() {
        int iV = this.f13698c;
        if (iV == 0) {
            int size = size();
            iV = v(size, 0, size);
            if (iV == 0) {
                iV = 1;
            }
            this.f13698c = iV;
        }
        return iV;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected void n(byte[] bArr, int i10, int i11, int i12) {
        System.arraycopy(this.f13697b, i10, bArr, i11, i12);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d, java.lang.Iterable
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public d.a iterator() {
        return new b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public int size() {
        return this.f13697b.length;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int v(int i10, int i11, int i12) {
        return I(i10, this.f13697b, H() + i11, i12);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int x() {
        return this.f13698c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public String z(String str) {
        return new String(this.f13697b, H(), size(), str);
    }

    p(byte[] bArr) {
        this.f13697b = bArr;
    }

    boolean E(p pVar, int i10, int i11) {
        if (i11 <= pVar.size()) {
            if (i10 + i11 <= pVar.size()) {
                byte[] bArr = this.f13697b;
                byte[] bArr2 = pVar.f13697b;
                int iH = H() + i11;
                int iH2 = H();
                int iH3 = pVar.H() + i10;
                while (iH2 < iH) {
                    if (bArr[iH2] != bArr2[iH3]) {
                        return false;
                    }
                    iH2++;
                    iH3++;
                }
                return true;
            }
            int size = pVar.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: ");
            sb2.append(i10);
            sb2.append(", ");
            sb2.append(i11);
            sb2.append(", ");
            sb2.append(size);
            throw new IllegalArgumentException(sb2.toString());
        }
        int size2 = size();
        StringBuilder sb3 = new StringBuilder(40);
        sb3.append("Length too large: ");
        sb3.append(i11);
        sb3.append(size2);
        throw new IllegalArgumentException(sb3.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public boolean r() {
        int iH = H();
        return y.f(this.f13697b, iH, size() + iH);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public e t() {
        return e.h(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int w(int i10, int i11, int i12) {
        int iH = H() + i11;
        return y.g(i10, this.f13697b, iH, i12 + iH);
    }
}
