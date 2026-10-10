package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class b<T> extends s0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private EnumC0048b f4584a = EnumC0048b.NOT_READY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private T f4585b;

    /* JADX INFO: renamed from: com.google.common.collect.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private enum EnumC0048b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    protected abstract T c();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4586a;

        static {
            int[] iArr = new int[EnumC0048b.values().length];
            f4586a = iArr;
            try {
                iArr[EnumC0048b.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4586a[EnumC0048b.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private boolean e() {
        this.f4584a = EnumC0048b.FAILED;
        this.f4585b = c();
        if (this.f4584a == EnumC0048b.DONE) {
            return false;
        }
        this.f4584a = EnumC0048b.READY;
        return true;
    }

    protected final T d() {
        this.f4584a = EnumC0048b.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        com.google.common.base.m.n(this.f4584a != EnumC0048b.FAILED);
        int i10 = a.f4586a[this.f4584a.ordinal()];
        if (i10 == 1) {
            return false;
        }
        if (i10 != 2) {
            return e();
        }
        return true;
    }

    protected b() {
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.f4584a = EnumC0048b.NOT_READY;
            T t10 = (T) e0.a(this.f4585b);
            this.f4585b = null;
            return t10;
        }
        throw new NoSuchElementException();
    }
}
