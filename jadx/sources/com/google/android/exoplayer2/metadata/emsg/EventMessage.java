package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import d1.k;
import java.util.Arrays;
import k0.e;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class EventMessage implements Metadata.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f1502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f1503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f1504e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final e f1498g = new e.b().F("application/id3").E();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final e f1499h = new e.b().F("application/x-scte35").E();
    public static final Parcelable.Creator<EventMessage> CREATOR = new a();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Parcelable.Creator<EventMessage> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public EventMessage createFromParcel(Parcel parcel) {
            return new EventMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public EventMessage[] newArray(int i10) {
            return new EventMessage[i10];
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
        if (obj != null && EventMessage.class == obj.getClass()) {
            EventMessage eventMessage = (EventMessage) obj;
            if (this.f1502c == eventMessage.f1502c && this.f1503d == eventMessage.f1503d && k.a(this.f1500a, eventMessage.f1500a) && k.a(this.f1501b, eventMessage.f1501b) && Arrays.equals(this.f1504e, eventMessage.f1504e)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f1505f == 0) {
            String str = this.f1500a;
            int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f1501b;
            int iHashCode2 = str2 != null ? str2.hashCode() : 0;
            long j10 = this.f1502c;
            int i10 = (((iHashCode + iHashCode2) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31;
            long j11 = this.f1503d;
            this.f1505f = ((i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + Arrays.hashCode(this.f1504e);
        }
        return this.f1505f;
    }

    public String toString() {
        String str = this.f1500a;
        long j10 = this.f1503d;
        long j11 = this.f1502c;
        String str2 = this.f1501b;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 79 + String.valueOf(str2).length());
        sb2.append("EMSG: scheme=");
        sb2.append(str);
        sb2.append(", id=");
        sb2.append(j10);
        sb2.append(", durationMs=");
        sb2.append(j11);
        sb2.append(", value=");
        sb2.append(str2);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f1500a);
        parcel.writeString(this.f1501b);
        parcel.writeLong(this.f1502c);
        parcel.writeLong(this.f1503d);
        parcel.writeByteArray(this.f1504e);
    }

    EventMessage(Parcel parcel) {
        this.f1500a = (String) k.b(parcel.readString());
        this.f1501b = (String) k.b(parcel.readString());
        this.f1502c = parcel.readLong();
        this.f1503d = parcel.readLong();
        this.f1504e = (byte[]) k.b(parcel.createByteArray());
    }
}
