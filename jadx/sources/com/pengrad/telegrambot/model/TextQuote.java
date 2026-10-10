package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class TextQuote implements Serializable {
    private static final long serialVersionUID = 0;
    private MessageEntity[] entities;
    private Boolean is_manual;
    private Integer position;
    private String text;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            TextQuote textQuote = (TextQuote) obj;
            if (Objects.equals(this.text, textQuote.text) && Arrays.equals(this.entities, textQuote.entities) && Objects.equals(this.position, textQuote.position) && Objects.equals(this.is_manual, textQuote.is_manual)) {
                return true;
            }
        }
        return false;
    }

    public MessageEntity[] entities() {
        return this.entities;
    }

    public int hashCode() {
        return (Objects.hash(this.text, this.position, this.is_manual) * 31) + Arrays.hashCode(this.entities);
    }

    public Boolean isManual() {
        return this.is_manual;
    }

    public Integer position() {
        return this.position;
    }

    public String text() {
        return this.text;
    }

    public String toString() {
        return "TextQuote{text='" + this.text + "', entities=" + Arrays.toString(this.entities) + ", position=" + this.position + ", is_manual=" + this.is_manual + '}';
    }
}
