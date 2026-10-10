package h3;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f10839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f10840b;

    public static void e(s[] sVarArr) {
        s sVar;
        s sVar2;
        s sVar3;
        float fB = b(sVarArr[0], sVarArr[1]);
        float fB2 = b(sVarArr[1], sVarArr[2]);
        float fB3 = b(sVarArr[0], sVarArr[2]);
        if (fB2 >= fB && fB2 >= fB3) {
            sVar = sVarArr[0];
            sVar2 = sVarArr[1];
            sVar3 = sVarArr[2];
        } else if (fB3 < fB2 || fB3 < fB) {
            sVar = sVarArr[2];
            sVar2 = sVarArr[0];
            sVar3 = sVarArr[1];
        } else {
            sVar = sVarArr[1];
            sVar2 = sVarArr[0];
            sVar3 = sVarArr[2];
        }
        if (a(sVar2, sVar, sVar3) < 0.0f) {
            s sVar4 = sVar3;
            sVar3 = sVar2;
            sVar2 = sVar4;
        }
        sVarArr[0] = sVar2;
        sVarArr[1] = sVar;
        sVarArr[2] = sVar3;
    }

    private static float a(s sVar, s sVar2, s sVar3) {
        float f10 = sVar2.f10839a;
        float f11 = sVar2.f10840b;
        return ((sVar3.f10839a - f10) * (sVar.f10840b - f11)) - ((sVar3.f10840b - f11) * (sVar.f10839a - f10));
    }

    public static float b(s sVar, s sVar2) {
        return q3.a.a(sVar.f10839a, sVar.f10840b, sVar2.f10839a, sVar2.f10840b);
    }

    public final float c() {
        return this.f10839a;
    }

    public final float d() {
        return this.f10840b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof s) {
            s sVar = (s) obj;
            if (this.f10839a == sVar.f10839a && this.f10840b == sVar.f10840b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f10839a) * 31) + Float.floatToIntBits(this.f10840b);
    }

    public final String toString() {
        return "(" + this.f10839a + ',' + this.f10840b + ')';
    }

    public s(float f10, float f11) {
        this.f10839a = f10;
        this.f10840b = f11;
    }
}
