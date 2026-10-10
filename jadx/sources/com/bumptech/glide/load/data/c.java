package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class c extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final OutputStream f1377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f1378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private m.b f1379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1380d;

    public c(@NonNull OutputStream outputStream, @NonNull m.b bVar) {
        this(outputStream, bVar, 65536);
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        byte[] bArr = this.f1378b;
        int i11 = this.f1380d;
        this.f1380d = i11 + 1;
        bArr[i11] = (byte) i10;
        b();
    }

    @VisibleForTesting
    c(@NonNull OutputStream outputStream, m.b bVar, int i10) {
        this.f1377a = outputStream;
        this.f1379c = bVar;
        this.f1378b = (byte[]) bVar.d(i10, byte[].class);
    }

    private void a() throws IOException {
        int i10 = this.f1380d;
        if (i10 > 0) {
            this.f1377a.write(this.f1378b, 0, i10);
            this.f1380d = 0;
        }
    }

    private void b() throws IOException {
        if (this.f1380d == this.f1378b.length) {
            a();
        }
    }

    private void c() {
        byte[] bArr = this.f1378b;
        if (bArr != null) {
            this.f1379c.put(bArr);
            this.f1378b = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f1377a.close();
            c();
        } catch (Throwable th) {
            this.f1377a.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        a();
        this.f1377a.flush();
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i10, int i11) throws IOException {
        int i12 = 0;
        do {
            int i13 = i11 - i12;
            int i14 = i10 + i12;
            int i15 = this.f1380d;
            if (i15 == 0 && i13 >= this.f1378b.length) {
                this.f1377a.write(bArr, i14, i13);
                return;
            }
            int iMin = Math.min(i13, this.f1378b.length - i15);
            System.arraycopy(bArr, i14, this.f1378b, this.f1380d, iMin);
            this.f1380d += iMin;
            i12 += iMin;
            b();
        } while (i12 < i11);
    }
}
