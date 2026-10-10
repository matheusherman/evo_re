package p9;

import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.load.kotlin.q;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class g implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ClassLoader f17443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ja.d f17444b;

    public g(ClassLoader classLoader) {
        kotlin.jvm.internal.m.f(classLoader, "classLoader");
        this.f17443a = classLoader;
        this.f17444b = new ja.d();
    }

    private final q.a d(String str) {
        f fVarA;
        Class<?> clsA = e.a(this.f17443a, str);
        if (clsA == null || (fVarA = f.f17440c.a(clsA)) == null) {
            return null;
        }
        return new q.a.b(fVarA, null, 2, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.t
    public InputStream a(ba.c packageFqName) {
        kotlin.jvm.internal.m.f(packageFqName, "packageFqName");
        if (packageFqName.i(kotlin.reflect.jvm.internal.impl.builtins.k.f12592u)) {
            return this.f17444b.a(ja.a.f11649r.r(packageFqName));
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.q
    public q.a b(ba.b classId, aa.e jvmMetadataVersion) {
        kotlin.jvm.internal.m.f(classId, "classId");
        kotlin.jvm.internal.m.f(jvmMetadataVersion, "jvmMetadataVersion");
        return d(h.b(classId));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.q
    public q.a c(u9.g javaClass, aa.e jvmMetadataVersion) {
        String strB;
        kotlin.jvm.internal.m.f(javaClass, "javaClass");
        kotlin.jvm.internal.m.f(jvmMetadataVersion, "jvmMetadataVersion");
        ba.c cVarD = javaClass.d();
        if (cVarD == null || (strB = cVarD.b()) == null) {
            return null;
        }
        return d(strB);
    }
}
