package kotlin.reflect.jvm.internal.impl.util;

import kotlin.reflect.jvm.internal.impl.descriptors.y;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class k implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14423a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f14424b = new a();

        private a() {
            super("must be a member function", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.f
        public boolean b(y functionDescriptor) {
            kotlin.jvm.internal.m.f(functionDescriptor, "functionDescriptor");
            return functionDescriptor.b0() != null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f14425b = new b();

        private b() {
            super("must be a member or an extension function", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.f
        public boolean b(y functionDescriptor) {
            kotlin.jvm.internal.m.f(functionDescriptor, "functionDescriptor");
            return (functionDescriptor.b0() == null && functionDescriptor.i0() == null) ? false : true;
        }
    }

    public /* synthetic */ k(String str, kotlin.jvm.internal.g gVar) {
        this(str);
    }

    private k(String str) {
        this.f14423a = str;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.f
    public String getDescription() {
        return this.f14423a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.f
    public String a(y yVar) {
        return f.a.a(this, yVar);
    }
}
