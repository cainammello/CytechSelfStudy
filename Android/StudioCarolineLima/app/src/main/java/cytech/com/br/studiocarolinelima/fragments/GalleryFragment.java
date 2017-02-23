package cytech.com.br.studiocarolinelima.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cytech.com.br.studiocarolinelima.R;

public class GalleryFragment extends Fragment{

    View view;

    @Nullable
    @Override
    //Method that receives informations about the fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Start the View Object with a layout (inflate that)
        view = inflater.inflate(R.layout.gallery_layout, container, false);
        //return a View Object
        return view;
    }
}
