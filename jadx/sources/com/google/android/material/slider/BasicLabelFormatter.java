package com.google.android.material.slider;

import androidx.annotation.NonNull;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class BasicLabelFormatter implements LabelFormatter {
    private static final int BILLION = 1000000000;
    private static final int MILLION = 1000000;
    private static final int THOUSAND = 1000;
    private static final long TRILLION = 1000000000000L;

    @Override // com.google.android.material.slider.LabelFormatter
    @NonNull
    public String getFormattedValue(float f10) {
        if (f10 >= 1.0E12f) {
            return String.format(Locale.US, "%.1fT", Float.valueOf(f10 / 1.0E12f));
        }
        if (f10 >= 1.0E9f) {
            return String.format(Locale.US, "%.1fB", Float.valueOf(f10 / 1.0E9f));
        }
        if (f10 >= 1000000.0f) {
            return String.format(Locale.US, "%.1fM", Float.valueOf(f10 / 1000000.0f));
        }
        return f10 >= 1000.0f ? String.format(Locale.US, "%.1fK", Float.valueOf(f10 / 1000.0f)) : String.format(Locale.US, "%.0f", Float.valueOf(f10));
    }
}
