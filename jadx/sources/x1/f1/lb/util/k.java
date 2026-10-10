package x1.f1.lb.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u000bJ\r\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u000eJ\r\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u000eJ\r\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u000bJ\r\u0010\u0016\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u000bR\u001e\u0010\u001b\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010#\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010\u001dR\u0016\u0010*\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010\"R\u0016\u0010,\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010\"R\u0016\u0010.\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010\u001d¨\u0006/"}, d2 = {"Lx1/f1/lb/util/k;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lr8/z;", "w", "(Landroid/content/Context;Lv8/f;)Ljava/lang/Object;", "", "x", "()Ljava/lang/String;", "", "q", "()I", "", "s", "()J", "t", "u", "y", "v", "r", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "c", "Ljava/lang/String;", "appDistributionChannel", "d", "appType", "e", "I", "appId", "f", "J", "appVersion", "g", "appVersionName", "h", "brandId", "i", "tenantId", "j", "packageName", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int appId;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long appVersion;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static int brandId;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static int tenantId;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f21398a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static q6.b logger = q6.c.d(k.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String appDistributionChannel = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static String appType = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static String appVersionName = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static String packageName = "";

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.util.AppAttrUtils$init$2", f = "AppAttrUtils.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, v8.f<? super a> fVar) {
            super(2, fVar);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new a(this.$context, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            ApplicationInfo applicationInfo;
            PackageInfo packageInfo;
            long longVersionCode;
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                try {
                    int i10 = Build.VERSION.SDK_INT;
                    if (i10 >= 33) {
                        applicationInfo = this.$context.getPackageManager().getApplicationInfo(this.$context.getPackageName(), PackageManager.ApplicationInfoFlags.of(128L));
                        kotlin.jvm.internal.m.c(applicationInfo);
                    } else {
                        applicationInfo = this.$context.getPackageManager().getApplicationInfo(this.$context.getPackageName(), 128);
                        kotlin.jvm.internal.m.c(applicationInfo);
                    }
                    k kVar = k.f21398a;
                    String string = applicationInfo.metaData.getString("DISTRIBUTION_CHANNEL");
                    if (string == null) {
                        string = k.appDistributionChannel;
                    }
                    k.appDistributionChannel = string;
                    String string2 = applicationInfo.metaData.getString("APP_TYPE");
                    if (string2 == null) {
                        string2 = "stb";
                    }
                    k.appType = string2;
                    k.tenantId = applicationInfo.metaData.getInt("TENANT_ID");
                    k.brandId = applicationInfo.metaData.getInt("BRAND_ID");
                    k.appId = applicationInfo.metaData.getInt("APP_ID");
                    k.packageName = this.$context.getPackageName();
                    if (i10 >= 33) {
                        packageInfo = this.$context.getPackageManager().getPackageInfo(k.packageName, PackageManager.PackageInfoFlags.of(0L));
                    } else {
                        packageInfo = this.$context.getPackageManager().getPackageInfo(k.packageName, 0);
                    }
                    if (i10 >= 28) {
                        longVersionCode = packageInfo.getLongVersionCode();
                    } else {
                        longVersionCode = packageInfo.versionCode;
                    }
                    k.appVersion = longVersionCode;
                    String str = packageInfo.versionName;
                    if (str == null) {
                        str = "";
                    }
                    k.appVersionName = str;
                    if (x1.f1.lb.config.b.f20643a.t()) {
                        k.logger.debug("App attr init, [ {} - {} - {} - {} - {} - {} - {} ]", k.appDistributionChannel, kotlin.coroutines.jvm.internal.b.b(k.tenantId), kotlin.coroutines.jvm.internal.b.b(k.brandId), kotlin.coroutines.jvm.internal.b.b(k.appId), k.packageName, kotlin.coroutines.jvm.internal.b.c(k.appVersion), k.appVersionName);
                    }
                } catch (PackageManager.NameNotFoundException e10) {
                    k.logger.error("get app distribution channel failure", e10);
                }
                return r8.z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final int q() {
        return appId;
    }

    public final String r() {
        return appType;
    }

    public final long s() {
        return appVersion;
    }

    public final String t() {
        return appVersionName;
    }

    public final int u() {
        return brandId;
    }

    public final String v() {
        return appDistributionChannel;
    }

    public final String x() {
        return packageName;
    }

    public final int y() {
        return tenantId;
    }

    private k() {
    }

    public final Object w(Context context, v8.f<? super r8.z> fVar) {
        Object objG = kotlinx.coroutines.h.g(kotlinx.coroutines.a1.b(), new a(context, null), fVar);
        if (objG == kotlin.coroutines.intrinsics.b.c()) {
            return objG;
        }
        return r8.z.f17874a;
    }
}
