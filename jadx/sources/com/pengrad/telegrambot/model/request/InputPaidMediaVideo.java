package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.request.ContentTypes;
import java.io.File;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InputPaidMediaVideo extends InputPaidMedia implements Serializable {
    private static final long serialVersionUID = 1;
    private String cover;
    private Integer duration;
    private Integer height;
    private Integer start_timestamp;
    private Boolean supports_streaming;
    private String thumbnail;
    private Integer width;

    public InputPaidMediaVideo(String str) {
        super("video", str);
    }

    public InputPaidMediaVideo cover(File file) {
        this.cover = addAttachment(file);
        return this;
    }

    public InputPaidMediaVideo thumbnail(File file) {
        this.thumbnail = addAttachment(file);
        return this;
    }

    public InputPaidMediaVideo(File file) {
        super("video", file);
    }

    public InputPaidMediaVideo cover(byte[] bArr) {
        this.cover = addAttachment(bArr);
        return this;
    }

    public InputPaidMediaVideo duration(Integer num) {
        this.duration = num;
        return this;
    }

    @Override // com.pengrad.telegrambot.model.request.InputPaidMedia
    public String getDefaultContentType() {
        return "video/mp4";
    }

    @Override // com.pengrad.telegrambot.model.request.InputPaidMedia
    public String getDefaultFileName() {
        return ContentTypes.VIDEO_FILE_NAME;
    }

    public InputPaidMediaVideo height(Integer num) {
        this.height = num;
        return this;
    }

    public InputPaidMediaVideo startTimestamp(Integer num) {
        this.start_timestamp = num;
        return this;
    }

    public InputPaidMediaVideo thumbnail(byte[] bArr) {
        this.thumbnail = addAttachment(bArr);
        return this;
    }

    public InputPaidMediaVideo width(Integer num) {
        this.width = num;
        return this;
    }

    public InputPaidMediaVideo(byte[] bArr) {
        super("video", bArr);
    }

    public InputPaidMediaVideo supportsStreaming(boolean z10) {
        this.supports_streaming = Boolean.valueOf(z10);
        return this;
    }
}
