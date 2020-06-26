val tolerance = 0.0001
def isCloseEnough(x: Double, y: Double): Boolean =
  math.abs((x - y) / x) / x < tolerance

def fixedPoint(f: Double => Double)(firstGuess: Double): Double = {
  @scala.annotation.tailrec
  def iterate(guess: Double): Double = {
    val next = f(guess)
    if (isCloseEnough(guess, next)) next
    else iterate(next)
  }

  iterate(firstGuess)
}

fixedPoint(x => 1 + x / 2)(1)

def sqrt(x: Double): Double = fixedPoint(y => (y + x / y) / 2)(1)

sqrt(9)

def averageDamp(f: Double => Double)(x: Double): Double = (x + f(x)) / 2

def sqrtAverageDamp(x: Double) =
  fixedPoint(averageDamp(y => x / y))(1)

sqrtAverageDamp(9)