package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u00052\u00020\u0006:\u0001CB\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0013J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"R \u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b#\u0010%R9\u0010-\u001a$\u0012 \u0012\u001e (*\u000e\u0018\u00010'R\b\u0012\u0004\u0012\u00028\u00000\u00000'R\b\u0012\u0004\u0012\u00028\u00000\u00000&8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020.0\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0016\u00102\u001a\u0004\u0018\u00010 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\"R\u0016\u00104\u001a\u0004\u0018\u00010 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\"R\u0014\u00108\u001a\u0002058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010B\u001a\u00020=8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bA\u0010?¨\u0006D"}, d2 = {"Lkotlin/reflect/jvm/internal/k;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/jvm/internal/n;", "Li9/d;", "Lkotlin/reflect/jvm/internal/l;", "Lkotlin/reflect/jvm/internal/e0;", "Ljava/lang/Class;", "jClass", "<init>", "(Ljava/lang/Class;)V", "", "N", "()Ljava/lang/Void;", "Lba/f;", "name", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/u0;", "z", "(Lba/f;)Ljava/util/Collection;", "Lkotlin/reflect/jvm/internal/impl/descriptors/y;", "v", "", "index", "w", "(I)Lkotlin/reflect/jvm/internal/impl/descriptors/u0;", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "d", "Ljava/lang/Class;", "()Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/h0$b;", "Lkotlin/reflect/jvm/internal/k$a;", "kotlin.jvm.PlatformType", "e", "Lkotlin/reflect/jvm/internal/h0$b;", "J", "()Lkotlin/reflect/jvm/internal/h0$b;", "data", "Lkotlin/reflect/jvm/internal/impl/descriptors/l;", "u", "()Ljava/util/Collection;", "constructorDescriptors", "simpleName", "b", "qualifiedName", "Lba/b;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "classId", "Lkotlin/reflect/jvm/internal/impl/descriptors/e;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/h;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "memberScope", "getStaticScope$kotlin_reflection", "staticScope", "a", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class k<T> extends n implements i9.d<T>, l, e0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Class<T> jClass;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final h0.b<k<T>.a> data;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\n\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\f\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u001a\u0010\u0017R-\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d0\u001c8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\f\u0012\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R%\u0010'\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030$0\u001c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b&\u0010 R#\u0010-\u001a\u0004\u0018\u00018\u00008FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b(\u0010)\u0012\u0004\b,\u0010\"\u001a\u0004\b*\u0010+R!\u00101\u001a\b\u0012\u0004\u0012\u00020.0\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\f\u001a\u0004\b0\u0010\u0014R!\u00105\u001a\b\u0012\u0004\u0012\u0002020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\f\u001a\u0004\b4\u0010\u0014R)\u00108\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000$0\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\f\u001a\u0004\b7\u0010\u0014R%\u0010:\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003090\u001c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b%\u0010 R%\u0010;\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003090\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b(\u0010 R%\u0010=\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003090\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\f\u001a\u0004\b3\u0010 R%\u0010?\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003090\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\f\u001a\u0004\b6\u0010 R%\u0010A\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003090\u001c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\f\u001a\u0004\b\u0019\u0010 R%\u0010C\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003090\u001c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\f\u001a\u0004\b\u001e\u0010 R%\u0010F\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003090\u001c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\f\u001a\u0004\bE\u0010 R%\u0010I\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003090\u001c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\f\u001a\u0004\bH\u0010 ¨\u0006J"}, d2 = {"Lkotlin/reflect/jvm/internal/k$a;", "Lkotlin/reflect/jvm/internal/n$b;", "Lkotlin/reflect/jvm/internal/n;", "<init>", "(Lkotlin/reflect/jvm/internal/k;)V", "Ljava/lang/Class;", "jClass", "", "f", "(Ljava/lang/Class;)Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/descriptors/e;", "d", "Lkotlin/reflect/jvm/internal/h0$a;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor", "", "", "e", "getAnnotations", "()Ljava/util/List;", "annotations", "o", "()Ljava/lang/String;", "simpleName", "g", "n", "qualifiedName", "", "Li9/g;", "h", "getConstructors", "()Ljava/util/Collection;", "getConstructors$annotations", "()V", "constructors", "Li9/d;", "i", "getNestedClasses", "nestedClasses", "j", "Lkotlin/reflect/jvm/internal/h0$b;", "getObjectInstance", "()Ljava/lang/Object;", "getObjectInstance$annotations", "objectInstance", "Li9/o;", "k", "getTypeParameters", "typeParameters", "Li9/n;", "l", "getSupertypes", "supertypes", "m", "getSealedSubclasses", "sealedSubclasses", "Lkotlin/reflect/jvm/internal/j;", "declaredNonStaticMembers", "declaredStaticMembers", "p", "inheritedNonStaticMembers", "q", "inheritedStaticMembers", "r", "allNonStaticMembers", "s", "allStaticMembers", "t", "getDeclaredMembers", "declaredMembers", "u", "getAllMembers", "allMembers", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class a extends kotlin.reflect.jvm.internal.n.b {

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        static final /* synthetic */ i9.k<Object>[] f14492w = {kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(a.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(a.class), "annotations", "getAnnotations()Ljava/util/List;")), kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(a.class), "simpleName", "getSimpleName()Ljava/lang/String;")), kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(a.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(a.class), "constructors", "getConstructors()Ljava/util/Collection;")), kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(a.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(a.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(a.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(a.class), "supertypes", "getSupertypes()Ljava/util/List;")), kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(a.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(a.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(a.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(a.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(a.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(a.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(a.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(a.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(a.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final h0.a descriptor;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final h0.a annotations;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final h0.a simpleName;

        /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
        private final h0.a qualifiedName;

        /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final h0.a constructors;

        /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final h0.a nestedClasses;

        /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
        private final h0.b objectInstance;

        /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
        private final h0.a typeParameters;

        /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
        private final h0.a supertypes;

        /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final h0.a sealedSubclasses;

        /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
        private final h0.a declaredNonStaticMembers;

        /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
        private final h0.a declaredStaticMembers;

        /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
        private final h0.a inheritedNonStaticMembers;

        /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
        private final h0.a inheritedStaticMembers;

        /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
        private final h0.a allNonStaticMembers;

        /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
        private final h0.a allStaticMembers;

        /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
        private final h0.a declaredMembers;

        /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
        private final h0.a allMembers;

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.k$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003 \u0004*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/reflect/jvm/internal/j;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        static final class C0275a extends kotlin.jvm.internal.o implements c9.a<List<? extends kotlin.reflect.jvm.internal.j<?>>> {
            final /* synthetic */ k<T>.a this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0275a(k<T>.a aVar) {
                super(0);
                this.this$0 = aVar;
            }

            @Override // c9.a
            public final List<? extends kotlin.reflect.jvm.internal.j<?>> invoke() {
                return kotlin.collections.r.B0(this.this$0.g(), this.this$0.h());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003 \u0004*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/reflect/jvm/internal/j;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        static final class b extends kotlin.jvm.internal.o implements c9.a<List<? extends kotlin.reflect.jvm.internal.j<?>>> {
            final /* synthetic */ k<T>.a this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(k<T>.a aVar) {
                super(0);
                this.this$0 = aVar;
            }

            @Override // c9.a
            public final List<? extends kotlin.reflect.jvm.internal.j<?>> invoke() {
                return kotlin.collections.r.B0(this.this$0.i(), this.this$0.l());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003 \u0004*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/reflect/jvm/internal/j;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        static final class c extends kotlin.jvm.internal.o implements c9.a<List<? extends kotlin.reflect.jvm.internal.j<?>>> {
            final /* synthetic */ k<T>.a this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(k<T>.a aVar) {
                super(0);
                this.this$0 = aVar;
            }

            @Override // c9.a
            public final List<? extends kotlin.reflect.jvm.internal.j<?>> invoke() {
                return kotlin.collections.r.B0(this.this$0.j(), this.this$0.m());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
        static final class d extends kotlin.jvm.internal.o implements c9.a<List<? extends Annotation>> {
            final /* synthetic */ k<T>.a this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(k<T>.a aVar) {
                super(0);
                this.this$0 = aVar;
            }

            @Override // c9.a
            public final List<? extends Annotation> invoke() {
                return n0.e(this.this$0.k());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003 \u0004*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "Li9/g;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        static final class e extends kotlin.jvm.internal.o implements c9.a<List<? extends i9.g<? extends T>>> {
            final /* synthetic */ k<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            e(k<T> kVar) {
                super(0);
                this.this$0 = kVar;
            }

            @Override // c9.a
            public final List<i9.g<T>> invoke() {
                Collection<kotlin.reflect.jvm.internal.impl.descriptors.l> collectionU = this.this$0.u();
                k<T> kVar = this.this$0;
                ArrayList arrayList = new ArrayList(kotlin.collections.r.w(collectionU, 10));
                Iterator<T> it = collectionU.iterator();
                while (it.hasNext()) {
                    arrayList.add(new kotlin.reflect.jvm.internal.o(kVar, (kotlin.reflect.jvm.internal.impl.descriptors.l) it.next()));
                }
                return arrayList;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003 \u0004*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/reflect/jvm/internal/j;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        static final class f extends kotlin.jvm.internal.o implements c9.a<List<? extends kotlin.reflect.jvm.internal.j<?>>> {
            final /* synthetic */ k<T>.a this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            f(k<T>.a aVar) {
                super(0);
                this.this$0 = aVar;
            }

            @Override // c9.a
            public final List<? extends kotlin.reflect.jvm.internal.j<?>> invoke() {
                return kotlin.collections.r.B0(this.this$0.i(), this.this$0.j());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003 \u0004*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/reflect/jvm/internal/j;", "kotlin.jvm.PlatformType", "a", "()Ljava/util/Collection;"}, k = 3, mv = {1, 8, 0})
        static final class g extends kotlin.jvm.internal.o implements c9.a<Collection<? extends kotlin.reflect.jvm.internal.j<?>>> {
            final /* synthetic */ k<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            g(k<T> kVar) {
                super(0);
                this.this$0 = kVar;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Collection<kotlin.reflect.jvm.internal.j<?>> invoke() {
                k<T> kVar = this.this$0;
                return kVar.x(kVar.L(), kotlin.reflect.jvm.internal.n.c.DECLARED);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003 \u0004*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/reflect/jvm/internal/j;", "kotlin.jvm.PlatformType", "a", "()Ljava/util/Collection;"}, k = 3, mv = {1, 8, 0})
        static final class h extends kotlin.jvm.internal.o implements c9.a<Collection<? extends kotlin.reflect.jvm.internal.j<?>>> {
            final /* synthetic */ k<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            h(k<T> kVar) {
                super(0);
                this.this$0 = kVar;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Collection<kotlin.reflect.jvm.internal.j<?>> invoke() {
                k<T> kVar = this.this$0;
                return kVar.x(kVar.M(), kotlin.reflect.jvm.internal.n.c.DECLARED);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/jvm/internal/impl/descriptors/e;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/impl/descriptors/e;"}, k = 3, mv = {1, 8, 0})
        static final class i extends kotlin.jvm.internal.o implements c9.a<kotlin.reflect.jvm.internal.impl.descriptors.e> {
            final /* synthetic */ k<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            i(k<T> kVar) {
                super(0);
                this.this$0 = kVar;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final kotlin.reflect.jvm.internal.impl.descriptors.e invoke() throws InvocationTargetException {
                ba.b bVarI = this.this$0.I();
                p9.k kVarA = this.this$0.J().invoke().a();
                kotlin.reflect.jvm.internal.impl.descriptors.e eVarB = bVarI.k() ? kVarA.a().b(bVarI) : kotlin.reflect.jvm.internal.impl.descriptors.x.a(kVarA.b(), bVarI);
                if (eVarB != null) {
                    return eVarB;
                }
                this.this$0.N();
                throw null;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003 \u0004*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/reflect/jvm/internal/j;", "kotlin.jvm.PlatformType", "a", "()Ljava/util/Collection;"}, k = 3, mv = {1, 8, 0})
        static final class j extends kotlin.jvm.internal.o implements c9.a<Collection<? extends kotlin.reflect.jvm.internal.j<?>>> {
            final /* synthetic */ k<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            j(k<T> kVar) {
                super(0);
                this.this$0 = kVar;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Collection<kotlin.reflect.jvm.internal.j<?>> invoke() {
                k<T> kVar = this.this$0;
                return kVar.x(kVar.L(), kotlin.reflect.jvm.internal.n.c.INHERITED);
            }
        }

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.k$a$k, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003 \u0004*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/reflect/jvm/internal/j;", "kotlin.jvm.PlatformType", "a", "()Ljava/util/Collection;"}, k = 3, mv = {1, 8, 0})
        static final class C0276k extends kotlin.jvm.internal.o implements c9.a<Collection<? extends kotlin.reflect.jvm.internal.j<?>>> {
            final /* synthetic */ k<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0276k(k<T> kVar) {
                super(0);
                this.this$0 = kVar;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Collection<kotlin.reflect.jvm.internal.j<?>> invoke() {
                k<T> kVar = this.this$0;
                return kVar.x(kVar.M(), kotlin.reflect.jvm.internal.n.c.INHERITED);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a6\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00000\u00000\u0003 \u0004*\u001a\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00000\u00000\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/reflect/jvm/internal/k;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        static final class l extends kotlin.jvm.internal.o implements c9.a<List<? extends k<? extends Object>>> {
            final /* synthetic */ k<T>.a this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            l(k<T>.a aVar) {
                super(0);
                this.this$0 = aVar;
            }

            @Override // c9.a
            public final List<? extends k<? extends Object>> invoke() {
                kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarU0 = this.this$0.k().u0();
                kotlin.jvm.internal.m.e(hVarU0, "descriptor.unsubstitutedInnerClassesScope");
                Collection collectionA = kotlin.reflect.jvm.internal.impl.resolve.scopes.k.a.a(hVarU0, null, null, 3, null);
                ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.m> arrayList = new ArrayList();
                for (T t10 : collectionA) {
                    if (!kotlin.reflect.jvm.internal.impl.resolve.e.B((kotlin.reflect.jvm.internal.impl.descriptors.m) t10)) {
                        arrayList.add(t10);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (kotlin.reflect.jvm.internal.impl.descriptors.m mVar : arrayList) {
                    kotlin.reflect.jvm.internal.impl.descriptors.e eVar = mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.e ? (kotlin.reflect.jvm.internal.impl.descriptors.e) mVar : null;
                    Class<?> clsP = eVar != null ? n0.p(eVar) : null;
                    k kVar = clsP != null ? new k(clsP) : null;
                    if (kVar != null) {
                        arrayList2.add(kVar);
                    }
                }
                return arrayList2;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        static final class m extends kotlin.jvm.internal.o implements c9.a<T> {
            final /* synthetic */ k<T>.a this$0;
            final /* synthetic */ k<T> this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            m(k<T>.a aVar, k<T> kVar) {
                super(0);
                this.this$0 = aVar;
                this.this$1 = kVar;
            }

            @Override // c9.a
            public final T invoke() {
                kotlin.reflect.jvm.internal.impl.descriptors.e eVarK = this.this$0.k();
                if (eVarK.g() != kotlin.reflect.jvm.internal.impl.descriptors.f.OBJECT) {
                    return null;
                }
                T t10 = (T) ((!eVarK.t() || kotlin.reflect.jvm.internal.impl.builtins.d.a(kotlin.reflect.jvm.internal.impl.builtins.c.f12458a, eVarK)) ? this.this$1.d().getDeclaredField("INSTANCE") : this.this$1.d().getEnclosingClass().getDeclaredField(eVarK.getName().f())).get(null);
                kotlin.jvm.internal.m.d(t10, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.KClassImpl");
                return t10;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
        static final class n extends kotlin.jvm.internal.o implements c9.a<String> {
            final /* synthetic */ k<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            n(k<T> kVar) {
                super(0);
                this.this$0 = kVar;
            }

            @Override // c9.a
            public final String invoke() {
                if (this.this$0.d().isAnonymousClass()) {
                    return null;
                }
                ba.b bVarI = this.this$0.I();
                if (bVarI.k()) {
                    return null;
                }
                return bVarI.b().b();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a&\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003 \u0004*\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/reflect/jvm/internal/k;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        static final class o extends kotlin.jvm.internal.o implements c9.a<List<? extends k<? extends T>>> {
            final /* synthetic */ k<T>.a this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            o(k<T>.a aVar) {
                super(0);
                this.this$0 = aVar;
            }

            @Override // c9.a
            public final List<k<? extends T>> invoke() {
                Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> collectionE = this.this$0.k().E();
                kotlin.jvm.internal.m.e(collectionE, "descriptor.sealedSubclasses");
                ArrayList arrayList = new ArrayList();
                for (kotlin.reflect.jvm.internal.impl.descriptors.e eVar : collectionE) {
                    kotlin.jvm.internal.m.d(eVar, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    Class<?> clsP = n0.p(eVar);
                    k kVar = clsP != null ? new k(clsP) : null;
                    if (kVar != null) {
                        arrayList.add(kVar);
                    }
                }
                return arrayList;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
        static final class p extends kotlin.jvm.internal.o implements c9.a<String> {
            final /* synthetic */ k<T> this$0;
            final /* synthetic */ k<T>.a this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            p(k<T> kVar, k<T>.a aVar) {
                super(0);
                this.this$0 = kVar;
                this.this$1 = aVar;
            }

            @Override // c9.a
            public final String invoke() {
                if (this.this$0.d().isAnonymousClass()) {
                    return null;
                }
                ba.b bVarI = this.this$0.I();
                if (bVarI.k()) {
                    return this.this$1.f(this.this$0.d());
                }
                String strF = bVarI.j().f();
                kotlin.jvm.internal.m.e(strF, "classId.shortClassName.asString()");
                return strF;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/reflect/jvm/internal/c0;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        static final class q extends kotlin.jvm.internal.o implements c9.a<List<? extends c0>> {
            final /* synthetic */ k<T>.a this$0;
            final /* synthetic */ k<T> this$1;

            /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.k$a$q$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/reflect/Type;", "a", "()Ljava/lang/reflect/Type;"}, k = 3, mv = {1, 8, 0})
            static final class C0277a extends kotlin.jvm.internal.o implements c9.a<Type> {
                final /* synthetic */ kotlin.reflect.jvm.internal.impl.types.g0 $kotlinType;
                final /* synthetic */ k<T>.a this$0;
                final /* synthetic */ k<T> this$1;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0277a(kotlin.reflect.jvm.internal.impl.types.g0 g0Var, k<T>.a aVar, k<T> kVar) {
                    super(0);
                    this.$kotlinType = g0Var;
                    this.this$0 = aVar;
                    this.this$1 = kVar;
                }

                @Override // c9.a
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Type invoke() {
                    kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = this.$kotlinType.J0().d();
                    if (!(hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.e)) {
                        throw new f0("Supertype not a class: " + hVarD);
                    }
                    Class<?> clsP = n0.p((kotlin.reflect.jvm.internal.impl.descriptors.e) hVarD);
                    if (clsP == null) {
                        throw new f0("Unsupported superclass of " + this.this$0 + ": " + hVarD);
                    }
                    if (kotlin.jvm.internal.m.a(this.this$1.d().getSuperclass(), clsP)) {
                        Type genericSuperclass = this.this$1.d().getGenericSuperclass();
                        kotlin.jvm.internal.m.e(genericSuperclass, "{\n                      …ass\n                    }");
                        return genericSuperclass;
                    }
                    Class<?>[] interfaces = this.this$1.d().getInterfaces();
                    kotlin.jvm.internal.m.e(interfaces, "jClass.interfaces");
                    int iW = kotlin.collections.j.W(interfaces, clsP);
                    if (iW >= 0) {
                        Type type = this.this$1.d().getGenericInterfaces()[iW];
                        kotlin.jvm.internal.m.e(type, "{\n                      …ex]\n                    }");
                        return type;
                    }
                    throw new f0("No superclass of " + this.this$0 + " in Java reflection for " + hVarD);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/reflect/Type;", "a", "()Ljava/lang/reflect/Type;"}, k = 3, mv = {1, 8, 0})
            static final class b extends kotlin.jvm.internal.o implements c9.a<Type> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final b f14512a = new b();

                b() {
                    super(0);
                }

                @Override // c9.a
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Type invoke() {
                    return Object.class;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            q(k<T>.a aVar, k<T> kVar) {
                super(0);
                this.this$0 = aVar;
                this.this$1 = kVar;
            }

            @Override // c9.a
            public final List<? extends c0> invoke() {
                Collection<kotlin.reflect.jvm.internal.impl.types.g0> collectionB = this.this$0.k().h().b();
                kotlin.jvm.internal.m.e(collectionB, "descriptor.typeConstructor.supertypes");
                ArrayList arrayList = new ArrayList(collectionB.size());
                k<T>.a aVar = this.this$0;
                k<T> kVar = this.this$1;
                for (kotlin.reflect.jvm.internal.impl.types.g0 kotlinType : collectionB) {
                    kotlin.jvm.internal.m.e(kotlinType, "kotlinType");
                    arrayList.add(new c0(kotlinType, new C0277a(kotlinType, aVar, kVar)));
                }
                if (!kotlin.reflect.jvm.internal.impl.builtins.h.u0(this.this$0.k())) {
                    if (arrayList.isEmpty()) {
                        kotlin.reflect.jvm.internal.impl.types.o0 o0VarI = ea.c.j(this.this$0.k()).i();
                        kotlin.jvm.internal.m.e(o0VarI, "descriptor.builtIns.anyType");
                        arrayList.add(new c0(o0VarI, b.f14512a));
                    } else {
                        Iterator<T> it = arrayList.iterator();
                        while (it.hasNext()) {
                            kotlin.reflect.jvm.internal.impl.descriptors.f fVarG = kotlin.reflect.jvm.internal.impl.resolve.e.e(((c0) it.next()).getTv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TYPE java.lang.String()).g();
                            kotlin.jvm.internal.m.e(fVarG, "getClassDescriptorForType(it.type).kind");
                            if (fVarG == kotlin.reflect.jvm.internal.impl.descriptors.f.INTERFACE || fVarG == kotlin.reflect.jvm.internal.impl.descriptors.f.ANNOTATION_CLASS) {
                            }
                        }
                        kotlin.reflect.jvm.internal.impl.types.o0 o0VarI2 = ea.c.j(this.this$0.k()).i();
                        kotlin.jvm.internal.m.e(o0VarI2, "descriptor.builtIns.anyType");
                        arrayList.add(new c0(o0VarI2, b.f14512a));
                    }
                }
                return sa.a.c(arrayList);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/reflect/jvm/internal/d0;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        static final class r extends kotlin.jvm.internal.o implements c9.a<List<? extends d0>> {
            final /* synthetic */ k<T>.a this$0;
            final /* synthetic */ k<T> this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            r(k<T>.a aVar, k<T> kVar) {
                super(0);
                this.this$0 = aVar;
                this.this$1 = kVar;
            }

            @Override // c9.a
            public final List<? extends d0> invoke() {
                List<f1> listR = this.this$0.k().r();
                kotlin.jvm.internal.m.e(listR, "descriptor.declaredTypeParameters");
                List<f1> list = listR;
                k<T> kVar = this.this$1;
                ArrayList arrayList = new ArrayList(kotlin.collections.r.w(list, 10));
                for (f1 descriptor : list) {
                    kotlin.jvm.internal.m.e(descriptor, "descriptor");
                    arrayList.add(new d0(kVar, descriptor));
                }
                return arrayList;
            }
        }

        public a() {
            super();
            this.descriptor = h0.c(new i(k.this));
            this.annotations = h0.c(new d(this));
            this.simpleName = h0.c(new p(k.this, this));
            this.qualifiedName = h0.c(new n(k.this));
            this.constructors = h0.c(new e(k.this));
            this.nestedClasses = h0.c(new l(this));
            this.objectInstance = h0.b(new m(this, k.this));
            this.typeParameters = h0.c(new r(this, k.this));
            this.supertypes = h0.c(new q(this, k.this));
            this.sealedSubclasses = h0.c(new o(this));
            this.declaredNonStaticMembers = h0.c(new g(k.this));
            this.declaredStaticMembers = h0.c(new h(k.this));
            this.inheritedNonStaticMembers = h0.c(new j(k.this));
            this.inheritedStaticMembers = h0.c(new C0276k(k.this));
            this.allNonStaticMembers = h0.c(new b(this));
            this.allStaticMembers = h0.c(new c(this));
            this.declaredMembers = h0.c(new f(this));
            this.allMembers = h0.c(new C0275a(this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<kotlin.reflect.jvm.internal.j<?>> j() {
            T tB = this.declaredStaticMembers.b(this, f14492w[11]);
            kotlin.jvm.internal.m.e(tB, "<get-declaredStaticMembers>(...)");
            return (Collection) tB;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<kotlin.reflect.jvm.internal.j<?>> l() {
            T tB = this.inheritedNonStaticMembers.b(this, f14492w[12]);
            kotlin.jvm.internal.m.e(tB, "<get-inheritedNonStaticMembers>(...)");
            return (Collection) tB;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<kotlin.reflect.jvm.internal.j<?>> m() {
            T tB = this.inheritedStaticMembers.b(this, f14492w[13]);
            kotlin.jvm.internal.m.e(tB, "<get-inheritedStaticMembers>(...)");
            return (Collection) tB;
        }

        public final Collection<kotlin.reflect.jvm.internal.j<?>> g() {
            T tB = this.allNonStaticMembers.b(this, f14492w[14]);
            kotlin.jvm.internal.m.e(tB, "<get-allNonStaticMembers>(...)");
            return (Collection) tB;
        }

        public final Collection<kotlin.reflect.jvm.internal.j<?>> h() {
            T tB = this.allStaticMembers.b(this, f14492w[15]);
            kotlin.jvm.internal.m.e(tB, "<get-allStaticMembers>(...)");
            return (Collection) tB;
        }

        public final Collection<kotlin.reflect.jvm.internal.j<?>> i() {
            T tB = this.declaredNonStaticMembers.b(this, f14492w[10]);
            kotlin.jvm.internal.m.e(tB, "<get-declaredNonStaticMembers>(...)");
            return (Collection) tB;
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.e k() {
            T tB = this.descriptor.b(this, f14492w[0]);
            kotlin.jvm.internal.m.e(tB, "<get-descriptor>(...)");
            return (kotlin.reflect.jvm.internal.impl.descriptors.e) tB;
        }

        public final String n() {
            return (String) this.qualifiedName.b(this, f14492w[3]);
        }

        public final String o() {
            return (String) this.simpleName.b(this, f14492w[2]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String f(Class<?> jClass) {
            String name = jClass.getSimpleName();
            Method enclosingMethod = jClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                kotlin.jvm.internal.m.e(name, "name");
                return ua.n.I0(name, enclosingMethod.getName() + '$', null, 2, null);
            }
            Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
            if (enclosingConstructor != null) {
                kotlin.jvm.internal.m.e(name, "name");
                return ua.n.I0(name, enclosingConstructor.getName() + '$', null, 2, null);
            }
            kotlin.jvm.internal.m.e(name, "name");
            return ua.n.H0(name, '$', null, 2, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u001e \u0004*\u000e\u0018\u00010\u0002R\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002R\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/jvm/internal/k$a;", "Lkotlin/reflect/jvm/internal/k;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/k$a;"}, k = 3, mv = {1, 8, 0})
    static final class c extends kotlin.jvm.internal.o implements c9.a<k<T>.a> {
        final /* synthetic */ k<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(k<T> kVar) {
            super(0);
            this.this$0 = kVar;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final k<T>.a invoke() {
            return this.this$0.new a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class d extends kotlin.jvm.internal.j implements c9.p<kotlin.reflect.jvm.internal.impl.serialization.deserialization.v, w9.n, u0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f14514a = new d();

        d() {
            super(2);
        }

        @Override // kotlin.jvm.internal.c, i9.c
        public final String getName() {
            return "loadProperty";
        }

        @Override // kotlin.jvm.internal.c
        public final i9.f getOwner() {
            return kotlin.jvm.internal.c0.b(kotlin.reflect.jvm.internal.impl.serialization.deserialization.v.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
        }

        @Override // c9.p
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final u0 invoke(kotlin.reflect.jvm.internal.impl.serialization.deserialization.v p10, w9.n p11) {
            kotlin.jvm.internal.m.f(p10, "p0");
            kotlin.jvm.internal.m.f(p11, "p1");
            return p10.l(p11);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14513a;

        static {
            int[] iArr = new int[v9.a.EnumC0377a.values().length];
            try {
                iArr[v9.a.EnumC0377a.FILE_FACADE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[v9.a.EnumC0377a.MULTIFILE_CLASS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[v9.a.EnumC0377a.MULTIFILE_CLASS_PART.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[v9.a.EnumC0377a.SYNTHETIC_CLASS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[v9.a.EnumC0377a.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[v9.a.EnumC0377a.CLASS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f14513a = iArr;
        }
    }

    public k(Class<T> jClass) {
        kotlin.jvm.internal.m.f(jClass, "jClass");
        this.jClass = jClass;
        h0.b<k<T>.a> bVarB = h0.b(new c(this));
        kotlin.jvm.internal.m.e(bVarB, "lazy { Data() }");
        this.data = bVarB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ba.b I() {
        return k0.f14515a.c(d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Void N() throws InvocationTargetException {
        v9.a aVarG;
        p9.f fVarA = p9.f.f17440c.a(d());
        v9.a.EnumC0377a enumC0377aC = (fVarA == null || (aVarG = fVarA.g()) == null) ? null : aVarG.c();
        switch (enumC0377aC == null ? -1 : b.f14513a[enumC0377aC.ordinal()]) {
            case -1:
            case 6:
                throw new f0("Unresolved class: " + d());
            case 0:
            default:
                throw new r8.n();
            case 1:
            case 2:
            case 3:
                throw new UnsupportedOperationException("Packages and file facades are not yet supported in Kotlin reflection. Meanwhile please use Java reflection to inspect this class: " + d());
            case 4:
                throw new UnsupportedOperationException("This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection library has no idea what declarations it has. Please use Java reflection to inspect this class: " + d());
            case 5:
                throw new f0("Unknown class: " + d() + " (kind = " + enumC0377aC + ')');
        }
    }

    public final h0.b<k<T>.a> J() {
        return this.data;
    }

    @Override // kotlin.reflect.jvm.internal.l
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.e i() {
        return this.data.invoke().k();
    }

    @Override // i9.d
    public String b() {
        return this.data.invoke().n();
    }

    @Override // kotlin.jvm.internal.d
    public Class<T> d() {
        return this.jClass;
    }

    @Override // i9.d
    public String e() {
        return this.data.invoke().o();
    }

    public boolean equals(Object other) {
        return (other instanceof k) && kotlin.jvm.internal.m.a(b9.a.c(this), b9.a.c((i9.d) other));
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("class ");
        ba.b bVarI = I();
        ba.c cVarH = bVarI.h();
        kotlin.jvm.internal.m.e(cVarH, "classId.packageFqName");
        if (cVarH.d()) {
            str = "";
        } else {
            str = cVarH.b() + '.';
        }
        String strB = bVarI.i().b();
        kotlin.jvm.internal.m.e(strB, "classId.relativeClassName.asString()");
        sb2.append(str + ua.n.D(strB, '.', '$', false, 4, null));
        return sb2.toString();
    }

    @Override // kotlin.reflect.jvm.internal.n
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.y> v(ba.f name) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarL = L();
        r9.d dVar = r9.d.FROM_REFLECTION;
        return kotlin.collections.r.B0(hVarL.c(name, dVar), M().c(name, dVar));
    }

    @Override // kotlin.reflect.jvm.internal.n
    public Collection<u0> z(ba.f name) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarL = L();
        r9.d dVar = r9.d.FROM_REFLECTION;
        return kotlin.collections.r.B0(hVarL.a(name, dVar), M().a(name, dVar));
    }

    public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h L() {
        return i().p().n();
    }

    public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h M() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarN = i().N();
        kotlin.jvm.internal.m.e(hVarN, "descriptor.staticScope");
        return hVarN;
    }

    public int hashCode() {
        return b9.a.c(this).hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.n
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.l> u() {
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarI = i();
        if (eVarI.g() != kotlin.reflect.jvm.internal.impl.descriptors.f.INTERFACE && eVarI.g() != kotlin.reflect.jvm.internal.impl.descriptors.f.OBJECT) {
            Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> collectionK = eVarI.k();
            kotlin.jvm.internal.m.e(collectionK, "descriptor.constructors");
            return collectionK;
        }
        return kotlin.collections.r.l();
    }

    @Override // kotlin.reflect.jvm.internal.n
    public u0 w(int index) {
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.d dVar;
        Class<?> declaringClass;
        if (kotlin.jvm.internal.m.a(d().getSimpleName(), "DefaultImpls") && (declaringClass = d().getDeclaringClass()) != null && declaringClass.isInterface()) {
            i9.d dVarE = b9.a.e(declaringClass);
            kotlin.jvm.internal.m.d(dVarE, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
            return ((k) dVarE).w(index);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarI = i();
        if (eVarI instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.d) {
            dVar = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.d) eVarI;
        } else {
            dVar = null;
        }
        if (dVar != null) {
            w9.c cVarW0 = dVar.W0();
            kotlin.reflect.jvm.internal.impl.protobuf.i.f<w9.c, List<w9.n>> classLocalVariable = z9.a.f23133j;
            kotlin.jvm.internal.m.e(classLocalVariable, "classLocalVariable");
            w9.n nVar = (w9.n) y9.e.b(cVarW0, classLocalVariable, index);
            if (nVar != null) {
                return (u0) n0.h(d(), nVar, dVar.V0().g(), dVar.V0().j(), dVar.Y0(), d.f14514a);
            }
        }
        return null;
    }
}
