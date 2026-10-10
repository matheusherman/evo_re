package com.pengrad.telegrambot.model.chatbackground;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class BackgroundTypeChatTheme extends BackgroundType {
    public static final String TYPE = "chat_theme";
    private String theme_name;

    public BackgroundTypeChatTheme(String str) {
        super(TYPE);
        this.theme_name = str;
    }

    @Override // com.pengrad.telegrambot.model.chatbackground.BackgroundType
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && super.equals(obj)) {
            return Objects.equals(this.theme_name, ((BackgroundTypeChatTheme) obj).theme_name);
        }
        return false;
    }

    public String themeName() {
        return this.theme_name;
    }

    @Override // com.pengrad.telegrambot.model.chatbackground.BackgroundType
    public String toString() {
        return "BackgroundTypeChatTheme{type='" + type() + "', theme_name=" + this.theme_name + '}';
    }

    @Override // com.pengrad.telegrambot.model.chatbackground.BackgroundType
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.theme_name);
    }
}
