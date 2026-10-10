package com.google.android.gms.common.images;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import com.google.android.gms.common.annotation.KeepName;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import x1.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class ImageManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f2237a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashSet f2238b = new HashSet();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @KeepName
    final class ImageReceiver extends ResultReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f2239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList f2240b;

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i10, Bundle bundle) {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
            ImageManager.i(null).execute(new a(null, this.f2239a, parcelFileDescriptor));
        }
    }

    static /* bridge */ /* synthetic */ Context a(ImageManager imageManager) {
        throw null;
    }

    static /* bridge */ /* synthetic */ Handler b(ImageManager imageManager) {
        throw null;
    }

    static /* bridge */ /* synthetic */ g c(ImageManager imageManager) {
        throw null;
    }

    static /* bridge */ /* synthetic */ Map f(ImageManager imageManager) {
        throw null;
    }

    static /* bridge */ /* synthetic */ Map g(ImageManager imageManager) {
        throw null;
    }

    static /* bridge */ /* synthetic */ Map h(ImageManager imageManager) {
        throw null;
    }

    static /* bridge */ /* synthetic */ ExecutorService i(ImageManager imageManager) {
        throw null;
    }
}
