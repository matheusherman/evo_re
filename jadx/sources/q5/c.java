package q5;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.live.evo.R$string;
import com.live.evo.R$style;
import com.live.evo.dialog.y;
import com.live.evo.util.u1;
import com.live.evo.util.v1;
import com.live.evo.util.x1;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import x1.f1.lb.util.g1;
import x1.f1.lb.util.w0;
import x1.f1.lb.util.z;
import z1.b1.lb.m.extra.upgrade.UpgradeInfo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\b\u0010\tJ/\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0018\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u001dR\u0016\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006#"}, d2 = {"Lq5/c;", "", "<init>", "()V", "Lr8/z;", "f", "", "isBackground", "d", "(Z)V", "Landroid/app/Activity;", "activity", "", "apkFilePath", "Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;", "upgradeInfo", "Lcom/live/evo/dialog/y$e;", "upgradeDialogListener", "g", "(Landroid/app/Activity;Ljava/lang/String;Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;Lcom/live/evo/dialog/y$e;)V", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "c", "Ljava/lang/String;", "mLastPromptVersion", "", "J", "mLastPromptTime", "Ljava/lang/Runnable;", "e", "Ljava/lang/Runnable;", "checkUpdateRunnable", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f17661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String mLastPromptVersion;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long mLastPromptTime;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final Runnable checkUpdateRunnable;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"q5/c$a", "Lcom/live/evo/dialog/y$e;", "Lcom/live/evo/dialog/y;", "upgradeDialog", "Lr8/z;", "c", "(Lcom/live/evo/dialog/y;)V", "b", "a", "()V", "", "d", "()I", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements y.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ y.e f17666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f17667b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17668c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f17669d;

        a(y.e eVar, Activity activity, String str, boolean z10) {
            this.f17666a = eVar;
            this.f17667b = activity;
            this.f17668c = str;
            this.f17669d = z10;
        }

        @Override // com.live.evo.dialog.y.e
        public void a() {
            y.e eVar = this.f17666a;
            if (eVar != null) {
                eVar.a();
            }
        }

        @Override // com.live.evo.dialog.y.e
        public void b(y upgradeDialog) {
            boolean zCanRequestPackageInstalls;
            m.f(upgradeDialog, "upgradeDialog");
            int i10 = Build.VERSION.SDK_INT;
            if (i10 < 26) {
                if (i10 >= 24) {
                    v1.a(this.f17667b, this.f17668c);
                    return;
                }
                try {
                    File file = new File(this.f17668c);
                    Intent intent = new Intent();
                    intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                    if (!com.live.evo.a.f5188h) {
                        intent.setFlags(268435456);
                    }
                    intent.setAction("android.intent.action.VIEW");
                    this.f17667b.startActivity(intent);
                    return;
                } catch (Exception e10) {
                    c.logger.error("install failure", e10);
                    g1 g1Var = g1.f21390a;
                    String strJ = x1.j(R$string.install_failed);
                    m.e(strJ, "getString(...)");
                    g1Var.e(strJ);
                    return;
                }
            }
            try {
                zCanRequestPackageInstalls = this.f17667b.getPackageManager().canRequestPackageInstalls();
            } catch (Exception unused) {
                zCanRequestPackageInstalls = false;
            }
            if (zCanRequestPackageInstalls) {
                v1.a(this.f17667b, this.f17668c);
                return;
            }
            Uri uri = Uri.parse("package:" + this.f17667b.getPackageName());
            try {
                try {
                    this.f17667b.startActivityForResult(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", uri), 100);
                } catch (Exception unused2) {
                    Intent intent2 = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", uri);
                    intent2.setClassName("com.android.tv.settings", "com.android.tv.settings.device.apps.specialaccess.ExternalSourcesActivity");
                    this.f17667b.startActivity(intent2);
                }
            } catch (Throwable th) {
                c.logger.error("apply install permission failure", th);
            }
            g1 g1Var2 = g1.f21390a;
            String strJ2 = x1.j(R$string.open_install_permission);
            m.e(strJ2, "getString(...)");
            g1Var2.e(strJ2);
        }

        @Override // com.live.evo.dialog.y.e
        public void c(y upgradeDialog) {
            m.f(upgradeDialog, "upgradeDialog");
            c.f17661a.f();
            upgradeDialog.dismiss();
            y.e eVar = this.f17666a;
            if (eVar != null) {
                eVar.c(upgradeDialog);
            }
        }

        @Override // com.live.evo.dialog.y.e
        public int d() {
            if (this.f17669d) {
                return y.f5804n;
            }
            y.e eVar = this.f17666a;
            return eVar != null ? eVar.d() : y.f5804n;
        }
    }

    public final synchronized void g(Activity activity, String apkFilePath, UpgradeInfo upgradeInfo, y.e upgradeDialogListener) {
        int i10;
        m.f(activity, "activity");
        m.f(apkFilePath, "apkFilePath");
        m.f(upgradeInfo, "upgradeInfo");
        y yVar = new y(activity, R$style.EPGDialog);
        String message = upgradeInfo.getMessage();
        int i11 = 0;
        boolean z10 = upgradeInfo.getForceUpgrade() == 1;
        if (TextUtils.isEmpty(message)) {
            message = activity.getResources().getString(R$string.update_msg);
        }
        try {
            if (z.f21470a.l() / ((long) 1024) <= 100) {
                message = message + "<br/><br/>" + String.format(x1.j(R$string.upgrade_freerom_tip), 100);
            }
        } catch (Exception unused) {
        }
        yVar.f(Html.fromHtml(message));
        String string = activity.getString(R$string.yes_now);
        m.e(string, "getString(...)");
        String string2 = activity.getString(R$string.no_later);
        m.e(string2, "getString(...)");
        String string3 = activity.getString(R$string.update_select);
        m.e(string3, "getString(...)");
        if (z10) {
            i11 = 8;
            i10 = 8;
        } else {
            i10 = 0;
        }
        yVar.d(0, i10, i11, string, string2, string3);
        yVar.e(new a(upgradeDialogListener, activity, apkFilePath, z10));
        String versionName = upgradeInfo.getVersionName();
        if (versionName == null) {
            versionName = "";
        }
        mLastPromptVersion = versionName;
        mLastPromptTime = u1.b().a();
        yVar.show();
    }

    static {
        c cVar = new c();
        f17661a = cVar;
        logger = q6.c.d(cVar.getClass());
        mLastPromptVersion = "";
        checkUpdateRunnable = new Runnable() { // from class: q5.a
            @Override // java.lang.Runnable
            public final void run() {
                c.e();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e() {
        f17661a.d(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        try {
            w0 w0Var = w0.f21452a;
            w0Var.t("prompt_version", mLastPromptVersion);
            w0Var.s("prompt_time", mLastPromptTime);
        } catch (Exception e10) {
            q6.b logger2 = logger;
            m.e(logger2, "logger");
            c5.b.c(logger2, e10, "save local update info error");
        }
    }

    private c() {
    }

    @WorkerThread
    public final void d(boolean isBackground) {
    }
}
