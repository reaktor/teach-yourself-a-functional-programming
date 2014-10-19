object Functions {

    // adds two integers together
    def plus(x: Int, y:Int):Int = ???
    
    // salutes the given name, e.g. Hello, User
    def salutation(name: String):String = ???

    // counts the number of characters in a given string
    def characters(name: String):Int = ???

    // counts the number of characters in a given string
    def pow(x: Int, y: Int) = ???

    /** Salutes the user according to the time of day given in isDayTime
      * During daytime, salutes with "Hello". During nighttime, salutes with "Good night"
      */
    def dayOrNightSalutation(name:String, isDayTime: Boolean) = ???

    // return first two names in a given list
    def firstTwo(names: List[String]) = ???

    // return the last name in a given list
    def lastName(names: List[String]) = ???

    // combines two lists
    def combine(names: List[String], letters: List[String]) = ???



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

    val tests = List[(String, Function0[Unit])](
        ("plus", () => {
            verify(6, plus(2, 4))
            verify(4, plus(2, 2))
        }),
        ("salutation", () => {
            verify("Hello, World", salutation("World"))
            verify("Hello, Mark" , salutation("Mark"))
        }),
        ("character count", () => {
            verify(6, characters("foobar"))
            verify(22, characters("functional programming"))
        }),
        ("power", () => {
            verify(216, pow(6, 3))
            verify(32, pow(2, 5))
        }),
        ("time-of-day-aware salutation", () => {
            verify("Hello, Mark", dayOrNightSalutation("Mark", true))
            verify("Good night, Mark", dayOrNightSalutation("Mark", false))
            verify("Good night, World", dayOrNightSalutation("World", false))
        }),
        ("get first two names in list", () => {
            verify(List("Jill", "Jack"), firstTwo(participants))
        }),
        ("get last two names in list", () => {
            verify("Mary", lastName(participants))
        }),
        ("combine two lists", () => {
            verify(List("Jill", "Jack", "John", "George", "Mary", "a", "b", "c"), combine(participants, letters))
        })
    )

    def verify(expected: Any, actual: Any) =
        assert(expected == actual, s"Expected: $expected, actual: $actual")

    val participants = List("Jill", "Jack", "John", "George", "Mary")
    val letters = List("a", "b", "c")
}