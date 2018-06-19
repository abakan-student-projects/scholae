package scholae.plugin.actions;


import com.intellij.openapi.actionSystem.*;

public class OpenScholaeAction extends AnAction{

    @Override
    public void update(AnActionEvent e) {
        super.update(e);
        e.getPresentation().setEnabled(true);
    }

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        System.out.println("Hello!");
    }
}
