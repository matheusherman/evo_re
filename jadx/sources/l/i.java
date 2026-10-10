package l;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class i<DataType, ResourceType, Transcode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<DataType> f15043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<? extends j.k<DataType, ResourceType>> f15044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final x.e<ResourceType, Transcode> f15045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f15046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f15047e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    interface a<ResourceType> {
        @NonNull
        v<ResourceType> a(@NonNull v<ResourceType> vVar);
    }

    @NonNull
    private v<ResourceType> b(com.bumptech.glide.load.data.e<DataType> eVar, int i10, int i11, @NonNull j.i iVar) {
        List<Throwable> list = (List) e0.k.d(this.f15046d.acquire());
        try {
            return c(eVar, i10, i11, iVar, list);
        } finally {
            this.f15046d.release(list);
        }
    }

    @NonNull
    private v<ResourceType> c(com.bumptech.glide.load.data.e<DataType> eVar, int i10, int i11, @NonNull j.i iVar, List<Throwable> list) throws q {
        int size = this.f15044b.size();
        v<ResourceType> vVarB = null;
        for (int i12 = 0; i12 < size; i12++) {
            j.k<DataType, ResourceType> kVar = this.f15044b.get(i12);
            try {
                if (kVar.a(eVar.a(), iVar)) {
                    vVarB = kVar.b(eVar.a(), i10, i11, iVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e10) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + kVar, e10);
                }
                list.add(e10);
            }
            if (vVarB != null) {
                break;
            }
        }
        if (vVarB != null) {
            return vVarB;
        }
        throw new q(this.f15047e, new ArrayList(list));
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f15043a + ", decoders=" + this.f15044b + ", transcoder=" + this.f15045c + '}';
    }

    public i(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends j.k<DataType, ResourceType>> list, x.e<ResourceType, Transcode> eVar, Pools.Pool<List<Throwable>> pool) {
        this.f15043a = cls;
        this.f15044b = list;
        this.f15045c = eVar;
        this.f15046d = pool;
        this.f15047e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public v<Transcode> a(com.bumptech.glide.load.data.e<DataType> eVar, int i10, int i11, @NonNull j.i iVar, a<ResourceType> aVar) {
        return this.f15045c.a(aVar.a(b(eVar, i10, i11, iVar)), iVar);
    }
}
