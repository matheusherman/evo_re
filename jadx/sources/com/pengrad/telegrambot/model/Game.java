package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class Game implements Serializable {
    private static final long serialVersionUID = 0;
    private Animation animation;
    private String description;
    private PhotoSize[] photo;
    private String text;
    private MessageEntity[] text_entities;
    private String title;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Game game = (Game) obj;
            String str = this.title;
            if (str == null ? game.title != null : !str.equals(game.title)) {
                return false;
            }
            String str2 = this.description;
            if (str2 == null ? game.description != null : !str2.equals(game.description)) {
                return false;
            }
            if (!Arrays.equals(this.photo, game.photo)) {
                return false;
            }
            String str3 = this.text;
            if (str3 == null ? game.text != null : !str3.equals(game.text)) {
                return false;
            }
            if (!Arrays.equals(this.text_entities, game.text_entities)) {
                return false;
            }
            Animation animation = this.animation;
            Animation animation2 = game.animation;
            if (animation != null) {
                return animation.equals(animation2);
            }
            if (animation2 == null) {
                return true;
            }
        }
        return false;
    }

    public Animation animation() {
        return this.animation;
    }

    public String description() {
        return this.description;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.description;
        int iHashCode2 = (((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.photo)) * 31;
        String str3 = this.text;
        int iHashCode3 = (((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Arrays.hashCode(this.text_entities)) * 31;
        Animation animation = this.animation;
        return iHashCode3 + (animation != null ? animation.hashCode() : 0);
    }

    public PhotoSize[] photo() {
        return this.photo;
    }

    public String text() {
        return this.text;
    }

    public MessageEntity[] textEntities() {
        return this.text_entities;
    }

    public String title() {
        return this.title;
    }

    public String toString() {
        return "Game{title='" + this.title + "', description='" + this.description + "', photo=" + Arrays.toString(this.photo) + ", text='" + this.text + "', text_entities=" + Arrays.toString(this.text_entities) + ", animation=" + this.animation + '}';
    }
}
