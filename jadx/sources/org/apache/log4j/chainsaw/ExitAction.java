package org.apache.log4j.chainsaw;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.apache.log4j.Logger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class ExitAction extends AbstractAction {
    public static final ExitAction INSTANCE;
    private static final Logger LOG;
    static /* synthetic */ Class class$org$apache$log4j$chainsaw$ExitAction;

    static {
        Class clsClass$ = class$org$apache$log4j$chainsaw$ExitAction;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.chainsaw.ExitAction");
            class$org$apache$log4j$chainsaw$ExitAction = clsClass$;
        }
        LOG = Logger.getLogger(clsClass$);
        INSTANCE = new ExitAction();
    }

    public void actionPerformed(ActionEvent actionEvent) {
        LOG.info("shutting down");
        System.exit(0);
    }

    private ExitAction() {
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }
}
