package com.hyosik.android.algorithmproblem.binarysearch

/**
 * 문제: 나무 자르기 (EKO)
 * 1. 문제 설명
 * 목재 절단기를 이용해 나무를 자르려고 합니다. 절단기에 높이 H를 지정하면, 밭에 있는 모든 나무 중 높이가 H보다 높은 나무들은 H 윗부분이 잘려 나갑니다. 낮은 나무는 잘리지 않습니다.
 * 예를 들어, 나무의 높이가 20, 15, 10, 17이고 절단기 높이를 15로 설정했다면, 잘린 나무의 길이는 각각 5, 0, 0, 2가 되어 총 7미터의 나무를 가져갈 수 있습니다.
 * 적어도 M미터의 나무를 집에 가져가기 위해 설정할 수 있는 절단기 높이(H)의 최댓값을 구하세요.
 * 2. 제한 사항
 * * 나무의 수 $N$: 1 이상 1,000,000 이하
 * * 필요한 나무의 길이 $M$: 1 이상 2,000,000,000 이하
 * * 각 나무의 높이: 0 이상 1,000,000,000 이하
 * * 정답은 항상 존재합니다.
 * 입출력 예시
 * 입력 (나무들, 필요한 길이 M)	출력 (최대 높이 H)	이유
 * [20, 15, 10, 17], 7	15	15로 자르면 5+2=7. 딱 맞음.
 * [4, 42, 40, 26, 46], 20	36	36으로 자르면 (42-36)+(40-36)+(46-36) = 6+4+10 = 20.
 *
 */

fun main() {

    val mArray = arrayOf<Long>(4,42,40,26,46)
    val m = 20L

    print(answer(mArray, m))

}

fun answer(mArray: Array<Long>, m: Long): Long {

    var min = 0L
    var max: Long = mArray.max()
    var ans = 0L

    while (min <= max) {

        val mid: Long = min + (max - min) / 2L
        var sum: Long = 0L

        mArray.forEach { tree ->
            val remain = if (tree > mid) tree - mid else 0L
            sum += remain
        }

        if (sum >= m) {
            ans = mid
            min = mid + 1L
        }

        else {
            max = mid - 1L
        }
    }

    return ans

}