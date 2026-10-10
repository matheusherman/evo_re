package com.pengrad.telegrambot.model;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class Dice implements Serializable {
    private static final long serialVersionUID = 0;
    private String emoji;
    private Integer value;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Dice dice = (Dice) obj;
            String str = this.emoji;
            if (str == null ? dice.emoji != null : !str.equals(dice.emoji)) {
                return false;
            }
            Integer num = this.value;
            Integer num2 = dice.value;
            if (num != null) {
                return num.equals(num2);
            }
            if (num2 == null) {
                return true;
            }
        }
        return false;
    }

    public String emoji() {
        return this.emoji;
    }

    public int hashCode() {
        String str = this.emoji;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.value;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "Dice{emoji='" + this.emoji + "', value=" + this.value + '}';
    }

    public Integer value() {
        return this.value;
    }
}
