package n5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.live.evo.R$color;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.util.v;
import com.live.evo.util.z0;
import com.live.evo.widget.GifView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import z1.b1.lb.m.meta.ChannelStreamResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0011B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\u00020\r2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010!\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0007¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010&R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010'R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010'¨\u00060"}, d2 = {"Ln5/f;", "Landroid/widget/BaseAdapter;", "Landroid/content/Context;", "mContext", "", "Lz1/b1/lb/m/meta/ChannelStreamResponse;", "list", "", "currentPlayChannelNumber", "<init>", "(Landroid/content/Context;Ljava/util/List;I)V", "datas", "playingChannelNum", "Lr8/z;", "c", "(Ljava/util/List;I)V", "data", "a", "(Lz1/b1/lb/m/meta/ChannelStreamResponse;)V", "getCount", "()I", "arg0", "", "getItem", "(I)Ljava/lang/Object;", "", "getItemId", "(I)J", "position", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", "arg2", "getView", "(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;", "pos", "b", "(I)V", "Landroid/content/Context;", "I", "Ljava/util/List;", "mHistoryList", "Landroid/view/LayoutInflater;", "d", "Landroid/view/LayoutInflater;", "mInflater", "e", "mCheckPos", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context mContext;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int currentPlayChannelNumber;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private List<ChannelStreamResponse> mHistoryList;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final LayoutInflater mInflater;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mCheckPos;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\f\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\tR\"\u0010\"\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!¨\u0006#"}, d2 = {"Ln5/f$a;", "", "<init>", "(Ln5/f;)V", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "f", "(Landroid/widget/TextView;)V", "channelId", "Lcom/live/evo/widget/GifView;", "b", "Lcom/live/evo/widget/GifView;", "c", "()Lcom/live/evo/widget/GifView;", "i", "(Lcom/live/evo/widget/GifView;)V", "playingGifView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "h", "(Landroid/widget/ImageView;)V", "icon", "d", "j", "vodName", "", "e", "Z", "()Z", "g", "(Z)V", "isCheck", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private TextView channelId;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private GifView playingGifView;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private ImageView icon;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private TextView vodName;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean isCheck;

        public a() {
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final TextView getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final ImageView getIcon() {
            return this.icon;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final GifView getPlayingGifView() {
            return this.playingGifView;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final TextView getVodName() {
            return this.vodName;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final boolean getIsCheck() {
            return this.isCheck;
        }

        public final void f(TextView textView) {
            this.channelId = textView;
        }

        public final void g(boolean z10) {
            this.isCheck = z10;
        }

        public final void h(ImageView imageView) {
            this.icon = imageView;
        }

        public final void i(GifView gifView) {
            this.playingGifView = gifView;
        }

        public final void j(TextView textView) {
            this.vodName = textView;
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int arg0) {
        return arg0;
    }

    public f(Context mContext, List<ChannelStreamResponse> list, int i10) {
        kotlin.jvm.internal.m.f(mContext, "mContext");
        kotlin.jvm.internal.m.f(list, "list");
        this.mContext = mContext;
        this.currentPlayChannelNumber = i10;
        ArrayList arrayList = new ArrayList();
        this.mHistoryList = arrayList;
        this.mCheckPos = -1;
        arrayList.addAll(list);
        this.mInflater = LayoutInflater.from(mContext);
    }

    public final void a(ChannelStreamResponse data) {
        kotlin.jvm.internal.m.f(data, "data");
        this.mHistoryList.remove(data);
        notifyDataSetChanged();
    }

    public final void b(int pos) {
        this.mCheckPos = pos;
        notifyDataSetChanged();
    }

    public final void c(List<ChannelStreamResponse> datas, int playingChannelNum) {
        kotlin.jvm.internal.m.f(datas, "datas");
        this.currentPlayChannelNumber = playingChannelNum;
        this.mHistoryList.clear();
        this.mHistoryList.addAll(datas);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mHistoryList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int arg0) {
        return this.mHistoryList.get(arg0);
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup arg2) {
        a aVar;
        View viewInflate;
        int i10;
        if (convertView == null) {
            aVar = new a();
            viewInflate = this.mInflater.inflate(R$layout.history_delete_program_list_item, (ViewGroup) null);
            aVar.f(viewInflate != null ? (TextView) viewInflate.findViewById(R$id.historyprogramlistitem_tv_channel_id) : null);
            aVar.i(viewInflate != null ? (GifView) viewInflate.findViewById(R$id.historyprogramlistitem_iv_play) : null);
            aVar.h(viewInflate != null ? (ImageView) viewInflate.findViewById(R$id.historyprogramlistitem_iv_program_icons) : null);
            aVar.j(viewInflate != null ? (TextView) viewInflate.findViewById(R$id.historyprogramlistitem_tv_program_item_name) : null);
            if (viewInflate != null) {
                viewInflate.setTag(aVar);
            }
        } else {
            aVar = (a) convertView.getTag();
            viewInflate = convertView;
        }
        ChannelStreamResponse channelStreamResponse = this.mHistoryList.get(position);
        String strB = t.v.c.i.a.f18646a.b(channelStreamResponse);
        if (strB.length() <= 1) {
            strB = "00" + strB;
        } else if (strB.length() <= 2) {
            strB = "0" + strB;
        }
        kotlin.jvm.internal.m.c(aVar);
        TextView channelId = aVar.getChannelId();
        kotlin.jvm.internal.m.c(channelId);
        channelId.setText(strB);
        TextView vodName = aVar.getVodName();
        kotlin.jvm.internal.m.c(vodName);
        vodName.setText(channelStreamResponse.getStreamName());
        GifView playingGifView = aVar.getPlayingGifView();
        kotlin.jvm.internal.m.c(playingGifView);
        playingGifView.setVisibility(this.currentPlayChannelNumber == Integer.parseInt(strB) ? 0 : 4);
        GifView playingGifView2 = aVar.getPlayingGifView();
        kotlin.jvm.internal.m.c(playingGifView2);
        playingGifView2.setMovieResource(R$drawable.channel_play);
        v.c(this.mContext, channelStreamResponse.getIconUrl(), 2131102158, aVar.getIcon());
        if (this.mCheckPos == position) {
            z0.d(convertView);
            aVar.g(true);
            i10 = R$color.item_selected_color;
        } else {
            if (aVar.getIsCheck()) {
                z0.g(convertView);
            }
            aVar.g(false);
            i10 = R$color.item_normal_color;
        }
        TextView channelId2 = aVar.getChannelId();
        kotlin.jvm.internal.m.c(channelId2);
        channelId2.setTextColor(this.mContext.getResources().getColor(i10));
        TextView vodName2 = aVar.getVodName();
        kotlin.jvm.internal.m.c(vodName2);
        vodName2.setTextColor(this.mContext.getResources().getColor(i10));
        kotlin.jvm.internal.m.c(viewInflate);
        return viewInflate;
    }
}
