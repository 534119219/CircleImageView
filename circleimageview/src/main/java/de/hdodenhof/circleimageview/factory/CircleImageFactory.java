package de.hdodenhof.circleimageview.factory;

import android.content.Context;

import androidx.annotation.NonNull;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Create by YiFang on 2019/11/5 20:02
 * Email:Skaberen@outlook.com
 */
public final class CircleImageFactory {

    public static void init(@NonNull Context context) {
        CircleImageView.load(context);
    }

}
