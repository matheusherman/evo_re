package h6;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import e6.d;
import e6.e;
import e6.f;
import f6.c;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class b extends RelativeLayout implements e6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected View f10851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected c f10852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected e6.a f10853c;

    /* JADX WARN: Multi-variable type inference failed */
    protected b(@NonNull View view) {
        this(view, view instanceof e6.a ? (e6.a) view : null);
    }

    protected b(@NonNull View view, @Nullable e6.a aVar) {
        super(view.getContext(), null, 0);
        this.f10851a = view;
        this.f10853c = aVar;
        if ((this instanceof e6.c) && (aVar instanceof d) && aVar.getSpinnerStyle() == c.f10064h) {
            aVar.getView().setScaleY(-1.0f);
            return;
        }
        if (this instanceof d) {
            e6.a aVar2 = this.f10853c;
            if ((aVar2 instanceof e6.c) && aVar2.getSpinnerStyle() == c.f10064h) {
                aVar.getView().setScaleY(-1.0f);
            }
        }
    }

    @Override // e6.a
    public void a(@NonNull e eVar, int i10, int i11) {
        e6.a aVar = this.f10853c;
        if (aVar != null && aVar != this) {
            aVar.a(eVar, i10, i11);
            return;
        }
        View view = this.f10851a;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.k) {
                eVar.a(this, ((SmartRefreshLayout.k) layoutParams).f8325a);
            }
        }
    }

    @SuppressLint({"RestrictedApi"})
    public boolean b(boolean z10) {
        e6.a aVar = this.f10853c;
        return (aVar instanceof e6.c) && ((e6.c) aVar).b(z10);
    }

    @Override // e6.a
    public void c(float f10, int i10, int i11) {
        e6.a aVar = this.f10853c;
        if (aVar == null || aVar == this) {
            return;
        }
        aVar.c(f10, i10, i11);
    }

    @Override // e6.a
    public int d(@NonNull f fVar, boolean z10) {
        e6.a aVar = this.f10853c;
        if (aVar == null || aVar == this) {
            return 0;
        }
        return aVar.d(fVar, z10);
    }

    @Override // e6.a
    public void e(@NonNull f fVar, int i10, int i11) {
        e6.a aVar = this.f10853c;
        if (aVar == null || aVar == this) {
            return;
        }
        aVar.e(fVar, i10, i11);
    }

    @Override // e6.a
    public boolean f() {
        e6.a aVar = this.f10853c;
        return (aVar == null || aVar == this || !aVar.f()) ? false : true;
    }

    @Override // e6.a
    public void g(@NonNull f fVar, int i10, int i11) {
        e6.a aVar = this.f10853c;
        if (aVar == null || aVar == this) {
            return;
        }
        aVar.g(fVar, i10, i11);
    }

    @Override // e6.a
    @NonNull
    public c getSpinnerStyle() {
        int i10;
        c cVar = this.f10852b;
        if (cVar != null) {
            return cVar;
        }
        e6.a aVar = this.f10853c;
        if (aVar != null && aVar != this) {
            return aVar.getSpinnerStyle();
        }
        View view = this.f10851a;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.k) {
                c cVar2 = ((SmartRefreshLayout.k) layoutParams).f8326b;
                this.f10852b = cVar2;
                if (cVar2 != null) {
                    return cVar2;
                }
            }
            if (layoutParams != null && ((i10 = layoutParams.height) == 0 || i10 == -1)) {
                for (c cVar3 : c.f10065i) {
                    if (cVar3.f10068c) {
                        this.f10852b = cVar3;
                        return cVar3;
                    }
                }
            }
        }
        c cVar4 = c.f10060d;
        this.f10852b = cVar4;
        return cVar4;
    }

    @Override // e6.a
    @NonNull
    public View getView() {
        View view = this.f10851a;
        return view == null ? this : view;
    }

    @Override // g6.e
    public void h(@NonNull f fVar, @NonNull f6.b bVar, @NonNull f6.b bVar2) {
        e6.a aVar = this.f10853c;
        if (aVar == null || aVar == this) {
            return;
        }
        if ((this instanceof e6.c) && (aVar instanceof d)) {
            if (bVar.isFooter) {
                bVar = bVar.f();
            }
            if (bVar2.isFooter) {
                bVar2 = bVar2.f();
            }
        } else if ((this instanceof d) && (aVar instanceof e6.c)) {
            if (bVar.isHeader) {
                bVar = bVar.a();
            }
            if (bVar2.isHeader) {
                bVar2 = bVar2.a();
            }
        }
        e6.a aVar2 = this.f10853c;
        if (aVar2 != null) {
            aVar2.h(fVar, bVar, bVar2);
        }
    }

    @Override // e6.a
    public void i(boolean z10, float f10, int i10, int i11, int i12) {
        e6.a aVar = this.f10853c;
        if (aVar == null || aVar == this) {
            return;
        }
        aVar.i(z10, f10, i10, i11, i12);
    }

    @Override // e6.a
    public void setPrimaryColors(@ColorInt int... iArr) {
        e6.a aVar = this.f10853c;
        if (aVar == null || aVar == this) {
            return;
        }
        aVar.setPrimaryColors(iArr);
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if ((obj instanceof e6.a) && getView() == ((e6.a) obj).getView()) {
            return true;
        }
        return false;
    }
}
