package db;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class o extends cb.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte f9722d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte f9723e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private short f9724f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f9725g;

    public o(int i10, long j10) {
        super(514, i10, j10);
    }

    public int d() {
        return this.f9725g;
    }

    public short e() {
        return fb.h.c(this.f9722d);
    }

    public void f(long j10) {
        this.f9725g = fb.h.a(j10);
    }

    public void g(short s10) {
        this.f9722d = fb.h.d(s10);
    }

    public void h(short s10) {
        this.f9723e = fb.h.d(s10);
    }

    public void i(int i10) {
        this.f9724f = fb.h.f(i10);
    }
}
