package com.pengrad.telegrambot.model.business;

import com.pengrad.telegrambot.model.Sticker;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class BusinessIntro {
    private String message;
    private Sticker sticker;
    private String title;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BusinessIntro businessIntro = (BusinessIntro) obj;
            if (Objects.equals(this.title, businessIntro.title) && Objects.equals(this.message, businessIntro.message) && Objects.equals(this.sticker, businessIntro.sticker)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.title, this.message, this.sticker);
    }

    public String message() {
        return this.message;
    }

    public Sticker sticker() {
        return this.sticker;
    }

    public String title() {
        return this.title;
    }

    public String toString() {
        return "BusinessIntro{title='" + this.title + "', message='" + this.message + "', sticker=" + this.sticker + '}';
    }
}
