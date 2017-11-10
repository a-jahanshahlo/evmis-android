package ir.jahanshahloo.evmis.UI;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.brunodles.compressor.BitmapCompressor;
import com.github.brunodles.pic_picker.PicPicker;
import com.github.brunodles.pic_picker.impl.WritePermissionAsker;
import com.github.brunodles.pic_picker.listener.CantFindCameraAppErrorListener;
import com.github.brunodles.pic_picker.listener.ErrorCreatingTempFileForCameraListener;
import com.github.brunodles.pic_picker.listener.PicResultListener;

import java.io.File;
import java.io.IOException;

import io.codetail.animation.ViewAnimationUtils;
import io.codetail.widget.RevealFrameLayout;
import ir.jahanshahloo.evmis.R;
import ir.jahanshahloo.evmis.Util.anim.AnimatorPath;
import ir.jahanshahloo.evmis.Util.anim.PathEvaluator;
import ir.jahanshahloo.evmis.Util.anim.PathPoint;

import static android.view.View.LAYER_TYPE_HARDWARE;


public class OptionMenuRevealFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View view;
    private OnOptionMenuRevealListener mListener;

    private float maskElevation;
    final static int SLOW_DURATION = 400;
    final static int FAST_DURATION = 200;
    private boolean toggle;

    ViewGroup cardsLine;
    FrameLayout mRevealContainerMask;
    CardView activatorMask;
    AppCompatImageButton reveal_gallery, reveal_camera;
    private ImageView image;

    public OptionMenuRevealFragment() {
        // Required empty public constructor
        toggle = false;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.option_menu_reveal, container, false);
//        picPicker=new PicPicker(view.getContext().)

        cardsLine = (ViewGroup) view.findViewById(R.id.cardsLine);
        activatorMask = (CardView) view.findViewById(R.id.activator_mask);
        mRevealContainerMask = (FrameLayout) view.findViewById(R.id.reveal_container_mask);
        mRevealContainerMask.getBackground().setAlpha(0);
        mRevealContainerMask.setVisibility(View.INVISIBLE);
        reveal_camera = (AppCompatImageButton) view.findViewById(R.id.reveal_camera);
        reveal_gallery = (AppCompatImageButton) view.findViewById(R.id.reveal_gallery);
        image = new ImageView(view.getContext());


        mRevealContainerMask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getToggleState()) {
                    OnClickToggleReveal(false, null);
                }
            }
        });
        reveal_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1 equals camera
                mListener.onClickMenuItem(1);
                OnClickToggleReveal(false, null);

            }
        });
        reveal_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1 equals gallery
                mListener.onClickMenuItem(2);
                OnClickToggleReveal(false, null);
            }
        });
        return view;
    }

    private void reveal() {
        mRevealContainerMask.getBackground().setAlpha(90);
        mRevealContainerMask.setVisibility(View.VISIBLE);
/*        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(mRevealContainerMask, "alpha", 0f, 1f);
        fadeIn.setDuration(FAST_DURATION);*/


        // Coordinates of circle initial point
        final ViewGroup parent = (ViewGroup) activatorMask.getParent();
        final Rect bounds = new Rect();
        final Rect maskBounds = new Rect();


        activatorMask.getDrawingRect(maskBounds);
        //   parent.offsetDescendantRectToMyCoords(activator, bounds);
        parent.offsetDescendantRectToMyCoords(activatorMask, maskBounds);

        // Put Mask view at circle initial points
        maskElevation = activatorMask.getCardElevation();
        activatorMask.setCardElevation(0);
        activatorMask.setVisibility(View.VISIBLE);
        //  activatorMask.setX(bounds.left - maskBounds.centerX());
        //  activatorMask.setY(bounds.top - maskBounds.centerY());


        final int cX = maskBounds.bottom;
        final int cY = maskBounds.right;


        Animator circularReveal =
                ViewAnimationUtils.createCircularReveal(activatorMask, cX, cY, 50,
                        (float) Math.hypot(maskBounds.width(), maskBounds.height()),
                        LAYER_TYPE_HARDWARE);

        final float c0X = bounds.bottom; // bounds.centerX() - maskBounds.centerX();
        final float c0Y = bounds.right;// bounds.centerY() - maskBounds.centerY();

        AnimatorPath path = new AnimatorPath();
        path.moveTo(c0X, c0Y);
        path.curveTo(c0X, c0Y, 0, c0Y, 0, 0);

        ObjectAnimator pathAnimator = ObjectAnimator.ofObject(this, "maskLocation", new PathEvaluator(),
                path.getPoints().toArray());

        AnimatorSet set = new AnimatorSet();
        set.playTogether(circularReveal, pathAnimator);
        set.setInterpolator(new FastOutSlowInInterpolator());
        set.setDuration(SLOW_DURATION);
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                executeCardsSequentialAnimation();
                activatorMask.setCardElevation(maskElevation);
            }

            @Override
            public void onAnimationStart(Animator animation) {

                super.onAnimationStart(animation);
            }
        });
        set.start();
    }

    private void executeCardsSequentialAnimation() {
        final int length = cardsLine.getChildCount();
        cardsLine.setVisibility(View.VISIBLE);

        final Animator[] animators = new Animator[length];
        for (int i = 0; i < length; i++) {
            View target = cardsLine.getChildAt(i);
            final float x0 = 0;// i == 0 ? 0 : -10 * (1 + i * 0.2f);
            final float y0 = 10 * i;

            target.setTranslationX(x0);
            target.setTranslationY(y0);

            AnimatorPath path = new AnimatorPath();
            path.moveTo(x0, y0);
            path.lineTo(0, 0);

            PathPoint[] points = new PathPoint[path.getPoints().size()];
            path.getPoints().toArray(points);

            AnimatorSet set = new AnimatorSet();
            set.play(ObjectAnimator.ofObject(target, PATH_POINT, new PathEvaluator(), points))
                    .with(ObjectAnimator.ofFloat(target, View.ALPHA, 0.8f, 1f));

            animators[i] = set;
            animators[i].setStartDelay(15 * i);
        }

        final AnimatorSet sequential = new AnimatorSet();
        sequential.playTogether(animators);
        sequential.setInterpolator(new FastOutLinearInInterpolator());
        sequential.setDuration(FAST_DURATION);
        sequential.start();
    }

    private final static Property<View, PathPoint> PATH_POINT =
            new Property<View, PathPoint>(PathPoint.class, "PATH_POINT") {
                PathPoint point;

                @Override
                public PathPoint get(View object) {
                    return point;
                }

                @Override
                public void set(View object, PathPoint value) {
                    point = value;

                    object.setTranslationX(value.mX);
                    object.setTranslationY(value.mY);
                }
            };


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnOptionMenuRevealListener) {
            mListener = (OnOptionMenuRevealListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public boolean getToggleState() {
        return toggle;
    }

    public void OnClickToggleReveal(boolean tg, @Nullable View view) {
        if (toggle == tg) {
            return;
        }

        if (tg) {
            reveal();
        } else {
            resetUi();

        }
        toggle = tg;
    }


    public interface OnOptionMenuRevealListener {
        // TODO: Update argument type and name
        void onClickMenuItem(int code);
    }


    void resetUi() {
    /*    ObjectAnimator fadeOut = ObjectAnimator.ofFloat(mRevealContainerMask, "alpha",  1f, 0f);
        fadeOut.setDuration(FAST_DURATION);*/

        cardsLine.setVisibility(View.INVISIBLE);


        // Coordinates of circle initial point
        final ViewGroup parent = (ViewGroup) activatorMask.getParent();
        final Rect bounds = new Rect();
        final Rect maskBounds = new Rect();


        activatorMask.getDrawingRect(maskBounds);

        parent.offsetDescendantRectToMyCoords(activatorMask, maskBounds);

        maskElevation = activatorMask.getCardElevation();
        activatorMask.setCardElevation(0);

        final int cX = maskBounds.centerX();
        final int cY = maskBounds.centerY();

        final Animator circularReveal = ViewAnimationUtils.createCircularReveal(activatorMask, cX, cY,
                (float) Math.hypot(maskBounds.width() * .5f, maskBounds.height() * .5f),
                50 / 2f, View.LAYER_TYPE_HARDWARE);

        final float c0X = bounds.centerX() - maskBounds.centerX();
        final float c0Y = bounds.centerY() - maskBounds.centerY();

        AnimatorPath path = new AnimatorPath();
        path.moveTo(0, 0);
        path.curveTo(0, 0, 0, c0Y, c0X, c0Y);

        ObjectAnimator pathAnimator = ObjectAnimator.ofObject(this, "maskLocation", new PathEvaluator(),
                path.getPoints().toArray());

        AnimatorSet set = new AnimatorSet();
        set.playTogether(circularReveal, pathAnimator);
        set.setInterpolator(new FastOutSlowInInterpolator());
        set.setDuration(SLOW_DURATION);
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                activatorMask.setCardElevation(maskElevation);
                activatorMask.setVisibility(View.INVISIBLE);
                mRevealContainerMask.getBackground().setAlpha(0);
                mRevealContainerMask.setVisibility(View.INVISIBLE);
            }
        });
        set.start();
    }


}
