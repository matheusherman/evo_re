package com.tvc.lib;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import p7.d;
import p7.f;
import p7.h;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class DataBinderMapperImpl extends DataBinderMapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f9186a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final SparseArray<String> f9187a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(1);
            f9187a = sparseArray;
            sparseArray.put(0, "_all");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final HashMap<String, Integer> f9188a;

        static {
            HashMap<String, Integer> map = new HashMap<>(4);
            f9188a = map;
            map.put("layout/common_view_tab_bar_0", Integer.valueOf(R$layout.common_view_tab_bar));
            map.put("layout/dialog_normal_notice_0", Integer.valueOf(R$layout.dialog_normal_notice));
            map.put("layout/dialog_view_loading_0", Integer.valueOf(R$layout.dialog_view_loading));
            map.put("layout/layout_my_video_view_0", Integer.valueOf(R$layout.layout_my_video_view));
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i10) {
        int i11 = f9186a.get(i10);
        if (i11 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        if (i11 == 1) {
            if ("layout/common_view_tab_bar_0".equals(tag)) {
                return new p7.b(dataBindingComponent, view);
            }
            throw new IllegalArgumentException("The tag for common_view_tab_bar is invalid. Received: " + tag);
        }
        if (i11 == 2) {
            if ("layout/dialog_normal_notice_0".equals(tag)) {
                return new d(dataBindingComponent, view);
            }
            throw new IllegalArgumentException("The tag for dialog_normal_notice is invalid. Received: " + tag);
        }
        if (i11 == 3) {
            if ("layout/dialog_view_loading_0".equals(tag)) {
                return new f(dataBindingComponent, view);
            }
            throw new IllegalArgumentException("The tag for dialog_view_loading is invalid. Received: " + tag);
        }
        if (i11 != 4) {
            return null;
        }
        if ("layout/layout_my_video_view_0".equals(tag)) {
            return new h(dataBindingComponent, view);
        }
        throw new IllegalArgumentException("The tag for layout_my_video_view is invalid. Received: " + tag);
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f9188a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(4);
        f9186a = sparseIntArray;
        sparseIntArray.put(R$layout.common_view_tab_bar, 1);
        sparseIntArray.put(R$layout.dialog_normal_notice, 2);
        sparseIntArray.put(R$layout.dialog_view_loading, 3);
        sparseIntArray.put(R$layout.layout_my_video_view, 4);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i10) {
        return a.f9187a.get(i10);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i10) {
        if (viewArr == null || viewArr.length == 0 || f9186a.get(i10) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
