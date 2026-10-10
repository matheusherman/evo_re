package com.pengrad.telegrambot.model.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ReplyKeyboardMarkup extends Keyboard implements Serializable {
    private static final long serialVersionUID = 0;
    private String input_field_placeholder;
    private boolean is_persistent;
    private final List<List<KeyboardButton>> keyboard;
    private boolean one_time_keyboard;
    private boolean resize_keyboard;
    private boolean selective;

    public ReplyKeyboardMarkup(String[][] strArr, boolean z10, boolean z11, String str, boolean z12, boolean z13) {
        this.keyboard = new ArrayList();
        this.resize_keyboard = z10;
        this.one_time_keyboard = z11;
        this.input_field_placeholder = str;
        this.selective = z12;
        this.is_persistent = z13;
        for (String[] strArr2 : strArr) {
            addRow(strArr2);
        }
    }

    public ReplyKeyboardMarkup addRow(KeyboardButton... keyboardButtonArr) {
        this.keyboard.add(Arrays.asList(keyboardButtonArr));
        return this;
    }

    public ReplyKeyboardMarkup addRow(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(new KeyboardButton(str));
        }
        this.keyboard.add(arrayList);
        return this;
    }

    public ReplyKeyboardMarkup inputFieldPlaceholder(String str) {
        this.input_field_placeholder = str;
        return this;
    }

    public ReplyKeyboardMarkup isPersistent(boolean z10) {
        this.is_persistent = z10;
        return this;
    }

    public ReplyKeyboardMarkup oneTimeKeyboard(boolean z10) {
        this.one_time_keyboard = z10;
        return this;
    }

    public ReplyKeyboardMarkup resizeKeyboard(boolean z10) {
        this.resize_keyboard = z10;
        return this;
    }

    public ReplyKeyboardMarkup selective(boolean z10) {
        this.selective = z10;
        return this;
    }

    public ReplyKeyboardMarkup(String[][] strArr, boolean z10, boolean z11, boolean z12, boolean z13) {
        this(strArr, z10, z11, null, z12, z13);
    }

    public ReplyKeyboardMarkup(String[]... strArr) {
        this(strArr, false, false, false, false);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReplyKeyboardMarkup(KeyboardButton[]... keyboardButtonArr) {
        this(new String[0][]);
        for (KeyboardButton[] keyboardButtonArr2 : keyboardButtonArr) {
            addRow(keyboardButtonArr2);
        }
    }

    public ReplyKeyboardMarkup(String... strArr) {
        this(strArr);
    }

    public ReplyKeyboardMarkup(KeyboardButton... keyboardButtonArr) {
        this(keyboardButtonArr);
    }
}
