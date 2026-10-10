package e0;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class d extends InputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("POOL")
    private static final Queue<d> f9786c = l.f(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InputStream f9787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IOException f9788b;

    public void c() {
        this.f9788b = null;
        this.f9787a = null;
        Queue<d> queue = f9786c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.f9787a.read();
        } catch (IOException e10) {
            this.f9788b = e10;
            throw e10;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f9787a.reset();
    }

    @NonNull
    public static d b(@NonNull InputStream inputStream) {
        d dVarPoll;
        Queue<d> queue = f9786c;
        synchronized (queue) {
            dVarPoll = queue.poll();
        }
        if (dVarPoll == null) {
            dVarPoll = new d();
        }
        dVarPoll.d(inputStream);
        return dVarPoll;
    }

    @Nullable
    public IOException a() {
        return this.f9788b;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f9787a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f9787a.close();
    }

    void d(@NonNull InputStream inputStream) {
        this.f9787a = inputStream;
    }

    @Override // java.io.InputStream
    public void mark(int i10) {
        this.f9787a.mark(i10);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f9787a.markSupported();
    }

    @Override // java.io.InputStream
    public long skip(long j10) throws IOException {
        try {
            return this.f9787a.skip(j10);
        } catch (IOException e10) {
            this.f9788b = e10;
            throw e10;
        }
    }

    d() {
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.f9787a.read(bArr);
        } catch (IOException e10) {
            this.f9788b = e10;
            throw e10;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        try {
            return this.f9787a.read(bArr, i10, i11);
        } catch (IOException e10) {
            this.f9788b = e10;
            throw e10;
        }
    }
}
