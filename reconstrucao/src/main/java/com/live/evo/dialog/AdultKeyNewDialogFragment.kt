package com.live.evo.dialog

import android.content.DialogInterface
import android.os.Bundle
import android.text.TextUtils
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.live.evo.AppUserManager
import com.live.evo.R
import com.live.evo.model.ChannelData
import com.live.evo.util.CommonUtils
import com.live.evo.util.ToastUtils
import com.live.evo.widget.RemoveKeyCodeEnterEditText

/**
 * Diálogo de tela cheia para digitar/definir a senha adulta (PIN de 4 dígitos).
 * Fluxo de [onConfirm] (botão GO):
 * 1. PIN < 4 dígitos → toast `adult_key_not_map`, mantém foco.
 * 2. Sem senha cadastrada ([AppUserManager.sdkFlagQ0] falso; `l.n().y()` no original): se PIN == "2026" → `adult_key_invalid` (PIN
 *    padrão proibido); senão salva ([AppUserManager.setAdultKey]), autoriza ([AppUserManager.setAdultAuth]),
 *    chama `callback.onSuccess(channel)` e fecha.
 * 3. Com senha: valida via MediaRepository `p0(pin)`; ok → autoriza + callback; inválida e != "2026" →
 *    `adult_key_not_map`; igual a "2026" → "reset": limpa a senha, desautoriza e reabre o diálogo (novo cadastro).
 * Título em maiúsculas se a flag `category_is_upcase` (padrão true). BACK/ESC (4/111) → `callback.onCancel()`.
 *
 * Original: com/live/evo/dialog/a.java (AdultKeyNewDialogFragment, tag "AdultKeyNewDialogFragment_TAG")
 */
class AdultKeyNewDialogFragment : DialogFragment() {
    /** Original: a.c */
    interface Callback {
        /** Original: a(i5.h) */ fun onSuccess(channel: ChannelData?)
        /** Original: b() */ fun onCancel()
    }

    private var callback: Callback? = null
    private var channel: ChannelData? = null
    private lateinit var pwd: RemoveKeyCodeEnterEditText
    private lateinit var title: TextView
    private lateinit var hint: TextView
    private lateinit var goButton: Button
    private val pinLength = 4

    /** Original: U() */
    fun onConfirm() {
        val pin = pwd.text.toString()
        if (pin.length < pinLength) {
            ToastUtils.show(requireActivity(), R.string.adult_key_not_map, 0)
            pwd.requestFocus()
            return
        }
        val um = AppUserManager.get()
        if (!um.sdkFlagQ0()) {
            if (TextUtils.equals(pin, "2026")) {
                ToastUtils.show(requireActivity(), R.string.adult_key_invalid, 0)
                pwd.setText("")
                pwd.requestFocus()
            } else {
                ToastUtils.show(requireActivity(), CommonUtils.string(R.string.adult_key_saved, pin), 1)
                um.setAdultKey(pin)
                um.setAdultAuth(true)
                callback!!.onSuccess(channel)
                dismiss()
            }
            return
        }
        if (com.foxivid.baselib.media.MediaRepository.verifyAdultKey(pin)) {      // MediaRepository.p0(pin)
            um.setAdultAuth(true)
            callback!!.onSuccess(channel)
            dismiss()
        } else if (!TextUtils.equals(pin, "2026")) {
            ToastUtils.show(requireActivity(), R.string.adult_key_not_map, 0)
            pwd.setText("")
            pwd.requestFocus()
        } else {
            // "2026" = código de reset: apaga a senha e reabre o diálogo em modo de cadastro
            ToastUtils.show(requireActivity(), R.string.adult_key_reset_hint, 0)
            um.setAdultKey("")
            um.setAdultAuth(false)
            val act = requireActivity()
            dismiss()
            um.showAdultKeyDialog(act, callback!!, channel)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.DialogFullScreen)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.adult_new_key, container, false)
        v.findViewById<RelativeLayout>(R.id.adultnewkey_rl_layout_pwd)
        pwd = v.findViewById(R.id.adultnewkey_tv_adult_pwd)
        goButton = v.findViewById(R.id.adultnewkey_btn_go)
        title = v.findViewById(R.id.adultnewkey_tv_title)
        hint = v.findViewById(R.id.adultnewkey_tv_hint)
        goButton.setOnClickListener { onConfirm() }
        dialog!!.setOnKeyListener(DialogInterface.OnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && (keyCode == 4 || keyCode == 111)) callback?.onCancel()
            // ENTER/OK solto sobre o EditText é consumido
            event.action == KeyEvent.ACTION_UP && pwd.hasFocus() && (keyCode == 23 || keyCode == 66)
        })
        return v
    }

    override fun onResume() {
        super.onResume()
        val upper = AppUserManager.get().getBoolean("category_is_upcase", true)
        var t = CommonUtils.string(R.string.adult_key_title)
        if (upper) t = t.uppercase()
        title.text = t
        hint.text = if (AppUserManager.get().sdkFlagQ0()) CommonUtils.string(R.string.adult_key_again_hint) else getString(R.string.adult_key_first_hint)
    }

    companion object {
        const val TAG = "AdultKeyNewDialogFragment_TAG"
        /** Original: V(c, i5.h) */
        fun newInstance(callback: Callback, channel: ChannelData?) = AdultKeyNewDialogFragment().also { it.callback = callback; it.channel = channel }
    }
}
