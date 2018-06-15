package scholae.plugin.actions

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.DumbAwareAction

class OpenScholaeActions: DumbAwareAction("Scholae", "View a list of our available scholae", null) {


    override fun actionPerformed (event: AnActionEvent) {
        println("Hello!")
    }
}
