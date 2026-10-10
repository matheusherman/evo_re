package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.p000lifecycle.CoroutineLiveDataKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class StyledPlayerControlView extends FrameLayout {
    private static final float[] X1;
    private final Drawable A;
    private final Drawable B;
    private final float C;
    private final float D;
    private long[] D1;
    private final String E;
    private boolean[] E1;
    private final String F;
    private long F1;
    private final Drawable G;
    private v G1;
    private final Drawable H;
    private Resources H1;
    private final String I;
    private RecyclerView I1;
    private final String J;
    private h J1;
    private final Drawable K;
    private e K1;
    private final Drawable L;
    private PopupWindow L1;
    private final String M;
    private boolean M1;
    private final String N;
    private int N1;

    @Nullable
    private k0.k O;
    private j O1;
    private boolean P;
    private b P1;
    private boolean Q;
    private b1.n Q1;
    private boolean R;

    @Nullable
    private ImageView R1;
    private boolean S;

    @Nullable
    private ImageView S1;
    private int T;

    @Nullable
    private ImageView T1;
    private int U;

    @Nullable
    private View U1;
    private int V;

    @Nullable
    private View V1;
    private long[] W;

    @Nullable
    private View W1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f1759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList<m> f1760b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private boolean[] f1761b1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final View f1762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final View f1763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final View f1764e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final View f1765f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private final View f1766g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final TextView f1767h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private final TextView f1768i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private final ImageView f1769j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private final ImageView f1770k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private final View f1771l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private final TextView f1772m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private final TextView f1773n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private final a0 f1774o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final StringBuilder f1775p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Formatter f1776q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final k0.m.a f1777r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final k0.m.b f1778s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Runnable f1779t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Drawable f1780u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Drawable f1781v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Drawable f1782w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final String f1783x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final String f1784y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final String f1785z;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class b extends l {
        private b() {
            super();
        }

        /* synthetic */ b(StyledPlayerControlView styledPlayerControlView, a aVar) {
            this();
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void b(i iVar) {
            iVar.f1800a.setText(R$string.exo_track_selection_auto);
            ((k0.k) d1.a.b(StyledPlayerControlView.this.O)).w();
            throw null;
        }

        public void d(List<k> list) {
            this.f1805a = list;
            ((k0.k) d1.a.b(StyledPlayerControlView.this.O)).w();
            if (!list.isEmpty()) {
                throw null;
            }
            StyledPlayerControlView.this.J1.c(1, StyledPlayerControlView.this.getResources().getString(R$string.exo_track_selection_none));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class c implements k0.k.a, a0.a, View.OnClickListener, PopupWindow.OnDismissListener {
        private c() {
        }

        /* synthetic */ c(StyledPlayerControlView styledPlayerControlView, a aVar) {
            this();
        }

        @Override // com.google.android.exoplayer2.ui.a0.a
        public void a(a0 a0Var, long j10) {
            if (StyledPlayerControlView.this.f1773n != null) {
                StyledPlayerControlView.this.f1773n.setText(d1.k.g(StyledPlayerControlView.this.f1775p, StyledPlayerControlView.this.f1776q, j10));
            }
        }

        @Override // com.google.android.exoplayer2.ui.a0.a
        public void b(a0 a0Var, long j10, boolean z10) {
            StyledPlayerControlView.this.S = false;
            if (!z10 && StyledPlayerControlView.this.O != null) {
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                styledPlayerControlView.h0(styledPlayerControlView.O, j10);
            }
            StyledPlayerControlView.this.G1.S();
        }

        @Override // com.google.android.exoplayer2.ui.a0.a
        public void c(a0 a0Var, long j10) {
            StyledPlayerControlView.this.S = true;
            if (StyledPlayerControlView.this.f1773n != null) {
                StyledPlayerControlView.this.f1773n.setText(d1.k.g(StyledPlayerControlView.this.f1775p, StyledPlayerControlView.this.f1776q, j10));
            }
            StyledPlayerControlView.this.G1.R();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k0.k kVar = StyledPlayerControlView.this.O;
            if (kVar == null) {
                return;
            }
            StyledPlayerControlView.this.G1.S();
            if (StyledPlayerControlView.this.f1763d == view) {
                kVar.y();
                return;
            }
            if (StyledPlayerControlView.this.f1762c == view) {
                kVar.i();
                return;
            }
            if (StyledPlayerControlView.this.f1765f == view) {
                if (kVar.getPlaybackState() != 4) {
                    kVar.z();
                    return;
                }
                return;
            }
            if (StyledPlayerControlView.this.f1766g == view) {
                kVar.B();
                return;
            }
            if (StyledPlayerControlView.this.f1764e == view) {
                StyledPlayerControlView.this.P(kVar);
                return;
            }
            if (StyledPlayerControlView.this.f1769j == view) {
                kVar.setRepeatMode(d1.h.a(kVar.getRepeatMode(), StyledPlayerControlView.this.V));
                return;
            }
            if (StyledPlayerControlView.this.f1770k == view) {
                kVar.e(!kVar.v());
                return;
            }
            if (StyledPlayerControlView.this.U1 == view) {
                StyledPlayerControlView.this.G1.R();
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                styledPlayerControlView.Q(styledPlayerControlView.J1);
                return;
            }
            if (StyledPlayerControlView.this.V1 == view) {
                StyledPlayerControlView.this.G1.R();
                StyledPlayerControlView styledPlayerControlView2 = StyledPlayerControlView.this;
                styledPlayerControlView2.Q(styledPlayerControlView2.K1);
            } else if (StyledPlayerControlView.this.W1 == view) {
                StyledPlayerControlView.this.G1.R();
                StyledPlayerControlView styledPlayerControlView3 = StyledPlayerControlView.this;
                styledPlayerControlView3.Q(styledPlayerControlView3.P1);
            } else if (StyledPlayerControlView.this.R1 == view) {
                StyledPlayerControlView.this.G1.R();
                StyledPlayerControlView styledPlayerControlView4 = StyledPlayerControlView.this;
                styledPlayerControlView4.Q(styledPlayerControlView4.O1);
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (StyledPlayerControlView.this.M1) {
                StyledPlayerControlView.this.G1.S();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface d {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class e extends RecyclerView.Adapter<i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String[] f1788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float[] f1789b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1790c;

        public e(String[] strArr, float[] fArr) {
            this.f1788a = strArr;
            this.f1789b = fArr;
        }

        public static /* synthetic */ void a(e eVar, int i10, View view) {
            if (i10 != eVar.f1790c) {
                StyledPlayerControlView.this.setPlaybackSpeed(eVar.f1789b[i10]);
            }
            StyledPlayerControlView.this.L1.dismiss();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(i iVar, final int i10) {
            String[] strArr = this.f1788a;
            if (i10 < strArr.length) {
                iVar.f1800a.setText(strArr[i10]);
            }
            iVar.f1801b.setVisibility(i10 == this.f1790c ? 0 : 4);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StyledPlayerControlView.e.a(this.f1885a, i10, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public i onCreateViewHolder(ViewGroup viewGroup, int i10) {
            return new i(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(R$layout.exo_styled_sub_settings_list_item, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f1788a.length;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface f {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class g extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextView f1792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TextView f1793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ImageView f1794c;

        public g(View view) {
            super(view);
            if (d1.k.f9577a < 26) {
                view.setFocusable(true);
            }
            this.f1792a = (TextView) view.findViewById(R$id.exo_main_text);
            this.f1793b = (TextView) view.findViewById(R$id.exo_sub_text);
            this.f1794c = (ImageView) view.findViewById(R$id.exo_icon);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    StyledPlayerControlView.g gVar = this.f1887a;
                    StyledPlayerControlView.this.d0(gVar.getAdapterPosition());
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class h extends RecyclerView.Adapter<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String[] f1796a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String[] f1797b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Drawable[] f1798c;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        public h(String[] strArr, Drawable[] drawableArr) {
            this.f1796a = strArr;
            this.f1797b = new String[strArr.length];
            this.f1798c = drawableArr;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public g onCreateViewHolder(ViewGroup viewGroup, int i10) {
            return StyledPlayerControlView.this.new g(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(R$layout.exo_styled_settings_list_item, viewGroup, false));
        }

        public void c(int i10, String str) {
            this.f1797b[i10] = str;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f1796a.length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(g gVar, int i10) {
            gVar.f1792a.setText(this.f1796a[i10]);
            if (this.f1797b[i10] == null) {
                gVar.f1793b.setVisibility(8);
            } else {
                gVar.f1793b.setText(this.f1797b[i10]);
            }
            if (this.f1798c[i10] == null) {
                gVar.f1794c.setVisibility(8);
            } else {
                gVar.f1794c.setImageDrawable(this.f1798c[i10]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class j extends l {
        private j() {
            super();
        }

        public void e(List<k> list) {
            boolean z10 = false;
            for (int i10 = 0; i10 < list.size(); i10++) {
                if (list.get(i10).a()) {
                    z10 = true;
                    break;
                }
            }
            if (StyledPlayerControlView.this.R1 != null) {
                ImageView imageView = StyledPlayerControlView.this.R1;
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                imageView.setImageDrawable(z10 ? styledPlayerControlView.G : styledPlayerControlView.H);
                StyledPlayerControlView.this.R1.setContentDescription(z10 ? StyledPlayerControlView.this.I : StyledPlayerControlView.this.J);
            }
            this.f1805a = list;
        }

        /* synthetic */ j(StyledPlayerControlView styledPlayerControlView, a aVar) {
            this();
        }

        public static /* synthetic */ void d(j jVar, View view) {
            if (StyledPlayerControlView.this.O == null) {
                return;
            }
            StyledPlayerControlView.this.O.w();
            k0.k unused = StyledPlayerControlView.this.O;
            throw null;
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void b(i iVar) {
            boolean z10;
            iVar.f1800a.setText(R$string.exo_track_selection_none);
            int i10 = 0;
            while (true) {
                if (i10 >= this.f1805a.size()) {
                    z10 = true;
                    break;
                } else {
                    if (this.f1805a.get(i10).a()) {
                        z10 = false;
                        break;
                    }
                    i10++;
                }
            }
            iVar.f1801b.setVisibility(z10 ? 0 : 4);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StyledPlayerControlView.j.d(this.f1888a, view);
                }
            });
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l, androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(i iVar, int i10) {
            int i11;
            super.onBindViewHolder(iVar, i10);
            if (i10 > 0) {
                k kVar = this.f1805a.get(i10 - 1);
                View view = iVar.f1801b;
                if (kVar.a()) {
                    i11 = 0;
                } else {
                    i11 = 4;
                }
                view.setVisibility(i11);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k0.n.a f1803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1804b;

        public boolean a() {
            return this.f1803a.b(this.f1804b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private abstract class l extends RecyclerView.Adapter<i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected List<k> f1805a = new ArrayList();

        protected abstract void b(i iVar);

        protected l() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a */
        public void onBindViewHolder(i iVar, int i10) {
            if (StyledPlayerControlView.this.O == null) {
                return;
            }
            if (i10 == 0) {
                b(iVar);
            } else {
                this.f1805a.get(i10 - 1).f1803a.a();
                ((k0.k) d1.a.b(StyledPlayerControlView.this.O)).w();
                throw null;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public i onCreateViewHolder(ViewGroup viewGroup, int i10) {
            return new i(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(R$layout.exo_styled_sub_settings_list_item, viewGroup, false));
        }

        protected void clear() {
            this.f1805a = Collections.EMPTY_LIST;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.f1805a.isEmpty()) {
                return 0;
            }
            return this.f1805a.size() + 1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface m {
        void a(int i10);
    }

    public StyledPlayerControlView(Context context) {
        this(context, null);
    }

    private static boolean L(k0.m mVar, k0.m.b bVar) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        int i18 = i13 - i11;
        int i19 = i17 - i15;
        if (!(i12 - i10 == i16 - i14 && i18 == i19) && this.L1.isShowing()) {
            u0();
            this.L1.update(view, (getWidth() - this.L1.getWidth()) - this.N1, (-this.L1.getHeight()) - this.N1, -1, -1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class i extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f1800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f1801b;

        public i(View view) {
            super(view);
            if (d1.k.f9577a < 26) {
                view.setFocusable(true);
            }
            this.f1800a = (TextView) view.findViewById(R$id.exo_text);
            this.f1801b = view.findViewById(R$id.exo_check);
        }
    }

    static {
        k0.c.a("goog.exo.ui");
        X1 = new float[]{0.25f, 0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f};
    }

    public StyledPlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(RecyclerView.Adapter<?> adapter) {
        this.I1.setAdapter(adapter);
        u0();
        this.M1 = false;
        this.L1.dismiss();
        this.M1 = true;
        this.L1.showAsDropDown(this, (getWidth() - this.L1.getWidth()) - this.N1, (-this.L1.getHeight()) - this.N1);
    }

    private com.google.common.collect.p<k> R(k0.n nVar, int i10) {
        new com.google.common.collect.p.a();
        throw null;
    }

    private static int S(TypedArray typedArray, int i10) {
        return typedArray.getInt(R$styleable.StyledPlayerControlView_repeat_toggle_modes, i10);
    }

    private void V() {
        this.O1.clear();
        this.P1.clear();
        k0.k kVar = this.O;
        if (kVar != null && kVar.p(30) && this.O.p(29)) {
            this.O.r();
            this.P1.d(R(null, 1));
            if (this.G1.A(this.R1)) {
                this.O1.e(R(null, 3));
            } else {
                this.O1.e(com.google.common.collect.p.w());
            }
        }
    }

    private static void W(View view, View.OnClickListener onClickListener) {
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        view.setOnClickListener(onClickListener);
    }

    @SuppressLint({"InlinedApi"})
    private static boolean Y(int i10) {
        return i10 == 90 || i10 == 89 || i10 == 85 || i10 == 79 || i10 == 126 || i10 == 127 || i10 == 87 || i10 == 88;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(int i10) {
        if (i10 == 0) {
            Q(this.K1);
        } else if (i10 == 1) {
            Q(this.P1);
        } else {
            this.L1.dismiss();
        }
    }

    private boolean i0() {
        k0.k kVar = this.O;
        return (kVar == null || kVar.getPlaybackState() == 4 || this.O.getPlaybackState() == 1 || !this.O.d()) ? false : true;
    }

    private void l0(boolean z10, @Nullable View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z10);
        view.setAlpha(z10 ? this.C : this.D);
    }

    private void m0() {
        k0.k kVar = this.O;
        int iK = (int) ((kVar != null ? kVar.k() : 15000L) / 1000);
        TextView textView = this.f1767h;
        if (textView != null) {
            textView.setText(String.valueOf(iK));
        }
        View view = this.f1765f;
        if (view != null) {
            view.setContentDescription(this.H1.getQuantityString(R$plurals.exo_controls_fastforward_by_amount_description, iK, Integer.valueOf(iK)));
        }
    }

    private static void n0(@Nullable View view, boolean z10) {
        if (view == null) {
            return;
        }
        if (z10) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    private void q0() {
        k0.k kVar = this.O;
        if (kVar == null) {
            return;
        }
        kVar.t();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaybackSpeed(float f10) {
        k0.k kVar = this.O;
        if (kVar == null) {
            return;
        }
        kVar.t();
        throw null;
    }

    private void t0() {
        k0.k kVar = this.O;
        int iC = (int) ((kVar != null ? kVar.C() : CoroutineLiveDataKt.DEFAULT_TIMEOUT) / 1000);
        TextView textView = this.f1768i;
        if (textView != null) {
            textView.setText(String.valueOf(iC));
        }
        View view = this.f1766g;
        if (view != null) {
            view.setContentDescription(this.H1.getQuantityString(R$plurals.exo_controls_rewind_by_amount_description, iC, Integer.valueOf(iC)));
        }
    }

    private void u0() {
        this.I1.measure(0, 0);
        this.L1.setWidth(Math.min(this.I1.getMeasuredWidth(), getWidth() - (this.N1 * 2)));
        this.L1.setHeight(Math.min(getHeight() - (this.N1 * 2), this.I1.getMeasuredHeight()));
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0017  */
    private void w0() {
        boolean z10;
        k0.k kVar = this.O;
        if (kVar == null) {
            return;
        }
        if (this.Q) {
            kVar.s();
            if (L(null, this.f1778s)) {
                z10 = true;
            } else {
                z10 = false;
            }
        } else {
            z10 = false;
        }
        this.R = z10;
        this.F1 = 0L;
        kVar.s();
        throw null;
    }

    public void T() {
        this.G1.C();
    }

    public void U() {
        this.G1.F();
    }

    public boolean X() {
        return this.G1.I();
    }

    void a0() {
        Iterator<m> it = this.f1760b.iterator();
        while (it.hasNext()) {
            it.next().a(getVisibility());
        }
    }

    public void e0(m mVar) {
        this.f1760b.remove(mVar);
    }

    void f0() {
        View view = this.f1764e;
        if (view != null) {
            view.requestFocus();
        }
    }

    @Nullable
    public k0.k getPlayer() {
        return this.O;
    }

    public int getRepeatToggleModes() {
        return this.V;
    }

    public boolean getShowShuffleButton() {
        return this.G1.A(this.f1770k);
    }

    public boolean getShowSubtitleButton() {
        return this.G1.A(this.R1);
    }

    public int getShowTimeoutMs() {
        return this.T;
    }

    public boolean getShowVrButton() {
        return this.G1.A(this.f1771l);
    }

    public void j0() {
        this.G1.X();
    }

    public void setAnimationEnabled(boolean z10) {
        this.G1.T(z10);
    }

    public void setOnFullScreenModeChangedListener(@Nullable d dVar) {
        n0(this.S1, dVar != null);
        n0(this.T1, dVar != null);
    }

    public void setRepeatToggleModes(int i10) {
        this.V = i10;
        k0.k kVar = this.O;
        if (kVar != null) {
            int repeatMode = kVar.getRepeatMode();
            if (i10 == 0 && repeatMode != 0) {
                this.O.setRepeatMode(0);
            } else if (i10 == 1 && repeatMode == 2) {
                this.O.setRepeatMode(1);
            } else if (i10 == 2 && repeatMode == 1) {
                this.O.setRepeatMode(2);
            }
        }
        this.G1.U(this.f1769j, i10 != 0);
        s0();
    }

    public void setShowFastForwardButton(boolean z10) {
        this.G1.U(this.f1765f, z10);
        o0();
    }

    public void setShowMultiWindowTimeBar(boolean z10) {
        this.Q = z10;
        w0();
    }

    public void setShowNextButton(boolean z10) {
        this.G1.U(this.f1763d, z10);
        o0();
    }

    public void setShowPreviousButton(boolean z10) {
        this.G1.U(this.f1762c, z10);
        o0();
    }

    public void setShowRewindButton(boolean z10) {
        this.G1.U(this.f1766g, z10);
        o0();
    }

    public void setShowShuffleButton(boolean z10) {
        this.G1.U(this.f1770k, z10);
        v0();
    }

    public void setShowSubtitleButton(boolean z10) {
        this.G1.U(this.R1, z10);
    }

    public void setShowTimeoutMs(int i10) {
        this.T = i10;
        if (X()) {
            this.G1.S();
        }
    }

    public void setShowVrButton(boolean z10) {
        this.G1.U(this.f1771l, z10);
    }

    public void setTimeBarMinUpdateInterval(int i10) {
        this.U = d1.k.c(i10, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.f1771l;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            l0(onClickListener != null, this.f1771l);
        }
    }

    public StyledPlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, attributeSet);
    }

    private void N(k0.k kVar) {
        kVar.pause();
    }

    private void O(k0.k kVar) {
        int playbackState = kVar.getPlaybackState();
        if (playbackState == 1) {
            kVar.prepare();
        } else if (playbackState == 4) {
            g0(kVar, kVar.o(), -9223372036854775807L);
        }
        kVar.play();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(k0.k kVar) {
        int playbackState = kVar.getPlaybackState();
        if (playbackState != 1 && playbackState != 4 && kVar.d()) {
            N(kVar);
        } else {
            O(kVar);
        }
    }

    private void g0(k0.k kVar, int i10, long j10) {
        kVar.c(i10, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(k0.k kVar, long j10) {
        kVar.s();
        if (!this.R) {
            g0(kVar, kVar.o(), j10);
            r0();
            return;
        }
        throw null;
    }

    private void o0() {
        boolean zP;
        boolean zP2;
        boolean zP3;
        boolean zP4;
        boolean zP5;
        if (Z() && this.P) {
            k0.k kVar = this.O;
            if (kVar != null) {
                zP = kVar.p(5);
                zP3 = kVar.p(7);
                zP4 = kVar.p(11);
                zP5 = kVar.p(12);
                zP2 = kVar.p(9);
            } else {
                zP = false;
                zP2 = false;
                zP3 = false;
                zP4 = false;
                zP5 = false;
            }
            if (zP4) {
                t0();
            }
            if (zP5) {
                m0();
            }
            l0(zP3, this.f1762c);
            l0(zP4, this.f1766g);
            l0(zP5, this.f1765f);
            l0(zP2, this.f1763d);
            a0 a0Var = this.f1774o;
            if (a0Var != null) {
                a0Var.setEnabled(zP);
            }
        }
    }

    private void p0() {
        if (Z() && this.P && this.f1764e != null) {
            if (i0()) {
                ((ImageView) this.f1764e).setImageDrawable(this.H1.getDrawable(R$drawable.exo_styled_controls_pause));
                this.f1764e.setContentDescription(this.H1.getString(R$string.exo_controls_pause_description));
            } else {
                ((ImageView) this.f1764e).setImageDrawable(this.H1.getDrawable(R$drawable.exo_styled_controls_play));
                this.f1764e.setContentDescription(this.H1.getString(R$string.exo_controls_play_description));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        long jL;
        long jX;
        int playbackState;
        long preferredUpdateDelay;
        if (Z() && this.P) {
            k0.k kVar = this.O;
            if (kVar != null) {
                jL = this.F1 + kVar.l();
                jX = this.F1 + kVar.x();
            } else {
                jL = 0;
                jX = 0;
            }
            TextView textView = this.f1773n;
            if (textView != null && !this.S) {
                textView.setText(d1.k.g(this.f1775p, this.f1776q, jL));
            }
            a0 a0Var = this.f1774o;
            if (a0Var != null) {
                a0Var.setPosition(jL);
                this.f1774o.setBufferedPosition(jX);
            }
            removeCallbacks(this.f1779t);
            if (kVar == null) {
                playbackState = 1;
            } else {
                playbackState = kVar.getPlaybackState();
            }
            if (kVar != null && kVar.isPlaying()) {
                a0 a0Var2 = this.f1774o;
                if (a0Var2 != null) {
                    preferredUpdateDelay = a0Var2.getPreferredUpdateDelay();
                } else {
                    preferredUpdateDelay = 1000;
                }
                Math.min(preferredUpdateDelay, 1000 - (jL % 1000));
                kVar.t();
                throw null;
            }
            if (playbackState != 4 && playbackState != 1) {
                postDelayed(this.f1779t, 1000L);
            }
        }
    }

    private void s0() {
        ImageView imageView;
        if (Z() && this.P && (imageView = this.f1769j) != null) {
            if (this.V == 0) {
                l0(false, imageView);
                return;
            }
            k0.k kVar = this.O;
            if (kVar == null) {
                l0(false, imageView);
                this.f1769j.setImageDrawable(this.f1780u);
                this.f1769j.setContentDescription(this.f1783x);
                return;
            }
            l0(true, imageView);
            int repeatMode = kVar.getRepeatMode();
            if (repeatMode != 0) {
                if (repeatMode != 1) {
                    if (repeatMode == 2) {
                        this.f1769j.setImageDrawable(this.f1782w);
                        this.f1769j.setContentDescription(this.f1785z);
                        return;
                    }
                    return;
                }
                this.f1769j.setImageDrawable(this.f1781v);
                this.f1769j.setContentDescription(this.f1784y);
                return;
            }
            this.f1769j.setImageDrawable(this.f1780u);
            this.f1769j.setContentDescription(this.f1783x);
        }
    }

    private void v0() {
        ImageView imageView;
        Drawable drawable;
        String str;
        if (Z() && this.P && (imageView = this.f1770k) != null) {
            k0.k kVar = this.O;
            if (!this.G1.A(imageView)) {
                l0(false, this.f1770k);
                return;
            }
            if (kVar == null) {
                l0(false, this.f1770k);
                this.f1770k.setImageDrawable(this.B);
                this.f1770k.setContentDescription(this.F);
                return;
            }
            l0(true, this.f1770k);
            ImageView imageView2 = this.f1770k;
            if (kVar.v()) {
                drawable = this.A;
            } else {
                drawable = this.B;
            }
            imageView2.setImageDrawable(drawable);
            ImageView imageView3 = this.f1770k;
            if (kVar.v()) {
                str = this.E;
            } else {
                str = this.F;
            }
            imageView3.setContentDescription(str);
        }
    }

    private void x0() {
        boolean z10;
        V();
        if (this.O1.getItemCount() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        l0(z10, this.R1);
    }

    public void K(m mVar) {
        d1.a.b(mVar);
        this.f1760b.add(mVar);
    }

    public boolean M(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        k0.k kVar = this.O;
        if (kVar != null && Y(keyCode)) {
            if (keyEvent.getAction() == 0) {
                if (keyCode == 90) {
                    if (kVar.getPlaybackState() != 4) {
                        kVar.z();
                        return true;
                    }
                    return true;
                }
                if (keyCode == 89) {
                    kVar.B();
                    return true;
                }
                if (keyEvent.getRepeatCount() == 0) {
                    if (keyCode != 79 && keyCode != 85) {
                        if (keyCode != 87) {
                            if (keyCode != 88) {
                                if (keyCode != 126) {
                                    if (keyCode == 127) {
                                        N(kVar);
                                        return true;
                                    }
                                    return true;
                                }
                                O(kVar);
                                return true;
                            }
                            kVar.i();
                            return true;
                        }
                        kVar.y();
                        return true;
                    }
                    P(kVar);
                    return true;
                }
                return true;
            }
            return true;
        }
        return false;
    }

    public boolean Z() {
        if (getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!M(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    void k0() {
        p0();
        o0();
        s0();
        v0();
        x0();
        q0();
        w0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.G1.K();
        this.P = true;
        if (X()) {
            this.G1.S();
        }
        k0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.G1.L();
        this.P = false;
        removeCallbacks(this.f1779t);
        this.G1.R();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.G1.M(z10, i10, i11, i12, i13);
    }

    public void setPlayer(@Nullable k0.k kVar) {
        boolean z10;
        boolean z11 = false;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z10 = true;
        } else {
            z10 = false;
        }
        d1.a.c(z10);
        if (kVar == null || kVar.u() == Looper.getMainLooper()) {
            z11 = true;
        }
        d1.a.a(z11);
        k0.k kVar2 = this.O;
        if (kVar2 == kVar) {
            return;
        }
        if (kVar2 != null) {
            kVar2.b(this.f1759a);
        }
        this.O = kVar;
        if (kVar != null) {
            kVar.m(this.f1759a);
        }
        if (kVar instanceof k0.f) {
            ((k0.f) kVar).D();
        }
        k0();
    }

    public StyledPlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i10, @Nullable AttributeSet attributeSet2) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        TextView textView;
        char c10;
        boolean z19;
        super(context, attributeSet, i10);
        int resourceId = R$layout.exo_styled_player_control_view;
        this.T = 5000;
        this.V = 0;
        this.U = 200;
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.StyledPlayerControlView, i10, 0);
            try {
                resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.StyledPlayerControlView_controller_layout_id, resourceId);
                this.T = typedArrayObtainStyledAttributes.getInt(R$styleable.StyledPlayerControlView_show_timeout, this.T);
                this.V = S(typedArrayObtainStyledAttributes, this.V);
                boolean z20 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_rewind_button, true);
                boolean z21 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_fastforward_button, true);
                boolean z22 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_previous_button, true);
                boolean z23 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_next_button, true);
                boolean z24 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_shuffle_button, false);
                boolean z25 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_subtitle_button, false);
                boolean z26 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_vr_button, false);
                setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(R$styleable.StyledPlayerControlView_time_bar_min_update_interval, this.U));
                boolean z27 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_animation_enabled, true);
                typedArrayObtainStyledAttributes.recycle();
                z16 = z24;
                z17 = z25;
                z10 = z26;
                z12 = z20;
                z13 = z21;
                z14 = z22;
                z11 = z27;
                z15 = z23;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            z10 = false;
            z11 = true;
            z12 = true;
            z13 = true;
            z14 = true;
            z15 = true;
            z16 = false;
            z17 = false;
        }
        LayoutInflater.from(context).inflate(resourceId, this);
        setDescendantFocusability(262144);
        c cVar = new c(this, null);
        this.f1759a = cVar;
        this.f1760b = new CopyOnWriteArrayList<>();
        this.f1777r = new k0.m.a();
        this.f1778s = new k0.m.b();
        StringBuilder sb2 = new StringBuilder();
        this.f1775p = sb2;
        this.f1776q = new Formatter(sb2, Locale.getDefault());
        this.W = new long[0];
        this.f1761b1 = new boolean[0];
        this.D1 = new long[0];
        this.E1 = new boolean[0];
        this.f1779t = new Runnable() { // from class: b1.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f644a.r0();
            }
        };
        this.f1772m = (TextView) findViewById(R$id.exo_duration);
        this.f1773n = (TextView) findViewById(R$id.exo_position);
        ImageView imageView = (ImageView) findViewById(R$id.exo_subtitle);
        this.R1 = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(cVar);
        }
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_fullscreen);
        this.S1 = imageView2;
        W(imageView2, new View.OnClickListener() { // from class: b1.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f645a.b0(view);
            }
        });
        ImageView imageView3 = (ImageView) findViewById(R$id.exo_minimal_fullscreen);
        this.T1 = imageView3;
        W(imageView3, new View.OnClickListener() { // from class: b1.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f645a.b0(view);
            }
        });
        View viewFindViewById = findViewById(R$id.exo_settings);
        this.U1 = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(cVar);
        }
        View viewFindViewById2 = findViewById(R$id.exo_playback_speed);
        this.V1 = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(cVar);
        }
        View viewFindViewById3 = findViewById(R$id.exo_audio_track);
        this.W1 = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(cVar);
        }
        int i11 = R$id.exo_progress;
        a0 a0Var = (a0) findViewById(i11);
        View viewFindViewById4 = findViewById(R$id.exo_progress_placeholder);
        if (a0Var != null) {
            this.f1774o = a0Var;
            z18 = z10;
            textView = null;
            c10 = 1;
        } else if (viewFindViewById4 != null) {
            z18 = z10;
            textView = null;
            c10 = 1;
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2, R$style.ExoStyledControls_TimeBar);
            defaultTimeBar.setId(i11);
            defaultTimeBar.setLayoutParams(viewFindViewById4.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById4.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById4);
            viewGroup.removeView(viewFindViewById4);
            viewGroup.addView(defaultTimeBar, iIndexOfChild);
            this.f1774o = defaultTimeBar;
        } else {
            z18 = z10;
            textView = null;
            c10 = 1;
            this.f1774o = null;
        }
        a0 a0Var2 = this.f1774o;
        if (a0Var2 != null) {
            a0Var2.a(cVar);
        }
        View viewFindViewById5 = findViewById(R$id.exo_play_pause);
        this.f1764e = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(cVar);
        }
        View viewFindViewById6 = findViewById(R$id.exo_prev);
        this.f1762c = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(cVar);
        }
        View viewFindViewById7 = findViewById(R$id.exo_next);
        this.f1763d = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(cVar);
        }
        Typeface font = ResourcesCompat.getFont(context, R$font.roboto_medium_numbers);
        View viewFindViewById8 = findViewById(R$id.exo_rew);
        TextView textView2 = viewFindViewById8 == null ? (TextView) findViewById(R$id.exo_rew_with_amount) : textView;
        this.f1768i = textView2;
        if (textView2 != null) {
            textView2.setTypeface(font);
        }
        viewFindViewById8 = viewFindViewById8 == null ? textView2 : viewFindViewById8;
        this.f1766g = viewFindViewById8;
        if (viewFindViewById8 != null) {
            viewFindViewById8.setOnClickListener(cVar);
        }
        View viewFindViewById9 = findViewById(R$id.exo_ffwd);
        TextView textView3 = viewFindViewById9 == null ? (TextView) findViewById(R$id.exo_ffwd_with_amount) : textView;
        this.f1767h = textView3;
        if (textView3 != null) {
            textView3.setTypeface(font);
        }
        viewFindViewById9 = viewFindViewById9 == null ? textView3 : viewFindViewById9;
        this.f1765f = viewFindViewById9;
        if (viewFindViewById9 != null) {
            viewFindViewById9.setOnClickListener(cVar);
        }
        ImageView imageView4 = (ImageView) findViewById(R$id.exo_repeat_toggle);
        this.f1769j = imageView4;
        if (imageView4 != null) {
            imageView4.setOnClickListener(cVar);
        }
        ImageView imageView5 = (ImageView) findViewById(R$id.exo_shuffle);
        this.f1770k = imageView5;
        if (imageView5 != null) {
            imageView5.setOnClickListener(cVar);
        }
        Resources resources = context.getResources();
        this.H1 = resources;
        this.C = resources.getInteger(R$integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.D = this.H1.getInteger(R$integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        View viewFindViewById10 = findViewById(R$id.exo_vr);
        this.f1771l = viewFindViewById10;
        if (viewFindViewById10 != null) {
            l0(false, viewFindViewById10);
        }
        v vVar = new v(this);
        this.G1 = vVar;
        vVar.T(z11);
        String string = this.H1.getString(R$string.exo_controls_playback_speed);
        Drawable drawable = this.H1.getDrawable(R$drawable.exo_styled_controls_speed);
        String[] strArr = {string, this.H1.getString(R$string.exo_track_selection_title_audio)};
        Drawable drawable2 = this.H1.getDrawable(R$drawable.exo_styled_controls_audiotrack);
        Drawable[] drawableArr = new Drawable[2];
        drawableArr[0] = drawable;
        drawableArr[c10] = drawable2;
        this.J1 = new h(strArr, drawableArr);
        this.N1 = this.H1.getDimensionPixelSize(R$dimen.exo_settings_offset);
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(R$layout.exo_styled_settings_list, (ViewGroup) null);
        this.I1 = recyclerView;
        recyclerView.setAdapter(this.J1);
        this.I1.setLayoutManager(new LinearLayoutManager(getContext()));
        PopupWindow popupWindow = new PopupWindow((View) this.I1, -2, -2, true);
        this.L1 = popupWindow;
        if (d1.k.f9577a < 23) {
            z19 = false;
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        } else {
            z19 = false;
        }
        this.L1.setOnDismissListener(cVar);
        this.M1 = true;
        this.Q1 = new b1.g(getResources());
        this.G = this.H1.getDrawable(R$drawable.exo_styled_controls_subtitle_on);
        this.H = this.H1.getDrawable(R$drawable.exo_styled_controls_subtitle_off);
        this.I = this.H1.getString(R$string.exo_controls_cc_enabled_description);
        this.J = this.H1.getString(R$string.exo_controls_cc_disabled_description);
        a aVar = null;
        this.O1 = new j(this, aVar);
        this.P1 = new b(this, aVar);
        this.K1 = new e(this.H1.getStringArray(R$array.exo_controls_playback_speeds), X1);
        this.K = this.H1.getDrawable(R$drawable.exo_styled_controls_fullscreen_exit);
        this.L = this.H1.getDrawable(R$drawable.exo_styled_controls_fullscreen_enter);
        this.f1780u = this.H1.getDrawable(R$drawable.exo_styled_controls_repeat_off);
        this.f1781v = this.H1.getDrawable(R$drawable.exo_styled_controls_repeat_one);
        this.f1782w = this.H1.getDrawable(R$drawable.exo_styled_controls_repeat_all);
        this.A = this.H1.getDrawable(R$drawable.exo_styled_controls_shuffle_on);
        this.B = this.H1.getDrawable(R$drawable.exo_styled_controls_shuffle_off);
        this.M = this.H1.getString(R$string.exo_controls_fullscreen_exit_description);
        this.N = this.H1.getString(R$string.exo_controls_fullscreen_enter_description);
        this.f1783x = this.H1.getString(R$string.exo_controls_repeat_off_description);
        this.f1784y = this.H1.getString(R$string.exo_controls_repeat_one_description);
        this.f1785z = this.H1.getString(R$string.exo_controls_repeat_all_description);
        this.E = this.H1.getString(R$string.exo_controls_shuffle_on_description);
        this.F = this.H1.getString(R$string.exo_controls_shuffle_off_description);
        this.G1.U((ViewGroup) findViewById(R$id.exo_bottom_bar), true);
        this.G1.U(viewFindViewById9, z13);
        this.G1.U(this.f1766g, z12);
        this.G1.U(this.f1762c, z14);
        this.G1.U(this.f1763d, z15);
        this.G1.U(imageView5, z16);
        this.G1.U(this.R1, z17);
        this.G1.U(viewFindViewById10, z18);
        this.G1.U(imageView4, this.V != 0 ? true : z19);
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: b1.m
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
                this.f646a.c0(view, i12, i13, i14, i15, i16, i17, i18, i19);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(View view) {
    }

    public void setProgressUpdateListener(@Nullable f fVar) {
    }
}
