package org.apache.log4j.lf5.viewer.categoryexplorer;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.EventListenerList;
import javax.swing.table.TableCellEditor;
import javax.swing.tree.TreeCellEditor;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class CategoryAbstractCellEditor implements TableCellEditor, TreeCellEditor {
    static /* synthetic */ Class class$javax$swing$event$CellEditorListener;
    protected Object _value;
    protected EventListenerList _listenerList = new EventListenerList();
    protected ChangeEvent _changeEvent = null;
    protected int _clickCountToStart = 1;

    public Component getTableCellEditorComponent(JTable jTable, Object obj, boolean z10, int i10, int i11) {
        return null;
    }

    public Component getTreeCellEditorComponent(JTree jTree, Object obj, boolean z10, boolean z11, boolean z12, int i10) {
        return null;
    }

    public boolean isCellEditable(EventObject eventObject) {
        return true;
    }

    public void addCellEditorListener(CellEditorListener cellEditorListener) throws Throwable {
        EventListenerList eventListenerList = this._listenerList;
        Class clsClass$ = class$javax$swing$event$CellEditorListener;
        if (clsClass$ == null) {
            clsClass$ = class$("javax.swing.event.CellEditorListener");
            class$javax$swing$event$CellEditorListener = clsClass$;
        }
        eventListenerList.add(clsClass$, cellEditorListener);
    }

    protected void fireEditingCanceled() throws Throwable {
        Object[] listenerList = this._listenerList.getListenerList();
        for (int length = listenerList.length - 2; length >= 0; length -= 2) {
            Object obj = listenerList[length];
            Class clsClass$ = class$javax$swing$event$CellEditorListener;
            if (clsClass$ == null) {
                clsClass$ = class$("javax.swing.event.CellEditorListener");
                class$javax$swing$event$CellEditorListener = clsClass$;
            }
            if (obj == clsClass$) {
                if (this._changeEvent == null) {
                    this._changeEvent = new ChangeEvent(this);
                }
                ((CellEditorListener) listenerList[length + 1]).editingCanceled(this._changeEvent);
            }
        }
    }

    protected void fireEditingStopped() throws Throwable {
        Object[] listenerList = this._listenerList.getListenerList();
        for (int length = listenerList.length - 2; length >= 0; length -= 2) {
            Object obj = listenerList[length];
            Class clsClass$ = class$javax$swing$event$CellEditorListener;
            if (clsClass$ == null) {
                clsClass$ = class$("javax.swing.event.CellEditorListener");
                class$javax$swing$event$CellEditorListener = clsClass$;
            }
            if (obj == clsClass$) {
                if (this._changeEvent == null) {
                    this._changeEvent = new ChangeEvent(this);
                }
                ((CellEditorListener) listenerList[length + 1]).editingStopped(this._changeEvent);
            }
        }
    }

    public Object getCellEditorValue() {
        return this._value;
    }

    public int getClickCountToStart() {
        return this._clickCountToStart;
    }

    public void removeCellEditorListener(CellEditorListener cellEditorListener) throws Throwable {
        EventListenerList eventListenerList = this._listenerList;
        Class clsClass$ = class$javax$swing$event$CellEditorListener;
        if (clsClass$ == null) {
            clsClass$ = class$("javax.swing.event.CellEditorListener");
            class$javax$swing$event$CellEditorListener = clsClass$;
        }
        eventListenerList.remove(clsClass$, cellEditorListener);
    }

    public void setCellEditorValue(Object obj) {
        this._value = obj;
    }

    public void setClickCountToStart(int i10) {
        this._clickCountToStart = i10;
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    public void cancelCellEditing() throws Throwable {
        fireEditingCanceled();
    }

    public boolean shouldSelectCell(EventObject eventObject) {
        if (isCellEditable(eventObject)) {
            if (eventObject == null || ((MouseEvent) eventObject).getClickCount() >= this._clickCountToStart) {
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean stopCellEditing() throws Throwable {
        fireEditingStopped();
        return true;
    }
}
