package y9;

import java.util.List;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class e {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends kotlin.reflect.jvm.internal.impl.protobuf.i.d<M>, T> T a(kotlin.reflect.jvm.internal.impl.protobuf.i.d<M> dVar, kotlin.reflect.jvm.internal.impl.protobuf.i.f<M, T> extension) {
        m.f(dVar, "<this>");
        m.f(extension, "extension");
        if (dVar.w(extension)) {
            return (T) dVar.t(extension);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends kotlin.reflect.jvm.internal.impl.protobuf.i.d<M>, T> T b(kotlin.reflect.jvm.internal.impl.protobuf.i.d<M> dVar, kotlin.reflect.jvm.internal.impl.protobuf.i.f<M, List<T>> extension, int i10) {
        m.f(dVar, "<this>");
        m.f(extension, "extension");
        if (i10 < dVar.v(extension)) {
            return (T) dVar.u(extension, i10);
        }
        return null;
    }
}
