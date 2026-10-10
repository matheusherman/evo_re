package j4;

import h3.s;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d extends s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f11598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f11599d;

    d(float f10, float f11, float f12) {
        this(f10, f11, f12, 1);
    }

    private d(float f10, float f11, float f12, int i10) {
        super(f10, f11);
        this.f11598c = f12;
        this.f11599d = i10;
    }

    d g(float f10, float f11, float f12) {
        int i10 = this.f11599d;
        int i11 = i10 + 1;
        float fC = (i10 * c()) + f11;
        float f13 = i11;
        return new d(fC / f13, ((this.f11599d * d()) + f10) / f13, ((this.f11599d * this.f11598c) + f12) / f13, i11);
    }

    public int h() {
        return this.f11599d;
    }

    public float i() {
        return this.f11598c;
    }

    boolean f(float f10, float f11, float f12) {
        if (Math.abs(f11 - d()) > f10 || Math.abs(f12 - c()) > f10) {
            return false;
        }
        float fAbs = Math.abs(f10 - this.f11598c);
        if (fAbs > 1.0f && fAbs > this.f11598c) {
            return false;
        }
        return true;
    }
}
