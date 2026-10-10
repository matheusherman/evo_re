package com.pengrad.telegrambot.request;

import c9.l;
import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegate;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegateKt;
import i9.k;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.j;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\bB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u0010B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0002\u0010\u0013B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0002\u0010\u0014B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u000e¢\u0006\u0002\u0010\u0015BC\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0005J\u001f\u0010!\u001a\u00020\u00002\u0012\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020 05\"\u00020 ¢\u0006\u0002\u00106J\u0014\u0010!\u001a\u00020\u00002\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u000e\u0010(\u001a\u00020\u00002\u0006\u0010(\u001a\u00020'J\u000e\u0010/\u001a\u00020\u00002\u0006\u0010/\u001a\u00020.R/\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR;\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010\u001e\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R/\u0010(\u001a\u0004\u0018\u00010'2\b\u0010\u0017\u001a\u0004\u0018\u00010'8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010\u001e\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R/\u0010/\u001a\u0004\u0018\u00010.2\b\u0010\u0017\u001a\u0004\u0018\u00010.8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010\u001e\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00067"}, d2 = {"Lcom/pengrad/telegrambot/request/SendDocument;", "Lcom/pengrad/telegrambot/request/AbstractThumbnailedMultipartRequest;", "chatId", "", "documentUrl", "", "(JLjava/lang/String;)V", "channelUsername", "(Ljava/lang/String;Ljava/lang/String;)V", "documentFile", "Ljava/io/File;", "(JLjava/io/File;)V", "(Ljava/lang/String;Ljava/io/File;)V", "documentBytes", "", "(J[B)V", "(Ljava/lang/String;[B)V", "", "document", "(Ljava/lang/Object;Ljava/lang/String;)V", "(Ljava/lang/Object;Ljava/io/File;)V", "(Ljava/lang/Object;[B)V", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;[B)V", "<set-?>", "caption", "getCaption", "()Ljava/lang/String;", "setCaption", "(Ljava/lang/String;)V", "caption$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "", "Lcom/pengrad/telegrambot/model/MessageEntity;", "captionEntities", "getCaptionEntities", "()Ljava/util/List;", "setCaptionEntities", "(Ljava/util/List;)V", "captionEntities$delegate", "", "disableContentTypeDetection", "getDisableContentTypeDetection", "()Ljava/lang/Boolean;", "setDisableContentTypeDetection", "(Ljava/lang/Boolean;)V", "disableContentTypeDetection$delegate", "Lcom/pengrad/telegrambot/model/request/ParseMode;", "parseMode", "getParseMode", "()Lcom/pengrad/telegrambot/model/request/ParseMode;", "setParseMode", "(Lcom/pengrad/telegrambot/model/request/ParseMode;)V", "parseMode$delegate", "", "([Lcom/pengrad/telegrambot/model/MessageEntity;)Lcom/pengrad/telegrambot/request/SendDocument;", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SendDocument extends AbstractThumbnailedMultipartRequest<SendDocument> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.e(new q(SendDocument.class, "caption", "getCaption()Ljava/lang/String;", 0)), c0.e(new q(SendDocument.class, "parseMode", "getParseMode()Lcom/pengrad/telegrambot/model/request/ParseMode;", 0)), c0.e(new q(SendDocument.class, "captionEntities", "getCaptionEntities()Ljava/util/List;", 0)), c0.e(new q(SendDocument.class, "disableContentTypeDetection", "getDisableContentTypeDetection()Ljava/lang/Boolean;", 0))};

    /* JADX INFO: renamed from: caption$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate caption;

    /* JADX INFO: renamed from: captionEntities$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate captionEntities;

    /* JADX INFO: renamed from: disableContentTypeDetection$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate disableContentTypeDetection;

    /* JADX INFO: renamed from: parseMode$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate parseMode;

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendDocument$caption$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendDocument;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendDocument;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass5 extends o implements l<SendDocument, z> {
        final /* synthetic */ String $caption;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendDocument sendDocument) {
            invoke2(sendDocument);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(String str) {
            super(1);
            this.$caption = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendDocument applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setCaption(this.$caption);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendDocument$captionEntities$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendDocument;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendDocument;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06095 extends o implements l<SendDocument, z> {
        final /* synthetic */ List<MessageEntity> $captionEntities;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendDocument sendDocument) {
            invoke2(sendDocument);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C06095(List<? extends MessageEntity> list) {
            super(1);
            this.$captionEntities = list;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendDocument applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setCaptionEntities(this.$captionEntities);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendDocument$disableContentTypeDetection$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendDocument;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendDocument;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06105 extends o implements l<SendDocument, z> {
        final /* synthetic */ boolean $disableContentTypeDetection;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendDocument sendDocument) {
            invoke2(sendDocument);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06105(boolean z10) {
            super(1);
            this.$disableContentTypeDetection = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendDocument applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setDisableContentTypeDetection(Boolean.valueOf(this.$disableContentTypeDetection));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendDocument$parseMode$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendDocument;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendDocument;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06115 extends o implements l<SendDocument, z> {
        final /* synthetic */ ParseMode $parseMode;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendDocument sendDocument) {
            invoke2(sendDocument);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06115(ParseMode parseMode) {
            super(1);
            this.$parseMode = parseMode;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendDocument applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setParseMode(this.$parseMode);
        }
    }

    /* synthetic */ SendDocument(Long l10, String str, String str2, File file, byte[] bArr, int i10, g gVar) {
        this((i10 & 1) != 0 ? null : l10, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : file, (i10 & 16) != 0 ? null : bArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendDocument captionEntities(List<? extends MessageEntity> captionEntities) {
        m.f(captionEntities, "captionEntities");
        return (SendDocument) applySelf(new C06095(captionEntities));
    }

    private SendDocument(Long l10, String str, String str2, File file, byte[] bArr) {
        super(l10, str, "document", str2, file, bArr, "file.txt", ContentTypes.DOC_MIME_TYPE);
        RequestParameterDelegate requestParameterDelegateOptionalRequestParameter$default = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null);
        k<?>[] kVarArr = $$delegatedProperties;
        this.caption = requestParameterDelegateOptionalRequestParameter$default.provideDelegate(this, kVarArr[0]);
        this.parseMode = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[1]);
        this.captionEntities = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[2]);
        this.disableContentTypeDetection = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[3]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendDocument caption(String caption) {
        m.f(caption, "caption");
        return (SendDocument) applySelf(new AnonymousClass5(caption));
    }

    public final SendDocument captionEntities(MessageEntity... captionEntities) {
        m.f(captionEntities, "captionEntities");
        return captionEntities(j.E0(captionEntities));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendDocument disableContentTypeDetection(boolean disableContentTypeDetection) {
        return (SendDocument) applySelf(new C06105(disableContentTypeDetection));
    }

    public final String getCaption() {
        return (String) this.caption.getValue(this, $$delegatedProperties[0]);
    }

    public final List<MessageEntity> getCaptionEntities() {
        return (List) this.captionEntities.getValue(this, $$delegatedProperties[2]);
    }

    public final Boolean getDisableContentTypeDetection() {
        return (Boolean) this.disableContentTypeDetection.getValue(this, $$delegatedProperties[3]);
    }

    public final ParseMode getParseMode() {
        return (ParseMode) this.parseMode.getValue(this, $$delegatedProperties[1]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendDocument parseMode(ParseMode parseMode) {
        m.f(parseMode, "parseMode");
        return (SendDocument) applySelf(new C06115(parseMode));
    }

    public final void setCaption(String str) {
        this.caption.setValue(this, $$delegatedProperties[0], str);
    }

    public final void setCaptionEntities(List<? extends MessageEntity> list) {
        this.captionEntities.setValue(this, $$delegatedProperties[2], list);
    }

    public final void setDisableContentTypeDetection(Boolean bool) {
        this.disableContentTypeDetection.setValue(this, $$delegatedProperties[3], bool);
    }

    public final void setParseMode(ParseMode parseMode) {
        this.parseMode.setValue(this, $$delegatedProperties[1], parseMode);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendDocument(long j10, String documentUrl) {
        this(Long.valueOf(j10), null, documentUrl, null, null, 24, null);
        m.f(documentUrl, "documentUrl");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendDocument(String channelUsername, String documentUrl) {
        this(null, channelUsername, documentUrl, null, null, 24, null);
        m.f(channelUsername, "channelUsername");
        m.f(documentUrl, "documentUrl");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendDocument(long j10, File documentFile) {
        this(Long.valueOf(j10), null, null, documentFile, null, 20, null);
        m.f(documentFile, "documentFile");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendDocument(String channelUsername, File documentFile) {
        this(null, channelUsername, null, documentFile, null, 20, null);
        m.f(channelUsername, "channelUsername");
        m.f(documentFile, "documentFile");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendDocument(long j10, byte[] documentBytes) {
        this(Long.valueOf(j10), null, null, null, documentBytes, 12, null);
        m.f(documentBytes, "documentBytes");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendDocument(String channelUsername, byte[] documentBytes) {
        this(null, channelUsername, null, null, documentBytes, 12, null);
        m.f(channelUsername, "channelUsername");
        m.f(documentBytes, "documentBytes");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SendDocument(Object chatId, String document) {
        m.f(chatId, "chatId");
        m.f(document, "document");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        this(number != null ? Long.valueOf(number.longValue()) : null, chatId instanceof String ? (String) chatId : null, document, null, null, 24, null);
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SendDocument(Object chatId, File document) {
        m.f(chatId, "chatId");
        m.f(document, "document");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        this(number != null ? Long.valueOf(number.longValue()) : null, chatId instanceof String ? (String) chatId : null, null, document, null, 20, null);
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SendDocument(Object chatId, byte[] document) {
        m.f(chatId, "chatId");
        m.f(document, "document");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        this(number != null ? Long.valueOf(number.longValue()) : null, chatId instanceof String ? (String) chatId : null, null, null, document, 12, null);
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }
}
