package com.foxivid.baselib.util

import android.graphics.Bitmap
import android.view.View
import android.widget.ImageView
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.qrcode.QRCodeWriter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Gerador de QR Code (ZXing, ofuscado: `y5.a` = QRCodeWriter, `v5.b` = EncodeHintType,
 * `v5.a` = BarcodeFormat, `w5.b` = BitMatrix).
 * Original: x1/f1/lb/util/t0.java (nome Kotlin original preservado no @DebugMetadata: `QrCodeUtils`).
 */
object QrCodeUtils {
    private val logger: Logger = LoggerFactory.getLogger(QrCodeUtils::class.java)

    /** Gera bitmap RGB_565 preto (0) / branco (-1), charset utf-8, margem 1. Original: `t0.c(String,int,int)`. */
    fun createBitmap(str: String, width: Int, height: Int): Bitmap {
        val hints = HashMap<EncodeHintType, Any>()
        hints[EncodeHintType.CHARACTER_SET] = "utf-8"
        hints[EncodeHintType.MARGIN] = 1
        val matrix = QRCodeWriter().encode(str, BarcodeFormat.QR_CODE, width, height, hints)
        val pixels = IntArray(width * height)
        for (y in 0 until height) {
            for (x in 0 until width) {
                pixels[y * width + x] = if (matrix.get(x, y)) 0 else -1
            }
        }
        return Bitmap.createBitmap(pixels, 0, width, width, height, Bitmap.Config.RGB_565)
    }

    /**
     * Gera o QR em IO e aplica na [imgView] no Main. Se `sizeInPx == 0`, esconde a view.
     * Original: `t0.d(String,int,ImageView,String)` (corrotina `QrCodeUtils$setQrCode$1`).
     */
    fun setQrCode(text: String, sizeInPx: Int, imgView: ImageView, logTag: String?) {
        if (sizeInPx == 0) {
            logger.warn("0 size to generate qrcode")
            imgView.visibility = View.GONE
            return
        }
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val bitmap = createBitmap(text, sizeInPx, sizeInPx)
                withContext(Dispatchers.Main) { imgView.setImageBitmap(bitmap) }
            } catch (t: Throwable) {
                logger.error("generate qrcode failure" + (if (logTag == null) "" else ": $logTag"), t)
            }
        }
    }
}
