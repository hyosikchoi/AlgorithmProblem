package com.hyosik.android.algorithmproblem.binarysearch

fun main() {
    val n = 6
    val times = arrayOf(7, 10)

    println(solution(n, times))

}


private fun solution(n: Int, times: Array<Int>): Long {

    var answer = Long.MAX_VALUE

    times.sort()
    var min = times.first()
    var max = times.last() * n

    while (min <= max) {

        val mid = (min + max) / 2

        var successN = 0

        times.forEach { successN += mid / it }

        if(successN >= n) {
            max = mid -1
            answer = mid.toLong()
        } else {
            min = mid +1
        }
    }

    return answer

}