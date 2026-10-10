package androidx.p000lifecycle;

import androidx.annotation.RequiresApi;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.RoomTrackingLiveData;
import c9.a;
import c9.p;
import java.time.Duration;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.flow.d0;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.h;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.n1;
import r8.r;
import r8.z;
import v8.k;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\t\u0010\n\u001a7\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0007\u0010\r¨\u0006\u000e"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/f;", "Lv8/j;", "context", "", "timeoutInMs", "Landroidx/lifecycle/LiveData;", "asLiveData", "(Lkotlinx/coroutines/flow/f;Lv8/j;J)Landroidx/lifecycle/LiveData;", "asFlow", "(Landroidx/lifecycle/LiveData;)Lkotlinx/coroutines/flow/f;", "Ljava/time/Duration;", "timeout", "(Lkotlinx/coroutines/flow/f;Lv8/j;Ljava/time/Duration;)Landroidx/lifecycle/LiveData;", "lifecycle-livedata-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FlowLiveDataConversions {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", l = {110, 114}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/s;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/channels/s;)V"}, k = 3, mv = {1, 8, 0})
    static final class AnonymousClass1<T> extends l implements p<s<? super T>, v8.f<? super z>, Object> {
        final /* synthetic */ LiveData<T> $this_asFlow;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @f(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", f = "FlowLiveData.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {1, 8, 0})
        static final class C00101 extends l implements p<l0, v8.f<? super z>, Object> {
            final /* synthetic */ Observer<T> $observer;
            final /* synthetic */ LiveData<T> $this_asFlow;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00101(LiveData<T> liveData, Observer<T> observer, v8.f<? super C00101> fVar) {
                super(2, fVar);
                this.$this_asFlow = liveData;
                this.$observer = observer;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                return new C00101(this.$this_asFlow, this.$observer, fVar);
            }

            @Override // c9.p
            public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                return ((C00101) create(l0Var, fVar)).invokeSuspend(z.f17874a);
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                b.c();
                if (this.label == 0) {
                    r.b(obj);
                    this.$this_asFlow.observeForever((Observer<? super T>) this.$observer);
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lr8/z;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        static final class AnonymousClass2 extends o implements a<z> {
            final /* synthetic */ Observer<T> $observer;
            final /* synthetic */ LiveData<T> $this_asFlow;

            /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @f(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2$1", f = "FlowLiveData.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {1, 8, 0})
            static final class C00111 extends l implements p<l0, v8.f<? super z>, Object> {
                final /* synthetic */ Observer<T> $observer;
                final /* synthetic */ LiveData<T> $this_asFlow;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00111(LiveData<T> liveData, Observer<T> observer, v8.f<? super C00111> fVar) {
                    super(2, fVar);
                    this.$this_asFlow = liveData;
                    this.$observer = observer;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                    return new C00111(this.$this_asFlow, this.$observer, fVar);
                }

                @Override // c9.p
                public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                    return ((C00111) create(l0Var, fVar)).invokeSuspend(z.f17874a);
                }

                /* JADX WARN: Type inference incomplete: some casts might be missing */
                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    b.c();
                    if (this.label == 0) {
                        r.b(obj);
                        this.$this_asFlow.removeObserver((Observer<? super T>) this.$observer);
                        return z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            @Override // c9.a
            public /* bridge */ /* synthetic */ z invoke() {
                invoke2();
                return z.f17874a;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(LiveData<T> liveData, Observer<T> observer) {
                super(0);
                this.$this_asFlow = liveData;
                this.$observer = observer;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                j.d(n1.f14892a, a1.c().getImmediate(), null, new C00111(this.$this_asFlow, this.$observer, null), 2, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LiveData<T> liveData, v8.f<? super AnonymousClass1> fVar) {
            super(2, fVar);
            this.$this_asFlow = liveData;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_asFlow, fVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // c9.p
        public final Object invoke(s<? super T> sVar, v8.f<? super z> fVar) {
            return ((AnonymousClass1) create(sVar, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0061, code lost:
        
            if (kotlinx.coroutines.channels.q.a(r3, r9, r8) == r0) goto L16;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Observer observer;
            s sVar;
            Object objC = b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    observer = (Observer) this.L$1;
                    sVar = (s) this.L$0;
                    r.b(obj);
                }
                return z.f17874a;
            }
            r.b(obj);
            final s sVar2 = (s) this.L$0;
            observer = new Observer() { // from class: androidx.lifecycle.e
                @Override // androidx.p000lifecycle.Observer
                public final void onChanged(Object obj2) {
                    sVar2.i(obj2);
                }
            };
            g2 immediate = a1.c().getImmediate();
            C00101 c00101 = new C00101(this.$this_asFlow, observer, null);
            this.L$0 = sVar2;
            this.L$1 = observer;
            this.label = 1;
            if (h.g(immediate, c00101, this) != objC) {
                sVar = sVar2;
            }
            return objC;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_asFlow, observer);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asLiveData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", f = "FlowLiveData.kt", l = {80}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LiveDataScope;", "Lr8/z;", "<anonymous>", "(Landroidx/lifecycle/LiveDataScope;)V"}, k = 3, mv = {1, 8, 0})
    static final class C05211<T> extends l implements p<LiveDataScope<T>, v8.f<? super z>, Object> {
        final /* synthetic */ kotlinx.coroutines.flow.f<T> $this_asLiveData;
        private /* synthetic */ Object L$0;
        int label;

        @Override // c9.p
        public final Object invoke(LiveDataScope<T> liveDataScope, v8.f<? super z> fVar) {
            return ((C05211) create(liveDataScope, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C05211(kotlinx.coroutines.flow.f<? extends T> fVar, v8.f<? super C05211> fVar2) {
            super(2, fVar2);
            this.$this_asLiveData = fVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            C05211 c05211 = new C05211(this.$this_asLiveData, fVar);
            c05211.L$0 = obj;
            return c05211;
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
                final LiveDataScope liveDataScope = (LiveDataScope) this.L$0;
                kotlinx.coroutines.flow.f<T> fVar = this.$this_asLiveData;
                g<? super T> gVar = new g() { // from class: androidx.lifecycle.FlowLiveDataConversions.asLiveData.1.1
                    @Override // kotlinx.coroutines.flow.g
                    public final Object emit(T t10, v8.f<? super z> fVar2) {
                        Object objEmit = liveDataScope.emit(t10, fVar2);
                        return objEmit == b.c() ? objEmit : z.f17874a;
                    }
                };
                this.label = 1;
                if (fVar.collect(gVar, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    public static final <T> LiveData<T> asLiveData(kotlinx.coroutines.flow.f<? extends T> fVar) {
        m.f(fVar, "<this>");
        return asLiveData$default(fVar, (v8.j) null, 0L, 3, (Object) null);
    }

    public static /* synthetic */ LiveData asLiveData$default(kotlinx.coroutines.flow.f fVar, v8.j jVar, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            jVar = k.f19724a;
        }
        if ((i10 & 2) != 0) {
            j10 = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
        }
        return asLiveData(fVar, jVar, j10);
    }

    public static final <T> kotlinx.coroutines.flow.f<T> asFlow(LiveData<T> liveData) {
        m.f(liveData, "<this>");
        return kotlinx.coroutines.flow.h.k(kotlinx.coroutines.flow.h.e(new AnonymousClass1(liveData, null)));
    }

    public static final <T> LiveData<T> asLiveData(kotlinx.coroutines.flow.f<? extends T> fVar, v8.j context) {
        m.f(fVar, "<this>");
        m.f(context, "context");
        return asLiveData$default(fVar, context, 0L, 2, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> LiveData<T> asLiveData(kotlinx.coroutines.flow.f<? extends T> fVar, v8.j context, long j10) {
        m.f(fVar, "<this>");
        m.f(context, "context");
        RoomTrackingLiveData roomTrackingLiveData = (LiveData<T>) CoroutineLiveDataKt.liveData(context, j10, new C05211(fVar, null));
        if (fVar instanceof d0) {
            if (ArchTaskExecutor.getInstance().isMainThread()) {
                roomTrackingLiveData.setValue(((d0) fVar).getValue());
                return roomTrackingLiveData;
            }
            roomTrackingLiveData.postValue(((d0) fVar).getValue());
        }
        return roomTrackingLiveData;
    }

    public static /* synthetic */ LiveData asLiveData$default(kotlinx.coroutines.flow.f fVar, v8.j jVar, Duration duration, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            jVar = k.f19724a;
        }
        return asLiveData(fVar, jVar, duration);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> asLiveData(kotlinx.coroutines.flow.f<? extends T> fVar, v8.j context, Duration timeout) {
        m.f(fVar, "<this>");
        m.f(context, "context");
        m.f(timeout, "timeout");
        return asLiveData(fVar, context, Api26Impl.INSTANCE.toMillis(timeout));
    }
}
