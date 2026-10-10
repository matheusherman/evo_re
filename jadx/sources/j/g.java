package j;

import android.content.Context;
import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import l.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class g<T> implements m<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Collection<? extends m<T>> f11520b;

    @Override // j.f
    public void a(@NonNull MessageDigest messageDigest) {
        Iterator<? extends m<T>> it = this.f11520b.iterator();
        while (it.hasNext()) {
            it.next().a(messageDigest);
        }
    }

    @Override // j.m
    @NonNull
    public v<T> b(@NonNull Context context, @NonNull v<T> vVar, int i10, int i11) {
        Iterator<? extends m<T>> it = this.f11520b.iterator();
        v<T> vVar2 = vVar;
        while (it.hasNext()) {
            v<T> vVarB = it.next().b(context, vVar2, i10, i11);
            if (vVar2 != null && !vVar2.equals(vVar) && !vVar2.equals(vVarB)) {
                vVar2.recycle();
            }
            vVar2 = vVarB;
        }
        return vVar2;
    }

    @Override // j.f
    public boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.f11520b.equals(((g) obj).f11520b);
        }
        return false;
    }

    @Override // j.f
    public int hashCode() {
        return this.f11520b.hashCode();
    }

    @SafeVarargs
    public g(@NonNull m<T>... mVarArr) {
        if (mVarArr.length != 0) {
            this.f11520b = Arrays.asList(mVarArr);
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }
}
