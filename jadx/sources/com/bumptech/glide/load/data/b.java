package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class b<T> implements d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AssetManager f1375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private T f1376c;

    protected abstract void c(T t10);

    protected abstract T e(AssetManager assetManager, String str);

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        T t10 = this.f1376c;
        if (t10 == null) {
            return;
        }
        try {
            c(t10);
        } catch (IOException unused) {
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void d(@NonNull com.bumptech.glide.h hVar, @NonNull d.a<? super T> aVar) {
        try {
            T tE = e(this.f1375b, this.f1374a);
            this.f1376c = tE;
            aVar.e(tE);
        } catch (IOException e10) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e10);
            }
            aVar.c(e10);
        }
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public j.a getDataSource() {
        return j.a.LOCAL;
    }

    public b(AssetManager assetManager, String str) {
        this.f1375b = assetManager;
        this.f1374a = str;
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }
}
