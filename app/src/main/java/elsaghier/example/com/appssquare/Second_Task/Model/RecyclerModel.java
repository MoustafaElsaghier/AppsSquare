package elsaghier.example.com.appssquare.Second_Task.Model;

import android.support.v4.app.Fragment;

/**
 * Created by ELSaghier on 1/12/2018.
 */

public class RecyclerModel {
    private int imageId;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    private String tittle;
    private Fragment fragment;
}
