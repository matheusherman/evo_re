package l9;

import ba.b;
import ba.c;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.load.java.a0;
import kotlin.reflect.jvm.internal.impl.load.java.b0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.s;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f15247a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<b> f15248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final b f15249c;

    /* JADX INFO: renamed from: l9.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class C0301a implements s.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ y f15250a;

        C0301a(y yVar) {
            this.f15250a = yVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.c
        public s.a c(b classId, a1 source) {
            m.f(classId, "classId");
            m.f(source, "source");
            if (!m.a(classId, a0.f13097a.a())) {
                return null;
            }
            this.f15250a.element = true;
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.s.c
        public void a() {
        }
    }

    static {
        List listO = r.o(b0.f13109a, b0.f13119k, b0.f13120l, b0.f13112d, b0.f13114f, b0.f13117i);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = listO.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(b.m((c) it.next()));
        }
        f15248b = linkedHashSet;
        b bVarM = b.m(b0.f13118j);
        m.e(bVarM, "topLevel(JvmAnnotationNames.REPEATABLE_ANNOTATION)");
        f15249c = bVarM;
    }

    public final b a() {
        return f15249c;
    }

    public final Set<b> b() {
        return f15248b;
    }

    public final boolean c(s klass) {
        m.f(klass, "klass");
        y yVar = new y();
        klass.h(new C0301a(yVar), null);
        return yVar.element;
    }

    private a() {
    }
}
