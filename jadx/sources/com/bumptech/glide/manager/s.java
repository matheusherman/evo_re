package com.bumptech.glide.manager;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<a0.e> f1434a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<a0.e> f1435b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1436c;

    public boolean a(@Nullable a0.e eVar) {
        boolean z10 = true;
        if (eVar == null) {
            return true;
        }
        boolean zRemove = this.f1434a.remove(eVar);
        if (!this.f1435b.remove(eVar) && !zRemove) {
            z10 = false;
        }
        if (z10) {
            eVar.clear();
        }
        return z10;
    }

    public void c() {
        this.f1436c = true;
        for (a0.e eVar : e0.l.j(this.f1434a)) {
            if (eVar.isRunning() || eVar.j()) {
                eVar.clear();
                this.f1435b.add(eVar);
            }
        }
    }

    public void d() {
        this.f1436c = true;
        for (a0.e eVar : e0.l.j(this.f1434a)) {
            if (eVar.isRunning()) {
                eVar.pause();
                this.f1435b.add(eVar);
            }
        }
    }

    public void f() {
        this.f1436c = false;
        for (a0.e eVar : e0.l.j(this.f1434a)) {
            if (!eVar.j() && !eVar.isRunning()) {
                eVar.h();
            }
        }
        this.f1435b.clear();
    }

    public void b() {
        Iterator it = e0.l.j(this.f1434a).iterator();
        while (it.hasNext()) {
            a((a0.e) it.next());
        }
        this.f1435b.clear();
    }

    public void e() {
        for (a0.e eVar : e0.l.j(this.f1434a)) {
            if (!eVar.j() && !eVar.g()) {
                eVar.clear();
                if (this.f1436c) {
                    this.f1435b.add(eVar);
                } else {
                    eVar.h();
                }
            }
        }
    }

    public void g(@NonNull a0.e eVar) {
        this.f1434a.add(eVar);
        if (!this.f1436c) {
            eVar.h();
            return;
        }
        eVar.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f1435b.add(eVar);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f1434a.size() + ", isPaused=" + this.f1436c + "}";
    }
}
