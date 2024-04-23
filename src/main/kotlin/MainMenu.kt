class MainMenu(arch: MutableList<Archive>): BaseMenuClass("Основное меню. Выбор действий", archives = arch) {
    override fun init() {
        addMenuItem(BaseMenuItem(0, "Архивы", MenuArchive(archives)))
        addMenuItem(BaseMenuItem(1, "Открыть уже созданный архив", { listArchive(archives) }))
        addMenuItem(BaseMenuItem(2, "Выход из программы").setAsExit())
    }
}