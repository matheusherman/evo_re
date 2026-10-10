package com.live.evo.widget.ijkmedia;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.PointerIconCompat;
import com.live.evo.R$layout;
import com.live.evo.util.c1;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b extends FrameLayout implements com.live.evo.widget.ijkmedia.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q6.b f7576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MediaController.MediaPlayerControl f7577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f7578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PopupWindow f7579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7580e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f7581f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f7582g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SeekBar f7583h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f7584i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextView f7585j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f7586k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TextView f7587l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f7588m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f7589n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f7590o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f7591p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f7592q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ImageButton f7593r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @SuppressLint({"HandlerLeak"})
    private Handler f7594s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private View.OnClickListener f7595t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private SeekBar.OnSeekBarChangeListener f7596u;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                b.this.hide();
                return;
            }
            if (i10 != 2) {
                return;
            }
            long jX = b.this.x();
            if (b.this.f7591p || !b.this.f7590o) {
                return;
            }
            sendMessageDelayed(obtainMessage(2), 1000 - (jX % 1000));
            b.this.A();
        }
    }

    /* JADX INFO: renamed from: com.live.evo.widget.ijkmedia.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class ViewOnClickListenerC0117b implements View.OnClickListener {
        ViewOnClickListenerC0117b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.s();
            b.this.z(3000);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements SeekBar.OnSeekBarChangeListener {
        c() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            if (z10 || b.this.f7591p) {
                if (b.this.f7589n <= 0) {
                    b bVar = b.this;
                    bVar.f7589n = bVar.f7577b.getDuration();
                }
                String strA = c1.a((b.this.f7589n * ((long) i10)) / 1000);
                if (b.this.f7587l != null) {
                    b.this.f7587l.setText(strA);
                }
                if (b.this.f7585j != null) {
                    b.this.f7585j.setText(strA);
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            b.this.f7591p = true;
            b.this.a();
            b.this.f7594s.removeMessages(2);
            if (b.this.f7587l != null) {
                b.this.f7587l.setText("");
                b.this.f7587l.setVisibility(0);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            long duration = (((long) b.this.f7577b.getDuration()) * ((long) seekBar.getProgress())) / 1000;
            b.this.f7576a.a("onStopTrackingTouch seekTo[{}] bar pos[{}] duration[{}]", Long.valueOf(duration), Integer.valueOf(seekBar.getProgress()), Long.valueOf(b.this.f7589n));
            b.this.f7577b.seekTo((int) duration);
            b.k(b.this);
            if (b.this.f7587l != null) {
                b.this.f7587l.setText("");
                b.this.f7587l.setVisibility(8);
            }
            b.this.z(3000);
            b.this.f7594s.removeMessages(2);
            b.this.f7591p = false;
            b.this.f7594s.sendEmptyMessageDelayed(2, 1000L);
        }
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7576a = q6.c.d(b.class);
        this.f7592q = false;
        this.f7594s = new a();
        this.f7595t = new ViewOnClickListenerC0117b();
        this.f7596u = new c();
        this.f7582g = this;
        this.f7592q = true;
        t(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        if (this.f7582g == null || this.f7593r == null) {
            return;
        }
        if (this.f7577b.isPlaying()) {
            this.f7593r.setImageDrawable(getPauseIconDrawable());
        } else {
            this.f7593r.setImageDrawable(getPlayIconDrawable());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.f7577b.isPlaying()) {
            this.f7577b.pause();
        } else {
            this.f7577b.start();
        }
        A();
    }

    private boolean t(Context context) {
        this.f7578c = context;
        return true;
    }

    private void v() {
        PopupWindow popupWindow = new PopupWindow(this.f7578c);
        this.f7579d = popupWindow;
        popupWindow.setFocusable(false);
        this.f7579d.setBackgroundDrawable(null);
        this.f7579d.setOutsideTouchable(true);
        this.f7580e = R.style.Animation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long x() {
        MediaController.MediaPlayerControl mediaPlayerControl = this.f7577b;
        if (mediaPlayerControl == null) {
            return 0L;
        }
        if (this.f7591p) {
            return this.f7583h.getProgress();
        }
        long currentPosition = mediaPlayerControl.getCurrentPosition();
        long duration = this.f7577b.getDuration();
        SeekBar seekBar = this.f7583h;
        if (seekBar != null) {
            if (duration > 0) {
                seekBar.setProgress((int) ((1000 * currentPosition) / duration));
            }
            this.f7583h.setSecondaryProgress(this.f7577b.getBufferPercentage() * 10);
        }
        this.f7589n = duration;
        TextView textView = this.f7584i;
        if (textView != null) {
            textView.setText(c1.a(duration));
        }
        TextView textView2 = this.f7585j;
        if (textView2 != null) {
            textView2.setText(c1.a(currentPosition));
        }
        return currentPosition;
    }

    @Override // com.live.evo.widget.ijkmedia.a
    public boolean b() {
        return this.f7591p;
    }

    @Override // com.live.evo.widget.ijkmedia.a
    public void c() {
        this.f7596u.onStopTrackingTouch(this.f7583h);
    }

    @Override // com.live.evo.widget.ijkmedia.a
    public void d() {
        this.f7596u.onStartTrackingTouch(this.f7583h);
    }

    @Override // com.live.evo.widget.ijkmedia.a
    public void hide() {
        if (this.f7581f != null && this.f7590o) {
            try {
                this.f7594s.removeMessages(2);
                if (this.f7592q) {
                    setVisibility(8);
                } else {
                    this.f7579d.dismiss();
                }
            } catch (IllegalArgumentException e10) {
                this.f7576a.debug("MediaController already removed", e10);
            }
            this.f7590o = false;
        }
    }

    @Override // com.live.evo.widget.ijkmedia.a
    public boolean isShowing() {
        return this.f7590o;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        z(3000);
        return true;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        z(3000);
        return false;
    }

    @Override // com.live.evo.widget.ijkmedia.a
    public void setAnchorView(View view) {
        this.f7581f = view;
        if (!this.f7592q) {
            removeAllViews();
            View viewW = w();
            this.f7582g = viewW;
            this.f7579d.setContentView(viewW);
            this.f7579d.setWidth(-1);
            this.f7579d.setHeight(-1);
        }
        u(this.f7582g);
    }

    public void setAnimationStyle(int i10) {
        this.f7580e = i10;
    }

    @Override // android.view.View, com.live.evo.widget.ijkmedia.a
    public void setEnabled(boolean z10) {
        ImageButton imageButton = this.f7593r;
        if (imageButton != null) {
            imageButton.setEnabled(z10);
        }
        SeekBar seekBar = this.f7583h;
        if (seekBar != null) {
            seekBar.setEnabled(z10);
        }
        super.setEnabled(z10);
    }

    public void setFileName(String str) {
        this.f7588m = str;
        TextView textView = this.f7586k;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setInfoView(TextView textView) {
        this.f7587l = textView;
    }

    @Override // com.live.evo.widget.ijkmedia.a
    public void setMediaPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.f7577b = mediaPlayerControl;
        A();
    }

    @Override // com.live.evo.widget.ijkmedia.a
    public void setTrackingProgress(int i10) {
        this.f7583h.setProgress(i10);
    }

    @Override // com.live.evo.widget.ijkmedia.a
    public void show() {
        z(3000);
    }

    protected View w() {
        return ((LayoutInflater) this.f7578c.getSystemService("layout_inflater")).inflate(getLayoutId(), this);
    }

    @TargetApi(16)
    public void y() {
        try {
            this.f7581f.setSystemUiVisibility(512);
            PopupWindow.class.getMethod("setWindowLayoutType", Integer.TYPE).invoke(this.f7579d, Integer.valueOf(PointerIconCompat.TYPE_HELP));
        } catch (Exception e10) {
            this.f7576a.error("setWindowLayoutType", e10);
        }
    }

    public void z(int i10) {
        View view;
        if (!this.f7590o && (view = this.f7581f) != null && view.getWindowToken() != null) {
            ImageButton imageButton = this.f7593r;
            if (imageButton != null) {
                imageButton.requestFocus();
            }
            if (this.f7592q) {
                setVisibility(0);
            } else {
                int[] iArr = new int[2];
                this.f7581f.getLocationOnScreen(iArr);
                int i11 = iArr[0];
                Rect rect = new Rect(i11, iArr[1], this.f7581f.getWidth() + i11, iArr[1] + this.f7581f.getHeight());
                this.f7579d.setAnimationStyle(this.f7580e);
                y();
                this.f7579d.showAtLocation(this.f7581f, 51, rect.left, rect.bottom);
            }
            this.f7590o = true;
        }
        A();
        this.f7594s.sendEmptyMessage(2);
        if (i10 != 0) {
            this.f7594s.removeMessages(1);
            Handler handler = this.f7594s;
            handler.sendMessageDelayed(handler.obtainMessage(1), i10);
        }
    }

    static /* bridge */ /* synthetic */ com.live.evo.widget.ijkmedia.a.d k(b bVar) {
        bVar.getClass();
        return null;
    }

    @Override // com.live.evo.widget.ijkmedia.a
    public void a() {
        z(Integer.MAX_VALUE);
    }

    protected int getLayoutId() {
        return R$layout.view_pure_player_mediacontroller;
    }

    protected Drawable getPauseIconDrawable() {
        return getContext().getResources().getDrawable(getResources().getIdentifier("mediacontroller_pause", "drawable", this.f7578c.getPackageName()));
    }

    protected int getPauseIconId() {
        return getResources().getIdentifier("mediacontroller_pause", "drawable", this.f7578c.getPackageName());
    }

    protected Drawable getPlayIconDrawable() {
        return getContext().getResources().getDrawable(getResources().getIdentifier("mediacontroller_play", "drawable", this.f7578c.getPackageName()));
    }

    protected int getPlayIconId() {
        return getResources().getIdentifier("mediacontroller_play", "drawable", this.f7578c.getPackageName());
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        View view = this.f7582g;
        if (view != null) {
            u(view);
        }
    }

    protected void u(View view) {
        ImageButton imageButton = (ImageButton) view.findViewById(getResources().getIdentifier("mediacontroller_play_pause", IjkMediaMeta.IJKM_KEY_TRACK_ID, this.f7578c.getPackageName()));
        this.f7593r = imageButton;
        if (imageButton != null) {
            imageButton.requestFocus();
            this.f7593r.setOnClickListener(this.f7595t);
        }
        SeekBar seekBar = (SeekBar) view.findViewById(getResources().getIdentifier("mediacontroller_seekbar", IjkMediaMeta.IJKM_KEY_TRACK_ID, this.f7578c.getPackageName()));
        this.f7583h = seekBar;
        if (seekBar != null) {
            seekBar.setOnSeekBarChangeListener(this.f7596u);
            this.f7583h.setMax(1000);
        }
        this.f7584i = (TextView) view.findViewById(getResources().getIdentifier("mediacontroller_time_total", IjkMediaMeta.IJKM_KEY_TRACK_ID, this.f7578c.getPackageName()));
        this.f7585j = (TextView) view.findViewById(getResources().getIdentifier("mediacontroller_time_current", IjkMediaMeta.IJKM_KEY_TRACK_ID, this.f7578c.getPackageName()));
        TextView textView = (TextView) view.findViewById(getResources().getIdentifier("mediacontroller_file_name", IjkMediaMeta.IJKM_KEY_TRACK_ID, this.f7578c.getPackageName()));
        this.f7586k = textView;
        if (textView != null) {
            textView.setText(this.f7588m);
        }
    }

    public b(Context context) {
        super(context);
        this.f7576a = q6.c.d(b.class);
        this.f7592q = false;
        this.f7594s = new a();
        this.f7595t = new ViewOnClickListenerC0117b();
        this.f7596u = new c();
        if (this.f7592q || !t(context)) {
            return;
        }
        v();
    }

    public void setOnHiddenListener(com.live.evo.widget.ijkmedia.a.InterfaceC0116a interfaceC0116a) {
    }

    public void setOnPauseListener(com.live.evo.widget.ijkmedia.a.b bVar) {
    }

    public void setOnResumeListener(com.live.evo.widget.ijkmedia.a.c cVar) {
    }

    public void setOnSeekListener(com.live.evo.widget.ijkmedia.a.d dVar) {
    }

    public void setOnShownListener(com.live.evo.widget.ijkmedia.a.e eVar) {
    }
}
