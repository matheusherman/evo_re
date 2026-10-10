package wf;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import q6.b;
import q6.c;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f20514a = c.d(getClass());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f20515b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f20516c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f20517d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f20518e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f20519f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ByteArrayOutputStream f20520g = new ByteArrayOutputStream();

    private void a(byte[] bArr) {
        int i10 = bArr[4] & 255;
        int i11 = ((bArr[i10 + 15] & 15) << 8) | (bArr[i10 + 16] & 255);
        int i12 = i10 + 17;
        while (true) {
            i12 += i11;
            if (i12 >= 184) {
                return;
            }
            int i13 = bArr[i12] & 255;
            int i14 = ((bArr[i12 + 1] & 31) << 8) | (bArr[i12 + 2] & 255);
            if (i13 == 27) {
                this.f20517d = "H264";
                this.f20516c = i14;
            } else if (i13 == 36) {
                this.f20517d = "H265";
                this.f20516c = i14;
            } else if (i13 == 2) {
                this.f20517d = "MPEG2";
                this.f20516c = i14;
            }
            if (this.f20516c != -1) {
                this.f20514a.debug("Detected Video PID: " + this.f20516c + " Codec: " + this.f20517d, new Object[0]);
                return;
            }
            i11 = (((bArr[i12 + 3] & 15) << 8) | (bArr[i12 + 4] & 255)) + 5;
        }
    }

    private byte[] b(byte[] bArr) {
        int i10 = (bArr[3] & 48) >> 4;
        int i11 = (i10 == 2 || i10 == 3) ? (bArr[4] & 255) + 5 : 4;
        if (i11 >= 188) {
            return null;
        }
        if ((bArr[1] & 64) != 0 && bArr[i11] == 0 && bArr[i11 + 1] == 0 && bArr[i11 + 2] == 1) {
            i11 += (bArr[i11 + 8] & 255) + 9;
        }
        int i12 = 188 - i11;
        if (i12 <= 0) {
            return null;
        }
        byte[] bArr2 = new byte[i12];
        System.arraycopy(bArr, i11, bArr2, 0, i12);
        return bArr2;
    }

    private void c(byte[] bArr, boolean z10) {
        byte b10 = bArr[3];
        int i10 = b10 & 15;
        int i11 = this.f20518e;
        if (i11 != -1 && ((b10 & 48) >> 4) != 2 && i10 != (i11 + 1) % 16 && i10 != i11) {
            this.f20519f = true;
        }
        this.f20518e = i10;
        if (z10) {
            if (this.f20520g.size() > 0 && !this.f20519f) {
                f(this.f20520g.toByteArray());
            }
            this.f20520g.reset();
            this.f20519f = false;
        }
        byte[] bArrB = b(bArr);
        if (bArrB != null) {
            this.f20520g.write(bArrB, 0, bArrB.length);
        }
    }

    private int d(byte[] bArr) {
        int i10 = bArr[4] & 255;
        return (bArr[i10 + 16] & 255) | ((bArr[i10 + 15] & 31) << 8);
    }

    private void f(byte[] bArr) {
        byte b10;
        for (int i10 = 0; i10 < bArr.length - 5; i10++) {
            if (bArr[i10] == 0 && bArr[i10 + 1] == 0 && ((b10 = bArr[i10 + 2]) == 1 || (b10 == 0 && bArr[i10 + 3] == 1))) {
                int i11 = b10 == 1 ? 3 : 4;
                if ("H264".equals(this.f20517d)) {
                    if ((bArr[i11 + i10] & 31) == 5) {
                        this.f20514a.debug("[MATCH] H.264 I-Frame Found", new Object[0]);
                    }
                } else if ("H265".equals(this.f20517d)) {
                    int i12 = (bArr[i11 + i10] & 126) >> 1;
                    if (i12 >= 16 && i12 <= 21) {
                        this.f20514a.debug("[MATCH] H.265 I-Frame Found", new Object[0]);
                    }
                } else if ("MPEG2".equals(this.f20517d)) {
                    int i13 = i11 + i10;
                    if (bArr[i13] == 0 && ((bArr[i13 + 2] & 56) >> 3) == 1) {
                        this.f20514a.debug("[MATCH] MPEG-2 I-Frame Found", new Object[0]);
                    }
                }
            }
        }
    }

    public void e(InputStream inputStream) {
        byte[] bArr = new byte[188];
        while (inputStream.read(bArr) == 188) {
            if (bArr[0] == 71) {
                byte b10 = bArr[1];
                int i10 = ((b10 & 31) << 8) | (bArr[2] & 255);
                boolean z10 = (b10 & 64) != 0;
                if (i10 == 0 && this.f20515b == -1) {
                    int iD = d(bArr);
                    this.f20515b = iD;
                    if (iD != -1) {
                        this.f20514a.debug("Discovered PMT PID: " + this.f20515b, new Object[0]);
                    }
                } else if (i10 == this.f20515b && this.f20516c == -1) {
                    a(bArr);
                } else if (i10 == this.f20516c && this.f20517d != null) {
                    c(bArr, z10);
                }
            }
        }
    }
}
