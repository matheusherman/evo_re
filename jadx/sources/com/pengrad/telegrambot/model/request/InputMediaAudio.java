package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.request.ContentTypes;
import java.io.File;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InputMediaAudio extends InputMedia<InputMediaAudio> implements Serializable {
    private static final long serialVersionUID = 0;
    private Integer duration;
    private String performer;
    private String title;

    public InputMediaAudio(String str) {
        super("audio", str);
    }

    public InputMediaAudio(File file) {
        super("audio", file);
    }

    public InputMediaAudio duration(Integer num) {
        this.duration = num;
        return this;
    }

    @Override // com.pengrad.telegrambot.model.request.InputMedia
    public String getDefaultContentType() {
        return ContentTypes.AUDIO_MIME_TYPE;
    }

    @Override // com.pengrad.telegrambot.model.request.InputMedia
    public String getDefaultFileName() {
        return ContentTypes.AUDIO_FILE_NAME;
    }

    public InputMediaAudio performer(String str) {
        this.performer = str;
        return this;
    }

    public InputMediaAudio title(String str) {
        this.title = str;
        return this;
    }

    public InputMediaAudio(byte[] bArr) {
        super("audio", bArr);
    }
}
