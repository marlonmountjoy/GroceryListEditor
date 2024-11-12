import java.util.*;
import java.io.PrintWriter;

public class GroceryList {
   protected ArrayList<String> listItems = new ArrayList<String>();
   protected Stack<UndoCommand> undoStack = new Stack<UndoCommand>();

   public void addWithUndo(String newItemName) {
      // Add the new list item
      listItems.add(newItemName);

      // Make an undo command that removes the last item and push onto stack
      undoStack.push(new RemoveLastCommand(listItems));
   }

   public void removeAtWithUndo(int removalIndex) {
      // Check that the index is in bounds then get the item to be removed
      if (removalIndex >= 0 && removalIndex < listItems.size()) {
         String removedItem = listItems.get(removalIndex);
         // Remove the item
         listItems.remove(removalIndex);
         // Undo 
         undoStack.push(new InsertAtCommand(listItems, removedItem, removalIndex));
      }

   }

   public void swapWithUndo(int index1, int index2) {
      // Check that indices are in bounds and not the same
      if (index1 >= 0 && index1 < listItems.size() && index2 >= 0 && index2 < listItems.size() && index1 != index2) {
         // Swap
         String temp = listItems.get(index1);
         listItems.set(index1, listItems.get(index2));
         listItems.set(index2, temp);
         // Undo
         undoStack.push(new SwapCommand(listItems, index1, index2));
      }

   }

   // Pop and execute the command at the top of the stack
   public void executeUndo() {
      // Check stack is not empty and ^
      if (!undoStack.isEmpty()) {
         UndoCommand lastCommand = undoStack.pop();
         lastCommand.execute();
      }
   }
   public int getListSize() {
      return listItems.size();
   }

   public int getUndoStackSize() {
      return undoStack.size();
   }

   public String[] getItemList() {
      String[] itemArray = new String[listItems.size()];
      itemArray = listItems.toArray(itemArray);
      return itemArray;
   }

   public void print(PrintWriter out) {
      for (int i = 0; i < listItems.size(); i++) {
         out.println(i + ". " + listItems.get(i));
      }
   }
}
