package ta;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a#\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a-\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005\"\u00028\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\t\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\f\u0010\r\u001a)\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001aE\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0015\u0010\u000f\u001a-\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0000*\u00020\u00162\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0017¢\u0006\u0004\b\u0019\u0010\u001a\u001a?\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0000*\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00018\u00002\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0011H\u0007¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "Lta/h;", "g", "(Ljava/util/Iterator;)Lta/h;", "", "elements", "s", "([Ljava/lang/Object;)Lta/h;", "element", "r", "(Ljava/lang/Object;)Lta/h;", "i", "()Lta/h;", "j", "(Lta/h;)Lta/h;", "R", "Lkotlin/Function1;", "iterator", "k", "(Lta/h;Lc9/l;)Lta/h;", "h", "", "Lkotlin/Function0;", "nextFunction", "n", "(Lc9/a;)Lta/h;", "seed", "o", "(Ljava/lang/Object;Lc9/l;)Lta/h;", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/sequences/SequencesKt")
public class r extends m {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"ta/r$a", "Lta/h;", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f19002a;

        public a(Iterator it) {
            this.f19002a = it;
        }

        @Override // ta.h
        public Iterator<T> iterator() {
            return this.f19002a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"ta/r$b", "Lta/h;", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b<T> implements h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f19003a;

        public b(Object obj) {
            this.f19003a = obj;
        }

        @Override // ta.h
        public Iterator<T> iterator() {
            return new c(this.f19003a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"ta/r$c", "", "next", "()Ljava/lang/Object;", "", "hasNext", "()Z", "a", "Z", "_hasNext", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c<T> implements Iterator<T>, d9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean _hasNext = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ T f19005b;

        c(T t10) {
            this.f19005b = t10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this._hasNext;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this._hasNext) {
                throw new NoSuchElementException();
            }
            this._hasNext = false;
            return this.f19005b;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static <T> h<T> g(Iterator<? extends T> it) {
        kotlin.jvm.internal.m.f(it, "<this>");
        return h(new a(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> h<T> h(h<? extends T> hVar) {
        kotlin.jvm.internal.m.f(hVar, "<this>");
        return hVar instanceof ta.a ? hVar : new ta.a(hVar);
    }

    public static <T> h<T> i() {
        return d.f18975a;
    }

    public static final <T> h<T> j(h<? extends h<? extends T>> hVar) {
        kotlin.jvm.internal.m.f(hVar, "<this>");
        return k(hVar, new c9.l() { // from class: ta.p
            @Override // c9.l
            public final Object invoke(Object obj) {
                return r.l((h) obj);
            }
        });
    }

    private static final <T, R> h<R> k(h<? extends T> hVar, c9.l<? super T, ? extends Iterator<? extends R>> lVar) {
        return hVar instanceof w ? ((w) hVar).d(lVar) : new f(hVar, new c9.l() { // from class: ta.q
            @Override // c9.l
            public final Object invoke(Object obj) {
                return r.m(obj);
            }
        }, lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterator l(h it) {
        kotlin.jvm.internal.m.f(it, "it");
        return it.iterator();
    }

    public static <T> h<T> n(final c9.a<? extends T> nextFunction) {
        kotlin.jvm.internal.m.f(nextFunction, "nextFunction");
        return h(new g(nextFunction, new c9.l() { // from class: ta.o
            @Override // c9.l
            public final Object invoke(Object obj) {
                return r.p(nextFunction, obj);
            }
        }));
    }

    public static <T> h<T> o(final T t10, c9.l<? super T, ? extends T> nextFunction) {
        kotlin.jvm.internal.m.f(nextFunction, "nextFunction");
        return t10 == null ? d.f18975a : new g(new c9.a() { // from class: ta.n
            @Override // c9.a
            public final Object invoke() {
                return r.q(t10);
            }
        }, nextFunction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object p(c9.a aVar, Object it) {
        kotlin.jvm.internal.m.f(it, "it");
        return aVar.invoke();
    }

    public static final <T> h<T> r(T t10) {
        return new b(t10);
    }

    public static final <T> h<T> s(T... elements) {
        kotlin.jvm.internal.m.f(elements, "elements");
        return kotlin.collections.j.G(elements);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object m(Object obj) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object q(Object obj) {
        return obj;
    }
}
