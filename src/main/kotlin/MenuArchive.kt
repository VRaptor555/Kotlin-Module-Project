class MenuArchive(arch: MutableList<Archive>): BaseMenuClass("Меню архивов:", archives = arch) {
    override fun init() {
        addMenuItem(BaseMenuItem(0, "Создать архив", { createArchive(archives) }))
        addMenuItem(BaseMenuItem(1, "Открыть уже созданный архив",  { listArchive(archives) }))
        addMenuItem(BaseMenuItem(2, "Выход").setAsExit())
    }

    private fun createArchive(archives: MutableList<Archive>) {
        println()
        println("${DOWN_PEN}Создаем архив:$DEFAULT_COLOR")
        if (createCommandText("Введите название"))
        {
            val search = archives.find { it.name.lowercase().equals(textCreated.lowercase()) }
            if (search == null) {
                val archiv = Archive(textCreated)
                archives.add(archiv)
                println()
                println("${YELLOW_COLOR}Архив ${CYAN_COLOR}$textCreated${YELLOW_COLOR} - создан.$DEFAULT_COLOR")
            } else {
                println("${RED_COLOR}Архив с таким именем уже существует!${DEFAULT_COLOR}")
            }
        }
    }

    private fun listArchive(archives: MutableList<Archive>) {
        val archiveList = ArchiveList(archives)
        archiveList.showMenu()
    }
}
