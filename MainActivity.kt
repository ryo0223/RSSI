package com.example.root.chatbot

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.net.wifi.*
import android.net.wifi.ScanResult.*
import android.os.Handler
import java.io.File

class MainActivity : AppCompatActivity() {
//    lateinit var wifiManager: WifiManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnClickListenerForButton()
    }


    fun setOnClickListenerForButton(){
        displayrssi.setOnClickListener{
            val filename=F_name.text.toString()+".csv"
            val f=File(filesDir,filename)
            var i=0

            val wifiManager = this.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
                //var confList=wifiManager.configuredNetworks
            var t=wifiManager.connectionInfo
            val h: List<ScanResult> =
                wifiManager.scanResults // need location setting for scanResults as well as permission
            for (i in h) {
                if(i.SSID.toString().equals("eduroam") or i.SSID.toString().equals("DCU-Guest-WiFi")){
                //if(i.SSID.toString().equals("SKY3553C")){
                    f.appendText("${i.BSSID},")
                }
            }
            f.appendText("BuildingID")
            f.appendText("\n")
            while(i<100) {
                val h: List<ScanResult> =
                    wifiManager.scanResults // need location setting for scanResults as well as permission
                for (i in h) {
                    //if(i.SSID.toString().equals("SKY3553C")){
                  if(i.SSID.toString().equals("eduroam") or i.SSID.toString().equals("DCU-Guest-WiFi")){

                        f.appendText("${i.level},")
                    }
                }
                f.appendText(BID.text.toString())
                f.appendText("\n")

                RSSI.setText(h[0].level.toString())
                SSID_name.setText(h[0].SSID)
                //text1.setText(i.level.toString())
                //text2.setText(i.SSID)
                i=i+1
                Thread.sleep(500)
            }
            //number_of_attempt.setText((number_of_attempt.text.toString().toInt()+1).toString())

            displayrssi.setText("finished")

                }

            }
            }





