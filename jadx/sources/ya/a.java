package ya;

import bb.d;
import bb.e;
import bb.h;
import db.i;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import za.c;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public abstract class a implements Closeable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Locale f22530j = Locale.US;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f22531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private i f22532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Set<Locale> f22533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f22534d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f22535e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private za.a f22536f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<c> f22537g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<Object> f22538h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Locale f22539i = f22530j;

    public abstract byte[] a(String str);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f22538h = null;
        this.f22532b = null;
        this.f22537g = null;
    }

    private void c() {
        if (this.f22534d) {
            return;
        }
        d();
        bb.i iVar = new bb.i();
        bb.a aVar = new bb.a(this.f22532b, this.f22539i);
        d dVar = new d(iVar, aVar);
        byte[] bArrA = a("AndroidManifest.xml");
        if (bArrA == null) {
            throw new ab.a("Manifest file not found");
        }
        f(bArrA, dVar);
        this.f22535e = iVar.f();
        this.f22536f = aVar.e();
        this.f22537g = aVar.f();
        this.f22534d = true;
    }

    private void d() {
        if (this.f22531a) {
            return;
        }
        this.f22531a = true;
        byte[] bArrA = a("resources.arsc");
        if (bArrA == null) {
            this.f22532b = new i();
            this.f22533c = Collections.EMPTY_SET;
        } else {
            e eVar = new e(ByteBuffer.wrap(bArrA));
            eVar.c();
            this.f22532b = eVar.b();
            this.f22533c = eVar.a();
        }
    }

    private void f(byte[] bArr, h hVar) {
        d();
        bb.c cVar = new bb.c(ByteBuffer.wrap(bArr), this.f22532b);
        cVar.k(this.f22539i);
        cVar.l(hVar);
        cVar.b();
    }

    public String b() {
        c();
        return this.f22535e;
    }
}
