package l;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class t<Data, ResourceType, Transcode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<Data> f15133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f15134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<? extends i<Data, ResourceType, Transcode>> f15135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f15136d;

    private v<Transcode> b(com.bumptech.glide.load.data.e<Data> eVar, @NonNull j.i iVar, int i10, int i11, i.a<ResourceType> aVar, List<Throwable> list) throws q {
        int size = this.f15135c.size();
        v<Transcode> vVarA = null;
        for (int i12 = 0; i12 < size; i12++) {
            try {
                vVarA = this.f15135c.get(i12).a(eVar, i10, i11, iVar, aVar);
            } catch (q e10) {
                list.add(e10);
            }
            if (vVarA != null) {
                break;
            }
        }
        if (vVarA != null) {
            return vVarA;
        }
        throw new q(this.f15136d, new ArrayList(list));
    }

    public v<Transcode> a(com.bumptech.glide.load.data.e<Data> eVar, @NonNull j.i iVar, int i10, int i11, i.a<ResourceType> aVar) {
        List<Throwable> list = (List) e0.k.d(this.f15134b.acquire());
        try {
            return b(eVar, iVar, i10, i11, aVar, list);
        } finally {
            this.f15134b.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f15135c.toArray()) + '}';
    }

    public t(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<i<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.f15133a = cls;
        this.f15134b = pool;
        this.f15135c = (List) e0.k.c(list);
        this.f15136d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }
}
