import * as React from 'react';
import { StyleSheet, View, Text, SafeAreaView } from 'react-native';
import RangeSlider from '@jesster2k10/react-native-range-slider';

const AndroidApp = () => {
  const onChange = (min: number, max: number) => {
    console.log('Max: ', max);
    console.log('Min: ', min);
  };

  return (
    <SafeAreaView style={styles.container}>
      <View>
        <Text style={styles.title}>Basic Slider (no customization)</Text>
        <RangeSlider min={0} max={100} onChange={onChange} />
      </View>
      <View>
        <Text style={styles.title}>Customized Colors</Text>
        <RangeSlider
          min={55}
          max={133}
          handleDiameter={5}
          handlePressedColor="blue"
          tintColor="grey"
          tintColorBetweenHandles="#cc3956"
          handleColor="#cc3956"
          onChange={onChange}
        />
      </View>
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
