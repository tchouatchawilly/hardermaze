package com.training.app.actors

import akka.actor.Actor
import akka.event.Logging

/**
  * Created by willy.s.kouemapoh on 6/29/2017.
  * Check the receive pattern by verifying if it's open.
  */
class CheckOpenPatternActor extends Actor {
  val log = Logging(context.system, this)

  def receive = {
    case (grid: Array[Array[Int]]) => {
      log.info("receive grid message :" + grid)
    }
    case _ => log.info("Unknown message")
  }
}
