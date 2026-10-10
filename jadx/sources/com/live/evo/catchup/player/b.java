package com.live.evo.catchup.player;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.c;
import com.youth.banner.adapter.BannerAdapter;
import java.util.List;
import l.j;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b extends BannerAdapter<String, RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5639a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f5640a;

        public a(@NonNull b bVar, ImageView imageView) {
            super(imageView);
            this.f5640a = imageView;
        }
    }

    @Override // com.youth.banner.holder.IViewHolder
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindView(RecyclerView.ViewHolder viewHolder, String str, int i10, int i11) {
        try {
            c.t(this.f5639a).u(str).g(j.f15048a).E0(((a) viewHolder).f5640a);
        } catch (Exception unused) {
        }
    }

    @Override // com.youth.banner.holder.IViewHolder
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public a onCreateHolder(ViewGroup viewGroup, int i10) {
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new a(this, imageView);
    }

    public b(Context context, List<String> list) {
        super(list);
        this.f5639a = context;
    }
}
