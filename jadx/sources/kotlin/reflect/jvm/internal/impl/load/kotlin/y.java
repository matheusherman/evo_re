package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface y {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13622a = new a();

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.y
        public List<String> a(String packageFqName) {
            kotlin.jvm.internal.m.f(packageFqName, "packageFqName");
            return kotlin.collections.r.l();
        }

        private a() {
        }
    }

    List<String> a(String str);
}
