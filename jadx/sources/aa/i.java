package aa;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import r8.p;
import w9.l;
import w9.n;
import w9.q;
import w9.u;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f190a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.protobuf.g f191b;

    static {
        kotlin.reflect.jvm.internal.impl.protobuf.g gVarD = kotlin.reflect.jvm.internal.impl.protobuf.g.d();
        z9.a.a(gVarD);
        m.e(gVarD, "newInstance().apply(JvmP…f::registerAllExtensions)");
        f191b = gVarD;
    }

    public static /* synthetic */ d.a d(i iVar, n nVar, y9.c cVar, y9.g gVar, boolean z10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = true;
        }
        return iVar.c(nVar, cVar, gVar, z10);
    }

    public static final boolean f(n proto) {
        m.f(proto, "proto");
        y9.b.C0480b c0480bA = c.f168a.a();
        Object objT = proto.t(z9.a.f23128e);
        m.e(objT, "proto.getExtension(JvmProtoBuf.flags)");
        Boolean boolD = c0480bA.d(((Number) objT).intValue());
        m.e(boolD, "JvmFlags.IS_MOVED_FROM_I…nsion(JvmProtoBuf.flags))");
        return boolD.booleanValue();
    }

    public static final p<f, w9.c> h(byte[] bytes, String[] strings) {
        m.f(bytes, "bytes");
        m.f(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        return new p<>(f190a.k(byteArrayInputStream, strings), w9.c.w1(byteArrayInputStream, f191b));
    }

    public static final p<f, w9.c> i(String[] data, String[] strings) {
        m.f(data, "data");
        m.f(strings, "strings");
        byte[] bArrE = a.e(data);
        m.e(bArrE, "decodeBytes(data)");
        return h(bArrE, strings);
    }

    public static final p<f, w9.i> j(String[] data, String[] strings) {
        m.f(data, "data");
        m.f(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a.e(data));
        return new p<>(f190a.k(byteArrayInputStream, strings), w9.i.E0(byteArrayInputStream, f191b));
    }

    private final f k(InputStream inputStream, String[] strArr) {
        z9.a.e eVarC = z9.a.e.C(inputStream, f191b);
        m.e(eVarC, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new f(eVarC, strArr);
    }

    public static final p<f, l> l(byte[] bytes, String[] strings) {
        m.f(bytes, "bytes");
        m.f(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        return new p<>(f190a.k(byteArrayInputStream, strings), l.d0(byteArrayInputStream, f191b));
    }

    public static final p<f, l> m(String[] data, String[] strings) {
        m.f(data, "data");
        m.f(strings, "strings");
        byte[] bArrE = a.e(data);
        m.e(bArrE, "decodeBytes(data)");
        return l(bArrE, strings);
    }

    public final kotlin.reflect.jvm.internal.impl.protobuf.g a() {
        return f191b;
    }

    public final d.b b(w9.d proto, y9.c nameResolver, y9.g typeTable) {
        String strQ0;
        m.f(proto, "proto");
        m.f(nameResolver, "nameResolver");
        m.f(typeTable, "typeTable");
        kotlin.reflect.jvm.internal.impl.protobuf.i.f<w9.d, z9.a.c> constructorSignature = z9.a.f23124a;
        m.e(constructorSignature, "constructorSignature");
        z9.a.c cVar = (z9.a.c) y9.e.a(proto, constructorSignature);
        String string = (cVar == null || !cVar.y()) ? "<init>" : nameResolver.getString(cVar.w());
        if (cVar == null || !cVar.x()) {
            List<u> listL = proto.L();
            m.e(listL, "proto.valueParameterList");
            List<u> list = listL;
            ArrayList arrayList = new ArrayList(r.w(list, 10));
            for (u it : list) {
                i iVar = f190a;
                m.e(it, "it");
                String strG = iVar.g(y9.f.q(it, typeTable), nameResolver);
                if (strG == null) {
                    return null;
                }
                arrayList.add(strG);
            }
            strQ0 = r.q0(arrayList, "", "(", ")V", 0, null, null, 56, null);
        } else {
            strQ0 = nameResolver.getString(cVar.v());
        }
        return new d.b(string, strQ0);
    }

    public final d.a c(n proto, y9.c nameResolver, y9.g typeTable, boolean z10) {
        String strG;
        m.f(proto, "proto");
        m.f(nameResolver, "nameResolver");
        m.f(typeTable, "typeTable");
        kotlin.reflect.jvm.internal.impl.protobuf.i.f<n, z9.a.d> propertySignature = z9.a.f23127d;
        m.e(propertySignature, "propertySignature");
        z9.a.d dVar = (z9.a.d) y9.e.a(proto, propertySignature);
        if (dVar == null) {
            return null;
        }
        z9.a.b bVarZ = dVar.E() ? dVar.z() : null;
        if (bVarZ == null && z10) {
            return null;
        }
        int iC0 = (bVarZ == null || !bVarZ.y()) ? proto.c0() : bVarZ.w();
        if (bVarZ == null || !bVarZ.x()) {
            strG = g(y9.f.n(proto, typeTable), nameResolver);
            if (strG == null) {
                return null;
            }
        } else {
            strG = nameResolver.getString(bVarZ.v());
        }
        return new d.a(nameResolver.getString(iC0), strG);
    }

    public final d.b e(w9.i proto, y9.c nameResolver, y9.g typeTable) {
        String string;
        m.f(proto, "proto");
        m.f(nameResolver, "nameResolver");
        m.f(typeTable, "typeTable");
        kotlin.reflect.jvm.internal.impl.protobuf.i.f<w9.i, z9.a.c> methodSignature = z9.a.f23125b;
        m.e(methodSignature, "methodSignature");
        z9.a.c cVar = (z9.a.c) y9.e.a(proto, methodSignature);
        int iD0 = (cVar == null || !cVar.y()) ? proto.d0() : cVar.w();
        if (cVar == null || !cVar.x()) {
            List listP = r.p(y9.f.k(proto, typeTable));
            List<u> listP0 = proto.p0();
            m.e(listP0, "proto.valueParameterList");
            List<u> list = listP0;
            ArrayList arrayList = new ArrayList(r.w(list, 10));
            for (u it : list) {
                m.e(it, "it");
                arrayList.add(y9.f.q(it, typeTable));
            }
            List listB0 = r.B0(listP, arrayList);
            ArrayList arrayList2 = new ArrayList(r.w(listB0, 10));
            Iterator it2 = listB0.iterator();
            while (it2.hasNext()) {
                String strG = f190a.g((q) it2.next(), nameResolver);
                if (strG == null) {
                    return null;
                }
                arrayList2.add(strG);
            }
            String strG2 = g(y9.f.m(proto, typeTable), nameResolver);
            if (strG2 == null) {
                return null;
            }
            string = r.q0(arrayList2, "", "(", ")", 0, null, null, 56, null) + strG2;
        } else {
            string = nameResolver.getString(cVar.v());
        }
        return new d.b(nameResolver.getString(iD0), string);
    }

    private i() {
    }

    private final String g(q qVar, y9.c cVar) {
        if (qVar.l0()) {
            return b.b(cVar.a(qVar.W()));
        }
        return null;
    }
}
