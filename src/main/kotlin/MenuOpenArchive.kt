class MenuOpenArchive(
    arch: MutableList<Archive>,
    indexArchiv: Int
): BaseMenuClass(
    "Открыли архив ${CYAN_COLOR}${arch[indexArchiv].name}",
    archives = arch,
    tmpIndex = indexArchiv
) {
    override fun init() {
        addMenuItem(BaseMenuItem(0, "Создать заметку", { createNote(archives[tmpIndex]) }))
        addMenuItem(BaseMenuItem(1, "Просмотреть заметок", {menuOpenNotes(tmpIndex)}))
        addMenuItem(BaseMenuItem(2, "Выход").setAsExit())
    }

    fun menuOpenNotes(index: Int) {
        val menuOpenNote = MenuOpenNote(archives, index)
        menuOpenNote.showMenu()
    }

    fun createNote(archiv: Archive) {
        println()
        println("${DOWN_PEN}Создаём заметку в архиве ${CYAN_COLOR}${archiv.name}$DEFAULT_COLOR")
        if (createCommandText("Введите название")) {
            val noteName = textCreated
            if (createCommandText("Введите текст заметки")) {
                val note = Note(noteName, textCreated)
                archiv.createNote(note)
                println()
                println("${YELLOW_COLOR}Заметка ${CYAN_COLOR}$noteName${YELLOW_COLOR} создана!${DEFAULT_COLOR}")
            }
        }

    }

}