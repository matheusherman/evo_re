package x1.f1.lb.util;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInstaller;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\bJ\u001d\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010!R\u0014\u0010$\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010!R\u0014\u0010%\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0017\u0010!R\u0014\u0010(\u001a\u00020\u00118\u0002X\u0082D¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010'R\u0016\u0010+\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010*R\u0016\u0010.\u001a\u00020,8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0007\u0010-R\u0014\u00100\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u00069"}, d2 = {"Lx1/f1/lb/util/PackageInstallManager;", "", "Landroid/content/Context;", "mContext", "<init>", "(Landroid/content/Context;)V", "Lr8/z;", "i", "()V", "", "statusCode", "g", "(I)V", "context", "", "apkPath", "packageName", "", "h", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z", "d", "()Z", "message", "e", "(Ljava/lang/String;)V", "c", "j", "(Ljava/lang/String;Ljava/lang/String;)Z", "a", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "b", "Ljava/lang/String;", "TAG", "BROADCAST_ACTION", "BROADCAST_SENDER_PERMISSION", "SECTION_NAME", "f", "Z", "DBG", "mInstallCompleted", "I", "mInstallStatusCode", "Ljava/util/concurrent/CountDownLatch;", "Ljava/util/concurrent/CountDownLatch;", "mCountDownLatch", "Ljava/lang/Object;", "mLock", "Ljava/lang/Runnable;", "k", "Ljava/lang/Runnable;", "mRunnable", "Landroid/content/BroadcastReceiver;", "l", "Landroid/content/BroadcastReceiver;", "mBroadcastReceiver", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PackageInstallManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context mContext;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String BROADCAST_ACTION;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String BROADCAST_SENDER_PERMISSION;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String SECTION_NAME;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean DBG;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean mInstallCompleted;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mInstallStatusCode;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private CountDownLatch mCountDownLatch;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final Object mLock;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final Runnable mRunnable;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final BroadcastReceiver mBroadcastReceiver;

    public PackageInstallManager(Context mContext) {
        kotlin.jvm.internal.m.f(mContext, "mContext");
        this.mContext = mContext;
        this.TAG = "PackageInstallManager";
        x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
        this.BROADCAST_ACTION = bVar.d() + ".ACTION_INSTALL_COMMIT";
        this.BROADCAST_SENDER_PERMISSION = bVar.d() + ".permission.INSTALL_PACKAGES";
        this.SECTION_NAME = "ZenithHost";
        this.DBG = true;
        this.mLock = new Object();
        this.mRunnable = new Runnable() { // from class: x1.f1.lb.util.s0
            @Override // java.lang.Runnable
            public final void run() {
                PackageInstallManager.f(this.f21445a);
            }
        };
        this.mBroadcastReceiver = new BroadcastReceiver() { // from class: x1.f1.lb.util.PackageInstallManager$mBroadcastReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                kotlin.jvm.internal.m.f(intent, "intent");
                this.f21290a.g(intent.getIntExtra("android.content.pm.extra.STATUS", 1));
            }
        };
        i();
    }

    private final boolean d() {
        e("getInstallResult " + this.mInstallCompleted + ";" + this.mInstallStatusCode);
        return this.mInstallCompleted && this.mInstallStatusCode == 0;
    }

    private final void e(String message) {
        if (this.DBG) {
            Log.d(this.TAG, message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(PackageInstallManager packageInstallManager) {
        packageInstallManager.e("mRunnable run");
        int i10 = 0;
        while (!packageInstallManager.mInstallCompleted) {
            try {
                packageInstallManager.e("mRunnable wait " + i10);
                Thread.sleep((long) 100);
                i10 += 100;
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        CountDownLatch countDownLatch = packageInstallManager.mCountDownLatch;
        if (countDownLatch == null) {
            kotlin.jvm.internal.m.v("mCountDownLatch");
            countDownLatch = null;
        }
        countDownLatch.countDown();
        packageInstallManager.e("mRunnable end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(int statusCode) {
        this.mInstallStatusCode = statusCode;
        this.mInstallCompleted = true;
        e("onPackageInstalled " + statusCode);
    }

    private final boolean h(Context context, String apkPath, String packageName) {
        File file = new File(apkPath);
        e("parserAndInstall start");
        try {
            PackageInstaller.SessionParams sessionParams = new PackageInstaller.SessionParams(1);
            sessionParams.setReferrerUri(Uri.fromFile(file));
            if (!TextUtils.isEmpty(packageName)) {
                sessionParams.setAppPackageName(packageName);
            }
            sessionParams.setSize(file.length());
            int iCreateSession = context.getPackageManager().getPackageInstaller().createSession(sessionParams);
            PackageInstaller.Session sessionOpenSession = context.getPackageManager().getPackageInstaller().openSession(iCreateSession);
            e("parserAndInstall params ready");
            try {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    OutputStream outputStreamOpenWrite = sessionOpenSession.openWrite(this.SECTION_NAME, 0L, file.length());
                    kotlin.jvm.internal.m.e(outputStreamOpenWrite, "openWrite(...)");
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int i10 = fileInputStream.read(bArr);
                            if (i10 == -1) {
                                break;
                            }
                            outputStreamOpenWrite.write(bArr, 0, i10);
                        }
                        sessionOpenSession.fsync(outputStreamOpenWrite);
                        outputStreamOpenWrite.close();
                        fileInputStream.close();
                        Thread.sleep(1000L);
                        Intent intent = new Intent(this.BROADCAST_ACTION);
                        sessionOpenSession.commit((Build.VERSION.SDK_INT >= 31 ? PendingIntent.getBroadcast(context, iCreateSession, intent, 201326592) : PendingIntent.getBroadcast(context, iCreateSession, intent, 134217728)).getIntentSender());
                        sessionOpenSession.close();
                        e("parserAndInstall end");
                        return true;
                    } catch (Throwable th) {
                        outputStreamOpenWrite.close();
                        fileInputStream.close();
                        throw th;
                    }
                } catch (IOException e10) {
                    Log.e(this.TAG, "install error with IOException", e10);
                    sessionOpenSession.close();
                    sessionOpenSession.close();
                    return false;
                } catch (SecurityException e11) {
                    Log.e(this.TAG, "install error with SecurityException", e11);
                    sessionOpenSession.close();
                    sessionOpenSession.close();
                    return false;
                }
            } catch (Throwable th2) {
                sessionOpenSession.close();
                throw th2;
            }
        } catch (IOException e12) {
            e12.printStackTrace();
            return false;
        }
    }

    private final void i() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(this.BROADCAST_ACTION);
        this.mContext.registerReceiver(this.mBroadcastReceiver, intentFilter, this.BROADCAST_SENDER_PERMISSION, null);
        e("onSetup");
    }

    public final void c() {
        try {
            this.mContext.unregisterReceiver(this.mBroadcastReceiver);
        } catch (Exception unused) {
        }
        e("destroy");
    }

    public final boolean j(String apkPath, String packageName) {
        kotlin.jvm.internal.m.f(apkPath, "apkPath");
        kotlin.jvm.internal.m.f(packageName, "packageName");
        synchronized (this.mLock) {
            try {
                e("silentInstallByPackageName " + apkPath + ";" + packageName);
                if (!h(this.mContext, apkPath, packageName)) {
                    r8.z zVar = r8.z.f17874a;
                    return false;
                }
                this.mInstallCompleted = false;
                this.mInstallStatusCode = 1;
                this.mCountDownLatch = new CountDownLatch(1);
                Thread thread = new Thread(this.mRunnable, "apk_installer");
                thread.setDaemon(true);
                thread.start();
                try {
                    CountDownLatch countDownLatch = this.mCountDownLatch;
                    if (countDownLatch == null) {
                        kotlin.jvm.internal.m.v("mCountDownLatch");
                        countDownLatch = null;
                    }
                    countDownLatch.await(1L, TimeUnit.MINUTES);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                return d();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
