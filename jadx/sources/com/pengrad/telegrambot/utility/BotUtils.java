package com.pengrad.telegrambot.utility;

import com.google.gson.c;
import com.google.gson.e;
import com.google.gson.f;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.chatbackground.BackgroundFill;
import com.pengrad.telegrambot.model.chatbackground.BackgroundType;
import com.pengrad.telegrambot.model.chatboost.source.ChatBoostSource;
import com.pengrad.telegrambot.model.gift.owned.OwnedGift;
import com.pengrad.telegrambot.model.message.MaybeInaccessibleMessage;
import com.pengrad.telegrambot.model.message.origin.MessageOrigin;
import com.pengrad.telegrambot.model.paidmedia.PaidMedia;
import com.pengrad.telegrambot.model.reaction.ReactionType;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartner;
import com.pengrad.telegrambot.model.stars.withdrawal.RevenueWithdrawalState;
import com.pengrad.telegrambot.utility.gson.BackgroundFillAdapter;
import com.pengrad.telegrambot.utility.gson.BackgroundTypeAdapter;
import com.pengrad.telegrambot.utility.gson.ChatBoostSourceTypeAdapter;
import com.pengrad.telegrambot.utility.gson.MaybeInaccessibleMessageTypeAdapter;
import com.pengrad.telegrambot.utility.gson.MessageOriginTypeAdapter;
import com.pengrad.telegrambot.utility.gson.OwnedGiftTypeAdapter;
import com.pengrad.telegrambot.utility.gson.PaidMediaTypeAdapter;
import com.pengrad.telegrambot.utility.gson.ReactionTypeAdapter;
import com.pengrad.telegrambot.utility.gson.RevenueWithdrawalStateTypeAdapter;
import com.pengrad.telegrambot.utility.gson.TransactionPartnerTypeAdapter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class BotUtils {
    public static final e GSON = new f().c(ReactionType.class, new ReactionTypeAdapter()).c(MessageOrigin.class, new MessageOriginTypeAdapter()).c(ChatBoostSource.class, new ChatBoostSourceTypeAdapter()).c(MaybeInaccessibleMessage.class, new MaybeInaccessibleMessageTypeAdapter()).c(BackgroundType.class, new BackgroundTypeAdapter()).c(BackgroundFill.class, new BackgroundFillAdapter()).c(RevenueWithdrawalState.class, new RevenueWithdrawalStateTypeAdapter()).c(TransactionPartner.class, TransactionPartnerTypeAdapter.INSTANCE).c(PaidMedia.class, new PaidMediaTypeAdapter()).c(OwnedGift.class, new OwnedGiftTypeAdapter()).f(c.f4798e).b();

    public static Update parseUpdate(String str) {
        return (Update) GSON.n(str, Update.class);
    }

    public static <R> R fromJson(String str, Class<R> cls) {
        return (R) GSON.n(str, cls);
    }

    public static byte[] getBytesFromInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[65535];
        while (true) {
            int i10 = inputStream.read(bArr);
            if (i10 == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i10);
        }
    }

    public static Update parseUpdate(Reader reader) {
        return (Update) GSON.k(reader, Update.class);
    }

    public static String toJson(Object obj) {
        return GSON.w(obj);
    }

    private BotUtils() {
    }
}
