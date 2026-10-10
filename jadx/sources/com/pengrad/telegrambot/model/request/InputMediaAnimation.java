package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.request.ContentTypes;
import java.io.File;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InputMediaAnimation extends InputMedia<InputMediaAnimation> implements Serializable {
    private static final long serialVersionUID = 0;
    private Integer duration;
    private Boolean has_spoiler;
    private Integer height;
    private Integer width;

    public InputMediaAnimation(String str) {
        super("animation", str);
    }

    public InputMediaAnimation(File file) {
        super("animation", file);
    }

    public InputMediaAnimation duration(Integer num) {
        this.duration = num;
        return this;
    }

    @Override // com.pengrad.telegrambot.model.request.InputMedia
    public String getDefaultContentType() {
        return ContentTypes.GIF_MIME_TYPE;
    }

    @Override // com.pengrad.telegrambot.model.request.InputMedia
    public String getDefaultFileName() {
        return ContentTypes.GIF_FILE_NAME;
    }

    public InputMediaAnimation height(Integer num) {
        this.height = num;
        return this;
    }

    public InputMediaAnimation width(Integer num) {
        this.width = num;
        return this;
    }

    public InputMediaAnimation(byte[] bArr) {
        super("animation", bArr);
    }

    public InputMediaAnimation hasSpoiler(boolean z10) {
        this.has_spoiler = Boolean.valueOf(z10);
        return this;
    }
}
