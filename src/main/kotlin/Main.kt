fun main(args: Array<String>) {
    val archivMenu = mapOf(
        0 to "Создать архив",
        1 to "Выбор архива",
        2 to "Выход"
    )
    val archiv = Archiv("Список архивов:", archivMenu)
    archiv.showMenu()
}