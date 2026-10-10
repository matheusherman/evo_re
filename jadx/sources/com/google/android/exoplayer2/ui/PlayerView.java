package com.google.android.exoplayer2.ui;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Deprecated
public class PlayerView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f1731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final AspectRatioFrameLayout f1732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final View f1733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final View f1734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f1735e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final ImageView f1736f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private final SubtitleView f1737g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final View f1738h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private final TextView f1739i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private final PlayerControlView f1740j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private final FrameLayout f1741k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private final FrameLayout f1742l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private k0.k f1743m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f1744n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private PlayerControlView.e f1745o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f1746p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private Drawable f1747q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f1748r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f1749s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private CharSequence f1750t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f1751u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f1752v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f1753w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f1754x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f1755y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f1756z;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class a implements k0.k.a, View.OnLayoutChangeListener, View.OnClickListener, PlayerControlView.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final k0.m.a f1757a = new k0.m.a();

        public a() {
        }

        @Override // com.google.android.exoplayer2.ui.PlayerControlView.e
        public void a(int i10) {
            PlayerView.this.w();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayerView.this.t();
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            PlayerView.e((TextureView) view, PlayerView.this.f1755y);
        }
    }

    public PlayerView(Context context) {
        this(context, null);
    }

    public void setUseArtwork(boolean z10) {
        d1.a.c((z10 && this.f1736f == null) ? false : true);
        if (this.f1746p != z10) {
            this.f1746p = z10;
            y(false);
        }
    }

    public PlayerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(TextureView textureView, int i10) {
        Matrix matrix = new Matrix();
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (width != 0.0f && height != 0.0f && i10 != 0) {
            float f10 = width / 2.0f;
            float f11 = height / 2.0f;
            matrix.postRotate(i10, f10, f11);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f10, f11);
        }
        textureView.setTransform(matrix);
    }

    private void f() {
        View view = this.f1733c;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private static void g(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(R$drawable.exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(R$color.exo_edit_mode_background_color));
    }

    @RequiresApi(23)
    private static void h(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(R$drawable.exo_edit_mode_logo, null));
        imageView.setBackgroundColor(resources.getColor(R$color.exo_edit_mode_background_color, null));
    }

    private void j() {
        ImageView imageView = this.f1736f;
        if (imageView != null) {
            imageView.setImageResource(R.color.transparent);
            this.f1736f.setVisibility(4);
        }
    }

    @SuppressLint({"InlinedApi"})
    private boolean l(int i10) {
        return i10 == 19 || i10 == 270 || i10 == 22 || i10 == 271 || i10 == 20 || i10 == 269 || i10 == 21 || i10 == 268 || i10 == 23;
    }

    private boolean m() {
        k0.k kVar = this.f1743m;
        return kVar != null && kVar.a() && this.f1743m.d();
    }

    private boolean q() {
        k0.k kVar = this.f1743m;
        if (kVar == null) {
            return true;
        }
        int playbackState = kVar.getPlaybackState();
        if (this.f1752v) {
            return playbackState == 1 || playbackState == 4 || !this.f1743m.d();
        }
        return false;
    }

    private void u() {
        k0.k kVar = this.f1743m;
        e1.e eVarG = kVar != null ? kVar.g() : e1.e.f9825e;
        int i10 = eVarG.f9827a;
        int i11 = eVarG.f9828b;
        int i12 = eVarG.f9829c;
        float f10 = (i11 == 0 || i10 == 0) ? 0.0f : (i10 * eVarG.f9830d) / i11;
        View view = this.f1734d;
        if (view instanceof TextureView) {
            if (f10 > 0.0f && (i12 == 90 || i12 == 270)) {
                f10 = 1.0f / f10;
            }
            if (this.f1755y != 0) {
                view.removeOnLayoutChangeListener(this.f1731a);
            }
            this.f1755y = i12;
            if (i12 != 0) {
                this.f1734d.addOnLayoutChangeListener(this.f1731a);
            }
            e((TextureView) this.f1734d, this.f1755y);
        }
        o(this.f1732b, this.f1735e ? 0.0f : f10);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0020  */
    private void v() {
        boolean z10;
        if (this.f1738h != null) {
            k0.k kVar = this.f1743m;
            if (kVar == null || kVar.getPlaybackState() != 2) {
                z10 = false;
            } else {
                int i10 = this.f1748r;
                z10 = true;
                if (i10 != 2 && (i10 != 1 || !this.f1743m.d())) {
                    z10 = false;
                }
            }
            this.f1738h.setVisibility(z10 ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        PlayerControlView playerControlView = this.f1740j;
        if (playerControlView == null || !this.f1744n) {
            setContentDescription(null);
        } else if (playerControlView.getVisibility() == 0) {
            setContentDescription(this.f1754x ? getResources().getString(R$string.exo_controls_hide) : null);
        } else {
            setContentDescription(getResources().getString(R$string.exo_controls_show));
        }
    }

    private void x() {
        TextView textView = this.f1739i;
        if (textView != null) {
            CharSequence charSequence = this.f1750t;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.f1739i.setVisibility(0);
            } else {
                k0.k kVar = this.f1743m;
                if (kVar != null) {
                    kVar.j();
                }
                this.f1739i.setVisibility(8);
            }
        }
    }

    private void y(boolean z10) {
        k0.k kVar = this.f1743m;
        if (kVar != null && kVar.p(30)) {
            kVar.r();
            throw null;
        }
        if (this.f1749s) {
            return;
        }
        j();
        f();
    }

    private boolean z() {
        if (!this.f1744n) {
            return false;
        }
        d1.a.d(this.f1740j);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        k0.k kVar = this.f1743m;
        if (kVar != null && kVar.a()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean zL = l(keyEvent.getKeyCode());
        if (zL && z() && !this.f1740j.C()) {
            n(true);
            return true;
        }
        if (i(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
            n(true);
            return true;
        }
        if (zL && z()) {
            n(true);
        }
        return false;
    }

    public List<b1.a> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.f1742l;
        if (frameLayout != null) {
            arrayList.add(new b1.a(frameLayout, 4, "Transparent overlay does not impact viewability"));
        }
        PlayerControlView playerControlView = this.f1740j;
        if (playerControlView != null) {
            arrayList.add(new b1.a(playerControlView, 1));
        }
        return com.google.common.collect.p.s(arrayList);
    }

    public ViewGroup getAdViewGroup() {
        return (ViewGroup) d1.a.e(this.f1741k, "exo_ad_overlay must be present for ad playback");
    }

    public boolean getControllerAutoShow() {
        return this.f1752v;
    }

    public boolean getControllerHideOnTouch() {
        return this.f1754x;
    }

    public int getControllerShowTimeoutMs() {
        return this.f1751u;
    }

    @Nullable
    public Drawable getDefaultArtwork() {
        return this.f1747q;
    }

    @Nullable
    public FrameLayout getOverlayFrameLayout() {
        return this.f1742l;
    }

    @Nullable
    public k0.k getPlayer() {
        return this.f1743m;
    }

    public int getResizeMode() {
        d1.a.d(this.f1732b);
        return this.f1732b.getResizeMode();
    }

    @Nullable
    public SubtitleView getSubtitleView() {
        return this.f1737g;
    }

    public boolean getUseArtwork() {
        return this.f1746p;
    }

    public boolean getUseController() {
        return this.f1744n;
    }

    @Nullable
    public View getVideoSurfaceView() {
        return this.f1734d;
    }

    public void k() {
        PlayerControlView playerControlView = this.f1740j;
        if (playerControlView != null) {
            playerControlView.z();
        }
    }

    protected void o(@Nullable AspectRatioFrameLayout aspectRatioFrameLayout, float f10) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f10);
        }
    }

    public void setAspectRatioListener(@Nullable AspectRatioFrameLayout.b bVar) {
        d1.a.d(this.f1732b);
        this.f1732b.setAspectRatioListener(bVar);
    }

    public void setControllerAutoShow(boolean z10) {
        this.f1752v = z10;
    }

    public void setControllerHideDuringAds(boolean z10) {
        this.f1753w = z10;
    }

    public void setControllerHideOnTouch(boolean z10) {
        d1.a.d(this.f1740j);
        this.f1754x = z10;
        w();
    }

    public void setControllerShowTimeoutMs(int i10) {
        d1.a.d(this.f1740j);
        this.f1751u = i10;
        if (this.f1740j.C()) {
            r();
        }
    }

    public void setControllerVisibilityListener(@Nullable PlayerControlView.e eVar) {
        d1.a.d(this.f1740j);
        PlayerControlView.e eVar2 = this.f1745o;
        if (eVar2 == eVar) {
            return;
        }
        if (eVar2 != null) {
            this.f1740j.D(eVar2);
        }
        this.f1745o = eVar;
        if (eVar != null) {
            this.f1740j.s(eVar);
        }
    }

    public void setCustomErrorMessage(@Nullable CharSequence charSequence) {
        d1.a.c(this.f1739i != null);
        this.f1750t = charSequence;
        x();
    }

    public void setDefaultArtwork(@Nullable Drawable drawable) {
        if (this.f1747q != drawable) {
            this.f1747q = drawable;
            y(false);
        }
    }

    public void setErrorMessageProvider(@Nullable d1.b<? super k0.i> bVar) {
        if (bVar != null) {
            x();
        }
    }

    public void setKeepContentOnPlayerReset(boolean z10) {
        if (this.f1749s != z10) {
            this.f1749s = z10;
            y(false);
        }
    }

    public void setRepeatToggleModes(int i10) {
        d1.a.d(this.f1740j);
        this.f1740j.setRepeatToggleModes(i10);
    }

    public void setResizeMode(int i10) {
        d1.a.d(this.f1732b);
        this.f1732b.setResizeMode(i10);
    }

    public void setShowBuffering(int i10) {
        if (this.f1748r != i10) {
            this.f1748r = i10;
            v();
        }
    }

    public void setShowFastForwardButton(boolean z10) {
        d1.a.d(this.f1740j);
        this.f1740j.setShowFastForwardButton(z10);
    }

    public void setShowMultiWindowTimeBar(boolean z10) {
        d1.a.d(this.f1740j);
        this.f1740j.setShowMultiWindowTimeBar(z10);
    }

    public void setShowNextButton(boolean z10) {
        d1.a.d(this.f1740j);
        this.f1740j.setShowNextButton(z10);
    }

    public void setShowPreviousButton(boolean z10) {
        d1.a.d(this.f1740j);
        this.f1740j.setShowPreviousButton(z10);
    }

    public void setShowRewindButton(boolean z10) {
        d1.a.d(this.f1740j);
        this.f1740j.setShowRewindButton(z10);
    }

    public void setShowShuffleButton(boolean z10) {
        d1.a.d(this.f1740j);
        this.f1740j.setShowShuffleButton(z10);
    }

    public void setShutterBackgroundColor(int i10) {
        View view = this.f1733c;
        if (view != null) {
            view.setBackgroundColor(i10);
        }
    }

    public void setUseController(boolean z10) {
        d1.a.c((z10 && this.f1740j == null) ? false : true);
        if (this.f1744n == z10) {
            return;
        }
        this.f1744n = z10;
        if (z()) {
            this.f1740j.setPlayer(this.f1743m);
        } else {
            PlayerControlView playerControlView = this.f1740j;
            if (playerControlView != null) {
                playerControlView.z();
                this.f1740j.setPlayer(null);
            }
        }
        w();
    }

    public PlayerView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        int i11;
        boolean z10;
        int i12;
        int integer;
        boolean z11;
        boolean z12;
        int i13;
        int i14;
        boolean z13;
        int i15;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        super(context, attributeSet, i10);
        a aVar = new a();
        this.f1731a = aVar;
        if (isInEditMode()) {
            this.f1732b = null;
            this.f1733c = null;
            this.f1734d = null;
            this.f1735e = false;
            this.f1736f = null;
            this.f1737g = null;
            this.f1738h = null;
            this.f1739i = null;
            this.f1740j = null;
            this.f1741k = null;
            this.f1742l = null;
            ImageView imageView = new ImageView(context);
            if (d1.k.f9577a >= 23) {
                h(getResources(), imageView);
            } else {
                g(getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i16 = R$layout.exo_player_view;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.PlayerView, i10, 0);
            try {
                int i17 = R$styleable.PlayerView_shutter_background_color;
                boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i17);
                int color = typedArrayObtainStyledAttributes.getColor(i17, 0);
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerView_player_layout_id, i16);
                boolean z18 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerView_use_artwork, true);
                int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerView_default_artwork, 0);
                boolean z19 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerView_use_controller, true);
                int i18 = typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerView_surface_type, 1);
                int i19 = typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerView_resize_mode, 0);
                int i20 = typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerView_show_timeout, 5000);
                boolean z20 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerView_hide_on_touch, true);
                boolean z21 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerView_auto_show, true);
                integer = typedArrayObtainStyledAttributes.getInteger(R$styleable.PlayerView_show_buffering, 0);
                this.f1749s = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerView_keep_content_on_player_reset, this.f1749s);
                boolean z22 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerView_hide_during_ads, true);
                typedArrayObtainStyledAttributes.recycle();
                i16 = resourceId;
                i11 = i20;
                z11 = z22;
                z12 = z20;
                z10 = z21;
                i12 = i19;
                z15 = zHasValue;
                i14 = color;
                i13 = i18;
                z14 = z19;
                i15 = resourceId2;
                z13 = z18;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            i11 = 5000;
            z10 = true;
            i12 = 0;
            integer = 0;
            z11 = true;
            z12 = true;
            i13 = 1;
            i14 = 0;
            z13 = true;
            i15 = 0;
            z14 = true;
            z15 = false;
        }
        LayoutInflater.from(context).inflate(i16, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(R$id.exo_content_frame);
        this.f1732b = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            p(aspectRatioFrameLayout, i12);
        }
        View viewFindViewById = findViewById(R$id.exo_shutter);
        this.f1733c = viewFindViewById;
        if (viewFindViewById != null && z15) {
            viewFindViewById.setBackgroundColor(i14);
        }
        if (aspectRatioFrameLayout != null && i13 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i13 == 2) {
                this.f1734d = new TextureView(context);
            } else {
                if (i13 == 3) {
                    try {
                        int i21 = f1.j.f9982m;
                        this.f1734d = (View) f1.j.class.getConstructor(Context.class).newInstance(context);
                        z17 = true;
                    } catch (Exception e10) {
                        throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e10);
                    }
                } else if (i13 != 4) {
                    this.f1734d = new SurfaceView(context);
                } else {
                    try {
                        int i22 = e1.b.f9808b;
                        this.f1734d = (View) e1.b.class.getConstructor(Context.class).newInstance(context);
                    } catch (Exception e11) {
                        throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e11);
                    }
                }
                this.f1734d.setLayoutParams(layoutParams);
                this.f1734d.setOnClickListener(aVar);
                this.f1734d.setClickable(false);
                aspectRatioFrameLayout.addView(this.f1734d, 0);
                z16 = z17;
            }
            z17 = false;
            this.f1734d.setLayoutParams(layoutParams);
            this.f1734d.setOnClickListener(aVar);
            this.f1734d.setClickable(false);
            aspectRatioFrameLayout.addView(this.f1734d, 0);
            z16 = z17;
        } else {
            this.f1734d = null;
            z16 = false;
        }
        this.f1735e = z16;
        this.f1741k = (FrameLayout) findViewById(R$id.exo_ad_overlay);
        this.f1742l = (FrameLayout) findViewById(R$id.exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_artwork);
        this.f1736f = imageView2;
        this.f1746p = z13 && imageView2 != null;
        if (i15 != 0) {
            this.f1747q = ContextCompat.getDrawable(getContext(), i15);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R$id.exo_subtitles);
        this.f1737g = subtitleView;
        if (subtitleView != null) {
            subtitleView.d();
            subtitleView.e();
        }
        View viewFindViewById2 = findViewById(R$id.exo_buffering);
        this.f1738h = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        this.f1748r = integer;
        TextView textView = (TextView) findViewById(R$id.exo_error_message);
        this.f1739i = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        int i23 = R$id.exo_controller;
        PlayerControlView playerControlView = (PlayerControlView) findViewById(i23);
        View viewFindViewById3 = findViewById(R$id.exo_controller_placeholder);
        if (playerControlView != null) {
            this.f1740j = playerControlView;
        } else if (viewFindViewById3 != null) {
            PlayerControlView playerControlView2 = new PlayerControlView(context, null, 0, attributeSet);
            this.f1740j = playerControlView2;
            playerControlView2.setId(i23);
            playerControlView2.setLayoutParams(viewFindViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById3.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById3);
            viewGroup.removeView(viewFindViewById3);
            viewGroup.addView(playerControlView2, iIndexOfChild);
        } else {
            this.f1740j = null;
        }
        PlayerControlView playerControlView3 = this.f1740j;
        this.f1751u = playerControlView3 != null ? i11 : 0;
        this.f1754x = z12;
        this.f1752v = z10;
        this.f1753w = z11;
        this.f1744n = z14 && playerControlView3 != null;
        k();
        w();
        PlayerControlView playerControlView4 = this.f1740j;
        if (playerControlView4 != null) {
            playerControlView4.s(aVar);
        }
    }

    private void n(boolean z10) {
        boolean z11;
        if ((!m() || !this.f1753w) && z()) {
            if (this.f1740j.C() && this.f1740j.getShowTimeoutMs() <= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            boolean zQ = q();
            if (z10 || z11 || zQ) {
                s(zQ);
            }
        }
    }

    private static void p(AspectRatioFrameLayout aspectRatioFrameLayout, int i10) {
        aspectRatioFrameLayout.setResizeMode(i10);
    }

    private void s(boolean z10) {
        int i10;
        if (!z()) {
            return;
        }
        PlayerControlView playerControlView = this.f1740j;
        if (z10) {
            i10 = 0;
        } else {
            i10 = this.f1751u;
        }
        playerControlView.setShowTimeoutMs(i10);
        this.f1740j.J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t() {
        if (z() && this.f1743m != null) {
            if (!this.f1740j.C()) {
                n(true);
            } else if (this.f1754x) {
                this.f1740j.z();
            }
            return true;
        }
        return false;
    }

    public boolean i(KeyEvent keyEvent) {
        if (z() && this.f1740j.u(keyEvent)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!z() || this.f1743m == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1 || !this.f1756z) {
                return false;
            }
            this.f1756z = false;
            performClick();
            return true;
        }
        this.f1756z = true;
        return true;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (z() && this.f1743m != null) {
            n(true);
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return t();
    }

    public void r() {
        s(q());
    }

    public void setPlayer(@Nullable k0.k kVar) {
        boolean z10;
        boolean z11;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z10 = true;
        } else {
            z10 = false;
        }
        d1.a.c(z10);
        if (kVar != null && kVar.u() != Looper.getMainLooper()) {
            z11 = false;
        } else {
            z11 = true;
        }
        d1.a.a(z11);
        k0.k kVar2 = this.f1743m;
        if (kVar2 == kVar) {
            return;
        }
        if (kVar2 != null) {
            kVar2.b(this.f1731a);
            if (kVar2.p(27)) {
                View view = this.f1734d;
                if (view instanceof TextureView) {
                    kVar2.f((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    kVar2.q((SurfaceView) view);
                }
            }
        }
        SubtitleView subtitleView = this.f1737g;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        this.f1743m = kVar;
        if (z()) {
            this.f1740j.setPlayer(kVar);
        }
        v();
        x();
        y(true);
        if (kVar != null) {
            if (kVar.p(27)) {
                View view2 = this.f1734d;
                if (view2 instanceof TextureView) {
                    kVar.A((TextureView) view2);
                } else if (view2 instanceof SurfaceView) {
                    kVar.h((SurfaceView) view2);
                }
                u();
            }
            if (this.f1737g != null && kVar.p(28)) {
                this.f1737g.setCues(kVar.n());
            }
            kVar.m(this.f1731a);
            n(false);
            return;
        }
        k();
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        View view = this.f1734d;
        if (view instanceof SurfaceView) {
            view.setVisibility(i10);
        }
    }
}
