package org.apache.log4j.lf5.viewer;

import java.awt.Adjustable;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class LF5SwingUtils {
    protected static boolean contains(int i10, TableModel tableModel) {
        return tableModel != null && i10 >= 0 && i10 < tableModel.getRowCount();
    }

    public static void selectRow(int i10, JTable jTable, JScrollPane jScrollPane) {
        if (jTable == null || jScrollPane == null || !contains(i10, jTable.getModel())) {
            return;
        }
        moveAdjustable(jTable.getRowHeight() * i10, jScrollPane.getVerticalScrollBar());
        selectRow(i10, jTable.getSelectionModel());
        repaintLater(jTable);
    }

    public static void makeScrollBarTrack(Adjustable adjustable) {
        if (adjustable == null) {
            return;
        }
        adjustable.addAdjustmentListener(new TrackingAdjustmentListener());
    }

    public static void makeVerticalScrollBarTrack(JScrollPane jScrollPane) {
        if (jScrollPane == null) {
            return;
        }
        makeScrollBarTrack(jScrollPane.getVerticalScrollBar());
    }

    protected static void moveAdjustable(int i10, Adjustable adjustable) {
        if (adjustable == null) {
            return;
        }
        adjustable.setValue(i10);
    }

    protected static void repaintLater(final JComponent jComponent) {
        SwingUtilities.invokeLater(new Runnable() { // from class: org.apache.log4j.lf5.viewer.LF5SwingUtils.1
            @Override // java.lang.Runnable
            public void run() {
                jComponent.repaint();
            }
        });
    }

    protected static void selectRow(int i10, ListSelectionModel listSelectionModel) {
        if (listSelectionModel == null) {
            return;
        }
        listSelectionModel.setSelectionInterval(i10, i10);
    }
}
