package com.live.evo.widget.sloading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b extends Drawable implements Animatable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.live.evo.widget.sloading.a f7726a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Drawable.Callback {
        a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            b.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
            b.this.scheduleSelf(runnable, j10);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            b.this.unscheduleSelf(runnable);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    void a(Context context, int i10) {
        com.live.evo.widget.sloading.a aVar = this.f7726a;
        if (aVar != null) {
            aVar.i(context);
            this.f7726a.k(context, i10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f7726a.e();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.f7726a.f();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f7726a.m();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f7726a.q(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f7726a.t(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f7726a.w();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f7726a.x();
    }

    b(com.live.evo.widget.sloading.a aVar) {
        this.f7726a = aVar;
        aVar.r(new a());
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (!getBounds().isEmpty()) {
            this.f7726a.c(canvas);
        }
    }
}
