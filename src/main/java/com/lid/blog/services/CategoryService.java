package com.lid.blog.services;

import com.lid.blog.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId) throws Throwable;

    void deleteCategory(Integer categoryId) throws Throwable;

    CategoryDto getCategory(Integer categoryId) throws Throwable;

    List<CategoryDto> getCategories();

}
