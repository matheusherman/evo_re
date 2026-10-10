package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f1598a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Parcelable.Creator<SpliceScheduleCommand> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SpliceScheduleCommand createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SpliceScheduleCommand[] newArray(int i10) {
            return new SpliceScheduleCommand[i10];
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f1600b;

        /* JADX INFO: Access modifiers changed from: private */
        public static b c(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(Parcel parcel) {
            parcel.writeInt(this.f1599a);
            parcel.writeLong(this.f1600b);
        }

        private b(int i10, long j10) {
            this.f1599a = i10;
            this.f1600b = j10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f1601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f1602b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f1603c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f1604d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f1605e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<b> f1606f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f1607g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f1608h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f1609i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f1610j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f1611k;

        /* JADX INFO: Access modifiers changed from: private */
        public static c c(Parcel parcel) {
            return new c(parcel);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(Parcel parcel) {
            parcel.writeLong(this.f1601a);
            parcel.writeByte(this.f1602b ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f1603c ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f1604d ? (byte) 1 : (byte) 0);
            int size = this.f1606f.size();
            parcel.writeInt(size);
            for (int i10 = 0; i10 < size; i10++) {
                this.f1606f.get(i10).d(parcel);
            }
            parcel.writeLong(this.f1605e);
            parcel.writeByte(this.f1607g ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f1608h);
            parcel.writeInt(this.f1609i);
            parcel.writeInt(this.f1610j);
            parcel.writeInt(this.f1611k);
        }

        private c(Parcel parcel) {
            boolean z10;
            boolean z11;
            boolean z12;
            this.f1601a = parcel.readLong();
            if (parcel.readByte() == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f1602b = z10;
            if (parcel.readByte() == 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.f1603c = z11;
            if (parcel.readByte() == 1) {
                z12 = true;
            } else {
                z12 = false;
            }
            this.f1604d = z12;
            int i10 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                arrayList.add(b.c(parcel));
            }
            this.f1606f = Collections.unmodifiableList(arrayList);
            this.f1605e = parcel.readLong();
            this.f1607g = parcel.readByte() == 1;
            this.f1608h = parcel.readLong();
            this.f1609i = parcel.readInt();
            this.f1610j = parcel.readInt();
            this.f1611k = parcel.readInt();
        }
    }

    /* synthetic */ SpliceScheduleCommand(Parcel parcel, a aVar) {
        this(parcel);
    }

    private SpliceScheduleCommand(Parcel parcel) {
        int i10 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add(c.c(parcel));
        }
        this.f1598a = Collections.unmodifiableList(arrayList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int size = this.f1598a.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f1598a.get(i11).d(parcel);
        }
    }
}
