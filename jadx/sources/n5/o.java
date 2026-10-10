package n5;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.live.evo.R$dimen;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.util.o0;
import com.live.evo.util.s0;
import com.live.evo.util.t;
import com.live.evo.util.u1;
import com.live.evo.util.v;
import com.live.evo.widget.GifView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import r8.z;
import z1.b1.lb.m.meta.EPGProgramme;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class o extends BaseAdapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<i5.h> f16035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f16036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LayoutInflater f16037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f16038e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f16039f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<i5.h> f16040g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q6.b f16034a = q6.c.d(o.class);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ObjectAnimator f16041h = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TextView f16042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ImageView f16043b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ImageView f16044c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ImageView f16045d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ImageView f16046e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private TextView f16047f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private TextView f16048g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private TextView f16049h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private ImageView f16050i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private GifView f16051j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private ObjectAnimator f16052k;

        /* synthetic */ a(o oVar, View view, p pVar) {
            this(oVar, view);
        }

        private a(o oVar, View view) {
            this.f16052k = null;
            this.f16042a = (TextView) view.findViewById(R$id.programlistitem_tv_channel_id);
            this.f16043b = (ImageView) view.findViewById(R$id.programlistitem_iv_fav);
            this.f16045d = (ImageView) view.findViewById(R$id.programlistitem_iv_play_image);
            this.f16046e = (ImageView) view.findViewById(R$id.programlistitem_iv_icons);
            this.f16047f = (TextView) view.findViewById(R$id.programlistitem_tv_admin_text);
            this.f16048g = (TextView) view.findViewById(R$id.programlistitem_tv_item_name);
            this.f16049h = (TextView) view.findViewById(R$id.programlistitem_mtv_smallepg);
            this.f16044c = (ImageView) view.findViewById(R$id.programlistitem_iv_play_back);
            this.f16050i = (ImageView) view.findViewById(R$id.programlistitem_iv_newimg);
            this.f16051j = (GifView) view.findViewById(R$id.programlistitem_iv_play);
            if (com.live.evo.util.e.b().a()) {
                t.b(this.f16042a);
                t.b(this.f16048g);
                t.b(this.f16047f);
                t.b(this.f16049h);
                return;
            }
            t.c(this.f16042a);
            t.a(this.f16048g);
            t.a(this.f16047f);
            t.b(this.f16049h);
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        final a aVar;
        p pVar = null;
        if (view == null) {
            view = this.f16037d.inflate(R$layout.program_list_item, (ViewGroup) null);
            view.setEnabled(false);
            aVar = new a(this, view, pVar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        i5.h hVar = this.f16040g.get(i10);
        if (t.v.c.i.a.f18646a.m0(Integer.parseInt(hVar.b()))) {
            String strO = o0.p().o();
            if (!TextUtils.isEmpty(strO) && new File(strO).exists()) {
                aVar.f16043b.setBackground(Drawable.createFromPath(strO));
            }
            aVar.f16042a.setTextSize(2, this.f16036c.getResources().getDimension(R$dimen.channelid_favorite_size));
            aVar.f16043b.setVisibility(0);
        } else {
            aVar.f16042a.setTextSize(2, 14.0f);
            aVar.f16043b.setVisibility(8);
        }
        String strValueOf = String.valueOf(hVar.i() + 1);
        if (strValueOf.length() <= 1) {
            strValueOf = "00" + strValueOf;
        } else if (strValueOf.length() <= 2) {
            strValueOf = "0" + strValueOf;
        }
        aVar.f16042a.setText(strValueOf);
        aVar.f16048g.setText(hVar.e());
        if (aVar.f16047f.getVisibility() == 0) {
            aVar.f16047f.setVisibility(8);
        }
        s0 s0Var = s0.f7342a;
        boolean zM = s0Var.M(hVar.f(), hVar.b(), null);
        int i11 = hVar.i();
        if (zM) {
            aVar.f16044c.setVisibility(0);
        } else {
            aVar.f16044c.setVisibility(4);
        }
        v.c(this.f16036c, hVar.g(), 2131102158, aVar.f16046e);
        if (this.f16038e == i11) {
            aVar.f16051j.setVisibility(0);
            aVar.f16051j.setMovieResource(R$drawable.channel_play);
        } else {
            aVar.f16051j.setVisibility(8);
        }
        hVar.m();
        aVar.f16050i.setVisibility(8);
        if (com.live.evo.util.e.b().f()) {
            try {
                s0Var.v(hVar.f(), u1.b().a(), new c9.l() { // from class: n5.n
                    @Override // c9.l
                    public final Object invoke(Object obj) {
                        return o.a(aVar, (EPGProgramme) obj);
                    }
                });
                return view;
            } catch (Exception unused) {
                aVar.f16049h.setText("");
                aVar.f16049h.setVisibility(8);
            }
        }
        return view;
    }

    public static /* synthetic */ z a(a aVar, EPGProgramme ePGProgramme) {
        if (ePGProgramme == null) {
            aVar.f16049h.setText("");
            aVar.f16049h.setVisibility(8);
            return null;
        }
        String title = ePGProgramme.getTitle();
        if (TextUtils.isEmpty(title)) {
            aVar.f16049h.setText("");
            aVar.f16049h.setVisibility(8);
            return null;
        }
        aVar.f16049h.setText(title);
        aVar.f16049h.setVisibility(0);
        return null;
    }

    public void b() {
        ObjectAnimator objectAnimator = this.f16041h;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f16041h = null;
        }
    }

    public void c(List<i5.h> list, int i10) {
        List<i5.h> list2 = this.f16040g;
        if (list2 != null) {
            this.f16038e = i10;
            this.f16039f = i10;
            list2.clear();
            if (list != null && list.size() > 0) {
                this.f16040g.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    public void d(int i10) {
        this.f16038e = i10;
        notifyDataSetChanged();
    }

    public void e(View view, boolean z10) {
        if (view == null) {
            return;
        }
        try {
            a aVar = (a) view.getTag();
            if (aVar != null) {
                if (z10) {
                    ((View) aVar.f16042a.getParent()).setEnabled(false);
                } else {
                    ((View) aVar.f16042a.getParent()).setEnabled(true);
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f16040g.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f16040g.get(i10);
    }

    public o(Context context, List<i5.h> list) {
        ArrayList arrayList = new ArrayList();
        this.f16040g = arrayList;
        this.f16036c = context;
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
        }
        this.f16035b = list;
        this.f16037d = LayoutInflater.from(this.f16036c);
    }
}
