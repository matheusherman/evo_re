package kotlin.reflect.jvm.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0005\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0004\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lkotlin/reflect/jvm/internal/i;", "", "<init>", "()V", "", "a", "()Ljava/lang/String;", "b", "c", "d", "Lkotlin/reflect/jvm/internal/i$a;", "Lkotlin/reflect/jvm/internal/i$b;", "Lkotlin/reflect/jvm/internal/i$c;", "Lkotlin/reflect/jvm/internal/i$d;", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class i {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/i$a;", "Lkotlin/reflect/jvm/internal/i;", "Ljava/lang/reflect/Field;", "field", "<init>", "(Ljava/lang/reflect/Field;)V", "", "a", "()Ljava/lang/String;", "Ljava/lang/reflect/Field;", "b", "()Ljava/lang/reflect/Field;", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Field field;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Field field) {
            super(null);
            kotlin.jvm.internal.m.f(field, "field");
            this.field = field;
        }

        @Override // kotlin.reflect.jvm.internal.i
        /* JADX INFO: renamed from: a */
        public String getString() {
            StringBuilder sb2 = new StringBuilder();
            String name = this.field.getName();
            kotlin.jvm.internal.m.e(name, "field.name");
            sb2.append(kotlin.reflect.jvm.internal.impl.load.java.a0.b(name));
            sb2.append("()");
            Class<?> type = this.field.getType();
            kotlin.jvm.internal.m.e(type, "field.type");
            sb2.append(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.b(type));
            return sb2.toString();
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final Field getField() {
            return this.field;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lkotlin/reflect/jvm/internal/i$b;", "Lkotlin/reflect/jvm/internal/i;", "Ljava/lang/reflect/Method;", "getterMethod", "setterMethod", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "", "a", "()Ljava/lang/String;", "Ljava/lang/reflect/Method;", "b", "()Ljava/lang/reflect/Method;", "c", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class b extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Method getterMethod;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final Method setterMethod;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Method getterMethod, Method method) {
            super(null);
            kotlin.jvm.internal.m.f(getterMethod, "getterMethod");
            this.getterMethod = getterMethod;
            this.setterMethod = method;
        }

        @Override // kotlin.reflect.jvm.internal.i
        /* JADX INFO: renamed from: a */
        public String getString() {
            return l0.b(this.getterMethod);
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final Method getGetterMethod() {
            return this.getterMethod;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final Method getSetterMethod() {
            return this.setterMethod;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0019\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lkotlin/reflect/jvm/internal/i$c;", "Lkotlin/reflect/jvm/internal/i;", "Lkotlin/reflect/jvm/internal/impl/descriptors/u0;", "descriptor", "Lw9/n;", "proto", "Lz9/a$d;", "signature", "Ly9/c;", "nameResolver", "Ly9/g;", "typeTable", "<init>", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;)V", "", "c", "()Ljava/lang/String;", "a", "Lkotlin/reflect/jvm/internal/impl/descriptors/u0;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "b", "Lw9/n;", "getProto", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;", "Lz9/a$d;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "d", "Ly9/c;", "getNameResolver", "()Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;", "e", "Ly9/g;", "getTypeTable", "()Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;", "f", "Ljava/lang/String;", TypedValues.Custom.S_STRING, "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class c extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final u0 descriptor;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final w9.n proto;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final z9.a.d signature;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final y9.c nameResolver;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final y9.g typeTable;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final String string;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(u0 descriptor, w9.n proto, z9.a.d signature, y9.c nameResolver, y9.g typeTable) {
            String str;
            super(null);
            kotlin.jvm.internal.m.f(descriptor, "descriptor");
            kotlin.jvm.internal.m.f(proto, "proto");
            kotlin.jvm.internal.m.f(signature, "signature");
            kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
            kotlin.jvm.internal.m.f(typeTable, "typeTable");
            this.descriptor = descriptor;
            this.proto = proto;
            this.signature = signature;
            this.nameResolver = nameResolver;
            this.typeTable = typeTable;
            if (signature.F()) {
                str = nameResolver.getString(signature.A().w()) + nameResolver.getString(signature.A().v());
            } else {
                aa.d.a aVarD = aa.i.d(aa.i.f190a, proto, nameResolver, typeTable, false, 8, null);
                if (aVarD == null) {
                    throw new f0("No field signature for property: " + descriptor);
                }
                String strD = aVarD.d();
                str = kotlin.reflect.jvm.internal.impl.load.java.a0.b(strD) + c() + "()" + aVarD.e();
            }
            this.string = str;
        }

        private final String c() {
            String string;
            kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = this.descriptor.b();
            kotlin.jvm.internal.m.e(mVarB, "descriptor.containingDeclaration");
            if (kotlin.jvm.internal.m.a(this.descriptor.getVisibility(), kotlin.reflect.jvm.internal.impl.descriptors.t.f13067d) && (mVarB instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.d)) {
                w9.c cVarW0 = ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.d) mVarB).W0();
                kotlin.reflect.jvm.internal.impl.protobuf.i.f<w9.c, Integer> classModuleName = z9.a.f23132i;
                kotlin.jvm.internal.m.e(classModuleName, "classModuleName");
                Integer num = (Integer) y9.e.a(cVarW0, classModuleName);
                if (num == null || (string = this.nameResolver.getString(num.intValue())) == null) {
                    string = "main";
                }
                return '$' + ba.g.b(string);
            }
            if (!kotlin.jvm.internal.m.a(this.descriptor.getVisibility(), kotlin.reflect.jvm.internal.impl.descriptors.t.f13064a) || !(mVarB instanceof kotlin.reflect.jvm.internal.impl.descriptors.l0)) {
                return "";
            }
            u0 u0Var = this.descriptor;
            kotlin.jvm.internal.m.d(u0Var, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f fVarY = ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.j) u0Var).Y();
            if (!(fVarY instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.m)) {
                return "";
            }
            kotlin.reflect.jvm.internal.impl.load.kotlin.m mVar = (kotlin.reflect.jvm.internal.impl.load.kotlin.m) fVarY;
            if (mVar.f() == null) {
                return "";
            }
            return '$' + mVar.h().f();
        }

        @Override // kotlin.reflect.jvm.internal.i
        /* JADX INFO: renamed from: a, reason: from getter */
        public String getString() {
            return this.string;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final u0 getDescriptor() {
            return this.descriptor;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final y9.c getNameResolver() {
            return this.nameResolver;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final w9.n getProto() {
            return this.proto;
        }

        /* JADX INFO: renamed from: f, reason: from getter */
        public final z9.a.d getSignature() {
            return this.signature;
        }

        /* JADX INFO: renamed from: g, reason: from getter */
        public final y9.g getTypeTable() {
            return this.typeTable;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lkotlin/reflect/jvm/internal/i$d;", "Lkotlin/reflect/jvm/internal/i;", "Lkotlin/reflect/jvm/internal/h$e;", "getterSignature", "setterSignature", "<init>", "(Lkotlin/reflect/jvm/internal/h$e;Lkotlin/reflect/jvm/internal/h$e;)V", "", "a", "()Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/h$e;", "b", "()Lkotlin/reflect/jvm/internal/h$e;", "c", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class d extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final h.e getterSignature;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final h.e setterSignature;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(h.e getterSignature, h.e eVar) {
            super(null);
            kotlin.jvm.internal.m.f(getterSignature, "getterSignature");
            this.getterSignature = getterSignature;
            this.setterSignature = eVar;
        }

        @Override // kotlin.reflect.jvm.internal.i
        /* JADX INFO: renamed from: a */
        public String getString() {
            return this.getterSignature.get_signature();
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final h.e getGetterSignature() {
            return this.getterSignature;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final h.e getSetterSignature() {
            return this.setterSignature;
        }
    }

    public /* synthetic */ i(kotlin.jvm.internal.g gVar) {
        this();
    }

    /* JADX INFO: renamed from: a */
    public abstract String getString();

    private i() {
    }
}
