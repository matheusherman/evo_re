package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class d implements Iterable<Byte> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f13632a = new p(new byte[0]);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a extends Iterator<Byte> {
        byte a();
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends OutputStream {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final byte[] f13633f = new byte[0];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f13634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<d> f13635b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f13636c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private byte[] f13637d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f13638e;

        public synchronized int d() {
            return this.f13636c + this.f13638e;
        }

        public synchronized d f() {
            c();
            return d.g(this.f13635b);
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i10) {
            try {
                if (this.f13638e == this.f13637d.length) {
                    b(1);
                }
                byte[] bArr = this.f13637d;
                int i11 = this.f13638e;
                this.f13638e = i11 + 1;
                bArr[i11] = (byte) i10;
            } catch (Throwable th) {
                throw th;
            }
        }

        private byte[] a(byte[] bArr, int i10) {
            byte[] bArr2 = new byte[i10];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i10));
            return bArr2;
        }

        private void b(int i10) {
            this.f13635b.add(new p(this.f13637d));
            int length = this.f13636c + this.f13637d.length;
            this.f13636c = length;
            this.f13637d = new byte[Math.max(this.f13634a, Math.max(i10, length >>> 1))];
            this.f13638e = 0;
        }

        private void c() {
            int i10 = this.f13638e;
            byte[] bArr = this.f13637d;
            if (i10 >= bArr.length) {
                this.f13635b.add(new p(this.f13637d));
                this.f13637d = f13633f;
            } else if (i10 > 0) {
                this.f13635b.add(new p(a(bArr, i10)));
            }
            this.f13636c += this.f13638e;
            this.f13638e = 0;
        }

        b(int i10) {
            if (i10 >= 0) {
                this.f13634a = i10;
                this.f13635b = new ArrayList<>();
                this.f13637d = new byte[i10];
                return;
            }
            throw new IllegalArgumentException("Buffer size < 0");
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(d()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i10, int i11) {
            try {
                byte[] bArr2 = this.f13637d;
                int length = bArr2.length;
                int i12 = this.f13638e;
                if (i11 <= length - i12) {
                    System.arraycopy(bArr, i10, bArr2, i12, i11);
                    this.f13638e += i11;
                } else {
                    int length2 = bArr2.length - i12;
                    System.arraycopy(bArr, i10, bArr2, i12, length2);
                    int i13 = i11 - length2;
                    b(i13);
                    System.arraycopy(bArr, i10 + length2, this.f13637d, 0, i13);
                    this.f13638e = i13;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static d e(Iterator<d> it, int i10) {
        if (i10 == 1) {
            return it.next();
        }
        int i11 = i10 >>> 1;
        return e(it, i11).f(e(it, i10 - i11));
    }

    public static d h(byte[] bArr) {
        return i(bArr, 0, bArr.length);
    }

    abstract void C(OutputStream outputStream, int i10, int i11);

    protected abstract void n(byte[] bArr, int i10, int i11, int i12);

    protected abstract int o();

    protected abstract boolean q();

    public abstract boolean r();

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: s */
    public abstract a iterator();

    public abstract int size();

    public abstract e t();

    protected abstract int v(int i10, int i11, int i12);

    protected abstract int w(int i10, int i11, int i12);

    protected abstract int x();

    public abstract String z(String str);

    public static d g(Iterable<d> iterable) {
        Collection arrayList;
        if (iterable instanceof Collection) {
            arrayList = (Collection) iterable;
        } else {
            arrayList = new ArrayList();
            Iterator<d> it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        return arrayList.isEmpty() ? f13632a : e(arrayList.iterator(), arrayList.size());
    }

    public static d i(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        return new p(bArr2);
    }

    public static d k(String str) {
        try {
            return new p(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("UTF-8 not supported?", e10);
        }
    }

    public static b u() {
        return new b(128);
    }

    public String A() {
        try {
            return z("UTF-8");
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("UTF-8 not supported?", e10);
        }
    }

    void B(OutputStream outputStream, int i10, int i11) {
        if (i10 < 0) {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Source offset < 0: ");
            sb2.append(i10);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        if (i11 < 0) {
            StringBuilder sb3 = new StringBuilder(23);
            sb3.append("Length < 0: ");
            sb3.append(i11);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
        int i12 = i10 + i11;
        if (i12 <= size()) {
            if (i11 > 0) {
                C(outputStream, i10, i11);
            }
        } else {
            StringBuilder sb4 = new StringBuilder(39);
            sb4.append("Source end offset exceeded: ");
            sb4.append(i12);
            throw new IndexOutOfBoundsException(sb4.toString());
        }
    }

    public void m(byte[] bArr, int i10, int i11, int i12) {
        if (i10 < 0) {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Source offset < 0: ");
            sb2.append(i10);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        if (i11 < 0) {
            StringBuilder sb3 = new StringBuilder(30);
            sb3.append("Target offset < 0: ");
            sb3.append(i11);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
        if (i12 < 0) {
            StringBuilder sb4 = new StringBuilder(23);
            sb4.append("Length < 0: ");
            sb4.append(i12);
            throw new IndexOutOfBoundsException(sb4.toString());
        }
        int i13 = i10 + i12;
        if (i13 > size()) {
            StringBuilder sb5 = new StringBuilder(34);
            sb5.append("Source end offset < 0: ");
            sb5.append(i13);
            throw new IndexOutOfBoundsException(sb5.toString());
        }
        int i14 = i11 + i12;
        if (i14 <= bArr.length) {
            if (i12 > 0) {
                n(bArr, i10, i11, i12);
            }
        } else {
            StringBuilder sb6 = new StringBuilder(34);
            sb6.append("Target end offset < 0: ");
            sb6.append(i14);
            throw new IndexOutOfBoundsException(sb6.toString());
        }
    }

    d() {
    }

    public d f(d dVar) {
        int size = size();
        int size2 = dVar.size();
        if (((long) size) + ((long) size2) < 2147483647L) {
            return u.I(this, dVar);
        }
        StringBuilder sb2 = new StringBuilder(53);
        sb2.append("ByteString would be too long: ");
        sb2.append(size);
        sb2.append("+");
        sb2.append(size2);
        throw new IllegalArgumentException(sb2.toString());
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public byte[] y() {
        int size = size();
        if (size == 0) {
            return j.f13686a;
        }
        byte[] bArr = new byte[size];
        n(bArr, 0, 0, size);
        return bArr;
    }
}
