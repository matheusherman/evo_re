package org.apache.log4j.lf5.viewer;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class LogFactor5InputDialog extends LogFactor5Dialog {
    public static final int SIZE = 30;
    private JTextField _textField;

    public LogFactor5InputDialog(JFrame jFrame, String str, String str2) {
        this(jFrame, str, str2, 30);
    }

    public LogFactor5InputDialog(JFrame jFrame, String str, String str2, int i10) {
        super(jFrame, str, true);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new FlowLayout());
        jPanel2.add(new JLabel(str2));
        JTextField jTextField = new JTextField(i10);
        this._textField = jTextField;
        jPanel2.add(jTextField);
        addKeyListener(new KeyAdapter() { // from class: org.apache.log4j.lf5.viewer.LogFactor5InputDialog.1
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == 10) {
                    LogFactor5InputDialog.this.hide();
                }
            }
        });
        JButton jButton = new JButton("Ok");
        jButton.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogFactor5InputDialog.2
            public void actionPerformed(ActionEvent actionEvent) {
                LogFactor5InputDialog.this.hide();
            }
        });
        JButton jButton2 = new JButton("Cancel");
        jButton2.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogFactor5InputDialog.3
            public void actionPerformed(ActionEvent actionEvent) {
                LogFactor5InputDialog.this.hide();
                LogFactor5InputDialog.this._textField.setText("");
            }
        });
        jPanel.add(jButton);
        jPanel.add(jButton2);
        getContentPane().add(jPanel2, "Center");
        getContentPane().add(jPanel, "South");
        pack();
        centerWindow(this);
        show();
    }

    public String getText() {
        String text = this._textField.getText();
        if (text == null || text.trim().length() != 0) {
            return text;
        }
        return null;
    }
}
