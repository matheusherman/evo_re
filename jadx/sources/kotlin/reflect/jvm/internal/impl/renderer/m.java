package kotlin.reflect.jvm.internal.impl.renderer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public enum m {
    PLAIN { // from class: kotlin.reflect.jvm.internal.impl.renderer.m.b
        @Override // kotlin.reflect.jvm.internal.impl.renderer.m
        public String f(String string) {
            kotlin.jvm.internal.m.f(string, "string");
            return string;
        }
    },
    HTML { // from class: kotlin.reflect.jvm.internal.impl.renderer.m.a
        @Override // kotlin.reflect.jvm.internal.impl.renderer.m
        public String f(String string) {
            kotlin.jvm.internal.m.f(string, "string");
            return ua.n.E(ua.n.E(string, "<", "&lt;", false, 4, null), ">", "&gt;", false, 4, null);
        }
    };

    /* synthetic */ m(kotlin.jvm.internal.g gVar) {
        this();
    }

    public abstract String f(String str);
}
