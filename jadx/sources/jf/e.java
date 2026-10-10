package jf;

import android.R;
import android.annotation.SuppressLint;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e extends LayerDrawable {
    private void c(c cVar) {
        f fVarA = a(R.id.background);
        f fVarA2 = a(R.id.secondaryProgress);
        f fVarA3 = a(R.id.progress);
        fVarA.e(cVar.j());
        fVarA2.e(cVar.j());
        fVarA3.e(cVar.j());
        if (cVar.e() != null) {
            fVarA.setTintList(cVar.e());
        }
        if (cVar.h() != null) {
            fVarA2.setTintList(cVar.h());
        }
        if (cVar.i() != null) {
            fVarA3.setTintList(cVar.i());
        }
    }

    public void d(int i10) {
        a(R.id.background).e(i10);
        a(R.id.secondaryProgress).e(i10);
        a(R.id.progress).e(i10);
    }

    public e(c cVar) {
        super(cVar.g());
        setId(0, R.id.background);
        setId(1, R.id.secondaryProgress);
        setId(2, R.id.progress);
        c(cVar);
    }

    @SuppressLint({"NewApi"})
    private f a(int i10) {
        String str;
        Drawable drawableFindDrawableByLayerId = findDrawableByLayerId(i10);
        if (i10 != 16908288) {
            if (i10 == 16908301 || i10 == 16908303) {
                ClipDrawable clipDrawable = (ClipDrawable) drawableFindDrawableByLayerId;
                int i11 = Build.VERSION.SDK_INT;
                if (i11 >= 23) {
                    return (f) clipDrawable.getDrawable();
                }
                if (i11 >= 22) {
                    str = "mState";
                } else {
                    str = "mClipState";
                }
                try {
                    Field declaredField = clipDrawable.getClass().getDeclaredField(str);
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(clipDrawable);
                    Field declaredField2 = obj.getClass().getDeclaredField("mDrawable");
                    declaredField2.setAccessible(true);
                    return (f) declaredField2.get(obj);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            throw new RuntimeException();
        }
        return (f) drawableFindDrawableByLayerId;
    }

    public float b() {
        Drawable drawableD = a(R.id.progress).d();
        return drawableD.getIntrinsicWidth() / drawableD.getIntrinsicHeight();
    }
}
