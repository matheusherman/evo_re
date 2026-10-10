package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.pengrad.telegrambot.model.message.origin.MessageOriginChannel;
import kotlin.Metadata;
import kotlinx.coroutines.k0;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/channels/r;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/e;", "Lkotlinx/coroutines/channels/s;", "Lv8/j;", "parentContext", "Lkotlinx/coroutines/channels/d;", MessageOriginChannel.MESSAGE_ORIGIN_TYPE, "<init>", "(Lv8/j;Lkotlinx/coroutines/channels/d;)V", "Lr8/z;", "value", "N0", "(Lr8/z;)V", "", "cause", "", "handled", "J0", "(Ljava/lang/Throwable;Z)V", "isActive", "()Z", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class r<E> extends e<E> implements s<E> {
    public r(v8.j jVar, d<E> dVar) {
        super(jVar, dVar, true, true);
    }

    @Override // kotlinx.coroutines.a
    protected void J0(Throwable cause, boolean handled) {
        if (!M0().g(cause) && !handled) {
            k0.a(getContext(), cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.a
    /* JADX INFO: renamed from: N0, reason: merged with bridge method [inline-methods] */
    public void K0(z value) {
        v.a.a(M0(), null, 1, null);
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.c2, kotlinx.coroutines.u1
    public boolean isActive() {
        return super.isActive();
    }
}
