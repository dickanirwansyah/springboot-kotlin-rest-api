package com.dicka.kotlin.kotlinrestapi.repository

import com.dicka.kotlin.kotlinrestapi.entities.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, Int> {
}