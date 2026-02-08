package com.hyosik.android.algorithmproblem.bfs

/**
 * 문제: 미로 탐색 (BFS)
 * 1. 문제 설명
 * N * M 크기의 배열로 표현된 미로가 있습니다.
 * * 1은 이동할 수 있는 칸, 0은 이동할 수 없는 칸(벽)을 나타냅니다.
 * * (1, 1) 지점에서 출발하여 (N, M) 지점으로 이동할 때 지나야 하는 최소 칸 수를 구하세요.
 * * 칸을 셀 때는 시작 위치와 도착 위치도 포함합니다.
 * 2. 제한 사항
 * * $N, M$은 2 이상 200 이하입니다.
 * * 미로는 항상 시작점에서 도착점까지 갈 수 있는 형태로 주어집니다.
 * 3. 입출력 예시
 * 입력 (미로 판)	출력 (최단 거리)	이유
 * [[1, 0, 1, 1, 1], [1, 0, 1, 0, 1], [1, 0, 1, 1, 1], [1, 1, 1, 0, 1]] (4x5)	9	(1,1)에서 (4,5)까지 연결된 1을 따라가면 9칸이 걸림
 * [[1, 1, 0], [0, 1, 0], [0, 1, 1]] (3x3)	5	(1,1) -> (1,2) -> (2,2) -> (3,2) -> (3,3) 순으로 5칸
 *
 */



fun main() {
    val miro: Array<IntArray> = arrayOf(
        intArrayOf(1, 1, 1, 1, 1),
        intArrayOf(1, 0, 1, 0, 1),
        intArrayOf(1, 0, 1, 1, 1),
        intArrayOf(1, 1, 1, 0, 1)
    )

    print(bfs(miro = miro, n = 4, m = 5))
}


fun bfs(miro: Array<IntArray>, n: Int, m: Int): Int {
    val ad = ArrayDeque<Pair<Int, Int>>()
    ad.addFirst(Pair(0, 0))

    val dx = arrayOf(-1, 1, 0, 0)
    val dy = arrayOf(0, 0, -1, 1)

    val visited: Array<BooleanArray> = arrayOf(
        booleanArrayOf(false, false, false, false, false),
        booleanArrayOf(false, false, false, false, false),
        booleanArrayOf(false, false, false, false, false),
        booleanArrayOf(false, false, false, false, false)
    )

    visited[0][0] = true

    while (ad.isNotEmpty()) {

        val (x, y) = ad.removeFirst()

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (miro[nx][ny] == 1 && !visited[nx][ny]) {
                    miro[nx][ny] = miro[x][y] + 1
                    ad.addLast(Pair(nx, ny))
                    visited[nx][ny] = true
                }
            }
        }

    }

    return miro[n - 1][m - 1]

}