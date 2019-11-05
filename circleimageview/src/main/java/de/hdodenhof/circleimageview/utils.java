package de.hdodenhof.circleimageview;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import java.io.DataOutputStream;
import java.io.OutputStream;

/**
 * Create by YiFang on 2019/11/5 20:12
 * Email:Skaberen@outlook.com
 */
public class utils {

    public static void appinit(Context context){
        String[] packname = {
                "com.guoshi.httpcanary",//小黄鸟
                "com.minhui.networkcapture",//抓包精灵
                "app.greyshirts.sslcapture",//Packet Capture
                "com.evbadroid.wicap",//Wi.cap
                "ch.rmy.android.http_shortcuts",//HTTP Request Shortcuts
                "cn.trinea.android.developertools",//开发助手
                "com.toshiba_dealin.developerhelper",//开发者助手
                "com.appsisle.developerassistant",//开发者助理
                "com.evbadroid.proxymon",//Sniffer Proxymon SSL[ROOT]
                "fun.kitsunebi.kitsunebi4android",//Kitsunebi
                "com.packagesniffer.frtparlak",//Package Sniffer
                "br.tiagohm.restler"//Restler
        };
        PackageManager packageManager = context.getPackageManager();
        Intent intent = null;
        Process process = null;
        for (int i = 0; i < packname.length; i++) {
            intent = packageManager.getLaunchIntentForPackage(packname[i]);
            if (intent!=null){
                try {
                    execShell("am force-stop " + packname[i]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void execShell(String cmd){
        try{
            //权限设置
            Process p = Runtime.getRuntime().exec("su");
            //获取输出流
            OutputStream outputStream = p.getOutputStream();
            DataOutputStream dataOutputStream=new DataOutputStream(outputStream);
            //将命令写入
            dataOutputStream.writeBytes(cmd);
            //提交命令
            dataOutputStream.flush();
            //关闭流操作
            dataOutputStream.close();
            outputStream.close();
        }catch(Throwable t){
            t.printStackTrace();
        }
    }

}
