package com.jesster2k10reactnativerangeslider

import com.facebook.react.bridge.Arguments
import com.facebook.react.uimanager.events.Event
import com.facebook.react.uimanager.events.RCTEventEmitter

class RangeSliderChangeEvent(viewId: Int): Event<RangeSliderChangeEvent>(viewId) {
  companion object {
    var EVENT_NAME = "sliderOnChange"
  }

  var min: Double = 0.0
  var max: Double = 0.0

  override fun getEventName(): String {
    return EVENT_NAME;
  }

  override fun getCoalescingKey(): Short {
    return 0
  }

  override fun canCoalesce(): Boolean {
    return false
  }

  override fun dispatch(rctEventEmitter: RCTEventEmitter?) {
    val eventData = Arguments.createMap()
    eventData.putInt("min", min.toInt())
    eventData.putInt("max", max.toInt())
    eventData.putInt("target", viewTag)

    rctEventEmitter?.receiveEvent(viewTag, eventName, eventData)
  }
}
