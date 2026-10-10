package e0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Class<?> f9801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Class<?> f9802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Class<?> f9803c;

    public j() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return this.f9801a.equals(jVar.f9801a) && this.f9802b.equals(jVar.f9802b) && l.d(this.f9803c, jVar.f9803c);
    }

    public j(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        a(cls, cls2, cls3);
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.f9801a = cls;
        this.f9802b = cls2;
        this.f9803c = cls3;
    }

    public int hashCode() {
        int iHashCode = ((this.f9801a.hashCode() * 31) + this.f9802b.hashCode()) * 31;
        Class<?> cls = this.f9803c;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f9801a + ", second=" + this.f9802b + '}';
    }
}
