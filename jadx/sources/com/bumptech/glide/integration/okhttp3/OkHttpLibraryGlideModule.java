package com.bumptech.glide.integration.okhttp3;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.c;
import com.bumptech.glide.i;
import com.bumptech.glide.module.LibraryGlideModule;
import java.io.InputStream;
import p.h;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class OkHttpLibraryGlideModule extends LibraryGlideModule {
    @Override // com.bumptech.glide.module.LibraryGlideModule
    public void a(@NonNull Context context, @NonNull c cVar, @NonNull i iVar) {
        iVar.r(h.class, InputStream.class, new a.C0036a());
    }
}
