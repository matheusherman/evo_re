package com.live.evo.util;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g8.d<? super Integer> f7242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h8.c f7243b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g8.c<Integer> f7244c;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(g8.d dVar) {
        this.f7242a = dVar;
    }

    public void c() {
        this.f7242a.a(1);
    }

    public void d(j8.c<Integer> cVar) {
        this.f7243b = this.f7244c.r(cVar);
    }

    public void e() {
        h8.c cVar = this.f7243b;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    public i1(int i10) {
        this.f7244c = g8.c.g(new g8.e() { // from class: com.live.evo.util.h1
            @Override // g8.e
            public final void a(g8.d dVar) {
                this.f7240a.b(dVar);
            }
        }).v(q8.a.b()).n(q8.a.b()).w(i10, TimeUnit.MILLISECONDS);
    }
}
