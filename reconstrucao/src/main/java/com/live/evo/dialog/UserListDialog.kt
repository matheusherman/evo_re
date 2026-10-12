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
 * Filtra as contas por tipo `e()`: tipo 3 ou 6 → mantém só as com `e() != -1` (sem filtro de ordem),
 * senão coloca `e()==0` e `e()==2` no topo (add(0)). Cada clique → `listener.onAccountSelected(account)`.
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
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.addItemDecoration(DividerItemDecoration(context, 1))
        // TODO("adapter d5.b(accounts, context, onClick) — origem das contas: mapa vazio nesta versão (HashMap() novo em b())")
    }

    /** Original: f() */ fun hasAccounts() = accounts.isNotEmpty()
    /** Original: g() */ fun show() { if (!dialog.isShowing) dialog.show() }
    /** Original: c() */ fun hide() { if (dialog.isShowing) dialog.hide() }
}
