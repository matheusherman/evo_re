package com.pengrad.telegrambot.model.request;

import kotlin.Metadata;
import w8.a;
import w8.b;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/pengrad/telegrambot/model/request/ChatAction;", "", "(Ljava/lang/String;I)V", "typing", "upload_photo", "record_video", "upload_video", "record_voice", "upload_voice", "upload_document", "choose_sticker", "find_location", "record_video_note", "upload_video_note", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum ChatAction {
    typing,
    upload_photo,
    record_video,
    upload_video,
    record_voice,
    upload_voice,
    upload_document,
    choose_sticker,
    find_location,
    record_video_note,
    upload_video_note;

    private static final /* synthetic */ a $ENTRIES = b.a(values());

    public static a<ChatAction> getEntries() {
        return $ENTRIES;
    }
}
