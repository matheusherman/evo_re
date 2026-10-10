package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import com.pengrad.telegrambot.model.chatbackground.BackgroundTypePattern;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import ua.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@ExperimentalWindowApi
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fJ\u001f\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u000fJ\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/window/embedding/MatcherUtils;", "", "()V", "sDebugMatchers", "", "sMatchersTag", "", "areActivityOrIntentComponentsMatching", "activity", "Landroid/app/Activity;", "ruleComponent", "Landroid/content/ComponentName;", "areActivityOrIntentComponentsMatching$window_release", "areComponentsMatching", "activityComponent", "areComponentsMatching$window_release", "wildcardMatch", "name", BackgroundTypePattern.TYPE, "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MatcherUtils {
    public static final MatcherUtils INSTANCE = new MatcherUtils();
    public static final boolean sDebugMatchers = false;
    public static final String sMatchersTag = "SplitRuleResolution";

    private final boolean wildcardMatch(String name, String pattern) {
        if (!n.O(pattern, "*", false, 2, null)) {
            return false;
        }
        if (m.a(pattern, "*")) {
            return true;
        }
        if (n.b0(pattern, "*", 0, false, 6, null) != n.h0(pattern, "*", 0, false, 6, null) || !n.v(pattern, "*", false, 2, null)) {
            throw new IllegalArgumentException("Name pattern with a wildcard must only contain a single wildcard in the end");
        }
        String strSubstring = pattern.substring(0, pattern.length() - 1);
        m.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return n.I(name, strSubstring, false, 2, null);
    }

    public final boolean areActivityOrIntentComponentsMatching$window_release(Activity activity, ComponentName ruleComponent) {
        ComponentName component;
        m.f(activity, "activity");
        m.f(ruleComponent, "ruleComponent");
        if (areComponentsMatching$window_release(activity.getComponentName(), ruleComponent)) {
            return true;
        }
        Intent intent = activity.getIntent();
        if (intent == null || (component = intent.getComponent()) == null) {
            return false;
        }
        return INSTANCE.areComponentsMatching$window_release(component, ruleComponent);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x005b  */
    /* JADX WARN: Code duplicated, block: B:25:0x0085  */
    public final boolean areComponentsMatching$window_release(ComponentName activityComponent, ComponentName ruleComponent) {
        boolean z10;
        boolean z11;
        m.f(ruleComponent, "ruleComponent");
        if (activityComponent == null) {
            return m.a(ruleComponent.getPackageName(), "*") && m.a(ruleComponent.getClassName(), "*");
        }
        String string = activityComponent.toString();
        m.e(string, "activityComponent.toString()");
        if (n.O(string, "*", false, 2, null)) {
            throw new IllegalArgumentException("Wildcard can only be part of the rule.");
        }
        if (m.a(activityComponent.getPackageName(), ruleComponent.getPackageName())) {
            z10 = true;
        } else {
            String packageName = activityComponent.getPackageName();
            m.e(packageName, "activityComponent.packageName");
            String packageName2 = ruleComponent.getPackageName();
            m.e(packageName2, "ruleComponent.packageName");
            if (wildcardMatch(packageName, packageName2)) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        if (m.a(activityComponent.getClassName(), ruleComponent.getClassName())) {
            z11 = true;
        } else {
            String className = activityComponent.getClassName();
            m.e(className, "activityComponent.className");
            String className2 = ruleComponent.getClassName();
            m.e(className2, "ruleComponent.className");
            if (wildcardMatch(className, className2)) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        return z10 && z11;
    }

    private MatcherUtils() {
    }
}
