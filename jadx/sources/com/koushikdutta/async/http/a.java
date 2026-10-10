package com.koushikdutta.async.http;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static a f5075f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final List<b> f5076a = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    d f5077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    e f5078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    i f5079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    com.koushikdutta.async.f f5080e;

    public static a a() {
        if (f5075f == null) {
            f5075f = new a(com.koushikdutta.async.f.g());
        }
        return f5075f;
    }

    public d b() {
        return this.f5077b;
    }

    public void c(b bVar) {
        this.f5076a.add(0, bVar);
    }

    public a(com.koushikdutta.async.f fVar) {
        this.f5080e = fVar;
        e eVar = new e(this);
        this.f5078c = eVar;
        c(eVar);
        d dVar = new d(this);
        this.f5077b = dVar;
        c(dVar);
        i iVar = new i();
        this.f5079d = iVar;
        c(iVar);
        this.f5077b.a(new n());
    }
}
