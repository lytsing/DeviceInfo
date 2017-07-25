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

import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.text.format.Formatter;
import android.util.Log;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class DeviceInfoActivity extends PreferenceActivity {

    private final static String TAG = "DeviceInfoActivity";

    private Preference mSdStorage;
    private Preference mProcessor;
    private Preference mMemory;
    private Preference mNetAddress;
    private Preference mMoreInfo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.main);

        mSdStorage = findPreference("sd_storage");
        mSdStorage.setSummary(R.string.info_not_available);

        mProcessor = findPreference("processor");
        mProcessor.setSummary("ARMv6-compatible processor rev 2 (v6l)");

        mNetAddress = findPreference("net_address");

        mMemory = findPreference("memory");
        mMoreInfo = findPreference("more_info");

        setNetAddress();

    }

    private void setNetAddress() {
        String ip = getLocalIpAddress();
        if (ip != null) {
            mNetAddress.setSummary(ip);
        } else {
            mNetAddress.setSummary(R.string.info_not_available);
        }
    }

    /**
     * Obtain IP address of current device
     * @return ip address
     */
    public String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en
                    .hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr
                        .hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException e) {
            Log.e(TAG, e.toString());
        }
        return null;
    }

    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if (preference == mMoreInfo) {
            // TODO:
            //startActivity();
            //return true;
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setClass(this, MarketInfoActivity.class);
            startActivity(intent);
        }

        return false;

    }

    private String formatSize(long size) {
        return Formatter.formatFileSize(this, size);
    }
}

