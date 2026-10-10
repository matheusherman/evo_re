package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<m> f1405a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1407c;

    void c() {
        this.f1407c = true;
        Iterator it = e0.l.j(this.f1405a).iterator();
        while (it.hasNext()) {
            ((m) it.next()).d();
        }
    }

    void d() {
        this.f1406b = true;
        Iterator it = e0.l.j(this.f1405a).iterator();
        while (it.hasNext()) {
            ((m) it.next()).onStart();
        }
    }

    void e() {
        this.f1406b = false;
        Iterator it = e0.l.j(this.f1405a).iterator();
        while (it.hasNext()) {
            ((m) it.next()).h();
        }
    }

    @Override // com.bumptech.glide.manager.l
    public void a(@NonNull m mVar) {
        this.f1405a.add(mVar);
        if (this.f1407c) {
            mVar.d();
        } else if (this.f1406b) {
            mVar.onStart();
        } else {
            mVar.h();
        }
    }

    @Override // com.bumptech.glide.manager.l
    public void b(@NonNull m mVar) {
        this.f1405a.remove(mVar);
    }

    a() {
    }
}
