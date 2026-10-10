package com.pengrad.telegrambot.request;

import c9.l;
import com.pengrad.telegrambot.model.LinkPreviewOptions;
import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegate;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegateKt;
import i9.k;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.j;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.w;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\bB\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\nB'\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00002\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0'\"\u00020\u000e¢\u0006\u0002\u0010(J\u0014\u0010\u000f\u001a\u00020\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001dR;\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R/\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\f\u001a\u0004\u0018\u00010\u00168F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR/\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\f\u001a\u0004\u0018\u00010\u001d8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0015\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0015\u001a\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/pengrad/telegrambot/request/SendMessage;", "Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "chatId", "", "text", "", "(JLjava/lang/String;)V", "channelUsername", "(Ljava/lang/String;Ljava/lang/String;)V", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "<set-?>", "", "Lcom/pengrad/telegrambot/model/MessageEntity;", "entities", "getEntities", "()Ljava/util/List;", "setEntities", "(Ljava/util/List;)V", "entities$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "Lcom/pengrad/telegrambot/model/LinkPreviewOptions;", "linkPreviewOptions", "getLinkPreviewOptions", "()Lcom/pengrad/telegrambot/model/LinkPreviewOptions;", "setLinkPreviewOptions", "(Lcom/pengrad/telegrambot/model/LinkPreviewOptions;)V", "linkPreviewOptions$delegate", "Lcom/pengrad/telegrambot/model/request/ParseMode;", "parseMode", "getParseMode", "()Lcom/pengrad/telegrambot/model/request/ParseMode;", "setParseMode", "(Lcom/pengrad/telegrambot/model/request/ParseMode;)V", "parseMode$delegate", "getText", "()Ljava/lang/String;", "text$delegate", "", "([Lcom/pengrad/telegrambot/model/MessageEntity;)Lcom/pengrad/telegrambot/request/SendMessage;", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SendMessage extends AbstractSendRequest<SendMessage> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(SendMessage.class, "text", "getText()Ljava/lang/String;", 0)), c0.e(new q(SendMessage.class, "parseMode", "getParseMode()Lcom/pengrad/telegrambot/model/request/ParseMode;", 0)), c0.e(new q(SendMessage.class, "entities", "getEntities()Ljava/util/List;", 0)), c0.e(new q(SendMessage.class, "linkPreviewOptions", "getLinkPreviewOptions()Lcom/pengrad/telegrambot/model/LinkPreviewOptions;", 0))};

    /* JADX INFO: renamed from: entities$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate entities;

    /* JADX INFO: renamed from: linkPreviewOptions$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate linkPreviewOptions;

    /* JADX INFO: renamed from: parseMode$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate parseMode;

    /* JADX INFO: renamed from: text$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate text;

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendMessage$entities$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendMessage;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendMessage;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass5 extends o implements l<SendMessage, z> {
        final /* synthetic */ List<MessageEntity> $entities;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendMessage sendMessage) {
            invoke2(sendMessage);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass5(List<? extends MessageEntity> list) {
            super(1);
            this.$entities = list;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendMessage applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setEntities(this.$entities);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendMessage$linkPreviewOptions$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendMessage;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendMessage;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06305 extends o implements l<SendMessage, z> {
        final /* synthetic */ LinkPreviewOptions $linkPreviewOptions;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendMessage sendMessage) {
            invoke2(sendMessage);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06305(LinkPreviewOptions linkPreviewOptions) {
            super(1);
            this.$linkPreviewOptions = linkPreviewOptions;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendMessage applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setLinkPreviewOptions(this.$linkPreviewOptions);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendMessage$parseMode$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendMessage;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendMessage;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06315 extends o implements l<SendMessage, z> {
        final /* synthetic */ ParseMode $parseMode;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendMessage sendMessage) {
            invoke2(sendMessage);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06315(ParseMode parseMode) {
            super(1);
            this.$parseMode = parseMode;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendMessage applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setParseMode(this.$parseMode);
        }
    }

    /* synthetic */ SendMessage(Long l10, String str, String str2, int i10, g gVar) {
        this((i10 & 1) != 0 ? null : l10, (i10 & 2) != 0 ? null : str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendMessage entities(List<? extends MessageEntity> entities) {
        m.f(entities, "entities");
        return (SendMessage) applySelf(new AnonymousClass5(entities));
    }

    private SendMessage(Long l10, String str, String str2) {
        super(l10, str);
        RequestParameterDelegate requestParameterDelegateRequestParameter$default = RequestParameterDelegateKt.requestParameter$default(str2, null, 2, null);
        k<?>[] kVarArr = $$delegatedProperties;
        this.text = requestParameterDelegateRequestParameter$default.provideDelegate(this, kVarArr[0]);
        this.parseMode = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[1]);
        this.entities = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[2]);
        this.linkPreviewOptions = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[3]);
    }

    public final SendMessage entities(MessageEntity... entities) {
        m.f(entities, "entities");
        return entities(j.E0(entities));
    }

    public final List<MessageEntity> getEntities() {
        return (List) this.entities.getValue(this, $$delegatedProperties[2]);
    }

    public final LinkPreviewOptions getLinkPreviewOptions() {
        return (LinkPreviewOptions) this.linkPreviewOptions.getValue(this, $$delegatedProperties[3]);
    }

    public final ParseMode getParseMode() {
        return (ParseMode) this.parseMode.getValue(this, $$delegatedProperties[1]);
    }

    public final String getText() {
        return (String) this.text.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendMessage linkPreviewOptions(LinkPreviewOptions linkPreviewOptions) {
        m.f(linkPreviewOptions, "linkPreviewOptions");
        return (SendMessage) applySelf(new C06305(linkPreviewOptions));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendMessage parseMode(ParseMode parseMode) {
        m.f(parseMode, "parseMode");
        return (SendMessage) applySelf(new C06315(parseMode));
    }

    public final void setEntities(List<? extends MessageEntity> list) {
        this.entities.setValue(this, $$delegatedProperties[2], list);
    }

    public final void setLinkPreviewOptions(LinkPreviewOptions linkPreviewOptions) {
        this.linkPreviewOptions.setValue(this, $$delegatedProperties[3], linkPreviewOptions);
    }

    public final void setParseMode(ParseMode parseMode) {
        this.parseMode.setValue(this, $$delegatedProperties[1], parseMode);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendMessage(long j10, String text) {
        this(Long.valueOf(j10), null, text);
        m.f(text, "text");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendMessage(String channelUsername, String text) {
        this(null, channelUsername, text);
        m.f(channelUsername, "channelUsername");
        m.f(text, "text");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SendMessage(Object chatId, String text) {
        m.f(chatId, "chatId");
        m.f(text, "text");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        this(number != null ? Long.valueOf(number.longValue()) : null, chatId instanceof String ? (String) chatId : null, text);
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }
}
