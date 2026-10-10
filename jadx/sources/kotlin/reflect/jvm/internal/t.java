package kotlin.reflect.jvm.internal;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001/B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001eR*\u0010$\u001a\u0018\u0012\u0014\u0012\u0012 !*\b\u0018\u00010 R\u00020\u00000 R\u00020\u00000\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0006\u0012\u0002\b\u00030\u00028TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001eR\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020'0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00060"}, d2 = {"Lkotlin/reflect/jvm/internal/t;", "Lkotlin/reflect/jvm/internal/n;", "Ljava/lang/Class;", "jClass", "<init>", "(Ljava/lang/Class;)V", "Lba/f;", "name", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/u0;", "z", "(Lba/f;)Ljava/util/Collection;", "Lkotlin/reflect/jvm/internal/impl/descriptors/y;", "v", "", "index", "w", "(I)Lkotlin/reflect/jvm/internal/impl/descriptors/u0;", "", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "d", "Ljava/lang/Class;", "()Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/h0$b;", "Lkotlin/reflect/jvm/internal/t$a;", "kotlin.jvm.PlatformType", "e", "Lkotlin/reflect/jvm/internal/h0$b;", "data", "y", "methodOwner", "Lkotlin/reflect/jvm/internal/impl/descriptors/l;", "u", "()Ljava/util/Collection;", "constructorDescriptors", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/h;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "scope", "a", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class t extends n {

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Class<?> jClass;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final h0.b<a> data;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001d\u0010\n\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\u000eR!\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\f\u0010\u0013R/\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u0006\u0010\u001aR%\u0010!\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001d0\u001c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0007\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lkotlin/reflect/jvm/internal/t$a;", "Lkotlin/reflect/jvm/internal/n$b;", "Lkotlin/reflect/jvm/internal/n;", "<init>", "(Lkotlin/reflect/jvm/internal/t;)V", "Lp9/f;", "d", "Lkotlin/reflect/jvm/internal/h0$a;", "getKotlinClass", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;", "kotlinClass", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/h;", "e", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "scope", "Ljava/lang/Class;", "f", "Lkotlin/reflect/jvm/internal/h0$b;", "()Ljava/lang/Class;", "multifileFacade", "Lr8/u;", "Laa/f;", "Lw9/l;", "Laa/e;", "g", "()Lr8/u;", "metadata", "", "Lkotlin/reflect/jvm/internal/j;", "h", "getMembers", "()Ljava/util/Collection;", "members", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class a extends n.b {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        static final /* synthetic */ i9.k<Object>[] f14551j = {kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(a.class), "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;")), kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(a.class), "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(a.class), "multifileFacade", "getMultifileFacade()Ljava/lang/Class;")), kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(a.class), "metadata", "getMetadata()Lkotlin/Triple;")), kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(a.class), "members", "getMembers()Ljava/util/Collection;"))};

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final h0.a kotlinClass;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final h0.a scope;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final h0.b multifileFacade;

        /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
        private final h0.b metadata;

        /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final h0.a members;

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.t$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lp9/f;", "a", "()Lp9/f;"}, k = 3, mv = {1, 8, 0})
        static final class C0278a extends kotlin.jvm.internal.o implements c9.a<p9.f> {
            final /* synthetic */ t this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0278a(t tVar) {
                super(0);
                this.this$0 = tVar;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final p9.f invoke() {
                return p9.f.f17440c.a(this.this$0.d());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0001 \u0002*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lkotlin/reflect/jvm/internal/j;", "kotlin.jvm.PlatformType", "a", "()Ljava/util/Collection;"}, k = 3, mv = {1, 8, 0})
        static final class b extends kotlin.jvm.internal.o implements c9.a<Collection<? extends j<?>>> {
            final /* synthetic */ t this$0;
            final /* synthetic */ a this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(t tVar, a aVar) {
                super(0);
                this.this$0 = tVar;
                this.this$1 = aVar;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Collection<j<?>> invoke() {
                return this.this$0.x(this.this$1.f(), n.c.DECLARED);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lr8/u;", "Laa/f;", "Lw9/l;", "Laa/e;", "a", "()Lr8/u;"}, k = 3, mv = {1, 8, 0})
        static final class c extends kotlin.jvm.internal.o implements c9.a<r8.u<? extends aa.f, ? extends w9.l, ? extends aa.e>> {
            c() {
                super(0);
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final r8.u<aa.f, w9.l, aa.e> invoke() {
                v9.a aVarG;
                p9.f fVarC = a.this.c();
                if (fVarC != null && (aVarG = fVarC.g()) != null) {
                    String[] strArrA = aVarG.a();
                    String[] strArrG = aVarG.g();
                    if (strArrA != null && strArrG != null) {
                        r8.p<aa.f, w9.l> pVarM = aa.i.m(strArrA, strArrG);
                        return new r8.u<>(pVarM.a(), pVarM.b(), aVarG.d());
                    }
                }
                return null;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/lang/Class;", "a", "()Ljava/lang/Class;"}, k = 3, mv = {1, 8, 0})
        static final class d extends kotlin.jvm.internal.o implements c9.a<Class<?>> {
            final /* synthetic */ t this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(t tVar) {
                super(0);
                this.this$1 = tVar;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Class<?> invoke() {
                v9.a aVarG;
                p9.f fVarC = a.this.c();
                String strE = (fVarC == null || (aVarG = fVarC.g()) == null) ? null : aVarG.e();
                if (strE == null || strE.length() <= 0) {
                    return null;
                }
                return this.this$1.d().getClassLoader().loadClass(ua.n.D(strE, '/', '.', false, 4, null));
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/resolve/scopes/h;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/impl/resolve/scopes/h;"}, k = 3, mv = {1, 8, 0})
        static final class e extends kotlin.jvm.internal.o implements c9.a<kotlin.reflect.jvm.internal.impl.resolve.scopes.h> {
            e() {
                super(0);
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h invoke() {
                p9.f fVarC = a.this.c();
                return fVarC != null ? a.this.a().c().a(fVarC) : kotlin.reflect.jvm.internal.impl.resolve.scopes.h.b.f14005b;
            }
        }

        public a() {
            super();
            this.kotlinClass = h0.c(new C0278a(t.this));
            this.scope = h0.c(new e());
            this.multifileFacade = h0.b(new d(t.this));
            this.metadata = h0.b(new c());
            this.members = h0.c(new b(t.this, this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public final p9.f c() {
            return (p9.f) this.kotlinClass.b(this, f14551j[0]);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final r8.u<aa.f, w9.l, aa.e> d() {
            return (r8.u) this.metadata.b(this, f14551j[3]);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Class<?> e() {
            return (Class) this.multifileFacade.b(this, f14551j[2]);
        }

        public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h f() {
            T tB = this.scope.b(this, f14551j[1]);
            kotlin.jvm.internal.m.e(tB, "<get-scope>(...)");
            return (kotlin.reflect.jvm.internal.impl.resolve.scopes.h) tB;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0012 \u0002*\b\u0018\u00010\u0000R\u00020\u00010\u0000R\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/reflect/jvm/internal/t$a;", "Lkotlin/reflect/jvm/internal/t;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/t$a;"}, k = 3, mv = {1, 8, 0})
    static final class b extends kotlin.jvm.internal.o implements c9.a<a> {
        b() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a invoke() {
            return t.this.new a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class c extends kotlin.jvm.internal.j implements c9.p<kotlin.reflect.jvm.internal.impl.serialization.deserialization.v, w9.n, u0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f14558a = new c();

        c() {
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

    public t(Class<?> jClass) {
        kotlin.jvm.internal.m.f(jClass, "jClass");
        this.jClass = jClass;
        h0.b<a> bVarB = h0.b(new b());
        kotlin.jvm.internal.m.e(bVarB, "lazy { Data() }");
        this.data = bVarB;
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.h G() {
        return this.data.invoke().f();
    }

    @Override // kotlin.jvm.internal.d
    public Class<?> d() {
        return this.jClass;
    }

    public boolean equals(Object other) {
        return (other instanceof t) && kotlin.jvm.internal.m.a(d(), ((t) other).d());
    }

    public String toString() {
        return "file class " + kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.a(d()).b();
    }

    @Override // kotlin.reflect.jvm.internal.n
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.y> v(ba.f name) {
        kotlin.jvm.internal.m.f(name, "name");
        return G().c(name, r9.d.FROM_REFLECTION);
    }

    @Override // kotlin.reflect.jvm.internal.n
    public u0 w(int index) {
        r8.u<aa.f, w9.l, aa.e> uVarD = this.data.invoke().d();
        if (uVarD != null) {
            aa.f fVarA = uVarD.a();
            w9.l lVarB = uVarD.b();
            aa.e eVarC = uVarD.c();
            kotlin.reflect.jvm.internal.impl.protobuf.i.f<w9.l, List<w9.n>> packageLocalVariable = z9.a.f23137n;
            kotlin.jvm.internal.m.e(packageLocalVariable, "packageLocalVariable");
            w9.n nVar = (w9.n) y9.e.b(lVarB, packageLocalVariable, index);
            if (nVar != null) {
                Class<?> clsD = d();
                w9.t tVarV = lVarB.V();
                kotlin.jvm.internal.m.e(tVarV, "packageProto.typeTable");
                return (u0) n0.h(clsD, nVar, fVarA, new y9.g(tVarV), eVarC, c.f14558a);
            }
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.n
    protected Class<?> y() {
        Class<?> clsE = this.data.invoke().e();
        return clsE == null ? d() : clsE;
    }

    @Override // kotlin.reflect.jvm.internal.n
    public Collection<u0> z(ba.f name) {
        kotlin.jvm.internal.m.f(name, "name");
        return G().a(name, r9.d.FROM_REFLECTION);
    }

    public int hashCode() {
        return d().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.n
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.l> u() {
        return kotlin.collections.r.l();
    }
}
