package elsaghier.example.com.appssquare.Second_Task.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import elsaghier.example.com.appssquare.R;

/**
 * Created by ELSaghier on 1/12/2018.
 */

public class ContactUsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.contact_us_layout,container,false);
    }
}
