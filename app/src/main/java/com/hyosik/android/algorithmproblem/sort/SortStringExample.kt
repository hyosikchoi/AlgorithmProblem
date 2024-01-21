package com.hyosik.android.algorithmproblem.sort

fun main() {
    var a = "abcd"
    var b = "abcd"

    println(System.identityHashCode("abcd"))
    println(System.identityHashCode(a))
    println(System.identityHashCode(b))

    if (a === b) println("같습니다.") else println("다릅니다.")

    a += "e"
    b += "e"

    println(System.identityHashCode(a))
    println(System.identityHashCode(b))

    if (a === b) println("같습니다.") else println("다릅니다.")
}