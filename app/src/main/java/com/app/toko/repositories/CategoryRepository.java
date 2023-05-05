package com.app.toko.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.app.toko.repositories.services.CategoryService;
import com.app.toko.responses.CategoryResponse;
import com.app.toko.utils.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryRepository {
    private CategoryService categoryService;
    private MutableLiveData<List<CategoryResponse>> categoryResponsesLiveData;

    public CategoryRepository() {
        categoryResponsesLiveData = new MutableLiveData<>();
        categoryService = ApiUtils.getCategoryService();
    }

    public void getAllParentsCategory() {
        categoryService.getAllParentsCategory().enqueue(
                new Callback<List<CategoryResponse>>() {
                    @Override
                    public void onResponse(Call<List<CategoryResponse>> call, Response<List<CategoryResponse>> response) {
                        System.out.println("On Response: " + response.body().toString());
                        if (response.body() != null) {
                            categoryResponsesLiveData.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<CategoryResponse>> call, Throwable t) {
                        System.out.println("Fail: " + t);
                        categoryResponsesLiveData.postValue(null);
                    }
                }
        );
    }

    public LiveData<List<CategoryResponse>> getCategoryResponseLiveData() {
        return categoryResponsesLiveData;
    }
}
