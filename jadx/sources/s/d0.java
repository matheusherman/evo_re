package s;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class d0 extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile byte[] f18140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f18141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f18142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f18143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f18144e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final m.b f18145f;

    public d0(@NonNull InputStream inputStream, @NonNull m.b bVar) {
        this(inputStream, bVar, 65536);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f18140a == null || inputStream == null) {
            throw d();
        }
        return (this.f18141b - this.f18144e) + inputStream.available();
    }

    public synchronized void b() {
        this.f18142c = this.f18140a.length;
    }

    public synchronized void c() {
        if (this.f18140a != null) {
            this.f18145f.put(this.f18140a);
            this.f18140a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i10) {
        this.f18142c = Math.max(this.f18142c, i10);
        this.f18143d = this.f18144e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        byte[] bArr = this.f18140a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw d();
        }
        if (this.f18144e >= this.f18141b && a(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f18140a && (bArr = this.f18140a) == null) {
            throw d();
        }
        int i10 = this.f18141b;
        int i11 = this.f18144e;
        if (i10 - i11 <= 0) {
            return -1;
        }
        this.f18144e = i11 + 1;
        return bArr[i11] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        if (this.f18140a == null) {
            throw new IOException("Stream is closed");
        }
        int i10 = this.f18143d;
        if (-1 == i10) {
            throw new a("Mark has been invalidated, pos: " + this.f18144e + " markLimit: " + this.f18142c);
        }
        this.f18144e = i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j10) {
        if (j10 < 1) {
            return 0L;
        }
        byte[] bArr = this.f18140a;
        if (bArr == null) {
            throw d();
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw d();
        }
        int i10 = this.f18141b;
        int i11 = this.f18144e;
        if (i10 - i11 >= j10) {
            this.f18144e = (int) (((long) i11) + j10);
            return j10;
        }
        long j11 = ((long) i10) - ((long) i11);
        this.f18144e = i10;
        if (this.f18143d == -1 || j10 > this.f18142c) {
            long jSkip = inputStream.skip(j10 - j11);
            if (jSkip > 0) {
                this.f18143d = -1;
            }
            return j11 + jSkip;
        }
        if (a(inputStream, bArr) == -1) {
            return j11;
        }
        int i12 = this.f18141b;
        int i13 = this.f18144e;
        if (i12 - i13 >= j10 - j11) {
            this.f18144e = (int) ((((long) i13) + j10) - j11);
            return j10;
        }
        long j12 = (j11 + ((long) i12)) - ((long) i13);
        this.f18144e = i12;
        return j12;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        a(String str) {
            super(str);
        }
    }

    @VisibleForTesting
    d0(@NonNull InputStream inputStream, @NonNull m.b bVar, int i10) {
        super(inputStream);
        this.f18143d = -1;
        this.f18145f = bVar;
        this.f18140a = (byte[]) bVar.d(i10, byte[].class);
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i10 = this.f18143d;
        if (i10 != -1) {
            int i11 = this.f18144e - i10;
            int i12 = this.f18142c;
            if (i11 < i12) {
                if (i10 == 0 && i12 > bArr.length && this.f18141b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i12) {
                        i12 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f18145f.d(i12, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f18140a = bArr2;
                    this.f18145f.put(bArr);
                    bArr = bArr2;
                } else if (i10 > 0) {
                    System.arraycopy(bArr, i10, bArr, 0, bArr.length - i10);
                }
                int i13 = this.f18144e - this.f18143d;
                this.f18144e = i13;
                this.f18143d = 0;
                this.f18141b = 0;
                int i14 = inputStream.read(bArr, i13, bArr.length - i13);
                int i15 = this.f18144e;
                if (i14 > 0) {
                    i15 += i14;
                }
                this.f18141b = i15;
                return i14;
            }
        }
        int i16 = inputStream.read(bArr);
        if (i16 > 0) {
            this.f18143d = -1;
            this.f18144e = 0;
            this.f18141b = i16;
        }
        return i16;
    }

    private static IOException d() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f18140a != null) {
            this.f18145f.put(this.f18140a);
            this.f18140a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        byte[] bArr2 = this.f18140a;
        if (bArr2 == null) {
            throw d();
        }
        if (i11 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i14 = this.f18144e;
            int i15 = this.f18141b;
            if (i14 < i15) {
                int i16 = i15 - i14 >= i11 ? i11 : i15 - i14;
                System.arraycopy(bArr2, i14, bArr, i10, i16);
                this.f18144e += i16;
                if (i16 == i11 || inputStream.available() == 0) {
                    return i16;
                }
                i10 += i16;
                i12 = i11 - i16;
            } else {
                i12 = i11;
            }
            while (true) {
                if (this.f18143d == -1 && i12 >= bArr2.length) {
                    i13 = inputStream.read(bArr, i10, i12);
                    if (i13 == -1) {
                        return i12 != i11 ? i11 - i12 : -1;
                    }
                } else {
                    if (a(inputStream, bArr2) == -1) {
                        return i12 != i11 ? i11 - i12 : -1;
                    }
                    if (bArr2 != this.f18140a && (bArr2 = this.f18140a) == null) {
                        throw d();
                    }
                    int i17 = this.f18141b;
                    int i18 = this.f18144e;
                    i13 = i17 - i18 >= i12 ? i12 : i17 - i18;
                    System.arraycopy(bArr2, i18, bArr, i10, i13);
                    this.f18144e += i13;
                }
                i12 -= i13;
                if (i12 == 0) {
                    return i11;
                }
                if (inputStream.available() == 0) {
                    return i11 - i12;
                }
                i10 += i13;
            }
        } else {
            throw d();
        }
    }
}
