package com.hyosik.android.algorithmproblem.stack

class Solution {
    fun solution(s: String): Int {
        // HashMap 으로 괄호의 쌍을 만든다.
        // 이중 포문으로 괄호의 배치를 바꾸면서 루프로 올바른 괄호를 찾는다.
        // ({[ 는 넣고 )}] 인경우 map 에서 키로 맞는 쌍인지 찾는다

        var answer: Int = 0

        val hashMap = HashMap<Char,Char>()
        hashMap['('] = ')'
        hashMap['{'] = '}'
        hashMap['['] = ']'

        var rotateString = s

        // 문자열 로테 돌리면서 올바른 괄호 찾기 시작
        for (i in 0 until s.length) {

            val stack = ArrayDeque<Char>()
            var isTrue = true

            for (j in 0 until s.length) {

                val now = rotateString[j]
                // 열리는 괄호인 경우
                if(hashMap.containsKey(now)) {
                    stack.addLast(now)
                }
                // 닫히는 괄호인 경우
                else {
                    if(stack.isEmpty()) {
                        isTrue = false
                        break
                    }
                    else {
                        // 쌍이 맞는지 비교한다. 맞으면 여는 괄호를 뺀다.
                        if (now == hashMap[stack.last()]) {
                            stack.removeLast()
                        }
                    }

                }
            }

            // isTrue 가 true 면서 stack이 비어있다면 올바른괄호이므로 +1
            if(isTrue && stack.isEmpty()) answer += 1

            // rotateString 에 로테를 돌린다.
            rotateString += rotateString[0]
            rotateString = rotateString.drop(1)

        }

        return answer
    }
}