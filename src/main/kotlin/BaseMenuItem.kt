class BaseMenuItem {
    var id: Int = 0
        private set

    var note: String = ""
        private set

    var itemColor: String = YELLOW_COLOR
        private set

    private var mainMenu: BaseMenuClass? = null

    private var onAction: (()->Unit)? = null

    private var isExit: Boolean = false

    constructor(id: Int, note: String, onAction: (()->Unit)? = null)
    {
        this.id = id
        this.note = note
        this.onAction = onAction
    }

    constructor(id: Int, note: String, menu: BaseMenuClass)
    {
        this.id = id
        this.note = note
        this.mainMenu = menu
    }
    internal fun runOrExit(): Boolean
    {
        if (mainMenu != null) {
            mainMenu!!.showMenu()
        } else {
            if (onAction != null) {
                onAction!!()
            }
        }

        return isExit
    }

    fun setAsExit(): BaseMenuItem
    {
        isExit = true
        itemColor = RED_COLOR
        return this
    }
}