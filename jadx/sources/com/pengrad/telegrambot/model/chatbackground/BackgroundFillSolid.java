package com.pengrad.telegrambot.model.chatbackground;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class BackgroundFillSolid extends BackgroundFill {
    public static final String TYPE = "solid";
    private Integer color;

    public BackgroundFillSolid(Integer num) {
        super(TYPE);
        this.color = num;
    }

    public Integer color() {
        return this.color;
    }

    @Override // com.pengrad.telegrambot.model.chatbackground.BackgroundFill
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && super.equals(obj)) {
            return Objects.equals(this.color, ((BackgroundFillSolid) obj).color);
        }
        return false;
    }

    @Override // com.pengrad.telegrambot.model.chatbackground.BackgroundFill
    public String toString() {
        return "BackgroundFillSolid{type='" + type() + "', color=" + this.color + '}';
    }

    @Override // com.pengrad.telegrambot.model.chatbackground.BackgroundFill
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.color);
    }
}
