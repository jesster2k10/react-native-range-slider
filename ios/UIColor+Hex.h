//
//  UIColor+Hex.h
//  jesster2k10-react-native-range-slider
//
//  Created by Jesse Onolememen on 23/03/2020.
//

#import <UIKit/UIKit.h>

@interface UIColor (fromHex)
+ (UIColor *)colorwithHexString:(NSString *)hexStr alpha:(CGFloat)alpha;
@end
