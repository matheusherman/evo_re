package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Comparator;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class h implements Comparator<kotlin.reflect.jvm.internal.impl.descriptors.m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f13931a = new h();

    private h() {
    }

    private static Integer b(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.m mVar2) {
        int iC = c(mVar2) - c(mVar);
        if (iC != 0) {
            return Integer.valueOf(iC);
        }
        if (e.B(mVar) && e.B(mVar2)) {
            return 0;
        }
        int iCompareTo = mVar.getName().compareTo(mVar2.getName());
        if (iCompareTo != 0) {
            return Integer.valueOf(iCompareTo);
        }
        return null;
    }

    private static int c(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (e.B(mVar)) {
            return 8;
        }
        if (mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.l) {
            return 7;
        }
        if (mVar instanceof u0) {
            if (((u0) mVar).i0() == null) {
                return 6;
            }
            return 5;
        }
        if (mVar instanceof y) {
            if (((y) mVar).i0() == null) {
                return 4;
            }
            return 3;
        }
        if (mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
            return 2;
        }
        if (mVar instanceof e1) {
            return 1;
        }
        return 0;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.m mVar2) {
        Integer numB = b(mVar, mVar2);
        if (numB != null) {
            return numB.intValue();
        }
        return 0;
    }
}
