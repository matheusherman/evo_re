package com.live.evo_mobile.ui

import android.content.Intent
import android.os.Bundle
import com.foxivid.ui.mobile.base.BaseDataBindActivity

/*
 * Activities secundárias da versão mobile. Todas estendem BaseDataBindActivity<z4.*> e têm `onCreate` herdado/nativo.
 * Abertas a partir do [ProfileFragment]/[MainViewActivity]; declaradas no AndroidManifest.
 */

/**
 * Renovar/recarregar: digitar código de recarga (`input_invalid_recharge_code`), mostra "in_recharging" enquanto
 * processa e `recharge_ok_extend_to` com a nova validade; `noUpdateCallback` quando não há atualização;
 * `isInRecharge` evita duplo envio. Retorna ActivityResult à MainViewActivity.
 * Original: com/live/evo_mobile/ui/RenewActivity.java (RenewActivity.kt)
 */
class RenewActivity : BaseDataBindActivity()

/**
 * Vincular conta (e-mail/telefone): verificação por código (`setting_verification_tip_txt1/2`), `digitCode`,
 * `phoneNumber`, `method`, botão `setting_btn_prev`. Original: com/live/evo_mobile/ui/AccountLinkActivity.java (AccountLinkActivity.kt)
 */
class AccountLinkActivity : BaseDataBindActivity()

/**
 * Gerenciar conta (`account_management`): mostra dados da conta, logout (`logout_success`/`logout_failure`, loading
 * `mLoadingViewDialog`), vincular ([AccountLinkActivity]) e abre [com.live.evo_mobile.ui.login.LoginTypeActivity] por `jumpForResult`.
 * Original: com/live/evo_mobile/ui/AccountManageActivity.java (AccountManageActivity.kt)
 */
class AccountManageActivity : BaseDataBindActivity()

/**
 * Configurações: lista (`MainSettingData`) com idioma (popup `profile_menu_switch_language_title/content`), versão/upgrade
 * (`upgrade_failure`), "Sobre nós" ([AboutUsActivity]) e fundo esmaecido (`bgAlpha`) ao abrir o popup.
 * Original: com/live/evo_mobile/ui/SettingsActivity.java
 */
class SettingsActivity : BaseDataBindActivity()

/** Detalhe de configuração (casca vazia sobre z4.i). Original: com/live/evo_mobile/ui/SettingsDetailActivity.java */
class SettingsDetailActivity : BaseDataBindActivity()

/** Sobre/Contato: HTML (`htmlText`) com `customer_service`/`contact_us` (`cs_tag`). Original: com/live/evo_mobile/ui/AboutUsActivity.java */
class AboutUsActivity : BaseDataBindActivity()

/**
 * Compartilhar app: monta `share_msg`/`share_app` e dispara `Intent.ACTION_SEND` (EXTRA_TEXT), com atalho para
 * `com.whatsapp`. Original: com/live/evo_mobile/ui/ShareActivity.java
 */
class ShareActivity : BaseDataBindActivity() {
    fun share(text: String, viaWhatsApp: Boolean) {
        startActivity(Intent(Intent.ACTION_SEND).apply { type = "text/plain"; putExtra(Intent.EXTRA_TEXT, text); if (viaWhatsApp) setPackage("com.whatsapp") })
    }
}

/**
 * Busca de canais ao vivo: palavra-chave, resultados (`LiveSearchListData`, categoria `channel_column_all`) e histórico
 * de buscas na chave `SEARCH_LIVE_HISTORY_KEY`. Original: com/live/evo_mobile/ui/SearchLiveActivity.java
 */
class SearchLiveActivity : BaseDataBindActivity()

/**
 * Histórico: ViewPager com abas "Live" (`main_live`, [HistoryLiveFragment]) e VOD (`home_menu_vod`), modo edição
 * (`editStatusLive`). Original: com/live/evo_mobile/ui/HistoryListActivity.java
 */
class HistoryListActivity : BaseDataBindActivity()
