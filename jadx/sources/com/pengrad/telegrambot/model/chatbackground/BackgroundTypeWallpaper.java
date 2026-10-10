package com.pengrad.telegrambot.model.chatbackground;

import com.pengrad.telegrambot.model.Document;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class BackgroundTypeWallpaper extends BackgroundType {
    public static final String TYPE = "wallpaper";
    private Integer dark_theme_dimming;
    private Document document;
    private Boolean is_blurred;
    private Boolean is_moving;

    @Override // com.pengrad.telegrambot.model.chatbackground.BackgroundType
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        BackgroundTypeWallpaper backgroundTypeWallpaper = (BackgroundTypeWallpaper) obj;
        return Objects.equals(this.document, backgroundTypeWallpaper.document) && Objects.equals(this.dark_theme_dimming, backgroundTypeWallpaper.dark_theme_dimming) && Objects.equals(this.is_blurred, backgroundTypeWallpaper.is_blurred) && Objects.equals(this.is_moving, backgroundTypeWallpaper.is_moving);
    }

    public Boolean isBlurred() {
        return this.is_blurred;
    }

    public Boolean isMoving() {
        return this.is_moving;
    }

    public BackgroundTypeWallpaper(Document document, Integer num) {
        super(TYPE);
        this.document = document;
        this.dark_theme_dimming = num;
    }

    public Integer darkThemeDimming() {
        return this.dark_theme_dimming;
    }

    public Document document() {
        return this.document;
    }

    public BackgroundTypeWallpaper isBlurred(Boolean bool) {
        this.is_blurred = bool;
        return this;
    }

    public BackgroundTypeWallpaper isMoving(Boolean bool) {
        this.is_moving = bool;
        return this;
    }

    @Override // com.pengrad.telegrambot.model.chatbackground.BackgroundType
    public String toString() {
        return "BackgroundTypeWallpaper{type='" + type() + "', document='" + this.document + "', dark_theme_dimming=" + this.dark_theme_dimming + ", is_blurred=" + this.is_blurred + ", is_moving=" + this.is_moving + '}';
    }

    @Override // com.pengrad.telegrambot.model.chatbackground.BackgroundType
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.document, this.dark_theme_dimming, this.is_blurred, this.is_moving);
    }
}
