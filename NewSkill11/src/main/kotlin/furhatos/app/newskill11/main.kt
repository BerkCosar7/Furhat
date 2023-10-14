package furhatos.app.newskill11

import furhatos.app.newskill11.flow.Init
import furhatos.flow.kotlin.Flow
import furhatos.skills.Skill

class Newskill11Skill : Skill() {
    override fun start() {
        Flow().run(Init)
    }
}

fun main(args: Array<String>) {
    Skill.main(args)
}
