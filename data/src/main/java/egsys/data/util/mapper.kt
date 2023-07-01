package egsys.data.util

fun extractKey(link: String, qntd: Int): Int{
    return link.substring(qntd).trim { link <= '/'.toString() }.toInt()
}
