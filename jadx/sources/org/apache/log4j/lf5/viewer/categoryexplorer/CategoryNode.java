package org.apache.log4j.lf5.viewer.categoryexplorer;

import java.util.Enumeration;
import javax.swing.tree.DefaultMutableTreeNode;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class CategoryNode extends DefaultMutableTreeNode {
    private static final long serialVersionUID = 5958994817693177319L;
    protected boolean _selected = true;
    protected int _numberOfContainedRecords = 0;
    protected int _numberOfRecordsFromChildren = 0;
    protected boolean _hasFatalChildren = false;
    protected boolean _hasFatalRecords = false;

    public void resetNumberOfContainedRecords() {
        this._numberOfContainedRecords = 0;
        this._numberOfRecordsFromChildren = 0;
        this._hasFatalRecords = false;
        this._hasFatalChildren = false;
    }

    public void addRecord() {
        this._numberOfContainedRecords++;
        addRecordToParent();
    }

    protected void addRecordFromChild() {
        this._numberOfRecordsFromChildren++;
        addRecordToParent();
    }

    public boolean equals(Object obj) {
        return (obj instanceof CategoryNode) && getTitle().toLowerCase().equals(((CategoryNode) obj).getTitle().toLowerCase());
    }

    public int getNumberOfContainedRecords() {
        return this._numberOfContainedRecords;
    }

    protected int getNumberOfRecordsFromChildren() {
        return this._numberOfRecordsFromChildren;
    }

    public boolean hasFatalChildren() {
        return this._hasFatalChildren;
    }

    public boolean hasFatalRecords() {
        return this._hasFatalRecords;
    }

    public boolean isSelected() {
        return this._selected;
    }

    public void setHasFatalChildren(boolean z10) {
        this._hasFatalChildren = z10;
    }

    public void setHasFatalRecords(boolean z10) {
        this._hasFatalRecords = z10;
    }

    public void setSelected(boolean z10) {
        if (z10 != this._selected) {
            this._selected = z10;
        }
    }

    public CategoryNode(String str) {
        setUserObject(str);
    }

    protected void addRecordToParent() {
        CategoryNode parent = getParent();
        if (parent == null) {
            return;
        }
        parent.addRecordFromChild();
    }

    public String getTitle() {
        return (String) getUserObject();
    }

    protected int getTotalNumberOfRecords() {
        return getNumberOfRecordsFromChildren() + getNumberOfContainedRecords();
    }

    public int hashCode() {
        return getTitle().hashCode();
    }

    public void setAllDescendantsDeSelected() {
        Enumeration enumerationChildren = children();
        while (enumerationChildren.hasMoreElements()) {
            CategoryNode categoryNode = (CategoryNode) enumerationChildren.nextElement();
            categoryNode.setSelected(false);
            categoryNode.setAllDescendantsDeSelected();
        }
    }

    public void setAllDescendantsSelected() {
        Enumeration enumerationChildren = children();
        while (enumerationChildren.hasMoreElements()) {
            CategoryNode categoryNode = (CategoryNode) enumerationChildren.nextElement();
            categoryNode.setSelected(true);
            categoryNode.setAllDescendantsSelected();
        }
    }

    public String toString() {
        return getTitle();
    }
}
