package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public interface d<T> {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a<T> {
        void c(@NonNull Exception exc);

        void e(@Nullable T t10);
    }

    @NonNull
    Class<T> a();

    void b();

    void cancel();

    void d(@NonNull com.bumptech.glide.h hVar, @NonNull a<? super T> aVar);

    @NonNull
    j.a getDataSource();
}
