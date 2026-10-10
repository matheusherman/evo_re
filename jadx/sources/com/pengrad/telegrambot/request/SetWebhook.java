package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.response.BaseResponse;
import java.io.File;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class SetWebhook extends BaseRequest<SetWebhook, BaseResponse> {
    private boolean isMultipart;

    public SetWebhook certificate(byte[] bArr) {
        this.isMultipart = true;
        return add("certificate", bArr);
    }

    public SetWebhook() {
        super(BaseResponse.class);
        this.isMultipart = false;
    }

    public SetWebhook allowedUpdates(String... strArr) {
        return add("allowed_updates", strArr);
    }

    public SetWebhook dropPendingUpdates(boolean z10) {
        return add("drop_pending_updates", Boolean.valueOf(z10));
    }

    public SetWebhook ipAddress(String str) {
        return add("ip_address", str);
    }

    @Override // com.pengrad.telegrambot.request.BaseRequest
    public boolean isMultipart() {
        return this.isMultipart;
    }

    public SetWebhook maxConnections(int i10) {
        return add("max_connections", Integer.valueOf(i10));
    }

    public SetWebhook secretToken(String str) {
        return add("secret_token", str);
    }

    public SetWebhook url(String str) {
        return add(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, str);
    }

    public SetWebhook certificate(File file) {
        this.isMultipart = true;
        return add("certificate", file);
    }
}
