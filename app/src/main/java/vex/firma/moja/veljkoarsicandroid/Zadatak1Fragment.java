package vex.firma.moja.veljkoarsicandroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Zadatak1Fragment extends Fragment {

    public Zadatak1Fragment() {
        // Required empty public constructor
    }

    public static Zadatak1Fragment newInstance() {
        return new Zadatak1Fragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_zadatak1, container, false);
    }

}
