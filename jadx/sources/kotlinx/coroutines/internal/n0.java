package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.internal.o0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0004j\u0002`\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0082\u0010¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0082\u0010¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\t\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\t\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001a\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0004\b\u001a\u0010\u0015J\u0017\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\bH\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\u001e\u0010\u001fR \u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010 R$\u0010$\u001a\u00020\b2\u0006\u0010!\u001a\u00020\b8F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b\u0011\u0010\fR\u0011\u0010'\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u000b\u0010)\u001a\u00020(8\u0002X\u0082\u0004¨\u0006*"}, d2 = {"Lkotlinx/coroutines/internal/n0;", "Lkotlinx/coroutines/internal/o0;", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "<init>", "()V", "", "i", "Lr8/z;", "l", "(I)V", "k", "", "f", "()[Lkotlinx/coroutines/internal/o0;", "j", "m", "(II)V", "e", "()Lkotlinx/coroutines/internal/o0;", "node", "", "g", "(Lkotlinx/coroutines/internal/o0;)Z", "b", "index", "h", "(I)Lkotlinx/coroutines/internal/o0;", "a", "(Lkotlinx/coroutines/internal/o0;)V", "[Lkotlinx/coroutines/internal/o0;", "value", "c", "()I", "size", "d", "()Z", "isEmpty", "Lkotlinx/atomicfu/AtomicInt;", "_size", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class n0<T extends o0 & Comparable<? super T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f14853b = AtomicIntegerFieldUpdater.newUpdater(n0.class, "_size");
    private volatile int _size;
    private T[] a;

    public final T e() {
        T t10;
        synchronized (this) {
            t10 = (T) b();
        }
        return t10;
    }

    public final boolean g(T node) {
        boolean z10;
        synchronized (this) {
            if (node.j() == null) {
                z10 = false;
            } else {
                h(node.getIndex());
                z10 = true;
            }
        }
        return z10;
    }

    public final T i() {
        T t10;
        synchronized (this) {
            t10 = c() > 0 ? (T) h(0) : null;
        }
        return t10;
    }

    private final T[] f() {
        T[] tArr = this.a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new o0[4];
            this.a = tArr2;
            return tArr2;
        }
        if (c() < tArr.length) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, c() * 2);
        kotlin.jvm.internal.m.e(objArrCopyOf, "copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((o0[]) objArrCopyOf);
        this.a = tArr3;
        return tArr3;
    }

    private final void j(int i10) {
        f14853b.set(this, i10);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002b  */
    private final void k(int i10) {
        while (true) {
            int i11 = i10 * 2;
            int i12 = i11 + 1;
            if (i12 >= c()) {
                return;
            }
            T[] tArr = this.a;
            kotlin.jvm.internal.m.c(tArr);
            int i13 = i11 + 2;
            if (i13 < c()) {
                T t10 = tArr[i13];
                kotlin.jvm.internal.m.c(t10);
                T t11 = tArr[i12];
                kotlin.jvm.internal.m.c(t11);
                if (((Comparable) t10).compareTo(t11) >= 0) {
                    i13 = i12;
                }
            } else {
                i13 = i12;
            }
            T t12 = tArr[i10];
            kotlin.jvm.internal.m.c(t12);
            T t13 = tArr[i13];
            kotlin.jvm.internal.m.c(t13);
            if (((Comparable) t12).compareTo(t13) <= 0) {
                return;
            }
            m(i10, i13);
            i10 = i13;
        }
    }

    private final void l(int i10) {
        while (i10 > 0) {
            T[] tArr = this.a;
            kotlin.jvm.internal.m.c(tArr);
            int i11 = (i10 - 1) / 2;
            T t10 = tArr[i11];
            kotlin.jvm.internal.m.c(t10);
            T t11 = tArr[i10];
            kotlin.jvm.internal.m.c(t11);
            if (((Comparable) t10).compareTo(t11) <= 0) {
                return;
            }
            m(i10, i11);
            i10 = i11;
        }
    }

    private final void m(int i10, int j10) {
        T[] tArr = this.a;
        kotlin.jvm.internal.m.c(tArr);
        T t10 = tArr[j10];
        kotlin.jvm.internal.m.c(t10);
        T t11 = tArr[i10];
        kotlin.jvm.internal.m.c(t11);
        tArr[i10] = t10;
        tArr[j10] = t11;
        t10.setIndex(i10);
        t11.setIndex(j10);
    }

    public final T b() {
        T[] tArr = this.a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int c() {
        return f14853b.get(this);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x003a  */
    public final T h(int index) {
        T[] tArr = this.a;
        kotlin.jvm.internal.m.c(tArr);
        j(c() - 1);
        if (index < c()) {
            m(index, c());
            int i10 = (index - 1) / 2;
            if (index > 0) {
                T t10 = tArr[index];
                kotlin.jvm.internal.m.c(t10);
                T t11 = tArr[i10];
                kotlin.jvm.internal.m.c(t11);
                if (((Comparable) t10).compareTo(t11) < 0) {
                    m(index, i10);
                    l(i10);
                } else {
                    k(index);
                }
            } else {
                k(index);
            }
        }
        T t12 = tArr[c()];
        kotlin.jvm.internal.m.c(t12);
        t12.a(null);
        t12.setIndex(-1);
        tArr[c()] = null;
        return t12;
    }

    public final void a(T node) {
        node.a(this);
        o0[] o0VarArrF = f();
        int iC = c();
        j(iC + 1);
        o0VarArrF[iC] = node;
        node.setIndex(iC);
        l(iC);
    }

    public final boolean d() {
        if (c() == 0) {
            return true;
        }
        return false;
    }
}
