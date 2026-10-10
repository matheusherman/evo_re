package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import d1.k;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class MlltFrame extends Id3Frame {
    public static final Parcelable.Creator<MlltFrame> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1554d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f1555e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f1556f;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Parcelable.Creator<MlltFrame> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MlltFrame createFromParcel(Parcel parcel) {
            return new MlltFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MlltFrame[] newArray(int i10) {
            return new MlltFrame[i10];
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
        if (obj != null && MlltFrame.class == obj.getClass()) {
            MlltFrame mlltFrame = (MlltFrame) obj;
            if (this.f1552b == mlltFrame.f1552b && this.f1553c == mlltFrame.f1553c && this.f1554d == mlltFrame.f1554d && Arrays.equals(this.f1555e, mlltFrame.f1555e) && Arrays.equals(this.f1556f, mlltFrame.f1556f)) {
                return true;
            }
        }
        return false;
    }

    MlltFrame(Parcel parcel) {
        super("MLLT");
        this.f1552b = parcel.readInt();
        this.f1553c = parcel.readInt();
        this.f1554d = parcel.readInt();
        this.f1555e = (int[]) k.b(parcel.createIntArray());
        this.f1556f = (int[]) k.b(parcel.createIntArray());
    }

    public int hashCode() {
        return ((((((((527 + this.f1552b) * 31) + this.f1553c) * 31) + this.f1554d) * 31) + Arrays.hashCode(this.f1555e)) * 31) + Arrays.hashCode(this.f1556f);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f1552b);
        parcel.writeInt(this.f1553c);
        parcel.writeInt(this.f1554d);
        parcel.writeIntArray(this.f1555e);
        parcel.writeIntArray(this.f1556f);
    }
}
