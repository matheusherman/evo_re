package h;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ByteBuffer f10714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f10715c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f10713a = new byte[256];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10716d = 0;

    private void i(int i10) {
        boolean z10 = false;
        while (!z10 && !b() && this.f10715c.f10702c <= i10) {
            int iD = d();
            if (iD == 33) {
                int iD2 = d();
                if (iD2 == 1) {
                    q();
                } else if (iD2 == 249) {
                    this.f10715c.f10703d = new b();
                    j();
                } else if (iD2 == 254) {
                    q();
                } else if (iD2 != 255) {
                    q();
                } else {
                    f();
                    StringBuilder sb2 = new StringBuilder();
                    for (int i11 = 0; i11 < 11; i11++) {
                        sb2.append((char) this.f10713a[i11]);
                    }
                    if (sb2.toString().equals("NETSCAPE2.0")) {
                        m();
                    } else {
                        q();
                    }
                }
            } else if (iD == 44) {
                c cVar = this.f10715c;
                if (cVar.f10703d == null) {
                    cVar.f10703d = new b();
                }
                e();
            } else if (iD != 59) {
                this.f10715c.f10701b = 1;
            } else {
                z10 = true;
            }
        }
    }

    private void o() {
        this.f10714b = null;
        Arrays.fill(this.f10713a, (byte) 0);
        this.f10715c = new c();
        this.f10716d = 0;
    }

    public void a() {
        this.f10714b = null;
        this.f10715c = null;
    }

    private boolean b() {
        return this.f10715c.f10701b != 0;
    }

    private int d() {
        try {
            return this.f10714b.get() & 255;
        } catch (Exception unused) {
            this.f10715c.f10701b = 1;
            return 0;
        }
    }

    private void e() {
        this.f10715c.f10703d.f10689a = n();
        this.f10715c.f10703d.f10690b = n();
        this.f10715c.f10703d.f10691c = n();
        this.f10715c.f10703d.f10692d = n();
        int iD = d();
        boolean z10 = (iD & 128) != 0;
        int iPow = (int) Math.pow(2.0d, (iD & 7) + 1);
        b bVar = this.f10715c.f10703d;
        bVar.f10693e = (iD & 64) != 0;
        if (z10) {
            bVar.f10699k = g(iPow);
        } else {
            bVar.f10699k = null;
        }
        this.f10715c.f10703d.f10698j = this.f10714b.position();
        r();
        if (b()) {
            return;
        }
        c cVar = this.f10715c;
        cVar.f10702c++;
        cVar.f10704e.add(cVar.f10703d);
    }

    @Nullable
    private int[] g(int i10) {
        byte[] bArr = new byte[i10 * 3];
        int[] iArr = null;
        try {
            this.f10714b.get(bArr);
            iArr = new int[256];
            int i11 = 0;
            int i12 = 0;
            while (i11 < i10) {
                int i13 = bArr[i12] & 255;
                int i14 = i12 + 2;
                int i15 = bArr[i12 + 1] & 255;
                i12 += 3;
                int i16 = i11 + 1;
                iArr[i11] = (i15 << 8) | (i13 << 16) | ViewCompat.MEASURED_STATE_MASK | (bArr[i14] & 255);
                i11 = i16;
            }
            return iArr;
        } catch (BufferUnderflowException e10) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e10);
            }
            this.f10715c.f10701b = 1;
            return iArr;
        }
    }

    private void k() {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < 6; i10++) {
            sb2.append((char) d());
        }
        if (!sb2.toString().startsWith("GIF")) {
            this.f10715c.f10701b = 1;
            return;
        }
        l();
        if (!this.f10715c.f10707h || b()) {
            return;
        }
        c cVar = this.f10715c;
        cVar.f10700a = g(cVar.f10708i);
        c cVar2 = this.f10715c;
        cVar2.f10711l = cVar2.f10700a[cVar2.f10709j];
    }

    private void l() {
        this.f10715c.f10705f = n();
        this.f10715c.f10706g = n();
        int iD = d();
        c cVar = this.f10715c;
        cVar.f10707h = (iD & 128) != 0;
        cVar.f10708i = (int) Math.pow(2.0d, (iD & 7) + 1);
        this.f10715c.f10709j = d();
        this.f10715c.f10710k = d();
    }

    private int n() {
        return this.f10714b.getShort();
    }

    @NonNull
    public c c() {
        if (this.f10714b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (b()) {
            return this.f10715c;
        }
        k();
        if (!b()) {
            h();
            c cVar = this.f10715c;
            if (cVar.f10702c < 0) {
                cVar.f10701b = 1;
            }
        }
        return this.f10715c;
    }

    private void f() {
        int iD = d();
        this.f10716d = iD;
        if (iD > 0) {
            int i10 = 0;
            int i11 = 0;
            while (true) {
                try {
                    int i12 = this.f10716d;
                    if (i10 < i12) {
                        i11 = i12 - i10;
                        this.f10714b.get(this.f10713a, i10, i11);
                        i10 += i11;
                    } else {
                        return;
                    }
                } catch (Exception e10) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i10 + " count: " + i11 + " blockSize: " + this.f10716d, e10);
                    }
                    this.f10715c.f10701b = 1;
                    return;
                }
            }
        }
    }

    private void h() {
        i(Integer.MAX_VALUE);
    }

    private void j() {
        d();
        int iD = d();
        b bVar = this.f10715c.f10703d;
        int i10 = (iD & 28) >> 2;
        bVar.f10695g = i10;
        boolean z10 = true;
        if (i10 == 0) {
            bVar.f10695g = 1;
        }
        if ((iD & 1) == 0) {
            z10 = false;
        }
        bVar.f10694f = z10;
        int iN = n();
        if (iN < 2) {
            iN = 10;
        }
        b bVar2 = this.f10715c.f10703d;
        bVar2.f10697i = iN * 10;
        bVar2.f10696h = d();
        d();
    }

    private void m() {
        do {
            f();
            byte[] bArr = this.f10713a;
            if (bArr[0] == 1) {
                this.f10715c.f10712m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f10716d <= 0) {
                return;
            }
        } while (!b());
    }

    private void q() {
        int iD;
        do {
            iD = d();
            this.f10714b.position(Math.min(this.f10714b.position() + iD, this.f10714b.limit()));
        } while (iD > 0);
    }

    private void r() {
        d();
        q();
    }

    public d p(@NonNull ByteBuffer byteBuffer) {
        o();
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f10714b = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.f10714b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }
}
