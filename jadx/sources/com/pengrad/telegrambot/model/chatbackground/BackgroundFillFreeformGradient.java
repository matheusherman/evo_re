package com.pengrad.telegrambot.model.chatbackground;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class BackgroundFillFreeformGradient extends BackgroundFill {
    public static final String TYPE = "freeform_gradient";
    private Integer[] colors;

    public BackgroundFillFreeformGradient(Integer... numArr) {
        super(TYPE);
        this.colors = numArr;
    }

    public Integer[] colors() {
        return this.colors;
    }

    @Override // com.pengrad.telegrambot.model.chatbackground.BackgroundFill
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && super.equals(obj)) {
            return Objects.deepEquals(this.colors, ((BackgroundFillFreeformGradient) obj).colors);
        }
        return false;
    }

    @Override // com.pengrad.telegrambot.model.chatbackground.BackgroundFill
    public String toString() {
        return "BackgroundFillFreeformGradient{colors=" + Arrays.toString(this.colors) + '}';
    }

    @Override // com.pengrad.telegrambot.model.chatbackground.BackgroundFill
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), Integer.valueOf(Arrays.hashCode(this.colors)));
    }
}
