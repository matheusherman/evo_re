package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class j extends f implements u9.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object[] f13034c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(ba.f fVar, Object[] values) {
        super(fVar, null);
        kotlin.jvm.internal.m.f(values, "values");
        this.f13034c = values;
    }

    @Override // u9.e
    public List<f> e() {
        Object[] objArr = this.f13034c;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            f.a aVar = f.f13031b;
            kotlin.jvm.internal.m.c(obj);
            arrayList.add(aVar.a(obj, null));
        }
        return arrayList;
    }
}
