object HigherOrderFunctions {

    // returns a function that increments a given argument with a predefined amount
    def plus(x:Int):(Int => Int) = (y:Int) => ???

    // returns a function that subtracts a given argument with a predefined amount
    def minus(x:Int):(Int => Int) = ???

    // calls 'action' function with the given x argument and returns the result
    def doIt(x:Int, action: (Int => Int)):Int = ???

    /** combines two functions that both take integer arguments by passing the result from
      * the first function as the argument to the second function, and returns its return value
      */
    def combineInt(first: (Int => Int), second: (Int => Int)):(Int => Int) = ???

    // combines two functions of generic types
    def combine[A, B, C](first: (A => B), second: (B => C)):(A => C) = ???

    /** converts a two-argument integer-taking function to a single-argument function
      * where the argument is fixed with given 'param'
      */
    def curry2int(fn: (Int, Int) => Int, param: Int): (Int => Int) = ???

    /** 'curries' a two-argument generic function - i.e. translates the evaluation of a function 
      * that takes two arguments into evaluating a sequence of functions, each with a single argument
      */
    def curry2[A, B, C](fn: (A, B) => C): (A => (B => C)) = ???





    def main(args: Array[String]) {
        
        println(s"${Console.GREEN}Running ${tests.size} tests:")

        tests.foreach { (fixture) =>
            val name = fixture._1
            val test = fixture._2
            try {
                print(s"${Console.GREEN}\t- '$name': ")
                test()
                println("PASS!")
            } catch {
                case e:Error => {
                    println(Console.RED + e.getMessage)
                }
            }

        }
    }

    def verify(expected: Any, actual: Any) =
        assert(expected == actual, s"Expected: $expected, actual: $actual")

    val tests = List[(String, Function0[Unit])](
        ("plus", () => {
            verify(6, plus(4)(2))
            verify(4, plus(2)(2))
        }),
        ("minus", () => {
            verify(2, minus(4)(6))
            verify(0, minus(2)(2))
        }),
        ("do it!",() => {
            verify(2, doIt(4, minus(2)))
            verify(20, doIt(10, plus(10)))
        }),
        ("combine integer functions", () => {
            verify(20, combineInt(plus(10), minus(5))(15))
            verify(12, combineInt(plus(6), minus(1))(7))
        }),
        ("combine generic functions", () => {
            verify(8, combine(characters, plus(4))("five"))
            verify("234", combine((x:Int) => x.toString, (s:String) => s + "34")(2))
        }),
        ("curry with integers", () => {
            verify(4, curry2int(plus, 4)(0))
            verify(200, curry2int((x:Int, y:Int) => x + y * 2, 4)(98))
        }),
        ("generic two-argument curry", () => {
            verify(5, curry2(plus)(2)(3))
            verify(17, curry2((x:Int, y:Int) => x + y * 5)(2)(3))
        })
    )

    // counts the number of characters in a given string
    def characters(name: String):Int = name.length

    val plus = (x:Int, y:Int) => x + y

}