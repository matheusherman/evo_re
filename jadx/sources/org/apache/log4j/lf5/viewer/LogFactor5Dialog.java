package org.apache.log4j.lf5.viewer;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.JFrame;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public abstract class LogFactor5Dialog extends JDialog {
    protected static final Font DISPLAY_FONT = new Font("Arial", 1, 12);

    protected GridBagConstraints getDefaultConstraints() {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 1.0d;
        gridBagConstraints.weighty = 1.0d;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.insets = new Insets(4, 4, 4, 4);
        gridBagConstraints.fill = 0;
        gridBagConstraints.anchor = 17;
        return gridBagConstraints;
    }

    protected LogFactor5Dialog(JFrame jFrame, String str, boolean z10) {
        super(jFrame, str, z10);
    }

    protected void centerWindow(Window window) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        if (screenSize.width < window.getSize().width) {
            window.setSize(screenSize.width, window.getSize().height);
        }
        if (screenSize.height < window.getSize().height) {
            window.setSize(window.getSize().width, screenSize.height);
        }
        window.setLocation((screenSize.width - window.getSize().width) / 2, (screenSize.height - window.getSize().height) / 2);
    }

    protected void minimumSizeDialog(Component component, int i10, int i11) {
        if (component.getSize().width < i10) {
            component.setSize(i10, component.getSize().height);
        }
        if (component.getSize().height < i11) {
            component.setSize(component.getSize().width, i11);
        }
    }

    public void show() {
        pack();
        minimumSizeDialog(this, 200, 100);
        centerWindow(this);
        super.show();
    }

    protected void wrapStringOnPanel(String str, Container container) {
        String strSubstring;
        GridBagConstraints defaultConstraints = getDefaultConstraints();
        defaultConstraints.gridwidth = 0;
        defaultConstraints.insets = new Insets(0, 0, 0, 0);
        GridBagLayout layout = container.getLayout();
        while (str.length() > 0) {
            int iIndexOf = str.indexOf(10);
            if (iIndexOf >= 0) {
                String strSubstring2 = str.substring(0, iIndexOf);
                strSubstring = str.substring(iIndexOf + 1);
                str = strSubstring2;
            } else {
                strSubstring = "";
            }
            Label label = new Label(str);
            label.setFont(DISPLAY_FONT);
            layout.setConstraints(label, defaultConstraints);
            container.add(label);
            str = strSubstring;
        }
    }
}
