package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import d1.k;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class PictureFrame implements Metadata.Entry {
    public static final Parcelable.Creator<PictureFrame> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f1511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f1512g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f1513h;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Parcelable.Creator<PictureFrame> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PictureFrame createFromParcel(Parcel parcel) {
            return new PictureFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public PictureFrame[] newArray(int i10) {
            return new PictureFrame[i10];
        }

        a() {
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && PictureFrame.class == obj.getClass()) {
            PictureFrame pictureFrame = (PictureFrame) obj;
            if (this.f1506a == pictureFrame.f1506a && this.f1507b.equals(pictureFrame.f1507b) && this.f1508c.equals(pictureFrame.f1508c) && this.f1509d == pictureFrame.f1509d && this.f1510e == pictureFrame.f1510e && this.f1511f == pictureFrame.f1511f && this.f1512g == pictureFrame.f1512g && Arrays.equals(this.f1513h, pictureFrame.f1513h)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((527 + this.f1506a) * 31) + this.f1507b.hashCode()) * 31) + this.f1508c.hashCode()) * 31) + this.f1509d) * 31) + this.f1510e) * 31) + this.f1511f) * 31) + this.f1512g) * 31) + Arrays.hashCode(this.f1513h);
    }

    public String toString() {
        String str = this.f1507b;
        String str2 = this.f1508c;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(str2).length());
        sb2.append("Picture: mimeType=");
        sb2.append(str);
        sb2.append(", description=");
        sb2.append(str2);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f1506a);
        parcel.writeString(this.f1507b);
        parcel.writeString(this.f1508c);
        parcel.writeInt(this.f1509d);
        parcel.writeInt(this.f1510e);
        parcel.writeInt(this.f1511f);
        parcel.writeInt(this.f1512g);
        parcel.writeByteArray(this.f1513h);
    }

    PictureFrame(Parcel parcel) {
        this.f1506a = parcel.readInt();
        this.f1507b = (String) k.b(parcel.readString());
        this.f1508c = (String) k.b(parcel.readString());
        this.f1509d = parcel.readInt();
        this.f1510e = parcel.readInt();
        this.f1511f = parcel.readInt();
        this.f1512g = parcel.readInt();
        this.f1513h = (byte[]) k.b(parcel.createByteArray());
    }
}
