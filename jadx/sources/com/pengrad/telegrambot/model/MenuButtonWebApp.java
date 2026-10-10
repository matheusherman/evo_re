package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class MenuButtonWebApp extends MenuButton implements Serializable {
    private static final long serialVersionUID = 0;
    private String text;
    private WebAppInfo web_app;

    public MenuButtonWebApp(String str, WebAppInfo webAppInfo) {
        super("web_app");
        this.text = str;
        this.web_app = webAppInfo;
    }

    @Override // com.pengrad.telegrambot.model.MenuButton
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        MenuButtonWebApp menuButtonWebApp = (MenuButtonWebApp) obj;
        return Objects.equals(this.text, menuButtonWebApp.text) && Objects.equals(this.web_app, menuButtonWebApp.web_app);
    }

    @Override // com.pengrad.telegrambot.model.MenuButton
    public String toString() {
        return "MenuButtonWebApp{text='" + this.text + "', web_app=" + this.web_app + '}';
    }

    @Override // com.pengrad.telegrambot.model.MenuButton
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.text, this.web_app);
    }

    MenuButtonWebApp() {
    }
}
