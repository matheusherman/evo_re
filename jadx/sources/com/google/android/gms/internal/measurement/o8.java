package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n8;
import com.google.android.gms.internal.measurement.o8;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class o8<MessageType extends n8<MessageType, BuilderType>, BuilderType extends o8<MessageType, BuilderType>> implements nb {
    @Override // com.google.android.gms.internal.measurement.nb
    public final /* synthetic */ nb P(byte[] bArr) {
        return j(bArr, 0, bArr.length);
    }

    @Override // com.google.android.gms.internal.measurement.nb
    public final /* synthetic */ nb V(byte[] bArr, q9 q9Var) {
        return k(bArr, 0, bArr.length, q9Var);
    }

    public abstract /* synthetic */ Object clone();

    public abstract BuilderType j(byte[] bArr, int i10, int i11);

    public abstract BuilderType k(byte[] bArr, int i10, int i11, q9 q9Var);

    protected static <T> void l(Iterable<T> iterable, List<? super T> list) {
        ga.e(iterable);
        if (iterable instanceof ua) {
            List<?> listB = ((ua) iterable).b();
            ua uaVar = (ua) list;
            int size = list.size();
            for (Object obj : listB) {
                if (obj == null) {
                    String str = "Element at index " + (uaVar.size() - size) + " is null.";
                    for (int size2 = uaVar.size() - 1; size2 >= size; size2--) {
                        uaVar.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof v8) {
                    uaVar.b0((v8) obj);
                } else if (obj instanceof byte[]) {
                    uaVar.b0(v8.m((byte[]) obj));
                } else {
                    uaVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof ac) {
            list.addAll((Collection) iterable);
            return;
        }
        if (iterable instanceof Collection) {
            int size3 = ((Collection) iterable).size();
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + size3);
            } else if (list instanceof bc) {
                ((bc) list).f(list.size() + size3);
            }
        }
        int size4 = list.size();
        if ((iterable instanceof List) && (iterable instanceof RandomAccess)) {
            List list2 = (List) iterable;
            int size5 = list2.size();
            for (int i10 = 0; i10 < size5; i10++) {
                a0.d dVar = (Object) list2.get(i10);
                if (dVar == null) {
                    m(list, size4);
                }
                list.add(dVar);
            }
            return;
        }
        for (Object obj2 : iterable) {
            if (obj2 == null) {
                m(list, size4);
            }
            list.add(obj2);
        }
    }

    private static void m(List<?> list, int i10) {
        String str = "Element at index " + (list.size() - i10) + " is null.";
        for (int size = list.size() - 1; size >= i10; size--) {
            list.remove(size);
        }
        throw new NullPointerException(str);
    }
}
