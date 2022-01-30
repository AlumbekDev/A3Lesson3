package com.example.a3lesson3.ui.fragments.city;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.a3lesson3.R;
import com.example.a3lesson3.databinding.FragmentCityBinding;

public class CityFragment extends Fragment {
    private FragmentCityBinding binding;
    private NavController controller;
    private String lol;

    public String getLol() {
        return lol;
    }

    public void setLol(String lol) {
        this.lol = lol;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        NavHostFragment hostFragment = (NavHostFragment) requireActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        controller = hostFragment.getNavController();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentCityBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.userField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pol=binding.userField.getText().toString();
                setLol(pol);
                controller.navigate(CityFragmentDirections.actionCityFragmentToWeatherFragment(pol));
            }
        });
    }
}

