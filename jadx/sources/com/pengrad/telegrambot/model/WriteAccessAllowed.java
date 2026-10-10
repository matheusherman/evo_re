package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class WriteAccessAllowed implements Serializable {
    private static final long serialVersionUID = 0;
    private Boolean from_attachment_menu;
    private Boolean from_request;
    private String web_app_name;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            WriteAccessAllowed writeAccessAllowed = (WriteAccessAllowed) obj;
            if (Objects.equals(this.from_request, writeAccessAllowed.from_request) && Objects.equals(this.web_app_name, writeAccessAllowed.web_app_name) && Objects.equals(this.from_attachment_menu, writeAccessAllowed.from_attachment_menu)) {
                return true;
            }
        }
        return false;
    }

    public Boolean fromAttachmentMenu() {
        Boolean bool = this.from_attachment_menu;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean fromRequest() {
        Boolean bool = this.from_request;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public int hashCode() {
        return Objects.hash(this.from_request, this.web_app_name, this.from_attachment_menu);
    }

    public String toString() {
        return "WriteAccessAllowed{from_request=" + this.from_request + ", web_app_name='" + this.web_app_name + "', from_attachment_menu=" + this.from_attachment_menu + '}';
    }

    public String webAppName() {
        return this.web_app_name;
    }
}
