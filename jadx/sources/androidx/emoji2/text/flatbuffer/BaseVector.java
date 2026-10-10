package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class BaseVector {

    /* JADX INFO: renamed from: bb, reason: collision with root package name */
    protected ByteBuffer f437bb;
    private int element_size;
    private int length;
    private int vector;

    public void reset() {
        __reset(0, 0, null);
    }

    protected int __element(int i10) {
        return this.vector + (i10 * this.element_size);
    }

    protected void __reset(int i10, int i11, ByteBuffer byteBuffer) {
        this.f437bb = byteBuffer;
        if (byteBuffer != null) {
            this.vector = i10;
            this.length = byteBuffer.getInt(i10 - 4);
            this.element_size = i11;
        } else {
            this.vector = 0;
            this.length = 0;
            this.element_size = 0;
        }
    }

    protected int __vector() {
        return this.vector;
    }

    public int length() {
        return this.length;
    }
}
