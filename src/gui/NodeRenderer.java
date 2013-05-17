package gui;

import java.awt.Component;

//import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
 
/**
* This class is implemented to customize the display of a node.
* @author Ha Minh Nam
*
*/
@SuppressWarnings("serial")
public class NodeRenderer extends DefaultTreeCellRenderer {
   /*private ImageIcon iconProject = new ImageIcon(getClass().getResource("/hainasoft/codelib/desktop/tree/project.png"));
   private ImageIcon iconSource = new ImageIcon(getClass().getResource("/hainasoft/codelib/desktop/tree/source.png"));
   private ImageIcon iconPackage = new ImageIcon(getClass().getResource("/hainasoft/codelib/desktop/tree/package.png"));
   private ImageIcon iconClass = new ImageIcon(getClass().getResource("/hainasoft/codelib/desktop/tree/class.png"));
   private ImageIcon iconFolder = new ImageIcon(getClass().getResource("/hainasoft/codelib/desktop/tree/folder.png"));*/
    
   @SuppressWarnings("unused")
   public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
       super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
       
       ProjectItemNode node = (ProjectItemNode) value;
       
       /*switch (node.getType()) {
           case ProjectItemNode.NODE_PROJECT:
               setIcon(iconProject);
               break;
           case ProjectItemNode.NODE_SOURCE:
               setIcon(iconSource);
               break;
           case ProjectItemNode.NODE_PACKAGE:
               setIcon(iconPackage);
               break;
           case ProjectItemNode.NODE_CLASS:
               setIcon(iconClass);
               break;
           case ProjectItemNode.NODE_FOLDER:
               setIcon(iconFolder);
               break;
       }*/
       
       return this;
   }
}