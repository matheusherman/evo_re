package j0;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0004\u0010\nJ!\u0010\r\u001a\u00028\u0000\"\b\b\u0000\u0010\u000b*\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u000b*\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u000eJ!\u0010\u0012\u001a\u00020\u00002\b\b\u0001\u0010\f\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u00002\b\b\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\u00002\b\b\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001b¨\u0006\u001d"}, d2 = {"Lj0/b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "", "resId", "Landroid/view/ViewGroup;", "parent", "(ILandroid/view/ViewGroup;)V", ExifInterface.GPS_DIRECTION_TRUE, "viewId", "a", "(I)Landroid/view/View;", "b", "", "value", "e", "(ILjava/lang/CharSequence;)Lj0/b;", "", "isGone", "c", "(IZ)Lj0/b;", "isSelected", "d", "Landroid/util/SparseArray;", "Landroid/util/SparseArray;", "views", "com.github.CymChad.brvah"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class b extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final SparseArray<View> views;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(View view) {
        super(view);
        m.f(view, "view");
        this.views = new SparseArray<>();
    }

    public final <T extends View> T b(@IdRes int viewId) {
        T t10 = (T) this.views.get(viewId);
        if (t10 != null) {
            return t10;
        }
        T t11 = (T) this.itemView.findViewById(viewId);
        if (t11 == null) {
            return null;
        }
        this.views.put(viewId, t11);
        return t11;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b(@LayoutRes int i10, ViewGroup parent) {
        m.f(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(i10, parent, false);
        m.e(viewInflate, "from(parent.context).inflate(resId, parent, false)");
        this(viewInflate);
    }

    public final <T extends View> T a(@IdRes int viewId) {
        T t10 = (T) b(viewId);
        if (t10 != null) {
            return t10;
        }
        throw new IllegalStateException(("No view found with id " + viewId).toString());
    }

    public final b c(@IdRes int viewId, boolean isGone) {
        int i10;
        View viewA = a(viewId);
        if (isGone) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        viewA.setVisibility(i10);
        return this;
    }

    public final b d(@IdRes int viewId, boolean isSelected) {
        a(viewId).setSelected(isSelected);
        return this;
    }

    public final b e(@IdRes int viewId, CharSequence value) {
        ((TextView) a(viewId)).setText(value);
        return this;
    }
}
