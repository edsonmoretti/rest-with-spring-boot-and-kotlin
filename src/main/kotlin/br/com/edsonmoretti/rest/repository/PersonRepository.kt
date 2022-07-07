package br.com.edsonmoretti.rest.repository

import br.com.edsonmoretti.rest.models.Person
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

@Repository
interface PersonRepository : JpaRepository<Person, Long?>