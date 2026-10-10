package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import c9.l;
import c9.p;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import v8.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0003\u0010\u0011\u0012B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004JG\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\b\b\u0001\u0010\u0005*\u00020\u00012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJM\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\b\b\u0001\u0010\u0005*\u00020\u00012(\u0010\b\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\nJ=\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\n\u0082\u0001\u0003\u0013\u0014\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Landroidx/paging/PageEvent;", "", ExifInterface.GPS_DIRECTION_TRUE, "<init>", "()V", "R", "Lkotlin/Function2;", "Lv8/f;", "transform", "map", "(Lc9/p;Lv8/f;)Ljava/lang/Object;", "", "flatMap", "", "predicate", "filter", "Drop", "Insert", "LoadStateUpdate", "Landroidx/paging/PageEvent$Insert;", "Landroidx/paging/PageEvent$Drop;", "Landroidx/paging/PageEvent$LoadStateUpdate;", "paging-common"}, k = 1, mv = {1, 4, 1})
public abstract class PageEvent<T> {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J7\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001e"}, d2 = {"Landroidx/paging/PageEvent$Drop;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/PageEvent;", "loadType", "Landroidx/paging/LoadType;", "minPageOffset", "", "maxPageOffset", "placeholdersRemaining", "(Landroidx/paging/LoadType;III)V", "getLoadType", "()Landroidx/paging/LoadType;", "getMaxPageOffset", "()I", "getMinPageOffset", "pageCount", "getPageCount", "getPlaceholdersRemaining", "component1", "component2", "component3", "component4", "copy", "equals", "", TransactionPartnerType.OTHER, "hashCode", "toString", "", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class Drop<T> extends PageEvent<T> {
        private final LoadType loadType;
        private final int maxPageOffset;
        private final int minPageOffset;
        private final int placeholdersRemaining;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Drop(LoadType loadType, int i10, int i11, int i12) {
            super(null);
            m.f(loadType, "loadType");
            this.loadType = loadType;
            this.minPageOffset = i10;
            this.maxPageOffset = i11;
            this.placeholdersRemaining = i12;
            if (!(loadType != LoadType.REFRESH)) {
                throw new IllegalArgumentException("Drop load type must be PREPEND or APPEND");
            }
            if (!(getPageCount() > 0)) {
                throw new IllegalArgumentException(("Drop count must be > 0, but was " + getPageCount()).toString());
            }
            if (i12 >= 0) {
                return;
            }
            throw new IllegalArgumentException(("Invalid placeholdersRemaining " + i12).toString());
        }

        public static /* synthetic */ Drop copy$default(Drop drop, LoadType loadType, int i10, int i11, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                loadType = drop.loadType;
            }
            if ((i13 & 2) != 0) {
                i10 = drop.minPageOffset;
            }
            if ((i13 & 4) != 0) {
                i11 = drop.maxPageOffset;
            }
            if ((i13 & 8) != 0) {
                i12 = drop.placeholdersRemaining;
            }
            return drop.copy(loadType, i10, i11, i12);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final LoadType getLoadType() {
            return this.loadType;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getMinPageOffset() {
            return this.minPageOffset;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getMaxPageOffset() {
            return this.maxPageOffset;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getPlaceholdersRemaining() {
            return this.placeholdersRemaining;
        }

        public final Drop<T> copy(LoadType loadType, int minPageOffset, int maxPageOffset, int placeholdersRemaining) {
            m.f(loadType, "loadType");
            return new Drop<>(loadType, minPageOffset, maxPageOffset, placeholdersRemaining);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Drop)) {
                return false;
            }
            Drop drop = (Drop) other;
            return m.a(this.loadType, drop.loadType) && this.minPageOffset == drop.minPageOffset && this.maxPageOffset == drop.maxPageOffset && this.placeholdersRemaining == drop.placeholdersRemaining;
        }

        public final LoadType getLoadType() {
            return this.loadType;
        }

        public final int getMaxPageOffset() {
            return this.maxPageOffset;
        }

        public final int getMinPageOffset() {
            return this.minPageOffset;
        }

        public final int getPageCount() {
            return (this.maxPageOffset - this.minPageOffset) + 1;
        }

        public final int getPlaceholdersRemaining() {
            return this.placeholdersRemaining;
        }

        public int hashCode() {
            LoadType loadType = this.loadType;
            return ((((((loadType != null ? loadType.hashCode() : 0) * 31) + this.minPageOffset) * 31) + this.maxPageOffset) * 31) + this.placeholdersRemaining;
        }

        public String toString() {
            return "Drop(loadType=" + this.loadType + ", minPageOffset=" + this.minPageOffset + ", maxPageOffset=" + this.maxPageOffset + ", placeholdersRemaining=" + this.placeholdersRemaining + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\b\u0018\u0000 ;*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003:\u0001;B=\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ@\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00020\u0000\"\b\b\u0002\u0010\u0010*\u00020\u00012\u001e\u0010\u0012\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00070\u0011H\u0082\b¢\u0006\u0004\b\u0013\u0010\u0014JO\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00020\u0000\"\b\b\u0002\u0010\u0010*\u00020\u00012*\u0010\u0012\u001a&\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00070\u00060\u0011H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0014JG\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\b\b\u0002\u0010\u0010*\u00020\u00012\"\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017H\u0096@ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001aJM\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\b\b\u0002\u0010\u0010*\u00020\u00012(\u0010\u0012\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u001b0\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017H\u0096@ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001aJ=\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\"\u0010\u001e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017H\u0096@ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u001aJ\u0010\u0010 \u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b \u0010!J\u001c\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b&\u0010%J\u0010\u0010'\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b'\u0010(JT\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010,\u001a\u00020+HÖ\u0001¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b.\u0010%J\u001a\u00100\u001a\u00020\u001d2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b0\u00101R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00102\u001a\u0004\b3\u0010!R#\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u00104\u001a\u0004\b5\u0010#R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u00106\u001a\u0004\b7\u0010%R\u0017\u0010\u000b\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000b\u00106\u001a\u0004\b8\u0010%R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u00109\u001a\u0004\b:\u0010(\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b\u0019¨\u0006<"}, d2 = {"Landroidx/paging/PageEvent$Insert;", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/PageEvent;", "Landroidx/paging/LoadType;", "loadType", "", "Landroidx/paging/TransformablePage;", "pages", "", "placeholdersBefore", "placeholdersAfter", "Landroidx/paging/CombinedLoadStates;", "combinedLoadStates", "<init>", "(Landroidx/paging/LoadType;Ljava/util/List;IILandroidx/paging/CombinedLoadStates;)V", "R", "Lkotlin/Function1;", "transform", "mapPages", "(Lc9/l;)Landroidx/paging/PageEvent$Insert;", "transformPages$paging_common", "transformPages", "Lkotlin/Function2;", "Lv8/f;", "map", "(Lc9/p;Lv8/f;)Ljava/lang/Object;", "", "flatMap", "", "predicate", "filter", "component1", "()Landroidx/paging/LoadType;", "component2", "()Ljava/util/List;", "component3", "()I", "component4", "component5", "()Landroidx/paging/CombinedLoadStates;", "copy", "(Landroidx/paging/LoadType;Ljava/util/List;IILandroidx/paging/CombinedLoadStates;)Landroidx/paging/PageEvent$Insert;", "", "toString", "()Ljava/lang/String;", "hashCode", TransactionPartnerType.OTHER, "equals", "(Ljava/lang/Object;)Z", "Landroidx/paging/LoadType;", "getLoadType", "Ljava/util/List;", "getPages", "I", "getPlaceholdersBefore", "getPlaceholdersAfter", "Landroidx/paging/CombinedLoadStates;", "getCombinedLoadStates", "Companion", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class Insert<T> extends PageEvent<T> {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private static final Insert<Object> EMPTY_REFRESH_LOCAL;
        private final CombinedLoadStates combinedLoadStates;
        private final LoadType loadType;
        private final List<TransformablePage<T>> pages;
        private final int placeholdersAfter;
        private final int placeholdersBefore;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004\"\b\b\u0002\u0010\b*\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ:\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004\"\b\b\u0002\u0010\b*\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u000b0\n2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJB\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004\"\b\b\u0002\u0010\b*\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u000b0\n2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Landroidx/paging/PageEvent$Insert$Companion;", "", "()V", "EMPTY_REFRESH_LOCAL", "Landroidx/paging/PageEvent$Insert;", "getEMPTY_REFRESH_LOCAL", "()Landroidx/paging/PageEvent$Insert;", "Append", ExifInterface.GPS_DIRECTION_TRUE, "pages", "", "Landroidx/paging/TransformablePage;", "placeholdersAfter", "", "combinedLoadStates", "Landroidx/paging/CombinedLoadStates;", "Prepend", "placeholdersBefore", "Refresh", "paging-common"}, k = 1, mv = {1, 4, 1})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(g gVar) {
                this();
            }

            public final <T> Insert<T> Append(List<TransformablePage<T>> pages, int placeholdersAfter, CombinedLoadStates combinedLoadStates) {
                m.f(pages, "pages");
                m.f(combinedLoadStates, "combinedLoadStates");
                return new Insert<>(LoadType.APPEND, pages, -1, placeholdersAfter, combinedLoadStates, null);
            }

            public final <T> Insert<T> Prepend(List<TransformablePage<T>> pages, int placeholdersBefore, CombinedLoadStates combinedLoadStates) {
                m.f(pages, "pages");
                m.f(combinedLoadStates, "combinedLoadStates");
                return new Insert<>(LoadType.PREPEND, pages, placeholdersBefore, -1, combinedLoadStates, null);
            }

            public final <T> Insert<T> Refresh(List<TransformablePage<T>> pages, int placeholdersBefore, int placeholdersAfter, CombinedLoadStates combinedLoadStates) {
                m.f(pages, "pages");
                m.f(combinedLoadStates, "combinedLoadStates");
                return new Insert<>(LoadType.REFRESH, pages, placeholdersBefore, placeholdersAfter, combinedLoadStates, null);
            }

            public final Insert<Object> getEMPTY_REFRESH_LOCAL() {
                return Insert.EMPTY_REFRESH_LOCAL;
            }
        }

        public /* synthetic */ Insert(LoadType loadType, List list, int i10, int i11, CombinedLoadStates combinedLoadStates, g gVar) {
            this(loadType, list, i10, i11, combinedLoadStates);
        }

        static {
            Companion companion = new Companion(null);
            INSTANCE = companion;
            List<TransformablePage<T>> listE = r.e(TransformablePage.INSTANCE.getEMPTY_INITIAL_PAGE());
            LoadState.NotLoading.Companion companion2 = LoadState.NotLoading.INSTANCE;
            EMPTY_REFRESH_LOCAL = companion.Refresh(listE, 0, 0, new CombinedLoadStates(companion2.getIncomplete$paging_common(), companion2.getComplete$paging_common(), companion2.getComplete$paging_common(), new LoadStates(companion2.getIncomplete$paging_common(), companion2.getComplete$paging_common(), companion2.getComplete$paging_common()), null, 16, null));
        }

        private Insert(LoadType loadType, List<TransformablePage<T>> list, int i10, int i11, CombinedLoadStates combinedLoadStates) {
            super(null);
            this.loadType = loadType;
            this.pages = list;
            this.placeholdersBefore = i10;
            this.placeholdersAfter = i11;
            this.combinedLoadStates = combinedLoadStates;
            boolean z10 = true;
            if (!(loadType == LoadType.APPEND || i10 >= 0)) {
                throw new IllegalArgumentException(("Prepend insert defining placeholdersBefore must be > 0, but was " + i10).toString());
            }
            if (!(loadType == LoadType.PREPEND || i11 >= 0)) {
                throw new IllegalArgumentException(("Append insert defining placeholdersAfter must be > 0, but was " + i11).toString());
            }
            if (loadType == LoadType.REFRESH && list.isEmpty()) {
                z10 = false;
            }
            if (!z10) {
                throw new IllegalArgumentException("Cannot create a REFRESH Insert event with no TransformablePages as this could permanently stall pagination. Note that this check does not prevent empty LoadResults and is instead usually an indication of an internal error in Paging itself.");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Insert copy$default(Insert insert, LoadType loadType, List list, int i10, int i11, CombinedLoadStates combinedLoadStates, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                loadType = insert.loadType;
            }
            if ((i12 & 2) != 0) {
                list = insert.pages;
            }
            if ((i12 & 4) != 0) {
                i10 = insert.placeholdersBefore;
            }
            if ((i12 & 8) != 0) {
                i11 = insert.placeholdersAfter;
            }
            if ((i12 & 16) != 0) {
                combinedLoadStates = insert.combinedLoadStates;
            }
            CombinedLoadStates combinedLoadStates2 = combinedLoadStates;
            int i13 = i10;
            return insert.copy(loadType, list, i13, i11, combinedLoadStates2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final LoadType getLoadType() {
            return this.loadType;
        }

        public final List<TransformablePage<T>> component2() {
            return this.pages;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getPlaceholdersBefore() {
            return this.placeholdersBefore;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getPlaceholdersAfter() {
            return this.placeholdersAfter;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final CombinedLoadStates getCombinedLoadStates() {
            return this.combinedLoadStates;
        }

        public final Insert<T> copy(LoadType loadType, List<TransformablePage<T>> pages, int placeholdersBefore, int placeholdersAfter, CombinedLoadStates combinedLoadStates) {
            m.f(loadType, "loadType");
            m.f(pages, "pages");
            m.f(combinedLoadStates, "combinedLoadStates");
            return new Insert<>(loadType, pages, placeholdersBefore, placeholdersAfter, combinedLoadStates);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Insert)) {
                return false;
            }
            Insert insert = (Insert) other;
            return m.a(this.loadType, insert.loadType) && m.a(this.pages, insert.pages) && this.placeholdersBefore == insert.placeholdersBefore && this.placeholdersAfter == insert.placeholdersAfter && m.a(this.combinedLoadStates, insert.combinedLoadStates);
        }

        /* JADX WARN: Code duplicated, block: B:17:0x009e  */
        /* JADX WARN: Code duplicated, block: B:20:0x00c7  */
        /* JADX WARN: Code duplicated, block: B:22:0x00cf  */
        /* JADX WARN: Code duplicated, block: B:25:0x0107 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:26:0x0108  */
        /* JADX WARN: Code duplicated, block: B:36:0x014d  */
        /* JADX WARN: Code duplicated, block: B:7:0x0017  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x009e -> B:18:0x00c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0108 -> B:27:0x011c). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // androidx.paging.PageEvent
        public java.lang.Object filter(c9.p<? super T, ? super v8.f<? super java.lang.Boolean>, ? extends java.lang.Object> r19, v8.f<? super androidx.paging.PageEvent<T>> r20) {
            /*
                Method dump skipped, instruction units count: 376
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.Insert.filter(c9.p, v8.f):java.lang.Object");
        }

        /* JADX WARN: Code duplicated, block: B:17:0x00a3  */
        /* JADX WARN: Code duplicated, block: B:20:0x00cc  */
        /* JADX WARN: Code duplicated, block: B:22:0x00d4  */
        /* JADX WARN: Code duplicated, block: B:25:0x0111 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:26:0x0112  */
        /* JADX WARN: Code duplicated, block: B:36:0x0158  */
        /* JADX WARN: Code duplicated, block: B:7:0x0017  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00a3 -> B:18:0x00c6). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0112 -> B:27:0x0120). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // androidx.paging.PageEvent
        public <R> java.lang.Object flatMap(c9.p<? super T, ? super v8.f<? super java.lang.Iterable<? extends R>>, ? extends java.lang.Object> r18, v8.f<? super androidx.paging.PageEvent<R>> r19) {
            /*
                Method dump skipped, instruction units count: 388
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.Insert.flatMap(c9.p, v8.f):java.lang.Object");
        }

        public final CombinedLoadStates getCombinedLoadStates() {
            return this.combinedLoadStates;
        }

        public final LoadType getLoadType() {
            return this.loadType;
        }

        public final List<TransformablePage<T>> getPages() {
            return this.pages;
        }

        public final int getPlaceholdersAfter() {
            return this.placeholdersAfter;
        }

        public final int getPlaceholdersBefore() {
            return this.placeholdersBefore;
        }

        public int hashCode() {
            LoadType loadType = this.loadType;
            int iHashCode = (loadType != null ? loadType.hashCode() : 0) * 31;
            List<TransformablePage<T>> list = this.pages;
            int iHashCode2 = (((((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + this.placeholdersBefore) * 31) + this.placeholdersAfter) * 31;
            CombinedLoadStates combinedLoadStates = this.combinedLoadStates;
            return iHashCode2 + (combinedLoadStates != null ? combinedLoadStates.hashCode() : 0);
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0091  */
        /* JADX WARN: Code duplicated, block: B:20:0x00ba  */
        /* JADX WARN: Code duplicated, block: B:22:0x00e7 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:23:0x00e8  */
        /* JADX WARN: Code duplicated, block: B:25:0x00fa  */
        /* JADX WARN: Code duplicated, block: B:7:0x0017  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0091 -> B:18:0x00b4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00e8 -> B:24:0x00f0). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // androidx.paging.PageEvent
        public <R> java.lang.Object map(c9.p<? super T, ? super v8.f<? super R>, ? extends java.lang.Object> r18, v8.f<? super androidx.paging.PageEvent<R>> r19) {
            /*
                Method dump skipped, instruction units count: 297
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.Insert.map(c9.p, v8.f):java.lang.Object");
        }

        public String toString() {
            return "Insert(loadType=" + this.loadType + ", pages=" + this.pages + ", placeholdersBefore=" + this.placeholdersBefore + ", placeholdersAfter=" + this.placeholdersAfter + ", combinedLoadStates=" + this.combinedLoadStates + ")";
        }

        public final <R> Insert<R> transformPages$paging_common(l<? super List<TransformablePage<T>>, ? extends List<TransformablePage<R>>> transform) {
            m.f(transform, "transform");
            return new Insert<>(getLoadType(), transform.invoke(getPages()), getPlaceholdersBefore(), getPlaceholdersAfter(), getCombinedLoadStates(), null);
        }

        private final <R> Insert<R> mapPages(l<? super TransformablePage<T>, TransformablePage<R>> transform) {
            LoadType loadType = getLoadType();
            List<TransformablePage<T>> pages = getPages();
            ArrayList arrayList = new ArrayList(r.w(pages, 10));
            Iterator<T> it = pages.iterator();
            while (it.hasNext()) {
                arrayList.add(transform.invoke(it.next()));
            }
            return new Insert<>(loadType, arrayList, getPlaceholdersBefore(), getPlaceholdersAfter(), getCombinedLoadStates(), null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001b*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001bB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\tHÆ\u0003J-\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Landroidx/paging/PageEvent$LoadStateUpdate;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/PageEvent;", "loadType", "Landroidx/paging/LoadType;", "fromMediator", "", "loadState", "Landroidx/paging/LoadState;", "(Landroidx/paging/LoadType;ZLandroidx/paging/LoadState;)V", "getFromMediator", "()Z", "getLoadState", "()Landroidx/paging/LoadState;", "getLoadType", "()Landroidx/paging/LoadType;", "component1", "component2", "component3", "copy", "equals", TransactionPartnerType.OTHER, "hashCode", "", "toString", "", "Companion", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class LoadStateUpdate<T> extends PageEvent<T> {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean fromMediator;
        private final LoadState loadState;
        private final LoadType loadType;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/paging/PageEvent$LoadStateUpdate$Companion;", "", "()V", "canDispatchWithoutInsert", "", "loadState", "Landroidx/paging/LoadState;", "fromMediator", "canDispatchWithoutInsert$paging_common", "paging-common"}, k = 1, mv = {1, 4, 1})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(g gVar) {
                this();
            }

            public final boolean canDispatchWithoutInsert$paging_common(LoadState loadState, boolean fromMediator) {
                m.f(loadState, "loadState");
                return (loadState instanceof LoadState.Loading) || (loadState instanceof LoadState.Error) || fromMediator;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoadStateUpdate(LoadType loadType, boolean z10, LoadState loadState) {
            super(null);
            m.f(loadType, "loadType");
            m.f(loadState, "loadState");
            this.loadType = loadType;
            this.fromMediator = z10;
            this.loadState = loadState;
            if (!((loadType == LoadType.REFRESH && !z10 && (loadState instanceof LoadState.NotLoading) && loadState.getEndOfPaginationReached()) ? false : true)) {
                throw new IllegalArgumentException("LoadStateUpdate for local REFRESH may not set endOfPaginationReached = true");
            }
            if (!INSTANCE.canDispatchWithoutInsert$paging_common(loadState, z10)) {
                throw new IllegalArgumentException("LoadStateUpdates cannot be used to dispatch NotLoading unless it is from remote mediator and remote mediator reached end of pagination.");
            }
        }

        public static /* synthetic */ LoadStateUpdate copy$default(LoadStateUpdate loadStateUpdate, LoadType loadType, boolean z10, LoadState loadState, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                loadType = loadStateUpdate.loadType;
            }
            if ((i10 & 2) != 0) {
                z10 = loadStateUpdate.fromMediator;
            }
            if ((i10 & 4) != 0) {
                loadState = loadStateUpdate.loadState;
            }
            return loadStateUpdate.copy(loadType, z10, loadState);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final LoadType getLoadType() {
            return this.loadType;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getFromMediator() {
            return this.fromMediator;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final LoadState getLoadState() {
            return this.loadState;
        }

        public final LoadStateUpdate<T> copy(LoadType loadType, boolean fromMediator, LoadState loadState) {
            m.f(loadType, "loadType");
            m.f(loadState, "loadState");
            return new LoadStateUpdate<>(loadType, fromMediator, loadState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadStateUpdate)) {
                return false;
            }
            LoadStateUpdate loadStateUpdate = (LoadStateUpdate) other;
            return m.a(this.loadType, loadStateUpdate.loadType) && this.fromMediator == loadStateUpdate.fromMediator && m.a(this.loadState, loadStateUpdate.loadState);
        }

        public final boolean getFromMediator() {
            return this.fromMediator;
        }

        public final LoadState getLoadState() {
            return this.loadState;
        }

        public final LoadType getLoadType() {
            return this.loadType;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        public int hashCode() {
            LoadType loadType = this.loadType;
            int iHashCode = (loadType != null ? loadType.hashCode() : 0) * 31;
            boolean z10 = this.fromMediator;
            ?? r10 = z10;
            if (z10) {
                r10 = 1;
            }
            int i10 = (iHashCode + r10) * 31;
            LoadState loadState = this.loadState;
            return i10 + (loadState != null ? loadState.hashCode() : 0);
        }

        public String toString() {
            return "LoadStateUpdate(loadType=" + this.loadType + ", fromMediator=" + this.fromMediator + ", loadState=" + this.loadState + ")";
        }
    }

    private PageEvent() {
    }

    public /* synthetic */ PageEvent(g gVar) {
        this();
    }

    static /* synthetic */ Object flatMap$suspendImpl(PageEvent pageEvent, p pVar, f fVar) {
        if (pageEvent != null) {
            return pageEvent;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.paging.PageEvent<R>");
    }

    static /* synthetic */ Object map$suspendImpl(PageEvent pageEvent, p pVar, f fVar) {
        if (pageEvent != null) {
            return pageEvent;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.paging.PageEvent<R>");
    }

    public Object filter(p<? super T, ? super f<? super Boolean>, ? extends Object> pVar, f<? super PageEvent<T>> fVar) {
        return filter$suspendImpl(this, pVar, fVar);
    }

    public <R> Object flatMap(p<? super T, ? super f<? super Iterable<? extends R>>, ? extends Object> pVar, f<? super PageEvent<R>> fVar) {
        return flatMap$suspendImpl(this, pVar, fVar);
    }

    public <R> Object map(p<? super T, ? super f<? super R>, ? extends Object> pVar, f<? super PageEvent<R>> fVar) {
        return map$suspendImpl(this, pVar, fVar);
    }

    static /* synthetic */ Object filter$suspendImpl(PageEvent pageEvent, p pVar, f fVar) {
        return pageEvent;
    }
}
