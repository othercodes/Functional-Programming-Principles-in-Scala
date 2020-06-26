package week02

class Rational(x: Int, y: Int) {

  require(y != 0, "Denominator must not be 0")

  // additional constructor that match when the class
  // is instantiated with one argument
  def this(x: Int) = this(x, 1)

  val numerator: Int = x / gcd(x, y)

  val denominator: Int = y / gcd(x, y)

  @scala.annotation.tailrec
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def less(that: Rational): Boolean =
    numerator * that.denominator < that.numerator * denominator

  def max(that: Rational): Rational = if (less(that)) that else this

  def add(that: Rational): Rational =
    new Rational(
      numerator * that.denominator + that.numerator * denominator,
      denominator * that.denominator
    )

  def neg: Rational =
    new Rational(-numerator, denominator)

  def sub(that: Rational): Rational =
    add(that.neg)

  override def toString: String = numerator + "/" + denominator
}
