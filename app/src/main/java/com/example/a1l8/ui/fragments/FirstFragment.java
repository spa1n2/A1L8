package com.example.a1l8.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.a1l8.R;
import com.example.a1l8.adapters.FirstFragmentAdapter;
import com.example.a1l8.databinding.FragmentFirstBinding;
import com.example.a1l8.models.TextModel;

import java.util.ArrayList;


public class FirstFragment extends Fragment {
    FragmentFirstBinding binding;
    private Bundle bundle;
    private TextModel text;
    private ArrayList<TextModel> list;
    private FirstFragmentAdapter firstFragmentAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firstFragmentAdapter = new FirstFragmentAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupListeners();
    }

    @Override
    public void onStart() {
        super.onStart();
        getDate();
    }

    private void setupListeners() {
        binding.btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(requireView()).navigate(R.id.secondFragment);
            }
        });
    }

    private void getDate() {
        if (getArguments() != null) {
            list = new ArrayList<>();
            bundle = getArguments();
            text = (TextModel) bundle.getSerializable("key");
            firstFragmentAdapter.addItem(text);
            Log.e("TAG", "getDate" + text.toString());
        } else {
            Log.e("TAG", "getDate: you");
        }
        binding.recyclerFragment.setAdapter(firstFragmentAdapter);
    }
}