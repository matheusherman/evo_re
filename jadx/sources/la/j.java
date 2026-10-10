package la;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'n' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class j {
    public static final j D;
    public static final j G1;
    public static final j L;
    public static final j O1;
    public static final j T;
    public static final j W1;

    /* JADX INFO: renamed from: e2, reason: collision with root package name */
    public static final j f15300e2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final j f15313n;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final j f15321v;
    private final String debugMessage;
    private final boolean isUnresolved;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f15290a = new j("UNRESOLVED_TYPE", 0, "Unresolved type for %s", true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f15292b = new j("UNRESOLVED_TYPE_PARAMETER_TYPE", 1, "Unresolved type parameter type", true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f15295c = new j("UNRESOLVED_CLASS_TYPE", 2, "Unresolved class %s", true);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j f15297d = new j("UNRESOLVED_JAVA_CLASS", 3, "Unresolved java class %s", true);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final j f15299e = new j("UNRESOLVED_DECLARATION", 4, "Unresolved declaration %s", true);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j f15301f = new j("UNRESOLVED_KCLASS_CONSTANT_VALUE", 5, "Unresolved type for %s (arrayDimensions=%s)", true);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final j f15303g = new j("UNRESOLVED_TYPE_ALIAS", 6, "Unresolved type alias %s", false, 2, null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final j f15305h = new j("RETURN_TYPE", 7, "Return type for %s cannot be resolved", false, 2, null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final j f15307i = new j("RETURN_TYPE_FOR_FUNCTION", 8, "Return type for function cannot be resolved", false, 2, null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final j f15309j = new j("RETURN_TYPE_FOR_PROPERTY", 9, "Return type for property %s cannot be resolved", false, 2, null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final j f15310k = new j("RETURN_TYPE_FOR_CONSTRUCTOR", 10, "Return type for constructor %s cannot be resolved", false, 2, null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final j f15311l = new j("IMPLICIT_RETURN_TYPE_FOR_FUNCTION", 11, "Implicit return type for function %s cannot be resolved", false, 2, null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final j f15312m = new j("IMPLICIT_RETURN_TYPE_FOR_PROPERTY", 12, "Implicit return type for property %s cannot be resolved", false, 2, null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final j f15314o = new j("ERROR_TYPE_FOR_DESTRUCTURING_COMPONENT", 14, "%s() return type", false, 2, null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final j f15315p = new j("RECURSIVE_TYPE", 15, "Recursive type", false, 2, null);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final j f15316q = new j("RECURSIVE_TYPE_ALIAS", 16, "Recursive type alias %s", false, 2, null);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final j f15317r = new j("RECURSIVE_ANNOTATION_TYPE", 17, "Recursive annotation's type", false, 2, null);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final j f15318s = new j("CYCLIC_UPPER_BOUNDS", 18, "Cyclic upper bounds", false, 2, null);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final j f15319t = new j("CYCLIC_SUPERTYPES", 19, "Cyclic supertypes", false, 2, null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final j f15320u = new j("UNINFERRED_LAMBDA_CONTEXT_RECEIVER_TYPE", 20, "Cannot infer a lambda context receiver type", false, 2, null);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final j f15322w = new j("UNINFERRED_TYPE_VARIABLE", 22, "Cannot infer a type variable %s", false, 2, null);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final j f15323x = new j("RESOLUTION_ERROR_TYPE", 23, "Resolution error type (%s)", false, 2, null);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final j f15324y = new j("ERROR_EXPECTED_TYPE", 24, "Error expected type", false, 2, null);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final j f15325z = new j("ERROR_DATA_FLOW_TYPE", 25, "Error type for data flow", false, 2, null);
    public static final j A = new j("ERROR_WHILE_RECONSTRUCTING_BARE_TYPE", 26, "Failed to reconstruct type %s", false, 2, null);
    public static final j B = new j("UNABLE_TO_SUBSTITUTE_TYPE", 27, "Unable to substitute type (%s)", false, 2, null);
    public static final j C = new j("DONT_CARE", 28, "Special DONT_CARE type", false, 2, null);
    public static final j E = new j("FUNCTION_PLACEHOLDER_TYPE", 30, "Function placeholder type (arguments: %s)", false, 2, null);
    public static final j F = new j("TYPE_FOR_RESULT", 31, "Stubbed 'Result' type", false, 2, null);
    public static final j G = new j("TYPE_FOR_COMPILER_EXCEPTION", 32, "Error type for a compiler exception while analyzing %s", false, 2, null);
    public static final j H = new j("ERROR_FLEXIBLE_TYPE", 33, "Error java flexible type with id %s. (%s..%s)", false, 2, null);
    public static final j I = new j("ERROR_RAW_TYPE", 34, "Error raw type %s", false, 2, null);
    public static final j J = new j("TYPE_WITH_MISMATCHED_TYPE_ARGUMENTS_AND_PARAMETERS", 35, "Inconsistent type %s (parameters.size = %s, arguments.size = %s)", false, 2, null);
    public static final j K = new j("ILLEGAL_TYPE_RANGE_FOR_DYNAMIC", 36, "Illegal type range for dynamic type %s..%s", false, 2, null);
    public static final j M = new j("CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER_BY_NAME", 38, "Couldn't deserialize type parameter %s in %s", false, 2, null);
    public static final j N = new j("INCONSISTENT_SUSPEND_FUNCTION", 39, "Inconsistent suspend function type in metadata with constructor %s", false, 2, null);
    public static final j O = new j("UNEXPECTED_FLEXIBLE_TYPE_ID", 40, "Unexpected id of a flexible type %s. (%s..%s)", false, 2, null);
    public static final j P = new j("UNKNOWN_TYPE", 41, "Unknown type", false, 2, null);
    public static final j Q = new j("NO_TYPE_SPECIFIED", 42, "No type specified for %s", false, 2, null);
    public static final j R = new j("NO_TYPE_FOR_LOOP_RANGE", 43, "Loop range has no type", false, 2, null);
    public static final j S = new j("NO_TYPE_FOR_LOOP_PARAMETER", 44, "Loop parameter has no type", false, 2, null);
    public static final j U = new j("MISSED_TYPE_ARGUMENT_FOR_TYPE_PARAMETER", 46, "Missed a type argument for a type parameter %s", false, 2, null);
    public static final j V = new j("PARSE_ERROR_ARGUMENT", 47, "Error type for parse error argument %s", false, 2, null);
    public static final j W = new j("STAR_PROJECTION_IN_CALL", 48, "Error type for star projection directly passing as a call type argument", false, 2, null);
    public static final j X = new j("PROHIBITED_DYNAMIC_TYPE", 49, "Dynamic type in a not allowed context", false, 2, null);
    public static final j Y = new j("NOT_ANNOTATION_TYPE_IN_ANNOTATION_CONTEXT", 50, "Not an annotation type %s in the annotation context", false, 2, null);
    public static final j Z = new j("UNIT_RETURN_TYPE_FOR_INC_DEC", 51, "Unit type returned by inc or dec", false, 2, null);

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public static final j f15293b1 = new j("RETURN_NOT_ALLOWED", 52, "Return not allowed", false, 2, null);
    public static final j D1 = new j("UNRESOLVED_PARCEL_TYPE", 53, "Unresolved 'Parcel' type", true);
    public static final j E1 = new j("KAPT_ERROR_TYPE", 54, "Kapt error type", false, 2, null);
    public static final j F1 = new j("SYNTHETIC_ELEMENT_ERROR_TYPE", 55, "Error type for synthetic element", false, 2, null);
    public static final j H1 = new j("ERROR_EXPRESSION_TYPE", 57, "Error expression type", false, 2, null);
    public static final j I1 = new j("ERROR_RECEIVER_TYPE", 58, "Error receiver type for %s", false, 2, null);
    public static final j J1 = new j("ERROR_CONSTANT_VALUE", 59, "Error constant value %s", false, 2, null);
    public static final j K1 = new j("EMPTY_CALLABLE_REFERENCE", 60, "Empty callable reference", false, 2, null);
    public static final j L1 = new j("UNSUPPORTED_CALLABLE_REFERENCE_TYPE", 61, "Unsupported callable reference type %s", false, 2, null);
    public static final j M1 = new j("TYPE_FOR_DELEGATION", 62, "Error delegation type for %s", false, 2, null);
    public static final j N1 = new j("UNAVAILABLE_TYPE_FOR_DECLARATION", 63, "Type is unavailable for declaration %s", false, 2, null);
    public static final j P1 = new j("ERROR_TYPE_PROJECTION", 65, "Error type projection", false, 2, null);
    public static final j Q1 = new j("ERROR_SUPER_TYPE", 66, "Error super type", false, 2, null);
    public static final j R1 = new j("SUPER_TYPE_FOR_ERROR_TYPE", 67, "Supertype of error type %s", false, 2, null);
    public static final j S1 = new j("ERROR_PROPERTY_TYPE", 68, "Error property type", false, 2, null);
    public static final j T1 = new j("ERROR_CLASS", 69, "Error class", false, 2, null);
    public static final j U1 = new j("TYPE_FOR_ERROR_TYPE_CONSTRUCTOR", 70, "Type for error type constructor (%s)", false, 2, null);
    public static final j V1 = new j("INTERSECTION_OF_ERROR_TYPES", 71, "Intersection of error types %s", false, 2, null);
    public static final j X1 = new j("NOT_FOUND_UNSIGNED_TYPE", 73, "Unsigned type %s not found", false, 2, null);
    public static final j Y1 = new j("ERROR_ENUM_TYPE", 74, "Not found the corresponding enum class for given enum entry %s.%s", false, 2, null);
    public static final j Z1 = new j("NO_RECORDED_TYPE", 75, "Not found recorded type for %s", false, 2, null);

    /* JADX INFO: renamed from: a2, reason: collision with root package name */
    public static final j f15291a2 = new j("NOT_FOUND_DESCRIPTOR_FOR_FUNCTION", 76, "Descriptor not found for function %s", false, 2, null);

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public static final j f15294b2 = new j("NOT_FOUND_DESCRIPTOR_FOR_CLASS", 77, "Cannot build class type, descriptor not found for builder %s", false, 2, null);

    /* JADX INFO: renamed from: c2, reason: collision with root package name */
    public static final j f15296c2 = new j("NOT_FOUND_DESCRIPTOR_FOR_TYPE_PARAMETER", 78, "Cannot build type parameter type, descriptor not found for builder %s", false, 2, null);

    /* JADX INFO: renamed from: d2, reason: collision with root package name */
    public static final j f15298d2 = new j("UNMAPPED_ANNOTATION_TARGET_TYPE", 79, "Type for unmapped Java annotation target to Kotlin one", false, 2, null);

    /* JADX INFO: renamed from: f2, reason: collision with root package name */
    public static final j f15302f2 = new j("NOT_FOUND_FQNAME_FOR_JAVA_ANNOTATION", 81, "No fqName for annotation %s", false, 2, null);

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public static final j f15304g2 = new j("NOT_FOUND_FQNAME", 82, "No fqName for %s", false, 2, null);

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public static final j f15306h2 = new j("TYPE_FOR_GENERATED_ERROR_EXPRESSION", 83, "Type for generated error expression", false, 2, null);

    /* JADX INFO: renamed from: i2, reason: collision with root package name */
    private static final /* synthetic */ j[] f15308i2 = a();

    static {
        kotlin.jvm.internal.g gVar = null;
        f15313n = new j("IMPLICIT_RETURN_TYPE_FOR_PROPERTY_ACCESSOR", 13, "Implicit return type for property accessor %s cannot be resolved", false, 2, gVar);
        f15321v = new j("UNINFERRED_LAMBDA_PARAMETER_TYPE", 21, "Cannot infer a lambda parameter type", false, 2, gVar);
        D = new j("STUB_TYPE", 29, "Stub type %s", false, 2, gVar);
        L = new j("CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER", 37, "Unknown type parameter %s. Please try recompiling module containing \"%s\"", false, 2, gVar);
        T = new j("MISSED_TYPE_FOR_PARAMETER", 45, "Missed a type for a value parameter %s", false, 2, gVar);
        kotlin.jvm.internal.g gVar2 = null;
        G1 = new j("AD_HOC_ERROR_TYPE_FOR_LIGHTER_CLASSES_RESOLVE", 56, "Error type in ad hoc resolve for lighter classes", false, 2, gVar2);
        O1 = new j("ERROR_TYPE_PARAMETER", 64, "Error type parameter", false, 2, gVar2);
        W1 = new j("CANNOT_COMPUTE_ERASED_BOUND", 72, "Cannot compute erased upper bound of a type parameter %s", false, 2, gVar2);
        f15300e2 = new j("UNKNOWN_ARRAY_ELEMENT_TYPE_OF_ANNOTATION_ARGUMENT", 80, "Unknown type for an array element of a java annotation argument", false, 2, gVar2);
    }

    private j(String str, int i10, String str2, boolean z10) {
        super(str, i10);
        this.debugMessage = str2;
        this.isUnresolved = z10;
    }

    /* synthetic */ j(String str, int i10, String str2, boolean z10, int i11, kotlin.jvm.internal.g gVar) {
        this(str, i10, str2, (i11 & 2) != 0 ? false : z10);
    }

    private static final /* synthetic */ j[] a() {
        return new j[]{f15290a, f15292b, f15295c, f15297d, f15299e, f15301f, f15303g, f15305h, f15307i, f15309j, f15310k, f15311l, f15312m, f15313n, f15314o, f15315p, f15316q, f15317r, f15318s, f15319t, f15320u, f15321v, f15322w, f15323x, f15324y, f15325z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, f15293b1, D1, E1, F1, G1, H1, I1, J1, K1, L1, M1, N1, O1, P1, Q1, R1, S1, T1, U1, V1, W1, X1, Y1, Z1, f15291a2, f15294b2, f15296c2, f15298d2, f15300e2, f15302f2, f15304g2, f15306h2};
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) f15308i2.clone();
    }

    public final String f() {
        return this.debugMessage;
    }

    public final boolean i() {
        return this.isUnresolved;
    }
}
