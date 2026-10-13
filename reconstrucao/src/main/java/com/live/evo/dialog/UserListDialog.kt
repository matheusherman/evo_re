package com.live.evo.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.live.evo.R
import com.live.evo.model.AccountBean
import com.live.evo.widget.BaseDialog

/**
 * Lista de contas do usuário (layout `user_list_dialog`, estilo `EPGDialog`): RecyclerView vertical com divisor.
 * Filtra as contas por tipo `e()` conforme [mode]: 3 → só tipo 2; 6 → só tipo 1; demais → só tipo 0 (cada uma inserida no topo).
 * No original o mapa de origem das contas é um `HashMap()` novo e vazio, então a lista nunca tem itens ([hasAccounts] = false).
 * Cada linha (`user_list_item`/`userlistitem_tv_email`): tipo 0 → nome; tipo 1 → DDI + número; senão nome mascarado ("****").
 * Clique → `listener.onAccountSelected(account)`.
 * Original: com/live/evo/dialog/z.java (adapter `d5.b`)
 */
class UserListDialog(private val context: Context, private val mode: Int, private val listener: Listener?) {
    /** Original: z.b */ interface Listener { fun onAccountSelected(account: AccountBean) }
    private val accounts = ArrayList<AccountBean>()
    private val dialog: BaseDialog
    private val recycler: RecyclerView

    init {
        val v = LayoutInflater.from(context).inflate(R.layout.user_list_dialog, null, false)
        dialog = BaseDialog(context, R.style.EPGDialog).also { it.setContentView(v); it.setCanceledOnTouchOutside(true) }
        recycler = v.findViewById(R.id.userlistdlg_rv_userlist)
        loadAccounts()
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.addItemDecoration(DividerItemDecoration(context, 1))
        recycler.adapter = UserListAdapter(accounts, context) { listener?.onAccountSelected(it) }
    }

    /** Original: b() — o mapa de contas é vazio nesta versão. */
    private fun loadAccounts() {
        val map = HashMap<String, AccountBean>()
        accounts.clear()
        for (a in map.values) {
            if (a.e() == -1) continue
            when (mode) {
                3 -> if (a.e() == 2) accounts.add(0, a)
                6 -> if (a.e() == 1) accounts.add(0, a)
                else -> if (a.e() == 0) accounts.add(0, a)
            }
        }
    }

    /** Original: f() */ fun hasAccounts() = accounts.isNotEmpty()
    /** Original: g() */ fun show() { if (!dialog.isShowing) dialog.show() }
    /** Original: c() */ fun hide() { if (dialog.isShowing) dialog.hide() }
}

/** Adapter da lista de contas. Original: d5/b.java */
private class UserListAdapter(private val items: List<AccountBean>, private val context: Context, private val onClick: (AccountBean) -> Unit) :
    RecyclerView.Adapter<UserListAdapter.Holder>() {
    class Holder(v: android.view.View) : RecyclerView.ViewHolder(v) { val email: android.widget.TextView = v.findViewById(R.id.userlistitem_tv_email) }
    override fun getItemCount() = items.size
    override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int) =
        Holder(LayoutInflater.from(context).inflate(R.layout.user_list_item, null, false))
    override fun onBindViewHolder(h: Holder, position: Int) {
        val a = items[position]
        h.email.text = when (a.e()) {
            0 -> a.a()
            1 -> a.d() + a.a()
            else -> com.live.evo.util.CommonUtils.maskEdges(a.a(), 4, 8, "********")
        }
        h.email.setOnClickListener { onClick(items[position]) }
    }
}
