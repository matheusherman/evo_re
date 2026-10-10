package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class i {
    /* JADX WARN: Code duplicated, block: B:11:0x002e  */
    /* JADX WARN: Code duplicated, block: B:13:0x0034 A[RETURN] */
    public static final e a(Annotation[] annotationArr, ba.c fqName) {
        kotlin.jvm.internal.m.f(annotationArr, "<this>");
        kotlin.jvm.internal.m.f(fqName, "fqName");
        for (Annotation annotation : annotationArr) {
            if (kotlin.jvm.internal.m.a(d.a(b9.a.b(b9.a.a(annotation))).b(), fqName)) {
                if (annotation != null) {
                    return new e(annotation);
                }
                return null;
            }
        }
        annotation = null;
        if (annotation != null) {
            return new e(annotation);
        }
        return null;
    }

    public static final List<e> b(Annotation[] annotationArr) {
        kotlin.jvm.internal.m.f(annotationArr, "<this>");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            arrayList.add(new e(annotation));
        }
        return arrayList;
    }
}
