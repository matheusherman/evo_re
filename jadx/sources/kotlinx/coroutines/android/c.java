package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import c9.l;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import h9.f;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.n;
import kotlinx.coroutines.u0;
import kotlinx.coroutines.y1;
import r8.z;
import v8.j;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B#\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB\u001d\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\u000bJ#\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0013J%\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0096\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010(R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010+\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u001a\u00100\u001a\u00020\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b-\u0010,\u001a\u0004\b.\u0010/¨\u00061"}, d2 = {"Lkotlinx/coroutines/android/c;", "Lkotlinx/coroutines/android/d;", "Lkotlinx/coroutines/u0;", "Landroid/os/Handler;", "handler", "", "name", "", "invokeImmediately", "<init>", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "(Landroid/os/Handler;Ljava/lang/String;)V", "Lv8/j;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lr8/z;", "u", "(Lv8/j;Ljava/lang/Runnable;)V", "isDispatchNeeded", "(Lv8/j;)Z", "dispatch", "", "timeMillis", "Lkotlinx/coroutines/n;", "continuation", "b", "(JLkotlinx/coroutines/n;)V", "toString", "()Ljava/lang/String;", "", TransactionPartnerType.OTHER, "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "a", "Landroid/os/Handler;", "Ljava/lang/String;", "c", "Z", "_immediate", "Lkotlinx/coroutines/android/c;", "d", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lkotlinx/coroutines/android/c;", "immediate", "kotlinx-coroutines-android"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class c extends d implements u0 {
    private volatile c _immediate;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Handler handler;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String name;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean invokeImmediately;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final c immediate;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lr8/z;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f14588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f14589b;

        public a(n nVar, c cVar) {
            this.f14588a = nVar;
            this.f14589b = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f14588a.o(this.f14589b, z.f17874a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lr8/z;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    static final class b extends o implements l<Throwable, z> {
        final /* synthetic */ Runnable $block;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(Throwable th) {
            invoke2(th);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Runnable runnable) {
            super(1);
            this.$block = runnable;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            c.this.handler.removeCallbacks(this.$block);
        }
    }

    private c(Handler handler, String str, boolean z10) {
        super(null);
        this.handler = handler;
        this.name = str;
        this.invokeImmediately = z10;
        this._immediate = z10 ? this : null;
        c cVar = this._immediate;
        if (cVar == null) {
            cVar = new c(handler, str, true);
            this._immediate = cVar;
        }
        this.immediate = cVar;
    }

    private final void u(j context, Runnable block) {
        y1.c(context, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        a1.b().dispatch(context, block);
    }

    @Override // kotlinx.coroutines.g2
    /* JADX INFO: renamed from: A, reason: from getter and merged with bridge method [inline-methods] */
    public c d() {
        return this.immediate;
    }

    @Override // kotlinx.coroutines.u0
    public void b(long timeMillis, n<? super z> continuation) {
        a aVar = new a(continuation, this);
        if (this.handler.postDelayed(aVar, f.f(timeMillis, 4611686018427387903L))) {
            continuation.h(new b(aVar));
        } else {
            u(continuation.getContext(), aVar);
        }
    }

    @Override // kotlinx.coroutines.i0
    public void dispatch(j context, Runnable block) {
        if (this.handler.post(block)) {
            return;
        }
        u(context, block);
    }

    public boolean equals(Object other) {
        return (other instanceof c) && ((c) other).handler == this.handler;
    }

    public int hashCode() {
        return System.identityHashCode(this.handler);
    }

    @Override // kotlinx.coroutines.i0
    public boolean isDispatchNeeded(j context) {
        return (this.invokeImmediately && m.a(Looper.myLooper(), this.handler.getLooper())) ? false : true;
    }

    @Override // kotlinx.coroutines.g2, kotlinx.coroutines.i0
    public String toString() {
        String strO = o();
        if (strO == null) {
            String string = this.name;
            if (string == null) {
                string = this.handler.toString();
            }
            if (this.invokeImmediately) {
                return string + ".immediate";
            }
            return string;
        }
        return strO;
    }

    public /* synthetic */ c(Handler handler, String str, int i10, g gVar) {
        this(handler, (i10 & 2) != 0 ? null : str);
    }

    public c(Handler handler, String str) {
        this(handler, str, false);
    }
}
