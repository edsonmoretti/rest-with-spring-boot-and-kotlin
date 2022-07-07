package br.com.edsonmoretti.rest.services

import br.com.edsonmoretti.rest.data.vo.v1.PersonVO
import br.com.edsonmoretti.rest.exceptions.ResourceNotFountException
import br.com.edsonmoretti.rest.mappper.DozerMapper
import br.com.edsonmoretti.rest.models.Person

import br.com.edsonmoretti.rest.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository


    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<PersonVO> {
        return DozerMapper.parseObjects(repository.findAll(), PersonVO::class.java)
    }

    fun findById(id: Long): PersonVO {
        return DozerMapper.parseObject(
            repository.findById(id).orElseThrow { ResourceNotFountException("Person not found") }, PersonVO::class.java
        )
    }

    fun create(person: PersonVO): PersonVO {
        logger.info("create person")
        return DozerMapper.parseObject(
            repository.save(
                DozerMapper.parseObject(
                    person, Person::class.java
                )
            ), PersonVO::class.java
        )
    }

    fun update(person: PersonVO): PersonVO {
        logger.info("update person")
        val entity = repository.findById(person.id).orElseThrow { ResourceNotFountException("Person not found") }
        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender

        return DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
    }

    fun delete(id: Long) {
        logger.info("delete person")
        val person = repository.findById(id).orElseThrow { ResourceNotFountException("Person not found") }
        repository.delete(person)
    }
}