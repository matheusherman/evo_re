package org.apache.log4j.lf5.viewer.categoryexplorer;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.TreePath;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class CategoryImmediateEditor extends DefaultTreeCellEditor {
    protected Icon editingIcon;
    private CategoryNodeRenderer renderer;

    protected boolean canEditImmediately(EventObject eventObject) {
        return false;
    }

    protected void determineOffset(JTree jTree, Object obj, boolean z10, boolean z11, boolean z12, int i10) {
        this.offset = 0;
    }

    public boolean shouldSelectCell(EventObject eventObject) {
        return false;
    }

    public boolean inCheckBoxHitRegion(MouseEvent mouseEvent) {
        TreePath pathForLocation = this.tree.getPathForLocation(mouseEvent.getX(), mouseEvent.getY());
        if (pathForLocation == null) {
            return false;
        }
        Rectangle rowBounds = this.tree.getRowBounds(this.lastRow);
        Dimension checkBoxOffset = this.renderer.getCheckBoxOffset();
        rowBounds.translate(this.offset + checkBoxOffset.width, checkBoxOffset.height);
        rowBounds.contains(mouseEvent.getPoint());
        return true;
    }

    public CategoryImmediateEditor(JTree jTree, CategoryNodeRenderer categoryNodeRenderer, CategoryNodeEditor categoryNodeEditor) {
        super(jTree, categoryNodeRenderer, categoryNodeEditor);
        this.editingIcon = null;
        this.renderer = categoryNodeRenderer;
        categoryNodeRenderer.setIcon(null);
        categoryNodeRenderer.setLeafIcon(null);
        categoryNodeRenderer.setOpenIcon(null);
        categoryNodeRenderer.setClosedIcon(null);
        ((DefaultTreeCellEditor) this).editingIcon = null;
    }
}
