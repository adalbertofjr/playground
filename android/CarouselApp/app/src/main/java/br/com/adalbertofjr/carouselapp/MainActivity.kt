package br.com.adalbertofjr.carouselapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.adalbertofjr.carouselapp.view.carousel.adapter.CarouselViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val items = listOf("Item 1", "Item 2", "Item 3", "Item 4")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        carousel.adapter = CarouselViewPagerAdapter(this, items)
    }
}
