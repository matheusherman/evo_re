package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.r;
import kotlin.collections.v0;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.load.kotlin.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f12565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f12566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set<String> f12567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<String> f12568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Set<String> f12569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Set<String> f12570f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Set<String> f12571g;

    static {
        k kVar = new k();
        f12565a = kVar;
        z zVar = z.f13623a;
        f12566b = v0.l(zVar.f("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        f12567c = v0.k(v0.k(v0.k(v0.k(v0.k(v0.k(kVar.b(), zVar.f("List", "sort(Ljava/util/Comparator;)V")), zVar.e("String", "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;")), zVar.e("Double", "isInfinite()Z", "isNaN()Z")), zVar.e("Float", "isInfinite()Z", "isNaN()Z")), zVar.e("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V")), zVar.e("CharSequence", "isEmpty()Z"));
        f12568d = v0.k(v0.k(v0.k(v0.k(v0.k(v0.k(zVar.e("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), zVar.f("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V")), zVar.e("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;")), zVar.e("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V")), zVar.f("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z")), zVar.f("List", "replaceAll(Ljava/util/function/UnaryOperator;)V")), zVar.f("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
        f12569e = v0.k(v0.k(zVar.f("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), zVar.f("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V")), zVar.f("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
        Set<String> setA = kVar.a();
        String[] strArrB = zVar.b("D");
        Set setK = v0.k(setA, zVar.e("Float", (String[]) Arrays.copyOf(strArrB, strArrB.length)));
        String[] strArrB2 = zVar.b("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        f12570f = v0.k(setK, zVar.e("String", (String[]) Arrays.copyOf(strArrB2, strArrB2.length)));
        String[] strArrB3 = zVar.b("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        f12571g = zVar.e("Throwable", (String[]) Arrays.copyOf(strArrB3, strArrB3.length));
    }

    private final Set<String> a() {
        z zVar = z.f13623a;
        fa.e eVar = fa.e.BYTE;
        List listO = r.o(fa.e.BOOLEAN, eVar, fa.e.DOUBLE, fa.e.FLOAT, eVar, fa.e.INT, fa.e.LONG, fa.e.SHORT);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = listO.iterator();
        while (it.hasNext()) {
            String strF = ((fa.e) it.next()).m().g().f();
            m.e(strF, "it.wrapperFqName.shortName().asString()");
            String[] strArrB = zVar.b("Ljava/lang/String;");
            r.C(linkedHashSet, zVar.e(strF, (String[]) Arrays.copyOf(strArrB, strArrB.length)));
        }
        return linkedHashSet;
    }

    private final Set<String> b() {
        z zVar = z.f13623a;
        List<fa.e> listO = r.o(fa.e.BOOLEAN, fa.e.CHAR);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (fa.e eVar : listO) {
            String strF = eVar.m().g().f();
            m.e(strF, "it.wrapperFqName.shortName().asString()");
            r.C(linkedHashSet, zVar.e(strF, eVar.k() + "Value()" + eVar.j()));
        }
        return linkedHashSet;
    }

    public final Set<String> c() {
        return f12566b;
    }

    public final Set<String> d() {
        return f12570f;
    }

    public final Set<String> e() {
        return f12567c;
    }

    public final Set<String> f() {
        return f12569e;
    }

    public final Set<String> g() {
        return f12571g;
    }

    public final Set<String> h() {
        return f12568d;
    }

    public final boolean i(ba.d fqName) {
        m.f(fqName, "fqName");
        return m.a(fqName, kotlin.reflect.jvm.internal.impl.builtins.k.a.f12614i) || kotlin.reflect.jvm.internal.impl.builtins.k.e(fqName);
    }

    public final boolean j(ba.d fqName) {
        m.f(fqName, "fqName");
        if (i(fqName)) {
            return true;
        }
        ba.b bVarN = c.f12505a.n(fqName);
        if (bVarN == null) {
            return false;
        }
        try {
            return Serializable.class.isAssignableFrom(Class.forName(bVarN.b().b()));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private k() {
    }
}
