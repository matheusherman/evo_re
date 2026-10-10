package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import kotlin.Metadata;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a8\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0086\b¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/graphics/Picture;", "", "width", "height", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "Lr8/z;", "block", "record", "(Landroid/graphics/Picture;IILc9/l;)Landroid/graphics/Picture;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PictureKt {
    public static final Picture record(Picture picture, int i10, int i11, c9.l<? super Canvas, z> lVar) {
        Canvas canvasBeginRecording = picture.beginRecording(i10, i11);
        try {
            lVar.invoke(canvasBeginRecording);
            return picture;
        } finally {
            kotlin.jvm.internal.l.b(1);
            picture.endRecording();
            kotlin.jvm.internal.l.a(1);
        }
    }
}
