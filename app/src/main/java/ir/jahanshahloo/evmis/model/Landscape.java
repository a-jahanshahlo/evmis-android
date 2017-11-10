package ir.jahanshahloo.evmis.model;

import java.util.ArrayList;

import ir.jahanshahloo.evmis.R;

/**
 * Created by Alireza on 6/27/2016.
 */
public class Landscape {
    private String Title;
    private String Desc;
    private int imageId;


    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }


    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public static ArrayList<Landscape> getData() {
        ArrayList<Landscape> dataList = new ArrayList<>();

        int[] images = getImages();
        for (int i = 0; i < images.length; i++) {
            Landscape item = new Landscape();
            item.setImageId(images[i]);
            item.setTitle("Land " + i);
            dataList.add(item);
        }
        return dataList;
    }

    public static int[] getImages() {
        int[] images = {
                R.drawable.w1,
                R.drawable.w1,
                R.drawable.w1,
                R.drawable.w1,
                R.drawable.w1,
                R.drawable.w1,
                R.drawable.w1,
                R.drawable.w1,
                R.drawable.w1,
                R.drawable.w1,
                R.drawable.w1,
                R.drawable.w1,
                R.drawable.w1,
        };

        return images;
    }
}
