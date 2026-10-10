package com.live.evo.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.live.evo.R$styleable;
import com.youth.banner.Banner;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnPageChangeListener;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class AdBannerView extends Banner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7401e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<String> f7402f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Context f7403g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f7404h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f7405i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f7406j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f7407k;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements View.OnClickListener {
        a(w4.a aVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements OnPageChangeListener {
        b(w4.a aVar) {
        }

        @Override // com.youth.banner.listener.OnPageChangeListener
        public void onPageSelected(int i10) {
            AdBannerView.this.f7407k = i10;
        }

        @Override // com.youth.banner.listener.OnPageChangeListener
        public void onPageScrollStateChanged(int i10) {
        }

        @Override // com.youth.banner.listener.OnPageChangeListener
        public void onPageScrolled(int i10, float f10, int i11) {
        }
    }

    public AdBannerView(Context context) {
        this(context, null);
    }

    public AdBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    private void b(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = this.f7403g.obtainStyledAttributes(attributeSet, R$styleable.BaseBannerView);
        this.f7399c = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 12);
        this.f7400d = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 4);
        this.f7401e = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 4);
        this.f7404h = typedArrayObtainStyledAttributes.getBoolean(3, true);
        this.f7405i = typedArrayObtainStyledAttributes.getInt(4, 3000);
        this.f7406j = typedArrayObtainStyledAttributes.getInt(5, 1000);
        setIndicator(new CircleIndicator(this.f7403g), true);
        setIndicatorGravity(this.f7398b);
        setIndicatorSpace(this.f7400d);
        setIndicatorMargins(new IndicatorConfig.Margins(this.f7399c));
        setBannerRound(this.f7401e);
        isAutoLoop(this.f7404h);
        setLoopTime(this.f7405i);
        setScrollTime(this.f7406j);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setAdBannerOnClick(w4.a aVar) {
        setOnClickListener(new a(aVar));
        addOnPageChangeListener(new b(aVar));
    }

    public AdBannerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f7397a = getClass().getSimpleName();
        this.f7398b = 1;
        this.f7399c = 12;
        this.f7400d = 4;
        this.f7401e = 4;
        this.f7402f = new ArrayList();
        this.f7404h = true;
        this.f7405i = 3000;
        this.f7406j = 3000;
        this.f7407k = 0;
        this.f7403g = context;
        b(attributeSet);
    }

    public void c() {
        stop();
    }
}
