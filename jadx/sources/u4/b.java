package u4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b<E> extends AbstractCollection<E> implements Queue, Cloneable, Serializable {
    private static final long serialVersionUID = 2340985798034038923L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient Object[] f19346a = new Object[16];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient int f19347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient int f19348c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: u4.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class C0370b implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f19349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f19350b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f19351c;

        private C0370b() {
            this.f19349a = b.this.f19347b;
            this.f19350b = b.this.f19348c;
            this.f19351c = -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f19349a != this.f19350b;
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.f19349a == this.f19350b) {
                throw new NoSuchElementException();
            }
            E e10 = (E) b.this.f19346a[this.f19349a];
            if (b.this.f19348c != this.f19350b || e10 == null) {
                throw new ConcurrentModificationException();
            }
            int i10 = this.f19349a;
            this.f19351c = i10;
            this.f19349a = (i10 + 1) & (b.this.f19346a.length - 1);
            return e10;
        }

        @Override // java.util.Iterator
        public void remove() {
            int i10 = this.f19351c;
            if (i10 < 0) {
                throw new IllegalStateException();
            }
            if (b.this.q(i10)) {
                this.f19349a = (this.f19349a - 1) & (b.this.f19346a.length - 1);
                this.f19350b = b.this.f19348c;
            }
            this.f19351c = -1;
        }

        /* synthetic */ C0370b(b bVar, a aVar) {
            this();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        int length = this.f19346a.length - 1;
        int i10 = this.f19347b;
        while (true) {
            Object obj2 = this.f19346a[i10];
            if (obj2 == null) {
                return false;
            }
            if (obj.equals(obj2)) {
                return true;
            }
            i10 = (i10 + 1) & length;
        }
    }

    @Override // java.util.Queue
    public E remove() {
        return removeFirst();
    }

    public boolean removeFirstOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        int length = this.f19346a.length - 1;
        int i10 = this.f19347b;
        while (true) {
            Object obj2 = this.f19346a[i10];
            if (obj2 == null) {
                return false;
            }
            if (obj.equals(obj2)) {
                q(i10);
                return true;
            }
            i10 = (i10 + 1) & length;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return o(new Object[size()]);
    }

    private void k(int i10) {
        int i11 = 8;
        if (i10 >= 8) {
            int i12 = i10 | (i10 >>> 1);
            int i13 = i12 | (i12 >>> 2);
            int i14 = i13 | (i13 >>> 4);
            int i15 = i14 | (i14 >>> 8);
            i11 = (i15 | (i15 >>> 16)) + 1;
            if (i11 < 0) {
                i11 >>>= 1;
            }
        }
        this.f19346a = new Object[i11];
    }

    private <T> T[] o(T[] tArr) {
        int i10 = this.f19347b;
        int i11 = this.f19348c;
        if (i10 < i11) {
            System.arraycopy(this.f19346a, i10, tArr, 0, size());
            return tArr;
        }
        if (i10 > i11) {
            Object[] objArr = this.f19346a;
            int length = objArr.length - i10;
            System.arraycopy(objArr, i10, tArr, 0, length);
            System.arraycopy(this.f19346a, 0, tArr, length, this.f19348c);
        }
        return tArr;
    }

    private void s() {
        int i10 = this.f19347b;
        Object[] objArr = this.f19346a;
        int length = objArr.length;
        int i11 = length - i10;
        int i12 = length << 1;
        if (i12 < 0) {
            throw new IllegalStateException("Sorry, deque too big");
        }
        Object[] objArr2 = new Object[i12];
        System.arraycopy(objArr, i10, objArr2, 0, i11);
        System.arraycopy(this.f19346a, 0, objArr2, i11, i10);
        this.f19346a = objArr2;
        this.f19347b = 0;
        this.f19348c = length;
    }

    public void addFirst(E e10) {
        if (e10 == null) {
            throw new NullPointerException("e == null");
        }
        Object[] objArr = this.f19346a;
        int length = (this.f19347b - 1) & (objArr.length - 1);
        this.f19347b = length;
        objArr[length] = e10;
        if (length == this.f19348c) {
            s();
        }
    }

    public void addLast(E e10) {
        if (e10 == null) {
            throw new NullPointerException("e == null");
        }
        Object[] objArr = this.f19346a;
        int i10 = this.f19348c;
        objArr[i10] = e10;
        int length = (objArr.length - 1) & (i10 + 1);
        this.f19348c = length;
        if (length == this.f19347b) {
            s();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        int i10 = this.f19347b;
        int i11 = this.f19348c;
        if (i10 != i11) {
            this.f19348c = 0;
            this.f19347b = 0;
            int length = this.f19346a.length - 1;
            do {
                this.f19346a[i10] = null;
                i10 = (i10 + 1) & length;
            } while (i10 != i11);
        }
    }

    public E getFirst() {
        E e10 = (E) this.f19346a[this.f19347b];
        if (e10 != null) {
            return e10;
        }
        throw new NoSuchElementException();
    }

    public E getLast() {
        Object[] objArr = this.f19346a;
        E e10 = (E) objArr[(this.f19348c - 1) & (objArr.length - 1)];
        if (e10 != null) {
            return e10;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f19347b == this.f19348c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new C0370b(this, null);
    }

    public E peekFirst() {
        return (E) this.f19346a[this.f19347b];
    }

    public E pollFirst() {
        int i10 = this.f19347b;
        Object[] objArr = this.f19346a;
        E e10 = (E) objArr[i10];
        if (e10 == null) {
            return null;
        }
        objArr[i10] = null;
        this.f19347b = (i10 + 1) & (objArr.length - 1);
        return e10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return (this.f19348c - this.f19347b) & (this.f19346a.length - 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        int size = size();
        if (tArr.length < size) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        }
        o(tArr);
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q(int i10) {
        m();
        Object[] objArr = this.f19346a;
        int length = objArr.length - 1;
        int i11 = this.f19347b;
        int i12 = this.f19348c;
        int i13 = (i10 - i11) & length;
        int i14 = (i12 - i10) & length;
        if (i13 < ((i12 - i11) & length)) {
            if (i13 < i14) {
                if (i11 <= i10) {
                    System.arraycopy(objArr, i11, objArr, i11 + 1, i13);
                } else {
                    System.arraycopy(objArr, 0, objArr, 1, i10);
                    objArr[0] = objArr[length];
                    System.arraycopy(objArr, i11, objArr, i11 + 1, length - i11);
                }
                objArr[i11] = null;
                this.f19347b = (i11 + 1) & length;
                return false;
            }
            if (i10 < i12) {
                System.arraycopy(objArr, i10 + 1, objArr, i10, i14);
                this.f19348c = i12 - 1;
            } else {
                System.arraycopy(objArr, i10 + 1, objArr, i10, length - i10);
                objArr[length] = objArr[0];
                System.arraycopy(objArr, 1, objArr, 0, i12);
                this.f19348c = (i12 - 1) & length;
            }
            return true;
        }
        throw new ConcurrentModificationException();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i10 = objectInputStream.readInt();
        k(i10);
        this.f19347b = 0;
        this.f19348c = i10;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f19346a[i11] = objectInputStream.readObject();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        int length = this.f19346a.length - 1;
        for (int i10 = this.f19347b; i10 != this.f19348c; i10 = (i10 + 1) & length) {
            objectOutputStream.writeObject(this.f19346a[i10]);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E e10) {
        addLast(e10);
        return true;
    }

    @Override // java.util.Queue
    public E element() {
        return getFirst();
    }

    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public b<E> clone() {
        try {
            b<E> bVar = (b) super.clone();
            Object[] objArr = this.f19346a;
            System.arraycopy(objArr, 0, bVar.f19346a, 0, objArr.length);
            return bVar;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    @Override // java.util.Queue
    public boolean offer(E e10) {
        return offerLast(e10);
    }

    public boolean offerLast(E e10) {
        addLast(e10);
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        return peekFirst();
    }

    @Override // java.util.Queue
    public E poll() {
        return pollFirst();
    }

    public E removeFirst() {
        E ePollFirst = pollFirst();
        if (ePollFirst != null) {
            return ePollFirst;
        }
        throw new NoSuchElementException();
    }

    private void m() {
    }
}
