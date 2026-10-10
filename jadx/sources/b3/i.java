package b3;

import com.google.gson.s;
import com.google.gson.v;
import com.google.gson.w;
import com.google.gson.x;
import com.google.gson.y;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class i extends x<Number> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final y f776b = f(v.f4934b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w f777a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements y {
        a() {
        }

        @Override // com.google.gson.y
        public <T> x<T> a(com.google.gson.e eVar, f3.a<T> aVar) {
            if (aVar.c() == Number.class) {
                return i.this;
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f779a;

        static {
            int[] iArr = new int[g3.b.values().length];
            f779a = iArr;
            try {
                iArr[g3.b.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f779a[g3.b.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f779a[g3.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static y e(w wVar) {
        return wVar == v.f4934b ? f776b : f(wVar);
    }

    private static y f(w wVar) {
        return new i(wVar).new a();
    }

    private i(w wVar) {
        this.f777a = wVar;
    }

    @Override // com.google.gson.x
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Number b(g3.a aVar) throws IOException {
        g3.b bVarB = aVar.B();
        int i10 = b.f779a[bVarB.ordinal()];
        if (i10 != 1) {
            if (i10 != 2 && i10 != 3) {
                throw new s("Expecting number, got: " + bVarB + "; at path " + aVar.getPath());
            }
            return this.f777a.a(aVar);
        }
        aVar.x();
        return null;
    }

    @Override // com.google.gson.x
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void d(g3.c cVar, Number number) throws IOException {
        cVar.F(number);
    }
}
