package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class WebAppData implements Serializable {
    private static final long serialVersionUID = 0;
    private String button_text;
    private String data;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            WebAppData webAppData = (WebAppData) obj;
            if (Objects.equals(this.data, webAppData.data) && Objects.equals(this.button_text, webAppData.button_text)) {
                return true;
            }
        }
        return false;
    }

    public String buttonText() {
        return this.button_text;
    }

    public String data() {
        return this.data;
    }

    public int hashCode() {
        return Objects.hash(this.data, this.button_text);
    }

    public String toString() {
        return "WebAppData{data=" + this.data + ", button_text=" + this.button_text + '}';
    }
}
