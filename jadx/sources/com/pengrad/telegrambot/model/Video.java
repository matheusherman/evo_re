package com.pengrad.telegrambot.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fHÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008e\u0001\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010*J\n\u0010\b\u001a\u00060+j\u0002`,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0006HÖ\u0001J\n\u0010\u0007\u001a\u00060+j\u0002`,J\t\u00101\u001a\u00020\u0003HÖ\u0001J\n\u0010\u0005\u001a\u00060+j\u0002`,R\u001b\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0016R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0016R\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0007¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0010\u0010\u0017R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0016R\u0017\u0010\r\u001a\u0004\u0018\u00010\u00068\u0007¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\r\u0010\u001aR\u0015\u0010\t\u001a\u0004\u0018\u00010\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015¨\u00062"}, d2 = {"Lcom/pengrad/telegrambot/model/Video;", "", "fileId", "", "fileUniqueId", "width", "", "height", TypedValues.TransitionType.S_DURATION, "thumbnail", "Lcom/pengrad/telegrambot/model/PhotoSize;", "cover", "", "startTimestamp", "fileName", "mimeType", "fileSize", "", "(Ljava/lang/String;Ljava/lang/String;IIILcom/pengrad/telegrambot/model/PhotoSize;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "()Ljava/util/List;", "getDuration", "()I", "()Ljava/lang/String;", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Lcom/pengrad/telegrambot/model/PhotoSize;", "getWidth", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;IIILcom/pengrad/telegrambot/model/PhotoSize;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/pengrad/telegrambot/model/Video;", "Ljava/lang/Integer;", "Lcom/pengrad/telegrambot/utility/kotlin/JavaInteger;", "equals", "", TransactionPartnerType.OTHER, "hashCode", "toString", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class Video {
    private final List<PhotoSize> cover;
    private final int duration;
    private final String fileId;
    private final String fileName;
    private final Long fileSize;
    private final String fileUniqueId;
    private final int height;
    private final String mimeType;
    private final Integer startTimestamp;
    private final PhotoSize thumbnail;
    private final int width;

    /* JADX WARN: Multi-variable type inference failed */
    public Video(String fileId, String fileUniqueId, int i10, int i11, int i12, PhotoSize photoSize, List<? extends PhotoSize> list, Integer num, String str, String str2, Long l10) {
        m.f(fileId, "fileId");
        m.f(fileUniqueId, "fileUniqueId");
        this.fileId = fileId;
        this.fileUniqueId = fileUniqueId;
        this.width = i10;
        this.height = i11;
        this.duration = i12;
        this.thumbnail = photoSize;
        this.cover = list;
        this.startTimestamp = num;
        this.fileName = str;
        this.mimeType = str2;
        this.fileSize = l10;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Video)) {
            return false;
        }
        Video video = (Video) other;
        return m.a(this.fileId, video.fileId) && m.a(this.fileUniqueId, video.fileUniqueId) && this.width == video.width && this.height == video.height && this.duration == video.duration && m.a(this.thumbnail, video.thumbnail) && m.a(this.cover, video.cover) && m.a(this.startTimestamp, video.startTimestamp) && m.a(this.fileName, video.fileName) && m.a(this.mimeType, video.mimeType) && m.a(this.fileSize, video.fileSize);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Video copy$default(Video video, String str, String str2, int i10, int i11, int i12, PhotoSize photoSize, List list, Integer num, String str3, String str4, Long l10, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = video.fileId;
        }
        if ((i13 & 2) != 0) {
            str2 = video.fileUniqueId;
        }
        if ((i13 & 4) != 0) {
            i10 = video.width;
        }
        if ((i13 & 8) != 0) {
            i11 = video.height;
        }
        if ((i13 & 16) != 0) {
            i12 = video.duration;
        }
        if ((i13 & 32) != 0) {
            photoSize = video.thumbnail;
        }
        if ((i13 & 64) != 0) {
            list = video.cover;
        }
        if ((i13 & 128) != 0) {
            num = video.startTimestamp;
        }
        if ((i13 & 256) != 0) {
            str3 = video.fileName;
        }
        if ((i13 & 512) != 0) {
            str4 = video.mimeType;
        }
        if ((i13 & 1024) != 0) {
            l10 = video.fileSize;
        }
        String str5 = str4;
        Long l11 = l10;
        Integer num2 = num;
        String str6 = str3;
        PhotoSize photoSize2 = photoSize;
        List list2 = list;
        int i14 = i12;
        int i15 = i10;
        return video.copy(str, str2, i15, i11, i14, photoSize2, list2, num2, str6, str5, l11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Long getFileSize() {
        return this.fileSize;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFileUniqueId() {
        return this.fileUniqueId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final PhotoSize getThumbnail() {
        return this.thumbnail;
    }

    public final List<PhotoSize> component7() {
        return this.cover;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getStartTimestamp() {
        return this.startTimestamp;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    public final Video copy(String fileId, String fileUniqueId, int width, int height, int duration, PhotoSize thumbnail, List<? extends PhotoSize> cover, Integer startTimestamp, String fileName, String mimeType, Long fileSize) {
        m.f(fileId, "fileId");
        m.f(fileUniqueId, "fileUniqueId");
        return new Video(fileId, fileUniqueId, width, height, duration, thumbnail, cover, startTimestamp, fileName, mimeType, fileSize);
    }

    public final List<PhotoSize> cover() {
        return this.cover;
    }

    public final Integer duration() {
        return Integer.valueOf(this.duration);
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

    public final /* synthetic */ int getDuration() {
        return this.duration;
    }

    public final /* synthetic */ int getHeight() {
        return this.height;
    }

    public final /* synthetic */ int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.fileId.hashCode() * 31) + this.fileUniqueId.hashCode()) * 31) + this.width) * 31) + this.height) * 31) + this.duration) * 31;
        PhotoSize photoSize = this.thumbnail;
        int iHashCode2 = (iHashCode + (photoSize == null ? 0 : photoSize.hashCode())) * 31;
        List<PhotoSize> list = this.cover;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num = this.startTimestamp;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.fileName;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.mimeType;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l10 = this.fileSize;
        return iHashCode6 + (l10 != null ? l10.hashCode() : 0);
    }

    public final Integer height() {
        return Integer.valueOf(this.height);
    }

    public final String mimeType() {
        return this.mimeType;
    }

    public final Integer startTimestamp() {
        return this.startTimestamp;
    }

    public final PhotoSize thumbnail() {
        return this.thumbnail;
    }

    public String toString() {
        return "Video(fileId=" + this.fileId + ", fileUniqueId=" + this.fileUniqueId + ", width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", thumbnail=" + this.thumbnail + ", cover=" + this.cover + ", startTimestamp=" + this.startTimestamp + ", fileName=" + this.fileName + ", mimeType=" + this.mimeType + ", fileSize=" + this.fileSize + ')';
    }

    public final Integer width() {
        return Integer.valueOf(this.width);
    }

    public /* synthetic */ Video(String str, String str2, int i10, int i11, int i12, PhotoSize photoSize, List list, Integer num, String str3, String str4, Long l10, int i13, g gVar) {
        this(str, str2, i10, i11, i12, (i13 & 32) != 0 ? null : photoSize, (i13 & 64) != 0 ? null : list, (i13 & 128) != 0 ? null : num, (i13 & 256) != 0 ? null : str3, (i13 & 512) != 0 ? null : str4, (i13 & 1024) != 0 ? null : l10);
    }
}
