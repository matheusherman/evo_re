package db;

import androidx.core.view.InputDeviceCompat;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class m extends cb.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte f9713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte f9714e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private short f9715f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f9716g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f9717h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private e f9718i;

    public m(int i10, long j10) {
        super(InputDeviceCompat.SOURCE_DPAD, i10, j10);
    }

    public e d() {
        return this.f9718i;
    }

    public int e() {
        return this.f9717h;
    }

    public int f() {
        return this.f9716g;
    }

    public short g() {
        return fb.h.c(this.f9713d);
    }

    public void h(e eVar) {
        this.f9718i = eVar;
    }

    public void i(long j10) {
        this.f9717h = fb.h.a(j10);
    }

    public void j(long j10) {
        this.f9716g = fb.h.a(j10);
    }

    public void k(short s10) {
        this.f9713d = fb.h.d(s10);
    }

    public void l(short s10) {
        this.f9714e = fb.h.d(s10);
    }

    public void m(int i10) {
        this.f9715f = fb.h.f(i10);
    }
}
