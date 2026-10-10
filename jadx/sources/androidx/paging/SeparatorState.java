package androidx.paging;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import c9.l;
import c9.q;
import h9.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import r8.n;
import v8.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00028\u00002\u00020\u0001B:\u0012.\u0010\u0006\u001a*\b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00020\t\"\b\b\u0002\u0010\u0003*\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011*\b\u0012\u0004\u0012\u00028\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0016\u001a\u00020\u0015*\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0018\u001a\u00020\u0015*\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0017J!\u0010\u0016\u001a\u00020\u0015\"\b\b\u0002\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0019J!\u0010\u0018\u001a\u00020\u0015\"\b\b\u0002\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00020\u0011¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u001fH\u0086@ø\u0001\u0000¢\u0006\u0004\b \u0010!R#\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t0\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\"\u0010'\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010(\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u0017\u00101\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\"\u00106\u001a\u0002058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010<\u001a\u0002058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u00107\u001a\u0004\b=\u00109\"\u0004\b>\u0010;R\"\u0010?\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010(\u001a\u0004\b@\u0010*\"\u0004\bA\u0010,R\"\u0010B\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010(\u001a\u0004\bC\u0010*\"\u0004\bD\u0010,RB\u0010\u0006\u001a*\b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048\u0006ø\u0001\u0000¢\u0006\f\n\u0004\b\u0006\u0010E\u001a\u0004\bF\u0010G\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006H"}, d2 = {"Landroidx/paging/SeparatorState;", "", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function3;", "Lv8/f;", "generator", "<init>", "(Lc9/q;)V", "Landroidx/paging/TransformablePage;", "originalPage", "transformablePageToStash", "(Landroidx/paging/TransformablePage;)Landroidx/paging/TransformablePage;", "Landroidx/paging/PageEvent;", NotificationCompat.CATEGORY_EVENT, "onEvent", "(Landroidx/paging/PageEvent;Lv8/f;)Ljava/lang/Object;", "Landroidx/paging/PageEvent$Insert;", "asRType", "(Landroidx/paging/PageEvent$Insert;)Landroidx/paging/PageEvent$Insert;", "Landroidx/paging/CombinedLoadStates;", "", "terminatesStart", "(Landroidx/paging/CombinedLoadStates;)Z", "terminatesEnd", "(Landroidx/paging/PageEvent$Insert;)Z", "onInsert", "(Landroidx/paging/PageEvent$Insert;Lv8/f;)Ljava/lang/Object;", "Landroidx/paging/PageEvent$Drop;", "onDrop", "(Landroidx/paging/PageEvent$Drop;)Landroidx/paging/PageEvent$Drop;", "Landroidx/paging/PageEvent$LoadStateUpdate;", "onLoadStateUpdate", "(Landroidx/paging/PageEvent$LoadStateUpdate;Lv8/f;)Ljava/lang/Object;", "", "pageStash", "Ljava/util/List;", "getPageStash", "()Ljava/util/List;", "endTerminalSeparatorDeferred", "Z", "getEndTerminalSeparatorDeferred", "()Z", "setEndTerminalSeparatorDeferred", "(Z)V", "startTerminalSeparatorDeferred", "getStartTerminalSeparatorDeferred", "setStartTerminalSeparatorDeferred", "Landroidx/paging/MutableLoadStateCollection;", "loadStates", "Landroidx/paging/MutableLoadStateCollection;", "getLoadStates", "()Landroidx/paging/MutableLoadStateCollection;", "", "placeholdersBefore", "I", "getPlaceholdersBefore", "()I", "setPlaceholdersBefore", "(I)V", "placeholdersAfter", "getPlaceholdersAfter", "setPlaceholdersAfter", "footerAdded", "getFooterAdded", "setFooterAdded", "headerAdded", "getHeaderAdded", "setHeaderAdded", "Lc9/q;", "getGenerator", "()Lc9/q;", "paging-common"}, k = 1, mv = {1, 4, 1})
final class SeparatorState<R, T extends R> {
    private boolean endTerminalSeparatorDeferred;
    private boolean footerAdded;
    private final q<T, T, f<? super R>, Object> generator;
    private boolean headerAdded;
    private final MutableLoadStateCollection loadStates;
    private final List<TransformablePage<T>> pageStash;
    private int placeholdersAfter;
    private int placeholdersBefore;
    private boolean startTerminalSeparatorDeferred;

    /* JADX INFO: renamed from: androidx.paging.SeparatorState$onDrop$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u0002H\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "R", "", ExifInterface.GPS_DIRECTION_TRUE, "stash", "Landroidx/paging/TransformablePage;", "invoke"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1 extends o implements l<TransformablePage<T>, Boolean> {
        final /* synthetic */ e $pageOffsetsToDrop;

        @Override // c9.l
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
            return Boolean.valueOf(invoke((TransformablePage) obj));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(e eVar) {
            super(1);
            this.$pageOffsetsToDrop = eVar;
        }

        public final boolean invoke(TransformablePage<T> stash) {
            m.f(stash, "stash");
            for (int i10 : stash.getOriginalPageOffsets()) {
                if (this.$pageOffsetsToDrop.n(i10)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.SeparatorState$onEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.paging.SeparatorState", f = "Separators.kt", l = {180, 182}, m = "onEvent")
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0005H\u0086@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "R", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/PageEvent;", NotificationCompat.CATEGORY_EVENT, "Lv8/f;", "continuation", "onEvent", "(Landroidx/paging/PageEvent;Lv8/f;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    static final class C05651 extends d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C05651(f fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SeparatorState.this.onEvent(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.SeparatorState$onInsert$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.paging.SeparatorState", f = "Separators.kt", l = {246, 309, 321, 327, 339, 348, 370, 379, 392, TypedValues.CycleType.TYPE_ALPHA}, m = "onInsert")
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0005H\u0086@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "R", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/PageEvent$Insert;", NotificationCompat.CATEGORY_EVENT, "Lv8/f;", "continuation", "onInsert", "(Landroidx/paging/PageEvent$Insert;Lv8/f;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    static final class C05661 extends d {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C05661(f fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SeparatorState.this.onInsert(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:123:0x040a  */
    /* JADX WARN: Code duplicated, block: B:126:0x0440  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:126:0x0440 -> B:127:0x0447). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:187:0x0645 -> B:17:0x00d1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:213:0x072b -> B:214:0x072c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object onInsert(androidx.paging.PageEvent.Insert<T> r28, v8.f<? super androidx.paging.PageEvent.Insert<R>> r29) {
        /*
            Method dump skipped, instruction units count: 2080
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SeparatorState.onInsert(androidx.paging.PageEvent$Insert, v8.f):java.lang.Object");
    }

    public final boolean terminatesEnd(CombinedLoadStates terminatesEnd) {
        LoadState append;
        m.f(terminatesEnd, "$this$terminatesEnd");
        if (!terminatesEnd.getSource().getAppend().getEndOfPaginationReached()) {
            return false;
        }
        LoadStates mediator = terminatesEnd.getMediator();
        return mediator == null || (append = mediator.getAppend()) == null || append.getEndOfPaginationReached();
    }

    public final boolean terminatesStart(CombinedLoadStates terminatesStart) {
        LoadState prepend;
        m.f(terminatesStart, "$this$terminatesStart");
        if (!terminatesStart.getSource().getPrepend().getEndOfPaginationReached()) {
            return false;
        }
        LoadStates mediator = terminatesStart.getMediator();
        return mediator == null || (prepend = mediator.getPrepend()) == null || prepend.getEndOfPaginationReached();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SeparatorState(q<? super T, ? super T, ? super f<? super R>, ? extends Object> generator) {
        m.f(generator, "generator");
        this.generator = generator;
        this.pageStash = new ArrayList();
        this.loadStates = new MutableLoadStateCollection();
    }

    private final <T> TransformablePage<T> transformablePageToStash(TransformablePage<T> originalPage) {
        Integer num;
        Integer num2;
        int[] originalPageOffsets = originalPage.getOriginalPageOffsets();
        List listO = r.o(r.g0(originalPage.getData()), r.s0(originalPage.getData()));
        int hintOriginalPageOffset = originalPage.getHintOriginalPageOffset();
        List<Integer> hintOriginalIndices = originalPage.getHintOriginalIndices();
        Integer numValueOf = Integer.valueOf((hintOriginalIndices == null || (num2 = (Integer) r.g0(hintOriginalIndices)) == null) ? 0 : num2.intValue());
        List<Integer> hintOriginalIndices2 = originalPage.getHintOriginalIndices();
        return new TransformablePage<>(originalPageOffsets, listO, hintOriginalPageOffset, r.o(numValueOf, Integer.valueOf((hintOriginalIndices2 == null || (num = (Integer) r.s0(hintOriginalIndices2)) == null) ? r.n(originalPage.getData()) : num.intValue())));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PageEvent.Insert<R> asRType(PageEvent.Insert<T> asRType) {
        m.f(asRType, "$this$asRType");
        return asRType;
    }

    public final boolean getEndTerminalSeparatorDeferred() {
        return this.endTerminalSeparatorDeferred;
    }

    public final boolean getFooterAdded() {
        return this.footerAdded;
    }

    public final q<T, T, f<? super R>, Object> getGenerator() {
        return this.generator;
    }

    public final boolean getHeaderAdded() {
        return this.headerAdded;
    }

    public final MutableLoadStateCollection getLoadStates() {
        return this.loadStates;
    }

    public final List<TransformablePage<T>> getPageStash() {
        return this.pageStash;
    }

    public final int getPlaceholdersAfter() {
        return this.placeholdersAfter;
    }

    public final int getPlaceholdersBefore() {
        return this.placeholdersBefore;
    }

    public final boolean getStartTerminalSeparatorDeferred() {
        return this.startTerminalSeparatorDeferred;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PageEvent.Drop<R> onDrop(PageEvent.Drop<T> event) {
        m.f(event, "event");
        this.loadStates.set(event.getLoadType(), false, LoadState.NotLoading.INSTANCE.getIncomplete$paging_common());
        LoadType loadType = event.getLoadType();
        LoadType loadType2 = LoadType.PREPEND;
        if (loadType == loadType2) {
            this.placeholdersBefore = event.getPlaceholdersRemaining();
            this.headerAdded = false;
        } else if (event.getLoadType() == LoadType.APPEND) {
            this.placeholdersAfter = event.getPlaceholdersRemaining();
            this.footerAdded = false;
        }
        if (this.pageStash.isEmpty()) {
            if (event.getLoadType() == loadType2) {
                this.startTerminalSeparatorDeferred = false;
            } else {
                this.endTerminalSeparatorDeferred = false;
            }
        }
        r.I(this.pageStash, new AnonymousClass1(new e(event.getMinPageOffset(), event.getMaxPageOffset())));
        return event;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [androidx.paging.SeparatorState, androidx.paging.SeparatorState<R, T extends R>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [androidx.paging.SeparatorState] */
    public final Object onEvent(PageEvent<T> pageEvent, f<? super PageEvent<R>> fVar) {
        C05651 c05651;
        ?? r10;
        Object objOnDrop;
        ?? r11;
        ?? r12;
        if (fVar instanceof C05651) {
            c05651 = (C05651) fVar;
            int i10 = c05651.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c05651.label = i10 - Integer.MIN_VALUE;
            } else {
                c05651 = new C05651(fVar);
            }
        } else {
            c05651 = new C05651(fVar);
        }
        Object objOnLoadStateUpdate = c05651.result;
        Object objC = b.c();
        int i11 = c05651.label;
        if (i11 == 0) {
            r8.r.b(objOnLoadStateUpdate);
            if (pageEvent instanceof PageEvent.Insert) {
                c05651.L$0 = this;
                c05651.label = 1;
                objOnLoadStateUpdate = onInsert((PageEvent.Insert) pageEvent, c05651);
                if (objOnLoadStateUpdate != objC) {
                    r12 = this;
                    objOnDrop = (PageEvent) objOnLoadStateUpdate;
                    r11 = r12;
                }
            } else if (pageEvent instanceof PageEvent.Drop) {
                objOnDrop = onDrop((PageEvent.Drop) pageEvent);
                r11 = this;
            } else {
                if (!(pageEvent instanceof PageEvent.LoadStateUpdate)) {
                    throw new n();
                }
                c05651.L$0 = this;
                c05651.label = 2;
                objOnLoadStateUpdate = onLoadStateUpdate((PageEvent.LoadStateUpdate) pageEvent, c05651);
                if (objOnLoadStateUpdate != objC) {
                    r10 = this;
                    objOnDrop = (PageEvent) objOnLoadStateUpdate;
                    r11 = r10;
                }
            }
            return objC;
        }
        if (i11 == 1) {
            SeparatorState separatorState = (SeparatorState) c05651.L$0;
            r8.r.b(objOnLoadStateUpdate);
            r12 = separatorState;
            objOnDrop = (PageEvent) objOnLoadStateUpdate;
            r11 = r12;
        } else {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            SeparatorState separatorState2 = (SeparatorState) c05651.L$0;
            r8.r.b(objOnLoadStateUpdate);
            r10 = separatorState2;
            objOnDrop = (PageEvent) objOnLoadStateUpdate;
            r11 = r10;
        }
        if (r11.endTerminalSeparatorDeferred && !r11.pageStash.isEmpty()) {
            throw new IllegalStateException("deferred endTerm, page stash should be empty");
        }
        if (!r11.startTerminalSeparatorDeferred || r11.pageStash.isEmpty()) {
            return objOnDrop;
        }
        throw new IllegalStateException("deferred startTerm, page stash should be empty");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object onLoadStateUpdate(PageEvent.LoadStateUpdate<T> loadStateUpdate, f<? super PageEvent<R>> fVar) {
        if (m.a(this.loadStates.get(loadStateUpdate.getLoadType(), loadStateUpdate.getFromMediator()), loadStateUpdate.getLoadState())) {
            return loadStateUpdate;
        }
        this.loadStates.set(loadStateUpdate.getLoadType(), loadStateUpdate.getFromMediator(), loadStateUpdate.getLoadState());
        if (loadStateUpdate.getLoadType() != LoadType.REFRESH && loadStateUpdate.getFromMediator() && loadStateUpdate.getLoadState().getEndOfPaginationReached()) {
            return onInsert(loadStateUpdate.getLoadType() == LoadType.PREPEND ? PageEvent.Insert.INSTANCE.Prepend(r.l(), this.placeholdersBefore, this.loadStates.snapshot()) : PageEvent.Insert.INSTANCE.Append(r.l(), this.placeholdersAfter, this.loadStates.snapshot()), fVar);
        }
        return loadStateUpdate;
    }

    public final void setEndTerminalSeparatorDeferred(boolean z10) {
        this.endTerminalSeparatorDeferred = z10;
    }

    public final void setFooterAdded(boolean z10) {
        this.footerAdded = z10;
    }

    public final void setHeaderAdded(boolean z10) {
        this.headerAdded = z10;
    }

    public final void setPlaceholdersAfter(int i10) {
        this.placeholdersAfter = i10;
    }

    public final void setPlaceholdersBefore(int i10) {
        this.placeholdersBefore = i10;
    }

    public final void setStartTerminalSeparatorDeferred(boolean z10) {
        this.startTerminalSeparatorDeferred = z10;
    }

    public final <T> boolean terminatesEnd(PageEvent.Insert<T> terminatesEnd) {
        m.f(terminatesEnd, "$this$terminatesEnd");
        return terminatesEnd.getLoadType() == LoadType.PREPEND ? this.endTerminalSeparatorDeferred : terminatesEnd(terminatesEnd.getCombinedLoadStates());
    }

    public final <T> boolean terminatesStart(PageEvent.Insert<T> terminatesStart) {
        m.f(terminatesStart, "$this$terminatesStart");
        return terminatesStart.getLoadType() == LoadType.APPEND ? this.startTerminalSeparatorDeferred : terminatesStart(terminatesStart.getCombinedLoadStates());
    }
}
