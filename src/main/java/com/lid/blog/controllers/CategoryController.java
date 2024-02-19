package com.lid.blog.controllers;

import com.lid.blog.payloads.ApiResponse;
import com.lid.blog.payloads.CategoryDto;
import com.lid.blog.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    //create
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createCategory=this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
    }

    //update
    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer catId) throws Throwable {
      CategoryDto updatedCategory=this.categoryService.updateCategory(categoryDto,catId);
      return new ResponseEntity<CategoryDto>(updatedCategory,HttpStatus.OK);
    }

    //delete

    @DeleteMapping("{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId) throws Throwable {
        this.categoryService.deleteCategory(catId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Category is deleted successfully",true, LocalDateTime.now()),HttpStatus.OK);
    }

    //get

    @GetMapping("{catId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId) throws Throwable {
        CategoryDto categoryDto= this.categoryService.getCategory(catId);
        return new ResponseEntity<>(categoryDto,HttpStatus.OK);
    }

    //getAll
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>>getCategories() throws Throwable {
        List<CategoryDto> categories=this.categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }
}
