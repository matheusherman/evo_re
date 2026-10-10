package com.pengrad.telegrambot.model;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ChosenInlineResult implements Serializable {
    private static final long serialVersionUID = 0;
    private User from;
    private String inline_message_id;
    private Location location;
    private String query;
    private String result_id;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ChosenInlineResult chosenInlineResult = (ChosenInlineResult) obj;
            String str = this.result_id;
            if (str == null ? chosenInlineResult.result_id != null : !str.equals(chosenInlineResult.result_id)) {
                return false;
            }
            User user = this.from;
            if (user == null ? chosenInlineResult.from != null : !user.equals(chosenInlineResult.from)) {
                return false;
            }
            Location location = this.location;
            if (location == null ? chosenInlineResult.location != null : !location.equals(chosenInlineResult.location)) {
                return false;
            }
            String str2 = this.inline_message_id;
            if (str2 == null ? chosenInlineResult.inline_message_id != null : !str2.equals(chosenInlineResult.inline_message_id)) {
                return false;
            }
            String str3 = this.query;
            String str4 = chosenInlineResult.query;
            if (str3 != null) {
                return str3.equals(str4);
            }
            if (str4 == null) {
                return true;
            }
        }
        return false;
    }

    public User from() {
        return this.from;
    }

    public int hashCode() {
        String str = this.result_id;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String inlineMessageId() {
        return this.inline_message_id;
    }

    public Location location() {
        return this.location;
    }

    public String query() {
        return this.query;
    }

    public String resultId() {
        return this.result_id;
    }

    public String toString() {
        return "ChosenInlineResult{result_id='" + this.result_id + "', from=" + this.from + ", location=" + this.location + ", inline_message_id='" + this.inline_message_id + "', query='" + this.query + "'}";
    }
}
