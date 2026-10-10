package kotlin.reflect.jvm.internal.impl.resolve.constants;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ba.b f13896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13897b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return kotlin.jvm.internal.m.a(this.f13896a, fVar.f13896a) && this.f13897b == fVar.f13897b;
    }

    public f(ba.b classId, int i10) {
        kotlin.jvm.internal.m.f(classId, "classId");
        this.f13896a = classId;
        this.f13897b = i10;
    }

    public final ba.b a() {
        return this.f13896a;
    }

    public final int b() {
        return this.f13897b;
    }

    public final int c() {
        return this.f13897b;
    }

    public final ba.b d() {
        return this.f13896a;
    }

    public int hashCode() {
        return (this.f13896a.hashCode() * 31) + this.f13897b;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int i10 = this.f13897b;
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append("kotlin/Array<");
        }
        sb2.append(this.f13896a);
        int i12 = this.f13897b;
        for (int i13 = 0; i13 < i12; i13++) {
            sb2.append(">");
        }
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
