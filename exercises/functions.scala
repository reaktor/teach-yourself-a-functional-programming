object Functions {

    def plus(x: Int, y:Int):Int = ???
    
    def salutation(name: String):String = ???

    def characters(name: String):Int = ???

    def pow(x: Int, y: Int) = ???


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
        })
    )

    def verify(expected: Any, actual: Any) =
        assert(expected == actual, s"Expected: $expected, actual: $actual")
}