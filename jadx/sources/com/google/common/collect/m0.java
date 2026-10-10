package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class m0 {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Field f4646a;

        /* synthetic */ b(Field field, a aVar) {
            this(field);
        }

        private b(Field field) {
            this.f4646a = field;
            field.setAccessible(true);
        }

        void a(T t10, int i10) {
            try {
                this.f4646a.set(t10, Integer.valueOf(i10));
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            }
        }

        void b(T t10, Object obj) {
            try {
                this.f4646a.set(t10, obj);
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    static <T> b<T> a(Class<T> cls, String str) {
        try {
            return new b<>(cls.getDeclaredField(str), null);
        } catch (NoSuchFieldException e10) {
            throw new AssertionError(e10);
        }
    }

    static <K, V> void b(a0<K, V> a0Var, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(a0Var.a().size());
        for (Map.Entry<K, Collection<V>> entry : a0Var.a().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().size());
            Iterator<V> it = entry.getValue().iterator();
            while (it.hasNext()) {
                objectOutputStream.writeObject(it.next());
            }
        }
    }
}
