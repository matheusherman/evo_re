package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.base.R$styleable;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class SignInButton extends FrameLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f2130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private View.OnClickListener f2131d;

    public SignInButton(@NonNull Context context) {
        this(context, null);
    }

    public SignInButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private final void b(Context context) {
        View view = this.f2130c;
        if (view != null) {
            removeView(view);
        }
        try {
            this.f2130c = com.google.android.gms.common.internal.l.c(context, this.f2128a, this.f2129b);
        } catch (u1.c.a unused) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            int i10 = this.f2128a;
            int i11 = this.f2129b;
            m1.n nVar = new m1.n(context, null);
            nVar.a(context.getResources(), i10, i11);
            this.f2130c = nVar;
        }
        addView(this.f2130c);
        this.f2130c.setEnabled(isEnabled());
        this.f2130c.setOnClickListener(this);
    }

    public void a(int i10, int i11) {
        this.f2128a = i10;
        this.f2129b = i11;
        b(getContext());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NonNull View view) {
        View.OnClickListener onClickListener = this.f2131d;
        if (onClickListener == null || view != this.f2130c) {
            return;
        }
        onClickListener.onClick(this);
    }

    public void setColorScheme(int i10) {
        a(this.f2128a, i10);
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f2131d = onClickListener;
        View view = this.f2130c;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    @Deprecated
    public void setScopes(@NonNull Scope[] scopeArr) {
        a(this.f2128a, this.f2129b);
    }

    public void setSize(int i10) {
        a(i10, this.f2129b);
    }

    public SignInButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2131d = null;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.SignInButton, 0, 0);
        try {
            this.f2128a = typedArrayObtainStyledAttributes.getInt(R$styleable.SignInButton_buttonSize, 0);
            this.f2129b = typedArrayObtainStyledAttributes.getInt(R$styleable.SignInButton_colorScheme, 2);
            typedArrayObtainStyledAttributes.recycle();
            a(this.f2128a, this.f2129b);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.f2130c.setEnabled(z10);
    }
}
