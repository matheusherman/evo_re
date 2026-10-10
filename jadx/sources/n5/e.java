package n5;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f15985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f15986d;

    public e(int i10, int i11, boolean z10, int i12) {
        this.f15983a = i10;
        this.f15984b = i11;
        this.f15985c = z10;
        this.f15986d = i12;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view) - this.f15986d;
        if (childAdapterPosition >= 0) {
            int i10 = this.f15983a;
            int i11 = childAdapterPosition % i10;
            if (this.f15985c) {
                int i12 = this.f15984b;
                rect.left = i12 - ((i11 * i12) / i10);
                rect.right = ((i11 + 1) * i12) / i10;
                if (childAdapterPosition < i10) {
                    rect.top = i12;
                }
                rect.bottom = i12;
                return;
            }
            int i13 = this.f15984b;
            rect.left = (i11 * i13) / i10;
            rect.right = i13 - (((i11 + 1) * i13) / i10);
            if (childAdapterPosition >= i10) {
                rect.top = i13;
            }
        }
    }
}
