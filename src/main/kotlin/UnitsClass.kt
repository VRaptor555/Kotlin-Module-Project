abstract class UnitsClass(val name: String) {
    protected abstract val title: String
    init {
        require(name.length > 0) {
            "${ERROR_COLOR}Название $title не должно быть пустым!${DEFAULT_COLOR}"
        }
    }
}