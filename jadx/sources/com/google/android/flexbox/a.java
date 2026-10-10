package com.google.android.flexbox;

import android.view.View;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
interface a {
    View a(int i10);

    int b(int i10, int i11, int i12);

    void c(int i10, View view);

    View d(int i10);

    int e(View view, int i10, int i11);

    int f(int i10, int i11, int i12);

    boolean g();

    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<b> getFlexLinesInternal();

    int getFlexWrap();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    int getSumOfCrossSize();

    int h(View view);

    void i(View view, int i10, int i11, b bVar);

    void k(b bVar);

    void setFlexLines(List<b> list);
}
