package com.pengrad.telegrambot.model;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InlineQuery implements Serializable {
    private static final long serialVersionUID = 0;
    private String chat_type;
    private User from;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f8234id;
    private Location location;
    private String offset;
    private String query;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            InlineQuery inlineQuery = (InlineQuery) obj;
            String str = this.f8234id;
            if (str == null ? inlineQuery.f8234id != null : !str.equals(inlineQuery.f8234id)) {
                return false;
            }
            User user = this.from;
            if (user == null ? inlineQuery.from != null : !user.equals(inlineQuery.from)) {
                return false;
            }
            Location location = this.location;
            if (location == null ? inlineQuery.location != null : !location.equals(inlineQuery.location)) {
                return false;
            }
            String str2 = this.query;
            if (str2 == null ? inlineQuery.query != null : !str2.equals(inlineQuery.query)) {
                return false;
            }
            String str3 = this.chat_type;
            if (str3 == null ? inlineQuery.chat_type != null : !str3.equals(inlineQuery.chat_type)) {
                return false;
            }
            String str4 = this.offset;
            String str5 = inlineQuery.offset;
            if (str4 != null) {
                return str4.equals(str5);
            }
            if (str5 == null) {
                return true;
            }
        }
        return false;
    }

    public String chatType() {
        return this.chat_type;
    }

    public User from() {
        return this.from;
    }

    public int hashCode() {
        String str = this.f8234id;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String id() {
        return this.f8234id;
    }

    public Location location() {
        return this.location;
    }

    public String offset() {
        return this.offset;
    }

    public String query() {
        return this.query;
    }

    public String toString() {
        return "InlineQuery{id='" + this.f8234id + "', from=" + this.from + ", location=" + this.location + ", query='" + this.query + "', offset='" + this.offset + "', chat_type='" + this.chat_type + "'}";
    }
}
