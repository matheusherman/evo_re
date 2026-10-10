package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.List;
import ka.n;
import kotlin.collections.r;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.w;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.x;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class f extends kotlin.reflect.jvm.internal.impl.builtins.h {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final /* synthetic */ i9.k<Object>[] f12535k = {c0.g(new w(c0.b(f.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a f12536h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private c9.a<b> f12537i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ka.i f12538j;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum a {
        FROM_DEPENDENCIES,
        FROM_CLASS_LOADER,
        FALLBACK
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final h0 f12543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f12544b;

        public b(h0 ownerModuleDescriptor, boolean z10) {
            m.f(ownerModuleDescriptor, "ownerModuleDescriptor");
            this.f12543a = ownerModuleDescriptor;
            this.f12544b = z10;
        }

        public final h0 a() {
            return this.f12543a;
        }

        public final boolean b() {
            return this.f12544b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class d extends o implements c9.a<i> {
        final /* synthetic */ n $storageManager;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class a extends o implements c9.a<b> {
            final /* synthetic */ f this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(f fVar) {
                super(0);
                this.this$0 = fVar;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final b invoke() {
                c9.a aVar = this.this$0.f12537i;
                if (aVar == null) {
                    throw new AssertionError("JvmBuiltins instance has not been initialized properly");
                }
                b bVar = (b) aVar.invoke();
                this.this$0.f12537i = null;
                return bVar;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(n nVar) {
            super(0);
            this.$storageManager = nVar;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i invoke() {
            x builtInsModule = f.this.r();
            m.e(builtInsModule, "builtInsModule");
            return new i(builtInsModule, this.$storageManager, new a(f.this));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class e extends o implements c9.a<b> {
        final /* synthetic */ boolean $isAdditionalBuiltInsFeatureSupported;
        final /* synthetic */ h0 $moduleDescriptor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(h0 h0Var, boolean z10) {
            super(0);
            this.$moduleDescriptor = h0Var;
            this.$isAdditionalBuiltInsFeatureSupported = z10;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b invoke() {
            return new b(this.$moduleDescriptor, this.$isAdditionalBuiltInsFeatureSupported);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12545a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                iArr[a.FROM_DEPENDENCIES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.FROM_CLASS_LOADER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[a.FALLBACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f12545a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(n storageManager, a kind) {
        super(storageManager);
        m.f(storageManager, "storageManager");
        m.f(kind, "kind");
        this.f12536h = kind;
        this.f12538j = storageManager.c(new d(storageManager));
        int i10 = c.f12545a[kind.ordinal()];
        if (i10 == 2) {
            f(false);
        } else {
            if (i10 != 3) {
                return;
            }
            f(true);
        }
    }

    public final i I0() {
        return (i) ka.m.a(this.f12538j, this, f12535k[0]);
    }

    public final void J0(h0 moduleDescriptor, boolean z10) {
        m.f(moduleDescriptor, "moduleDescriptor");
        K0(new e(moduleDescriptor, z10));
    }

    public final void K0(c9.a<b> computation) {
        m.f(computation, "computation");
        this.f12537i = computation;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.builtins.h
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public List<n9.b> v() {
        Iterable<n9.b> iterableV = super.v();
        m.e(iterableV, "super.getClassDescriptorFactories()");
        n storageManager = U();
        m.e(storageManager, "storageManager");
        x builtInsModule = r();
        m.e(builtInsModule, "builtInsModule");
        return r.A0(iterableV, new kotlin.reflect.jvm.internal.impl.builtins.jvm.e(storageManager, builtInsModule, null, 4, null));
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.h
    protected n9.c M() {
        return I0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.h
    protected n9.a g() {
        return I0();
    }
}
