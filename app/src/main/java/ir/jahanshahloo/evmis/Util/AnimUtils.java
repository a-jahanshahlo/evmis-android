package ir.jahanshahloo.evmis.Util;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableRow;

import java.util.ArrayList;
import java.util.Collection;

import ir.jahanshahloo.evmis.R;
import ir.jahanshahloo.evmis.Util.anim.PathPoint;

/**
 * Created by Ali on 8/2/2016.
 */
public class AnimUtils {

    static int ANIMATION_DURATION=500;//in milisecond
    public static void expand(final View v) {

        v.measure(LinearLayoutCompat.LayoutParams.MATCH_PARENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT);
        final int targtetHeight = v.getMeasuredHeight();

        v.getLayoutParams().height = 0;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation()
        {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? LinearLayoutCompat.LayoutParams.WRAP_CONTENT
                        : (int)(targtetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration(ANIMATION_DURATION);

        // a.setDuration((int)(targtetHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }



    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation()
        {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if(interpolatedTime == 1){
                    v.setVisibility(View.GONE);
                }else{
                    v.getLayoutParams().height = initialHeight - (int)(initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration(ANIMATION_DURATION);
        // a.setDuration((int)(initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }


    public static void setRotationAnim(AppCompatActivity act, final ImageButton button_expand_house , final LinearLayoutCompat linearLayoutCompat_expandable){

        final Animation button_expand;
        final Animation button_collapse;
        button_expand = AnimationUtils.loadAnimation(act.getBaseContext(), R.anim.button_expand);
        button_collapse = AnimationUtils.loadAnimation(act.getBaseContext(), R.anim.button_collapse);

        button_expand_house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {


                if (linearLayoutCompat_expandable.getVisibility() == View.GONE) {

                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) v.getLayoutParams();

                    v.setLayoutParams(layoutParams);
                    v.startAnimation(button_expand);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            AnimUtils.expand(linearLayoutCompat_expandable);

                        }
                    }, 1);

                } else {

                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) v.getLayoutParams();

                    v.setLayoutParams(layoutParams);
                    v.startAnimation(button_collapse);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            AnimUtils.collapse(linearLayoutCompat_expandable);

                        }
                    }, 1);

                }
            }
        });
    }

}
