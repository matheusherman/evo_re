package com.pengrad.telegrambot.request;

import androidx.constraintlayout.core.motion.utils.TypedValues;
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
import kotlin.jvm.internal.q;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\bB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u0010B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0002\u0010\u0013B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0002\u0010\u0014B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u000e¢\u0006\u0002\u0010\u0015BC\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0005J\u001f\u0010!\u001a\u00020\u00002\u0012\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0H\"\u00020 ¢\u0006\u0002\u0010IJ\u0014\u0010!\u001a\u00020\u00002\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u000e\u0010(\u001a\u00020\u00002\u0006\u0010(\u001a\u00020'J\u000e\u0010/\u001a\u00020\u00002\u0006\u0010/\u001a\u00020.J\u000e\u00105\u001a\u00020\u00002\u0006\u00105\u001a\u00020'J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010:\u001a\u000209J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010@\u001a\u00020.J\u000e\u0010D\u001a\u00020\u00002\u0006\u0010D\u001a\u00020'R/\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR;\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010\u001e\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R/\u0010(\u001a\u0004\u0018\u00010'2\b\u0010\u0017\u001a\u0004\u0018\u00010'8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010\u001e\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R/\u0010/\u001a\u0004\u0018\u00010.2\b\u0010\u0017\u001a\u0004\u0018\u00010.8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010\u001e\u001a\u0004\b0\u00101\"\u0004\b2\u00103R/\u00105\u001a\u0004\u0018\u00010'2\b\u0010\u0017\u001a\u0004\u0018\u00010'8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b8\u0010\u001e\u001a\u0004\b6\u0010*\"\u0004\b7\u0010,R/\u0010:\u001a\u0004\u0018\u0001092\b\u0010\u0017\u001a\u0004\u0018\u0001098F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b?\u0010\u001e\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R/\u0010@\u001a\u0004\u0018\u00010.2\b\u0010\u0017\u001a\u0004\u0018\u00010.8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bC\u0010\u001e\u001a\u0004\bA\u00101\"\u0004\bB\u00103R/\u0010D\u001a\u0004\u0018\u00010'2\b\u0010\u0017\u001a\u0004\u0018\u00010'8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bG\u0010\u001e\u001a\u0004\bE\u0010*\"\u0004\bF\u0010,¨\u0006J"}, d2 = {"Lcom/pengrad/telegrambot/request/SendAnimation;", "Lcom/pengrad/telegrambot/request/AbstractThumbnailedMultipartRequest;", "chatId", "", "animationUrl", "", "(JLjava/lang/String;)V", "channelUsername", "(Ljava/lang/String;Ljava/lang/String;)V", "animationFile", "Ljava/io/File;", "(JLjava/io/File;)V", "(Ljava/lang/String;Ljava/io/File;)V", "animationBytes", "", "(J[B)V", "(Ljava/lang/String;[B)V", "", "animation", "(Ljava/lang/Object;Ljava/lang/String;)V", "(Ljava/lang/Object;Ljava/io/File;)V", "(Ljava/lang/Object;[B)V", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;[B)V", "<set-?>", "caption", "getCaption", "()Ljava/lang/String;", "setCaption", "(Ljava/lang/String;)V", "caption$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "", "Lcom/pengrad/telegrambot/model/MessageEntity;", "captionEntities", "getCaptionEntities", "()Ljava/util/List;", "setCaptionEntities", "(Ljava/util/List;)V", "captionEntities$delegate", "", TypedValues.TransitionType.S_DURATION, "getDuration", "()Ljava/lang/Integer;", "setDuration", "(Ljava/lang/Integer;)V", "duration$delegate", "", "hasSpoiler", "getHasSpoiler", "()Ljava/lang/Boolean;", "setHasSpoiler", "(Ljava/lang/Boolean;)V", "hasSpoiler$delegate", "height", "getHeight", "setHeight", "height$delegate", "Lcom/pengrad/telegrambot/model/request/ParseMode;", "parseMode", "getParseMode", "()Lcom/pengrad/telegrambot/model/request/ParseMode;", "setParseMode", "(Lcom/pengrad/telegrambot/model/request/ParseMode;)V", "parseMode$delegate", "showCaptionAboveMedia", "getShowCaptionAboveMedia", "setShowCaptionAboveMedia", "showCaptionAboveMedia$delegate", "width", "getWidth", "setWidth", "width$delegate", "", "([Lcom/pengrad/telegrambot/model/MessageEntity;)Lcom/pengrad/telegrambot/request/SendAnimation;", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SendAnimation extends AbstractThumbnailedMultipartRequest<SendAnimation> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.e(new q(SendAnimation.class, "caption", "getCaption()Ljava/lang/String;", 0)), c0.e(new q(SendAnimation.class, "parseMode", "getParseMode()Lcom/pengrad/telegrambot/model/request/ParseMode;", 0)), c0.e(new q(SendAnimation.class, "captionEntities", "getCaptionEntities()Ljava/util/List;", 0)), c0.e(new q(SendAnimation.class, "showCaptionAboveMedia", "getShowCaptionAboveMedia()Ljava/lang/Boolean;", 0)), c0.e(new q(SendAnimation.class, "hasSpoiler", "getHasSpoiler()Ljava/lang/Boolean;", 0)), c0.e(new q(SendAnimation.class, TypedValues.TransitionType.S_DURATION, "getDuration()Ljava/lang/Integer;", 0)), c0.e(new q(SendAnimation.class, "width", "getWidth()Ljava/lang/Integer;", 0)), c0.e(new q(SendAnimation.class, "height", "getHeight()Ljava/lang/Integer;", 0))};

    /* JADX INFO: renamed from: caption$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate caption;

    /* JADX INFO: renamed from: captionEntities$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate captionEntities;

    /* JADX INFO: renamed from: duration$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate duration;

    /* JADX INFO: renamed from: hasSpoiler$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate hasSpoiler;

    /* JADX INFO: renamed from: height$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate height;

    /* JADX INFO: renamed from: parseMode$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate parseMode;

    /* JADX INFO: renamed from: showCaptionAboveMedia$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate showCaptionAboveMedia;

    /* JADX INFO: renamed from: width$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate width;

    /* synthetic */ SendAnimation(Long l10, String str, String str2, File file, byte[] bArr, int i10, g gVar) {
        this((i10 & 1) != 0 ? null : l10, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : file, (i10 & 16) != 0 ? null : bArr);
    }

    public final SendAnimation captionEntities(List<? extends MessageEntity> captionEntities) {
        m.f(captionEntities, "captionEntities");
        setCaptionEntities(captionEntities);
        return this;
    }

    private SendAnimation(Long l10, String str, String str2, File file, byte[] bArr) {
        super(l10, str, "animation", str2, file, bArr, ContentTypes.GIF_FILE_NAME, ContentTypes.GIF_MIME_TYPE);
        RequestParameterDelegate requestParameterDelegateOptionalRequestParameter$default = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null);
        k<?>[] kVarArr = $$delegatedProperties;
        this.caption = requestParameterDelegateOptionalRequestParameter$default.provideDelegate(this, kVarArr[0]);
        this.parseMode = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[1]);
        this.captionEntities = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[2]);
        this.showCaptionAboveMedia = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[3]);
        this.hasSpoiler = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[4]);
        this.duration = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[5]);
        this.width = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[6]);
        this.height = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[7]);
    }

    public final SendAnimation caption(String caption) {
        m.f(caption, "caption");
        setCaption(caption);
        return this;
    }

    public final SendAnimation captionEntities(MessageEntity... captionEntities) {
        m.f(captionEntities, "captionEntities");
        setCaptionEntities(j.E0(captionEntities));
        return this;
    }

    public final String getCaption() {
        return (String) this.caption.getValue(this, $$delegatedProperties[0]);
    }

    public final List<MessageEntity> getCaptionEntities() {
        return (List) this.captionEntities.getValue(this, $$delegatedProperties[2]);
    }

    public final Integer getDuration() {
        return (Integer) this.duration.getValue(this, $$delegatedProperties[5]);
    }

    public final Boolean getHasSpoiler() {
        return (Boolean) this.hasSpoiler.getValue(this, $$delegatedProperties[4]);
    }

    public final Integer getHeight() {
        return (Integer) this.height.getValue(this, $$delegatedProperties[7]);
    }

    public final ParseMode getParseMode() {
        return (ParseMode) this.parseMode.getValue(this, $$delegatedProperties[1]);
    }

    public final Boolean getShowCaptionAboveMedia() {
        return (Boolean) this.showCaptionAboveMedia.getValue(this, $$delegatedProperties[3]);
    }

    public final Integer getWidth() {
        return (Integer) this.width.getValue(this, $$delegatedProperties[6]);
    }

    public final SendAnimation parseMode(ParseMode parseMode) {
        m.f(parseMode, "parseMode");
        setParseMode(parseMode);
        return this;
    }

    public final void setCaption(String str) {
        this.caption.setValue(this, $$delegatedProperties[0], str);
    }

    public final void setCaptionEntities(List<? extends MessageEntity> list) {
        this.captionEntities.setValue(this, $$delegatedProperties[2], list);
    }

    public final void setDuration(Integer num) {
        this.duration.setValue(this, $$delegatedProperties[5], num);
    }

    public final void setHasSpoiler(Boolean bool) {
        this.hasSpoiler.setValue(this, $$delegatedProperties[4], bool);
    }

    public final void setHeight(Integer num) {
        this.height.setValue(this, $$delegatedProperties[7], num);
    }

    public final void setParseMode(ParseMode parseMode) {
        this.parseMode.setValue(this, $$delegatedProperties[1], parseMode);
    }

    public final void setShowCaptionAboveMedia(Boolean bool) {
        this.showCaptionAboveMedia.setValue(this, $$delegatedProperties[3], bool);
    }

    public final void setWidth(Integer num) {
        this.width.setValue(this, $$delegatedProperties[6], num);
    }

    public final SendAnimation duration(int duration) {
        setDuration(Integer.valueOf(duration));
        return this;
    }

    public final SendAnimation hasSpoiler(boolean hasSpoiler) {
        setHasSpoiler(Boolean.valueOf(hasSpoiler));
        return this;
    }

    public final SendAnimation height(int height) {
        setHeight(Integer.valueOf(height));
        return this;
    }

    public final SendAnimation showCaptionAboveMedia(boolean showCaptionAboveMedia) {
        setShowCaptionAboveMedia(Boolean.valueOf(showCaptionAboveMedia));
        return this;
    }

    public final SendAnimation width(int width) {
        setWidth(Integer.valueOf(width));
        return this;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendAnimation(long j10, String animationUrl) {
        this(Long.valueOf(j10), null, animationUrl, null, null, 24, null);
        m.f(animationUrl, "animationUrl");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendAnimation(String channelUsername, String animationUrl) {
        this(null, channelUsername, animationUrl, null, null, 24, null);
        m.f(channelUsername, "channelUsername");
        m.f(animationUrl, "animationUrl");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendAnimation(long j10, File animationFile) {
        this(Long.valueOf(j10), null, null, animationFile, null, 20, null);
        m.f(animationFile, "animationFile");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendAnimation(String channelUsername, File animationFile) {
        this(null, channelUsername, null, animationFile, null, 20, null);
        m.f(channelUsername, "channelUsername");
        m.f(animationFile, "animationFile");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendAnimation(long j10, byte[] animationBytes) {
        this(Long.valueOf(j10), null, null, null, animationBytes, 12, null);
        m.f(animationBytes, "animationBytes");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendAnimation(String channelUsername, byte[] animationBytes) {
        this(null, channelUsername, null, null, animationBytes, 12, null);
        m.f(channelUsername, "channelUsername");
        m.f(animationBytes, "animationBytes");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SendAnimation(Object chatId, String animation) {
        m.f(chatId, "chatId");
        m.f(animation, "animation");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        this(number != null ? Long.valueOf(number.longValue()) : null, chatId instanceof String ? (String) chatId : null, animation, null, null, 24, null);
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SendAnimation(Object chatId, File animation) {
        m.f(chatId, "chatId");
        m.f(animation, "animation");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        this(number != null ? Long.valueOf(number.longValue()) : null, chatId instanceof String ? (String) chatId : null, null, animation, null, 20, null);
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SendAnimation(Object chatId, byte[] animation) {
        m.f(chatId, "chatId");
        m.f(animation, "animation");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        this(number != null ? Long.valueOf(number.longValue()) : null, chatId instanceof String ? (String) chatId : null, null, null, animation, 12, null);
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }
}
