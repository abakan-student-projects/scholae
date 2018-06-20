package scholae.plugin.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import scholae.plugin.view.OpenScholaeDialogs;

public class OpenScholaeAction extends AnAction {

    @Override
    public void update(AnActionEvent e) {
        super.update(e);
        e.getPresentation().setEnabled(true);
    }

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        new OpenScholaeDialogs();
    }
}