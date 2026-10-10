package p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public interface o<Model, Data> {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j.f f17201a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<j.f> f17202b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bumptech.glide.load.data.d<Data> f17203c;

        public a(@NonNull j.f fVar, @NonNull com.bumptech.glide.load.data.d<Data> dVar) {
            this(fVar, Collections.EMPTY_LIST, dVar);
        }

        public a(@NonNull j.f fVar, @NonNull List<j.f> list, @NonNull com.bumptech.glide.load.data.d<Data> dVar) {
            this.f17201a = (j.f) e0.k.d(fVar);
            this.f17202b = (List) e0.k.d(list);
            this.f17203c = (com.bumptech.glide.load.data.d) e0.k.d(dVar);
        }
    }

    boolean a(@NonNull Model model);

    @Nullable
    a<Data> b(@NonNull Model model, int i10, int i11, @NonNull j.i iVar);
}
