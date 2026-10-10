package com.hjq.toast.config;

import android.app.Application;
import com.hjq.toast.ToastParams;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public interface IToastStrategy {
    void cancelToast();

    int computeShowDuration(CharSequence charSequence);

    IToast createToast(ToastParams toastParams);

    void registerStrategy(Application application);

    void showToast(ToastParams toastParams);
}
