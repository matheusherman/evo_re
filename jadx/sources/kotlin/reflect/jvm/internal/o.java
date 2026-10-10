package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u00020\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB7\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u0011B+\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001a\u0010\u0018J5\u0010\u001f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b0\u001e2\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010\"\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\fH\u0016¢\u0006\u0004\b'\u0010(R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001b\u0010\t\u001a\u00020\b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001f\u0010:\u001a\u0006\u0012\u0002\b\u0003058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R!\u0010=\u001a\b\u0012\u0002\b\u0003\u0018\u0001058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b;\u00107\u001a\u0004\b<\u00109R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010B\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0014\u0010\r\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010(R\u0014\u0010E\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010&R\u0014\u0010F\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010AR\u0014\u0010G\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010AR\u0014\u0010H\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bH\u0010AR\u0014\u0010I\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010AR\u0014\u0010J\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010A¨\u0006K"}, d2 = {"Lkotlin/reflect/jvm/internal/o;", "Lkotlin/reflect/jvm/internal/j;", "", "Li9/g;", "Lkotlin/jvm/internal/i;", "Lkotlin/reflect/jvm/internal/g;", "Lkotlin/reflect/jvm/internal/n;", "container", "Lkotlin/reflect/jvm/internal/impl/descriptors/y;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/n;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "", "name", "signature", "descriptorInitialValue", "rawBoundReceiver", "(Lkotlin/reflect/jvm/internal/n;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "boundReceiver", "(Lkotlin/reflect/jvm/internal/n;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "Ljava/lang/reflect/Method;", "member", "Lkotlin/reflect/jvm/internal/calls/f$h;", ExifInterface.LONGITUDE_EAST, "(Ljava/lang/reflect/Method;)Lkotlin/reflect/jvm/internal/calls/f$h;", "D", "C", "Ljava/lang/reflect/Constructor;", "", "isDefault", "Lkotlin/reflect/jvm/internal/calls/f;", "B", "(Ljava/lang/reflect/Constructor;Lkotlin/reflect/jvm/internal/impl/descriptors/y;Z)Lkotlin/reflect/jvm/internal/calls/f;", TransactionPartnerType.OTHER, "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "f", "Lkotlin/reflect/jvm/internal/n;", "r", "()Lkotlin/reflect/jvm/internal/n;", "g", "Ljava/lang/String;", "h", "Ljava/lang/Object;", "i", "Lkotlin/reflect/jvm/internal/h0$a;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "Lkotlin/reflect/jvm/internal/calls/e;", "j", "Lr8/i;", "q", "()Lkotlin/reflect/jvm/internal/calls/e;", "caller", "k", "s", "defaultCaller", "F", "()Ljava/lang/Object;", "v", "()Z", "isBound", "getName", "getArity", "arity", "isInline", "isExternal", "isOperator", "isInfix", "isSuspend", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class o extends j<Object> implements kotlin.jvm.internal.i<Object>, i9.g<Object>, g {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final /* synthetic */ i9.k<Object>[] f14533l = {kotlin.jvm.internal.c0.g(new kotlin.jvm.internal.w(kotlin.jvm.internal.c0.b(o.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;"))};

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final n container;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final String signature;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Object rawBoundReceiver;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final h0.a descriptor;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final r8.i caller;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final r8.i defaultCaller;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/e;", "Ljava/lang/reflect/Executable;", "a", "()Lkotlin/reflect/jvm/internal/calls/e;"}, k = 3, mv = {1, 8, 0})
    static final class a extends kotlin.jvm.internal.o implements c9.a<kotlin.reflect.jvm.internal.calls.e<? extends Executable>> {
        a() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.calls.e<Executable> invoke() {
            Object objB;
            kotlin.reflect.jvm.internal.calls.e eVarD;
            h hVarG = k0.f14515a.g(o.this.w());
            if (hVarG instanceof h.d) {
                if (o.this.u()) {
                    Class<?> clsD = o.this.getContainer().d();
                    List<i9.j> parameters = o.this.getParameters();
                    ArrayList arrayList = new ArrayList(kotlin.collections.r.w(parameters, 10));
                    Iterator<T> it = parameters.iterator();
                    while (it.hasNext()) {
                        String name = ((i9.j) it.next()).getName();
                        kotlin.jvm.internal.m.c(name);
                        arrayList.add(name);
                    }
                    return new kotlin.reflect.jvm.internal.calls.a(clsD, arrayList, kotlin.reflect.jvm.internal.calls.a.EnumC0209a.POSITIONAL_CALL, kotlin.reflect.jvm.internal.calls.a.b.KOTLIN, null, 16, null);
                }
                objB = o.this.getContainer().n(((h.d) hVarG).b());
            } else if (hVarG instanceof h.e) {
                h.e eVar = (h.e) hVarG;
                objB = o.this.getContainer().r(eVar.c(), eVar.b());
            } else if (hVarG instanceof h.c) {
                objB = ((h.c) hVarG).getMethod();
            } else {
                if (!(hVarG instanceof h.b)) {
                    if (!(hVarG instanceof h.a)) {
                        throw new r8.n();
                    }
                    List<Method> listB = ((h.a) hVarG).b();
                    Class<?> clsD2 = o.this.getContainer().d();
                    List<Method> list = listB;
                    ArrayList arrayList2 = new ArrayList(kotlin.collections.r.w(list, 10));
                    Iterator<T> it2 = list.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(((Method) it2.next()).getName());
                    }
                    return new kotlin.reflect.jvm.internal.calls.a(clsD2, arrayList2, kotlin.reflect.jvm.internal.calls.a.EnumC0209a.POSITIONAL_CALL, kotlin.reflect.jvm.internal.calls.a.b.JAVA, listB);
                }
                objB = ((h.b) hVarG).b();
            }
            if (objB instanceof Constructor) {
                o oVar = o.this;
                eVarD = oVar.B((Constructor) objB, oVar.w(), false);
            } else {
                if (!(objB instanceof Method)) {
                    throw new f0("Could not compute caller for function: " + o.this.w() + " (member = " + objB + ')');
                }
                Method method = (Method) objB;
                if (Modifier.isStatic(method.getModifiers())) {
                    eVarD = o.this.w().getAnnotations().j(n0.j()) != null ? o.this.D(method) : o.this.E(method);
                } else {
                    eVarD = o.this.C(method);
                }
            }
            return kotlin.reflect.jvm.internal.calls.i.c(eVarD, o.this.w(), false, 2, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/e;", "Ljava/lang/reflect/Executable;", "a", "()Lkotlin/reflect/jvm/internal/calls/e;"}, k = 3, mv = {1, 8, 0})
    static final class b extends kotlin.jvm.internal.o implements c9.a<kotlin.reflect.jvm.internal.calls.e<? extends Executable>> {
        b() {
            super(0);
        }

        /* JADX WARN: Code duplicated, block: B:35:0x012d  */
        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.calls.e<Executable> invoke() {
            GenericDeclaration genericDeclarationO;
            kotlin.reflect.jvm.internal.calls.e eVarE;
            h hVarG = k0.f14515a.g(o.this.w());
            if (hVarG instanceof h.e) {
                n container = o.this.getContainer();
                h.e eVar = (h.e) hVarG;
                String strC = eVar.c();
                String strB = eVar.b();
                Member memberB = o.this.q().b();
                kotlin.jvm.internal.m.c(memberB);
                genericDeclarationO = container.p(strC, strB, !Modifier.isStatic(memberB.getModifiers()));
            } else if (hVarG instanceof h.d) {
                if (o.this.u()) {
                    Class<?> clsD = o.this.getContainer().d();
                    List<i9.j> parameters = o.this.getParameters();
                    ArrayList arrayList = new ArrayList(kotlin.collections.r.w(parameters, 10));
                    Iterator<T> it = parameters.iterator();
                    while (it.hasNext()) {
                        String name = ((i9.j) it.next()).getName();
                        kotlin.jvm.internal.m.c(name);
                        arrayList.add(name);
                    }
                    return new kotlin.reflect.jvm.internal.calls.a(clsD, arrayList, kotlin.reflect.jvm.internal.calls.a.EnumC0209a.CALL_BY_NAME, kotlin.reflect.jvm.internal.calls.a.b.KOTLIN, null, 16, null);
                }
                genericDeclarationO = o.this.getContainer().o(((h.d) hVarG).b());
            } else {
                if (hVarG instanceof h.a) {
                    List<Method> listB = ((h.a) hVarG).b();
                    Class<?> clsD2 = o.this.getContainer().d();
                    List<Method> list = listB;
                    ArrayList arrayList2 = new ArrayList(kotlin.collections.r.w(list, 10));
                    Iterator<T> it2 = list.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(((Method) it2.next()).getName());
                    }
                    return new kotlin.reflect.jvm.internal.calls.a(clsD2, arrayList2, kotlin.reflect.jvm.internal.calls.a.EnumC0209a.CALL_BY_NAME, kotlin.reflect.jvm.internal.calls.a.b.JAVA, listB);
                }
                genericDeclarationO = null;
            }
            if (genericDeclarationO instanceof Constructor) {
                o oVar = o.this;
                eVarE = oVar.B((Constructor) genericDeclarationO, oVar.w(), true);
            } else if (!(genericDeclarationO instanceof Method)) {
                eVarE = null;
            } else if (o.this.w().getAnnotations().j(n0.j()) != null) {
                kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = o.this.w().b();
                kotlin.jvm.internal.m.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                if (((kotlin.reflect.jvm.internal.impl.descriptors.e) mVarB).t()) {
                    eVarE = o.this.E((Method) genericDeclarationO);
                } else {
                    eVarE = o.this.D((Method) genericDeclarationO);
                }
            } else {
                eVarE = o.this.E((Method) genericDeclarationO);
            }
            if (eVarE != null) {
                return kotlin.reflect.jvm.internal.calls.i.b(eVarE, o.this.w(), true);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/y;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/impl/descriptors/y;"}, k = 3, mv = {1, 8, 0})
    static final class c extends kotlin.jvm.internal.o implements c9.a<kotlin.reflect.jvm.internal.impl.descriptors.y> {
        final /* synthetic */ String $name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str) {
            super(0);
            this.$name = str;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.descriptors.y invoke() {
            return o.this.getContainer().q(this.$name, o.this.signature);
        }
    }

    /* synthetic */ o(n nVar, String str, String str2, kotlin.reflect.jvm.internal.impl.descriptors.y yVar, Object obj, int i10, kotlin.jvm.internal.g gVar) {
        this(nVar, str, str2, yVar, (i10 & 16) != 0 ? kotlin.jvm.internal.c.NO_RECEIVER : obj);
    }

    @Override // c9.a
    public Object invoke() {
        return g.a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.calls.f<Constructor<?>> B(Constructor<?> member, kotlin.reflect.jvm.internal.impl.descriptors.y descriptor, boolean isDefault) {
        if (isDefault || !fa.b.f(descriptor)) {
            return v() ? new kotlin.reflect.jvm.internal.calls.f.c(member, F()) : new kotlin.reflect.jvm.internal.calls.f.e(member);
        }
        return v() ? new kotlin.reflect.jvm.internal.calls.f.a(member, F()) : new kotlin.reflect.jvm.internal.calls.f.b(member);
    }

    private final Object F() {
        return kotlin.reflect.jvm.internal.calls.i.a(this.rawBoundReceiver, w());
    }

    @Override // kotlin.reflect.jvm.internal.j
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.y w() {
        T tB = this.descriptor.b(this, f14533l[0]);
        kotlin.jvm.internal.m.e(tB, "<get-descriptor>(...)");
        return (kotlin.reflect.jvm.internal.impl.descriptors.y) tB;
    }

    @Override // c9.l
    public Object invoke(Object obj) {
        return g.a.b(this, obj);
    }

    @Override // kotlin.reflect.jvm.internal.j
    public kotlin.reflect.jvm.internal.calls.e<?> q() {
        return (kotlin.reflect.jvm.internal.calls.e) this.caller.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.j
    /* JADX INFO: renamed from: r, reason: from getter */
    public n getContainer() {
        return this.container;
    }

    @Override // kotlin.reflect.jvm.internal.j
    public kotlin.reflect.jvm.internal.calls.e<?> s() {
        return (kotlin.reflect.jvm.internal.calls.e) this.defaultCaller.getValue();
    }

    public String toString() {
        return j0.f14485a.d(w());
    }

    @Override // kotlin.reflect.jvm.internal.j
    public boolean v() {
        return !kotlin.jvm.internal.m.a(this.rawBoundReceiver, kotlin.jvm.internal.c.NO_RECEIVER);
    }

    private o(n nVar, String str, String str2, kotlin.reflect.jvm.internal.impl.descriptors.y yVar, Object obj) {
        this.container = nVar;
        this.signature = str2;
        this.rawBoundReceiver = obj;
        this.descriptor = h0.d(yVar, new c(str));
        r8.m mVar = r8.m.PUBLICATION;
        this.caller = r8.j.b(mVar, new a());
        this.defaultCaller = r8.j.b(mVar, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.calls.f.h C(Method member) {
        if (v()) {
            return new kotlin.reflect.jvm.internal.calls.f.h.a(member, F());
        }
        return new kotlin.reflect.jvm.internal.calls.f.h.d(member);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.calls.f.h D(Method member) {
        if (v()) {
            return new kotlin.reflect.jvm.internal.calls.f.h.b(member);
        }
        return new kotlin.reflect.jvm.internal.calls.f.h.e(member);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.calls.f.h E(Method member) {
        if (v()) {
            return new kotlin.reflect.jvm.internal.calls.f.h.c(member, F());
        }
        return new kotlin.reflect.jvm.internal.calls.f.h.C0211f(member);
    }

    public boolean equals(Object other) {
        o oVarC = n0.c(other);
        if (oVarC == null || !kotlin.jvm.internal.m.a(getContainer(), oVarC.getContainer()) || !kotlin.jvm.internal.m.a(getName(), oVarC.getName()) || !kotlin.jvm.internal.m.a(this.signature, oVarC.signature) || !kotlin.jvm.internal.m.a(this.rawBoundReceiver, oVarC.rawBoundReceiver)) {
            return false;
        }
        return true;
    }

    @Override // kotlin.jvm.internal.i
    public int getArity() {
        return kotlin.reflect.jvm.internal.calls.g.a(q());
    }

    @Override // i9.c
    public String getName() {
        String strF = w().getName().f();
        kotlin.jvm.internal.m.e(strF, "descriptor.name.asString()");
        return strF;
    }

    public int hashCode() {
        return (((getContainer().hashCode() * 31) + getName().hashCode()) * 31) + this.signature.hashCode();
    }

    @Override // c9.p
    public Object invoke(Object obj, Object obj2) {
        return g.a.c(this, obj, obj2);
    }

    @Override // i9.g
    public boolean isExternal() {
        return w().isExternal();
    }

    @Override // i9.g
    public boolean isInfix() {
        return w().isInfix();
    }

    @Override // i9.g
    public boolean isInline() {
        return w().isInline();
    }

    @Override // i9.g
    public boolean isOperator() {
        return w().isOperator();
    }

    @Override // i9.c
    public boolean isSuspend() {
        return w().isSuspend();
    }

    @Override // c9.q
    public Object invoke(Object obj, Object obj2, Object obj3) {
        return g.a.d(this, obj, obj2, obj3);
    }

    @Override // c9.r
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return g.a.e(this, obj, obj2, obj3, obj4);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(n container, String name, String signature, Object obj) {
        this(container, name, signature, null, obj);
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(signature, "signature");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public o(n container, kotlin.reflect.jvm.internal.impl.descriptors.y descriptor) {
        kotlin.jvm.internal.m.f(container, "container");
        kotlin.jvm.internal.m.f(descriptor, "descriptor");
        String strF = descriptor.getName().f();
        kotlin.jvm.internal.m.e(strF, "descriptor.name.asString()");
        this(container, strF, k0.f14515a.g(descriptor).get_signature(), descriptor, null, 16, null);
    }
}
