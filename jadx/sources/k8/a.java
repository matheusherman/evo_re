package k8;

import androidx.p000lifecycle.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public enum a implements h8.c {
    DISPOSED;

    public static boolean m(h8.c cVar, h8.c cVar2) {
        if (cVar2 == null) {
            p8.a.l(new NullPointerException("next is null"));
            return false;
        }
        if (cVar == null) {
            return true;
        }
        cVar2.dispose();
        k();
        return false;
    }

    @Override // h8.c
    public boolean f() {
        return true;
    }

    public static boolean i(h8.c cVar) {
        return cVar == DISPOSED;
    }

    public static void k() {
        p8.a.l(new i8.d("Disposable already set!"));
    }

    public static boolean l(AtomicReference<h8.c> atomicReference, h8.c cVar) {
        Objects.requireNonNull(cVar, "d is null");
        if (h.a(atomicReference, null, cVar)) {
            return true;
        }
        cVar.dispose();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        k();
        return false;
    }

    public static boolean a(AtomicReference<h8.c> atomicReference) {
        h8.c andSet;
        h8.c cVar = atomicReference.get();
        a aVar = DISPOSED;
        if (cVar != aVar && (andSet = atomicReference.getAndSet(aVar)) != aVar) {
            if (andSet != null) {
                andSet.dispose();
                return true;
            }
            return true;
        }
        return false;
    }

    public static boolean j(AtomicReference<h8.c> atomicReference, h8.c cVar) {
        h8.c cVar2;
        do {
            cVar2 = atomicReference.get();
            if (cVar2 == DISPOSED) {
                if (cVar != null) {
                    cVar.dispose();
                    return false;
                }
                return false;
            }
        } while (!h.a(atomicReference, cVar2, cVar));
        return true;
    }

    @Override // h8.c
    public void dispose() {
    }
}
