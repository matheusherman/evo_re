package ke;

import oe.h;
import oe.i;
import oe.k;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f12249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private oe.b f12250e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private i f12251f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private h f12252g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private oe.a f12253h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private i[] f12254i;

    public b(int i10, int i11, oe.b bVar, i iVar, oe.a aVar, h hVar, String str) {
        super(true, str);
        this.f12248c = i10;
        this.f12249d = i11;
        this.f12250e = bVar;
        this.f12251f = iVar;
        this.f12253h = aVar;
        this.f12252g = hVar;
        this.f12254i = new k(bVar, iVar).c();
    }

    public b(int i10, int i11, oe.b bVar, i iVar, h hVar, String str) {
        this(i10, i11, bVar, iVar, oe.c.a(bVar, iVar), hVar, str);
    }

    public oe.b b() {
        return this.f12250e;
    }

    public i c() {
        return this.f12251f;
    }

    public oe.a d() {
        return this.f12253h;
    }

    public int e() {
        return this.f12249d;
    }

    public int f() {
        return this.f12248c;
    }

    public h g() {
        return this.f12252g;
    }
}
