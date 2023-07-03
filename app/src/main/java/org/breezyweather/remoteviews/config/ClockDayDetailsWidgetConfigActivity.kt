package org.breezyweather.remoteviews.config

import android.view.View
import android.widget.RemoteViews
import dagger.hilt.android.AndroidEntryPoint
import org.breezyweather.R
import org.breezyweather.remoteviews.presenters.ClockDayDetailsWidgetIMP

/**
 * Clock day details widget config activity.
 */
@AndroidEntryPoint
class ClockDayDetailsWidgetConfigActivity : AbstractWidgetConfigActivity() {
    override fun initData() {
        super.initData()
        val clockFonts = resources.getStringArray(R.array.widget_clock_fonts)
        val clockFontValues = resources.getStringArray(R.array.widget_clock_font_values)
        clockFontValueNow = "light"
        this.clockFonts = arrayOf(clockFonts[0], clockFonts[1], clockFonts[2])
        this.clockFontValues = arrayOf(clockFontValues[0], clockFontValues[1], clockFontValues[2])
    }

    override fun initView() {
        super.initView()
        mCardStyleContainer.visibility = View.VISIBLE
        mCardAlphaContainer.visibility = View.VISIBLE
        mTextColorContainer.visibility = View.VISIBLE
        mTextSizeContainer.visibility = View.VISIBLE
        mClockFontContainer.visibility = View.VISIBLE
        mHideLunarContainer.visibility = isHideLunarContainerVisible()
    }

    override fun getRemoteViews(): RemoteViews {
        return ClockDayDetailsWidgetIMP.getRemoteViews(
            this, getLocationNow(),
            cardStyleValueNow, cardAlpha, textColorValueNow, textSize, clockFontValueNow, hideLunar
        )
    }

    override fun getConfigStoreName(): String {
        return getString(R.string.sp_widget_clock_day_details_setting)
    }
}