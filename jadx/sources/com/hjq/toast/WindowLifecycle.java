package com.hjq.toast;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class WindowLifecycle implements Application.ActivityLifecycleCallbacks {
    private Activity mActivity;
    private Application mApplication;
    private ToastImpl mToastImpl;

    WindowLifecycle(Activity activity) {
        this.mActivity = activity;
    }

    void unregister() {
        this.mToastImpl = null;
        Activity activity = this.mActivity;
        if (activity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            activity.unregisterActivityLifecycleCallbacks(this);
        } else {
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    public WindowManager getWindowManager() {
        Activity activity = this.mActivity;
        if (activity != null) {
            if (activity.isDestroyed()) {
                return null;
            }
            return this.mActivity.getWindowManager();
        }
        Application application = this.mApplication;
        if (application != null) {
            return (WindowManager) application.getSystemService("window");
        }
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (this.mActivity != activity) {
            return;
        }
        ToastImpl toastImpl = this.mToastImpl;
        if (toastImpl != null) {
            toastImpl.cancel();
        }
        unregister();
        this.mActivity = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        ToastImpl toastImpl;
        if (this.mActivity == activity && (toastImpl = this.mToastImpl) != null) {
            toastImpl.cancel();
        }
    }

    void register(ToastImpl toastImpl) {
        this.mToastImpl = toastImpl;
        Activity activity = this.mActivity;
        if (activity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            activity.registerActivityLifecycleCallbacks(this);
        } else {
            activity.getApplication().registerActivityLifecycleCallbacks(this);
        }
    }

    WindowLifecycle(Application application) {
        this.mApplication = application;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
