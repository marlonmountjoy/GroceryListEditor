import java.util.ArrayList;

public class InsertAtCommand extends UndoCommand {
   private ArrayList<String> sourceList;
   private String item;
   private int index;

   // Constructor 
   public InsertAtCommand(ArrayList<String> list, String item, int index) {
      this.sourceList = list;
      this.item = item;
      this.index = index;
   }

   @Override
   public void execute() {
      // Check if the index is in bounds and insert item at index
      if (index >= 0 && index <= sourceList.size()) {
         sourceList.add(index, item);
      }
   }
}
