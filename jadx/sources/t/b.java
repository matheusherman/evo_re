package t;

import androidx.annotation.NonNull;
import e0.k;
import l.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class b implements v<byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f18644a;

    @Override // l.v
    @NonNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public byte[] get() {
        return this.f18644a;
    }

    @Override // l.v
    @NonNull
    public Class<byte[]> b() {
        return byte[].class;
    }

    @Override // l.v
    public int getSize() {
        return this.f18644a.length;
    }

    public b(byte[] bArr) {
        this.f18644a = (byte[]) k.d(bArr);
    }

    @Override // l.v
    public void recycle() {
    }
}
