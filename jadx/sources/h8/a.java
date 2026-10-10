package h8;

import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a implements c, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    io.reactivex.rxjava3.internal.util.d<c> f10888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile boolean f10889b;

    @Override // h8.d
    public boolean b(c cVar) {
        Objects.requireNonNull(cVar, "disposable is null");
        if (!this.f10889b) {
            synchronized (this) {
                try {
                    if (!this.f10889b) {
                        io.reactivex.rxjava3.internal.util.d<c> dVar = this.f10888a;
                        if (dVar == null) {
                            dVar = new io.reactivex.rxjava3.internal.util.d<>();
                            this.f10888a = dVar;
                        }
                        dVar.a(cVar);
                        return true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        cVar.dispose();
        return false;
    }

    @Override // h8.d
    public boolean c(c cVar) {
        Objects.requireNonNull(cVar, "disposable is null");
        if (this.f10889b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.f10889b) {
                    return false;
                }
                io.reactivex.rxjava3.internal.util.d<c> dVar = this.f10888a;
                if (dVar != null && dVar.e(cVar)) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void d(io.reactivex.rxjava3.internal.util.d<c> dVar) {
        if (dVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : dVar.b()) {
            if (obj instanceof c) {
                try {
                    ((c) obj).dispose();
                } catch (Throwable th) {
                    i8.b.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() != 1) {
                throw new i8.a(arrayList);
            }
            throw io.reactivex.rxjava3.internal.util.b.d((Throwable) arrayList.get(0));
        }
    }

    @Override // h8.c
    public void dispose() {
        if (this.f10889b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f10889b) {
                    return;
                }
                this.f10889b = true;
                io.reactivex.rxjava3.internal.util.d<c> dVar = this.f10888a;
                this.f10888a = null;
                d(dVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // h8.c
    public boolean f() {
        return this.f10889b;
    }

    @Override // h8.d
    public boolean a(c cVar) {
        if (c(cVar)) {
            cVar.dispose();
            return true;
        }
        return false;
    }
}
