package br.com.adalbertofjr.habittrainer

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import br.com.adalbertofjr.habittrainer.db.HabitDbTable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //    private var tvDescription : TextView? = null
    private lateinit var tvDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        tvDescription = findViewById(R.id.tv_description)
//        tvDescription = findViewById<TextView>(R.id.tv_description)

//        tv_title.text = "Drink Water"
//        iv_icon.setImageResource(R.drawable.water)
//        tv_description.text = "A refreshing glass of water gets you hydrated"

        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)

        val habits = HabitDbTable(this).readAllHabits()
        rv.adapter = HabitsAdapter(habits)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.add_habit) {
            switchTo(CreateHabitActivity::class.java)
        }

        return true
    }

    private fun switchTo(c: Class<*>) {
        val intent: Intent = Intent(this, c)
        startActivity(intent)
    }


}
