package com.pengrad.telegrambot.model;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ChatPhoto implements Serializable {
    private static final long serialVersionUID = 0;
    private String big_file_id;
    private String big_file_unique_id;
    private String small_file_id;
    private String small_file_unique_id;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ChatPhoto chatPhoto = (ChatPhoto) obj;
            String str = this.small_file_id;
            if (str == null ? chatPhoto.small_file_id != null : !str.equals(chatPhoto.small_file_id)) {
                return false;
            }
            String str2 = this.small_file_unique_id;
            if (str2 == null ? chatPhoto.small_file_unique_id != null : !str2.equals(chatPhoto.small_file_unique_id)) {
                return false;
            }
            String str3 = this.big_file_id;
            if (str3 == null ? chatPhoto.big_file_id != null : !str3.equals(chatPhoto.big_file_id)) {
                return false;
            }
            String str4 = this.big_file_unique_id;
            String str5 = chatPhoto.big_file_unique_id;
            if (str4 != null) {
                return str4.equals(str5);
            }
            if (str5 == null) {
                return true;
            }
        }
        return false;
    }

    public String bigFileId() {
        return this.big_file_id;
    }

    public String bigFileUniqueId() {
        return this.big_file_unique_id;
    }

    public int hashCode() {
        String str = this.small_file_id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.big_file_id;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String smallFileId() {
        return this.small_file_id;
    }

    public String smallFileUniqueId() {
        return this.small_file_unique_id;
    }

    public String toString() {
        return "ChatPhoto{small_file_id='" + this.small_file_id + "', small_file_unique_id='" + this.small_file_unique_id + "', big_file_id='" + this.big_file_id + "', big_file_unique_id='" + this.big_file_unique_id + "'}";
    }
}
