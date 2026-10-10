package w;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class b implements h.a.InterfaceC0185a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m.d f20005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final m.b f20006b;

    @Override // h.a.InterfaceC0185a
    @NonNull
    public Bitmap a(int i10, int i11, @NonNull Bitmap.Config config) {
        return this.f20005a.e(i10, i11, config);
    }

    @Override // h.a.InterfaceC0185a
    @NonNull
    public int[] b(int i10) {
        m.b bVar = this.f20006b;
        return bVar == null ? new int[i10] : (int[]) bVar.d(i10, int[].class);
    }

    @Override // h.a.InterfaceC0185a
    public void c(@NonNull Bitmap bitmap) {
        this.f20005a.c(bitmap);
    }

    @Override // h.a.InterfaceC0185a
    public void d(@NonNull byte[] bArr) {
        m.b bVar = this.f20006b;
        if (bVar == null) {
            return;
        }
        bVar.put(bArr);
    }

    @Override // h.a.InterfaceC0185a
    @NonNull
    public byte[] e(int i10) {
        m.b bVar = this.f20006b;
        return bVar == null ? new byte[i10] : (byte[]) bVar.d(i10, byte[].class);
    }

    @Override // h.a.InterfaceC0185a
    public void f(@NonNull int[] iArr) {
        m.b bVar = this.f20006b;
        if (bVar == null) {
            return;
        }
        bVar.put(iArr);
    }

    public b(m.d dVar, @Nullable m.b bVar) {
        this.f20005a = dVar;
        this.f20006b = bVar;
    }
}
