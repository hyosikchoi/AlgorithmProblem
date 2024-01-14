package com.hyosik.android.algorithmproblem.stack

class FunctionDevelop {
    fun solution(progresses: IntArray, speeds: IntArray): ArrayDeque<Int> {
        val answer = ArrayDeque<Int>()

        val progressDeque = ArrayDeque<Int>()
        val speedDeque = ArrayDeque<Int>()

        // O(N) 100개 이하
        for (i in progresses.indices) {
            progressDeque.addLast(progresses[i])
            speedDeque.addLast(speeds[i])
        }

        var roop: Int = 0

        while (!progressDeque.isEmpty()) {

            if(roop == progressDeque.size) {
                roop = 0
                if(progressDeque.first() >= 100) {

                    var successDevelop: Int = 0

                    while (!progressDeque.isEmpty() && progressDeque.first() >= 100) {
                        successDevelop += 1
                        progressDeque.removeFirst()
                        speedDeque.removeFirst()
                    }
                    answer.addLast(successDevelop)
                }
            } else {
                var progress = progressDeque.removeFirst()
                val speed = speedDeque.removeFirst()

                progress += speed

                progressDeque.addLast(progress)
                speedDeque.addLast(speed)
                roop += 1
            }
        }

        return answer
    }
}