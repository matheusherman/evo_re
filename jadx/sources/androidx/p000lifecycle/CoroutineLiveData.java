package androidx.p000lifecycle;

import androidx.exifinterface.media.ExifInterface;
import c9.a;
import c9.p;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.b1;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.u1;
import r8.r;
import r8.z;
import v8.f;
import v8.j;
import v8.k;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BH\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012(\u0010\f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0014\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0017\u001a\u00020\nH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001a\u0010\u0019R\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 \u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Landroidx/lifecycle/CoroutineLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MediatorLiveData;", "Lv8/j;", "context", "", "timeoutInMs", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lv8/f;", "Lr8/z;", "", "block", "<init>", "(Lv8/j;JLc9/p;)V", "Landroidx/lifecycle/LiveData;", "source", "Lkotlinx/coroutines/b1;", "emitSource$lifecycle_livedata_ktx_release", "(Landroidx/lifecycle/LiveData;Lv8/f;)Ljava/lang/Object;", "emitSource", "clearSource$lifecycle_livedata_ktx_release", "(Lv8/f;)Ljava/lang/Object;", "clearSource", "onActive", "()V", "onInactive", "Landroidx/lifecycle/BlockRunner;", "blockRunner", "Landroidx/lifecycle/BlockRunner;", "Landroidx/lifecycle/EmittedSource;", "emittedSource", "Landroidx/lifecycle/EmittedSource;", "lifecycle-livedata-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CoroutineLiveData<T> extends MediatorLiveData<T> {
    private BlockRunner<T> blockRunner;
    private EmittedSource emittedSource;

    /* JADX INFO: renamed from: androidx.lifecycle.CoroutineLiveData$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lr8/z;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    static final class AnonymousClass1 extends o implements a<z> {
        final /* synthetic */ CoroutineLiveData<T> this$0;

        @Override // c9.a
        public /* bridge */ /* synthetic */ z invoke() {
            invoke2();
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CoroutineLiveData<T> coroutineLiveData) {
            super(0);
            this.this$0 = coroutineLiveData;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((CoroutineLiveData) this.this$0).blockRunner = null;
        }
    }

    public /* synthetic */ CoroutineLiveData(j jVar, long j10, p pVar, int i10, g gVar) {
        this((i10 & 1) != 0 ? k.f19724a : jVar, (i10 & 2) != 0 ? CoroutineLiveDataKt.DEFAULT_TIMEOUT : j10, pVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object clearSource$lifecycle_livedata_ktx_release(f<? super z> fVar) {
        CoroutineLiveData$clearSource$1 coroutineLiveData$clearSource$1;
        CoroutineLiveData<T> coroutineLiveData;
        if (fVar instanceof CoroutineLiveData$clearSource$1) {
            coroutineLiveData$clearSource$1 = (CoroutineLiveData$clearSource$1) fVar;
            int i10 = coroutineLiveData$clearSource$1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                coroutineLiveData$clearSource$1.label = i10 - Integer.MIN_VALUE;
            } else {
                coroutineLiveData$clearSource$1 = new CoroutineLiveData$clearSource$1(this, fVar);
            }
        } else {
            coroutineLiveData$clearSource$1 = new CoroutineLiveData$clearSource$1(this, fVar);
        }
        Object obj = coroutineLiveData$clearSource$1.result;
        Object objC = b.c();
        int i11 = coroutineLiveData$clearSource$1.label;
        if (i11 == 0) {
            r.b(obj);
            EmittedSource emittedSource = this.emittedSource;
            if (emittedSource != null) {
                coroutineLiveData$clearSource$1.L$0 = this;
                coroutineLiveData$clearSource$1.label = 1;
                if (emittedSource.disposeNow(coroutineLiveData$clearSource$1) == objC) {
                    return objC;
                }
            }
            coroutineLiveData = this;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineLiveData = (CoroutineLiveData) coroutineLiveData$clearSource$1.L$0;
            r.b(obj);
        }
        coroutineLiveData.emittedSource = null;
        return z.f17874a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0063, code lost:
    
        if (r7 == r1) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emitSource$lifecycle_livedata_ktx_release(LiveData<T> liveData, f<? super b1> fVar) {
        CoroutineLiveData$emitSource$1 coroutineLiveData$emitSource$1;
        LiveData<T> liveData2;
        CoroutineLiveData coroutineLiveData;
        CoroutineLiveData coroutineLiveData2;
        if (fVar instanceof CoroutineLiveData$emitSource$1) {
            coroutineLiveData$emitSource$1 = (CoroutineLiveData$emitSource$1) fVar;
            int i10 = coroutineLiveData$emitSource$1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                coroutineLiveData$emitSource$1.label = i10 - Integer.MIN_VALUE;
            } else {
                coroutineLiveData$emitSource$1 = new CoroutineLiveData$emitSource$1(this, fVar);
            }
        } else {
            coroutineLiveData$emitSource$1 = new CoroutineLiveData$emitSource$1(this, fVar);
        }
        Object objAddDisposableSource = coroutineLiveData$emitSource$1.result;
        Object objC = b.c();
        int i11 = coroutineLiveData$emitSource$1.label;
        if (i11 == 0) {
            r.b(objAddDisposableSource);
            coroutineLiveData$emitSource$1.L$0 = this;
            coroutineLiveData$emitSource$1.L$1 = liveData;
            coroutineLiveData$emitSource$1.label = 1;
            if (clearSource$lifecycle_livedata_ktx_release(coroutineLiveData$emitSource$1) != objC) {
                liveData2 = liveData;
                coroutineLiveData = this;
            }
            return objC;
        }
        if (i11 == 1) {
            LiveData<T> liveData3 = (LiveData) coroutineLiveData$emitSource$1.L$1;
            CoroutineLiveData coroutineLiveData3 = (CoroutineLiveData) coroutineLiveData$emitSource$1.L$0;
            r.b(objAddDisposableSource);
            liveData2 = liveData3;
            coroutineLiveData = coroutineLiveData3;
        } else {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            CoroutineLiveData coroutineLiveData4 = (CoroutineLiveData) coroutineLiveData$emitSource$1.L$0;
            r.b(objAddDisposableSource);
            coroutineLiveData2 = coroutineLiveData4;
        }
        EmittedSource emittedSource = (EmittedSource) objAddDisposableSource;
        coroutineLiveData2.emittedSource = emittedSource;
        return emittedSource;
        coroutineLiveData$emitSource$1.L$0 = coroutineLiveData;
        coroutineLiveData$emitSource$1.L$1 = null;
        coroutineLiveData$emitSource$1.label = 2;
        objAddDisposableSource = CoroutineLiveDataKt.addDisposableSource(coroutineLiveData, liveData2, coroutineLiveData$emitSource$1);
        coroutineLiveData2 = coroutineLiveData;
    }

    public CoroutineLiveData(j context, long j10, p<? super LiveDataScope<T>, ? super f<? super z>, ? extends Object> block) {
        m.f(context, "context");
        m.f(block, "block");
        this.blockRunner = new BlockRunner<>(this, block, j10, m0.a(a1.c().getImmediate().plus(context).plus(q2.a((u1) context.get(u1.INSTANCE)))), new AnonymousClass1(this));
    }

    @Override // androidx.p000lifecycle.MediatorLiveData, androidx.p000lifecycle.LiveData
    protected void onActive() {
        super.onActive();
        BlockRunner<T> blockRunner = this.blockRunner;
        if (blockRunner != null) {
            blockRunner.maybeRun();
        }
    }

    @Override // androidx.p000lifecycle.MediatorLiveData, androidx.p000lifecycle.LiveData
    protected void onInactive() {
        super.onInactive();
        BlockRunner<T> blockRunner = this.blockRunner;
        if (blockRunner != null) {
            blockRunner.cancel();
        }
    }
}
