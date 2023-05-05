package com.app.toko.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {
    @SerializedName("id")
    @Expose
    private UUID id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("parent")
    @Expose
    private UUID parent;
    @SerializedName("imageSource")
    @Expose
    private String imageSource;


}
