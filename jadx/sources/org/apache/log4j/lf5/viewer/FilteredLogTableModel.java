package org.apache.log4j.lf5.viewer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.apache.log4j.lf5.LogRecord;
import org.apache.log4j.lf5.LogRecordFilter;
import org.apache.log4j.lf5.PassingLogRecordFilter;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class FilteredLogTableModel extends AbstractTableModel {
    protected List _filteredRecords;
    protected LogRecordFilter _filter = new PassingLogRecordFilter();
    protected List _allRecords = new ArrayList();
    protected int _maxNumberOfLogRecords = 5000;
    protected String[] _colNames = {"Date", "Thread", "Message #", "Level", "NDC", "Category", "Message", "Location", "Thrown"};

    public synchronized boolean addLogRecord(LogRecord logRecord) {
        this._allRecords.add(logRecord);
        if (!this._filter.passes(logRecord)) {
            return false;
        }
        getFilteredRecords().add(logRecord);
        fireTableRowsInserted(getRowCount(), getRowCount());
        trimRecords();
        return true;
    }

    public synchronized void clear() {
        this._allRecords.clear();
        this._filteredRecords.clear();
        fireTableDataChanged();
    }

    public synchronized void fastRefresh() {
        this._filteredRecords.remove(0);
        fireTableRowsDeleted(0, 0);
    }

    public synchronized void refresh() {
        this._filteredRecords = createFilteredRecordsList();
        fireTableDataChanged();
    }

    private int numberOfRecordsToTrim() {
        return this._allRecords.size() - this._maxNumberOfLogRecords;
    }

    protected List createFilteredRecordsList() {
        ArrayList arrayList = new ArrayList();
        for (LogRecord logRecord : this._allRecords) {
            if (this._filter.passes(logRecord)) {
                arrayList.add(logRecord);
            }
        }
        return arrayList;
    }

    protected Object getColumn(int i10, LogRecord logRecord) {
        if (logRecord == null) {
            return "NULL Column";
        }
        String string = new Date(logRecord.getMillis()).toString();
        switch (i10) {
            case 0:
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(string);
                stringBuffer.append(" (");
                stringBuffer.append(logRecord.getMillis());
                stringBuffer.append(")");
                return stringBuffer.toString();
            case 1:
                return logRecord.getThreadDescription();
            case 2:
                return new Long(logRecord.getSequenceNumber());
            case 3:
                return logRecord.getLevel();
            case 4:
                return logRecord.getNDC();
            case 5:
                return logRecord.getCategory();
            case 6:
                return logRecord.getMessage();
            case 7:
                return logRecord.getLocation();
            case 8:
                return logRecord.getThrownStackTrace();
            default:
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("The column number ");
                stringBuffer2.append(i10);
                stringBuffer2.append("must be between 0 and 8");
                throw new IllegalArgumentException(stringBuffer2.toString());
        }
    }

    public int getColumnCount() {
        return this._colNames.length;
    }

    public String getColumnName(int i10) {
        return this._colNames[i10];
    }

    protected List getFilteredRecords() {
        if (this._filteredRecords == null) {
            refresh();
        }
        return this._filteredRecords;
    }

    public LogRecordFilter getLogRecordFilter() {
        return this._filter;
    }

    public int getTotalRowCount() {
        return this._allRecords.size();
    }

    protected boolean needsTrimming() {
        return this._allRecords.size() > this._maxNumberOfLogRecords;
    }

    public void setLogRecordFilter(LogRecordFilter logRecordFilter) {
        this._filter = logRecordFilter;
    }

    public void setMaxNumberOfLogRecords(int i10) {
        if (i10 > 0) {
            this._maxNumberOfLogRecords = i10;
        }
    }

    protected void trimOldestRecords() {
        synchronized (this._allRecords) {
            try {
                int iNumberOfRecordsToTrim = numberOfRecordsToTrim();
                if (iNumberOfRecordsToTrim > 1) {
                    this._allRecords.subList(0, iNumberOfRecordsToTrim).clear();
                    refresh();
                } else {
                    this._allRecords.remove(0);
                    fastRefresh();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected LogRecord getFilteredRecord(int i10) {
        List filteredRecords = getFilteredRecords();
        int size = filteredRecords.size();
        if (i10 < size) {
            return (LogRecord) filteredRecords.get(i10);
        }
        return (LogRecord) filteredRecords.get(size - 1);
    }

    public int getRowCount() {
        return getFilteredRecords().size();
    }

    public Object getValueAt(int i10, int i11) {
        return getColumn(i11, getFilteredRecord(i10));
    }

    protected void trimRecords() {
        if (needsTrimming()) {
            trimOldestRecords();
        }
    }
}
