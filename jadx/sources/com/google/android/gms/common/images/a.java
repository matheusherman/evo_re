package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f2245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final ParcelFileDescriptor f2246b;

    @Override // java.lang.Runnable
    public final void run() {
        boolean z10;
        m1.b.b("LoadBitmapFromDiskRunnable can't be executed in the main thread");
        ParcelFileDescriptor parcelFileDescriptor = this.f2246b;
        Bitmap bitmapDecodeFileDescriptor = null;
        boolean z11 = false;
        if (parcelFileDescriptor != null) {
            try {
                bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
            } catch (OutOfMemoryError e10) {
                Log.e("ImageManager", "OOM while loading bitmap for uri: ".concat(String.valueOf(this.f2245a)), e10);
                z11 = true;
            }
            try {
                this.f2246b.close();
            } catch (IOException e11) {
                Log.e("ImageManager", "closed failed", e11);
            }
            z10 = z11;
        } else {
            z10 = false;
        }
        Bitmap bitmap = bitmapDecodeFileDescriptor;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ImageManager.b(null).post(new b(null, this.f2245a, bitmap, z10, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            Log.w("ImageManager", "Latch interrupted while posting ".concat(String.valueOf(this.f2245a)));
        }
    }

    public a(ImageManager imageManager, @Nullable Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
        this.f2245a = uri;
        this.f2246b = parcelFileDescriptor;
    }
}
