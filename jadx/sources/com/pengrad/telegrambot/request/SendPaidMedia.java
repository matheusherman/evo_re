package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.request.ForceReply;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.InputPaidMedia;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.model.request.ReplyKeyboardRemove;
import com.pengrad.telegrambot.model.request.ReplyParameters;
import com.pengrad.telegrambot.response.SendResponse;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class SendPaidMedia extends BaseRequest<SendPaidMedia, SendResponse> {
    private boolean isMultipart;

    public SendPaidMedia replyMarkup(InlineKeyboardMarkup inlineKeyboardMarkup) {
        return add("reply_markup", inlineKeyboardMarkup);
    }

    public SendPaidMedia(Object obj, Integer num, InputPaidMedia... inputPaidMediaArr) {
        super(SendResponse.class);
        this.isMultipart = false;
        add("chat_id", obj).add("star_count", num).add("media", inputPaidMediaArr);
        for (InputPaidMedia inputPaidMedia : inputPaidMediaArr) {
            Map<String, Object> attachments = inputPaidMedia.getAttachments();
            if (attachments != null && !attachments.isEmpty()) {
                addAll(attachments);
                this.isMultipart = true;
            }
            if (inputPaidMedia.inputFile() != null) {
                add(inputPaidMedia.getInputFileId(), inputPaidMedia.inputFile());
                this.isMultipart = true;
            }
        }
    }

    public SendPaidMedia allowPaidBroadcast(boolean z10) {
        return add("allow_paid_broadcast", Boolean.valueOf(z10));
    }

    public SendPaidMedia businessConnectionId(String str) {
        return add("business_connection_id", str);
    }

    public SendPaidMedia caption(String str) {
        return add("caption", str);
    }

    public SendPaidMedia captionEntities(MessageEntity... messageEntityArr) {
        return add("caption_entities", messageEntityArr);
    }

    public SendPaidMedia disableNotification(boolean z10) {
        return add("disable_notification", Boolean.valueOf(z10));
    }

    @Override // com.pengrad.telegrambot.request.BaseRequest
    public boolean isMultipart() {
        return this.isMultipart;
    }

    public SendPaidMedia parseMode(ParseMode parseMode) {
        return add("parse_mode", parseMode.name());
    }

    public SendPaidMedia payload(String str) {
        return add("payload", str);
    }

    public SendPaidMedia protectContent(boolean z10) {
        return add("protect_content", Boolean.valueOf(z10));
    }

    public SendPaidMedia replyMarkup(ReplyKeyboardMarkup replyKeyboardMarkup) {
        return add("reply_markup", replyKeyboardMarkup);
    }

    public SendPaidMedia replyParameters(ReplyParameters replyParameters) {
        return add("reply_parameters", replyParameters);
    }

    public SendPaidMedia showCaptionAboveMedia(boolean z10) {
        return add("show_caption_above_media", Boolean.valueOf(z10));
    }

    public SendPaidMedia replyMarkup(ReplyKeyboardRemove replyKeyboardRemove) {
        return add("reply_markup", replyKeyboardRemove);
    }

    public SendPaidMedia replyMarkup(ForceReply forceReply) {
        return add("reply_markup", forceReply);
    }
}
