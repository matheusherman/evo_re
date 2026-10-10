package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
abstract class a<E> extends t0<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4583b;

    protected abstract E c(int i10);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f4583b < this.f4582a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f4583b > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f4583b;
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f4583b - 1;
    }

    protected a(int i10, int i11) {
        com.google.common.base.m.k(i11, i10);
        this.f4582a = i10;
        this.f4583b = i11;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int i10 = this.f4583b;
            this.f4583b = i10 + 1;
            return c(i10);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i10 = this.f4583b - 1;
            this.f4583b = i10;
            return c(i10);
        }
        throw new NoSuchElementException();
    }
}
