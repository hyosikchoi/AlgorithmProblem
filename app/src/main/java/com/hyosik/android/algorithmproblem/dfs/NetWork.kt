package com.hyosik.android.algorithmproblem.dfs

/**
 * 네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다.
 * 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고,
 * 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다.
 * 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
   컴퓨터의 개수 n,연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.

   제한사항
   • 컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
   • 각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
   • i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
   • computer[i][i]는 항상 1입니다.
   입출력 예
   n	computers	return
   3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
   3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
 */

fun main() {

    val n = 3
    val computers = arrayOf<IntArray>(intArrayOf(1,1,0),intArrayOf(1,1,0),intArrayOf(0,0,1))

    print(solution(n , computers))

}

private fun solution(n  : Int , computers : Array<IntArray>) : Int {

   val visited : Array<Array<Boolean>> = Array(n) {Array<Boolean>(n) {false}}

   var network = 0

   for(i in 0 until n) {
      // 자기 자신만 있는 경우(자기 자신이 네트워크인 경우)
      if(computers[i].filter {it == 1}.size == 1) network++

      for(j in 0 until n) {
         if(i == j) continue

         if(visited[i][j].not() && computers[i][j] == 1) {
            visited[i][j] = true
            dfs(j,computers,visited)
            network++
         }

      }
   }

   return network
}

private fun dfs(start : Int, computers: Array<IntArray>, visited : Array<Array<Boolean>>) {

   for (k in computers.indices) {
      if(k == start) continue

      if(visited[start][k].not() && computers[start][k] == 1) {
         visited[start][k] = true
         dfs(start = k , computers = computers , visited = visited)
      }
   }
}