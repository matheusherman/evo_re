package k8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c implements h8.c, h8.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<h8.c> f12174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile boolean f12175b;

    @Override // h8.d
    public boolean b(h8.c cVar) {
        Objects.requireNonNull(cVar, "d is null");
        if (!this.f12175b) {
            synchronized (this) {
                try {
                    if (!this.f12175b) {
                        List linkedList = this.f12174a;
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            this.f12174a = linkedList;
                        }
                        linkedList.add(cVar);
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
    public boolean c(h8.c cVar) {
        Objects.requireNonNull(cVar, "Disposable item is null");
        if (this.f12175b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.f12175b) {
                    return false;
                }
                List<h8.c> list = this.f12174a;
                if (list != null && list.remove(cVar)) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void d(List<h8.c> list) {
        if (list == null) {
            return;
        }
        Iterator<h8.c> it = list.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            try {
                it.next().dispose();
            } catch (Throwable th) {
                i8.b.b(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
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
        if (this.f12175b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f12175b) {
                    return;
                }
                this.f12175b = true;
                List<h8.c> list = this.f12174a;
                this.f12174a = null;
                d(list);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // h8.c
    public boolean f() {
        return this.f12175b;
    }

    @Override // h8.d
    public boolean a(h8.c cVar) {
        if (c(cVar)) {
            cVar.dispose();
            return true;
        }
        return false;
    }
}
