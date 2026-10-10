package androidx.window.layout;

import android.app.Activity;
import androidx.core.util.Consumer;
import c9.p;
import kotlin.Metadata;
import r8.r;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/window/layout/WindowInfoTrackerImpl;", "Landroidx/window/layout/WindowInfoTracker;", "Landroidx/window/layout/WindowMetricsCalculator;", "windowMetricsCalculator", "Landroidx/window/layout/WindowBackend;", "windowBackend", "<init>", "(Landroidx/window/layout/WindowMetricsCalculator;Landroidx/window/layout/WindowBackend;)V", "Landroid/app/Activity;", "activity", "Lkotlinx/coroutines/flow/f;", "Landroidx/window/layout/WindowLayoutInfo;", "windowLayoutInfo", "(Landroid/app/Activity;)Lkotlinx/coroutines/flow/f;", "Landroidx/window/layout/WindowMetricsCalculator;", "Landroidx/window/layout/WindowBackend;", "Companion", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WindowInfoTrackerImpl implements WindowInfoTracker {
    private static final int BUFFER_CAPACITY = 10;
    private final WindowBackend windowBackend;
    private final WindowMetricsCalculator windowMetricsCalculator;

    /* JADX INFO: renamed from: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1", f = "WindowInfoTrackerImpl.kt", l = {54, 55}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Landroidx/window/layout/WindowLayoutInfo;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {1, 6, 0})
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.l implements p<kotlinx.coroutines.flow.g<? super WindowLayoutInfo>, v8.f<? super z>, Object> {
        final /* synthetic */ Activity $activity;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Activity activity, v8.f<? super AnonymousClass1> fVar) {
            super(2, fVar);
            this.$activity = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invokeSuspend$lambda-0, reason: not valid java name */
        public static final void m92invokeSuspend$lambda0(kotlinx.coroutines.channels.d dVar, WindowLayoutInfo info) {
            kotlin.jvm.internal.m.e(info, "info");
            dVar.i(info);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            AnonymousClass1 anonymousClass1 = WindowInfoTrackerImpl.this.new AnonymousClass1(this.$activity, fVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.flow.g<? super WindowLayoutInfo> gVar, v8.f<? super z> fVar) {
            return ((AnonymousClass1) create(gVar, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0072  */
        /* JADX WARN: Code duplicated, block: B:21:0x0073  */
        /* JADX WARN: Code duplicated, block: B:24:0x007e A[Catch: all -> 0x001f, TRY_LEAVE, TryCatch #0 {all -> 0x001f, blocks: (B:7:0x001a, B:18:0x0064, B:22:0x0076, B:24:0x007e, B:14:0x0036, B:17:0x0060), top: B:31:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:27:0x0093  */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0090, code lost:
        
            if (r5.emit(r10, r9) == r0) goto L26;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0090 -> B:8:0x001d). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.g gVar;
            Consumer<WindowLayoutInfo> consumer;
            kotlinx.coroutines.channels.f it;
            kotlinx.coroutines.flow.g gVar2;
            Object objA;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            try {
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            it = (kotlinx.coroutines.channels.f) this.L$2;
                            consumer = (Consumer) this.L$1;
                            gVar2 = (kotlinx.coroutines.flow.g) this.L$0;
                            r.b(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        it = (kotlinx.coroutines.channels.f) this.L$2;
                        consumer = (Consumer) this.L$1;
                        gVar2 = (kotlinx.coroutines.flow.g) this.L$0;
                        r.b(obj);
                        if (((Boolean) obj).booleanValue()) {
                            WindowLayoutInfo windowLayoutInfo = (WindowLayoutInfo) it.next();
                            this.L$0 = gVar2;
                            this.L$1 = consumer;
                            this.L$2 = it;
                            this.label = 2;
                        } else {
                            WindowInfoTrackerImpl.this.windowBackend.unregisterLayoutChangeCallback(consumer);
                            return z.f17874a;
                        }
                    }
                } else {
                    r.b(obj);
                    gVar = (kotlinx.coroutines.flow.g) this.L$0;
                    final kotlinx.coroutines.channels.d dVarB = kotlinx.coroutines.channels.g.b(10, kotlinx.coroutines.channels.a.DROP_OLDEST, null, 4, null);
                    consumer = new Consumer() { // from class: androidx.window.layout.l
                        @Override // androidx.core.util.Consumer
                        public final void accept(Object obj2) {
                            WindowInfoTrackerImpl.AnonymousClass1.m92invokeSuspend$lambda0(dVarB, (WindowLayoutInfo) obj2);
                        }
                    };
                    WindowInfoTrackerImpl.this.windowBackend.registerLayoutChangeCallback(this.$activity, new androidx.privacysandbox.ads.adservices.adid.h(), consumer);
                    it = dVarB.iterator();
                    this.L$0 = gVar;
                    this.L$1 = consumer;
                    this.L$2 = it;
                    this.label = 1;
                    objA = it.a(this);
                    if (objA == objC) {
                        gVar2 = gVar;
                        obj = objA;
                        if (((Boolean) obj).booleanValue()) {
                            WindowLayoutInfo windowLayoutInfo2 = (WindowLayoutInfo) it.next();
                            this.L$0 = gVar2;
                            this.L$1 = consumer;
                            this.L$2 = it;
                            this.label = 2;
                        } else {
                            WindowInfoTrackerImpl.this.windowBackend.unregisterLayoutChangeCallback(consumer);
                            return z.f17874a;
                        }
                    }
                    return objC;
                }
                gVar = gVar2;
                this.L$0 = gVar;
                this.L$1 = consumer;
                this.L$2 = it;
                this.label = 1;
                objA = it.a(this);
                if (objA == objC) {
                    gVar2 = gVar;
                    obj = objA;
                    if (((Boolean) obj).booleanValue()) {
                        WindowLayoutInfo windowLayoutInfo3 = (WindowLayoutInfo) it.next();
                        this.L$0 = gVar2;
                        this.L$1 = consumer;
                        this.L$2 = it;
                        this.label = 2;
                    } else {
                        WindowInfoTrackerImpl.this.windowBackend.unregisterLayoutChangeCallback(consumer);
                        return z.f17874a;
                    }
                }
                return objC;
            } catch (Throwable th) {
                WindowInfoTrackerImpl.this.windowBackend.unregisterLayoutChangeCallback(consumer);
                throw th;
            }
        }
    }

    public WindowInfoTrackerImpl(WindowMetricsCalculator windowMetricsCalculator, WindowBackend windowBackend) {
        kotlin.jvm.internal.m.f(windowMetricsCalculator, "windowMetricsCalculator");
        kotlin.jvm.internal.m.f(windowBackend, "windowBackend");
        this.windowMetricsCalculator = windowMetricsCalculator;
        this.windowBackend = windowBackend;
    }

    @Override // androidx.window.layout.WindowInfoTracker
    public kotlinx.coroutines.flow.f<WindowLayoutInfo> windowLayoutInfo(Activity activity) {
        kotlin.jvm.internal.m.f(activity, "activity");
        return kotlinx.coroutines.flow.h.v(new AnonymousClass1(activity, null));
    }
}
