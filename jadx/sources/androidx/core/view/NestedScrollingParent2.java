package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public interface NestedScrollingParent2 extends NestedScrollingParent {
    void onNestedPreScroll(@NonNull View view, int i10, int i11, @NonNull int[] iArr, int i12);

    void onNestedScroll(@NonNull View view, int i10, int i11, int i12, int i13, int i14);

    void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i10, int i11);

    boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i10, int i11);

    void onStopNestedScroll(@NonNull View view, int i10);
}
