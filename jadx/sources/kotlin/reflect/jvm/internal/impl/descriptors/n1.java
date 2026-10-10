package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f13000b;

    protected n1(String name, boolean z10) {
        kotlin.jvm.internal.m.f(name, "name");
        this.f12999a = name;
        this.f13000b = z10;
    }

    public Integer a(n1 visibility) {
        kotlin.jvm.internal.m.f(visibility, "visibility");
        return m1.f12985a.a(this, visibility);
    }

    public String b() {
        return this.f12999a;
    }

    public final boolean c() {
        return this.f13000b;
    }

    public final String toString() {
        return b();
    }

    public n1 d() {
        return this;
    }
}
