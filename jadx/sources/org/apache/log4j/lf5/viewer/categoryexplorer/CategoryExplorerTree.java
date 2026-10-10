package org.apache.log4j.lf5.viewer.categoryexplorer;

import java.awt.event.MouseEvent;
import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.tree.TreePath;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class CategoryExplorerTree extends JTree {
    private static final long serialVersionUID = 8066257446951323576L;
    protected CategoryExplorerModel _model;
    protected boolean _rootAlreadyExpanded;

    public CategoryExplorerTree(CategoryExplorerModel categoryExplorerModel) {
        super(categoryExplorerModel);
        this._rootAlreadyExpanded = false;
        this._model = categoryExplorerModel;
        init();
    }

    protected void ensureRootExpansion() {
        this._model.addTreeModelListener(new TreeModelAdapter() { // from class: org.apache.log4j.lf5.viewer.categoryexplorer.CategoryExplorerTree.1
            @Override // org.apache.log4j.lf5.viewer.categoryexplorer.TreeModelAdapter
            public void treeNodesInserted(TreeModelEvent treeModelEvent) {
                CategoryExplorerTree.this.expandRootNode();
            }
        });
    }

    protected void expandRootNode() {
        if (this._rootAlreadyExpanded) {
            return;
        }
        this._rootAlreadyExpanded = true;
        expandPath(new TreePath(this._model.getRootCategoryNode().getPath()));
    }

    public CategoryExplorerModel getExplorerModel() {
        return this._model;
    }

    protected void init() {
        putClientProperty("JTree.lineStyle", "Angled");
        CategoryNodeRenderer categoryNodeRenderer = new CategoryNodeRenderer();
        setEditable(true);
        setCellRenderer(categoryNodeRenderer);
        setCellEditor(new CategoryImmediateEditor(this, new CategoryNodeRenderer(), new CategoryNodeEditor(this._model)));
        setShowsRootHandles(true);
        setToolTipText("");
        ensureRootExpansion();
    }

    public String getToolTipText(MouseEvent mouseEvent) {
        try {
            return super.getToolTipText(mouseEvent);
        } catch (Exception unused) {
            return "";
        }
    }

    public CategoryExplorerTree() {
        this._rootAlreadyExpanded = false;
        CategoryExplorerModel categoryExplorerModel = new CategoryExplorerModel(new CategoryNode("Categories"));
        this._model = categoryExplorerModel;
        setModel(categoryExplorerModel);
        init();
    }
}
