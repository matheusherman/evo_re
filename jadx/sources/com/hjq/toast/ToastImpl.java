package com.hjq.toast;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Toast;
import org.apache.log4j.net.SyslogAppender;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class ToastImpl {
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());
    private static final String WINDOW_TITLE = "Toast";
    private final Runnable mCancelRunnable;
    private boolean mGlobalShow;
    private final String mPackageName;
    private boolean mShow;
    private final Runnable mShowRunnable;
    private final CustomToast mToast;
    private WindowLifecycle mWindowLifecycle;

    /* JADX INFO: renamed from: com.hjq.toast.ToastImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        @SuppressLint({"WrongConstant"})
        public void run() {
            WindowManager windowManager = ToastImpl.this.mWindowLifecycle.getWindowManager();
            if (windowManager == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            layoutParams.format = -3;
            layoutParams.flags = SyslogAppender.LOG_LOCAL3;
            layoutParams.packageName = ToastImpl.this.mPackageName;
            layoutParams.gravity = ToastImpl.this.mToast.getGravity();
            layoutParams.x = ToastImpl.this.mToast.getXOffset();
            layoutParams.y = ToastImpl.this.mToast.getYOffset();
            layoutParams.verticalMargin = ToastImpl.this.mToast.getVerticalMargin();
            layoutParams.horizontalMargin = ToastImpl.this.mToast.getHorizontalMargin();
            layoutParams.windowAnimations = ToastImpl.this.mToast.getAnimationsId();
            layoutParams.setTitle(ToastImpl.WINDOW_TITLE);
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                layoutParams.setFitInsetsIgnoringVisibility(true);
            }
            if (ToastImpl.this.mGlobalShow) {
                if (i10 >= 26) {
                    layoutParams.type = 2038;
                    layoutParams.flags &= -17;
                } else {
                    layoutParams.type = 2003;
                }
            }
            try {
                windowManager.addView(ToastImpl.this.mToast.getView(), layoutParams);
                ToastImpl.HANDLER.postDelayed(new Runnable() { // from class: com.hjq.toast.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        ToastImpl.this.cancel();
                    }
                }, ToastImpl.this.mToast.getDuration() == 1 ? ToastImpl.this.mToast.getLongDuration() : ToastImpl.this.mToast.getShortDuration());
                ToastImpl.this.mWindowLifecycle.register(ToastImpl.this);
                ToastImpl.this.setShow(true);
                ToastImpl toastImpl = ToastImpl.this;
                toastImpl.sendAccessibilityEvent(toastImpl.mToast.getView());
            } catch (WindowManager.BadTokenException e10) {
                e = e10;
                e.printStackTrace();
            } catch (IllegalStateException e11) {
                e = e11;
                e.printStackTrace();
            }
        }
    }

    ToastImpl(Activity activity, CustomToast customToast) {
        this((Context) activity, customToast);
        this.mGlobalShow = false;
        this.mWindowLifecycle = new WindowLifecycle(activity);
    }

    boolean isShow() {
        return this.mShow;
    }

    void setShow(boolean z10) {
        this.mShow = z10;
    }

    private boolean isMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAccessibilityEvent(View view) {
        AccessibilityEvent accessibilityEventObtain;
        Context context = view.getContext();
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (!accessibilityManager.isEnabled()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            accessibilityEventObtain = a.a();
            accessibilityEventObtain.setEventType(64);
        } else {
            accessibilityEventObtain = AccessibilityEvent.obtain(64);
        }
        accessibilityEventObtain.setClassName(Toast.class.getName());
        accessibilityEventObtain.setPackageName(context.getPackageName());
        view.dispatchPopulateAccessibilityEvent(accessibilityEventObtain);
        accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cancel() {
        if (!isShow()) {
            return;
        }
        Handler handler = HANDLER;
        handler.removeCallbacks(this.mShowRunnable);
        if (isMainThread()) {
            this.mCancelRunnable.run();
        } else {
            handler.removeCallbacks(this.mCancelRunnable);
            handler.post(this.mCancelRunnable);
        }
    }

    void show() {
        if (isShow()) {
            return;
        }
        if (isMainThread()) {
            this.mShowRunnable.run();
            return;
        }
        Handler handler = HANDLER;
        handler.removeCallbacks(this.mShowRunnable);
        handler.post(this.mShowRunnable);
    }

    ToastImpl(Application application, CustomToast customToast) {
        this((Context) application, customToast);
        this.mGlobalShow = true;
        this.mWindowLifecycle = new WindowLifecycle(application);
    }

    private ToastImpl(Context context, CustomToast customToast) {
        this.mShowRunnable = new AnonymousClass1();
        this.mCancelRunnable = new Runnable() { // from class: com.hjq.toast.ToastImpl.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        WindowManager windowManager = ToastImpl.this.mWindowLifecycle.getWindowManager();
                        if (windowManager != null) {
                            windowManager.removeViewImmediate(ToastImpl.this.mToast.getView());
                        }
                    } catch (IllegalArgumentException e10) {
                        e10.printStackTrace();
                    }
                } finally {
                    ToastImpl.this.mWindowLifecycle.unregister();
                    ToastImpl.this.setShow(false);
                }
            }
        };
        this.mToast = customToast;
        this.mPackageName = context.getPackageName();
    }
}
