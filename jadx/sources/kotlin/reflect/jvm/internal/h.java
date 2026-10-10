package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0005\u0005\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0005\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/h;", "", "<init>", "()V", "", "a", "()Ljava/lang/String;", "b", "c", "d", "e", "Lkotlin/reflect/jvm/internal/h$a;", "Lkotlin/reflect/jvm/internal/h$b;", "Lkotlin/reflect/jvm/internal/h$c;", "Lkotlin/reflect/jvm/internal/h$d;", "Lkotlin/reflect/jvm/internal/h$e;", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class h {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000bR%\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\f8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011¨\u0006\u0013"}, d2 = {"Lkotlin/reflect/jvm/internal/h$a;", "Lkotlin/reflect/jvm/internal/h;", "Ljava/lang/Class;", "jClass", "<init>", "(Ljava/lang/Class;)V", "", "a", "()Ljava/lang/String;", "Ljava/lang/Class;", "getJClass", "()Ljava/lang/Class;", "", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "b", "Ljava/util/List;", "()Ljava/util/List;", "methods", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Class<?> jClass;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final List<Method> methods;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        public static final class b<T> implements Comparator {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                return t8.a.a(((Method) t10).getName(), ((Method) t11).getName());
            }
        }

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/reflect/Method;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 8, 0})
        static final class C0212a extends kotlin.jvm.internal.o implements c9.l<Method, CharSequence> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0212a f12430a = new C0212a();

            C0212a() {
                super(1);
            }

            @Override // c9.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final CharSequence invoke(Method method) {
                Class<?> returnType = method.getReturnType();
                kotlin.jvm.internal.m.e(returnType, "it.returnType");
                return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.b(returnType);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Class<?> jClass) {
            super(null);
            kotlin.jvm.internal.m.f(jClass, "jClass");
            this.jClass = jClass;
            Method[] declaredMethods = jClass.getDeclaredMethods();
            kotlin.jvm.internal.m.e(declaredMethods, "jClass.declaredMethods");
            this.methods = kotlin.collections.j.t0(declaredMethods, new b());
        }

        @Override // kotlin.reflect.jvm.internal.h
        /* JADX INFO: renamed from: a */
        public String get_signature() {
            return kotlin.collections.r.q0(this.methods, "", "<init>(", ")V", 0, null, C0212a.f12430a, 24, null);
        }

        public final List<Method> b() {
            return this.methods;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/h$b;", "Lkotlin/reflect/jvm/internal/h;", "Ljava/lang/reflect/Constructor;", "constructor", "<init>", "(Ljava/lang/reflect/Constructor;)V", "", "a", "()Ljava/lang/String;", "Ljava/lang/reflect/Constructor;", "b", "()Ljava/lang/reflect/Constructor;", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class b extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Constructor<?> constructor;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/lang/Class;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Class;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 8, 0})
        static final class a extends kotlin.jvm.internal.o implements c9.l<Class<?>, CharSequence> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f12432a = new a();

            a() {
                super(1);
            }

            @Override // c9.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final CharSequence invoke(Class<?> it) {
                kotlin.jvm.internal.m.e(it, "it");
                return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.b(it);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Constructor<?> constructor) {
            super(null);
            kotlin.jvm.internal.m.f(constructor, "constructor");
            this.constructor = constructor;
        }

        @Override // kotlin.reflect.jvm.internal.h
        /* JADX INFO: renamed from: a */
        public String get_signature() {
            Class<?>[] parameterTypes = this.constructor.getParameterTypes();
            kotlin.jvm.internal.m.e(parameterTypes, "constructor.parameterTypes");
            return kotlin.collections.j.d0(parameterTypes, "", "<init>(", ")V", 0, null, a.f12432a, 24, null);
        }

        public final Constructor<?> b() {
            return this.constructor;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/h$c;", "Lkotlin/reflect/jvm/internal/h;", "Ljava/lang/reflect/Method;", "method", "<init>", "(Ljava/lang/reflect/Method;)V", "", "a", "()Ljava/lang/String;", "Ljava/lang/reflect/Method;", "b", "()Ljava/lang/reflect/Method;", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class c extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Method method;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Method method) {
            super(null);
            kotlin.jvm.internal.m.f(method, "method");
            this.method = method;
        }

        @Override // kotlin.reflect.jvm.internal.h
        /* JADX INFO: renamed from: a */
        public String get_signature() {
            return l0.b(this.method);
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final Method getMethod() {
            return this.method;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\f\u0010\b¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/h$d;", "Lkotlin/reflect/jvm/internal/h;", "Laa/d$b;", "signature", "<init>", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "", "a", "()Ljava/lang/String;", "Laa/d$b;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "b", "Ljava/lang/String;", "_signature", "constructorDesc", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class d extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final aa.d.b signature;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final String _signature;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(aa.d.b signature) {
            super(null);
            kotlin.jvm.internal.m.f(signature, "signature");
            this.signature = signature;
            this._signature = signature.a();
        }

        @Override // kotlin.reflect.jvm.internal.h
        /* JADX INFO: renamed from: a, reason: from getter */
        public String get_signature() {
            return this._signature;
        }

        public final String b() {
            return this.signature.b();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\bR\u0011\u0010\u0011\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\f\u0010\b¨\u0006\u0012"}, d2 = {"Lkotlin/reflect/jvm/internal/h$e;", "Lkotlin/reflect/jvm/internal/h;", "Laa/d$b;", "signature", "<init>", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "", "a", "()Ljava/lang/String;", "Laa/d$b;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "b", "Ljava/lang/String;", "_signature", "c", "methodName", "methodDesc", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class e extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final aa.d.b signature;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final String _signature;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(aa.d.b signature) {
            super(null);
            kotlin.jvm.internal.m.f(signature, "signature");
            this.signature = signature;
            this._signature = signature.a();
        }

        @Override // kotlin.reflect.jvm.internal.h
        /* JADX INFO: renamed from: a, reason: from getter */
        public String get_signature() {
            return this._signature;
        }

        public final String b() {
            return this.signature.b();
        }

        public final String c() {
            return this.signature.c();
        }
    }

    public /* synthetic */ h(kotlin.jvm.internal.g gVar) {
        this();
    }

    /* JADX INFO: renamed from: a */
    public abstract String get_signature();

    private h() {
    }
}
