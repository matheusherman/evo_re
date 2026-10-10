package zb;

import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class a extends OutputStream {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final byte[] f23240g = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<byte[]> f23241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f23242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f23243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f23244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f23245e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f23246f;

    public a() {
        this(1024);
    }

    public synchronized byte[] b() {
        int i10 = this.f23245e;
        if (i10 == 0) {
            return f23240g;
        }
        byte[] bArr = new byte[i10];
        int i11 = 0;
        for (byte[] bArr2 : this.f23241a) {
            int iMin = Math.min(bArr2.length, i10);
            System.arraycopy(bArr2, 0, bArr, i11, iMin);
            i11 += iMin;
            i10 -= iMin;
            if (i10 == 0) {
                break;
            }
        }
        return bArr;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) {
        int i12;
        if (i10 < 0 || i10 > bArr.length || i11 < 0 || (i12 = i10 + i11) > bArr.length || i12 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i11 == 0) {
            return;
        }
        synchronized (this) {
            try {
                int i13 = this.f23245e;
                int i14 = i13 + i11;
                int i15 = i13 - this.f23243c;
                while (i11 > 0) {
                    int iMin = Math.min(i11, this.f23244d.length - i15);
                    System.arraycopy(bArr, i12 - i11, this.f23244d, i15, iMin);
                    i11 -= iMin;
                    if (i11 > 0) {
                        a(i14);
                        i15 = 0;
                    }
                }
                this.f23245e = i14;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public a(int i10) {
        this.f23241a = new ArrayList();
        this.f23246f = true;
        if (i10 >= 0) {
            synchronized (this) {
                a(i10);
            }
        } else {
            throw new IllegalArgumentException("Negative initial size: " + i10);
        }
    }

    private void a(int i10) {
        if (this.f23242b < this.f23241a.size() - 1) {
            this.f23243c += this.f23244d.length;
            int i11 = this.f23242b + 1;
            this.f23242b = i11;
            this.f23244d = this.f23241a.get(i11);
            return;
        }
        byte[] bArr = this.f23244d;
        if (bArr == null) {
            this.f23243c = 0;
        } else {
            i10 = Math.max(bArr.length << 1, i10 - this.f23243c);
            this.f23243c += this.f23244d.length;
        }
        this.f23242b++;
        byte[] bArr2 = new byte[i10];
        this.f23244d = bArr2;
        this.f23241a.add(bArr2);
    }

    @Deprecated
    public String toString() {
        return new String(b(), Charset.defaultCharset());
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i10) {
        try {
            int i11 = this.f23245e;
            int i12 = i11 - this.f23243c;
            if (i12 == this.f23244d.length) {
                a(i11 + 1);
                i12 = 0;
            }
            this.f23244d[i12] = (byte) i10;
            this.f23245e++;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
