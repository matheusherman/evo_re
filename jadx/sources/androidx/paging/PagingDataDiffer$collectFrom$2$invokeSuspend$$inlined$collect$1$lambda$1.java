package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.y;
import kotlinx.coroutines.l0;
import r8.r;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@f(c = "androidx.paging.PagingDataDiffer$collectFrom$2$1$1", f = "PagingDataDiffer.kt", l = {141, 177}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/l0;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "androidx/paging/PagingDataDiffer$collectFrom$2$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1 extends l implements p<l0, v8.f<? super z>, Object> {
    final /* synthetic */ PageEvent $event;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 this$0;

    /* JADX INFO: renamed from: androidx.paging.PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lr8/z;", "invoke", "()V", "androidx/paging/PagingDataDiffer$collectFrom$2$1$1$transformedLastAccessedIndex$1", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1 extends o implements c9.a<z> {
        final /* synthetic */ PagePresenter $newPresenter;
        final /* synthetic */ y $onListPresentableCalled;

        @Override // c9.a
        public /* bridge */ /* synthetic */ z invoke() {
            invoke2();
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PagePresenter pagePresenter, y yVar) {
            super(0);
            this.$newPresenter = pagePresenter;
            this.$onListPresentableCalled = yVar;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PagingDataDiffer.this.presenter = this.$newPresenter;
            this.$onListPresentableCalled.element = true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1(PageEvent pageEvent, v8.f fVar, PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1) {
        super(2, fVar);
        this.$event = pageEvent;
        this.this$0 = pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final v8.f<z> create(Object obj, v8.f<?> completion) {
        m.f(completion, "completion");
        return new PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1(this.$event, completion, this.this$0);
    }

    @Override // c9.p
    public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
        return ((PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1) create(l0Var, fVar)).invokeSuspend(z.f17874a);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x008f  */
    /* JADX WARN: Code duplicated, block: B:22:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:24:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:25:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:27:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:28:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:37:0x011a  */
    /* JADX WARN: Code duplicated, block: B:40:0x0129  */
    /* JADX WARN: Code duplicated, block: B:50:0x017b  */
    /* JADX WARN: Code duplicated, block: B:52:0x0195  */
    /* JADX WARN: Code duplicated, block: B:56:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:58:0x01d5  */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f8, code lost:
    
        if (kotlinx.coroutines.z2.a(r12) == r0) goto L34;
     */
    @Override // kotlin.coroutines.jvm.internal.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1 pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1;
        PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1 pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$2;
        y yVar;
        PagePresenter pagePresenter;
        Integer num;
        UiReceiver uiReceiver;
        UiReceiver uiReceiver2;
        PageEvent pageEvent;
        UiReceiver uiReceiver3;
        Object objC = b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    r.b(obj);
                    pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1 = this;
                    PagingDataDiffer.this.presenter.processEvent(pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1.$event, PagingDataDiffer.this.processPageEventCallback);
                    if (pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1.$event instanceof PageEvent.Drop) {
                        PagingDataDiffer.this.lastAccessedIndexUnfulfilled = false;
                    }
                    pageEvent = pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1.$event;
                    if (pageEvent instanceof PageEvent.Insert) {
                        boolean endOfPaginationReached = ((PageEvent.Insert) pageEvent).getCombinedLoadStates().getPrepend().getEndOfPaginationReached();
                        boolean endOfPaginationReached2 = ((PageEvent.Insert) pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1.$event).getCombinedLoadStates().getAppend().getEndOfPaginationReached();
                        if ((((PageEvent.Insert) pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1.$event).getLoadType() != LoadType.PREPEND && endOfPaginationReached) || (((PageEvent.Insert) pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1.$event).getLoadType() == LoadType.APPEND && endOfPaginationReached2)) {
                            PagingDataDiffer.this.lastAccessedIndexUnfulfilled = false;
                        } else if (PagingDataDiffer.this.lastAccessedIndexUnfulfilled) {
                            if (PagingDataDiffer.this.lastAccessedIndex >= PagingDataDiffer.this.presenter.getPlaceholdersBefore() || PagingDataDiffer.this.lastAccessedIndex > PagingDataDiffer.this.presenter.getPlaceholdersBefore() + PagingDataDiffer.this.presenter.getStorageCount()) {
                                uiReceiver3 = PagingDataDiffer.this.receiver;
                                if (uiReceiver3 != null) {
                                    uiReceiver3.accessHint(PagingDataDiffer.this.presenter.accessHintForPresenterIndex(PagingDataDiffer.this.lastAccessedIndex));
                                }
                            } else {
                                PagingDataDiffer.this.lastAccessedIndexUnfulfilled = false;
                            }
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                yVar = (y) this.L$1;
                pagePresenter = (PagePresenter) this.L$0;
                r.b(obj);
                pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$2 = this;
                num = (Integer) obj;
                if (yVar.element) {
                    PagingDataDiffer.this.dispatchLoadStates(((PageEvent.Insert) pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$2.$event).getCombinedLoadStates());
                    if (num == null) {
                        uiReceiver2 = PagingDataDiffer.this.receiver;
                        if (uiReceiver2 != null) {
                            uiReceiver2.accessHint(pagePresenter.initializeHint());
                        }
                    } else {
                        PagingDataDiffer.this.lastAccessedIndex = num.intValue();
                        uiReceiver = PagingDataDiffer.this.receiver;
                        if (uiReceiver != null) {
                            uiReceiver.accessHint(pagePresenter.accessHintForPresenterIndex(num.intValue()));
                        }
                    }
                } else {
                    throw new IllegalStateException("Missing call to onListPresentable after new list was presented. If you are seeing this exception, it is generally an indication of an issue with Paging. Please file a bug so we can fix it at: https://issuetracker.google.com/issues/new?component=413106");
                }
            }
        } else {
            r.b(obj);
            PageEvent pageEvent2 = this.$event;
            if ((pageEvent2 instanceof PageEvent.Insert) && ((PageEvent.Insert) pageEvent2).getLoadType() == LoadType.REFRESH) {
                PagingDataDiffer.this.lastAccessedIndexUnfulfilled = false;
                PagePresenter pagePresenter2 = new PagePresenter((PageEvent.Insert) this.$event);
                y yVar2 = new y();
                yVar2.element = false;
                PagingDataDiffer pagingDataDiffer = PagingDataDiffer.this;
                PagePresenter pagePresenter3 = pagingDataDiffer.presenter;
                CombinedLoadStates combinedLoadStates = ((PageEvent.Insert) this.$event).getCombinedLoadStates();
                int i11 = PagingDataDiffer.this.lastAccessedIndex;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(pagePresenter2, yVar2);
                this.L$0 = pagePresenter2;
                this.L$1 = yVar2;
                this.label = 1;
                pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$2 = this;
                Object objPresentNewList = pagingDataDiffer.presentNewList(pagePresenter3, pagePresenter2, combinedLoadStates, i11, anonymousClass1, pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$2);
                if (objPresentNewList != objC) {
                    yVar = yVar2;
                    obj = objPresentNewList;
                    pagePresenter = pagePresenter2;
                    num = (Integer) obj;
                    if (yVar.element) {
                        PagingDataDiffer.this.dispatchLoadStates(((PageEvent.Insert) pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$2.$event).getCombinedLoadStates());
                        if (num == null) {
                            uiReceiver2 = PagingDataDiffer.this.receiver;
                            if (uiReceiver2 != null) {
                                uiReceiver2.accessHint(pagePresenter.initializeHint());
                            }
                        } else {
                            PagingDataDiffer.this.lastAccessedIndex = num.intValue();
                            uiReceiver = PagingDataDiffer.this.receiver;
                            if (uiReceiver != null) {
                                uiReceiver.accessHint(pagePresenter.accessHintForPresenterIndex(num.intValue()));
                            }
                        }
                    } else {
                        throw new IllegalStateException("Missing call to onListPresentable after new list was presented. If you are seeing this exception, it is generally an indication of an issue with Paging. Please file a bug so we can fix it at: https://issuetracker.google.com/issues/new?component=413106");
                    }
                }
            } else {
                pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1 = this;
                if (PagingDataDiffer.this.postEvents()) {
                    pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1.label = 2;
                }
                PagingDataDiffer.this.presenter.processEvent(pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1.$event, PagingDataDiffer.this.processPageEventCallback);
                if (pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1.$event instanceof PageEvent.Drop) {
                    PagingDataDiffer.this.lastAccessedIndexUnfulfilled = false;
                }
                pageEvent = pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1.$event;
                if (pageEvent instanceof PageEvent.Insert) {
                    boolean endOfPaginationReached3 = ((PageEvent.Insert) pageEvent).getCombinedLoadStates().getPrepend().getEndOfPaginationReached();
                    boolean endOfPaginationReached4 = ((PageEvent.Insert) pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1.$event).getCombinedLoadStates().getAppend().getEndOfPaginationReached();
                    if (((PageEvent.Insert) pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1$lambda$1.$event).getLoadType() != LoadType.PREPEND) {
                        if (PagingDataDiffer.this.lastAccessedIndexUnfulfilled) {
                            if (PagingDataDiffer.this.lastAccessedIndex >= PagingDataDiffer.this.presenter.getPlaceholdersBefore()) {
                                uiReceiver3 = PagingDataDiffer.this.receiver;
                                if (uiReceiver3 != null) {
                                    uiReceiver3.accessHint(PagingDataDiffer.this.presenter.accessHintForPresenterIndex(PagingDataDiffer.this.lastAccessedIndex));
                                }
                            } else {
                                uiReceiver3 = PagingDataDiffer.this.receiver;
                                if (uiReceiver3 != null) {
                                    uiReceiver3.accessHint(PagingDataDiffer.this.presenter.accessHintForPresenterIndex(PagingDataDiffer.this.lastAccessedIndex));
                                }
                            }
                        }
                    } else if (PagingDataDiffer.this.lastAccessedIndexUnfulfilled) {
                        if (PagingDataDiffer.this.lastAccessedIndex >= PagingDataDiffer.this.presenter.getPlaceholdersBefore()) {
                            uiReceiver3 = PagingDataDiffer.this.receiver;
                            if (uiReceiver3 != null) {
                                uiReceiver3.accessHint(PagingDataDiffer.this.presenter.accessHintForPresenterIndex(PagingDataDiffer.this.lastAccessedIndex));
                            }
                        } else {
                            uiReceiver3 = PagingDataDiffer.this.receiver;
                            if (uiReceiver3 != null) {
                                uiReceiver3.accessHint(PagingDataDiffer.this.presenter.accessHintForPresenterIndex(PagingDataDiffer.this.lastAccessedIndex));
                            }
                        }
                    }
                }
            }
            return objC;
        }
        return z.f17874a;
    }
}
