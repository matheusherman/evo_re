package com.pengrad.telegrambot.model.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InlineKeyboardMarkup extends Keyboard implements Serializable {
    private static final long serialVersionUID = 0;
    private final List<List<InlineKeyboardButton>> inline_keyboard;

    public InlineKeyboardMarkup() {
        this.inline_keyboard = new ArrayList();
    }

    public InlineKeyboardMarkup addRow(InlineKeyboardButton... inlineKeyboardButtonArr) {
        this.inline_keyboard.add(Arrays.asList(inlineKeyboardButtonArr));
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.inline_keyboard, ((InlineKeyboardMarkup) obj).inline_keyboard);
    }

    public int hashCode() {
        return Objects.hash(this.inline_keyboard);
    }

    public InlineKeyboardButton[][] inlineKeyboard() {
        InlineKeyboardButton[][] inlineKeyboardButtonArr = new InlineKeyboardButton[this.inline_keyboard.size()][];
        for (int i10 = 0; i10 < this.inline_keyboard.size(); i10++) {
            inlineKeyboardButtonArr[i10] = (InlineKeyboardButton[]) this.inline_keyboard.get(i10).toArray(new InlineKeyboardButton[0]);
        }
        return inlineKeyboardButtonArr;
    }

    public String toString() {
        return "InlineKeyboardMarkup{inline_keyboard=" + this.inline_keyboard + '}';
    }

    public InlineKeyboardMarkup(InlineKeyboardButton[]... inlineKeyboardButtonArr) {
        this();
        for (InlineKeyboardButton[] inlineKeyboardButtonArr2 : inlineKeyboardButtonArr) {
            addRow(inlineKeyboardButtonArr2);
        }
    }

    public InlineKeyboardMarkup(InlineKeyboardButton... inlineKeyboardButtonArr) {
        this(inlineKeyboardButtonArr);
    }
}
