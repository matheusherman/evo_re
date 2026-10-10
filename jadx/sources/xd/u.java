package xd;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class u implements Serializable {
    private static final long serialVersionUID = 1;
    private final int height;
    private final byte[] value;

    public int a() {
        return this.height;
    }

    public byte[] b() {
        return a0.c(this.value);
    }

    protected u(int i10, byte[] bArr) {
        this.height = i10;
        this.value = bArr;
    }
}
