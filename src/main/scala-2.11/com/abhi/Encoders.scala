package com.abhi

import io.getquill.context.cassandra.CassandraSessionContext
import scala.reflect.ClassTag
import scala.collection.JavaConverters._

trait SetEncoder {
   this: CassandraSessionContext[_] =>
   implicit def setEncoder[T](implicit t: ClassTag[T]) : Encoder[Set[T]] = {
      encoder((index, value, row) => row.setSet[T](index, value.asJava, t.runtimeClass.asInstanceOf[Class[T]]))
   }
}

trait SetDecoder {
   this: CassandraSessionContext[_] =>
   implicit def setDecoder[T](implicit t: ClassTag[T]) : Decoder[Set[T]] = {
      decoder((index, row) => row.getSet(index, t.runtimeClass.asInstanceOf[Class[T]]).asScala.toSet)
   }
}