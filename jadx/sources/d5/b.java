package d5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.util.x1;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<i5.a> f9638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f9639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f9640c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a {
        void a(i5.a aVar);
    }

    /* JADX INFO: renamed from: d5.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class C0170b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextView f9641a;

        C0170b(b bVar, View view) {
            super(view);
            this.f9641a = (TextView) view.findViewById(R$id.userlistitem_tv_email);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(int i10, View view) {
        a aVar = this.f9640c;
        if (aVar != null) {
            aVar.a(this.f9638a.get(i10));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f9638a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i10) {
        C0170b c0170b = (C0170b) viewHolder;
        i5.a aVar = this.f9638a.get(i10);
        if (aVar.e() == 0) {
            c0170b.f9641a.setText(aVar.a());
        } else if (aVar.e() == 1) {
            c0170b.f9641a.setText(aVar.d() + aVar.a());
        } else {
            c0170b.f9641a.setText(x1.c(aVar.a(), 4, 8, "********"));
        }
        c0170b.f9641a.setOnClickListener(new View.OnClickListener() { // from class: d5.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f9636a.b(i10, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        return new C0170b(this, LayoutInflater.from(this.f9639b).inflate(R$layout.user_list_item, (ViewGroup) null, false));
    }

    public b(List<i5.a> list, Context context, a aVar) {
        this.f9638a = list;
        this.f9639b = context;
        this.f9640c = aVar;
    }
}
