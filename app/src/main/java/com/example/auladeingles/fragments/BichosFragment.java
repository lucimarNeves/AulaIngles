package com.example.auladeingles.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.auladeingles.R;


/**
 * A simple {@link Fragment} subclass.
 */
//implements View.OnClickListener adiciona essa interface, pois não vai usar o onclick, trata todos os eventos de click em um méotodo
public class BichosFragment extends Fragment implements View.OnClickListener {

    private ImageButton buttonCao, buttonGato, buttonLeao, buttonMacaco, buttonOvelha, buttonVaca;

    private MediaPlayer mediaPlayer;

    public BichosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //quando usamos fragment não podemos adicionar a direto o findById temos que atribuir a view primeiro
        View view = inflater.inflate(R.layout.fragment_bichos, container, false);

        buttonCao = view.findViewById(R.id.buttonCao);
        buttonGato = view.findViewById(R.id.buttonGato);
        buttonLeao = view.findViewById(R.id.imageButtonLeao);
        buttonMacaco = view.findViewById(R.id.imageButtonMacaco);
        buttonOvelha = view.findViewById(R.id.imageButtonOvelha);
        buttonVaca = view.findViewById(R.id.imageButtonVaca);

        //recomendado quando tem muitos botões, não utiliza-se nesse caso o onclicklistener, usa-se o this, o próprio listener vai cuidar dos objetos
        buttonCao.setOnClickListener(this);
        buttonGato.setOnClickListener(this);
        buttonLeao.setOnClickListener(this);
        buttonMacaco.setOnClickListener(this);
        buttonOvelha.setOnClickListener(this);
        buttonVaca.setOnClickListener(this);

        return view;
    }

    //implementado após ser adicionado  o implements View.OnClickListener, defino de forma global
    @Override
    public void onClick(View view) {
        //Log.i("Elemento clicado", "Item: " + view.getId());

        switch (view.getId()) {
            case R.id.buttonCao:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog); //getActivity() retorna contexto da activity princiapl
                tocarSom();
                break;
            case R.id.buttonGato:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat);
                tocarSom();
                break;
            case R.id.imageButtonLeao:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion);
                tocarSom();
                break;
            case R.id.imageButtonMacaco:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey);
                tocarSom();
                break;
            case R.id.imageButtonOvelha:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep);
                tocarSom();
                break;
            case R.id.imageButtonVaca:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow);
                tocarSom();
                break;
        }
    }

    public void tocarSom() {
        if (mediaPlayer != null) {
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
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
