fun main() {
    val braces: String = "(())()"
    val result: Boolean = answer(braces)
    println(result)
}


fun answer(braces: String): Boolean {
    val ad = ArrayDeque<Char>()

    braces.forEach { s ->
        when(s) {
            '(' -> ad.addFirst(s)

            ')' -> {
                if(ad.isEmpty()) return false
                if(ad.removeFirst() != '(') return false
            }
        }
    }

    return ad.isEmpty()

}