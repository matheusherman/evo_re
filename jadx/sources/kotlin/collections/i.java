package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u001e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0007\u0018\u0000 V*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001KB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u000fJ%\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u001f\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001f\u0010\u001bJ\u000f\u0010 \u001a\u00020\tH\u0002¢\u0006\u0004\b \u0010\u0007J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00028\u0000¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b&\u0010%J\r\u0010'\u001a\u00028\u0000¢\u0006\u0004\b'\u0010%J\u000f\u0010(\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b(\u0010%J\u0015\u0010*\u001a\u00020\t2\u0006\u0010)\u001a\u00028\u0000¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\u00020\t2\u0006\u0010)\u001a\u00028\u0000¢\u0006\u0004\b,\u0010+J\r\u0010-\u001a\u00028\u0000¢\u0006\u0004\b-\u0010%J\u000f\u0010.\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b.\u0010%J\r\u0010/\u001a\u00028\u0000¢\u0006\u0004\b/\u0010%J\u0017\u00100\u001a\u00020!2\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0004\b0\u00101J\u001f\u00100\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0004\b0\u00102J\u001d\u00103\u001a\u00020!2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016¢\u0006\u0004\b3\u00104J%\u00103\u001a\u00020!2\u0006\u0010\r\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016¢\u0006\u0004\b3\u00105J\u0018\u00106\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b6\u00107J \u00108\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010)\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b8\u00109J\u0018\u0010:\u001a\u00020!2\u0006\u0010)\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b:\u00101J\u0017\u0010;\u001a\u00020\u00032\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\u00020\u00032\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0004\b=\u0010<J\u0017\u0010>\u001a\u00020!2\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0004\b>\u00101J\u0017\u0010?\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b?\u00107J\u001d\u0010@\u001a\u00020!2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016¢\u0006\u0004\b@\u00104J\u001d\u0010A\u001a\u00020!2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016¢\u0006\u0004\bA\u00104J\u000f\u0010B\u001a\u00020\tH\u0016¢\u0006\u0004\bB\u0010\u0007J)\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00010D\"\u0004\b\u0001\u0010C2\f\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00010DH\u0016¢\u0006\u0004\bF\u0010GJ\u0017\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010H0DH\u0016¢\u0006\u0004\bF\u0010IJ\u001f\u0010J\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0014¢\u0006\u0004\bJ\u0010\u001bR\u0016\u0010M\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u001e\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010H0D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR$\u0010U\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020\u00038\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\bR\u0010L\u001a\u0004\bS\u0010T¨\u0006W"}, d2 = {"Lkotlin/collections/i;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/f;", "", "initialCapacity", "<init>", "(I)V", "()V", "minCapacity", "Lr8/z;", "m", "newCapacity", "i", "index", "t", "(I)I", "r", "o", "k", "internalIndex", "", "elements", "h", "(ILjava/util/Collection;)V", "fromIndex", "toIndex", "w", "(II)V", "x", "internalFromIndex", "internalToIndex", "s", "u", "", "isEmpty", "()Z", "first", "()Ljava/lang/Object;", "n", "last", "q", "element", "addFirst", "(Ljava/lang/Object;)V", "addLast", "removeFirst", "v", "removeLast", "add", "(Ljava/lang/Object;)Z", "(ILjava/lang/Object;)V", "addAll", "(Ljava/util/Collection;)Z", "(ILjava/util/Collection;)Z", "get", "(I)Ljava/lang/Object;", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "contains", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "remove", "f", "removeAll", "retainAll", "clear", ExifInterface.GPS_DIRECTION_TRUE, "", "array", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "", "()[Ljava/lang/Object;", "removeRange", "a", "I", "head", "b", "[Ljava/lang/Object;", "elementData", "value", "c", "e", "()I", "size", "d", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class i<E> extends f<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object[] f12300e = new Object[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int head;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Object[] elementData;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int size;

    public i(int i10) {
        Object[] objArr;
        if (i10 == 0) {
            objArr = f12300e;
        } else {
            if (i10 <= 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + i10);
            }
            objArr = new Object[i10];
        }
        this.elementData = objArr;
    }

    private final void s(int internalFromIndex, int internalToIndex) {
        if (internalFromIndex < internalToIndex) {
            m.r(this.elementData, null, internalFromIndex, internalToIndex);
            return;
        }
        Object[] objArr = this.elementData;
        m.r(objArr, null, internalFromIndex, objArr.length);
        m.r(this.elementData, null, 0, internalToIndex);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E element) {
        addLast(element);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        kotlin.jvm.internal.m.f(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        u();
        m(size() + elements.size());
        h(t(this.head + size()), elements);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.m.f(array, "array");
        if (array.length < size()) {
            array = (T[]) k.a(array, size());
        }
        T[] tArr = array;
        int iT = t(this.head + size());
        int i10 = this.head;
        if (i10 < iT) {
            m.n(this.elementData, tArr, 0, i10, iT, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr = this.elementData;
            m.i(objArr, tArr, 0, this.head, objArr.length);
            Object[] objArr2 = this.elementData;
            m.i(objArr2, tArr, objArr2.length - this.head, 0, iT);
        }
        return (T[]) s.f(size(), tArr);
    }

    private final void i(int newCapacity) {
        Object[] objArr = new Object[newCapacity];
        Object[] objArr2 = this.elementData;
        m.i(objArr2, objArr, 0, this.head, objArr2.length);
        Object[] objArr3 = this.elementData;
        int length = objArr3.length;
        int i10 = this.head;
        m.i(objArr3, objArr, length - i10, 0, i10);
        this.head = 0;
        this.elementData = objArr;
    }

    private final int k(int index) {
        return index == 0 ? o.R(this.elementData) : index - 1;
    }

    private final void m(int minCapacity) {
        if (minCapacity < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.elementData;
        if (minCapacity <= objArr.length) {
            return;
        }
        if (objArr == f12300e) {
            this.elementData = new Object[h9.f.c(minCapacity, 10)];
        } else {
            i(d.INSTANCE.e(objArr.length, minCapacity));
        }
    }

    private final int o(int index) {
        if (index == o.R(this.elementData)) {
            return 0;
        }
        return index + 1;
    }

    private final int r(int index) {
        return index < 0 ? index + this.elementData.length : index;
    }

    private final int t(int index) {
        Object[] objArr = this.elementData;
        return index >= objArr.length ? index - objArr.length : index;
    }

    private final void u() {
        ((AbstractList) this).modCount++;
    }

    private final void w(int fromIndex, int toIndex) {
        int iT = t(this.head + (fromIndex - 1));
        int iT2 = t(this.head + (toIndex - 1));
        while (fromIndex > 0) {
            int i10 = iT + 1;
            int iMin = Math.min(fromIndex, Math.min(i10, iT2 + 1));
            Object[] objArr = this.elementData;
            int i11 = iT2 - iMin;
            int i12 = iT - iMin;
            m.i(objArr, objArr, i11 + 1, i12 + 1, i10);
            iT = r(i12);
            iT2 = r(i11);
            fromIndex -= iMin;
        }
    }

    private final void x(int fromIndex, int toIndex) {
        int iT = t(this.head + toIndex);
        int iT2 = t(this.head + fromIndex);
        int size = size();
        while (true) {
            size -= toIndex;
            if (size <= 0) {
                return;
            }
            Object[] objArr = this.elementData;
            toIndex = Math.min(size, Math.min(objArr.length - iT, objArr.length - iT2));
            Object[] objArr2 = this.elementData;
            int i10 = iT + toIndex;
            m.i(objArr2, objArr2, iT2, iT, i10);
            iT = t(i10);
            iT2 = t(iT2 + toIndex);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int index, E element) {
        d.INSTANCE.c(index, size());
        if (index == size()) {
            addLast(element);
            return;
        }
        if (index == 0) {
            addFirst(element);
            return;
        }
        u();
        m(size() + 1);
        int iT = t(this.head + index);
        if (index < ((size() + 1) >> 1)) {
            int iK = k(iT);
            int iK2 = k(this.head);
            int i10 = this.head;
            if (iK >= i10) {
                Object[] objArr = this.elementData;
                objArr[iK2] = objArr[i10];
                m.i(objArr, objArr, i10, i10 + 1, iK + 1);
            } else {
                Object[] objArr2 = this.elementData;
                m.i(objArr2, objArr2, i10 - 1, i10, objArr2.length);
                Object[] objArr3 = this.elementData;
                objArr3[objArr3.length - 1] = objArr3[0];
                m.i(objArr3, objArr3, 0, 1, iK + 1);
            }
            this.elementData[iK] = element;
            this.head = iK2;
        } else {
            int iT2 = t(this.head + size());
            if (iT < iT2) {
                Object[] objArr4 = this.elementData;
                m.i(objArr4, objArr4, iT + 1, iT, iT2);
            } else {
                Object[] objArr5 = this.elementData;
                m.i(objArr5, objArr5, 1, 0, iT2);
                Object[] objArr6 = this.elementData;
                objArr6[0] = objArr6[objArr6.length - 1];
                m.i(objArr6, objArr6, iT + 1, iT, objArr6.length - 1);
            }
            this.elementData[iT] = element;
        }
        this.size = size() + 1;
    }

    @Override // kotlin.collections.f
    /* JADX INFO: renamed from: e, reason: from getter */
    public int getSize() {
        return this.size;
    }

    @Override // kotlin.collections.f
    public E f(int index) {
        d.INSTANCE.b(index, size());
        if (index == t.n(this)) {
            return removeLast();
        }
        if (index == 0) {
            return removeFirst();
        }
        u();
        int iT = t(this.head + index);
        E e10 = (E) this.elementData[iT];
        if (index < (size() >> 1)) {
            int i10 = this.head;
            if (iT >= i10) {
                Object[] objArr = this.elementData;
                m.i(objArr, objArr, i10 + 1, i10, iT);
            } else {
                Object[] objArr2 = this.elementData;
                m.i(objArr2, objArr2, 1, 0, iT);
                Object[] objArr3 = this.elementData;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i11 = this.head;
                m.i(objArr3, objArr3, i11 + 1, i11, objArr3.length - 1);
            }
            Object[] objArr4 = this.elementData;
            int i12 = this.head;
            objArr4[i12] = null;
            this.head = o(i12);
        } else {
            int iT2 = t(this.head + t.n(this));
            if (iT <= iT2) {
                Object[] objArr5 = this.elementData;
                m.i(objArr5, objArr5, iT, iT + 1, iT2 + 1);
            } else {
                Object[] objArr6 = this.elementData;
                m.i(objArr6, objArr6, iT, iT + 1, objArr6.length);
                Object[] objArr7 = this.elementData;
                objArr7[objArr7.length - 1] = objArr7[0];
                m.i(objArr7, objArr7, 0, 1, iT2 + 1);
            }
            this.elementData[iT2] = null;
        }
        this.size = size() - 1;
        return e10;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int index) {
        d.INSTANCE.b(index, size());
        return (E) this.elementData[t(this.head + index)];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object element) {
        int i10;
        int iT = t(this.head + size());
        int length = this.head;
        if (length < iT) {
            while (length < iT) {
                if (kotlin.jvm.internal.m.a(element, this.elementData[length])) {
                    i10 = this.head;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iT) {
            return -1;
        }
        int length2 = this.elementData.length;
        while (length < length2) {
            if (kotlin.jvm.internal.m.a(element, this.elementData[length])) {
                i10 = this.head;
            } else {
                length++;
            }
        }
        for (int i11 = 0; i11 < iT; i11++) {
            if (kotlin.jvm.internal.m.a(element, this.elementData[i11])) {
                length = i11 + this.elementData.length;
                i10 = this.head;
            }
        }
        return -1;
        return length - i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object element) {
        int iR;
        int i10;
        int iT = t(this.head + size());
        int i11 = this.head;
        if (i11 < iT) {
            iR = iT - 1;
            if (i11 <= iR) {
                while (!kotlin.jvm.internal.m.a(element, this.elementData[iR])) {
                    if (iR != i11) {
                        iR--;
                    }
                }
                i10 = this.head;
                return iR - i10;
            }
            return -1;
        }
        if (i11 > iT) {
            for (int i12 = iT - 1; -1 < i12; i12--) {
                if (kotlin.jvm.internal.m.a(element, this.elementData[i12])) {
                    iR = i12 + this.elementData.length;
                    i10 = this.head;
                    return iR - i10;
                }
            }
            iR = o.R(this.elementData);
            int i13 = this.head;
            if (i13 <= iR) {
                while (!kotlin.jvm.internal.m.a(element, this.elementData[iR])) {
                    if (iR != i13) {
                        iR--;
                    }
                }
                i10 = this.head;
                return iR - i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> elements) {
        int iT;
        kotlin.jvm.internal.m.f(elements, "elements");
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int iT2 = t(this.head + size());
            int i10 = this.head;
            if (i10 < iT2) {
                iT = i10;
                while (i10 < iT2) {
                    Object obj = this.elementData[i10];
                    if (elements.contains(obj)) {
                        z10 = true;
                    } else {
                        this.elementData[iT] = obj;
                        iT++;
                    }
                    i10++;
                }
                m.r(this.elementData, null, iT, iT2);
            } else {
                int length = this.elementData.length;
                int i11 = i10;
                boolean z11 = false;
                while (i10 < length) {
                    Object[] objArr = this.elementData;
                    Object obj2 = objArr[i10];
                    objArr[i10] = null;
                    if (elements.contains(obj2)) {
                        z11 = true;
                    } else {
                        this.elementData[i11] = obj2;
                        i11++;
                    }
                    i10++;
                }
                iT = t(i11);
                for (int i12 = 0; i12 < iT2; i12++) {
                    Object[] objArr2 = this.elementData;
                    Object obj3 = objArr2[i12];
                    objArr2[i12] = null;
                    if (elements.contains(obj3)) {
                        z11 = true;
                    } else {
                        this.elementData[iT] = obj3;
                        iT = o(iT);
                    }
                }
                z10 = z11;
            }
            if (z10) {
                u();
                this.size = r(iT - this.head);
            }
        }
        return z10;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int fromIndex, int toIndex) {
        d.INSTANCE.d(fromIndex, toIndex, size());
        int i10 = toIndex - fromIndex;
        if (i10 == 0) {
            return;
        }
        if (i10 == size()) {
            clear();
            return;
        }
        if (i10 == 1) {
            f(fromIndex);
            return;
        }
        u();
        if (fromIndex < size() - toIndex) {
            w(fromIndex, toIndex);
            int iT = t(this.head + i10);
            s(this.head, iT);
            this.head = iT;
        } else {
            x(fromIndex, toIndex);
            int iT2 = t(this.head + size());
            s(r(iT2 - i10), iT2);
        }
        this.size = size() - i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> elements) {
        int iT;
        kotlin.jvm.internal.m.f(elements, "elements");
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int iT2 = t(this.head + size());
            int i10 = this.head;
            if (i10 < iT2) {
                iT = i10;
                while (i10 < iT2) {
                    Object obj = this.elementData[i10];
                    if (elements.contains(obj)) {
                        this.elementData[iT] = obj;
                        iT++;
                    } else {
                        z10 = true;
                    }
                    i10++;
                }
                m.r(this.elementData, null, iT, iT2);
            } else {
                int length = this.elementData.length;
                int i11 = i10;
                boolean z11 = false;
                while (i10 < length) {
                    Object[] objArr = this.elementData;
                    Object obj2 = objArr[i10];
                    objArr[i10] = null;
                    if (elements.contains(obj2)) {
                        this.elementData[i11] = obj2;
                        i11++;
                    } else {
                        z11 = true;
                    }
                    i10++;
                }
                iT = t(i11);
                for (int i12 = 0; i12 < iT2; i12++) {
                    Object[] objArr2 = this.elementData;
                    Object obj3 = objArr2[i12];
                    objArr2[i12] = null;
                    if (elements.contains(obj3)) {
                        this.elementData[iT] = obj3;
                        iT = o(iT);
                    } else {
                        z11 = true;
                    }
                }
                z10 = z11;
            }
            if (z10) {
                u();
                this.size = r(iT - this.head);
            }
        }
        return z10;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int index, E element) {
        d.INSTANCE.b(index, size());
        int iT = t(this.head + index);
        Object[] objArr = this.elementData;
        E e10 = (E) objArr[iT];
        objArr[iT] = element;
        return e10;
    }

    private final void h(int internalIndex, Collection<? extends E> elements) {
        Iterator<? extends E> it = elements.iterator();
        int length = this.elementData.length;
        while (internalIndex < length && it.hasNext()) {
            this.elementData[internalIndex] = it.next();
            internalIndex++;
        }
        int i10 = this.head;
        for (int i11 = 0; i11 < i10 && it.hasNext(); i11++) {
            this.elementData[i11] = it.next();
        }
        this.size = size() + elements.size();
    }

    public final void addFirst(E element) {
        u();
        m(size() + 1);
        int iK = k(this.head);
        this.head = iK;
        this.elementData[iK] = element;
        this.size = size() + 1;
    }

    public final void addLast(E element) {
        u();
        m(size() + 1);
        this.elementData[t(this.head + size())] = element;
        this.size = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (!isEmpty()) {
            u();
            s(this.head, t(this.head + size()));
        }
        this.head = 0;
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object element) {
        if (indexOf(element) != -1) {
            return true;
        }
        return false;
    }

    public final E first() {
        if (!isEmpty()) {
            return (E) this.elementData[this.head];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public final E last() {
        if (!isEmpty()) {
            return (E) this.elementData[t(this.head + t.n(this))];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E n() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.elementData[this.head];
    }

    public final E q() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.elementData[t(this.head + t.n(this))];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object element) {
        int iIndexOf = indexOf(element);
        if (iIndexOf == -1) {
            return false;
        }
        f(iIndexOf);
        return true;
    }

    public final E removeFirst() {
        if (!isEmpty()) {
            u();
            Object[] objArr = this.elementData;
            int i10 = this.head;
            E e10 = (E) objArr[i10];
            objArr[i10] = null;
            this.head = o(i10);
            this.size = size() - 1;
            return e10;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeLast() {
        if (!isEmpty()) {
            u();
            int iT = t(this.head + t.n(this));
            Object[] objArr = this.elementData;
            E e10 = (E) objArr[iT];
            objArr[iT] = null;
            this.size = size() - 1;
            return e10;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E v() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int index, Collection<? extends E> elements) {
        kotlin.jvm.internal.m.f(elements, "elements");
        d.INSTANCE.c(index, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (index == size()) {
            return addAll(elements);
        }
        u();
        m(size() + elements.size());
        int iT = t(this.head + size());
        int iT2 = t(this.head + index);
        int size = elements.size();
        if (index < ((size() + 1) >> 1)) {
            int i10 = this.head;
            int length = i10 - size;
            if (iT2 < i10) {
                Object[] objArr = this.elementData;
                m.i(objArr, objArr, length, i10, objArr.length);
                if (size >= iT2) {
                    Object[] objArr2 = this.elementData;
                    m.i(objArr2, objArr2, objArr2.length - size, 0, iT2);
                } else {
                    Object[] objArr3 = this.elementData;
                    m.i(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.elementData;
                    m.i(objArr4, objArr4, 0, size, iT2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.elementData;
                m.i(objArr5, objArr5, length, i10, iT2);
            } else {
                Object[] objArr6 = this.elementData;
                length += objArr6.length;
                int i11 = iT2 - i10;
                int length2 = objArr6.length - length;
                if (length2 >= i11) {
                    m.i(objArr6, objArr6, length, i10, iT2);
                } else {
                    m.i(objArr6, objArr6, length, i10, i10 + length2);
                    Object[] objArr7 = this.elementData;
                    m.i(objArr7, objArr7, 0, this.head + length2, iT2);
                }
            }
            this.head = length;
            h(r(iT2 - size), elements);
        } else {
            int i12 = iT2 + size;
            if (iT2 < iT) {
                int i13 = size + iT;
                Object[] objArr8 = this.elementData;
                if (i13 <= objArr8.length) {
                    m.i(objArr8, objArr8, i12, iT2, iT);
                } else if (i12 >= objArr8.length) {
                    m.i(objArr8, objArr8, i12 - objArr8.length, iT2, iT);
                } else {
                    int length3 = iT - (i13 - objArr8.length);
                    m.i(objArr8, objArr8, 0, length3, iT);
                    Object[] objArr9 = this.elementData;
                    m.i(objArr9, objArr9, i12, iT2, length3);
                }
            } else {
                Object[] objArr10 = this.elementData;
                m.i(objArr10, objArr10, size, 0, iT);
                Object[] objArr11 = this.elementData;
                if (i12 >= objArr11.length) {
                    m.i(objArr11, objArr11, i12 - objArr11.length, iT2, objArr11.length);
                } else {
                    m.i(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.elementData;
                    m.i(objArr12, objArr12, i12, iT2, objArr12.length - size);
                }
            }
            h(iT2, elements);
        }
        return true;
    }

    public i() {
        this.elementData = f12300e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
