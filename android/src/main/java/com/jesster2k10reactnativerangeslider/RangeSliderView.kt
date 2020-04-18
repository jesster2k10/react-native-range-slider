package com.jesster2k10reactnativerangeslider

import android.content.Context
import android.graphics.Color
import android.widget.LinearLayout
import com.facebook.react.bridge.ReactContext
import com.facebook.react.uimanager.UIManagerModule
import hearsilent.discreteslider.DiscreteSlider
import hearsilent.discreteslider.DiscreteSlider.ValueLabelFormatter
import hearsilent.discreteslider.libs.Utils

class RangeSliderView(context: Context): LinearLayout(context) {
  private var slider: DiscreteSlider

  var suffix: String? = ""
    set(value) {
      field = value
      updateLabelFormatter()
    }

  var prefix: String? = ""
    set(value) {
      field = value
      updateLabelFormatter()
    }

  private var step: Int? = null
  private var min: Int = 0

  init {
    inflate(context, R.layout.rn_range_slider, this)
    slider = findViewById(R.id.rn_discrete_slider)
    slider.mode = DiscreteSlider.MODE_RANGE
    slider.setOnValueChangedListener(object: DiscreteSlider.OnValueChangedListener() {
      override fun onValueChanged(minProgress: Int, maxProgress: Int, fromUser: Boolean) {
        super.onValueChanged(minProgress, maxProgress, fromUser)
        val event = RangeSliderChangeEvent(slider.id)
        event.max = maxProgress.toDouble() + min.toDouble()
        event.min = minProgress.toDouble() + min.toDouble()

        val reactContext = context as ReactContext
        reactContext.getNativeModule(UIManagerModule::class.java).eventDispatcher.dispatchEvent(
          event
        )
      }
    })
  }

  fun setSelectedMinimum(min: Int) {
    if (slider.mode != DiscreteSlider.MODE_RANGE) {
      return
    }
    slider.minProgress = min
  }

  fun setSelectedMaximum(max: Int) {
    if (slider.mode != DiscreteSlider.MODE_RANGE) {
      return
    }
    slider.maxProgress = max
  }

  fun setMinValue(min: Int) {
    this.min = min
    updateLabelFormatter()
  }

  fun setMaxValue(max: Int) {
    if (slider.mode != DiscreteSlider.MODE_RANGE) {
      return
    }
    slider.count = max
  }

  fun setDisableRange(disableRange: Boolean) {
    if (disableRange) {
      slider.mode = DiscreteSlider.MODE_NORMAL
    } else {
      slider.mode = DiscreteSlider.MODE_RANGE
    }
  }

  fun setTintColorBetweenHandles(colorStr: String) {
    val color = Color.parseColor(colorStr)
    slider.trackColor = color
  }

  fun setTintColor(colorStr: String) {
    val color = Color.parseColor(colorStr)
    slider.inactiveTrackColor = color
  }

  fun setHandleColor(colorStr: String) {
    slider.thumbColor = Color.parseColor(colorStr)
  }

  fun setHandlePressedColor(colorStr: String) {
    slider.thumbPressedColor = Color.parseColor(colorStr)
  }

  fun setHandleDiameter(diameter: Float) {
    slider.thumbRadius = diameter / 2
  }

  fun setLabelColor(colorStr: String) {
    slider.valueLabelTextColor = Color.parseColor(colorStr)
  }

  fun setLabelFontSize(size: Float) {
    slider.valueLabelTextSize = Utils.convertSpToPixel(size, context).toFloat()
  }

  fun setHideLabels(hideLabels: Boolean) {
    if (hideLabels) {
      slider.valueLabelMode = 0
    } else {
      slider.valueLabelMode = 3
    }
  }

  fun setStep(step: Int) {
    val max = slider.count - 1
    val factor = step % max
    if (factor !== 0) return
    this.step = step
    slider.tickMarkStep = step
  }

  private fun updateLabelFormatter() {
    slider.valueLabelFormatter = object : ValueLabelFormatter() {
      override fun getLabel(input: Int): String? {
        var number = input
        val min = min
        if (min !== null) {
          number += min
        }
        var formatted = number.toString()
        if (prefix !== null) {
          formatted = prefix + formatted
        }
        if (suffix !== null) {
          formatted += suffix
        }
        return formatted
      }
    }
  }
}
