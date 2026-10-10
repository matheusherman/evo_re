package com.hjq.toast;

import android.app.Activity;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class ActivityToast extends CustomToast {
    private final ToastImpl mToastImpl;

    @Override // com.hjq.toast.config.IToast
    public void cancel() {
        this.mToastImpl.cancel();
    }

    @Override // com.hjq.toast.config.IToast
    public void show() {
        this.mToastImpl.show();
    }

    public ActivityToast(Activity activity) {
        this.mToastImpl = new ToastImpl(activity, (CustomToast) this);
    }
}
