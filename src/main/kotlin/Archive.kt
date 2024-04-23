class Archive(name: String): UnitsClass(name = name) {
    override val title: String = "архива"
    val noteList: MutableList<Note> = mutableListOf()

    fun createNote(note: Note) {
        noteList.add(note)
    }

    fun printNotes(index: Int) {
        val note = noteList[index]
        println("${GREEN_COLOR}Заметка: ${CYAN_COLOR}${note.name}\n${GREEN_COLOR}Текст заметки: ${DEFAULT_COLOR}${note.text}")
    }
}