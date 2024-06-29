package com.hyosik.android.algorithmproblem.sort

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))

    val N = bf.readLine().toInt()

    val coordinateList: ArrayDeque<Pair<Int, Int>> = ArrayDeque()

    (0 until N).forEach {
        val st = StringTokenizer(bf.readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        coordinateList.add(Pair(x,y))
    }
    val list = coordinateList.sortedWith(compareBy<Pair<Int,Int>>( {it.first} , {it.second}))

    list.forEach {
        println("${it.first} ${it.second}")
    }

}