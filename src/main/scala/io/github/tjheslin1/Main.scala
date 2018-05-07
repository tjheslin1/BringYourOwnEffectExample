package io.github.tjheslin1

import cats.Monad
import io.github.tjheslin1.gymbookings.Classes.defaultClasses
import io.github.tjheslin1.gymbookings.{Classes, Member, Members}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}

import scala.concurrent.duration._

object Main extends App {

  implicit val futureMonad: Monad[Future] = cats.instances.future.catsStdInstancesForFuture

  val classes = Classes[Future]()
  val allClasses = for {
    _ <- classes.populate(defaultClasses)
    all <- classes.availableClasses()
  } yield all

  val members = Members[Future]()
  val allMembers = for {
    _ <- members.register(Member("Tom"))
    _ <- members.register(Member("Fiona"))
    _ <- members.register(Member("Sam"))
    all <- members.allMembers()
  } yield all

  val classesResult = Await.result(allClasses, 1 second)
  val membersResult = Await.result(allMembers, 1 second)

  println(s"classes = $classesResult")
  println(s"members = $membersResult")
}
