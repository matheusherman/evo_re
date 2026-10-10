package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.model.MessageEntity;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ReplyParameters implements Serializable {
    private static final long serialVersionUID = 0;
    private Boolean allow_sending_without_reply;
    private Object chat_id;
    private Integer checklist_task_id;
    private Integer message_id;
    private String quote;
    private MessageEntity[] quote_entities;
    private String quote_parse_mode;
    private Integer quote_position;

    public ReplyParameters(Integer num) {
        this.message_id = num;
    }

    public ReplyParameters allowSendingWithoutReply(Boolean bool) {
        this.allow_sending_without_reply = bool;
        return this;
    }

    public ReplyParameters checklistTaskId(Integer num) {
        this.checklist_task_id = num;
        return this;
    }

    public ReplyParameters quote(String str) {
        this.quote = str;
        return this;
    }

    public ReplyParameters quoteEntities(MessageEntity[] messageEntityArr) {
        this.quote_entities = messageEntityArr;
        return this;
    }

    public ReplyParameters quotePosition(Integer num) {
        this.quote_position = num;
        return this;
    }

    public ReplyParameters(Integer num, Object obj) {
        this.message_id = num;
        this.chat_id = obj;
    }

    public ReplyParameters quoteParseMode(ParseMode parseMode) {
        this.quote_parse_mode = parseMode.name();
        return this;
    }
}
