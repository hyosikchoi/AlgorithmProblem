package com.hyosik.android.algorithmproblem.sort

/**
 * 출처
 * https://school.programmers.co.kr/learn/courses/30/lessons/138476>
 */
fun main() {
    println(solution(6 , intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)))
    println(solution2(6 , intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)))
}

private fun solution(k: Int, tangerine: IntArray): Int {

    var answer: Int = 0

    val sortTangerine : IntArray = tangerine

    sortTangerine.sort()

    // 각 배열의 원소의 같은 숫자의 크기를 저장한 배열
    var equalList = mutableListOf<Int>()

    // 같은 원소들 카운트 재서 저장(이중 for문은 시간초과)
    var number = sortTangerine[0]
    var equalCount = 0
    for(i in sortTangerine.indices) {
        if(sortTangerine[i] == number) {
            equalCount++
            if(i == sortTangerine.lastIndex) equalList.add(equalCount)
        } else {
            equalList.add(equalCount)
            number = sortTangerine[i]
            equalCount = 1
            if(i == sortTangerine.lastIndex) equalList.add(equalCount)
        }
    }

    // 크기가 큰 순으로 정렬
    equalList.sortDescending()

    var target = 0
    // 같은 원소 카운트 리스트에서 루프돌면서 k값보다 크거나 같을 경우 break
    // 아닐 때 answer에 계속 종류의 수 카운트업
    for(i in equalList.indices) {
        if(k <= target){
            // 처음부터 k 를 만족한다면 answer 에 1로 값 지정
            if(i == 0) answer = 1
            break
        }
        else {
            target += equalList[i]
            answer++
        }
    }

    return answer
}

private fun solution2(k: Int, tangerine: IntArray): Int {
    val groupMap: Map<Int, List<Int>> = tangerine.groupBy { it }
    val sortedValueSize = groupMap.toList().sortedByDescending { it.second.size }

    var temporaryTangerine: Int = 0
    var answer: Int = 0

    sortedValueSize.forEach {
        if(temporaryTangerine < k) {
            temporaryTangerine += it.second.size
            answer++
        } else return@forEach
    }

    return answer

}

