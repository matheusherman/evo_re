package androidx.databinding.adapters;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import androidx.databinding.BindingConversion;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class Converters {
    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int i10) {
        return new ColorDrawable(i10);
    }

    @BindingConversion
    public static ColorStateList convertColorToColorStateList(int i10) {
        return ColorStateList.valueOf(i10);
    }
}
