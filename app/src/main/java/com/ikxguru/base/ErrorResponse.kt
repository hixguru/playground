package com.ikxguru.base

data class ErrorResponse(
    val message: String
) {
    companion object {
        val NO_BODY = ErrorResponse("No body")
    }
}