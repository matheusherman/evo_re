package e2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class g<TResult> {
    @NonNull
    public abstract g<TResult> a(@NonNull Executor executor, @NonNull b bVar);

    @NonNull
    public abstract g<TResult> b(@NonNull c<TResult> cVar);

    @NonNull
    public abstract g<TResult> c(@NonNull Executor executor, @NonNull c<TResult> cVar);

    @NonNull
    public abstract g<TResult> d(@NonNull d dVar);

    @NonNull
    public abstract g<TResult> e(@NonNull Executor executor, @NonNull d dVar);

    @NonNull
    public abstract g<TResult> f(@NonNull Executor executor, @NonNull e<? super TResult> eVar);

    @Nullable
    public abstract Exception g();

    public abstract TResult h();

    public abstract boolean i();

    public abstract boolean j();

    public abstract boolean k();
}
