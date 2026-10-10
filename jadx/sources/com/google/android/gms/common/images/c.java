package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import x1.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f2250a;

    protected abstract void a(@Nullable Drawable drawable, boolean z10, boolean z11, boolean z12);

    final void b(Context context, g gVar, boolean z10) {
        int i10 = this.f2250a;
        a(i10 != 0 ? context.getResources().getDrawable(i10) : null, z10, false, false);
    }

    final void c(Context context, Bitmap bitmap, boolean z10) {
        m1.b.c(bitmap);
        a(new BitmapDrawable(context.getResources(), bitmap), false, false, true);
    }
}
