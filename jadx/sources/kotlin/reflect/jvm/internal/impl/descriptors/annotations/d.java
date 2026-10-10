package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.types.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g0 f12670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<ba.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> f12671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a1 f12672c;

    private static /* synthetic */ void b(int i10) {
        String str = (i10 == 3 || i10 == 4 || i10 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 3 || i10 == 4 || i10 == 5) ? 2 : 3];
        if (i10 == 1) {
            objArr[0] = "valueArguments";
        } else if (i10 == 2) {
            objArr[0] = "source";
        } else if (i10 == 3 || i10 == 4 || i10 == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[0] = "annotationType";
        }
        if (i10 == 3) {
            objArr[1] = "getType";
        } else if (i10 == 4) {
            objArr[1] = "getAllValueArguments";
        } else if (i10 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i10 != 3 && i10 != 4 && i10 != 5) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i10 != 3 && i10 != 4 && i10 != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public d(g0 g0Var, Map<ba.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> map, a1 a1Var) {
        if (g0Var == null) {
            b(0);
        }
        if (map == null) {
            b(1);
        }
        if (a1Var == null) {
            b(2);
        }
        this.f12670a = g0Var;
        this.f12671b = map;
        this.f12672c = a1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public Map<ba.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a() {
        Map<ba.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> map = this.f12671b;
        if (map == null) {
            b(4);
        }
        return map;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public a1 getSource() {
        a1 a1Var = this.f12672c;
        if (a1Var == null) {
            b(5);
        }
        return a1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public g0 getType() {
        g0 g0Var = this.f12670a;
        if (g0Var == null) {
            b(3);
        }
        return g0Var;
    }

    public String toString() {
        return kotlin.reflect.jvm.internal.impl.renderer.c.f13790g.r(this, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public ba.c d() {
        return c.a.a(this);
    }
}
