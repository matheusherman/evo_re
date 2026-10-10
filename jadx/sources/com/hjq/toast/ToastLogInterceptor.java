package com.hjq.toast;

import android.util.Log;
import com.hjq.toast.config.IToastInterceptor;
import java.lang.reflect.Modifier;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class ToastLogInterceptor implements IToastInterceptor {
    protected boolean filterClass(Class<?> cls) {
        return IToastInterceptor.class.isAssignableFrom(cls) || Toaster.class.equals(cls) || cls.isInterface() || Modifier.isAbstract(cls.getModifiers());
    }

    @Override // com.hjq.toast.config.IToastInterceptor
    public boolean intercept(ToastParams toastParams) {
        printToast(toastParams.text);
        return false;
    }

    protected void printLog(String str) {
        Log.i("Toaster", str);
    }

    protected boolean isLogEnable() {
        return Toaster.isDebugMode();
    }

    protected void printToast(CharSequence charSequence) {
        if (isLogEnable()) {
            for (StackTraceElement stackTraceElement : new Throwable().getStackTrace()) {
                int lineNumber = stackTraceElement.getLineNumber();
                if (lineNumber > 0) {
                    try {
                        if (!filterClass(Class.forName(stackTraceElement.getClassName()))) {
                            printLog("(" + stackTraceElement.getFileName() + ":" + lineNumber + ") " + charSequence.toString());
                            return;
                        }
                        continue;
                    } catch (ClassNotFoundException e10) {
                        e10.printStackTrace();
                    }
                }
            }
        }
    }
}
