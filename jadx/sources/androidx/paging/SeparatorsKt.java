package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import c9.q;
import com.taobao.sophix.PatchStatus;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.j;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.flow.g;
import r8.r;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ag\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00032.\u0010\u0006\u001a*\b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a?\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0002*\u00020\u00002\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001aK\u0010\u0013\u001a\u00020\u0012\"\b\b\u0000\u0010\u0002*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00112\b\u0010\t\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001am\u0010\u0013\u001a\u00020\u0012\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00028\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00112\b\u0010\t\u001a\u0004\u0018\u00018\u00002\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00032\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0013\u0010\u0017\u001ar\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00190\u0018\"\b\b\u0000\u0010\u0002*\u00028\u0001\"\b\b\u0001\u0010\u0001*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00190\u00182.\u0010\u0006\u001a*\b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"", "R", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/TransformablePage;", "Lkotlin/Function3;", "Lv8/f;", "generator", "insertInternalSeparators", "(Landroidx/paging/TransformablePage;Lc9/q;Lv8/f;)Ljava/lang/Object;", "separator", "", "originalPageOffsets", "", "hintOriginalPageOffset", "hintOriginalIndex", "separatorPage", "(Ljava/lang/Object;[III)Landroidx/paging/TransformablePage;", "", "Lr8/z;", "addSeparatorPage", "(Ljava/util/List;Ljava/lang/Object;[III)V", "adjacentPageBefore", "adjacentPageAfter", "(Ljava/util/List;Ljava/lang/Object;Landroidx/paging/TransformablePage;Landroidx/paging/TransformablePage;II)V", "Lkotlinx/coroutines/flow/f;", "Landroidx/paging/PageEvent;", "insertEventSeparators", "(Lkotlinx/coroutines/flow/f;Lc9/q;)Lkotlinx/coroutines/flow/f;", "paging-common"}, k = 2, mv = {1, 4, 1})
public final class SeparatorsKt {

    /* JADX INFO: renamed from: androidx.paging.SeparatorsKt$insertInternalSeparators$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.SeparatorsKt", f = "Separators.kt", l = {50}, m = "insertInternalSeparators")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00032.\u0010\u0006\u001a*\b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00042\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0005H\u0080@¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "R", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/TransformablePage;", "Lkotlin/Function3;", "Lv8/f;", "generator", "continuation", "insertInternalSeparators", "(Landroidx/paging/TransformablePage;Lc9/q;Lv8/f;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1 extends d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SeparatorsKt.insertInternalSeparators(null, null, this);
        }

        AnonymousClass1(v8.f fVar) {
            super(fVar);
        }
    }

    public static final <T> void addSeparatorPage(List<TransformablePage<T>> addSeparatorPage, T t10, int[] originalPageOffsets, int i10, int i11) {
        m.f(addSeparatorPage, "$this$addSeparatorPage");
        m.f(originalPageOffsets, "originalPageOffsets");
        if (t10 == null) {
            return;
        }
        addSeparatorPage.add(separatorPage(t10, originalPageOffsets, i10, i11));
    }

    public static final <T extends R, R> kotlinx.coroutines.flow.f<PageEvent<R>> insertEventSeparators(final kotlinx.coroutines.flow.f<? extends PageEvent<T>> insertEventSeparators, q<? super T, ? super T, ? super v8.f<? super R>, ? extends Object> generator) {
        m.f(insertEventSeparators, "$this$insertEventSeparators");
        m.f(generator, "generator");
        final SeparatorState separatorState = new SeparatorState(new SeparatorsKt$insertEventSeparators$separatorState$1(generator, null));
        return new kotlinx.coroutines.flow.f<PageEvent<R>>() { // from class: androidx.paging.SeparatorsKt$insertEventSeparators$$inlined$map$1

            /* JADX INFO: Add missing generic type declarations: [T] */
            /* JADX INFO: renamed from: androidx.paging.SeparatorsKt$insertEventSeparators$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/g;", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 1})
            public static final class AnonymousClass2<T> implements g<PageEvent<T>> {
                final /* synthetic */ g $this_unsafeFlow$inlined;
                final /* synthetic */ SeparatorsKt$insertEventSeparators$$inlined$map$1 this$0;

                /* JADX INFO: renamed from: androidx.paging.SeparatorsKt$insertEventSeparators$$inlined$map$1$2$1, reason: invalid class name */
                @f(c = "androidx.paging.SeparatorsKt$insertEventSeparators$$inlined$map$1$2", f = "Separators.kt", l = {PatchStatus.CODE_LOAD_LIB_UNZIP, PatchStatus.CODE_LOAD_LIB_UNZIP}, m = "emit")
                @Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lv8/f;", "Lr8/z;", "continuation", "", "emit"}, k = 3, mv = {1, 4, 1})
                public static final class AnonymousClass1 extends d {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    Object L$7;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(v8.f fVar) {
                        super(fVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(g gVar, SeparatorsKt$insertEventSeparators$$inlined$map$1 separatorsKt$insertEventSeparators$$inlined$map$1) {
                    this.$this_unsafeFlow$inlined = gVar;
                    this.this$0 = separatorsKt$insertEventSeparators$$inlined$map$1;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
                
                    if (r7.emit(r8, r0) == r1) goto L22;
                 */
                @Override // kotlinx.coroutines.flow.g
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(Object obj, v8.f fVar) {
                    AnonymousClass1 anonymousClass1;
                    g gVar;
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
                    Object obj2 = anonymousClass1.result;
                    Object objC = b.c();
                    int i11 = anonymousClass1.label;
                    if (i11 != 0) {
                        if (i11 == 1) {
                            g gVar2 = (g) anonymousClass1.L$0;
                            r.b(obj2);
                            gVar = gVar2;
                        } else {
                            if (i11 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            r.b(obj2);
                        }
                        return z.f17874a;
                    }
                    r.b(obj2);
                    g gVar3 = this.$this_unsafeFlow$inlined;
                    SeparatorState separatorState = separatorState;
                    anonymousClass1.L$0 = gVar3;
                    anonymousClass1.label = 1;
                    Object objOnEvent = separatorState.onEvent((PageEvent) obj, anonymousClass1);
                    if (objOnEvent != objC) {
                        obj2 = objOnEvent;
                        gVar = gVar3;
                    }
                    return objC;
                    anonymousClass1.L$0 = null;
                    anonymousClass1.label = 2;
                }
            }

            @Override // kotlinx.coroutines.flow.f
            public Object collect(g gVar, v8.f fVar) {
                Object objCollect = insertEventSeparators.collect(new AnonymousClass2(gVar, this), fVar);
                return objCollect == b.c() ? objCollect : z.f17874a;
            }
        };
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:28:0x00cd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:31:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00ce -> B:12:0x0041). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final <R, T extends R> java.lang.Object insertInternalSeparators(androidx.paging.TransformablePage<T> r10, c9.q<? super T, ? super T, ? super v8.f<? super R>, ? extends java.lang.Object> r11, v8.f<? super androidx.paging.TransformablePage<R>> r12) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SeparatorsKt.insertInternalSeparators(androidx.paging.TransformablePage, c9.q, v8.f):java.lang.Object");
    }

    public static final <T> TransformablePage<T> separatorPage(T separator, int[] originalPageOffsets, int i10, int i11) {
        m.f(separator, "separator");
        m.f(originalPageOffsets, "originalPageOffsets");
        return new TransformablePage<>(originalPageOffsets, kotlin.collections.r.e(separator), i10, kotlin.collections.r.e(Integer.valueOf(i11)));
    }

    public static final <R, T extends R> void addSeparatorPage(List<TransformablePage<R>> addSeparatorPage, R r10, TransformablePage<T> transformablePage, TransformablePage<T> transformablePage2, int i10, int i11) {
        m.f(addSeparatorPage, "$this$addSeparatorPage");
        int[] originalPageOffsets = transformablePage != null ? transformablePage.getOriginalPageOffsets() : null;
        int[] originalPageOffsets2 = transformablePage2 != null ? transformablePage2.getOriginalPageOffsets() : null;
        if (originalPageOffsets != null && originalPageOffsets2 != null) {
            originalPageOffsets = kotlin.collections.r.N0(kotlin.collections.r.I0(j.K(j.v(originalPageOffsets, originalPageOffsets2))));
        } else if (originalPageOffsets == null && originalPageOffsets2 != null) {
            originalPageOffsets = originalPageOffsets2;
        } else if (originalPageOffsets == null || originalPageOffsets2 != null) {
            throw new IllegalArgumentException("Separator page expected adjacentPageBefore or adjacentPageAfter, but both were null.");
        }
        addSeparatorPage(addSeparatorPage, r10, originalPageOffsets, i10, i11);
    }
}
