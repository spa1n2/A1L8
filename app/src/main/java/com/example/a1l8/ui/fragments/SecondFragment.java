package com.example.a1l8.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.a1l8.R;
import com.example.a1l8.databinding.FragmentSecondBinding;
import com.example.a1l8.models.TextModel;

public class SecondFragment extends Fragment {

    FragmentSecondBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupListener();
    }


    private void setupListener() {
        binding.btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = binding.etText.getText().toString().trim();
                Bundle bundle = new Bundle();
                TextModel textModel = new TextModel(s);
                bundle.putSerializable("key", textModel);
                FirstFragment firstFragment = new FirstFragment();
                firstFragment.setArguments(bundle);
                Navigation.findNavController(requireView()).navigate(R.id.firstFragment, bundle);
            }
        });
    }
}