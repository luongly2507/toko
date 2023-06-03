package com.app.toko.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.toko.R;
import com.app.toko.databinding.FragmentRegisterBinding;

public class RegisterFragment extends Fragment {
    FragmentRegisterBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater , container , false);
        NavHostFragment navHostFragment = (NavHostFragment) getParentFragment().getParentFragmentManager().findFragmentById(R.id.nav_host_fragment_register);
        binding.buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navHostFragment.getNavController().navigate(R.id.registerPersonalInfoFragment);
            }
        });

        return binding.getRoot();
    }
}