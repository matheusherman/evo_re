package org.apache.log4j.lf5.viewer.categoryexplorer;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.JCheckBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class CategoryNodeEditor extends CategoryAbstractCellEditor {
    protected CategoryExplorerModel _categoryModel;
    protected JCheckBox _checkBox;
    protected CategoryNode _lastEditedNode;
    protected CategoryNodeEditorRenderer _renderer;
    protected JTree _tree;

    @Override // org.apache.log4j.lf5.viewer.categoryexplorer.CategoryAbstractCellEditor
    public Component getTreeCellEditorComponent(JTree jTree, Object obj, boolean z10, boolean z11, boolean z12, int i10) {
        this._lastEditedNode = (CategoryNode) obj;
        this._tree = jTree;
        return this._renderer.getTreeCellRendererComponent(jTree, obj, z10, z11, z12, i10, true);
    }

    protected void collapse(CategoryNode categoryNode) {
        this._tree.collapsePath(getTreePath(categoryNode));
    }

    protected JMenuItem createCollapseMenuItem(final CategoryNode categoryNode) {
        JMenuItem jMenuItem = new JMenuItem("Collapse All Descendant Categories");
        jMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.categoryexplorer.CategoryNodeEditor.7
            public void actionPerformed(ActionEvent actionEvent) {
                CategoryNodeEditor.this.collapseDescendants(categoryNode);
            }
        });
        return jMenuItem;
    }

    protected JMenuItem createExpandMenuItem(final CategoryNode categoryNode) {
        JMenuItem jMenuItem = new JMenuItem("Expand All Descendant Categories");
        jMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.categoryexplorer.CategoryNodeEditor.6
            public void actionPerformed(ActionEvent actionEvent) {
                CategoryNodeEditor.this.expandDescendants(categoryNode);
            }
        });
        return jMenuItem;
    }

    protected JMenuItem createPropertiesMenuItem(final CategoryNode categoryNode) {
        JMenuItem jMenuItem = new JMenuItem("Properties");
        jMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.categoryexplorer.CategoryNodeEditor.3
            public void actionPerformed(ActionEvent actionEvent) {
                CategoryNodeEditor.this.showPropertiesDialog(categoryNode);
            }
        });
        return jMenuItem;
    }

    protected JMenuItem createRemoveMenuItem() {
        JMenuItem jMenuItem = new JMenuItem("Remove All Empty Categories");
        jMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.categoryexplorer.CategoryNodeEditor.8
            public void actionPerformed(ActionEvent actionEvent) {
                while (CategoryNodeEditor.this.removeUnusedNodes() > 0) {
                }
            }
        });
        return jMenuItem;
    }

    protected JMenuItem createSelectDescendantsMenuItem(final CategoryNode categoryNode) {
        JMenuItem jMenuItem = new JMenuItem("Select All Descendant Categories");
        jMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.categoryexplorer.CategoryNodeEditor.4
            public void actionPerformed(ActionEvent actionEvent) {
                CategoryNodeEditor.this._categoryModel.setDescendantSelection(categoryNode, true);
            }
        });
        return jMenuItem;
    }

    protected JMenuItem createUnselectDescendantsMenuItem(final CategoryNode categoryNode) {
        JMenuItem jMenuItem = new JMenuItem("Deselect All Descendant Categories");
        jMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.categoryexplorer.CategoryNodeEditor.5
            public void actionPerformed(ActionEvent actionEvent) {
                CategoryNodeEditor.this._categoryModel.setDescendantSelection(categoryNode, false);
            }
        });
        return jMenuItem;
    }

    protected void expand(CategoryNode categoryNode) {
        this._tree.expandPath(getTreePath(categoryNode));
    }

    @Override // org.apache.log4j.lf5.viewer.categoryexplorer.CategoryAbstractCellEditor
    public Object getCellEditorValue() {
        return this._lastEditedNode.getUserObject();
    }

    protected Object getDisplayedProperties(CategoryNode categoryNode) {
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Category: ");
        stringBuffer.append(categoryNode.getTitle());
        arrayList.add(stringBuffer.toString());
        if (categoryNode.hasFatalRecords()) {
            arrayList.add("Contains at least one fatal LogRecord.");
        }
        if (categoryNode.hasFatalChildren()) {
            arrayList.add("Contains descendants with a fatal LogRecord.");
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("LogRecords in this category alone: ");
        stringBuffer2.append(categoryNode.getNumberOfContainedRecords());
        arrayList.add(stringBuffer2.toString());
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append("LogRecords in descendant categories: ");
        stringBuffer3.append(categoryNode.getNumberOfRecordsFromChildren());
        arrayList.add(stringBuffer3.toString());
        StringBuffer stringBuffer4 = new StringBuffer();
        stringBuffer4.append("LogRecords in this category including descendants: ");
        stringBuffer4.append(categoryNode.getTotalNumberOfRecords());
        arrayList.add(stringBuffer4.toString());
        return arrayList.toArray();
    }

    protected TreePath getTreePath(CategoryNode categoryNode) {
        return new TreePath(categoryNode.getPath());
    }

    protected int removeUnusedNodes() {
        Enumeration enumerationDepthFirstEnumeration = this._categoryModel.getRootCategoryNode().depthFirstEnumeration();
        int i10 = 0;
        while (enumerationDepthFirstEnumeration.hasMoreElements()) {
            MutableTreeNode mutableTreeNode = (CategoryNode) enumerationDepthFirstEnumeration.nextElement();
            if (mutableTreeNode.isLeaf() && mutableTreeNode.getNumberOfContainedRecords() == 0 && mutableTreeNode.getParent() != null) {
                this._categoryModel.removeNodeFromParent(mutableTreeNode);
                i10++;
            }
        }
        return i10;
    }

    protected void showPopup(CategoryNode categoryNode, int i10, int i11) {
        JPopupMenu jPopupMenu = new JPopupMenu();
        jPopupMenu.setSize(150, 400);
        if (categoryNode.getParent() == null) {
            jPopupMenu.add(createRemoveMenuItem());
            jPopupMenu.addSeparator();
        }
        jPopupMenu.add(createSelectDescendantsMenuItem(categoryNode));
        jPopupMenu.add(createUnselectDescendantsMenuItem(categoryNode));
        jPopupMenu.addSeparator();
        jPopupMenu.add(createExpandMenuItem(categoryNode));
        jPopupMenu.add(createCollapseMenuItem(categoryNode));
        jPopupMenu.addSeparator();
        jPopupMenu.add(createPropertiesMenuItem(categoryNode));
        jPopupMenu.show(this._renderer, i10, i11);
    }

    protected void showPropertiesDialog(CategoryNode categoryNode) {
        JTree jTree = this._tree;
        Object displayedProperties = getDisplayedProperties(categoryNode);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Category Properties: ");
        stringBuffer.append(categoryNode.getTitle());
        JOptionPane.showMessageDialog(jTree, displayedProperties, stringBuffer.toString(), -1);
    }

    public CategoryNodeEditor(CategoryExplorerModel categoryExplorerModel) {
        CategoryNodeEditorRenderer categoryNodeEditorRenderer = new CategoryNodeEditorRenderer();
        this._renderer = categoryNodeEditorRenderer;
        JCheckBox checkBox = categoryNodeEditorRenderer.getCheckBox();
        this._checkBox = checkBox;
        this._categoryModel = categoryExplorerModel;
        checkBox.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.categoryexplorer.CategoryNodeEditor.1
            public void actionPerformed(ActionEvent actionEvent) throws Throwable {
                CategoryNodeEditor categoryNodeEditor = CategoryNodeEditor.this;
                categoryNodeEditor._categoryModel.update(categoryNodeEditor._lastEditedNode, categoryNodeEditor._checkBox.isSelected());
                CategoryNodeEditor.this.stopCellEditing();
            }
        });
        this._renderer.addMouseListener(new MouseAdapter() { // from class: org.apache.log4j.lf5.viewer.categoryexplorer.CategoryNodeEditor.2
            public void mousePressed(MouseEvent mouseEvent) throws Throwable {
                if ((mouseEvent.getModifiers() & 4) != 0) {
                    CategoryNodeEditor categoryNodeEditor = CategoryNodeEditor.this;
                    categoryNodeEditor.showPopup(categoryNodeEditor._lastEditedNode, mouseEvent.getX(), mouseEvent.getY());
                }
                CategoryNodeEditor.this.stopCellEditing();
            }
        });
    }

    protected void collapseDescendants(CategoryNode categoryNode) {
        Enumeration enumerationDepthFirstEnumeration = categoryNode.depthFirstEnumeration();
        while (enumerationDepthFirstEnumeration.hasMoreElements()) {
            collapse((CategoryNode) enumerationDepthFirstEnumeration.nextElement());
        }
    }

    protected void expandDescendants(CategoryNode categoryNode) {
        Enumeration enumerationDepthFirstEnumeration = categoryNode.depthFirstEnumeration();
        while (enumerationDepthFirstEnumeration.hasMoreElements()) {
            expand((CategoryNode) enumerationDepthFirstEnumeration.nextElement());
        }
    }
}
