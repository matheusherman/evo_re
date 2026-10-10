package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.model.MessageEntity;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InputPollOption implements Serializable {
    private static final long serialVersionUID = 0;
    private String text;
    private MessageEntity[] text_entities;
    private String text_parse_mode;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InputPollOption)) {
            return false;
        }
        InputPollOption inputPollOption = (InputPollOption) obj;
        return Objects.equals(this.text, inputPollOption.text) && Objects.equals(this.text_parse_mode, inputPollOption.text_parse_mode) && Arrays.equals(this.text_entities, inputPollOption.text_entities);
    }

    public int hashCode() {
        return Objects.hash(this.text, this.text_parse_mode, this.text_entities);
    }

    public InputPollOption textEntities(MessageEntity... messageEntityArr) {
        this.text_entities = messageEntityArr;
        return this;
    }

    public InputPollOption textParseMode(String str) {
        this.text_parse_mode = str;
        return this;
    }

    public String toString() {
        return "InputPollOption{text='" + this.text + "', text_parse_mode='" + this.text_parse_mode + "', text_entities=" + Arrays.toString(this.text_entities) + '}';
    }

    public InputPollOption(String str) {
        this.text = str;
    }
}
