package app.afernandesjr.viagens.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import app.afernandesjr.viagens.R
import app.afernandesjr.viagens.model.Pacote
import app.afernandesjr.viagens.util.DiaUtil
import app.afernandesjr.viagens.util.MoedaUtil
import app.afernandesjr.viagens.util.ResourceUtil
import kotlinx.android.synthetic.main.item_pacote.view.*

class ListaPacotesAdapter(val pacotes: List<Pacote>, val context: Context) : BaseAdapter() {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false)

        val pacote = pacotes.get(position)
        val local = pacote.local
        val dias = DiaUtil.formatarDia(pacote.dias)
        val preco = MoedaUtil.formatarPreco(pacote.preco)
        val imagem = ResourceUtil.buscaImagem(context, pacote.imagem)

        view.imv_item_pacote.setImageDrawable(imagem)
        view.txv_item_pacote_local.text = local
        view.txv_item_pacote_dias.text = dias
        view.txv_item_pacote_preco.text = preco

        return view
    }

    override fun getItem(position: Int): Pacote {
        return pacotes.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return pacotes.size
    }
}