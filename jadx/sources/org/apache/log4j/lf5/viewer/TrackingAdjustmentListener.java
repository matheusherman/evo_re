package org.apache.log4j.lf5.viewer;

import java.awt.Adjustable;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class TrackingAdjustmentListener implements AdjustmentListener {
    protected int _lastMaximum = -1;

    public void adjustmentValueChanged(AdjustmentEvent adjustmentEvent) {
        Adjustable adjustable = adjustmentEvent.getAdjustable();
        int maximum = adjustable.getMaximum();
        if (adjustable.getMaximum() == this._lastMaximum) {
            return;
        }
        if (adjustable.getValue() + adjustable.getVisibleAmount() + adjustable.getUnitIncrement() >= this._lastMaximum) {
            adjustable.setValue(adjustable.getMaximum());
        }
        this._lastMaximum = maximum;
    }
}
