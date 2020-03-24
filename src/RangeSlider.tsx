import React from 'react';
import { Platform, requireNativeComponent } from 'react-native';
import { RangeSliderProps, RangeSliderChangeEvent } from './types';

const Slider = requireNativeComponent('RNRangeSlider');

const RangeSlider: React.FC<RangeSliderProps> = ({
  min,
  max,
  onChange,
  tintColor,
  tintColorBetweenHandles,
  step,
  handleBorderColor,
  handleColor,
  handleDiameter,
  handleBorderWidth,
  type = 'range',
  selectedMaximum,
  selectedMinimum,
  minLabelColor,
  maxLabelColor,
  lineHeight,
  prefix,
  suffix,
  hideLabels,
  maxLabelFont,
  minLabelFont,
  maxLabelFontSize,
  minLabelFontSize,
  lineBorderWidth,
  lineBorderColor,
  labelPadding,
  minDistance,
  maxDistance,
  leftHandleColor,
  rightHandleColor,
  leftHandlePressedColor,
  rightHandlePressedColor,
  handlePressedColor,
  minStartValue,
  maxStartValue,
  fixGap,
  style = {},
  cornerRadius,
}: RangeSliderProps) => {
  const defaultStyle = {
    width: '100%',
    height: 70,
  };
  const handleChange = ({ nativeEvent }: RangeSliderChangeEvent) => {
    onChange && onChange(nativeEvent.min, nativeEvent.max);
  };

  if (Platform.OS === 'android') {
    return (
      <Slider
        min={Number(min)}
        max={Number(max)}
        step={Number(step)}
        tintColor={tintColor}
        tintColorBetweenHandles={tintColorBetweenHandles}
        handleColor={handleColor}
        onChange={handleChange}
        leftHandleColor={leftHandleColor}
        rightHandleColor={rightHandleColor}
        minStartValue={minStartValue}
        maxStartValue={maxStartValue}
        fixGap={fixGap}
        leftHandlePressedColor={leftHandlePressedColor}
        rightHandlePressedColor={rightHandlePressedColor}
        handlePressedColor={handlePressedColor || handleColor}
        cornerRadius={cornerRadius}
        prefix={prefix}
        suffix={suffix}
        style={[defaultStyle, style]}
      />
    );
  } else {
    return (
      <Slider
        disableRange={type === 'slider'}
        minValue={Number(min)}
        maxValue={Number(max)}
        step={Number(step)}
        selectedMaximum={selectedMaximum}
        selectedMinimum={selectedMinimum}
        tintColor={tintColor}
        tintColorBetweenHandles={tintColorBetweenHandles}
        handleBorderColor={handleBorderColor}
        handleBorderWidth={handleBorderWidth}
        handleColor={handleColor}
        handleDiameter={handleDiameter}
        minLabelColour={minLabelColor}
        minLabelFont={minLabelFont}
        minLabelFontSize={minLabelFontSize}
        maxLabelFont={maxLabelFont}
        maxLabelFontSize={maxLabelFontSize}
        maxLabelColour={maxLabelColor}
        lineHeight={lineHeight}
        lineBorderWidth={lineBorderWidth}
        lineBorderColor={lineBorderColor}
        prefix={prefix}
        suffix={suffix}
        hideLabels={hideLabels}
        labelPadding={labelPadding}
        minDistance={minDistance}
        maxDistance={maxDistance}
        onChange={handleChange}
        style={[defaultStyle, style]}
      />
    );
  }
};

RangeSlider.defaultProps = {
  min: 0,
  max: 100,
  step: 1,
  type: 'range',
  selectedMinimum: 0,
  selectedMaximum: 100,
  tintColor: '#DCDCDC', // extra light gray
};

export default RangeSlider;
