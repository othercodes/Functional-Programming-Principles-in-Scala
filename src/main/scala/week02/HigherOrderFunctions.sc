def sum(f: Int => Int, a: Int, b: Int): Int = {
  @scala.annotation.tailrec
  def loop(a: Int, accumulator: Int): Int = {
    if (a > b) accumulator
    else loop(a + 1, f(a) + accumulator)
  }

  loop(a, 0)
}

sum(x => x * x, 3, 5)