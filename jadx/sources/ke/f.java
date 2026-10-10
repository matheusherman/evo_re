package ke;

import oe.h;
import oe.i;
import oe.k;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f12258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private oe.b f12260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private i f12261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private oe.a f12262f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private h f12263g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private h f12264h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private oe.a f12265i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private i[] f12266j;

    public f(int i10, int i11, oe.b bVar, i iVar, h hVar, h hVar2, oe.a aVar) {
        super(true, null);
        this.f12259c = i11;
        this.f12258b = i10;
        this.f12260d = bVar;
        this.f12261e = iVar;
        this.f12262f = aVar;
        this.f12263g = hVar;
        this.f12264h = hVar2;
        this.f12265i = oe.c.a(bVar, iVar);
        this.f12266j = new k(bVar, iVar).c();
    }

    public oe.b a() {
        return this.f12260d;
    }

    public i b() {
        return this.f12261e;
    }

    public int c() {
        return this.f12259c;
    }

    public int d() {
        return this.f12258b;
    }

    public h e() {
        return this.f12263g;
    }

    public h f() {
        return this.f12264h;
    }

    public oe.a g() {
        return this.f12262f;
    }
}
