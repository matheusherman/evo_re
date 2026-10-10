package com.pengrad.telegrambot.model;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class Document implements Serializable {
    private static final long serialVersionUID = 0;
    private String file_id;
    private String file_name;
    private Long file_size;
    private String file_unique_id;
    private String mime_type;
    private PhotoSize thumbnail;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Document document = (Document) obj;
            String str = this.file_id;
            if (str == null ? document.file_id != null : !str.equals(document.file_id)) {
                return false;
            }
            String str2 = this.file_unique_id;
            if (str2 == null ? document.file_unique_id != null : !str2.equals(document.file_unique_id)) {
                return false;
            }
            PhotoSize photoSize = this.thumbnail;
            if (photoSize == null ? document.thumbnail != null : !photoSize.equals(document.thumbnail)) {
                return false;
            }
            String str3 = this.file_name;
            if (str3 == null ? document.file_name != null : !str3.equals(document.file_name)) {
                return false;
            }
            String str4 = this.mime_type;
            if (str4 == null ? document.mime_type != null : !str4.equals(document.mime_type)) {
                return false;
            }
            Long l10 = this.file_size;
            Long l11 = document.file_size;
            if (l10 != null) {
                return l10.equals(l11);
            }
            if (l11 == null) {
                return true;
            }
        }
        return false;
    }

    public String fileId() {
        return this.file_id;
    }

    public String fileName() {
        return this.file_name;
    }

    public Long fileSize() {
        return this.file_size;
    }

    public String fileUniqueId() {
        return this.file_unique_id;
    }

    public int hashCode() {
        String str = this.file_id;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String mimeType() {
        return this.mime_type;
    }

    public PhotoSize thumbnail() {
        return this.thumbnail;
    }

    public String toString() {
        return "Document{file_id='" + this.file_id + "', file_unique_id='" + this.file_unique_id + "', thumbnail=" + this.thumbnail + ", file_name='" + this.file_name + "', mime_type='" + this.mime_type + "', file_size=" + this.file_size + '}';
    }
}
