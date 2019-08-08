package chapter09design_patterns.factory

interface Computer {
    val cpu: String

    companion object {
        operator fun invoke(type: ComputerType): Computer =
                when (type) {
                    ComputerType.PC -> PC()
                    else -> Server()
                }
    }
}

class PC(override val cpu: String = "Core") : Computer
class Server(override val cpu: String = "Xeon") : Computer

enum class ComputerType {
    PC, Server
}

object ComputerFactory {
    operator fun invoke(type: ComputerType): Computer =
            when (type) {
                ComputerType.PC -> PC()
                else -> Server()
            }
}

fun Computer.Companion.fromCPU(cpu: String): ComputerType? =
        when (cpu) {
            "Core" -> {
                ComputerType.PC
            }
            "Xeon" -> {
                ComputerType.Server
            }
            else -> {
                null
            }
        }

fun main(args: Array<String>) {
    val computer = ComputerFactory(ComputerType.Server)
    println("computer.cpu = ${computer.cpu}")

    val computer1 = Computer(ComputerType.PC)
    println("computer1.cpu = ${computer1.cpu}")

    println("Computer.fromCPU(\"Xeon\") = ${Computer.fromCPU("Xeon")}")
}