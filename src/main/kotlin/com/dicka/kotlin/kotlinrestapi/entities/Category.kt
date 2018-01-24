package com.dicka.kotlin.kotlinrestapi.entities

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "category",
        catalog = "belajar_laravel")
class Category{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idcategory: Int = 0

    @get: NotBlank
    @Column(name = "name", nullable = false)
    val name: String = ""

    @get: NotBlank
    @Column(name="description", nullable = false)
    val description = ""

}