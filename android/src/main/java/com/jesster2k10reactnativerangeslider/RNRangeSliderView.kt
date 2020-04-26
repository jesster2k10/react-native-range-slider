package com.jesster2k10reactnativerangeslider

import android.content.Context
import android.graphics.Color
import android.widget.LinearLayout
import android.widget.TextView
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar
import com.facebook.react.bridge.ReactContext
import com.facebook.react.uimanager.UIManagerModule
import java.lang.StringBuilder

class RNRangeSliderView(context: Context): LinearLayout(context), OnRangeSeekbarChangeListener {
  private var rangeSeekBar: CrystalRangeSeekbar
  private var minTextView: TextView?
  private var maxTextView: TextView?

  private var minValue: Float = 0f
  private var maxValue: Float = 100f

  var suffix: String? = ""
    set(value) {
      field = value
      updateText()
    }

  var prefix: String? = ""
    set(value) {
      field = value
      updateText()
    }

  init {
    inflate(context, R.layout.range_slider, this)
    rangeSeekBar = findViewById(R.id.range_seek_bar)
    rangeSeekBar.setOnRangeSeekbarChangeListener(this)
    rangeSeekBar.setMinStartValue(minValue)
    rangeSeekBar.setMaxStartValue(maxValue)

    minTextView = findViewById(R.id.range_seek_bar_min)
    maxTextView = findViewById(R.id.range_seek_bar_max)
    updateText(minValue, maxValue)
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
    minValue = min
    rangeSeekBar.setMinValue(min)
    updateText(minValue, maxValue)
  }

  fun setMaxValue(max: Float) {
    maxValue = max
    rangeSeekBar.setMaxValue(max)
    updateText(minValue, maxValue)
  }

  fun setMinStartValue(minStartValue: Float) {
    rangeSeekBar.setMinStartValue(minStartValue)
  }

  fun setMaxStartValue(maxStartValue: Float) {
    rangeSeekBar.setMaxStartValue(maxStartValue)
  }

  fun setFixGap(gap: Float) {
    rangeSeekBar.setFixGap(gap)
  }

  fun setStep(steps: Float) {
    rangeSeekBar.setSteps(steps)
  }

  private fun updateText(min: Number? = null, max: Number? = null) {
    var minText = minTextView?.text
    var maxText = minTextView?.text
    if (min !== null) {
      minText = min.toString()
    }

    if (max !== null) {
      maxText = max.toString()
    }

    minTextView?.text = StringBuilder()
      .append(prefix)
      .append(minText)
      .append(suffix)

    maxTextView?.text = StringBuilder()
      .append(prefix)
      .append(maxText)
      .append(suffix)
  }

  override fun valueChanged(min: Number?, max: Number?) {
    if (max == null || min == null) return
    updateText(min, max)

    val event = RangeSliderChangeEvent(rangeSeekBar.id)
    event.max = max.toDouble()
    event.min = min.toDouble()

    val reactContext = context as ReactContext
    reactContext.getNativeModule(UIManagerModule::class.java).eventDispatcher.dispatchEvent(
      event
    )
  }
}
