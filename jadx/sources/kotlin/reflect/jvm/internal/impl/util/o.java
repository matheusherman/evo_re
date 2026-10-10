package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class o<T> extends c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f14429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14430b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a implements Iterator<T>, d9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f14431a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ o<T> f14432b;

        a(o<T> oVar) {
            this.f14432b = oVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f14431a;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f14431a) {
                throw new NoSuchElementException();
            }
            this.f14431a = false;
            return this.f14432b.i();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.c
    public int e() {
        return 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(T value, int i10) {
        super(null);
        kotlin.jvm.internal.m.f(value, "value");
        this.f14429a = value;
        this.f14430b = i10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.c
    public void f(int i10, T value) {
        kotlin.jvm.internal.m.f(value, "value");
        throw new IllegalStateException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.c
    public T get(int i10) {
        if (i10 == this.f14430b) {
            return this.f14429a;
        }
        return null;
    }

    public final int h() {
        return this.f14430b;
    }

    public final T i() {
        return this.f14429a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.c, java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this);
    }
}
