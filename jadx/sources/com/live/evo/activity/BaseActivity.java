package com.live.evo.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.SkinAppCompatDelegateImpl;
import com.live.evo.MyApplication;
import me.jessyan.autosize.internal.CustomAdapt;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class BaseActivity extends com.live.evo.activity.base.BaseActivity implements CustomAdapt {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f5221h = false;

    @Override // me.jessyan.autosize.internal.CustomAdapt
    public float getSizeInDp() {
        return 0.0f;
    }

    @Override // me.jessyan.autosize.internal.CustomAdapt
    public boolean isBaseOnWidth() {
        return true;
    }

    public static /* synthetic */ void s(View view, int i10) {
        if ((i10 & 4) == 0) {
            view.setSystemUiVisibility(3846);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(com.live.evo.util.j.a(context));
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    @NonNull
    public AppCompatDelegate getDelegate() {
        return SkinAppCompatDelegateImpl.get(this, this);
    }

    @Override // com.live.evo.activity.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // com.live.evo.activity.base.BaseActivity, com.live.evo.activity.base.MonitorableActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        com.live.evo.util.j.a(this);
        final View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(3846);
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.live.evo.activity.a
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public final void onSystemUiVisibilityChange(int i10) {
                BaseActivity.s(decorView, i10);
            }
        });
        MyApplication.a().b(this);
    }

    @Override // com.live.evo.activity.base.BaseActivity, com.live.evo.activity.base.MonitorableActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        MyApplication.a().e(this);
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // com.live.evo.activity.base.MonitorableActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f5221h = true;
    }

    @Override // com.live.evo.activity.base.BaseActivity, com.live.evo.activity.base.MonitorableActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        this.f5221h = false;
    }

    protected void t() {
        getWindow().addFlags(128);
    }
}
