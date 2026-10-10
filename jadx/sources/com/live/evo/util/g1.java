package com.live.evo.util;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class g1 extends BitmapDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7238c;

    private synchronized void a() {
        if (this.f7236a <= 0 && this.f7237b <= 0 && this.f7238c && b()) {
            getBitmap().recycle();
        }
    }

    private synchronized boolean b() {
        Bitmap bitmap;
        bitmap = getBitmap();
        return (bitmap == null || bitmap.isRecycled()) ? false : true;
    }

    public void c(boolean z10) {
        synchronized (this) {
            try {
                if (z10) {
                    this.f7236a++;
                } else {
                    this.f7236a--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        a();
    }
}
