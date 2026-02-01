package com.hyosik.android.algorithmproblem.bruteforce

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 1. 문제 설명Leo는 카펫을 사러 갔다가 중앙에는 **노란색(Yellow)**으로 칠해져 있고 테두리 1줄은 **갈색(Brown)**으로 칠해져 있는 격자 모양 카펫을 봤습니다.
 * Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때, 카펫의 가로, 세로 크기를 순서대로 배열에 담아 반환하세요.
 * 2. 제한 사항갈색 격자의 수 brown: 8 이상 5,000 이하인 자연수노란색 격자의 수 yellow: 1 이상 2,000,000 이하인 자연수카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
 * 3. 입출력 예시
 * brown yellow return (가로, 세로)
 * 10       2       [4, 3]
 * 8        1       [3, 3]
 * 24       24      [8, 6]
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (b, y) = br.readLine().split(" ").map { it.toInt() }

    print("${answer(b, y)[0]} ${answer(b, y)[1]}")
}


fun answer(b: Int, y: Int): List<Int> {

    for (i in 1..y) {
        // 일단 약수를 먼저 구해야한다.
        if (y % i == 0) {
           val width = i
           val height = y / i
            // yellow 가  x * y 가 몇인지 구하면 brown 의 갯수는 (x+2) * (y+2) - brown 갯수 라는 공식이 성립하게 된다.
            if ((width + 2) * (height + 2) - y == b) return arrayOf(width+2, height+2).sortedDescending()
        }
    }

    return listOf()
}