package s;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class i0 implements j.k<Bitmap, Bitmap> {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a implements l.v<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Bitmap f18164a;

        @Override // l.v
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap get() {
            return this.f18164a;
        }

        @Override // l.v
        @NonNull
        public Class<Bitmap> b() {
            return Bitmap.class;
        }

        @Override // l.v
        public int getSize() {
            return e0.l.h(this.f18164a);
        }

        a(@NonNull Bitmap bitmap) {
            this.f18164a = bitmap;
        }

        @Override // l.v
        public void recycle() {
        }
    }

    @Override // j.k
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Bitmap bitmap, @NonNull j.i iVar) {
        return true;
    }

    @Override // j.k
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public l.v<Bitmap> b(@NonNull Bitmap bitmap, int i10, int i11, @NonNull j.i iVar) {
        return new a(bitmap);
    }
}
