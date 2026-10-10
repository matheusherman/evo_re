package io.reactivex.rxjava3.internal.observers;

import g8.g;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c<T> extends AtomicReference<h8.c> implements g<T>, h8.c {
    private static final long serialVersionUID = -7251123623727029452L;
    final j8.a onComplete;
    final j8.c<? super Throwable> onError;
    final j8.c<? super T> onNext;
    final j8.c<? super h8.c> onSubscribe;

    public c(j8.c<? super T> cVar, j8.c<? super Throwable> cVar2, j8.a aVar, j8.c<? super h8.c> cVar3) {
        this.onNext = cVar;
        this.onError = cVar2;
        this.onComplete = aVar;
        this.onSubscribe = cVar3;
    }

    @Override // g8.g
    public void a(T t10) {
        if (!f()) {
            try {
                this.onNext.accept(t10);
            } catch (Throwable th) {
                i8.b.b(th);
                get().dispose();
                onError(th);
            }
        }
    }

    @Override // g8.g
    public void b() {
        if (!f()) {
            lazySet(k8.a.DISPOSED);
            try {
                this.onComplete.run();
            } catch (Throwable th) {
                i8.b.b(th);
                p8.a.l(th);
            }
        }
    }

    @Override // g8.g
    public void d(h8.c cVar) {
        if (k8.a.l(this, cVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                i8.b.b(th);
                cVar.dispose();
                onError(th);
            }
        }
    }

    @Override // h8.c
    public void dispose() {
        k8.a.a(this);
    }

    @Override // h8.c
    public boolean f() {
        if (get() == k8.a.DISPOSED) {
            return true;
        }
        return false;
    }

    @Override // g8.g
    public void onError(Throwable th) {
        if (!f()) {
            lazySet(k8.a.DISPOSED);
            try {
                this.onError.accept(th);
                return;
            } catch (Throwable th2) {
                i8.b.b(th2);
                p8.a.l(new i8.a(th, th2));
                return;
            }
        }
        p8.a.l(th);
    }
}
