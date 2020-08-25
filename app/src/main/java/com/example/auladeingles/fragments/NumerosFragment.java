package com.example.auladeingles.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.auladeingles.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumerosFragment extends Fragment implements View.OnClickListener {

    private ImageButton imageView1,imageView2,imageView3,imageView4,imageView5,imageView6;
    private MediaPlayer mediaPlayer;


    public NumerosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        imageView1 = view.findViewById(R.id.ImageView1);
        imageView2 = view.findViewById(R.id.ImageView2);
        imageView3 = view.findViewById(R.id.ImageView3);
        imageView4 = view.findViewById(R.id.ImageView4);
        imageView5 = view.findViewById(R.id.ImageView5);
        imageView6 = view.findViewById(R.id.ImageView6);

        //aplicando eventos em click

        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);
        imageView5.setOnClickListener(this);
        imageView6.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View view) {

        switch (view.getId() ){

            case R.id.ImageView1 :
                 mediaPlayer = MediaPlayer.create(getActivity(), R.raw.one);
                 tocarSom();
                 break;

            case R.id.ImageView2 :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.two);
                tocarSom();
                break;

            case R.id.ImageView3 :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.three);
                tocarSom();
                break;

            case R.id.ImageView4 :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.four);
                tocarSom();
                break;

            case R.id.ImageView5 :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.five);
                tocarSom();
                break;

            case R.id.ImageView6 :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.six);
                tocarSom();
                break;

        }

    }

    public void tocarSom(){

        if( mediaPlayer  != null){
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if(mediaPlayer  != null) {

            mediaPlayer.release();
            mediaPlayer = null;

        }
    }
}
