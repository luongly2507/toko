package com.app.toko.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.app.toko.repositories.CategoryRepository;
import com.app.toko.responses.CategoryResponse;

import java.util.List;

public class DashboardViewModel extends ViewModel {

    private CategoryRepository categoryRepository;
    private LiveData<List<CategoryResponse>> categoryResponsesLiveData;


    public DashboardViewModel() {
        categoryRepository = new CategoryRepository();
        categoryResponsesLiveData = categoryRepository.getCategoryResponseLiveData();
    }

    public void getAllParentsCategory() {
        categoryRepository.getAllParentsCategory();
    }

    public LiveData<List<CategoryResponse>> getCategoryResponsesLiveData() {
        return categoryResponsesLiveData;
    }
}