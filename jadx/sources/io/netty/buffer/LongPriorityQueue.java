package io.netty.buffer;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class LongPriorityQueue {
    private long[] array = new long[9];
    private int size;

    private void lift(int i10) {
        while (i10 > 1) {
            int i11 = i10 >> 1;
            if (!subord(i11, i10)) {
                return;
            }
            swap(i10, i11);
            i10 = i11;
        }
    }

    public void remove(long j10) {
        int i10 = 1;
        while (true) {
            int i11 = this.size;
            if (i10 > i11) {
                return;
            }
            long[] jArr = this.array;
            if (jArr[i10] == j10) {
                this.size = i11 - 1;
                jArr[i10] = jArr[i11];
                lift(i10);
                sink(i10);
                return;
            }
            i10++;
        }
    }

    private void sink(int i10) {
        while (true) {
            int i11 = i10 << 1;
            int i12 = this.size;
            if (i11 > i12) {
                return;
            }
            if (i11 < i12) {
                int i13 = i11 + 1;
                if (subord(i11, i13)) {
                    i11 = i13;
                }
            }
            if (!subord(i10, i11)) {
                return;
            }
            swap(i10, i11);
            i10 = i11;
        }
    }

    private boolean subord(int i10, int i11) {
        long[] jArr = this.array;
        return jArr[i10] > jArr[i11];
    }

    private void swap(int i10, int i11) {
        long[] jArr = this.array;
        long j10 = jArr[i10];
        jArr[i10] = jArr[i11];
        jArr[i11] = j10;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void offer(long j10) {
        if (j10 == -1) {
            throw new IllegalArgumentException("The NO_VALUE (-1) cannot be added to the queue.");
        }
        int i10 = this.size + 1;
        this.size = i10;
        long[] jArr = this.array;
        if (i10 == jArr.length) {
            this.array = Arrays.copyOf(jArr, ((jArr.length - 1) * 2) + 1);
        }
        long[] jArr2 = this.array;
        int i11 = this.size;
        jArr2[i11] = j10;
        lift(i11);
    }

    public long poll() {
        int i10 = this.size;
        if (i10 == 0) {
            return -1L;
        }
        long[] jArr = this.array;
        long j10 = jArr[1];
        jArr[1] = jArr[i10];
        jArr[i10] = 0;
        this.size = i10 - 1;
        sink(1);
        return j10;
    }

    LongPriorityQueue() {
    }
}
