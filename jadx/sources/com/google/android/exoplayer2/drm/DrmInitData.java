package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import d1.k;
import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;
import k0.b;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class DrmInitData implements Comparator<SchemeData>, Parcelable {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SchemeData[] f1486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f1488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1489d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1490a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final UUID f1491b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final String f1492c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f1493d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public final byte[] f1494e;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a implements Parcelable.Creator<SchemeData> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SchemeData createFromParcel(Parcel parcel) {
                return new SchemeData(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SchemeData[] newArray(int i10) {
                return new SchemeData[i10];
            }

            a() {
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            return k.a(this.f1492c, schemeData.f1492c) && k.a(this.f1493d, schemeData.f1493d) && k.a(this.f1491b, schemeData.f1491b) && Arrays.equals(this.f1494e, schemeData.f1494e);
        }

        public int hashCode() {
            if (this.f1490a == 0) {
                int iHashCode = this.f1491b.hashCode() * 31;
                String str = this.f1492c;
                this.f1490a = ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f1493d.hashCode()) * 31) + Arrays.hashCode(this.f1494e);
            }
            return this.f1490a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeLong(this.f1491b.getMostSignificantBits());
            parcel.writeLong(this.f1491b.getLeastSignificantBits());
            parcel.writeString(this.f1492c);
            parcel.writeString(this.f1493d);
            parcel.writeByteArray(this.f1494e);
        }

        SchemeData(Parcel parcel) {
            this.f1491b = new UUID(parcel.readLong(), parcel.readLong());
            this.f1492c = parcel.readString();
            this.f1493d = (String) k.b(parcel.readString());
            this.f1494e = parcel.createByteArray();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Parcelable.Creator<DrmInitData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DrmInitData createFromParcel(Parcel parcel) {
            return new DrmInitData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DrmInitData[] newArray(int i10) {
            return new DrmInitData[i10];
        }

        a() {
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && DrmInitData.class == obj.getClass()) {
            DrmInitData drmInitData = (DrmInitData) obj;
            if (k.a(this.f1488c, drmInitData.f1488c) && Arrays.equals(this.f1486a, drmInitData.f1486a)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(SchemeData schemeData, SchemeData schemeData2) {
        UUID uuid = b.f11752a;
        if (uuid.equals(schemeData.f1491b)) {
            return uuid.equals(schemeData2.f1491b) ? 0 : 1;
        }
        return schemeData.f1491b.compareTo(schemeData2.f1491b);
    }

    public int hashCode() {
        if (this.f1487b == 0) {
            String str = this.f1488c;
            this.f1487b = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f1486a);
        }
        return this.f1487b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f1488c);
        parcel.writeTypedArray(this.f1486a, 0);
    }

    DrmInitData(Parcel parcel) {
        this.f1488c = parcel.readString();
        SchemeData[] schemeDataArr = (SchemeData[]) k.b((SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR));
        this.f1486a = schemeDataArr;
        this.f1489d = schemeDataArr.length;
    }
}
