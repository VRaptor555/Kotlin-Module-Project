import java.util.Scanner

abstract class BaseMenuClass(var title: String, val archives: MutableList<Archive>, val tmpIndex: Int = 0) {
    private val menuItems: MutableList<BaseMenuItem>
    private val scanner = Scanner(System.`in`)

    protected var textCreated = ""

    init {
        menuItems = ArrayList()
        init()
    }


    protected abstract fun init()

    fun addMenuItem(menuItem: BaseMenuItem) {
        menuItems.add(menuItem)
    }

    fun showMenu() {
        while(true) {
            println()
            println("$GREEN_COLOR$title$DEFAULT_COLOR")
            for (item in menuItems) {
                println("${item.itemColor}${item.id}. ${item.note}$DEFAULT_COLOR")
            }
            val input = scanner.nextLine()
            if (input.all { char -> char.isDigit()}) {
                val itemIndex = input.toInt()
                try {
                    val menuItem = menuItems[itemIndex]
                    if (menuItem.runOrExit())
                        break
                }
                catch (e: IndexOutOfBoundsException) {
                    println("${ERROR_COLOR}Такого пункта меню не существует!${DEFAULT_COLOR}")
                }
            } else {
                println("${ERROR_COLOR}Вводить нужно только цифры!${DEFAULT_COLOR}")
            }
        }
    }

    fun createCommandText(commandText: String): Boolean {
        println("${CYAN_COLOR}Для отмены нажмите [0]${DEFAULT_COLOR}")
        textCreated = ""
        while(textCreated == "") {
            println("$commandText:")
            val name = scanner.nextLine()
            if (name != "") {
                if (name.all { char -> char.isDigit()}) {
                    val command = name.toInt()
                    if (command == 0)
                        return false
                    else
                        println("${ERROR_COLOR}Не известная комманда${DEFAULT_COLOR}")
                } else
                    textCreated = name
            } else {
                println("${ERROR_COLOR}Название не может быть пустым!${DEFAULT_COLOR}")
            }
        }
        return true
    }
}