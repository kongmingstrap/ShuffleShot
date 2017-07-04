import scala.util.{Try, Success, Failure, Random}

//import scala.util.Random

object ShuffleShot {
  def main(args: Array[String]): Unit = {
    if (args.length == 0) {
      println("required filename to sbt \"run hoge.txt\"\n")
      return
    }
    val filename = args(0)
    Try(scala.io.Source.fromFile(filename)) match {
      case Success(source) => {
        val lines = try source.mkString finally source.close()
        val shuffle = Random.shuffle(lines.lines.toList)
        shuffle.foreach(s => println(s))
      }
      case Failure(error) => println(error.toString)
    }
  }
}