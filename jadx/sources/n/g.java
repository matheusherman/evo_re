package n;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import l.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class g extends e0.h<j.f, v<?>> implements h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private h.a f15825e;

    @Override // n.h
    @SuppressLint({"InlinedApi"})
    public void a(int i10) {
        if (i10 >= 40) {
            b();
        } else if (i10 >= 20 || i10 == 15) {
            m(h() / 2);
        }
    }

    @Override // n.h
    public void e(@NonNull h.a aVar) {
        this.f15825e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e0.h
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int i(@Nullable v<?> vVar) {
        return vVar == null ? super.i(null) : vVar.getSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e0.h
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void j(@NonNull j.f fVar, @Nullable v<?> vVar) {
        h.a aVar = this.f15825e;
        if (aVar == null || vVar == null) {
            return;
        }
        aVar.b(vVar);
    }

    public g(long j10) {
        super(j10);
    }

    @Override // n.h
    @Nullable
    public /* bridge */ /* synthetic */ v c(@NonNull j.f fVar, @Nullable v vVar) {
        return (v) super.k(fVar, vVar);
    }

    @Override // n.h
    @Nullable
    public /* bridge */ /* synthetic */ v d(@NonNull j.f fVar) {
        return (v) super.l(fVar);
    }
}
