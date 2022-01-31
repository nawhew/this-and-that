package sample

class BasicSyntax {

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    // 리턴을 생략하고 아래와 같이 바로 리턴 가능
    fun simpleSum(a: Int, b: Int) = a + b

    // 자바의 void와 같은 Unit
    fun printHelloWorld(): Unit {
        println("hello world")
    }

    // Unit은 생략 가능
    fun simplePrintHelloWorld() {
        println("hello world")
    }

    fun defineVariables() {
        // val : 읽기 전용 변수
        // 자바의 final과 유사, 값을 한번만 할당 할 수 있음
        val a: Int = 1 // 즉시 할당
        val b = 2 // type 생략 시 컴파일러가 자동으로 Int type으로 추론하여 타입을 정해줌
//        val c: Int // 컴파일 오류, 초기화가 필요함
//        c = 3 // 컴파일 오류, 읽기 전용

        // var : Mutable 변수
        var x = 5
        x += 1
    }

    fun stringInterpolation() {
        var a = 1

        // 변수를 바로 ${변수명}으로 가지고 올 수 있음
        val s1 = "a is $a"

        a = 2

        // 함수의 반환값을 바로 사용 가능
        val s2 = "${s1.replace("is", "was")}, but now is $a"
    }

    fun maxOf(a: Int, b: Int): Int {
        if(a > b) {
            return a
        } else {
            return b
        }
    }

    fun simpleMaxOf(a: Int, b: Int) = if (a > b) a else b

    // 리턴 타입이 nullable한 경우 nullable mark({Type}?)를 명시 해주어야 한다.
    fun parseInt(str: String): Int? {
        return str.toIntOrNull()
    }

    fun printProduct(arg1: String, arg2: String) {
        val x: Int? = this.parseInt(arg1)
        val y: Int? = this.parseInt(arg2)

        // nullable한 타입의 변수에 접근 할 때에는 반드시 null 체크를 해주어야한다.
        // null체크를 안해주면 컴파일 오류 발생
        if ( x != null && y != null) {
            println(x * y)
        } else {
            println("either '$arg1' or '$arg2' is not a number.")
        }
    }

    // Any는 자바의 Object와 같은 최상위 타입
    fun getStringLength(obj: Any): Int? {
        // type 체크 후 cast도 자동으로 됨.
        if(obj is String) {
            return obj.length
        }

        return null
    }

    fun printItems() {
        val items = listOf<String>("apple", "banana", "kiwi")
        var index = 0
        while (index < items.size) {
            println("item at $index is ${items[index]}")
            index++
        }
    }

    // 자바의 switch case와 같지만 모든 타입에 사용 가능
    fun describe(obj: Any): String =
        when (obj) {
            1 -> "one"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "unknown"
        }

    // in을 사용하여.. 범위, 컬렉션
    fun testRange() {
        val x = 3
        if (x in 1..10) {
            println("fit in range")
        }

        for (x in 1..5) {
            print(x)
        }

        // collection도 in으로 컬렉션에 포함여부 및 반복문 가능
        val items = listOf<String>("apple", "banana", "kiwi")
        if("banana" in items) {
            println("banana in itmes")
        }

        // define set
        val fruits = setOf("apple", "banana", "kiwi")
        when {
            "orange" in fruits -> println("Orange!!")
            "apple" in fruits -> println("Apple!!")
        }

        for (item in items) {
            println("$item in items")
        }
    }

    fun filtered(items: List<String>) {
        // it은 컬렉션의 각각의 값들 : 자바의 스트림처럼
        items.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
//            .forEach(println(it)) // it를 못 가지고 옴? - Unresolved reference: it 강의에선 됨. 버전문제인듯
    }
}

fun main() {
    // 클래스 선언 및 메소드 호출
    val bs = BasicSyntax()
    println(bs.testRange())
}