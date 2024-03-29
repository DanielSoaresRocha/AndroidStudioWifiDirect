package com.example.bolsista.wifidirectaplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.widget.Toast;

import com.example.bolsista.wifidirectaplication.MainActivity;

public class WifiDirectBroadcastReceiver extends BroadcastReceiver {
    private WifiP2pManager mManager; //Gerenciador de wifi P2P
    private WifiP2pManager.Channel mChannel;
    private MainActivity mActivity;

    public WifiDirectBroadcastReceiver(WifiP2pManager mManager, WifiP2pManager.Channel mChannel, MainActivity mActivity){
        this.mManager = mManager;
        this.mChannel = mChannel;
        this.mActivity = mActivity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();


        if(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action)){ //indica se o wifi p2p está ativado
            //estado do Wifi
            int state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE,-1);

            if(state == WifiP2pManager.WIFI_P2P_STATE_ENABLED) {
                Toast.makeText(context, "Wifi está ligado", Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(context, "Wifi desligado", Toast.LENGTH_SHORT).show();
            }
        }else if(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(action)){ //indica que a lista de PEERS disponível foi alterada
            //do something
            if(mManager!=null)
            {
                mManager.requestPeers(mChannel,mActivity.peerListListener);
            }
        }else if(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(action)){ // INDICA SE O ESTADO DE CONECTIVIDADE P2P WIFI MUDOU
            //do something
            if(mManager==null)
            {
                return;
            }

            NetworkInfo networkInfo = intent.getParcelableExtra(WifiP2pManager.EXTRA_NETWORK_INFO);

            if(networkInfo.isConnected())
            {
                mManager.requestConnectionInfo(mChannel,mActivity.connectionInfoListener);
            }else{
                mActivity.connectionStatus.setText("Device Disconnected");
            }
        }else if(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION.equals(action)){ // indica que os detalhes de configuração deste dispositivo foram alterados
            //do something
        }
    }
}
