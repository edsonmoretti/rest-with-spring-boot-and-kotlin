package br.com.edsonmoretti.rest.exceptions.handler

import br.com.edsonmoretti.rest.exceptions.ExceptionResponse
import br.com.edsonmoretti.rest.exceptions.ResourceNotFountException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.Date

@ControllerAdvice
@RestController
class CustomizeResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest)
            : ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(
            Date(),
            ex.message,
            request.getDescription(false)
        )
        return ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(ResourceNotFountException::class)
    fun handleResourceNotFountException(ex: Exception, request: WebRequest)
            : ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(
            Date(),
            ex.message,
            request.getDescription(false)
        )
        return ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND)
    }
}