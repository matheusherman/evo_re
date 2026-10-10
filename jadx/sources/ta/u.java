package ta;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a(\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a%\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001d\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u000b\u0010\u0007\u001a+\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000e\u001a7\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\u0004\b\u0011\u0010\u0012\u001a7\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\u0004\b\u0013\u0010\u0012\u001a)\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u0000*\u00020\u0014*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a7\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\u0004\b\u0017\u0010\u0012\u001a7\u0010\u001a\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0010\b\u0001\u0010\u0006*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0018*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0019\u001a\u00028\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001a#\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001a#\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b \u0010\u001e\u001aC\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010!*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00010\u000f¢\u0006\u0004\b#\u0010\u0012\u001a=\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010!*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f¢\u0006\u0004\b$\u0010\u0012\u001aC\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010!*\u00020\u0014*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u000f¢\u0006\u0004\b%\u0010\u0012\u001a\u001d\u0010&\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b&\u0010'\u001a.\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b(\u0010)\u001a4\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000*H\u0086\u0002¢\u0006\u0004\b,\u0010-\u001a}\u00107\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\f\b\u0001\u0010\u0015*\u00060.j\u0002`/*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u00100\u001a\u00028\u00012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u0002012\b\b\u0002\u00104\u001a\u0002012\b\b\u0002\u00105\u001a\u00020\b2\b\b\u0002\u00106\u001a\u0002012\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u000201\u0018\u00010\u000f¢\u0006\u0004\b7\u00108\u001ag\u0010:\u001a\u000209\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u0002012\b\b\u0002\u00104\u001a\u0002012\b\b\u0002\u00105\u001a\u00020\b2\b\b\u0002\u00106\u001a\u0002012\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u000201\u0018\u00010\u000f¢\u0006\u0004\b:\u0010;\u001a#\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000*\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b<\u0010=¨\u0006>"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lta/h;", "element", "", "v", "(Lta/h;Ljava/lang/Object;)Z", "C", "(Lta/h;)Ljava/lang/Object;", "", ExifInterface.LONGITUDE_EAST, "(Lta/h;Ljava/lang/Object;)I", "I", "n", "x", "(Lta/h;I)Lta/h;", "Lkotlin/Function1;", "predicate", "y", "(Lta/h;Lc9/l;)Lta/h;", "z", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lta/h;)Lta/h;", "N", "", "destination", "O", "(Lta/h;Ljava/util/Collection;)Ljava/util/Collection;", "", "P", "(Lta/h;)Ljava/util/List;", "", "Q", "R", "transform", "D", "J", "K", "w", "(Lta/h;)I", "M", "(Lta/h;Ljava/lang/Object;)Lta/h;", "", "elements", "L", "(Lta/h;Ljava/lang/Iterable;)Lta/h;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "buffer", "", "separator", "prefix", "postfix", "limit", "truncated", "F", "(Lta/h;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lc9/l;)Ljava/lang/Appendable;", "", "G", "(Lta/h;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lc9/l;)Ljava/lang/String;", "u", "(Lta/h;)Ljava/lang/Iterable;", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/sequences/SequencesKt")
public class u extends s {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"ta/u$a", "", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Iterable<T>, d9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f19006a;

        public a(h hVar) {
            this.f19006a = hVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.f19006a.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class b<R> extends kotlin.jvm.internal.k implements c9.l<h<? extends R>, Iterator<? extends R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f19007a = new b();

        b() {
            super(1, h.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final Iterator<R> invoke(h<? extends R> p10) {
            kotlin.jvm.internal.m.f(p10, "p0");
            return p10.iterator();
        }
    }

    public static <T> h<T> A(h<? extends T> hVar) {
        kotlin.jvm.internal.m.f(hVar, "<this>");
        h<T> hVarZ = z(hVar, new c9.l() { // from class: ta.t
            @Override // c9.l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(u.B(obj));
            }
        });
        kotlin.jvm.internal.m.d(hVarZ, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return hVarZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean B(Object obj) {
        return obj == null;
    }

    public static <T> T C(h<? extends T> hVar) {
        kotlin.jvm.internal.m.f(hVar, "<this>");
        Iterator<? extends T> it = hVar.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static <T, R> h<R> D(h<? extends T> hVar, c9.l<? super T, ? extends h<? extends R>> transform) {
        kotlin.jvm.internal.m.f(hVar, "<this>");
        kotlin.jvm.internal.m.f(transform, "transform");
        return new f(hVar, transform, b.f19007a);
    }

    public static final <T> int E(h<? extends T> hVar, T t10) {
        kotlin.jvm.internal.m.f(hVar, "<this>");
        int i10 = 0;
        for (T t11 : hVar) {
            if (i10 < 0) {
                kotlin.collections.r.v();
            }
            if (kotlin.jvm.internal.m.a(t10, t11)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static final <T, A extends Appendable> A F(h<? extends T> hVar, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, c9.l<? super T, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.m.f(hVar, "<this>");
        kotlin.jvm.internal.m.f(buffer, "buffer");
        kotlin.jvm.internal.m.f(separator, "separator");
        kotlin.jvm.internal.m.f(prefix, "prefix");
        kotlin.jvm.internal.m.f(postfix, "postfix");
        kotlin.jvm.internal.m.f(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (T t10 : hVar) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            ua.n.a(buffer, t10, lVar);
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <T> String G(h<? extends T> hVar, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, c9.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.m.f(hVar, "<this>");
        kotlin.jvm.internal.m.f(separator, "separator");
        kotlin.jvm.internal.m.f(prefix, "prefix");
        kotlin.jvm.internal.m.f(postfix, "postfix");
        kotlin.jvm.internal.m.f(truncated, "truncated");
        return ((StringBuilder) F(hVar, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
    }

    public static /* synthetic */ String H(h hVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, c9.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i11 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i11 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        c9.l lVar2 = lVar;
        return G(hVar, charSequence, charSequence2, charSequence3, i10, charSequence5, lVar2);
    }

    public static <T> T I(h<? extends T> hVar) {
        kotlin.jvm.internal.m.f(hVar, "<this>");
        Iterator<? extends T> it = hVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static <T, R> h<R> J(h<? extends T> hVar, c9.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.m.f(hVar, "<this>");
        kotlin.jvm.internal.m.f(transform, "transform");
        return new w(hVar, transform);
    }

    public static <T, R> h<R> K(h<? extends T> hVar, c9.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.m.f(hVar, "<this>");
        kotlin.jvm.internal.m.f(transform, "transform");
        return A(new w(hVar, transform));
    }

    public static <T> h<T> L(h<? extends T> hVar, Iterable<? extends T> elements) {
        kotlin.jvm.internal.m.f(hVar, "<this>");
        kotlin.jvm.internal.m.f(elements, "elements");
        return r.j(r.s(hVar, kotlin.collections.r.Z(elements)));
    }

    public static <T> h<T> M(h<? extends T> hVar, T t10) {
        kotlin.jvm.internal.m.f(hVar, "<this>");
        return r.j(r.s(hVar, r.r(t10)));
    }

    public static <T> h<T> N(h<? extends T> hVar, c9.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.m.f(hVar, "<this>");
        kotlin.jvm.internal.m.f(predicate, "predicate");
        return new v(hVar, predicate);
    }

    public static final <T, C extends Collection<? super T>> C O(h<? extends T> hVar, C destination) {
        kotlin.jvm.internal.m.f(hVar, "<this>");
        kotlin.jvm.internal.m.f(destination, "destination");
        Iterator<? extends T> it = hVar.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static <T> List<T> P(h<? extends T> hVar) {
        kotlin.jvm.internal.m.f(hVar, "<this>");
        Iterator<? extends T> it = hVar.iterator();
        if (!it.hasNext()) {
            return kotlin.collections.r.l();
        }
        T next = it.next();
        if (!it.hasNext()) {
            return kotlin.collections.r.e(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static <T> List<T> Q(h<? extends T> hVar) {
        kotlin.jvm.internal.m.f(hVar, "<this>");
        return (List) O(hVar, new ArrayList());
    }

    public static <T> Iterable<T> u(h<? extends T> hVar) {
        kotlin.jvm.internal.m.f(hVar, "<this>");
        return new a(hVar);
    }

    public static <T> boolean v(h<? extends T> hVar, T t10) {
        kotlin.jvm.internal.m.f(hVar, "<this>");
        return E(hVar, t10) >= 0;
    }

    public static <T> int w(h<? extends T> hVar) {
        kotlin.jvm.internal.m.f(hVar, "<this>");
        Iterator<? extends T> it = hVar.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            it.next();
            i10++;
            if (i10 < 0) {
                kotlin.collections.r.u();
            }
        }
        return i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> h<T> x(h<? extends T> hVar, int i10) {
        kotlin.jvm.internal.m.f(hVar, "<this>");
        if (i10 >= 0) {
            if (i10 == 0) {
                return hVar;
            }
            return hVar instanceof c ? ((c) hVar).a(i10) : new ta.b(hVar, i10);
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    public static <T> h<T> y(h<? extends T> hVar, c9.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.m.f(hVar, "<this>");
        kotlin.jvm.internal.m.f(predicate, "predicate");
        return new e(hVar, true, predicate);
    }

    public static <T> h<T> z(h<? extends T> hVar, c9.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.m.f(hVar, "<this>");
        kotlin.jvm.internal.m.f(predicate, "predicate");
        return new e(hVar, false, predicate);
    }
}
