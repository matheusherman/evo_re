package com.google.common.collect;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class t<K, V> extends r<K, V> implements a0 {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient s<V> f4684c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a<K, V> extends r.a<K, V> {
        public t<K, V> a() {
            Collection collectionEntrySet = this.f4676a.entrySet();
            Comparator<? super K> comparator = this.f4677b;
            if (comparator != null) {
                collectionEntrySet = g0.a(comparator).d().b(collectionEntrySet);
            }
            return t.e(collectionEntrySet, this.f4678c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final m0.b<t> f4685a = m0.a(t.class, "emptySet");
    }

    private static <V> s<V> d(Comparator<? super V> comparator) {
        return comparator == null ? s.w() : u.I(comparator);
    }

    public static <K, V> t<K, V> f() {
        return m.f4645d;
    }

    private static <V> s<V> h(Comparator<? super V> comparator, Collection<? extends V> collection) {
        return comparator == null ? s.s(collection) : u.C(comparator, collection);
    }

    private static <V> s.a<V> i(Comparator<? super V> comparator) {
        return comparator == null ? new s.a<>() : new u.a(comparator);
    }

    Comparator<? super V> g() {
        s<V> sVar = this.f4684c;
        if (sVar instanceof u) {
            return ((u) sVar).comparator();
        }
        return null;
    }

    t(q<K, s<V>> qVar, int i10, Comparator<? super V> comparator) {
        super(qVar, i10);
        this.f4684c = d(comparator);
    }

    static <K, V> t<K, V> e(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, Comparator<? super V> comparator) {
        if (collection.isEmpty()) {
            return f();
        }
        q.a aVar = new q.a(collection.size());
        int size = 0;
        for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : collection) {
            K key = entry.getKey();
            s sVarH = h(comparator, entry.getValue());
            if (!sVarH.isEmpty()) {
                aVar.f(key, sVarH);
                size += sVarH.size();
            }
        }
        return new t<>(aVar.c(), size, comparator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        int i10 = objectInputStream.readInt();
        if (i10 >= 0) {
            q.a aVarA = q.a();
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                Object object = objectInputStream.readObject();
                Objects.requireNonNull(object);
                int i13 = objectInputStream.readInt();
                if (i13 > 0) {
                    s.a aVarI = i(comparator);
                    for (int i14 = 0; i14 < i13; i14++) {
                        Object object2 = objectInputStream.readObject();
                        Objects.requireNonNull(object2);
                        aVarI.f(object2);
                    }
                    s sVarI = aVarI.i();
                    if (sVarI.size() == i13) {
                        aVarA.f(object, sVarI);
                        i11 += i13;
                    } else {
                        throw new InvalidObjectException("Duplicate key-value pairs exist for key " + object);
                    }
                } else {
                    throw new InvalidObjectException("Invalid value count " + i13);
                }
            }
            try {
                r.b.f4679a.b(this, aVarA.c());
                r.b.f4680b.a(this, i11);
                b.f4685a.b(this, d(comparator));
                return;
            } catch (IllegalArgumentException e10) {
                throw ((InvalidObjectException) new InvalidObjectException(e10.getMessage()).initCause(e10));
            }
        }
        throw new InvalidObjectException("Invalid key count " + i10);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(g());
        m0.b(this, objectOutputStream);
    }
}
