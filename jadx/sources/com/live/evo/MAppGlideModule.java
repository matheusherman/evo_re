package com.live.evo;

import android.content.Context;
import com.bumptech.glide.module.AppGlideModule;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class MAppGlideModule extends AppGlideModule {
    @Override // com.bumptech.glide.module.AppGlideModule
    public boolean c() {
        return false;
    }

    @Override // com.bumptech.glide.module.LibraryGlideModule
    public void a(Context context, com.bumptech.glide.c cVar, com.bumptech.glide.i iVar) {
        iVar.r(p.h.class, InputStream.class, new com.bumptech.glide.integration.okhttp3.a.C0036a(of.e.f16588a.e()));
    }
}
