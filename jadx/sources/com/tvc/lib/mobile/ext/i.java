package com.tvc.lib.mobile.ext;

import android.text.SpannableString;
import android.text.style.StyleSpan;
import com.google.android.material.tabs.TabLayout;
import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import ua.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0007\u001a\u00020\u0001*\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/android/material/tabs/TabLayout;", "Lr8/z;", "b", "(Lcom/google/android/material/tabs/TabLayout;)V", "Lcom/google/android/material/tabs/TabLayout$Tab;", "", IjkMediaMeta.IJKM_KEY_SELECTED, "c", "(Lcom/google/android/material/tabs/TabLayout$Tab;Z)V", "tvclib_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class i {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"com/tvc/lib/mobile/ext/i$a", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "Lr8/z;", "onTabSelected", "(Lcom/google/android/material/tabs/TabLayout$Tab;)V", "onTabUnselected", "onTabReselected", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements TabLayout.OnTabSelectedListener {
        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            i.c(tab, true);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            i.c(tab, false);
        }

        a() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }
    }

    public static final void b(TabLayout tabLayout) {
        if (tabLayout == null) {
            return;
        }
        tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(TabLayout.Tab tab, boolean z10) {
        if (tab == null || tab.getText() == null) {
            return;
        }
        String string = n.Q0(String.valueOf(tab.getText())).toString();
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(z10 ? new StyleSpan(1) : new StyleSpan(0), 0, string.length(), 17);
        tab.setText(spannableString);
    }
}
