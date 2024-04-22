class MenuItem {
    var id: Long = 0
        private set

    var note: String = ""
        private set

    private var menu: MenuClass? = null

    private var action: (()->Unit)? = null

    private var isExit: Boolean = false

    constructor(id: Long, note: String, action: (()->Unit)? = null)
    {
        this.id = id
        this.note = note
        this.action = action
    }

    constructor(id: Long, note: String, menu: MenuClass)
    {
        this.id = id
        this.note = note
        this.menu = menu
    }
    internal fun runExit(): Boolean
    {
        if (menu != null)
            menu!!.showMenu()
        else if (action != null)
            action!!()
        return isExit
    }

    fun setAsExit(): MenuItem
    {
        isExit = true
        return this
    }
}