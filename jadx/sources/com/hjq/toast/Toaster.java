package com.hjq.toast;

import android.app.Application;
import android.content.res.Resources;
import com.hjq.toast.config.IToastInterceptor;
import com.hjq.toast.config.IToastStrategy;
import com.hjq.toast.config.IToastStyle;
import com.hjq.toast.style.BlackToastStyle;
import com.hjq.toast.style.CustomToastStyle;
import com.hjq.toast.style.LocationToastStyle;
import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class Toaster {
    private static Application sApplication;
    private static Boolean sDebugMode;
    private static IToastInterceptor sToastInterceptor;
    private static IToastStrategy sToastStrategy;
    private static IToastStyle<?> sToastStyle;

    public static void debugShow(int i10) {
        debugShow(stringIdToCharSequence(i10));
    }

    public static void delayedShow(int i10, long j10) {
        delayedShow(stringIdToCharSequence(i10), j10);
    }

    public static void init(Application application) {
        init(application, sToastStyle);
    }

    public static void setGravity(int i10) {
        setGravity(i10, 0, 0);
    }

    public static void show(int i10) {
        show(stringIdToCharSequence(i10));
    }

    public static void showLong(int i10) {
        showLong(stringIdToCharSequence(i10));
    }

    public static void showShort(int i10) {
        showShort(stringIdToCharSequence(i10));
    }

    public static void cancel() {
        sToastStrategy.cancelToast();
    }

    private static void checkInitStatus() {
        if (sApplication == null) {
            throw new IllegalStateException("Toaster has not been initialized");
        }
    }

    public static void debugShow(Object obj) {
        debugShow(objectToCharSequence(obj));
    }

    public static void delayedShow(Object obj, long j10) {
        delayedShow(objectToCharSequence(obj), j10);
    }

    public static IToastInterceptor getInterceptor() {
        return sToastInterceptor;
    }

    public static IToastStrategy getStrategy() {
        return sToastStrategy;
    }

    public static IToastStyle<?> getStyle() {
        return sToastStyle;
    }

    public static void init(Application application, IToastStrategy iToastStrategy) {
        init(application, iToastStrategy, null);
    }

    static boolean isDebugMode() {
        if (sDebugMode == null) {
            checkInitStatus();
            sDebugMode = Boolean.valueOf((sApplication.getApplicationInfo().flags & 2) != 0);
        }
        return sDebugMode.booleanValue();
    }

    public static boolean isInit() {
        return (sApplication == null || sToastStrategy == null || sToastStyle == null) ? false : true;
    }

    private static CharSequence objectToCharSequence(Object obj) {
        return obj != null ? obj.toString() : Configurator.NULL;
    }

    public static void setGravity(int i10, int i11, int i12) {
        setGravity(i10, i11, i12, 0.0f, 0.0f);
    }

    public static void setInterceptor(IToastInterceptor iToastInterceptor) {
        sToastInterceptor = iToastInterceptor;
    }

    public static void setStrategy(IToastStrategy iToastStrategy) {
        if (iToastStrategy == null) {
            return;
        }
        sToastStrategy = iToastStrategy;
        iToastStrategy.registerStrategy(sApplication);
    }

    public static void setStyle(IToastStyle<?> iToastStyle) {
        if (iToastStyle == null) {
            return;
        }
        sToastStyle = iToastStyle;
    }

    public static void setView(int i10) {
        IToastStyle<?> iToastStyle;
        if (i10 > 0 && (iToastStyle = sToastStyle) != null) {
            setStyle(new CustomToastStyle(i10, iToastStyle.getGravity(), sToastStyle.getXOffset(), sToastStyle.getYOffset(), sToastStyle.getHorizontalMargin(), sToastStyle.getVerticalMargin()));
        }
    }

    public static void show(Object obj) {
        show(objectToCharSequence(obj));
    }

    public static void showLong(Object obj) {
        showLong(objectToCharSequence(obj));
    }

    public static void showShort(Object obj) {
        showShort(objectToCharSequence(obj));
    }

    private Toaster() {
    }

    public static void debugShow(CharSequence charSequence) {
        if (isDebugMode()) {
            ToastParams toastParams = new ToastParams();
            toastParams.text = charSequence;
            show(toastParams);
        }
    }

    public static void delayedShow(CharSequence charSequence, long j10) {
        ToastParams toastParams = new ToastParams();
        toastParams.text = charSequence;
        toastParams.delayMillis = j10;
        show(toastParams);
    }

    public static void init(Application application, IToastStyle<?> iToastStyle) {
        init(application, null, iToastStyle);
    }

    public static void setDebugMode(boolean z10) {
        sDebugMode = Boolean.valueOf(z10);
    }

    public static void setGravity(int i10, int i11, int i12, float f10, float f11) {
        sToastStyle = new LocationToastStyle(sToastStyle, i10, i11, i12, f10, f11);
    }

    public static void show(CharSequence charSequence) {
        ToastParams toastParams = new ToastParams();
        toastParams.text = charSequence;
        show(toastParams);
    }

    public static void showLong(CharSequence charSequence) {
        ToastParams toastParams = new ToastParams();
        toastParams.text = charSequence;
        toastParams.duration = 1;
        show(toastParams);
    }

    public static void showShort(CharSequence charSequence) {
        ToastParams toastParams = new ToastParams();
        toastParams.text = charSequence;
        toastParams.duration = 0;
        show(toastParams);
    }

    private static CharSequence stringIdToCharSequence(int i10) {
        checkInitStatus();
        try {
            return sApplication.getResources().getText(i10);
        } catch (Resources.NotFoundException unused) {
            return String.valueOf(i10);
        }
    }

    public static void init(Application application, IToastStrategy iToastStrategy, IToastStyle<?> iToastStyle) {
        if (isInit()) {
            return;
        }
        sApplication = application;
        ActivityStack.getInstance().register(application);
        if (iToastStrategy == null) {
            iToastStrategy = new ToastStrategy();
        }
        setStrategy(iToastStrategy);
        if (iToastStyle == null) {
            iToastStyle = new BlackToastStyle();
        }
        setStyle(iToastStyle);
    }

    public static void show(ToastParams toastParams) {
        checkInitStatus();
        CharSequence charSequence = toastParams.text;
        if (charSequence == null || charSequence.length() == 0) {
            return;
        }
        if (toastParams.strategy == null) {
            toastParams.strategy = sToastStrategy;
        }
        if (toastParams.interceptor == null) {
            if (sToastInterceptor == null) {
                sToastInterceptor = new ToastLogInterceptor();
            }
            toastParams.interceptor = sToastInterceptor;
        }
        if (toastParams.style == null) {
            toastParams.style = sToastStyle;
        }
        if (toastParams.interceptor.intercept(toastParams)) {
            return;
        }
        if (toastParams.duration == -1) {
            toastParams.duration = toastParams.strategy.computeShowDuration(toastParams.text);
        }
        toastParams.strategy.showToast(toastParams);
    }
}
