package br.com.edsonmoretti.rest.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class ResourceNotFountException(exception: String?): java.lang.RuntimeException(exception) {

}