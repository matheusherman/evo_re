package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class PollOption implements Serializable {
    private static final long serialVersionUID = 0;
    private String text;
    private MessageEntity[] text_entities;
    private Integer voter_count;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PollOption pollOption = (PollOption) obj;
            if (!Arrays.equals(this.text_entities, pollOption.text_entities)) {
                return false;
            }
            String str = this.text;
            if (str == null ? pollOption.text != null : !str.equals(pollOption.text)) {
                return false;
            }
            Integer num = this.voter_count;
            Integer num2 = pollOption.voter_count;
            if (num != null) {
                return num.equals(num2);
            }
            if (num2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.text;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.voter_count;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public String text() {
        return this.text;
    }

    public MessageEntity[] textEntities() {
        return this.text_entities;
    }

    public String toString() {
        return "PollOption{text='" + this.text + "', voter_count=" + this.voter_count + ", text_entities=" + Arrays.toString(this.text_entities) + '}';
    }

    public Integer voterCount() {
        return this.voter_count;
    }
}
