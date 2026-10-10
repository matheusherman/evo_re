package e0;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class c extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9785b;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return (int) Math.max(this.f9784a - ((long) this.f9785b), ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        int i10;
        i10 = super.read();
        a(i10 >= 0 ? 1 : -1);
        return i10;
    }

    private int a(int i10) throws IOException {
        if (i10 >= 0) {
            this.f9785b += i10;
            return i10;
        }
        if (this.f9784a - ((long) this.f9785b) <= 0) {
            return i10;
        }
        throw new IOException("Failed to read all expected data, expected: " + this.f9784a + ", but read: " + this.f9785b);
    }

    @NonNull
    public static InputStream b(@NonNull InputStream inputStream, long j10) {
        return new c(inputStream, j10);
    }

    private c(@NonNull InputStream inputStream, long j10) {
        super(inputStream);
        this.f9784a = j10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i10, int i11) {
        return a(super.read(bArr, i10, i11));
    }
}
