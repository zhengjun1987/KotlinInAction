package chapter09design_patterns.template

/*abstract*/ open class CitizensCenterTask {
    fun execute(task:() -> Unit){
        lineUp()
        /*askForHelp()*/
        task()
        score()
    }

    open fun askForHelp(){}

    private fun score() {
        println("CitizensCenterTask.score")
    }

    fun lineUp(){
        println("CitizensCenterTask.lineUp")
    }
}

class QuerySocialSecurity : CitizensCenterTask(){
    override fun askForHelp() {
        println("查询社保信息")
    }
}

class ApplyForCitizenCard : CitizensCenterTask(){
    override fun askForHelp() {
        println("申请市民卡")
    }
}
fun applyForCitizenCard() {
    println("申请市民卡")
}
fun querySocialSecurity() {
    println("查询社保信息")
}
fun main(args: Array<String>) {
//    QuerySocialSecurity().execute()
//    ApplyForCitizenCard().execute()

    val task = CitizensCenterTask()
    task.execute(::querySocialSecurity)
    task.execute(::applyForCitizenCard)
}