package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class l<T> implements d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f1398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ContentResolver f1399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private T f1400c;

    protected abstract void c(T t10);

    protected abstract T e(Uri uri, ContentResolver contentResolver);

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        T t10 = this.f1400c;
        if (t10 != null) {
            try {
                c(t10);
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void d(@NonNull com.bumptech.glide.h hVar, @NonNull d.a<? super T> aVar) {
        try {
            T tE = e(this.f1398a, this.f1399b);
            this.f1400c = tE;
            aVar.e(tE);
        } catch (FileNotFoundException e10) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e10);
            }
            aVar.c(e10);
        }
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public j.a getDataSource() {
        return j.a.LOCAL;
    }

    public l(ContentResolver contentResolver, Uri uri) {
        this.f1399b = contentResolver;
        this.f1398a = uri;
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }
}
