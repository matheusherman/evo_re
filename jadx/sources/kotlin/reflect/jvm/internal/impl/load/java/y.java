package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.EnumMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EnumMap<b, r> f13502a;

    public y(EnumMap<b, r> defaultQualifiers) {
        kotlin.jvm.internal.m.f(defaultQualifiers, "defaultQualifiers");
        this.f13502a = defaultQualifiers;
    }

    public final r a(b bVar) {
        return this.f13502a.get(bVar);
    }

    public final EnumMap<b, r> b() {
        return this.f13502a;
    }
}
