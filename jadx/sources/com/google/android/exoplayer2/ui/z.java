package com.google.android.exoplayer2.ui;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class z {
    public static /* synthetic */ boolean a(Object obj) {
        return (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan);
    }

    public static /* synthetic */ boolean b(Object obj) {
        return !(obj instanceof z0.a);
    }

    public static void c(y0.a.b bVar) {
        bVar.b();
        if (bVar.c() instanceof Spanned) {
            if (!(bVar.c() instanceof Spannable)) {
                bVar.h(SpannableString.valueOf(bVar.c()));
            }
            e((Spannable) d1.a.b(bVar.c()), new com.google.common.base.n() { // from class: com.google.android.exoplayer2.ui.x
                @Override // com.google.common.base.n
                public final boolean apply(Object obj) {
                    return z.b(obj);
                }
            });
        }
        d(bVar);
    }

    public static void d(y0.a.b bVar) {
        bVar.j(-3.4028235E38f, Integer.MIN_VALUE);
        if (bVar.c() instanceof Spanned) {
            if (!(bVar.c() instanceof Spannable)) {
                bVar.h(SpannableString.valueOf(bVar.c()));
            }
            e((Spannable) d1.a.b(bVar.c()), new com.google.common.base.n() { // from class: com.google.android.exoplayer2.ui.y
                @Override // com.google.common.base.n
                public final boolean apply(Object obj) {
                    return z.a(obj);
                }
            });
        }
    }

    private static void e(Spannable spannable, com.google.common.base.n<Object> nVar) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            if (nVar.apply(obj)) {
                spannable.removeSpan(obj);
            }
        }
    }

    public static float f(int i10, float f10, int i11, int i12) {
        float f11;
        if (f10 == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    return -3.4028235E38f;
                }
                return f10;
            }
            f11 = i11;
        } else {
            f11 = i12;
        }
        return f10 * f11;
    }
}
