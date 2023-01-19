package com.test.project.testproject.data.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * Wyjątek na potrzeby projektu
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
internal class NotFoundException(
    override val message: String?
) : RuntimeException()