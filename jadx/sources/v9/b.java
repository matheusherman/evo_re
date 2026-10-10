package v9;

import ba.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.load.java.b0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.s;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class b implements s.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final boolean f19744j = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Map<ba.b, v9.a.EnumC0377a> f19745k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f19746a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f19747b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f19748c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f19749d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String[] f19750e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String[] f19751f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String[] f19752g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private v9.a.EnumC0377a f19753h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String[] f19754i = null;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: v9.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static abstract class AbstractC0379b implements s.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<String> f19755a = new ArrayList();

        private static /* synthetic */ void f(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "enumEntryName";
            } else if (i10 == 2) {
                objArr[0] = "classLiteralValue";
            } else if (i10 != 3) {
                objArr[0] = "enumClassId";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
            if (i10 == 2) {
                objArr[2] = "visitClassLiteral";
            } else if (i10 != 3) {
                objArr[2] = "visitEnum";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        protected abstract void g(String[] strArr);

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.b
        public void a() {
            g((String[]) this.f19755a.toArray(new String[0]));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.b
        public void b(Object obj) {
            if (obj instanceof String) {
                this.f19755a.add((String) obj);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.b
        public void c(ba.b bVar, f fVar) {
            if (bVar == null) {
                f(0);
            }
            if (fVar == null) {
                f(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.b
        public s.a d(ba.b bVar) {
            if (bVar != null) {
                return null;
            }
            f(3);
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.b
        public void e(kotlin.reflect.jvm.internal.impl.resolve.constants.f fVar) {
            if (fVar == null) {
                f(2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class c implements s.a {

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a extends AbstractC0379b {
            private static /* synthetic */ void f(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"));
            }

            a() {
            }

            @Override // v9.b.AbstractC0379b
            protected void g(String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                b.this.f19750e = strArr;
            }
        }

        /* JADX INFO: renamed from: v9.b$c$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class C0380b extends AbstractC0379b {
            private static /* synthetic */ void f(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2", "visitEnd"));
            }

            C0380b() {
            }

            @Override // v9.b.AbstractC0379b
            protected void g(String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                b.this.f19751f = strArr;
            }
        }

        private c() {
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "enumClassId";
            } else if (i10 == 2) {
                objArr[0] = "enumEntryName";
            } else if (i10 != 3) {
                objArr[0] = "classLiteralValue";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            if (i10 == 1 || i10 == 2) {
                objArr[2] = "visitEnum";
            } else if (i10 != 3) {
                objArr[2] = "visitClassLiteral";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
        public s.b b(f fVar) {
            String strF = fVar != null ? fVar.f() : null;
            if ("d1".equals(strF)) {
                return h();
            }
            if ("d2".equals(strF)) {
                return i();
            }
            return null;
        }

        /* synthetic */ c(b bVar, a aVar) {
            this();
        }

        private s.b h() {
            return new a();
        }

        private s.b i() {
            return new C0380b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
        public void c(f fVar, ba.b bVar, f fVar2) {
            if (bVar == null) {
                g(1);
            }
            if (fVar2 == null) {
                g(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
        public void d(f fVar, kotlin.reflect.jvm.internal.impl.resolve.constants.f fVar2) {
            if (fVar2 == null) {
                g(0);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
        public s.a e(f fVar, ba.b bVar) {
            if (bVar != null) {
                return null;
            }
            g(3);
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
        public void f(f fVar, Object obj) {
            if (fVar == null) {
                return;
            }
            String strF = fVar.f();
            if ("k".equals(strF)) {
                if (obj instanceof Integer) {
                    b.this.f19753h = v9.a.EnumC0377a.i(((Integer) obj).intValue());
                    return;
                }
                return;
            }
            if ("mv".equals(strF)) {
                if (obj instanceof int[]) {
                    b.this.f19746a = (int[]) obj;
                    return;
                }
                return;
            }
            if ("xs".equals(strF)) {
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.isEmpty()) {
                        return;
                    }
                    b.this.f19747b = str;
                    return;
                }
                return;
            }
            if ("xi".equals(strF)) {
                if (obj instanceof Integer) {
                    b.this.f19748c = ((Integer) obj).intValue();
                    return;
                }
                return;
            }
            if ("pn".equals(strF) && (obj instanceof String)) {
                String str2 = (String) obj;
                if (str2.isEmpty()) {
                    return;
                }
                b.this.f19749d = str2;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
        public void a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class d implements s.a {

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a extends AbstractC0379b {
            private static /* synthetic */ void f(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinSerializedIrArgumentVisitor$1", "visitEnd"));
            }

            a() {
            }

            @Override // v9.b.AbstractC0379b
            protected void g(String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                b.this.f19754i = strArr;
            }
        }

        private d() {
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "enumClassId";
            } else if (i10 == 2) {
                objArr[0] = "enumEntryName";
            } else if (i10 != 3) {
                objArr[0] = "classLiteralValue";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinSerializedIrArgumentVisitor";
            if (i10 == 1 || i10 == 2) {
                objArr[2] = "visitEnum";
            } else if (i10 != 3) {
                objArr[2] = "visitClassLiteral";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
        public s.b b(f fVar) {
            if ("b".equals(fVar != null ? fVar.f() : null)) {
                return h();
            }
            return null;
        }

        /* synthetic */ d(b bVar, a aVar) {
            this();
        }

        private s.b h() {
            return new a();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
        public void c(f fVar, ba.b bVar, f fVar2) {
            if (bVar == null) {
                g(1);
            }
            if (fVar2 == null) {
                g(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
        public void d(f fVar, kotlin.reflect.jvm.internal.impl.resolve.constants.f fVar2) {
            if (fVar2 == null) {
                g(0);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
        public s.a e(f fVar, ba.b bVar) {
            if (bVar != null) {
                return null;
            }
            g(3);
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
        public void a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
        public void f(f fVar, Object obj) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class e implements s.a {

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a extends AbstractC0379b {
            private static /* synthetic */ void f(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1", "visitEnd"));
            }

            a() {
            }

            @Override // v9.b.AbstractC0379b
            protected void g(String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                b.this.f19750e = strArr;
            }
        }

        /* JADX INFO: renamed from: v9.b$e$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class C0381b extends AbstractC0379b {
            private static /* synthetic */ void f(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2", "visitEnd"));
            }

            C0381b() {
            }

            @Override // v9.b.AbstractC0379b
            protected void g(String[] strArr) {
                if (strArr == null) {
                    f(0);
                }
                b.this.f19751f = strArr;
            }
        }

        private e() {
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "enumClassId";
            } else if (i10 == 2) {
                objArr[0] = "enumEntryName";
            } else if (i10 != 3) {
                objArr[0] = "classLiteralValue";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
            if (i10 == 1 || i10 == 2) {
                objArr[2] = "visitEnum";
            } else if (i10 != 3) {
                objArr[2] = "visitClassLiteral";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
        public s.b b(f fVar) {
            String strF = fVar != null ? fVar.f() : null;
            if ("data".equals(strF) || "filePartClassNames".equals(strF)) {
                return h();
            }
            if ("strings".equals(strF)) {
                return i();
            }
            return null;
        }

        /* synthetic */ e(b bVar, a aVar) {
            this();
        }

        private s.b h() {
            return new a();
        }

        private s.b i() {
            return new C0381b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
        public void c(f fVar, ba.b bVar, f fVar2) {
            if (bVar == null) {
                g(1);
            }
            if (fVar2 == null) {
                g(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
        public void d(f fVar, kotlin.reflect.jvm.internal.impl.resolve.constants.f fVar2) {
            if (fVar2 == null) {
                g(0);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
        public s.a e(f fVar, ba.b bVar) {
            if (bVar != null) {
                return null;
            }
            g(3);
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
        public void f(f fVar, Object obj) {
            if (fVar == null) {
                return;
            }
            String strF = fVar.f();
            if ("version".equals(strF)) {
                if (obj instanceof int[]) {
                    b.this.f19746a = (int[]) obj;
                }
            } else if ("multifileClassName".equals(strF)) {
                b.this.f19747b = obj instanceof String ? (String) obj : null;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.a
        public void a() {
        }
    }

    private static /* synthetic */ void d(int i10) {
        Object[] objArr = new Object[3];
        if (i10 != 1) {
            objArr[0] = "classId";
        } else {
            objArr[0] = "source";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        objArr[2] = "visitAnnotation";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    static {
        HashMap map = new HashMap();
        f19745k = map;
        map.put(ba.b.m(new ba.c("kotlin.jvm.internal.KotlinClass")), v9.a.EnumC0377a.CLASS);
        map.put(ba.b.m(new ba.c("kotlin.jvm.internal.KotlinFileFacade")), v9.a.EnumC0377a.FILE_FACADE);
        map.put(ba.b.m(new ba.c("kotlin.jvm.internal.KotlinMultifileClass")), v9.a.EnumC0377a.MULTIFILE_CLASS);
        map.put(ba.b.m(new ba.c("kotlin.jvm.internal.KotlinMultifileClassPart")), v9.a.EnumC0377a.MULTIFILE_CLASS_PART);
        map.put(ba.b.m(new ba.c("kotlin.jvm.internal.KotlinSyntheticClass")), v9.a.EnumC0377a.SYNTHETIC_CLASS);
    }

    private boolean o() {
        v9.a.EnumC0377a enumC0377a = this.f19753h;
        return enumC0377a == v9.a.EnumC0377a.CLASS || enumC0377a == v9.a.EnumC0377a.FILE_FACADE || enumC0377a == v9.a.EnumC0377a.MULTIFILE_CLASS_PART;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.c
    public s.a c(ba.b bVar, a1 a1Var) {
        v9.a.EnumC0377a enumC0377a;
        if (bVar == null) {
            d(0);
        }
        if (a1Var == null) {
            d(1);
        }
        ba.c cVarB = bVar.b();
        a aVar = null;
        if (cVarB.equals(b0.f13109a)) {
            return new c(this, aVar);
        }
        if (cVarB.equals(b0.f13127s)) {
            return new d(this, aVar);
        }
        if (f19744j || this.f19753h != null || (enumC0377a = f19745k.get(bVar)) == null) {
            return null;
        }
        this.f19753h = enumC0377a;
        return new e(this, aVar);
    }

    public v9.a m(aa.e eVar) {
        if (this.f19753h == null || this.f19746a == null) {
            return null;
        }
        aa.e eVar2 = new aa.e(this.f19746a, (this.f19748c & 8) != 0);
        if (!eVar2.h(eVar)) {
            this.f19752g = this.f19750e;
            this.f19750e = null;
        } else if (o() && this.f19750e == null) {
            return null;
        }
        String[] strArr = this.f19754i;
        return new v9.a(this.f19753h, eVar2, this.f19750e, this.f19752g, this.f19751f, this.f19747b, this.f19748c, this.f19749d, strArr != null ? aa.a.e(strArr) : null);
    }

    public v9.a n() {
        return m(aa.e.f177i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.c
    public void a() {
    }
}
