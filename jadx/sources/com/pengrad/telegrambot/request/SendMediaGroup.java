package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.request.InputMedia;
import com.pengrad.telegrambot.model.request.ReplyParameters;
import com.pengrad.telegrambot.response.MessagesResponse;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class SendMediaGroup extends BaseRequest<SendMediaGroup, MessagesResponse> {
    private boolean isMultipart;

    public SendMediaGroup(Object obj, InputMedia<?>... inputMediaArr) {
        super(MessagesResponse.class);
        this.isMultipart = false;
        add("chat_id", obj).add("media", inputMediaArr);
        for (InputMedia<?> inputMedia : inputMediaArr) {
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
    }

    public SendMediaGroup businessConnectionId(String str) {
        return add("business_connection_id", str);
    }

    public SendMediaGroup disableNotification(boolean z10) {
        return add("disable_notification", Boolean.valueOf(z10));
    }

    @Override // com.pengrad.telegrambot.request.BaseRequest
    public boolean isMultipart() {
        return this.isMultipart;
    }

    public SendMediaGroup messageThreadId(Integer num) {
        return add("message_thread_id", num);
    }

    public SendMediaGroup protectContent(boolean z10) {
        return add("protect_content", Boolean.valueOf(z10));
    }

    public SendMediaGroup replyParameters(ReplyParameters replyParameters) {
        return add("reply_parameters", replyParameters);
    }
}
