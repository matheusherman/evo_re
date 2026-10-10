package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class PlayerControlView extends FrameLayout {
    private final Drawable A;
    private final Drawable B;
    private final float C;
    private final float D;
    private long D1;
    private final String E;
    private long E1;
    private final String F;
    private long F1;

    @Nullable
    private k0.k G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private int L;
    private int M;
    private int N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private long T;
    private long[] U;
    private boolean[] V;
    private long[] W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f1703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList<e> f1704b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private boolean[] f1705b1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final View f1706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final View f1707d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final View f1708e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final View f1709f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private final View f1710g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final View f1711h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private final ImageView f1712i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private final ImageView f1713j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private final View f1714k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private final TextView f1715l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private final TextView f1716m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private final a0 f1717n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final StringBuilder f1718o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Formatter f1719p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final k0.m.a f1720q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final k0.m.b f1721r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Runnable f1722s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Runnable f1723t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Drawable f1724u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Drawable f1725v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Drawable f1726w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final String f1727x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final String f1728y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final String f1729z;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class c implements k0.k.a, a0.a, View.OnClickListener {
        private c() {
        }

        /* synthetic */ c(PlayerControlView playerControlView, a aVar) {
            this();
        }

        @Override // com.google.android.exoplayer2.ui.a0.a
        public void a(a0 a0Var, long j10) {
            if (PlayerControlView.this.f1716m != null) {
                PlayerControlView.this.f1716m.setText(d1.k.g(PlayerControlView.this.f1718o, PlayerControlView.this.f1719p, j10));
            }
        }

        @Override // com.google.android.exoplayer2.ui.a0.a
        public void b(a0 a0Var, long j10, boolean z10) {
            PlayerControlView.this.K = false;
            if (z10 || PlayerControlView.this.G == null) {
                return;
            }
            PlayerControlView playerControlView = PlayerControlView.this;
            playerControlView.H(playerControlView.G, j10);
        }

        @Override // com.google.android.exoplayer2.ui.a0.a
        public void c(a0 a0Var, long j10) {
            PlayerControlView.this.K = true;
            if (PlayerControlView.this.f1716m != null) {
                PlayerControlView.this.f1716m.setText(d1.k.g(PlayerControlView.this.f1718o, PlayerControlView.this.f1719p, j10));
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k0.k kVar = PlayerControlView.this.G;
            if (kVar == null) {
                return;
            }
            if (PlayerControlView.this.f1707d == view) {
                kVar.y();
                return;
            }
            if (PlayerControlView.this.f1706c == view) {
                kVar.i();
                return;
            }
            if (PlayerControlView.this.f1710g == view) {
                if (kVar.getPlaybackState() != 4) {
                    kVar.z();
                    return;
                }
                return;
            }
            if (PlayerControlView.this.f1711h == view) {
                kVar.B();
                return;
            }
            if (PlayerControlView.this.f1708e == view) {
                PlayerControlView.this.w(kVar);
                return;
            }
            if (PlayerControlView.this.f1709f == view) {
                PlayerControlView.this.v(kVar);
            } else if (PlayerControlView.this.f1712i == view) {
                kVar.setRepeatMode(d1.h.a(kVar.getRepeatMode(), PlayerControlView.this.N));
            } else if (PlayerControlView.this.f1713j == view) {
                kVar.e(!kVar.v());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface d {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface e {
        void a(int i10);
    }

    public PlayerControlView(Context context) {
        this(context, null);
    }

    private static boolean t(k0.m mVar, k0.m.b bVar) {
        throw null;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @RequiresApi(21)
    private static final class b {
        @DoNotInline
        public static boolean a(View view) {
            return view.isAccessibilityFocused();
        }
    }

    static {
        k0.c.a("goog.exo.ui");
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void A() {
        removeCallbacks(this.f1723t);
        if (this.L <= 0) {
            this.T = -9223372036854775807L;
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        int i10 = this.L;
        this.T = jUptimeMillis + ((long) i10);
        if (this.H) {
            postDelayed(this.f1723t, i10);
        }
    }

    @SuppressLint({"InlinedApi"})
    private static boolean B(int i10) {
        return i10 == 90 || i10 == 89 || i10 == 85 || i10 == 79 || i10 == 126 || i10 == 127 || i10 == 87 || i10 == 88;
    }

    private boolean I() {
        k0.k kVar = this.G;
        return (kVar == null || kVar.getPlaybackState() == 4 || this.G.getPlaybackState() == 1 || !this.G.d()) ? false : true;
    }

    private void L(boolean z10, boolean z11, @Nullable View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z11);
        view.setAlpha(z11 ? this.C : this.D);
        view.setVisibility(z10 ? 0 : 8);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0017  */
    private void R() {
        boolean z10;
        k0.k kVar = this.G;
        if (kVar == null) {
            return;
        }
        if (this.I) {
            kVar.s();
            if (t(null, this.f1721r)) {
                z10 = true;
            } else {
                z10 = false;
            }
        } else {
            z10 = false;
        }
        this.J = z10;
        this.D1 = 0L;
        kVar.s();
        throw null;
    }

    private static int y(TypedArray typedArray, int i10) {
        return typedArray.getInt(R$styleable.PlayerControlView_repeat_toggle_modes, i10);
    }

    public void D(e eVar) {
        this.f1704b.remove(eVar);
    }

    @Nullable
    public k0.k getPlayer() {
        return this.G;
    }

    public int getRepeatToggleModes() {
        return this.N;
    }

    public boolean getShowShuffleButton() {
        return this.S;
    }

    public int getShowTimeoutMs() {
        return this.L;
    }

    public boolean getShowVrButton() {
        View view = this.f1714k;
        return view != null && view.getVisibility() == 0;
    }

    public void setRepeatToggleModes(int i10) {
        this.N = i10;
        k0.k kVar = this.G;
        if (kVar != null) {
            int repeatMode = kVar.getRepeatMode();
            if (i10 == 0 && repeatMode != 0) {
                this.G.setRepeatMode(0);
            } else if (i10 == 1 && repeatMode == 2) {
                this.G.setRepeatMode(1);
            } else if (i10 == 2 && repeatMode == 1) {
                this.G.setRepeatMode(2);
            }
        }
        P();
    }

    public void setShowFastForwardButton(boolean z10) {
        this.P = z10;
        M();
    }

    public void setShowMultiWindowTimeBar(boolean z10) {
        this.I = z10;
        R();
    }

    public void setShowNextButton(boolean z10) {
        this.R = z10;
        M();
    }

    public void setShowPreviousButton(boolean z10) {
        this.Q = z10;
        M();
    }

    public void setShowRewindButton(boolean z10) {
        this.O = z10;
        M();
    }

    public void setShowShuffleButton(boolean z10) {
        this.S = z10;
        Q();
    }

    public void setShowTimeoutMs(int i10) {
        this.L = i10;
        if (C()) {
            A();
        }
    }

    public void setShowVrButton(boolean z10) {
        View view = this.f1714k;
        if (view != null) {
            view.setVisibility(z10 ? 0 : 8);
        }
    }

    public void setTimeBarMinUpdateInterval(int i10) {
        this.M = d1.k.c(i10, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.f1714k;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            L(getShowVrButton(), onClickListener != null, this.f1714k);
        }
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, attributeSet);
    }

    private void E() {
        View view;
        View view2;
        boolean zI = I();
        if (!zI && (view2 = this.f1708e) != null) {
            view2.sendAccessibilityEvent(8);
        } else if (zI && (view = this.f1709f) != null) {
            view.sendAccessibilityEvent(8);
        }
    }

    private void F() {
        View view;
        View view2;
        boolean zI = I();
        if (!zI && (view2 = this.f1708e) != null) {
            view2.requestFocus();
        } else if (zI && (view = this.f1709f) != null) {
            view.requestFocus();
        }
    }

    private void G(k0.k kVar, int i10, long j10) {
        kVar.c(i10, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(k0.k kVar, long j10) {
        kVar.s();
        if (!this.J) {
            G(kVar, kVar.o(), j10);
            O();
            return;
        }
        throw null;
    }

    private void K() {
        N();
        M();
        P();
        Q();
        R();
    }

    private void M() {
        boolean zP;
        boolean zP2;
        boolean zP3;
        boolean zP4;
        boolean zP5;
        if (C() && this.H) {
            k0.k kVar = this.G;
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
            L(this.Q, zP3, this.f1706c);
            L(this.O, zP4, this.f1711h);
            L(this.P, zP5, this.f1710g);
            L(this.R, zP2, this.f1707d);
            a0 a0Var = this.f1717n;
            if (a0Var != null) {
                a0Var.setEnabled(zP);
            }
        }
    }

    private void N() {
        boolean z10;
        boolean z11;
        boolean z12;
        int i10;
        if (C() && this.H) {
            boolean zI = I();
            View view = this.f1708e;
            int i11 = 8;
            boolean z13 = true;
            if (view != null) {
                if (zI && view.isFocused()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (d1.k.f9577a < 21) {
                    z11 = z10;
                } else if (zI && b.a(this.f1708e)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                View view2 = this.f1708e;
                if (zI) {
                    i10 = 8;
                } else {
                    i10 = 0;
                }
                view2.setVisibility(i10);
            } else {
                z10 = false;
                z11 = false;
            }
            View view3 = this.f1709f;
            if (view3 != null) {
                if (!zI && view3.isFocused()) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                z10 |= z12;
                if (d1.k.f9577a < 21) {
                    z13 = z10;
                } else if (zI || !b.a(this.f1709f)) {
                    z13 = false;
                }
                z11 |= z13;
                View view4 = this.f1709f;
                if (zI) {
                    i11 = 0;
                }
                view4.setVisibility(i11);
            }
            if (z10) {
                F();
            }
            if (z11) {
                E();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        long jL;
        long jX;
        boolean z10;
        int playbackState;
        long preferredUpdateDelay;
        if (C() && this.H) {
            k0.k kVar = this.G;
            if (kVar != null) {
                jL = this.D1 + kVar.l();
                jX = this.D1 + kVar.x();
            } else {
                jL = 0;
                jX = 0;
            }
            if (jL != this.E1) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.E1 = jL;
            this.F1 = jX;
            TextView textView = this.f1716m;
            if (textView != null && !this.K && z10) {
                textView.setText(d1.k.g(this.f1718o, this.f1719p, jL));
            }
            a0 a0Var = this.f1717n;
            if (a0Var != null) {
                a0Var.setPosition(jL);
                this.f1717n.setBufferedPosition(jX);
            }
            removeCallbacks(this.f1722s);
            if (kVar == null) {
                playbackState = 1;
            } else {
                playbackState = kVar.getPlaybackState();
            }
            if (kVar != null && kVar.isPlaying()) {
                a0 a0Var2 = this.f1717n;
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
                postDelayed(this.f1722s, 1000L);
            }
        }
    }

    private void P() {
        ImageView imageView;
        if (C() && this.H && (imageView = this.f1712i) != null) {
            if (this.N == 0) {
                L(false, false, imageView);
                return;
            }
            k0.k kVar = this.G;
            if (kVar == null) {
                L(true, false, imageView);
                this.f1712i.setImageDrawable(this.f1724u);
                this.f1712i.setContentDescription(this.f1727x);
                return;
            }
            L(true, true, imageView);
            int repeatMode = kVar.getRepeatMode();
            if (repeatMode != 0) {
                if (repeatMode != 1) {
                    if (repeatMode == 2) {
                        this.f1712i.setImageDrawable(this.f1726w);
                        this.f1712i.setContentDescription(this.f1729z);
                    }
                } else {
                    this.f1712i.setImageDrawable(this.f1725v);
                    this.f1712i.setContentDescription(this.f1728y);
                }
            } else {
                this.f1712i.setImageDrawable(this.f1724u);
                this.f1712i.setContentDescription(this.f1727x);
            }
            this.f1712i.setVisibility(0);
        }
    }

    private void Q() {
        ImageView imageView;
        Drawable drawable;
        String str;
        if (C() && this.H && (imageView = this.f1713j) != null) {
            k0.k kVar = this.G;
            if (!this.S) {
                L(false, false, imageView);
                return;
            }
            if (kVar == null) {
                L(true, false, imageView);
                this.f1713j.setImageDrawable(this.B);
                this.f1713j.setContentDescription(this.F);
                return;
            }
            L(true, true, imageView);
            ImageView imageView2 = this.f1713j;
            if (kVar.v()) {
                drawable = this.A;
            } else {
                drawable = this.B;
            }
            imageView2.setImageDrawable(drawable);
            ImageView imageView3 = this.f1713j;
            if (kVar.v()) {
                str = this.E;
            } else {
                str = this.F;
            }
            imageView3.setContentDescription(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(k0.k kVar) {
        kVar.pause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(k0.k kVar) {
        int playbackState = kVar.getPlaybackState();
        if (playbackState == 1) {
            kVar.prepare();
        } else if (playbackState == 4) {
            G(kVar, kVar.o(), -9223372036854775807L);
        }
        kVar.play();
    }

    private void x(k0.k kVar) {
        int playbackState = kVar.getPlaybackState();
        if (playbackState != 1 && playbackState != 4 && kVar.d()) {
            v(kVar);
        } else {
            w(kVar);
        }
    }

    public boolean C() {
        if (getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void J() {
        if (!C()) {
            setVisibility(0);
            Iterator<e> it = this.f1704b.iterator();
            while (it.hasNext()) {
                it.next().a(getVisibility());
            }
            K();
            F();
            E();
        }
        A();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!u(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.f1723t);
        } else if (motionEvent.getAction() == 1) {
            A();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.H = true;
        long j10 = this.T;
        if (j10 != -9223372036854775807L) {
            long jUptimeMillis = j10 - SystemClock.uptimeMillis();
            if (jUptimeMillis <= 0) {
                z();
            } else {
                postDelayed(this.f1723t, jUptimeMillis);
            }
        } else if (C()) {
            A();
        }
        K();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.H = false;
        removeCallbacks(this.f1722s);
        removeCallbacks(this.f1723t);
    }

    public void s(e eVar) {
        d1.a.b(eVar);
        this.f1704b.add(eVar);
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
        k0.k kVar2 = this.G;
        if (kVar2 == kVar) {
            return;
        }
        if (kVar2 != null) {
            kVar2.b(this.f1703a);
        }
        this.G = kVar;
        if (kVar != null) {
            kVar.m(this.f1703a);
        }
        K();
    }

    public boolean u(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        k0.k kVar = this.G;
        if (kVar != null && B(keyCode)) {
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
                                        v(kVar);
                                        return true;
                                    }
                                    return true;
                                }
                                w(kVar);
                                return true;
                            }
                            kVar.i();
                            return true;
                        }
                        kVar.y();
                        return true;
                    }
                    x(kVar);
                    return true;
                }
                return true;
            }
            return true;
        }
        return false;
    }

    public void z() {
        if (C()) {
            setVisibility(8);
            Iterator<e> it = this.f1704b.iterator();
            while (it.hasNext()) {
                it.next().a(getVisibility());
            }
            removeCallbacks(this.f1722s);
            removeCallbacks(this.f1723t);
            this.T = -9223372036854775807L;
        }
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i10, @Nullable AttributeSet attributeSet2) {
        super(context, attributeSet, i10);
        int resourceId = R$layout.exo_player_control_view;
        this.L = 5000;
        this.N = 0;
        this.M = 200;
        this.T = -9223372036854775807L;
        this.O = true;
        this.P = true;
        this.Q = true;
        this.R = true;
        this.S = false;
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.PlayerControlView, i10, 0);
            try {
                this.L = typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerControlView_show_timeout, this.L);
                resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_controller_layout_id, resourceId);
                this.N = y(typedArrayObtainStyledAttributes, this.N);
                this.O = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_rewind_button, this.O);
                this.P = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_fastforward_button, this.P);
                this.Q = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_previous_button, this.Q);
                this.R = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_next_button, this.R);
                this.S = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_shuffle_button, this.S);
                setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerControlView_time_bar_min_update_interval, this.M));
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }
        this.f1704b = new CopyOnWriteArrayList<>();
        this.f1720q = new k0.m.a();
        this.f1721r = new k0.m.b();
        StringBuilder sb2 = new StringBuilder();
        this.f1718o = sb2;
        this.f1719p = new Formatter(sb2, Locale.getDefault());
        this.U = new long[0];
        this.V = new boolean[0];
        this.W = new long[0];
        this.f1705b1 = new boolean[0];
        c cVar = new c(this, null);
        this.f1703a = cVar;
        this.f1722s = new Runnable() { // from class: b1.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f642a.O();
            }
        };
        this.f1723t = new Runnable() { // from class: b1.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f643a.z();
            }
        };
        LayoutInflater.from(context).inflate(resourceId, this);
        setDescendantFocusability(262144);
        int i11 = R$id.exo_progress;
        a0 a0Var = (a0) findViewById(i11);
        View viewFindViewById = findViewById(R$id.exo_progress_placeholder);
        if (a0Var != null) {
            this.f1717n = a0Var;
        } else if (viewFindViewById != null) {
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2);
            defaultTimeBar.setId(i11);
            defaultTimeBar.setLayoutParams(viewFindViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById);
            viewGroup.removeView(viewFindViewById);
            viewGroup.addView(defaultTimeBar, iIndexOfChild);
            this.f1717n = defaultTimeBar;
        } else {
            this.f1717n = null;
        }
        this.f1715l = (TextView) findViewById(R$id.exo_duration);
        this.f1716m = (TextView) findViewById(R$id.exo_position);
        a0 a0Var2 = this.f1717n;
        if (a0Var2 != null) {
            a0Var2.a(cVar);
        }
        View viewFindViewById2 = findViewById(R$id.exo_play);
        this.f1708e = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(cVar);
        }
        View viewFindViewById3 = findViewById(R$id.exo_pause);
        this.f1709f = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(cVar);
        }
        View viewFindViewById4 = findViewById(R$id.exo_prev);
        this.f1706c = viewFindViewById4;
        if (viewFindViewById4 != null) {
            viewFindViewById4.setOnClickListener(cVar);
        }
        View viewFindViewById5 = findViewById(R$id.exo_next);
        this.f1707d = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(cVar);
        }
        View viewFindViewById6 = findViewById(R$id.exo_rew);
        this.f1711h = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(cVar);
        }
        View viewFindViewById7 = findViewById(R$id.exo_ffwd);
        this.f1710g = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(cVar);
        }
        ImageView imageView = (ImageView) findViewById(R$id.exo_repeat_toggle);
        this.f1712i = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(cVar);
        }
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_shuffle);
        this.f1713j = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(cVar);
        }
        View viewFindViewById8 = findViewById(R$id.exo_vr);
        this.f1714k = viewFindViewById8;
        setShowVrButton(false);
        L(false, false, viewFindViewById8);
        Resources resources = context.getResources();
        this.C = resources.getInteger(R$integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.D = resources.getInteger(R$integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        this.f1724u = resources.getDrawable(R$drawable.exo_controls_repeat_off);
        this.f1725v = resources.getDrawable(R$drawable.exo_controls_repeat_one);
        this.f1726w = resources.getDrawable(R$drawable.exo_controls_repeat_all);
        this.A = resources.getDrawable(R$drawable.exo_controls_shuffle_on);
        this.B = resources.getDrawable(R$drawable.exo_controls_shuffle_off);
        this.f1727x = resources.getString(R$string.exo_controls_repeat_off_description);
        this.f1728y = resources.getString(R$string.exo_controls_repeat_one_description);
        this.f1729z = resources.getString(R$string.exo_controls_repeat_all_description);
        this.E = resources.getString(R$string.exo_controls_shuffle_on_description);
        this.F = resources.getString(R$string.exo_controls_shuffle_off_description);
        this.E1 = -9223372036854775807L;
        this.F1 = -9223372036854775807L;
    }

    public void setProgressUpdateListener(@Nullable d dVar) {
    }
}
