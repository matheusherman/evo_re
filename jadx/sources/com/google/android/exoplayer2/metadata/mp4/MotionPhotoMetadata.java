package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import g2.e;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class MotionPhotoMetadata implements Metadata.Entry {
    public static final Parcelable.Creator<MotionPhotoMetadata> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f1569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f1570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f1571e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Parcelable.Creator<MotionPhotoMetadata> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MotionPhotoMetadata createFromParcel(Parcel parcel) {
            return new MotionPhotoMetadata(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MotionPhotoMetadata[] newArray(int i10) {
            return new MotionPhotoMetadata[i10];
        }

        a() {
        }
    }

    /* synthetic */ MotionPhotoMetadata(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && MotionPhotoMetadata.class == obj.getClass()) {
            MotionPhotoMetadata motionPhotoMetadata = (MotionPhotoMetadata) obj;
            if (this.f1567a == motionPhotoMetadata.f1567a && this.f1568b == motionPhotoMetadata.f1568b && this.f1569c == motionPhotoMetadata.f1569c && this.f1570d == motionPhotoMetadata.f1570d && this.f1571e == motionPhotoMetadata.f1571e) {
                return true;
            }
        }
        return false;
    }

    private MotionPhotoMetadata(Parcel parcel) {
        this.f1567a = parcel.readLong();
        this.f1568b = parcel.readLong();
        this.f1569c = parcel.readLong();
        this.f1570d = parcel.readLong();
        this.f1571e = parcel.readLong();
    }

    public int hashCode() {
        return ((((((((527 + e.b(this.f1567a)) * 31) + e.b(this.f1568b)) * 31) + e.b(this.f1569c)) * 31) + e.b(this.f1570d)) * 31) + e.b(this.f1571e);
    }

    public String toString() {
        long j10 = this.f1567a;
        long j11 = this.f1568b;
        long j12 = this.f1569c;
        long j13 = this.f1570d;
        long j14 = this.f1571e;
        StringBuilder sb2 = new StringBuilder(218);
        sb2.append("Motion photo metadata: photoStartPosition=");
        sb2.append(j10);
        sb2.append(", photoSize=");
        sb2.append(j11);
        sb2.append(", photoPresentationTimestampUs=");
        sb2.append(j12);
        sb2.append(", videoStartPosition=");
        sb2.append(j13);
        sb2.append(", videoSize=");
        sb2.append(j14);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f1567a);
        parcel.writeLong(this.f1568b);
        parcel.writeLong(this.f1569c);
        parcel.writeLong(this.f1570d);
        parcel.writeLong(this.f1571e);
    }
}
