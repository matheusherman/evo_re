package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.taobao.sophix.PatchStatus;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.flow.g;
import r8.r;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"androidx/paging/PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1", "Lkotlinx/coroutines/flow/g;", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 1})
public final class PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1 implements g<LoadStates> {
    final /* synthetic */ b0 $prev$inlined;
    final /* synthetic */ PageFetcher.C05411.AnonymousClass2 this$0;

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1$1, reason: invalid class name */
    @f(c = "androidx.paging.PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1", f = "PageFetcher.kt", l = {PatchStatus.CODE_LOAD_LIB_UNZIP, 139, 143}, m = "emit")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lv8/f;", "Lr8/z;", "continuation", "", "emit"}, k = 3, mv = {1, 4, 1})
    public static final class AnonymousClass1 extends d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v8.f fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1.this.emit(null, this);
        }
    }

    public PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1(PageFetcher.C05411.AnonymousClass2 anonymousClass2, b0 b0Var) {
        this.this$0 = anonymousClass2;
        this.$prev$inlined = b0Var;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00cb A[PHI: r2 r9
      0x00cb: PHI (r2v5 androidx.paging.PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1) = 
      (r2v4 androidx.paging.PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1)
      (r2v4 androidx.paging.PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1)
      (r2v11 androidx.paging.PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1)
     binds: [B:25:0x00a7, B:27:0x00c8, B:16:0x0040] A[DONT_GENERATE, DONT_INLINE]
      0x00cb: PHI (r9v3 androidx.paging.LoadStates) = (r9v18 androidx.paging.LoadStates), (r9v19 androidx.paging.LoadStates), (r9v20 androidx.paging.LoadStates) binds: [B:25:0x00a7, B:27:0x00c8, B:16:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:31:0x00df  */
    /* JADX WARN: Code duplicated, block: B:34:0x0101  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0091, code lost:
    
        if (r10.invoke2(r2, r6, (v8.f<? super r8.z>) r0) == r1) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.flow.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(LoadStates loadStates, v8.f fVar) {
        AnonymousClass1 anonymousClass1;
        PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1 pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1;
        LoadStates loadStates2;
        LoadStates loadStates3;
        boolean zA;
        LoadType loadType;
        PageFetcher.C05411.C00171 c00171;
        LoadState append;
        PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1 pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$2;
        T t10;
        LoadStates loadStates4;
        if (fVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) fVar;
            int i10 = anonymousClass1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i10 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(fVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(fVar);
        }
        Object obj = anonymousClass1.result;
        Object objC = b.c();
        int i11 = anonymousClass1.label;
        if (i11 != 0) {
            if (i11 == 1) {
                LoadStates loadStates5 = (LoadStates) anonymousClass1.L$1;
                pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1 = (PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1) anonymousClass1.L$0;
                r.b(obj);
                loadStates2 = loadStates5;
            } else {
                if (i11 == 2) {
                    LoadStates loadStates6 = (LoadStates) anonymousClass1.L$1;
                    pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1 = (PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1) anonymousClass1.L$0;
                    r.b(obj);
                    loadStates3 = loadStates6;
                    loadStates3 = loadStates2;
                    zA = m.a(((LoadStates) pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1.$prev$inlined.element).getAppend(), loadStates3.getAppend());
                    t10 = loadStates3;
                    if (!zA) {
                        MutableLoadStateCollection mutableLoadStateCollection = pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1.this$0.$loadStates;
                        loadType = LoadType.APPEND;
                        mutableLoadStateCollection.set(loadType, true, loadStates3.getAppend());
                        c00171 = pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1.this$0.$dispatchIfValid$1;
                        append = loadStates3.getAppend();
                        anonymousClass1.L$0 = pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1;
                        anonymousClass1.L$1 = loadStates3;
                        anonymousClass1.label = 3;
                        if (c00171.invoke(loadType, append, (v8.f<? super z>) anonymousClass1) != objC) {
                            pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$2 = pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1;
                            loadStates4 = loadStates3;
                        }
                        loadStates3 = loadStates2;
                        return objC;
                    }
                    pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1.$prev$inlined.element = t10;
                    return z.f17874a;
                }
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LoadStates loadStates7 = (LoadStates) anonymousClass1.L$1;
                pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$2 = (PageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1) anonymousClass1.L$0;
                r.b(obj);
                loadStates4 = loadStates7;
            }
            pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1 = pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$2;
            t10 = loadStates4;
            pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1.$prev$inlined.element = t10;
            return z.f17874a;
        }
        r.b(obj);
        LoadStates loadStates8 = loadStates;
        if (!m.a(((LoadStates) this.$prev$inlined.element).getRefresh(), loadStates8.getRefresh())) {
            MutableLoadStateCollection mutableLoadStateCollection2 = this.this$0.$loadStates;
            LoadType loadType2 = LoadType.REFRESH;
            mutableLoadStateCollection2.set(loadType2, true, loadStates8.getRefresh());
            PageFetcher.C05411.C00171 c00172 = this.this$0.$dispatchIfValid$1;
            LoadState refresh = loadStates8.getRefresh();
            anonymousClass1.L$0 = this;
            anonymousClass1.L$1 = loadStates8;
            anonymousClass1.label = 1;
        }
        pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1 = this;
        loadStates2 = loadStates8;
        boolean zA2 = m.a(((LoadStates) pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1.$prev$inlined.element).getPrepend(), loadStates2.getPrepend());
        loadStates3 = loadStates2;
        if (!zA2) {
            MutableLoadStateCollection mutableLoadStateCollection3 = pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1.this$0.$loadStates;
            LoadType loadType3 = LoadType.PREPEND;
            mutableLoadStateCollection3.set(loadType3, true, loadStates2.getPrepend());
            PageFetcher.C05411.C00171 c00173 = pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1.this$0.$dispatchIfValid$1;
            LoadState prepend = loadStates2.getPrepend();
            anonymousClass1.L$0 = pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1;
            anonymousClass1.L$1 = loadStates2;
            anonymousClass1.label = 2;
            if (c00173.invoke(loadType3, prepend, (v8.f<? super z>) anonymousClass1) != objC) {
                loadStates3 = loadStates2;
                zA = m.a(((LoadStates) pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1.$prev$inlined.element).getAppend(), loadStates3.getAppend());
                t10 = loadStates3;
                if (!zA) {
                    MutableLoadStateCollection mutableLoadStateCollection4 = pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1.this$0.$loadStates;
                    loadType = LoadType.APPEND;
                    mutableLoadStateCollection4.set(loadType, true, loadStates3.getAppend());
                    c00171 = pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1.this$0.$dispatchIfValid$1;
                    append = loadStates3.getAppend();
                    anonymousClass1.L$0 = pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1;
                    anonymousClass1.L$1 = loadStates3;
                    anonymousClass1.label = 3;
                    if (c00171.invoke(loadType, append, (v8.f<? super z>) anonymousClass1) != objC) {
                        pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$2 = pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1;
                        loadStates4 = loadStates3;
                        pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1 = pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$2;
                        t10 = loadStates4;
                    }
                }
            }
            loadStates3 = loadStates2;
            return objC;
        }
        loadStates3 = loadStates2;
        zA = m.a(((LoadStates) pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1.$prev$inlined.element).getAppend(), loadStates3.getAppend());
        t10 = loadStates3;
        if (!zA) {
            MutableLoadStateCollection mutableLoadStateCollection5 = pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1.this$0.$loadStates;
            loadType = LoadType.APPEND;
            mutableLoadStateCollection5.set(loadType, true, loadStates3.getAppend());
            c00171 = pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1.this$0.$dispatchIfValid$1;
            append = loadStates3.getAppend();
            anonymousClass1.L$0 = pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1;
            anonymousClass1.L$1 = loadStates3;
            anonymousClass1.label = 3;
            if (c00171.invoke(loadType, append, (v8.f<? super z>) anonymousClass1) != objC) {
                pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$2 = pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1;
                loadStates4 = loadStates3;
                pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1 = pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$2;
                t10 = loadStates4;
            }
            loadStates3 = loadStates2;
            return objC;
        }
        pageFetcher$injectRemoteEvents$1$2$invokeSuspend$$inlined$collect$1.$prev$inlined.element = t10;
        return z.f17874a;
    }
}
