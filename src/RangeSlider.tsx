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
  labelColor,
  labelFontSize,
  handlePressedColor,
  style = {},
}: RangeSliderProps) => {
  const defaultStyle = {
    width: '100%',
    height: 70,
  };
  const handleChange = ({ nativeEvent }: RangeSliderChangeEvent) => {
    onChange && onChange(nativeEvent.min, nativeEvent.max);
  };
  const commonProps = {
    minValue: Number(min),
    maxValue: Number(max),
    tintColor,
    tintColorBetweenHandles,
    handleColor,
    handleDiameter,
    suffix,
    prefix,
    disableRange: type !== 'range',
    hideLabels,
    step,
    onChange: handleChange,
    style: [defaultStyle, style],
  };
  const platformSpecificProps = Platform.select({
    ios: {
      selectedMaximum,
      selectedMinimum,
      handleBorderColor,
      handleBorderWidth,
      minLabelColor: minLabelColor || labelColor,
      minLabelFont,
      minLabelFontSize: minLabelFontSize || labelFontSize,
      maxLabelColor: maxLabelColor || labelColor,
      maxLabelFont,
      maxLabelFontSize: maxLabelFontSize || labelFontSize,
      lineHeight,
      lineBorderWidth,
      lineBorderColor,
      labelPadding,
      minDistance,
      maxDistance,
    },
    android: {
      labelColor,
      labelFontSize,
      handlePressedColor,
    },
    default: {},
  });

  return <Slider {...commonProps} {...platformSpecificProps} />;
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
