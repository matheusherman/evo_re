package com.google.android.exoplayer2.offline;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class StreamKey implements Comparable<StreamKey>, Parcelable {
    public static final Parcelable.Creator<StreamKey> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public final int f1635d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Parcelable.Creator<StreamKey> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StreamKey createFromParcel(Parcel parcel) {
            return new StreamKey(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public StreamKey[] newArray(int i10) {
            return new StreamKey[i10];
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
        if (obj != null && StreamKey.class == obj.getClass()) {
            StreamKey streamKey = (StreamKey) obj;
            if (this.f1632a == streamKey.f1632a && this.f1633b == streamKey.f1633b && this.f1634c == streamKey.f1634c) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(StreamKey streamKey) {
        int i10 = this.f1632a - streamKey.f1632a;
        if (i10 != 0) {
            return i10;
        }
        int i11 = this.f1633b - streamKey.f1633b;
        return i11 == 0 ? this.f1634c - streamKey.f1634c : i11;
    }

    public int hashCode() {
        return (((this.f1632a * 31) + this.f1633b) * 31) + this.f1634c;
    }

    public String toString() {
        int i10 = this.f1632a;
        int i11 = this.f1633b;
        int i12 = this.f1634c;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append(i10);
        sb2.append(".");
        sb2.append(i11);
        sb2.append(".");
        sb2.append(i12);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f1632a);
        parcel.writeInt(this.f1633b);
        parcel.writeInt(this.f1634c);
    }

    StreamKey(Parcel parcel) {
        this.f1632a = parcel.readInt();
        this.f1633b = parcel.readInt();
        int i10 = parcel.readInt();
        this.f1634c = i10;
        this.f1635d = i10;
    }
}
