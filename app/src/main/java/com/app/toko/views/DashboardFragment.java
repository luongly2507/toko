package com.app.toko.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.toko.R;
import com.app.toko.adapters.CategoryAdapter;
import com.app.toko.databinding.FragmentDashboardBinding;
import com.app.toko.responses.CategoryResponse;
import com.app.toko.viewmodels.DashboardViewModel;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private DashboardViewModel dashboardViewModel;
    private CategoryAdapter categoryAdapter;
    private RecyclerView categoryRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        categoryRecyclerView = root.findViewById(R.id.recycler_view_category);
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        dashboardViewModel.getAllParentsCategory();
        dashboardViewModel.getCategoryResponsesLiveData().observe(getViewLifecycleOwner(), categoryResponses -> {
            System.out.println("CategoryResponse Body: "+ categoryResponses);
            categoryAdapter = new CategoryAdapter(getContext(), (ArrayList<CategoryResponse>) categoryResponses);
            categoryRecyclerView.setAdapter(categoryAdapter);
            categoryRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}