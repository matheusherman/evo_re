package org.apache.log4j.chainsaw;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.swing.table.AbstractTableModel;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class MyTableModel extends AbstractTableModel {
    private static final String[] COL_NAMES;
    private static final DateFormat DATE_FORMATTER;
    private static final EventDetails[] EMPTY_LIST;
    private static final Logger LOG;
    private static final Comparator MY_COMP;
    static /* synthetic */ Class class$java$lang$Boolean;
    static /* synthetic */ Class class$java$lang$Object;
    static /* synthetic */ Class class$org$apache$log4j$chainsaw$MyTableModel;
    private final Object mLock = new Object();
    private final SortedSet mAllEvents = new TreeSet(MY_COMP);
    private EventDetails[] mFilteredEvents = EMPTY_LIST;
    private final List mPendingEvents = new ArrayList();
    private boolean mPaused = false;
    private String mThreadFilter = "";
    private String mMessageFilter = "";
    private String mNDCFilter = "";
    private String mCategoryFilter = "";
    private Priority mPriorityFilter = Priority.DEBUG;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class Processor implements Runnable {
        private Processor() {
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x0016 */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                }
                synchronized (MyTableModel.this.mLock) {
                    if (!MyTableModel.this.mPaused) {
                        boolean z10 = false;
                        boolean z11 = true;
                        for (EventDetails eventDetails : MyTableModel.this.mPendingEvents) {
                            MyTableModel.this.mAllEvents.add(eventDetails);
                            z11 = z11 && eventDetails == MyTableModel.this.mAllEvents.first();
                            z10 = z10 || MyTableModel.this.matchFilter(eventDetails);
                        }
                        MyTableModel.this.mPendingEvents.clear();
                        if (z10) {
                            MyTableModel.this.updateFilteredEvents(z11);
                        }
                    }
                }
            }
        }
    }

    public Class getColumnClass(int i10) throws Throwable {
        if (i10 == 2) {
            Class cls = class$java$lang$Boolean;
            if (cls != null) {
                return cls;
            }
            Class clsClass$ = class$("java.lang.Boolean");
            class$java$lang$Boolean = clsClass$;
            return clsClass$;
        }
        Class cls2 = class$java$lang$Object;
        if (cls2 != null) {
            return cls2;
        }
        Class clsClass$2 = class$("java.lang.Object");
        class$java$lang$Object = clsClass$2;
        return clsClass$2;
    }

    static {
        Class clsClass$ = class$org$apache$log4j$chainsaw$MyTableModel;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.chainsaw.MyTableModel");
            class$org$apache$log4j$chainsaw$MyTableModel = clsClass$;
        }
        LOG = Logger.getLogger(clsClass$);
        MY_COMP = new Comparator() { // from class: org.apache.log4j.chainsaw.MyTableModel.1
            @Override // java.util.Comparator
            public int compare(Object obj, Object obj2) {
                if (obj == null && obj2 == null) {
                    return 0;
                }
                if (obj == null) {
                    return -1;
                }
                return (obj2 != null && ((EventDetails) obj).getTimeStamp() >= ((EventDetails) obj2).getTimeStamp()) ? -1 : 1;
            }
        };
        COL_NAMES = new String[]{"Time", "Priority", "Trace", "Category", "NDC", "Message"};
        EMPTY_LIST = new EventDetails[0];
        DATE_FORMATTER = DateFormat.getDateTimeInstance(3, 2);
    }

    public void addEvent(EventDetails eventDetails) {
        synchronized (this.mLock) {
            this.mPendingEvents.add(eventDetails);
        }
    }

    public void clear() {
        synchronized (this.mLock) {
            this.mAllEvents.clear();
            this.mFilteredEvents = new EventDetails[0];
            this.mPendingEvents.clear();
            fireTableDataChanged();
        }
    }

    public int getColumnCount() {
        return COL_NAMES.length;
    }

    public String getColumnName(int i10) {
        return COL_NAMES[i10];
    }

    public EventDetails getEventDetails(int i10) {
        EventDetails eventDetails;
        synchronized (this.mLock) {
            eventDetails = this.mFilteredEvents[i10];
        }
        return eventDetails;
    }

    public int getRowCount() {
        int length;
        synchronized (this.mLock) {
            length = this.mFilteredEvents.length;
        }
        return length;
    }

    public Object getValueAt(int i10, int i11) {
        synchronized (this.mLock) {
            try {
                EventDetails eventDetails = this.mFilteredEvents[i10];
                if (i11 == 0) {
                    return DATE_FORMATTER.format(new Date(eventDetails.getTimeStamp()));
                }
                if (i11 == 1) {
                    return eventDetails.getPriority();
                }
                if (i11 == 2) {
                    return eventDetails.getThrowableStrRep() == null ? Boolean.FALSE : Boolean.TRUE;
                }
                if (i11 == 3) {
                    return eventDetails.getCategoryName();
                }
                if (i11 == 4) {
                    return eventDetails.getNDC();
                }
                return eventDetails.getMessage();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean isPaused() {
        boolean z10;
        synchronized (this.mLock) {
            z10 = this.mPaused;
        }
        return z10;
    }

    public void setCategoryFilter(String str) {
        synchronized (this.mLock) {
            this.mCategoryFilter = str.trim();
            updateFilteredEvents(false);
        }
    }

    public void setMessageFilter(String str) {
        synchronized (this.mLock) {
            this.mMessageFilter = str.trim();
            updateFilteredEvents(false);
        }
    }

    public void setNDCFilter(String str) {
        synchronized (this.mLock) {
            this.mNDCFilter = str.trim();
            updateFilteredEvents(false);
        }
    }

    public void setPriorityFilter(Priority priority) {
        synchronized (this.mLock) {
            this.mPriorityFilter = priority;
            updateFilteredEvents(false);
        }
    }

    public void setThreadFilter(String str) {
        synchronized (this.mLock) {
            this.mThreadFilter = str.trim();
            updateFilteredEvents(false);
        }
    }

    public void toggle() {
        synchronized (this.mLock) {
            this.mPaused = !this.mPaused;
        }
    }

    MyTableModel() {
        Thread thread = new Thread(new Processor());
        thread.setDaemon(true);
        thread.start();
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean matchFilter(EventDetails eventDetails) {
        if (eventDetails.getPriority().isGreaterOrEqual(this.mPriorityFilter) && eventDetails.getThreadName().indexOf(this.mThreadFilter) >= 0 && eventDetails.getCategoryName().indexOf(this.mCategoryFilter) >= 0 && (this.mNDCFilter.length() == 0 || (eventDetails.getNDC() != null && eventDetails.getNDC().indexOf(this.mNDCFilter) >= 0))) {
            String message = eventDetails.getMessage();
            if (message == null) {
                if (this.mMessageFilter.length() != 0) {
                    return false;
                }
                return true;
            }
            if (message.indexOf(this.mMessageFilter) >= 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFilteredEvents(boolean z10) {
        EventDetails eventDetails;
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        int size = this.mAllEvents.size();
        for (EventDetails eventDetails2 : this.mAllEvents) {
            if (matchFilter(eventDetails2)) {
                arrayList.add(eventDetails2);
            }
        }
        EventDetails[] eventDetailsArr = this.mFilteredEvents;
        if (eventDetailsArr.length == 0) {
            eventDetails = null;
        } else {
            eventDetails = eventDetailsArr[0];
        }
        this.mFilteredEvents = (EventDetails[]) arrayList.toArray(EMPTY_LIST);
        if (z10 && eventDetails != null) {
            int iIndexOf = arrayList.indexOf(eventDetails);
            if (iIndexOf < 1) {
                LOG.warn("In strange state");
                fireTableDataChanged();
            } else {
                fireTableRowsInserted(0, iIndexOf - 1);
            }
        } else {
            fireTableDataChanged();
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        Logger logger = LOG;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Total time [ms]: ");
        stringBuffer.append(jCurrentTimeMillis2 - jCurrentTimeMillis);
        stringBuffer.append(" in update, size: ");
        stringBuffer.append(size);
        logger.debug(stringBuffer.toString());
    }
}
