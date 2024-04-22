import java.util.Scanner

abstract class MenuClass(var title: String) {
    private val menuItems: MutableList<MenuItem>

    init {
        menuItems = ArrayList()
        init()
    }

    protected abstract fun init()

    fun addMenuItem(menuItem: MenuItem) {
        menuItems.add(menuItem)
    }

    fun showMenu() {
        val scanner = Scanner(System.`in`)
        while(true) {
            println()
            println(title)
            for (item in menuItems) {
                println("${item.id}. ${item.description}")
            }
            val input = scanner.nextLine()
            if (input.all { char -> char.isDigit()}) {
                val itemIndex = input.toInt()
                try {
                    val menuItem = menuItems[itemIndex]
                    if (menuItem.runExit())
                        break
                }
                catch (e: IndexOutOfBoundsException) {
                    println("Такого пункта меню не существует!")
                }
            } else {
                println("Вводить нужно только цифры!")
            }
        }
    }
}