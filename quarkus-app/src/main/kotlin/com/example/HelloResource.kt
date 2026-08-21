package com.example

import com.example.shared.SharedUtil
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path

@Path("/hello")
class HelloResource {
    @GET
    fun hello(): String = SharedUtil.greet("World")
}
