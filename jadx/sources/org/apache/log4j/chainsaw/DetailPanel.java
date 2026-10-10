package org.apache.log4j.chainsaw;

import com.pengrad.telegrambot.model.request.InlineQueryResultVideo;
import java.awt.BorderLayout;
import java.text.MessageFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.apache.log4j.Logger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class DetailPanel extends JPanel implements ListSelectionListener {
    private static final MessageFormat FORMATTER;
    private static final Logger LOG;
    static /* synthetic */ Class class$org$apache$log4j$chainsaw$DetailPanel;
    private final JEditorPane mDetails;
    private final MyTableModel mModel;

    static {
        Class clsClass$ = class$org$apache$log4j$chainsaw$DetailPanel;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.chainsaw.DetailPanel");
            class$org$apache$log4j$chainsaw$DetailPanel = clsClass$;
        }
        LOG = Logger.getLogger(clsClass$);
        FORMATTER = new MessageFormat("<b>Time:</b> <code>{0,time,medium}</code>&nbsp;&nbsp;<b>Priority:</b> <code>{1}</code>&nbsp;&nbsp;<b>Thread:</b> <code>{2}</code>&nbsp;&nbsp;<b>NDC:</b> <code>{3}</code><br><b>Logger:</b> <code>{4}</code><br><b>Location:</b> <code>{5}</code><br><b>Message:</b><pre>{6}</pre><b>Throwable:</b><pre>{7}</pre>");
    }

    private String escape(String str) {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\"') {
                stringBuffer.append("&quot;");
            } else if (cCharAt == '&') {
                stringBuffer.append("&amp;");
            } else if (cCharAt == '<') {
                stringBuffer.append("&lt;");
            } else if (cCharAt != '>') {
                stringBuffer.append(cCharAt);
            } else {
                stringBuffer.append("&gt;");
            }
        }
        return stringBuffer.toString();
    }

    DetailPanel(JTable jTable, MyTableModel myTableModel) {
        this.mModel = myTableModel;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Details: "));
        JEditorPane jEditorPane = new JEditorPane();
        this.mDetails = jEditorPane;
        jEditorPane.setEditable(false);
        jEditorPane.setContentType(InlineQueryResultVideo.MIME_TEXT_HTML);
        add(new JScrollPane(jEditorPane), "Center");
        jTable.getSelectionModel().addListSelectionListener(this);
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    private static String getThrowableStrRep(EventDetails eventDetails) {
        String[] throwableStrRep = eventDetails.getThrowableStrRep();
        if (throwableStrRep == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : throwableStrRep) {
            stringBuffer.append(str);
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        if (listSelectionEvent.getValueIsAdjusting()) {
            return;
        }
        ListSelectionModel listSelectionModel = (ListSelectionModel) listSelectionEvent.getSource();
        if (listSelectionModel.isSelectionEmpty()) {
            this.mDetails.setText("Nothing selected");
            return;
        }
        EventDetails eventDetails = this.mModel.getEventDetails(listSelectionModel.getMinSelectionIndex());
        this.mDetails.setText(FORMATTER.format(new Object[]{new Date(eventDetails.getTimeStamp()), eventDetails.getPriority(), escape(eventDetails.getThreadName()), escape(eventDetails.getNDC()), escape(eventDetails.getCategoryName()), escape(eventDetails.getLocationDetails()), escape(eventDetails.getMessage()), escape(getThrowableStrRep(eventDetails))}));
        this.mDetails.setCaretPosition(0);
    }
}
