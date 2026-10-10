package org.apache.log4j.lf5.viewer.categoryexplorer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultTreeCellRenderer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class CategoryNodeRenderer extends DefaultTreeCellRenderer {
    public static final Color FATAL_CHILDREN = new Color(189, 113, 0);
    protected static ImageIcon _sat = null;
    private static final long serialVersionUID = -6046702673278595048L;
    protected JCheckBox _checkBox = new JCheckBox();
    protected JPanel _panel;

    public Component getTreeCellRendererComponent(JTree jTree, Object obj, boolean z10, boolean z11, boolean z12, int i10, boolean z13) {
        CategoryNode categoryNode = (CategoryNode) obj;
        super.getTreeCellRendererComponent(jTree, obj, z10, z11, z12, i10, z13);
        if (i10 == 0) {
            this._checkBox.setVisible(false);
        } else {
            this._checkBox.setVisible(true);
            this._checkBox.setSelected(categoryNode.isSelected());
        }
        this._panel.setToolTipText(buildToolTip(categoryNode));
        if (categoryNode.hasFatalChildren()) {
            setForeground(FATAL_CHILDREN);
        }
        if (categoryNode.hasFatalRecords()) {
            setForeground(Color.red);
        }
        return this._panel;
    }

    protected String buildToolTip(CategoryNode categoryNode) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(categoryNode.getTitle());
        stringBuffer.append(" contains a total of ");
        stringBuffer.append(categoryNode.getTotalNumberOfRecords());
        stringBuffer.append(" LogRecords.");
        stringBuffer.append(" Right-click for more info.");
        return stringBuffer.toString();
    }

    public Dimension getCheckBoxOffset() {
        return new Dimension(0, 0);
    }

    public CategoryNodeRenderer() {
        JPanel jPanel = new JPanel();
        this._panel = jPanel;
        jPanel.setBackground(UIManager.getColor("Tree.textBackground"));
        if (_sat == null) {
            _sat = new ImageIcon(getClass().getResource("/org/apache/log4j/lf5/viewer/images/channelexplorer_satellite.gif"));
        }
        setOpaque(false);
        this._checkBox.setOpaque(false);
        this._panel.setOpaque(false);
        this._panel.setLayout(new FlowLayout(0, 0, 0));
        this._panel.add(this._checkBox);
        this._panel.add(this);
        setOpenIcon(_sat);
        setClosedIcon(_sat);
        setLeafIcon(_sat);
    }
}
