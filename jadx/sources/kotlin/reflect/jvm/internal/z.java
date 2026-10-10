package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Member;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0006\b\u0002\u0010\u0002 \u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"D", ExifInterface.LONGITUDE_EAST, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ljava/lang/reflect/Member;", "a", "()Ljava/lang/reflect/Member;"}, k = 3, mv = {1, 8, 0})
final class z extends kotlin.jvm.internal.o implements c9.a<Member> {
    final /* synthetic */ x<Object, Object, Object> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    z(x<Object, Object, Object> xVar) {
        super(0);
        this.this$0 = xVar;
    }

    @Override // c9.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Member invoke() {
        return this.this$0.w();
    }
}
