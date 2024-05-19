package com.example.easychat.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.easychat.R;
import com.example.easychat.model.UserModel;

public class AndroidUtil {
    public static  void showToast(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }

    public static void passUserModelAsIntent(Intent intent, UserModel model){
        intent.putExtra("username",model.getUsername());
        intent.putExtra("phone",model.getPhone());
        intent.putExtra("userId",model.getUserId());
        intent.putExtra("fcmToken",model.getFcmToken());

    }

    public static UserModel getUserModelFromIntent(Intent intent){
        UserModel userModel = new UserModel();
        userModel.setUsername(intent.getStringExtra("username"));
        userModel.setPhone(intent.getStringExtra("phone"));
        userModel.setUserId(intent.getStringExtra("userId"));
        userModel.setFcmToken(intent.getStringExtra("fcmToken"));
        return userModel;
    }

//    public static void setProfilePic(Context context, Uri imageUri, ImageView imageView){
//        Glide.with(context).load(imageUri).apply(RequestOptions.circleCropTransform()).into(imageView);
//    }

    public static void setProfilePic(Context context, Uri uri, ImageView imageView) {
        if (context != null && imageView != null) {
            RequestManager glide = Glide.with(context);
            if (glide != null) {
                glide.load(uri)
     .apply(RequestOptions.circleCropTransform()
                          .placeholder(R.drawable.person_icon)
                          .error(R.drawable.person_icon)) // Add an error placeholder
     .into(imageView);
            }
        }
    }
}
