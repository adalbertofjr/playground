package br.com.adalbertofjr.carouselapp.view.carousel

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.text.Html
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import br.com.adalbertofjr.carouselapp.R
import br.com.adalbertofjr.carouselapp.view.carousel.adapter.CarouselViewPagerAdapter
import kotlinx.android.synthetic.main.carousel.view.*

class CarouselView : FrameLayout {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView(context)
    }

    private lateinit var dots: Array<TextView?>
    private lateinit var dotsLayout: LinearLayout
    private lateinit var items: List<String>
    var adapter: CarouselViewPagerAdapter? = null
        set(value) {
            viewPager.adapter = value
            this.items = value?.items ?: emptyList()
            addDots(0)

            field = value
        }

    private fun initView(context: Context) {
        isSaveEnabled = true
        val view = View.inflate(context, R.layout.carousel, null)
        view.viewPager.addOnPageChangeListener(viewPagerChangeListener)
        dotsLayout = view.layoutDots as LinearLayout
        addView(view)
    }

    // Dots indicator
    private fun addDots(currentPage: Int) {
        if (items.isEmpty()) {
            return
        }

        dots = arrayOfNulls(items.size)
        dotsLayout.removeAllViews()

        for (i in 0 until items.size) {
            dots[i] = TextView(context)
            dots[i]!!.text = Html.fromHtml("&#8226;")
            dots[i]!!.setTextSize(35f)
            dots[i]!!.setTextColor(ContextCompat.getColor(context, R.color.dot_inactive))
            dotsLayout.addView(dots[i])
        }

        if (dots.size > 0)
            dots[currentPage]!!.setTextColor(ContextCompat.getColor(context, R.color.dot_active))
    }

    var viewPagerChangeListener: ViewPager.OnPageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(position: Int) {

        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        }

        override fun onPageSelected(position: Int) {
            addDots(position)
        }
    }
}