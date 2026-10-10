package kotlin.reflect.jvm.internal.impl.load.java.components;

import i9.k;
import java.util.Collection;
import java.util.Map;
import kotlin.collections.n0;
import kotlin.collections.r;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.w;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.types.o0;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, s9.g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final /* synthetic */ k<Object>[] f13161f = {c0.g(new w(c0.b(b.class), IjkMediaMeta.IJKM_KEY_TYPE, "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ba.c f13162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a1 f13163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ka.i f13164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final u9.b f13165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f13166e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends o implements c9.a<o0> {
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.lazy.g $c;
        final /* synthetic */ b this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar, b bVar) {
            super(0);
            this.$c = gVar;
            this.this$0 = bVar;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final o0 invoke() {
            o0 o0VarP = this.$c.d().l().o(this.this$0.d()).p();
            m.e(o0VarP, "c.module.builtIns.getBui…qName(fqName).defaultType");
            return o0VarP;
        }
    }

    public b(kotlin.reflect.jvm.internal.impl.load.java.lazy.g c10, u9.a aVar, ba.c fqName) {
        a1 NO_SOURCE;
        Collection<u9.b> arguments;
        m.f(c10, "c");
        m.f(fqName, "fqName");
        this.f13162a = fqName;
        if (aVar == null || (NO_SOURCE = c10.a().t().a(aVar)) == null) {
            NO_SOURCE = a1.f12668a;
            m.e(NO_SOURCE, "NO_SOURCE");
        }
        this.f13163b = NO_SOURCE;
        this.f13164c = c10.e().c(new a(c10, this));
        this.f13165d = (aVar == null || (arguments = aVar.getArguments()) == null) ? null : (u9.b) r.h0(arguments);
        boolean z10 = false;
        if (aVar != null && aVar.g()) {
            z10 = true;
        }
        this.f13166e = z10;
    }

    protected final u9.b b() {
        return this.f13165d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public o0 getType() {
        return (o0) ka.m.a(this.f13164c, this, f13161f[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public ba.c d() {
        return this.f13162a;
    }

    @Override // s9.g
    public boolean g() {
        return this.f13166e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public a1 getSource() {
        return this.f13163b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public Map<ba.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a() {
        return n0.i();
    }
}
