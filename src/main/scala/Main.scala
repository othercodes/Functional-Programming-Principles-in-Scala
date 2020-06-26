import week03.{Empty, NonEmpty}

object Main {
  def main(args: Array[String]): Unit = {
    val t1 = new NonEmpty(3, Empty, Empty)
    val t2 = t1 incl 5
    println(t2)
  }
}