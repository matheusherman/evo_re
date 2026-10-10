package ua;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BG\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012&\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R4\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lua/e;", "Lta/h;", "Lh9/e;", "", "input", "", "startIndex", "limit", "Lkotlin/Function2;", "Lr8/p;", "getNextMatch", "<init>", "(Ljava/lang/CharSequence;IILc9/p;)V", "", "iterator", "()Ljava/util/Iterator;", "a", "Ljava/lang/CharSequence;", "b", "I", "c", "d", "Lc9/p;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class e implements ta.h<h9.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final CharSequence input;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int startIndex;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int limit;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final c9.p<CharSequence, Integer, r8.p<Integer, Integer>> getNextMatch;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\u0019\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\u001dR\"\u0010\"\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\r\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011¨\u0006#"}, d2 = {"ua/e$a", "", "Lh9/e;", "Lr8/z;", "c", "()V", "d", "()Lh9/e;", "", "hasNext", "()Z", "", "a", "I", "getNextState", "()I", "setNextState", "(I)V", "nextState", "b", "getCurrentStartIndex", "setCurrentStartIndex", "currentStartIndex", "getNextSearchIndex", "setNextSearchIndex", "nextSearchIndex", "Lh9/e;", "getNextItem", "setNextItem", "(Lh9/e;)V", "nextItem", "e", "getCounter", "setCounter", "counter", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Iterator<h9.e>, d9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int nextState = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int currentStartIndex;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int nextSearchIndex;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private h9.e nextItem;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int counter;

        a() {
            int iH = h9.f.h(e.this.startIndex, 0, e.this.input.length());
            this.currentStartIndex = iH;
            this.nextSearchIndex = iH;
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0022  */
        /* JADX WARN: Code duplicated, block: B:12:0x0030 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:18:0x0097  */
        private final void c() {
            r8.p pVar;
            if (this.nextSearchIndex < 0) {
                this.nextState = 0;
                this.nextItem = null;
                return;
            }
            if (e.this.limit > 0) {
                int i10 = this.counter + 1;
                this.counter = i10;
                if (i10 >= e.this.limit) {
                    this.nextItem = new h9.e(this.currentStartIndex, b0.V(e.this.input));
                    this.nextSearchIndex = -1;
                } else if (this.nextSearchIndex > e.this.input.length() && (pVar = (r8.p) e.this.getNextMatch.invoke(e.this.input, Integer.valueOf(this.nextSearchIndex))) != null) {
                    int iIntValue = ((Number) pVar.a()).intValue();
                    int iIntValue2 = ((Number) pVar.b()).intValue();
                    this.nextItem = h9.f.m(this.currentStartIndex, iIntValue);
                    int i11 = iIntValue + iIntValue2;
                    this.currentStartIndex = i11;
                    this.nextSearchIndex = i11 + (iIntValue2 == 0 ? 1 : 0);
                } else {
                    this.nextItem = new h9.e(this.currentStartIndex, b0.V(e.this.input));
                    this.nextSearchIndex = -1;
                }
            } else if (this.nextSearchIndex > e.this.input.length()) {
                this.nextItem = new h9.e(this.currentStartIndex, b0.V(e.this.input));
                this.nextSearchIndex = -1;
            } else {
                int iIntValue3 = ((Number) pVar.a()).intValue();
                int iIntValue4 = ((Number) pVar.b()).intValue();
                this.nextItem = h9.f.m(this.currentStartIndex, iIntValue3);
                int i12 = iIntValue3 + iIntValue4;
                this.currentStartIndex = i12;
                this.nextSearchIndex = i12 + (iIntValue4 == 0 ? 1 : 0);
            }
            this.nextState = 1;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public h9.e next() {
            if (this.nextState == -1) {
                c();
            }
            if (this.nextState == 0) {
                throw new NoSuchElementException();
            }
            h9.e eVar = this.nextItem;
            kotlin.jvm.internal.m.d(eVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.nextItem = null;
            this.nextState = -1;
            return eVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextState == -1) {
                c();
            }
            return this.nextState == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(CharSequence input, int i10, int i11, c9.p<? super CharSequence, ? super Integer, r8.p<Integer, Integer>> getNextMatch) {
        kotlin.jvm.internal.m.f(input, "input");
        kotlin.jvm.internal.m.f(getNextMatch, "getNextMatch");
        this.input = input;
        this.startIndex = i10;
        this.limit = i11;
        this.getNextMatch = getNextMatch;
    }

    @Override // ta.h
    public Iterator<h9.e> iterator() {
        return new a();
    }
}
