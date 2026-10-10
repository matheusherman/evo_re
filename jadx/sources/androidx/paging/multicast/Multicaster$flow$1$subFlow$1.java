package androidx.paging.multicast;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.channels.d;
import kotlinx.coroutines.flow.g;
import r8.r;
import r8.z;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@f(c = "androidx.paging.multicast.Multicaster$flow$1$subFlow$1", f = "Multicaster.kt", l = {78}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/g;", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class Multicaster$flow$1$subFlow$1<T> extends l implements p<g<? super ChannelManager.Message.Dispatch.Value<T>>, v8.f<? super z>, Object> {
    final /* synthetic */ d $channel;
    int label;
    final /* synthetic */ Multicaster$flow$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Multicaster$flow$1$subFlow$1(Multicaster$flow$1 multicaster$flow$1, d dVar, v8.f fVar) {
        super(2, fVar);
        this.this$0 = multicaster$flow$1;
        this.$channel = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final v8.f<z> create(Object obj, v8.f<?> completion) {
        m.f(completion, "completion");
        return new Multicaster$flow$1$subFlow$1(this.this$0, this.$channel, completion);
    }

    @Override // c9.p
    public final Object invoke(Object obj, v8.f<? super z> fVar) {
        return ((Multicaster$flow$1$subFlow$1) create(obj, fVar)).invokeSuspend(z.f17874a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object objC = b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                r.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            r.b(obj);
            ChannelManager channelManager = this.this$0.this$0.getChannelManager();
            d dVar = this.$channel;
            this.label = 1;
            if (channelManager.addDownstream(dVar, this) == objC) {
                return objC;
            }
        }
        return z.f17874a;
    }
}
