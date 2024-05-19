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
        /**
         * 이분 탐색에서는 문제에서 최대의 길이를 원하는지 최소의 길이를 원하는지에 따라서 max 쪽에 <= 를 할지 min 쪽에 할지 정해진다.
         * 또한 결과값도 max 를 내보내야 할지 min 을 내보내야 할지 정해진다.
         */
        /**
         * 현재 문제에서는 랜선의 최대 길이를 구하는 것이므로 total < N 으로 = 조건을 빼야한다 안그러면 구하려는 값이 = 에 부합할 때 max 에서 -1 을 하게 되서 답이 잘못된다.
         * 또한 return 하는 값도 랜선 최대 길이이므로 max 를 리턴하게 해야 한다.
         */
        if (total < N) {
            max = mid - 1
        } else {
            min = mid + 1
        }
    }

    println(max)
}