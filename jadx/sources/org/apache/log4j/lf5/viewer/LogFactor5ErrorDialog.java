package org.apache.log4j.lf5.viewer;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class LogFactor5ErrorDialog extends LogFactor5Dialog {
    public LogFactor5ErrorDialog(JFrame jFrame, String str) {
        super(jFrame, "Error", true);
        JButton jButton = new JButton("Ok");
        jButton.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogFactor5ErrorDialog.1
            public void actionPerformed(ActionEvent actionEvent) {
                LogFactor5ErrorDialog.this.hide();
            }
        });
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.add(jButton);
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new GridBagLayout());
        wrapStringOnPanel(str, jPanel2);
        getContentPane().add(jPanel2, "Center");
        getContentPane().add(jPanel, "South");
        show();
    }
}
