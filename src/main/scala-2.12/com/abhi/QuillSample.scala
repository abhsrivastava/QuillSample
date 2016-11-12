package com.abhi

import java.util.UUID

import io.getquill.CassandraSyncContext
import io.getquill.SnakeCase
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by abhsrivastava on 11/10/16.
  */
object QuillSample extends App {
   lazy val ctx = new CassandraSyncContext[SnakeCase]("ctx")
   import ctx._
   val getAllRows = quote {
      query[Movies]
   }
   val result = ctx.run(getAllRows)
   println(result)
}

case class Movies(uUID: UUID,
                  avgRating: Float,
                  genres: Set[String],
                  name: String,
                  releaseDate: java.util.Date,
                  videoReleaseDate: java.util.Date)