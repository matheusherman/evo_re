package z1.b1.lb.m.extra.marquee;

import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.List;
import n6.a;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class MarqueeList extends a {
    private List<MarqueeInfo> marqueeList = new ArrayList();

    @Keep
    public List<MarqueeInfo> getMarqueeList() {
        return this.marqueeList;
    }

    @Keep
    public void setMarqueeList(List<MarqueeInfo> list) {
        this.marqueeList = list;
    }
}
