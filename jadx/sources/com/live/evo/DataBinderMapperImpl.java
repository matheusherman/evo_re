package com.live.evo;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import z4.b0;
import z4.b1;
import z4.d0;
import z4.d1;
import z4.f0;
import z4.f1;
import z4.h0;
import z4.h1;
import z4.j0;
import z4.j1;
import z4.l0;
import z4.l1;
import z4.n;
import z4.n0;
import z4.n1;
import z4.p;
import z4.p0;
import z4.p1;
import z4.r;
import z4.r0;
import z4.s1;
import z4.t;
import z4.t0;
import z4.u1;
import z4.v;
import z4.v0;
import z4.w1;
import z4.x;
import z4.x0;
import z4.z;
import z4.z0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class DataBinderMapperImpl extends DataBinderMapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f5170a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final SparseArray<String> f5171a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(1);
            f5171a = sparseArray;
            sparseArray.put(0, "_all");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final HashMap<String, Integer> f5172a;

        static {
            HashMap<String, Integer> map = new HashMap<>(36);
            f5172a = map;
            map.put("layout/account_activity_login_type_0", Integer.valueOf(R$layout.account_activity_login_type));
            map.put("layout/activity_about_us_0", Integer.valueOf(R$layout.activity_about_us));
            map.put("layout/activity_history_list_0", Integer.valueOf(R$layout.activity_history_list));
            map.put("layout/activity_live_search_0", Integer.valueOf(R$layout.activity_live_search));
            map.put("layout/activity_renew_0", Integer.valueOf(R$layout.activity_renew));
            map.put("layout/activity_settings_0", Integer.valueOf(R$layout.activity_settings));
            map.put("layout/activity_settings_detail_0", Integer.valueOf(R$layout.activity_settings_detail));
            map.put("layout/activity_settings_link_0", Integer.valueOf(R$layout.activity_settings_link));
            map.put("layout/activity_share_0", Integer.valueOf(R$layout.activity_share));
            map.put("layout/activity_view_main_0", Integer.valueOf(R$layout.activity_view_main));
            map.put("layout/dialog_channel_time_list_0", Integer.valueOf(R$layout.dialog_channel_time_list));
            map.put("layout/fragment_channle_list_0", Integer.valueOf(R$layout.fragment_channle_list));
            map.put("layout/fragment_create_account_0", Integer.valueOf(R$layout.fragment_create_account));
            map.put("layout/fragment_epg_list_0", Integer.valueOf(R$layout.fragment_epg_list));
            map.put("layout/fragment_favorite_list_0", Integer.valueOf(R$layout.fragment_favorite_list));
            map.put("layout/fragment_history_live_0", Integer.valueOf(R$layout.fragment_history_live));
            map.put("layout/fragment_history_vod_0", Integer.valueOf(R$layout.fragment_history_vod));
            map.put("layout/fragment_login_account_0", Integer.valueOf(R$layout.fragment_login_account));
            map.put("layout/fragment_login_email_0", Integer.valueOf(R$layout.fragment_login_email));
            map.put("layout/fragment_login_phone_0", Integer.valueOf(R$layout.fragment_login_phone));
            map.put("layout/fragment_login_type_0", Integer.valueOf(R$layout.fragment_login_type));
            map.put("layout/fragment_main_me_0", Integer.valueOf(R$layout.fragment_main_me));
            map.put("layout/fragment_main_tv_0", Integer.valueOf(R$layout.fragment_main_tv));
            map.put("layout/fragment_main_vod_0", Integer.valueOf(R$layout.fragment_main_vod));
            map.put("layout/fragment_reset_password_0", Integer.valueOf(R$layout.fragment_reset_password));
            map.put("layout/fragment_subscribe_list_0", Integer.valueOf(R$layout.fragment_subscribe_list));
            map.put("layout/fragment_vod_single_0", Integer.valueOf(R$layout.fragment_vod_single));
            map.put("layout/include_history_del_view_0", Integer.valueOf(R$layout.include_history_del_view));
            map.put("layout/item_vod_list_type_banner_0", Integer.valueOf(R$layout.item_vod_list_type_banner));
            map.put("layout/item_vod_list_type_title_0", Integer.valueOf(R$layout.item_vod_list_type_title));
            map.put("layout/layout_header_0", Integer.valueOf(R$layout.layout_header));
            map.put("layout/layout_settings_item_0", Integer.valueOf(R$layout.layout_settings_item));
            map.put("layout/layout_settings_link_0", Integer.valueOf(R$layout.layout_settings_link));
            map.put("layout/settings_detail_bottom_0", Integer.valueOf(R$layout.settings_detail_bottom));
            map.put("layout/view_empty_data_0", Integer.valueOf(R$layout.view_empty_data));
            map.put("layout/vod_banner_0", Integer.valueOf(R$layout.vod_banner));
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i10) {
        int i11 = f5170a.get(i10);
        if (i11 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i11) {
            case 1:
                if ("layout/account_activity_login_type_0".equals(tag)) {
                    return new z4.b(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for account_activity_login_type is invalid. Received: " + tag);
            case 2:
                if ("layout/activity_about_us_0".equals(tag)) {
                    return new z4.e(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_about_us is invalid. Received: " + tag);
            case 3:
                if ("layout/activity_history_list_0".equals(tag)) {
                    return new z4.g(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_history_list is invalid. Received: " + tag);
            case 4:
                if ("layout/activity_live_search_0".equals(tag)) {
                    return new z4.j(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_live_search is invalid. Received: " + tag);
            case 5:
                if ("layout/activity_renew_0".equals(tag)) {
                    return new z4.l(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_renew is invalid. Received: " + tag);
            case 6:
                if ("layout/activity_settings_0".equals(tag)) {
                    return new n(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_settings is invalid. Received: " + tag);
            case 7:
                if ("layout/activity_settings_detail_0".equals(tag)) {
                    return new p(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_settings_detail is invalid. Received: " + tag);
            case 8:
                if ("layout/activity_settings_link_0".equals(tag)) {
                    return new r(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_settings_link is invalid. Received: " + tag);
            case 9:
                if ("layout/activity_share_0".equals(tag)) {
                    return new t(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_share is invalid. Received: " + tag);
            case 10:
                if ("layout/activity_view_main_0".equals(tag)) {
                    return new v(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_view_main is invalid. Received: " + tag);
            case 11:
                if ("layout/dialog_channel_time_list_0".equals(tag)) {
                    return new x(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_channel_time_list is invalid. Received: " + tag);
            case 12:
                if ("layout/fragment_channle_list_0".equals(tag)) {
                    return new z(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_channle_list is invalid. Received: " + tag);
            case 13:
                if ("layout/fragment_create_account_0".equals(tag)) {
                    return new b0(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_create_account is invalid. Received: " + tag);
            case 14:
                if ("layout/fragment_epg_list_0".equals(tag)) {
                    return new d0(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_epg_list is invalid. Received: " + tag);
            case 15:
                if ("layout/fragment_favorite_list_0".equals(tag)) {
                    return new f0(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_favorite_list is invalid. Received: " + tag);
            case 16:
                if ("layout/fragment_history_live_0".equals(tag)) {
                    return new h0(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_history_live is invalid. Received: " + tag);
            case 17:
                if ("layout/fragment_history_vod_0".equals(tag)) {
                    return new j0(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_history_vod is invalid. Received: " + tag);
            case 18:
                if ("layout/fragment_login_account_0".equals(tag)) {
                    return new l0(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_login_account is invalid. Received: " + tag);
            case 19:
                if ("layout/fragment_login_email_0".equals(tag)) {
                    return new n0(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_login_email is invalid. Received: " + tag);
            case 20:
                if ("layout/fragment_login_phone_0".equals(tag)) {
                    return new p0(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_login_phone is invalid. Received: " + tag);
            case 21:
                if ("layout/fragment_login_type_0".equals(tag)) {
                    return new r0(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_login_type is invalid. Received: " + tag);
            case 22:
                if ("layout/fragment_main_me_0".equals(tag)) {
                    return new t0(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_main_me is invalid. Received: " + tag);
            case 23:
                if ("layout/fragment_main_tv_0".equals(tag)) {
                    return new v0(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_main_tv is invalid. Received: " + tag);
            case 24:
                if ("layout/fragment_main_vod_0".equals(tag)) {
                    return new x0(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_main_vod is invalid. Received: " + tag);
            case 25:
                if ("layout/fragment_reset_password_0".equals(tag)) {
                    return new z0(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_reset_password is invalid. Received: " + tag);
            case 26:
                if ("layout/fragment_subscribe_list_0".equals(tag)) {
                    return new b1(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_subscribe_list is invalid. Received: " + tag);
            case 27:
                if ("layout/fragment_vod_single_0".equals(tag)) {
                    return new d1(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_vod_single is invalid. Received: " + tag);
            case 28:
                if ("layout/include_history_del_view_0".equals(tag)) {
                    return new f1(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for include_history_del_view is invalid. Received: " + tag);
            case 29:
                if ("layout/item_vod_list_type_banner_0".equals(tag)) {
                    return new h1(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_vod_list_type_banner is invalid. Received: " + tag);
            case 30:
                if ("layout/item_vod_list_type_title_0".equals(tag)) {
                    return new j1(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_vod_list_type_title is invalid. Received: " + tag);
            case 31:
                if ("layout/layout_header_0".equals(tag)) {
                    return new l1(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_header is invalid. Received: " + tag);
            case 32:
                if ("layout/layout_settings_item_0".equals(tag)) {
                    return new n1(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_settings_item is invalid. Received: " + tag);
            case 33:
                if ("layout/layout_settings_link_0".equals(tag)) {
                    return new p1(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_settings_link is invalid. Received: " + tag);
            case 34:
                if ("layout/settings_detail_bottom_0".equals(tag)) {
                    return new s1(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for settings_detail_bottom is invalid. Received: " + tag);
            case 35:
                if ("layout/view_empty_data_0".equals(tag)) {
                    return new u1(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_empty_data is invalid. Received: " + tag);
            case 36:
                if ("layout/vod_banner_0".equals(tag)) {
                    return new w1(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for vod_banner is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f5172a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(36);
        f5170a = sparseIntArray;
        sparseIntArray.put(R$layout.account_activity_login_type, 1);
        sparseIntArray.put(R$layout.activity_about_us, 2);
        sparseIntArray.put(R$layout.activity_history_list, 3);
        sparseIntArray.put(R$layout.activity_live_search, 4);
        sparseIntArray.put(R$layout.activity_renew, 5);
        sparseIntArray.put(R$layout.activity_settings, 6);
        sparseIntArray.put(R$layout.activity_settings_detail, 7);
        sparseIntArray.put(R$layout.activity_settings_link, 8);
        sparseIntArray.put(R$layout.activity_share, 9);
        sparseIntArray.put(R$layout.activity_view_main, 10);
        sparseIntArray.put(R$layout.dialog_channel_time_list, 11);
        sparseIntArray.put(R$layout.fragment_channle_list, 12);
        sparseIntArray.put(R$layout.fragment_create_account, 13);
        sparseIntArray.put(R$layout.fragment_epg_list, 14);
        sparseIntArray.put(R$layout.fragment_favorite_list, 15);
        sparseIntArray.put(R$layout.fragment_history_live, 16);
        sparseIntArray.put(R$layout.fragment_history_vod, 17);
        sparseIntArray.put(R$layout.fragment_login_account, 18);
        sparseIntArray.put(R$layout.fragment_login_email, 19);
        sparseIntArray.put(R$layout.fragment_login_phone, 20);
        sparseIntArray.put(R$layout.fragment_login_type, 21);
        sparseIntArray.put(R$layout.fragment_main_me, 22);
        sparseIntArray.put(R$layout.fragment_main_tv, 23);
        sparseIntArray.put(R$layout.fragment_main_vod, 24);
        sparseIntArray.put(R$layout.fragment_reset_password, 25);
        sparseIntArray.put(R$layout.fragment_subscribe_list, 26);
        sparseIntArray.put(R$layout.fragment_vod_single, 27);
        sparseIntArray.put(R$layout.include_history_del_view, 28);
        sparseIntArray.put(R$layout.item_vod_list_type_banner, 29);
        sparseIntArray.put(R$layout.item_vod_list_type_title, 30);
        sparseIntArray.put(R$layout.layout_header, 31);
        sparseIntArray.put(R$layout.layout_settings_item, 32);
        sparseIntArray.put(R$layout.layout_settings_link, 33);
        sparseIntArray.put(R$layout.settings_detail_bottom, 34);
        sparseIntArray.put(R$layout.view_empty_data, 35);
        sparseIntArray.put(R$layout.vod_banner, 36);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.tvc.lib.DataBinderMapperImpl());
        arrayList.add(new ziyi.kit.keyboard.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i10) {
        return a.f5171a.get(i10);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i10) {
        if (viewArr == null || viewArr.length == 0 || f5170a.get(i10) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
