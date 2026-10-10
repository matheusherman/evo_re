package kotlin.reflect.jvm.internal.calls;

import androidx.core.app.NotificationCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.l;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.n0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0002 \u0001*\u0004\u0018\u00010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0010B%\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001a0\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u001f¨\u0006!"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/h;", "Ljava/lang/reflect/Member;", "M", "Lkotlin/reflect/jvm/internal/calls/e;", "Lkotlin/reflect/jvm/internal/impl/descriptors/b;", "descriptor", "caller", "", "isDefault", "<init>", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/e;Z)V", "", "args", "", NotificationCompat.CATEGORY_CALL, "([Ljava/lang/Object;)Ljava/lang/Object;", "a", "Lkotlin/reflect/jvm/internal/calls/e;", "b", "Z", "Lkotlin/reflect/jvm/internal/calls/h$a;", "c", "Lkotlin/reflect/jvm/internal/calls/h$a;", "data", "()Ljava/lang/reflect/Member;", "member", "Ljava/lang/reflect/Type;", "getReturnType", "()Ljava/lang/reflect/Type;", "returnType", "", "()Ljava/util/List;", "parameterTypes", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class h<M extends Member> implements e<M> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final e<M> caller;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isDefault;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final a data;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0086\u0002¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0086\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0010\u001a\u0004\b\u0011\u0010\u000bR\u001f\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0013\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\u0015\u0010\u000f¨\u0006\u0016"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/h$a;", "", "Lh9/e;", "argumentRange", "", "Ljava/lang/reflect/Method;", "unbox", "box", "<init>", "(Lh9/e;[Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "a", "()Lh9/e;", "b", "()[Ljava/lang/reflect/Method;", "c", "()Ljava/lang/reflect/Method;", "Lh9/e;", "getArgumentRange", "[Ljava/lang/reflect/Method;", "getUnbox", "Ljava/lang/reflect/Method;", "getBox", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final h9.e argumentRange;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final Method[] unbox;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final Method box;

        public a(h9.e argumentRange, Method[] unbox, Method method) {
            m.f(argumentRange, "argumentRange");
            m.f(unbox, "unbox");
            this.argumentRange = argumentRange;
            this.unbox = unbox;
            this.box = method;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final h9.e getArgumentRange() {
            return this.argumentRange;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final Method[] getUnbox() {
            return this.unbox;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final Method getBox() {
            return this.box;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004d  */
    /* JADX WARN: Multi-variable type inference failed */
    public h(kotlin.reflect.jvm.internal.impl.descriptors.b descriptor, e<? extends M> caller, boolean z10) {
        a aVar;
        Class<?> clsI;
        m.f(descriptor, "descriptor");
        m.f(caller, "caller");
        this.caller = caller;
        this.isDefault = z10;
        g0 returnType = descriptor.getReturnType();
        m.c(returnType);
        Class<?> clsI2 = i.i(returnType);
        Method methodD = clsI2 != null ? i.d(clsI2, descriptor) : null;
        int i10 = 0;
        if (kotlin.reflect.jvm.internal.impl.resolve.g.a(descriptor)) {
            aVar = new a(h9.e.INSTANCE.a(), new Method[0], methodD);
        } else {
            int i11 = -1;
            if (!(caller instanceof f.h.c)) {
                if (descriptor instanceof l) {
                    if (!(caller instanceof d)) {
                        i11 = 0;
                    }
                } else if (descriptor.b0() == null || (caller instanceof d)) {
                    i11 = 0;
                } else {
                    kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = descriptor.b();
                    m.e(mVarB, "descriptor.containingDeclaration");
                    if (kotlin.reflect.jvm.internal.impl.resolve.g.b(mVarB)) {
                        i11 = 0;
                    } else {
                        i11 = 1;
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            x0 x0VarI0 = descriptor.i0();
            g0 type = x0VarI0 != null ? x0VarI0.getType() : null;
            if (type != null) {
                arrayList.add(type);
            } else if (descriptor instanceof l) {
                kotlin.reflect.jvm.internal.impl.descriptors.e eVarW = ((l) descriptor).w();
                m.e(eVarW, "descriptor.constructedClass");
                if (eVarW.J()) {
                    kotlin.reflect.jvm.internal.impl.descriptors.m mVarB2 = eVarW.b();
                    m.d(mVarB2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.e) mVarB2).p());
                }
            } else {
                kotlin.reflect.jvm.internal.impl.descriptors.m mVarB3 = descriptor.b();
                m.e(mVarB3, "descriptor.containingDeclaration");
                if ((mVarB3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) && kotlin.reflect.jvm.internal.impl.resolve.g.b(mVarB3)) {
                    arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.e) mVarB3).p());
                }
            }
            List<j1> listF = descriptor.f();
            m.e(listF, "descriptor.valueParameters");
            Iterator<T> it = listF.iterator();
            while (it.hasNext()) {
                arrayList.add(((j1) it.next()).getType());
            }
            int size = arrayList.size() + i11 + (this.isDefault ? ((arrayList.size() + 31) / 32) + 1 : 0) + (((descriptor instanceof y) && ((y) descriptor).isSuspend()) ? 1 : 0);
            if (g.a(this) != size) {
                throw new f0("Inconsistent number of parameters in the descriptor and Java reflection object: " + g.a(this) + " != " + size + "\nCalling: " + descriptor + "\nParameter types: " + a() + ")\nDefault: " + this.isDefault);
            }
            h9.e eVarM = h9.f.m(Math.max(i11, 0), arrayList.size() + i11);
            Method[] methodArr = new Method[size];
            while (i10 < size) {
                methodArr[i10] = (i10 > eVarM.getLast() || eVarM.getFirst() > i10 || (clsI = i.i((g0) arrayList.get(i10 - i11))) == null) ? null : i.f(clsI, descriptor);
                i10++;
            }
            aVar = new a(eVarM, methodArr, methodD);
        }
        this.data = aVar;
    }

    @Override // kotlin.reflect.jvm.internal.calls.e
    public List<Type> a() {
        return this.caller.a();
    }

    @Override // kotlin.reflect.jvm.internal.calls.e
    public M b() {
        return (M) this.caller.b();
    }

    @Override // kotlin.reflect.jvm.internal.calls.e
    public Object call(Object[] args) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke;
        m.f(args, "args");
        a aVar = this.data;
        h9.e argumentRange = aVar.getArgumentRange();
        Method[] unbox = aVar.getUnbox();
        Method box = aVar.getBox();
        Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
        m.e(objArrCopyOf, "copyOf(this, size)");
        int first = argumentRange.getFirst();
        int last = argumentRange.getLast();
        if (first <= last) {
            while (true) {
                Method method = unbox[first];
                Object objG = args[first];
                if (method != null) {
                    if (objG != null) {
                        objG = method.invoke(objG, null);
                    } else {
                        Class<?> returnType = method.getReturnType();
                        m.e(returnType, "method.returnType");
                        objG = n0.g(returnType);
                    }
                }
                objArrCopyOf[first] = objG;
                if (first == last) {
                    break;
                }
                first++;
            }
        }
        Object objCall = this.caller.call(objArrCopyOf);
        return (box == null || (objInvoke = box.invoke(null, objCall)) == null) ? objCall : objInvoke;
    }

    @Override // kotlin.reflect.jvm.internal.calls.e
    public Type getReturnType() {
        return this.caller.getReturnType();
    }
}
