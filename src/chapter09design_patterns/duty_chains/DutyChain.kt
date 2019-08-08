package chapter09design_patterns.duty_chains

data class Activity(val name: String, val money: Int)

interface ApplyHandler {
    val successor: ApplyHandler?
    fun getTopLimit(): Int
    val leader: String

    fun handleEvent(activity: Activity) {
        when {
            activity.money <= getTopLimit() -> println("$leader handled:${activity.name}")
            else -> when (successor) {
                is ApplyHandler -> {
                    println("The activity(${activity.name}) deployed from ${leader} to ${successor?.leader}")
                    successor?.handleEvent(activity)
                }
                else -> println("The activity(${activity.name}) cannot be handled. --$leader")
            }
        }
    }

}

class GroupLeader(override val successor: ApplyHandler?, override val leader: String = "Group Leader") : ApplyHandler {
    override fun getTopLimit(): Int = 100
}

class Chairman(override val successor: ApplyHandler?, override val leader: String = "Chair Man") : ApplyHandler {
    override fun getTopLimit(): Int = 500
}

class CollegeCoach(override val successor: ApplyHandler?, override val leader: String = "College Coach") : ApplyHandler {
    override fun getTopLimit(): Int = 1000
}

fun main(args: Array<String>) {
    val collegeCoach = CollegeCoach(null)
    val chairman = Chairman(collegeCoach)
    val dept1 = GroupLeader(chairman, "Dept1")
    val dept2 = GroupLeader(chairman, "Dept2")

    dept1.handleEvent(Activity("Buy a mark pen", 10))
    dept2.handleEvent(Activity("Team building", 200))
    dept1.handleEvent(Activity("Debate match", 650))
    dept2.handleEvent(Activity("Annual meeting of the college", 1200))
}
