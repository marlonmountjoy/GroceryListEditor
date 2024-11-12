import java.util.ArrayList;

public class RemoveLastCommand extends UndoCommand {
   private ArrayList<String> sourceList;

   public RemoveLastCommand(ArrayList<String> list) {
      this.sourceList = list;
   }

   @Override
   public void execute() {
      if(!sourceList.isEmpty()) {
         // Check list is not empty before removing the last item
         if (!sourceList.isEmpty()) {
           sourceList.remove(sourceList.size() -1);
         }
      }
   }
}
