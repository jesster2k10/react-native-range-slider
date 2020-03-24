import * as React from 'react';
import { StyleSheet, View, Text, SafeAreaView, ScrollView } from 'react-native';
import RangeSlider from '@jesster2k10/react-native-range-slider';

const AndroidApp = () => {
  const onChange = (min: number, max: number) => {
    console.log('Max: ', max);
    console.log('Min: ', min);
  };

  return (
    <SafeAreaView style={styles.container}>
      <ScrollView>
        <View>
          <Text style={styles.title}>Basic Slider</Text>
          <RangeSlider
            min={0}
            max={100}
            onChange={onChange}
            style={styles.slider}
          />
        </View>
        <View>
          <Text style={styles.title}>Custom Range & Step</Text>
          <RangeSlider
            min={50}
            step={50}
            max={300}
            tintColor="#ecf0f1"
            handleColor="#f368e0"
            handlePressedColor="#f368e0"
            tintColorBetweenHandles="#ff9ff3"
            onChange={onChange}
            style={styles.slider}
          />
        </View>
        <View>
          <Text style={styles.title}>Customized Colors</Text>
          <RangeSlider
            min={55}
            max={133}
            handleColor="#3498db"
            handlePressedColor="#2980b9"
            tintColor="#ecf0f1"
            tintColorBetweenHandles="#1abc9c"
            onChange={onChange}
          />
        </View>
        <View>
          <Text style={styles.title}>Prefixed Slider</Text>
          <RangeSlider
            min={0}
            max={100}
            prefix="$"
            onChange={onChange}
            style={styles.slider}
            tintColorBetweenHandles="#9b59b6"
            handleColor="#8e44ad"
            handlePressedColor="#8e44ad"
          />
        </View>
        <View>
          <Text style={styles.title}>Suffixed Slider</Text>
          <RangeSlider
            min={0}
            max={100}
            suffix=" US$"
            onChange={onChange}
            style={styles.slider}
          />
        </View>
        <View>
          <Text style={styles.title}>Customized Handles</Text>
          <RangeSlider
            type="slider"
            min={0}
            max={100}
            leftHandleColor="#00b894"
            rightHandleColor="#00cec9"
            leftHandlePressedColor="#55efc4"
            rightHandlePressedColor="#81ecec"
            onChange={onChange}
            selectedMinimum={20}
            selectedMaximum={40}
            style={styles.slider}
          />
        </View>
      </ScrollView>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    flexDirection: 'column',
    paddingTop: 25,
  },
  title: {
    marginLeft: 15,
    marginBottom: 15,
    textAlign: 'left',
    fontWeight: 'bold',
  },
  slider: {
    marginBottom: 15,
  },
});
export default AndroidApp;
