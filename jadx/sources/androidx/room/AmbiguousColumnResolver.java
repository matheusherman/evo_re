package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import com.pengrad.telegrambot.model.chatbackground.BackgroundTypePattern;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.k0;
import kotlin.collections.r;
import kotlin.collections.v0;
import kotlin.jvm.internal.b0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0003\u001d\u001e\u001fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0004H\u0007¢\u0006\u0004\b\t\u0010\nJQ\u0010\u0013\u001a\u00020\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042$\u0010\u0012\u001a \u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\u00110\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J]\u0010\u001b\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u00152\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\u000b2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00102\u0018\u0010\u001a\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0004\u0012\u00020\u00110\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Landroidx/room/AmbiguousColumnResolver;", "", "<init>", "()V", "", "", "resultColumns", "mappings", "", "resolve", "([Ljava/lang/String;[[Ljava/lang/String;)[[I", "", "Landroidx/room/AmbiguousColumnResolver$ResultColumn;", "content", BackgroundTypePattern.TYPE, "Lkotlin/Function3;", "", "Lr8/z;", "onHashMatch", "rabinKarpSearch", "(Ljava/util/List;[Ljava/lang/String;Lc9/q;)V", ExifInterface.GPS_DIRECTION_TRUE, "", "current", "depth", "Lkotlin/Function1;", "block", "dfs", "(Ljava/util/List;Ljava/util/List;ILc9/l;)V", "Match", "ResultColumn", "Solution", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class AmbiguousColumnResolver {
    public static final AmbiguousColumnResolver INSTANCE = new AmbiguousColumnResolver();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$Match;", "", "Lh9/e;", "resultRange", "", "", "resultIndices", "<init>", "(Lh9/e;Ljava/util/List;)V", "Lh9/e;", "getResultRange", "()Lh9/e;", "Ljava/util/List;", "getResultIndices", "()Ljava/util/List;", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
    static final class Match {
        private final List<Integer> resultIndices;
        private final h9.e resultRange;

        public Match(h9.e resultRange, List<Integer> resultIndices) {
            kotlin.jvm.internal.m.f(resultRange, "resultRange");
            kotlin.jvm.internal.m.f(resultIndices, "resultIndices");
            this.resultRange = resultRange;
            this.resultIndices = resultIndices;
        }

        public final List<Integer> getResultIndices() {
            return this.resultIndices;
        }

        public final h9.e getResultRange() {
            return this.resultRange;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$ResultColumn;", "", "name", "", "index", "", "(Ljava/lang/String;I)V", "getIndex", "()I", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", TransactionPartnerType.OTHER, "hashCode", "toString", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
    static final /* data */ class ResultColumn {
        private final int index;
        private final String name;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResultColumn)) {
                return false;
            }
            ResultColumn resultColumn = (ResultColumn) other;
            return kotlin.jvm.internal.m.a(this.name, resultColumn.name) && this.index == resultColumn.index;
        }

        public ResultColumn(String name, int i10) {
            kotlin.jvm.internal.m.f(name, "name");
            this.name = name;
            this.index = i10;
        }

        public static /* synthetic */ ResultColumn copy$default(ResultColumn resultColumn, String str, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = resultColumn.name;
            }
            if ((i11 & 2) != 0) {
                i10 = resultColumn.index;
            }
            return resultColumn.copy(str, i10);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        public final ResultColumn copy(String name, int index) {
            kotlin.jvm.internal.m.f(name, "name");
            return new ResultColumn(name, index);
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.index;
        }

        public String toString() {
            return "ResultColumn(name=" + this.name + ", index=" + this.index + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0011\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0000H\u0096\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0011"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$Solution;", "", "matches", "", "Landroidx/room/AmbiguousColumnResolver$Match;", "coverageOffset", "", "overlaps", "(Ljava/util/List;II)V", "getCoverageOffset", "()I", "getMatches", "()Ljava/util/List;", "getOverlaps", "compareTo", TransactionPartnerType.OTHER, "Companion", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class Solution implements Comparable<Solution> {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Solution NO_SOLUTION = new Solution(r.l(), Integer.MAX_VALUE, Integer.MAX_VALUE);
        private final int coverageOffset;
        private final List<Match> matches;
        private final int overlaps;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$Solution$Companion;", "", "()V", "NO_SOLUTION", "Landroidx/room/AmbiguousColumnResolver$Solution;", "getNO_SOLUTION", "()Landroidx/room/AmbiguousColumnResolver$Solution;", "build", "matches", "", "Landroidx/room/AmbiguousColumnResolver$Match;", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
                this();
            }

            private Companion() {
            }

            public final Solution build(List<Match> matches) {
                kotlin.jvm.internal.m.f(matches, "matches");
                List<Match> list = matches;
                int i10 = 0;
                int last = 0;
                for (Match match : list) {
                    last += ((match.getResultRange().getLast() - match.getResultRange().getFirst()) + 1) - match.getResultIndices().size();
                }
                Iterator<T> it = list.iterator();
                if (!it.hasNext()) {
                    throw new NoSuchElementException();
                }
                int first = ((Match) it.next()).getResultRange().getFirst();
                while (it.hasNext()) {
                    int first2 = ((Match) it.next()).getResultRange().getFirst();
                    if (first > first2) {
                        first = first2;
                    }
                }
                Iterator<T> it2 = list.iterator();
                if (!it2.hasNext()) {
                    throw new NoSuchElementException();
                }
                int last2 = ((Match) it2.next()).getResultRange().getLast();
                while (it2.hasNext()) {
                    int last3 = ((Match) it2.next()).getResultRange().getLast();
                    if (last2 < last3) {
                        last2 = last3;
                    }
                }
                Iterable eVar = new h9.e(first, last2);
                if (!(eVar instanceof Collection) || !((Collection) eVar).isEmpty()) {
                    Iterator it3 = eVar.iterator();
                    int i11 = 0;
                    while (it3.hasNext()) {
                        int iNextInt = ((k0) it3).nextInt();
                        Iterator<T> it4 = list.iterator();
                        int i12 = 0;
                        while (it4.hasNext()) {
                            if (((Match) it4.next()).getResultRange().n(iNextInt)) {
                                i12++;
                            }
                            if (i12 > 1) {
                                i11++;
                                if (i11 >= 0) {
                                    break;
                                }
                                r.u();
                                break;
                            }
                        }
                    }
                    i10 = i11;
                }
                return new Solution(matches, last, i10);
            }

            public final Solution getNO_SOLUTION() {
                return Solution.NO_SOLUTION;
            }
        }

        public Solution(List<Match> matches, int i10, int i11) {
            kotlin.jvm.internal.m.f(matches, "matches");
            this.matches = matches;
            this.coverageOffset = i10;
            this.overlaps = i11;
        }

        @Override // java.lang.Comparable
        public int compareTo(Solution other) {
            kotlin.jvm.internal.m.f(other, "other");
            int iH = kotlin.jvm.internal.m.h(this.overlaps, other.overlaps);
            return iH != 0 ? iH : kotlin.jvm.internal.m.h(this.coverageOffset, other.coverageOffset);
        }

        public final int getCoverageOffset() {
            return this.coverageOffset;
        }

        public final List<Match> getMatches() {
            return this.matches;
        }

        public final int getOverlaps() {
            return this.overlaps;
        }
    }

    /* JADX INFO: renamed from: androidx.room.AmbiguousColumnResolver$resolve$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Landroidx/room/AmbiguousColumnResolver$Match;", "it", "Lr8/z;", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    static final class AnonymousClass4 extends kotlin.jvm.internal.o implements c9.l<List<? extends Match>, r8.z> {
        final /* synthetic */ b0<Solution> $bestSolution;

        @Override // c9.l
        public /* bridge */ /* synthetic */ r8.z invoke(List<? extends Match> list) {
            invoke2((List<Match>) list);
            return r8.z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(b0<Solution> b0Var) {
            super(1);
            this.$bestSolution = b0Var;
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [T, androidx.room.AmbiguousColumnResolver$Solution] */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Match> it) {
            kotlin.jvm.internal.m.f(it, "it");
            ?? Build = Solution.INSTANCE.build(it);
            if (Build.compareTo(this.$bestSolution.element) < 0) {
                this.$bestSolution.element = Build;
            }
        }
    }

    private final void rabinKarpSearch(List<ResultColumn> content, String[] pattern, c9.q<? super Integer, ? super Integer, ? super List<ResultColumn>, r8.z> onHashMatch) {
        int i10 = 0;
        int iHashCode = 0;
        for (String str : pattern) {
            iHashCode += str.hashCode();
        }
        int length = pattern.length;
        Iterator<T> it = content.subList(0, length).iterator();
        int iHashCode2 = 0;
        while (it.hasNext()) {
            iHashCode2 += ((ResultColumn) it.next()).getName().hashCode();
        }
        while (true) {
            if (iHashCode == iHashCode2) {
                onHashMatch.invoke(Integer.valueOf(i10), Integer.valueOf(length), content.subList(i10, length));
            }
            int i11 = i10 + 1;
            int i12 = length + 1;
            if (i12 > content.size()) {
                return;
            }
            iHashCode2 = (iHashCode2 - content.get(i10).getName().hashCode()) + content.get(length).getName().hashCode();
            i10 = i11;
            length = i12;
        }
    }

    static /* synthetic */ void dfs$default(AmbiguousColumnResolver ambiguousColumnResolver, List list, List list2, int i10, c9.l lVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            list2 = new ArrayList();
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        ambiguousColumnResolver.dfs(list, list2, i10, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, androidx.room.AmbiguousColumnResolver$Solution] */
    public static final int[][] resolve(String[] resultColumns, String[][] mappings) {
        kotlin.jvm.internal.m.f(resultColumns, "resultColumns");
        kotlin.jvm.internal.m.f(mappings, "mappings");
        int length = resultColumns.length;
        for (int i10 = 0; i10 < length; i10++) {
            String strSubstring = resultColumns[i10];
            if (strSubstring.charAt(0) == '`' && strSubstring.charAt(strSubstring.length() - 1) == '`') {
                strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
                kotlin.jvm.internal.m.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            Locale US = Locale.US;
            kotlin.jvm.internal.m.e(US, "US");
            String lowerCase = strSubstring.toLowerCase(US);
            kotlin.jvm.internal.m.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            resultColumns[i10] = lowerCase;
        }
        int length2 = mappings.length;
        for (int i11 = 0; i11 < length2; i11++) {
            int length3 = mappings[i11].length;
            for (int i12 = 0; i12 < length3; i12++) {
                String[] strArr = mappings[i11];
                String str = strArr[i12];
                Locale US2 = Locale.US;
                kotlin.jvm.internal.m.e(US2, "US");
                String lowerCase2 = str.toLowerCase(US2);
                kotlin.jvm.internal.m.e(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                strArr[i12] = lowerCase2;
            }
        }
        Set setB = v0.b();
        for (String[] strArr2 : mappings) {
            r.D(setB, strArr2);
        }
        Set setA = v0.a(setB);
        List listC = r.c();
        int length4 = resultColumns.length;
        int i13 = 0;
        int i14 = 0;
        while (i13 < length4) {
            String str2 = resultColumns[i13];
            int i15 = i14 + 1;
            if (setA.contains(str2)) {
                listC.add(new ResultColumn(str2, i14));
            }
            i13++;
            i14 = i15;
        }
        List<ResultColumn> listA = r.a(listC);
        int length5 = mappings.length;
        ArrayList arrayList = new ArrayList(length5);
        for (int i16 = 0; i16 < length5; i16++) {
            arrayList.add(new ArrayList());
        }
        int length6 = mappings.length;
        int i17 = 0;
        int i18 = 0;
        while (i17 < length6) {
            String[] strArr3 = mappings[i17];
            int i19 = i18 + 1;
            INSTANCE.rabinKarpSearch(listA, strArr3, new AmbiguousColumnResolver$resolve$1$1(strArr3, arrayList, i18));
            if (((List) arrayList.get(i18)).isEmpty()) {
                ArrayList arrayList2 = new ArrayList(strArr3.length);
                for (String str3 : strArr3) {
                    List listC2 = r.c();
                    for (ResultColumn resultColumn : listA) {
                        if (kotlin.jvm.internal.m.a(str3, resultColumn.getName())) {
                            listC2.add(Integer.valueOf(resultColumn.getIndex()));
                        }
                    }
                    List listA2 = r.a(listC2);
                    if (listA2.isEmpty()) {
                        throw new IllegalStateException(("Column " + str3 + " not found in result").toString());
                    }
                    arrayList2.add(listA2);
                }
                dfs$default(INSTANCE, arrayList2, null, 0, new AmbiguousColumnResolver$resolve$1$2(arrayList, i18), 6, null);
            }
            i17++;
            i18 = i19;
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (((List) it.next()).isEmpty()) {
                    throw new IllegalStateException("Failed to find matches for all mappings");
                }
            }
        }
        b0 b0Var = new b0();
        b0Var.element = Solution.INSTANCE.getNO_SOLUTION();
        dfs$default(INSTANCE, arrayList, null, 0, new AnonymousClass4(b0Var), 6, null);
        List<Match> matches = ((Solution) b0Var.element).getMatches();
        ArrayList arrayList3 = new ArrayList(r.w(matches, 10));
        Iterator<T> it2 = matches.iterator();
        while (it2.hasNext()) {
            arrayList3.add(r.N0(((Match) it2.next()).getResultIndices()));
        }
        Object[] array = arrayList3.toArray(new int[0][]);
        kotlin.jvm.internal.m.d(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (int[][]) array;
    }

    private AmbiguousColumnResolver() {
    }

    private final <T> void dfs(List<? extends List<? extends T>> content, List<T> current, int depth, c9.l<? super List<? extends T>, r8.z> block) {
        if (depth == content.size()) {
            block.invoke(r.O0(current));
            return;
        }
        Iterator<T> it = content.get(depth).iterator();
        while (it.hasNext()) {
            current.add(it.next());
            INSTANCE.dfs(content, current, depth + 1, block);
            r.K(current);
        }
    }
}
