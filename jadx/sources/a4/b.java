package a4;

import java.util.Objects;
import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z3.b f101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final z3.b f102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final z3.c f103c;

    z3.c a() {
        return this.f103c;
    }

    z3.b b() {
        return this.f101a;
    }

    z3.b c() {
        return this.f102b;
    }

    boolean d() {
        return this.f102b == null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Objects.equals(this.f101a, bVar.f101a) && Objects.equals(this.f102b, bVar.f102b) && Objects.equals(this.f103c, bVar.f103c);
    }

    public int hashCode() {
        return (Objects.hashCode(this.f101a) ^ Objects.hashCode(this.f102b)) ^ Objects.hashCode(this.f103c);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[ ");
        sb2.append(this.f101a);
        sb2.append(" , ");
        sb2.append(this.f102b);
        sb2.append(" : ");
        z3.c cVar = this.f103c;
        sb2.append(cVar == null ? Configurator.NULL : Integer.valueOf(cVar.c()));
        sb2.append(" ]");
        return sb2.toString();
    }

    b(z3.b bVar, z3.b bVar2, z3.c cVar) {
        this.f101a = bVar;
        this.f102b = bVar2;
        this.f103c = cVar;
    }
}
