package com.live.evo.widget.nicespinner;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import com.live.evo.R$id;
import com.live.evo.R$layout;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class c<T> extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f7652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final r5.d f7653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ColorStateList f7654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f7656e;

    public abstract T a(int i10);

    @Override // android.widget.Adapter
    public abstract int getCount();

    @Override // android.widget.Adapter
    public abstract T getItem(int i10);

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7657a;

        static {
            int[] iArr = new int[d.values().length];
            f7657a = iArr;
            try {
                iArr[d.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7657a[d.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7657a[d.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TextView f7658a;

        b(TextView textView) {
            this.f7658a = textView;
        }
    }

    private void c(TextView textView) {
        int i10 = a.f7657a[this.f7652a.ordinal()];
        if (i10 == 1) {
            textView.setGravity(GravityCompat.START);
        } else if (i10 == 2) {
            textView.setGravity(GravityCompat.END);
        } else {
            if (i10 != 3) {
                return;
            }
            textView.setGravity(1);
        }
    }

    void b(int i10) {
        this.f7656e = i10;
    }

    c(Context context, ColorStateList colorStateList, int i10, r5.d dVar, d dVar2) {
        this.f7653b = dVar;
        this.f7655d = i10;
        this.f7654c = colorStateList;
        this.f7652a = dVar2;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, @Nullable View view, ViewGroup viewGroup) {
        TextView textView;
        Context context = viewGroup.getContext();
        if (view == null) {
            view = View.inflate(context, R$layout.spinner_list_item, null);
            textView = (TextView) view.findViewById(R$id.text_view_spinner);
            view.setTag(new b(textView));
        } else {
            textView = ((b) view.getTag()).f7658a;
        }
        textView.setText(this.f7653b.a(getItem(i10)));
        textView.setTextColor(this.f7654c);
        c(textView);
        return view;
    }
}
