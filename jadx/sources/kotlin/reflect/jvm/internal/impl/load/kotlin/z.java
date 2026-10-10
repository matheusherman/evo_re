package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f13623a = new z();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.l<String, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13624a = new a();

        a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(String it) {
            kotlin.jvm.internal.m.f(it, "it");
            return z.f13623a.c(it);
        }
    }

    public final String[] b(String... signatures) {
        kotlin.jvm.internal.m.f(signatures, "signatures");
        ArrayList arrayList = new ArrayList(signatures.length);
        for (String str : signatures) {
            arrayList.add("<init>(" + str + ")V");
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public final Set<String> d(String internalName, String... signatures) {
        kotlin.jvm.internal.m.f(internalName, "internalName");
        kotlin.jvm.internal.m.f(signatures, "signatures");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str : signatures) {
            linkedHashSet.add(internalName + '.' + str);
        }
        return linkedHashSet;
    }

    public final Set<String> e(String name, String... signatures) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(signatures, "signatures");
        return d(h(name), (String[]) Arrays.copyOf(signatures, signatures.length));
    }

    public final Set<String> f(String name, String... signatures) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(signatures, "signatures");
        return d(i(name), (String[]) Arrays.copyOf(signatures, signatures.length));
    }

    public final String g(String name) {
        kotlin.jvm.internal.m.f(name, "name");
        return "java/util/function/" + name;
    }

    public final String h(String name) {
        kotlin.jvm.internal.m.f(name, "name");
        return "java/lang/" + name;
    }

    public final String i(String name) {
        kotlin.jvm.internal.m.f(name, "name");
        return "java/util/" + name;
    }

    public final String j(String name, List<String> parameters, String ret) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(parameters, "parameters");
        kotlin.jvm.internal.m.f(ret, "ret");
        return name + '(' + kotlin.collections.r.q0(parameters, "", null, null, 0, null, a.f13624a, 30, null) + ')' + c(ret);
    }

    public final String k(String internalName, String jvmDescriptor) {
        kotlin.jvm.internal.m.f(internalName, "internalName");
        kotlin.jvm.internal.m.f(jvmDescriptor, "jvmDescriptor");
        return internalName + '.' + jvmDescriptor;
    }

    private z() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c(String str) {
        if (str.length() > 1) {
            return 'L' + str + ';';
        }
        return str;
    }
}
