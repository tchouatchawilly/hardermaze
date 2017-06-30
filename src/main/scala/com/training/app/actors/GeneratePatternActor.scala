package com.training.app.actors

import akka.actor.{Actor, ActorRef, Props}
import akka.event.Logging

/**
  * Created by willy.s.kouemapoh on 6/29/2017.
  * Convert Decimal to binaries and send message to Validate actor.
  */
class GeneratePatternActor extends Actor {
  val log = Logging(context.system, this)
  //  var validatePatternActor = context.actorOf(Props[ValidatePatternActor], name = actorName)
  var validatePatternActor: ActorRef = null
  var actorName = ""

  def this(actorid: String) = {
    this()
    this.actorName = actorid
    this.validatePatternActor = context.actorOf(Props[ValidatePatternActor], name = this.actorName)
  }

  def receive = {
    case (patterns: List[Int]) => {
      //convert the pattern to binary
      //and send it to validator actor.
      log.info("receive list : " + patterns)
      var convertList = for (e <- patterns) yield e % 2
      validatePatternActor ! convertList
    }
    case _ => log.info("receive unknow message")
  }
}
