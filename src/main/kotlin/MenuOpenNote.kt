class MenuOpenNote(
    arch: MutableList<Archive>,
    indexArchive: Int
): BaseMenuClass(
    "Открыть заметку архива ${CYAN_COLOR}${arch[indexArchive].name}",
    archives = arch,
    tmpIndex = indexArchive
) {
    override fun init() {
        var index = 0
        var iterator = archives[tmpIndex].noteList.iterator()
        for ((indx, note) in iterator.withIndex()) {
            addMenuItem(BaseMenuItem(indx, note.name, { openNote(indx)}))
            index = indx + 1
        }
        addMenuItem(BaseMenuItem(index, "Выход").setAsExit())
    }

    private fun openNote(index: Int) {
        println()
        println("${DOWN_PEN}Смотрим заметку.${DEFAULT_COLOR}")
        archives[tmpIndex].printNotes(index)
    }
}