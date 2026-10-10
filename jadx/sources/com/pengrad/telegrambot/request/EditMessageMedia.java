package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.InputMedia;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.SendResponse;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class EditMessageMedia extends BaseRequest<EditMessageMedia, BaseResponse> {
    private boolean isMultipart;
    private InputMedia<?> media;

    public EditMessageMedia(Object obj, int i10, InputMedia<?> inputMedia) {
        super(SendResponse.class);
        add("chat_id", obj).add("message_id", Integer.valueOf(i10));
        addMedia(inputMedia);
    }

    private void addMedia(InputMedia<?> inputMedia) {
        this.media = inputMedia;
        add("media", inputMedia);
        Map<String, Object> attachments = inputMedia.getAttachments();
        if (attachments != null && attachments.size() > 0) {
            addAll(attachments);
            this.isMultipart = true;
        }
        if (inputMedia.inputFile() != null) {
            add(inputMedia.getInputFileId(), inputMedia.inputFile());
            this.isMultipart = true;
        }
    }

    public EditMessageMedia businessConnectionId(String str) {
        return add("business_connection_id", str);
    }

    @Override // com.pengrad.telegrambot.request.BaseRequest
    public String getContentType() {
        return this.media.getContentType();
    }

    @Override // com.pengrad.telegrambot.request.BaseRequest
    public String getFileName() {
        return this.media.getFileName();
    }

    @Override // com.pengrad.telegrambot.request.BaseRequest
    public boolean isMultipart() {
        return this.isMultipart;
    }

    public EditMessageMedia replyMarkup(InlineKeyboardMarkup inlineKeyboardMarkup) {
        return add("reply_markup", inlineKeyboardMarkup);
    }

    public EditMessageMedia(String str, InputMedia<?> inputMedia) {
        super(BaseResponse.class);
        add("inline_message_id", str);
        addMedia(inputMedia);
    }
}
