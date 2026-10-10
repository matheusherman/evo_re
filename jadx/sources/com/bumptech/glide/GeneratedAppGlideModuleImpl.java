package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule;
import com.live.evo.MAppGlideModule;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MAppGlideModule f1272a = new MAppGlideModule();

    @Override // com.bumptech.glide.module.LibraryGlideModule
    public void a(@NonNull Context context, @NonNull c cVar, @NonNull i iVar) {
        new OkHttpLibraryGlideModule().a(context, cVar, iVar);
        this.f1272a.a(context, cVar, iVar);
    }

    @Override // com.bumptech.glide.module.AppGlideModule
    public void b(@NonNull Context context, @NonNull d dVar) {
        this.f1272a.b(context, dVar);
    }

    @Override // com.bumptech.glide.module.AppGlideModule
    public boolean c() {
        return this.f1272a.c();
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    @NonNull
    public Set<Class<?>> d() {
        return Collections.EMPTY_SET;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.GeneratedAppGlideModule
    @NonNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public a e() {
        return new a();
    }

    public GeneratedAppGlideModuleImpl(Context context) {
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Discovered AppGlideModule from annotation: com.live.evo.MAppGlideModule");
            Log.d("Glide", "Discovered LibraryGlideModule from annotation: com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule");
        }
    }
}
