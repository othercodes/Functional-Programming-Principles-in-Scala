def sum(f: Int => Int): (Int, Int) => Int = {
  def sumFunction(a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sumFunction(a + 1, b)

  sumFunction
}
// define an middle function
def sumInt = sum(x => x)
// Execute
sumInt(1, 5)

// Using curried function.
// type: (Int => Int) => (Int, Int) => Int
def sumCurry(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 0 else f(a) + sum(f)(a + 1, b)
// using _ to replace the actual value.
val sumIntCurried = sumCurry(x => x)(_, _)
sumIntCurried(1, 5)


def product(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 1 else f(a) * product(f)(a + 1, b)

product(x => x * x)(3, 4)

def factorial(n: Int) = product(x => x)(1, n)
factorial(5)


// generalize sum and product
def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
  if (a > b) zero else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))


def productMapReduce(f: Int => Int)(a: Int, b: Int): Int =
  mapReduce(f, (x, y) => x * y, 1)(a, b)

product(x => x * x)(3, 4)