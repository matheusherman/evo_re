package com.pengrad.telegrambot.model;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class BotCommand implements Serializable {
    private static final long serialVersionUID = 0;
    private String command;
    private String description;

    public BotCommand(String str, String str2) {
        this.command = str;
        this.description = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BotCommand botCommand = (BotCommand) obj;
            String str = this.command;
            if (str == null ? botCommand.command != null : !str.equals(botCommand.command)) {
                return false;
            }
            String str2 = this.description;
            String str3 = botCommand.description;
            if (str2 != null) {
                return str2.equals(str3);
            }
            if (str3 == null) {
                return true;
            }
        }
        return false;
    }

    public String command() {
        return this.command;
    }

    public String description() {
        return this.description;
    }

    public int hashCode() {
        String str = this.command;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.description;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "BotCommand{command='" + this.command + "', description='" + this.description + "'}";
    }

    BotCommand() {
    }
}
