package db;

import java.util.Locale;
import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f9684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private cb.b f9685d;

    public int a() {
        return this.f9683b;
    }

    public String b() {
        return this.f9684c;
    }

    public int c() {
        return this.f9682a;
    }

    public cb.b d() {
        return this.f9685d;
    }

    public void e(int i10) {
        this.f9683b = i10;
    }

    public void f(String str) {
        this.f9684c = str;
    }

    public void g(int i10) {
        this.f9682a = i10;
    }

    public void h(cb.b bVar) {
        this.f9685d = bVar;
    }

    public String i(i iVar, Locale locale) {
        cb.b bVar = this.f9685d;
        return bVar != null ? bVar.k(iVar, locale) : Configurator.NULL;
    }

    public String toString() {
        return "ResourceEntry{size=" + this.f9682a + ", flags=" + this.f9683b + ", key='" + this.f9684c + "', value=" + this.f9685d + '}';
    }
}
