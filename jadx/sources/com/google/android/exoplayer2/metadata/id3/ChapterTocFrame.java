package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import d1.k;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class ChapterTocFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterTocFrame> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f1538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f1539e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Id3Frame[] f1540f;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Parcelable.Creator<ChapterTocFrame> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ChapterTocFrame createFromParcel(Parcel parcel) {
            return new ChapterTocFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ChapterTocFrame[] newArray(int i10) {
            return new ChapterTocFrame[i10];
        }

        a() {
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ChapterTocFrame.class == obj.getClass()) {
            ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
            if (this.f1537c == chapterTocFrame.f1537c && this.f1538d == chapterTocFrame.f1538d && k.a(this.f1536b, chapterTocFrame.f1536b) && Arrays.equals(this.f1539e, chapterTocFrame.f1539e) && Arrays.equals(this.f1540f, chapterTocFrame.f1540f)) {
                return true;
            }
        }
        return false;
    }

    ChapterTocFrame(Parcel parcel) {
        super("CTOC");
        this.f1536b = (String) k.b(parcel.readString());
        this.f1537c = parcel.readByte() != 0;
        this.f1538d = parcel.readByte() != 0;
        this.f1539e = (String[]) k.b(parcel.createStringArray());
        int i10 = parcel.readInt();
        this.f1540f = new Id3Frame[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            this.f1540f[i11] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public int hashCode() {
        int i10 = (((527 + (this.f1537c ? 1 : 0)) * 31) + (this.f1538d ? 1 : 0)) * 31;
        String str = this.f1536b;
        return i10 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f1536b);
        parcel.writeByte(this.f1537c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f1538d ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.f1539e);
        parcel.writeInt(this.f1540f.length);
        for (Id3Frame id3Frame : this.f1540f) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }
}
