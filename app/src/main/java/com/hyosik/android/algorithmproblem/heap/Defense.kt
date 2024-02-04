package com.hyosik.android.algorithmproblem.heap

import java.util.*


fun main() {
    val n = 7
    val k = 3
    val enemy = intArrayOf(5,2,4,3,10,2)

    print(solution(n,k,enemy))
}

fun solution(n: Int, k: Int, enemy: IntArray): Int {

    var answer: Int = 0
    var soldier = n
    var power = k

    val priorityQueue = PriorityQueue<Int>(Collections.reverseOrder())
    /** 가장 효율적으로 무적권을 쓰기 위해서는 순차적으로 진행 하면서 가장 많은 적을 만났을 때 무적권을 사용하게 해야 한다. */
    /** 계속 마주치는 적을 우선순위 큐에 넣어준다. */
    for (i in enemy.indices) {
        priorityQueue.add(enemy[i])
        /** 병사보다 많은 적을 만났을 시 그동안 만나온 적들중(지금 만난적 포함) 가장 큰 애들을 더해주고 무적권을 쓴다. */
        if(power > 0 && soldier < enemy[i]) {
            soldier += priorityQueue.poll()
            power--
        }
        /** 지금 만난적을 빼준다. (지금 만난적한테 무적권을 썼다면 또이또이가 되는거고 아니라면 병사가 좀 남을것이다.) */
        soldier -= enemy[i]
        if(soldier < 0) break
        answer++
    }

    return answer
}