package g;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class c implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f10390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Charset f10391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f10392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f10394e;

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
                return new String(((ByteArrayOutputStream) this).buf, 0, i10, c.this.f10391b.name());
            } catch (UnsupportedEncodingException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    public c(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public c(InputStream inputStream, int i10, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(d.f10396a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f10390a = inputStream;
        this.f10391b = charset;
        this.f10392c = new byte[i10];
    }

    private void b() throws IOException {
        InputStream inputStream = this.f10390a;
        byte[] bArr = this.f10392c;
        int i10 = inputStream.read(bArr, 0, bArr.length);
        if (i10 == -1) {
            throw new EOFException();
        }
        this.f10393d = 0;
        this.f10394e = i10;
    }

    public boolean c() {
        return this.f10394e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f10390a) {
            try {
                if (this.f10392c != null) {
                    this.f10392c = null;
                    this.f10390a.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x002f  */
    public String d() {
        int i10;
        byte[] bArr;
        int i11;
        synchronized (this.f10390a) {
            try {
                if (this.f10392c == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.f10393d >= this.f10394e) {
                    b();
                }
                for (int i12 = this.f10393d; i12 != this.f10394e; i12++) {
                    byte[] bArr2 = this.f10392c;
                    if (bArr2[i12] == 10) {
                        int i13 = this.f10393d;
                        if (i12 != i13) {
                            i11 = i12 - 1;
                            if (bArr2[i11] != 13) {
                                i11 = i12;
                            }
                        } else {
                            i11 = i12;
                        }
                        String str = new String(bArr2, i13, i11 - i13, this.f10391b.name());
                        this.f10393d = i12 + 1;
                        return str;
                    }
                }
                a aVar = new a((this.f10394e - this.f10393d) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.f10392c;
                    int i14 = this.f10393d;
                    aVar.write(bArr3, i14, this.f10394e - i14);
                    this.f10394e = -1;
                    b();
                    i10 = this.f10393d;
                    while (i10 != this.f10394e) {
                        bArr = this.f10392c;
                        if (bArr[i10] == 10) {
                            break loop1;
                        }
                        i10++;
                    }
                }
                int i15 = this.f10393d;
                if (i10 != i15) {
                    aVar.write(bArr, i15, i10 - i15);
                }
                this.f10393d = i10 + 1;
                return aVar.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
