package z7;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.r;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0015\u0010\nJ\u001d\u0010\u0016\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\u000eJ\u001d\u0010\u0017\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u000eJ\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\nJ\u001d\u0010\u0019\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\u000eJ\u000f\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R$\u0010%\u001a\u0012\u0012\u0004\u0012\u00028\u00000!j\b\u0012\u0004\u0012\u00028\u0000`\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lz7/c;", ExifInterface.LONGITUDE_EAST, "", "", "maxSize", "<init>", "(I)V", "element", "", "add", "(Ljava/lang/Object;)Z", "", "elements", "addAll", "(Ljava/util/Collection;)Z", "Lr8/z;", "clear", "()V", "", "iterator", "()Ljava/util/Iterator;", "remove", "removeAll", "retainAll", "contains", "containsAll", "isEmpty", "()Z", "", "toString", "()Ljava/lang/String;", "a", "I", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "b", "Ljava/util/LinkedHashSet;", "linkedHashSet", "e", "()I", "size", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c<E> implements Set<E>, d9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int maxSize;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final LinkedHashSet<E> linkedHashSet;

    public c() {
        this(0, 1, null);
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.f.a(this);
    }

    public c(int i10) {
        this.maxSize = i10;
        this.linkedHashSet = new LinkedHashSet<>();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(E element) {
        if (this.linkedHashSet.contains(element)) {
            this.linkedHashSet.remove(element);
        }
        boolean zAdd = this.linkedHashSet.add(element);
        if (zAdd && size() > this.maxSize) {
            Iterator<E> it = this.linkedHashSet.iterator();
            kotlin.jvm.internal.m.e(it, "iterator(...)");
            while (it.hasNext() && this.linkedHashSet.size() > this.maxSize) {
                it.next();
                it.remove();
            }
        }
        return zAdd;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends E> elements) {
        kotlin.jvm.internal.m.f(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            if (add(it.next())) {
                z10 = true;
            }
        }
        return z10;
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.linkedHashSet.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object element) {
        return this.linkedHashSet.contains(element);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        kotlin.jvm.internal.m.f(elements, "elements");
        return this.linkedHashSet.containsAll(elements);
    }

    public int e() {
        return this.linkedHashSet.size();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.linkedHashSet.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        Iterator<E> it = this.linkedHashSet.iterator();
        kotlin.jvm.internal.m.e(it, "iterator(...)");
        return it;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object element) {
        return this.linkedHashSet.remove(element);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        kotlin.jvm.internal.m.f(elements, "elements");
        return this.linkedHashSet.removeAll(r.S0(elements));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        kotlin.jvm.internal.m.f(elements, "elements");
        return this.linkedHashSet.retainAll(r.S0(elements));
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.m.f(array, "array");
        return (T[]) kotlin.jvm.internal.f.b(this, array);
    }

    public String toString() {
        String string = this.linkedHashSet.toString();
        kotlin.jvm.internal.m.e(string, "toString(...)");
        return string;
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return e();
    }

    public /* synthetic */ c(int i10, int i11, kotlin.jvm.internal.g gVar) {
        this((i11 & 1) != 0 ? 20 : i10);
    }
}
