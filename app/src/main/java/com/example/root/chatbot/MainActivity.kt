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
            var counter=0
            while(counter<500){
            var wifiManager = this.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
                //var confList=wifiManager.configuredNetworks
            var t=wifiManager.connectionInfo
            var h:List<ScanResult> =wifiManager.scanResults // need location setting for scanResults as well as permission

            for(i in h){
                if(i.SSID.toString().equals("DCU-Guest-WiFi") or i.SSID.toString().equals("eduroam")){
                f.appendText("${i.SSID},${i.level},")}
            }
                f.appendText("\n")


                //text1.setText(i.level.toString())
                //text2.setText(i.SSID)
                counter+=1
                }

            displayrssi.setText("finished")

                }

            }
            }





