package com.youth.banner.util;

import android.content.res.Resources;
import android.graphics.Outline;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class BannerUtils {
    public static int getRealPosition(boolean z10, int i10, int i11) {
        if (!z10) {
            return i10;
        }
        if (i10 == 0) {
            return i11 - 1;
        }
        if (i10 == i11 + 1) {
            return 0;
        }
        return i10 - 1;
    }

    @RequiresApi(api = 21)
    public static void setBannerRound(View view, final float f10) {
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.youth.banner.util.BannerUtils.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), f10);
            }
        });
        view.setClipToOutline(true);
    }

    public static int dp2px(float f10) {
        return (int) TypedValue.applyDimension(1, f10, Resources.getSystem().getDisplayMetrics());
    }

    public static View getView(@NonNull ViewGroup viewGroup, @LayoutRes int i10) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(i10, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = viewInflate.getLayoutParams();
        if (layoutParams.height == -1 && layoutParams.width == -1) {
            return viewInflate;
        }
        layoutParams.height = -1;
        layoutParams.width = -1;
        viewInflate.setLayoutParams(layoutParams);
        return viewInflate;
    }
}
