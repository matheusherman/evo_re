package com.pengrad.telegrambot.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jz\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0006HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0005\u0010\u0010R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0012R\u0015\u0010\t\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0012R\u0017\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u000b\u0010\u0013R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0012R\u0015\u0010\n\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0012R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0015R\u0015\u0010\b\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012¨\u0006&"}, d2 = {"Lcom/pengrad/telegrambot/model/Audio;", "", "fileId", "", "fileUniqueId", TypedValues.TransitionType.S_DURATION, "", "performer", "title", "fileName", "mimeType", "fileSize", "", "thumbnail", "Lcom/pengrad/telegrambot/model/PhotoSize;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/pengrad/telegrambot/model/PhotoSize;)V", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Ljava/lang/String;", "()Ljava/lang/Long;", "Ljava/lang/Long;", "()Lcom/pengrad/telegrambot/model/PhotoSize;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/pengrad/telegrambot/model/PhotoSize;)Lcom/pengrad/telegrambot/model/Audio;", "equals", "", TransactionPartnerType.OTHER, "hashCode", "toString", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class Audio {
    private final Integer duration;
    private final String fileId;
    private final String fileName;
    private final Long fileSize;
    private final String fileUniqueId;
    private final String mimeType;
    private final String performer;
    private final PhotoSize thumbnail;
    private final String title;

    public Audio() {
        this(null, null, null, null, null, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Audio)) {
            return false;
        }
        Audio audio = (Audio) other;
        return m.a(this.fileId, audio.fileId) && m.a(this.fileUniqueId, audio.fileUniqueId) && m.a(this.duration, audio.duration) && m.a(this.performer, audio.performer) && m.a(this.title, audio.title) && m.a(this.fileName, audio.fileName) && m.a(this.mimeType, audio.mimeType) && m.a(this.fileSize, audio.fileSize) && m.a(this.thumbnail, audio.thumbnail);
    }

    public Audio(String str, String str2, Integer num, String str3, String str4, String str5, String str6, Long l10, PhotoSize photoSize) {
        this.fileId = str;
        this.fileUniqueId = str2;
        this.duration = num;
        this.performer = str3;
        this.title = str4;
        this.fileName = str5;
        this.mimeType = str6;
        this.fileSize = l10;
        this.thumbnail = photoSize;
    }

    public static /* synthetic */ Audio copy$default(Audio audio, String str, String str2, Integer num, String str3, String str4, String str5, String str6, Long l10, PhotoSize photoSize, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = audio.fileId;
        }
        if ((i10 & 2) != 0) {
            str2 = audio.fileUniqueId;
        }
        if ((i10 & 4) != 0) {
            num = audio.duration;
        }
        if ((i10 & 8) != 0) {
            str3 = audio.performer;
        }
        if ((i10 & 16) != 0) {
            str4 = audio.title;
        }
        if ((i10 & 32) != 0) {
            str5 = audio.fileName;
        }
        if ((i10 & 64) != 0) {
            str6 = audio.mimeType;
        }
        if ((i10 & 128) != 0) {
            l10 = audio.fileSize;
        }
        if ((i10 & 256) != 0) {
            photoSize = audio.thumbnail;
        }
        Long l11 = l10;
        PhotoSize photoSize2 = photoSize;
        String str7 = str5;
        String str8 = str6;
        String str9 = str4;
        Integer num2 = num;
        return audio.copy(str, str2, num2, str3, str9, str7, str8, l11, photoSize2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFileUniqueId() {
        return this.fileUniqueId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPerformer() {
        return this.performer;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Long getFileSize() {
        return this.fileSize;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final PhotoSize getThumbnail() {
        return this.thumbnail;
    }

    public final Audio copy(String fileId, String fileUniqueId, Integer duration, String performer, String title, String fileName, String mimeType, Long fileSize, PhotoSize thumbnail) {
        return new Audio(fileId, fileUniqueId, duration, performer, title, fileName, mimeType, fileSize, thumbnail);
    }

    public final Integer duration() {
        return this.duration;
    }

    public final String fileId() {
        return this.fileId;
    }

    public final String fileName() {
        return this.fileName;
    }

    public final Long fileSize() {
        return this.fileSize;
    }

    public final String fileUniqueId() {
        return this.fileUniqueId;
    }

    public int hashCode() {
        String str = this.fileId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.fileUniqueId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.duration;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.performer;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.title;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.fileName;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.mimeType;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Long l10 = this.fileSize;
        int iHashCode8 = (iHashCode7 + (l10 == null ? 0 : l10.hashCode())) * 31;
        PhotoSize photoSize = this.thumbnail;
        return iHashCode8 + (photoSize != null ? photoSize.hashCode() : 0);
    }

    public final String mimeType() {
        return this.mimeType;
    }

    public final String performer() {
        return this.performer;
    }

    public final PhotoSize thumbnail() {
        return this.thumbnail;
    }

    public final String title() {
        return this.title;
    }

    public String toString() {
        return "Audio(fileId=" + this.fileId + ", fileUniqueId=" + this.fileUniqueId + ", duration=" + this.duration + ", performer=" + this.performer + ", title=" + this.title + ", fileName=" + this.fileName + ", mimeType=" + this.mimeType + ", fileSize=" + this.fileSize + ", thumbnail=" + this.thumbnail + ')';
    }

    public /* synthetic */ Audio(String str, String str2, Integer num, String str3, String str4, String str5, String str6, Long l10, PhotoSize photoSize, int i10, g gVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : num, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? null : str5, (i10 & 64) != 0 ? null : str6, (i10 & 128) != 0 ? null : l10, (i10 & 256) != 0 ? null : photoSize);
    }
}
