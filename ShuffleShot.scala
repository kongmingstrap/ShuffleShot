import scala.util.Random

object ShuffleShot {
  def main(args: Array[String]): Unit = {
    val source = scala.io.Source.fromFile("member.txt")
    val lines = try source.mkString finally source.close()
    val shuffle = Random.shuffle(lines.lines.toList)
    shuffle.foreach(s => print(s + '\n'))
  }
}