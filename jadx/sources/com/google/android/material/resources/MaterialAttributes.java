package com.google.android.material.resources;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialAttributes {
    public static int resolveOrThrow(@NonNull Context context, @AttrRes int i10, @NonNull String str) {
        return resolveTypedValueOrThrow(context, i10, str).data;
    }

    @NonNull
    public static TypedValue resolveTypedValueOrThrow(@NonNull View view, @AttrRes int i10) {
        return resolveTypedValueOrThrow(view.getContext(), i10, view.getClass().getCanonicalName());
    }

    @Nullable
    public static TypedValue resolve(@NonNull Context context, @AttrRes int i10) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i10, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    @Px
    public static int resolveMinimumAccessibleTouchTarget(@NonNull Context context) {
        return resolveDimension(context, R.attr.minTouchTargetSize, R.dimen.mtrl_min_touch_target_size);
    }

    public static int resolveOrThrow(@NonNull View view, @AttrRes int i10) {
        return resolveTypedValueOrThrow(view, i10).data;
    }

    public static boolean resolveBoolean(@NonNull Context context, @AttrRes int i10, boolean z10) {
        TypedValue typedValueResolve = resolve(context, i10);
        if (typedValueResolve != null && typedValueResolve.type == 18) {
            if (typedValueResolve.data != 0) {
                return true;
            }
            return false;
        }
        return z10;
    }

    public static boolean resolveBooleanOrThrow(@NonNull Context context, @AttrRes int i10, @NonNull String str) {
        if (resolveOrThrow(context, i10, str) != 0) {
            return true;
        }
        return false;
    }

    @Px
    public static int resolveDimension(@NonNull Context context, @AttrRes int i10, @DimenRes int i11) {
        float dimension;
        TypedValue typedValueResolve = resolve(context, i10);
        if (typedValueResolve != null && typedValueResolve.type == 5) {
            dimension = typedValueResolve.getDimension(context.getResources().getDisplayMetrics());
        } else {
            dimension = context.getResources().getDimension(i11);
        }
        return (int) dimension;
    }

    public static int resolveInteger(@NonNull Context context, @AttrRes int i10, int i11) {
        TypedValue typedValueResolve = resolve(context, i10);
        if (typedValueResolve != null && typedValueResolve.type == 16) {
            return typedValueResolve.data;
        }
        return i11;
    }

    @NonNull
    public static TypedValue resolveTypedValueOrThrow(@NonNull Context context, @AttrRes int i10, @NonNull String str) {
        TypedValue typedValueResolve = resolve(context, i10);
        if (typedValueResolve != null) {
            return typedValueResolve;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i10)));
    }
}
