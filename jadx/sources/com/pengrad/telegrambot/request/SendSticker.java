package com.pengrad.telegrambot.request;

import c9.l;
import com.pengrad.telegrambot.model.reaction.ReactionTypeEmoji;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegate;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegateKt;
import i9.k;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\bB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u0010B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0002\u0010\u0013B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0002\u0010\u0014B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u000e¢\u0006\u0002\u0010\u0015BC\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0005R/\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/pengrad/telegrambot/request/SendSticker;", "Lcom/pengrad/telegrambot/request/AbstractThumbnailedMultipartRequest;", "chatId", "", "stickerUrl", "", "(JLjava/lang/String;)V", "channelUsername", "(Ljava/lang/String;Ljava/lang/String;)V", "stickerFile", "Ljava/io/File;", "(JLjava/io/File;)V", "(Ljava/lang/String;Ljava/io/File;)V", "stickerBytes", "", "(J[B)V", "(Ljava/lang/String;[B)V", "", "sticker", "(Ljava/lang/Object;Ljava/lang/String;)V", "(Ljava/lang/Object;Ljava/io/File;)V", "(Ljava/lang/Object;[B)V", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;[B)V", "<set-?>", ReactionTypeEmoji.EMOJI_TYPE, "getEmoji", "()Ljava/lang/String;", "setEmoji", "(Ljava/lang/String;)V", "emoji$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SendSticker extends AbstractThumbnailedMultipartRequest<SendSticker> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.e(new q(SendSticker.class, ReactionTypeEmoji.EMOJI_TYPE, "getEmoji()Ljava/lang/String;", 0))};

    /* JADX INFO: renamed from: emoji$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate emoji;

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendSticker$emoji$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendSticker;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendSticker;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass5 extends o implements l<SendSticker, z> {
        final /* synthetic */ String $emoji;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendSticker sendSticker) {
            invoke2(sendSticker);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(String str) {
            super(1);
            this.$emoji = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendSticker applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setEmoji(this.$emoji);
        }
    }

    /* synthetic */ SendSticker(Long l10, String str, String str2, File file, byte[] bArr, int i10, g gVar) {
        this((i10 & 1) != 0 ? null : l10, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : file, (i10 & 16) != 0 ? null : bArr);
    }

    private SendSticker(Long l10, String str, String str2, File file, byte[] bArr) {
        super(l10, str, "sticker", str2, file, bArr, ContentTypes.PHOTO_FILE_NAME, ContentTypes.PHOTO_MIME_TYPE);
        this.emoji = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, $$delegatedProperties[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendSticker emoji(String emoji) {
        m.f(emoji, "emoji");
        return (SendSticker) applySelf(new AnonymousClass5(emoji));
    }

    public final String getEmoji() {
        return (String) this.emoji.getValue(this, $$delegatedProperties[0]);
    }

    public final void setEmoji(String str) {
        this.emoji.setValue(this, $$delegatedProperties[0], str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendSticker(long j10, String stickerUrl) {
        this(Long.valueOf(j10), null, stickerUrl, null, null, 24, null);
        m.f(stickerUrl, "stickerUrl");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendSticker(String channelUsername, String stickerUrl) {
        this(null, channelUsername, stickerUrl, null, null, 24, null);
        m.f(channelUsername, "channelUsername");
        m.f(stickerUrl, "stickerUrl");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendSticker(long j10, File stickerFile) {
        this(Long.valueOf(j10), null, null, stickerFile, null, 20, null);
        m.f(stickerFile, "stickerFile");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendSticker(String channelUsername, File stickerFile) {
        this(null, channelUsername, null, stickerFile, null, 20, null);
        m.f(channelUsername, "channelUsername");
        m.f(stickerFile, "stickerFile");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendSticker(long j10, byte[] stickerBytes) {
        this(Long.valueOf(j10), null, null, null, stickerBytes, 12, null);
        m.f(stickerBytes, "stickerBytes");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendSticker(String channelUsername, byte[] stickerBytes) {
        this(null, channelUsername, null, null, stickerBytes, 12, null);
        m.f(channelUsername, "channelUsername");
        m.f(stickerBytes, "stickerBytes");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SendSticker(Object chatId, String sticker) {
        m.f(chatId, "chatId");
        m.f(sticker, "sticker");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        this(number != null ? Long.valueOf(number.longValue()) : null, chatId instanceof String ? (String) chatId : null, sticker, null, null, 24, null);
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SendSticker(Object chatId, File sticker) {
        m.f(chatId, "chatId");
        m.f(sticker, "sticker");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        this(number != null ? Long.valueOf(number.longValue()) : null, chatId instanceof String ? (String) chatId : null, null, sticker, null, 20, null);
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SendSticker(Object chatId, byte[] sticker) {
        m.f(chatId, "chatId");
        m.f(sticker, "sticker");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        this(number != null ? Long.valueOf(number.longValue()) : null, chatId instanceof String ? (String) chatId : null, null, null, sticker, 12, null);
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }
}
