package com.hyosik.android.algorithmproblem.binarysearch

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


fun main() {

    val bf = BufferedReader(InputStreamReader(System.`in`))

    val st = StringTokenizer(bf.readLine())

    val K: Int = st.nextToken().toInt()

    val N: Long = st.nextToken().toLong()

    val lanList: MutableList<Long> = mutableListOf()

    (0 until K).forEach { _ ->
        lanList.add(bf.readLine().toLong())
    }

    lanList.sort()

    var min: Long = 0

    var max: Long = lanList.last()

    while (min <= max) {

        val mid: Long = (min + max) / 2L

        if (mid == 0L) break

        var total: Long = 0

        lanList.forEach { total += it / mid }

        if (total < N) {
            max = mid - 1
        } else {
            min = mid + 1
        }
    }

    println(max)
}