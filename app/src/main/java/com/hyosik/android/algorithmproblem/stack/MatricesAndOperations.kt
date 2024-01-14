package com.hyosik.android.algorithmproblem.stack

class MatricesAndOperations {

    fun solution(rc: Array<IntArray>, operations: Array<String>): Array<IntArray> {
        var answer: Array<IntArray> = Array<IntArray>(rc.size) { IntArray(rc[0].size) }

        val left = ArrayDeque<Int>()
        val right = ArrayDeque<Int>()

        val mid = ArrayDeque<ArrayDeque<Int>>()

        // 행열 담기 O(N)
        for (i in rc.indices) {
            left.addLast(rc[i][0])
            val midQueue = ArrayDeque<Int>()

            for (j in 1 until rc[i].size -1) {
                midQueue.addLast(rc[i][j])
            }

            mid.addLast(midQueue)
            right.addLast(rc[i][rc[i].lastIndex])
        }

        // 로테 돌리기 O(N)
        operations.forEach { operation: String ->
            if(operation == "ShiftRow") {
                left.addFirst(left.removeLast()) // O(1)
                mid.addFirst(mid.removeLast()) // O(1)
                right.addFirst(right.removeLast()) // O(1)
            } else {
                mid.first().addFirst(left.removeFirst()) // O(1)
                right.addFirst(mid.first().removeLast()) // O(1)
                mid.last().addLast(right.removeLast()) // O(1)
                left.addLast(mid.last().removeFirst()) // O(1)
            }
        }

        // answer 에 담기
        for (i in 0 until answer.size) {
            answer[i][0] = left.removeFirst()
            val midQueue = mid.removeFirst()
            for (j in 1 until answer[i].size -1) {
                answer[i][j] = midQueue.removeFirst()
            }
            answer[i][answer[i].lastIndex] = right.removeFirst()
        }

        return answer
    }
}