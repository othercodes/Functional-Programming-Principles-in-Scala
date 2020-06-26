@scala.annotation.tailrec
def gcd(a: Int, b: Int): Int =
  if (b == 0) a else gcd(b, a % b)

gcd(14, 21)

def factorial(n: Int): Int =
  if (n == 0) 1 else n * factorial(n - 1)

factorial(5)

def factorialTailRec(n: Int): Int = {
  @scala.annotation.tailrec
  def loop(accumulator: Int, n: Int): Int =
    if (n == 0) accumulator
    else loop(accumulator * n, n - 1)

  loop(1, n)
}

factorialTailRec(5)