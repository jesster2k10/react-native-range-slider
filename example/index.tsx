import { AppRegistry, Platform } from 'react-native';
import { Fragment } from 'react';
import IOSApp from './src/App';
import AndroidApp from './src/AndroidApp';
import { name as appName } from './app.json';

const App =
  Platform.select({
    ios: IOSApp,
    android: AndroidApp,
  }) || Fragment;

AppRegistry.registerComponent(appName, () => App);
