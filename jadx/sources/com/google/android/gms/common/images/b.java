package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f2247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final Bitmap f2248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CountDownLatch f2249c;

    @Override // java.lang.Runnable
    public final void run() {
        m1.b.a("OnBitmapLoadedRunnable must be executed in the main thread");
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) ImageManager.h(null).remove(this.f2247a);
        if (imageReceiver != null) {
            ArrayList arrayList = imageReceiver.f2240b;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                c cVar = (c) arrayList.get(i10);
                Bitmap bitmap = this.f2248b;
                if (bitmap != null) {
                    cVar.c(ImageManager.a(null), bitmap, false);
                } else {
                    ImageManager.f(null).put(this.f2247a, Long.valueOf(SystemClock.elapsedRealtime()));
                    Context contextA = ImageManager.a(null);
                    ImageManager.c(null);
                    cVar.b(contextA, null, false);
                }
                ImageManager.g(null).remove(cVar);
            }
        }
        this.f2249c.countDown();
        synchronized (ImageManager.f2237a) {
            ImageManager.f2238b.remove(this.f2247a);
        }
    }

    public b(ImageManager imageManager, @Nullable Uri uri, Bitmap bitmap, boolean z10, CountDownLatch countDownLatch) {
        this.f2247a = uri;
        this.f2248b = bitmap;
        this.f2249c = countDownLatch;
    }
}
