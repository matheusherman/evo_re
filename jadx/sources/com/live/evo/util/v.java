package com.live.evo.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class v {
    public static void a(Context context, int i10, int i11, ImageView imageView) {
        try {
            com.bumptech.glide.k kVarG = com.bumptech.glide.c.t(context).t(Integer.valueOf(i10)).g(l.j.f15048a);
            if (i11 <= 0) {
                i11 = 2131102158;
            }
            kVarG.b0(i11).E0(imageView);
        } catch (Exception unused) {
        }
    }

    public static void b(Context context, Bitmap bitmap, int i10, ImageView imageView) {
        try {
            com.bumptech.glide.k kVarG = com.bumptech.glide.c.t(context).s(bitmap).g(l.j.f15048a);
            if (i10 <= 0) {
                i10 = 2131102158;
            }
            kVarG.b0(i10).E0(imageView);
        } catch (Exception unused) {
        }
    }

    public static void c(Context context, String str, int i10, ImageView imageView) {
        try {
            com.bumptech.glide.k kVarG = com.bumptech.glide.c.t(context).u(str).g(l.j.f15048a);
            if (i10 <= 0) {
                i10 = 2131102158;
            }
            kVarG.b0(i10).E0(imageView);
        } catch (Exception unused) {
        }
    }

    public static void d(Context context, String str, ImageView imageView) {
        c(context, str, 2131102158, imageView);
    }
}
