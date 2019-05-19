package br.com.adalbertofjr.carouselapp.view.carousel.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import br.com.adalbertofjr.carouselapp.R
import kotlinx.android.synthetic.main.carousel_item.view.*

class CarouselViewPagerAdapter(val context: Context, val items: List<String>) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)
        val layout = inflater.inflate(R.layout.carousel_item, container, false)
        layout.description.text = items[position]
        container.addView(layout)
        return layout
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }
}