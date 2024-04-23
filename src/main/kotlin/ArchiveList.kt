class ArchiveList(arch: MutableList<Archive>): BaseMenuClass("Выберете архив:", archives = arch) {
    override fun init() {
        var index = 0
        var iterator = archives.iterator()
        for ((indx, archive) in iterator.withIndex()) {
            addMenuItem(BaseMenuItem(indx, archive.name, MenuOpenArchive(archives, index)))
            index = indx + 1
        }
        addMenuItem(BaseMenuItem(index, "Выход").setAsExit())
    }
}