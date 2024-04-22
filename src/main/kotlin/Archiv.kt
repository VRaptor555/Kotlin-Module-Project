class Archiv: MenuClass("Список архивов:") {
    override fun init() {
        addMenuItem(MenuItem(0, "Создать архив", { createArchiv() }))
        addMenuItem(MenuItem(1, "Это мой уже созданный архив", Archiv()))
        addMenuItem(MenuItem(2, "Выход").setAsExit())
    }

    fun createArchiv() {

    }
}