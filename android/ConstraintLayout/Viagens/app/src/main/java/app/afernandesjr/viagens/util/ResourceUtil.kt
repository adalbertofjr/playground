package app.afernandesjr.viagens.util

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat

class ResourceUtil {
    companion object {
        private val TYPE_RESOURCE = "drawable"

        fun buscaImagem(context: Context, imagem: String): Drawable? {
            val idImagem = context.resources.getIdentifier(imagem, TYPE_RESOURCE, context.packageName)
            val imagem = ContextCompat.getDrawable(context, idImagem)
            return imagem
        }

    }
}