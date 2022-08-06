
fun addTwoNumbers(number1: Int, number2: Int): Int {
    return number1 + number2
}

fun addTenNine(funtion: (Int, Int) -> Int) {

    val result: Int = funtion(10, 9)
    print(result)
}


addTenNine(::addTwoNumbers)

val addTenNine2 : (Int,Int) -> Int = { number1:Int, number2: Int ->

    number1+number2

}
