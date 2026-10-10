package g0;

import android.animation.Animator;
import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.h0;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0010!\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 W*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\b\u0012\u0004\u0012\u00020\u00020\u0004:\u0005UZ]7eB\u0017\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0013\u001a\u00028\u00012\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H$¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0017\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u00012\u0006\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00018\u0000H$¢\u0006\u0004\b\u0017\u0010\u0018J7\u0010\u001b\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u00012\u0006\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00018\u00002\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0005H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001d\u001a\u00020\u00112\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ%\u0010 \u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0014¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u0011¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b$\u0010%J\u001d\u0010&\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b&\u0010'J\u001d\u0010(\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b(\u0010)J+\u0010(\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00112\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0004\b(\u0010+J\u0017\u0010-\u001a\u00020,2\u0006\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0017¢\u0006\u0004\b/\u0010\fJ\u0017\u00100\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0017¢\u0006\u0004\b0\u0010\fJ\u0017\u00103\u001a\u00020\n2\u0006\u00102\u001a\u000201H\u0017¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\n2\u0006\u00102\u001a\u000201H\u0017¢\u0006\u0004\b5\u00104J\u001f\u00107\u001a\u00020\n2\u0006\u00106\u001a\u00028\u00012\u0006\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b7\u0010)J\u001f\u00109\u001a\u00020\n2\u0006\u00109\u001a\u0002082\u0006\u0010\u0015\u001a\u00020\u0011H\u0014¢\u0006\u0004\b9\u0010:J\u001f\u0010;\u001a\u00020\n2\u0006\u00109\u001a\u0002082\u0006\u0010\u0015\u001a\u00020\u0011H\u0014¢\u0006\u0004\b;\u0010:J\u001f\u0010=\u001a\u00020<2\u0006\u00109\u001a\u0002082\u0006\u0010\u0015\u001a\u00020\u0011H\u0014¢\u0006\u0004\b=\u0010>J\u0017\u0010@\u001a\u00020<2\u0006\u0010?\u001a\u00020\u0011H\u0016¢\u0006\u0004\b@\u0010AJ\u0019\u0010B\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\bB\u0010CJ\u001f\u0010E\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010D\u001a\u00020\u0011¢\u0006\u0004\bE\u0010FJ\u001d\u0010G\u001a\u00020<2\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\bG\u0010HJ\u001f\u0010K\u001a\u00020\n2\u0006\u0010J\u001a\u00020I2\u0006\u0010\t\u001a\u00020\u0002H\u0014¢\u0006\u0004\bK\u0010LJ\u001f\u0010M\u001a\u00020\n2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005H\u0016¢\u0006\u0004\bM\u0010\bJ\"\u0010O\u001a\u00020\n2\b\b\u0001\u0010\u0015\u001a\u00020\u00112\u0006\u0010N\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\bO\u0010PJ)\u0010S\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u000e\u0010R\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010Q¢\u0006\u0004\bS\u0010TR(\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010\bR\u0016\u0010\\\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u001e\u0010_\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R$\u0010c\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000a\u0018\u00010`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010bR$\u0010f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000d\u0018\u00010`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010bR\u001e\u0010i\u001a\n\u0012\u0004\u0012\u00020g\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010VR\u0018\u0010l\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR*\u0010o\u001a\u00020<2\u0006\u0010m\u001a\u00020<8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR.\u0010y\u001a\u0004\u0018\u0001082\b\u0010m\u001a\u0004\u0018\u0001088\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\"\u0010}\u001a\u00020<8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010n\u001a\u0004\b{\u0010p\"\u0004\b|\u0010rR\"\u0010~\u001a\u00020<8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010n\u001a\u0004\b~\u0010p\"\u0004\b\u007f\u0010rR6\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0080\u00012\t\u0010m\u001a\u0005\u0018\u00010\u0080\u00018\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0005\b \u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001c\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000*8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0087\u0001\u0010XR\u0013\u00102\u001a\u0002018F¢\u0006\b\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0012\u0010\u000e\u001a\u00020\r8F¢\u0006\u0007\u001a\u0005\bz\u0010\u008b\u0001¨\u0006\u008c\u0001"}, d2 = {"Lg0/d;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "", "items", "<init>", "(Ljava/util/List;)V", "holder", "Lr8/z;", "w", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "parent", "", "viewType", "s", "(Landroid/content/Context;Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "item", "q", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILjava/lang/Object;)V", "", "payloads", "r", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILjava/lang/Object;Ljava/util/List;)V", "k", "(Ljava/util/List;)I", "list", "l", "(ILjava/util/List;)I", "getItemCount", "()I", "getItemViewType", "(I)I", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILjava/util/List;)V", "", "getItemId", "(I)J", "onViewAttachedToWindow", "onViewDetachedFromWindow", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onDetachedFromRecyclerView", "viewHolder", "d", "Landroid/view/View;", "v", "(Landroid/view/View;I)V", "t", "", "u", "(Landroid/view/View;I)Z", "itemType", "p", "(I)Z", "getItem", "(I)Ljava/lang/Object;", "layoutResId", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Landroid/content/Context;I)V", "h", "(Ljava/util/List;)Z", "Landroid/animation/Animator;", "anim", "D", "(Landroid/animation/Animator;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "submitList", "data", "x", "(ILjava/lang/Object;)V", "Lg0/d$d;", "listener", "C", "(Lg0/d$d;)Lg0/d;", "a", "Ljava/util/List;", "m", "()Ljava/util/List;", "B", "b", "I", "mLastPosition", "c", "Lg0/d$d;", "mOnItemClickListener", "Landroid/util/SparseArray;", "Lg0/d$b;", "Landroid/util/SparseArray;", "mOnItemChildClickArray", "Lg0/d$c;", "e", "mOnItemChildLongClickArray", "Lg0/d$e;", "f", "mOnViewAttachStateChangeListeners", "g", "Landroidx/recyclerview/widget/RecyclerView;", "_recyclerView", "value", "Z", "isEmptyViewEnable", "()Z", "z", "(Z)V", "i", "Landroid/view/View;", "getEmptyView", "()Landroid/view/View;", "y", "(Landroid/view/View;)V", "emptyView", "j", "getAnimationEnable", "setAnimationEnable", "animationEnable", "isAnimationFirstOnly", "setAnimationFirstOnly", "Lh0/b;", "Lh0/b;", "getItemAnimation", "()Lh0/b;", "setItemAnimation", "(Lh0/b;)V", "itemAnimation", "n", "mutableItems", "o", "()Landroidx/recyclerview/widget/RecyclerView;", "()Landroid/content/Context;", "com.github.CymChad.brvah"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class d<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private List<? extends T> items;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int mLastPosition;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private InterfaceC0181d<T> mOnItemClickListener;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private SparseArray<b<T>> mOnItemChildClickArray;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private SparseArray<c<T>> mOnItemChildLongClickArray;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private List<e> mOnViewAttachStateChangeListeners;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private RecyclerView _recyclerView;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isEmptyViewEnable;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View emptyView;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean animationEnable;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isAnimationFirstOnly;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private h0.b itemAnimation;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002J1\u0010\n\u001a\u00020\t2\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u00028\u0002\u0012\u0002\b\u00030\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lg0/d$b;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lg0/d;", "adapter", "Landroid/view/View;", "view", "", "position", "Lr8/z;", "a", "(Lg0/d;Landroid/view/View;I)V", "com.github.CymChad.brvah"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface b<T> {
        void a(d<T, ?> adapter, View view, int position);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002J1\u0010\n\u001a\u00020\t2\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u00028\u0002\u0012\u0002\b\u00030\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lg0/d$c;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lg0/d;", "adapter", "Landroid/view/View;", "view", "", "position", "", "a", "(Lg0/d;Landroid/view/View;I)Z", "com.github.CymChad.brvah"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface c<T> {
        boolean a(d<T, ?> adapter, View view, int position);
    }

    /* JADX INFO: renamed from: g0.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002J1\u0010\n\u001a\u00020\t2\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u00028\u0002\u0012\u0002\b\u00030\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lg0/d$d;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lg0/d;", "adapter", "Landroid/view/View;", "view", "", "position", "Lr8/z;", "b", "(Lg0/d;Landroid/view/View;I)V", "com.github.CymChad.brvah"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface InterfaceC0181d<T> {
        void b(d<T, ?> adapter, View view, int position);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lg0/d$e;", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "Lr8/z;", "a", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "b", "com.github.CymChad.brvah"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface e {
        void a(RecyclerView.ViewHolder holder);

        void b(RecyclerView.ViewHolder holder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (i(this, null, 1, null)) {
            return 1;
        }
        return k(m());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int position) {
        if (i(this, null, 1, null)) {
            return 268436821;
        }
        return l(position, m());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        m.f(holder, "holder");
        if (holder instanceof j0.a) {
            ((j0.a) holder).a(this.emptyView);
        } else {
            q(holder, position, getItem(position));
        }
    }

    protected abstract void q(VH holder, int position, T item);

    protected abstract VH s(Context context, ViewGroup parent, int viewType);

    public final void y(View view) {
        boolean zI = i(this, null, 1, null);
        this.emptyView = view;
        boolean zI2 = i(this, null, 1, null);
        if (zI && !zI2) {
            notifyItemRemoved(0);
            return;
        }
        if (zI2 && !zI) {
            notifyItemInserted(0);
        } else if (zI && zI2) {
            notifyItemChanged(0, 0);
        }
    }

    public final void z(boolean z10) {
        boolean zI = i(this, null, 1, null);
        this.isEmptyViewEnable = z10;
        boolean zI2 = i(this, null, 1, null);
        if (zI && !zI2) {
            notifyItemRemoved(0);
            return;
        }
        if (zI2 && !zI) {
            notifyItemInserted(0);
        } else if (zI && zI2) {
            notifyItemChanged(0, 0);
        }
    }

    public /* synthetic */ d(List list, int i10, g gVar) {
        this((i10 & 1) != 0 ? r.l() : list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(RecyclerView.ViewHolder viewHolder, d this$0, View v10) {
        m.f(viewHolder, "$viewHolder");
        m.f(this$0, "this$0");
        int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return;
        }
        m.e(v10, "v");
        this$0.t(v10, bindingAdapterPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(RecyclerView.ViewHolder viewHolder, d this$0, View v10) {
        m.f(viewHolder, "$viewHolder");
        m.f(this$0, "this$0");
        int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return false;
        }
        m.e(v10, "v");
        return this$0.u(v10, bindingAdapterPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(RecyclerView.ViewHolder viewHolder, d this$0, View v10) {
        m.f(viewHolder, "$viewHolder");
        m.f(this$0, "this$0");
        int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return;
        }
        m.e(v10, "v");
        this$0.v(v10, bindingAdapterPosition);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean i(d dVar, List list, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: displayEmptyView");
        }
        if ((i10 & 1) != 0) {
            list = dVar.m();
        }
        return dVar.h(list);
    }

    private final void w(RecyclerView.ViewHolder holder) {
        if (this.animationEnable) {
            if (!this.isAnimationFirstOnly || holder.getLayoutPosition() > this.mLastPosition) {
                h0.b aVar = this.itemAnimation;
                if (aVar == null) {
                    aVar = new h0.a(0L, 0.0f, 3, null);
                }
                View view = holder.itemView;
                m.e(view, "holder.itemView");
                D(aVar.a(view), holder);
                this.mLastPosition = holder.getLayoutPosition();
            }
        }
    }

    public final void A(Context context, @LayoutRes int layoutResId) {
        m.f(context, "context");
        y(LayoutInflater.from(context).inflate(layoutResId, (ViewGroup) new FrameLayout(context), false));
    }

    public void B(List<? extends T> list) {
        m.f(list, "<set-?>");
        this.items = list;
    }

    public final d<T, VH> C(InterfaceC0181d<T> listener) {
        this.mOnItemClickListener = listener;
        return this;
    }

    protected void D(Animator anim, RecyclerView.ViewHolder holder) {
        m.f(anim, "anim");
        m.f(holder, "holder");
        anim.start();
    }

    protected void d(final VH viewHolder, int viewType) {
        m.f(viewHolder, "viewHolder");
        if (this.mOnItemClickListener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: g0.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.g(viewHolder, this, view);
                }
            });
        }
        SparseArray<b<T>> sparseArray = this.mOnItemChildClickArray;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i10 = 0; i10 < size; i10++) {
                View viewFindViewById = viewHolder.itemView.findViewById(sparseArray.keyAt(i10));
                if (viewFindViewById != null) {
                    m.e(viewFindViewById, "findViewById<View>(id)");
                    viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: g0.b
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            d.e(viewHolder, this, view);
                        }
                    });
                }
            }
        }
        SparseArray<c<T>> sparseArray2 = this.mOnItemChildLongClickArray;
        if (sparseArray2 != null) {
            int size2 = sparseArray2.size();
            for (int i11 = 0; i11 < size2; i11++) {
                View viewFindViewById2 = viewHolder.itemView.findViewById(sparseArray2.keyAt(i11));
                if (viewFindViewById2 != null) {
                    m.e(viewFindViewById2, "findViewById<View>(id)");
                    viewFindViewById2.setOnLongClickListener(new View.OnLongClickListener() { // from class: g0.c
                        @Override // android.view.View.OnLongClickListener
                        public final boolean onLongClick(View view) {
                            return d.f(viewHolder, this, view);
                        }
                    });
                }
            }
        }
    }

    public final boolean h(List<? extends T> list) {
        m.f(list, "list");
        if (this.emptyView == null || !this.isEmptyViewEnable) {
            return false;
        }
        return list.isEmpty();
    }

    protected int k(List<? extends T> items) {
        m.f(items, "items");
        return items.size();
    }

    protected int l(int position, List<? extends T> list) {
        m.f(list, "list");
        return 0;
    }

    public List<T> m() {
        return this.items;
    }

    public final RecyclerView o() {
        RecyclerView recyclerView = this._recyclerView;
        if (recyclerView == null) {
            throw new IllegalStateException("Please get it after onAttachedToRecyclerView()");
        }
        m.c(recyclerView);
        return recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        m.f(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this._recyclerView = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.f(parent, "parent");
        if (viewType == 268436821) {
            FrameLayout frameLayout = new FrameLayout(parent.getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return new j0.a(frameLayout);
        }
        Context context = parent.getContext();
        m.e(context, "parent.context");
        RecyclerView.ViewHolder viewHolderS = s(context, parent, viewType);
        d(viewHolderS, viewType);
        return viewHolderS;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        m.f(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this._recyclerView = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        m.f(holder, "holder");
        super.onViewAttachedToWindow(holder);
        if (p(getItemViewType(holder.getBindingAdapterPosition()))) {
            i0.a.a(holder);
        } else {
            w(holder);
        }
        List<e> list = this.mOnViewAttachStateChangeListeners;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((e) it.next()).a(holder);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        m.f(holder, "holder");
        List<e> list = this.mOnViewAttachStateChangeListeners;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((e) it.next()).b(holder);
            }
        }
    }

    protected void r(VH holder, int position, T item, List<? extends Object> payloads) {
        m.f(holder, "holder");
        m.f(payloads, "payloads");
        q(holder, position, item);
    }

    public void submitList(List<? extends T> list) {
        List<? extends T> listL = list == null ? r.l() : list;
        if (list == m()) {
            return;
        }
        this.mLastPosition = -1;
        boolean zI = i(this, null, 1, null);
        boolean zH = h(listL);
        if (zI && !zH) {
            B(listL);
            notifyItemRemoved(0);
            notifyItemRangeInserted(0, listL.size());
        } else if (zH && !zI) {
            notifyItemRangeRemoved(0, m().size());
            B(listL);
            notifyItemInserted(0);
        } else if (zI && zH) {
            B(listL);
            notifyItemChanged(0, 0);
        } else {
            B(listL);
            notifyDataSetChanged();
        }
    }

    protected void t(View v10, int position) {
        b<T> bVar;
        m.f(v10, "v");
        SparseArray<b<T>> sparseArray = this.mOnItemChildClickArray;
        if (sparseArray == null || (bVar = sparseArray.get(v10.getId())) == null) {
            return;
        }
        bVar.a(this, v10, position);
    }

    protected boolean u(View v10, int position) {
        c<T> cVar;
        m.f(v10, "v");
        SparseArray<c<T>> sparseArray = this.mOnItemChildLongClickArray;
        if (sparseArray == null || (cVar = sparseArray.get(v10.getId())) == null) {
            return false;
        }
        return cVar.a(this, v10, position);
    }

    protected void v(View v10, int position) {
        m.f(v10, "v");
        InterfaceC0181d<T> interfaceC0181d = this.mOnItemClickListener;
        if (interfaceC0181d != null) {
            interfaceC0181d.b(this, v10, position);
        }
    }

    private final List<T> n() {
        List<T> listM = m();
        if (listM instanceof ArrayList) {
            List<T> listM2 = m();
            m.d(listM2, "null cannot be cast to non-null type java.util.ArrayList<T of com.chad.library.adapter.base.BaseQuickAdapter>");
            return (ArrayList) listM2;
        }
        if (h0.n(listM)) {
            List<T> listM3 = m();
            m.d(listM3, "null cannot be cast to non-null type kotlin.collections.MutableList<T of com.chad.library.adapter.base.BaseQuickAdapter>");
            return h0.c(listM3);
        }
        List<T> listQ0 = r.Q0(m());
        B(listQ0);
        return listQ0;
    }

    public final T getItem(@IntRange(from = 0) int position) {
        return (T) r.j0(m(), position);
    }

    public final Context j() {
        Context context = o().getContext();
        m.e(context, "recyclerView.context");
        return context;
    }

    public boolean p(int itemType) {
        if (itemType == 268436821) {
            return true;
        }
        return false;
    }

    public void x(@IntRange(from = 0) int position, T data) {
        if (position < m().size()) {
            n().set(position, data);
            notifyItemChanged(position);
            return;
        }
        throw new IndexOutOfBoundsException("position: " + position + ". size:" + m().size());
    }

    public d(List<? extends T> items) {
        m.f(items, "items");
        this.items = items;
        this.mLastPosition = -1;
        this.isAnimationFirstOnly = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<Object> payloads) {
        m.f(holder, "holder");
        m.f(payloads, "payloads");
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position);
        } else if (holder instanceof j0.a) {
            ((j0.a) holder).a(this.emptyView);
        } else {
            r(holder, position, getItem(position), payloads);
        }
    }
}
