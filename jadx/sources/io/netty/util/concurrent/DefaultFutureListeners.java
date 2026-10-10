package io.netty.util.concurrent;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class DefaultFutureListeners {
    private GenericFutureListener<? extends Future<?>>[] listeners;
    private int size = 2;

    public void add(GenericFutureListener<? extends Future<?>> genericFutureListener) {
        GenericFutureListener<? extends Future<?>>[] genericFutureListenerArr = this.listeners;
        int i10 = this.size;
        if (i10 == genericFutureListenerArr.length) {
            genericFutureListenerArr = (GenericFutureListener[]) Arrays.copyOf(genericFutureListenerArr, i10 << 1);
            this.listeners = genericFutureListenerArr;
        }
        genericFutureListenerArr[i10] = genericFutureListener;
        this.size = i10 + 1;
    }

    public GenericFutureListener<? extends Future<?>>[] listeners() {
        return this.listeners;
    }

    public void remove(GenericFutureListener<? extends Future<?>> genericFutureListener) {
        GenericFutureListener<? extends Future<?>>[] genericFutureListenerArr = this.listeners;
        int i10 = this.size;
        for (int i11 = 0; i11 < i10; i11++) {
            if (genericFutureListenerArr[i11] == genericFutureListener) {
                int i12 = (i10 - i11) - 1;
                if (i12 > 0) {
                    System.arraycopy(genericFutureListenerArr, i11 + 1, genericFutureListenerArr, i11, i12);
                }
                int i13 = i10 - 1;
                genericFutureListenerArr[i13] = null;
                this.size = i13;
                return;
            }
        }
    }

    public int size() {
        return this.size;
    }

    DefaultFutureListeners(GenericFutureListener<? extends Future<?>> genericFutureListener, GenericFutureListener<? extends Future<?>> genericFutureListener2) {
        this.listeners = new GenericFutureListener[]{genericFutureListener, genericFutureListener2};
    }
}
