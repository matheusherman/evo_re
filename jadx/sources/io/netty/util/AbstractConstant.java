package io.netty.util;

import io.netty.util.AbstractConstant;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class AbstractConstant<T extends AbstractConstant<T>> implements Constant<T> {
    private static final AtomicLong uniqueIdGenerator = new AtomicLong();

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f11366id;
    private final String name;
    private final long uniquifier = uniqueIdGenerator.getAndIncrement();

    @Override // java.lang.Comparable
    public final int compareTo(T t10) {
        if (this == t10) {
            return 0;
        }
        int iHashCode = hashCode() - t10.hashCode();
        if (iHashCode != 0) {
            return iHashCode;
        }
        long j10 = this.uniquifier;
        long j11 = t10.uniquifier;
        if (j10 < j11) {
            return -1;
        }
        if (j10 > j11) {
            return 1;
        }
        throw new Error("failed to compare two different constants");
    }

    public final int id() {
        return this.f11366id;
    }

    public final String name() {
        return this.name;
    }

    protected AbstractConstant(int i10, String str) {
        this.f11366id = i10;
        this.name = str;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        return name();
    }
}
