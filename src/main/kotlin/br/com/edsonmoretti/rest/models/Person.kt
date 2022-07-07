package br.com.edsonmoretti.rest.models

import javax.persistence.*

@Entity
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(nullable = false, length = 80)
    var firstName: String = "",

    @Column(nullable = false, length = 80)
    var lastName: String = "",

    @Column(nullable = false, length = 100)
    var address: String = "",

    @Column(nullable = false)
    var gender: String = ""
)