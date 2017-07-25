/*
 * Copyright (C) 2017 lytsing.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.lytsing.android.deviceinfo;

import android.app.Activity;
import android.content.Context;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.TextView;
import android.provider.Settings;

import java.util.Locale;

/**
 * Show Android Market collect device info
 *
 */
public class MarketInfoActivity extends Activity {

    private static final String TAG = "MarketInfoActivity";

    private String mLineNumber;
    private String mOperatorName;
    private String mOperatorNumericName;
    private String mSimOperatorName;
    private String mSimOperatorNumericName;

    private TelephonyManager mTelephonyManager;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        setContentView(R.layout.main);

        mTelephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = Settings.System.getString(getContentResolver(),
                Settings.Secure.ANDROID_ID);


        TextView tv = (TextView)findViewById(R.id.device_id);
        StringBuilder sb = new StringBuilder()
                .append("androidId:")
                .append(deviceId)
                .append("\ndeviceAndSdkVersion:")
                .append(getDeviceAndSdkVersion())
                .append("\nuserLanguage:")
                .append(getUserLocale().getLanguage())
                .append("\nuserCountry:")
                .append(getUserLocale().getCountry())
                .append("\noperatorAlpha:")
                .append(getOperatorName())
                .append("\noperatorNumeric:")
                .append(getOperatorNumericName())
                .append("\nsimOperatorAlpha:")
                .append(getSimOperatorName())
                .append("\nsimOperatorNumeric:")
                .append(getSimOperatorNumericName());

        tv.setText("Android Market collect device info:\n" + sb.toString());

        PackageManager packageManager = getPackageManager();
        FeatureInfo[] systemAvailableFeatures = packageManager.getSystemAvailableFeatures();

        StringBuilder feactures = new StringBuilder();
        for (FeatureInfo arr : systemAvailableFeatures) {
            if (arr != null && arr.name != null) {
                Log.d(TAG, arr.name);
                feactures.append(arr.name).append('\n');
            }
        }

        tv = (TextView)findViewById(R.id.android_id);
        tv.setText("SystemAvailableFeatures:\n" + feactures.toString());
    }

    public String getLineNumber() {
        if (mLineNumber == null) {
            mLineNumber = mTelephonyManager.getLine1Number();
        }

        return mLineNumber;
    }

    public String getOperatorName() {
        if (mOperatorName == null) {
            mOperatorName = mTelephonyManager.getNetworkOperatorName();
        }

        return mOperatorName;
    }

    public String getOperatorNumericName() {
        if (mOperatorNumericName == null) {
            mOperatorNumericName = mTelephonyManager.getNetworkOperatorName();
        }

        return mOperatorNumericName;
    }
    public String getSimOperatorName() {
        if (mSimOperatorName == null) {
            mSimOperatorName = mTelephonyManager.getSimOperatorName();
        }
        return mSimOperatorName;
    }

    public String getSimOperatorNumericName() {
        if (mSimOperatorNumericName == null) {
            mSimOperatorNumericName = mTelephonyManager.getNetworkOperator();
        }

        return mSimOperatorNumericName;
    }

    public Locale getUserLocale() {
        return Locale.getDefault();
    }

    public String getDeviceName() {
        return Build.DEVICE;
    }

    public String getSdkVersion() {
        return Integer.toString(Build.VERSION.SDK_INT);
    }

    public String getDeviceAndSdkVersion() {
        return getDeviceName() + ":" + getSdkVersion();
    }
}

