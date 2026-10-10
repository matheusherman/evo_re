package androidx.paging.multicast;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import r8.z;
import v8.f;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/multicast/ChannelManager$Message;", "p1", "Lr8/z;", "invoke", "(Landroidx/paging/multicast/ChannelManager$Message;Lv8/f;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final /* synthetic */ class ChannelManager$Actor$newProducer$1<T> extends k implements p<ChannelManager.Message<T>, f<? super z>, Object> {
    ChannelManager$Actor$newProducer$1(ChannelManager.Actor actor) {
        super(2, actor, ChannelManager.Actor.class, "send", "send(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // c9.p
    public final Object invoke(ChannelManager.Message<T> message, f<? super z> fVar) {
        return ((ChannelManager.Actor) this.receiver).send(message, fVar);
    }
}
