val CYAN_COLOR = "\u001b[96m"
val GREEN_COLOR = "\u001b[32m"
val RED_COLOR = "\u001b[91m"
val YELLOW_COLOR = "\u001b[93m"
val DEFAULT_COLOR = "\u001b[0m"
val DOWN_PEN = "\u001b[4m"
val ERROR_COLOR = "\u001b[41m"
fun main(args: Array<String>) {
    val archives: MutableList<Archive> = mutableListOf()
    val mainMenu = MainMenu(archives)
    mainMenu.showMenu()
}
