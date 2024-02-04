package com.hyosik.android.algorithmproblem.heap

import java.util.PriorityQueue
import kotlin.math.min


data class Stones(
    val idx: Int,
    val stValue: Int
)



fun main () {
    print(solution(intArrayOf(2,4,5,3,2,1,4,2,5,1) , 3))
}

fun solution(stones: IntArray, k: Int): Int {
    var answer = 0
    val priorityQueue = PriorityQueue<Stones>(Comparator { s1, s2 -> s2.stValue.compareTo(s1.stValue) })

    var startIndex: Int = k

    for (i in 0 until k ) {
        priorityQueue.add(Stones(idx = i, stValue = stones[i]))
    }

    answer = priorityQueue.peek().stValue

    /** 징검다리 진행 */
    while (startIndex < stones.size) {
        priorityQueue.add(Stones(idx = startIndex, stValue = stones[startIndex]))
        startIndex++

        /** 진행중 구간(k)을 벗어난 징검다리들은 제거한다. */
        /** 이유는 내가 점프할 수 있는 거리 안에 있는 값들 중 최대값을 구해야 하기 때문이다. */
        while (priorityQueue.peek().idx < startIndex - k) priorityQueue.poll()

        /** 진행중 내가 점프할 수 있는 거리 안에 있는 값들 중 최대값의 최소값이 내가 최대로 건널 수 있는 인원이다. */
        /** 2,4,5,3,2,1,4,2,5,1 경우 idx 6 일 때 3이 최대값이 되고 그 이후에 4,5가 오더라도 중간에 */
        /** 3명 지나가고 나면 더이상 그 앞에선 k를 벗어난 거리여서 못 지나가기 때문이다. */
        answer = min(answer, priorityQueue.peek().stValue)
    }


    return answer
}