package com.live.evo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.leanback.widget.BaseGridView;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.OnChildViewHolderSelectedListener;
import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ProgramRecycleView extends VerticalGridView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    OnChildViewHolderSelectedListener f7519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f7520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RecyclerView.ViewHolder f7521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ItemBridgeAdapter.AdapterListener f7522d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements BaseGridView.OnKeyInterceptListener {
        a() {
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0038  */
        /* JADX WARN: Code duplicated, block: B:22:0x004b  */
        /* JADX WARN: Code duplicated, block: B:24:0x0051  */
        /* JADX WARN: Code duplicated, block: B:26:0x0059  */
        @Override // androidx.leanback.widget.BaseGridView.OnKeyInterceptListener
        public boolean onInterceptKeyEvent(KeyEvent keyEvent) {
            if (!ProgramRecycleView.this.f7520b && keyEvent.getAction() == 0 && ProgramRecycleView.this.getAdapter() != null && ProgramRecycleView.this.getAdapter().getItemCount() > 0) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 19) {
                    if (ProgramRecycleView.this.getSelectedPosition() == 0) {
                        ProgramRecycleView programRecycleView = ProgramRecycleView.this;
                        programRecycleView.setSelectedPosition(programRecycleView.getAdapter().getItemCount() - 1);
                        return true;
                    }
                } else if (keyCode == 20) {
                    if (ProgramRecycleView.this.getSelectedPosition() == ProgramRecycleView.this.getAdapter().getItemCount() - 1) {
                        ProgramRecycleView.this.setSelectedPosition(0);
                        return true;
                    }
                } else if (keyCode != 92) {
                    if (keyCode == 93) {
                        if (ProgramRecycleView.this.getSelectedPosition() == ProgramRecycleView.this.getAdapter().getItemCount() - 1) {
                            ProgramRecycleView.this.setSelectedPosition(0);
                            return true;
                        }
                    }
                } else if (ProgramRecycleView.this.getSelectedPosition() == 0) {
                    ProgramRecycleView programRecycleView2 = ProgramRecycleView.this;
                    programRecycleView2.setSelectedPosition(programRecycleView2.getAdapter().getItemCount() - 1);
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b extends OnChildViewHolderSelectedListener {
        b() {
        }

        @Override // androidx.leanback.widget.OnChildViewHolderSelectedListener
        public void onChildViewHolderSelected(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i10, int i11) {
            super.onChildViewHolderSelected(recyclerView, viewHolder, i10, i11);
            if (ProgramRecycleView.this.f7521c != null && ProgramRecycleView.this.f7521c.itemView != null) {
                ProgramRecycleView.this.f7521c.itemView.setSelected(false);
            }
            ProgramRecycleView.this.f7521c = viewHolder;
            if (ProgramRecycleView.this.f7521c != null && ProgramRecycleView.this.f7521c.itemView != null) {
                ProgramRecycleView.this.f7521c.itemView.setSelected(true);
            }
            OnChildViewHolderSelectedListener onChildViewHolderSelectedListener = ProgramRecycleView.this.f7519a;
            if (onChildViewHolderSelectedListener != null) {
                onChildViewHolderSelectedListener.onChildViewHolderSelected(recyclerView, viewHolder, i10, i11);
            }
        }

        @Override // androidx.leanback.widget.OnChildViewHolderSelectedListener
        public void onChildViewHolderSelectedAndPositioned(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i10, int i11) {
            super.onChildViewHolderSelectedAndPositioned(recyclerView, viewHolder, i10, i11);
            OnChildViewHolderSelectedListener onChildViewHolderSelectedListener = ProgramRecycleView.this.f7519a;
            if (onChildViewHolderSelectedListener != null) {
                onChildViewHolderSelectedListener.onChildViewHolderSelectedAndPositioned(recyclerView, viewHolder, i10, i11);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c extends ItemBridgeAdapter.AdapterListener {

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ItemBridgeAdapter.ViewHolder f7526a;

            a(ItemBridgeAdapter.ViewHolder viewHolder) {
                this.f7526a = viewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ProgramRecycleView.this.getClass();
            }
        }

        c() {
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
        public void onBind(ItemBridgeAdapter.ViewHolder viewHolder) {
            super.onBind(viewHolder);
            viewHolder.itemView.setOnClickListener(new a(viewHolder));
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
        public void onUnbind(ItemBridgeAdapter.ViewHolder viewHolder) {
            super.onUnbind(viewHolder);
            viewHolder.itemView.setOnClickListener(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface d<T> {
    }

    public ProgramRecycleView(Context context) {
        this(context, null);
    }

    public ProgramRecycleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setOnItemSelectListener(OnChildViewHolderSelectedListener onChildViewHolderSelectedListener) {
        this.f7519a = onChildViewHolderSelectedListener;
    }

    public ProgramRecycleView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f7522d = new c();
        setOnKeyInterceptListener(new a());
        setOnChildViewHolderSelectedListener(new b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
        if (adapter instanceof ItemBridgeAdapter) {
            ((ItemBridgeAdapter) adapter).setAdapterListener(this.f7522d);
        }
    }

    public void setOnItemClickListener(d dVar) {
    }
}
