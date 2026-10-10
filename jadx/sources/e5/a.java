package e5;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: e5.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface InterfaceC0175a {
        boolean H();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean c(Fragment fragment) {
        return fragment != 0 && fragment.isVisible() && fragment.getUserVisibleHint() && (fragment instanceof InterfaceC0175a) && ((InterfaceC0175a) fragment).H();
    }

    public static boolean a(Fragment fragment) {
        return b(fragment.getChildFragmentManager());
    }

    public static boolean b(FragmentManager fragmentManager) {
        List<Fragment> fragments = fragmentManager.getFragments();
        if (fragments == null) {
            return false;
        }
        for (int size = fragments.size() - 1; size >= 0; size--) {
            if (c(fragments.get(size))) {
                return true;
            }
        }
        if (fragmentManager.getBackStackEntryCount() <= 0) {
            return false;
        }
        fragmentManager.popBackStack();
        return true;
    }
}
