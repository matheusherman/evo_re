package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import d1.k;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class ChapterFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterFrame> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f1533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f1534f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Id3Frame[] f1535g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Parcelable.Creator<ChapterFrame> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ChapterFrame createFromParcel(Parcel parcel) {
            return new ChapterFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ChapterFrame[] newArray(int i10) {
            return new ChapterFrame[i10];
        }

        a() {
        }
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ChapterFrame.class == obj.getClass()) {
            ChapterFrame chapterFrame = (ChapterFrame) obj;
            if (this.f1531c == chapterFrame.f1531c && this.f1532d == chapterFrame.f1532d && this.f1533e == chapterFrame.f1533e && this.f1534f == chapterFrame.f1534f && k.a(this.f1530b, chapterFrame.f1530b) && Arrays.equals(this.f1535g, chapterFrame.f1535g)) {
                return true;
            }
        }
        return false;
    }

    ChapterFrame(Parcel parcel) {
        super("CHAP");
        this.f1530b = (String) k.b(parcel.readString());
        this.f1531c = parcel.readInt();
        this.f1532d = parcel.readInt();
        this.f1533e = parcel.readLong();
        this.f1534f = parcel.readLong();
        int i10 = parcel.readInt();
        this.f1535g = new Id3Frame[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            this.f1535g[i11] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public int hashCode() {
        int i10 = (((((((527 + this.f1531c) * 31) + this.f1532d) * 31) + ((int) this.f1533e)) * 31) + ((int) this.f1534f)) * 31;
        String str = this.f1530b;
        return i10 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f1530b);
        parcel.writeInt(this.f1531c);
        parcel.writeInt(this.f1532d);
        parcel.writeLong(this.f1533e);
        parcel.writeLong(this.f1534f);
        parcel.writeInt(this.f1535g.length);
        for (Id3Frame id3Frame : this.f1535g) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }
}
