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

