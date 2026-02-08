package com.hyosik.android.algorithmproblem.dfs

/**
 * 섬의 개수 (Number of Islands)
 * 1. 문제 설명
 * N*M 크기의 지도가 있습니다.
 * 1은 육지, 0은 바다를 나타냅니다.
 * 상, 하, 좌, 우로 연결된 육지들은 하나의 섬으로 간주합니다.
 * 지도에 총 몇 개의 섬이 있는지 그 개수를 구하세요.
 *
 * 입출력 예시
 * 입력 (지도)	출력 (섬의 개수)	이유
 * [[1, 1, 0, 0, 0], [1, 1, 0, 0, 0], [0, 0, 1, 0, 0], [0, 0, 0, 1, 1]]	3	왼쪽 위(4칸), 중앙(1칸), 오른쪽 아래(2칸) 총 3개
 * [[1, 0, 1], [0, 1, 0], [1, 0, 1]]	5	대각선은 연결된 것이 아니므로 각각 독립된 5개의 섬
 *
 */
fun main() {

    val islands: Array<IntArray> = arrayOf(
        intArrayOf(1,0,1),
        intArrayOf(0,1,0),
        intArrayOf(1,0,1),
    )

    print(solution(islands))

}

fun solution(islands: Array<IntArray>): Int {

    val visited = Array(islands.size) { BooleanArray(islands[0].size) { false } }

    var answer = 0

    for (i in islands.indices) {
        for (j in islands[i].indices) {

            if (islands[i][j] == 1 && visited[i][j].not()) {
                dfs(islands, visited, i, j)
                answer++
            }
        }
    }

    return answer
}


fun dfs(islands: Array<IntArray>, visited: Array<BooleanArray>, x: Int, y: Int) {

    val dx = arrayOf(-1, 1, 0, 0)
    val dy = arrayOf(0, 0, -1, 1)

    visited[x][y] = true

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx >= 0 && nx < islands.size && ny >= 0 && ny < islands[0].size && islands[nx][ny] == 1 && visited[nx][ny].not()) {
            dfs(islands = islands, visited = visited, nx, ny)
        }
    }
}