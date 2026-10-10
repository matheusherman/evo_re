package org.apache.log4j.lf5.viewer;

import java.awt.Font;
import java.awt.Graphics;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.apache.log4j.lf5.util.DateFormatManager;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class LogTable extends JTable {
    private static final long serialVersionUID = 4867085140195148458L;
    protected JTextArea _detailTextArea;
    protected int _rowHeight = 30;
    protected int _numCols = 9;
    protected TableColumn[] _tableColumns = new TableColumn[9];
    protected int[] _colWidths = {40, 40, 40, 70, 70, 360, 440, 200, 60};
    protected LogTableColumn[] _colNames = LogTableColumn.getLogTableColumnArray();
    protected int _colDate = 0;
    protected int _colThread = 1;
    protected int _colMessageNum = 2;
    protected int _colLevel = 3;
    protected int _colNDC = 4;
    protected int _colCategory = 5;
    protected int _colMessage = 6;
    protected int _colLocation = 7;
    protected int _colThrown = 8;
    protected DateFormatManager _dateFormatManager = null;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class LogTableListSelectionListener implements ListSelectionListener {
        protected JTable _table;

        public LogTableListSelectionListener(JTable jTable) {
            this._table = jTable;
        }

        public void valueChanged(ListSelectionEvent listSelectionEvent) {
            String string;
            if (!listSelectionEvent.getValueIsAdjusting()) {
                ListSelectionModel listSelectionModel = (ListSelectionModel) listSelectionEvent.getSource();
                if (listSelectionModel.isSelectionEmpty()) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                int minSelectionIndex = listSelectionModel.getMinSelectionIndex();
                for (int i10 = 0; i10 < LogTable.this._numCols - 1; i10++) {
                    Object valueAt = this._table.getModel().getValueAt(minSelectionIndex, i10);
                    if (valueAt != null) {
                        string = valueAt.toString();
                    } else {
                        string = "";
                    }
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(LogTable.this._colNames[i10]);
                    stringBuffer2.append(":");
                    stringBuffer.append(stringBuffer2.toString());
                    stringBuffer.append("\t");
                    LogTable logTable = LogTable.this;
                    if (i10 == logTable._colThread || i10 == logTable._colMessage || i10 == logTable._colLevel) {
                        stringBuffer.append("\t");
                    }
                    LogTable logTable2 = LogTable.this;
                    if (i10 == logTable2._colDate || i10 == logTable2._colNDC) {
                        stringBuffer.append("\t\t");
                    }
                    stringBuffer.append(string);
                    stringBuffer.append("\n");
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                LogTable logTable3 = LogTable.this;
                stringBuffer3.append(logTable3._colNames[logTable3._numCols - 1]);
                stringBuffer3.append(":\n");
                stringBuffer.append(stringBuffer3.toString());
                Object valueAt2 = this._table.getModel().getValueAt(minSelectionIndex, LogTable.this._numCols - 1);
                if (valueAt2 != null) {
                    stringBuffer.append(valueAt2.toString());
                }
                LogTable.this._detailTextArea.setText(stringBuffer.toString());
            }
        }
    }

    public synchronized void clearLogRecords() {
        getFilteredLogTableModel().clear();
    }

    protected Vector getColumnNameAndNumber() {
        Vector vector = new Vector();
        int i10 = 0;
        while (true) {
            LogTableColumn[] logTableColumnArr = this._colNames;
            if (i10 >= logTableColumnArr.length) {
                return vector;
            }
            vector.add(i10, logTableColumnArr[i10]);
            i10++;
        }
    }

    public DateFormatManager getDateFormatManager() {
        return this._dateFormatManager;
    }

    protected void init() {
        setRowHeight(this._rowHeight);
        setSelectionMode(0);
    }

    public void setDateFormatManager(DateFormatManager dateFormatManager) {
        this._dateFormatManager = dateFormatManager;
    }

    public LogTable(JTextArea jTextArea) {
        int i10 = 0;
        init();
        this._detailTextArea = jTextArea;
        setModel(new FilteredLogTableModel());
        Enumeration columns = getColumnModel().getColumns();
        while (columns.hasMoreElements()) {
            TableColumn tableColumn = (TableColumn) columns.nextElement();
            tableColumn.setCellRenderer(new LogTableRowRenderer());
            tableColumn.setPreferredWidth(this._colWidths[i10]);
            this._tableColumns[i10] = tableColumn;
            i10++;
        }
        getSelectionModel().addListSelectionListener(new LogTableListSelectionListener(this));
    }

    public FilteredLogTableModel getFilteredLogTableModel() {
        return getModel();
    }

    public void setDetailedView() {
        TableColumnModel columnModel = getColumnModel();
        for (int i10 = 0; i10 < this._numCols; i10++) {
            columnModel.removeColumn(this._tableColumns[i10]);
        }
        for (int i11 = 0; i11 < this._numCols; i11++) {
            columnModel.addColumn(this._tableColumns[i11]);
        }
        sizeColumnsToFit(-1);
    }

    public void setFont(Font font) {
        super.setFont(font);
        Graphics graphics = getGraphics();
        if (graphics != null) {
            int height = graphics.getFontMetrics(font).getHeight();
            int i10 = height + (height / 3);
            this._rowHeight = i10;
            setRowHeight(i10);
        }
    }

    public void setView(List list) {
        TableColumnModel columnModel = getColumnModel();
        for (int i10 = 0; i10 < this._numCols; i10++) {
            columnModel.removeColumn(this._tableColumns[i10]);
        }
        Iterator it = list.iterator();
        Vector columnNameAndNumber = getColumnNameAndNumber();
        while (it.hasNext()) {
            columnModel.addColumn(this._tableColumns[columnNameAndNumber.indexOf(it.next())]);
        }
        sizeColumnsToFit(-1);
    }
}
