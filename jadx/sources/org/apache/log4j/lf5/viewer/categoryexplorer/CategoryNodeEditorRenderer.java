package org.apache.log4j.lf5.viewer.categoryexplorer;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JTree;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class CategoryNodeEditorRenderer extends CategoryNodeRenderer {
    private static final long serialVersionUID = -6094804684259929574L;

    public JCheckBox getCheckBox() {
        return this._checkBox;
    }

    @Override // org.apache.log4j.lf5.viewer.categoryexplorer.CategoryNodeRenderer
    public Component getTreeCellRendererComponent(JTree jTree, Object obj, boolean z10, boolean z11, boolean z12, int i10, boolean z13) {
        return super.getTreeCellRendererComponent(jTree, obj, z10, z11, z12, i10, z13);
    }
}
