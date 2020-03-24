import { NativeSyntheticEvent } from 'react-native';

export type RangeSliderChangeEvent = NativeSyntheticEvent<{
  min: number;
  max: number;
  target?: any;
  fromUser?: boolean;
}>;

export interface CommonRangeSliderProps {
  min: number;
  max: number;
  onChange: (min: number, max: number) => void;
  tintColor?: string;
  tintColorBetweenHandles?: string;
  step?: number;
  handleColor?: string;
  handleDiameter?: number;
  style?: object;
}

export interface IOSOnlyRangeSliderProps {
  type?: 'slider' | 'range';
  selectedMinimum: number;
  selectedMaximum: number;
  handleBorderColor?: string;
  handleBorderWidth?: number;
  minLabelColor?: string;
  maxLabelColor?: string;
  lineHeight?: number;
  prefix?: string;
  suffix?: string;
  hideLabels?: boolean;
  minLabelFont?: string;
  maxLabelFont?: string;
  minLabelFontSize?: number;
  maxLabelFontSize?: number;
  labelPadding?: number;
  minDistance?: number;
  maxDistance?: number;
  lineBorderWidth?: number;
  lineBorderColor?: string;
}

export interface AndroidOnlyRangeSliderProps {
  leftHandleColor?: string;
  rightHandleColor?: string;
  leftHandlePressedColor?: string;
  rightHandlePressedColor?: string;
  handlePressedColor?: string;
  minStartValue?: number;
  maxStartValue?: number;
  fixGap?: number;
  cornerRadius?: number;
}

export type RangeSliderProps = CommonRangeSliderProps &
  Partial<IOSOnlyRangeSliderProps> &
  Partial<AndroidOnlyRangeSliderProps>;
