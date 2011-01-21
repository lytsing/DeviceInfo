package org.lytsing.android.deviceinfo;

public class DeviceConfiguration {

    public DeviceConfiguration() {
    }

    public DeviceConfiguration addNativePlatform(String platform) {
        return null;
    }

    public DeviceConfiguration addSystemLocale(String locale) {
        return null;
    }

    public DeviceConfiguration addSystemSharedLibrary(String library) {
        return null;
    }

    public boolean equals(Object o) {
        return false;
    }

    public int getGlEsVersion() {
        return 0;
    }

    public Keyboard getKeyboard() {
        return null;
    }

    public String getNativePlatform(int index) {
        return null;
    }

    public int getNativePlatformCount() {
        return 0;
    }

    public Navigation getNavigation() {
        return null;
    }

    public int getScreenDensity() {

        return 0;
    }

    public int getScreenHeight() {
        return 0;
    }

    public ScreenLayoutSize getScreenLayoutSize() {
        return null;
    }

    public int getScreenWidth() {
        return 0;
    }

    public String getSystemAvailableFeature(int index) {
        return null;
    }

    public int getSystemAvailableFeatureCount() {
        return 0;
    }

    public String getSystemSharedLibrary(int index) {
        return null;
    }

    public int getSystemSharedLibraryCount() {
        return 0;
    }

    public TouchScreen getTouchScreen() {
        return null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean isHasFiveWayNavigation() {
        return false;
    }

    public boolean isHasHardKeyboard() {
        return false;
    }

    public DeviceConfiguration removeSystemAvailableFeature(int index) {
        return null;
    }

    public DeviceConfiguration removeSystemSharedLibrary(int index) {
        return null;
    }

    public DeviceConfiguration setGlEsVersion(int version) {
        return null;
    }

    public DeviceConfiguration setHasFiveWayNavigation(boolean hasFiveWayNavigation) {
        return null;
    }

    public DeviceConfiguration setHasHardKeyboard(boolean hasHardKeyboard) {
        return null;
    }

    public DeviceConfiguration setKeyboard(Keyboard keyboard) {
        return null;
    }

    public DeviceConfiguration setNavigation(Navigation navigation) {
        return null;
    }

    public DeviceConfiguration setScreenDensity(int screenDensity) {
        return null;
    }

    public DeviceConfiguration setScreenHeight(int screenHeight) {
        return null;
    }

    public DeviceConfiguration setScreenLayoutSize(ScreenLayoutSize screenLayout) {
        return null;
    }

    public DeviceConfiguration setScreenWidth(int screenWidth) {
        return null;
    }

    public DeviceConfiguration setTouchScreen(TouchScreen touchScreen) {
        return null;
    }

    public String toString() {
        return null;
    }

    public enum ScreenLayoutSize {
        UNDEFINED,
        SMALL,
        NORMAL,
        LARGE;

        private int mId;

        public int getId() {
            return mId;
        }
    }

    public enum TouchScreen {
        UNDEFINED,
        NOTOUCH,
        STYLUS,
        FINGER;

        private int mId;

        public int getId() {
            return mId;
        }
    }

    public enum Keyboard {
        UNDEFINED,
        NOKEYS,
        QWERTY,
        TWELVE_KEY;

        private int mId;

        public int getId() {
            return mId;
        }
    }

    public enum Navigation {
        UNDEFINED,
        NONAV,
        DPAD,
        TRACKBALL,
        WHEEL;

        private int mId;

        public int getId() {
            return mId;
        }
    }

}

