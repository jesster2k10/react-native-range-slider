package com.jesster2k10reactnativerangeslider

import android.content.Context
import android.graphics.Color
import android.widget.LinearLayout
import android.widget.TextView
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar
import com.facebook.react.bridge.ReactContext
import com.facebook.react.uimanager.UIManagerModule

class RangeSliderView(context: Context): LinearLayout(context), OnRangeSeekbarChangeListener {
  private var rangeSeekBar: CrystalRangeSeekbar
  private var minTextView: TextView?
  private var maxTextView: TextView?

  init {
    inflate(context, R.layout.range_slider, this)
    rangeSeekBar = findViewById(R.id.range_seek_bar)
    rangeSeekBar.setOnRangeSeekbarChangeListener(this)

    minTextView = findViewById(R.id.range_seek_bar_min)
    maxTextView = findViewById(R.id.range_seek_bar_max)
  }

  fun setTintColorBetweenHandles(color: String) {
    rangeSeekBar.setBarHighlightColor(Color.parseColor(color))
  }

  fun setTintColor(color: String) {
    rangeSeekBar.setBarColor(Color.parseColor(color))
  }

  fun setHandleColor(color: String) {
    rangeSeekBar.setLeftThumbColor(Color.parseColor(color))
    rangeSeekBar.setRightThumbColor(Color.parseColor(color))
  }

  fun setHandlePressedColor(color: String) {
    rangeSeekBar.setLeftThumbHighlightColor(Color.parseColor(color))
    rangeSeekBar.setRightThumbHighlightColor(Color.parseColor(color))
  }

  fun setLeftHandleColor(color: String) {
    rangeSeekBar.setLeftThumbColor(Color.parseColor(color))
  }

  fun setRightHandleColor(color: String) {
    rangeSeekBar.setRightThumbColor(Color.parseColor(color))
  }

  fun setLeftHandlePressedColor(color: String) {
    rangeSeekBar.setLeftThumbHighlightColor(Color.parseColor(color))
  }

  fun setRightHandlePressedColor(color: String) {
    rangeSeekBar.setRightThumbHighlightColor(Color.parseColor(color))
  }

  fun setCornerRadius(diameter: Float) {
    rangeSeekBar.setCornerRadius(diameter / 2)
  }

  fun setMinValue(min: Float) {
    minTextView?.text = min.toInt().toString()
    rangeSeekBar.setMinValue(min)
  }

  fun setMaxValue(max: Float) {
    maxTextView?.text = max.toInt().toString()
    rangeSeekBar.setMaxValue(max)
  }

  fun setMinStartValue(minStartValue: Float) {
    rangeSeekBar.setMinStartValue(minStartValue)
  }

  fun setMaxStartValue(maxStartValue: Float) {
    rangeSeekBar.setMinStartValue(maxStartValue)
  }

  fun setFixGap(gap: Float) {
    rangeSeekBar.setFixGap(gap)
  }

  fun setStep(steps: Float) {
    rangeSeekBar.setSteps(steps)
  }

  override fun valueChanged(min: Number?, max: Number?) {
    minTextView?.text = min?.toInt()?.toString()
    maxTextView?.text = max?.toInt()?.toString()

    if (max == null || min == null) return

    val event = RangeSliderChangeEvent(rangeSeekBar.id)
    event.max = max.toDouble()
    event.min = min.toDouble()

    val reactContext = context as ReactContext
    reactContext.getNativeModule(UIManagerModule::class.java).eventDispatcher.dispatchEvent(
      event
    )
  }
}
