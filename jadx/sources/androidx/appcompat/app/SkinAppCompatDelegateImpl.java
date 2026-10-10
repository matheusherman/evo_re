package androidx.appcompat.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class SkinAppCompatDelegateImpl extends AppCompatDelegate {
    private static Map<Activity, AppCompatDelegate> sDelegateMap = new HashMap();
    private final Activity mActivity;
    private final AppCompatDelegate mDelegate;

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(View view) {
        this.mDelegate.setContentView(view);
    }

    public static AppCompatDelegate get(Activity activity, AppCompatCallback appCompatCallback) {
        AppCompatDelegate appCompatDelegate = sDelegateMap.get(activity);
        if (appCompatDelegate != null) {
            return appCompatDelegate;
        }
        SkinAppCompatDelegateImpl skinAppCompatDelegateImpl = new SkinAppCompatDelegateImpl(activity, appCompatCallback);
        sDelegateMap.put(activity, skinAppCompatDelegateImpl);
        return skinAppCompatDelegateImpl;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mDelegate.addContentView(view, layoutParams);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean applyDayNight() {
        return this.mDelegate.applyDayNight();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public View createView(@Nullable View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return this.mDelegate.createView(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @Nullable
    public View findViewById(int i10) {
        return this.mDelegate.findViewById(i10);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @Nullable
    public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return this.mDelegate.getDrawerToggleDelegate();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public MenuInflater getMenuInflater() {
        return this.mDelegate.getMenuInflater();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @Nullable
    public ActionBar getSupportActionBar() {
        return this.mDelegate.getSupportActionBar();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean hasWindowFeature(int i10) {
        return this.mDelegate.hasWindowFeature(i10);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void invalidateOptionsMenu() {
        this.mDelegate.invalidateOptionsMenu();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean isHandleNativeActionModesEnabled() {
        return this.mDelegate.isHandleNativeActionModesEnabled();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onConfigurationChanged(Configuration configuration) {
        this.mDelegate.onConfigurationChanged(configuration);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onCreate(Bundle bundle) {
        this.mDelegate.onCreate(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onDestroy() {
        this.mDelegate.onDestroy();
        sDelegateMap.remove(this.mActivity);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onPostCreate(Bundle bundle) {
        this.mDelegate.onPostCreate(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onPostResume() {
        this.mDelegate.onPostResume();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onSaveInstanceState(Bundle bundle) {
        this.mDelegate.onSaveInstanceState(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onStart() {
        this.mDelegate.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void onStop() {
        this.mDelegate.onStop();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean requestWindowFeature(int i10) {
        return this.mDelegate.requestWindowFeature(i10);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(int i10) {
        this.mDelegate.setContentView(i10);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setHandleNativeActionModesEnabled(boolean z10) {
        this.mDelegate.setHandleNativeActionModesEnabled(z10);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setLocalNightMode(int i10) {
        this.mDelegate.setLocalNightMode(i10);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        this.mDelegate.setSupportActionBar(toolbar);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setTitle(@Nullable CharSequence charSequence) {
        this.mDelegate.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    @Nullable
    public ActionMode startSupportActionMode(@NonNull ActionMode.Callback callback) {
        return this.mDelegate.startSupportActionMode(callback);
    }

    private SkinAppCompatDelegateImpl(Activity activity, AppCompatCallback appCompatCallback) {
        this.mActivity = activity;
        this.mDelegate = AppCompatDelegate.create(activity, appCompatCallback);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mDelegate.setContentView(view, layoutParams);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void installViewFactory() {
    }
}
