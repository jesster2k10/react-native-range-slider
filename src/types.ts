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
  tintColor?: string;
  tintColorBetweenHandles?: string;
  handleColor?: string;
  handleDiameter?: number;
  hideLabels?: boolean;
  type?: 'slider' | 'range';
  onChange?: (min: number, max: number) => void;
  step?: number;
  style?: object;
  prefix?: string;
  suffix?: string;
  labelColor?: string;
  labelFontSize?: string;
}

export interface IOSOnlyRangeSliderProps {
  selectedMinimum: number;
  selectedMaximum: number;
  handleBorderColor?: string;
  handleBorderWidth?: number;
  minLabelColor?: string;
  maxLabelColor?: string;
  lineHeight?: number;
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
  handlePressedColor?: string;
}

export type RangeSliderProps = CommonRangeSliderProps &
  Partial<IOSOnlyRangeSliderProps> &
  Partial<AndroidOnlyRangeSliderProps>;
