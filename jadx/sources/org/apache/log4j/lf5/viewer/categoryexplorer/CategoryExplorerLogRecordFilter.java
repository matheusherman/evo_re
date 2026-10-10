package org.apache.log4j.lf5.viewer.categoryexplorer;

import java.util.Enumeration;
import javax.swing.tree.TreeNode;
import org.apache.log4j.lf5.LogRecord;
import org.apache.log4j.lf5.LogRecordFilter;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class CategoryExplorerLogRecordFilter implements LogRecordFilter {
    protected CategoryExplorerModel _model;

    @Override // org.apache.log4j.lf5.LogRecordFilter
    public boolean passes(LogRecord logRecord) {
        return this._model.isCategoryPathActive(new CategoryPath(logRecord.getCategory()));
    }

    protected void resetAllNodes() {
        Enumeration enumerationDepthFirstEnumeration = this._model.getRootCategoryNode().depthFirstEnumeration();
        while (enumerationDepthFirstEnumeration.hasMoreElements()) {
            TreeNode treeNode = (CategoryNode) enumerationDepthFirstEnumeration.nextElement();
            treeNode.resetNumberOfContainedRecords();
            this._model.nodeChanged(treeNode);
        }
    }

    public CategoryExplorerLogRecordFilter(CategoryExplorerModel categoryExplorerModel) {
        this._model = categoryExplorerModel;
    }

    public void reset() {
        resetAllNodes();
    }
}
