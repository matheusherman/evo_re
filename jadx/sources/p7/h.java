package p7;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tvc.lib.R$id;
import t.v.c.widget.LinearLayout;
import t.v.c.widget.MyButton;
import t.v.c.widget.MyRelativelayout;
import t.v.c.widget.MyRoundImageView;
import t.v.c.widget.TextView;
import t.v.c.widget.videoview.PlayerView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class h extends g {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts D = null;

    @Nullable
    private static final SparseIntArray E;

    @NonNull
    private final FrameLayout A;

    @Nullable
    private final i B;
    private long C;

    public h(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 28, D, E));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.C = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.C != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.C = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i10, Object obj, int i11) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, @Nullable Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        E = sparseIntArray;
        sparseIntArray.put(R$id.loading_layout_tvc_lib, 4);
        sparseIntArray.put(R$id.channel_video_view, 5);
        sparseIntArray.put(R$id.livenewa_iv_no_signal, 6);
        sparseIntArray.put(R$id.tip_msg, 7);
        sparseIntArray.put(R$id.btn_retry, 8);
        sparseIntArray.put(R$id.top_view, 9);
        sparseIntArray.put(R$id.iv_back, 10);
        sparseIntArray.put(R$id.tv_title, 11);
        sparseIntArray.put(R$id.iv_video_love, 12);
        sparseIntArray.put(R$id.iv_video_subtitle, 13);
        sparseIntArray.put(R$id.center_view, 14);
        sparseIntArray.put(R$id.play_pause_btn, 15);
        sparseIntArray.put(R$id.bottom_view, 16);
        sparseIntArray.put(R$id.iv_video_sound, 17);
        sparseIntArray.put(R$id.iv_video_full, 18);
        sparseIntArray.put(R$id.start_time, 19);
        sparseIntArray.put(R$id.progress_playback, 20);
        sparseIntArray.put(R$id.end_time, 21);
        sparseIntArray.put(R$id.vod_fullscreen_menu_bottom, 22);
        sparseIntArray.put(R$id.cl_bind, 23);
        sparseIntArray.put(R$id.tv_bind_title, 24);
        sparseIntArray.put(R$id.tv_watch, 25);
        sparseIntArray.put(R$id.tv_bind, 26);
        sparseIntArray.put(R$id.rv_channel_list, 27);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private h(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        MyRelativelayout myRelativelayout = (MyRelativelayout) objArr[16];
        MyButton myButton = (MyButton) objArr[8];
        MyRelativelayout myRelativelayout2 = (MyRelativelayout) objArr[14];
        PlayerView playerView = (PlayerView) objArr[5];
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[23];
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[1];
        TextView textView = (TextView) objArr[21];
        MyRelativelayout myRelativelayout3 = (MyRelativelayout) objArr[2];
        AppCompatImageView appCompatImageView = (AppCompatImageView) objArr[10];
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) objArr[18];
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) objArr[12];
        AppCompatImageView appCompatImageView4 = (AppCompatImageView) objArr[17];
        AppCompatImageView appCompatImageView5 = (AppCompatImageView) objArr[13];
        ImageView imageView = (ImageView) objArr[6];
        Object obj = objArr[4];
        super(dataBindingComponent, view, 0, myRelativelayout, myButton, myRelativelayout2, playerView, constraintLayout, constraintLayout2, textView, myRelativelayout3, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, appCompatImageView5, imageView, obj != null ? j.a((View) obj) : null, (MyRoundImageView) objArr[15], (SeekBar) objArr[20], (RecyclerView) objArr[27], (TextView) objArr[19], (TextView) objArr[7], (MyRelativelayout) objArr[9], (android.widget.TextView) objArr[26], (android.widget.TextView) objArr[24], (android.widget.TextView) objArr[11], (android.widget.TextView) objArr[25], (LinearLayout) objArr[22]);
        this.C = -1L;
        this.f17387f.setTag(null);
        this.f17389h.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.A = frameLayout;
        frameLayout.setTag(null);
        Object obj2 = objArr[3];
        this.B = obj2 != null ? i.a((View) obj2) : null;
        setRootTag(view);
        invalidateAll();
    }
}
