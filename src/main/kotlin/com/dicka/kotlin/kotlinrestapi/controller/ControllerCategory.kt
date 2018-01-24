package com.dicka.kotlin.kotlinrestapi.controller

import com.dicka.kotlin.kotlinrestapi.entities.Category
import com.dicka.kotlin.kotlinrestapi.repository.CategoryRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class ControllerCategory(private val categoryRepository: CategoryRepository){

    //list category
    @GetMapping("/category")
    fun getAllCategory()
            :List<Category> = categoryRepository.findAll();

    //insert category
    @PostMapping("/create")
    fun getInsertCategory(@Valid @RequestBody category:Category)
            :Category = categoryRepository.save(category);

    //get idcategory
    @GetMapping("/category/{idcategory}")
    fun getIdcategory(@PathVariable("idcategory")idcategory: Int):ResponseEntity<Category>{
        return categoryRepository.findById(idcategory)
                .map { categoryid -> ResponseEntity.ok(categoryid)
                }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping(value = "/update/{idcategory}")
    fun getUpdateCategory(@PathVariable(value = "idcategory")idcategory: Int,
                          @Valid @RequestBody category: Category):ResponseEntity<Category>{
        
        return ResponseEntity(categoryRepository.save(category),HttpStatus.CREATED);
    }

    //delete category
    @DeleteMapping("/delete/{idcategory}")
    fun getDelete(@PathVariable("idcategory")categoryId: Int):ResponseEntity<Void>{

        return categoryRepository.findById(categoryId).map {
            category -> categoryRepository.delete(category)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity(HttpStatus.NOT_FOUND))
    }
}