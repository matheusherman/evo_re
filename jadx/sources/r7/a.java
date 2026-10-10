package r7;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.tvc.lib.mobile.ext.g;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0004¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00018\u0000H\u0004¢\u0006\u0004\b\u0012\u0010\u0013J7\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00018\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010 \u001a\u00020\u0003*\u00020\u00032\b\b\u0001\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001d2\b\b\u0003\u0010\u001f\u001a\u00020\n¢\u0006\u0004\b \u0010!J/\u0010\"\u001a\u00020\u0003*\u00020\u00032\b\b\u0001\u0010\u001c\u001a\u00020\n2\b\b\u0003\u0010\u001e\u001a\u00020\n2\b\b\u0003\u0010\u001f\u001a\u00020\n¢\u0006\u0004\b\"\u0010#J5\u0010$\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00028\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\b$\u0010\u0018J'\u0010\u0001\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00028\u0000H&¢\u0006\u0004\b\u0001\u0010\u0013J\u000f\u0010%\u001a\u00020\nH'¢\u0006\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lr7/a;", ExifInterface.LONGITUDE_EAST, "Lg0/d;", "Lj0/b;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "parent", "", "viewType", "N", "(Landroid/content/Context;Landroid/view/ViewGroup;I)Lj0/b;", "holder", "position", "item", "Lr8/z;", "L", "(Lj0/b;ILjava/lang/Object;)V", "", "", "payloads", "M", "(Lj0/b;ILjava/lang/Object;Ljava/util/List;)V", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onViewRecycled", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "viewId", "", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR, "I", "(Lj0/b;ILjava/lang/String;I)Lj0/b;", "H", "(Lj0/b;III)Lj0/b;", "F", "G", "()I", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class a<E> extends g0.d<E, j0.b> {
    public a() {
        super(null, 1, null);
    }

    public abstract void E(j0.b holder, int position, E item);

    @LayoutRes
    public abstract int G();

    public static /* synthetic */ j0.b J(a aVar, j0.b bVar, int i10, int i11, int i12, int i13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadImg");
        }
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = 0;
        }
        return aVar.H(bVar, i10, i11, i12);
    }

    public static /* synthetic */ j0.b K(a aVar, j0.b bVar, int i10, String str, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadImg");
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        return aVar.I(bVar, i10, str, i11);
    }

    public void F(j0.b holder, int position, E item, List<? extends Object> payloads) {
        m.f(holder, "holder");
        m.f(payloads, "payloads");
    }

    public final j0.b H(j0.b bVar, @IdRes int i10, @DrawableRes int i11, @DrawableRes int i12) {
        m.f(bVar, "<this>");
        g.f((AppCompatImageView) bVar.a(i10), i11, i12, 0, 4, null);
        return bVar;
    }

    public final j0.b I(j0.b bVar, @IdRes int i10, String url, @DrawableRes int i11) {
        m.f(bVar, "<this>");
        m.f(url, "url");
        g.g((AppCompatImageView) bVar.a(i10), url, i11, 0, 4, null);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g0.d
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public final void q(j0.b holder, int position, E item) {
        m.f(holder, "holder");
        if (item == null) {
            return;
        }
        E(holder, position, item);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g0.d
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public void r(j0.b holder, int position, E item, List<? extends Object> payloads) {
        m.f(holder, "holder");
        m.f(payloads, "payloads");
        if (item != null) {
            F(holder, position, item, payloads);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g0.d
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public final j0.b s(Context context, ViewGroup parent, int viewType) {
        m.f(context, "context");
        m.f(parent, "parent");
        return new j0.b(G(), parent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        m.f(holder, "holder");
        super.onViewRecycled(holder);
    }
}
