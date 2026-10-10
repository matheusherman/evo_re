package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.request.ContentTypes;
import java.io.File;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InputMediaVideo extends InputMedia<InputMediaVideo> implements Serializable {
    private static final long serialVersionUID = 1;
    private String cover;
    private Integer duration;
    private Boolean has_spoiler;
    private Integer height;
    private Integer start_timestamp;
    private Boolean supports_streaming;
    private Integer width;

    public InputMediaVideo(String str) {
        super("video", str);
    }

    public InputMediaVideo cover(File file) {
        this.cover = addAttachment(file);
        return this;
    }

    public InputMediaVideo(File file) {
        super("video", file);
    }

    public InputMediaVideo cover(byte[] bArr) {
        this.cover = addAttachment(bArr);
        return this;
    }

    public InputMediaVideo duration(Integer num) {
        this.duration = num;
        return this;
    }

    @Override // com.pengrad.telegrambot.model.request.InputMedia
    public String getDefaultContentType() {
        return "video/mp4";
    }

    @Override // com.pengrad.telegrambot.model.request.InputMedia
    public String getDefaultFileName() {
        return ContentTypes.VIDEO_FILE_NAME;
    }

    public InputMediaVideo height(Integer num) {
        this.height = num;
        return this;
    }

    public InputMediaVideo startTimestamp(Integer num) {
        this.start_timestamp = num;
        return this;
    }

    public InputMediaVideo width(Integer num) {
        this.width = num;
        return this;
    }

    public InputMediaVideo(byte[] bArr) {
        super("video", bArr);
    }

    public InputMediaVideo hasSpoiler(boolean z10) {
        this.has_spoiler = Boolean.valueOf(z10);
        return this;
    }

    public InputMediaVideo supportsStreaming(boolean z10) {
        this.supports_streaming = Boolean.valueOf(z10);
        return this;
    }
}
