package io.netty.channel.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class SelectedSelectionKeySetSelector extends Selector {
    private final Selector delegate;
    private final SelectedSelectionKeySet selectionKeys;

    @Override // java.nio.channels.Selector
    public int select(long j10) {
        this.selectionKeys.reset();
        return this.delegate.select(j10);
    }

    @Override // java.nio.channels.Selector, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // java.nio.channels.Selector
    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    @Override // java.nio.channels.Selector
    public Set<SelectionKey> keys() {
        return this.delegate.keys();
    }

    @Override // java.nio.channels.Selector
    public SelectorProvider provider() {
        return this.delegate.provider();
    }

    @Override // java.nio.channels.Selector
    public int selectNow() {
        this.selectionKeys.reset();
        return this.delegate.selectNow();
    }

    @Override // java.nio.channels.Selector
    public Set<SelectionKey> selectedKeys() {
        return this.delegate.selectedKeys();
    }

    @Override // java.nio.channels.Selector
    public Selector wakeup() {
        return this.delegate.wakeup();
    }

    SelectedSelectionKeySetSelector(Selector selector, SelectedSelectionKeySet selectedSelectionKeySet) {
        this.delegate = selector;
        this.selectionKeys = selectedSelectionKeySet;
    }

    @Override // java.nio.channels.Selector
    public int select() {
        this.selectionKeys.reset();
        return this.delegate.select();
    }
}
