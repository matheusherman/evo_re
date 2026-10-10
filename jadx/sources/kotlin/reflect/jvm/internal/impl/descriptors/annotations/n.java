package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.n0;
import kotlin.collections.r;
import r8.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public enum n {
    CLASS("class", false, 2, null),
    ANNOTATION_CLASS("annotation class", false, 2, null),
    TYPE_PARAMETER("type parameter", false),
    PROPERTY("property", false, 2, null),
    FIELD("field", false, 2, null),
    LOCAL_VARIABLE("local variable", false, 2, null),
    VALUE_PARAMETER("value parameter", false, 2, null),
    CONSTRUCTOR("constructor", false, 2, null),
    FUNCTION("function", false, 2, null),
    PROPERTY_GETTER("getter", false, 2, null),
    PROPERTY_SETTER("setter", false, 2, null),
    TYPE("type usage", false),
    EXPRESSION("expression", false),
    FILE("file", false),
    TYPEALIAS("typealias", false),
    TYPE_PROJECTION("type projection", false),
    STAR_PROJECTION("star projection", false),
    PROPERTY_PARAMETER("property constructor parameter", false),
    CLASS_ONLY("class", false),
    OBJECT("object", false),
    STANDALONE_OBJECT("standalone object", false),
    COMPANION_OBJECT("companion object", false),
    INTERFACE("interface", false),
    ENUM_CLASS("enum class", false),
    ENUM_ENTRY("enum entry", false),
    LOCAL_CLASS("local class", false),
    LOCAL_FUNCTION("local function", false),
    MEMBER_FUNCTION("member function", false),
    TOP_LEVEL_FUNCTION("top level function", false),
    MEMBER_PROPERTY("member property", false),
    MEMBER_PROPERTY_WITH_BACKING_FIELD("member property with backing field", false),
    MEMBER_PROPERTY_WITH_DELEGATE("member property with delegate", false),
    MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("member property without backing field or delegate", false),
    TOP_LEVEL_PROPERTY("top level property", false),
    TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD("top level property with backing field", false),
    TOP_LEVEL_PROPERTY_WITH_DELEGATE("top level property with delegate", false),
    TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("top level property without backing field or delegate", false),
    BACKING_FIELD("backing field", false, 2, null),
    INITIALIZER("initializer", false),
    DESTRUCTURING_DECLARATION("destructuring declaration", false),
    LAMBDA_EXPRESSION("lambda expression", false),
    ANONYMOUS_FUNCTION("anonymous function", false),
    OBJECT_LITERAL("object literal", false);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12705a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap<String, n> f12706b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set<n> f12708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<n> f12709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final List<n> f12710e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final List<n> f12711f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final List<n> f12712g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final List<n> f12713h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final List<n> f12714i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final List<n> f12715j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final List<n> f12716k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final List<n> f12717l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final List<n> f12718m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final List<n> f12719n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final List<n> f12720o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final List<n> f12721p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Map<e, n> f12722q;
    private final String description;
    private final boolean isDefault;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }
    }

    n(String str, boolean z10) {
        this.description = str;
        this.isDefault = z10;
    }

    static {
        for (n nVar : values()) {
            f12706b.put(nVar.name(), nVar);
        }
        n[] nVarArrValues = values();
        ArrayList arrayList = new ArrayList();
        for (n nVar2 : nVarArrValues) {
            if (nVar2.isDefault) {
                arrayList.add(nVar2);
            }
        }
        f12708c = r.S0(arrayList);
        f12709d = kotlin.collections.j.R0(values());
        n nVar3 = CLASS;
        f12710e = r.o(ANNOTATION_CLASS, nVar3);
        f12711f = r.o(LOCAL_CLASS, nVar3);
        f12712g = r.o(CLASS_ONLY, nVar3);
        n nVar4 = OBJECT;
        f12713h = r.o(COMPANION_OBJECT, nVar4, nVar3);
        f12714i = r.o(STANDALONE_OBJECT, nVar4, nVar3);
        f12715j = r.o(INTERFACE, nVar3);
        f12716k = r.o(ENUM_CLASS, nVar3);
        n nVar5 = PROPERTY;
        n nVar6 = FIELD;
        f12717l = r.o(ENUM_ENTRY, nVar5, nVar6);
        n nVar7 = PROPERTY_SETTER;
        f12718m = r.e(nVar7);
        n nVar8 = PROPERTY_GETTER;
        f12719n = r.e(nVar8);
        f12720o = r.e(FUNCTION);
        n nVar9 = FILE;
        f12721p = r.e(nVar9);
        e eVar = e.CONSTRUCTOR_PARAMETER;
        n nVar10 = VALUE_PARAMETER;
        f12722q = n0.l(v.a(eVar, nVar10), v.a(e.FIELD, nVar6), v.a(e.PROPERTY, nVar5), v.a(e.FILE, nVar9), v.a(e.PROPERTY_GETTER, nVar8), v.a(e.PROPERTY_SETTER, nVar7), v.a(e.RECEIVER, nVar10), v.a(e.SETTER_PARAMETER, nVar10), v.a(e.PROPERTY_DELEGATE_FIELD, nVar6));
    }

    /* synthetic */ n(String str, boolean z10, int i10, kotlin.jvm.internal.g gVar) {
        this(str, (i10 & 2) != 0 ? true : z10);
    }
}
