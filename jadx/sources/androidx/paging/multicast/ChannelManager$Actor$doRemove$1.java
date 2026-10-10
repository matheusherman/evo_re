package androidx.paging.multicast;

import androidx.exifinterface.media.ExifInterface;
import com.pengrad.telegrambot.model.message.origin.MessageOriginChannel;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@f(c = "androidx.paging.multicast.ChannelManager$Actor", f = "ChannelManager.kt", l = {206}, m = "doRemove")
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0082@¢\u0006\u0004\b\b\u0010\t"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/v;", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", MessageOriginChannel.MESSAGE_ORIGIN_TYPE, "Lv8/f;", "Lr8/z;", "continuation", "", "doRemove", "(Lkotlinx/coroutines/channels/v;Lv8/f;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
final class ChannelManager$Actor$doRemove$1 extends d {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChannelManager.Actor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChannelManager$Actor$doRemove$1(ChannelManager.Actor actor, v8.f fVar) {
        super(fVar);
        this.this$0 = actor;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doRemove(null, this);
    }
}
