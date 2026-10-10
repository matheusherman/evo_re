package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class x implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<b0.i<?>> f1471a = Collections.newSetFromMap(new WeakHashMap());

    public void c() {
        this.f1471a.clear();
    }

    @Override // com.bumptech.glide.manager.m
    public void d() {
        Iterator it = e0.l.j(this.f1471a).iterator();
        while (it.hasNext()) {
            ((b0.i) it.next()).d();
        }
    }

    @NonNull
    public List<b0.i<?>> e() {
        return e0.l.j(this.f1471a);
    }

    public void f(@NonNull b0.i<?> iVar) {
        this.f1471a.add(iVar);
    }

    @Override // com.bumptech.glide.manager.m
    public void h() {
        Iterator it = e0.l.j(this.f1471a).iterator();
        while (it.hasNext()) {
            ((b0.i) it.next()).h();
        }
    }

    public void m(@NonNull b0.i<?> iVar) {
        this.f1471a.remove(iVar);
    }

    @Override // com.bumptech.glide.manager.m
    public void onStart() {
        Iterator it = e0.l.j(this.f1471a).iterator();
        while (it.hasNext()) {
            ((b0.i) it.next()).onStart();
        }
    }
}
