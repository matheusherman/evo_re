package androidx.leanback.system;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import androidx.annotation.RestrictTo;
import androidx.leanback.widget.ShadowOverlayContainer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class Settings {
    private static final String ACTION_PARTNER_CUSTOMIZATION = "android.support.v17.leanback.action.PARTNER_CUSTOMIZATION";
    private static final boolean DEBUG = false;
    public static final String OUTLINE_CLIPPING_DISABLED = "OUTLINE_CLIPPING_DISABLED";
    public static final String PREFER_STATIC_SHADOWS = "PREFER_STATIC_SHADOWS";
    private static final String TAG = "Settings";
    private static Settings sInstance;
    private boolean mOutlineClippingDisabled;
    private boolean mPreferStaticShadows;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class Customizations {
        String mPackageName;
        Resources mResources;

        public boolean getBoolean(String str, boolean z10) {
            int identifier = this.mResources.getIdentifier(str, "bool", this.mPackageName);
            return identifier > 0 ? this.mResources.getBoolean(identifier) : z10;
        }

        public Customizations(Resources resources, String str) {
            this.mResources = resources;
            this.mPackageName = str;
        }
    }

    public boolean getBoolean(String str) {
        return getOrSetBoolean(str, false, false);
    }

    public void setBoolean(String str, boolean z10) {
        getOrSetBoolean(str, true, z10);
    }

    public static Settings getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new Settings(context);
        }
        return sInstance;
    }

    private static boolean isSystemApp(ResolveInfo resolveInfo) {
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        return (activityInfo == null || (activityInfo.applicationInfo.flags & 1) == 0) ? false : true;
    }

    boolean getOrSetBoolean(String str, boolean z10, boolean z11) {
        if (str.compareTo(PREFER_STATIC_SHADOWS) == 0) {
            if (!z10) {
                return this.mPreferStaticShadows;
            }
            this.mPreferStaticShadows = z11;
            return z11;
        }
        if (str.compareTo(OUTLINE_CLIPPING_DISABLED) != 0) {
            throw new IllegalArgumentException("Invalid key");
        }
        if (!z10) {
            return this.mOutlineClippingDisabled;
        }
        this.mOutlineClippingDisabled = z11;
        return z11;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOutlineClippingDisabled() {
        return this.mOutlineClippingDisabled;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean preferStaticShadows() {
        return this.mPreferStaticShadows;
    }

    private Settings(Context context) {
        generateSetting(getCustomizations(context), context);
    }

    private void generateSetting(Customizations customizations, Context context) {
        if (ShadowOverlayContainer.supportsDynamicShadow()) {
            this.mPreferStaticShadows = false;
            if (customizations != null) {
                this.mPreferStaticShadows = customizations.getBoolean("leanback_prefer_static_shadows", false);
            }
        } else {
            this.mPreferStaticShadows = true;
        }
        boolean zIsLowRamDevice = ((ActivityManager) context.getSystemService("activity")).isLowRamDevice();
        this.mOutlineClippingDisabled = zIsLowRamDevice;
        if (customizations != null) {
            this.mOutlineClippingDisabled = customizations.getBoolean("leanback_outline_clipping_disabled", zIsLowRamDevice);
        }
    }

    private Customizations getCustomizations(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Resources resourcesForApplication = null;
        String str = null;
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(new Intent(ACTION_PARTNER_CUSTOMIZATION), 0)) {
            String str2 = resolveInfo.activityInfo.packageName;
            if (str2 != null && isSystemApp(resolveInfo)) {
                try {
                    resourcesForApplication = packageManager.getResourcesForApplication(str2);
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            if (resourcesForApplication != null) {
                str = str2;
                break;
            }
            str = str2;
        }
        if (resourcesForApplication == null) {
            return null;
        }
        return new Customizations(resourcesForApplication, str);
    }
}
