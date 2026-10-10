package a8;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016¨\u0006\u0018"}, d2 = {"La8/a;", "Landroid/graphics/drawable/Drawable;", "bgFolderColor", "imageDrawable", "<init>", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V", "Landroid/graphics/Canvas;", "canvas", "Lr8/z;", "draw", "(Landroid/graphics/Canvas;)V", "", "alpha", "setAlpha", "(I)V", "Landroid/graphics/ColorFilter;", "colorFilter", "setColorFilter", "(Landroid/graphics/ColorFilter;)V", "getOpacity", "()I", "a", "Landroid/graphics/drawable/Drawable;", "b", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Drawable bgFolderColor;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Drawable imageDrawable;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public a(Drawable bgFolderColor, Drawable imageDrawable) {
        m.f(bgFolderColor, "bgFolderColor");
        m.f(imageDrawable, "imageDrawable");
        this.bgFolderColor = bgFolderColor;
        this.imageDrawable = imageDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i10;
        int i11;
        m.f(canvas, "canvas");
        this.bgFolderColor.setBounds(getBounds());
        this.bgFolderColor.draw(canvas);
        int iWidth = getBounds().width();
        int iHeight = getBounds().height();
        int intrinsicWidth = this.imageDrawable.getIntrinsicWidth();
        int intrinsicHeight = this.imageDrawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return;
        }
        float f10 = iWidth;
        float f11 = iHeight;
        float f12 = intrinsicWidth / intrinsicHeight;
        if (f10 / f11 > f12) {
            i11 = (int) (f10 / f12);
            i10 = iWidth;
        } else {
            i10 = (int) (f11 * f12);
            i11 = iHeight;
        }
        int i12 = (iWidth - i10) / 2;
        int i13 = (iHeight - i11) / 2;
        this.imageDrawable.setBounds(i12, i13, i10 + i12, i11 + i13);
        this.imageDrawable.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.imageDrawable.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.imageDrawable.setColorFilter(colorFilter);
    }
}
