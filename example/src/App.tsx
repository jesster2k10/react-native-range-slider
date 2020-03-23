import * as React from 'react';
import { StyleSheet, View, Text, SafeAreaView, ScrollView } from 'react-native';
import RangeSlider from '@jesster2k10/react-native-range-slider';

export default function App() {
  const onChange = (min: number, max: number) => {
    console.log('Max: ', max);
    console.log('Min: ', min);
  };

  return (
    <SafeAreaView style={styles.container}>
      <ScrollView style={styles.container}>
        <View>
          <Text style={styles.title}>Basic Slider</Text>
          <RangeSlider
            min={0}
            max={100}
            onChange={onChange}
            selectedMinimum={20}
            selectedMaximum={40}
            style={styles.slider}
          />
        </View>
        <View>
          <Text style={styles.title}>Custom Font Slider</Text>
          <RangeSlider
            min={0}
            max={100}
            tintColor="#cc3956"
            tintColorBetweenHandles="#cc3956"
            handleColor="#cc3956"
            maxLabelFont="AvenirNext-Bold"
            minLabelFont="AvenirNext-Regular"
            minLabelFontSize={15}
            maxLabelFontSize={15}
            onChange={onChange}
            selectedMinimum={20}
            selectedMaximum={40}
            style={styles.slider}
          />
        </View>
        <View>
          <Text style={styles.title}>Suffixed Slider</Text>
          <RangeSlider
            min={0}
            max={100}
            suffix=" US$"
            onChange={onChange}
            selectedMinimum={20}
            selectedMaximum={40}
            style={styles.slider}
          />
        </View>
        <View>
          <Text style={styles.title}>Simple Slider (Range Disabled)</Text>
          <RangeSlider
            type="slider"
            min={0}
            max={100}
            onChange={onChange}
            selectedMinimum={20}
            selectedMaximum={40}
            style={styles.slider}
          />
        </View>
        <View>
          <Text style={styles.title}>Customized Handle</Text>
          <RangeSlider
            type="slider"
            min={0}
            max={100}
            handleDiameter={30}
            handleBorderWidth={5}
            handleBorderColor="#00000"
            onChange={onChange}
            selectedMinimum={20}
            selectedMaximum={40}
            style={styles.slider}
          />
        </View>
      </ScrollView>
    </SafeAreaView>
  );
}

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
