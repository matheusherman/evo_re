package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.common.base.k;
import com.google.common.collect.l;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class SlowMotionData implements Metadata.Entry {
    public static final Parcelable.Creator<SlowMotionData> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Segment> f1572a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class Segment implements Parcelable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f1574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f1575b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f1576c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Comparator<Segment> f1573d = new Comparator() { // from class: o0.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                SlowMotionData.Segment segment = (SlowMotionData.Segment) obj;
                SlowMotionData.Segment segment2 = (SlowMotionData.Segment) obj2;
                return l.g().e(segment.f1574a, segment2.f1574a).e(segment.f1575b, segment2.f1575b).d(segment.f1576c, segment2.f1576c).f();
            }
        };
        public static final Parcelable.Creator<Segment> CREATOR = new a();

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a implements Parcelable.Creator<Segment> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Segment[] newArray(int i10) {
                return new Segment[i10];
            }

            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Segment createFromParcel(Parcel parcel) {
                return new Segment(parcel.readLong(), parcel.readLong(), parcel.readInt());
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
            if (obj != null && Segment.class == obj.getClass()) {
                Segment segment = (Segment) obj;
                if (this.f1574a == segment.f1574a && this.f1575b == segment.f1575b && this.f1576c == segment.f1576c) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return k.b(Long.valueOf(this.f1574a), Long.valueOf(this.f1575b), Integer.valueOf(this.f1576c));
        }

        public String toString() {
            return d1.k.f("Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", Long.valueOf(this.f1574a), Long.valueOf(this.f1575b), Integer.valueOf(this.f1576c));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeLong(this.f1574a);
            parcel.writeLong(this.f1575b);
            parcel.writeInt(this.f1576c);
        }

        public Segment(long j10, long j11, int i10) {
            boolean z10;
            if (j10 < j11) {
                z10 = true;
            } else {
                z10 = false;
            }
            d1.a.a(z10);
            this.f1574a = j10;
            this.f1575b = j11;
            this.f1576c = i10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Parcelable.Creator<SlowMotionData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SlowMotionData createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, Segment.class.getClassLoader());
            return new SlowMotionData(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SlowMotionData[] newArray(int i10) {
            return new SlowMotionData[i10];
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
        if (obj == null || SlowMotionData.class != obj.getClass()) {
            return false;
        }
        return this.f1572a.equals(((SlowMotionData) obj).f1572a);
    }

    public int hashCode() {
        return this.f1572a.hashCode();
    }

    public String toString() {
        String strValueOf = String.valueOf(this.f1572a);
        StringBuilder sb2 = new StringBuilder(strValueOf.length() + 21);
        sb2.append("SlowMotion: segments=");
        sb2.append(strValueOf);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeList(this.f1572a);
    }

    public SlowMotionData(List<Segment> list) {
        this.f1572a = list;
        d1.a.a(!a(list));
    }

    private static boolean a(List<Segment> list) {
        if (list.isEmpty()) {
            return false;
        }
        long j10 = list.get(0).f1575b;
        for (int i10 = 1; i10 < list.size(); i10++) {
            if (list.get(i10).f1574a < j10) {
                return true;
            }
            j10 = list.get(i10).f1575b;
        }
        return false;
    }
}
