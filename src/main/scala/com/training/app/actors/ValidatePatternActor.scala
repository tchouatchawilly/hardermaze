package com.training.app.actors

import akka.actor.{Actor, Props}
import akka.event.Logging

/**
  * Created by willy.s.kouemapoh on 6/29/2017.
  * Validate the given pattern by verifying if it's not a fence.
  */
class ValidatePatternActor extends Actor {
  val log = Logging(context.system, this)
  val checkOpenPatternActor = context.actorOf(Props[CheckOpenPatternActor], name = "checkOpenPatternActor")
  
  def receive = {
    case (patterns: List[Int]) => {
      patterns.foreach(e => {
        var grid = Array.ofDim[Int](3, 3)
        checkOpenPatternActor ! grid
      })
    }
    case _ => log.info("receive unknown message")
  }

}
