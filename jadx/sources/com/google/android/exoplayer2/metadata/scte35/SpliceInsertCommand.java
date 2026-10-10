package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f1585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f1586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f1587f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f1588g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<b> f1589h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f1590i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f1591j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f1592k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f1593l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f1594m;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Parcelable.Creator<SpliceInsertCommand> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SpliceInsertCommand createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SpliceInsertCommand[] newArray(int i10) {
            return new SpliceInsertCommand[i10];
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f1596b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f1597c;

        public static b a(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public void b(Parcel parcel) {
            parcel.writeInt(this.f1595a);
            parcel.writeLong(this.f1596b);
            parcel.writeLong(this.f1597c);
        }

        private b(int i10, long j10, long j11) {
            this.f1595a = i10;
            this.f1596b = j10;
            this.f1597c = j11;
        }
    }

    /* synthetic */ SpliceInsertCommand(Parcel parcel, a aVar) {
        this(parcel);
    }

    private SpliceInsertCommand(Parcel parcel) {
        this.f1582a = parcel.readLong();
        this.f1583b = parcel.readByte() == 1;
        this.f1584c = parcel.readByte() == 1;
        this.f1585d = parcel.readByte() == 1;
        this.f1586e = parcel.readByte() == 1;
        this.f1587f = parcel.readLong();
        this.f1588g = parcel.readLong();
        int i10 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add(b.a(parcel));
        }
        this.f1589h = Collections.unmodifiableList(arrayList);
        this.f1590i = parcel.readByte() == 1;
        this.f1591j = parcel.readLong();
        this.f1592k = parcel.readInt();
        this.f1593l = parcel.readInt();
        this.f1594m = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f1582a);
        parcel.writeByte(this.f1583b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f1584c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f1585d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f1586e ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f1587f);
        parcel.writeLong(this.f1588g);
        int size = this.f1589h.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f1589h.get(i11).b(parcel);
        }
        parcel.writeByte(this.f1590i ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f1591j);
        parcel.writeInt(this.f1592k);
        parcel.writeInt(this.f1593l);
        parcel.writeInt(this.f1594m);
    }
}
