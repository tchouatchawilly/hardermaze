package com.training.app

import akka.actor.{ActorSystem, Props, TypedActor}
import com.training.app.actors.GeneratePatternActor


/**
  * @author ${user.name}
  */
object App {

  def foo(x: Array[String]) = x.foldLeft("")((a, b) => a + b)

  def main(args: Array[String]) {
    //    println("Hello World!")
    //    println("concat arguments = " + foo(args))
    val system = ActorSystem("HarderMazeSystem")
    val generatePatternActor1 = system.actorOf(Props(new GeneratePatternActor("validatePatternActor1")), name = "generatePatternActor1")
    val generatePatternActor2 = system.actorOf(Props(new GeneratePatternActor("validatePatternActor2")), name = "generatePatternActor2")
    //    val generatePatternActor2 = system.actorOf(Props[GeneratePatternActor], name = "generatePatternActor2")
    generatePatternActor1 ! List(1, 2, 3, 4, 5, 6, 5, 2, 5, 6, 5, 8, 4, 8, 7)
    generatePatternActor2 ! List(9, 65, 4, 2, 5, 8, 7, 4, 9, 8, 7, 5, 1, 1, 6)
  }
}
