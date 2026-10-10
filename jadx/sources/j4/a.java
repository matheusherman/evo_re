package j4;

import h3.s;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a extends s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f11586c;

    a(float f10, float f11, float f12) {
        super(f10, f11);
        this.f11586c = f12;
    }

    boolean f(float f10, float f11, float f12) {
        if (Math.abs(f11 - d()) > f10 || Math.abs(f12 - c()) > f10) {
            return false;
        }
        float fAbs = Math.abs(f10 - this.f11586c);
        if (fAbs > 1.0f && fAbs > this.f11586c) {
            return false;
        }
        return true;
    }

    a g(float f10, float f11, float f12) {
        return new a((c() + f11) / 2.0f, (d() + f10) / 2.0f, (this.f11586c + f12) / 2.0f);
    }
}
