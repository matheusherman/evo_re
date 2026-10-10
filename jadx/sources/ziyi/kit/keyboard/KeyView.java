package ziyi.kit.keyboard;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class KeyView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f23305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f23306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f23307c;

    public KeyView(Context context) {
        this(context, null);
    }

    public KeyView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(@DrawableRes int i10) {
        a aVar = this.f23307c;
        if (aVar != null) {
            aVar.g(i10);
            this.f23306b.setImageResource(i10);
        }
    }

    public void b(CharSequence charSequence) {
        a aVar = this.f23307c;
        if (aVar != null) {
            aVar.i(charSequence);
            this.f23305a.setText(charSequence);
        }
    }

    public void c(boolean z10) {
        a aVar = this.f23307c;
        if (aVar != null) {
            if (z10) {
                aVar.i(aVar.d().toString().toUpperCase());
                a aVar2 = this.f23307c;
                aVar2.j(aVar2.e().toString().toUpperCase());
            } else {
                aVar.i(aVar.d().toString().toLowerCase());
                a aVar3 = this.f23307c;
                aVar3.j(aVar3.e().toString().toLowerCase());
            }
            this.f23305a.setText(this.f23307c.d());
        }
    }

    public a getBean() {
        return this.f23307c;
    }

    public ImageView getImageKeyView() {
        return this.f23306b;
    }

    public TextView getTextKeyView() {
        return this.f23305a;
    }

    public void setBean(a aVar) {
        this.f23307c = aVar;
        if (aVar.a() != -1) {
            this.f23306b.setVisibility(0);
            this.f23305a.setVisibility(4);
            this.f23306b.setImageResource(aVar.a());
            this.f23305a.setText("");
            return;
        }
        this.f23306b.setVisibility(4);
        this.f23305a.setVisibility(0);
        this.f23306b.setImageDrawable(null);
        this.f23305a.setText(aVar.d());
    }

    public void setTypeface(Typeface typeface) {
        TextView textView = this.f23305a;
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        textView.setTypeface(typeface);
    }

    public KeyView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        View.inflate(context, R$layout.key_key_view, this);
        this.f23305a = (TextView) findViewById(R$id.tv_key);
        this.f23306b = (ImageView) findViewById(R$id.iv_key);
        setFocusable(true);
        setClickable(true);
    }
}
