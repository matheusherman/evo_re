package com.pengrad.telegrambot.request;

import androidx.constraintlayout.core.motion.utils.TypedValues;
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
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\bB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u0010B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0002\u0010\u0013B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0002\u0010\u0014B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u000e¢\u0006\u0002\u0010\u0015BC\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0005J\u001f\u0010!\u001a\u00020\u00002\u0012\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0=\"\u00020 ¢\u0006\u0002\u0010>J\u0014\u0010!\u001a\u00020\u00002\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u000e\u0010(\u001a\u00020\u00002\u0006\u0010(\u001a\u00020'J\u000e\u0010/\u001a\u00020\u00002\u0006\u0010/\u001a\u00020.J\u000e\u00105\u001a\u00020\u00002\u0006\u00105\u001a\u00020\u0005J\u000e\u00109\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0005R/\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR;\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010\u001e\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R/\u0010(\u001a\u0004\u0018\u00010'2\b\u0010\u0017\u001a\u0004\u0018\u00010'8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010\u001e\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R/\u0010/\u001a\u0004\u0018\u00010.2\b\u0010\u0017\u001a\u0004\u0018\u00010.8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010\u001e\u001a\u0004\b0\u00101\"\u0004\b2\u00103R/\u00105\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b8\u0010\u001e\u001a\u0004\b6\u0010\u001a\"\u0004\b7\u0010\u001cR/\u00109\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b<\u0010\u001e\u001a\u0004\b:\u0010\u001a\"\u0004\b;\u0010\u001c¨\u0006?"}, d2 = {"Lcom/pengrad/telegrambot/request/SendAudio;", "Lcom/pengrad/telegrambot/request/AbstractThumbnailedMultipartRequest;", "chatId", "", "audioUrl", "", "(JLjava/lang/String;)V", "channelUsername", "(Ljava/lang/String;Ljava/lang/String;)V", "audioFile", "Ljava/io/File;", "(JLjava/io/File;)V", "(Ljava/lang/String;Ljava/io/File;)V", "audioBytes", "", "(J[B)V", "(Ljava/lang/String;[B)V", "", "audio", "(Ljava/lang/Object;Ljava/lang/String;)V", "(Ljava/lang/Object;Ljava/io/File;)V", "(Ljava/lang/Object;[B)V", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;[B)V", "<set-?>", "caption", "getCaption", "()Ljava/lang/String;", "setCaption", "(Ljava/lang/String;)V", "caption$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "", "Lcom/pengrad/telegrambot/model/MessageEntity;", "captionEntities", "getCaptionEntities", "()Ljava/util/List;", "setCaptionEntities", "(Ljava/util/List;)V", "captionEntities$delegate", "", TypedValues.TransitionType.S_DURATION, "getDuration", "()Ljava/lang/Integer;", "setDuration", "(Ljava/lang/Integer;)V", "duration$delegate", "Lcom/pengrad/telegrambot/model/request/ParseMode;", "parseMode", "getParseMode", "()Lcom/pengrad/telegrambot/model/request/ParseMode;", "setParseMode", "(Lcom/pengrad/telegrambot/model/request/ParseMode;)V", "parseMode$delegate", "performer", "getPerformer", "setPerformer", "performer$delegate", "title", "getTitle", "setTitle", "title$delegate", "", "([Lcom/pengrad/telegrambot/model/MessageEntity;)Lcom/pengrad/telegrambot/request/SendAudio;", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SendAudio extends AbstractThumbnailedMultipartRequest<SendAudio> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.e(new q(SendAudio.class, "caption", "getCaption()Ljava/lang/String;", 0)), c0.e(new q(SendAudio.class, "parseMode", "getParseMode()Lcom/pengrad/telegrambot/model/request/ParseMode;", 0)), c0.e(new q(SendAudio.class, "captionEntities", "getCaptionEntities()Ljava/util/List;", 0)), c0.e(new q(SendAudio.class, TypedValues.TransitionType.S_DURATION, "getDuration()Ljava/lang/Integer;", 0)), c0.e(new q(SendAudio.class, "performer", "getPerformer()Ljava/lang/String;", 0)), c0.e(new q(SendAudio.class, "title", "getTitle()Ljava/lang/String;", 0))};

    /* JADX INFO: renamed from: caption$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate caption;

    /* JADX INFO: renamed from: captionEntities$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate captionEntities;

    /* JADX INFO: renamed from: duration$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate duration;

    /* JADX INFO: renamed from: parseMode$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate parseMode;

    /* JADX INFO: renamed from: performer$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate performer;

    /* JADX INFO: renamed from: title$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate title;

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendAudio$caption$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendAudio;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendAudio;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass5 extends o implements l<SendAudio, z> {
        final /* synthetic */ String $caption;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendAudio sendAudio) {
            invoke2(sendAudio);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(String str) {
            super(1);
            this.$caption = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendAudio applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setCaption(this.$caption);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendAudio$captionEntities$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendAudio;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendAudio;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06045 extends o implements l<SendAudio, z> {
        final /* synthetic */ List<MessageEntity> $captionEntities;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendAudio sendAudio) {
            invoke2(sendAudio);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C06045(List<? extends MessageEntity> list) {
            super(1);
            this.$captionEntities = list;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendAudio applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setCaptionEntities(this.$captionEntities);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendAudio$duration$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendAudio;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendAudio;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06055 extends o implements l<SendAudio, z> {
        final /* synthetic */ int $duration;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendAudio sendAudio) {
            invoke2(sendAudio);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06055(int i10) {
            super(1);
            this.$duration = i10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendAudio applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setDuration(Integer.valueOf(this.$duration));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendAudio$parseMode$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendAudio;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendAudio;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06065 extends o implements l<SendAudio, z> {
        final /* synthetic */ ParseMode $parseMode;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendAudio sendAudio) {
            invoke2(sendAudio);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06065(ParseMode parseMode) {
            super(1);
            this.$parseMode = parseMode;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendAudio applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setParseMode(this.$parseMode);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendAudio$performer$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendAudio;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendAudio;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06075 extends o implements l<SendAudio, z> {
        final /* synthetic */ String $performer;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendAudio sendAudio) {
            invoke2(sendAudio);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06075(String str) {
            super(1);
            this.$performer = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendAudio applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setPerformer(this.$performer);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendAudio$title$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendAudio;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendAudio;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06085 extends o implements l<SendAudio, z> {
        final /* synthetic */ String $title;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendAudio sendAudio) {
            invoke2(sendAudio);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06085(String str) {
            super(1);
            this.$title = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendAudio applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setTitle(this.$title);
        }
    }

    /* synthetic */ SendAudio(Long l10, String str, String str2, File file, byte[] bArr, int i10, g gVar) {
        this((i10 & 1) != 0 ? null : l10, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : file, (i10 & 16) != 0 ? null : bArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendAudio captionEntities(List<? extends MessageEntity> captionEntities) {
        m.f(captionEntities, "captionEntities");
        return (SendAudio) applySelf(new C06045(captionEntities));
    }

    private SendAudio(Long l10, String str, String str2, File file, byte[] bArr) {
        super(l10, str, "audio", str2, file, bArr, ContentTypes.AUDIO_FILE_NAME, ContentTypes.AUDIO_MIME_TYPE);
        RequestParameterDelegate requestParameterDelegateOptionalRequestParameter$default = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null);
        k<?>[] kVarArr = $$delegatedProperties;
        this.caption = requestParameterDelegateOptionalRequestParameter$default.provideDelegate(this, kVarArr[0]);
        this.parseMode = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[1]);
        this.captionEntities = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[2]);
        this.duration = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[3]);
        this.performer = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[4]);
        this.title = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[5]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendAudio caption(String caption) {
        m.f(caption, "caption");
        return (SendAudio) applySelf(new AnonymousClass5(caption));
    }

    public final SendAudio captionEntities(MessageEntity... captionEntities) {
        m.f(captionEntities, "captionEntities");
        return captionEntities(j.E0(captionEntities));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendAudio duration(int duration) {
        return (SendAudio) applySelf(new C06055(duration));
    }

    public final String getCaption() {
        return (String) this.caption.getValue(this, $$delegatedProperties[0]);
    }

    public final List<MessageEntity> getCaptionEntities() {
        return (List) this.captionEntities.getValue(this, $$delegatedProperties[2]);
    }

    public final Integer getDuration() {
        return (Integer) this.duration.getValue(this, $$delegatedProperties[3]);
    }

    public final ParseMode getParseMode() {
        return (ParseMode) this.parseMode.getValue(this, $$delegatedProperties[1]);
    }

    public final String getPerformer() {
        return (String) this.performer.getValue(this, $$delegatedProperties[4]);
    }

    public final String getTitle() {
        return (String) this.title.getValue(this, $$delegatedProperties[5]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendAudio parseMode(ParseMode parseMode) {
        m.f(parseMode, "parseMode");
        return (SendAudio) applySelf(new C06065(parseMode));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendAudio performer(String performer) {
        m.f(performer, "performer");
        return (SendAudio) applySelf(new C06075(performer));
    }

    public final void setCaption(String str) {
        this.caption.setValue(this, $$delegatedProperties[0], str);
    }

    public final void setCaptionEntities(List<? extends MessageEntity> list) {
        this.captionEntities.setValue(this, $$delegatedProperties[2], list);
    }

    public final void setDuration(Integer num) {
        this.duration.setValue(this, $$delegatedProperties[3], num);
    }

    public final void setParseMode(ParseMode parseMode) {
        this.parseMode.setValue(this, $$delegatedProperties[1], parseMode);
    }

    public final void setPerformer(String str) {
        this.performer.setValue(this, $$delegatedProperties[4], str);
    }

    public final void setTitle(String str) {
        this.title.setValue(this, $$delegatedProperties[5], str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendAudio title(String title) {
        m.f(title, "title");
        return (SendAudio) applySelf(new C06085(title));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendAudio(long j10, String audioUrl) {
        this(Long.valueOf(j10), null, audioUrl, null, null, 24, null);
        m.f(audioUrl, "audioUrl");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendAudio(String channelUsername, String audioUrl) {
        this(null, channelUsername, audioUrl, null, null, 24, null);
        m.f(channelUsername, "channelUsername");
        m.f(audioUrl, "audioUrl");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendAudio(long j10, File audioFile) {
        this(Long.valueOf(j10), null, null, audioFile, null, 20, null);
        m.f(audioFile, "audioFile");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendAudio(String channelUsername, File audioFile) {
        this(null, channelUsername, null, audioFile, null, 20, null);
        m.f(channelUsername, "channelUsername");
        m.f(audioFile, "audioFile");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendAudio(long j10, byte[] audioBytes) {
        this(Long.valueOf(j10), null, null, null, audioBytes, 12, null);
        m.f(audioBytes, "audioBytes");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendAudio(String channelUsername, byte[] audioBytes) {
        this(null, channelUsername, null, null, audioBytes, 12, null);
        m.f(channelUsername, "channelUsername");
        m.f(audioBytes, "audioBytes");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SendAudio(Object chatId, String audio) {
        m.f(chatId, "chatId");
        m.f(audio, "audio");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        this(number != null ? Long.valueOf(number.longValue()) : null, chatId instanceof String ? (String) chatId : null, audio, null, null, 24, null);
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SendAudio(Object chatId, File audio) {
        m.f(chatId, "chatId");
        m.f(audio, "audio");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        this(number != null ? Long.valueOf(number.longValue()) : null, chatId instanceof String ? (String) chatId : null, null, audio, null, 20, null);
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SendAudio(Object chatId, byte[] audio) {
        m.f(chatId, "chatId");
        m.f(audio, "audio");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        this(number != null ? Long.valueOf(number.longValue()) : null, chatId instanceof String ? (String) chatId : null, null, null, audio, 12, null);
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }
}
