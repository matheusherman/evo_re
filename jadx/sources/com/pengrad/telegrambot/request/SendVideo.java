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
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\bB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u0010B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0002\u0010\u0013B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0002\u0010\u0014B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u000e¢\u0006\u0002\u0010\u0015BC\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0005J\u001f\u0010!\u001a\u00020\u00002\u0012\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0`\"\u00020 ¢\u0006\u0002\u0010aJ\u0014\u0010!\u001a\u00020\u00002\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u000e\u0010'\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u000eJ\u000e\u0010-\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\nJ\u000e\u00103\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0005J\u000e\u00108\u001a\u00020\u00002\u0006\u00108\u001a\u000207J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010?\u001a\u00020>J\u000e\u0010E\u001a\u00020\u00002\u0006\u0010E\u001a\u000207J\u000e\u0010J\u001a\u00020\u00002\u0006\u0010J\u001a\u00020IJ\u000e\u0010P\u001a\u00020\u00002\u0006\u0010P\u001a\u00020>J\u000e\u0010T\u001a\u00020\u00002\u0006\u0010T\u001a\u000207J\u000e\u0010X\u001a\u00020\u00002\u0006\u0010X\u001a\u00020>J\u000e\u0010\\\u001a\u00020\u00002\u0006\u0010\\\u001a\u000207R/\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR;\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010\u001e\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R/\u0010'\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010\u001e\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R/\u0010-\u001a\u0004\u0018\u00010\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b2\u0010\u001e\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R/\u00103\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b6\u0010\u001e\u001a\u0004\b4\u0010\u001a\"\u0004\b5\u0010\u001cR/\u00108\u001a\u0004\u0018\u0001072\b\u0010\u0017\u001a\u0004\u0018\u0001078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b=\u0010\u001e\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R/\u0010?\u001a\u0004\u0018\u00010>2\b\u0010\u0017\u001a\u0004\u0018\u00010>8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bD\u0010\u001e\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR/\u0010E\u001a\u0004\u0018\u0001072\b\u0010\u0017\u001a\u0004\u0018\u0001078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bH\u0010\u001e\u001a\u0004\bF\u0010:\"\u0004\bG\u0010<R/\u0010J\u001a\u0004\u0018\u00010I2\b\u0010\u0017\u001a\u0004\u0018\u00010I8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bO\u0010\u001e\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR/\u0010P\u001a\u0004\u0018\u00010>2\b\u0010\u0017\u001a\u0004\u0018\u00010>8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bS\u0010\u001e\u001a\u0004\bQ\u0010A\"\u0004\bR\u0010CR/\u0010T\u001a\u0004\u0018\u0001072\b\u0010\u0017\u001a\u0004\u0018\u0001078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bW\u0010\u001e\u001a\u0004\bU\u0010:\"\u0004\bV\u0010<R/\u0010X\u001a\u0004\u0018\u00010>2\b\u0010\u0017\u001a\u0004\u0018\u00010>8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b[\u0010\u001e\u001a\u0004\bY\u0010A\"\u0004\bZ\u0010CR/\u0010\\\u001a\u0004\u0018\u0001072\b\u0010\u0017\u001a\u0004\u0018\u0001078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b_\u0010\u001e\u001a\u0004\b]\u0010:\"\u0004\b^\u0010<¨\u0006b"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVideo;", "Lcom/pengrad/telegrambot/request/AbstractThumbnailedMultipartRequest;", "chatId", "", "videoUrl", "", "(JLjava/lang/String;)V", "channelUsername", "(Ljava/lang/String;Ljava/lang/String;)V", "videoFile", "Ljava/io/File;", "(JLjava/io/File;)V", "(Ljava/lang/String;Ljava/io/File;)V", "videoBytes", "", "(J[B)V", "(Ljava/lang/String;[B)V", "", "video", "(Ljava/lang/Object;Ljava/lang/String;)V", "(Ljava/lang/Object;Ljava/io/File;)V", "(Ljava/lang/Object;[B)V", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;[B)V", "<set-?>", "caption", "getCaption", "()Ljava/lang/String;", "setCaption", "(Ljava/lang/String;)V", "caption$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "", "Lcom/pengrad/telegrambot/model/MessageEntity;", "captionEntities", "getCaptionEntities", "()Ljava/util/List;", "setCaptionEntities", "(Ljava/util/List;)V", "captionEntities$delegate", "coverBytes", "getCoverBytes", "()[B", "setCoverBytes", "([B)V", "coverBytes$delegate", "coverFile", "getCoverFile", "()Ljava/io/File;", "setCoverFile", "(Ljava/io/File;)V", "coverFile$delegate", "coverUrl", "getCoverUrl", "setCoverUrl", "coverUrl$delegate", "", TypedValues.TransitionType.S_DURATION, "getDuration", "()Ljava/lang/Integer;", "setDuration", "(Ljava/lang/Integer;)V", "duration$delegate", "", "hasSpoiler", "getHasSpoiler", "()Ljava/lang/Boolean;", "setHasSpoiler", "(Ljava/lang/Boolean;)V", "hasSpoiler$delegate", "height", "getHeight", "setHeight", "height$delegate", "Lcom/pengrad/telegrambot/model/request/ParseMode;", "parseMode", "getParseMode", "()Lcom/pengrad/telegrambot/model/request/ParseMode;", "setParseMode", "(Lcom/pengrad/telegrambot/model/request/ParseMode;)V", "parseMode$delegate", "showCaptionAboveMedia", "getShowCaptionAboveMedia", "setShowCaptionAboveMedia", "showCaptionAboveMedia$delegate", "startTimestamp", "getStartTimestamp", "setStartTimestamp", "startTimestamp$delegate", "supportsStreaming", "getSupportsStreaming", "setSupportsStreaming", "supportsStreaming$delegate", "width", "getWidth", "setWidth", "width$delegate", "", "([Lcom/pengrad/telegrambot/model/MessageEntity;)Lcom/pengrad/telegrambot/request/SendVideo;", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SendVideo extends AbstractThumbnailedMultipartRequest<SendVideo> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.e(new q(SendVideo.class, TypedValues.TransitionType.S_DURATION, "getDuration()Ljava/lang/Integer;", 0)), c0.e(new q(SendVideo.class, "width", "getWidth()Ljava/lang/Integer;", 0)), c0.e(new q(SendVideo.class, "height", "getHeight()Ljava/lang/Integer;", 0)), c0.e(new q(SendVideo.class, "coverUrl", "getCoverUrl()Ljava/lang/String;", 0)), c0.e(new q(SendVideo.class, "coverFile", "getCoverFile()Ljava/io/File;", 0)), c0.e(new q(SendVideo.class, "coverBytes", "getCoverBytes()[B", 0)), c0.e(new q(SendVideo.class, "startTimestamp", "getStartTimestamp()Ljava/lang/Integer;", 0)), c0.e(new q(SendVideo.class, "caption", "getCaption()Ljava/lang/String;", 0)), c0.e(new q(SendVideo.class, "parseMode", "getParseMode()Lcom/pengrad/telegrambot/model/request/ParseMode;", 0)), c0.e(new q(SendVideo.class, "captionEntities", "getCaptionEntities()Ljava/util/List;", 0)), c0.e(new q(SendVideo.class, "showCaptionAboveMedia", "getShowCaptionAboveMedia()Ljava/lang/Boolean;", 0)), c0.e(new q(SendVideo.class, "hasSpoiler", "getHasSpoiler()Ljava/lang/Boolean;", 0)), c0.e(new q(SendVideo.class, "supportsStreaming", "getSupportsStreaming()Ljava/lang/Boolean;", 0))};

    /* JADX INFO: renamed from: caption$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate caption;

    /* JADX INFO: renamed from: captionEntities$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate captionEntities;

    /* JADX INFO: renamed from: coverBytes$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate coverBytes;

    /* JADX INFO: renamed from: coverFile$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate coverFile;

    /* JADX INFO: renamed from: coverUrl$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate coverUrl;

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

    /* JADX INFO: renamed from: startTimestamp$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate startTimestamp;

    /* JADX INFO: renamed from: supportsStreaming$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate supportsStreaming;

    /* JADX INFO: renamed from: width$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate width;

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendVideo$caption$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVideo;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendVideo;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass5 extends o implements l<SendVideo, z> {
        final /* synthetic */ String $caption;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendVideo sendVideo) {
            invoke2(sendVideo);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(String str) {
            super(1);
            this.$caption = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendVideo applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setCaption(this.$caption);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendVideo$captionEntities$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVideo;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendVideo;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06505 extends o implements l<SendVideo, z> {
        final /* synthetic */ List<MessageEntity> $captionEntities;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendVideo sendVideo) {
            invoke2(sendVideo);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C06505(List<? extends MessageEntity> list) {
            super(1);
            this.$captionEntities = list;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendVideo applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setCaptionEntities(this.$captionEntities);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendVideo$captionEntities$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVideo;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendVideo;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass6 extends o implements l<SendVideo, z> {
        final /* synthetic */ MessageEntity[] $captionEntities;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendVideo sendVideo) {
            invoke2(sendVideo);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(MessageEntity[] messageEntityArr) {
            super(1);
            this.$captionEntities = messageEntityArr;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendVideo applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setCaptionEntities(j.E0(this.$captionEntities));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendVideo$coverBytes$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVideo;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendVideo;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06515 extends o implements l<SendVideo, z> {
        final /* synthetic */ byte[] $coverBytes;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendVideo sendVideo) {
            invoke2(sendVideo);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06515(byte[] bArr) {
            super(1);
            this.$coverBytes = bArr;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendVideo applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setCoverBytes(this.$coverBytes);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendVideo$coverFile$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVideo;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendVideo;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06525 extends o implements l<SendVideo, z> {
        final /* synthetic */ File $coverFile;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendVideo sendVideo) {
            invoke2(sendVideo);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06525(File file) {
            super(1);
            this.$coverFile = file;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendVideo applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setCoverFile(this.$coverFile);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendVideo$coverUrl$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVideo;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendVideo;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06535 extends o implements l<SendVideo, z> {
        final /* synthetic */ String $coverUrl;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendVideo sendVideo) {
            invoke2(sendVideo);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06535(String str) {
            super(1);
            this.$coverUrl = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendVideo applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setCoverUrl(this.$coverUrl);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendVideo$duration$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVideo;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendVideo;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06545 extends o implements l<SendVideo, z> {
        final /* synthetic */ int $duration;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendVideo sendVideo) {
            invoke2(sendVideo);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06545(int i10) {
            super(1);
            this.$duration = i10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendVideo applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setDuration(Integer.valueOf(this.$duration));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendVideo$hasSpoiler$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVideo;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendVideo;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06555 extends o implements l<SendVideo, z> {
        final /* synthetic */ boolean $hasSpoiler;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendVideo sendVideo) {
            invoke2(sendVideo);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06555(boolean z10) {
            super(1);
            this.$hasSpoiler = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendVideo applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setHasSpoiler(Boolean.valueOf(this.$hasSpoiler));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendVideo$height$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVideo;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendVideo;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06565 extends o implements l<SendVideo, z> {
        final /* synthetic */ int $height;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendVideo sendVideo) {
            invoke2(sendVideo);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06565(int i10) {
            super(1);
            this.$height = i10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendVideo applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setHeight(Integer.valueOf(this.$height));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendVideo$parseMode$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVideo;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendVideo;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06575 extends o implements l<SendVideo, z> {
        final /* synthetic */ ParseMode $parseMode;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendVideo sendVideo) {
            invoke2(sendVideo);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06575(ParseMode parseMode) {
            super(1);
            this.$parseMode = parseMode;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendVideo applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setParseMode(this.$parseMode);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendVideo$showCaptionAboveMedia$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVideo;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendVideo;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06585 extends o implements l<SendVideo, z> {
        final /* synthetic */ boolean $showCaptionAboveMedia;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendVideo sendVideo) {
            invoke2(sendVideo);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06585(boolean z10) {
            super(1);
            this.$showCaptionAboveMedia = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendVideo applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setShowCaptionAboveMedia(Boolean.valueOf(this.$showCaptionAboveMedia));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendVideo$startTimestamp$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVideo;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendVideo;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06595 extends o implements l<SendVideo, z> {
        final /* synthetic */ int $startTimestamp;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendVideo sendVideo) {
            invoke2(sendVideo);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06595(int i10) {
            super(1);
            this.$startTimestamp = i10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendVideo applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setStartTimestamp(Integer.valueOf(this.$startTimestamp));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendVideo$supportsStreaming$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVideo;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendVideo;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06605 extends o implements l<SendVideo, z> {
        final /* synthetic */ boolean $supportsStreaming;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendVideo sendVideo) {
            invoke2(sendVideo);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06605(boolean z10) {
            super(1);
            this.$supportsStreaming = z10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendVideo applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setSupportsStreaming(Boolean.valueOf(this.$supportsStreaming));
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.SendVideo$width$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVideo;", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/SendVideo;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C06615 extends o implements l<SendVideo, z> {
        final /* synthetic */ int $width;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(SendVideo sendVideo) {
            invoke2(sendVideo);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06615(int i10) {
            super(1);
            this.$width = i10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SendVideo applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setWidth(Integer.valueOf(this.$width));
        }
    }

    /* synthetic */ SendVideo(Long l10, String str, String str2, File file, byte[] bArr, int i10, g gVar) {
        this((i10 & 1) != 0 ? null : l10, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : file, (i10 & 16) != 0 ? null : bArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendVideo captionEntities(List<? extends MessageEntity> captionEntities) {
        m.f(captionEntities, "captionEntities");
        return (SendVideo) applySelf(new C06505(captionEntities));
    }

    private SendVideo(Long l10, String str, String str2, File file, byte[] bArr) {
        super(l10, str, "video", str2, file, bArr, ContentTypes.VIDEO_FILE_NAME, "video/mp4");
        RequestParameterDelegate requestParameterDelegateOptionalRequestParameter$default = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null);
        k<?>[] kVarArr = $$delegatedProperties;
        this.duration = requestParameterDelegateOptionalRequestParameter$default.provideDelegate(this, kVarArr[0]);
        this.width = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[1]);
        this.height = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[2]);
        this.coverUrl = RequestParameterDelegateKt.optionalRequestParameter$default(null, "cover", null, 5, null).provideDelegate(this, kVarArr[3]);
        this.coverFile = RequestParameterDelegateKt.optionalRequestParameter$default(null, "cover", null, 5, null).provideDelegate(this, kVarArr[4]);
        this.coverBytes = RequestParameterDelegateKt.optionalRequestParameter$default(null, "cover", null, 5, null).provideDelegate(this, kVarArr[5]);
        this.startTimestamp = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[6]);
        this.caption = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[7]);
        this.parseMode = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[8]);
        this.captionEntities = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[9]);
        this.showCaptionAboveMedia = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[10]);
        this.hasSpoiler = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[11]);
        this.supportsStreaming = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[12]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendVideo caption(String caption) {
        m.f(caption, "caption");
        return (SendVideo) applySelf(new AnonymousClass5(caption));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendVideo captionEntities(MessageEntity... captionEntities) {
        m.f(captionEntities, "captionEntities");
        return (SendVideo) applySelf(new AnonymousClass6(captionEntities));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendVideo coverBytes(byte[] coverBytes) {
        m.f(coverBytes, "coverBytes");
        return (SendVideo) applySelf(new C06515(coverBytes));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendVideo coverFile(File coverFile) {
        m.f(coverFile, "coverFile");
        return (SendVideo) applySelf(new C06525(coverFile));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendVideo coverUrl(String coverUrl) {
        m.f(coverUrl, "coverUrl");
        return (SendVideo) applySelf(new C06535(coverUrl));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendVideo duration(int duration) {
        return (SendVideo) applySelf(new C06545(duration));
    }

    public final String getCaption() {
        return (String) this.caption.getValue(this, $$delegatedProperties[7]);
    }

    public final List<MessageEntity> getCaptionEntities() {
        return (List) this.captionEntities.getValue(this, $$delegatedProperties[9]);
    }

    public final byte[] getCoverBytes() {
        return (byte[]) this.coverBytes.getValue(this, $$delegatedProperties[5]);
    }

    public final File getCoverFile() {
        return (File) this.coverFile.getValue(this, $$delegatedProperties[4]);
    }

    public final String getCoverUrl() {
        return (String) this.coverUrl.getValue(this, $$delegatedProperties[3]);
    }

    public final Integer getDuration() {
        return (Integer) this.duration.getValue(this, $$delegatedProperties[0]);
    }

    public final Boolean getHasSpoiler() {
        return (Boolean) this.hasSpoiler.getValue(this, $$delegatedProperties[11]);
    }

    public final Integer getHeight() {
        return (Integer) this.height.getValue(this, $$delegatedProperties[2]);
    }

    public final ParseMode getParseMode() {
        return (ParseMode) this.parseMode.getValue(this, $$delegatedProperties[8]);
    }

    public final Boolean getShowCaptionAboveMedia() {
        return (Boolean) this.showCaptionAboveMedia.getValue(this, $$delegatedProperties[10]);
    }

    public final Integer getStartTimestamp() {
        return (Integer) this.startTimestamp.getValue(this, $$delegatedProperties[6]);
    }

    public final Boolean getSupportsStreaming() {
        return (Boolean) this.supportsStreaming.getValue(this, $$delegatedProperties[12]);
    }

    public final Integer getWidth() {
        return (Integer) this.width.getValue(this, $$delegatedProperties[1]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendVideo hasSpoiler(boolean hasSpoiler) {
        return (SendVideo) applySelf(new C06555(hasSpoiler));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendVideo height(int height) {
        return (SendVideo) applySelf(new C06565(height));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendVideo parseMode(ParseMode parseMode) {
        m.f(parseMode, "parseMode");
        return (SendVideo) applySelf(new C06575(parseMode));
    }

    public final void setCaption(String str) {
        this.caption.setValue(this, $$delegatedProperties[7], str);
    }

    public final void setCaptionEntities(List<? extends MessageEntity> list) {
        this.captionEntities.setValue(this, $$delegatedProperties[9], list);
    }

    public final void setCoverBytes(byte[] bArr) {
        this.coverBytes.setValue(this, $$delegatedProperties[5], bArr);
    }

    public final void setCoverFile(File file) {
        this.coverFile.setValue(this, $$delegatedProperties[4], file);
    }

    public final void setCoverUrl(String str) {
        this.coverUrl.setValue(this, $$delegatedProperties[3], str);
    }

    public final void setDuration(Integer num) {
        this.duration.setValue(this, $$delegatedProperties[0], num);
    }

    public final void setHasSpoiler(Boolean bool) {
        this.hasSpoiler.setValue(this, $$delegatedProperties[11], bool);
    }

    public final void setHeight(Integer num) {
        this.height.setValue(this, $$delegatedProperties[2], num);
    }

    public final void setParseMode(ParseMode parseMode) {
        this.parseMode.setValue(this, $$delegatedProperties[8], parseMode);
    }

    public final void setShowCaptionAboveMedia(Boolean bool) {
        this.showCaptionAboveMedia.setValue(this, $$delegatedProperties[10], bool);
    }

    public final void setStartTimestamp(Integer num) {
        this.startTimestamp.setValue(this, $$delegatedProperties[6], num);
    }

    public final void setSupportsStreaming(Boolean bool) {
        this.supportsStreaming.setValue(this, $$delegatedProperties[12], bool);
    }

    public final void setWidth(Integer num) {
        this.width.setValue(this, $$delegatedProperties[1], num);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendVideo showCaptionAboveMedia(boolean showCaptionAboveMedia) {
        return (SendVideo) applySelf(new C06585(showCaptionAboveMedia));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendVideo startTimestamp(int startTimestamp) {
        return (SendVideo) applySelf(new C06595(startTimestamp));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendVideo supportsStreaming(boolean supportsStreaming) {
        return (SendVideo) applySelf(new C06605(supportsStreaming));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SendVideo width(int width) {
        return (SendVideo) applySelf(new C06615(width));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendVideo(long j10, String videoUrl) {
        this(Long.valueOf(j10), null, videoUrl, null, null, 24, null);
        m.f(videoUrl, "videoUrl");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendVideo(String channelUsername, String videoUrl) {
        this(null, channelUsername, videoUrl, null, null, 24, null);
        m.f(channelUsername, "channelUsername");
        m.f(videoUrl, "videoUrl");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendVideo(long j10, File videoFile) {
        this(Long.valueOf(j10), null, null, videoFile, null, 20, null);
        m.f(videoFile, "videoFile");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendVideo(String channelUsername, File videoFile) {
        this(null, channelUsername, null, videoFile, null, 20, null);
        m.f(channelUsername, "channelUsername");
        m.f(videoFile, "videoFile");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendVideo(long j10, byte[] videoBytes) {
        this(Long.valueOf(j10), null, null, null, videoBytes, 12, null);
        m.f(videoBytes, "videoBytes");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendVideo(String channelUsername, byte[] videoBytes) {
        this(null, channelUsername, null, null, videoBytes, 12, null);
        m.f(channelUsername, "channelUsername");
        m.f(videoBytes, "videoBytes");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SendVideo(Object chatId, String video) {
        m.f(chatId, "chatId");
        m.f(video, "video");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        this(number != null ? Long.valueOf(number.longValue()) : null, chatId instanceof String ? (String) chatId : null, video, null, null, 24, null);
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SendVideo(Object chatId, File video) {
        m.f(chatId, "chatId");
        m.f(video, "video");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        this(number != null ? Long.valueOf(number.longValue()) : null, chatId instanceof String ? (String) chatId : null, null, video, null, 20, null);
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SendVideo(Object chatId, byte[] video) {
        m.f(chatId, "chatId");
        m.f(video, "video");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        this(number != null ? Long.valueOf(number.longValue()) : null, chatId instanceof String ? (String) chatId : null, null, null, video, 12, null);
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }
}
