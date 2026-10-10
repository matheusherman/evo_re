package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.Update;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface UpdatesListener {
    public static final int CONFIRMED_UPDATES_ALL = -1;
    public static final int CONFIRMED_UPDATES_NONE = -2;

    int process(List<Update> list);
}
