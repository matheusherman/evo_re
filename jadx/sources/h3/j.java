package h3;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10804b;

    public abstract byte[] b();

    public abstract byte[] c(int i10, byte[] bArr);

    public boolean f() {
        return false;
    }

    public final int a() {
        return this.f10804b;
    }

    public final int d() {
        return this.f10803a;
    }

    public j e() {
        return new i(this);
    }

    public j g() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        char c10;
        int i10 = this.f10803a;
        byte[] bArrC = new byte[i10];
        StringBuilder sb2 = new StringBuilder(this.f10804b * (i10 + 1));
        for (int i11 = 0; i11 < this.f10804b; i11++) {
            bArrC = c(i11, bArrC);
            for (int i12 = 0; i12 < this.f10803a; i12++) {
                int i13 = bArrC[i12] & 255;
                if (i13 < 64) {
                    c10 = '#';
                } else if (i13 < 128) {
                    c10 = '+';
                } else {
                    c10 = i13 < 192 ? '.' : ' ';
                }
                sb2.append(c10);
            }
            sb2.append('\n');
        }
        return sb2.toString();
    }

    protected j(int i10, int i11) {
        this.f10803a = i10;
        this.f10804b = i11;
    }
}
