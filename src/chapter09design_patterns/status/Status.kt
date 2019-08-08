package chapter09design_patterns.status

class WaterMachine {
    var state:MachineState
    val heating = MachineState.Heating(this)
    val off = MachineState.Off(this)
    val cooling = MachineState.Cooling(this)
    init {
        state = off
    }
    fun turn(state: MachineState){
        this.state.turn(state)
    }
}

sealed class MachineState(open val machine:WaterMachine){
    fun turn(state: MachineState) {
        val kClass = state::class
        if (this !is Heating) {
            println("this = ${this}")
            machine.state = machine.heating
        }
    }

    class Off(machine: WaterMachine) : MachineState(machine)
    class Heating(machine: WaterMachine) : MachineState(machine)
    class Cooling(machine: WaterMachine) : MachineState(machine)
}