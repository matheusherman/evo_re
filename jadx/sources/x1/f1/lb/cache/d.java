package x1.f1.lb.cache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class d implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f20635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Charset f20636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f20637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f20638d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f20639e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends ByteArrayOutputStream {
        a(int i10) {
            super(i10);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i10 = ((ByteArrayOutputStream) this).count;
            if (i10 > 0 && ((ByteArrayOutputStream) this).buf[i10 - 1] == 13) {
                i10--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i10, d.this.f20636b.name());
            } catch (UnsupportedEncodingException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    public d(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public d(InputStream inputStream, int i10, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(e.f20641a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f20635a = inputStream;
        this.f20636b = charset;
        this.f20637c = new byte[i10];
    }

    private void b() throws IOException {
        InputStream inputStream = this.f20635a;
        byte[] bArr = this.f20637c;
        int i10 = inputStream.read(bArr, 0, bArr.length);
        if (i10 == -1) {
            throw new EOFException();
        }
        this.f20638d = 0;
        this.f20639e = i10;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x002f  */
    public String c() {
        int i10;
        byte[] bArr;
        int i11;
        synchronized (this.f20635a) {
            try {
                if (this.f20637c == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.f20638d >= this.f20639e) {
                    b();
                }
                for (int i12 = this.f20638d; i12 != this.f20639e; i12++) {
                    byte[] bArr2 = this.f20637c;
                    if (bArr2[i12] == 10) {
                        int i13 = this.f20638d;
                        if (i12 != i13) {
                            i11 = i12 - 1;
                            if (bArr2[i11] != 13) {
                                i11 = i12;
                            }
                        } else {
                            i11 = i12;
                        }
                        String str = new String(bArr2, i13, i11 - i13, this.f20636b.name());
                        this.f20638d = i12 + 1;
                        return str;
                    }
                }
                a aVar = new a((this.f20639e - this.f20638d) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.f20637c;
                    int i14 = this.f20638d;
                    aVar.write(bArr3, i14, this.f20639e - i14);
                    this.f20639e = -1;
                    b();
                    i10 = this.f20638d;
                    while (i10 != this.f20639e) {
                        bArr = this.f20637c;
                        if (bArr[i10] == 10) {
                            break loop1;
                        }
                        i10++;
                    }
                }
                int i15 = this.f20638d;
                if (i10 != i15) {
                    aVar.write(bArr, i15, i10 - i15);
                }
                this.f20638d = i10 + 1;
                return aVar.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f20635a) {
            try {
                if (this.f20637c != null) {
                    this.f20637c = null;
                    this.f20635a.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
