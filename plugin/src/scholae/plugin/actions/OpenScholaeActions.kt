package scholae.plugin.actions

import com.intellij.openapi.project.DumbAwareAction
import com.intellij.openapi.actionSystem.AnActionEvent

class OpenScholaeActions : DumbAwareAction("Scholae", "View a list of our available scholae", null) {

    override fun actionPerformed(e: AnActionEvent) {
        //val courses = EduUtils.getCoursesUnderProgress() ?: return
        //BrowseCoursesDialog(courses).show()
    }
}