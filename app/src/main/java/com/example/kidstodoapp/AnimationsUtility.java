package com.example.kidstodoapp;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class AnimationsUtility {
    public static void toggleEntryVisibility(View view, Context context) {
        if(view.isShown()) {
            view.setVisibility(View.GONE);
//            AnimationsUtility.toggleClose(context, view);
        }
        else {
            view.setVisibility(View.VISIBLE);
            AnimationsUtility.toggleOpen(context, view);
        }
    }

    public static void toggleEntryVisibility(View view, Context context, String string) {
        if (view.isShown()) {
            view.setVisibility(View.GONE);
//            AnimationsUtility.toggleClose(context, view);
        }
        else {
            if(ParentModeUtility.getInstance().isInParentMode()) {
                view.setVisibility(View.VISIBLE);
                AnimationsUtility.toggleOpen(context, view);
            }
            else {
                Toast.makeText(context,
                        "Please enter Parent Mode to " + string,
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static void toggleOpen(Context context, View view) {
        Animation toggleOpen = AnimationUtils.loadAnimation(context, R.anim.toggle_open);
        if(toggleOpen != null) {
            toggleOpen.reset();
            if(view != null) {
                view.clearAnimation();
                view.startAnimation(toggleOpen);
            }
        }
    }
    public static void toggleClose(Context context, View view) {
        Animation toggleClose = AnimationUtils.loadAnimation(context, R.anim.toggle_close);
        if(toggleClose != null) {
            toggleClose.reset();
            if(view != null) {
                view.clearAnimation();
                view.startAnimation(toggleClose);
            }
        }
    }
}
