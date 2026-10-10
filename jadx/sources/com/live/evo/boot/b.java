package com.live.evo.boot;

import c9.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import org.greenrobot.eventbus.ThreadMode;
import r8.r;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u001d\u0010\r\u001a\u00020\f2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0010R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/live/evo/boot/b;", "", "<init>", "()V", "", "what", "Lr8/z;", "c", "(I)V", "a", "", "checkpoints", "", "b", "(Ljava/util/Set;)Z", "", "Ljava/util/Map;", "mCheckpoints", "", "Lcom/live/evo/boot/b$a;", "Ljava/util/List;", "mWaitingManList", "d", "Ljava/lang/Object;", "mLock", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f5537a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static Map<Integer, Boolean> mCheckpoints;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static List<a> mWaitingManList;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Object mLock;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u000e\u001a\u0004\b\u0006\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0019\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/live/evo/boot/b$a;", "", "<init>", "()V", "", "", "a", "Ljava/util/Set;", "b", "()Ljava/util/Set;", "setConditions", "(Ljava/util/Set;)V", "conditions", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "()Ljava/lang/Runnable;", "setAction", "(Ljava/lang/Runnable;)V", "action", "Lorg/greenrobot/eventbus/ThreadMode;", "c", "Lorg/greenrobot/eventbus/ThreadMode;", "()Lorg/greenrobot/eventbus/ThreadMode;", "setThreadMode", "(Lorg/greenrobot/eventbus/ThreadMode;)V", "threadMode", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private Set<Integer> conditions;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private Runnable action;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private ThreadMode threadMode;

        /* JADX INFO: renamed from: a, reason: from getter */
        public final Runnable getAction() {
            return this.action;
        }

        public final Set<Integer> b() {
            return this.conditions;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final ThreadMode getThreadMode() {
            return this.threadMode;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "com.live.evo.boot.BootManager$postCheckpointComplete$1", f = "BootManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class c extends l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ a $waitingMan;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(a aVar, v8.f<? super c> fVar) {
            super(2, fVar);
            this.$waitingMan = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new c(this.$waitingMan, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((c) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r.b(obj);
                Runnable action = this.$waitingMan.getAction();
                if (action != null) {
                    action.run();
                }
                return z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "com.live.evo.boot.BootManager$postCheckpointComplete$2", f = "BootManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class d extends l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ a $waitingMan;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(a aVar, v8.f<? super d> fVar) {
            super(2, fVar);
            this.$waitingMan = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new d(this.$waitingMan, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((d) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r.b(obj);
                Runnable action = this.$waitingMan.getAction();
                if (action != null) {
                    action.run();
                }
                return z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final boolean b(Set<Integer> checkpoints) {
        Boolean bool;
        if (checkpoints == null) {
            return false;
        }
        Iterator<Integer> it = checkpoints.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (iIntValue >= 0 && (bool = mCheckpoints.get(Integer.valueOf(iIntValue))) != null && !bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.live.evo.boot.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class C0067b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5544a;

        static {
            int[] iArr = new int[ThreadMode.values().length];
            try {
                iArr[ThreadMode.MAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ThreadMode.MAIN_ORDERED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ThreadMode.ASYNC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ThreadMode.BACKGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f5544a = iArr;
        }
    }

    static {
        HashMap map = new HashMap();
        mCheckpoints = map;
        mLock = new Object();
        Boolean bool = Boolean.FALSE;
        map.put(0, bool);
        mCheckpoints.put(1, bool);
        mCheckpoints.put(2, bool);
        mCheckpoints.put(3, bool);
        mCheckpoints.put(4, bool);
        mCheckpoints.put(5, bool);
        mCheckpoints.put(6, bool);
        mWaitingManList = new ArrayList();
    }

    private final void c(int what) {
        List<a> list = mWaitingManList;
        m.c(list);
        int size = list.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i10 = size - 1;
            List<a> list2 = mWaitingManList;
            m.c(list2);
            a aVar = list2.get(size);
            Set<Integer> setB = aVar.b();
            m.c(setB);
            if (setB.contains(Integer.valueOf(what)) && b(aVar.b())) {
                List<a> list3 = mWaitingManList;
                m.c(list3);
                list3.remove(size);
                ThreadMode threadMode = aVar.getThreadMode();
                int i11 = threadMode == null ? -1 : C0067b.f5544a[threadMode.ordinal()];
                if (i11 == 1 || i11 == 2) {
                    j.d(m0.b(), null, null, new c(aVar, null), 3, null);
                } else if (i11 == 3 || i11 == 4) {
                    j.d(m0.a(a1.b()), null, null, new d(aVar, null), 3, null);
                } else {
                    Runnable action = aVar.getAction();
                    if (action != null) {
                        action.run();
                    }
                }
            }
            if (i10 < 0) {
                return;
            } else {
                size = i10;
            }
        }
    }

    public final void a(int what) {
        synchronized (mLock) {
            mCheckpoints.put(Integer.valueOf(what), Boolean.TRUE);
            f5537a.c(what);
            z zVar = z.f17874a;
        }
    }

    private b() {
    }
}
