package n5;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class a<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<T> f15949a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f15950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f15951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected e f15952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected g f15953e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected f f15954f;

    /* JADX INFO: renamed from: n5.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class ViewOnClickListenerC0309a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f15955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f15956b;

        ViewOnClickListenerC0309a(int i10, Object obj) {
            this.f15955a = i10;
            this.f15956b = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f15952d.a(this.f15955a, this.f15956b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements View.OnKeyListener {
        b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            return a.this.f15954f.v(view, i10, keyEvent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c extends GridLayoutManager.SpanSizeLookup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ GridLayoutManager f15959a;

        c(GridLayoutManager gridLayoutManager) {
            this.f15959a = gridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i10) {
            if (a.this.getItemViewType(i10) == 0) {
                return this.f15959a.getSpanCount();
            }
            return 1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface e<T> {
        void a(int i10, T t10);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface f {
        boolean v(View view, int i10, KeyEvent keyEvent);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface g {
        void a(View view, int i10);
    }

    public abstract void c(RecyclerView.ViewHolder viewHolder, int i10, T t10);

    public abstract RecyclerView.ViewHolder d(ViewGroup viewGroup, int i10);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public class d extends RecyclerView.ViewHolder {
        public d(a aVar, View view) {
            super(view);
        }
    }

    public void a(List<T> list) {
        List<T> list2 = this.f15949a;
        if (list2 != null) {
            list2.clear();
        }
        if (list != null) {
            this.f15949a.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void e(e eVar) {
        this.f15952d = eVar;
    }

    public void f(f fVar) {
        this.f15954f = fVar;
    }

    public void g(g gVar) {
        this.f15953e = gVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f15950b == null ? this.f15949a.size() : this.f15949a.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        return (this.f15950b != null && i10 == 0) ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return (this.f15950b == null || i10 != 0) ? d(viewGroup, i10) : new d(this, this.f15950b);
    }

    public int b(RecyclerView.ViewHolder viewHolder) {
        int layoutPosition = viewHolder.getLayoutPosition();
        if (this.f15950b == null) {
            return layoutPosition;
        }
        return layoutPosition - 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new c(gridLayoutManager));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        if (getItemViewType(i10) != 0) {
            int iB = b(viewHolder);
            if (this.f15951c == 1 && iB != i10 && iB > 0) {
                iB--;
            }
            if (iB < this.f15949a.size()) {
                T t10 = this.f15949a.get(iB);
                c(viewHolder, iB, t10);
                if (this.f15952d != null) {
                    viewHolder.itemView.setOnClickListener(new ViewOnClickListenerC0309a(iB, t10));
                }
                if (this.f15954f != null) {
                    viewHolder.itemView.setOnKeyListener(new b());
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        if (layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) && viewHolder.getLayoutPosition() == 0) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }
}
