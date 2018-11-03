package app.afernandesjr.viagens.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import app.afernandesjr.viagens.R
import app.afernandesjr.viagens.dao.PacoteDao.Companion.lista
import app.afernandesjr.viagens.ui.adapter.ListaPacotesAdapter
import kotlinx.android.synthetic.main.activity_lista_pacotes.*


class ListaPacotesActivity : AppCompatActivity() {

    private val TITULO_APP_BAR = "Pacotes"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_pacotes)

        setTitle(TITULO_APP_BAR)

        lvw_lista_pacotes.adapter = ListaPacotesAdapter(lista(), this)
    }
}

