package br.com.edsonmoretti.rest

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {
    val counter: AtomicLong = AtomicLong()

    @RequestMapping("/greeting")
    fun greeting(@RequestParam(value="nameS", defaultValue = "Word") nameS: String?): Greeting {
        return Greeting(counter.incrementAndGet(), "Hello, $nameS!")
    }
}