package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.h.b;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class h<FieldDescriptorType extends b<FieldDescriptorType>> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final h f13661d = new h(true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f13663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f13664c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v<FieldDescriptorType, Object> f13662a = v.o(16);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface b<T extends b<T>> extends Comparable<T> {
        q.a D(q.a aVar, q qVar);

        boolean E();

        z.b H();

        z.c L();

        boolean N();

        int h();
    }

    private h() {
    }

    public int k() {
        int iF = 0;
        for (int i10 = 0; i10 < this.f13662a.j(); i10++) {
            Map.Entry<K, Object> entryI = this.f13662a.i(i10);
            iF += f((b) entryI.getKey(), entryI.getValue());
        }
        Iterator it = this.f13662a.k().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            iF += f((b) entry.getKey(), entry.getValue());
        }
        return iF;
    }

    public boolean n() {
        for (int i10 = 0; i10 < this.f13662a.j(); i10++) {
            if (!o(this.f13662a.i(i10))) {
                return false;
            }
        }
        Iterator it = this.f13662a.k().iterator();
        while (it.hasNext()) {
            if (!o((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public void r(h<FieldDescriptorType> hVar) {
        for (int i10 = 0; i10 < hVar.f13662a.j(); i10++) {
            s(hVar.f13662a.i(i10));
        }
        Iterator it = hVar.f13662a.k().iterator();
        while (it.hasNext()) {
            s((Map.Entry) it.next());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f13666b;

        static {
            int[] iArr = new int[z.b.values().length];
            f13666b = iArr;
            try {
                iArr[z.b.f13748a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13666b[z.b.f13749b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13666b[z.b.f13750c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13666b[z.b.f13751d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13666b[z.b.f13752e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13666b[z.b.f13753f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13666b[z.b.f13754g.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13666b[z.b.f13755h.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f13666b[z.b.f13756i.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f13666b[z.b.f13759l.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f13666b[z.b.f13760m.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f13666b[z.b.f13762o.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f13666b[z.b.f13763p.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f13666b[z.b.f13764q.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f13666b[z.b.f13765r.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f13666b[z.b.f13757j.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f13666b[z.b.f13758k.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f13666b[z.b.f13761n.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[z.c.values().length];
            f13665a = iArr2;
            try {
                iArr2[z.c.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f13665a[z.c.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f13665a[z.c.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f13665a[z.c.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f13665a[z.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f13665a[z.c.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f13665a[z.c.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f13665a[z.c.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f13665a[z.c.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    private Object c(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private static int e(z.b bVar, Object obj) {
        switch (a.f13666b[bVar.ordinal()]) {
            case 1:
                return f.g(((Double) obj).doubleValue());
            case 2:
                return f.m(((Float) obj).floatValue());
            case 3:
                return f.q(((Long) obj).longValue());
            case 4:
                return f.F(((Long) obj).longValue());
            case 5:
                return f.p(((Integer) obj).intValue());
            case 6:
                return f.k(((Long) obj).longValue());
            case 7:
                return f.j(((Integer) obj).intValue());
            case 8:
                return f.b(((Boolean) obj).booleanValue());
            case 9:
                return f.C((String) obj);
            case 10:
                return obj instanceof d ? f.e((d) obj) : f.c((byte[]) obj);
            case 11:
                return f.E(((Integer) obj).intValue());
            case 12:
                return f.x(((Integer) obj).intValue());
            case 13:
                return f.y(((Long) obj).longValue());
            case 14:
                return f.z(((Integer) obj).intValue());
            case 15:
                return f.B(((Long) obj).longValue());
            case 16:
                return f.n((q) obj);
            case 17:
                return obj instanceof l ? f.r((l) obj) : f.t((q) obj);
            case 18:
                return obj instanceof j.a ? f.i(((j.a) obj).h()) : f.i(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static <T extends b<T>> h<T> g() {
        return f13661d;
    }

    static int l(z.b bVar, boolean z10) {
        if (z10) {
            return 2;
        }
        return bVar.f();
    }

    public static <T extends b<T>> h<T> t() {
        return new h<>();
    }

    public static Object u(e eVar, z.b bVar, boolean z10) {
        switch (a.f13666b[bVar.ordinal()]) {
            case 1:
                return Double.valueOf(eVar.m());
            case 2:
                return Float.valueOf(eVar.q());
            case 3:
                return Long.valueOf(eVar.t());
            case 4:
                return Long.valueOf(eVar.M());
            case 5:
                return Integer.valueOf(eVar.s());
            case 6:
                return Long.valueOf(eVar.p());
            case 7:
                return Integer.valueOf(eVar.o());
            case 8:
                return Boolean.valueOf(eVar.k());
            case 9:
                return z10 ? eVar.J() : eVar.I();
            case 10:
                return eVar.l();
            case 11:
                return Integer.valueOf(eVar.L());
            case 12:
                return Integer.valueOf(eVar.E());
            case 13:
                return Long.valueOf(eVar.F());
            case 14:
                return Integer.valueOf(eVar.G());
            case 15:
                return Long.valueOf(eVar.H());
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static void x(f fVar, z.b bVar, int i10, Object obj) throws IOException {
        if (bVar == z.b.f13757j) {
            fVar.Y(i10, (q) obj);
        } else {
            fVar.w0(i10, l(bVar, false));
            y(fVar, bVar, obj);
        }
    }

    private static void y(f fVar, z.b bVar, Object obj) throws IOException {
        switch (a.f13666b[bVar.ordinal()]) {
            case 1:
                fVar.R(((Double) obj).doubleValue());
                break;
            case 2:
                fVar.X(((Float) obj).floatValue());
                break;
            case 3:
                fVar.c0(((Long) obj).longValue());
                break;
            case 4:
                fVar.z0(((Long) obj).longValue());
                break;
            case 5:
                fVar.b0(((Integer) obj).intValue());
                break;
            case 6:
                fVar.V(((Long) obj).longValue());
                break;
            case 7:
                fVar.U(((Integer) obj).intValue());
                break;
            case 8:
                fVar.M(((Boolean) obj).booleanValue());
                break;
            case 9:
                fVar.v0((String) obj);
                break;
            case 10:
                if (!(obj instanceof d)) {
                    fVar.N((byte[]) obj);
                } else {
                    fVar.P((d) obj);
                }
                break;
            case 11:
                fVar.y0(((Integer) obj).intValue());
                break;
            case 12:
                fVar.q0(((Integer) obj).intValue());
                break;
            case 13:
                fVar.r0(((Long) obj).longValue());
                break;
            case 14:
                fVar.s0(((Integer) obj).intValue());
                break;
            case 15:
                fVar.u0(((Long) obj).longValue());
                break;
            case 16:
                fVar.Z((q) obj);
                break;
            case 17:
                fVar.e0((q) obj);
                break;
            case 18:
                if (!(obj instanceof j.a)) {
                    fVar.T(((Integer) obj).intValue());
                } else {
                    fVar.T(((j.a) obj).h());
                }
                break;
        }
    }

    public Object h(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f13662a.get(fielddescriptortype);
        return obj instanceof l ? ((l) obj).e() : obj;
    }

    public Iterator<Map.Entry<FieldDescriptorType, Object>> p() {
        return this.f13664c ? new l.c(this.f13662a.entrySet().iterator()) : this.f13662a.entrySet().iterator();
    }

    public void q() {
        if (this.f13663b) {
            return;
        }
        this.f13662a.n();
        this.f13663b = true;
    }

    private static int d(z.b bVar, int i10, Object obj) {
        int iD = f.D(i10);
        if (bVar == z.b.f13757j) {
            iD *= 2;
        }
        return iD + e(bVar, obj);
    }

    public static int f(b<?> bVar, Object obj) {
        z.b bVarH = bVar.H();
        int iH = bVar.h();
        if (bVar.E()) {
            int iD = 0;
            if (bVar.N()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    iD += e(bVarH, it.next());
                }
                return f.D(iH) + iD + f.v(iD);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                iD += d(bVarH, iH, it2.next());
            }
            return iD;
        }
        return d(bVarH, iH, obj);
    }

    private boolean o(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.L() == z.c.MESSAGE) {
            if (key.E()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((q) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof q) {
                    if (!((q) value).isInitialized()) {
                        return false;
                    }
                } else {
                    if (value instanceof l) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private void s(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof l) {
            value = ((l) value).e();
        }
        if (key.E()) {
            Object objH = h(key);
            if (objH == null) {
                objH = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objH).add(c(it.next()));
            }
            this.f13662a.p(key, objH);
            return;
        }
        if (key.L() == z.c.MESSAGE) {
            Object objH2 = h(key);
            if (objH2 == null) {
                this.f13662a.p(key, c(value));
                return;
            } else {
                this.f13662a.p(key, key.D(((q) objH2).c(), (q) value).build());
                return;
            }
        }
        this.f13662a.p(key, c(value));
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001e  */
    private static void w(z.b bVar, Object obj) {
        obj.getClass();
        boolean z10 = true;
        boolean z11 = false;
        switch (a.f13665a[bVar.a().ordinal()]) {
            case 1:
                z11 = obj instanceof Integer;
                break;
            case 2:
                z11 = obj instanceof Long;
                break;
            case 3:
                z11 = obj instanceof Float;
                break;
            case 4:
                z11 = obj instanceof Double;
                break;
            case 5:
                z11 = obj instanceof Boolean;
                break;
            case 6:
                z11 = obj instanceof String;
                break;
            case 7:
                if (!(obj instanceof d) && !(obj instanceof byte[])) {
                    z10 = false;
                }
                z11 = z10;
                break;
            case 8:
                if (!(obj instanceof Integer) && !(obj instanceof j.a)) {
                    z10 = false;
                }
                z11 = z10;
                break;
            case 9:
                if (!(obj instanceof q) && !(obj instanceof l)) {
                    z10 = false;
                }
                z11 = z10;
                break;
        }
        if (z11) {
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public static void z(b<?> bVar, Object obj, f fVar) throws IOException {
        z.b bVarH = bVar.H();
        int iH = bVar.h();
        if (bVar.E()) {
            List list = (List) obj;
            if (bVar.N()) {
                fVar.w0(iH, 2);
                Iterator it = list.iterator();
                int iE = 0;
                while (it.hasNext()) {
                    iE += e(bVarH, it.next());
                }
                fVar.o0(iE);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    y(fVar, bVarH, it2.next());
                }
                return;
            }
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                x(fVar, bVarH, iH, it3.next());
            }
            return;
        }
        if (obj instanceof l) {
            x(fVar, bVarH, iH, ((l) obj).e());
        } else {
            x(fVar, bVarH, iH, obj);
        }
    }

    public void a(FieldDescriptorType fielddescriptortype, Object obj) {
        List arrayList;
        if (fielddescriptortype.E()) {
            w(fielddescriptortype.H(), obj);
            Object objH = h(fielddescriptortype);
            if (objH == null) {
                arrayList = new ArrayList();
                this.f13662a.p(fielddescriptortype, arrayList);
            } else {
                arrayList = (List) objH;
            }
            arrayList.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public h<FieldDescriptorType> clone() {
        h<FieldDescriptorType> hVarT = t();
        for (int i10 = 0; i10 < this.f13662a.j(); i10++) {
            Map.Entry<K, Object> entryI = this.f13662a.i(i10);
            hVarT.v((b) entryI.getKey(), entryI.getValue());
        }
        Iterator it = this.f13662a.k().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            hVarT.v((b) entry.getKey(), entry.getValue());
        }
        hVarT.f13664c = this.f13664c;
        return hVarT;
    }

    public Object i(FieldDescriptorType fielddescriptortype, int i10) {
        if (fielddescriptortype.E()) {
            Object objH = h(fielddescriptortype);
            if (objH != null) {
                return ((List) objH).get(i10);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int j(FieldDescriptorType fielddescriptortype) {
        if (fielddescriptortype.E()) {
            Object objH = h(fielddescriptortype);
            if (objH == null) {
                return 0;
            }
            return ((List) objH).size();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public boolean m(FieldDescriptorType fielddescriptortype) {
        if (!fielddescriptortype.E()) {
            if (this.f13662a.get(fielddescriptortype) != null) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    public void v(FieldDescriptorType fielddescriptortype, Object obj) {
        if (fielddescriptortype.E()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    w(fielddescriptortype.H(), it.next());
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            w(fielddescriptortype.H(), obj);
        }
        if (obj instanceof l) {
            this.f13664c = true;
        }
        this.f13662a.p(fielddescriptortype, obj);
    }

    private h(boolean z10) {
        q();
    }
}
