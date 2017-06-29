package com.training.app.actors

import akka.actor.Actor

/**
  * Created by willy.s.kouemapoh on 6/29/2017.
  * Check the receive pattern by verifying if it's open.
  */
class CheckOpenPatternActor extends Actor {

  def receive = {
    case a => a
  }

}
