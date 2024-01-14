import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var N = br.readLine().toInt()

    val num: Array<Int> = Array(N) {0}

    val st = StringTokenizer(br.readLine())

    for (i in num.indices) {
        num[i] = st.nextToken().toInt()
    }

    val stack = ArrayDeque<Int>()

    val answer = Array<Int>(N) {-1}

    for (i in N -1 downTo(0)) {
        // 스택이 비어있지 않으면서 스택 젤 위에 값이 현재 값보다 작다면 다 제거
        while (!stack.isEmpty() && stack.last() <= num[i]) {
            stack.removeLast()
        }
        // 제거 후에 바로 위에 남아 있는 수가 오큰수가 된다.
        if(!stack.isEmpty()) answer[i] = stack.last()
        // 그리고 현재 값을 넣어준다. 다음 차례의 숫자가 현재값이 오큰수인지 판단하게 하기 위해
        // 그리고 위에서 < 가 아닌 <= 를 넣은 이유가 여기서 addLast 를 해주기 때문에
        // 같은 값도 위에서 빼줘야 한다.
        stack.addLast(num[i])
    }

    answer.forEach { i ->
        bw.write("$i ")
    }

    bw.flush()
    bw.close()
}