package com.pengrad.telegrambot.model.chatbackground;

import com.pengrad.telegrambot.model.Document;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class BackgroundTypePattern extends BackgroundType {
    public static final String TYPE = "pattern";
    private Document document;
    private BackgroundFill fill;
    private Integer intensity;
    private Boolean is_inverted;
    private Boolean is_moving;

    @Override // com.pengrad.telegrambot.model.chatbackground.BackgroundType
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        BackgroundTypePattern backgroundTypePattern = (BackgroundTypePattern) obj;
        return Objects.equals(this.document, backgroundTypePattern.document) && Objects.equals(this.fill, backgroundTypePattern.fill) && Objects.equals(this.intensity, backgroundTypePattern.intensity) && Objects.equals(this.is_inverted, backgroundTypePattern.is_inverted) && Objects.equals(this.is_moving, backgroundTypePattern.is_moving);
    }

    public Boolean isInverted() {
        return this.is_inverted;
    }

    public Boolean isMoving() {
        return this.is_moving;
    }

    public BackgroundTypePattern(Document document, BackgroundFill backgroundFill, Integer num) {
        super(TYPE);
        this.document = document;
        this.fill = backgroundFill;
        this.intensity = num;
    }

    public Document document() {
        return this.document;
    }

    public BackgroundFill fill() {
        return this.fill;
    }

    public Integer intensity() {
        return this.intensity;
    }

    public BackgroundTypePattern isInverted(Boolean bool) {
        this.is_inverted = bool;
        return this;
    }

    public BackgroundTypePattern isMoving(Boolean bool) {
        this.is_moving = bool;
        return this;
    }

    @Override // com.pengrad.telegrambot.model.chatbackground.BackgroundType
    public String toString() {
        return "BackgroundTypePattern{document=" + this.document + ", fill=" + this.fill + ", intensity=" + this.intensity + ", is_inverted=" + this.is_inverted + ", is_moving=" + this.is_moving + '}';
    }

    @Override // com.pengrad.telegrambot.model.chatbackground.BackgroundType
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.document, this.fill, this.intensity, this.is_inverted, this.is_moving);
    }
}
