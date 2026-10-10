package kotlin.reflect.jvm.internal.impl.util;

import kotlin.reflect.jvm.internal.impl.descriptors.y;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class t implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14475a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f14476b;

        public a(int i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("must have at least ");
            sb2.append(i10);
            sb2.append(" value parameter");
            sb2.append(i10 > 1 ? "s" : "");
            super(sb2.toString(), null);
            this.f14476b = i10;
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.f
        public boolean b(y functionDescriptor) {
            kotlin.jvm.internal.m.f(functionDescriptor, "functionDescriptor");
            return functionDescriptor.f().size() >= this.f14476b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f14477b;

        public b(int i10) {
            super("must have exactly " + i10 + " value parameters", null);
            this.f14477b = i10;
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.f
        public boolean b(y functionDescriptor) {
            kotlin.jvm.internal.m.f(functionDescriptor, "functionDescriptor");
            return functionDescriptor.f().size() == this.f14477b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class c extends t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f14478b = new c();

        private c() {
            super("must have no value parameters", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.f
        public boolean b(y functionDescriptor) {
            kotlin.jvm.internal.m.f(functionDescriptor, "functionDescriptor");
            return functionDescriptor.f().isEmpty();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class d extends t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f14479b = new d();

        private d() {
            super("must have a single value parameter", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.f
        public boolean b(y functionDescriptor) {
            kotlin.jvm.internal.m.f(functionDescriptor, "functionDescriptor");
            return functionDescriptor.f().size() == 1;
        }
    }

    public /* synthetic */ t(String str, kotlin.jvm.internal.g gVar) {
        this(str);
    }

    private t(String str) {
        this.f14475a = str;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.f
    public String getDescription() {
        return this.f14475a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.f
    public String a(y yVar) {
        return f.a.a(this, yVar);
    }
}
