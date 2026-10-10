package com.live.evo.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import com.live.evo.R$dimen;
import com.live.evo.R$layout;
import com.live.evo.util.w0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class EmailAutoCompleteTextView extends AppCompatAutoCompleteTextView implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InputMethodManager f7425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    List<String> f7428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final ArrayList<String> f7429f;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class a extends BaseAdapter implements Filterable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f7430a;

        /* JADX INFO: renamed from: com.live.evo.widget.EmailAutoCompleteTextView$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class C0114a extends Filter {
            C0114a() {
            }

            @Override // android.widget.Filter
            protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                Object arrayList;
                EmailAutoCompleteTextView.this.f7429f.clear();
                ArrayList<String> arrayList2 = EmailAutoCompleteTextView.this.f7429f;
                if (filterResults == null || (arrayList = filterResults.values) == null) {
                    arrayList = new ArrayList();
                }
                arrayList2.addAll((Collection) arrayList);
                a.this.notifyDataSetChanged();
            }

            @Override // android.widget.Filter
            protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                if (TextUtils.isEmpty(charSequence)) {
                    return null;
                }
                String string = charSequence.toString();
                int i10 = 0;
                while (w0.a(a.this.f7430a).matcher(charSequence).find()) {
                    i10++;
                }
                if (i10 == 1) {
                    ArrayList arrayList = new ArrayList();
                    Filter.FilterResults filterResults = new Filter.FilterResults();
                    int iIndexOf = string.indexOf(a.this.f7430a);
                    if (string.length() - iIndexOf == 1) {
                        for (String str : EmailAutoCompleteTextView.this.f7428e) {
                            if (str.indexOf(string) >= 0) {
                                arrayList.add(ac.g.r(str));
                            } else if (str.indexOf(a.this.f7430a) < 0) {
                                arrayList.add(((Object) charSequence) + ac.g.r(str));
                            }
                        }
                    } else {
                        String strReplace = string.substring(iIndexOf).replace("@", "");
                        for (String str2 : EmailAutoCompleteTextView.this.f7428e) {
                            if (str2.indexOf(string) >= 0) {
                                arrayList.add(ac.g.r(str2));
                            } else if (str2.startsWith(strReplace) && !strReplace.equals(ac.g.r(str2)) && str2.indexOf(a.this.f7430a) < 0) {
                                arrayList.add(((Object) charSequence) + str2.replace(strReplace, ""));
                            }
                        }
                    }
                    filterResults.values = arrayList;
                    filterResults.count = arrayList.size();
                    return filterResults;
                }
                if (EmailAutoCompleteTextView.this.f7427d && !TextUtils.isEmpty(string)) {
                    string.getClass();
                }
                return null;
            }
        }

        /* synthetic */ a(EmailAutoCompleteTextView emailAutoCompleteTextView, m mVar) {
            this();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        private a() {
            this.f7430a = "@";
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return EmailAutoCompleteTextView.this.f7429f.size();
        }

        @Override // android.widget.Filterable
        public Filter getFilter() {
            return new C0114a();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            return EmailAutoCompleteTextView.this.f7429f.get(i10);
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.v_item_email, viewGroup, false);
            }
            TextView textView = (TextView) view;
            textView.setText((CharSequence) getItem(i10));
            return textView;
        }
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
        if (i10 != 5) {
            return false;
        }
        View viewFocusSearch = focusSearch(130);
        if (viewFocusSearch == null) {
            return true;
        }
        viewFocusSearch.requestFocus();
        return true;
    }

    private void b() {
        List<String> list = this.f7428e;
        setDropDownHeight((list != null ? Math.min(list.size(), 5) : 0) * ((int) this.f7424a.getResources().getDimension(R$dimen.sm_50)));
        setDropDownVerticalOffset(10);
        setDropDownBackgroundResource(2131099811);
        setThreshold(1);
        setAdapter(new a(this, null));
    }

    private void setEmailDomains(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        this.f7428e = Arrays.asList(strArr);
        b();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i10, KeyEvent keyEvent) {
        if (i10 != 19) {
            return false;
        }
        if (keyEvent.getAction() == 1) {
            return true;
        }
        int listSelection = getListSelection();
        if (listSelection > 0) {
            setListSelection(listSelection - 1);
            return true;
        }
        if (listSelection != 0) {
            return false;
        }
        dismissDropDown();
        return true;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if ((i10 == 23 || i10 == 66) && getListSelection() == -1) {
            if (requestFocus()) {
                this.f7426c = true;
                this.f7425b.showSoftInput(this, 0);
                return true;
            }
        } else if (isPopupShowing() && (i10 == 4 || i10 == 111)) {
            dismissDropDown();
            return true;
        }
        try {
            return super.onKeyUp(i10, keyEvent);
        } catch (Exception unused) {
            return true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        if (!this.f7426c) {
            return super.performLongClick();
        }
        this.f7426c = false;
        return true;
    }

    public EmailAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7426c = false;
        this.f7427d = false;
        this.f7428e = new ArrayList();
        this.f7429f = new ArrayList<>();
        this.f7424a = context;
        setOnEditorActionListener(this);
        this.f7425b = (InputMethodManager) getContext().getSystemService("input_method");
        ac.g.s("gmail.com,hotmail.com,outlook.com,yahoo.com,yahoo.com.br");
    }

    public void c(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f7427d = z10;
        setEmailDomains(ac.g.l(ac.g.s(str), ","));
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        try {
            return super.onKeyDown(i10, keyEvent);
        } catch (Exception unused) {
            return true;
        }
    }
}
