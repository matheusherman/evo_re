package ta;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\tJ\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\u0015\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096@¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001f\u001a\u00060\u001bj\u0002`\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010#R*\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lta/i;", ExifInterface.GPS_DIRECTION_TRUE, "Lta/j;", "", "Lv8/f;", "Lr8/z;", "<init>", "()V", "k", "()Ljava/lang/Object;", "", "i", "()Ljava/lang/Throwable;", "", "hasNext", "()Z", "next", "value", "c", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "iterator", "d", "(Ljava/util/Iterator;Lv8/f;)Ljava/lang/Object;", "Lr8/q;", "result", "resumeWith", "(Ljava/lang/Object;)V", "", "Lkotlin/sequences/State;", "a", "I", "state", "b", "Ljava/lang/Object;", "nextValue", "Ljava/util/Iterator;", "nextIterator", "Lv8/f;", "getNextStep", "()Lv8/f;", "l", "(Lv8/f;)V", "nextStep", "Lv8/j;", "getContext", "()Lv8/j;", "context", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class i<T> extends j<T> implements Iterator<T>, v8.f<z>, d9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int state;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private T nextValue;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Iterator<? extends T> nextIterator;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private v8.f<? super z> nextStep;

    private final Throwable i() {
        int i10 = this.state;
        if (i10 == 4) {
            return new NoSuchElementException();
        }
        if (i10 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.state);
    }

    @Override // ta.j
    public Object c(T t10, v8.f<? super z> fVar) {
        this.nextValue = t10;
        this.state = 3;
        this.nextStep = fVar;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        if (objC == kotlin.coroutines.intrinsics.b.c()) {
            kotlin.coroutines.jvm.internal.h.c(fVar);
        }
        return objC == kotlin.coroutines.intrinsics.b.c() ? objC : z.f17874a;
    }

    @Override // v8.f
    public v8.j getContext() {
        return v8.k.f19724a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i10 = this.state;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2 || i10 == 3) {
                        return true;
                    }
                    if (i10 == 4) {
                        return false;
                    }
                    throw i();
                }
                Iterator<? extends T> it = this.nextIterator;
                kotlin.jvm.internal.m.c(it);
                if (it.hasNext()) {
                    this.state = 2;
                    return true;
                }
                this.nextIterator = null;
            }
            this.state = 5;
            v8.f<? super z> fVar = this.nextStep;
            kotlin.jvm.internal.m.c(fVar);
            this.nextStep = null;
            fVar.resumeWith(r8.q.a(z.f17874a));
        }
    }

    public final void l(v8.f<? super z> fVar) {
        this.nextStep = fVar;
    }

    @Override // java.util.Iterator
    public T next() throws Throwable {
        int i10 = this.state;
        if (i10 == 0 || i10 == 1) {
            return k();
        }
        if (i10 == 2) {
            this.state = 1;
            Iterator<? extends T> it = this.nextIterator;
            kotlin.jvm.internal.m.c(it);
            return it.next();
        }
        if (i10 != 3) {
            throw i();
        }
        this.state = 0;
        T t10 = this.nextValue;
        this.nextValue = null;
        return t10;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private final T k() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // ta.j
    public Object d(Iterator<? extends T> it, v8.f<? super z> fVar) {
        if (!it.hasNext()) {
            return z.f17874a;
        }
        this.nextIterator = it;
        this.state = 2;
        this.nextStep = fVar;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        if (objC == kotlin.coroutines.intrinsics.b.c()) {
            kotlin.coroutines.jvm.internal.h.c(fVar);
        }
        if (objC == kotlin.coroutines.intrinsics.b.c()) {
            return objC;
        }
        return z.f17874a;
    }

    @Override // v8.f
    public void resumeWith(Object result) {
        r8.r.b(result);
        this.state = 4;
    }
}
