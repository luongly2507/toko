package com.app.toko.repositories.services;

import com.app.toko.responses.CategoryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryService {
    @GET("api/v1/categories/parent")
    Call<List<CategoryResponse>> getAllParentsCategory();
}
