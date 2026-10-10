package com.pengrad.telegrambot.request;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegate;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegateKt;
import i9.k;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.q;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\bB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u0010B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0002\u0010\u0013B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0002\u0010\u0014B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u000e¢\u0006\u0002\u0010\u0015BC\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0018R/\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u00188F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR/\u0010 \u001a\u0004\u0018\u00010\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u00188F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u001f\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001d¨\u0006$"}, d2 = {"Lcom/pengrad/telegrambot/request/SendVideoNote;", "Lcom/pengrad/telegrambot/request/AbstractThumbnailedMultipartRequest;", "chatId", "", "videoNoteUrl", "", "(JLjava/lang/String;)V", "channelUsername", "(Ljava/lang/String;Ljava/lang/String;)V", "videoNoteFile", "Ljava/io/File;", "(JLjava/io/File;)V", "(Ljava/lang/String;Ljava/io/File;)V", "videoNoteBytes", "", "(J[B)V", "(Ljava/lang/String;[B)V", "", "videoNote", "(Ljava/lang/Object;Ljava/lang/String;)V", "(Ljava/lang/Object;Ljava/io/File;)V", "(Ljava/lang/Object;[B)V", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;[B)V", "<set-?>", "", TypedValues.TransitionType.S_DURATION, "getDuration", "()Ljava/lang/Integer;", "setDuration", "(Ljava/lang/Integer;)V", "duration$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "length", "getLength", "setLength", "length$delegate", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SendVideoNote extends AbstractThumbnailedMultipartRequest<SendVideoNote> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.e(new q(SendVideoNote.class, TypedValues.TransitionType.S_DURATION, "getDuration()Ljava/lang/Integer;", 0)), c0.e(new q(SendVideoNote.class, "length", "getLength()Ljava/lang/Integer;", 0))};

    /* JADX INFO: renamed from: duration$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate duration;

    /* JADX INFO: renamed from: length$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate length;

    /* synthetic */ SendVideoNote(Long l10, String str, String str2, File file, byte[] bArr, int i10, g gVar) {
        this((i10 & 1) != 0 ? null : l10, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : file, (i10 & 16) != 0 ? null : bArr);
    }

    private SendVideoNote(Long l10, String str, String str2, File file, byte[] bArr) {
        super(l10, str, "video_note", str2, file, bArr, ContentTypes.VIDEO_FILE_NAME, "video/mp4");
        RequestParameterDelegate requestParameterDelegateOptionalRequestParameter$default = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null);
        k<?>[] kVarArr = $$delegatedProperties;
        this.duration = requestParameterDelegateOptionalRequestParameter$default.provideDelegate(this, kVarArr[0]);
        this.length = RequestParameterDelegateKt.optionalRequestParameter$default(null, null, null, 7, null).provideDelegate(this, kVarArr[1]);
    }

    public final Integer getDuration() {
        return (Integer) this.duration.getValue(this, $$delegatedProperties[0]);
    }

    public final Integer getLength() {
        return (Integer) this.length.getValue(this, $$delegatedProperties[1]);
    }

    public final void setDuration(Integer num) {
        this.duration.setValue(this, $$delegatedProperties[0], num);
    }

    public final void setLength(Integer num) {
        this.length.setValue(this, $$delegatedProperties[1], num);
    }

    public final SendVideoNote duration(int duration) {
        setDuration(Integer.valueOf(duration));
        return this;
    }

    public final SendVideoNote length(int length) {
        setLength(Integer.valueOf(length));
        return this;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendVideoNote(long j10, String videoNoteUrl) {
        this(Long.valueOf(j10), null, videoNoteUrl, null, null, 24, null);
        m.f(videoNoteUrl, "videoNoteUrl");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendVideoNote(String channelUsername, String videoNoteUrl) {
        this(null, channelUsername, videoNoteUrl, null, null, 24, null);
        m.f(channelUsername, "channelUsername");
        m.f(videoNoteUrl, "videoNoteUrl");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendVideoNote(long j10, File videoNoteFile) {
        this(Long.valueOf(j10), null, null, videoNoteFile, null, 20, null);
        m.f(videoNoteFile, "videoNoteFile");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendVideoNote(String channelUsername, File videoNoteFile) {
        this(null, channelUsername, null, videoNoteFile, null, 20, null);
        m.f(channelUsername, "channelUsername");
        m.f(videoNoteFile, "videoNoteFile");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendVideoNote(long j10, byte[] videoNoteBytes) {
        this(Long.valueOf(j10), null, null, null, videoNoteBytes, 12, null);
        m.f(videoNoteBytes, "videoNoteBytes");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendVideoNote(String channelUsername, byte[] videoNoteBytes) {
        this(null, channelUsername, null, null, videoNoteBytes, 12, null);
        m.f(channelUsername, "channelUsername");
        m.f(videoNoteBytes, "videoNoteBytes");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SendVideoNote(Object chatId, String videoNote) {
        m.f(chatId, "chatId");
        m.f(videoNote, "videoNote");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        this(number != null ? Long.valueOf(number.longValue()) : null, chatId instanceof String ? (String) chatId : null, videoNote, null, null, 24, null);
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SendVideoNote(Object chatId, File videoNote) {
        m.f(chatId, "chatId");
        m.f(videoNote, "videoNote");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        this(number != null ? Long.valueOf(number.longValue()) : null, chatId instanceof String ? (String) chatId : null, null, videoNote, null, 20, null);
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SendVideoNote(Object chatId, byte[] videoNote) {
        m.f(chatId, "chatId");
        m.f(videoNote, "videoNote");
        Number number = chatId instanceof Number ? (Number) chatId : null;
        this(number != null ? Long.valueOf(number.longValue()) : null, chatId instanceof String ? (String) chatId : null, null, null, videoNote, 12, null);
        if (getChatId() == null && getChannelUsername() == null) {
            throw new IllegalArgumentException("chatId parameter must be either Long or String");
        }
    }
}
