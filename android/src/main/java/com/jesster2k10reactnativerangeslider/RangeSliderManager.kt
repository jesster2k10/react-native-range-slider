package com.jesster2k10reactnativerangeslider

import android.content.Context
import com.facebook.react.common.MapBuilder
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp

class RangeSliderManager: SimpleViewManager<RangeSliderView>() {
  override fun getName(): String {
    return "RNRangeSlider"
  }

  override fun createViewInstance(reactContext: ThemedReactContext): RangeSliderView {
    return RangeSliderView(reactContext as Context)
  }

  @ReactProp(name = "minValue")
  fun setMinValue(view: RangeSliderView, min: Int?) {
    if (min == null) return
    view.run { setMinValue(min) }
  }

  @ReactProp(name = "maxValue")
  fun setMaxValue(view: RangeSliderView, max: Int?) {
    if (max == null) return
    view.run { setMaxValue(max) }
  }

  @ReactProp(name = "selectedMinimum")
  fun setSelectedMinimum(view: RangeSliderView, min: Int?) {
    if (min == null) return
    view.setSelectedMinimum(min)
  }

  @ReactProp(name = "selectedMaximum")
  fun setSelectedMaximum(view: RangeSliderView, max: Int?) {
    if (max == null) return
    view.setSelectedMaximum(max)
  }

  @ReactProp(name = "tintColor")
  fun setTintColor(view: RangeSliderView, color: String?) {
    if (color == null) return
    view.run { setTintColor(color) }
  }

  @ReactProp(name = "tintColorBetweenHandles")
  fun setTintColorBetweenHandles(view: RangeSliderView, color: String?) {
    if (color == null) return
    view.run { setTintColorBetweenHandles(color) }
  }

  @ReactProp(name = "labelColor")
  fun setLabelColor(view: RangeSliderView, color: String?) {
    if (color == null) return
    view.run { setLabelColor(color) }
  }

  @ReactProp(name = "labelFontSize")
  fun setLabelFontSize(view: RangeSliderView, size: Int?) {
    if (size == null) return
    view.run { setLabelFontSize(size.toFloat()) }
  }

  @ReactProp(name = "handleColor")
  fun setHandleColor(view: RangeSliderView, color: String?) {
    if (color == null) return
    view.run { setHandleColor(color) }
  }

  @ReactProp(name = "handlePressedColor")
  fun setHandlePressedColor(view: RangeSliderView, color: String?) {
    if (color == null) return
    view.run { setHandlePressedColor(color) }
  }

  @ReactProp(name = "handleDiameter")
  fun setHandleDiameter(view: RangeSliderView, diameter: Int?) {
    if (diameter == null) return
    view.run { setHandleDiameter(diameter.toFloat()) }
  }

  @ReactProp(name = "suffix")
  fun setSuffix(view: RangeSliderView, suffix: String?) {
    if (suffix == null) return
    view.suffix = suffix
  }

  @ReactProp(name = "prefix")
  fun setPrefix(view: RangeSliderView, prefix: String?) {
    if (prefix == null) return
    view.prefix = prefix
  }

  @ReactProp(name = "step")
  fun setStep(view: RangeSliderView, step: Int?) {
    if (step == null) return
    view.run { setStep(step) }
  }

  @ReactProp(name = "disableRange")
  fun setDisableRange(view: RangeSliderView, disableRange: Boolean?) {
    if (disableRange == null) return
    view.run { setDisableRange(disableRange) }
  }

  @ReactProp(name = "hideLabels")
  fun setHideLabels(view: RangeSliderView, hideLabels: Boolean?) {
    if (hideLabels == null) return
    view.run { setHideLabels(hideLabels) }
  }

  override fun getExportedCustomDirectEventTypeConstants(): MutableMap<String, Any> {
    return MapBuilder.of(
      RangeSliderChangeEvent.EVENT_NAME, MapBuilder.of(
      "registrationName", "onChange"
      )
    )
  }
}
