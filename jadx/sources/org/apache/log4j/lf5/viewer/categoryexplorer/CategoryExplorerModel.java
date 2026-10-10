package org.apache.log4j.lf5.viewer.categoryexplorer;

import androidx.core.view.PointerIconCompat;
import java.awt.AWTEventMulticaster;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import org.apache.log4j.lf5.LogRecord;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class CategoryExplorerModel extends DefaultTreeModel {
    private static final long serialVersionUID = -3413887384316015901L;
    protected ActionEvent _event;
    protected ActionListener _listener;
    protected boolean _renderFatal;

    public synchronized void addActionListener(ActionListener actionListener) {
        this._listener = AWTEventMulticaster.add(this._listener, actionListener);
    }

    public CategoryNode getCategoryNode(String str) {
        return getCategoryNode(new CategoryPath(str));
    }

    public synchronized void removeActionListener(ActionListener actionListener) {
        this._listener = AWTEventMulticaster.remove(this._listener, actionListener);
    }

    public void addLogRecord(LogRecord logRecord) {
        CategoryPath categoryPath = new CategoryPath(logRecord.getCategory());
        addCategory(categoryPath);
        CategoryNode categoryNode = getCategoryNode(categoryPath);
        categoryNode.addRecord();
        if (this._renderFatal && logRecord.isFatal()) {
            CategoryNode[] pathToRoot = getPathToRoot(categoryNode);
            int length = pathToRoot.length;
            for (int i10 = 1; i10 < length - 1; i10++) {
                CategoryNode categoryNode2 = pathToRoot[i10];
                categoryNode2.setHasFatalChildren(true);
                nodeChanged(categoryNode2);
            }
            categoryNode.setHasFatalRecords(true);
            nodeChanged(categoryNode);
        }
    }

    public TreePath getTreePathToRoot(CategoryNode categoryNode) {
        if (categoryNode == null) {
            return null;
        }
        return new TreePath(getPathToRoot(categoryNode));
    }

    protected void notifyActionListeners() {
        ActionListener actionListener = this._listener;
        if (actionListener != null) {
            actionListener.actionPerformed(this._event);
        }
    }

    protected void refresh(final CategoryNode categoryNode) {
        SwingUtilities.invokeLater(new Runnable() { // from class: org.apache.log4j.lf5.viewer.categoryexplorer.CategoryExplorerModel.1
            @Override // java.lang.Runnable
            public void run() {
                CategoryExplorerModel.this.nodeChanged(categoryNode);
            }
        });
    }

    public CategoryExplorerModel(CategoryNode categoryNode) {
        super(categoryNode);
        this._renderFatal = true;
        this._listener = null;
        this._event = new ActionEvent(this, PointerIconCompat.TYPE_CONTEXT_MENU, "Nodes Selection changed");
    }

    public CategoryNode addCategory(CategoryPath categoryPath) {
        CategoryNode categoryNode;
        boolean z10;
        CategoryNode categoryNode2 = (CategoryNode) getRoot();
        for (int i10 = 0; i10 < categoryPath.size(); i10++) {
            CategoryElement categoryElementCategoryElementAt = categoryPath.categoryElementAt(i10);
            Enumeration enumerationChildren = categoryNode2.children();
            while (true) {
                if (enumerationChildren.hasMoreElements()) {
                    categoryNode = (CategoryNode) enumerationChildren.nextElement();
                    if (categoryNode.getTitle().toLowerCase().equals(categoryElementCategoryElementAt.getTitle().toLowerCase())) {
                        z10 = true;
                        break;
                    }
                } else {
                    categoryNode = categoryNode2;
                    z10 = false;
                    break;
                }
            }
            if (!z10) {
                categoryNode2 = new CategoryNode(categoryElementCategoryElementAt.getTitle());
                insertNodeInto(categoryNode2, categoryNode, categoryNode.getChildCount());
                refresh(categoryNode2);
            } else {
                categoryNode2 = categoryNode;
            }
        }
        return categoryNode2;
    }

    public CategoryNode getCategoryNode(CategoryPath categoryPath) {
        CategoryNode categoryNode;
        boolean z10;
        CategoryNode categoryNode2 = (CategoryNode) getRoot();
        int i10 = 0;
        while (i10 < categoryPath.size()) {
            CategoryElement categoryElementCategoryElementAt = categoryPath.categoryElementAt(i10);
            Enumeration enumerationChildren = categoryNode2.children();
            while (true) {
                if (!enumerationChildren.hasMoreElements()) {
                    categoryNode = categoryNode2;
                    z10 = false;
                    break;
                }
                categoryNode = (CategoryNode) enumerationChildren.nextElement();
                if (categoryNode.getTitle().toLowerCase().equals(categoryElementCategoryElementAt.getTitle().toLowerCase())) {
                    z10 = true;
                    break;
                }
            }
            if (!z10) {
                return null;
            }
            i10++;
            categoryNode2 = categoryNode;
        }
        return categoryNode2;
    }

    public CategoryNode getRootCategoryNode() {
        return (CategoryNode) getRoot();
    }

    public boolean isCategoryPathActive(CategoryPath categoryPath) {
        boolean z10;
        CategoryNode categoryNode = (CategoryNode) getRoot();
        boolean z11 = false;
        for (int i10 = 0; i10 < categoryPath.size(); i10++) {
            CategoryElement categoryElementCategoryElementAt = categoryPath.categoryElementAt(i10);
            Enumeration enumerationChildren = categoryNode.children();
            while (true) {
                if (enumerationChildren.hasMoreElements()) {
                    categoryNode = (CategoryNode) enumerationChildren.nextElement();
                    if (categoryNode.getTitle().toLowerCase().equals(categoryElementCategoryElementAt.getTitle().toLowerCase())) {
                        z11 = true;
                        if (!categoryNode.isSelected()) {
                            z11 = false;
                        }
                        z10 = true;
                        break;
                    }
                } else {
                    z11 = false;
                    z10 = false;
                    break;
                }
            }
            if (!z11 || !z10) {
                return false;
            }
        }
        return z11;
    }

    public void resetAllNodeCounts() {
        Enumeration enumerationDepthFirstEnumeration = getRootCategoryNode().depthFirstEnumeration();
        while (enumerationDepthFirstEnumeration.hasMoreElements()) {
            CategoryNode categoryNode = (CategoryNode) enumerationDepthFirstEnumeration.nextElement();
            categoryNode.resetNumberOfContainedRecords();
            nodeChanged(categoryNode);
        }
    }

    public void setDescendantSelection(CategoryNode categoryNode, boolean z10) {
        Enumeration enumerationDepthFirstEnumeration = categoryNode.depthFirstEnumeration();
        while (enumerationDepthFirstEnumeration.hasMoreElements()) {
            CategoryNode categoryNode2 = (CategoryNode) enumerationDepthFirstEnumeration.nextElement();
            if (categoryNode2.isSelected() != z10) {
                categoryNode2.setSelected(z10);
                nodeChanged(categoryNode2);
            }
        }
        notifyActionListeners();
    }

    public void setParentSelection(CategoryNode categoryNode, boolean z10) {
        CategoryNode[] pathToRoot = getPathToRoot(categoryNode);
        int length = pathToRoot.length;
        for (int i10 = 1; i10 < length; i10++) {
            CategoryNode categoryNode2 = pathToRoot[i10];
            if (categoryNode2.isSelected() != z10) {
                categoryNode2.setSelected(z10);
                nodeChanged(categoryNode2);
            }
        }
        notifyActionListeners();
    }

    public void update(CategoryNode categoryNode, boolean z10) {
        if (categoryNode.isSelected() == z10) {
            return;
        }
        if (z10) {
            setParentSelection(categoryNode, true);
        } else {
            setDescendantSelection(categoryNode, false);
        }
    }
}
