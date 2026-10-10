package b3;

import com.google.gson.v;
import com.google.gson.w;
import com.google.gson.x;
import com.google.gson.y;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class j extends x<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final y f780c = f(v.f4933a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.gson.e f781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final w f782b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ w f783a;

        a(w wVar) {
            this.f783a = wVar;
        }

        @Override // com.google.gson.y
        public <T> x<T> a(com.google.gson.e eVar, f3.a<T> aVar) {
            a aVar2 = null;
            if (aVar.c() != Object.class) {
                return null;
            }
            return new j(eVar, this.f783a, aVar2);
        }
    }

    /* synthetic */ j(com.google.gson.e eVar, w wVar, a aVar) {
        this(eVar, wVar);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f784a;

        static {
            int[] iArr = new int[g3.b.values().length];
            f784a = iArr;
            try {
                iArr[g3.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f784a[g3.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f784a[g3.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f784a[g3.b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f784a[g3.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f784a[g3.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private j(com.google.gson.e eVar, w wVar) {
        this.f781a = eVar;
        this.f782b = wVar;
    }

    public static y e(w wVar) {
        return wVar == v.f4933a ? f780c : f(wVar);
    }

    private static y f(w wVar) {
        return new a(wVar);
    }

    private Object g(g3.a aVar, g3.b bVar) throws IOException {
        int i10 = b.f784a[bVar.ordinal()];
        if (i10 == 3) {
            return aVar.z();
        }
        if (i10 == 4) {
            return this.f782b.a(aVar);
        }
        if (i10 == 5) {
            return Boolean.valueOf(aVar.r());
        }
        if (i10 == 6) {
            aVar.x();
            return null;
        }
        throw new IllegalStateException("Unexpected token: " + bVar);
    }

    private Object h(g3.a aVar, g3.b bVar) throws IOException {
        int i10 = b.f784a[bVar.ordinal()];
        if (i10 == 1) {
            aVar.a();
            return new ArrayList();
        }
        if (i10 != 2) {
            return null;
        }
        aVar.b();
        return new com.google.gson.internal.h();
    }

    @Override // com.google.gson.x
    public void d(g3.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.q();
            return;
        }
        x xVarQ = this.f781a.q(obj.getClass());
        if (!(xVarQ instanceof j)) {
            xVarQ.d(cVar, obj);
        } else {
            cVar.d();
            cVar.j();
        }
    }

    @Override // com.google.gson.x
    public Object b(g3.a aVar) throws IOException {
        String strV;
        boolean z10;
        g3.b bVarB = aVar.B();
        Object objH = h(aVar, bVarB);
        if (objH == null) {
            return g(aVar, bVarB);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.n()) {
                if (objH instanceof Map) {
                    strV = aVar.v();
                } else {
                    strV = null;
                }
                g3.b bVarB2 = aVar.B();
                Object objH2 = h(aVar, bVarB2);
                if (objH2 != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (objH2 == null) {
                    objH2 = g(aVar, bVarB2);
                }
                if (objH instanceof List) {
                    ((List) objH).add(objH2);
                } else {
                    ((Map) objH).put(strV, objH2);
                }
                if (z10) {
                    arrayDeque.addLast(objH);
                    objH = objH2;
                }
            } else {
                if (objH instanceof List) {
                    aVar.i();
                } else {
                    aVar.j();
                }
                if (arrayDeque.isEmpty()) {
                    return objH;
                }
                objH = arrayDeque.removeLast();
            }
        }
    }
}
