package ja;

import java.io.IOException;
import java.io.InputStream;
import ka.n;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.p;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c extends p implements kotlin.reflect.jvm.internal.impl.builtins.b {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f11651o = new a(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f11652n;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        private a() {
        }

        public final c a(ba.c fqName, n storageManager, h0 module, InputStream inputStream, boolean z10) throws IOException {
            m.f(fqName, "fqName");
            m.f(storageManager, "storageManager");
            m.f(module, "module");
            m.f(inputStream, "inputStream");
            r8.p<w9.m, x9.a> pVarA = x9.c.a(inputStream);
            w9.m mVarA = pVarA.a();
            x9.a aVarB = pVarA.b();
            if (mVarA != null) {
                return new c(fqName, storageManager, module, mVarA, aVarB, z10, null);
            }
            throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + x9.a.f22010h + ", actual " + aVarB + ". Please update Kotlin");
        }
    }

    public /* synthetic */ c(ba.c cVar, n nVar, h0 h0Var, w9.m mVar, x9.a aVar, boolean z10, g gVar) {
        this(cVar, nVar, h0Var, mVar, aVar, z10);
    }

    private c(ba.c cVar, n nVar, h0 h0Var, w9.m mVar, x9.a aVar, boolean z10) {
        super(cVar, nVar, h0Var, mVar, aVar, null);
        this.f11652n = z10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.z, kotlin.reflect.jvm.internal.impl.descriptors.impl.j
    public String toString() {
        return "builtins package fragment for " + d() + " from " + ea.c.p(this);
    }
}
