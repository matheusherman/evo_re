package z1.b1.lb.m.meta;

import androidx.annotation.Keep;
import n6.b;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class ApiPageableResponse<T> extends b<T> {
    private int pageId;
    private int pageNo;
    private int pageSize;
    private long totalCount;

    @Keep
    public int getPageId() {
        return this.pageId;
    }

    @Keep
    public int getPageNo() {
        return this.pageNo;
    }

    @Keep
    public int getPageSize() {
        return this.pageSize;
    }

    @Keep
    public long getTotalCount() {
        return this.totalCount;
    }

    @Keep
    public void setPageId(int i10) {
        this.pageId = i10;
    }

    @Keep
    public void setPageNo(int i10) {
        this.pageNo = i10;
    }

    @Keep
    public void setPageSize(int i10) {
        this.pageSize = i10;
    }

    @Keep
    public void setTotalCount(long j10) {
        this.totalCount = j10;
    }
}
