package com.pengrad.telegrambot.model.chatbackground;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class BackgroundTypeFill extends BackgroundType {
    public static final String TYPE = "fill";
    private Integer dark_theme_dimming;
    private BackgroundFill fill;

    @Override // com.pengrad.telegrambot.model.chatbackground.BackgroundType
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        BackgroundTypeFill backgroundTypeFill = (BackgroundTypeFill) obj;
        return Objects.equals(this.fill, backgroundTypeFill.fill) && Objects.equals(this.dark_theme_dimming, backgroundTypeFill.dark_theme_dimming);
    }

    public BackgroundTypeFill(BackgroundFill backgroundFill, Integer num) {
        super(TYPE);
        this.fill = backgroundFill;
        this.dark_theme_dimming = num;
    }

    public Integer darkThemeDimming() {
        return this.dark_theme_dimming;
    }

    public BackgroundFill fill() {
        return this.fill;
    }

    @Override // com.pengrad.telegrambot.model.chatbackground.BackgroundType
    public String toString() {
        return "BackgroundTypeFill{type='" + type() + "', fill='" + this.fill + "', dark_theme_dimming=" + this.dark_theme_dimming + '}';
    }

    @Override // com.pengrad.telegrambot.model.chatbackground.BackgroundType
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.fill, this.dark_theme_dimming);
    }
}
