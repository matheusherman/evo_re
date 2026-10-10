package com.live.evo.widget.nicespinner;

import android.content.Context;
import android.content.res.ColorStateList;
import android.widget.ListAdapter;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b extends c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ListAdapter f7651f;

    b(Context context, ListAdapter listAdapter, ColorStateList colorStateList, int i10, r5.d dVar, d dVar2) {
        super(context, colorStateList, i10, dVar, dVar2);
        this.f7651f = listAdapter;
    }

    @Override // com.live.evo.widget.nicespinner.c
    public Object a(int i10) {
        return this.f7651f.getItem(i10);
    }

    @Override // com.live.evo.widget.nicespinner.c, android.widget.Adapter
    public int getCount() {
        return this.f7651f.getCount() - 1;
    }

    @Override // com.live.evo.widget.nicespinner.c, android.widget.Adapter
    public Object getItem(int i10) {
        ListAdapter listAdapter = this.f7651f;
        if (i10 >= this.f7656e) {
            i10++;
        }
        return listAdapter.getItem(i10);
    }
}
