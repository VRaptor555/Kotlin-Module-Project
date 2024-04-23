class MenuOpenArchive(
    arch: MutableList<Archive>,
    indexArchiv: Int
): BaseMenuClass(
    "Просмотр архива ${CYAN_COLOR}${arch[indexArchiv].name}",
    archives = arch,
    tmpIndex = indexArchiv
) {
    override fun init() {
        addMenuItem(BaseMenuItem(0, "Создать заметку") { createNote(archives[tmpIndex]) })
        addMenuItem(BaseMenuItem(1, "Просмотреть заметки") { menuOpenNotes(tmpIndex) })
        addMenuItem(BaseMenuItem(2, "Выход").setAsExit())
    }

    private fun menuOpenNotes(index: Int) {
        val menuOpenNote = MenuOpenNote(archives, index)
        menuOpenNote.showMenu()
    }

    private fun createNote(archive: Archive) {
        println()
        println("${DOWN_PEN}Создаём заметку в архиве ${CYAN_COLOR}${archive.name}$DEFAULT_COLOR")
        if (createCommandText("Введите название")) {
            val search = archive.noteList.find { it.name.lowercase().equals(textCreated.lowercase()) }
            if (search == null) {
                val noteName = textCreated
                if (createCommandText("Введите текст заметки")) {
                    val note = Note(noteName, textCreated)
                    archive.createNote(note)
                    println()
                    println("${YELLOW_COLOR}Заметка ${CYAN_COLOR}$noteName${YELLOW_COLOR} создана!${DEFAULT_COLOR}")
                }
            } else {
                println("${RED_COLOR}Заметка в архиве ${CYAN_COLOR}${archive.name}${RED_COLOR} с таким именем уже существует!${DEFAULT_COLOR}")
            }
        }

    }

}