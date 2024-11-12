import java.util.ArrayList;

public class SwapCommand extends UndoCommand {
   private ArrayList<String> sourceList;
   private int index1;
   private int index2;

   // Constructor
public SwapCommand(ArrayList<String> list, int index1, int index2) {
   this.sourceList = list;
   this.index1 = index1;
   this.index2 = index2;
}

   @Override
   public void execute() {
      // Check if indices are in bounds
      if (index1 >= 0 && index1 < sourceList.size() && index2 >= 0 && index2 < sourceList.size()) {
         // Swap elements
         String temp = sourceList.get(index1);
         sourceList.set(index1, sourceList.get(index2));
         sourceList.set(index2, temp);
      }
   }

}
