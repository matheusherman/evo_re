package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class r {
    public static final s a(q qVar, ba.b classId, aa.e jvmMetadataVersion) {
        kotlin.jvm.internal.m.f(qVar, "<this>");
        kotlin.jvm.internal.m.f(classId, "classId");
        kotlin.jvm.internal.m.f(jvmMetadataVersion, "jvmMetadataVersion");
        q.a aVarB = qVar.b(classId, jvmMetadataVersion);
        if (aVarB != null) {
            return aVarB.a();
        }
        return null;
    }

    public static final s b(q qVar, u9.g javaClass, aa.e jvmMetadataVersion) {
        kotlin.jvm.internal.m.f(qVar, "<this>");
        kotlin.jvm.internal.m.f(javaClass, "javaClass");
        kotlin.jvm.internal.m.f(jvmMetadataVersion, "jvmMetadataVersion");
        q.a aVarC = qVar.c(javaClass, jvmMetadataVersion);
        if (aVarC != null) {
            return aVarC.a();
        }
        return null;
    }
}
