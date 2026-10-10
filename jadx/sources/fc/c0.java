package fc;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class c0 extends z implements Iterable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final m0 f10120b = new a(c0.class, 16);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    f[] f10121a;

    class b implements Enumeration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f10122a = 0;

        b() {
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f10122a < c0.this.f10121a.length;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            int i10 = this.f10122a;
            f[] fVarArr = c0.this.f10121a;
            if (i10 >= fVarArr.length) {
                throw new NoSuchElementException();
            }
            this.f10122a = i10 + 1;
            return fVarArr[i10];
        }
    }

    protected c0() {
        this.f10121a = g.f10150d;
    }

    abstract c C();

    abstract j D();

    abstract v E();

    abstract d0 H();

    @Override // fc.z
    boolean o() {
        return true;
    }

    static class a extends m0 {
        a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // fc.m0
        z c(c0 c0Var) {
            return c0Var;
        }
    }

    protected c0(f fVar) {
        if (fVar == null) {
            throw new NullPointerException("'element' cannot be null");
        }
        this.f10121a = new f[]{fVar};
    }

    public static c0 z(Object obj) {
        if (obj == null || (obj instanceof c0)) {
            return (c0) obj;
        }
        if (obj instanceof f) {
            z zVarF = ((f) obj).f();
            if (zVarF instanceof c0) {
                return (c0) zVarF;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (c0) f10120b.b((byte[]) obj);
            } catch (IOException e10) {
                throw new IllegalArgumentException("failed to construct sequence from byte[]: " + e10.getMessage());
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    public f A(int i10) {
        return this.f10121a[i10];
    }

    public Enumeration B() {
        return new b();
    }

    f[] I() {
        return this.f10121a;
    }

    @Override // fc.z, fc.s
    public int hashCode() {
        int length = this.f10121a.length;
        int iHashCode = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return iHashCode;
            }
            iHashCode = (iHashCode * 257) ^ this.f10121a[length].f().hashCode();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<f> iterator() {
        return new re.a.C0346a(this.f10121a);
    }

    @Override // fc.z
    boolean m(z zVar) {
        if (!(zVar instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) zVar;
        int size = size();
        if (c0Var.size() != size) {
            return false;
        }
        for (int i10 = 0; i10 < size; i10++) {
            z zVarF = this.f10121a[i10].f();
            z zVarF2 = c0Var.f10121a[i10].f();
            if (zVarF != zVarF2 && !zVarF.m(zVarF2)) {
                return false;
            }
        }
        return true;
    }

    public int size() {
        return this.f10121a.length;
    }

    @Override // fc.z
    z v() {
        return new u1(this.f10121a, false);
    }

    @Override // fc.z
    z w() {
        return new i2(this.f10121a, false);
    }

    protected c0(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("'elementVector' cannot be null");
        }
        this.f10121a = gVar.g();
    }

    public String toString() {
        int size = size();
        if (size == 0) {
            return "[]";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        int i10 = 0;
        while (true) {
            stringBuffer.append(this.f10121a[i10]);
            i10++;
            if (i10 >= size) {
                stringBuffer.append(']');
                return stringBuffer.toString();
            }
            stringBuffer.append(", ");
        }
    }

    c[] x() {
        int size = size();
        c[] cVarArr = new c[size];
        for (int i10 = 0; i10 < size; i10++) {
            cVarArr[i10] = c.A(this.f10121a[i10]);
        }
        return cVarArr;
    }

    v[] y() {
        int size = size();
        v[] vVarArr = new v[size];
        for (int i10 = 0; i10 < size; i10++) {
            vVarArr[i10] = v.z(this.f10121a[i10]);
        }
        return vVarArr;
    }

    c0(f[] fVarArr, boolean z10) {
        this.f10121a = z10 ? g.b(fVarArr) : fVarArr;
    }
}
