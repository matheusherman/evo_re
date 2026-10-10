package kotlin.reflect.jvm.internal;

import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b*\u00060\u0004j\u0002`\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\b*\u00060\u0004j\u0002`\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u0015\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010!\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010$¨\u0006&"}, d2 = {"Lkotlin/reflect/jvm/internal/j0;", "", "<init>", "()V", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Lkotlin/reflect/jvm/internal/impl/descriptors/x0;", "receiver", "Lr8/z;", "a", "(Ljava/lang/StringBuilder;Lkotlin/reflect/jvm/internal/impl/descriptors/x0;)V", "Lkotlin/reflect/jvm/internal/impl/descriptors/a;", "callable", "b", "(Ljava/lang/StringBuilder;Lkotlin/reflect/jvm/internal/impl/descriptors/a;)V", "descriptor", "", "c", "(Lkotlin/reflect/jvm/internal/impl/descriptors/a;)Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/descriptors/u0;", "g", "(Lkotlin/reflect/jvm/internal/impl/descriptors/u0;)Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/descriptors/y;", "d", "(Lkotlin/reflect/jvm/internal/impl/descriptors/y;)Ljava/lang/String;", "invoke", "e", "Lkotlin/reflect/jvm/internal/u;", "parameter", "f", "(Lkotlin/reflect/jvm/internal/u;)Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/types/g0;", IjkMediaMeta.IJKM_KEY_TYPE, "h", "(Lkotlin/reflect/jvm/internal/impl/types/g0;)Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/renderer/c;", "Lkotlin/reflect/jvm/internal/impl/renderer/c;", "renderer", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j0 f14485a = new j0();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final kotlin.reflect.jvm.internal.impl.renderer.c renderer = kotlin.reflect.jvm.internal.impl.renderer.c.f13790g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/j1;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lkotlin/reflect/jvm/internal/impl/descriptors/j1;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 8, 0})
    static final class b extends kotlin.jvm.internal.o implements c9.l<j1, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f14488a = new b();

        b() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(j1 j1Var) {
            j0 j0Var = j0.f14485a;
            kotlin.reflect.jvm.internal.impl.types.g0 type = j1Var.getType();
            kotlin.jvm.internal.m.e(type, "it.type");
            return j0Var.h(type);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/j1;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lkotlin/reflect/jvm/internal/impl/descriptors/j1;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 8, 0})
    static final class c extends kotlin.jvm.internal.o implements c9.l<j1, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f14489a = new c();

        c() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(j1 j1Var) {
            j0 j0Var = j0.f14485a;
            kotlin.reflect.jvm.internal.impl.types.g0 type = j1Var.getType();
            kotlin.jvm.internal.m.e(type, "it.type");
            return j0Var.h(type);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14487a;

        static {
            int[] iArr = new int[i9.j.a.values().length];
            try {
                iArr[i9.j.a.EXTENSION_RECEIVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[i9.j.a.INSTANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[i9.j.a.VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f14487a = iArr;
        }
    }

    private final void a(StringBuilder sb2, x0 x0Var) {
        if (x0Var != null) {
            kotlin.reflect.jvm.internal.impl.types.g0 type = x0Var.getType();
            kotlin.jvm.internal.m.e(type, "receiver.type");
            sb2.append(h(type));
            sb2.append(".");
        }
    }

    private final String c(kotlin.reflect.jvm.internal.impl.descriptors.a descriptor) {
        if (descriptor instanceof u0) {
            return g((u0) descriptor);
        }
        if (descriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.y) {
            return d((kotlin.reflect.jvm.internal.impl.descriptors.y) descriptor);
        }
        throw new IllegalStateException(("Illegal callable: " + descriptor).toString());
    }

    public final String d(kotlin.reflect.jvm.internal.impl.descriptors.y descriptor) throws IOException {
        kotlin.jvm.internal.m.f(descriptor, "descriptor");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("fun ");
        j0 j0Var = f14485a;
        j0Var.b(sb2, descriptor);
        kotlin.reflect.jvm.internal.impl.renderer.c cVar = renderer;
        ba.f name = descriptor.getName();
        kotlin.jvm.internal.m.e(name, "descriptor.name");
        sb2.append(cVar.v(name, true));
        List<j1> listF = descriptor.f();
        kotlin.jvm.internal.m.e(listF, "descriptor.valueParameters");
        kotlin.collections.c0.n0(listF, sb2, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "(", (124 & 8) == 0 ? ")" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : b.f14488a);
        sb2.append(": ");
        kotlin.reflect.jvm.internal.impl.types.g0 returnType = descriptor.getReturnType();
        kotlin.jvm.internal.m.c(returnType);
        sb2.append(j0Var.h(returnType));
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String e(kotlin.reflect.jvm.internal.impl.descriptors.y invoke) throws IOException {
        kotlin.jvm.internal.m.f(invoke, "invoke");
        StringBuilder sb2 = new StringBuilder();
        j0 j0Var = f14485a;
        j0Var.b(sb2, invoke);
        List<j1> listF = invoke.f();
        kotlin.jvm.internal.m.e(listF, "invoke.valueParameters");
        kotlin.collections.c0.n0(listF, sb2, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "(", (124 & 8) == 0 ? ")" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : c.f14489a);
        sb2.append(" -> ");
        kotlin.reflect.jvm.internal.impl.types.g0 returnType = invoke.getReturnType();
        kotlin.jvm.internal.m.c(returnType);
        sb2.append(j0Var.h(returnType));
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String f(u parameter) {
        kotlin.jvm.internal.m.f(parameter, "parameter");
        StringBuilder sb2 = new StringBuilder();
        int i10 = a.f14487a[parameter.getKind().ordinal()];
        if (i10 == 1) {
            sb2.append("extension receiver parameter");
        } else if (i10 == 2) {
            sb2.append("instance parameter");
        } else if (i10 == 3) {
            sb2.append("parameter #" + parameter.getIndex() + ' ' + parameter.getName());
        }
        sb2.append(" of ");
        sb2.append(f14485a.c(parameter.i().w()));
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String g(u0 descriptor) {
        kotlin.jvm.internal.m.f(descriptor, "descriptor");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(descriptor.f0() ? "var " : "val ");
        j0 j0Var = f14485a;
        j0Var.b(sb2, descriptor);
        kotlin.reflect.jvm.internal.impl.renderer.c cVar = renderer;
        ba.f name = descriptor.getName();
        kotlin.jvm.internal.m.e(name, "descriptor.name");
        sb2.append(cVar.v(name, true));
        sb2.append(": ");
        kotlin.reflect.jvm.internal.impl.types.g0 type = descriptor.getType();
        kotlin.jvm.internal.m.e(type, "descriptor.type");
        sb2.append(j0Var.h(type));
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String h(kotlin.reflect.jvm.internal.impl.types.g0 type) {
        kotlin.jvm.internal.m.f(type, "type");
        return renderer.w(type);
    }

    private j0() {
    }

    private final void b(StringBuilder sb2, kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        boolean z10;
        x0 x0VarI = n0.i(aVar);
        x0 x0VarI0 = aVar.i0();
        a(sb2, x0VarI);
        if (x0VarI != null && x0VarI0 != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            sb2.append("(");
        }
        a(sb2, x0VarI0);
        if (z10) {
            sb2.append(")");
        }
    }
}
