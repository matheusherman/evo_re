package b0;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e0.l;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class c<T> implements i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private a0.e f612c;

    public c() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public c(int i10, int i11) {
        if (l.u(i10, i11)) {
            this.f610a = i10;
            this.f611b = i11;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i10 + " and height: " + i11);
    }

    @Override // b0.i
    public final void i(@Nullable a0.e eVar) {
        this.f612c = eVar;
    }

    @Override // b0.i
    public final void j(@NonNull h hVar) {
        hVar.e(this.f610a, this.f611b);
    }

    @Override // b0.i
    @Nullable
    public final a0.e l() {
        return this.f612c;
    }

    @Override // com.bumptech.glide.manager.m
    public void d() {
    }

    @Override // com.bumptech.glide.manager.m
    public void h() {
    }

    @Override // com.bumptech.glide.manager.m
    public void onStart() {
    }

    @Override // b0.i
    public final void a(@NonNull h hVar) {
    }

    @Override // b0.i
    public void g(@Nullable Drawable drawable) {
    }

    @Override // b0.i
    public void k(@Nullable Drawable drawable) {
    }
}
