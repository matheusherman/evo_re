package androidx.leanback.widget;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class Action {
    public static final long NO_ID = -1;
    private Drawable mIcon;
    private long mId;
    private ArrayList<Integer> mKeyCodes;
    private CharSequence mLabel1;
    private CharSequence mLabel2;

    public Action(long j10) {
        this(j10, "");
    }

    public Action(long j10, CharSequence charSequence) {
        this(j10, charSequence, null);
    }

    public final void addKeyCode(int i10) {
        this.mKeyCodes.add(Integer.valueOf(i10));
    }

    public final Drawable getIcon() {
        return this.mIcon;
    }

    public final long getId() {
        return this.mId;
    }

    public final CharSequence getLabel1() {
        return this.mLabel1;
    }

    public final CharSequence getLabel2() {
        return this.mLabel2;
    }

    public final void removeKeyCode(int i10) {
        this.mKeyCodes.remove(i10);
    }

    public final boolean respondsToKeyCode(int i10) {
        return this.mKeyCodes.contains(Integer.valueOf(i10));
    }

    public final void setIcon(Drawable drawable) {
        this.mIcon = drawable;
    }

    public final void setId(long j10) {
        this.mId = j10;
    }

    public final void setLabel1(CharSequence charSequence) {
        this.mLabel1 = charSequence;
    }

    public final void setLabel2(CharSequence charSequence) {
        this.mLabel2 = charSequence;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(this.mLabel1)) {
            sb2.append(this.mLabel1);
        }
        if (!TextUtils.isEmpty(this.mLabel2)) {
            if (!TextUtils.isEmpty(this.mLabel1)) {
                sb2.append(" ");
            }
            sb2.append(this.mLabel2);
        }
        if (this.mIcon != null && sb2.length() == 0) {
            sb2.append("(action icon)");
        }
        return sb2.toString();
    }

    public Action(long j10, CharSequence charSequence, CharSequence charSequence2) {
        this(j10, charSequence, charSequence2, null);
    }

    public Action(long j10, CharSequence charSequence, CharSequence charSequence2, Drawable drawable) {
        this.mId = -1L;
        this.mKeyCodes = new ArrayList<>();
        setId(j10);
        setLabel1(charSequence);
        setLabel2(charSequence2);
        setIcon(drawable);
    }
}
