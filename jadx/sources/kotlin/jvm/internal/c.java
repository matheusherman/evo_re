package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class c implements i9.c, Serializable {
    public static final Object NO_RECEIVER = a.f12332a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient i9.c reflected;
    private final String signature;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f12332a = new a();

        private Object readResolve() {
            return f12332a;
        }

        private a() {
        }
    }

    public c() {
        this(NO_RECEIVER);
    }

    protected abstract i9.c computeReflected();

    protected c(Object obj) {
        this(obj, null, null, null, false);
    }

    public i9.c compute() {
        i9.c cVar = this.reflected;
        if (cVar != null) {
            return cVar;
        }
        i9.c cVarComputeReflected = computeReflected();
        this.reflected = cVarComputeReflected;
        return cVarComputeReflected;
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // i9.c
    public String getName() {
        return this.name;
    }

    public i9.f getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? c0.c(cls) : c0.b(cls);
    }

    public String getSignature() {
        return this.signature;
    }

    protected c(Object obj, Class cls, String str, String str2, boolean z10) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z10;
    }

    @Override // i9.c
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // i9.c
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    @Override // i9.b
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    @Override // i9.c
    public List<i9.j> getParameters() {
        return getReflected().getParameters();
    }

    protected i9.c getReflected() {
        i9.c cVarCompute = compute();
        if (cVarCompute != this) {
            return cVarCompute;
        }
        throw new b9.b();
    }

    @Override // i9.c
    public i9.n getReturnType() {
        return getReflected().getReturnType();
    }

    @Override // i9.c
    public List<i9.o> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // i9.c
    public i9.r getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // i9.c
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // i9.c
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // i9.c
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // i9.c
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}
