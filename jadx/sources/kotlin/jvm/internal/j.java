package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class j extends c implements i, i9.g {
    private final int arity;
    private final int flags;

    public j(int i10) {
        this(i10, c.NO_RECEIVER, null, null, null, 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            return getName().equals(jVar.getName()) && getSignature().equals(jVar.getSignature()) && this.flags == jVar.flags && this.arity == jVar.arity && m.a(getBoundReceiver(), jVar.getBoundReceiver()) && m.a(getOwner(), jVar.getOwner());
        }
        if (obj instanceof i9.g) {
            return obj.equals(compute());
        }
        return false;
    }

    public j(int i10, Object obj) {
        this(i10, obj, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.i
    public int getArity() {
        return this.arity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.c
    public i9.g getReflected() {
        return (i9.g) super.getReflected();
    }

    public j(int i10, Object obj, Class cls, String str, String str2, int i11) {
        super(obj, cls, str, str2, (i11 & 1) == 1);
        this.arity = i10;
        this.flags = i11 >> 1;
    }

    @Override // kotlin.jvm.internal.c
    protected i9.c computeReflected() {
        return c0.a(this);
    }

    public int hashCode() {
        int iHashCode;
        if (getOwner() == null) {
            iHashCode = 0;
        } else {
            iHashCode = getOwner().hashCode() * 31;
        }
        return ((iHashCode + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // i9.g
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // i9.g
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // i9.g
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // i9.g
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.c, i9.c
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        i9.c cVarCompute = compute();
        if (cVarCompute != this) {
            return cVarCompute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }
}
