package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.h1;
import kotlin.reflect.jvm.internal.impl.descriptors.i0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e0 {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends na.k> h1<T> a(w9.c cVar, y9.c nameResolver, y9.g typeTable, c9.l<? super w9.q, ? extends T> typeDeserializer, c9.l<? super ba.f, ? extends T> typeOfPublicProperty) {
        T tInvoke;
        List<w9.q> listR0;
        kotlin.jvm.internal.m.f(cVar, "<this>");
        kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.m.f(typeTable, "typeTable");
        kotlin.jvm.internal.m.f(typeDeserializer, "typeDeserializer");
        kotlin.jvm.internal.m.f(typeOfPublicProperty, "typeOfPublicProperty");
        if (cVar.L0() <= 0) {
            if (!cVar.n1()) {
                return null;
            }
            ba.f fVarB = w.b(nameResolver, cVar.I0());
            w9.q qVarI = y9.f.i(cVar, typeTable);
            if ((qVarI != null && (tInvoke = typeDeserializer.invoke(qVarI)) != null) || (tInvoke = typeOfPublicProperty.invoke(fVarB)) != null) {
                return new kotlin.reflect.jvm.internal.impl.descriptors.z(fVarB, tInvoke);
            }
            throw new IllegalStateException(("cannot determine underlying type for value class " + w.b(nameResolver, cVar.E0()) + " with property " + fVarB).toString());
        }
        List<Integer> multiFieldValueClassUnderlyingNameList = cVar.M0();
        kotlin.jvm.internal.m.e(multiFieldValueClassUnderlyingNameList, "multiFieldValueClassUnderlyingNameList");
        List<Integer> list = multiFieldValueClassUnderlyingNameList;
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
        for (Integer it : list) {
            kotlin.jvm.internal.m.e(it, "it");
            arrayList.add(w.b(nameResolver, it.intValue()));
        }
        r8.p pVarA = r8.v.a(Integer.valueOf(cVar.P0()), Integer.valueOf(cVar.O0()));
        if (kotlin.jvm.internal.m.a(pVarA, r8.v.a(Integer.valueOf(arrayList.size()), 0))) {
            List<Integer> multiFieldValueClassUnderlyingTypeIdList = cVar.Q0();
            kotlin.jvm.internal.m.e(multiFieldValueClassUnderlyingTypeIdList, "multiFieldValueClassUnderlyingTypeIdList");
            List<Integer> list2 = multiFieldValueClassUnderlyingTypeIdList;
            listR0 = new ArrayList<>(kotlin.collections.r.w(list2, 10));
            for (Integer it2 : list2) {
                kotlin.jvm.internal.m.e(it2, "it");
                listR0.add(typeTable.a(it2.intValue()));
            }
        } else {
            if (!kotlin.jvm.internal.m.a(pVarA, r8.v.a(0, Integer.valueOf(arrayList.size())))) {
                throw new IllegalStateException(("class " + w.b(nameResolver, cVar.E0()) + " has illegal multi-field value class representation").toString());
            }
            listR0 = cVar.R0();
        }
        kotlin.jvm.internal.m.e(listR0, "when (typeIdCount to typ…epresentation\")\n        }");
        List<w9.q> list3 = listR0;
        ArrayList arrayList2 = new ArrayList(kotlin.collections.r.w(list3, 10));
        Iterator<T> it3 = list3.iterator();
        while (it3.hasNext()) {
            arrayList2.add(typeDeserializer.invoke(it3.next()));
        }
        return new i0(kotlin.collections.r.W0(arrayList, arrayList2));
    }
}
