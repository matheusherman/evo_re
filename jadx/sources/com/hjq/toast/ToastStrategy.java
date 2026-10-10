package com.hjq.toast;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import com.hjq.toast.config.IToast;
import com.hjq.toast.config.IToastStrategy;
import com.hjq.toast.config.IToastStyle;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class ToastStrategy implements IToastStrategy {
    private static final int DEFAULT_DELAY_TIMEOUT = 200;
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());
    public static final int SHOW_STRATEGY_TYPE_IMMEDIATELY = 0;
    public static final int SHOW_STRATEGY_TYPE_QUEUE = 1;
    private Application mApplication;
    private final Object mCancelMessageToken;
    private volatile long mLastShowToastMillis;
    private final Object mShowMessageToken;
    private final int mShowStrategyType;
    private WeakReference<IToast> mToastReference;

    /* JADX INFO: renamed from: com.hjq.toast.ToastStrategy$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class CancelToastRunnable implements Runnable {
        private CancelToastRunnable() {
        }

        /* synthetic */ CancelToastRunnable(ToastStrategy toastStrategy, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            IToast iToast = ToastStrategy.this.mToastReference != null ? (IToast) ToastStrategy.this.mToastReference.get() : null;
            if (iToast == null) {
                return;
            }
            iToast.cancel();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class ShowToastRunnable implements Runnable {
        private final ToastParams mToastParams;

        /* synthetic */ ShowToastRunnable(ToastStrategy toastStrategy, ToastParams toastParams, AnonymousClass1 anonymousClass1) {
            this(toastParams);
        }

        private ShowToastRunnable(ToastParams toastParams) {
            this.mToastParams = toastParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            IToast iToast = ToastStrategy.this.mToastReference != null ? (IToast) ToastStrategy.this.mToastReference.get() : null;
            if (iToast != null) {
                iToast.cancel();
            }
            IToast iToastCreateToast = ToastStrategy.this.createToast(this.mToastParams);
            ToastStrategy.this.mToastReference = new WeakReference(iToastCreateToast);
            iToastCreateToast.setDuration(this.mToastParams.duration);
            iToastCreateToast.setText(this.mToastParams.text);
            iToastCreateToast.show();
        }
    }

    public ToastStrategy() {
        this(0);
    }

    protected boolean isActivityAvailable(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        return !activity.isDestroyed();
    }

    public ToastStrategy(int i10) {
        this.mShowMessageToken = new Object();
        this.mCancelMessageToken = new Object();
        this.mShowStrategyType = i10;
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("Please don't pass non-existent toast show strategy");
        }
    }

    @SuppressLint({"PrivateApi"})
    protected boolean areNotificationsEnabled(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return ((NotificationManager) context.getSystemService(NotificationManager.class)).areNotificationsEnabled();
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        try {
            Class<?> cls = appOpsManager.getClass();
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("checkOpNoThrow", cls2, cls2, String.class);
            Integer num = (Integer) appOpsManager.getClass().getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class);
            num.intValue();
            return ((Integer) method.invoke(appOpsManager, num, Integer.valueOf(context.getApplicationInfo().uid), context.getPackageName())).intValue() == 0;
        } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException e10) {
            e10.printStackTrace();
            return true;
        }
    }

    protected boolean areSupportCustomToastStyle(IToast iToast) {
        return (iToast instanceof CustomToast) || Build.VERSION.SDK_INT < 30;
    }

    protected void diyToastStyle(IToast iToast, IToastStyle<?> iToastStyle) {
        iToast.setView(iToastStyle.createView(this.mApplication));
        iToast.setGravity(iToastStyle.getGravity(), iToastStyle.getXOffset(), iToastStyle.getYOffset());
        iToast.setMargin(iToastStyle.getHorizontalMargin(), iToastStyle.getVerticalMargin());
    }

    protected int generateToastWaitMillis(ToastParams toastParams) {
        int i10 = toastParams.duration;
        if (i10 == 0) {
            return 1000;
        }
        return i10 == 1 ? 1500 : 0;
    }

    @SuppressLint({"PrivateApi"})
    protected boolean isChangeEnabledCompat(long j10) {
        if (Build.VERSION.SDK_INT < 30) {
            return false;
        }
        try {
            Method method = Class.forName("android.app.compat.CompatChanges").getMethod("isChangeEnabled", Long.TYPE);
            method.setAccessible(true);
            return Boolean.parseBoolean(String.valueOf(method.invoke(null, Long.valueOf(j10))));
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    @Override // com.hjq.toast.config.IToastStrategy
    public void registerStrategy(Application application) {
        this.mApplication = application;
    }

    @Override // com.hjq.toast.config.IToastStrategy
    public void showToast(ToastParams toastParams) {
        int i10 = this.mShowStrategyType;
        AnonymousClass1 anonymousClass1 = null;
        if (i10 == 0) {
            cancelToast();
            HANDLER.postAtTime(new ShowToastRunnable(this, toastParams, anonymousClass1), this.mShowMessageToken, SystemClock.uptimeMillis() + toastParams.delayMillis + ((long) (toastParams.crossPageShow ? 0 : 200)));
        } else {
            if (i10 != 1) {
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis() + toastParams.delayMillis + ((long) (toastParams.crossPageShow ? 0 : 200));
            long jGenerateToastWaitMillis = generateToastWaitMillis(toastParams);
            if (jUptimeMillis < this.mLastShowToastMillis + jGenerateToastWaitMillis) {
                jUptimeMillis = this.mLastShowToastMillis + jGenerateToastWaitMillis;
            }
            HANDLER.postAtTime(new ShowToastRunnable(this, toastParams, anonymousClass1), this.mShowMessageToken, jUptimeMillis);
            this.mLastShowToastMillis = jUptimeMillis;
        }
    }

    @Override // com.hjq.toast.config.IToastStrategy
    public void cancelToast() {
        HANDLER.postAtTime(new CancelToastRunnable(this, null), this.mCancelMessageToken, SystemClock.uptimeMillis());
    }

    @Override // com.hjq.toast.config.IToastStrategy
    public int computeShowDuration(CharSequence charSequence) {
        if (charSequence.length() > 20) {
            return 1;
        }
        return 0;
    }

    @Override // com.hjq.toast.config.IToastStrategy
    public IToast createToast(ToastParams toastParams) {
        IToast systemToast;
        Activity foregroundActivity = getForegroundActivity();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 23 && Settings.canDrawOverlays(this.mApplication)) {
            systemToast = new GlobalToast(this.mApplication);
        } else if (!toastParams.crossPageShow && isActivityAvailable(foregroundActivity)) {
            systemToast = new ActivityToast(foregroundActivity);
        } else if (i10 == 25) {
            systemToast = new SafeToast(this.mApplication);
        } else if (i10 < 29 && !areNotificationsEnabled(this.mApplication)) {
            systemToast = new NotificationToast(this.mApplication);
        } else {
            systemToast = new SystemToast(this.mApplication);
        }
        if (!areSupportCustomToastStyle(systemToast) && onlyShowSystemToastStyle()) {
            return systemToast;
        }
        diyToastStyle(systemToast, toastParams.style);
        return systemToast;
    }

    protected Activity getForegroundActivity() {
        return ActivityStack.getInstance().getForegroundActivity();
    }

    protected boolean onlyShowSystemToastStyle() {
        return isChangeEnabledCompat(147798919L);
    }
}
