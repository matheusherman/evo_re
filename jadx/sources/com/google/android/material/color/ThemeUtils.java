package com.google.android.material.color;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ThemeUtils {
    private ThemeUtils() {
    }

    public static void applyThemeOverlay(@NonNull Context context, @StyleRes int i10) {
        Resources.Theme windowDecorViewTheme;
        context.getTheme().applyStyle(i10, true);
        if ((context instanceof Activity) && (windowDecorViewTheme = getWindowDecorViewTheme((Activity) context)) != null) {
            windowDecorViewTheme.applyStyle(i10, true);
        }
    }

    @Nullable
    private static Resources.Theme getWindowDecorViewTheme(@NonNull Activity activity) {
        View viewPeekDecorView;
        Context context;
        Window window = activity.getWindow();
        if (window != null && (viewPeekDecorView = window.peekDecorView()) != null && (context = viewPeekDecorView.getContext()) != null) {
            return context.getTheme();
        }
        return null;
    }
}
