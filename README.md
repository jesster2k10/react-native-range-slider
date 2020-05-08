# React Native Range Slider

A high-quality, cross platform, native iOS range slider for react native. A slider, similar in style to UISlider, but which allows you to pick a minimum and maximum range; inspired by [react-native-range-slider](https://github.com/ismnoiet/react-native-range-slider)

## Features

- iOS Support
- Android Support
- Native Code
- Customizable
- Typescript Support

## IOS Example

![IOS Demo](./Range-slider-ios.gif 'Ios')

## Android Example

![IOS Demo](./Range-slider-android.gif 'Android')

## Installation

Install the library using either yarn or npm like so:

```sh
yarn add @jesster2k10/react-native-range-slider
```

```sh
npm install --save @jesster2k10/react-native-range-slider
```

### IOS Installation

If you're using React Native versions > 60.0, it's relatively straightforward.

```sh
cd ios && pod install
```

For versions below 0.60.0, use rnpm links

- Run `react-native link @jesster2k10/react-native-range-slider`
- If linking fails, follow the
  [manual linking steps](https://facebook.github.io/react-native/docs/linking-libraries-ios.html#manual-linking)

### Android Installation

For versions below 0.60.0, follow the linking instructions above.
There are additional steps required to get started with android.

### Step One

Modify your settings.gradle to include the following

```gradle
include ':rangeseekbar'
project(':rangeseekbar').projectDir = new File(rootProject.projectDir, '../node_modules/@jesster2k10/react-native-range-slider/android/crystalrangeseekbar')
```

### Step Two

Modify and your application `build.gradle` to include:

```gradle
buildscript {
  dependencies {
    classpath 'com.github.dcendents:android-maven-gradle-plugin:1.5'
    classpath 'com.jfrog.bintray.gradle:gradle-bintray-plugin:1.7.3'
  }
}
```

### Step Three

*NOTE: This only applies to react native versions greater than 0.60.0*
*NOTE: if you don't have a react-native.config.js file, just create one at the root of your project

Adjust your `react-native.config.js` to include the following:


```js
module.exports = {
  dependencies: {
    '@jesster2k10/react-native-range-slider': {
      platforms: {
        android: {
          packageImportPath:
            'import com.jesster2k10reactnativerangeslider.ReactNativeRangeSliderPackage;',
        },
      },
    },
  },
}
```

### Step Four

Modify your `AndroidManifest.xml` and set `android:allowBackup="true"`, see below for example:

```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
  xmlns:tools="http://schemas.android.com/tools"
  package="com.ReactNativeRangeSliderExample">

    <uses-permission android:name="android.permission.INTERNET" />

    <application
      android:name=".MainApplication"
      android:label="@string/app_name"
      android:icon="@mipmap/ic_launcher"
      android:roundIcon="@mipmap/ic_launcher_round"
      android:allowBackup="true"
      android:theme="@style/AppTheme">
      <activity
        android:name=".MainActivity"
        android:label="@string/app_name"
        android:configChanges="keyboard|keyboardHidden|orientation|screenSize"
        android:windowSoftInputMode="adjustResize">
        <intent-filter>
            <action android:name="android.intent.action.MAIN" />
            <category android:name="android.intent.category.LAUNCHER" />
        </intent-filter>
      </activity>
      <activity android:name="com.facebook.react.devsupport.DevSettingsActivity" />
    </application>

</manifest>
```

## Usage

### Basic Usage

You can check out the [examples](./example/src/App.tsx) for more usage.

```js
import RangeSlider from '@jesster2k10/react-native-range-slider';

// ...
const App = () => {
  const onChange = (min: number, max: number) => {
    console.log('min: ', min)
    console.log('max: ', max)
  }

  return (
  <RangeSlider
    type="range" // ios only
    min={0}
    max={100}
    selectedMinimum={20} // ios only
    selectedMaximum={60} // ios only
    tintColor="#ecf0f1"
    handleColor="#f368e0"
    handlePressedColor="#f368e0"
    tintColorBetweenHandles="#ff9ff3"
    onChange={onChange}
  />
  )
}
```

## Props

![Props Explanation](./illustration.png)

### Common Props

| property                | type                               | description                                                                      | required |
| ----------------------- | ---------------------------------- | -------------------------------------------------------------------------------- | -------- |
| min                     | number                             | the minimum value for the slider                                                 | TRUE     |
| max                     | number                             | the maximum value for the slider                                                 | TRUE     |
| onChange                | (min: number, max: number) => void | a callback that will be called with slider data once the values change           | FALSE    |
| tintColor               | string                             | tint color for the slider track & handles (ios only, use handleColor on android) | FALSE    |
| tintColorBetweenHandles | string                             | tint color for the active part of the slider track                               | FALSE    |
| step                    | number                             | the step for the slider                                                          | FALSE    |
| handleColor             | string                             | the color for both left and right handlers                                       | FALSE    |
| style                   | object                             | a custom style object for the slider                                             | FALSE    |
| prefix                  | string                             | the prefix for the min and max values                                            |          |
| suffix                  | string                             | the suffix for the min and max values                                            |          |  | FALSE |

### IOS Only Props

| property          | type    | description                                               | required           |
| ----------------- | ------- | --------------------------------------------------------- | ------------------ |
| type              | slider  | range                                                     | the type of slider | FALSE |
| selectedMaximum   | number  | the selected maximum value, it shouldn't be less than max | FALSE              |
| selectedMinimum   | number  | the selected minimum value, it shouldn't be less than min | FALSE              |
| handleBorderColor | string  | the color for the slider handle border                    | FALSE              |
| handleWidth       | number  | the size of the handle                                    | FALSE              |
| minLabelColor     | string  | the color of the minimum (left hand) label                | FALSE              |
| maxLabelColor     | string  | the color of the maximum (right hand) label               | FALSE              |
| handleDiameter    | number  | the diameter of the handle                                | FALSE              |
| lineHeight        | number  | the height of the slider track                            | FALSE              |
| hideLabels        | boolean | controls whether the min and max labels are visible       | FALSE              |
| minLabelFont      | string  | the font family name of the min (left hand) label         | FALSE              |
| minLabelFontSize  | number  | the font size of the min (left hand) label                | FALSE              |
| maxLabelFont      | string  | the font family name of the max (right hand) label        | FALSE              |
| maxLabelFontSize  | number  | the font size of the max (right hand) label               | FALSE              |
| labelPadding      | number  | extra padding for the min & max labels                    | FALSE              |
| maxDistance       | number  | the maximum distance between handles                      | FALSE              |
| minDistance       | number  | the minimum distance between handles                      | FALSE              |
| lineBorderWidth   | number  | the border width of the slider track                      | FALSE              |
| lineBorderColor   | string  | the border color of the slider track                      | FALSE              |

### Android Only Props

| property                | type   | description                                      | required |
| ----------------------- | ------ | ------------------------------------------------ | -------- |
| leftHandleColor         | string | the color of the left handle                     | FALSE    |
| leftHandlePressedColor  | string | the color of the left (min) handle when touched  | FALSE    |
| rightHandleColor        | string | the color of the right (max) handle              | FALSE    |
| rightHandlePressedColor | string | the color of the right (max) handle when touched | FALSE    |
| handlePressedColor      | string | the color of the handle when touched             | FALSE    |
| minStartValue           | number | -                                                | FALSE    |
| maxStartValue           | number | -                                                | FALSE    |
| fixGap                  | number | a fixed gap between the handles                  | FALSE    |
| corderRadius            | number | the corder radius of the slider track            | FALSE    |

#### Please note that on android, the tint color refers to the color of the empty track.

## Acknowledgments

- This library is an extended version of [react-native-range-slider](https://github.com/ismnoiet/react-native-range-slider)
- The iOS version is based off of [TTRangeSlider](https://github.com/TomThorpe/TTRangeSlider)
- The Android version is a modified version of [CrystalRangeSeekbar](https://github.com/syedowaisali/crystal-range-seekbar)

### Roadmap

- [ ] Improve android customization abilities (fonts, handle size)
- [ ] Improve documentation
- [ ] Unit tests
- [ ] Flow support

### Contribution

Please visit the [CONTRIBUTING.md](CONTRIBUTING.md) file.

## License

MIT
