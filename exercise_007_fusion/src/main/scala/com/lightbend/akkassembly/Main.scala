package com.lightbend.akkassembly

import java.nio.file.FileSystems

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.alpakka.file.scaladsl.DirectoryChangesSource
import akka.stream.scaladsl.Source

import scala.concurrent.duration.FiniteDuration
import scala.concurrent.duration._

object Main {
  def main(args: Array[String]): Unit = {

    implicit val system = ActorSystem("akkassembly")
    implicit val materializer = ActorMaterializer()
    implicit val loggingAdapter = system.log
    import system.dispatcher
  val path = args(0)

    val fs = FileSystems.getDefault
    val changes = DirectoryChangesSource(fs.getPath(path), pollInterval = 1.second, maxBufferSize = 1000)
    changes.runForeach {
      case (path, change) => println("Path: " + path + ", Change: " + change)
    }


  }
}