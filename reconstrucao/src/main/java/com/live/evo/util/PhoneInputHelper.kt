package com.live.evo.util

import android.content.Context
import android.text.SpannableString
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import com.live.evo.R
import com.live.evo.model.AccountBean
import com.live.evo.model.PhoneCountry
import com.live.evo.widget.nicespinner.NiceSpinner
import com.live.evo.widget.nicespinner.SpinnerTextFormatter
import org.slf4j.LoggerFactory

/**
 * Liga o spinner de DDI (`spinner_phonecode`) ao campo de telefone (`et_phonenumber`) das telas de login/cadastro/reset.
 * Itens do spinner: "+55(BR)" (DDI + nome quando existe); popup com altura 400 se há mais de 5 países.
 *
 * Original: o5/d.java
 */
class PhoneInputHelper(private val context: Context, view: View) {
    private val logger = LoggerFactory.getLogger(PhoneInputHelper::class.java)
    var spinner: NiceSpinner? = null; private set
    var editText: EditText? = null; private set

    init {
        spinner = view.findViewById(R.id.spinner_phonecode)
        editText = view.findViewById(R.id.et_phonenumber)
        if (spinner != null && editText != null) setupSpinner()
    }

    private fun setupSpinner() {
        val list = AccountValidators.countries
        val fmt = SpinnerTextFormatter<PhoneCountry> { c -> SpannableString(if (!TextUtils.isEmpty(c.name)) c.preCode + "(" + c.name + ")" else c.preCode) }
        spinner!!.setSpinnerTextFormatter(fmt)
        spinner!!.setSelectedTextFormatter(fmt)
        spinner!!.attachDataSource(list)
        if (list.size > 5) spinner!!.setHeight(400)
    }

    /** DDI + número (ou "" se o número é vazio). Original: d() */
    fun fullNumber(): String = try {
        if (TextUtils.isEmpty(editText!!.text.toString().trim())) "" else AccountValidators.countries[spinner!!.selectedIndex].preCode + editText!!.text.toString().trim()
    } catch (e: Exception) { "" }

    /** Só o número digitado. Original: e() */
    fun number(): String = try { editText!!.text.toString().trim() } catch (e: Exception) { "" }

    /** País selecionado. Original: g() */
    fun selectedCountry(): PhoneCountry = AccountValidators.countries[spinner!!.selectedIndex]

    /** Preenche o campo com um número completo ("+55..."): seleciona o país pelo prefixo e coloca o resto. Original: h(String) */
    fun setFullNumber(number: String?) {
        try {
            var s = number
            if (TextUtils.isEmpty(s)) { editText!!.setText(""); return }
            val list = AccountValidators.countries
            for (i in list.indices) {
                val c = list[i]
                if (s!!.contains(c.preCode) && s.indexOf(c.preCode) == 0) { spinner!!.setSelectedIndex(i, true); s = s.replace(c.preCode, ""); break }
            }
            if (TextUtils.isEmpty(s)) editText!!.setText("") else { editText!!.setText(s); editText!!.setSelection(s!!.length) }
        } catch (e: Exception) { logger.error(e.message, e) }
    }

    /** Preenche a partir de uma conta salva (DDI + nome). Original: j(AccountBean) */
    fun setAccount(a: AccountBean?) {
        if (a != null) {
            try {
                if (!TextUtils.isEmpty(a.accountName) && AccountValidators.isPhone(a.phonePreCode + a.accountName, "")) {
                    val list = AccountValidators.countries
                    for (i in list.indices) if (list[i].preCode.equals(a.phonePreCode, ignoreCase = true)) { spinner!!.setSelectedIndex(i, true); break }
                    editText!!.setText(a.accountName); editText!!.setSelection(a.accountName!!.length)
                    return
                }
            } catch (e: Exception) { logger.error(e.message, e); return }
        }
        editText!!.setText("")
    }

    /** Seleciona o país da conta (DDI + sigla). Original: n(AccountBean) */
    fun selectCountry(a: AccountBean) {
        val list = AccountValidators.countries
        for (i in list.indices) {
            val c = list[i]
            if (c.preCode.equals(a.phonePreCode, ignoreCase = true) && c.code.equals(a.countryCode, ignoreCase = true)) { spinner?.setSelectedIndex(i, true); return }
        }
    }

    /** Original: l(CharSequence) */ fun setNumber(text: CharSequence?) { try { editText!!.setText(text) } catch (e: Exception) { e.printStackTrace() } }
    /** Original: m(int, boolean) */ fun selectIndex(i: Int, notify: Boolean) { try { spinner!!.setSelectedIndex(i, notify) } catch (_: Exception) {} }
}
