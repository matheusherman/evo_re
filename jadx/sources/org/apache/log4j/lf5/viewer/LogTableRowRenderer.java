package org.apache.log4j.lf5.viewer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import org.apache.log4j.lf5.LogLevel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class LogTableRowRenderer extends DefaultTableCellRenderer {
    private static final long serialVersionUID = -3951639953706443213L;
    protected boolean _highlightFatal = true;
    protected Color _color = new Color(230, 230, 230);

    public Component getTableCellRendererComponent(JTable jTable, Object obj, boolean z10, boolean z11, int i10, int i11) {
        if (i10 % 2 == 0) {
            setBackground(this._color);
        } else {
            setBackground(Color.white);
        }
        setForeground(getLogLevelColor(jTable.getModel().getFilteredRecord(i10).getLevel()));
        return super.getTableCellRendererComponent(jTable, obj, z10, z11, i10, i11);
    }

    protected Color getLogLevelColor(LogLevel logLevel) {
        return (Color) LogLevel.getLogLevelColorMap().get(logLevel);
    }
}
