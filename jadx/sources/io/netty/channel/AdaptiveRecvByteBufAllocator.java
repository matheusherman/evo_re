package io.netty.channel;

import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class AdaptiveRecvByteBufAllocator extends DefaultMaxMessagesRecvByteBufAllocator {

    @Deprecated
    public static final AdaptiveRecvByteBufAllocator DEFAULT;
    private static final int[] SIZE_TABLE;
    private final int initial;
    private final int maxIndex;
    private final int minIndex;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class HandleImpl extends DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle {
        private boolean decreaseNow;
        private int index;
        private final int maxIndex;
        private final int minIndex;
        private int nextReceiveBufferSize;

        HandleImpl(int i10, int i11, int i12) {
            super();
            this.minIndex = i10;
            this.maxIndex = i11;
            this.index = AdaptiveRecvByteBufAllocator.getSizeTableIndex(i12);
            this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
        }

        @Override // io.netty.channel.RecvByteBufAllocator.Handle
        public int guess() {
            return this.nextReceiveBufferSize;
        }

        private void record(int i10) {
            if (i10 <= AdaptiveRecvByteBufAllocator.SIZE_TABLE[Math.max(0, this.index - 1)]) {
                if (this.decreaseNow) {
                    this.index = Math.max(this.index - 1, this.minIndex);
                    this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
                    this.decreaseNow = false;
                    return;
                }
                this.decreaseNow = true;
                return;
            }
            if (i10 >= this.nextReceiveBufferSize) {
                this.index = Math.min(this.index + 4, this.maxIndex);
                this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
                this.decreaseNow = false;
            }
        }

        @Override // io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle, io.netty.channel.RecvByteBufAllocator.Handle
        public void lastBytesRead(int i10) {
            if (i10 == attemptedBytesRead()) {
                record(i10);
            }
            super.lastBytesRead(i10);
        }

        @Override // io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle, io.netty.channel.RecvByteBufAllocator.Handle
        public void readComplete() {
            record(totalBytesRead());
        }
    }

    public AdaptiveRecvByteBufAllocator() {
        this(64, 2048, 65536);
    }

    static {
        int i10;
        ArrayList arrayList = new ArrayList();
        int i11 = 16;
        while (true) {
            if (i11 >= 512) {
                break;
            }
            arrayList.add(Integer.valueOf(i11));
            i11 += 16;
        }
        for (i10 = 512; i10 > 0; i10 <<= 1) {
            arrayList.add(Integer.valueOf(i10));
        }
        SIZE_TABLE = new int[arrayList.size()];
        int i12 = 0;
        while (true) {
            int[] iArr = SIZE_TABLE;
            if (i12 >= iArr.length) {
                DEFAULT = new AdaptiveRecvByteBufAllocator();
                return;
            } else {
                iArr[i12] = ((Integer) arrayList.get(i12)).intValue();
                i12++;
            }
        }
    }

    public AdaptiveRecvByteBufAllocator(int i10, int i11, int i12) {
        ObjectUtil.checkPositive(i10, "minimum");
        if (i11 < i10) {
            throw new IllegalArgumentException("initial: " + i11);
        }
        if (i12 < i11) {
            throw new IllegalArgumentException("maximum: " + i12);
        }
        int sizeTableIndex = getSizeTableIndex(i10);
        int[] iArr = SIZE_TABLE;
        if (iArr[sizeTableIndex] < i10) {
            this.minIndex = sizeTableIndex + 1;
        } else {
            this.minIndex = sizeTableIndex;
        }
        int sizeTableIndex2 = getSizeTableIndex(i12);
        if (iArr[sizeTableIndex2] > i12) {
            this.maxIndex = sizeTableIndex2 - 1;
        } else {
            this.maxIndex = sizeTableIndex2;
        }
        this.initial = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getSizeTableIndex(int i10) {
        int length = SIZE_TABLE.length - 1;
        int i11 = 0;
        while (length >= i11) {
            if (length == i11) {
                return length;
            }
            int i12 = (i11 + length) >>> 1;
            int[] iArr = SIZE_TABLE;
            int i13 = iArr[i12];
            int i14 = i12 + 1;
            if (i10 > iArr[i14]) {
                i11 = i14;
            } else {
                if (i10 >= i13) {
                    return i10 == i13 ? i12 : i14;
                }
                length = i12 - 1;
            }
        }
        return i11;
    }

    @Override // io.netty.channel.RecvByteBufAllocator
    public RecvByteBufAllocator.Handle newHandle() {
        return new HandleImpl(this.minIndex, this.maxIndex, this.initial);
    }
}
