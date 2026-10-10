package b0;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class b extends e<Bitmap> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b0.e
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void q(Bitmap bitmap) {
        ((ImageView) this.f618b).setImageBitmap(bitmap);
    }

    public b(ImageView imageView) {
        super(imageView);
    }
}
